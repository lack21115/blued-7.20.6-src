package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.dd;
import com.xiaomi.push.dv;
import com.xiaomi.push.ex;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fv;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gz;
import com.xiaomi.push.service.bg;
import java.util.Date;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/be.class */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f27937a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(XMPushService xMPushService) {
        this.f27937a = xMPushService;
    }

    private void a(gi giVar) {
        String c2 = giVar.c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String[] split = c2.split(com.huawei.openalliance.ad.constant.t.aE);
        com.xiaomi.push.cp a2 = com.xiaomi.push.ct.a().a(fv.a(), false);
        if (a2 == null || split.length <= 0) {
            return;
        }
        a2.a(split);
        this.f27937a.a(20, (Exception) null);
        this.f27937a.a(true);
    }

    private void b(gl glVar) {
        bg.b a2;
        String l = glVar.l();
        String k = glVar.k();
        if (TextUtils.isEmpty(l) || TextUtils.isEmpty(k) || (a2 = bg.a().a(k, l)) == null) {
            return;
        }
        gz.a(this.f27937a, a2.f963a, gz.a(glVar.mo8764a()), true, true, System.currentTimeMillis());
    }

    private void c(fj fjVar) {
        bg.b a2;
        String g = fjVar.g();
        String num = Integer.toString(fjVar.a());
        if (TextUtils.isEmpty(g) || TextUtils.isEmpty(num) || (a2 = bg.a().a(num, g)) == null) {
            return;
        }
        gz.a(this.f27937a, a2.f963a, fjVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fj fjVar) {
        if (5 != fjVar.a()) {
            c(fjVar);
        }
        try {
            b(fjVar);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + fjVar.a() + " cmd = " + fjVar.m8708a() + " packetid = " + fjVar.e() + " failure ", e);
        }
    }

    public void a(gl glVar) {
        if (!"5".equals(glVar.k())) {
            b(glVar);
        }
        String k = glVar.k();
        String str = k;
        if (TextUtils.isEmpty(k)) {
            str = "1";
            glVar.l("1");
        }
        if (str.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Received wrong packet with chid = 0 : " + glVar.mo8764a());
        }
        if (glVar instanceof gj) {
            gi a2 = glVar.a("kick");
            if (a2 != null) {
                String l = glVar.l();
                String a3 = a2.a("type");
                String a4 = a2.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m8344a("kicked by server, chid=" + str + " res=" + bg.b.a(l) + " type=" + a3 + " reason=" + a4);
                if (!"wait".equals(a3)) {
                    this.f27937a.a(str, l, 3, a4, a3);
                    bg.a().m9104a(str, l);
                    return;
                }
                bg.b a5 = bg.a().a(str, l);
                if (a5 != null) {
                    this.f27937a.a(a5);
                    a5.a(bg.c.unbind, 3, 0, a4, a3);
                    return;
                }
                return;
            }
        } else if (glVar instanceof gk) {
            gk gkVar = (gk) glVar;
            if ("redir".equals(gkVar.b())) {
                gi a6 = gkVar.a("hosts");
                if (a6 != null) {
                    a(a6);
                    return;
                }
                return;
            }
        }
        this.f27937a.m9047b().a(this.f27937a, str, glVar);
    }

    public void b(fj fjVar) {
        bg.c cVar;
        int i;
        String m8708a = fjVar.m8708a();
        if (fjVar.a() == 0) {
            if ("PING".equals(m8708a)) {
                byte[] m8712a = fjVar.m8712a();
                if (m8712a != null && m8712a.length > 0) {
                    dv.j a2 = dv.j.a(m8712a);
                    if (a2.m8648b()) {
                        bv.a().a(a2.m8646a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f27937a.getPackageName())) {
                    this.f27937a.m9044a();
                }
                if ("1".equals(fjVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("received a server ping");
                } else {
                    fh.b();
                }
                this.f27937a.m9048b();
                return;
            } else if (!"SYNC".equals(m8708a)) {
                if ("NOTIFY".equals(fjVar.m8708a())) {
                    dv.h a3 = dv.h.a(fjVar.m8712a());
                    com.xiaomi.channel.commonutils.logger.b.m8344a("notify by server err = " + a3.c() + " desc = " + a3.m8640a());
                    return;
                }
                return;
            } else if ("CONF".equals(fjVar.m8714b())) {
                bv.a().a(dv.b.a(fjVar.m8712a()));
                return;
            } else if (TextUtils.equals("U", fjVar.m8714b())) {
                dv.k a4 = dv.k.a(fjVar.m8712a());
                dd.a(this.f27937a).a(a4.m8650a(), a4.m8653b(), new Date(a4.m8649a()), new Date(a4.m8652b()), a4.c() * 1024, a4.e());
                fj fjVar2 = new fj();
                fjVar2.a(0);
                fjVar2.a(fjVar.m8708a(), "UCA");
                fjVar2.a(fjVar.e());
                XMPushService xMPushService = this.f27937a;
                xMPushService.a(new bt(xMPushService, fjVar2));
                return;
            } else if (TextUtils.equals("P", fjVar.m8714b())) {
                dv.i a5 = dv.i.a(fjVar.m8712a());
                fj fjVar3 = new fj();
                fjVar3.a(0);
                fjVar3.a(fjVar.m8708a(), "PCA");
                fjVar3.a(fjVar.e());
                dv.i iVar = new dv.i();
                if (a5.m8644a()) {
                    iVar.a(a5.m8643a());
                }
                fjVar3.a(iVar.a(), (String) null);
                XMPushService xMPushService2 = this.f27937a;
                xMPushService2.a(new bt(xMPushService2, fjVar3));
                com.xiaomi.channel.commonutils.logger.b.m8344a("ACK msgP: id = " + fjVar.e());
                return;
            } else {
                return;
            }
        }
        String num = Integer.toString(fjVar.a());
        if ("SECMSG".equals(fjVar.m8708a())) {
            if (!fjVar.m8711a()) {
                this.f27937a.m9047b().a(this.f27937a, num, fjVar);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a("Recv SECMSG errCode = " + fjVar.b() + " errStr = " + fjVar.m8715c());
        } else if (!"BIND".equals(m8708a)) {
            if ("KICK".equals(m8708a)) {
                dv.g a6 = dv.g.a(fjVar.m8712a());
                String g = fjVar.g();
                String m8635a = a6.m8635a();
                String m8637b = a6.m8637b();
                com.xiaomi.channel.commonutils.logger.b.m8344a("kicked by server, chid=" + num + " res= " + bg.b.a(g) + " type=" + m8635a + " reason=" + m8637b);
                if (!"wait".equals(m8635a)) {
                    this.f27937a.a(num, g, 3, m8637b, m8635a);
                    bg.a().m9104a(num, g);
                    return;
                }
                bg.b a7 = bg.a().a(num, g);
                if (a7 != null) {
                    this.f27937a.a(a7);
                    a7.a(bg.c.unbind, 3, 0, m8637b, m8635a);
                }
            }
        } else {
            dv.d a8 = dv.d.a(fjVar.m8712a());
            String g2 = fjVar.g();
            bg.b a9 = bg.a().a(num, g2);
            if (a9 == null) {
                return;
            }
            if (a8.m8614a()) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("SMACK: channel bind succeeded, chid=" + fjVar.a());
                a9.a(bg.c.binded, 1, 0, (String) null, (String) null);
                return;
            }
            String m8613a = a8.m8613a();
            if ("auth".equals(m8613a)) {
                if ("invalid-sig".equals(a8.m8615b())) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("SMACK: bind error invalid-sig token = " + a9.f27941c + " sec = " + a9.h);
                    fh.a(0, ex.BIND_INVALID_SIG.a(), 1, null, 0);
                }
                cVar = bg.c.unbind;
                i = 5;
            } else if (!com.anythink.expressad.d.a.b.dO.equals(m8613a)) {
                if ("wait".equals(m8613a)) {
                    this.f27937a.a(a9);
                    a9.a(bg.c.unbind, 1, 7, a8.m8615b(), m8613a);
                }
                com.xiaomi.channel.commonutils.logger.b.m8344a("SMACK: channel bind failed, chid=" + num + " reason=" + a8.m8615b());
            } else {
                cVar = bg.c.unbind;
                i = 7;
            }
            a9.a(cVar, 1, i, a8.m8615b(), m8613a);
            bg.a().m9104a(num, g2);
            com.xiaomi.channel.commonutils.logger.b.m8344a("SMACK: channel bind failed, chid=" + num + " reason=" + a8.m8615b());
        }
    }
}
