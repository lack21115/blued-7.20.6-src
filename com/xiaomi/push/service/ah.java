package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
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
            return a(u.m12210a((Context) xMPushService), xMPushService, icVar);
        } catch (iw e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static fj a(t tVar, Context context, ic icVar) {
        try {
            fj fjVar = new fj();
            fjVar.a(5);
            fjVar.c(tVar.f1080a);
            fjVar.b(a(icVar));
            fjVar.a("SECMSG", "message");
            String str = tVar.f1080a;
            icVar.f708a.f632a = str.substring(0, str.indexOf("@"));
            icVar.f708a.f636c = str.substring(str.indexOf(BridgeUtil.SPLIT_MARK) + 1);
            fjVar.a(iq.a(icVar), tVar.f41702c);
            fjVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m11394a("try send mi push message. packagename:" + icVar.f713b + " action:" + icVar.f706a);
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
        hvVar.f631a = 5L;
        hvVar.f632a = "fakeid";
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
        if (icVar.f707a != null && icVar.f707a.f622b != null) {
            String str = icVar.f707a.f622b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return icVar.f713b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService) {
        t m12210a = u.m12210a(xMPushService.getApplicationContext());
        if (m12210a != null) {
            bg.b a2 = u.m12210a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m11394a("prepare account. " + a2.f1010a);
            a(xMPushService, a2);
            bg.a().a(a2);
            a(xMPushService, m12210a, 172800);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, ic icVar) {
        cz.a(icVar.b(), xMPushService.getApplicationContext(), icVar, -1);
        fu m12092a = xMPushService.m12092a();
        if (m12092a == null) {
            throw new gf("try send msg while connection is null.");
        }
        if (!m12092a.mo11775a()) {
            throw new gf("Don't support XMPP connection.");
        }
        fj a2 = a(u.m12210a((Context) xMPushService), xMPushService, icVar);
        if (a2 != null) {
            m12092a.b(a2);
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
        fu m12092a = xMPushService.m12092a();
        if (m12092a == null) {
            throw new gf("try send msg while connection is null.");
        }
        if (!m12092a.mo11775a()) {
            throw new gf("Don't support XMPP connection.");
        }
        fj a2 = a(xMPushService, bArr);
        if (a2 != null) {
            m12092a.b(a2);
        } else {
            x.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ic b(String str, String str2) {
        Cif cif = new Cif();
        cif.b(str2);
        cif.c(hq.AppDataCleared.f583a);
        cif.a(bd.a());
        cif.a(false);
        return a(str, str2, cif, hg.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends ir<T, ?>> ic b(String str, String str2, T t, hg hgVar) {
        return a(str, str2, t, hgVar, false);
    }
}
