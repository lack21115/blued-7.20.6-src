package com.anythink.core.common.b;

import android.text.TextUtils;
import com.reyun.mobdna.MobClientInfo;
import com.reyun.mobdna.MobDNA;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/i.class */
public class i {
    private static volatile i b;
    private final String a = getClass().getSimpleName();
    private String c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;

    public static i a() {
        if (b == null) {
            synchronized (i.class) {
                try {
                    if (b == null) {
                        b = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private boolean e() {
        return (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) ? false : true;
    }

    public final void a(int i, com.anythink.core.common.e.e eVar) {
        String str;
        if (eVar != null) {
            if (i == 4 || i == 6) {
                com.anythink.core.c.a b2 = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                if (n.a().H()) {
                    a(b2);
                    if (e()) {
                        try {
                            Map<String, Object> m = n.a().m();
                            str = "";
                            if (m != null) {
                                str = m.get("user_id").toString();
                            }
                        } catch (Throwable th) {
                            str = "";
                        }
                        try {
                            if (b2.h() == 1 && i == 4) {
                                MobDNA.dna_event_ad(str, eVar.H(), eVar.k(), String.valueOf(eVar.w()), 2);
                            } else if (b2.f() == 1 && i == 6) {
                                MobDNA.dna_event_ad(str, eVar.H(), eVar.k(), String.valueOf(eVar.w()), 3);
                            }
                        } catch (Throwable th2) {
                        }
                    }
                }
            }
        }
    }

    public final boolean a(com.anythink.core.c.a aVar) {
        synchronized (this) {
            if (this.g) {
                return true;
            }
            if (aVar == null || aVar.d() != 1) {
                return false;
            }
            try {
                if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) {
                    MobClientInfo clientInfo = MobDNA.getClientInfo(n.a().g());
                    if (clientInfo == null) {
                        return false;
                    }
                    this.c = clientInfo.oid;
                    this.d = clientInfo.appkey;
                    this.e = clientInfo.rdid;
                    StringBuilder sb = new StringBuilder("oid: ");
                    sb.append(this.c);
                    sb.append(", appkey: ");
                    sb.append(this.d);
                    sb.append(", rdid: ");
                    sb.append(this.e);
                }
            } catch (Throwable th) {
            }
            boolean e = e();
            this.g = e;
            if (!this.f && e) {
                this.f = true;
                com.anythink.core.common.j.c.b(this.c, this.d, this.e);
            }
            return this.g;
        }
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }
}
