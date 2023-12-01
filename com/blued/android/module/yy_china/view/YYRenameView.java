package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRenameView.class */
public class YYRenameView extends BaseFullScreenDialog {
    private EditText a;
    private FrameLayout b;
    private ImageView c;
    private ShapeTextView d;

    private void a(View view) {
        this.d = (ShapeTextView) view.findViewById(R.id.tv_modify);
        this.c = (ImageView) view.findViewById(R.id.img_back);
        EditText editText = (EditText) view.findViewById(R.id.et_room_name);
        this.a = editText;
        editText.setFilters(new InputFilter[]{new EnglishCharFilter(32)});
        this.b = (FrameLayout) view.findViewById(R.id.fl_loading_view);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYRenameView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                String trim = YYRenameView.this.a.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    ToastUtils.a("房间名不能为空", 0);
                } else {
                    YYRenameView.this.a(trim);
                }
            }
        });
        view.findViewById(R.id.iv).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYRenameView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYRenameView.this.dismissAllowingStateLoss();
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYRenameView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYRenameView.this.dismissAllowingStateLoss();
            }
        });
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        this.a.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.view.YYRenameView.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                YYRenameView.this.a(!TextUtils.isEmpty(editable));
            }
        });
        this.a.setText(b.room_name);
        if (b.room_id.equals(b.room_name)) {
            EditText editText2 = this.a;
            editText2.setText(b.name + "的语音聊天室");
        }
        this.a.setFocusableInTouchMode(true);
        this.a.setFocusable(true);
        this.a.requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.a, 0);
        EditText editText3 = this.a;
        editText3.setSelection(editText3.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.a(b.room_id, str, "", b.type_id, new BluedUIHttpResponse(a()) { // from class: com.blued.android.module.yy_china.view.YYRenameView.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                YYRenameView.this.b.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                YYRenameView.this.b.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                b.room_name = str;
                LiveEventBus.get("notify_room_rename").post(str);
                YYRenameView.this.dismissAllowingStateLoss();
            }
        }, (IRequestHost) a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        ShapeHelper.a(this.d, z ? R.color.syc_00E0AB : R.color.white_alpha10, z ? R.color.syc_3883FD : R.color.white_alpha10);
        this.d.setEnabled(z);
        this.d.setAlpha(1.0f);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_yy_modify_room_name, viewGroup, true);
        a(inflate);
        return inflate;
    }
}
