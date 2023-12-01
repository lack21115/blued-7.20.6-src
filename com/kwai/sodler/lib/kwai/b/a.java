package com.kwai.sodler.lib.kwai.b;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.kwai.sodler.lib.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/kwai/b/a.class */
public class a {
    private static final String CLAZZ_NAME = a.class.getName();
    private static final ThreadLocal<C0599a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwai.sodler.lib.kwai.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/kwai/b/a$a.class */
    public static final class C0599a {
        private WeakReference<Context> aaH;
        private int aaI;
        private StackTraceElement[] aaJ;
        private int aaK;
        private long aaL;

        private C0599a() {
            this.aaH = new WeakReference<>(null);
            this.aaI = 0;
            this.aaJ = null;
            this.aaK = 0;
        }

        /* synthetic */ C0599a(byte b) {
            this();
        }

        static /* synthetic */ int c(C0599a c0599a) {
            int i = c0599a.aaI;
            c0599a.aaI = i + 1;
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

        static /* synthetic */ int g(C0599a c0599a) {
            int i = c0599a.aaK;
            c0599a.aaK = i + 1;
            return i;
        }
    }

    private static Context a(String str, Context context) {
        Map<String, WeakReference<Context>> map = sResContextCache;
        WeakReference<Context> weakReference = map.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        if (fO != null) {
            if (!fO.isLoaded()) {
                return theme;
            }
            Resources resources = fO.getResources();
            if (resources != null) {
                Resources.Theme theme3 = theme2;
                if (theme2 == null) {
                    theme3 = resources.newTheme();
                    theme3.applyStyle(i, true);
                }
                return theme3;
            }
        }
        return theme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resources a(Resources resources, String str) {
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        if (fO == null || !fO.isLoaded()) {
            StringBuilder sb = new StringBuilder("replaceExternalResources pluginId: ");
            sb.append(str);
            sb.append(" , plugin: ");
            sb.append(fO);
            sb.append(", isLoaded(): false");
            return resources;
        }
        Resources resources2 = fO.getResources();
        StringBuilder sb2 = new StringBuilder("replaceExternalResources pluginId: ");
        sb2.append(str);
        sb2.append(", wrappedResources: ");
        sb2.append(resources2);
        return resources2 != null ? resources2 : resources;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        LayoutInflater layoutInflater2 = layoutInflater;
        if (fO != null) {
            if (!fO.isLoaded()) {
                return layoutInflater;
            }
            Context context = layoutInflater.getContext();
            layoutInflater2 = layoutInflater;
            if (!(context instanceof b)) {
                Context at = at(context, str);
                layoutInflater2 = layoutInflater;
                if (at instanceof b) {
                    layoutInflater2 = layoutInflater.cloneInContext(at);
                }
            }
        }
        return layoutInflater2;
    }

    private static void a(String str, Context context, Context context2) {
        Map<String, WeakReference<Context>> map = sResContextCache;
        map.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean a(String str, Context context, C0599a c0599a) {
        String str2;
        Context a2 = a(str, context);
        String name = a2 != null ? a2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, c0599a.aaJ)) {
            if (c0599a.aaJ != null) {
                c0599a.clear();
                return false;
            }
            c0599a.aaJ = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str3 : getAutoUnWrapStackList()) {
                    str2 = className.contains(str3) ? "needAutoUnWrap true 命中白名单" : "needAutoUnWrap true 命中白名单";
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
        C0599a.g(c0599a);
        c0599a.aaJ = stackTrace;
        if (c0599a.aaK < 5) {
            return false;
        }
        str2 = "needAutoUnWrap true 连续相同堆栈";
        Log.d("Solder.PluginWrapper", str2);
        return true;
    }

    public static Context at(Context context, String str) {
        if (context == null) {
            return null;
        }
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        if (fO != null) {
            if (!fO.isLoaded()) {
                return context;
            }
            if (!(context instanceof b)) {
                if (b(str, context)) {
                    return context;
                }
                Context a2 = a(str, context);
                if (a2 != null) {
                    return a2;
                }
                Context cVar = context instanceof ContextThemeWrapper ? new c((ContextThemeWrapper) context, str) : context instanceof androidx.appcompat.view.ContextThemeWrapper ? new d((androidx.appcompat.view.ContextThemeWrapper) context, str) : context instanceof ContextWrapper ? new e(context, str) : new e(context, str);
                a(str, context, cVar);
                return cVar;
            }
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader b(ClassLoader classLoader, String str) {
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        if (fO != null) {
            if (!fO.isLoaded()) {
                return classLoader;
            }
            com.kwai.sodler.lib.kwai.kwai.b Jv = fO.Jv();
            if (Jv != null) {
                return Jv;
            }
        }
        return classLoader;
    }

    private static boolean b(String str, Context context) {
        C0599a c0599a = sAutoUnWrapModelTL.get();
        if (c0599a == null) {
            sAutoUnWrapModelTL.set(new C0599a((byte) 0));
            return false;
        } else if (c0599a.aaH.get() != context || Math.abs(System.currentTimeMillis() - c0599a.aaL) >= 150) {
            c0599a.clear();
            c0599a.aaH = new WeakReference(context);
            c0599a.aaL = System.currentTimeMillis();
            return false;
        } else {
            C0599a.c(c0599a);
            if (c0599a.aaI < (context instanceof Application ? 15 : 5) || !a(str, context, c0599a)) {
                return false;
            }
            c0599a.clear();
            return true;
        }
    }

    private static boolean dg(Context context) {
        return context instanceof b;
    }

    private static Context dh(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static com.kwai.sodler.lib.kwai.a fO(String str) {
        com.kwai.sodler.lib.a.a fM = i.Jl().Jo().fM(str);
        if (fM != null && fM.isLoaded() && (fM instanceof com.kwai.sodler.lib.kwai.a)) {
            return (com.kwai.sodler.lib.kwai.a) fM;
        }
        return null;
    }

    private static List<String> getAutoUnWrapStackList() {
        if (sAutoUnWrapStackList.isEmpty()) {
            sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
        }
        return sAutoUnWrapStackList;
    }

    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = context;
        if (dg(context)) {
            context2 = dh(context);
        }
        if (!dg(context2)) {
            return context2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return context2;
            }
            context2 = dh(context2);
            if (!dg(context2)) {
                return context2;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object wrapSystemService(Object obj, String str, Context context) {
        LayoutInflater layoutInflater = obj;
        if (Context.LAYOUT_INFLATER_SERVICE.equals(str)) {
            layoutInflater = obj;
            if (obj instanceof LayoutInflater) {
                LayoutInflater layoutInflater2 = (LayoutInflater) obj;
                if (layoutInflater2.getContext() instanceof b) {
                    return layoutInflater2;
                }
                layoutInflater = layoutInflater2.cloneInContext(context);
            }
        }
        return layoutInflater;
    }
}
