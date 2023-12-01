package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ba.class */
public class ba implements au {
    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a2 = OpenIdHelper.a();
        bg.a("getOAID", "isSupported", Boolean.valueOf(a2));
        if (a2) {
            return OpenIdHelper.a(context);
        }
        return null;
    }
}
