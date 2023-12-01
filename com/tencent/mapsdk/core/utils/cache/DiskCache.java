package com.tencent.mapsdk.core.utils.cache;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mapsdk.internal.ga;
import com.tencent.mapsdk.internal.m9;
import com.tencent.mapsdk.internal.ma;
import com.tencent.mapsdk.internal.n9;
import com.tencent.mapsdk.internal.o9;
import com.tencent.mapsdk.internal.ra;
import com.tencent.mapsdk.internal.s9;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/utils/cache/DiskCache.class */
public final class DiskCache<D extends n9> extends s9<D> {
    private static final String k = "DiskCache";
    private static final String l = ".disk_idx";
    private static final String m = ".disk_idx_root";
    private static final b n = new a();
    private o9.a<c> d;
    private d e;
    private File f;
    private File g;
    private Map<String, String> h;
    private List<String> i;
    private boolean j;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/utils/cache/DiskCache$a.class */
    public static final class a implements b {
        @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.b
        public File a(String str, String str2, byte[] bArr) {
            File file = new File(str2, str);
            ga.b(file, bArr);
            return file;
        }

        @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.b
        public byte[] a(String str, File file) {
            return ga.h(file);
        }

        @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.b
        public boolean b(String str, File file) {
            return ga.d(file);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/utils/cache/DiskCache$b.class */
    public interface b {
        File a(String str, String str2, byte[] bArr);

        byte[] a(String str, File file);

        boolean b(String str, File file);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/utils/cache/DiskCache$c.class */
    public static final class c extends n9 {

        /* renamed from: a  reason: collision with root package name */
        private File f37275a;
        private int b;

        public c(File file, int i) {
            this.f37275a = file;
            this.b = i;
        }

        @Override // com.tencent.mapsdk.internal.n9
        public int a() {
            return this.b;
        }

        @Override // com.tencent.mapsdk.internal.n9
        public void a(byte[] bArr) {
        }

        @Override // com.tencent.mapsdk.internal.n9
        public byte[] b() {
            return new byte[this.b];
        }

        public String toString() {
            return this.f37275a.getName() + "," + this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/utils/cache/DiskCache$d.class */
    public static class d extends s9.d {
        public static final long k = -1;
        private File e;
        private String f;
        private b g;
        private long h;
        private final m9.b<c> i;
        private m9.b<File> j;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/core/utils/cache/DiskCache$d$a.class */
        public class a implements m9.b<c> {
            public a() {
            }

            @Override // com.tencent.mapsdk.internal.m9.b
            public boolean a(c cVar) {
                boolean z = false;
                boolean z2 = false;
                if (cVar != null) {
                    if (d.this.j != null) {
                        z2 = d.this.j.a(cVar.f37275a);
                    }
                    z = z2;
                    if (!z2) {
                        ga.d(cVar.f37275a);
                        z = true;
                    }
                }
                return z;
            }
        }

        public d() {
            super(s9.b.DISK);
            this.e = ga.e;
            this.f = "tmp";
            this.g = DiskCache.n;
            this.h = -1L;
            this.i = new a();
        }

        public d(String str) {
            super(s9.b.DISK);
            this.e = ga.e;
            this.f = "tmp";
            this.g = DiskCache.n;
            this.h = -1L;
            this.i = new a();
            this.f = str;
        }

        public d a(long j) {
            this.h = j;
            return this;
        }

        public d a(b bVar) {
            this.g = bVar;
            return this;
        }

        public d a(m9.b<File> bVar) {
            this.j = bVar;
            return this;
        }

        public d a(File file) {
            this.e = file;
            return this;
        }

        public d a(String str) {
            this.f = str;
            return this;
        }

        public File d() {
            return new File(this.e, this.f);
        }

        @Override // com.tencent.mapsdk.internal.s9.d
        public String toString() {
            return "Options{mCacheDirectory=" + this.e + ", mCacheName='" + this.f + "', fileAccessStrategy=" + this.g + "} " + super.toString();
        }
    }

    public DiskCache(d dVar) {
        super(dVar);
        this.e = dVar;
        if (dVar != null) {
            this.f = ga.a(dVar.e, this.e.f);
            boolean z = this.e.a() == -1;
            this.j = z;
            if (!z) {
                this.d = new o9.a<>(this.e.a(), this.e.i);
            }
            l();
        }
    }

    private void a(String str, c cVar) {
        if (cVar == null || cVar.f37275a == null) {
            return;
        }
        File parentFile = cVar.f37275a.getParentFile();
        File b2 = ga.b(parentFile, l);
        String str2 = str + "#" + cVar.toString();
        if (ga.d(b2, str2) == -1) {
            ra.g(k).a("index writeLine data:" + str2);
            ga.e(b2, str2);
        }
        int d2 = ga.d(this.g, parentFile.getAbsolutePath());
        if (d2 != -1) {
            String str3 = "," + str;
            String b3 = ga.b(this.g, d2);
            if (b3 != null && !b3.contains(str)) {
                ra.g(k).a("root writeAppend data:" + str3);
                ga.b(this.g, d2, "," + str);
            }
        } else {
            String str4 = parentFile.getAbsolutePath() + "#" + str;
            ra.g(k).a("root writeLine data:" + str4);
            ga.e(this.g, str4);
        }
        this.h.put(str, parentFile.getAbsolutePath());
    }

    private void b(String str) {
        String b2;
        String str2 = this.h.get(str);
        if (str2 != null) {
            ra.g(k).a("key：" + str, "dir : " + str2);
            File file = new File(new File(str2), l);
            int d2 = ga.d(file, str);
            if (d2 != -1) {
                ga.a(file, d2);
            }
            int d3 = ga.d(this.g, str2);
            if (d3 == -1 || (b2 = ga.b(this.g, d3)) == null || !b2.contains(str)) {
                return;
            }
            ga.a(this.g, d3, b2.replaceAll(str + ",", ""));
        }
    }

    private void c(String str) {
        String str2 = this.h.get(str);
        if (str2 == null || this.i.contains(str2)) {
            return;
        }
        ra.g(k).a("key：" + str, "dir : " + str2);
        List<String> g = ga.g(ga.b(new File(str2), l));
        if (g == null || g.isEmpty()) {
            return;
        }
        ra.g(k).a(g.toArray());
        if (this.d != null) {
            for (String str3 : g) {
                String[] split = str3.split("#");
                String[] split2 = split[1].split(",");
                this.d.a((o9.a<c>) split[0], (String) new c(new File(str2, split2[0]), Integer.parseInt(split2[1])));
            }
        }
        if (g.size() > 0) {
            this.i.add(str2);
        }
    }

    private void l() {
        this.g = ga.b(this.f, m);
        this.i = new ArrayList();
        this.h = new HashMap();
        List<String> g = ga.g(this.g);
        if (g != null) {
            for (String str : g) {
                if (str.length() > 0) {
                    String[] split = str.split("#");
                    if (split.length > 1) {
                        String[] split2 = split[1].split(",");
                        int length = split2.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < length) {
                                this.h.put(split2[i2], split[0]);
                                i = i2 + 1;
                            }
                        }
                    }
                }
            }
        }
        ra.a("loadRootIndex count:" + this.h.size(), "disk_cache_dir:" + this.f);
    }

    @Override // com.tencent.mapsdk.internal.m9, com.tencent.mapsdk.internal.t9
    public long a() {
        if (this.j) {
            return -1L;
        }
        return this.d.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mapsdk.internal.m9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public D a(java.lang.String r6, java.lang.Class<D> r7) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.core.utils.cache.DiskCache.a(java.lang.String, java.lang.Class):com.tencent.mapsdk.internal.n9");
    }

    @Override // com.tencent.mapsdk.internal.m9
    public void a(String str, D d2) {
        if (TextUtils.isEmpty(str) || d2 == null) {
            return;
        }
        ra.a(ma.p, str, "put");
        String a2 = this.e.c().a(str);
        byte[] b2 = d2.b();
        if (b2 != null) {
            File a3 = this.e.g.a(a2, this.f.getAbsolutePath(), b2);
            if (!this.j || this.e.h != -1) {
                c cVar = new c(a3, b2.length);
                if (!this.j) {
                    this.d.a((o9.a<c>) a2, (String) cVar);
                }
                a(a2, cVar);
            }
        }
        ra.a(ma.p, str, "put data length", Integer.valueOf(b2 == null ? 0 : b2.length));
    }

    @Override // com.tencent.mapsdk.internal.m9
    public void clear() {
        if (this.f != null) {
            if (this.j) {
                this.e.g.b(null, this.f);
                return;
            }
            this.d.b();
            this.e.g.b(null, this.f);
        }
    }

    @Override // com.tencent.mapsdk.internal.m9
    public long f() {
        if (this.j) {
            return -1L;
        }
        return this.d.h();
    }

    @Override // com.tencent.mapsdk.internal.m9
    public long getCount() {
        int size;
        if (this.j) {
            d dVar = this.e;
            if (dVar == null || dVar.h == -1) {
                return -1L;
            }
            size = this.h.size();
        } else {
            size = this.d.i().size();
        }
        return size;
    }

    @Override // com.tencent.mapsdk.internal.s9
    /* renamed from: k */
    public d i() {
        return this.e;
    }

    public void m() {
        d dVar = this.e;
        if (dVar == null || dVar.h == -1 || this.h.size() <= this.e.h) {
            return;
        }
        ra.a("cached tile count:" + this.h.size());
        Log.d("dorothy", "cached tile count:" + this.h.size());
        clear();
    }

    @Override // com.tencent.mapsdk.internal.m9
    public boolean remove(String str) {
        String a2 = this.e.c().a(str);
        File file = null;
        File file2 = null;
        if (!this.j || this.e.h != -1) {
            c(a2);
            if (!this.j) {
                c cVar = (c) this.d.b((o9.a<c>) a2);
                File file3 = null;
                if (cVar != null) {
                    file3 = cVar.f37275a;
                }
                file = file3;
                if (file3 != null) {
                    file = file3;
                    if (file3.exists()) {
                        this.d.c(a2);
                        file = file3;
                    }
                }
            }
            file2 = file;
            if (file != null) {
                file2 = file;
                if (file.exists()) {
                    b(a2);
                    file2 = file;
                }
            }
        }
        return this.e.g.b(a2, file2);
    }
}
