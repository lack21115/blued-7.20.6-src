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
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.login.R;
import com.blued.login.model.BluedCheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
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
    private final MutableLiveData<Boolean> f20572a = new MutableLiveData<>();
    private final MutableLiveData<String> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Integer> f20573c = new MutableLiveData<>();
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
        Map<String, String> ajaxParams = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        this.f = str;
        this.g = str2;
        Intrinsics.a((Object) str);
        arrayMap.put("type", str);
        Intrinsics.a((Object) str2);
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, str2);
        String b = BluedHttpTools.b(str3);
        Intrinsics.c(b, "getSHA(password)");
        arrayMap.put("password", b);
        String a2 = LoginDeviceUtils.a();
        Intrinsics.c(a2, "getDevicesID()");
        if (!TextUtils.isEmpty(a2)) {
            arrayMap.put(UGCDataReportDef.DR_KEY_DEV_ID, a2);
        }
        String b2 = LoginDeviceUtils.b();
        Intrinsics.c(b2, "getDevicesIDCompat()");
        if (!TextUtils.isEmpty(b2)) {
            arrayMap.put("dev_id_safe", b2);
        }
        String mac = AppInfo.e;
        Intrinsics.c(mac, "mac");
        arrayMap.put("mac", mac);
        String IMEI = AppInfo.d;
        Intrinsics.c(IMEI, "IMEI");
        arrayMap.put("imei", IMEI);
        String channel = AppInfo.f9487c;
        Intrinsics.c(channel, "channel");
        arrayMap.put("channel", channel);
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
            Intrinsics.a((Object) d2);
            arrayMap.put("rid", d2);
        }
        LoginAccountModel loginAccountModel3 = this.j;
        if (!TextUtils.isEmpty(loginAccountModel3 == null ? null : loginAccountModel3.e())) {
            LoginAccountModel loginAccountModel4 = this.j;
            String e2 = loginAccountModel4 == null ? null : loginAccountModel4.e();
            Intrinsics.a((Object) e2);
            arrayMap.put("token", e2);
        }
        try {
            String b3 = AesCrypto2.b(AppInfo.f().toJson(arrayMap));
            Intrinsics.c(ajaxParams, "ajaxParams");
            ajaxParams.put(BridgeUtil.UNDERLINE_STR, b3);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        HttpManager.b(Intrinsics.a(BluedHttpUrl.q(), (Object) "/passport/auth"), new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.blued.login.test.LoginViewModel$toLogin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedLoginResult> parseData(String str4) {
                List<BluedLoginResult> list;
                LoginViewModel.this.a(str4);
                BluedEntityA<BluedLoginResult> bluedEntityA = (BluedEntityA) super.parseData(str4);
                if (bluedEntityA == null) {
                    list = null;
                } else {
                    try {
                        list = bluedEntityA.data;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        AppMethods.a((CharSequence) "解析失败");
                    }
                }
                if (list != null && bluedEntityA.data.size() > 0) {
                    bluedEntityA.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(bluedEntityA.data.get(0).getEncrypted()), (Class<Object>) BluedLoginResult.class));
                    return bluedEntityA;
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                try {
                    Intrinsics.a(bluedEntityA);
                    UserInfo.getInstance().saveUserInfo(str2, Intrinsics.a((Object) "mobile", (Object) str) ? 1 : 0, LoginViewModel.this.f(), bluedEntityA.data.get(0), null);
                    LoginViewModel.this.d().setValue(true);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    AppMethods.a((CharSequence) "登录失败");
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str4, String str5) {
                if (i == 401) {
                    String str6 = str4;
                    if (!TextUtils.isEmpty(str6)) {
                        AppMethods.a((CharSequence) str6);
                    }
                    LoginAccountModel k = LoginViewModel.this.k();
                    if (TextUtils.isEmpty(k == null ? null : k.f())) {
                        return true;
                    }
                    LoginViewModel.this.e().setValue(1);
                    return true;
                } else if (i == 4035009) {
                    AppMethods.a((CharSequence) ("账号：" + ((Object) str2) + "请输入验证码"));
                    LoginViewModel loginViewModel = LoginViewModel.this;
                    BluedCheckResult g2 = loginViewModel.g(str5);
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
                            super(null);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                        /* renamed from: a */
                        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                            LoginViewModel.this.e().setValue(2);
                        }
                    }, LoginViewModel.this.j(), "send", "", LoginViewModel.this.i(), null);
                    return true;
                } else if (i != 4036002 && i != 4036205) {
                    String str7 = str4;
                    if (TextUtils.isEmpty(str7)) {
                        return true;
                    }
                    AppMethods.a((CharSequence) str7);
                    return true;
                } else {
                    AppMethods.a((CharSequence) str4);
                    LoginAccountModel k2 = LoginViewModel.this.k();
                    if (k2 != null) {
                        String[] e4 = LoginViewModel.this.e(str5);
                        k2.f(e4 == null ? null : e4[0]);
                    }
                    if (LoginViewModel.this.f(str5)) {
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
                        String[] e5 = LoginViewModel.this.e(str5);
                        k3.g(e5 == null ? null : e5[1]);
                    }
                    LoginViewModel.this.a(context);
                    return true;
                }
            }
        }, null).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(ajaxParams)).a(false).h();
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
        smOption.setChannel(AppInfo.f9487c);
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
            public void onSuccess(CharSequence rid, boolean z) {
                AlertDialog alertDialog;
                Intrinsics.e(rid, "rid");
                SmCaptchaWebView.ResultListener resultListener2 = SmCaptchaWebView.ResultListener.this;
                if (resultListener2 != null) {
                    resultListener2.onSuccess(rid, z);
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

    public final void a(final Context context, String phoneNum, final String vCode, String captcha) {
        boolean z;
        Intrinsics.e(phoneNum, "phoneNum");
        Intrinsics.e(vCode, "vCode");
        Intrinsics.e(captcha, "captcha");
        LoginAccountModel loginAccountModel = this.j;
        if (loginAccountModel != null) {
            loginAccountModel.c(phoneNum);
        }
        LoginAccountModel loginAccountModel2 = this.j;
        if (loginAccountModel2 != null) {
            loginAccountModel2.i(vCode);
        }
        LoginAccountModel loginAccountModel3 = this.j;
        if (loginAccountModel3 != null) {
            loginAccountModel3.h(captcha);
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
        arrayMap.put(WifiEnterpriseConfig.IDENTITY_KEY, phoneNum);
        arrayMap.put("type", "mobile");
        if (TextUtils.isEmpty(vCode)) {
            z = "identify";
        } else {
            arrayMap.put("authcode", vCode);
            z = "verify";
        }
        arrayMap.put("stage", z);
        LoginAccountModel loginAccountModel4 = this.j;
        if (!TextUtils.isEmpty(loginAccountModel4 == null ? null : loginAccountModel4.d())) {
            LoginAccountModel loginAccountModel5 = this.j;
            String d2 = loginAccountModel5 == null ? null : loginAccountModel5.d();
            Intrinsics.a((Object) d2);
            arrayMap.put("rid", d2);
        }
        if (!TextUtils.isEmpty(captcha)) {
            arrayMap.put("captcha", captcha);
        }
        String channel = AppInfo.f9487c;
        Intrinsics.c(channel, "channel");
        arrayMap.put("channel", channel);
        Map<String, String> ajaxParams = BluedHttpTools.a();
        try {
            String json = AppInfo.f().toJson(arrayMap);
            Intrinsics.c(ajaxParams, "ajaxParams");
            ajaxParams.put(BridgeUtil.UNDERLINE_STR, AesCrypto2.b(json));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        HttpManager.b(Intrinsics.a(BluedHttpUrl.q(), (Object) "/passport/3rd/message/auth"), new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.blued.login.test.LoginViewModel$phoneCodeLogin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedLoginResult> parseData(String str) {
                List<BluedLoginResult> list;
                if (TextUtils.isEmpty(String.this)) {
                    return (BluedEntityA) super.parseData(str);
                }
                this.a(str);
                BluedEntityA<BluedLoginResult> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA == null) {
                    list = null;
                } else {
                    try {
                        list = bluedEntityA.data;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        AppMethods.a((CharSequence) "解析失败");
                    }
                }
                if (list != null && bluedEntityA.data.size() > 0) {
                    bluedEntityA.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(bluedEntityA.data.get(0).getEncrypted()), (Class<Object>) BluedLoginResult.class));
                    return bluedEntityA;
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                if (TextUtils.isEmpty(String.this)) {
                    AppMethods.a((CharSequence) "验证码已发送");
                    return;
                }
                try {
                    Intrinsics.a(bluedEntityA);
                    UserInfo.getInstance().saveUserInfo(this.h(), 1, this.f(), bluedEntityA.data.get(0), null);
                    this.d().setValue(true);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    AppMethods.a((CharSequence) "登录失败");
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                if (i == 4036002 || i == 4036205) {
                    AppMethods.a((CharSequence) str);
                    LoginAccountModel k = this.k();
                    if (k != null) {
                        String[] e3 = this.e(str2);
                        k.f(e3 == null ? null : e3[0]);
                    }
                    if (this.f(str2)) {
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
                                String str3 = null;
                                String b = k3 == null ? null : k3.b();
                                Intrinsics.a((Object) b);
                                LoginAccountModel k4 = LoginViewModel.this.k();
                                if (k4 != null) {
                                    str3 = k4.h();
                                }
                                Intrinsics.a((Object) str3);
                                loginViewModel2.a(context3, b, str3, "");
                            }
                        });
                    } else {
                        LoginAccountModel k2 = this.k();
                        if (k2 != null) {
                            String[] e4 = this.e(str2);
                            k2.g(e4 == null ? null : e4[1]);
                        }
                        LoginAccountModel k3 = this.k();
                        if (!TextUtils.isEmpty(k3 == null ? null : k3.f())) {
                            this.e().setValue(1);
                        }
                    }
                }
                return super.onUIFailure(i, str, str2);
            }
        }, null).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(ajaxParams)).h();
    }

    public final void a(BluedUIHttpResponse<?> bluedUIHttpResponse, String token, String stage, String code, String type, IRequestHost iRequestHost) {
        Intrinsics.e(token, "token");
        Intrinsics.e(stage, "stage");
        Intrinsics.e(code, "code");
        Intrinsics.e(type, "type");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("token", token);
        arrayMap.put("stage", stage);
        arrayMap.put("authcode", code);
        arrayMap.put("type", type);
        try {
            String b = AesCrypto2.b(AppInfo.f().toJson(arrayMap));
            Intrinsics.c(ajaxParams, "ajaxParams");
            ajaxParams.put(BridgeUtil.UNDERLINE_STR, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpManager.b(Intrinsics.a(BluedHttpUrl.q(), (Object) "/passport/safe/device"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(ajaxParams)).h();
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
        return this.f20572a;
    }

    public final void d(String code) {
        Intrinsics.e(code, "code");
        a(new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.blued.login.test.LoginViewModel$toVerifyPhoneCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedLoginResult> parseData(String str) {
                List<BluedLoginResult> list;
                LoginViewModel.this.a(str);
                BluedEntityA<BluedLoginResult> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA == null) {
                    list = null;
                } else {
                    try {
                        list = bluedEntityA.data;
                    } catch (Exception e) {
                        e.printStackTrace();
                        AppMethods.a((CharSequence) "解析失败");
                    }
                }
                if (list != null && bluedEntityA.data.size() > 0) {
                    bluedEntityA.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(bluedEntityA.data.get(0).getEncrypted()), (Class<Object>) BluedLoginResult.class));
                    return bluedEntityA;
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                try {
                    Intrinsics.a(bluedEntityA);
                    UserInfo.getInstance().saveUserInfo(LoginViewModel.this.h(), Intrinsics.a((Object) "mobile", (Object) LoginViewModel.this.g()) ? 1 : 0, LoginViewModel.this.f(), bluedEntityA.data.get(0), null);
                    LoginViewModel.this.d().setValue(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) "登录失败");
                }
            }
        }, this.i, "verify", code, this.h, null);
    }

    public final MutableLiveData<Integer> e() {
        return this.f20573c;
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
