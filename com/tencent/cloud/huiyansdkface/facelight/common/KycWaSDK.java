package com.tencent.cloud.huiyansdkface.facelight.common;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.analytics.WBSimpleAnalyticsService;
import com.tencent.cloud.huiyansdkface.analytics.WBSimpleStartParam;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/common/KycWaSDK.class */
public class KycWaSDK {

    /* renamed from: a  reason: collision with root package name */
    private static WBSimpleAnalyticsService f35586a;
    private static volatile KycWaSDK b;

    static {
        WBSimpleAnalyticsService wBSimpleAnalyticsService = new WBSimpleAnalyticsService();
        f35586a = wBSimpleAnalyticsService;
        wBSimpleAnalyticsService.init("M188386620", "https://kycwa.tencentcloudapi.com/rcrm-codcs/mob-data-collect");
    }

    private KycWaSDK() {
    }

    public static KycWaSDK getInstance() {
        if (b == null) {
            synchronized (KycWaSDK.class) {
                try {
                    if (b == null) {
                        b = new KycWaSDK();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public boolean startStatService(Context context, WBSimpleStartParam wBSimpleStartParam) {
        return f35586a.startStatService(context, wBSimpleStartParam);
    }

    public void trackCustomKVEvent(Context context, String str, String str2, Properties properties) {
        f35586a.trackCustomKVEvent(context, str, str2, properties);
    }

    public void trackIMSWarnVEvent(Context context, String str, String str2, Properties properties) {
        f35586a.trackIMSWarnVEvent(context, str, str2, properties);
    }

    public void updateEcifNo(String str) {
        f35586a.updateEcifNo(str);
    }

    public void updateEnableWBAService(boolean z) {
        f35586a.updateEnableWBAService(z);
    }

    public void updateFiled_y(String str, String str2) {
        f35586a.updateFieldValue(str, str2);
    }

    public void updateOpenId(String str) {
        f35586a.updateOpenId(str);
    }

    public void updateUnionId(String str) {
        f35586a.updateUnionId(str);
    }
}
