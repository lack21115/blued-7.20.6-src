package com.soft.blued.ui.login_register.View;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonGuidePop;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.activity.PhoneOrEmailLoginActivity;
import com.bytedance.applog.tracker.Tracker;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.Contract.LoginWithTypeContract;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter;
import com.soft.blued.ui.login_register.utils.LoginTool;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/LoginWithEmailFragment.class */
public class LoginWithEmailFragment extends BaseFragment implements View.OnClickListener, LoginWithTypeContract.IView {

    /* renamed from: a  reason: collision with root package name */
    public View f17807a;
    public ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public ClearEditText f17808c;
    public ClearEditText d;
    public ClearEditText e;
    private Context f;
    private LoginWithTypeContract.IPresenter g;
    private View h;
    private CommonEdittextView i;
    private CommonEdittextView j;
    private CommonEdittextView k;
    private Dialog l;
    private TextView m;
    private Bundle n;
    private CheckBox o;
    private CommonGuidePop p;

    public static void a(Context context, Bundle bundle) {
        PhoneOrEmailLoginActivity.d.a(context, LoginWithEmailFragment.class, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j() {
        this.p = LoginTool.f17894a.a(getContext());
        CommonEdittextView findViewById = this.h.findViewById(2131362783);
        this.k = findViewById;
        findViewById.a();
        this.b = (ImageView) this.h.findViewById(2131361892);
        this.f17808c = this.k.getEditText();
        CommonEdittextView findViewById2 = this.h.findViewById(R.id.cev_password);
        this.j = findViewById2;
        findViewById2.a();
        ClearEditText editText = this.j.getEditText();
        this.e = editText;
        editText.setInputType(128);
        this.e.setTypeface(Typeface.DEFAULT);
        this.e.setTransformationMethod(new PasswordTransformationMethod());
        CommonEdittextView findViewById3 = this.h.findViewById(R.id.cev_email);
        this.i = findViewById3;
        findViewById3.a();
        ClearEditText editText2 = this.i.getEditText();
        this.d = editText2;
        editText2.setInputType(524320);
        this.f17807a = this.h.findViewById(2131367685);
        this.l = DialogUtils.a(this.f);
        this.m = (TextView) this.h.findViewById(R.id.tv_login);
        this.d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithEmailFragment.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (!z || LoginWithEmailFragment.this.o.isChecked()) {
                    return;
                }
                LoginTool.f17894a.a(LoginWithEmailFragment.this.o, LoginWithEmailFragment.this.p, LoginWithEmailFragment.this.h.findViewById(2131364005));
            }
        });
        this.e.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithEmailFragment.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (!z || LoginWithEmailFragment.this.o.isChecked()) {
                    return;
                }
                LoginTool.f17894a.a(LoginWithEmailFragment.this.o, LoginWithEmailFragment.this.p, LoginWithEmailFragment.this.h.findViewById(2131364005));
            }
        });
        this.h.findViewById(2131370694).getLeftImg().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithEmailFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LoginWithEmailFragment.this.getActivity().finish();
            }
        });
        i();
        this.o = (CheckBox) this.h.findViewById(2131364005).findViewById(2131362774);
        LoginTool.f17894a.a(this.h, false);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LOGIN_CHECK, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.login_register.View.LoginWithEmailFragment.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (!bool.booleanValue()) {
                    KeyboardUtils.b(LoginWithEmailFragment.this.d);
                    LoginWithEmailFragment.this.d.clearFocus();
                    LoginWithEmailFragment.this.d.setCursorVisible(false);
                    return;
                }
                LoginTool.f17894a.a(LoginWithEmailFragment.this.o, LoginWithEmailFragment.this.p, LoginWithEmailFragment.this.h.findViewById(2131364005));
                LoginWithEmailFragment.this.d.requestFocus();
                LoginWithEmailFragment.this.d.setCursorVisible(true);
                LoginWithEmailFragment.this.d.setSelection(LoginWithEmailFragment.this.d.getText().length());
                KeyboardUtils.a(LoginWithEmailFragment.this.d);
            }
        });
        this.h.findViewById(R.id.tv_login_Q).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithEmailFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LoginRegisterTools.b(LoginWithEmailFragment.this.getActivity());
            }
        });
    }

    private void k() {
        UserAccountsModel a2;
        if (this.n != null || (a2 = UserAccountsVDao.a().a(0)) == null || StringUtils.d(a2.getUsername())) {
            return;
        }
        this.d.setText(a2.getUsername());
        this.d.setSelection(a2.getUsername().length());
    }

    private void l() {
        this.b.setOnClickListener(this);
        TextWatcher textWatcher = new TextWatcher() { // from class: com.soft.blued.ui.login_register.View.LoginWithEmailFragment.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                LoginWithEmailFragment.this.i();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.f17808c.addTextChangedListener(textWatcher);
        this.d.addTextChangedListener(textWatcher);
        this.e.addTextChangedListener(textWatcher);
        this.m.setOnClickListener(this);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a() {
        DialogUtils.b(this.l);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a(String str) {
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a(String str, String str2) {
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a(String str, boolean z) {
        LoginRegisterTools.a((IRequestHost) getFragmentActive(), this.b, str);
        this.f17807a.setVisibility(0);
        this.f17808c.requestFocus();
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void a(boolean z) {
        LoginRegisterTools.a(this.f, new SmCaptchaWebView.ResultListener() { // from class: com.soft.blued.ui.login_register.View.LoginWithEmailFragment.8
            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onError(int i) {
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onReady() {
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onSuccess(CharSequence charSequence, boolean z2) {
                if (z2) {
                    LoginWithEmailFragment.this.g.b(charSequence.toString());
                    LoginWithEmailFragment.this.m.callOnClick();
                }
            }
        });
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void b() {
        DialogUtils.a(this.l);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void c() {
        LoginRegisterTools.a(getActivity(), 0);
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void d() {
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public int e() {
        return 0;
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void f() {
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void g() {
        getActivity().finish();
    }

    @Override // com.soft.blued.ui.login_register.Contract.LoginWithTypeContract.IView
    public void h() {
    }

    public void i() {
        if (StringUtils.d(this.d.getText().toString()) || StringUtils.d(this.e.getText().toString())) {
            this.m.setEnabled(false);
        } else if (this.f17807a.getVisibility() != 0) {
            this.m.setEnabled(true);
        } else if (StringUtils.d(this.f17808c.getText().toString())) {
            this.m.setEnabled(false);
        } else {
            this.m.setEnabled(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131361892) {
            if (StringUtils.d(this.g.b())) {
                return;
            }
            a(this.g.b(), true);
        } else if (id != 2131371873) {
        } else {
            com.blued.android.framework.utils.KeyboardUtils.a(getActivity());
            if (!this.o.isChecked()) {
                LoginTool.f17894a.a(this.o, this.p, this.h.findViewById(2131364005));
                return;
            }
            BluedPreferences.aE();
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.EMAIL);
            if (StringUtils.d(this.d.getText().toString()) || StringUtils.d(this.e.getText().toString())) {
                AppMethods.a(AppInfo.d().getResources().getString(R.string.user_login_fail));
            } else {
                this.g.a("email", this.d.getText().toString(), this.e.getText().toString(), this.g.d(), this.f17808c.getText().toString());
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = getActivity();
        View view = this.h;
        if (view == null) {
            this.h = layoutInflater.inflate(R.layout.fragment_login_v1_email, viewGroup, false);
            this.n = getArguments();
            j();
            k();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.h.getParent()).removeView(this.h);
        }
        return this.h;
    }

    public void onDestroy() {
        DialogUtils.b(this.l);
        this.l = null;
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LoginWithTypePresenter loginWithTypePresenter = new LoginWithTypePresenter(this.f, this, getFragmentActive());
        this.g = loginWithTypePresenter;
        Bundle bundle2 = this.n;
        if (bundle2 != null) {
            loginWithTypePresenter.a(bundle2.getString("aliasUserId"));
        }
        l();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.login_register.View.LoginWithEmailFragment.1
            @Override // java.lang.Runnable
            public void run() {
                LoginWithEmailFragment.this.d.requestFocus();
                KeyboardUtils.a(LoginWithEmailFragment.this.d);
            }
        }, 200L);
    }
}
