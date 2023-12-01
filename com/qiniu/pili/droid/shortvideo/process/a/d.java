package com.qiniu.pili.droid.shortvideo.process.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.qiniu.pili.droid.shortvideo.PLBuiltinFilter;
import com.qiniu.pili.droid.shortvideo.PLGifWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.PLWatermarkSetting;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f14079a;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private PLWatermarkSetting i;
    private ConcurrentHashMap<PLGifWatermarkSetting, com.qiniu.pili.droid.shortvideo.gl.c.b> j;
    private PLWatermarkSetting k;
    private PLWatermarkSetting l;
    private com.qiniu.pili.droid.shortvideo.c.a.a m;
    private com.qiniu.pili.droid.shortvideo.gl.c.c n;
    private com.qiniu.pili.droid.shortvideo.gl.c.d o;
    private com.qiniu.pili.droid.shortvideo.gl.c.d p;
    private com.qiniu.pili.droid.shortvideo.gl.c.d q;
    private volatile boolean r;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14080c = true;
    private boolean s = true;
    private ConcurrentHashMap<String, Runnable> t = new ConcurrentHashMap<>();

    public d(Context context) {
        this.f14079a = context;
        QosManager.a(context).a(QosManager.KeyPoint.filter_init);
    }

    private void a(com.qiniu.pili.droid.shortvideo.gl.c.d dVar, PLWatermarkSetting pLWatermarkSetting, boolean z, int i, int i2) {
        dVar.c(z);
        dVar.a(pLWatermarkSetting.getAlpha() / 255.0f);
        dVar.b(pLWatermarkSetting.getX(), pLWatermarkSetting.getY());
        if (pLWatermarkSetting.getWidth() > 0.0f && pLWatermarkSetting.getHeight() > 0.0f) {
            dVar.a(pLWatermarkSetting.getWidth(), pLWatermarkSetting.getHeight());
        }
        if (z) {
            dVar.a(i, i2);
        }
        dVar.h();
    }

    private boolean a(PLGifWatermarkSetting pLGifWatermarkSetting, long j) {
        return j >= pLGifWatermarkSetting.getStartTimeMs() && j <= pLGifWatermarkSetting.getStartTimeMs() + pLGifWatermarkSetting.getDurationMs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qiniu.pili.droid.shortvideo.gl.c.d d(PLWatermarkSetting pLWatermarkSetting) {
        Bitmap bitmap = pLWatermarkSetting.getBitmap();
        Bitmap bitmap2 = bitmap;
        if (bitmap == null) {
            bitmap2 = BitmapFactory.decodeResource(this.f14079a.getResources(), pLWatermarkSetting.getResourceId());
        }
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = new com.qiniu.pili.droid.shortvideo.gl.c.d(bitmap2);
        dVar.a(pLWatermarkSetting.getAlpha() / 255.0f);
        dVar.b(pLWatermarkSetting.getX(), pLWatermarkSetting.getY());
        if (pLWatermarkSetting.getWidth() > 0.0f && pLWatermarkSetting.getHeight() > 0.0f) {
            dVar.a(pLWatermarkSetting.getWidth(), pLWatermarkSetting.getHeight());
        }
        com.qiniu.pili.droid.shortvideo.gl.c.c cVar = this.n;
        int n = cVar != null ? cVar.n() : this.d;
        com.qiniu.pili.droid.shortvideo.gl.c.c cVar2 = this.n;
        dVar.a(n, cVar2 != null ? cVar2.o() : this.e);
        dVar.b();
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.qiniu.pili.droid.shortvideo.c.a.a aVar = this.m;
        if (aVar != null) {
            aVar.f();
            this.m = null;
        }
        this.f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.qiniu.pili.droid.shortvideo.gl.c.c cVar = this.n;
        if (cVar != null) {
            cVar.f();
            this.n = null;
        }
        this.g = null;
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = this.o;
        if (dVar != null) {
            dVar.f();
            this.o = null;
        }
        this.i = null;
    }

    private void n() {
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = this.q;
        if (dVar != null) {
            dVar.f();
            this.q = null;
        }
        this.k = null;
    }

    private void o() {
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = this.p;
        if (dVar != null) {
            dVar.f();
            this.p = null;
        }
        this.l = null;
    }

    private void p() {
        ConcurrentHashMap<PLGifWatermarkSetting, com.qiniu.pili.droid.shortvideo.gl.c.b> concurrentHashMap = this.j;
        if (concurrentHashMap == null) {
            return;
        }
        for (PLGifWatermarkSetting pLGifWatermarkSetting : concurrentHashMap.keySet()) {
            this.j.get(pLGifWatermarkSetting).f();
        }
        this.j.clear();
        this.j = null;
    }

    public int a(int i) {
        return a(i, 0L, true);
    }

    public int a(int i, long j, boolean z) {
        return a(i, j, z, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
        if (r7.s != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(int r8, long r9, boolean r11, long r12) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.process.a.d.a(int, long, boolean, long):int");
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
        this.b = true;
    }

    public void a(final PLGifWatermarkSetting pLGifWatermarkSetting) {
        if (pLGifWatermarkSetting == null) {
            com.qiniu.pili.droid.shortvideo.f.e.g.d("VideoFilterManager", "addGifWatermark : PLGifWatermarkSetting is null");
            return;
        }
        ConcurrentHashMap<String, Runnable> concurrentHashMap = this.t;
        concurrentHashMap.put("add_gif_watermark" + pLGifWatermarkSetting.hashCode(), new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.j == null) {
                    d.this.j = new ConcurrentHashMap();
                }
                if (d.this.j.containsKey(pLGifWatermarkSetting)) {
                    return;
                }
                com.qiniu.pili.droid.shortvideo.gl.c.b bVar = new com.qiniu.pili.droid.shortvideo.gl.c.b(pLGifWatermarkSetting);
                bVar.a(d.this.d, d.this.e);
                bVar.b();
                d.this.j.put(pLGifWatermarkSetting, bVar);
            }
        });
    }

    public void a(final PLWatermarkSetting pLWatermarkSetting) {
        this.t.put("watermark", new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.m();
                PLWatermarkSetting pLWatermarkSetting2 = pLWatermarkSetting;
                if (pLWatermarkSetting2 != null) {
                    d.this.i = pLWatermarkSetting2;
                    d dVar = d.this;
                    dVar.o = dVar.d(pLWatermarkSetting);
                }
            }
        });
    }

    public void a(final String str, final String str2, final int i, final int i2) {
        this.r = false;
        this.t.put("mv", new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.l();
                String str3 = str;
                if (str3 == null || str2 == null) {
                    return;
                }
                d.this.g = str3;
                d.this.h = str2;
                d dVar = d.this;
                dVar.n = new com.qiniu.pili.droid.shortvideo.gl.c.c(dVar.g, d.this.h);
                d.this.n.a(i, i2);
                d.this.n.b(d.this.d, d.this.e);
            }
        });
        a(this.i);
    }

    public void a(final String str, final boolean z) {
        this.t.put("filter", new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.k();
                String str2 = str;
                if (str2 != null) {
                    d.this.f = str2;
                    d.this.f14080c = z;
                    if (d.this.f14080c) {
                        d dVar = d.this;
                        Context context = dVar.f14079a;
                        dVar.m = new com.qiniu.pili.droid.shortvideo.c.a.a(context, "filters/" + str + "/filter.png", true);
                    } else {
                        d dVar2 = d.this;
                        dVar2.m = new com.qiniu.pili.droid.shortvideo.c.a.a(dVar2.f14079a, str, false);
                    }
                    d.this.m.a(d.this.d, d.this.e);
                    if (d.this.m.b()) {
                        return;
                    }
                    com.qiniu.pili.droid.shortvideo.f.e.g.e("VideoFilterManager", "setFilter failed, filter processor setup failed!");
                    d.this.m = null;
                }
            }
        });
    }

    public void a(final Set<PLGifWatermarkSetting> set) {
        if (set == null) {
            return;
        }
        this.t.put("set_watermarks", new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.j == null) {
                    d.this.j = new ConcurrentHashMap();
                }
                d.this.j.clear();
                for (PLGifWatermarkSetting pLGifWatermarkSetting : set) {
                    com.qiniu.pili.droid.shortvideo.gl.c.b bVar = new com.qiniu.pili.droid.shortvideo.gl.c.b(pLGifWatermarkSetting);
                    bVar.a(d.this.d, d.this.e);
                    bVar.b();
                    d.this.j.put(pLGifWatermarkSetting, bVar);
                }
            }
        });
    }

    public void a(boolean z) {
        this.s = z;
    }

    public PLBuiltinFilter[] a() {
        try {
            String[] list = this.f14079a.getAssets().list("filters");
            if (list == null) {
                return null;
            }
            PLBuiltinFilter[] pLBuiltinFilterArr = new PLBuiltinFilter[list.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.length) {
                    return pLBuiltinFilterArr;
                }
                pLBuiltinFilterArr[i2] = new PLBuiltinFilter();
                pLBuiltinFilterArr[i2].setName(list[i2]);
                PLBuiltinFilter pLBuiltinFilter = pLBuiltinFilterArr[i2];
                pLBuiltinFilter.setAssetFilePath("filters/" + list[i2] + "/thumb.png");
                i = i2 + 1;
            }
        } catch (IOException e) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.g;
            eVar.e("VideoFilterManager", "get builtin filter list failed:" + e.getMessage());
            return null;
        }
    }

    public void b(final PLGifWatermarkSetting pLGifWatermarkSetting) {
        if (pLGifWatermarkSetting == null) {
            com.qiniu.pili.droid.shortvideo.f.e.g.d("VideoFilterManager", "removeGifWatermark : PLGifWatermarkSetting is null");
            return;
        }
        ConcurrentHashMap<String, Runnable> concurrentHashMap = this.t;
        concurrentHashMap.put("remove_gif_watermark" + pLGifWatermarkSetting.hashCode(), new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.qiniu.pili.droid.shortvideo.gl.c.b bVar;
                if (d.this.j == null || !d.this.j.containsKey(pLGifWatermarkSetting) || (bVar = (com.qiniu.pili.droid.shortvideo.gl.c.b) d.this.j.remove(pLGifWatermarkSetting)) == null) {
                    return;
                }
                bVar.f();
            }
        });
    }

    public void b(PLWatermarkSetting pLWatermarkSetting) {
        if (pLWatermarkSetting == null) {
            o();
            return;
        }
        boolean z = this.p == null || this.l == null;
        boolean z2 = (!z && this.l.getBitmap() == pLWatermarkSetting.getBitmap() && this.l.getResourceId() == pLWatermarkSetting.getResourceId()) ? false : true;
        com.qiniu.pili.droid.shortvideo.gl.c.c cVar = this.n;
        int n = cVar != null ? cVar.n() : this.d;
        com.qiniu.pili.droid.shortvideo.gl.c.c cVar2 = this.n;
        int o = cVar2 != null ? cVar2.o() : this.e;
        boolean z3 = (z || this.p.n() == n || this.p.o() == o) ? false : true;
        if (!z2) {
            a(this.p, pLWatermarkSetting, z3, n, o);
            return;
        }
        this.p = d(pLWatermarkSetting);
        this.l = PLWatermarkSetting.fromSetting(pLWatermarkSetting);
    }

    public void b(boolean z) {
        this.r = z;
    }

    public boolean b() {
        if (this.f == null && this.g == null && this.i == null) {
            ConcurrentHashMap<PLGifWatermarkSetting, com.qiniu.pili.droid.shortvideo.gl.c.b> concurrentHashMap = this.j;
            return (concurrentHashMap == null || concurrentHashMap.isEmpty()) ? false : true;
        }
        return true;
    }

    public void c(final PLGifWatermarkSetting pLGifWatermarkSetting) {
        if (pLGifWatermarkSetting == null) {
            com.qiniu.pili.droid.shortvideo.f.e.g.d("VideoFilterManager", "updateGifWatermark : PLGifWatermarkSetting is null");
            return;
        }
        ConcurrentHashMap<String, Runnable> concurrentHashMap = this.t;
        concurrentHashMap.put("update_gif_watermark" + pLGifWatermarkSetting.hashCode(), new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.process.a.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.j == null || !d.this.j.containsKey(pLGifWatermarkSetting)) {
                    return;
                }
                com.qiniu.pili.droid.shortvideo.gl.c.b bVar = (com.qiniu.pili.droid.shortvideo.gl.c.b) d.this.j.remove(pLGifWatermarkSetting);
                if (bVar != null) {
                    bVar.f();
                }
                com.qiniu.pili.droid.shortvideo.gl.c.b bVar2 = new com.qiniu.pili.droid.shortvideo.gl.c.b(pLGifWatermarkSetting);
                bVar2.a(d.this.d, d.this.e);
                bVar2.b();
                d.this.j.put(pLGifWatermarkSetting, bVar2);
            }
        });
    }

    public void c(PLWatermarkSetting pLWatermarkSetting) {
        if (pLWatermarkSetting == null) {
            n();
            return;
        }
        boolean z = this.q == null || this.k == null;
        boolean z2 = (!z && this.k.getBitmap() == pLWatermarkSetting.getBitmap() && this.k.getResourceId() == pLWatermarkSetting.getResourceId()) ? false : true;
        com.qiniu.pili.droid.shortvideo.gl.c.c cVar = this.n;
        int n = cVar != null ? cVar.n() : this.d;
        com.qiniu.pili.droid.shortvideo.gl.c.c cVar2 = this.n;
        int o = cVar2 != null ? cVar2.o() : this.e;
        boolean z3 = (z || this.q.n() == n || this.q.o() == o) ? false : true;
        if (!z2) {
            a(this.q, pLWatermarkSetting, z3, n, o);
            return;
        }
        this.q = d(pLWatermarkSetting);
        this.k = PLWatermarkSetting.fromSetting(pLWatermarkSetting);
    }

    public boolean c() {
        return this.f14080c;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.h;
    }

    public PLWatermarkSetting g() {
        return this.i;
    }

    public Set<PLGifWatermarkSetting> h() {
        ConcurrentHashMap<PLGifWatermarkSetting, com.qiniu.pili.droid.shortvideo.gl.c.b> concurrentHashMap = this.j;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.keySet();
    }

    public boolean i() {
        return this.b;
    }

    public void j() {
        k();
        l();
        m();
        n();
        o();
        p();
        this.d = 0;
        this.e = 0;
        this.b = false;
    }
}
