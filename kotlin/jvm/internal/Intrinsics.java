package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Intrinsics.class */
public class Intrinsics {

    /* loaded from: source-3503164-dex2jar.jar:kotlin/jvm/internal/Intrinsics$Kotlin.class */
    public static class Kotlin {
        private Kotlin() {
        }
    }

    private Intrinsics() {
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public static String a(String str, Object obj) {
        return str + obj;
    }

    private static <T extends Throwable> T a(T t) {
        return (T) a((Throwable) t, Intrinsics.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
                return t;
            }
            if (str.equals(stackTrace[i3].getClassName())) {
                i = i3;
            }
            i2 = i3 + 1;
        }
    }

    public static void a() {
        throw ((KotlinNullPointerException) a(new KotlinNullPointerException()));
    }

    public static void a(int i, String str) {
        c();
    }

    public static void a(Object obj) {
        if (obj == null) {
            b();
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            a(str);
        }
    }

    public static void a(String str) {
        throw ((NullPointerException) a(new NullPointerException(str)));
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b() {
        throw ((NullPointerException) a(new NullPointerException()));
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) a(new IllegalStateException(str + " must not be null")));
    }

    public static void b(String str) {
        throw ((UninitializedPropertyAccessException) a(new UninitializedPropertyAccessException(str)));
    }

    public static void c() {
        d("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) a(new NullPointerException(str + " must not be null")));
    }

    public static void c(String str) {
        b("lateinit property " + str + " has not been initialized");
    }

    public static void d() {
        c();
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            e(str);
        }
    }

    public static void d(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            f(str);
        }
    }

    private static void e(String str) {
        throw ((IllegalArgumentException) a(new IllegalArgumentException(g(str))));
    }

    private static void f(String str) {
        throw ((NullPointerException) a(new NullPointerException(g(str))));
    }

    private static String g(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }
}
