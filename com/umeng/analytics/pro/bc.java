package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bc.class */
public class bc implements au {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26960a = false;

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        try {
            if (!this.f26960a) {
                OpenIDSDK.a(context);
                this.f26960a = true;
            }
            if (OpenIDSDK.a()) {
                return OpenIDSDK.b(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception e) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
