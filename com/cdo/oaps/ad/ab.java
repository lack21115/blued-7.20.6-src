package com.cdo.oaps.ad;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/ab.class */
public class ab {
    public static boolean a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(a.b(y.f21551a));
        intent.setFlags(268435456);
        intent.setPackage(af.b(context));
        intent.setDataAndType(Uri.parse(str), a.b(y.b));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
        boolean z = false;
        if (queryIntentActivities != null) {
            z = false;
            if (queryIntentActivities.size() > 0) {
                ResolveInfo resolveInfo = queryIntentActivities.get(0);
                ComponentName componentName = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                if (context instanceof Activity) {
                    ((Activity) context).startActivityForResult(intent2, 1000);
                } else {
                    context.startActivity(intent2);
                }
                z = true;
            }
        }
        return z;
    }

    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(a.b(y.f21551a));
        intent.setPackage(af.b(context));
        intent.setDataAndType(Uri.parse(str), a.b(y.b));
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 32);
        boolean z = false;
        if (queryIntentServices != null) {
            z = false;
            if (queryIntentServices.size() > 0) {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                context.startService(intent2);
                z = true;
            }
        }
        return z;
    }
}
