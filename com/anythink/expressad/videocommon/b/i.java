package com.anythink.expressad.videocommon.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.anythink.expressad.foundation.h.v;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.videocommon.b.h;
import com.anythink.expressad.videocommon.b.j;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5901a = "ending_page_source";
    public static final String b = "ending_page_save_time";

    /* renamed from: c  reason: collision with root package name */
    private static final String f5902c = "H5DownLoadManager";
    private static volatile i f;
    private CopyOnWriteArrayList<String> d;
    private ConcurrentMap<String, com.anythink.expressad.videocommon.b.d> e;
    private m g;
    private j h;
    private boolean i = false;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/i$a.class */
    public interface a {
        void a(String str);

        void a(String str, String str2);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/i$b.class */
    public interface b extends a {
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/i$c.class */
    public interface c {
        void a();

        void a(String str);

        void a(byte[] bArr, String str);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/i$d.class */
    public interface d extends a {
    }

    private i() {
        try {
            this.g = m.a();
            this.h = j.a.f5908a;
            this.d = new CopyOnWriteArrayList<>();
            this.e = new ConcurrentHashMap();
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f5902c, th.getMessage(), th);
        }
    }

    public static i a() {
        if (f == null) {
            synchronized (i.class) {
                try {
                    if (f == null) {
                        f = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    private void a(String str, d dVar) {
        try {
            if (!TextUtils.isEmpty(this.g.a(str))) {
                if (dVar != null) {
                    dVar.a(str);
                }
            } else if (!this.e.containsKey(str)) {
                com.anythink.expressad.videocommon.b.d dVar2 = new com.anythink.expressad.videocommon.b.d(this.e, this.g, dVar, str);
                this.e.put(str, dVar2);
                g.a(str, dVar2);
            } else {
                com.anythink.expressad.videocommon.b.d dVar3 = this.e.get(str);
                if (dVar3 != null) {
                    dVar3.a(dVar);
                }
            }
        } catch (Exception e) {
            if (dVar != null) {
                dVar.a(str, "downloadzip failed");
            }
            if (com.anythink.expressad.a.f4103a) {
                e.printStackTrace();
            }
        }
    }

    private static void a(String str, String str2) {
        try {
            com.anythink.expressad.foundation.h.o.b(f5902c, "sourceContent:".concat(String.valueOf(str)));
            v.a(com.anythink.expressad.foundation.b.a.b().d(), f5901a.concat(String.valueOf(str2)), str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(String str, d dVar) {
        try {
            if (!TextUtils.isEmpty(this.g.a(str))) {
                if (dVar != null) {
                    dVar.a(str);
                }
            } else if (!this.e.containsKey(str)) {
                com.anythink.expressad.videocommon.b.d dVar2 = new com.anythink.expressad.videocommon.b.d(this.e, this.g, dVar, str);
                this.e.put(str, dVar2);
                g.a(str, dVar2);
            } else {
                com.anythink.expressad.videocommon.b.d dVar3 = this.e.get(str);
                if (dVar3 != null) {
                    dVar3.a(dVar);
                }
            }
        } catch (Exception e) {
            if (dVar != null) {
                dVar.a(str, "downloadzip failed");
            }
            if (com.anythink.expressad.a.f4103a) {
                e.printStackTrace();
            }
        }
    }

    private void c(final String str, final a aVar) {
        try {
            com.anythink.expressad.foundation.h.o.d(f5902c, "download url:".concat(String.valueOf(str)));
            if (this.d.contains(str)) {
                return;
            }
            this.d.add(str);
            h.a.f5900a.a(new com.anythink.expressad.foundation.g.g.a() { // from class: com.anythink.expressad.videocommon.b.i.1
                @Override // com.anythink.expressad.foundation.g.g.a
                public final void a() {
                    if (TextUtils.isEmpty(i.this.h.b(str))) {
                        g.a(str, new c() { // from class: com.anythink.expressad.videocommon.b.i.1.1
                            @Override // com.anythink.expressad.videocommon.b.i.c
                            public final void a() {
                            }

                            @Override // com.anythink.expressad.videocommon.b.i.c
                            public final void a(String str2) {
                                try {
                                    i.this.d.remove(str);
                                    if (aVar != null) {
                                        aVar.a(str, str2);
                                    }
                                } catch (Exception e) {
                                    if (com.anythink.expressad.a.f4103a) {
                                        e.printStackTrace();
                                    }
                                    if (aVar != null) {
                                        aVar.a(str, str2);
                                    }
                                }
                            }

                            @Override // com.anythink.expressad.videocommon.b.i.c
                            public final void a(byte[] bArr, String str2) {
                                try {
                                    i.this.d.remove(str2);
                                    if (bArr == null || bArr.length <= 0) {
                                        return;
                                    }
                                    if (i.this.h.a(str2, bArr)) {
                                        if (aVar != null) {
                                            aVar.a(str2);
                                        }
                                    } else if (aVar != null) {
                                        aVar.a(str2, "save file failed");
                                    }
                                } catch (Exception e) {
                                    if (com.anythink.expressad.a.f4103a) {
                                        e.printStackTrace();
                                    }
                                    if (aVar != null) {
                                        aVar.a(str2, e.getMessage());
                                    }
                                }
                            }
                        });
                        return;
                    }
                    i.this.d.remove(str);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(str);
                    }
                }

                @Override // com.anythink.expressad.foundation.g.g.a
                public final void b() {
                }

                @Override // com.anythink.expressad.foundation.g.g.a
                public final void c() {
                }
            });
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f4103a) {
                th.printStackTrace();
            }
        }
    }

    private String d(String str) {
        j jVar = this.h;
        String str2 = str;
        if (jVar != null) {
            str2 = jVar.a(str);
        }
        return str2;
    }

    private static String e(String str) {
        try {
            Object b2 = v.b(com.anythink.expressad.foundation.b.a.b().d(), f5901a.concat(String.valueOf(str)), "");
            if (b2 == null || !(b2 instanceof String)) {
                return null;
            }
            String str2 = (String) b2;
            if (w.b(str2)) {
                return str2;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static long f(String str) {
        try {
            Object b2 = v.b(com.anythink.expressad.foundation.b.a.b().d(), b.concat(String.valueOf(str)), 0L);
            if (b2 == null || !(b2 instanceof Long)) {
                return 0L;
            }
            return ((Long) b2).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private static void g(String str) {
        try {
            v.a(com.anythink.expressad.foundation.b.a.b().d(), b.concat(String.valueOf(str)), Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void h(String str) {
        b(str, (a) null);
    }

    public final String a(String str) {
        m mVar = this.g;
        if (mVar != null) {
            return mVar.a(str);
        }
        return null;
    }

    public final void a(String str, a aVar) {
        c(str, aVar);
    }

    public final void b(String str) {
        c(str, null);
    }

    public final void b(String str, a aVar) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        a(str, (d) aVar);
                        return;
                    } else {
                        c(str, aVar);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (aVar != null) {
            aVar.a(str, "The URL does not contain a path ");
        }
    }

    public final String c(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri parse = Uri.parse(str);
                String path = parse.getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) {
                        if (path.toLowerCase().endsWith(".zip")) {
                            return a(str);
                        }
                        String str2 = str;
                        if (this.h != null) {
                            str2 = this.h.a(str);
                        }
                        return str2;
                    }
                    return str;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
