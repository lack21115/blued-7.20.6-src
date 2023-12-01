package com.anythink.basead.a;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b.class */
public final class b {
    public static final int A = 27;
    public static final int B = 28;
    public static final int C = 29;
    public static final int D = 30;
    public static final int E = 31;
    public static final int F = 32;
    public static final int G = 33;
    public static final int H = 34;
    public static final int I = 35;
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;
    public static final int n = 14;
    public static final int o = 15;
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;
    public static final int s = 19;
    public static final int t = 20;
    public static final int u = 21;
    public static final int v = 22;
    public static final int w = 23;
    public static final int x = 24;
    public static final int y = 25;
    public static final int z = 26;

    public static void a(final int i2, final com.anythink.core.common.e.i iVar, final com.anythink.basead.c.i iVar2) {
        if (iVar.L()) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.anythink.basead.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.e.i iVar3 = com.anythink.core.common.e.i.this;
                if (iVar3 instanceof s) {
                    s sVar = (s) iVar3;
                    boolean a2 = iVar3.k() != null ? b.a(i2, com.anythink.core.common.e.i.this.k()) : false;
                    if (i2 == 8) {
                        new com.anythink.basead.g.c(sVar.P(), iVar2.a, a2).a(0, (com.anythink.core.common.g.i) null);
                    }
                    com.anythink.basead.g.b bVar = new com.anythink.basead.g.b(i2, sVar, iVar2.a);
                    bVar.b(iVar2.b);
                    bVar.a(0, (com.anythink.core.common.g.i) null);
                } else {
                    j.a(i2, (aa) iVar3, iVar2);
                }
                if (i2 == 21) {
                    com.anythink.core.common.e.i iVar4 = com.anythink.core.common.e.i.this;
                    if (iVar4 instanceof com.anythink.core.common.e.g) {
                        com.anythink.core.common.e.g gVar = (com.anythink.core.common.e.g) iVar4;
                        if (gVar.c() == 1) {
                            if (!com.anythink.core.common.k.h.a(n.a().g().getApplicationContext(), gVar.B())) {
                                StringBuilder sb = new StringBuilder("check offer installed(Apk Install Broadcast):false,dsp offerid:");
                                sb.append(gVar.U());
                                sb.append(",packagename:");
                                sb.append(gVar.B());
                                return;
                            }
                            StringBuilder sb2 = new StringBuilder("check offer installed(Apk Install Broadcast):true,dsp offerid:");
                            sb2.append(gVar.U());
                            sb2.append(",packagename:");
                            sb2.append(gVar.B());
                            com.anythink.core.common.a.b.a().c(gVar);
                        }
                    }
                }
            }
        };
        if (Looper.getMainLooper() != Looper.myLooper()) {
            runnable.run();
        } else {
            com.anythink.core.common.k.b.a.a().a(runnable);
        }
    }

    private static void a(com.anythink.core.common.e.i iVar) {
        if (iVar instanceof com.anythink.core.common.e.g) {
            com.anythink.core.common.e.g gVar = (com.anythink.core.common.e.g) iVar;
            if (gVar.c() == 1) {
                if (!com.anythink.core.common.k.h.a(n.a().g().getApplicationContext(), gVar.B())) {
                    StringBuilder sb = new StringBuilder("check offer installed(Apk Install Broadcast):false,dsp offerid:");
                    sb.append(gVar.U());
                    sb.append(",packagename:");
                    sb.append(gVar.B());
                    return;
                }
                StringBuilder sb2 = new StringBuilder("check offer installed(Apk Install Broadcast):true,dsp offerid:");
                sb2.append(gVar.U());
                sb2.append(",packagename:");
                sb2.append(gVar.B());
                com.anythink.core.common.a.b.a().c(gVar);
            }
        }
    }

    public static boolean a(int i2, k kVar) {
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 8) {
            if (i2 == 9) {
                return kVar.d() == 1;
            } else if (i2 != 35) {
                return false;
            }
        }
        return kVar.c() == 1;
    }

    public static boolean a(Context context, com.anythink.core.common.e.i iVar) {
        if (TextUtils.isEmpty(iVar.z()) || !com.anythink.core.basead.a.a.a(context, iVar.z(), false)) {
            if (TextUtils.isEmpty(iVar.B())) {
                return false;
            }
            return c.a(context, iVar.B());
        }
        return true;
    }

    public static boolean a(Context context, com.anythink.core.common.e.j jVar, final com.anythink.core.common.e.i iVar, com.anythink.basead.c.d dVar, String str, com.anythink.core.common.f.b bVar) {
        try {
            IExHandler b2 = n.a().b();
            String str2 = (dVar == null || TextUtils.isEmpty(dVar.c)) ? "" : dVar.c;
            if (b2 != null) {
                final Context applicationContext = context.getApplicationContext();
                b2.handleOfferClick(applicationContext, jVar, iVar, str, str2, new Runnable() { // from class: com.anythink.basead.a.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (com.anythink.core.common.e.i.this instanceof aa) {
                            h.a(applicationContext).a();
                            h.a(applicationContext).a(com.anythink.core.common.e.i.this.p(), com.anythink.core.common.e.i.this);
                        }
                    }
                }, bVar);
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(com.anythink.core.common.e.i iVar, k kVar) {
        return iVar instanceof com.anythink.core.common.e.g ? (kVar instanceof ab) && ((ab) kVar).Y() == 1 : (iVar instanceof s) && ((s) iVar).O() == 1;
    }
}
