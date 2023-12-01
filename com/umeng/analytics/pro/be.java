package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.vivo.identifier.IdentifierManager;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/be.class */
public class be implements au {
    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        try {
            if (IdentifierManager.a(context)) {
                return IdentifierManager.b(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception e) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
