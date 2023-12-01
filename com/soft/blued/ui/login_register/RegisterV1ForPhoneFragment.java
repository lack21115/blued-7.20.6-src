package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.chat.utils.BlueAppChatLocal;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.model.BluedCheckResult;
import com.bytedance.applog.tracker.Tracker;
import com.google.common.reflect.TypeToken;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment;
import com.soft.blued.ui.user.fragment.AccountLockedFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.password.PasswordCheckUtils;
import com.soft.blued.utils.password.PasswordStatusView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1ForPhoneFragment.class */
public class RegisterV1ForPhoneFragment extends BaseFragment implements View.OnClickListener {
    private FrameLayout A;
    private ImageView B;
    private SmCaptchaWebView C;
    private SmCaptchaWebView.ResultListener D;
    private SmCaptchaWebView.SmOption E;
    private String H;
    private TextWatcher I;
    private TextWatcher J;
    private PasswordStatusView L;
    private boolean N;
    private View d;
    private Context e;
    private ScrollView f;
    private CommonEdittextView g;
    private ClearEditText h;
    private CommonEdittextView i;
    private ClearEditText j;
    private LinearLayout k;
    private CheckBox l;
    private TextView m;
    private TextView n;
    private TextView o;
    private CommonTopTitleNoTrans p;
    private Dialog q;
    private ShapeTextView r;
    private LinearLayout s;
    private TextView t;
    private String u;
    private String v;
    private LinearLayout w;
    private ImageView x;
    private CommonEdittextView y;
    private ClearEditText z;

