package com.igexin.push.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import com.igexin.c.a.d.g;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.d;
import com.igexin.push.core.e.f;
import com.igexin.push.e.h;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/f.class */
public final class f extends HandlerThread {
    public f() {
        super("CoreThread");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        d dVar = d.a.f9866a;
        try {
            e.a(dVar.f9861a);
            com.igexin.push.config.b.a();
            com.igexin.push.config.b.b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(b.H);
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("com.igexin.action.notification.click");
            intentFilter.addAction(Intent.ACTION_SCREEN_ON);
            intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
            dVar.f9861a.registerReceiver(i.a(), intentFilter, e.ac, null);
            com.igexin.push.a.a aVar = new com.igexin.push.a.a();
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.f.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.config.a.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.e.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.c.a());
            dVar.f.a((com.igexin.c.a.d.f) aVar, true, false);
            com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
            if (TextUtils.isEmpty(com.igexin.push.f.g.f10041c)) {
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass26(), true, false);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass27(), true, false);
            }
            com.igexin.push.core.d.b.c().a();
            com.igexin.c.a.c.a.b("Type145Task", "doAction ---");
            Intent intent = new Intent(e.g + ".doaction");
            intent.putExtra("cid", e.A);
            intent.putExtra("appid", e.f9887a);
            intent.putExtra("gtcid", e.C);
            intent.putExtra("type145DelayMs", com.igexin.push.config.d.Z);
            intent.putExtra("type145Enable", com.igexin.push.config.d.Y);
            intent.putExtra("biUploadUrl", SDKUrlConfig.getBiUploadServiceUrl());
            intent.putExtra("gtsdkGuardStart", ServiceManager.getInstance().initType.first);
            intent.putExtra("type145PicEnable", com.igexin.push.config.d.aa);
            intent.putExtra("type145IpEnable", com.igexin.push.config.d.ab);
            intent.putExtra("type145GpsLocationEnable", com.igexin.push.config.d.ac);
            intent.putExtra("type145NetLocEnable", com.igexin.push.config.d.ad);
            intent.putExtra("type145CellInfoEnable", com.igexin.push.config.d.ae);
            com.igexin.push.e.h.a(e.l, 1, intent);
            com.igexin.push.e.h unused = h.a.f10027a;
            com.igexin.push.e.h.a(e.l, intent);
            com.igexin.c.a.b.e eVar = dVar.f;
            Context context = dVar.f9861a;
            if (!eVar.H) {
                if (!com.igexin.push.f.n.m()) {
                    eVar.u = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
                    eVar.C = true;
                    eVar.v = (AlarmManager) context.getSystemService("alarm");
                    context.registerReceiver(eVar, new g.AnonymousClass1(context), e.ac, null);
                    eVar.A = "AlarmNioTaskSchedule." + context.getPackageName();
                    context.registerReceiver(eVar, new IntentFilter(eVar.A), e.ac, null);
                    int i = 134217728;
                    if (com.igexin.push.f.n.a(context) >= 31) {
                        i = 134217728;
                        if (Build.VERSION.SDK_INT >= 30) {
                            i = 201326592;
                        }
                    }
                    eVar.w = new Intent("AlarmTaskSchedule." + context.getPackageName());
                    eVar.x = PendingIntent.getBroadcast(context, eVar.hashCode(), eVar.w, i);
                    eVar.hashCode();
                    eVar.y = new Intent(eVar.A);
                    eVar.z = PendingIntent.getBroadcast(context, eVar.hashCode() + 2, eVar.y, i);
                    eVar.hashCode();
                }
                eVar.p.start();
                Thread.yield();
                eVar.H = true;
            }
            com.igexin.c.a.b.e eVar2 = dVar.f;
            byte[] a3 = com.igexin.c.b.a.a(e.L.getBytes());
            eVar2.e = a3;
            eVar2.f = com.igexin.c.b.a.a(a3);
            if (eVar2.f != null) {
                new String(eVar2.f);
            }
            e.ae = dVar.f.a((com.igexin.c.a.d.f) com.igexin.push.e.b.b.g(), false, true);
            e.af = dVar.f.a((com.igexin.c.a.d.f) com.igexin.push.e.b.e.g(), true, true);
            com.igexin.push.b.c.a();
            com.igexin.push.b.c.b();
            dVar.c();
            dVar.d = com.igexin.push.core.a.b.d();
            dVar.h.a();
            com.igexin.push.e.f.c().d();
            e.m.set(true);
            com.igexin.push.e.g.c().d();
            while (!dVar.f9862c.isEmpty()) {
                Message poll = dVar.f9862c.poll();
                if (poll != null && dVar.b != null) {
                    dVar.b.sendMessage(poll);
                }
            }
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new d.AnonymousClass1(), true);
        } catch (Throwable th) {
            th = th;
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTrace = th.getStackTrace();
            while (th.getCause() != null) {
                th = th.getCause();
            }
            sb.append(th.toString());
            sb.append("\n");
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    String sb2 = sb.toString();
                    com.igexin.c.a.c.a.b("CoreLogic", sb2);
                    com.igexin.c.a.c.a.d.a().a("[CoreLogic] ------ CoreLogic init failed = " + sb2 + " ------");
                    return;
                }
                sb.append(stackTrace[i3].toString());
                sb.append("\n");
                i2 = i3 + 1;
            }
        }
    }
}
