package com.soft.blued.ui.login_register;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.ClearEditText;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.fragment.FinishProfile1Fragment;
import com.blued.login.model.BluedCheckResult;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.R;
import com.soft.blued.customview.gridcodeedittext.GridCodeEditText;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.setting.fragment.BindingSecureEmailFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/RegisterV1ForPhone2Fragment.class */
public class RegisterV1ForPhone2Fragment extends BaseFragment implements View.OnClickListener {
    private String A;
    private int B;
    private View f;
    private Context g;
    private Dialog h;
    private CommonTopTitleNoTrans i;
    private View j;
    private ImageView k;
    private ClearEditText l;
    private String m;
    private String n;
    private String o;
    private LinearLayout q;
    private TextWatcher r;
    private TextView s;
    private TextView t;
    private ShapeTextView u;
    private GridCodeEditText v;
    private TextView w;
    private String x;
    private String y;
    private String z;
    private String e = RegisterV1ForPhone2Fragment.class.getSimpleName();
    private String p = "";

    /* renamed from: a  reason: collision with root package name */
    Runnable f31455a = new Runnable() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.3
        @Override // java.lang.Runnable
        public void run() {
            if (RegisterV1ForPhone2Fragment.this.B == 0) {
                RegisterV1ForPhone2Fragment.this.w.setEnabled(true);
                RegisterV1ForPhone2Fragment.this.w.setClickable(true);
                RegisterV1ForPhone2Fragment.this.w.setText(RegisterV1ForPhone2Fragment.this.getResources().getString(2131891539));
                RegisterV1ForPhone2Fragment.this.w.setTextColor(RegisterV1ForPhone2Fragment.this.getResources().getColor(2131101190));
                return;
            }
            RegisterV1ForPhone2Fragment.this.w.setEnabled(false);
            RegisterV1ForPhone2Fragment.this.w.setClickable(false);
            RegisterV1ForPhone2Fragment.this.w.setText(String.format(RegisterV1ForPhone2Fragment.this.getResources().getString(2131886709), Integer.valueOf(RegisterV1ForPhone2Fragment.this.B)));
            RegisterV1ForPhone2Fragment.this.w.setTextColor(RegisterV1ForPhone2Fragment.this.getResources().getColor(2131101206));
            RegisterV1ForPhone2Fragment.d(RegisterV1ForPhone2Fragment.this);
            if (RegisterV1ForPhone2Fragment.this.B == 0) {
                RegisterV1ForPhone2Fragment.this.postSafeRunOnUiThread(this);
            } else {
                RegisterV1ForPhone2Fragment.this.postDelaySafeRunOnUiThread(this, 1000L);
            }
        }
    };
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.6

        /* renamed from: a  reason: collision with root package name */
        String f31462a = "";

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<BluedLoginResult> parseData(String str) {
            this.f31462a = str;
            BluedEntityA<BluedLoginResult> bluedEntityA = (BluedEntityA) super.parseData(str);
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                        String a2 = AesCrypto2.a(bluedEntityA.data.get(0).getEncrypted());
                        Logger.b(RegisterV1ForPhone2Fragment.this.e, "解密：deData===", a2);
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
                Logger.b(RegisterV1ForPhone2Fragment.this.e, "===success", "加密：responseJson:", bluedEntityA);
                if (bluedEntityA.data.get(0) != null) {
                    BluedLoginResult bluedLoginResult = bluedEntityA.data.get(0);
                    UserInfo userInfo = UserInfo.getInstance();
                    userInfo.saveUserInfo(RegisterV1ForPhone2Fragment.this.o + "-" + RegisterV1ForPhone2Fragment.this.m, 1, this.f31462a, bluedLoginResult, new String[0]);
                    Bundle bundle = new Bundle();
                    bundle.putString("from_tag_page", "from_tag_register");
                    HomeArgumentHelper.a(RegisterV1ForPhone2Fragment.this.g, (String) null, bundle);
                }
            } catch (Exception e) {
                e.printStackTrace();
                AppMethods.d(2131887272);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            DialogUtils.b(RegisterV1ForPhone2Fragment.this.h);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            DialogUtils.a(RegisterV1ForPhone2Fragment.this.h);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public BluedUIHttpResponse f31456c = new BluedUIHttpResponse() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.7

        /* renamed from: a  reason: collision with root package name */
        int f31463a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f31464c;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str, String str2) {
            this.f31463a = i;
            this.b = str;
            this.f31464c = str2;
            if (i == 4036202 || i == 4036712) {
                return true;
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            BluedCheckResult bluedCheckResult;
            super.onUIFinish();
            DialogUtils.b(RegisterV1ForPhone2Fragment.this.h);
            int i = this.f31463a;
            if (i > 0) {
                switch (i) {
                    case 4036001:
                        RegisterV1ForPhone2Fragment.this.getActivity().finish();
                        return;
                    case 4036002:
                        RegisterV1ForPhone2Fragment.this.z = LoginRegisterTools.a(this.f31464c);
                        return;
                    case 4036202:
                        String str = this.b;
                        String str2 = str;
                        if (StringUtils.d(str)) {
                            str2 = "";
                        }
                        CommonAlertDialog.a(RegisterV1ForPhone2Fragment.this.g, "", str2, RegisterV1ForPhone2Fragment.this.g.getResources().getString(2131886605), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.7.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                RegisterV1ForPhone2Fragment.this.k();
                            }
                        }, RegisterV1ForPhone2Fragment.this.g.getResources().getString(2131886718), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.7.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                            }
                        }, (DialogInterface.OnDismissListener) null);
                        return;
                    case 4036205:
                        try {
                            Gson f = AppInfo.f();
                            BluedEntityA bluedEntityA = (BluedEntityA) f.fromJson(this.f31464c, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.7.1
                            }.getType());
                            if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (bluedCheckResult = (BluedCheckResult) f.fromJson(AesCrypto.c(((BluedCheckResult) bluedEntityA.data.get(0)).getEncrypted()), (Class<Object>) BluedCheckResult.class)) == null) {
                                return;
                            }
                            RegisterV1ForPhone2Fragment.this.z = bluedCheckResult.getCaptcha();
                            if (!StringUtils.d(RegisterV1ForPhone2Fragment.this.z)) {
                                LoginRegisterTools.a(RegisterV1ForPhone2Fragment.this.getFragmentActive(), RegisterV1ForPhone2Fragment.this.k, RegisterV1ForPhone2Fragment.this.z);
                            }
                            RegisterV1ForPhone2Fragment.this.j.setVisibility(0);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    case 4036712:
                        CommonAlertDialog.a(RegisterV1ForPhone2Fragment.this.g, RegisterV1ForPhone2Fragment.this.getString(R.string.common_string_notice), this.b, RegisterV1ForPhone2Fragment.this.getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.7.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Tracker.onClick(dialogInterface, i2);
                                SignInActivity.e = RegisterV1ForPhone2Fragment.this.m;
                                SignInActivity.f = RegisterV1ForPhone2Fragment.this.o;
                                SignInActivity.a(RegisterV1ForPhone2Fragment.this.g, new Bundle[0]);
                            }
                        }, (DialogInterface.OnDismissListener) null, 0);
                        return;
                    default:
                        if (i == 4036007) {
                            LoginRegisterHttpUtils.a("wrong_acode");
                        }
                        if (StringUtils.d(RegisterV1ForPhone2Fragment.this.z)) {
                            return;
                        }
                        LoginRegisterTools.a(RegisterV1ForPhone2Fragment.this.getFragmentActive(), RegisterV1ForPhone2Fragment.this.k, RegisterV1ForPhone2Fragment.this.z);
                        return;
                }
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            DialogUtils.a(RegisterV1ForPhone2Fragment.this.h);
            super.onUIStart();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            RegisterV1ForPhone2Fragment.this.o();
        }
    };
    public BluedUIHttpResponse d = new BluedUIHttpResponse() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.8

        /* renamed from: a  reason: collision with root package name */
        int f31469a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f31470c;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str, String str2) {
            this.f31469a = i;
            this.b = str;
            this.f31470c = str2;
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            DialogUtils.b(RegisterV1ForPhone2Fragment.this.h);
            int i = this.f31469a;
            if (i > 0) {
                switch (i) {
                    case 4036001:
                        RegisterV1ForPhone2Fragment.this.getActivity().finish();
                        break;
                    case 4036002:
                        RegisterV1ForPhone2Fragment.this.y = LoginRegisterTools.a(this.f31470c);
                        RegisterV1ForPhone2Fragment.this.n();
                        break;
                    case 4036204:
                        RegisterV1ForPhone2Fragment.this.m();
                        break;
                    default:
                        if (!StringUtils.d(RegisterV1ForPhone2Fragment.this.z)) {
                            LoginRegisterTools.a(RegisterV1ForPhone2Fragment.this.getFragmentActive(), RegisterV1ForPhone2Fragment.this.k, RegisterV1ForPhone2Fragment.this.z);
                            break;
                        }
                        break;
                }
            }
            super.onUIFinish();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            DialogUtils.a(RegisterV1ForPhone2Fragment.this.h);
            super.onUIStart();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            AppMethods.a((CharSequence) RegisterV1ForPhone2Fragment.this.g.getResources().getString(2131886716));
            RegisterV1ForPhone2Fragment.this.l();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public BluedEntity parseData(String str) {
            this.f31470c = str;
            return super.parseData(str);
        }
    };

    private void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f.findViewById(2131370749);
        this.i = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.i.f();
        this.i.setLeftClickListener(this);
        if (getArguments() != null) {
            String string = getArguments().getString("binding_type");
            this.A = string;
            if (!"change".equals(string)) {
                this.i.setCenterText(this.g.getString(2131886632));
                return;
            }
            this.i.setCenterText("");
            this.i.setTitleBackgroundDrawable(2131101191);
        }
    }

    private void a(String str) {
        BluedUIHttpResponse bluedUIHttpResponse = this.d;
        LoginRegisterHttpUtils.a(bluedUIHttpResponse, this.o + "-" + this.m, this.x, str, "mobile", "identify", "", getFragmentActive());
    }

    private void b() {
        this.t = (TextView) this.f.findViewById(2131371262);
        this.h = DialogUtils.a(this.g);
        LinearLayout linearLayout = (LinearLayout) this.f.findViewById(R.id.ll_root_layout);
        this.q = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.f.findViewById(R.id.tv_resend);
        this.w = textView;
        textView.setOnClickListener(this);
        ShapeTextView shapeTextView = (ShapeTextView) this.f.findViewById(2131371164);
        this.u = shapeTextView;
        shapeTextView.setOnClickListener(this);
        GridCodeEditText gridCodeEditText = (GridCodeEditText) this.f.findViewById(R.id.gcet_grid_code_view);
        this.v = gridCodeEditText;
        gridCodeEditText.setPasswordVisibility(true);
        this.j = this.f.findViewById(2131367685);
        ImageView imageView = (ImageView) this.f.findViewById(2131361892);
        this.k = imageView;
        imageView.setOnClickListener(this);
        this.l = ((CommonEdittextView) this.f.findViewById(2131362783)).getEditText();
        TextView textView2 = (TextView) this.f.findViewById(R.id.tv_resend);
        this.s = textView2;
        textView2.setOnClickListener(this);
        this.r = new TextWatcher() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                RegisterV1ForPhone2Fragment.this.c();
            }
        };
        this.v.setOnPasswordChangedListener(new GridCodeEditText.OnPasswordChangedListener() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.2
            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void a(String str) {
                RegisterV1ForPhone2Fragment.this.c();
            }

            @Override // com.soft.blued.customview.gridcodeedittext.GridCodeEditText.OnPasswordChangedListener
            public void b(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.j.getVisibility() == 8) {
            if (this.v.getPassWord() == null || this.v.getPassWord().length() != 6) {
                this.u.setEnabled(false);
            } else {
                this.u.setEnabled(true);
            }
        } else if (this.v.getPassWord() == null || this.v.getPassWord().length() != 6 || StringUtils.d(this.l.getText().toString())) {
            this.u.setEnabled(false);
        } else {
            this.u.setEnabled(true);
        }
    }

    static /* synthetic */ int d(RegisterV1ForPhone2Fragment registerV1ForPhone2Fragment) {
        int i = registerV1ForPhone2Fragment.B;
        registerV1ForPhone2Fragment.B = i - 1;
        return i;
    }

    private void d() {
        if (getArguments() != null) {
            this.m = getArguments().getString(LoginRegisterTools.e);
            String string = getArguments().getString(LoginRegisterTools.h);
            this.n = string;
            try {
                this.p = BluedHttpTools.b(string);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            TextView textView = this.t;
            textView.setText(getResources().getString(2131886705) + LoginRegisterTools.e(this.m) + "\n" + getResources().getString(2131886707));
            this.o = getArguments().getString(LoginRegisterTools.g);
            this.x = getArguments().getString(LoginRegisterTools.d);
            this.y = getArguments().getString(LoginRegisterTools.f31400c);
        }
        g();
    }

    private void e() {
        this.l.addTextChangedListener(this.r);
    }

    private void f() {
        this.l.removeTextChangedListener(this.r);
    }

    private void g() {
        this.B = 60;
        postSafeRunOnUiThread(this.f31455a);
    }

    private void h() {
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                RegisterV1ForPhone2Fragment.this.l();
                AppMethods.d(2131886716);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(RegisterV1ForPhone2Fragment.this.h);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(RegisterV1ForPhone2Fragment.this.h);
            }
        }, "mobile", "", (IRequestHost) null);
    }

    private void i() {
        LoginRegisterHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.login_register.RegisterV1ForPhone2Fragment.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    new Bundle().putString("binding_type", "add");
                    TerminalActivity.d(RegisterV1ForPhone2Fragment.this.g, BindingSecureEmailFragment.class, null);
                    RegisterV1ForPhone2Fragment.this.getActivity().finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.d(2131887272);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(RegisterV1ForPhone2Fragment.this.h);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                DialogUtils.a(RegisterV1ForPhone2Fragment.this.h);
            }
        }, 1, this.v.getPassWord(), (IRequestHost) null);
    }

    private void j() {
        LoginRegisterHttpUtils.b(this.f31456c, this.x, this.v.getPassWord(), this.l.getText().toString(), "mobile", getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        LoginRegisterHttpUtils.b(this.b, this.x, "mobile", this.n, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.j.setVisibility(8);
        this.l.setText("");
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.s.setEnabled(false);
        this.s.setText(this.g.getResources().getString(2131891539));
        this.s.setTextColor(this.g.getResources().getColor(2131101290));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Bundle bundle = new Bundle();
        bundle.putString(LoginRegisterTools.d, this.x);
        bundle.putString(LoginRegisterTools.f31400c, this.y);
        Logger.b(this.e, "tokenVer===", this.x);
        Logger.b(this.e, "captchaFromOne===", this.y);
        TerminalActivity.a(this, RegisterV1ForCaptchaCodeFragment.class, bundle, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        FinishProfile1Fragment.Companion companion = FinishProfile1Fragment.f20540a;
        Context context = this.g;
        String str = this.x;
        String str2 = this.n;
        companion.a(context, str, str2, this.o + "-" + this.m, LoginAndRegisterProtos.Source.PHONE, "");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000 && intent != null) {
            String stringExtra = intent.getStringExtra(LoginRegisterTools.f31400c);
            if (StringUtils.d(stringExtra)) {
                return;
            }
            a(stringExtra);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131361892:
                if (StringUtils.d(this.z)) {
                    return;
                }
                LoginRegisterTools.a(getFragmentActive(), this.k, this.z);
                return;
            case 2131363120:
                getActivity().finish();
                return;
            case R.id.ll_root_layout /* 2131368210 */:
                KeyboardUtils.a(getActivity());
                return;
            case 2131371164:
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.AUTHCODE_CONFIRM_BTN_CLICK);
                if (!TextUtils.isEmpty(this.A) && "change".equals(this.A)) {
                    i();
                    return;
                } else if (StringUtils.d(this.v.getPassWord())) {
                    AppMethods.d(2131886603);
                    return;
                } else {
                    if (this.j.getVisibility() != 0) {
                        j();
                    } else if (StringUtils.d(this.l.getText().toString())) {
                        AppMethods.d(2131886603);
                    } else {
                        j();
                    }
                    LoginRegisterHttpUtils.a("resend_acode_mo");
                    return;
                }
            case R.id.tv_resend /* 2131372436 */:
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.AUTHCODE_RESEND_BTN_CLICK);
                this.v.a();
                LoginRegisterHttpUtils.a("resend_acode");
                if ("change".equals(this.A)) {
                    h();
                    return;
                } else {
                    n();
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.g = getActivity();
        View view = this.f;
        if (view == null) {
            this.f = layoutInflater.inflate(R.layout.fragment_register_v1_forphone_step2, viewGroup, false);
            a();
            b();
            d();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f.getParent()).removeView(this.f);
        }
        return this.f;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        f();
        super.onStop();
    }
}
