package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.eb;
import com.xiaomi.push.ed;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/o.class */
public class o {
    public static void a(Context context, Intent intent, Uri uri) {
        eb a2;
        ed edVar;
        if (context == null) {
            return;
        }
        ao.a(context).m8395a();
        if (eb.a(context.getApplicationContext()).m8660a() == null) {
            eb.a(context.getApplicationContext()).a(b.m8407a(context.getApplicationContext()).m8408a(), context.getPackageName(), ba.a(context.getApplicationContext()).a(hl.AwakeInfoUploadWaySwitch.a(), 0), new c());
            ba.a(context).a(new q(102, "awake online config", context));
        }
        if ((context instanceof Activity) && intent != null) {
            a2 = eb.a(context.getApplicationContext());
            edVar = ed.ACTIVITY;
        } else if (!(context instanceof Service) || intent == null) {
            if (uri == null || TextUtils.isEmpty(uri.toString())) {
                return;
            }
            eb.a(context.getApplicationContext()).a(ed.PROVIDER, context, (Intent) null, uri.toString());
            return;
        } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            a2 = eb.a(context.getApplicationContext());
            edVar = ed.SERVICE_COMPONENT;
        } else {
            a2 = eb.a(context.getApplicationContext());
            edVar = ed.SERVICE_ACTION;
        }
        a2.a(edVar, context, intent, (String) null);
    }

    private static void a(Context context, Cif cif) {
        boolean z = false;
        boolean a2 = ba.a(context).a(hl.AwakeAppPingSwitch.a(), false);
        int a3 = ba.a(context).a(hl.AwakeAppPingFrequency.a(), 0);
        int i = a3;
        if (a3 >= 0) {
            i = a3;
            if (a3 < 30) {
                com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                i = 30;
            }
        }
        if (i >= 0) {
            z = a2;
        }
        if (!com.xiaomi.push.j.m8997a()) {
            a(context, cif, z, i);
        } else if (z) {
            com.xiaomi.push.ai.a(context.getApplicationContext()).a((ai.a) new p(cif, context), i);
        }
    }

    public static final <T extends ir<T, ?>> void a(Context context, T t, boolean z, int i) {
        byte[] a2 = iq.a(t);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a2);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ao.a(context).m8397a(intent);
    }

    public static void a(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.m8344a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", "9999");
        hashMap.put("description", "ping message");
        Cif cif = new Cif();
        cif.b(b.m8407a(context).m8408a());
        cif.d(context.getPackageName());
        cif.c(hq.AwakeAppResponse.f536a);
        cif.a(bd.a());
        cif.f678a = hashMap;
        a(context, cif);
    }

    public static void a(Context context, String str, int i, String str2) {
        Cif cif = new Cif();
        cif.b(str);
        cif.a(new HashMap());
        cif.m8914a().put("extra_aw_app_online_cmd", String.valueOf(i));
        cif.m8914a().put("extra_help_aw_info", str2);
        cif.a(bd.a());
        byte[] a2 = iq.a(cif);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a2);
        ao.a(context).m8397a(intent);
    }
}
