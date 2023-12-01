package com.anythink.core.common.a;

import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.c.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/a/j.class */
public class j {
    private static volatile j b;
    private long e;

    /* renamed from: a  reason: collision with root package name */
    final String f6459a = j.class.getSimpleName();
    private long f = 0;

    /* renamed from: c  reason: collision with root package name */
    private m f6460c = m.a(com.anythink.core.common.c.c.a(n.a().g()));
    private Map<String, Integer> d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.a.j$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/a/j$2.class */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f6462a;

        AnonymousClass2(i iVar) {
            this.f6462a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                File file = new File(this.f6462a.b());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
            }
            j.this.f6460c.c(this.f6462a.a());
        }
    }

    private j() {
        this.e = 209715200L;
        this.e = n.a().d(4);
    }

    public static j a() {
        if (b == null) {
            synchronized (j.class) {
                try {
                    if (b == null) {
                        b = new j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private void a(i iVar) {
        if (iVar == null) {
            return;
        }
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass2(iVar));
    }

    public final i a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f6460c.a(str);
    }

    public final void a(final String str, final String str2, final long j, final long j2, final int i, boolean z) {
        this.d.put(str, Integer.valueOf(i));
        if (z) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.a.j.3
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.f6460c.a(str, str2, j, j2, i);
                }
            });
        }
    }

    public final boolean a(String str, int i) {
        boolean z;
        synchronized (this) {
            z = b(str) >= i;
        }
        return z;
    }

    public final int b(String str) {
        synchronized (this) {
            if (this.d.containsKey(str) && this.d.get(str) != null) {
                return this.d.get(str).intValue();
            }
            i a2 = this.f6460c.a(str);
            if (a2 == null || a2.c() <= 0) {
                return 0;
            }
            File file = new File(a2.b());
            if (!file.exists() || file.length() < a2.e()) {
                if (a2 != null) {
                    com.anythink.core.common.k.b.a.a().a(new AnonymousClass2(a2));
                }
                return 0;
            }
            this.d.put(str, Integer.valueOf(a2.c()));
            this.f6460c.b(str);
            return a2.c();
        }
    }

    public final void b() {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.a.j.1
            @Override // java.lang.Runnable
            public final void run() {
                new ArrayList();
                j jVar = j.this;
                jVar.f = jVar.f6460c.c();
                StringBuilder sb = new StringBuilder("recycleSpace check curDownloadedVideoFileSize:");
                sb.append(j.this.f);
                sb.append(",MAX_VIDEO_CACHE_SIZE:");
                sb.append(j.this.e);
                if (j.this.f > j.this.e) {
                    List<i> d = j.this.f6460c.d();
                    new StringBuilder("recycleSpace start to delete video file,file list size:").append(d.size());
                    for (i iVar : d) {
                        try {
                            File file = new File(iVar.b());
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (Throwable th) {
                        }
                        try {
                            if (!TextUtils.isEmpty(iVar.a())) {
                                String a2 = iVar.a();
                                j.this.d.remove(a2);
                                com.anythink.core.common.res.a.c.a().b(a2);
                            }
                        } catch (Throwable th2) {
                        }
                    }
                }
            }
        });
    }

    public final long c() {
        return this.e;
    }

    public final long d() {
        return this.f;
    }
}
