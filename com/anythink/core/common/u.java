package com.anythink.core.common;

import com.anythink.core.api.AdError;
import com.anythink.core.common.g.a.c;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/u.class */
public class u {

    /* renamed from: c  reason: collision with root package name */
    private static volatile u f6923c;
    private String b = u.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    AtomicInteger f6924a = new AtomicInteger(0);

    private u() {
    }

    public static u a() {
        if (f6923c == null) {
            synchronized (u.class) {
                try {
                    if (f6923c == null) {
                        f6923c = new u();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6923c;
    }

    public final void a(final int i, final String str, final String str2, final String str3, final String str4) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.u.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.e.o oVar = new com.anythink.core.common.e.o();
                oVar.b = i;
                oVar.d = str;
                oVar.f6672c = str2;
                oVar.e = str3;
                oVar.f = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(oVar.f);
                sb.append(str3);
                oVar.f6671a = com.anythink.core.common.k.f.a(sb.toString() != null ? str3 : "");
                oVar.g = str4;
                String unused = u.this.b;
                new StringBuilder("save request:").append(oVar.a());
                com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).a(oVar);
            }
        });
    }

    public final void b() {
        List<com.anythink.core.common.e.o> c2;
        synchronized (this) {
            if (this.f6924a.get() <= 0 && (c2 = com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).c()) != null && c2.size() > 0) {
                this.f6924a.set(c2.size());
                new StringBuilder("need to send request count: ").append(this.f6924a.get());
                for (final com.anythink.core.common.e.o oVar : c2) {
                    if (System.currentTimeMillis() - oVar.f >= 604800000) {
                        this.f6924a.decrementAndGet();
                        com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).b(oVar);
                    } else {
                        int i = 1000;
                        try {
                            i = new JSONObject(oVar.g).optInt(com.anythink.core.common.e.o.h);
                        } catch (Throwable th) {
                        }
                        if (oVar.b == 3) {
                            new com.anythink.core.common.g.a.b(oVar.e, i).a(new c.a() { // from class: com.anythink.core.common.u.2
                                @Override // com.anythink.core.common.g.a.c.a
                                public final void a(Object obj) {
                                    String unused = u.this.b;
                                    new StringBuilder("re-send success.... ").append(oVar.a());
                                    com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).b(oVar);
                                    u.this.f6924a.decrementAndGet();
                                }

                                @Override // com.anythink.core.common.g.a.c.a
                                public final void a(Throwable th2) {
                                    String unused = u.this.b;
                                    StringBuilder sb = new StringBuilder("re-send fail.... ");
                                    sb.append(oVar.a());
                                    sb.append("--error: ");
                                    sb.append(th2.getMessage());
                                    u.this.f6924a.decrementAndGet();
                                }
                            });
                        } else {
                            final com.anythink.core.common.g.l lVar = new com.anythink.core.common.g.l(oVar);
                            if (i == 1001) {
                                lVar.p();
                            }
                            lVar.a(0, new com.anythink.core.common.g.i() { // from class: com.anythink.core.common.u.3
                                @Override // com.anythink.core.common.g.i
                                public final void onLoadCanceled(int i2) {
                                    u.this.f6924a.decrementAndGet();
                                }

                                @Override // com.anythink.core.common.g.i
                                public final void onLoadError(int i2, String str, AdError adError) {
                                    String unused = u.this.b;
                                    StringBuilder sb = new StringBuilder("re-send fail.... ");
                                    sb.append(oVar.a());
                                    sb.append("--error: ");
                                    if (str == null) {
                                        str = "";
                                    }
                                    sb.append(str);
                                    u.this.f6924a.decrementAndGet();
                                }

                                @Override // com.anythink.core.common.g.i
                                public final void onLoadFinish(int i2, Object obj) {
                                    String unused = u.this.b;
                                    new StringBuilder("re-send success.... ").append(oVar.a());
                                    com.anythink.core.common.c.g.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).b(lVar.q());
                                    u.this.f6924a.decrementAndGet();
                                }

                                @Override // com.anythink.core.common.g.i
                                public final void onLoadStart(int i2) {
                                }
                            });
                        }
                    }
                }
            }
        }
    }
}
