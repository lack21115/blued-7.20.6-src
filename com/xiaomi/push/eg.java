package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/eg.class */
public class eg implements ee {
    private void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str) || context == null) {
                dx.a(context, com.umeng.analytics.pro.d.M, 1008, "B get a incorrect message");
                return;
            }
            String[] split = str.split("/");
            if (split.length <= 0 || TextUtils.isEmpty(split[split.length - 1])) {
                dx.a(context, com.umeng.analytics.pro.d.M, 1008, "B get a incorrect message");
                return;
            }
            String str2 = split[split.length - 1];
            if (TextUtils.isEmpty(str2)) {
                dx.a(context, com.umeng.analytics.pro.d.M, 1008, "B get a incorrect message");
                return;
            }
            String decode = Uri.decode(str2);
            if (TextUtils.isEmpty(decode)) {
                dx.a(context, com.umeng.analytics.pro.d.M, 1008, "B get a incorrect message");
                return;
            }
            String b = dw.b(decode);
            if (TextUtils.isEmpty(b)) {
                dx.a(context, com.umeng.analytics.pro.d.M, 1008, "B get a incorrect message");
            } else {
                dx.a(context, b, 1007, "play with provider successfully");
            }
        } catch (Exception e) {
            dx.a(context, com.umeng.analytics.pro.d.M, 1008, "B meet a exception" + e.getMessage());
        }
    }

    private void b(Context context, ea eaVar) {
        String b = eaVar.b();
        String d = eaVar.d();
        int a2 = eaVar.a();
        if (context == null || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                dx.a(context, com.umeng.analytics.pro.d.M, 1008, "argument error");
            } else {
                dx.a(context, d, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.l.b(context, b)) {
            dx.a(context, d, 1003, "B is not ready");
        } else {
            dx.a(context, d, 1002, "B is ready");
            dx.a(context, d, 1004, "A is ready");
            String a3 = dw.a(d);
            try {
                if (TextUtils.isEmpty(a3)) {
                    dx.a(context, d, 1008, "info is empty");
                } else if (a2 == 1 && !eb.m8659a(context)) {
                    dx.a(context, d, 1008, "A not in foreground");
                } else {
                    String type = context.getContentResolver().getType(dw.a(b, a3));
                    if (TextUtils.isEmpty(type) || !com.baidu.mobads.sdk.internal.bw.o.equals(type)) {
                        dx.a(context, d, 1008, "A is fail to help B's provider");
                        return;
                    }
                    dx.a(context, d, 1005, "A is successful");
                    dx.a(context, d, 1006, "The job is finished");
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                dx.a(context, d, 1008, "A meet a exception when help B's provider");
            }
        }
    }

    @Override // com.xiaomi.push.ee
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // com.xiaomi.push.ee
    public void a(Context context, ea eaVar) {
        if (eaVar != null) {
            b(context, eaVar);
        } else {
            dx.a(context, com.umeng.analytics.pro.d.M, 1008, "A receive incorrect message");
        }
    }
}
