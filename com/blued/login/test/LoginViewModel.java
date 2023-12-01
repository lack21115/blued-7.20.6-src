package com.blued.login.test;

import android.app.AlertDialog;
import android.content.Context;
import android.hardware.Camera;
import android.net.wifi.WifiEnterpriseConfig;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.collection.ArrayMap;
import androidx.lifecycle.MutableLiveData;
import com.anythink.pd.ExHandler;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.login.R;
import com.blued.login.model.BluedCheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.tencent.tendinsv.a.b;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/test/LoginViewModel.class */
public final class LoginViewModel extends BaseViewModel {
    private String d;
    private boolean e;

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<Boolean> f6966a = new MutableLiveData<>();
    private final MutableLiveData<String> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Integer> f6967c = new MutableLiveData<>();
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private LoginAccountModel j = new LoginAccountModel();

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context) {
        a(context, this.j);
    }

    private final void b(final Context context, final String str, final String str2, String str3) {
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        this.f = str;
        this.g = str2;
        Intrinsics.a(str);
        arrayMap.put("type", str);
        Intrinsics.a(str2);
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, str2);
        String b = BluedHttpTools.b(str3);
        Intrinsics.c(b, "getSHA(password)");
        arrayMap.put("password", b);
        String a3 = LoginDeviceUtils.a();
        Intrinsics.c(a3, "getDevicesID()");
        if (!TextUtils.isEmpty(a3)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, a3);
        }
        String b2 = LoginDeviceUtils.b();
        Intrinsics.c(b2, "getDevicesIDCompat()");
        if (!TextUtils.isEmpty(b2)) {
            arrayMap.put("dev_id_safe", b2);
        }
        String str4 = AppInfo.e;
        Intrinsics.c(str4, "mac");
        arrayMap.put("mac", str4);
        String str5 = AppInfo.d;
        Intrinsics.c(str5, b.a.f25299c);
        arrayMap.put(ExHandler.JSON_REQUEST_IMEI, str5);
        String str6 = AppInfo.c;
        Intrinsics.c(str6, "channel");
        arrayMap.put("channel", str6);
        String d = BluedDeviceIdentity.a().d();
        Intrinsics.c(d, "getInstance().shumengId");
        arrayMap.put("dev_dna", d);
        String e = BluedDeviceIdentity.a().e();
        Intrinsics.c(e, "getInstance().shumengDeviceLabel");
        arrayMap.put("dev_dna_label", e);
        String f = BluedDeviceIdentity.a().f();
        Intrinsics.c(f, "getInstance().shumeiId");
        arrayMap.put("smid", f);
        String g = BluedDeviceIdentity.a().g();
        Intrinsics.c(g, "getInstance().shumeiBoxId");
        arrayMap.put("boxid", g);
        String h = BluedDeviceIdentity.a().h();
        Intrinsics.c(h, "getInstance().oaid");
        arrayMap.put("oaid", h);
        if (this.e) {
            arrayMap.put("from", "auto");
        } else {
            arrayMap.put("from", Camera.Parameters.FOCUS_MODE_MANUAL_POSITION);
        }
        LoginAccountModel loginAccountModel = this.j;
        if (!TextUtils.isEmpty(loginAccountModel == null ? null : loginAccountModel.d())) {
            LoginAccountModel loginAccountModel2 = this.j;
            String d2 = loginAccountModel2 == null ? null : loginAccountModel2.d();
            Intrinsics.a(d2);
            arrayMap.put("rid", d2);
        }
        LoginAccountModel loginAccountModel3 = this.j;
        if (!TextUtils.isEmpty(loginAccountModel3 == null ? null : loginAccountModel3.e())) {
            LoginAccountModel loginAccountModel4 = this.j;
            String e2 = loginAccountModel4 == null ? null : loginAccountModel4.e();
            Intrinsics.a(e2);
            arrayMap.put("token", e2);
        }
        try {
            String b3 = AesCrypto2.b(AppInfo.f().toJson(arrayMap));
            Intrinsics.c(a2, "ajaxParams");
            a2.put("_", b3);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        HttpManager.b(Intrinsics.a(BluedHttpUrl.q(), "/passport/auth"), new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.blued.login.test.LoginViewModel$toLogin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super((IRequestHost) null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<BluedLoginResult> parseData(String str7) {
                List list;
                LoginViewModel.this.a(str7);
                BluedEntityA<BluedLoginResult> parseData = super.parseData(str7);
                if (parseData == null) {
                    list = null;
                } else {
                    try {
                        list = parseData.data;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        AppMethods.a("解析失败");
                    }
                }
                if (list != null && parseData.data.size() > 0) {
                    parseData.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(((BluedLoginResult) parseData.data.get(0)).getEncrypted()), (Class<Object>) BluedLoginResult.class));
                    return parseData;
                }
                return parseData;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                try {
                    Intrinsics.a(bluedEntityA);
                    UserInfo.getInstance().saveUserInfo(str2, Intrinsics.a("mobile", str) ? 1 : 0, LoginViewModel.this.f(), (BluedLoginResult) bluedEntityA.data.get(0), new String[]{null});
                    LoginViewModel.this.d().setValue(true);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    AppMethods.a("登录失败");
                }
            }

            public boolean onUIFailure(int i, String str7, String str8) {
                if (i == 401) {
                    String str9 = str7;
                    if (!TextUtils.isEmpty(str9)) {
                        AppMethods.a(str9);
                    }
                    LoginAccountModel k = LoginViewModel.this.k();
                    if (TextUtils.isEmpty(k == null ? null : k.f())) {
                        return true;
                    }
                    LoginViewModel.this.e().setValue(1);
                    return true;
                } else if (i == 4035009) {
                    AppMethods.a("账号：" + ((Object) str2) + "请输入验证码");
                    LoginViewModel loginViewModel = LoginViewModel.this;
                    BluedCheckResult g2 = loginViewModel.g(str8);
                    Intrinsics.a(g2);
                    String token = g2.getToken();
                    Intrinsics.c(token, "getTokenAndMobile(responseContent)!!.getToken()");
                    loginViewModel.c(token);
                    if (TextUtils.equals(str, "mobile")) {
                        LoginViewModel.this.b("login_mobile");
                    } else {
                        LoginViewModel.this.b("login_email");
                    }
                    final LoginViewModel loginViewModel2 = LoginViewModel.this;
                    loginViewModel2.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.login.test.LoginViewModel$toLogin$1$onUIFailure$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super((IRequestHost) null);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                            LoginViewModel.this.e().setValue(2);
                        }
                    }, LoginViewModel.this.j(), "send", "", LoginViewModel.this.i(), null);
                    return true;
                } else if (i != 4036002 && i != 4036205) {
                    String str10 = str7;
                    if (TextUtils.isEmpty(str10)) {
                        return true;
                    }
                    AppMethods.a(str10);
                    return true;
                } else {
                    AppMethods.a(str7);
                    LoginAccountModel k2 = LoginViewModel.this.k();
                    if (k2 != null) {
                        String[] e4 = LoginViewModel.this.e(str8);
                        k2.f(e4 == null ? null : e4[0]);
                    }
                    if (LoginViewModel.this.f(str8)) {
                        final LoginViewModel loginViewModel3 = LoginViewModel.this;
                        final Context context2 = context;
                        loginViewModel3.a(context2, new SmCaptchaWebView.ResultListener() { // from class: com.blued.login.test.LoginViewModel$toLogin$1$onUIFailure$1
                            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
                            public void onError(int i2) {
                            }

                            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
                            public void onReady() {
                            }

                            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
                            public void onSuccess(CharSequence charSequence, boolean z) {
                                LoginAccountModel k3 = LoginViewModel.this.k();
                                if (k3 != null) {
                                    k3.e(String.valueOf(charSequence));
                                }
                                LoginViewModel.this.a(context2);
                            }
                        });
                        return true;
                    }
                    LoginAccountModel k3 = LoginViewModel.this.k();
                    if (k3 != null) {
                        String[] e5 = LoginViewModel.this.e(str8);
                        k3.g(e5 == null ? null : e5[1]);
                    }
                    LoginViewModel.this.a(context);
                    return true;
                }
            }
        }, (IRequestHost) null).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a2)).a(false).h();
    }

    public final AlertDialog a(Context context, final SmCaptchaWebView.ResultListener resultListener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_sm_captcha_test, (ViewGroup) null, false);
        Intrinsics.c(inflate, "from(context).inflate(R.…aptcha_test, null, false)");
        final AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
        Intrinsics.a(context);
        String string = context.getString(R.string.biao_v1_lr_ver_sm_captcha);
        Intrinsics.c(string, "context!!.getString(R.st…iao_v1_lr_ver_sm_captcha)");
        View findViewById = inflate.findViewById(R.id.sm_captcha);
        Intrinsics.c(findViewById, "contentView.findViewById(R.id.sm_captcha)");
        SmCaptchaWebView smCaptchaWebView = (SmCaptchaWebView) findViewById;
        SmCaptchaWebView.SmOption smOption = new SmCaptchaWebView.SmOption();
        smOption.setOrganization("qRLrIEyYwqE1vOhOACQy");
        smOption.setMode(SmCaptchaWebView.MODE_SLIDE);
        smOption.setAppId("1");
        smOption.setChannel(AppInfo.c);
        if (!BlueAppLocal.d()) {
            HashMap hashMap = new HashMap();
            hashMap.put("lang", "en");
            smOption.setExtOption(hashMap);
        }
        if (!TextUtils.isEmpty(string)) {
            smOption.setTipMessage(string);
        }
        smCaptchaWebView.setBackgroundColor(0);
        smCaptchaWebView.initWithOption(smOption, new SmCaptchaWebView.ResultListener() { // from class: com.blued.login.test.LoginViewModel$showSmCaptcha$listener$1
            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onError(int i) {
                SmCaptchaWebView.ResultListener resultListener2 = SmCaptchaWebView.ResultListener.this;
                if (resultListener2 != null) {
                    resultListener2.onError(i);
                }
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onReady() {
                SmCaptchaWebView.ResultListener resultListener2 = SmCaptchaWebView.ResultListener.this;
                if (resultListener2 != null) {
                    resultListener2.onReady();
                }
            }

            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
            public void onSuccess(CharSequence charSequence, boolean z) {
                AlertDialog alertDialog;
                Intrinsics.e(charSequence, "rid");
                SmCaptchaWebView.ResultListener resultListener2 = SmCaptchaWebView.ResultListener.this;
                if (resultListener2 != null) {
                    resultListener2.onSuccess(charSequence, z);
                }
                if (!z || (alertDialog = create) == null) {
                    return;
                }
                alertDialog.dismiss();
            }
        });
        Intrinsics.a(create);
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        create.show();
        if (create.getWindow() != null) {
            Window window = create.getWindow();
            Intrinsics.a(window);
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        return create;
    }

    public final void a(Context context, LoginAccountModel loginAccountModel) {
        this.j = loginAccountModel;
        b(context, loginAccountModel == null ? null : loginAccountModel.getType(), loginAccountModel == null ? null : loginAccountModel.b(), loginAccountModel == null ? null : loginAccountModel.c());
    }

    public final void a(final Context context, String str, final String str2, String str3) {
        boolean z;
        Intrinsics.e(str, "phoneNum");
        Intrinsics.e(str2, "vCode");
        Intrinsics.e(str3, "captcha");
        LoginAccountModel loginAccountModel = this.j;
        if (loginAccountModel != null) {
            loginAccountModel.c(str);
        }
        LoginAccountModel loginAccountModel2 = this.j;
        if (loginAccountModel2 != null) {
            loginAccountModel2.i(str2);
        }
        LoginAccountModel loginAccountModel3 = this.j;
        if (loginAccountModel3 != null) {
            loginAccountModel3.h(str3);
        }
        ArrayMap arrayMap = new ArrayMap();
        String a2 = LoginDeviceUtils.a();
        Intrinsics.c(a2, "getDevicesID()");
        if (!TextUtils.isEmpty(a2)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, a2);
        }
        String f = BluedDeviceIdentity.a().f();
        Intrinsics.c(f, "getInstance().shumeiId");
        arrayMap.put("smid", f);
        String g = BluedDeviceIdentity.a().g();
        Intrinsics.c(g, "getInstance().shumeiBoxId");
        arrayMap.put("boxid", g);
        String d = BluedDeviceIdentity.a().d();
        Intrinsics.c(d, "getInstance().shumengId");
        arrayMap.put("dev_dna", d);
        String e = BluedDeviceIdentity.a().e();
        Intrinsics.c(e, "getInstance().shumengDeviceLabel");
        arrayMap.put("dev_dna_label", e);
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, str);
        arrayMap.put("type", "mobile");
        if (TextUtils.isEmpty(str2)) {
            z = "identify";
        } else {
            arrayMap.put("authcode", str2);
            z = "verify";
        }
        arrayMap.put("stage", z);
        LoginAccountModel loginAccountModel4 = this.j;
        if (!TextUtils.isEmpty(loginAccountModel4 == null ? null : loginAccountModel4.d())) {
            LoginAccountModel loginAccountModel5 = this.j;
            String d2 = loginAccountModel5 == null ? null : loginAccountModel5.d();
            Intrinsics.a(d2);
            arrayMap.put("rid", d2);
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayMap.put("captcha", str3);
        }
        String str4 = AppInfo.c;
        Intrinsics.c(str4, "channel");
        arrayMap.put("channel", str4);
        Map a3 = BluedHttpTools.a();
        try {
            String json = AppInfo.f().toJson(arrayMap);
            Intrinsics.c(a3, "ajaxParams");
            a3.put("_", AesCrypto2.b(json));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HttpManager.b(Intrinsics.a(BluedHttpUrl.q(), "/passport/3rd/message/auth"), new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.blued.login.test.LoginViewModel$phoneCodeLogin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super((IRequestHost) null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<BluedLoginResult> parseData(String str5) {
                List list;
                if (TextUtils.isEmpty(str2)) {
                    return super.parseData(str5);
                }
                this.a(str5);
                BluedEntityA<BluedLoginResult> parseData = super.parseData(str5);
                if (parseData == null) {
                    list = null;
                } else {
                    try {
                        list = parseData.data;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        AppMethods.a("解析失败");
                    }
                }
                if (list != null && parseData.data.size() > 0) {
                    parseData.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(((BluedLoginResult) parseData.data.get(0)).getEncrypted()), (Class<Object>) BluedLoginResult.class));
                    return parseData;
                }
                return parseData;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                if (TextUtils.isEmpty(str2)) {
                    AppMethods.a("验证码已发送");
                    return;
                }
                try {
                    Intrinsics.a(bluedEntityA);
                    UserInfo.getInstance().saveUserInfo(this.h(), 1, this.f(), (BluedLoginResult) bluedEntityA.data.get(0), new String[]{null});
                    this.d().setValue(true);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    AppMethods.a("登录失败");
                }
            }

            public boolean onUIFailure(int i, String str5, String str6) {
                if (i == 4036002 || i == 4036205) {
                    AppMethods.a(str5);
                    LoginAccountModel k = this.k();
                    if (k != null) {
                        String[] e3 = this.e(str6);
                        k.f(e3 == null ? null : e3[0]);
                    }
                    if (this.f(str6)) {
                        final LoginViewModel loginViewModel = this;
                        final Context context2 = context;
                        loginViewModel.a(context2, new SmCaptchaWebView.ResultListener() { // from class: com.blued.login.test.LoginViewModel$phoneCodeLogin$1$onUIFailure$1
                            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
                            public void onError(int i2) {
                            }

                            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
                            public void onReady() {
                            }

                            @Override // com.ishumei.sdk.captcha.SmCaptchaWebView.ResultListener
                            public void onSuccess(CharSequence charSequence, boolean z2) {
                                LoginAccountModel k2 = LoginViewModel.this.k();
                                if (k2 != null) {
                                    k2.e(String.valueOf(charSequence));
                                }
                                LoginViewModel loginViewModel2 = LoginViewModel.this;
                                Context context3 = context2;
                                LoginAccountModel k3 = loginViewModel2.k();
                                String str7 = null;
                                String b = k3 == null ? null : k3.b();
                                Intrinsics.a(b);
                                LoginAccountModel k4 = LoginViewModel.this.k();
                                if (k4 != null) {
                                    str7 = k4.h();
                                }
                                Intrinsics.a(str7);
                                loginViewModel2.a(context3, b, str7, "");
                            }
                        });
                    } else {
                        LoginAccountModel k2 = this.k();
                        if (k2 != null) {
                            String[] e4 = this.e(str6);
                            k2.g(e4 == null ? null : e4[1]);
                        }
                        LoginAccountModel k3 = this.k();
                        if (!TextUtils.isEmpty(k3 == null ? null : k3.f())) {
                            this.e().setValue(1);
                        }
                    }
                }
                return super.onUIFailure(i, str5, str6);
            }
        }, (IRequestHost) null).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(a3)).h();
    }

    public final void a(BluedUIHttpResponse<?> bluedUIHttpResponse, String str, String str2, String str3, String str4, IRequestHost iRequestHost) {
        Intrinsics.e(str, "token");
        Intrinsics.e(str2, "stage");
        Intrinsics.e(str3, "code");
        Intrinsics.e(str4, "type");
        Map a2 = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", str);
        arrayMap.put("stage", str2);
        arrayMap.put("authcode", str3);
        arrayMap.put("type", str4);
        try {
            String b = AesCrypto2.b(AppInfo.f().toJson(arrayMap));
            Intrinsics.c(a2, "ajaxParams");
            a2.put("_", b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(Intrinsics.a(BluedHttpUrl.q(), "/passport/safe/device"), (HttpResponseHandler) bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void b(String str) {
        Intrinsics.e(str, "<set-?>");
        this.h = str;
    }

    public final void c(String str) {
        Intrinsics.e(str, "<set-?>");
        this.i = str;
    }

    public final MutableLiveData<Boolean> d() {
        return this.f6966a;
    }

    public final void d(String str) {
        Intrinsics.e(str, "code");
        a(new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.blued.login.test.LoginViewModel$toVerifyPhoneCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((IRequestHost) null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<BluedLoginResult> parseData(String str2) {
                List list;
                LoginViewModel.this.a(str2);
                BluedEntityA<BluedLoginResult> parseData = super.parseData(str2);
                if (parseData == null) {
                    list = null;
                } else {
                    try {
                        list = parseData.data;
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a("解析失败");
                    }
                }
                if (list != null && parseData.data.size() > 0) {
                    parseData.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(((BluedLoginResult) parseData.data.get(0)).getEncrypted()), (Class<Object>) BluedLoginResult.class));
                    return parseData;
                }
                return parseData;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                try {
                    Intrinsics.a(bluedEntityA);
                    UserInfo.getInstance().saveUserInfo(LoginViewModel.this.h(), Intrinsics.a("mobile", LoginViewModel.this.g()) ? 1 : 0, LoginViewModel.this.f(), (BluedLoginResult) bluedEntityA.data.get(0), new String[]{null});
                    LoginViewModel.this.d().setValue(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a("登录失败");
                }
            }
        }, this.i, "verify", str, this.h, null);
    }

    public final MutableLiveData<Integer> e() {
        return this.f6967c;
    }

    public final String[] e(String str) {
        BluedCheckResult bluedCheckResult;
        String[] strArr = new String[2];
        try {
            Gson f = AppInfo.f();
            BluedEntityA bluedEntityA = (BluedEntityA) f.fromJson(str, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.blued.login.test.LoginViewModel$getTokenAndCaptcha$bluedEntityA$1
            }.getType());
            if (bluedEntityA != null && bluedEntityA.hasData() && (bluedCheckResult = (BluedCheckResult) f.fromJson(AesCrypto2.a(((BluedCheckResult) bluedEntityA.data.get(0)).getEncrypted()), (Class<Object>) BluedCheckResult.class)) != null) {
                strArr[0] = bluedCheckResult.getToken();
                strArr[1] = bluedCheckResult.getCaptcha();
                return strArr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArr;
    }

    public final String f() {
        return this.d;
    }

    public final boolean f(String str) {
        BluedCheckResult bluedCheckResult;
        try {
            Gson f = AppInfo.f();
            BluedEntityA bluedEntityA = (BluedEntityA) f.fromJson(str, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.blued.login.test.LoginViewModel$isSmCaptcha$bluedEntityA$1
            }.getType());
            if (bluedEntityA == null || !bluedEntityA.hasData() || (bluedCheckResult = (BluedCheckResult) f.fromJson(AesCrypto2.a(((BluedCheckResult) bluedEntityA.data.get(0)).getEncrypted()), (Class<Object>) BluedCheckResult.class)) == null) {
                return false;
            }
            return bluedCheckResult.getIs_sm_captcha() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final BluedCheckResult g(String str) {
        try {
            Gson f = AppInfo.f();
            BluedEntityA bluedEntityA = (BluedEntityA) f.fromJson(str, new TypeToken<BluedEntityA<BluedCheckResult>>() { // from class: com.blued.login.test.LoginViewModel$getTokenAndMobile$bluedEntityA$1
            }.getType());
            if (bluedEntityA != null && bluedEntityA.hasData()) {
                Object fromJson = f.fromJson(AesCrypto2.a(((BluedCheckResult) bluedEntityA.data.get(0)).getEncrypted()), (Class<Object>) BluedCheckResult.class);
                Intrinsics.c(fromJson, "gson.fromJson(deData, Bl…dCheckResult::class.java)");
                return (BluedCheckResult) fromJson;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BluedCheckResult();
    }

    public final String g() {
        return this.f;
    }

    public final String h() {
        return this.g;
    }

    public final String i() {
        return this.h;
    }

    public final String j() {
        return this.i;
    }

    public final LoginAccountModel k() {
        return this.j;
    }
}
