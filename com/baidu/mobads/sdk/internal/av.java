package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/av.class */
public class av {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9322a = "bqt_ad_tag";

    /* renamed from: c  reason: collision with root package name */
    private static final a[] f9323c = new a[0];
    private static final Map<String, a> d = new HashMap();
    static volatile a[] b = f9323c;
    private static final a e = new aw();

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/av$a.class */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal<String> f9324a = new ThreadLocal<>();

        private void b(int i, Throwable th, String str) {
            String str2;
            String b = b();
            if (a(b, i)) {
                String str3 = str;
                if (str != null) {
                    str3 = str;
                    if (str.length() == 0) {
                        str3 = null;
                    }
                }
                if (str3 != null) {
                    str2 = str3;
                    if (th != null) {
                        str2 = str3 + "\n" + g(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str2 = g(th);
                }
                a(i, b, str2, th);
            }
        }

        private String g(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private String g(Object[] objArr) {
            StringBuilder sb = new StringBuilder();
            int length = objArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                sb.append(objArr[i2]);
                sb.append(' ');
                i = i2 + 1;
            }
        }

        abstract String a();

        protected String a(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public void a(int i, String str) {
            b(i, null, str);
        }

        protected abstract void a(int i, String str, String str2, Throwable th);

        public void a(int i, Throwable th) {
            b(i, th, null);
        }

        public void a(int i, Throwable th, String str) {
            b(i, th, str);
        }

        public void a(int i, Object... objArr) {
            b(i, null, g(objArr));
        }

        public void a(Object obj) {
            b(3, null, b(obj));
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                c("Empty/Null json content");
                return;
            }
            try {
                String trim = str.trim();
                if (trim.startsWith("{")) {
                    b(3, null, new JSONObject(trim).toString(2));
                } else if (trim.startsWith("[")) {
                    b(3, null, new JSONArray(trim).toString(2));
                } else {
                    f("Invalid Json");
                }
            } catch (Exception e) {
                f("Invalid Json");
            }
        }

        public void a(Throwable th) {
            b(2, th, null);
        }

        public void a(Throwable th, String str) {
            b(2, th, str);
        }

        public void a(Object... objArr) {
            b(2, null, g(objArr));
        }

        protected boolean a(int i) {
            return true;
        }

        protected boolean a(String str, int i) {
            return a(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String b() {
            String str = this.f9324a.get();
            if (str != null) {
                this.f9324a.remove();
            }
            return str;
        }

        protected String b(Object obj) {
            return obj == null ? com.igexin.push.core.b.l : !obj.getClass().isArray() ? obj.toString() : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object";
        }

        public void b(String str) {
            b(2, null, str);
        }

        public void b(Throwable th) {
            b(3, th, null);
        }

        public void b(Throwable th, String str) {
            b(3, th, str);
        }

        public void b(Object... objArr) {
            b(3, null, g(objArr));
        }

        public void c(String str) {
            b(3, null, str);
        }

        public void c(Throwable th) {
            b(4, th, null);
        }

        public void c(Throwable th, String str) {
            b(4, th, str);
        }

        public void c(Object... objArr) {
            b(4, null, g(objArr));
        }

        public void d(String str) {
            b(4, null, str);
        }

        public void d(Throwable th) {
            b(5, th, null);
        }

        public void d(Throwable th, String str) {
            b(5, th, str);
        }

        public void d(Object... objArr) {
            b(5, null, g(objArr));
        }

        public void e(String str) {
            b(5, null, str);
        }

        public void e(Throwable th) {
            b(6, th, null);
        }

        public void e(Throwable th, String str) {
            b(6, th, str);
        }

        public void e(Object... objArr) {
            b(6, null, g(objArr));
        }

        public void f(String str) {
            b(6, null, str);
        }

        public void f(Throwable th) {
            b(7, th, null);
        }

        public void f(Throwable th, String str) {
            b(7, th, str);
        }

        public void f(Object... objArr) {
            b(7, null, g(objArr));
        }

        public void g(String str) {
            b(7, null, str);
        }
    }

    public static void a() {
        try {
            i("local");
            i("debug");
        } catch (Throwable th) {
        }
    }

    public static void a(int i, String str) {
        e.a(i, str);
    }

    public static void a(int i, Throwable th) {
        e.a(i, th);
    }

    public static void a(int i, Throwable th, String str) {
        e.a(i, th, str);
    }

    public static void a(int i, Object... objArr) {
        e.a(i, objArr);
    }

    public static void a(a aVar) {
        if (aVar == null || aVar == e) {
            return;
        }
        synchronized (d) {
            d.put(aVar.a(), aVar);
            b = (a[]) d.values().toArray(new a[0]);
        }
    }

    public static void a(Object obj) {
        e.a(obj);
    }

    public static void a(String str) {
        e.a(str);
    }

    public static void a(Throwable th) {
        e.a(th);
    }

    public static void a(Throwable th, String str) {
        e.a(th, str);
    }

    public static void a(boolean z) {
        try {
            a();
            if (ci.f9380a) {
                a((a) new at());
            } else if (z) {
                a((a) new as());
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Object... objArr) {
        e.a(objArr);
    }

    public static a b() {
        return e;
    }

    public static void b(a aVar) {
        i(aVar.a());
    }

    public static void b(String str) {
        e.b(str);
    }

    public static void b(Throwable th) {
        e.b(th);
    }

    public static void b(Throwable th, String str) {
        e.b(th, str);
    }

    public static void b(Object... objArr) {
        e.b(objArr);
    }

    public static a c() {
        a[] aVarArr = b;
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return e;
            }
            aVarArr[i2].f9324a.set(f9322a);
            i = i2 + 1;
        }
    }

    public static void c(String str) {
        e.c(str);
    }

    public static void c(Throwable th) {
        e.c(th);
    }

    public static void c(Throwable th, String str) {
        e.c(th, str);
    }

    public static void c(Object... objArr) {
        e.c(objArr);
    }

    public static void d() {
        synchronized (d) {
            d.clear();
            b = f9323c;
        }
    }

    public static void d(String str) {
        e.d(str);
    }

    public static void d(Throwable th) {
        e.d(th);
    }

    public static void d(Throwable th, String str) {
        e.d(th, str);
    }

    public static void d(Object... objArr) {
        e.d(objArr);
    }

    public static List<a> e() {
        List<a> unmodifiableList;
        synchronized (d) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(d.values()));
        }
        return unmodifiableList;
    }

    public static void e(String str) {
        e.e(str);
    }

    public static void e(Throwable th) {
        e.e(th);
    }

    public static void e(Throwable th, String str) {
        e.e(th, str);
    }

    public static void e(Object... objArr) {
        e.e(objArr);
    }

    public static int f() {
        int size;
        synchronized (d) {
            size = d.size();
        }
        return size;
    }

    public static void f(String str) {
        e.f(str);
    }

    public static void f(Throwable th) {
        e.f(th);
    }

    public static void f(Throwable th, String str) {
        e.f(th, str);
    }

    public static void f(Object... objArr) {
        e.f(objArr);
    }

    public static void g(String str) {
        e.g(str);
    }

    public static a h(String str) {
        a[] aVarArr = b;
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return e;
            }
            aVarArr[i2].f9324a.set(str);
            i = i2 + 1;
        }
    }

    public static void i(String str) {
        synchronized (d) {
            if (d.remove(str) == null) {
                return;
            }
            b = (a[]) d.values().toArray(new a[0]);
        }
    }
}
