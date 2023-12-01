package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gf;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/w.class */
public class w extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f28015a;

    /* renamed from: a  reason: collision with other field name */
    private String f1037a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f1038a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f28016c;

    public w(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f28015a = xMPushService;
        this.f1037a = str;
        this.f1038a = bArr;
        this.b = str2;
        this.f28016c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        bg.b next;
        t m9160a = u.m9160a((Context) this.f28015a);
        t tVar = m9160a;
        if (m9160a == null) {
            try {
                tVar = u.a(this.f28015a, this.f1037a, this.b, this.f28016c);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. ".concat(String.valueOf(e)));
                tVar = m9160a;
            }
        }
        if (tVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            x.a(this.f28015a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("do registration now.");
        Collection<bg.b> m9100a = bg.a().m9100a("5");
        if (m9100a.isEmpty()) {
            next = tVar.a(this.f28015a);
            ah.a(this.f28015a, next);
            bg.a().a(next);
        } else {
            next = m9100a.iterator().next();
        }
        if (!this.f28015a.m9050c()) {
            x.a(this.f1037a, this.f1038a);
            this.f28015a.a(true);
            return;
        }
        try {
            if (next.f961a == bg.c.binded) {
                ah.a(this.f28015a, this.f1037a, this.f1038a);
            } else if (next.f961a == bg.c.unbind) {
                x.a(this.f1037a, this.f1038a);
                XMPushService xMPushService = this.f28015a;
                XMPushService xMPushService2 = this.f28015a;
                xMPushService2.getClass();
                xMPushService.a(new XMPushService.b(next));
            }
        } catch (gf e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. ".concat(String.valueOf(e2)));
            this.f28015a.a(10, e2);
        }
    }
}
