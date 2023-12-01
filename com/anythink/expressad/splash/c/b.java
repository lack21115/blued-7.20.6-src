package com.anythink.expressad.splash.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.splash.c.e;
import com.anythink.expressad.splash.view.ATSplashView;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f8190a = "ResManager";
    private static int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f8191c = new ConcurrentHashMap<>();

    private static com.anythink.expressad.foundation.d.c a(com.anythink.expressad.foundation.d.c cVar) {
        if (!TextUtils.isEmpty(cVar.c()) || (!TextUtils.isEmpty(cVar.d()) && cVar.d().contains("<MBTPLMARK>"))) {
            cVar.a(true);
            cVar.b(false);
            return cVar;
        }
        cVar.a(false);
        cVar.b(true);
        return cVar;
    }

    public static void a(final ATSplashView aTSplashView, final com.anythink.expressad.foundation.d.c cVar, final com.anythink.expressad.splash.view.a aVar) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.c.b.1
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str) {
                b.f8191c.put(com.anythink.expressad.foundation.d.c.this.be(), Boolean.TRUE);
                com.anythink.expressad.splash.view.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
                ATSplashView aTSplashView2 = aTSplashView;
                if (aTSplashView2 != null) {
                    aTSplashView2.setImageReady(true);
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str, String str2) {
                b.f8191c.put(com.anythink.expressad.foundation.d.c.this.be(), Boolean.FALSE);
                com.anythink.expressad.splash.view.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
                ATSplashView aTSplashView2 = aTSplashView;
                if (aTSplashView2 != null) {
                    aTSplashView2.setImageReady(false);
                }
            }
        });
        if (TextUtils.isEmpty(cVar.bd())) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.bd(), new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.splash.c.b.2
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str) {
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str, String str2) {
            }
        });
    }

    private static void a(ATSplashView aTSplashView, String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, boolean z, int i, boolean z2) {
        e.c cVar2 = new e.c();
        cVar2.c(str3);
        cVar2.b(str2);
        cVar2.a(cVar);
        cVar2.a(str);
        cVar2.b(z);
        cVar2.a(i);
        cVar2.a(z2);
        e.a.a().a(aTSplashView, cVar2, null);
    }

    public static void a(String str) {
        f8191c.remove(str);
    }

    public static boolean a(ATSplashView aTSplashView, com.anythink.expressad.foundation.d.c cVar) {
        if (aTSplashView == null) {
            o.d(f8190a, "mbSplashView  is null");
            return false;
        }
        boolean z = true;
        if (!TextUtils.isEmpty(cVar.S())) {
            z = aTSplashView.isVideoReady();
            o.d(f8190a, "======isReady isVideoReady:".concat(String.valueOf(z)));
        }
        boolean z2 = z;
        if (z) {
            z2 = z;
            if (!TextUtils.isEmpty(cVar.c())) {
                z2 = aTSplashView.isH5Ready();
                o.d(f8190a, "======isReady getAdZip:".concat(String.valueOf(z2)));
            }
        }
        boolean z3 = z2;
        if (z2) {
            z3 = z2;
            if (TextUtils.isEmpty(cVar.c())) {
                z3 = z2;
                if (!TextUtils.isEmpty(cVar.d())) {
                    z3 = aTSplashView.isH5Ready();
                    o.d(f8190a, "======isReady getAdHtml:".concat(String.valueOf(z3)));
                }
            }
        }
        boolean z4 = z3;
        if (TextUtils.isEmpty(cVar.c())) {
            z4 = z3;
            if (TextUtils.isEmpty(cVar.d())) {
                o.d(f8190a, "======isReady getAdHtml  getAdZip all are empty");
                z4 = false;
            }
        }
        if (cVar.j()) {
            z4 = false;
            if (!TextUtils.isEmpty(cVar.be())) {
                z4 = aTSplashView.isImageReady();
            }
            o.d(f8190a, "======isReady DYNAMIC VIEW and image state is : ".concat(String.valueOf(z4)));
        }
        return z4;
    }

    private static String b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return "file:///" + file.getAbsolutePath();
            }
            return "";
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e) {
                e.getMessage();
                return "";
            }
        }
    }
}
