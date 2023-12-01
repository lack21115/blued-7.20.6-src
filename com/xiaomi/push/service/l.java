package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/l.class */
public class l {
    public static ComponentName a(Context context, Intent intent) {
        ComponentName componentName = null;
        if (intent != null) {
            try {
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                componentName = null;
                if (resolveActivity != null) {
                    componentName = new ComponentName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
                }
            } catch (Exception e) {
                return null;
            }
        }
        return componentName;
    }

    public static boolean a(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            if (serviceInfoArr == null) {
                return false;
            }
            int length = serviceInfoArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                ServiceInfo serviceInfo = serviceInfoArr[i2];
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("checkService ".concat(String.valueOf(e)));
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryIntentServices != null) {
                return !queryIntentServices.isEmpty();
            }
            return false;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("checkService action: " + str2 + ", " + e);
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        boolean z;
        boolean z2 = false;
        boolean z3 = false;
        try {
            List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(null, 0, 8);
            z = false;
            if (queryContentProviders != null) {
                z = false;
                if (!queryContentProviders.isEmpty()) {
                    Iterator<ProviderInfo> it = queryContentProviders.iterator();
                    while (true) {
                        z3 = z2;
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        boolean z4 = z2;
                        ProviderInfo next = it.next();
                        boolean z5 = z2;
                        if (next.enabled) {
                            boolean z6 = z2;
                            if (next.exported) {
                                boolean z7 = z2;
                                if (next.authority.equals(str)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("checkProvider ".concat(String.valueOf(e)));
            z = z3;
        }
        return z;
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            return packageManager.resolveActivity(intent, 65536) != null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("checkActivity action: " + str2 + ", " + e);
            return false;
        }
    }
}