    /* renamed from: c  reason: collision with root package name */
    private String f31472c = RegisterV1ForPhoneFragment.class.getSimpleName();
    private boolean F = true;
    private boolean G = false;
    private final int K = 11;
    private boolean M = true;

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f31471a = new AnonymousClass10();
    public BluedUIHttpResponse b = new BluedUIHttpResponse() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.11
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str, String str2) {
            switch (i) {
                case 4036001:
                    RegisterV1ForPhoneFragment.this.k();
                    return true;
                case 4036002:
                    if (RegisterV1ForPhoneFragment.this.F) {
                        RegisterV1ForPhoneFragment.this.C.reloadCaptcha();
                        RegisterV1ForPhoneFragment.this.g();
                        return true;
                    }
                    RegisterV1ForPhoneFragment.this.v = LoginRegisterTools.a(str2);
                    if (StringUtils.d(RegisterV1ForPhoneFragment.this.v)) {
                        return true;
                    }
                    LoginRegisterTools.a(RegisterV1ForPhoneFragment.this.getFragmentActive(), RegisterV1ForPhoneFragment.this.x, RegisterV1ForPhoneFragment.this.v);
                    return true;
                default:
                    return super.onUIFailure(i, str);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            DialogUtils.b(RegisterV1ForPhoneFragment.this.q);
            super.onUIFinish();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            DialogUtils.a(RegisterV1ForPhoneFragment.this.q);
            super.onUIStart();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            AppMethods.a((CharSequence) RegisterV1ForPhoneFragment.this.e.getResources().getString(2131886716));
            RegisterV1ForPhoneFragment.this.l();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment$10  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1ForPhoneFragment$10.class */
    public class AnonymousClass10 extends BluedUIHttpResponse<BluedEntityA<BluedCheckResult>> {
        AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z) {
            RegisterV1ForPhoneFragment.this.M = z;
            RegisterV1ForPhoneFragment.this.g();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<BluedCheckResult> parseData(String str) {
            BluedEntityA<BluedCheckResult> bluedEntityA = (BluedEntityA) super.parseData(str);
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                        String a2 = AesCrypto2.a(bluedEntityA.data.get(0).getEncrypted());
                        Logger.b(RegisterV1ForPhoneFragment.this.f31472c, "解密：deData===", a2);
                        bluedEntityA.data.set(0, (BluedCheckResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedCheckResult.class));
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
        public void onUIUpdate(BluedEntityA<BluedCheckResult> bluedEntityA) {
            BluedCheckResult bluedCheckResult;
            try {
                boolean z = true;
                Logger.b(RegisterV1ForPhoneFragment.this.f31472c, "===success", "加密：responseJson:", bluedEntityA);
                if (bluedEntityA.data.get(0) == null || (bluedCheckResult = bluedEntityA.data.get(0)) == null) {
                    return;
                }
                RegisterV1ForPhoneFragment.this.u = bluedCheckResult.getToken();
                RegisterV1ForPhoneFragment.this.v = bluedCheckResult.getCaptcha();
                RegisterV1ForPhoneFragment.this.L.a(RegisterV1ForPhoneFragment.this.h, RegisterV1ForPhoneFragment.this.j, RegisterV1ForPhoneFragment.this.u, PasswordCheckUtils.PWD_CHECK_PAGE.REGISTER, RegisterV1ForPhoneFragment.this.getFragmentActive(), new PasswordStatusView.OnCheckResult() { // from class: com.soft.blued.ui.login_register.-$$Lambda$RegisterV1ForPhoneFragment$10$2WhY5pZYaAsH5eDqh36Tegge5Lk
                    @Override // com.soft.blued.utils.password.PasswordStatusView.OnCheckResult
                    public final void onResult(boolean z2) {
                        RegisterV1ForPhoneFragment.AnonymousClass10.this.a(z2);
                    }
                });
                RegisterV1ForPhoneFragment registerV1ForPhoneFragment = RegisterV1ForPhoneFragment.this;
                if (bluedCheckResult.getIs_sm_captcha() != 1) {
                    z = false;
                }
                registerV1ForPhoneFragment.F = z;
                if (RegisterV1ForPhoneFragment.this.F) {
                    RegisterV1ForPhoneFragment.this.w.setVisibility(8);
                    RegisterV1ForPhoneFragment.this.A.setVisibility(0);
                    RegisterV1ForPhoneFragment.this.f();
                    return;
                }
                RegisterV1ForPhoneFragment.this.w.setVisibility(0);
                RegisterV1ForPhoneFragment.this.A.setVisibility(8);
                if (StringUtils.d(RegisterV1ForPhoneFragment.this.v)) {
                    return;
                }
                LoginRegisterTools.a(RegisterV1ForPhoneFragment.this.getFragmentActive(), RegisterV1ForPhoneFragment.this.x, RegisterV1ForPhoneFragment.this.v);
            } catch (Exception e) {
                e.printStackTrace();
                AppMethods.d(2131887272);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str, String str2) {
            if (i == 4036005 || i == 4036501) {
                try {
                    BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str2, new TypeToken<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.10.1
                    }.getType());
                    if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                        BluedLoginResult bluedLoginResult = (BluedLoginResult) bluedEntityA.data.get(0);
                        AccountLockedFragment.a(RegisterV1ForPhoneFragment.this.e, bluedLoginResult.reason, bluedLoginResult.uid);
                    }
                } catch (Exception e) {
                }
                DialogUtils.b(RegisterV1ForPhoneFragment.this.q);
                RegisterV1ForPhoneFragment.this.getActivity().finish();
                return true;
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            DialogUtils.b(RegisterV1ForPhoneFragment.this.q);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            DialogUtils.a(RegisterV1ForPhoneFragment.this.q);
        }
    }

    private void c() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.d.findViewById(2131370749);
        this.p = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.p.f();
        this.p.setCenterText(this.e.getString(2131886632));
        this.p.setLeftClickListener(this);
    }

    private void d() {
        this.L = (PasswordStatusView) this.d.findViewById(R.id.pwd_check_view);
        this.q = DialogUtils.a(this.e);
        CommonEdittextView commonEdittextView = (CommonEdittextView) this.d.findViewById(R.id.cev_mobile);
        this.i = commonEdittextView;
        ClearEditText editText = commonEdittextView.getEditText();
        this.j = editText;
        editText.setInputType(2);
        this.j.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        CommonEdittextView commonEdittextView2 = (CommonEdittextView) this.d.findViewById(R.id.cev_password);
        this.g = commonEdittextView2;
        ClearEditText editText2 = commonEdittextView2.getEditText();
        this.h = editText2;
        editText2.setTypeface(Typeface.DEFAULT);
        this.h.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.ll_root_layout);
        this.s = linearLayout;
        linearLayout.setOnClickListener(this);
        this.n = (TextView) this.d.findViewById(2131372706);
        this.l = (CheckBox) this.d.findViewById(2131362774);
        this.m = (TextView) this.d.findViewById(2131372705);
        this.k = (LinearLayout) this.d.findViewById(2131368281);
        TextView textView = (TextView) this.d.findViewById(R.id.tv_wechat_login);
        this.o = textView;
        textView.setOnClickListener(this);
        ShapeTextView shapeTextView = (ShapeTextView) this.d.findViewById(R.id.tv_to_register);
        this.r = shapeTextView;
        shapeTextView.setOnClickListener(this);
        TextView areaCodeText = this.i.getAreaCodeText();
        this.t = areaCodeText;
        areaCodeText.setOnClickListener(this);
        if (BlueAppChatLocal.isZh()) {
            this.n.setVisibility(8);
            this.m.setVisibility(0);
        } else {
            this.n.setVisibility(0);
            this.m.setVisibility(8);
        }
        String areaCode = AreaUtils.getAreaCode(AreaUtils.getAreaCodeList());
        if (StringUtils.d(areaCode)) {
            this.t.setText("+86");
        } else {
            this.t.setText(areaCode);
        }
        ImageView imageView = (ImageView) this.d.findViewById(2131361892);
        this.x = imageView;
        imageView.setOnClickListener(this);
        CommonEdittextView commonEdittextView3 = (CommonEdittextView) this.d.findViewById(2131362783);
        this.y = commonEdittextView3;
        this.z = commonEdittextView3.getEditText();
        this.w = (LinearLayout) this.d.findViewById(2131367685);
        this.A = (FrameLayout) this.d.findViewById(2131368252);
        ImageView imageView2 = (ImageView) this.d.findViewById(2131369861);
        this.B = imageView2;
        imageView2.setOnClickListener(this);
        e();
        k();
        if (BlueAppChatLocal.isZh()) {
            this.n.setVisibility(8);
            this.m.setVisibility(0);
            TypefaceUtils.a(this.e, this.m, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(RegisterV1ForPhoneFragment.this.e, H5Url.a(21), 0);
                }
            }, new TypefaceUtils.SpannIndex(10, 24), new TypefaceUtils.SpannIndex(86, 104));
            TypefaceUtils.a(this.e, this.m, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(RegisterV1ForPhoneFragment.this.e, H5Url.a(22), 0);
                }
            }, new TypefaceUtils.SpannIndex(25, 35), new TypefaceUtils.SpannIndex(109, 123));
        } else {
            this.n.setVisibility(0);
            this.m.setVisibility(8);
            TypefaceUtils.a(this.e, this.n, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(RegisterV1ForPhoneFragment.this.e, H5Url.a(21), 0);
                }
            }, new TypefaceUtils.SpannIndex(10, 24), new TypefaceUtils.SpannIndex(86, 104));
            TypefaceUtils.a(this.e, this.n, new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(RegisterV1ForPhoneFragment.this.e, H5Url.a(22), 0);
                }
            }, new TypefaceUtils.SpannIndex(25, 35), new TypefaceUtils.SpannIndex(109, 123));
        }
        this.l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                RegisterV1ForPhoneFragment.this.g();
                RegisterV1ForPhoneFragment.this.N = z;
            }
        });
        g();
        this.I = new TextWatcher() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegisterV1ForPhoneFragment.this.g();
                if (RegisterV1ForPhoneFragment.this.F) {
                    RegisterV1ForPhoneFragment.this.h();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.J = new TextWatcher() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.7
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f31483c;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RegisterV1ForPhoneFragment.this.g();
                if (RegisterV1ForPhoneFragment.this.F) {
                    RegisterV1ForPhoneFragment.this.h();
                }
                RegisterV1ForPhoneFragment.this.h.removeTextChangedListener(RegisterV1ForPhoneFragment.this.J);
                this.b = RegisterV1ForPhoneFragment.this.h.getSelectionStart();
                this.f31483c = RegisterV1ForPhoneFragment.this.h.getSelectionEnd();
                RegisterV1ForPhoneFragment.this.h.setSelection(this.b);
                RegisterV1ForPhoneFragment.this.h.addTextChangedListener(RegisterV1ForPhoneFragment.this.J);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
    }

    private void e() {
        String string = getString(2131886715);
        this.C = (SmCaptchaWebView) this.d.findViewById(2131369860);
        SmCaptchaWebView.SmOption smOption = new SmCaptchaWebView.SmOption();
        this.E = smOption;
        smOption.setOrganization("qRLrIEyYwqE1vOhOACQy");
        this.E.setMode(SmCaptchaWebView.MODE_SLIDE);
        this.E.setAppId("1");
        this.E.setChannel(AppInfo.f9487c);
        if (!BlueAppLocal.d()) {
            HashMap hashMap = new HashMap();
            hashMap.put("lang", "en");
            this.E.setExtOption(hashMap);
        }
        if (!TextUtils.isEmpty(string)) {
            this.E.setTipMessage(string);
        }
        this.C.setBackgroundColor(0);
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        layoutParams.width = AppInfo.l - DensityUtils.a(this.e, 80.0f);
        layoutParams.height = (int) ((layoutParams.width / 300.0d) * 234.0d);
        this.C.setLayoutParams(layoutParams);
        this.f = (ScrollView) this.d.findViewById(2131369645);
        this.C.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                RegisterV1ForPhoneFragment.this.f.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        this.D = new SmCaptchaWebView.ResultListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhoneFragment.9
            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onError(int i) {
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onReady() {
                RegisterV1ForPhoneFragment.this.h();
                RegisterV1ForPhoneFragment.this.C.setVisibility(0);
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onSuccess(CharSequence charSequence, boolean z) {
                RegisterV1ForPhoneFragment.this.H = charSequence.toString();
                RegisterV1ForPhoneFragment.this.G = z;
                RegisterV1ForPhoneFragment.this.g();
            }
        };
        this.A.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.C.initWithOption(this.E, this.D);
        int i = SmCaptchaWebView.SMCAPTCHA_SUCCESS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (StringUtils.d(this.j.getText().toString()) || StringUtils.d(this.h.getText().toString()) || !this.l.isChecked() || ((!(this.F && this.G) && (this.F || StringUtils.d(this.z.getText().toString()))) || this.M)) {
            this.r.setEnabled(false);
        } else {
            this.r.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.G) {
            return;
        }
        if (StringUtils.d(this.j.getText().toString()) || StringUtils.d(this.h.getText().toString())) {
            this.C.disableCaptcha();
        } else {
            this.C.enableCaptcha();
        }
    }

    private void i() {
        this.j.addTextChangedListener(this.I);
        this.h.addTextChangedListener(this.J);
        this.z.addTextChangedListener(this.I);
    }

    private void j() {
        this.j.removeTextChangedListener(this.I);
        this.h.removeTextChangedListener(this.J);
        this.z.removeTextChangedListener(this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        LoginRegisterHttpUtils.a(this.f31471a, "mobile", getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Bundle bundle = new Bundle();
        bundle.putString(LoginRegisterTools.d, this.u);
        bundle.putString(LoginRegisterTools.f31400c, this.v);
        bundle.putString(LoginRegisterTools.e, this.j.getText().toString());
        bundle.putString(LoginRegisterTools.g, this.t.getText().toString());
        bundle.putString(LoginRegisterTools.h, this.h.getText().toString());
        Logger.b(this.f31472c, "tokenVer===", this.u);
        Logger.b(this.f31472c, "captcha===", this.v);
        Logger.b(this.f31472c, "phonenum===", this.j.getText().toString());
        Logger.b(this.f31472c, "areacode===", this.t.getText().toString());
        Logger.b(this.f31472c, "password===", this.h.getText().toString());
        TerminalActivity.d(getActivity(), RegisterV1ForPhone2Fragment.class, bundle);
    }

    public String a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
        Date date = new Date(System.currentTimeMillis());
        return "" + simpleDateFormat.format(date);
    }

    public void b() {
        if (TextUtils.isEmpty(this.h.getText())) {
            return;
        }
        int length = this.h.getText().toString().length();
        String str = this.F ? "identify_sm" : "identify";
        if (length < 6) {
            AppMethods.a((CharSequence) this.e.getResources().getString(2131886713));
        } else if (StringUtils.d(this.j.getText().toString()) || StringUtils.d(this.h.getText().toString()) || (StringUtils.d(this.z.getText().toString()) && !this.G)) {
            AppMethods.d(2131886603);
        } else {
            BluedUIHttpResponse bluedUIHttpResponse = this.b;
            LoginRegisterHttpUtils.a(bluedUIHttpResponse, this.t.getText().toString() + "-" + this.j.getText().toString(), this.u, this.z.getText().toString(), "mobile", str, this.H, getFragmentActive());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && intent != null) {
            String stringExtra = intent.getStringExtra(RegisterV1AreaCodeFragment.j);
            if (StringUtils.d(stringExtra)) {
                return;
            }
            this.t.setText(stringExtra);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131361892:
                if (StringUtils.d(this.v)) {
                    return;
                }
                LoginRegisterTools.a(getFragmentActive(), this.x, this.v);
                return;
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.ll_root_layout /* 2131368210 */:
                KeyboardUtils.a(getActivity());
                return;
            case 2131369861:
                f();
                return;
            case 2131370914:
                LoginRegisterHttpUtils.a("country_mo");
                Bundle bundle = new Bundle();
                bundle.putString(RegisterV1AreaCodeFragment.k, RegisterV1ForPhoneFragment.class.getSimpleName());
                TerminalActivity.a(this, RegisterV1AreaCodeFragment.class, bundle, 100);
                return;
            case R.id.tv_to_register /* 2131372777 */:
                BluedPreferences.aE();
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.REGISTER_PAGE_REGISTER_BTN_CLICK);
                LoginRegisterHttpUtils.a("reg_mo");
                BluedPreferences.ae(a());
                b();
                return;
            case R.id.tv_wechat_login /* 2131372956 */:
                if (!this.N) {
                    AppMethods.d(2131890421);
                    return;
                }
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.REGISTER_PAGE_THIRD_LOGIN_BTN_CLICK);
                Intent intent = new Intent(this.e, LoginV1ForThreeActivity.class);
                intent.putExtra("from_three_plat", "plat_weixin");
                this.e.startActivity(intent);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_register_v1_forphone_step1, viewGroup, false);
            c();
            d();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g();
        i();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        j();
        super.onStop();
    }
}
