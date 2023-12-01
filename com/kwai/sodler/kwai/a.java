package com.kwai.sodler.kwai;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.ext.c;
import com.kwai.sodler.lib.i;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/kwai/a.class */
public final class a {
    private static InterfaceC0424a aJF;
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static volatile boolean hasInit = false;

    /* renamed from: com.kwai.sodler.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/kwai/a$a.class */
    public interface InterfaceC0424a {
        void a(f fVar, File file);

        int getMaxRetryCount();

        boolean sp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/kwai/a$b.class */
    public static final class b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> extends b.C0425b<P, R> {
        com.kwai.sodler.lib.ext.b<P, R> aJI;
        c<P, R> aJJ;

        protected b(com.kwai.sodler.lib.ext.b<P, R> bVar, c<P, R> cVar) {
            this.aJI = bVar;
            this.aJJ = cVar;
        }

        @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
        public final void a(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.a(r);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
        public final void a(R r, P p) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.a((com.kwai.sodler.lib.ext.b<P, R>) r, (R) p);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
        public final void a(R r, PluginError pluginError) {
            com.kwai.sodler.lib.a.e("Sodler.helper", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.a((com.kwai.sodler.lib.ext.b<P, R>) r, pluginError);
            }
            c<P, R> cVar = this.aJJ;
            if (cVar != null) {
                cVar.d(r);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
        public final void b(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.b(r);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0425b, com.kwai.sodler.lib.ext.b
        public final void c(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aJI;
            if (bVar != null) {
                bVar.c(r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/kwai/a$c.class */
    public interface c<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {
        void d(R r);
    }

    private static <P extends com.kwai.sodler.lib.a.a, R extends f<P>> void a(Context context, R r, com.kwai.sodler.lib.ext.b<P, R> bVar) {
        init(context);
        r.dm(i.Jl().Jn().getRetryCount());
        r.a(new b(bVar, new c<P, R>() { // from class: com.kwai.sodler.kwai.a.1
            /* JADX WARN: Incorrect types in method signature: (TR;)V */
            @Override // com.kwai.sodler.kwai.a.c
            public final void d(final f fVar) {
                i.Jl().l(fVar);
                a.handler.postDelayed(new Runnable() { // from class: com.kwai.sodler.kwai.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (fVar.JD()) {
                            i.Jl().a(fVar, 16);
                        }
                    }
                }, fVar.JC() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        }));
        i.Jl().a(r, 16);
    }

    public static void a(Context context, com.kwai.sodler.lib.c.b bVar, b.a aVar) {
        a(context, new com.kwai.sodler.lib.b.a(bVar), aVar);
    }

    public static void a(Context context, com.kwai.sodler.lib.c.b bVar, b.c cVar) {
        a(context, new com.kwai.sodler.lib.b.c(bVar), cVar);
    }

    public static void a(InterfaceC0424a interfaceC0424a) {
        aJF = interfaceC0424a;
    }

    public static <T extends com.kwai.sodler.lib.a.a> T ar(Context context, String str) {
        init(context);
        return (T) i.Jl().Jo().fM(str);
    }

    private static void init(Context context) {
        int i;
        boolean z;
        synchronized (a.class) {
            try {
                if (hasInit) {
                    return;
                }
                if (aJF != null) {
                    i = aJF.getMaxRetryCount();
                    z = aJF.sp();
                } else {
                    i = 1;
                    z = false;
                }
                i.Jl().a(context, new c.a().fY("sodler").dn(i).bW(false).bX(z).JY());
                if (aJF != null) {
                    i.Jl().Jp().a(new g.a() { // from class: com.kwai.sodler.kwai.a.2
                        @Override // com.kwai.sodler.lib.a.g.a
                        public final void a(f fVar, File file) {
                            a.aJF.a(fVar, file);
                        }
                    });
                }
                hasInit = true;
            } finally {
            }
        }
    }
}
