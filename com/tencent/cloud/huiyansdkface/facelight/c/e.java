package com.tencent.cloud.huiyansdkface.facelight.c;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.analytics.WBSimpleStartParam;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelivesdk.BuildConfig;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/e.class */
public class e {
    public static void a(Context context, boolean z, String str) {
        WLogger.d("ReportHelper", "initWa");
        WLogger.d("ReportHelper", "initWa url:https://kycwa.tencentcloudapi.com/rcrm-codcs/mob-data-collect");
        KycWaSDK.getInstance().startStatService(context, new WBSimpleStartParam.Builder("M188386620", str, "https://kycwa.tencentcloudapi.com/rcrm-codcs/mob-data-collect").setSubAppId(Param.getAppId()).setUnionId(Param.getUserId()).setEcifNo(Param.getFaceId()).setAppVersion(BuildConfig.VERSION_NAME).setEnableWAService(true).setLogEnable(z).build());
        KycWaSDK.getInstance().updateFiled_y("field_y_0", "");
        KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_sdk_init", null, null);
    }
}
