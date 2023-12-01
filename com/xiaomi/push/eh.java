package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/eh.class */
public class eh implements ee {
    private void a(Service service, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (TextUtils.isEmpty(stringExtra)) {
            dx.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
            return;
        }
        String b = dw.b(stringExtra);
        boolean isEmpty = TextUtils.isEmpty(b);
        Context applicationContext = service.getApplicationContext();
        if (isEmpty) {
            dx.a(applicationContext, "service", 1008, "B get a incorrect message");
        } else {
            dx.a(applicationContext, b, 1007, "play with service successfully");
        }
    }

    private void b(Context context, ea eaVar) {
        String m11708a = eaVar.m11708a();
        String b = eaVar.b();
        String d = eaVar.d();
        int a2 = eaVar.a();
        if (context == null || TextUtils.isEmpty(m11708a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                dx.a(context, "service", 1008, "argument error");
            } else {
                dx.a(context, d, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.l.a(context, m11708a, b)) {
            dx.a(context, d, 1003, "B is not ready");
        } else {
            dx.a(context, d, 1002, "B is ready");
            dx.a(context, d, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setAction(b);
                intent.setPackage(m11708a);
                intent.putExtra("awake_info", dw.a(d));
                if (a2 == 1 && !eb.m11709a(context)) {
                    dx.a(context, d, 1008, "A not in foreground");
                } else if (context.startService(intent) == null) {
                    dx.a(context, d, 1008, "A is fail to help B's service");
                } else {
                    dx.a(context, d, 1005, "A is successful");
                    dx.a(context, d, 1006, "The job is finished");
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                dx.a(context, d, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.ee
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            dx.a(context, "service", 1008, "A receive incorrect message");
        } else {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.ee
    public void a(Context context, ea eaVar) {
        if (eaVar != null) {
            b(context, eaVar);
        } else {
            dx.a(context, "service", 1008, "A receive incorrect message");
        }
    }
}
