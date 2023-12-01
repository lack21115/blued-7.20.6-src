package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.jy;
import com.amap.api.col.p0003sl.kb;
import com.anythink.expressad.exoplayer.g.b.i;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.cdo.oaps.ad.OapsWrapper;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.hp  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp.class */
public final class hp {
    private static volatile boolean C = false;

    /* renamed from: a  reason: collision with root package name */
    public static int f5080a = -1;
    public static String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static Context f5081c;
    private static String k = "6";
    private static String l = "4";
    private static String m = "9";
    private static String n = "8";
    private static volatile boolean o = true;
    private static Vector<e> p = new Vector<>();
    private static Map<String, Integer> q = new HashMap();
    private static String r = null;
    private static long s = 0;
    public static volatile boolean d = false;
    private static volatile ConcurrentHashMap<String, Long> t = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, Long> u = new ConcurrentHashMap<>(8);
    private static volatile ConcurrentHashMap<String, d> v = new ConcurrentHashMap<>(8);
    private static boolean w = false;
    public static int e = 5000;
    public static boolean f = true;
    public static boolean g = false;
    private static int x = 3;
    public static boolean h = true;
    public static boolean i = false;
    private static int y = 3;
    public static boolean j = false;
    private static ConcurrentHashMap<String, Boolean> z = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ArrayList<jy.a> B = new ArrayList<>();
    private static Queue<jy.c> D = new LinkedList();

    /* renamed from: com.amap.api.col.3sl.hp$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp$a.class */
    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.amap.api.col.3sl.hp$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp$b.class */
    public static final class b {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f5084a;
        @Deprecated
        public JSONObject b;

        /* renamed from: c  reason: collision with root package name */
        public String f5085c;
        public int d = -1;
        public long e = 0;
        public JSONObject f;
        public a g;
        public C0056b h;
        private boolean i;

        /* renamed from: com.amap.api.col.3sl.hp$b$a */
        /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp$b$a.class */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f5086a;
            public boolean b;

            /* renamed from: c  reason: collision with root package name */
            public JSONObject f5087c;
        }

        /* renamed from: com.amap.api.col.3sl.hp$b$b  reason: collision with other inner class name */
        /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp$b$b.class */
        public static final class C0056b {

            /* renamed from: a  reason: collision with root package name */
            public boolean f5088a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.hp$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp$c.class */
    public static final class c extends jv {
        private String h;
        private Map<String, String> i;
        private String j;
        private String k;
        private String l;

        c(Context context, ia iaVar, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, iaVar);
            this.h = str;
            this.i = map;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            setHttpProtocol(kb.c.HTTPS);
            setDegradeAbility(kb.a.FIX);
        }

