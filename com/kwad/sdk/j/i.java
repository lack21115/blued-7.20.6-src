package com.kwad.sdk.j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/i.class */
public class i {
    private static final String CLAZZ_NAME = i.class.getName();
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean aDO = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/j/i$a.class */
    public static final class a {
        private WeakReference<Context> aaH;
        private int aaI;
        private StackTraceElement[] aaJ;
        private int aaK;
        private long aaL;

        private a() {
            this.aaH = new WeakReference<>(null);
            this.aaI = 0;
            this.aaJ = null;
            this.aaK = 0;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        static /* synthetic */ int c(a aVar) {
            int i = aVar.aaI;
            aVar.aaI = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aaH = new WeakReference<>(null);
            this.aaI = 0;
            this.aaJ = null;
            this.aaK = 0;
            this.aaL = 0L;
        }

        static /* synthetic */ int g(a aVar) {
            int i = aVar.aaK;
            aVar.aaK = i + 1;
            return i;
        }
    }

    public static boolean FO() {
        return aDO.get();
    }

    private static void a(final Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            com.kwad.sdk.core.b.b.vS();
            com.kwad.sdk.core.b.b.a(new com.kwad.sdk.core.b.d() { // from class: com.kwad.sdk.j.i.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
                public final void onActivityDestroyed(Activity activity) {
                    if (activity == Context.this) {
                        com.kwad.sdk.core.b.b.vS();
                        com.kwad.sdk.core.b.b.b(this);
                        i.onDestroy(Context.this);
                    }
                }
            });
        }
    }

    private static boolean a(Context context, a aVar) {
        String str;
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, aVar.aaJ)) {
            if (aVar.aaJ != null) {
                aVar.clear();
                return false;
            }
            aVar.aaJ = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str2 : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str2) && className.contains(str2)) {
                        str = "needAutoUnWrap true 命中白名单";
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                int i3 = i + 1;
                i = i3;
                if (i3 < stackTrace.length) {
                    i = i3;
                    if (CLAZZ_NAME.equals(className)) {
                        i = i3;
                        if ("wrapContextIfNeed".equals(methodName)) {
                            StackTraceElement stackTraceElement2 = stackTrace[i3];
                            i = i3;
                            if (TextUtils.equals(name, stackTraceElement2.getClassName())) {
                                i = i3;
                                if ("getBaseContext".equals(stackTraceElement2.getMethodName())) {
                                    int i4 = i2 + 1;
                                    i2 = i4;
                                    i = i3;
                                    if (i4 >= 5) {
                                        return true;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }
        a.g(aVar);
        aVar.aaJ = stackTrace;
        if (aVar.aaK < 5) {
            return false;
        }
        str = "needAutoUnWrap true 连续相同堆栈";
        Log.d("Wrapper", str);
        return true;
    }

    public static void bO(boolean z) {
        aDO.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context de(Context context) {
        Context context2 = context;
        if (context instanceof com.kwad.sdk.j.a) {
            context2 = ((com.kwad.sdk.j.a) context).getDelegatedContext();
        }
        if (k.m7853do(context2)) {
            return context2;
        }
        RuntimeException runtimeException = null;
        int i = 0;
        Context context3 = context2;
        while (true) {
            RuntimeException runtimeException2 = runtimeException;
            if (i >= 10) {
                return context3;
            }
            runtimeException = runtimeException2;
            if (runtimeException2 == null) {
                runtimeException = new RuntimeException("expect normalContext --context:" + context3.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish());
                ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(runtimeException);
            }
            Context context4 = context3;
            if (j.dg(context3)) {
                context4 = j.dh(context3);
            }
            context3 = context4;
            if (context4 instanceof com.kwad.sdk.j.a) {
                context3 = ((com.kwad.sdk.j.a) context4).getDelegatedContext();
            }
            if (k.m7853do(context3)) {
                return context3;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context df(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context applicationContext = de(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return applicationContext;
            }
            Context applicationContext2 = applicationContext.getApplicationContext();
            if (applicationContext2 instanceof Application) {
                return applicationContext2;
            }
            applicationContext = applicationContext2;
            if (applicationContext2 instanceof com.kwad.sdk.j.a) {
                applicationContext = ((com.kwad.sdk.j.a) applicationContext2).getDelegatedContext();
            }
            i = i2 + 1;
        }
    }

    private static List<String> getAutoUnWrapStackList() {
        if (sAutoUnWrapStackList.isEmpty()) {
            sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
        }
        return sAutoUnWrapStackList;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = e.FK().getClassLoader();
        return classLoader2 != null ? classLoader2 : classLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources resources = e.FK().getResources();
        if (resources != null) {
            Resources.Theme theme3 = theme2;
            if (theme2 == null) {
                theme3 = resources.newTheme();
                theme3.applyStyle(i, true);
            }
            return theme3;
        }
        return theme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        a aVar = sAutoUnWrapModelTL.get();
        if (aVar == null) {
            sAutoUnWrapModelTL.set(new a((byte) 0));
            return false;
        } else if (aVar.aaH.get() != context || Math.abs(System.currentTimeMillis() - aVar.aaL) >= 150) {
            aVar.clear();
            aVar.aaH = new WeakReference(context);
            aVar.aaL = System.currentTimeMillis();
            return false;
        } else {
            a.c(aVar);
            if (aVar.aaI < (context instanceof Application ? 15 : 5) || !a(context, aVar)) {
                return false;
            }
            aVar.clear();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context wrapContextIfNeed(Context context) {
        Context bVar;
        if (context == null) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        }
        if (((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal() && !(context instanceof com.kwad.sdk.j.a)) {
            Context context2 = sResContextCache.get(context);
            if (context2 instanceof com.kwad.sdk.j.a) {
                return context2;
            }
            Context context3 = context;
            if (j.dg(context)) {
                Context unwrapContextIfNeed = j.unwrapContextIfNeed(context);
                context3 = unwrapContextIfNeed;
                if (j.dg(unwrapContextIfNeed)) {
                    ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                    return unwrapContextIfNeed;
                }
            }
            if (returnUnWrappedContext(context3)) {
                com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
                dVar.gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context3.getClass().getName()));
                return context3;
            }
            if (context3 instanceof Application) {
                bVar = new f((Application) context3, new g(context3, e.FK()));
                k.a((Application) bVar);
            } else {
                bVar = context3 instanceof ContextThemeWrapper ? new b((ContextThemeWrapper) context3) : context3 instanceof androidx.appcompat.view.ContextThemeWrapper ? new c((androidx.appcompat.view.ContextThemeWrapper) context3) : context3 instanceof ContextWrapper ? new d(context3) : new d(context3);
            }
            a(context3, bVar);
            return bVar;
        }
        return context;
    }
}
