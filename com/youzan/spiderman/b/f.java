package com.youzan.spiderman.b;

import com.google.gson.reflect.TypeToken;
import com.youzan.spiderman.cache.CacheUrl;
import com.youzan.spiderman.utils.FileUtil;
import com.youzan.spiderman.utils.JsonUtil;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/b/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f41723a;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41724c = false;
    private boolean d = false;
    private g e = g.a();
    private e f = e.a();
    private d g = d.a();
    private ExecutorService h = Executors.newFixedThreadPool(1);

    private f() {
    }

    public static f a() {
        if (f41723a == null) {
            f41723a = new f();
        }
        return f41723a;
    }

    static /* synthetic */ void a(f fVar, String str, File file) {
        fVar.f41724c = true;
        if (fVar.f.b(str) == null) {
            fVar.f.b(str, Long.valueOf(file.length()));
        }
    }

    static /* synthetic */ boolean a(f fVar, boolean z) {
        fVar.b = true;
        return true;
    }

    static /* synthetic */ void b(f fVar, String str, File file) {
        fVar.f41724c = true;
        if (fVar.e.b(str) == null) {
            fVar.e.b(str, Long.valueOf(file.length()));
        }
    }

    static /* synthetic */ void c(f fVar, String str, File file) {
        fVar.f41724c = true;
        if (fVar.g.b(str) == null) {
            fVar.g.b(str, Long.valueOf(file.length()));
        }
    }

    public final void a(final CacheUrl cacheUrl, final File file) {
        this.h.execute(new Runnable() { // from class: com.youzan.spiderman.b.f.2
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.b && !f.this.d) {
                    if (cacheUrl.isImg()) {
                        f.a(f.this, cacheUrl.getMd5(), file);
                    } else if (cacheUrl.isScript()) {
                        f.b(f.this, cacheUrl.getMd5(), file);
                    }
                }
            }
        });
    }

    public final void a(final String str) {
        this.h.execute(new Runnable() { // from class: com.youzan.spiderman.b.f.3
            @Override // java.lang.Runnable
            public final void run() {
                if (f.this.b && !f.this.d) {
                    f.c(f.this, str, new File(com.youzan.spiderman.cache.g.h()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(LinkedHashMap<String, Long> linkedHashMap) {
        if (this.d) {
            return;
        }
        this.f41724c = true;
        this.e.a((LinkedHashMap) linkedHashMap);
    }

    public final void b() {
        if (this.b) {
            return;
        }
        this.h.execute(new Runnable() { // from class: com.youzan.spiderman.b.f.1
            @Override // java.lang.Runnable
            public final void run() {
                f.this.f.a((LinkedHashMap) a.a());
                f.this.e.a((LinkedHashMap) a.b());
                f.this.g.a((LinkedHashMap) a.c());
                f.a(f.this, true);
                f.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(LinkedHashMap<String, Long> linkedHashMap) {
        if (this.d) {
            return;
        }
        this.f41724c = true;
        this.f.a((LinkedHashMap) linkedHashMap);
    }

    public final void c() {
        if (this.f41724c) {
            this.h.execute(new Runnable() { // from class: com.youzan.spiderman.b.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.b) {
                        f.this.d = true;
                        try {
                            try {
                                LinkedHashMap<String, Long> b = f.this.f.b();
                                try {
                                    FileUtil.writeContentToFile(new File(com.youzan.spiderman.cache.g.e(), "lru_cache_map_image").getPath(), JsonUtil.toJson(b, new TypeToken<LinkedHashMap<String, Long>>() { // from class: com.youzan.spiderman.b.a.1
                                    }.getType()));
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                a.a(f.this.e.b());
                                LinkedHashMap<String, Long> b2 = f.this.g.b();
                                try {
                                    FileUtil.writeContentToFile(new File(com.youzan.spiderman.cache.g.e(), "lru_cache_map_html_data").getPath(), JsonUtil.toJson(b2, new TypeToken<LinkedHashMap<String, Long>>() { // from class: com.youzan.spiderman.b.a.5
                                    }.getType()));
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } finally {
                            f.this.d = false;
                        }
                    }
                }
            });
            this.f41724c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(LinkedHashMap<String, Long> linkedHashMap) {
        if (this.d) {
            return;
        }
        this.f41724c = true;
        this.g.a((LinkedHashMap) linkedHashMap);
    }

    public final void d() {
        if (this.b) {
            com.youzan.spiderman.a.c.a().a(new b());
            this.f41724c = true;
        }
    }
}
