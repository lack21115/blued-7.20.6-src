package com.opos.cmn.g.b.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.b.b;
import com.cdo.oaps.ad.af;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/b/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24967a = "com." + com.opos.cmn.an.a.a.f24484c + ".market";

    private static boolean a(Activity activity, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "marketUrl is empty";
        } else if (activity != null) {
            try {
                Context applicationContext = activity.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (b(applicationContext, f24967a)) {
                    intent.setPackage(f24967a);
                } else if (!b(applicationContext, af.e)) {
                    com.opos.cmn.an.f.a.d("MarketDLTool", "not find market app");
                    return false;
                } else {
                    intent.setPackage(af.e);
                }
                activity.startActivityForResult(intent, 100);
                return true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MarketDLTool", "launchDownloadPageForActivity", e);
                return true;
            }
        } else {
            str2 = "activity is null";
        }
        com.opos.cmn.an.f.a.d("MarketDLTool", str2);
        return false;
    }

    public static boolean a(Context context, String str) {
        String str2;
        if (context == null) {
            str2 = b.f7836a;
        } else if (!TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("MarketDLTool", "market url:" + str);
            try {
                Context applicationContext = context.getApplicationContext();
                if (!b(applicationContext, f24967a) && !b(applicationContext, af.e)) {
                    com.opos.cmn.an.f.a.d("MarketDLTool", "not find market app");
                    return false;
                } else if (context instanceof Activity) {
                    a((Activity) context, str);
                    return true;
                } else {
                    com.opos.cmn.an.transactivity.api.a.a(context, new com.opos.cmn.g.b.a.a(str));
                    return true;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MarketDLTool", "launchDownloadPage", e);
                return true;
            }
        } else {
            str2 = "marketUrl is empty";
        }
        com.opos.cmn.an.f.a.d("MarketDLTool", str2);
        return false;
    }

    private static boolean b(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            boolean z = false;
            if (packageInfo != null) {
                z = false;
                if (packageInfo.applicationInfo != null) {
                    z = false;
                    if (packageInfo.applicationInfo.enabled) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
