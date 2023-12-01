package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYTypingDialogFragment.class */
public class YYTypingDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private EditText f17464a;
    private ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private View f17465c;
    private String d;
    private IEditorCallback e;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYTypingDialogFragment$IEditorCallback.class */
    public interface IEditorCallback {
        void a(String str, String str2);
    }

    public YYTypingDialogFragment(String str, IEditorCallback iEditorCallback) {
        this.d = str;
        this.e = iEditorCallback;
    }

    private void a(View view) {
        EditText editText = (EditText) view.findViewById(R.id.et_input);
        this.f17464a = editText;
        editText.setHint("请输入礼物数量，最多500个");
        this.b = (ShapeTextView) view.findViewById(R.id.tv_ok_btn);
        View findViewById = view.findViewById(R.id.conver_view);
        this.f17465c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.YYTypingDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYTypingDialogFragment.this.d();
            }
        });
        this.f17464a.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYTypingDialogFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    YYTypingDialogFragment.this.b.setEnabled(false);
                    ShapeHelper.a(YYTypingDialogFragment.this.b, R.color.syc_dark_j, R.color.syc_dark_j);
                    return;
                }
                YYTypingDialogFragment.this.b.setEnabled(true);
                ShapeHelper.a(YYTypingDialogFragment.this.b, R.color.syc_00E0AB, R.color.syc_3883FD);
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.YYTypingDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (YYTypingDialogFragment.this.e != null) {
                    String trim = YYTypingDialogFragment.this.f17464a.getText().toString().trim();
                    String str = StringUtils.a(trim) + "";
                    if (StringUtils.a(str, 0) <= 0) {
                        ToastUtils.a("输入数量不能为0");
                        return;
                    } else if (StringUtils.a(str, 0) > 500) {
                        ToastUtils.a("输入数量不能大于500");
                        return;
                    } else {
                        YYTypingDialogFragment.this.e.a(YYTypingDialogFragment.this.d, str);
                    }
                }
                YYTypingDialogFragment.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        KeyboardUtils.b(this.f17464a);
        KeyboardUtils.b(getContext(), this.f17464a);
        KeyboardUtils.a(getActivity());
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f17464a.setFocusableInTouchMode(true);
        this.f17464a.setFocusable(true);
        this.f17464a.requestFocus();
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.f17464a, 0);
        EditText editText = this.f17464a;
        editText.setSelection(editText.getText().length());
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 16973946);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_yy_typing_layout, (ViewGroup) null);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setSoftInputMode(16);
        a(inflate);
        return inflate;
    }
}
