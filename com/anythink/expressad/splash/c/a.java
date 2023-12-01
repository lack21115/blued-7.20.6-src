package com.anythink.expressad.splash.c;

import android.content.Context;
import com.anythink.core.common.b.n;
import com.anythink.expressad.splash.view.ATSplashNativeView;
import com.anythink.expressad.splash.view.ATSplashView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/a.class */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.splash.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/a$a.class */
    public static final class C0085a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f5349a = new a((byte) 0);

        C0085a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ a a() {
            return f5349a;
        }
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private static a a() {
        return C0085a.f5349a;
    }

    private static void a(Context context, ATSplashView aTSplashView, com.anythink.expressad.splash.a.b bVar, com.anythink.expressad.splash.b.a aVar) {
        try {
            ATSplashNativeView aTSplashNativeView = new ATSplashNativeView(context, aTSplashView, bVar);
            if (aVar != null) {
                aVar.a(aTSplashNativeView);
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.a("View render error.");
            }
        }
    }

    public static void a(ATSplashView aTSplashView, com.anythink.expressad.splash.a.b bVar, com.anythink.expressad.splash.b.a aVar) {
        Context context = aTSplashView.getContext();
        Context context2 = context;
        if (context == null) {
            context2 = n.a().g();
        }
        try {
            aVar.a(new ATSplashNativeView(context2, aTSplashView, bVar));
        } catch (Throwable th) {
            aVar.a("View render error.");
        }
    }
}
