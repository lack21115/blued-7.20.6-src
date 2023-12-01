package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.setting.fragment.BindingSecureEmailFragment;
import com.soft.blued.ui.setting.model.BindingModel;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1ForEmail2Fragment.class */
public class RegisterV1ForEmail2Fragment extends BaseFragment implements View.OnClickListener {
    private View d;
    private Context e;
    private Dialog f;
    private CommonTopTitleNoTrans g;
    private TextView h;
    private GridCodeEditText i;
    private TextView j;
    private TextView k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String r;
    private String s;
    private int t;
    private int u;
    private TextWatcher v;

    /* renamed from: c  reason: collision with root package name */
    private String f31446c = RegisterV1ForEmail2Fragment.class.getSimpleName();
    private String q = "";

    /* renamed from: a  reason: collision with root package name */
    Runnable f31445a = new Runnable() { // from class: com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment.3
        @Override // java.lang.Runnable
        public void run() {
            if (RegisterV1ForEmail2Fragment.this.u == 0) {
                RegisterV1ForEmail2Fragment.this.j.setEnabled(true);
                RegisterV1ForEmail2Fragment.this.j.setClickable(true);
                RegisterV1ForEmail2Fragment.this.j.setText(RegisterV1ForEmail2Fragment.this.getResources().getString(2131891539));
                RegisterV1ForEmail2Fragment.this.j.setTextColor(RegisterV1ForEmail2Fragment.this.getResources().getColor(2131101190));
                return;
            }
            RegisterV1ForEmail2Fragment.this.j.setEnabled(false);
            RegisterV1ForEmail2Fragment.this.j.setClickable(false);
            RegisterV1ForEmail2Fragment.this.j.setText(String.format(RegisterV1ForEmail2Fragment.this.getResources().getString(2131886709), Integer.valueOf(RegisterV1ForEmail2Fragment.this.u)));
            RegisterV1ForEmail2Fragment.this.j.setTextColor(RegisterV1ForEmail2Fragment.this.getResources().getColor(2131102263));
            RegisterV1ForEmail2Fragment.e(RegisterV1ForEmail2Fragment.this);
            if (RegisterV1ForEmail2Fragment.this.u == 0) {
                RegisterV1ForEmail2Fragment.this.postSafeRunOnUiThread(this);
            } else {
                RegisterV1ForEmail2Fragment.this.postDelaySafeRunOnUiThread(this, 1000L);
            }
        }
    };
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment.6
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<BluedLoginResult> parseData(String str) {
            RegisterV1ForEmail2Fragment.this.r = str;
            BluedEntityA<BluedLoginResult> bluedEntityA = (BluedEntityA) super.parseData(str);
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                        String a2 = AesCrypto2.a(bluedEntityA.data.get(0).getEncrypted());
                        Logger.b(RegisterV1ForEmail2Fragment.this.f31446c, "解密：deData===", a2);
                        bluedEntityA.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedLoginResult.class));
                        return bluedEntityA;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.d(2131887272);
                }
            }
            return bluedEntityA;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
            try {
                Logger.b(RegisterV1ForEmail2Fragment.this.f31446c, "===success", "加密：responseJson:", bluedEntityA);
                if (bluedEntityA.data.size() <= 0 || bluedEntityA.data.get(0) == null) {
                    return;
                }
                Logger.b(RegisterV1ForEmail2Fragment.this.f31446c, "===success", "加密：responseJson:", bluedEntityA);
                UserInfo.getInstance().saveUserInfo(RegisterV1ForEmail2Fragment.this.n, 0, RegisterV1ForEmail2Fragment.this.r, bluedEntityA.data.get(0), new String[0]);
                Bundle bundle = new Bundle();
                bundle.putString("from_tag_page", "from_tag_register");
                HomeArgumentHelper.a(RegisterV1ForEmail2Fragment.this.e, (String) null, bundle);
            } catch (Exception e) {
                e.printStackTrace();
                AppMethods.d(2131887272);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            DialogUtils.b(RegisterV1ForEmail2Fragment.this.f);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            DialogUtils.a(RegisterV1ForEmail2Fragment.this.f);
        }
    };

    private void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.d.findViewById(2131370749);
        this.g = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.g.f();
        this.g.setCenterText("");
        this.g.setTitleBackgroundDrawable(2131101191);
        this.g.setLeftClickListener(this);
    }

    private void b() {
        this.f = DialogUtils.a(this.e);
        this.k = (TextView) this.d.findViewById(2131371262);
        TextView textView = (TextView) this.d.findViewById(2131371164);
        this.h = textView;
        textView.setOnClickListener(this);
        GridCodeEditText gridCodeEditText = (GridCodeEditText) this.d.findViewById(R.id.et_ver_code);
        this.i = gridCodeEditText;
        gridCodeEditText.setPasswordVisibility(true);
        this.i.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment.1
            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void a(String str) {
                if (str == null || str.length() != 6) {
                    RegisterV1ForEmail2Fragment.this.h.setEnabled(false);
                    RegisterV1ForEmail2Fragment.this.h.setClickable(false);
                    return;
                }
                RegisterV1ForEmail2Fragment.this.h.setEnabled(true);
                RegisterV1ForEmail2Fragment.this.h.setClickable(true);
            }

            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void b(String str) {
            }
        });
        TextView textView2 = (TextView) this.d.findViewById(R.id.lr_btn_countdown);
        this.j = textView2;
        textView2.setOnClickListener(this);
        this.v = new TextWatcher() { // from class: com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegisterV1ForEmail2Fragment.this.d();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
    }

    private void c() {
        if (getArguments() != null) {
            this.m = getArguments().getString(LoginRegisterTools.f31400c);
            this.p = getArguments().getString("original_email");
            this.o = getArguments().getString("secure_email");
            this.s = getArguments().getString("binding_type");
            if (TextUtils.isEmpty(this.p)) {
                this.n = this.o;
                this.t = 0;
            } else {
                this.n = this.p;
                this.t = 1;
            }
            if ("change".equals(this.s)) {
                this.g.setCenterText(this.e.getResources().getString(2131886921));
            } else if ("add".equals(this.s)) {
                this.g.setCenterText(this.e.getResources().getString(2131892292));
            } else {
                this.g.setCenterText(this.e.getResources().getString(2131886632));
            }
            TextView textView = this.k;
            textView.setText(getResources().getString(2131886668) + this.n + "\n" + getResources().getString(2131886669));
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (StringUtils.d(this.i.getPassWord())) {
            this.h.setClickable(false);
            this.h.setEnabled(false);
            return;
        }
        this.h.setClickable(true);
        this.h.setEnabled(true);
    }

    static /* synthetic */ int e(RegisterV1ForEmail2Fragment registerV1ForEmail2Fragment) {
        int i = registerV1ForEmail2Fragment.u;
        registerV1ForEmail2Fragment.u = i - 1;
        return i;
    }

    private void e() {
        this.u = 60;
        postSafeRunOnUiThread(this.f31445a);
    }

    private void f() {
        LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BindingModel>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BindingModel> parseData(String str) {
                BluedEntityA<BindingModel> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (RegisterV1ForEmail2Fragment.this.t == 0 && bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            String a2 = AesCrypto2.a(bluedEntityA.data.get(0).getEncrypted());
                            Logger.b(RegisterV1ForEmail2Fragment.this.f31446c, "解密：deData===", a2);
                            bluedEntityA.data.set(0, (BindingModel) AppInfo.f().fromJson(a2, (Class<Object>) BindingModel.class));
                            return bluedEntityA;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.d(2131887272);
                    }
                }
                return bluedEntityA;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BindingModel> bluedEntityA) {
                BindingModel bindingModel;
                try {
                    if (RegisterV1ForEmail2Fragment.this.t == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putString("binding_type", RegisterV1ForEmail2Fragment.this.s);
                        TerminalActivity.d(RegisterV1ForEmail2Fragment.this.e, BindingSecureEmailFragment.class, bundle);
                        RegisterV1ForEmail2Fragment.this.getActivity().finish();
                        return;
                    }
                    if (bluedEntityA.data.get(0) != null && (bindingModel = bluedEntityA.data.get(0)) != null) {
                        UserInfo.getInstance().setBoundMail(bindingModel.getSafeEmail());
                    }
                    AppMethods.d(2131890501);
                    RegisterV1ForEmail2Fragment.this.getActivity().finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.d(2131887272);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(RegisterV1ForEmail2Fragment.this.f);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(RegisterV1ForEmail2Fragment.this.f);
            }
        }, this.t, this.i.getPassWord(), (IRequestHost) null);
    }

    private void g() {
        LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BindingModel>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BindingModel> parseData(String str) {
                BluedEntityA<BindingModel> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            String a2 = AesCrypto2.a(bluedEntityA.data.get(0).getEncrypted());
                            Logger.b(RegisterV1ForEmail2Fragment.this.f31446c, "解密：deData===", a2);
                            bluedEntityA.data.set(0, (BindingModel) AppInfo.f().fromJson(a2, (Class<Object>) BindingModel.class));
                            return bluedEntityA;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.d(2131887272);
                    }
                }
                return bluedEntityA;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BindingModel> bluedEntityA) {
                BindingModel bindingModel;
                try {
                    if (bluedEntityA.data.get(0) != null && (bindingModel = bluedEntityA.data.get(0)) != null) {
                        UserInfo.getInstance().setBoundMail(bindingModel.getSafeEmail());
                    }
                    AppMethods.d(2131890501);
                    RegisterV1ForEmail2Fragment.this.getActivity().finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(RegisterV1ForEmail2Fragment.this.f);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(RegisterV1ForEmail2Fragment.this.f);
            }
        }, 0, this.i.getPassWord(), (IRequestHost) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.j.setEnabled(false);
        this.j.setText(this.e.getResources().getString(2131886708));
    }

    private void j() {
        Bundle bundle = new Bundle();
        bundle.putString(LoginRegisterTools.d, this.l);
        bundle.putString(LoginRegisterTools.f31400c, this.m);
        bundle.putString("binding_type", "add");
        Logger.b(this.f31446c, "tokenVer===", this.l);
        Logger.b(this.f31446c, "captcha===", this.m);
        TerminalActivity.a(this, RegisterV1ForCaptchaCodeFragment.class, bundle, 1000);
    }

    private void k() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                RegisterV1ForEmail2Fragment.this.h();
                AppMethods.d(2131886716);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(RegisterV1ForEmail2Fragment.this.f);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(RegisterV1ForEmail2Fragment.this.f);
            }
        }, "email", this.n, (IRequestHost) null);
    }

    public void a(String str, int i, String str2) {
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForEmail2Fragment.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<Object> parseData(String str3) {
                Logger.b(RegisterV1ForEmail2Fragment.this.f31446c, "===success", "responseJson:", str3);
                return (BluedEntityA) super.parseData(str3);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    AppMethods.a((CharSequence) RegisterV1ForEmail2Fragment.this.e.getResources().getString(2131886716));
                    RegisterV1ForEmail2Fragment.this.h();
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.d(2131887272);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str3) {
                if (i2 != 4036001) {
                    if (i2 != 4036204) {
                        return super.onUIFailure(i2, str3);
                    }
                    RegisterV1ForEmail2Fragment.this.i();
                    return true;
                } else if (RegisterV1ForEmail2Fragment.this.getActivity() != null) {
                    RegisterV1ForEmail2Fragment.this.getActivity().finish();
                    return true;
                } else {
                    return true;
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(RegisterV1ForEmail2Fragment.this.f);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(RegisterV1ForEmail2Fragment.this.f);
            }
        }, str, i, str2, (IRequestHost) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000 && intent != null) {
            String stringExtra = intent.getStringExtra(LoginRegisterTools.f31400c);
            if (StringUtils.d(stringExtra)) {
                return;
            }
            a(stringExtra, 0, this.n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id == 2131368406) {
            this.i.a();
            LoginRegisterHttpUtils.a("resend_acode");
            if ("add".equals(this.s)) {
                j();
            } else if (this.t == 1) {
                k();
            } else {
                j();
            }
        } else if (id != 2131371164) {
        } else {
            if (!TextUtils.isEmpty(this.s) && "change".equals(this.s)) {
                f();
            } else if (StringUtils.d(this.i.getPassWord())) {
                AppMethods.d(2131886603);
            } else {
                g();
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_register_v1_foremail_step2, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d();
    }
}
