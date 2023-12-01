package com.anythink.core.common.b;

import android.content.Context;
import android.content.Intent;
import com.anythink.core.activity.AnyThinkGdprAuthActivity;
import com.anythink.core.api.ATGDPRAuthCallback;
import com.anythink.core.api.AdError;
import com.anythink.core.api.NetTrafficeCallback;
import com.anythink.core.common.b.g;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/p.class */
public class p {
    private static volatile p d;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    int f6560c;

    /* renamed from: a  reason: collision with root package name */
    final int f6559a = -100;
    private ConcurrentHashMap<Integer, Boolean> e = new ConcurrentHashMap<>(5);

    private p(Context context) {
        this.f6560c = 2;
        if (context != null) {
            this.b = context.getApplicationContext();
        }
        this.f6560c = com.anythink.core.common.k.p.b(this.b, g.o, g.o.d, 2);
    }

    public static p a(Context context) {
        if (d == null) {
            synchronized (p.class) {
                try {
                    if (d == null) {
                        d = new p(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public final int a() {
        return this.f6560c;
    }

    public final void a(int i) {
        this.f6560c = i;
        com.anythink.core.common.k.p.a(this.b, g.o, g.o.d, i);
    }

    public final void a(final Context context, final ATGDPRAuthCallback aTGDPRAuthCallback) {
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.p.1
            @Override // java.lang.Runnable
            public final void run() {
                AnyThinkGdprAuthActivity.mCallback = aTGDPRAuthCallback;
                Intent intent = new Intent(context, AnyThinkGdprAuthActivity.class);
                intent.setFlags(268435456);
                context.startActivity(intent);
            }
        });
    }

    public final void a(final NetTrafficeCallback netTrafficeCallback) {
        int b = com.anythink.core.common.k.p.b(this.b, g.o, g.o.j, -100);
        if (b == -100) {
            new com.anythink.core.common.g.h().a(0, new com.anythink.core.common.g.i() { // from class: com.anythink.core.common.b.p.2
                @Override // com.anythink.core.common.g.i
                public final void onLoadCanceled(int i) {
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadError(int i, String str, AdError adError) {
                    NetTrafficeCallback netTrafficeCallback2 = netTrafficeCallback;
                    if (netTrafficeCallback2 != null) {
                        netTrafficeCallback2.onErrorCallback(adError.printStackTrace());
                    }
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadFinish(int i, Object obj) {
                    try {
                        if (obj == null) {
                            if (netTrafficeCallback != null) {
                                netTrafficeCallback.onErrorCallback("There is no result.");
                            }
                        } else if (!((JSONObject) obj).has("is_eu")) {
                            if (netTrafficeCallback != null) {
                                netTrafficeCallback.onErrorCallback("There is no result.");
                            }
                        } else if (((JSONObject) obj).optInt("is_eu") == 1) {
                            if (netTrafficeCallback != null) {
                                netTrafficeCallback.onResultCallback(true);
                            }
                        } else if (netTrafficeCallback != null) {
                            netTrafficeCallback.onResultCallback(false);
                        }
                    } catch (Throwable th) {
                        NetTrafficeCallback netTrafficeCallback2 = netTrafficeCallback;
                        if (netTrafficeCallback2 != null) {
                            netTrafficeCallback2.onErrorCallback("Internal error");
                        }
                    }
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadStart(int i) {
                }
            });
        } else if (b == 1) {
            if (netTrafficeCallback != null) {
                netTrafficeCallback.onResultCallback(true);
            }
        } else if (netTrafficeCallback != null) {
            netTrafficeCallback.onResultCallback(false);
        }
    }

    public final void b(final int i) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.p.3
            @Override // java.lang.Runnable
            public final void run() {
                if (p.this.c(i)) {
                    return;
                }
                p a2 = p.a(n.a().g());
                com.anythink.core.c.a b = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                if (a2.f6560c == 2 && b.U() == 1 && b.I() == 0) {
                    com.anythink.core.common.j.c.a(1, a2.f6560c, b.U(), i);
                }
                if (a2.f6560c == 1 && b.S() == 0 && b.U() == 0) {
                    com.anythink.core.common.j.c.a(2, a2.f6560c, b.U(), i);
                }
                p.this.e.put(Integer.valueOf(i), Boolean.TRUE);
            }
        });
    }

    public final boolean b() {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(this.b).b(n.a().p());
        if (b == null || b.G()) {
            return this.f6560c != 1;
        } else if (b.U() == 0) {
            return true;
        } else {
            int i = this.f6560c;
            if (b.S() == 1) {
                i = b.R();
            }
            return i == 0;
        }
    }

    public final boolean c() {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(this.b).b(n.a().p());
        return (b == null || b.G()) ? this.f6560c != 1 : this.f6560c == 2 ? b.U() == 0 : b.S() == 1 ? b.R() == 0 : this.f6560c == 0 || b.U() == 0;
    }

    public final boolean c(int i) {
        return this.e.get(Integer.valueOf(i)) != null && this.e.get(Integer.valueOf(i)).booleanValue();
    }

    public final boolean d() {
        return com.anythink.core.common.k.p.b(this.b, g.o, g.o.j, -100) == 1;
    }
}
