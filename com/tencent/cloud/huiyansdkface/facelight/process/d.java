package com.tencent.cloud.huiyansdkface.facelight.process;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.cloud.huiyansdkface.facelight.a.b.b;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbFaceVerifyInitCusSdkCallback;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.c.e;
import com.tencent.cloud.huiyansdkface.facelight.c.f;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.CusInitParam;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.LoginResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.WbCusMetaData;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbUiTips;
import com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity;
import com.tencent.cloud.huiyansdkface.facelight.ui.FaceVerifyActivity;
import com.tencent.cloud.huiyansdkface.facelivesdk.BuildConfig;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFrameworkTool;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f35631a;
    private WbCloudFaceVerifyResultListener b;

    /* renamed from: c  reason: collision with root package name */
    private WbCloudFaceVerifyLoginListener f35632c;
    private WbFaceVerifyInitCusSdkCallback d;
    private boolean e;
    private boolean f;
    private String g;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private String t;
    private boolean u;
    private boolean v;
    private CloudFaceCountDownTimer w;
    private com.tencent.cloud.huiyansdkface.facelight.a.a.c h = new com.tencent.cloud.huiyansdkface.facelight.a.a.c();
    private com.tencent.cloud.huiyansdkface.facelight.a.a.b i = new com.tencent.cloud.huiyansdkface.facelight.a.a.b();
    private com.tencent.cloud.huiyansdkface.facelight.a.b.a j = new com.tencent.cloud.huiyansdkface.facelight.a.b.a();
    private com.tencent.cloud.huiyansdkface.facelight.c.c x = new com.tencent.cloud.huiyansdkface.facelight.c.c();

    private void B() {
        this.m = 0;
        this.l = 0;
        this.s = 0;
        this.t = "";
        this.u = false;
        this.v = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.n = false;
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.w;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.w = null;
        }
        Param.setDeviceModel(Build.MODEL);
    }

    private void C() {
        WLogger.d("WbFaceVerifyControl", "encrySdkInfoAndReturn");
        String str = null;
        this.g = null;
        String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(false, generateAESKey, "cus login:");
        try {
            str = WbCloudNetSecurityManger.base64Encry(false, new WeJson().toJson(new CusInitParam()), generateAESKey);
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("WbFaceVerifyControl", "encry CusInitParam failed!" + e.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry CusInitParam failed!" + e.toString(), null);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("encryptedAESKey", encryptAESKey);
        hashMap.put("identityStr", str);
        WbFaceVerifyInitCusSdkCallback wbFaceVerifyInitCusSdkCallback = this.d;
        if (wbFaceVerifyInitCusSdkCallback != null) {
            this.g = generateAESKey;
            wbFaceVerifyInitCusSdkCallback.onInitSuccess(hashMap);
        }
    }

    private void D() {
        if (this.j.O()) {
            WLogger.e("WbFaceVerifyControl", "[WBFACE] duplicate init,ignore!");
        } else {
            Log.e("WbFaceVerifyControl", "[WBFACE] duplicate init,ignore!");
        }
    }

    private void a(Context context) {
        WLogger.setEnable(this.j.O(), "cloud face");
        WLogger.localLogFileName(context, "kyc-face-log");
    }

    private void a(final Context context, long j) {
        WLogger.d("WbFaceVerifyControl", "startLoginRequest");
        this.o = true;
        new com.tencent.cloud.huiyansdkface.facelight.process.d.a(f35631a, this.x).a(context, j, new ProcessCallback<LoginResult>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.d.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a */
            public void onSuccess(LoginResult loginResult) {
                d.this.j.f(loginResult.protocolCorpName);
                d.this.j.g(loginResult.authProtocolVersion);
                d.this.j.h(loginResult.testMsg);
                d.this.j.k(loginResult.activeType);
                d.this.j.j(loginResult.colorData);
                d.this.j.d(loginResult.needLogReport);
                d.this.j.b(loginResult.needAuth);
                d.this.j.c(loginResult.authTickSwitch);
                d.this.j.a(loginResult.popupWarnSwitch);
                d.this.j.e(loginResult.optimalGradeType);
                d.this.j.i(loginResult.uploadWillVideo);
                WLogger.d("WbFaceVerifyControl", "isLoginOk true");
                d.this.u = true;
                d.this.e(context);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                d.this.a(context, wbFaceInnerError.toWbFaceError());
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, WbFaceError wbFaceError) {
        WLogger.w("WbFaceVerifyControl", "LoginFailed!" + wbFaceError.getReason());
        this.e = false;
        Properties Z = this.j.Z();
        Z.setProperty("isInit", String.valueOf(this.e));
        Z.setProperty("isStartSdk", String.valueOf(this.f));
        if (WbFaceError.WBFaceErrorDomainLoginNetwork.equals(wbFaceError.getDomain())) {
            KycWaSDK.getInstance().trackIMSWarnVEvent(context, "faceservice_login_network_fail", wbFaceError.getReason(), Z);
        } else {
            KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_login_fail", wbFaceError.getReason(), Z);
        }
        WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener = this.f35632c;
        if (wbCloudFaceVerifyLoginListener != null) {
            wbCloudFaceVerifyLoginListener.onLoginFailed(wbFaceError);
        }
    }

    private void a(final Context context, String str) {
        WLogger.d("WbFaceVerifyControl", "getCdnConfig：" + str);
        this.i = new com.tencent.cloud.huiyansdkface.facelight.a.a.b();
        com.tencent.cloud.huiyansdkface.facelight.a.a.c cVar = new com.tencent.cloud.huiyansdkface.facelight.a.a.c();
        this.h = cVar;
        cVar.a(this.j.X(), context, str, new com.tencent.cloud.huiyansdkface.facelight.a.a.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.d.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.a.a.a
            public void a() {
                WLogger.d("WbFaceVerifyControl", "cdn finish!isGetConfig true");
                d dVar = d.this;
                dVar.i = dVar.h.a();
                d.this.v = true;
                d.this.e(context);
            }
        });
    }

    private void a(Context context, String str, String str2, String str3) {
        a(context, str, str2, str3, true);
    }

    private void a(Context context, String str, String str2, String str3, boolean z) {
        this.e = false;
        if (z) {
            Properties properties = new Properties();
            properties.setProperty("isInit", String.valueOf(this.e));
            properties.setProperty("isStartSdk", String.valueOf(this.f));
            KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_params_invalid", str3, properties);
        }
        if (this.f35632c != null) {
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainParams);
            wbFaceError.setCode(str);
            wbFaceError.setDesc(str2);
            wbFaceError.setReason(str3);
            this.f35632c.onLoginFailed(wbFaceError);
        }
        if (this.d != null) {
            WbFaceError wbFaceError2 = new WbFaceError();
            wbFaceError2.setDomain(WbFaceError.WBFaceErrorDomainParams);
            wbFaceError2.setCode(str);
            wbFaceError2.setDesc(str2);
            wbFaceError2.setReason(str3);
            this.d.onInitFailed(wbFaceError2);
        }
    }

    private void a(Context context, boolean z, boolean z2, boolean z3, Bundle bundle, WbFaceVerifyInitCusSdkCallback wbFaceVerifyInitCusSdkCallback, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        String str;
        if (z3) {
            if (wbFaceVerifyInitCusSdkCallback == null) {
                throw new IllegalArgumentException("InitCusSdkCallback is null！");
            }
        } else if (wbCloudFaceVerifyLoginListener == null) {
            throw new IllegalArgumentException("FaceVerifyLoginListener is null！");
        }
        if (context == null) {
            WbFaceError wbFaceError = new WbFaceError(WbFaceError.WBFaceErrorDomainParams, WbFaceError.WBFaceErrorDomainParams, "传入参数为空", "传入context为空");
            if (z3) {
                wbFaceVerifyInitCusSdkCallback.onInitFailed(wbFaceError);
            } else {
                wbCloudFaceVerifyLoginListener.onLoginFailed(wbFaceError);
            }
        } else if (bundle == null) {
            WbFaceError wbFaceError2 = new WbFaceError(WbFaceError.WBFaceErrorDomainParams, WbFaceError.WBFaceErrorDomainParams, "传入参数为空", "传入bundle Data对象为空");
            if (z3) {
                wbFaceVerifyInitCusSdkCallback.onInitFailed(wbFaceError2);
            } else {
                wbCloudFaceVerifyLoginListener.onLoginFailed(wbFaceError2);
            }
        } else {
            Context applicationContext = context.getApplicationContext();
            WLogger.setEnable(true, "cloud face");
            com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().a(applicationContext);
            com.tencent.cloud.huiyansdkface.facelight.a.b.a a2 = com.tencent.cloud.huiyansdkface.facelight.a.b.b.a(bundle, z, z3, z2);
            if (!z3) {
                b.a b = com.tencent.cloud.huiyansdkface.facelight.a.b.b.b(a2);
                if (!b.c()) {
                    wbCloudFaceVerifyLoginListener.onLoginFailed(new WbFaceError(WbFaceError.WBFaceErrorDomainParams, WbFaceError.WBFaceErrorCodeInputParaNull, "传入参数有误", b.b));
                    WLogger.setEnable(false, "cloud face");
                    return;
                }
            }
            if (a(applicationContext, a2.g())) {
                WLogger.w("WbFaceVerifyControl", "double click,check is same faceId");
                if (a2.g()) {
                    D();
                    return;
                }
            }
            WLogger.d("WbFaceVerifyControl", "initSdk:" + z);
            if (a(applicationContext, a2.t(), wbCloudFaceVerifyLoginListener)) {
                this.e = true;
                this.j = a2;
                if (wbFaceVerifyInitCusSdkCallback != null) {
                    this.d = wbFaceVerifyInitCusSdkCallback;
                    this.f35632c = null;
                } else {
                    this.d = null;
                    this.f35632c = wbCloudFaceVerifyLoginListener;
                }
                B();
                a(applicationContext);
                if (b(applicationContext)) {
                    int a3 = com.tencent.cloud.huiyansdkface.b.a.a(this.j.i().licence);
                    if (a3 != 0) {
                        WLogger.e("WbFaceVerifyControl", "keyLicence is not valid!keyValid=" + a3);
                        Properties properties = new Properties();
                        properties.setProperty("licence", this.j.i().licence);
                        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
                        kycWaSDK.trackCustomKVEvent(applicationContext, "faceservice_keylicence_invalid", "keyValid=" + a3, properties);
                        a(applicationContext, WbFaceError.WBFaceErrorCodeKeyLicenceError, "传入keyLicence不可用", "传入keyLicence不可用(" + a3 + ")");
                        return;
                    }
                    d(applicationContext);
                    WbFaceModeProviders.faceMode().onStartFaceVerify(applicationContext);
                    if (this.j.S()) {
                        this.o = true;
                        C();
                        return;
                    }
                    if ("none".equals(this.j.k())) {
                        WLogger.d("WbFaceVerifyControl", "compareType: NONE");
                        str = "gradelive";
                    } else {
                        str = "grade";
                    }
                    Param.setCompareMode(str);
                    this.x.a(this.j.O());
                    this.x.b(this.j.X(), this.j.P(), false);
                    a(applicationContext, this.j.H());
                    KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_login_start", null, null);
                    a(applicationContext, 5000L);
                }
            }
        }
    }

    private void a(String str, String str2, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        wbCloudFaceVerifyLoginListener.onLoginFailed(new WbFaceError(WbFaceError.WBFaceErrorDomainParams, WbFaceError.WBFaceErrorCodeInputModelsError, str, str2));
        WLogger.setEnable(false, "cloud face");
    }

    private boolean a(Context context, String str, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("WbFaceVerifyControl", "check assets");
            if (f.a(context.getAssets(), "models/face-tracker-v001", "yt_model_config.ini")) {
                return true;
            }
            a("资源文件为空，请检查", "ytModelLoc is null and assets is also null! ", wbCloudFaceVerifyLoginListener);
            return false;
        }
        WLogger.d("WbFaceVerifyControl", "check input ytModelLoc:" + str);
        YtSDKKitFrameworkTool.a a2 = new YtSDKKitFrameworkTool().a(str);
        if (a2 != YtSDKKitFrameworkTool.a.VALIDITY_OK) {
            a("资源文件校验失败", "ytModelLoc check failed:" + a2.toString(), wbCloudFaceVerifyLoginListener);
            return false;
        }
        return true;
    }

    private boolean a(Context context, Map<String, Object> map) {
        WbCusMetaData wbCusMetaData;
        String str;
        if (context == null || map == null) {
            return false;
        }
        String str2 = null;
        try {
            wbCusMetaData = (WbCusMetaData) WbCloudNetSecurityManger.decry(false, (String) map.get("envInfo"), WbCusMetaData.class, this.g);
        } catch (Exception e) {
            e.printStackTrace();
            wbCusMetaData = null;
        }
        if (wbCusMetaData == null) {
            return false;
        }
        WLogger.d("WbFaceVerifyControl", "cusMetaData=" + wbCusMetaData.toString());
        String str3 = wbCusMetaData.appId;
        WLogger.d("WbFaceVerifyControl", "appId=" + str3);
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        Param.setAppId(str3);
        String str4 = wbCusMetaData.orderNo;
        WLogger.d("WbFaceVerifyControl", "orderNo=" + str4);
        if (TextUtils.isEmpty(str4) || !str4.equals(Param.getOrderNo())) {
            return false;
        }
        WLogger.d("WbFaceVerifyControl", "orderNo matched!");
        if (!TextUtils.isEmpty(wbCusMetaData.cdnFile)) {
            str2 = new String(Base64.decode(wbCusMetaData.cdnFile, 2));
        }
        WLogger.d("WbFaceVerifyControl", "cdnContent=" + str2);
        com.tencent.cloud.huiyansdkface.facelight.a.a.c cVar = new com.tencent.cloud.huiyansdkface.facelight.a.a.c();
        this.h = cVar;
        cVar.a(context, this.j.H(), str2);
        this.i = this.h.a();
        String str5 = wbCusMetaData.verifyType;
        WLogger.d("WbFaceVerifyControl", "verifyType=" + str5);
        if (TextUtils.isEmpty(str5)) {
            return false;
        }
        Param.setVerifyType(str5);
        if (TextUtils.isEmpty(wbCusMetaData.gradeCompareType)) {
            str = "gradeCompareType is null!";
        } else {
            Param.setGradeCompareType(wbCusMetaData.gradeCompareType);
            KycWaSDK.getInstance().updateFiled_y("field_y_0", wbCusMetaData.gradeCompareType);
            String str6 = wbCusMetaData.optimalGradeType;
            if (!TextUtils.isEmpty(str6)) {
                this.j.e(str6);
                String str7 = wbCusMetaData.activeType;
                String str8 = wbCusMetaData.colorData;
                WLogger.d("WbFaceVerifyControl", "actType=" + str7);
                WLogger.d("WbFaceVerifyControl", "colorData=" + str8);
                if (str6.contains("2")) {
                    if (TextUtils.isEmpty(str7)) {
                        return false;
                    }
                    this.j.k(str7);
                }
                if (str6.contains("3")) {
                    if (TextUtils.isEmpty(str8)) {
                        return false;
                    }
                    WLogger.d("WbFaceVerifyControl", "set colorData");
                    this.j.j(str8);
                    WLogger.d("WbFaceVerifyControl", "set colorData finish:" + this.j.M());
                }
                String str9 = wbCusMetaData.faceId;
                Param.setFaceId(str9);
                WLogger.d("WbFaceVerifyControl", "faceId=" + str9);
                this.j.f(wbCusMetaData.protocolCorpName);
                this.j.g(wbCusMetaData.authProtocolVersion);
                this.j.h(wbCusMetaData.testMsg);
                WLogger.d("WbFaceVerifyControl", "protocolCorpName=" + this.j.U());
                WLogger.d("WbFaceVerifyControl", "protocolNo=" + this.j.V());
                this.j.d(wbCusMetaData.needLogReport);
                WLogger.d("WbFaceVerifyControl", "needLogReport=" + this.j.c());
                this.j.b(wbCusMetaData.needAuth);
                WLogger.d("WbFaceVerifyControl", "needAuth=" + this.j.a());
                this.j.c(wbCusMetaData.authTickSwitch);
                WLogger.d("WbFaceVerifyControl", "authTickSwitch=" + this.j.b());
                this.j.a(wbCusMetaData.popupWarnSwitch);
                WLogger.d("WbFaceVerifyControl", "isLoginOk true");
                return true;
            }
            str = "optimalGradeType is null!";
        }
        WLogger.w("WbFaceVerifyControl", str);
        return false;
    }

    private boolean a(Context context, boolean z) {
        if (this.e || this.f) {
            WLogger.d("WbFaceVerifyControl", "checkSdkInService,isInit=" + this.e + ",isStartSdk=" + this.f);
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            kycWaSDK.trackCustomKVEvent(context, "faceservice_sdk_dup_init", "isIdDup:" + z + ",isInit=" + this.e + ",isStartSdk=" + this.f, null);
            return true;
        }
        return false;
    }

    private void b(Context context, String str, String str2, String str3) {
        a(context, str, str2, str3, false);
    }

    private boolean b(Context context) {
        WLogger.d("WbFaceVerifyControl", "checkParams");
        b.a a2 = com.tencent.cloud.huiyansdkface.facelight.a.b.b.a(this.j);
        if ("-1".equals(this.j.h()) || "1".equals(this.j.h())) {
            if (a2.b()) {
                c(context);
            }
        } else if ("0".equals(this.j.h())) {
            WLogger.i("WbFaceVerifyControl", "no report:" + this.j.h() + "," + a2.b());
        }
        if (a2.c()) {
            return true;
        }
        if (a2.f35519a == 1) {
            a(context, WbFaceError.WBFaceErrorCodeInputParaNull, "传入参数有误", a2.b);
            return false;
        }
        b(context, WbFaceError.WBFaceErrorCodeInputParaNull, "传入参数有误", a2.b);
        return false;
    }

    private void c(Context context) {
        WLogger.i("WbFaceVerifyControl", "initReport");
        String str = Param.getAppId() + Param.getOrderNo();
        com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().a(str);
        e.a(context, this.j.O(), str);
    }

    private void d(Context context) {
        Param.setTuringPackage(null);
        Param.setTuringVideoData(null);
        int i = Build.VERSION.SDK_INT;
        String deviceModel = Param.getDeviceModel();
        WLogger.d("WbFaceVerifyControl", "deviceModel=" + deviceModel);
        String a2 = f.a(context);
        String a3 = f.a(this.j.H());
        String str = Build.BRAND + BridgeUtil.SPLIT_MARK + com.tencent.cloud.huiyansdkface.facelight.c.a.a(Build.BRAND);
        String str2 = this.j.f() ? "uni" : "nor";
        Param.setDeviceInfo("di=;dt=Android;dv=" + String.valueOf(i) + ";dm=" + deviceModel + ";rom=" + str + ";st=" + a2 + ";wv=" + BuildConfig.VERSION_NAME + ";lang=" + a3 + ";apt=" + str2 + com.tencent.cloud.huiyansdkface.facelight.c.d.d.b(context));
        StringBuilder sb = new StringBuilder();
        sb.append("deviceInfo:");
        sb.append(Param.getDeviceInfo());
        WLogger.d("WbFaceVerifyControl", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final Context context) {
        WLogger.d("WbFaceVerifyControl", "canStartFaceVerify");
        if (this.u) {
            if (!this.v) {
                WLogger.d("WbFaceVerifyControl", "wait cdn!");
                this.w = new CloudFaceCountDownTimer(200L, 100L) { // from class: com.tencent.cloud.huiyansdkface.facelight.process.d.2
                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onFinish() {
                        WLogger.d("WbFaceVerifyControl", "get cdn out of time!no wait!");
                        d.this.h.a(context, d.this.j.H());
                        d dVar = d.this;
                        dVar.i = dVar.h.a();
                        d.this.v = true;
                        d.this.e(context);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onTick(long j) {
                    }
                }.start();
                return;
            }
            WLogger.d("WbFaceVerifyControl", "return login sucess!");
            CloudFaceCountDownTimer cloudFaceCountDownTimer = this.w;
            if (cloudFaceCountDownTimer != null) {
                cloudFaceCountDownTimer.cancel();
                this.w = null;
            }
            if (this.f35632c != null) {
                KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_login_success", null, this.j.Z());
                this.f35632c.onLoginSuccess();
                this.u = false;
                this.v = false;
            }
        }
    }

    public static d z() {
        if (f35631a == null) {
            synchronized (d.class) {
                try {
                    if (f35631a == null) {
                        f35631a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f35631a;
    }

    public void A() {
        WLogger.d("WbFaceVerifyControl", "release");
        h();
        if (this.f35632c != null) {
            this.f35632c = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    public WeOkHttp a() {
        return this.x.a();
    }

    public void a(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        WLogger.d("WbFaceVerifyControl", "initCommonSdk");
        a(context, false, false, false, bundle, null, wbCloudFaceVerifyLoginListener);
    }

    public void a(Context context, Bundle bundle, WbFaceVerifyInitCusSdkCallback wbFaceVerifyInitCusSdkCallback) {
        WLogger.d("WbFaceVerifyControl", "initCusSdk");
        a(context, false, false, true, bundle, wbFaceVerifyInitCusSdkCallback, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3 */
    public void a(Context context, WbCloudFaceVerifyResultListener wbCloudFaceVerifyResultListener) {
        Intent intent;
        Class<?> cls;
        if (context == null) {
            throw new IllegalArgumentException("startWbFaceVerifySdk context is null");
        }
        Context applicationContext = context.getApplicationContext();
        if (this.f) {
            WLogger.w("WbFaceVerifyControl", "already in service！Please not duplicate start!");
            KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_startwb_failed", "duplicate startWb", null);
            if (this.j.g()) {
                D();
                return;
            }
        } else if (!this.e) {
            WLogger.e("WbFaceVerifyControl", "not init,please init first...");
            KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_startwb_failed", "not init", null);
        }
        WLogger.i("WbFaceVerifyControl", "startWbFaceVerifySdk");
        this.f = true;
        this.e = false;
        if ("1".equals(this.j.c())) {
            WLogger.i("WbFaceVerifyControl", "enable startStatService");
            KycWaSDK.getInstance().updateEnableWBAService(true);
        } else {
            WLogger.i("WbFaceVerifyControl", "disable startStatService");
            KycWaSDK.getInstance().updateEnableWBAService(false);
        }
        KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_startwb", Param.getCompareMode(), null);
        this.b = wbCloudFaceVerifyResultListener;
        if ("1".equals(this.j.a())) {
            intent = new Intent();
            cls = FaceGuideActivity.class;
        } else {
            intent = new Intent();
            cls = FaceVerifyActivity.class;
        }
        intent.setClass(context, cls);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(0, 0);
    }

    public void a(Context context, String str, Properties properties) {
        WLogger.d("WbFaceVerifyControl", "sdk release start status");
        this.f = false;
        Properties properties2 = properties;
        if (properties == null) {
            properties2 = new Properties();
        }
        properties2.setProperty("isInit", String.valueOf(this.e));
        properties2.setProperty("isStartSdk", String.valueOf(this.f));
        KycWaSDK.getInstance().trackCustomKVEvent(context, "facepage_returnresult", str, properties2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x010e, code lost:
        if ("1".equals(r6.j.c()) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0114, code lost:
        com.tencent.cloud.huiyansdkface.normal.tools.WLogger.i("WbFaceVerifyControl", "disable startStatService");
        com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK.getInstance().updateEnableWBAService(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0155, code lost:
        if ("0".equals(r6.j.h()) != false) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r7, java.util.Map<java.lang.String, java.lang.Object> r8, com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener r9) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.process.d.a(android.content.Context, java.util.Map, com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener):void");
    }

    public void a(boolean z) {
        this.r = z;
    }

    public void b(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        WLogger.d("WbFaceVerifyControl", "initAdvSdk");
        a(context, true, false, false, bundle, null, wbCloudFaceVerifyLoginListener);
    }

    public void b(boolean z) {
        this.p = z;
        if (z || !this.q) {
            return;
        }
        this.q = false;
    }

    public boolean b() {
        return this.r;
    }

    public void c(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        WLogger.d("WbFaceVerifyControl", "initWillSdk");
        a(context, true, true, false, bundle, null, wbCloudFaceVerifyLoginListener);
    }

    public void c(boolean z) {
        this.q = z;
    }

    public boolean c() {
        return this.p;
    }

    public void d(boolean z) {
        this.n = z;
    }

    public boolean d() {
        return this.q;
    }

    public com.tencent.cloud.huiyansdkface.facelight.a.a.b e() {
        return this.i;
    }

    public void e(boolean z) {
        this.k = z;
    }

    public WbUiTips f() {
        return this.i.G();
    }

    public boolean g() {
        return this.o;
    }

    public void h() {
        WLogger.d("WbFaceVerifyControl", "resetSdkServiceStatus");
        this.e = false;
        this.f = false;
    }

    public int i() {
        return this.s;
    }

    public void j() {
        this.s++;
    }

    public void k() {
        this.s--;
    }

    public void l() {
        this.s = 0;
    }

    public String m() {
        return this.t;
    }

    public void n() {
        this.t += "0";
    }

    public void o() {
        this.t += "1";
    }

    public void p() {
        this.t = "";
    }

    public boolean q() {
        return this.n;
    }

    public int r() {
        return this.l;
    }

    public void s() {
        this.l++;
    }

    public boolean t() {
        return this.k;
    }

    public boolean u() {
        return this.j.n() && this.i.y();
    }

    public boolean v() {
        return this.j.I() && this.i.D();
    }

    public String w() {
        return this.j.i().orderNo;
    }

    public com.tencent.cloud.huiyansdkface.facelight.a.b.a x() {
        return this.j;
    }

    public WbCloudFaceVerifyResultListener y() {
        return this.b;
    }
}
