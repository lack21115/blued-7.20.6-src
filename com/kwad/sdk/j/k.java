package com.kwad.sdk.j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/k.class */
public final class k {
    private static Application aDP;

    public static Application FP() {
        checkInit();
        Application FQ = FQ();
        if (i.FO()) {
            aDP = (Application) i.wrapContextIfNeed(FQ);
        }
        return aDP;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.Application FQ() {
        /*
            android.app.Application r0 = com.kwad.sdk.j.k.aDP
            r2 = r0
            r0 = r2
            if (r0 == 0) goto La
            r0 = r2
            return r0
        La:
            android.content.Context r0 = com.kwad.sdk.service.ServiceProvider.CA()
            android.content.Context r0 = r0.getApplicationContext()
            r2 = r0
            r0 = r2
            boolean r0 = r0 instanceof android.app.Application
            if (r0 == 0) goto L23
            r0 = r2
            android.app.Application r0 = (android.app.Application) r0
            r2 = r0
        L1d:
            r0 = r2
            com.kwad.sdk.j.k.aDP = r0
            r0 = r2
            return r0
        L23:
            r0 = r2
            boolean r0 = dg(r0)
            if (r0 == 0) goto L32
            r0 = r2
            android.content.Context r0 = com.kwad.sdk.j.i.df(r0)
            r2 = r0
            goto L48
        L32:
            r0 = r2
            boolean r0 = com.kwad.sdk.j.j.dg(r0)
            if (r0 == 0) goto L41
            r0 = r2
            android.content.Context r0 = com.kwad.sdk.j.j.df(r0)
            r2 = r0
            goto L48
        L41:
            android.content.Context r0 = com.kwad.sdk.service.ServiceProvider.CA()
            android.content.Context r0 = r0.getApplicationContext()
            r2 = r0
        L48:
            r0 = r2
            boolean r0 = r0 instanceof android.app.Application
            if (r0 == 0) goto L5b
            r0 = r2
            android.app.Application r0 = (android.app.Application) r0
            r3 = r0
        L54:
            r0 = r3
            com.kwad.sdk.j.k.aDP = r0
            goto L92
        L5b:
            com.kwad.sdk.core.b.b r0 = com.kwad.sdk.core.b.b.vS()
            android.app.Application r0 = r0.getApplication()
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L69
            goto L54
        L69:
            r0 = r2
            boolean r0 = r0 instanceof android.content.ContextWrapper
            if (r0 == 0) goto L92
            r0 = r2
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            r4 = r0
            r0 = r4
            r3 = r0
            r0 = r4
            if (r0 == 0) goto L83
            r0 = r4
            android.content.Context r0 = r0.getApplicationContext()
            r3 = r0
        L83:
            r0 = r3
            boolean r0 = r0 instanceof android.app.Application
            if (r0 == 0) goto L92
            r0 = r3
            android.app.Application r0 = (android.app.Application) r0
            r3 = r0
            goto L54
        L92:
            android.app.Application r0 = com.kwad.sdk.j.k.aDP
            if (r0 != 0) goto L9e
            android.app.Application r0 = FR()
            com.kwad.sdk.j.k.aDP = r0
        L9e:
            r0 = r2
            android.app.Application r0 = dn(r0)
            r2 = r0
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.j.k.FQ():android.app.Application");
    }

    private static Application FR() {
        Application application = (Application) s.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) s.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static View a(Context context, int i, ViewGroup viewGroup, boolean z) {
        return dq(context).inflate(i, viewGroup, false);
    }

    public static void a(Application application) {
        if (aDP == null) {
            aDP = application;
        }
    }

    public static void a(LayoutInflater layoutInflater) {
        s.a(layoutInflater, "mFactory", (Object) null);
        s.a(layoutInflater, "mFactory2", (Object) null);
    }

    private static void checkInit() {
        if (e.FK().Ep()) {
            return;
        }
        ServiceProvider.b(new RuntimeException("please init KSPlugin"));
    }

    private static boolean dg(Context context) {
        return context instanceof a;
    }

    public static int di(Context context) {
        if (!(context instanceof ContextThemeWrapper)) {
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
            }
            return 0;
        }
        Object a2 = s.a((Object) context, "getThemeResId", new Object[0]);
        if (a2 != null) {
            return ((Integer) a2).intValue();
        }
        return 0;
    }

    public static Activity dj(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context dl = dl(context);
        if (dl instanceof Activity) {
            return (Activity) dl;
        }
        com.kwad.sdk.core.b.b.vS();
        return com.kwad.sdk.core.b.b.getCurrentActivity();
    }

    private static Context dk(Context context) {
        RuntimeException runtimeException;
        if (i.FO() && !dg(context)) {
            boolean hasInitFinish = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish();
            runtimeException = new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish);
        } else if (i.FO() || j.dg(context)) {
            return context;
        } else {
            boolean hasInitFinish2 = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish();
            runtimeException = new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish2);
        }
        ServiceProvider.b(runtimeException);
        return context;
    }

    public static Context dl(Context context) {
        checkInit();
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal() && !m7853do(context)) {
            return dm(dg(context) ? i.de(context) : j.unwrapContextIfNeed(context));
        }
        return context;
    }

    private static Context dm(Context context) {
        if (j.dg(context) || (context instanceof a)) {
            boolean hasInitFinish = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish();
            ServiceProvider.b(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish));
        }
        return context;
    }

    private static Application dn(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        boolean hasInitFinish = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish();
        ServiceProvider.b(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + hasInitFinish + "--isExternal:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal()));
        return null;
    }

    /* renamed from: do  reason: not valid java name */
    public static boolean m7853do(Context context) {
        return (dg(context) || j.dg(context)) ? false : true;
    }

    public static Context dp(Context context) {
        Context context2 = context;
        if (j.dg(context)) {
            context2 = j.dh(context);
        }
        Context context3 = context2;
        if (context2 instanceof a) {
            context3 = ((a) context2).getDelegatedContext();
        }
        if (m7853do(context3)) {
            return context3;
        }
        Context context4 = context3;
        for (int i = 0; i < 5; i++) {
            Context context5 = context4;
            if (j.dg(context4)) {
                context5 = j.dh(context4);
            }
            context4 = context5;
            if (context5 instanceof a) {
                context4 = ((a) context5).getDelegatedContext();
            }
            if (m7853do(context4)) {
                return context4;
            }
        }
        return context4;
    }

    public static LayoutInflater dq(Context context) {
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        boolean dg = j.dg(wrapContextIfNeed);
        LayoutInflater from = LayoutInflater.from(wrapContextIfNeed);
        if (dg) {
            a(from);
        }
        return from;
    }

    public static void g(Activity activity) {
        j.onDestroy(activity);
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        return dq(context).inflate(i, viewGroup);
    }

    public static Context wrapContextIfNeed(Context context) {
        checkInit();
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal()) {
            return dk(i.FO() ? i.wrapContextIfNeed(context) : j.wrapContextIfNeed(context));
        }
        return context;
    }

    public static void x(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }
}
