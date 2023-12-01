package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/Wrapper.class */
public class Wrapper {
    private static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    private static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    private static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    private static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    private static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    private static final String TAG = "Wrapper";
    private static final int TIMELINE_MINIWRAP = 150;
    private static final String CLAZZ_NAME = Wrapper.class.getName();
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/Wrapper$a.class */
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

    private static List<String> getAutoUnWrapStackList() {
        if (sAutoUnWrapStackList.isEmpty()) {
            sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
        }
        return sAutoUnWrapStackList;
    }

    private static boolean needAutoUnWrap(Context context, a aVar) {
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
                        if (METHOD_WRAP_CONTEXT.equals(methodName)) {
                            StackTraceElement stackTraceElement2 = stackTrace[i3];
                            i = i3;
                            if (TextUtils.equals(name, stackTraceElement2.getClassName())) {
                                i = i3;
                                if (METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName())) {
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
        Log.d(TAG, str);
        return true;
    }

    public static void onDestroy(Context context) {
        if (context == null) {
            return;
        }
        sResContextCache.remove(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        return externalClassLoader != null ? externalClassLoader : classLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : resources;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources.Theme theme3 = (Resources.Theme) com.kwad.sdk.api.c.a("WRT", theme, theme2, Integer.valueOf(i));
        if (theme3 != null) {
            return theme3;
        }
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource != null) {
            Resources.Theme theme4 = theme2;
            if (theme2 == null) {
                theme4 = externalResource.newTheme();
                theme4.applyStyle(i, true);
            }
            return theme4;
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
            if (aVar.aaI < (context instanceof Application ? 15 : 5) || !needAutoUnWrap(context, aVar)) {
                return false;
            }
            aVar.clear();
            return true;
        }
    }

    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.a("URC", context);
        if (context2 != null) {
            return context2;
        }
        ResContext resContext = null;
        if (context instanceof ResContext) {
            resContext = (ResContext) context;
        }
        Context context3 = context;
        while (true) {
            Context context4 = context3;
            if (!(context4 instanceof ContextWrapper)) {
                if (resContext != null) {
                    context = resContext.getDelegatedContext();
                }
                return context;
            } else if (context4 instanceof Activity) {
                return context4;
            } else {
                if (context4 instanceof ResContext) {
                    resContext = (ResContext) context4;
                    context3 = resContext.getDelegatedContext();
                } else {
                    context3 = ((ContextWrapper) context4).getBaseContext();
                }
            }
        }
    }

    public static Context wrapContextIfNeed(Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.a("WRC", context);
        if (context2 != null) {
            return context2;
        }
        if (Loader.get().isExternalLoaded()) {
            if (context == null) {
                return null;
            }
            if (!(context instanceof ResContext) && !returnUnWrappedContext(context)) {
                if (context instanceof ContextThemeWrapper) {
                    Context context3 = sResContextCache.get(context);
                    n nVar = context3;
                    if (context3 == null) {
                        nVar = new n((ContextThemeWrapper) context);
                        sResContextCache.put(context, nVar);
                    }
                    return nVar;
                } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                    Context context4 = sResContextCache.get(context);
                    o oVar = context4;
                    if (context4 == null) {
                        oVar = new o((androidx.appcompat.view.ContextThemeWrapper) context);
                        sResContextCache.put(context, oVar);
                    }
                    return oVar;
                } else if (context instanceof ContextWrapper) {
                    Context context5 = sResContextCache.get(context);
                    p pVar = context5;
                    if (context5 == null) {
                        pVar = new p(context);
                        sResContextCache.put(context, pVar);
                    }
                    return pVar;
                } else {
                    Context context6 = sResContextCache.get(context);
                    p pVar2 = context6;
                    if (context6 == null) {
                        pVar2 = new p(context);
                        sResContextCache.put(context, pVar2);
                    }
                    return pVar2;
                }
            }
            return context;
        }
        return context;
    }

    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) com.kwad.sdk.api.c.a("WRI", layoutInflater);
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        if (Loader.get().isExternalLoaded()) {
            Context context = layoutInflater.getContext();
            LayoutInflater layoutInflater3 = layoutInflater;
            if (!(context instanceof ResContext)) {
                Context wrapContextIfNeed = wrapContextIfNeed(context);
                layoutInflater3 = layoutInflater;
                if (wrapContextIfNeed instanceof ResContext) {
                    layoutInflater3 = layoutInflater.cloneInContext(wrapContextIfNeed);
                }
            }
            return layoutInflater3;
        }
        return layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object wrapSystemService(Object obj, String str, Context context) {
        LayoutInflater layoutInflater = obj;
        if (Context.LAYOUT_INFLATER_SERVICE.equals(str)) {
            layoutInflater = obj;
            if (obj instanceof LayoutInflater) {
                LayoutInflater layoutInflater2 = (LayoutInflater) obj;
                if (layoutInflater2.getContext() instanceof ResContext) {
                    return layoutInflater2;
                }
                layoutInflater = layoutInflater2.cloneInContext(context);
            }
        }
        return layoutInflater;
    }
}
