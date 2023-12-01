package androidx.tracing;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/tracing/Trace.class */
public final class Trace {

    /* renamed from: a  reason: collision with root package name */
    private static long f3355a;
    private static Method b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f3356c;
    private static Method d;
    private static Method e;

    private Trace() {
    }

    private static void a(String str, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f3356c == null) {
                    f3356c = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                }
                f3356c.invoke(null, Long.valueOf(f3355a), str, Integer.valueOf(i));
            } catch (Exception e2) {
                a("asyncTraceBegin", e2);
            }
        }
    }

    private static void a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    private static boolean a() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (b == null) {
                    f3355a = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    b = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) b.invoke(null, Long.valueOf(f3355a))).booleanValue();
            } catch (Exception e2) {
                a("isTagEnabled", e2);
                return false;
            }
        }
        return false;
    }

    private static void b(String str, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (d == null) {
                    d = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                }
                d.invoke(null, Long.valueOf(f3355a), str, Integer.valueOf(i));
            } catch (Exception e2) {
                a("asyncTraceEnd", e2);
            }
        }
    }

    public static void beginAsyncSection(String str, int i) {
        try {
            if (f3356c == null) {
                TraceApi29Impl.beginAsyncSection(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError e2) {
        }
        a(str, i);
    }

    public static void beginSection(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceApi18Impl.beginSection(str);
        }
    }

    private static void c(String str, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (e == null) {
                    e = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
                }
                e.invoke(null, Long.valueOf(f3355a), str, Integer.valueOf(i));
            } catch (Exception e2) {
                a("traceCounter", e2);
            }
        }
    }

    public static void endAsyncSection(String str, int i) {
        try {
            if (d == null) {
                TraceApi29Impl.endAsyncSection(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError e2) {
        }
        b(str, i);
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceApi18Impl.endSection();
        }
    }

    public static boolean isEnabled() {
        try {
            if (b == null) {
                return android.os.Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError e2) {
        }
        return a();
    }

    public static void setCounter(String str, int i) {
        try {
            if (e == null) {
                TraceApi29Impl.setCounter(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError e2) {
        }
        c(str, i);
    }
}
