package com.anythink.expressad.videocommon;

import android.text.TextUtils;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5879a = "TemplateWebviewCache";
    private static ConcurrentHashMap<String, C0093a> b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, C0093a> f5880c = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0093a> d = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0093a> e = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0093a> f = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0093a> g = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0093a> h = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0093a> i = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0093a> j = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0093a> k = new ConcurrentHashMap<>();

    /* renamed from: com.anythink.expressad.videocommon.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/a$a.class */
    public static final class C0093a {

        /* renamed from: a  reason: collision with root package name */
        private WindVaneWebView f5883a;
        private boolean b;

        public final WindVaneWebView a() {
            return this.f5883a;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.f5883a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.f5883a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final void a(boolean z) {
            this.b = z;
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.f5883a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.b;
        }
    }

    public static C0093a a(int i2, c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            String aa = cVar.aa();
            if (i2 == 94) {
                if (cVar.A()) {
                    if (f5880c == null || f5880c.size() <= 0) {
                        return null;
                    }
                    return f5880c.get(aa);
                } else if (f == null || f.size() <= 0) {
                    return null;
                } else {
                    return f.get(aa);
                }
            } else if (i2 != 287) {
                if (b == null || b.size() <= 0) {
                    return null;
                }
                return b.get(aa);
            } else if (cVar.A()) {
                if (d == null || d.size() <= 0) {
                    return null;
                }
                return d.get(aa);
            } else if (g == null || g.size() <= 0) {
                return null;
            } else {
                return g.get(aa);
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f4103a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static C0093a a(String str) {
        if (h.containsKey(str)) {
            return h.get(str);
        }
        if (i.containsKey(str)) {
            return i.get(str);
        }
        if (j.containsKey(str)) {
            return j.get(str);
        }
        if (k.containsKey(str)) {
            return k.get(str);
        }
        return null;
    }

    private static ConcurrentHashMap<String, C0093a> a(int i2, boolean z) {
        return i2 != 94 ? i2 != 287 ? b : z ? d : g : z ? f5880c : f;
    }

    public static void a() {
        h.clear();
        i.clear();
    }

    public static void a(int i2) {
        try {
            if (i2 == 94) {
                if (f5880c != null) {
                    f5880c.clear();
                }
            } else if (i2 == 287 && d != null) {
                d.clear();
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f4103a) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(int i2, String str, C0093a c0093a) {
        try {
            if (i2 == 94) {
                if (f5880c == null) {
                    f5880c = new ConcurrentHashMap<>();
                }
                f5880c.put(str, c0093a);
            } else if (i2 != 287) {
            } else {
                if (d == null) {
                    d = new ConcurrentHashMap<>();
                }
                d.put(str, c0093a);
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f4103a) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(String str, C0093a c0093a, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                i.put(str, c0093a);
            } else {
                h.put(str, c0093a);
            }
        } else if (z2) {
            k.put(str, c0093a);
        } else {
            j.put(str, c0093a);
        }
    }

    private static void a(String str, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                for (Map.Entry<String, C0093a> entry : i.entrySet()) {
                    if (entry.getKey().startsWith(str)) {
                        i.remove(entry.getKey());
                    }
                }
                return;
            }
            for (Map.Entry<String, C0093a> entry2 : h.entrySet()) {
                if (entry2.getKey().startsWith(str)) {
                    h.remove(entry2.getKey());
                }
            }
        } else if (z2) {
            for (Map.Entry<String, C0093a> entry3 : k.entrySet()) {
                if (entry3.getKey().startsWith(str)) {
                    k.remove(entry3.getKey());
                }
            }
        } else {
            for (Map.Entry<String, C0093a> entry4 : j.entrySet()) {
                if (entry4.getKey().startsWith(str)) {
                    j.remove(entry4.getKey());
                }
            }
        }
    }

    public static void b() {
        j.clear();
        k.clear();
    }

    public static void b(int i2) {
        try {
            if (i2 == 94) {
                if (f != null) {
                    f.clear();
                }
            } else if (i2 != 287) {
                if (b != null) {
                    b.clear();
                }
            } else if (g != null) {
                g.clear();
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f4103a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(int i2, c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            String aa = cVar.aa();
            if (i2 == 94) {
                if (cVar.A()) {
                    if (f5880c != null) {
                        f5880c.remove(aa);
                    }
                } else if (f != null) {
                    f.remove(aa);
                }
            } else if (i2 != 287) {
                if (b != null) {
                    b.remove(aa);
                }
            } else if (cVar.A()) {
                if (d != null) {
                    d.remove(aa);
                }
            } else if (g != null) {
                g.remove(aa);
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f4103a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(int i2, String str, C0093a c0093a) {
        try {
            if (i2 == 94) {
                if (f == null) {
                    f = new ConcurrentHashMap<>();
                }
                f.put(str, c0093a);
            } else if (i2 != 287) {
                if (b == null) {
                    b = new ConcurrentHashMap<>();
                }
                b.put(str, c0093a);
            } else {
                if (g == null) {
                    g = new ConcurrentHashMap<>();
                }
                g.put(str, c0093a);
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f4103a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        if (h.containsKey(str)) {
            h.remove(str);
        }
        if (j.containsKey(str)) {
            j.remove(str);
        }
        if (i.containsKey(str)) {
            i.remove(str);
        }
        if (k.containsKey(str)) {
            k.remove(str);
        }
    }

    private static void c() {
        h.clear();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            h.clear();
        } else {
            for (String str2 : h.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    h.remove(str2);
                }
            }
        }
        i.clear();
    }

    public static void d(String str) {
        for (Map.Entry<String, C0093a> entry : h.entrySet()) {
            if (entry.getKey().contains(str)) {
                h.remove(entry.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry<String, C0093a> entry : i.entrySet()) {
            if (entry.getKey().contains(str)) {
                i.remove(entry.getKey());
            }
        }
    }

    private static void f(String str) {
        for (Map.Entry<String, C0093a> entry : j.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                j.remove(entry.getKey());
            }
        }
    }

    private static void g(String str) {
        for (Map.Entry<String, C0093a> entry : k.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                k.remove(entry.getKey());
            }
        }
    }
}
