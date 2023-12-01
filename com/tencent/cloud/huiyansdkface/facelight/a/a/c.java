package com.tencent.cloud.huiyansdkface.facelight.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.c.d.d;
import com.tencent.cloud.huiyansdkface.facelight.c.g;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.GetCdnGradeInfo;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbUiTips;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/a/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private b f21821a = new b();
    private CloudFaceCountDownTimer b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21822c;

    private String a(Context context) {
        WLogger.d("GetCdnInfo", "check local config is exist");
        return (String) new g(context).b("gradeInfo", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Properties a(b bVar) {
        Properties properties = new Properties();
        properties.setProperty("cdnConfig", bVar.toString());
        return properties;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, GetCdnGradeInfo.GetGradeInfoResponse getGradeInfoResponse) {
        WLogger.d("GetCdnInfo", "updateSp");
        if (getGradeInfoResponse == null) {
            return;
        }
        g gVar = new g(context);
        if (!TextUtils.isEmpty(getGradeInfoResponse.version)) {
            gVar.a("version", getGradeInfoResponse.version);
        }
        String json = new WeJson().toJson(getGradeInfoResponse);
        if (TextUtils.isEmpty(json)) {
            return;
        }
        gVar.a("gradeInfo", json);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:282:0x14f1  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x1533  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x1575  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x15e6  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x1650  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x16ba  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x1724  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x178e  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x17f8  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x1862  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x18cc  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x1c18  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x1c5a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r9, java.lang.String r10, com.tencent.cloud.huiyansdkface.facelight.net.GetCdnGradeInfo.GetGradeInfoResponse r11) {
        /*
            Method dump skipped, instructions count: 7558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.a.a.c.a(android.content.Context, java.lang.String, com.tencent.cloud.huiyansdkface.facelight.net.GetCdnGradeInfo$GetGradeInfoResponse):void");
    }

    private void a(List<String> list, List<String> list2) {
        String str;
        WLogger.d("GetCdnInfo", "after appId set,check version and model is use Turing");
        if (this.f21821a.G) {
            if (list != null) {
                String valueOf = String.valueOf(Build.VERSION.SDK_INT);
                WLogger.d("GetCdnInfo", "versionList=" + list.toString().trim() + MttLoader.QQBROWSER_PARAMS_VERSION + valueOf);
                if (list.contains(valueOf)) {
                    WLogger.d("GetCdnInfo", "match banTuringSdkVersionList! no use TuringSdk:osversion");
                    this.f21821a.G = false;
                    str = "osversion";
                } else {
                    WLogger.d("GetCdnInfo", "dont match banTuringSdkVersionList list! ");
                }
            } else {
                WLogger.e("GetCdnInfo", "cdn cant get banTuringSdkVersionList list");
            }
            if (list2 == null) {
                WLogger.e("GetCdnInfo", "cdn cant get banTuringSdk list");
                return;
            }
            WLogger.d("GetCdnInfo", "banTuringList=" + list2.toString().trim());
            String deviceModel = Param.getDeviceModel();
            WLogger.d("GetCdnInfo", "model=" + deviceModel);
            if (!list2.contains(deviceModel)) {
                WLogger.d("GetCdnInfo", "dont match banTuringSdk list! ");
                return;
            }
            WLogger.d("GetCdnInfo", "match banTuringSdk list! ");
            this.f21821a.G = false;
            str = "device";
        } else {
            WLogger.d("GetCdnInfo", "appId already false");
            str = "appid";
        }
        Param.appendTuringInfo(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String b(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -1179248177:
                if (str.equals(WbCloudFaceContant.LANGUAGE_EN)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1179248063:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ID)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1179248035:
                if (str.equals(WbCloudFaceContant.LANGUAGE_JA)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1179247990:
                if (str.equals(WbCloudFaceContant.LANGUAGE_KO)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1179247718:
                if (str.equals(WbCloudFaceContant.LANGUAGE_TH)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1869350094:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ZH_HK)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        return z ? !z ? !z ? !z ? !z ? !z ? "kyc_language_CN" : "kyc_language_TH" : "kyc_language_KR" : "kyc_language_JP" : "kyc_language_ID" : "kyc_language_US" : "kyc_language_TCN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        if (this.f21822c) {
            WLogger.d("GetCdnInfo", "already init TuringSdk");
            return;
        }
        this.f21822c = true;
        if (!this.f21821a.G) {
            WLogger.d("GetCdnInfo", "no need to initTuringSdk");
            return;
        }
        WLogger.d("GetCdnInfo", "initTuringSdk");
        Param.appendTuringSdkInfo();
        d.a(context);
        this.f21821a.H = true;
    }

    private WbUiTips c(String str) {
        str.hashCode();
        return new WbUiTips();
    }

    public b a() {
        return this.f21821a;
    }

    public GetCdnGradeInfo.GetGradeInfoResponse a(String str) {
        WLogger.d("GetCdnInfo", "parseStringToConfig");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (GetCdnGradeInfo.GetGradeInfoResponse) new WeJson().fromJson(str, (Class<Object>) GetCdnGradeInfo.GetGradeInfoResponse.class);
        } catch (WeJsonException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(Context context, String str) {
        WLogger.d("GetCdnInfo", "checkDefaultOrLocalConfig");
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            b(context, str);
        } else {
            a(context, str, a(a2));
        }
    }

    public void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            WLogger.i("GetCdnInfo", "cus cdn config is null,use default or local");
            a(context, str);
            return;
        }
        WLogger.i("GetCdnInfo", "useCusCdnConfig");
        GetCdnGradeInfo.GetGradeInfoResponse a2 = a(str2);
        a(context, str, a2);
        a(context, a2);
    }

    public void a(boolean z, final Context context, final String str, final a aVar) {
        WLogger.d("GetCdnInfo", "getConfigInfo");
        String str2 = "https://kyccdn.tencentcloudapi.com" + (!WbCloudFaceContant.LANGUAGE_ZH_CN.equals(str) ? "/kyc/WbGradeInfoInternational.json" : "/kyc/WbGradeInfo.json");
        WLogger.d("GetCdnInfo", "start getConfigInfo request:" + str2);
        KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_cdn_request", null, null);
        GetCdnGradeInfo.requestExec(str2, new WeReq.Callback<GetCdnGradeInfo.GetGradeInfoResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.a.a.c.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a */
            public void onSuccess(WeReq weReq, GetCdnGradeInfo.GetGradeInfoResponse getGradeInfoResponse) {
                WLogger.d("GetCdnInfo", "cdn拉取设置信息 onSuccess");
                if (getGradeInfoResponse != null) {
                    c.this.a(context, str, getGradeInfoResponse);
                } else {
                    WLogger.e("GetCdnInfo", "getGradeInfoResponse is null!");
                    c.this.a(context, str);
                }
                KycWaSDK kycWaSDK = KycWaSDK.getInstance();
                Context context2 = context;
                c cVar = c.this;
                kycWaSDK.trackCustomKVEvent(context2, "faceservice_cdn_response", "onSuccess", cVar.a(cVar.f21821a));
                aVar.a();
                c.this.a(context, getGradeInfoResponse);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i, String str3, IOException iOException) {
                WLogger.e("GetCdnInfo", "cdn拉取设置信息失败:" + errType + ",code=" + i + "; msg=" + str3);
                KycWaSDK kycWaSDK = KycWaSDK.getInstance();
                Context context2 = context;
                kycWaSDK.trackCustomKVEvent(context2, "faceservice_cdn_response", "onFailed:type=" + errType + "code=" + i + ",msg=" + str3, null);
                c.this.a(context, str);
                aVar.a();
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
                if (c.this.b == null) {
                    c.this.b = new CloudFaceCountDownTimer(500L, 250L) { // from class: com.tencent.cloud.huiyansdkface.facelight.a.a.c.1.1
                        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                        public void onFinish() {
                            WLogger.d("GetCdnInfo", "init turing cdt finish");
                            c.this.b(context);
                        }

                        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                        public void onTick(long j) {
                        }
                    }.start();
                    WLogger.d("GetCdnInfo", "init turing cdt start");
                }
            }
        });
    }

    public void b(Context context, String str) {
        WLogger.d("GetCdnInfo", "useDefaultConfig");
        a(context, str, a(new b().aC));
    }
}
