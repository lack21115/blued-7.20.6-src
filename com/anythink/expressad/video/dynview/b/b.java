package com.anythink.expressad.video.dynview.b;

import android.view.View;
import com.anythink.expressad.video.dynview.c;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f8353a;

    private b() {
    }

    public static b a() {
        b bVar;
        if (f8353a == null) {
            synchronized (b.class) {
                try {
                    if (f8353a == null) {
                        f8353a = new b();
                    }
                    bVar = f8353a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bVar;
        }
        return f8353a;
    }

    private static void a(View view) {
        new com.anythink.expressad.video.dynview.j.b().a(view);
    }

    public static void a(View view, c cVar) {
        if (cVar == null) {
            return;
        }
        int h = cVar.h();
        if (h == 1) {
            new com.anythink.expressad.video.dynview.j.b().a(view);
        } else if (h == 102 || h == 202 || h == 302 || h == 802 || h == 904) {
            new com.anythink.expressad.video.dynview.j.b().a(view, cVar);
        } else if (h == 3) {
            new com.anythink.expressad.video.dynview.j.b().b(view, cVar);
        } else if (h == 4) {
            new com.anythink.expressad.video.dynview.j.b().c(view, cVar);
        } else if (h != 5) {
        } else {
            new com.anythink.expressad.video.dynview.j.b();
        }
    }

    public static void b() {
        if (f8353a != null) {
            f8353a = null;
        }
    }

    private static void b(View view, c cVar) {
        new com.anythink.expressad.video.dynview.j.b().a(view, cVar);
    }

    private static void c() {
        new com.anythink.expressad.video.dynview.j.b();
    }

    private static void c(View view, c cVar) {
        new com.anythink.expressad.video.dynview.j.b().b(view, cVar);
    }

    private static void d(View view, c cVar) {
        new com.anythink.expressad.video.dynview.j.b().c(view, cVar);
    }
}
