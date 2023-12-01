package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.cz;
import com.xiaomi.push.fj;
import com.xiaomi.push.fu;
import com.xiaomi.push.gf;
import com.xiaomi.push.gl;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.hv;
import com.xiaomi.push.ic;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.bg;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ah.class */
public final class ah {
    static fj a(XMPushService xMPushService, byte[] bArr) {
        ic icVar = new ic();
        try {
            iq.a(icVar, bArr);
            return a(u.m9160a((Context) xMPushService), xMPushService, icVar);
        } catch (iw e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static fj a(t tVar, Context context, ic icVar) {
        try {
            fj fjVar = new fj();
            fjVar.a(5);
            fjVar.c(tVar.f1033a);
            fjVar.b(a(icVar));
            fjVar.a("SECMSG", "message");
            String str = tVar.f1033a;
            icVar.f661a.f585a = str.substring(0, str.indexOf("@"));
            icVar.f661a.f589c = str.substring(str.indexOf("/") + 1);
            fjVar.a(iq.a(icVar), tVar.f28011c);
            fjVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m8344a("try send mi push message. packagename:" + icVar.f666b + " action:" + icVar.f659a);
            return fjVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ic a(String str, String str2) {
        Cif cif = new Cif();
        cif.b(str2);
        cif.c("package uninstalled");
        cif.a(gl.i());
        cif.a(false);
        return a(str, str2, cif, hg.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends ir<T, ?>> ic a(String str, String str2, T t, hg hgVar) {
        return a(str, str2, t, hgVar, true);
    }

    private static <T extends ir<T, ?>> ic a(String str, String str2, T t, hg hgVar, boolean z) {
        byte[] a2 = iq.a(t);
        ic icVar = new ic();
        hv hvVar = new hv();
        hvVar.f584a = 5L;
        hvVar.f585a = "fakeid";
        icVar.a(hvVar);
        icVar.a(ByteBuffer.wrap(a2));
        icVar.a(hgVar);
        icVar.b(z);
        icVar.b(str);
        icVar.a(false);
        icVar.a(str2);
        return icVar;
    }

    private static String a(ic icVar) {
        if (icVar.f660a != null && icVar.f660a.f575b != null) {
            String str = icVar.f660a.f575b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return icVar.f666b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService) {
        t m9160a = u.m9160a(xMPushService.getApplicationContext());
        if (m9160a != null) {
            bg.b a2 = u.m9160a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m8344a("prepare account. " + a2.f963a);
            a(xMPushService, a2);
            bg.a().a(a2);
            a(xMPushService, m9160a, 172800);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, ic icVar) {
        cz.a(icVar.b(), xMPushService.getApplicationContext(), icVar, -1);
        fu m9042a = xMPushService.m9042a();
        if (m9042a == null) {
            throw new gf("try send msg while connection is null.");
        }
        if (!m9042a.mo8725a()) {
            throw new gf("Don't support XMPP connection.");
        }
        fj a2 = a(u.m9160a((Context) xMPushService), xMPushService, icVar);
        if (a2 != null) {
            m9042a.b(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, bg.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new aj(xMPushService));
    }

    private static void a(XMPushService xMPushService, t tVar, int i) {
        bx.a(xMPushService).a(new ai("MSAID", i, xMPushService, tVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        cz.a(str, xMPushService.getApplicationContext(), bArr);
        fu m9042a = xMPushService.m9042a();
        if (m9042a == null) {
            throw new gf("try send msg while connection is null.");
        }
        if (!m9042a.mo8725a()) {
            throw new gf("Don't support XMPP connection.");
        }
        fj a2 = a(xMPushService, bArr);
        if (a2 != null) {
            m9042a.b(a2);
        } else {
            x.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ic b(String str, String str2) {
        Cif cif = new Cif();
        cif.b(str2);
        cif.c(hq.AppDataCleared.f536a);
        cif.a(bd.a());
        cif.a(false);
        return a(str, str2, cif, hg.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends ir<T, ?>> ic b(String str, String str2, T t, hg hgVar) {
        return a(str, str2, t, hgVar, false);
    }
}
