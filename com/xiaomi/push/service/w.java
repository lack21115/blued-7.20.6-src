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
    private XMPushService f41706a;

    /* renamed from: a  reason: collision with other field name */
    private String f1084a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f1085a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f41707c;

    public w(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f41706a = xMPushService;
        this.f1084a = str;
        this.f1085a = bArr;
        this.b = str2;
        this.f41707c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        bg.b next;
        t m12210a = u.m12210a((Context) this.f41706a);
        t tVar = m12210a;
        if (m12210a == null) {
            try {
                tVar = u.a(this.f41706a, this.f1084a, this.b, this.f41707c);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. ".concat(String.valueOf(e)));
                tVar = m12210a;
            }
        }
        if (tVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            x.a(this.f41706a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("do registration now.");
        Collection<bg.b> m12150a = bg.a().m12150a("5");
        if (m12150a.isEmpty()) {
            next = tVar.a(this.f41706a);
            ah.a(this.f41706a, next);
            bg.a().a(next);
        } else {
            next = m12150a.iterator().next();
        }
        if (!this.f41706a.m12100c()) {
            x.a(this.f1084a, this.f1085a);
            this.f41706a.a(true);
            return;
        }
        try {
            if (next.f1008a == bg.c.binded) {
                ah.a(this.f41706a, this.f1084a, this.f1085a);
            } else if (next.f1008a == bg.c.unbind) {
                x.a(this.f1084a, this.f1085a);
                XMPushService xMPushService = this.f41706a;
                XMPushService xMPushService2 = this.f41706a;
                xMPushService2.getClass();
                xMPushService.a(new XMPushService.b(next));
            }
        } catch (gf e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. ".concat(String.valueOf(e2)));
            this.f41706a.a(10, e2);
        }
    }
}
