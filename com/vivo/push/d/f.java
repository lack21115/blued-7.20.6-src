package com.vivo.push.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/f.class */
public final class f extends com.vivo.push.l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.vivo.push.o oVar) {
        super(oVar);
    }

    public static boolean a(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            com.vivo.push.util.p.a("OnChangePushStatusTask", "enableService error: can not find push service.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 1) {
            com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has enabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
        com.vivo.push.util.p.d("OnChangePushStatusTask", "enableService push service.");
        return true;
    }

    public static boolean b(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            com.vivo.push.util.p.a("OnChangePushStatusTask", "disableService error: can not find push service.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 2) {
            com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has disabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
        com.vivo.push.util.p.d("OnChangePushStatusTask", "disableService push service.");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r5.size() <= 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<android.content.pm.ResolveInfo> c(android.content.Context r4) {
        /*
            android.content.Intent r0 = new android.content.Intent
            r1 = r0
            java.lang.String r2 = "com.vivo.pushservice.action.RECEIVE"
            r1.<init>(r2)
            r5 = r0
            r0 = r5
            r1 = r4
            java.lang.String r1 = r1.getPackageName()
            android.content.Intent r0 = r0.setPackage(r1)
            r0 = r4
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L54
            r1 = r5
            r2 = 576(0x240, float:8.07E-43)
            java.util.List r0 = r0.queryBroadcastReceivers(r1, r2)     // Catch: java.lang.Exception -> L54
            r5 = r0
            goto L24
        L22:
            r0 = 0
            r5 = r0
        L24:
            r0 = r5
            if (r0 == 0) goto L33
            r0 = r5
            r6 = r0
            r0 = r5
            int r0 = r0.size()
            if (r0 > 0) goto L52
        L33:
            android.content.Intent r0 = new android.content.Intent
            r1 = r0
            java.lang.String r2 = "com.vivo.pushclient.action.RECEIVE"
            r1.<init>(r2)
            r6 = r0
            r0 = r6
            r1 = r4
            java.lang.String r1 = r1.getPackageName()
            android.content.Intent r0 = r0.setPackage(r1)
            r0 = r4
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L58
            r1 = r6
            r2 = 576(0x240, float:8.07E-43)
            java.util.List r0 = r0.queryBroadcastReceivers(r1, r2)     // Catch: java.lang.Exception -> L58
            r6 = r0
        L52:
            r0 = r6
            return r0
        L54:
            r5 = move-exception
            goto L22
        L58:
            r4 = move-exception
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.d.f.c(android.content.Context):java.util.List");
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        String str;
        if (this.f27414a.getPackageName().equals(com.vivo.push.util.t.b(this.f27414a))) {
            return;
        }
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) oVar;
        int d = jVar.d();
        int e = jVar.e();
        com.vivo.push.util.p.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + d + " ; receiverStatus is " + e);
        if (d == 2) {
            b(this.f27414a);
        } else if (d == 1) {
            a(this.f27414a);
        } else if (d == 0) {
            Context context = this.f27414a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            } else {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 0) {
                    packageManager.setComponentEnabledSetting(componentName, 0, 1);
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has defaulted");
                }
            }
        }
        if (e == 2) {
            Context context2 = this.f27414a;
            List<ResolveInfo> c2 = c(context2);
            if (c2 == null || c2.size() <= 0) {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            } else {
                String str2 = c2.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str2)) {
                    str = "disableReceiver error: className is null. ";
                } else {
                    PackageManager packageManager2 = context2.getPackageManager();
                    ComponentName componentName2 = new ComponentName(context2, str2);
                    if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                        packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                        str = "push service disableReceiver ";
                    } else {
                        str = "push service has disableReceiver ";
                    }
                }
                com.vivo.push.util.p.d("OnChangePushStatusTask", str);
            }
            com.vivo.push.sdk.a.a().b();
        } else if (e == 1) {
            Context context3 = this.f27414a;
            List<ResolveInfo> c3 = c(context3);
            if (c3 == null || c3.size() <= 0) {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
                return;
            }
            String str3 = c3.get(0).activityInfo.name;
            if (TextUtils.isEmpty(str3)) {
                com.vivo.push.util.p.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                return;
            }
            PackageManager packageManager3 = context3.getPackageManager();
            ComponentName componentName3 = new ComponentName(context3, str3);
            if (packageManager3.getComponentEnabledSetting(componentName3) == 1) {
                com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has enableReceiver ");
                return;
            }
            packageManager3.setComponentEnabledSetting(componentName3, 1, 1);
            com.vivo.push.util.p.d("OnChangePushStatusTask", "push service enableReceiver ");
        } else if (e == 0) {
            Context context4 = this.f27414a;
            List<ResolveInfo> c4 = c(context4);
            if (c4 == null || c4.size() <= 0) {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
                return;
            }
            String str4 = c4.get(0).activityInfo.name;
            if (TextUtils.isEmpty(str4)) {
                com.vivo.push.util.p.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                return;
            }
            PackageManager packageManager4 = context4.getPackageManager();
            ComponentName componentName4 = new ComponentName(context4, str4);
            if (packageManager4.getComponentEnabledSetting(componentName4) == 0) {
                com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has defaulted");
                return;
            }
            packageManager4.setComponentEnabledSetting(componentName4, 0, 1);
            com.vivo.push.util.p.d("OnChangePushStatusTask", "push service defaultReceiver ");
        }
    }
}
