package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ei.class */
public class ei implements ee {
    private void a(Service service, Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                dx.a(service.getApplicationContext(), "service", 1007, "old version message");
            } else if (TextUtils.isEmpty(stringExtra2)) {
                dx.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
            } else {
                String b = dw.b(stringExtra2);
                boolean isEmpty = TextUtils.isEmpty(b);
                Context applicationContext = service.getApplicationContext();
                if (isEmpty) {
                    dx.a(applicationContext, "service", 1008, "B get a incorrect message");
                } else {
                    dx.a(applicationContext, b, 1007, "old version message ");
                }
            }
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                dx.a(context, "service", 1008, "argument error");
            } else {
                dx.a(context, str3, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.l.a(context, str)) {
            dx.a(context, str3, 1003, "B is not ready");
        } else {
            dx.a(context, str3, 1002, "B is ready");
            dx.a(context, str3, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                intent.putExtra("waker_pkgname", context.getPackageName());
                intent.putExtra("awake_info", dw.a(str3));
                if (context.startService(intent) == null) {
                    dx.a(context, str3, 1008, "A is fail to help B's service");
                    return;
                }
                dx.a(context, str3, 1005, "A is successful");
                dx.a(context, str3, 1006, "The job is finished");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                dx.a(context, str3, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.ee
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            return;
        }
        a((Service) context, intent);
    }

    @Override // com.xiaomi.push.ee
    public void a(Context context, ea eaVar) {
        if (eaVar != null) {
            a(context, eaVar.m11708a(), eaVar.c(), eaVar.d());
        }
    }
}
