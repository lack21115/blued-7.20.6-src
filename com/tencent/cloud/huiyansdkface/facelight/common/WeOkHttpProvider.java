package com.tencent.cloud.huiyansdkface.facelight.common;

import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/common/WeOkHttpProvider.class */
public class WeOkHttpProvider {
    public static String getComparePath(boolean z) {
        boolean equals = "none".equals(d.z().x().k());
        return z ? equals ? "/v3/sdk/appUploadGen" : "/v3/sdk/faceCompareGen" : equals ? "/gradelive/appuploadEn" : "/grade/facecompareEn";
    }

    public static String getLoginPath(boolean z) {
        return z ? "/v3/sdk/ssoLoginGen" : "/idap/v2/ssoLoginEn";
    }

    public static String getPathEnv() {
        int Y = d.z().x().Y();
        return Y != 1 ? Y != 2 ? "/api" : "/api-press" : "/api-dev";
    }

    public static String getQueryPath(boolean z) {
        return z ? "/v3/sdk/getFaceResultGen" : "/server/getfaceresult";
    }

    public static String getResPath(boolean z) {
        d z2 = d.z();
        boolean z3 = "none".equals(z2.x().k()) || z2.x().l();
        return z ? z3 ? "/v3/sdk/getLiveFlashResourceGen" : "/v3/sdk/getFlashResourceGen" : z3 ? "/gradelive/getflashresourceEn" : "/grade/getflashresourceEn";
    }

    public static String getTuringCamPath(boolean z) {
        return z ? "/v3/sdk/turingPackageCameraGen" : "/server/turingpackagecamera";
    }

    public static String getTuringPath(boolean z) {
        return z ? "/v3/sdk/turingPackageSyncGen" : "/server/turingpackagesync";
    }

    public static WeOkHttp getWeOkHttp() {
        return d.z().a();
    }

    public static String getWillAsrPath() {
        return "/asr/sdkasr";
    }

    public static String getWillComparePath(boolean z) {
        return z ? "/v3/sdk/willFacecompareGen" : "/grade/willFacecompareEn";
    }

    public static String getWillLoginPath(boolean z) {
        return z ? "/v3/sdk/willLoginGen" : "/idap/v2/willLoginEn";
    }

    public static String getWillResPath(boolean z) {
        return z ? "/v3/sdk/getWillResourceGen" : "/asr/getWillResource";
    }

    public static String getWillUploadVideoPath() {
        return "/asr/uploadData";
    }
}
