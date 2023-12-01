package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.fj;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gn;
import com.xiaomi.push.service.bg;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private y f27993a = new y();

    public static String a(bg.b bVar) {
        StringBuilder sb;
        String str;
        if ("9".equals(bVar.g)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(bVar.f963a);
            sb = sb2;
            str = ".permission.MIMC_RECEIVE";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(bVar.f963a);
            str = ".permission.MIPUSH_RECEIVE";
            sb = sb3;
        }
        sb.append(str);
        return sb.toString();
    }

    private static void a(Context context, Intent intent, bg.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    bg.b a(fj fjVar) {
        Collection<bg.b> m9100a = bg.a().m9100a(Integer.toString(fjVar.a()));
        if (m9100a.isEmpty()) {
            return null;
        }
        Iterator<bg.b> it = m9100a.iterator();
        if (m9100a.size() == 1) {
            return it.next();
        }
        String g = fjVar.g();
        while (it.hasNext()) {
            bg.b next = it.next();
            if (TextUtils.equals(g, next.f966b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.xiaomi.push.service.bg.b a(com.xiaomi.push.gl r4) {
        /*
            r3 = this;
            com.xiaomi.push.service.bg r0 = com.xiaomi.push.service.bg.a()
            r1 = r4
            java.lang.String r1 = r1.k()
            java.util.Collection r0 = r0.m9100a(r1)
            r6 = r0
            r0 = r6
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L16
            r0 = 0
            return r0
        L16:
            r0 = r6
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
            r0 = r6
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L31
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.xiaomi.push.service.bg$b r0 = (com.xiaomi.push.service.bg.b) r0
            return r0
        L31:
            r0 = r4
            java.lang.String r0 = r0.m()
            r6 = r0
            r0 = r4
            java.lang.String r0 = r0.l()
            r4 = r0
        L3b:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L6a
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.xiaomi.push.service.bg$b r0 = (com.xiaomi.push.service.bg.b) r0
            r7 = r0
            r0 = r6
            r1 = r7
            java.lang.String r1 = r1.f966b
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 != 0) goto L67
            r0 = r4
            r1 = r7
            java.lang.String r1 = r1.f966b
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L3b
        L67:
            r0 = r7
            return r0
        L6a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.j.a(com.xiaomi.push.gl):com.xiaomi.push.service.bg$b");
    }

    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (com.xiaomi.push.j.m9002c()) {
            intent.addFlags(16777216);
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
        context.sendBroadcast(intent);
    }

    public void a(Context context, bg.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f963a);
        intent.putExtra(bk.t, bVar.g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(bk.q, bVar.f966b);
        intent.putExtra(bk.F, bVar.i);
        if (bVar.f957a == null || !"9".equals(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.g, bVar.f963a, Integer.valueOf(i)));
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.f957a.send(Message.obtain(null, 17, intent));
        } catch (RemoteException e) {
            bVar.f957a = null;
            com.xiaomi.channel.commonutils.logger.b.m8344a("peer may died: " + bVar.f966b.substring(bVar.f966b.lastIndexOf(64)));
        }
    }

    public void a(Context context, bg.b bVar, String str, String str2) {
        if (bVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify kick by server!");
        } else if ("5".equalsIgnoreCase(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
        } else {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(bVar.f963a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", bVar.g);
            intent.putExtra(bk.q, bVar.f966b);
            intent.putExtra(bk.F, bVar.i);
            com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.g, bVar.f963a, str2));
            a(context, intent, bVar);
        }
    }

    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.f27993a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f963a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(bk.q, bVar.f966b);
        intent.putExtra(bk.F, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.g, bVar.f963a, Boolean.valueOf(z), Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fj fjVar) {
        bg.b a2 = a(fjVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f27993a.a(xMPushService, fjVar, a2);
        } else {
            String str2 = a2.f963a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", fjVar.m8713a(a2.h));
            intent.putExtra(bk.F, a2.i);
            intent.putExtra(bk.x, a2.h);
            if (a2.f957a != null) {
                try {
                    a2.f957a.send(Message.obtain(null, 17, intent));
                    com.xiaomi.channel.commonutils.logger.b.m8344a("message was sent by messenger for chid=".concat(String.valueOf(str)));
                    return;
                } catch (RemoteException e) {
                    a2.f957a = null;
                    com.xiaomi.channel.commonutils.logger.b.m8344a("peer may died: " + a2.f966b.substring(a2.f966b.lastIndexOf(64)));
                }
            }
            if ("com.xiaomi.xmsf".equals(str2)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a2.g, a2.f963a, fjVar.e()));
            a(xMPushService, intent, a2);
            if (!"10".equals(str) || fjVar.f403a == null) {
                return;
            }
            fjVar.f403a.d = System.currentTimeMillis();
            ao.a(xMPushService, "coord_down", fjVar.f403a);
        }
    }

    public void a(XMPushService xMPushService, String str, gl glVar) {
        String str2;
        bg.b a2 = a(glVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f27993a.a(xMPushService, glVar, a2);
        } else {
            String str3 = a2.f963a;
            if (glVar instanceof gk) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (glVar instanceof gj) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (!(glVar instanceof gn)) {
                com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                return;
            } else {
                str2 = "com.xiaomi.push.new_pres";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", glVar.a());
            intent.putExtra(bk.F, a2.i);
            intent.putExtra(bk.x, a2.h);
            com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("[Bcst] notify packet arrival. %s,%s,%s", a2.g, a2.f963a, glVar.j()));
            a(xMPushService, intent, a2);
        }
    }
}
