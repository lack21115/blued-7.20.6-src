package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.em;
import com.xiaomi.push.fj;
import com.xiaomi.push.gf;
import com.xiaomi.push.gi;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gz;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ic;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/y.class */
public class y {
    public static Intent a(byte[] bArr, long j) {
        ic a2 = a(bArr);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a2.f713b);
        return intent;
    }

    public static ic a(Context context, ic icVar) {
        return a(context, icVar, (Map<String, String>) null);
    }

    public static ic a(Context context, ic icVar, Map<String, String> map) {
        hw hwVar = new hw();
        hwVar.b(icVar.m11946a());
        ht m11945a = icVar.m11945a();
        if (m11945a != null) {
            hwVar.a(m11945a.m11895a());
            hwVar.a(m11945a.m11893a());
            if (!TextUtils.isEmpty(m11945a.m11900b())) {
                hwVar.c(m11945a.m11900b());
            }
        }
        hwVar.a(iq.a(context, icVar));
        ic a2 = ah.a(icVar.b(), icVar.m11946a(), hwVar, hg.AckMessage);
        ht m11945a2 = icVar.m11945a();
        ht htVar = m11945a2;
        if (m11945a2 != null) {
            htVar = br.a(m11945a2.m11894a());
        }
        htVar.a("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str : map.keySet()) {
                        htVar.a(str, map.get(str));
                    }
                }
            } catch (Throwable th) {
            }
        }
        a2.a(htVar);
        return a2;
    }

    public static ic a(byte[] bArr) {
        ic icVar = new ic();
        try {
            iq.a(icVar, bArr);
            return icVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static void a(Context context, ic icVar, byte[] bArr) {
        try {
            ak.a(icVar);
            icVar.m11945a();
            ak.c m12109a = ak.m12109a(context, icVar, bArr);
            if (m12109a.f41604a > 0 && !TextUtils.isEmpty(m12109a.f970a)) {
                gz.a(context, m12109a.f970a, m12109a.f41604a, true, false, System.currentTimeMillis());
            }
            if (!com.xiaomi.push.j.m12048a(context) || !ag.a(context, icVar, m12109a.f971a)) {
                b(context, icVar, bArr);
                return;
            }
            ag.m12103a(context, icVar);
            com.xiaomi.channel.commonutils.logger.b.m11394a("consume this broadcast by tts");
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("notify push msg error ".concat(String.valueOf(e)));
            e.printStackTrace();
        }
    }

    private static void a(XMPushService xMPushService, ic icVar) {
        xMPushService.a(new z(4, xMPushService, icVar));
    }

    private static void a(XMPushService xMPushService, ic icVar, Cif cif) {
        xMPushService.a(new af(4, cif, icVar, xMPushService));
    }

    private static void a(XMPushService xMPushService, ic icVar, String str) {
        xMPushService.a(new ad(4, xMPushService, icVar, str));
    }

    private static void a(XMPushService xMPushService, ic icVar, String str, String str2) {
        xMPushService.a(new ae(4, xMPushService, icVar, str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0526 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.xiaomi.push.service.XMPushService r9, java.lang.String r10, byte[] r11, android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 1671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.y.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m11896a;
        ic a2 = a(bArr);
        if (a2 == null) {
            return;
        }
        if (TextUtils.isEmpty(a2.f713b)) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a3 = a(bArr, valueOf.longValue());
        String a4 = ak.a(a2);
        gz.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
        ht m11945a = a2.m11945a();
        if (m11945a != null && m11945a.m11895a() != null) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a2.m11946a(), bd.a(m11945a.m11895a()), a2.a()));
        }
        if (m11945a != null) {
            m11945a.a("mrt", Long.toString(valueOf.longValue()));
        }
        String str = "";
        if (hg.SendMessage == a2.a() && v.a(xMPushService).m12215a(a2.f713b) && !ak.m12113a(a2)) {
            if (m11945a != null) {
                String m11895a = m11945a.m11895a();
                str = m11895a;
                if (ak.e(a2)) {
                    em.a(xMPushService.getApplicationContext()).a(a2.b(), ak.b(a2), m11895a, "1");
                    str = m11895a;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m11394a("Drop a message for unregistered, msgid=".concat(String.valueOf(str)));
            a(xMPushService, a2, a2.f713b);
        } else if (hg.SendMessage == a2.a() && v.a(xMPushService).m12217c(a2.f713b) && !ak.m12113a(a2)) {
            if (m11945a != null) {
                String m11895a2 = m11945a.m11895a();
                str = m11895a2;
                if (ak.e(a2)) {
                    em.a(xMPushService.getApplicationContext()).a(a2.b(), ak.b(a2), m11895a2, "2");
                    str = m11895a2;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m11394a("Drop a message for push closed, msgid=".concat(String.valueOf(str)));
            a(xMPushService, a2, a2.f713b);
        } else if (hg.SendMessage == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f713b)) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f713b);
            a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f713b);
            if (m11945a == null || !ak.e(a2)) {
                return;
            }
            em.a(xMPushService.getApplicationContext()).a(a2.b(), ak.b(a2), m11945a.m11895a(), "3");
        } else if (hg.SendMessage != a2.a() || com.xiaomi.push.i.a() != 999 || !com.xiaomi.push.i.a(xMPushService, a4)) {
            if (m11945a == null || (m11896a = m11945a.m11896a()) == null || !m11896a.containsKey("hide") || !"true".equalsIgnoreCase(m11896a.get("hide"))) {
                a(xMPushService, a4, bArr, a3);
            } else {
                b(xMPushService, a2);
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Receive the uninstalled dual app message");
            try {
                ah.a(xMPushService, ah.a(a4, a2.m11946a()));
                com.xiaomi.channel.commonutils.logger.b.m11394a("uninstall " + a4 + " msg sent");
            } catch (gf e) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e.getMessage());
                xMPushService.a(10, e);
            }
            ak.m12110a((Context) xMPushService, a4);
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                return !queryBroadcastReceivers.isEmpty();
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                return !queryIntentServices.isEmpty();
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (com.xiaomi.push.g.m11801a(context, str)) {
            Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(str);
            try {
                if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                    return false;
                }
                com.xiaomi.channel.commonutils.logger.b.m11394a("broadcast message arrived.");
                context.sendBroadcast(intent, ah.a(str));
                return true;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("meet error when broadcast message arrived. ".concat(String.valueOf(e)));
                return false;
            }
        }
        return false;
    }

    private static boolean a(ic icVar) {
        return "com.xiaomi.xmsf".equals(icVar.f713b) && icVar.m11945a() != null && icVar.m11945a().m11896a() != null && icVar.m11945a().m11896a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, ic icVar, ht htVar) {
        boolean z = true;
        if (htVar != null) {
            z = true;
            if (htVar.m11896a() != null) {
                z = true;
                if (htVar.m11896a().containsKey("__check_alive")) {
                    z = true;
                    if (htVar.m11896a().containsKey("__awake")) {
                        Cif cif = new Cif();
                        cif.b(icVar.m11946a());
                        cif.d(str);
                        cif.c(hq.AwakeSystemApp.f583a);
                        cif.a(htVar.m11895a());
                        cif.f725a = new HashMap();
                        boolean m11801a = com.xiaomi.push.g.m11801a(xMPushService.getApplicationContext(), str);
                        cif.f725a.put("app_running", Boolean.toString(m11801a));
                        z = true;
                        if (!m11801a) {
                            boolean parseBoolean = Boolean.parseBoolean(htVar.m11896a().get("__awake"));
                            cif.f725a.put("awaked", Boolean.toString(parseBoolean));
                            z = true;
                            if (!parseBoolean) {
                                z = false;
                            }
                        }
                        try {
                            ah.a(xMPushService, ah.a(icVar.b(), icVar.m11946a(), cif, hg.Notification));
                            return z;
                        } catch (gf e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                }
            }
        }
        return z;
    }

    private static void b(Context context, ic icVar, byte[] bArr) {
        if (ak.m12113a(icVar)) {
            return;
        }
        String a2 = ak.a(icVar);
        if (TextUtils.isEmpty(a2) || a(context, a2, bArr)) {
            return;
        }
        em.a(context).b(a2, ak.b(icVar), icVar.m11945a().m11895a(), "1");
    }

    private static void b(XMPushService xMPushService, ic icVar) {
        xMPushService.a(new aa(4, xMPushService, icVar));
    }

    private static boolean b(ic icVar) {
        Map<String, String> m11896a = icVar.m11945a().m11896a();
        return m11896a != null && m11896a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, ic icVar) {
        xMPushService.a(new ab(4, xMPushService, icVar));
    }

    private static boolean c(ic icVar) {
        if (icVar.m11945a() == null || icVar.m11945a().m11896a() == null) {
            return false;
        }
        return "1".equals(icVar.m11945a().m11896a().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, ic icVar) {
        xMPushService.a(new ac(4, xMPushService, icVar));
    }

    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        t m12210a;
        if (z || (m12210a = u.m12210a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        u.a(context, m12210a.f, m12210a.d, m12210a.e);
    }

    public void a(XMPushService xMPushService, fj fjVar, bg.b bVar) {
        try {
            a(xMPushService, fjVar.m11763a(bVar.h), fjVar.c());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gl glVar, bg.b bVar) {
        if (!(glVar instanceof gk)) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("not a mipush message");
            return;
        }
        gk gkVar = (gk) glVar;
        gi a2 = gkVar.a("s");
        if (a2 != null) {
            try {
                a(xMPushService, bp.a(bp.a(bVar.h, gkVar.j()), a2.c()), gz.a(glVar.mo11814a()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