        private static String a(String str, String str2) {
            String str3 = str;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    str3 = Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString();
                }
                return str3;
            } catch (Throwable th) {
                return str;
            }
        }

        @Override // com.amap.api.col.p0003sl.jv
        public final byte[] c() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.jv
        public final byte[] d() {
            String u = hs.u(this.f5232a);
            String str = u;
            if (!TextUtils.isEmpty(u)) {
                str = hw.b(new StringBuilder(u).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.h) ? "" : this.h);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.b.a());
            hashMap.put("version", this.b.b());
            hashMap.put(MediaStore.EXTRA_OUTPUT, "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", str);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.i;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.i);
            }
            hashMap.put("abitype", ib.a(this.f5232a));
            hashMap.put("ext", this.b.d());
            return ib.a(ib.a(hashMap));
        }

        @Override // com.amap.api.col.p0003sl.jv
        protected final String e() {
            return "3.0";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.col.p0003sl.kb
        public final String getIPDNSName() {
            return !TextUtils.isEmpty(this.l) ? this.l : super.getIPDNSName();
        }

        @Override // com.amap.api.col.p0003sl.hv, com.amap.api.col.p0003sl.kb
        public final String getIPV6URL() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.k);
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.l)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.l);
            return hashMap;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getURL() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.hp$d */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        ia f5089a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        a f5090c;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    /* renamed from: com.amap.api.col.3sl.hp$e */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp$e.class */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private String f5091a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private AtomicInteger f5092c;

        public e(String str, String str2, int i) {
            this.f5091a = str;
            this.b = str2;
            this.f5092c = new AtomicInteger(i);
        }

        public static e b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable th) {
                return null;
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f5092c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void a(String str) {
            this.b = str;
        }

        public final String b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f5091a);
                jSONObject.put("f", this.b);
                jSONObject.put("h", this.f5092c.get());
                return jSONObject.toString();
            } catch (Throwable th) {
                return "";
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.hp$f */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hp$f.class */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f5093a = true;
        public static boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public static boolean f5094c = true;
        public static int d = 0;
        public static boolean e = false;
        public static int f;
    }

    public static b a(Context context, ia iaVar, String str, String str2, String str3, String str4) {
        return a(context, iaVar, str, null, str2, str3, str4);
    }

    public static b a(Context context, ia iaVar, String str, Map<String, String> map) {
        return b(context, iaVar, str, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.p0003sl.hp.b a(android.content.Context r10, com.amap.api.col.p0003sl.ia r11, java.lang.String r12, java.util.Map<java.lang.String, java.lang.String> r13, java.lang.String r14, java.lang.String r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 1121
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.hp.a(android.content.Context, com.amap.api.col.3sl.ia, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.3sl.hp$b");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.p0003sl.hp.e a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.Class<com.amap.api.col.3sl.hp> r0 = com.amap.api.col.p0003sl.hp.class
            monitor-enter(r0)
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La8
            if (r0 != 0) goto L41
            r0 = 0
            r9 = r0
        Lc:
            r0 = r9
            java.util.Vector<com.amap.api.col.3sl.hp$e> r1 = com.amap.api.col.p0003sl.hp.p     // Catch: java.lang.Throwable -> La8
            int r1 = r1.size()     // Catch: java.lang.Throwable -> La8
            if (r0 >= r1) goto L41
            java.util.Vector<com.amap.api.col.3sl.hp$e> r0 = com.amap.api.col.p0003sl.hp.p     // Catch: java.lang.Throwable -> La8
            r1 = r9
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> La8
            com.amap.api.col.3sl.hp$e r0 = (com.amap.api.col.p0003sl.hp.e) r0     // Catch: java.lang.Throwable -> La8
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L3a
            r0 = r7
            r1 = r11
            java.lang.String r1 = com.amap.api.col.p0003sl.hp.e.c(r1)     // Catch: java.lang.Throwable -> La8
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> La8
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L3a
            goto L44
        L3a:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto Lc
        L41:
            r0 = 0
            r11 = r0
        L44:
            r0 = r11
            if (r0 == 0) goto L4f
            java.lang.Class<com.amap.api.col.3sl.hp> r0 = com.amap.api.col.p0003sl.hp.class
            monitor-exit(r0)
            r0 = r11
            return r0
        L4f:
            r0 = r6
            if (r0 != 0) goto L58
            java.lang.Class<com.amap.api.col.3sl.hp> r0 = com.amap.api.col.p0003sl.hp.class
            monitor-exit(r0)
            r0 = 0
            return r0
        L58:
            r0 = r6
            r1 = r8
            r2 = r7
            java.lang.String r3 = ""
            java.lang.String r0 = com.amap.api.col.p0003sl.jj.b(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> La8
            com.amap.api.col.3sl.hp$e r0 = com.amap.api.col.p0003sl.hp.e.b(r0)     // Catch: java.lang.Throwable -> La8
            r8 = r0
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La8
            java.lang.String r1 = "yyyyMMdd"
            java.lang.String r0 = com.amap.api.col.p0003sl.ib.a(r0, r1)     // Catch: java.lang.Throwable -> La8
            r11 = r0
            r0 = r8
            r6 = r0
            r0 = r8
            if (r0 != 0) goto L81
            com.amap.api.col.3sl.hp$e r0 = new com.amap.api.col.3sl.hp$e     // Catch: java.lang.Throwable -> La8
            r1 = r0
            r2 = r7
            r3 = r11
            r4 = 0
            r1.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> La8
            r6 = r0
        L81:
            r0 = r11
            r1 = r6
            java.lang.String r1 = com.amap.api.col.p0003sl.hp.e.a(r1)     // Catch: java.lang.Throwable -> La8
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> La8
            if (r0 != 0) goto L9b
            r0 = r6
            r1 = r11
            r0.a(r1)     // Catch: java.lang.Throwable -> La8
            r0 = r6
            java.util.concurrent.atomic.AtomicInteger r0 = com.amap.api.col.p0003sl.hp.e.b(r0)     // Catch: java.lang.Throwable -> La8
            r1 = 0
            r0.set(r1)     // Catch: java.lang.Throwable -> La8
        L9b:
            java.util.Vector<com.amap.api.col.3sl.hp$e> r0 = com.amap.api.col.p0003sl.hp.p     // Catch: java.lang.Throwable -> La8 java.lang.Throwable -> La8
            r1 = r6
            boolean r0 = r0.add(r1)     // Catch: java.lang.Throwable -> La8
            java.lang.Class<com.amap.api.col.3sl.hp> r0 = com.amap.api.col.p0003sl.hp.class
            monitor-exit(r0)
            r0 = r6
            return r0
        La8:
            r6 = move-exception
            java.lang.Class<com.amap.api.col.3sl.hp> r0 = com.amap.api.col.p0003sl.hp.class
            monitor-exit(r0)
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.hp.a(android.content.Context, java.lang.String, java.lang.String):com.amap.api.col.3sl.hp$e");
    }

    public static void a(Context context) {
        if (context != null) {
            f5081c = context.getApplicationContext();
        }
    }

    private static void a(Context context, ia iaVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", iaVar.a());
        hashMap.put("amap_sdk_version", iaVar.c());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            kj kjVar = new kj(context, "core", "2.0", "O001");
            kjVar.a(jSONObject);
            kk.a(kjVar, context);
        } catch (hn e2) {
        }
    }

    public static void a(Context context, ia iaVar, String str, a aVar) {
        synchronized (hp.class) {
            if (context == null || iaVar == null) {
                return;
            }
            try {
                if (f5081c == null) {
                    f5081c = context.getApplicationContext();
                }
                String a2 = iaVar.a();
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                a(iaVar);
                if (v == null) {
                    v = new ConcurrentHashMap<>(8);
                }
                if (u == null) {
                    u = new ConcurrentHashMap<>(8);
                }
                if (t == null) {
                    t = new ConcurrentHashMap<>(8);
                }
                if (!v.containsKey(a2)) {
                    d dVar = new d((byte) 0);
                    dVar.f5089a = iaVar;
                    dVar.b = str;
                    dVar.f5090c = aVar;
                    v.put(a2, dVar);
                    t.put(a2, Long.valueOf(jj.b(f5081c, "open_common", a2)));
                    d(f5081c);
                }
            } catch (Throwable th) {
                try {
                    it.a(th, "at", "rglc");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0491 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x037b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r5, com.amap.api.col.p0003sl.ia r6, java.lang.String r7, com.amap.api.col.p0003sl.hp.b r8, org.json.JSONObject r9) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.hp.a(android.content.Context, com.amap.api.col.3sl.ia, java.lang.String, com.amap.api.col.3sl.hp$b, org.json.JSONObject):void");
    }

    private static void a(Context context, ia iaVar, Throwable th) {
        a(context, iaVar, th.getMessage());
    }

    public static void a(Context context, String str) {
        ho.a(context, str);
    }

    private static void a(Context context, String str, String str2, e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f5091a)) {
            return;
        }
        String b2 = eVar.b();
        if (TextUtils.isEmpty(b2) || context == null) {
            return;
        }
        SharedPreferences.Editor a2 = jj.a(context, str2);
        a2.putString(str, b2);
        jj.a(a2);
    }

    private static void a(ia iaVar) {
        if (iaVar != null) {
            try {
                if (TextUtils.isEmpty(iaVar.a())) {
                    return;
                }
                String c2 = iaVar.c();
                String str = c2;
                if (TextUtils.isEmpty(c2)) {
                    str = iaVar.b();
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ip.a(iaVar.a(), str);
            } catch (Throwable th) {
            }
        }
    }

    public static void a(jy.c cVar) {
        if (cVar == null || f5081c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", cVar.f5247c);
        hashMap.put("hostname", cVar.e);
        hashMap.put(OapsWrapper.KEY_PATH, cVar.d);
        hashMap.put("csid", cVar.f5246a);
        hashMap.put("degrade", String.valueOf(cVar.b.a()));
        hashMap.put("errorcode", String.valueOf(cVar.m));
        hashMap.put("errorsubcode", String.valueOf(cVar.n));
        hashMap.put("connecttime", String.valueOf(cVar.h));
        hashMap.put("writetime", String.valueOf(cVar.i));
        hashMap.put("readtime", String.valueOf(cVar.j));
        hashMap.put("datasize", String.valueOf(cVar.l));
        hashMap.put("totaltime", String.valueOf(cVar.f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--埋点--".concat(String.valueOf(jSONObject));
        jy.b();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            kj kjVar = new kj(f5081c, "core", "2.0", "O008");
            kjVar.a(jSONObject);
            kk.a(kjVar, f5081c);
        } catch (hn e2) {
        }
    }

    private static void a(String str, String str2) {
        e a2 = a(f5081c, str, str2);
        String a3 = ib.a(System.currentTimeMillis(), "yyyyMMdd");
        if (!a3.equals(a2.b)) {
            a2.a(a3);
            a2.f5092c.set(0);
        }
        a2.f5092c.incrementAndGet();
        a(f5081c, str, str2, a2);
    }

    public static void a(final String str, boolean z2, final String str2, final String str3, final String str4) {
        synchronized (hp.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (u == null) {
                    u = new ConcurrentHashMap<>(8);
                }
                u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (v == null) {
                    return;
                }
                if (v.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z2) {
                        jx.a(true, str);
                    }
                    lb.a().a(new lc() { // from class: com.amap.api.col.3sl.hp.1
                        @Override // com.amap.api.col.p0003sl.lc
                        public final void runTask() {
                            d dVar = (d) hp.v.get(String.this);
                            if (dVar == null) {
                                return;
                            }
                            a aVar = dVar.f5090c;
                            b a2 = hp.a(hp.f5081c, dVar.f5089a, dVar.b, str2, str3, str4);
                            if (a2 == null || aVar == null) {
                                return;
                            }
                            aVar.a(a2);
                        }
                    });
                }
            } catch (Throwable th) {
                try {
                    it.a(th, "at", "lca");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void a(String str, boolean z2, boolean z3, boolean z4) {
        if (TextUtils.isEmpty(str) || f5081c == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", String.valueOf(z2));
        hashMap.put("ant", hs.o(f5081c) == 0 ? "0" : "1");
        if (z4) {
            hashMap.put("type", z2 ? m : n);
        } else {
            hashMap.put("type", z2 ? k : l);
        }
        hashMap.put("status", z3 ? "0" : "1");
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            kj kjVar = new kj(f5081c, "core", "2.0", "O002");
            kjVar.a(jSONObject);
            kk.a(kjVar, f5081c);
        } catch (hn e2) {
        }
    }

    public static void a(boolean z2, jy.a aVar) {
        if (!C || aVar == null) {
            return;
        }
        synchronized (B) {
            if (z2) {
                Iterator<jy.a> it = B.iterator();
                while (it.hasNext()) {
                    jy.a next = it.next();
                    if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                        if (next.j == aVar.j) {
                            it.remove();
                            jy.b();
                        } else {
                            next.j.set(next.j.get() - aVar.j.get());
                            jy.b();
                        }
                    }
                }
            }
            C = false;
            Iterator<jy.a> it2 = B.iterator();
            jy.b();
            while (it2.hasNext()) {
                jy.a next2 = it2.next();
                StringBuilder sb = new StringBuilder("----path=");
                sb.append(next2.e);
                sb.append("-counts=");
                sb.append(next2.j);
                sb.append("-code=");
                sb.append(next2.f);
                sb.append(i.f7358a);
                jy.b();
            }
            jy.b();
        }
    }

    public static void a(boolean z2, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            jy.b();
            if (f || z2) {
                if ((i || !z2) && !TextUtils.isEmpty(str)) {
                    if (z2) {
                        if (A.get(str) != null) {
                            return;
                        }
                        A.put(str, Boolean.TRUE);
                        a(b(str, "a15"), "open_common");
                    } else if (z.get(str) != null) {
                    } else {
                        z.put(str, Boolean.TRUE);
                        a(b(str, "a14"), "open_common");
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public static boolean a() {
        e a2;
        if (f5081c != null) {
            i();
            if (!c()) {
                return false;
            }
            if (b()) {
                return true;
            }
        }
        return o && (a2 = a(f5081c, "IPV6_CONFIG_NAME", "open_common")) != null && a2.a() < 5;
    }

    public static boolean a(String str) {
        synchronized (hp.class) {
            try {
            } finally {
                try {
                    return false;
                } finally {
                }
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (v == null) {
                return false;
            }
            if (u == null) {
                u = new ConcurrentHashMap<>(8);
            }
            if (v.containsKey(str) && !u.containsKey(str)) {
                u.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static boolean a(String str, long j2) {
        boolean z2;
        synchronized (hp.class) {
            try {
            } catch (Throwable th) {
                z2 = false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            z2 = false;
            if (j2 > c(str)) {
                long j3 = 0;
                if (u != null) {
                    j3 = 0;
                    if (u.containsKey(str)) {
                        j3 = u.get(str).longValue();
                    }
                }
                z2 = false;
                if (SystemClock.elapsedRealtime() - j3 > 30000) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    public static boolean a(String str, boolean z2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z2;
            }
            String[] split = URLDecoder.decode(str).split(BridgeUtil.SPLIT_MARK);
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable th) {
            return z2;
        }
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static b b(Context context, ia iaVar, String str, Map<String, String> map) {
        return a(context, iaVar, str, map, null, null, null);
    }

    private static String b(String str, String str2) {
        String a2 = hw.a(str.getBytes());
        return str2 + BridgeUtil.UNDERLINE_STR + a2;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        o = jj.a(context, "open_common", "a2", true);
    }

    public static void b(jy.c cVar) {
        boolean z2;
        synchronized (B) {
            int i2 = 0;
            boolean z3 = false;
            while (true) {
                z2 = z3;
                if (i2 >= B.size()) {
                    break;
                }
                jy.a aVar = B.get(i2);
                boolean z4 = z2;
                if (cVar.f5247c.equals(aVar.b)) {
                    z4 = z2;
                    if (cVar.d.equals(aVar.e)) {
                        z4 = z2;
                        if (cVar.m == aVar.f) {
                            if (aVar.f == 1) {
                                aVar.i = ((aVar.j.get() * aVar.i) + cVar.f) / (aVar.j.get() + 1);
                            }
                            aVar.j.getAndIncrement();
                            z4 = true;
                        }
                    }
                }
                i2++;
                z3 = z4;
            }
            if (!z2) {
                B.add(new jy.a(cVar));
            }
            jy.b();
        }
    }

    public static void b(String str) {
        synchronized (hp.class) {
            try {
                if (u == null) {
                    return;
                }
                if (u.containsKey(str)) {
                    u.remove(str);
                }
            } finally {
            }
        }
    }

    private static void b(String str, long j2) {
        synchronized (hp.class) {
            try {
                if (v != null && v.containsKey(str)) {
                    if (t == null) {
                        t = new ConcurrentHashMap<>(8);
                    }
                    t.put(str, Long.valueOf(j2));
                    if (f5081c != null) {
                        SharedPreferences.Editor a2 = jj.a(f5081c, "open_common");
                        jj.a(a2, str, j2);
                        jj.a(a2);
                    }
                }
            } catch (Throwable th) {
                try {
                    it.a(th, "at", "ucut");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void b(String str, boolean z2) {
        synchronized (hp.class) {
            try {
                a(str, z2, (String) null, (String) null, (String) null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        Integer num;
        Context context = f5081c;
        if (context == null) {
            return false;
        }
        String t2 = hs.t(context);
        return (TextUtils.isEmpty(t2) || (num = q.get(t2.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static long c(String str) {
        synchronized (hp.class) {
            try {
                if (t == null) {
                    t = new ConcurrentHashMap<>(8);
                }
                if (t.containsKey(str)) {
                    return t.get(str).longValue();
                }
            } catch (Throwable th) {
                try {
                    it.a(th, "at", "glcut");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return 0L;
        }
    }

    private static void c(Context context) {
        if (context == null) {
            return;
        }
        f = jj.a(context, "open_common", "a13", true);
        h = jj.a(context, "open_common", "a6", true);
        g = jj.a(context, "open_common", "a7", false);
        e = jj.a(context, "open_common", "a8", 5000);
        x = jj.a(context, "open_common", "a9", 3);
        i = jj.a(context, "open_common", "a10", false);
        y = jj.a(context, "open_common", "a11", 3);
        j = jj.a(context, "open_common", "a12", false);
    }

    public static void c(jy.c cVar) {
        if (cVar != null && j) {
            synchronized (D) {
                D.offer(cVar);
                jy.b();
            }
        }
    }

    public static boolean c() {
        Integer num;
        Context context = f5081c;
        if (context == null) {
            return false;
        }
        String t2 = hs.t(context);
        return (TextUtils.isEmpty(t2) || (num = q.get(t2.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static void d() {
        try {
            e a2 = a(f5081c, "IPV6_CONFIG_NAME", "open_common");
            String a3 = ib.a(System.currentTimeMillis(), "yyyyMMdd");
            if (!a3.equals(a2.b)) {
                a2.a(a3);
                a2.f5092c.set(0);
            }
            a2.f5092c.incrementAndGet();
            a(f5081c, "IPV6_CONFIG_NAME", "open_common", a2);
        } catch (Throwable th) {
        }
    }

    private static void d(Context context) {
        try {
            if (w) {
                return;
            }
            ip.d = jj.a(context, "open_common", "a4", true);
            ip.e = jj.a(context, "open_common", "a5", true);
            w = true;
        } catch (Throwable th) {
        }
    }

    public static boolean d(String str) {
        e a2;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f) {
                if (z.get(str) == null) {
                    if (f5081c == null || (a2 = a(f5081c, b(str, "a14"), "open_common")) == null) {
                        return true;
                    }
                    return a2.a() < x;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return true;
        }
    }

    public static void e() {
        if (d) {
            return;
        }
        try {
            Context context = f5081c;
            if (context == null) {
                return;
            }
            d = true;
            hu.a().a(context);
            b(context);
            c(context);
            f.f5093a = jj.a(context, "open_common", "ucf", f.f5093a);
            f.b = jj.a(context, "open_common", "fsv2", f.b);
            f.f5094c = jj.a(context, "open_common", "usc", f.f5094c);
            f.d = jj.a(context, "open_common", "umv", f.d);
            f.e = jj.a(context, "open_common", "ust", f.e);
            f.f = jj.a(context, "open_common", "ustv", f.f);
        } catch (Throwable th) {
        }
    }

    public static boolean e(String str) {
        e a2;
        try {
            if (!TextUtils.isEmpty(str) && i) {
                if (A.get(str) == null) {
                    if (f5081c == null || (a2 = a(f5081c, b(str, "a15"), "open_common")) == null) {
                        return true;
                    }
                    return a2.a() < y;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static jy.a f() {
        if (C) {
            return null;
        }
        synchronized (B) {
            if (C) {
                return null;
            }
            Collections.sort(B);
            if (B.size() > 0) {
                jy.a clone = B.get(0).clone();
                C = true;
                return clone;
            }
            return null;
        }
    }

    public static jy.c g() {
        synchronized (D) {
            jy.c poll = D.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    private static void i() {
        try {
            if (f5081c != null) {
                String t2 = hs.t(f5081c);
                if (!TextUtils.isEmpty(r) && !TextUtils.isEmpty(t2) && r.equals(t2) && System.currentTimeMillis() - s < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(t2)) {
                    r = t2;
                }
            } else if (System.currentTimeMillis() - s < 10000) {
                return;
            }
            s = System.currentTimeMillis();
            q.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    int i2 = 0;
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        if (address instanceof Inet6Address) {
                            if (!a((Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(ib.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            q.put("WIFI", Integer.valueOf(i2));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            q.put("MOBILE", Integer.valueOf(i2));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            it.a(th, "at", "ipstack");
        }
    }
}
