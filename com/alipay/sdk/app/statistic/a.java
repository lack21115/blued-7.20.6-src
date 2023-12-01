package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.d;
import com.alipay.sdk.packet.impl.e;
import com.alipay.sdk.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/statistic/a.class */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.sdk.app.statistic.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/statistic/a$a.class */
    public static final class C0006a {
        private static final String a = "RecordPref";
        private static final String b = "alipay_cashier_statistic_record";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.alipay.sdk.app.statistic.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/statistic/a$a$a.class */
        public static final class C0007a {
            final LinkedHashMap<String, String> a = new LinkedHashMap<>();

            C0007a() {
            }

            C0007a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            return;
                        }
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                        i = i2 + 1;
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                }
            }

            String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                    return new JSONArray().toString();
                }
            }
        }

        private C0006a() {
        }

        static int a(Context context, String str) {
            synchronized (C0006a.class) {
                try {
                    com.alipay.sdk.util.c.a(a, "stat remove " + str);
                    if (context != null && !TextUtils.isEmpty(str)) {
                        C0007a b2 = b(context);
                        if (b2.a.isEmpty()) {
                            return 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (Map.Entry<String, String> entry : b2.a.entrySet()) {
                            if (str.equals(entry.getValue())) {
                                arrayList.add(entry.getKey());
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b2.a.remove((String) it.next());
                        }
                        a(context, b2);
                        return arrayList.size();
                    }
                    return 0;
                } finally {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static String a(Context context) {
            synchronized (C0006a.class) {
                try {
                    com.alipay.sdk.util.c.a(a, "stat peek");
                    if (context == null) {
                        return null;
                    }
                    C0007a b2 = b(context);
                    if (b2.a.isEmpty()) {
                        return null;
                    }
                    return b2.a.entrySet().iterator().next().getValue();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        static String a(Context context, String str, String str2) {
            synchronized (C0006a.class) {
                try {
                    com.alipay.sdk.util.c.a(a, "stat append " + str2 + " , " + str);
                    if (context != null && !TextUtils.isEmpty(str)) {
                        String str3 = str2;
                        if (TextUtils.isEmpty(str2)) {
                            str3 = UUID.randomUUID().toString();
                        }
                        C0007a b2 = b(context);
                        if (b2.a.size() > 20) {
                            b2.a.clear();
                        }
                        b2.a.put(str3, str);
                        a(context, b2);
                        return str3;
                    }
                    return null;
                } finally {
                }
            }
        }

        private static void a(Context context, C0007a c0007a) {
            synchronized (C0006a.class) {
                C0007a c0007a2 = c0007a;
                if (c0007a == null) {
                    try {
                        c0007a2 = new C0007a();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
                j.a(null, context, b, c0007a2.a());
            }
        }

        private static C0007a b(Context context) {
            synchronized (C0006a.class) {
                try {
                    String b2 = j.b(null, context, b, null);
                    if (TextUtils.isEmpty(b2)) {
                        return new C0007a();
                    }
                    return new C0007a(b2);
                } catch (Throwable th) {
                    try {
                        com.alipay.sdk.util.c.a(th);
                        return new C0007a();
                    } finally {
                    }
                }
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/statistic/a$b.class */
    static final class b {
        private b() {
        }

        static void a(Context context) {
            synchronized (b.class) {
                try {
                    a(context, null, null);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        static void a(Context context, com.alipay.sdk.app.statistic.c cVar, String str, String str2) {
            synchronized (b.class) {
                if (context == null || cVar == null || str == null) {
                    return;
                }
                try {
                    a(context, cVar.a(str), str2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private static void a(Context context, String str, String str2) {
            synchronized (b.class) {
                if (context == null) {
                    return;
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        C0006a.a(context, str, str2);
                    }
                    new Thread(new com.alipay.sdk.app.statistic.b(str, context)).start();
                } finally {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(Context context, String str) {
            synchronized (b.class) {
                try {
                    com.alipay.sdk.util.c.a(com.alipay.sdk.cons.a.x, "stat sub " + str);
                    if ((com.alipay.sdk.data.a.j().g() ? new d() : new e()).a((com.alipay.sdk.sys.a) null, context, str) != null) {
                        C0006a.a(context, str);
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/statistic/a$c.class */
    static final class c {
        private static final String a = "alipay_cashier_statistic_v";

        c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static long a(Context context) {
            long j;
            long j2;
            synchronized (c.class) {
                try {
                    String b = j.b(null, context, a, null);
                    j = 0;
                    if (!TextUtils.isEmpty(b)) {
                        j = Long.parseLong(b);
                    }
                } catch (Throwable th) {
                    j = 0;
                }
                j2 = j + 1;
                try {
                    j.a(null, context, a, Long.toString(j2));
                } catch (Throwable th2) {
                }
            }
            return j2;
        }
    }

    private a() {
    }

    public static void a(Context context) {
        synchronized (a.class) {
            try {
                b.a(context);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context == null || aVar == null) {
                return;
            }
            try {
                C0006a.a(context, aVar.s.a(str), str2);
            } catch (Throwable th) {
                try {
                    com.alipay.sdk.util.c.a(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        aVar.s.a(str, str2);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.s.a(str, str2, str3);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th) {
        if (aVar == null) {
            return;
        }
        aVar.s.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, String str2, Throwable th, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.s.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.sys.a aVar, String str, Throwable th) {
        if (aVar == null || th == null || th.getClass() == null) {
            return;
        }
        aVar.s.a(str, th.getClass().getSimpleName(), th);
    }

    public static void b(Context context, com.alipay.sdk.sys.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context == null || aVar == null) {
                return;
            }
            try {
                b.a(context, aVar.s, str, str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(com.alipay.sdk.sys.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.s.b(str, str2, str3);
    }
}
