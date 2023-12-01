package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import com.umeng.analytics.pro.bh;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m.class */
final class m {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m$a.class */
    static abstract class a<T> implements c<T> {
        c<T> ZY;

        a(c<T> cVar) {
            this.ZY = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m$b.class */
    public static final class b implements f<a.C0549a> {
        b() {
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0549a> cVar) {
            try {
                new com.kwad.sdk.api.loader.f(vVar).a(new f.a() { // from class: com.kwad.sdk.api.loader.m.b.1
                    @Override // com.kwad.sdk.api.loader.f.a
                    public final void a(a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.tn()) {
                            cVar.b(bVar.Zo);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.d.an(vVar.getContext()).cancel();
                        } catch (Throwable th) {
                        }
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m$c.class */
    public interface c<T> {
        void b(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m$d.class */
    public static final class d implements f<a.C0549a> {
        f<a.C0549a> aac;

        d(f<a.C0549a> fVar) {
            this.aac = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0549a> cVar) {
            this.aac.a(vVar, new a<a.C0549a>(cVar) { // from class: com.kwad.sdk.api.loader.m.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void b(a.C0549a c0549a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        j.a(c0549a);
                        File k = com.kwad.sdk.api.loader.h.k(vVar.getContext(), c0549a.sdkVersion);
                        i.b(c0549a.Zl, k);
                        j.a(c0549a, System.currentTimeMillis() - currentTimeMillis);
                        c0549a.Zm = k;
                        file = k;
                        cVar.b(c0549a);
                    } catch (Throwable th) {
                        j.a(c0549a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        com.kwad.sdk.api.loader.h.e(file);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m$e.class */
    public static final class e implements f<Boolean> {
        f<a.C0549a> aac;

        e(f<a.C0549a> fVar) {
            this.aac = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<Boolean> cVar) {
            this.aac.a(vVar, new c<a.C0549a>() { // from class: com.kwad.sdk.api.loader.m.e.1
                private void a(a.C0549a c0549a, int i, Throwable th) {
                    com.kwad.sdk.api.loader.h.e(c0549a.Zm);
                    j.b(c0549a, i, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void b(a.C0549a c0549a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.b(c0549a);
                        if (!com.kwad.sdk.api.loader.b.a(vVar.getContext(), getClass().getClassLoader(), c0549a.Zm.getPath(), c0549a.sdkVersion)) {
                            a(c0549a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.g.i(vVar.getContext(), c0549a.sdkVersion);
                        com.kwad.sdk.api.loader.h.e(c0549a.Zm);
                        j.b(c0549a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.b(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0549a, 2, th);
                    }
                }
            });
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m$f.class */
    public interface f<T> {
        void a(v vVar, c<T> cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m$g.class */
    public static final class g implements f<a.C0549a> {
        f<a.C0549a> aac;

        g(f<a.C0549a> fVar) {
            this.aac = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, final c<a.C0549a> cVar) {
            this.aac.a(vVar, new a<a.C0549a>(cVar) { // from class: com.kwad.sdk.api.loader.m.g.1
                private void a(a.C0549a c0549a, int i, Throwable th) {
                    com.kwad.sdk.api.loader.h.e(c0549a.Zm);
                    j.a(c0549a, i, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void b(a.C0549a c0549a) {
                    try {
                        File file = c0549a.Zm;
                        if (!r.f(file)) {
                            a(c0549a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (r.a(file, c0549a.Tf)) {
                            cVar.b(c0549a);
                        } else {
                            a(c0549a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c0549a, 3, th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/m$h.class */
    public static final class h implements f<a.C0549a> {
        f<a.C0549a> aac;

        h(f<a.C0549a> fVar) {
            this.aac = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0549a> cVar) {
            this.aac.a(vVar, new c<a.C0549a>() { // from class: com.kwad.sdk.api.loader.m.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c */
                public void b(a.C0549a c0549a) {
                    String ao = com.kwad.sdk.api.loader.g.ao(vVar.getContext());
                    String str = ao;
                    if (TextUtils.isEmpty(ao)) {
                        str = com.kwad.sdk.api.c.ti().getSDKVersion();
                    }
                    String str2 = c0549a.sdkVersion;
                    StringBuilder sb = new StringBuilder("UpgradeProducer curVersion:");
                    sb.append(str);
                    sb.append("-newVersion");
                    sb.append(str2);
                    t.a(vVar.getContext(), bh.aX, c0549a.interval);
                    t.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0549a.tm()) {
                        u.au(vVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + str);
                    } else if (com.kwad.sdk.api.loader.g.q(c0549a.sdkVersion, str) && c0549a.tl()) {
                        cVar.b(c0549a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0549a.sdkVersion + " currentDynamicVersion:" + str + " dynamicType:" + c0549a.Zk);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f<Boolean> tu() {
        return new e(new g(new d(new h(new b()))));
    }
}
