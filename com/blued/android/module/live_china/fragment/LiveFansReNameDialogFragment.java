package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansReNameModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansReNameDialogFragment.class */
public class LiveFansReNameDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public Context a;
    public String b;
    public long c;
    public ILiveFansEditDialog d;
    private EditText e;
    private TextView f;
    private View g;
    private View h;
    private final int i = 3;
    private boolean j = false;
    private boolean k = false;
    private TextWatcher l = new TextWatcher() { // from class: com.blued.android.module.live_china.fragment.LiveFansReNameDialogFragment.3
        private int b;
        private int c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.b = LiveFansReNameDialogFragment.this.e.getSelectionStart();
            this.c = LiveFansReNameDialogFragment.this.e.getSelectionEnd();
            LiveFansReNameDialogFragment.this.e.removeTextChangedListener(LiveFansReNameDialogFragment.this.l);
            while (editable.length() > 3) {
                editable.delete(this.b - 1, this.c);
                this.b--;
                this.c--;
            }
            LiveFansReNameDialogFragment.this.e.setSelection(this.b);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("(");
            stringBuffer.append(editable.length());
            stringBuffer.append(BridgeUtil.SPLIT_MARK);
            stringBuffer.append(3);
            stringBuffer.append(")");
            LiveFansReNameDialogFragment.this.f.setText(stringBuffer.toString());
            LiveFansReNameDialogFragment.this.e.addTextChangedListener(LiveFansReNameDialogFragment.this.l);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansReNameDialogFragment$ILiveFansEditDialog.class */
    public interface ILiveFansEditDialog {
        void a(boolean z, String str);

        void q_();
    }

    private void e() {
        if (getArguments() != null) {
            this.b = getArguments().getString("name");
            this.c = getArguments().getLong("lid");
        }
    }

    public void a(ILiveFansEditDialog iLiveFansEditDialog) {
        this.d = iLiveFansEditDialog;
    }

    public void d() {
        LiveRoomHttpUtils.e(this.e.getText().toString(), new BluedUIHttpResponse<BluedEntityA<LiveFansReNameModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveFansReNameDialogFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansReNameModel> bluedEntityA) {
                LiveFansReNameDialogFragment.this.k = true;
                AppMethods.d(R.string.live_fans_change_success);
                LiveRoomManager.a().q().apply = 1;
                if (LiveFansReNameDialogFragment.this.j) {
                    LiveFansReNameDialogFragment.this.dismiss();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        view.getId();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        e();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_fans_edit, (ViewGroup) null);
        DensityUtils.a(getActivity(), 300.0f);
        DensityUtils.a(getActivity(), 216.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        window.setWindowAnimations(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_fans_edit, viewGroup);
        this.e = (EditText) inflate.findViewById(R.id.et_fans_name);
        this.f = (TextView) inflate.findViewById(R.id.tv_fans_num);
        this.g = inflate.findViewById(R.id.tv_cancel);
        this.h = inflate.findViewById(R.id.tv_confirm);
        this.e.addTextChangedListener(this.l);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansReNameDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.b(LiveProtos.Event.FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK, String.valueOf(LiveFansReNameDialogFragment.this.c));
                if (TextUtils.isEmpty(LiveFansReNameDialogFragment.this.e.getText().toString())) {
                    AppMethods.d(R.string.live_fans_name_empty);
                } else {
                    LiveFansReNameDialogFragment.this.d();
                }
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveFansReNameDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveFansReNameDialogFragment.this.dismiss();
            }
        });
        ILiveFansEditDialog iLiveFansEditDialog = this.d;
        if (iLiveFansEditDialog != null) {
            iLiveFansEditDialog.q_();
        }
        this.e.setText(this.b);
        this.j = true;
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        this.j = false;
        ILiveFansEditDialog iLiveFansEditDialog = this.d;
        if (iLiveFansEditDialog != null) {
            iLiveFansEditDialog.a(this.k, this.e.getText().toString());
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
