package com.soft.blued.ui.login_register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1ForCaptchaCodeFragment.class */
public class RegisterV1ForCaptchaCodeFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f17752a = RegisterV1ForCaptchaCodeFragment.class.getSimpleName();
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Context f17753c;
    private CommonTopTitleNoTrans d;
    private TextView e;
    private LinearLayout f;
    private ImageView g;
    private EditText h;
    private String i;
    private String j;
    private TextWatcher k;

    private void a() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        this.d = findViewById;
        findViewById.a();
        this.d.setCenterText(getString(2131886632));
        this.d.setLeftClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (StringUtils.d(this.h.getText().toString())) {
            this.e.setEnabled(true);
            this.e.setClickable(true);
            return;
        }
        this.e.setEnabled(true);
        this.e.setClickable(true);
    }

    private void c() {
        this.h.addTextChangedListener(this.k);
    }

    private void d() {
        this.h.removeTextChangedListener(this.k);
    }

    private void e() {
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_root_layout);
        this.f = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.b.findViewById(2131371164);
        this.e = textView;
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) this.b.findViewById(2131361892);
        this.g = imageView;
        imageView.setOnClickListener(this);
        EditText editText = (EditText) this.b.findViewById(R.id.et_img_ver_code);
        this.h = editText;
        editText.setTextColor(BluedSkinUtils.a(this.f17753c, 2131102254));
        this.k = new TextWatcher() { // from class: com.soft.blued.ui.login_register.RegisterV1ForCaptchaCodeFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegisterV1ForCaptchaCodeFragment.this.b();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
    }

    private void f() {
        if (getArguments() != null) {
            this.i = getArguments().getString(LoginRegisterTools.d);
            this.j = getArguments().getString(LoginRegisterTools.f17710c);
            if ("add".equals(getArguments().getString("binding_type"))) {
                this.d.setCenterText(this.f17753c.getResources().getString(2131892292));
            }
            if (StringUtils.d(this.j)) {
                return;
            }
            LoginRegisterTools.a((IRequestHost) getFragmentActive(), this.g, this.j);
        }
    }

    private void g() {
        Intent intent = new Intent();
        intent.putExtra(LoginRegisterTools.f17710c, "");
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public boolean onBackPressed() {
        g();
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131361892:
                if (StringUtils.d(this.j)) {
                    return;
                }
                LoginRegisterTools.a((IRequestHost) getFragmentActive(), this.g, this.j);
                return;
            case 2131363120:
                g();
                return;
            case R.id.ll_root_layout /* 2131368210 */:
                KeyboardUtils.a(getActivity());
                return;
            case 2131371164:
                LoginRegisterHttpUtils.a("captcha_acode");
                if (StringUtils.d(this.h.getText().toString())) {
                    AppMethods.d(2131886603);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(LoginRegisterTools.f17710c, this.h.getText().toString());
                getActivity().setResult(-1, intent);
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17753c = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_register_v1_forphone_step2_1, viewGroup, false);
            a();
            e();
            f();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    public void onResume() {
        super.onResume();
        b();
        c();
    }

    public void onStop() {
        d();
        super.onStop();
    }
}
