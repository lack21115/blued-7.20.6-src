package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/f.class */
public class f implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f41223a;

    /* renamed from: a  reason: collision with other field name */
    private Context f155a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f156a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f158a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<e, AbstractPushManager> f157a = new HashMap();

    private f(Context context) {
        this.f155a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (f41223a == null) {
            synchronized (f.class) {
                try {
                    if (f41223a == null) {
                        f41223a = new f(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41223a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        PushConfiguration pushConfiguration = this.f156a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f156a.getOpenHmsPush() + " HW online switch : " + i.m11483a(this.f155a, e.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + n.m11491a(this.f155a));
                com.xiaomi.channel.commonutils.logger.b.m11394a(sb.toString());
            }
            if (this.f156a.getOpenHmsPush() && i.m11483a(this.f155a, e.ASSEMBLE_PUSH_HUAWEI) && n.m11491a(this.f155a)) {
                if (!m11476a(e.ASSEMBLE_PUSH_HUAWEI)) {
                    a(e.ASSEMBLE_PUSH_HUAWEI, ak.a(this.f155a, e.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m11476a(e.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(e.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m11475a(e.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f156a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f156a.getOpenFCMPush() + " FCM online switch : " + i.m11483a(this.f155a, e.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + n.b(this.f155a));
                com.xiaomi.channel.commonutils.logger.b.m11394a(sb2.toString());
            }
            if (this.f156a.getOpenFCMPush() && i.m11483a(this.f155a, e.ASSEMBLE_PUSH_FCM) && n.b(this.f155a)) {
                if (!m11476a(e.ASSEMBLE_PUSH_FCM)) {
                    a(e.ASSEMBLE_PUSH_FCM, ak.a(this.f155a, e.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m11476a(e.ASSEMBLE_PUSH_FCM) && (a3 = a(e.ASSEMBLE_PUSH_FCM)) != null) {
                m11475a(e.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f156a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f156a.getOpenCOSPush() + " COS online switch : " + i.m11483a(this.f155a, e.ASSEMBLE_PUSH_COS) + " COS isSupport : " + n.c(this.f155a));
                com.xiaomi.channel.commonutils.logger.b.m11394a(sb3.toString());
            }
            if (this.f156a.getOpenCOSPush() && i.m11483a(this.f155a, e.ASSEMBLE_PUSH_COS) && n.c(this.f155a)) {
                a(e.ASSEMBLE_PUSH_COS, ak.a(this.f155a, e.ASSEMBLE_PUSH_COS));
            } else if (m11476a(e.ASSEMBLE_PUSH_COS) && (a4 = a(e.ASSEMBLE_PUSH_COS)) != null) {
                m11475a(e.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f156a.getOpenFTOSPush() && i.m11483a(this.f155a, e.ASSEMBLE_PUSH_FTOS) && n.d(this.f155a)) {
                a(e.ASSEMBLE_PUSH_FTOS, ak.a(this.f155a, e.ASSEMBLE_PUSH_FTOS));
            } else if (!m11476a(e.ASSEMBLE_PUSH_FTOS) || (a5 = a(e.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m11475a(e.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(e eVar) {
        return this.f157a.get(eVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f156a = pushConfiguration;
        this.f158a = ba.a(this.f155a).a(hl.AggregatePushSwitch.a(), true);
        if (this.f156a.getOpenHmsPush() || this.f156a.getOpenFCMPush() || this.f156a.getOpenCOSPush() || this.f156a.getOpenFTOSPush()) {
            ba.a(this.f155a).a(new g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11475a(e eVar) {
        this.f157a.remove(eVar);
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f157a.containsKey(eVar)) {
                this.f157a.remove(eVar);
            }
            this.f157a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11476a(e eVar) {
        return this.f157a.containsKey(eVar);
    }

    public boolean b(e eVar) {
        int i = h.f41225a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f156a;
            z = false;
            if (pushConfiguration != null) {
                z = pushConfiguration.getOpenHmsPush();
            }
        } else if (i != 2) {
            if (i == 3) {
                PushConfiguration pushConfiguration2 = this.f156a;
                if (pushConfiguration2 != null) {
                    z = pushConfiguration2.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration3 = this.f156a;
            if (pushConfiguration3 != null) {
                return pushConfiguration3.getOpenFTOSPush();
            }
        } else {
            PushConfiguration pushConfiguration4 = this.f156a;
            z = false;
            if (pushConfiguration4 != null) {
                return pushConfiguration4.getOpenFCMPush();
            }
        }
        return z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m11394a("ASSEMBLE_PUSH : assemble push register");
        if (this.f157a.size() <= 0) {
            a();
        }
        if (this.f157a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f157a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            i.m11479a(this.f155a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m11394a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f157a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f157a.clear();
    }
}
