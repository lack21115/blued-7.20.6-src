package com.tencent.cloud.huiyansdkface.facelight.a.b;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/a/b/b.class */
public class b {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/a/b/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f35519a = 0;
        public String b;

        public static a a() {
            return new a();
        }

        public static a a(String str) {
            a aVar = new a();
            aVar.f35519a = 2;
            aVar.b = str;
            return aVar;
        }

        public static a b(String str) {
            a aVar = new a();
            aVar.f35519a = 1;
            aVar.b = str;
            return aVar;
        }

        public boolean b() {
            int i = this.f35519a;
            boolean z = true;
            if (i != 1) {
                if (i == 0) {
                    return true;
                }
                z = false;
            }
            return z;
        }

        public boolean c() {
            return this.f35519a == 0;
        }
    }

    public static com.tencent.cloud.huiyansdkface.facelight.a.b.a a(Bundle bundle, boolean z, boolean z2, boolean z3) {
        String substring;
        com.tencent.cloud.huiyansdkface.facelight.a.b.a aVar = new com.tencent.cloud.huiyansdkface.facelight.a.b.a();
        WLogger.d("SdkConfigReader", "readSdkConfig");
        aVar.b = z2;
        aVar.f35517a = z;
        aVar.f35518c = z3;
        if (z3) {
            aVar.f35517a = true;
        }
        aVar.g = bundle.getBoolean(WbCloudFaceContant.IS_ENABLE_LOG, false);
        aVar.d = bundle.getBoolean(WbCloudFaceContant.IS_UNI, false);
        aVar.h = bundle.getBoolean(WbCloudFaceContant.IS_ABROAD, false);
        aVar.k = (WbCloudFaceVerifySdk.InputData) bundle.getSerializable(WbCloudFaceContant.INPUT_DATA);
        aVar.m = bundle.getString(WbCloudFaceContant.COMPARE_TYPE, WbCloudFaceContant.ID_CARD);
        if (z2) {
            aVar.l = WbCloudFaceContant.LANGUAGE_ZH_CN;
            aVar.j = bundle.getString(WbCloudFaceContant.ENABLE_TRACK_LOG, "-1");
        } else {
            aVar.l = bundle.getString(WbCloudFaceContant.LANGUAGE, WbCloudFaceContant.LANGUAGE_ZH_CN);
            aVar.j = "-1";
        }
        if (z3) {
            if ("none".equals(aVar.m)) {
                aVar.m = WbCloudFaceContant.ID_CARD;
            }
            aVar.i = false;
            aVar.y = WbCloudFaceContant.WHITE;
            aVar.z = 0;
            aVar.s = bundle.getFloat(WbCloudFaceContant.WILL_MAX_PLAY_VOLUME);
            aVar.q = bundle.getBoolean(WbCloudFaceContant.RECORD_WILL_VIDEO, false);
            if (aVar.q) {
                aVar.r = bundle.getBoolean(WbCloudFaceContant.CHECK_WILL_VIDEO, false);
                aVar.t = bundle.getBoolean(WbCloudFaceContant.UPLOAD_AND_RETURN_WILL_VIDEO, false);
            }
        } else {
            aVar.i = bundle.getBoolean(WbCloudFaceContant.IS_LANDSCAPE, false);
            aVar.y = bundle.getString(WbCloudFaceContant.COLOR_MODE, WbCloudFaceContant.WHITE);
            aVar.z = bundle.getInt(WbCloudFaceContant.CUSTOMER_TIPS_LOC, 0);
        }
        aVar.o = bundle.getBoolean(WbCloudFaceContant.VIDEO_UPLOAD, false);
        aVar.n = bundle.getBoolean(WbCloudFaceContant.VIDEO_CHECK, false);
        if (!aVar.o) {
            aVar.n = false;
        }
        aVar.p = true;
        if (Build.VERSION.SDK_INT < 18) {
            WLogger.w("SdkConfigReader", "not support YT recording!");
            aVar.p = false;
        }
        String deviceModel = Param.getDeviceModel();
        if ("ZUK Z2131".equals(deviceModel) || "Lenovo X3c70".equals(deviceModel)) {
            aVar.p = false;
        }
        aVar.u = bundle.getBoolean(WbCloudFaceContant.PLAY_VOICE, false);
        if ("PCHM10".equals(deviceModel) || "PCHT10".equals(deviceModel) || "PCHM30".equals(deviceModel) || "PCHT30".equals(deviceModel) || "PDAM10".equals(deviceModel)) {
            aVar.u = false;
        }
        aVar.v = bundle.getString(WbCloudFaceContant.YT_MODEL_LOC);
        aVar.x = bundle.getBoolean(WbCloudFaceContant.SWITCH_CAM, false);
        aVar.w = bundle.getInt(WbCloudFaceContant.BLINK_SAFETY, 1);
        aVar.A = bundle.getString(WbCloudFaceContant.CUSTOMER_TIPS_LIVE);
        aVar.B = bundle.getString(WbCloudFaceContant.CUSTOMER_TIPS_UPLOAD);
        aVar.C = bundle.getString(WbCloudFaceContant.CUSTOMER_LONG_TIP);
        aVar.D = bundle.getString(WbCloudFaceContant.CUSTOMER_CAM_REASON);
        aVar.E = bundle.getString(WbCloudFaceContant.CUSTOMER_WILL_PERMISSION_REASON);
        if (!TextUtils.isEmpty(aVar.A)) {
            aVar.A = aVar.A.length() > 17 ? aVar.A.substring(0, 17) : aVar.A;
        }
        if (!TextUtils.isEmpty(aVar.B)) {
            aVar.B = aVar.B.length() > 17 ? aVar.B.substring(0, 17) : aVar.B;
        }
        if (!TextUtils.isEmpty(aVar.C)) {
            aVar.C = aVar.C.length() > 70 ? aVar.C.substring(0, 70) : aVar.C;
        }
        if (!TextUtils.isEmpty(aVar.D)) {
            aVar.D = aVar.D.length() > 17 ? aVar.D.substring(0, 17) : aVar.D;
        }
        if (!TextUtils.isEmpty(aVar.E)) {
            aVar.E = aVar.E.length() > 17 ? aVar.E.substring(0, 17) : aVar.E;
        }
        if (WbCloudFaceContant.LANGUAGE_ZH_CN.equals(aVar.l)) {
            aVar.F = bundle.getString(WbCloudFaceContant.DIALOG_TITLE);
            aVar.G = bundle.getString(WbCloudFaceContant.DIALOG_TEXT);
            aVar.H = bundle.getString(WbCloudFaceContant.DIALOG_YES);
            aVar.I = bundle.getString(WbCloudFaceContant.DIALOG_NO);
            if (!TextUtils.isEmpty(aVar.F)) {
                aVar.F = aVar.F.length() > 8 ? aVar.F.substring(0, 8) : aVar.F;
            }
            if (!TextUtils.isEmpty(aVar.G)) {
                aVar.G = aVar.G.length() > 15 ? aVar.G.substring(0, 15) : aVar.G;
            }
            if (!TextUtils.isEmpty(aVar.H)) {
                aVar.H = aVar.H.length() > 5 ? aVar.H.substring(0, 5) : aVar.H;
            }
            if (!TextUtils.isEmpty(aVar.I)) {
                substring = aVar.I.length() > 5 ? aVar.I.substring(0, 5) : aVar.I;
            }
            aVar.J = bundle.getBoolean(WbCloudFaceContant.IS_SIMPLE_MODE, false);
            WLogger.d("SdkConfigReader", "isSimpleMode=" + aVar.J);
            aVar.K = bundle.getBoolean(WbCloudFaceContant.RETURN_VIDEO, false);
            aVar.L = bundle.getString(WbCloudFaceContant.USER_PUBLIC_KEY);
            aVar.M = bundle.getString(WbCloudFaceContant.USER_AES_IV);
            WLogger.d("SdkConfigReader", "finish read setting");
            return aVar;
        }
        WLogger.d("SdkConfigReader", "international");
        aVar.u = false;
        substring = null;
        aVar.F = null;
        aVar.G = null;
        aVar.H = null;
        aVar.I = substring;
        aVar.J = bundle.getBoolean(WbCloudFaceContant.IS_SIMPLE_MODE, false);
        WLogger.d("SdkConfigReader", "isSimpleMode=" + aVar.J);
        aVar.K = bundle.getBoolean(WbCloudFaceContant.RETURN_VIDEO, false);
        aVar.L = bundle.getString(WbCloudFaceContant.USER_PUBLIC_KEY);
        aVar.M = bundle.getString(WbCloudFaceContant.USER_AES_IV);
        WLogger.d("SdkConfigReader", "finish read setting");
        return aVar;
    }

    public static a a(com.tencent.cloud.huiyansdkface.facelight.a.b.a aVar) {
        String str;
        WLogger.i("SdkConfigReader", "checkInputData");
        WbCloudFaceVerifySdk.InputData inputData = aVar.k;
        if (inputData == null) {
            WLogger.e("SdkConfigReader", "InputData is null!");
            return a.a("传入的InputData为空");
        }
        Param.setFaceId(inputData.faceId);
        if (!TextUtils.isEmpty(inputData.appId)) {
            str = inputData.appId;
        } else if (!aVar.S()) {
            WLogger.e("SdkConfigReader", "appId is null!");
            return a.a("传入appId为空");
        } else {
            str = "";
        }
        Param.setAppId(str);
        if (TextUtils.isEmpty(inputData.orderNo)) {
            WLogger.e("SdkConfigReader", "orderNo is null!");
            return a.a("传入orderNo为空");
        }
        Param.setOrderNo(inputData.orderNo);
        if (TextUtils.isEmpty(inputData.licence)) {
            WLogger.e("SdkConfigReader", "licence is null!");
            return a.b("传入licence为空");
        } else if (aVar.S()) {
            return a.a();
        } else {
            if (TextUtils.isEmpty(inputData.userId)) {
                WLogger.e("SdkConfigReader", "userId is null!");
                return a.b("传入userId为空");
            }
            Param.setUserId(inputData.userId);
            if (TextUtils.isEmpty(inputData.version)) {
                WLogger.e("SdkConfigReader", "version is null!");
                return a.b("传入version为空");
            }
            Param.setVersion(inputData.version);
            if (TextUtils.isEmpty(inputData.nonce)) {
                WLogger.e("SdkConfigReader", "nonce is null!");
                return a.b("传入nonce为空");
            } else if (TextUtils.isEmpty(inputData.sign)) {
                WLogger.e("SdkConfigReader", "sign is null!");
                return a.b("传入sign为空");
            } else {
                return a.a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        if ("none".equals(r4.k()) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0127, code lost:
        if (r4.T() == false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.cloud.huiyansdkface.facelight.a.b.b.a b(com.tencent.cloud.huiyansdkface.facelight.a.b.a r4) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.a.b.b.b(com.tencent.cloud.huiyansdkface.facelight.a.b.a):com.tencent.cloud.huiyansdkface.facelight.a.b.b$a");
    }
}
