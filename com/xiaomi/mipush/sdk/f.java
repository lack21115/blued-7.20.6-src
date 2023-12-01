package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/f.class */
public class f implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f27532a;

    /* renamed from: a  reason: collision with other field name */
    private Context f108a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f109a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f111a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<e, AbstractPushManager> f110a = new HashMap();

    private f(Context context) {
        this.f108a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (f27532a == null) {
            synchronized (f.class) {
                try {
                    if (f27532a == null) {
                        f27532a = new f(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27532a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        PushConfiguration pushConfiguration = this.f109a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f109a.getOpenHmsPush() + " HW online switch : " + i.m8433a(this.f108a, e.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + n.m8441a(this.f108a));
                com.xiaomi.channel.commonutils.logger.b.m8344a(sb.toString());
            }
            if (this.f109a.getOpenHmsPush() && i.m8433a(this.f108a, e.ASSEMBLE_PUSH_HUAWEI) && n.m8441a(this.f108a)) {
                if (!m8426a(e.ASSEMBLE_PUSH_HUAWEI)) {
                    a(e.ASSEMBLE_PUSH_HUAWEI, ak.a(this.f108a, e.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m8426a(e.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(e.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m8425a(e.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f109a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f109a.getOpenFCMPush() + " FCM online switch : " + i.m8433a(this.f108a, e.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + n.b(this.f108a));
                com.xiaomi.channel.commonutils.logger.b.m8344a(sb2.toString());
            }
            if (this.f109a.getOpenFCMPush() && i.m8433a(this.f108a, e.ASSEMBLE_PUSH_FCM) && n.b(this.f108a)) {
                if (!m8426a(e.ASSEMBLE_PUSH_FCM)) {
                    a(e.ASSEMBLE_PUSH_FCM, ak.a(this.f108a, e.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m8426a(e.ASSEMBLE_PUSH_FCM) && (a3 = a(e.ASSEMBLE_PUSH_FCM)) != null) {
                m8425a(e.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f109a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f109a.getOpenCOSPush() + " COS online switch : " + i.m8433a(this.f108a, e.ASSEMBLE_PUSH_COS) + " COS isSupport : " + n.c(this.f108a));
                com.xiaomi.channel.commonutils.logger.b.m8344a(sb3.toString());
            }
            if (this.f109a.getOpenCOSPush() && i.m8433a(this.f108a, e.ASSEMBLE_PUSH_COS) && n.c(this.f108a)) {
                a(e.ASSEMBLE_PUSH_COS, ak.a(this.f108a, e.ASSEMBLE_PUSH_COS));
            } else if (m8426a(e.ASSEMBLE_PUSH_COS) && (a4 = a(e.ASSEMBLE_PUSH_COS)) != null) {
                m8425a(e.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f109a.getOpenFTOSPush() && i.m8433a(this.f108a, e.ASSEMBLE_PUSH_FTOS) && n.d(this.f108a)) {
                a(e.ASSEMBLE_PUSH_FTOS, ak.a(this.f108a, e.ASSEMBLE_PUSH_FTOS));
            } else if (!m8426a(e.ASSEMBLE_PUSH_FTOS) || (a5 = a(e.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m8425a(e.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(e eVar) {
        return this.f110a.get(eVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f109a = pushConfiguration;
        this.f111a = ba.a(this.f108a).a(hl.AggregatePushSwitch.a(), true);
        if (this.f109a.getOpenHmsPush() || this.f109a.getOpenFCMPush() || this.f109a.getOpenCOSPush() || this.f109a.getOpenFTOSPush()) {
            ba.a(this.f108a).a(new g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8425a(e eVar) {
        this.f110a.remove(eVar);
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f110a.containsKey(eVar)) {
                this.f110a.remove(eVar);
            }
            this.f110a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8426a(e eVar) {
        return this.f110a.containsKey(eVar);
    }

    public boolean b(e eVar) {
        int i = h.f27534a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f109a;
            z = false;
            if (pushConfiguration != null) {
                z = pushConfiguration.getOpenHmsPush();
            }
        } else if (i != 2) {
            if (i == 3) {
                PushConfiguration pushConfiguration2 = this.f109a;
                if (pushConfiguration2 != null) {
                    z = pushConfiguration2.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration3 = this.f109a;
            if (pushConfiguration3 != null) {
                return pushConfiguration3.getOpenFTOSPush();
            }
        } else {
            PushConfiguration pushConfiguration4 = this.f109a;
            z = false;
            if (pushConfiguration4 != null) {
                return pushConfiguration4.getOpenFCMPush();
            }
        }
        return z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : assemble push register");
        if (this.f110a.size() <= 0) {
            a();
        }
        if (this.f110a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f110a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            i.m8429a(this.f108a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f110a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f110a.clear();
    }
}
