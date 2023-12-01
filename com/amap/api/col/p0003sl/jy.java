package com.amap.api.col.p0003sl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ju;
import com.amap.api.col.p0003sl.kb;
import com.amap.api.maps.AMapException;
import com.umeng.analytics.pro.o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;

/* renamed from: com.amap.api.col.3sl.jy  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jy.class */
public final class jy {
    private static SoftReference<SSLContext> k;
    private static SoftReference<jz> t;

    /* renamed from: a  reason: collision with root package name */
    private boolean f5241a;
    private SSLContext b;

    /* renamed from: c  reason: collision with root package name */
    private Proxy f5242c;
    private String g;
    private ju.a h;
    private d i;
    private boolean l;
    private String m;
    private String n;
    private volatile boolean d = false;
    private long e = -1;
    private long f = 0;
    private String j = "";
    private boolean o = false;
    private boolean p = false;
    private String q = "";
    private String r = "";
    private String s = "";
    private f u = new f();

    /* renamed from: com.amap.api.col.3sl.jy$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jy$a.class */
    public static final class a implements Cloneable, Comparable {

        /* renamed from: a  reason: collision with root package name */
        public int f5243a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f5244c;
        public String d;
        public String e;
        public int f;
        public int g;
        public int h;
        public long i;
        public volatile AtomicInteger j = new AtomicInteger(1);

        public a(c cVar) {
            this.b = cVar.f5247c;
            this.f5244c = cVar.e;
            this.e = cVar.d;
            this.f = cVar.m;
            this.g = cVar.n;
            this.h = cVar.b.a();
            this.d = cVar.f5246a;
            this.i = cVar.f;
            if (this.f == 10) {
                this.f5243a = 0;
            }
        }

        /* renamed from: a */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.f + "#";
                if (TextUtils.isEmpty(this.e)) {
                    str = str5 + "-#";
                } else {
                    str = str5 + this.e + "#";
                }
                String str6 = (str + this.h + "#") + this.j + "#";
                if (TextUtils.isEmpty(this.b)) {
                    str2 = str6 + "-#";
                } else {
                    str2 = str6 + this.b + "#";
                }
                if (this.f == 1) {
                    str3 = str2 + this.d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f == 1) {
                    str4 = str3 + this.i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String str7 = (str4 + this.f5244c + "#") + this.g;
                String b = ht.b(jq.a(str7.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                StringBuilder sb = new StringBuilder("上报异常数据");
                sb.append(str7);
                sb.append("加密后：");
                sb.append(b);
                jy.b();
                return b;
            } catch (Exception e) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f5243a - ((a) obj).f5243a;
        }
    }

    /* renamed from: com.amap.api.col.3sl.jy$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jy$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public HttpURLConnection f5245a;
        public int b = this.b;
        public int b = this.b;

        public b(HttpURLConnection httpURLConnection) {
            this.f5245a = httpURLConnection;
        }
    }

    /* renamed from: com.amap.api.col.3sl.jy$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jy$c.class */
    public static final class c implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public String f5246a = "";
        public kb.b b = kb.b.FIRST_NONDEGRADE;

        /* renamed from: c  reason: collision with root package name */
        public String f5247c = "";
        public String d = "";
        public String e = "";
        public long f = 0;
        public long g = 0;
        public long h = 0;
        public long i = 0;
        public long j = 0;
        public String k = "-";
        public String l = "-";
        public int m = 0;
        public int n = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        protected final String b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.f5247c)) {
                str = "-#";
            } else {
                str = this.f5247c + "#";
            }
            if (TextUtils.isEmpty(this.d)) {
                str2 = str + "-#";
            } else {
                str2 = str + this.d + "#";
            }
            String str3 = (((str2 + this.b.a() + "#") + this.h + "#") + this.j + "#") + this.f;
            String b = ht.b(jq.a(str3.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            StringBuilder sb = new StringBuilder("上报耗时数据");
            sb.append(str3);
            sb.append("加密后：");
            sb.append(b);
            jy.b();
            return b;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f5246a + "', degradeType=" + this.b + ", serverIp='" + this.f5247c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.jy$d */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jy$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private Vector<e> f5248a;
        private volatile e b;

        private d() {
            this.f5248a = new Vector<>();
            this.b = new e((byte) 0);
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.b;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f5248a.size()) {
                    e eVar = new e((byte) 0);
                    eVar.b(str);
                    this.f5248a.add(eVar);
                    return eVar;
                }
                e eVar2 = this.f5248a.get(i2);
                if (eVar2 != null && eVar2.a().equals(str)) {
                    return eVar2;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.jy$e */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jy$e.class */
    public static final class e implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        private String f5249a;
        private String b;

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public final String a() {
            return this.b;
        }

        public final void a(String str) {
            String[] split;
            if (TextUtils.isEmpty(this.f5249a) || !str.contains(":") || (split = str.split(":")) == null || split.length <= 0) {
                this.f5249a = str;
            } else {
                this.f5249a = split[0];
            }
        }

        public final void b(String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return !TextUtils.isEmpty(this.f5249a) ? this.f5249a.equals(str) : !TextUtils.isEmpty(this.b) ? defaultHostnameVerifier.verify(this.b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.jy$f */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/jy$f.class */
    public final class f {

        /* renamed from: a  reason: collision with root package name */
        long f5250a = 0;
        long b = 0;

        /* renamed from: c  reason: collision with root package name */
        c f5251c = new c();
        a d;
        c e;
        String f;
        URL g;

        f() {
        }

        public final void a() {
            this.f5251c.h = SystemClock.elapsedRealtime() - this.b;
        }

        public final void a(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            jy.b();
            try {
                this.f5251c.f = SystemClock.elapsedRealtime() - this.f5250a;
                this.f5251c.m = i;
                if (this.f5251c.b.e()) {
                    hp.a(false, this.f5251c.e);
                }
                boolean a2 = jy.this.a(this.f5251c.e);
                if (a2) {
                    if (jy.this.p && !TextUtils.isEmpty(jy.this.n) && this.f5251c.b.b()) {
                        hp.d();
                    }
                    if (this.f5251c.b.c()) {
                        hp.a(this.f5251c.b.c(), this.f5251c.e);
                    }
                    hp.c(this.e);
                    hp.a(false, this.d);
                    hp.b(this.f5251c);
                }
                hp.a(this.g.toString(), this.f5251c.b.c(), true, a2);
                new StringBuilder("!!!error-").append(this.f5251c.toString());
                jy.b();
            } catch (Throwable th) {
            }
        }

        public final void a(long j) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            this.f5251c.l = decimalFormat.format(((float) j) / 1024.0f);
        }

        public final void a(kb kbVar, URL url) {
            this.g = url;
            this.f5251c.d = url.getPath();
            this.f5251c.e = url.getHost();
            if (!TextUtils.isEmpty(jy.this.n) && kbVar.getDegradeType().b()) {
                c cVar = this.f5251c;
                cVar.f5247c = cVar.e.replace("[", "").replace("]", "");
                this.f5251c.e = jy.this.n;
            }
            if (kbVar.getDegradeType().b()) {
                kbVar.setNon_degrade_final_Host(this.f5251c.e);
            }
            if (kbVar.getDegradeType().d()) {
                this.f = kbVar.getNon_degrade_final_Host();
            }
        }

        public final void a(kc kcVar) {
            c clone;
            try {
                this.f5251c.f = SystemClock.elapsedRealtime() - this.f5250a;
                if (kcVar != null) {
                    kcVar.f = this.f5251c.b.c();
                }
                if (this.f5251c.b.b() && this.f5251c.f > 10000) {
                    hp.a(false, this.f5251c.e);
                }
                if (this.f5251c.b.d()) {
                    hp.a(false, this.f);
                }
                boolean a2 = jy.this.a(this.f5251c.e);
                if (a2) {
                    hp.c(this.f5251c);
                    hp.a(true, this.d);
                    if (this.f5251c.f > hp.e && (clone = this.f5251c.clone()) != null) {
                        clone.m = 1;
                        hp.b(clone);
                        new StringBuilder("!!!finish&error-").append(clone.toString());
                        jy.b();
                    }
                }
                hp.a(this.g.toString(), this.f5251c.b.c(), false, a2);
                new StringBuilder("!!!finish-").append(this.f5251c.toString());
                jy.b();
            } catch (Throwable th) {
            }
        }

        public final void b() {
            this.f5251c.i = SystemClock.elapsedRealtime() - this.b;
        }

        public final void b(int i) {
            this.f5251c.n = i;
        }

        public final void c() {
            this.f5251c.j = SystemClock.elapsedRealtime() - this.b;
        }

        public final void d() {
            c clone = this.f5251c.clone();
            if (this.f5251c.f > hp.e) {
                clone.m = 1;
            }
            hp.a(clone);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public jy() {
        hp.e();
        try {
            this.g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            it.a(th, "ht", "ic");
        }
    }

    private static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return o.a.h;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        return exc instanceof SocketTimeoutException ? 2102 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x0506, code lost:
        r14 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x039b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x036a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0003sl.jy.b a(com.amap.api.col.p0003sl.kb r8, boolean r9, boolean r10) throws java.io.IOException, com.amap.api.col.p0003sl.hn {
        /*
            Method dump skipped, instructions count: 1300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.jy.a(com.amap.api.col.3sl.kb, boolean, boolean):com.amap.api.col.3sl.jy$b");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x05aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x05f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x05c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0194  */
    /* JADX WARN: Type inference failed for: r0v117, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v191, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.amap.api.col.p0003sl.kc a(com.amap.api.col.p0003sl.jy.b r7, boolean r8) throws com.amap.api.col.p0003sl.hn, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.jy.a(com.amap.api.col.3sl.jy$b, boolean):com.amap.api.col.3sl.kc");
    }

    private static String a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> hashMap = map;
        if (ju.e != null) {
            if (map != null) {
                map.putAll(ju.e);
                hashMap = map;
            } else {
                hashMap = ju.e;
            }
        }
        String str2 = str;
        if (hashMap != null) {
            if (hashMap.size() <= 0) {
                return str;
            }
            int indexOf = str.indexOf("?");
            HashMap hashMap2 = hashMap;
            if (indexOf >= 0) {
                HashMap hashMap3 = new HashMap();
                String substring = str.substring(indexOf);
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    String str3 = value;
                    if (value == null) {
                        str3 = "";
                    }
                    String encode = URLEncoder.encode(key);
                    if (!substring.matches(".*[\\?\\&]" + encode + "=.*")) {
                        hashMap3.put(key, str3);
                    }
                }
                hashMap2 = hashMap3;
            }
            if (hashMap2.size() == 0) {
                return str;
            }
            String a2 = a(hashMap2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (indexOf < 0) {
                stringBuffer.append("?");
            } else if (!str.endsWith("?") && !str.endsWith("&")) {
                stringBuffer.append("&");
            }
            if (a2 != null) {
                stringBuffer.append(a2);
            }
            str2 = stringBuffer.toString();
        }
        return str2;
    }

    private static String a(HttpURLConnection httpURLConnection) {
        List<String> list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            return (headerFields == null || (list = headerFields.get("gsid")) == null || list.size() <= 0) ? "" : list.get(0);
        } catch (Throwable th) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String str = value;
                if (value == null) {
                    str = "";
                }
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(key));
                sb.append("=");
                sb.append(URLEncoder.encode(str));
            }
            return sb.toString();
        }
        return null;
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection, boolean z) {
        String b2;
        c g;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                it.a(th, "ht", "adh");
                return;
            }
        }
        if (ju.d != null) {
            for (String str2 : ju.d.keySet()) {
                httpURLConnection.addRequestProperty(str2, ju.d.get(str2));
            }
        }
        if (z && !this.m.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.j) && hp.a(this.j)) {
            this.o = true;
            httpURLConnection.addRequestProperty("lct", String.valueOf(hp.c(this.j)));
        }
        httpURLConnection.addRequestProperty("csid", this.g);
        if (a(this.u.f5251c.e)) {
            f fVar = this.u;
            if (TextUtils.isEmpty(fVar.f5251c.f5247c)) {
                b2 = "";
            } else {
                b2 = ht.b(jq.a(fVar.f5251c.f5247c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                StringBuilder sb = new StringBuilder("上报本次请求serverIp:");
                sb.append(fVar.f5251c.f5247c);
                sb.append("加密后：");
                sb.append(b2);
            }
            if (!TextUtils.isEmpty(b2)) {
                httpURLConnection.addRequestProperty("sip", b2);
            }
            if (hp.j && (g = hp.g()) != null) {
                httpURLConnection.addRequestProperty("nls", g.b());
                this.u.e = g;
            }
            a f2 = hp.f();
            if (f2 != null) {
                httpURLConnection.addRequestProperty("nlf", f2.b());
                this.u.d = f2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (this.l) {
            return true;
        }
        return (!TextUtils.isEmpty(this.n) && (this.n.contains("rest") || this.n.contains("apilocate"))) || b(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5, boolean r6) {
        /*
            r4 = this;
            r0 = 1
            r8 = r0
            r0 = r5
            java.lang.String r1 = "sc"
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> Lbb
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> Lbb
            r11 = r0
            r0 = r11
            if (r0 == 0) goto Lc4
            r0 = r11
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lbb
            if (r0 <= 0) goto Lc4
            r0 = r11
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lbb
            r11 = r0
            r0 = r11
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lbb
            if (r0 != 0) goto Lc4
            r0 = r11
            java.lang.String r1 = "#"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> Lbb
            if (r0 != 0) goto L43
            goto Lbf
        L43:
            r0 = r11
            java.lang.String r1 = "#"
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> Lbb
            r11 = r0
            r0 = r11
            int r0 = r0.length     // Catch: java.lang.Throwable -> Lbb
            r1 = 1
            if (r0 <= r1) goto Lc4
            java.lang.String r0 = "1"
            r1 = r11
            r2 = 1
            r1 = r1[r2]     // Catch: java.lang.Throwable -> Lbb
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lbb
            if (r0 == 0) goto Lc4
            goto Lbf
        L64:
            r0 = r6
            if (r0 == 0) goto Lb8
            r0 = r5
            java.lang.String r1 = "lct"
            boolean r0 = r0.containsKey(r1)     // Catch: java.lang.Throwable -> Lbb
            if (r0 == 0) goto Lb5
            r0 = r5
            java.lang.String r1 = "lct"
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> Lbb
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> Lbb
            r5 = r0
            r0 = r5
            if (r0 == 0) goto Lb5
            r0 = r5
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lbb
            if (r0 <= 0) goto Lb5
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lbb
            r5 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lbb
            if (r0 != 0) goto Lb5
            r0 = r5
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> Lbb
            long r0 = r0.longValue()     // Catch: java.lang.Throwable -> Lbb
            r9 = r0
            r0 = r4
            java.lang.String r0 = r0.j     // Catch: java.lang.Throwable -> Lbb
            r1 = r9
            boolean r0 = com.amap.api.col.p0003sl.hp.a(r0, r1)     // Catch: java.lang.Throwable -> Lbb
            r6 = r0
            r0 = r6
            return r0
        Lb5:
            r0 = 0
            r8 = r0
        Lb8:
            r0 = r8
            return r0
        Lbb:
            r5 = move-exception
            goto Lb5
        Lbf:
            r0 = 1
            r7 = r0
            goto Lc6
        Lc4:
            r0 = 0
            r7 = r0
        Lc6:
            r0 = r7
            if (r0 != 0) goto L64
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.jy.a(java.util.Map, boolean):boolean");
    }

    private static String b(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains("#")) {
                String[] split = str.split("#");
                if (split.length <= 1) {
                    return "";
                }
                str = split[0];
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    public static void b() {
    }

    private static boolean b(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    private jz c() {
        try {
            if (t == null || t.get() == null) {
                t = new SoftReference<>(new jz(hp.f5081c, this.b));
            }
            jz jzVar = k != null ? t.get() : null;
            jz jzVar2 = jzVar;
            if (jzVar == null) {
                jzVar2 = new jz(hp.f5081c, this.b);
            }
            return jzVar2;
        } catch (Throwable th) {
            iw.c(th, "ht", "gsf");
            return null;
        }
    }

    private void d(kb kbVar) throws hn {
        this.i = new d((byte) 0);
        this.p = kbVar.isIPV6Request();
        this.f5242c = kbVar.getProxy();
        this.h = kbVar.getUrlConnectionImpl();
        this.l = kbVar.isBinary();
        this.j = kbVar.parseSdkNameFromRequest();
        this.f5241a = hu.a().b(kbVar.isHttps());
        String b2 = kbVar.getDegradeType().b() ? kbVar.b() : kbVar.a();
        this.m = b2;
        this.m = jx.a(b2, this.j);
        this.n = kbVar.getIPDNSName();
        if ("loc".equals(this.j)) {
            String a2 = kbVar.a();
            String b3 = kbVar.b();
            if (!TextUtils.isEmpty(a2)) {
                try {
                    this.r = new URL(a2).getHost();
                } catch (Exception e2) {
                }
            }
            if (TextUtils.isEmpty(b3)) {
                return;
            }
            try {
                if (TextUtils.isEmpty(this.n)) {
                    this.q = new URL(b3).getHost();
                } else {
                    this.q = this.n;
                }
            } catch (Exception e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, String> a(kb kbVar) throws hn {
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        HttpURLConnection httpURLConnection7;
        HttpURLConnection httpURLConnection8;
        HttpURLConnection httpURLConnection9;
        HttpURLConnection httpURLConnection10;
        int i;
        HttpURLConnection httpURLConnection11;
        String headerFieldKey;
        HttpURLConnection httpURLConnection12 = null;
        try {
            try {
                d(kbVar);
                this.m = a(this.m, kbVar.getParams());
                httpURLConnection11 = a(kbVar, false, false).f5245a;
            } catch (hn e2) {
                e = e2;
            } catch (ConnectException e3) {
                e = e3;
                httpURLConnection10 = null;
            } catch (SocketException e4) {
                e = e4;
                httpURLConnection9 = null;
            } catch (SocketTimeoutException e5) {
                e = e5;
                httpURLConnection8 = null;
            } catch (UnknownHostException e6) {
                httpURLConnection7 = null;
            } catch (SSLException e7) {
                e = e7;
                httpURLConnection6 = null;
            } catch (ConnectTimeoutException e8) {
                e = e8;
                httpURLConnection5 = null;
            } catch (InterruptedIOException e9) {
                httpURLConnection4 = null;
            } catch (MalformedURLException e10) {
                httpURLConnection3 = null;
            } catch (IOException e11) {
                httpURLConnection2 = null;
            } catch (Throwable th2) {
                httpURLConnection = null;
                th = th2;
            }
            try {
                this.u.b = SystemClock.elapsedRealtime();
                httpURLConnection11.connect();
                this.u.a();
                int responseCode = httpURLConnection11.getResponseCode();
                if (responseCode >= 400) {
                    this.u.b(responseCode);
                    this.u.a(10);
                    hn hnVar = new hn("http读取header失败");
                    hnVar.a(responseCode);
                    throw hnVar;
                }
                HashMap hashMap = new HashMap();
                for (i = 0; i < 50 && (headerFieldKey = httpURLConnection11.getHeaderFieldKey(i)) != null; i++) {
                    hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection11.getHeaderField(headerFieldKey));
                }
                this.u.a((kc) null);
                if (httpURLConnection11 != null) {
                    try {
                        httpURLConnection11.disconnect();
                    } catch (Throwable th3) {
                        it.a(th3, "hth", "mgr");
                    }
                }
                this.u.d();
                return hashMap;
            } catch (hn e12) {
                e = e12;
                httpURLConnection12 = httpURLConnection11;
                HttpURLConnection httpURLConnection13 = httpURLConnection12;
                this.u.a(e.g());
                HttpURLConnection httpURLConnection14 = httpURLConnection12;
                throw e;
            } catch (ConnectException e13) {
                e = e13;
                httpURLConnection10 = httpURLConnection11;
                HttpURLConnection httpURLConnection15 = httpURLConnection10;
                this.u.b(a(e));
                HttpURLConnection httpURLConnection16 = httpURLConnection10;
                this.u.a(6);
                HttpURLConnection httpURLConnection17 = httpURLConnection10;
                throw new hn(AMapException.ERROR_CONNECTION);
            } catch (MalformedURLException e14) {
                httpURLConnection3 = httpURLConnection11;
                HttpURLConnection httpURLConnection18 = httpURLConnection3;
                this.u.a(8);
                HttpURLConnection httpURLConnection19 = httpURLConnection3;
                throw new hn("url异常 - MalformedURLException");
            } catch (SocketTimeoutException e15) {
                e = e15;
                httpURLConnection8 = httpURLConnection11;
                HttpURLConnection httpURLConnection20 = httpURLConnection8;
                this.u.b(a(e));
                HttpURLConnection httpURLConnection21 = httpURLConnection8;
                this.u.a(2);
                HttpURLConnection httpURLConnection22 = httpURLConnection8;
                throw new hn("socket 连接超时 - SocketTimeoutException");
            } catch (UnknownHostException e16) {
                httpURLConnection7 = httpURLConnection11;
                HttpURLConnection httpURLConnection23 = httpURLConnection7;
                this.u.a(9);
                HttpURLConnection httpURLConnection24 = httpURLConnection7;
                throw new hn("未知主机 - UnKnowHostException");
            } catch (SSLException e17) {
                e = e17;
                httpURLConnection6 = httpURLConnection11;
                HttpURLConnection httpURLConnection25 = httpURLConnection6;
                e.printStackTrace();
                HttpURLConnection httpURLConnection26 = httpURLConnection6;
                this.u.b(a(e));
                HttpURLConnection httpURLConnection27 = httpURLConnection6;
                this.u.a(4);
                HttpURLConnection httpURLConnection28 = httpURLConnection6;
                throw new hn("IO 操作异常 - IOException");
            } catch (ConnectTimeoutException e18) {
                e = e18;
                httpURLConnection5 = httpURLConnection11;
                HttpURLConnection httpURLConnection29 = httpURLConnection5;
                e.printStackTrace();
                HttpURLConnection httpURLConnection30 = httpURLConnection5;
                this.u.b(a(e));
                HttpURLConnection httpURLConnection31 = httpURLConnection5;
                this.u.a(2);
                HttpURLConnection httpURLConnection32 = httpURLConnection5;
                throw new hn("IO 操作异常 - IOException");
            } catch (InterruptedIOException e19) {
                httpURLConnection4 = httpURLConnection11;
                HttpURLConnection httpURLConnection33 = httpURLConnection4;
                this.u.b(7101);
                HttpURLConnection httpURLConnection34 = httpURLConnection4;
                this.u.a(7);
                HttpURLConnection httpURLConnection35 = httpURLConnection4;
                throw new hn(AMapException.ERROR_UNKNOWN);
            } catch (SocketException e20) {
                e = e20;
                httpURLConnection9 = httpURLConnection11;
                HttpURLConnection httpURLConnection36 = httpURLConnection9;
                this.u.b(a(e));
                HttpURLConnection httpURLConnection37 = httpURLConnection9;
                this.u.a(6);
                HttpURLConnection httpURLConnection38 = httpURLConnection9;
                throw new hn(AMapException.ERROR_SOCKET);
            } catch (IOException e21) {
                httpURLConnection2 = httpURLConnection11;
                HttpURLConnection httpURLConnection39 = httpURLConnection2;
                this.u.a(7);
                HttpURLConnection httpURLConnection40 = httpURLConnection2;
                throw new hn("IO 操作异常 - IOException");
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection11;
                this.u.a(9);
                HttpURLConnection httpURLConnection41 = httpURLConnection;
                th.printStackTrace();
                HttpURLConnection httpURLConnection42 = httpURLConnection;
                throw new hn(AMapException.ERROR_UNKNOWN);
            }
        } catch (Throwable th5) {
            if (kbVar != 0) {
                try {
                    kbVar.disconnect();
                } catch (Throwable th6) {
                    it.a(th6, "hth", "mgr");
                }
            }
            this.u.d();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j) {
        this.f = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0fde: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:582:0x0fde */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0fb6: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r17 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:575:0x0fb6 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x047f A[Catch: all -> 0x07b5, hn -> 0x07c4, IOException -> 0x07d3, InterruptedIOException -> 0x07e2, SocketTimeoutException -> 0x07f1, SocketException -> 0x0800, UnknownHostException -> 0x080f, MalformedURLException -> 0x081e, ConnectTimeoutException -> 0x082d, SSLException -> 0x083c, ConnectException -> 0x084b, TRY_ENTER, TRY_LEAVE, TryCatch #54 {hn -> 0x07c4, InterruptedIOException -> 0x07e2, ConnectException -> 0x084b, MalformedURLException -> 0x081e, SocketException -> 0x0800, SocketTimeoutException -> 0x07f1, UnknownHostException -> 0x080f, SSLException -> 0x083c, ConnectTimeoutException -> 0x082d, IOException -> 0x07d3, all -> 0x07b5, blocks: (B:103:0x02e0, B:139:0x047f), top: B:687:0x02e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0b1a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0e2d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:600:0x0b31 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0e44 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:610:0x095b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:612:0x0c61 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0972 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:618:0x0c78 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0a78 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0d7a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:624:0x0f84 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0a8f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:628:0x0d91 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0f9b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0bbd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0bd4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0ee0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:641:0x09eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:643:0x0ced A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0ef7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0a02 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:651:0x0d04 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:655:0x0937 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:657:0x0c3d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:659:0x0af6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:661:0x0a54 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:663:0x0e09 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0d56 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:667:0x0f60 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:669:0x0b99 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:671:0x0ebc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:675:0x0cc9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:677:0x09c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:683:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.amap.api.col.p0003sl.kb r8, com.amap.api.col.p0003sl.jw.a r9) {
        /*
            Method dump skipped, instructions count: 4123
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.jy.a(com.amap.api.col.3sl.kb, com.amap.api.col.3sl.jw$a):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v243, types: [com.amap.api.col.3sl.jy$f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amap.api.col.3sl.kb] */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v40, types: [com.amap.api.col.3sl.kc] */
    public final kc b(kb kbVar) throws hn {
        HttpURLConnection httpURLConnection = null;
        HttpURLConnection httpURLConnection2 = null;
        HttpURLConnection httpURLConnection3 = null;
        HttpURLConnection httpURLConnection4 = null;
        HttpURLConnection httpURLConnection5 = null;
        HttpURLConnection httpURLConnection6 = null;
        HttpURLConnection httpURLConnection7 = null;
        HttpURLConnection httpURLConnection8 = null;
        HttpURLConnection httpURLConnection9 = null;
        HttpURLConnection httpURLConnection10 = null;
        HttpURLConnection httpURLConnection11 = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    d(kbVar);
                                    String a2 = a(this.m, kbVar.getParams());
                                    this.m = a2;
                                    kc b2 = jx.b(a2, this.j);
                                    if (b2 != null) {
                                        this.u.d();
                                        return b2;
                                    }
                                    b a3 = a((kb) kbVar, false, true);
                                    HttpURLConnection httpURLConnection12 = a3.f5245a;
                                    this.u.b = SystemClock.elapsedRealtime();
                                    httpURLConnection12.connect();
                                    this.u.a();
                                    kbVar = a(a3, kbVar.isIgnoreGZip());
                                    httpURLConnection = httpURLConnection12;
                                    httpURLConnection2 = httpURLConnection12;
                                    httpURLConnection3 = httpURLConnection12;
                                    httpURLConnection4 = httpURLConnection12;
                                    httpURLConnection5 = httpURLConnection12;
                                    httpURLConnection6 = httpURLConnection12;
                                    httpURLConnection7 = httpURLConnection12;
                                    httpURLConnection8 = httpURLConnection12;
                                    httpURLConnection9 = httpURLConnection12;
                                    httpURLConnection10 = httpURLConnection12;
                                    httpURLConnection11 = httpURLConnection12;
                                    this.u.a(kbVar);
                                    if (httpURLConnection12 != null) {
                                        try {
                                            httpURLConnection12.disconnect();
                                        } catch (Throwable th) {
                                            it.a(th, "ht", "mgr");
                                        }
                                    }
                                    this.u.d();
                                    return kbVar;
                                } catch (InterruptedIOException e2) {
                                    HttpURLConnection httpURLConnection13 = httpURLConnection10;
                                    this.u.b(7101);
                                    HttpURLConnection httpURLConnection14 = httpURLConnection10;
                                    this.u.a(7);
                                    HttpURLConnection httpURLConnection15 = httpURLConnection10;
                                    throw new hn(AMapException.ERROR_UNKNOWN);
                                } catch (UnknownHostException e3) {
                                    HttpURLConnection httpURLConnection16 = httpURLConnection9;
                                    this.u.a(9);
                                    HttpURLConnection httpURLConnection17 = httpURLConnection9;
                                    throw new hn("未知主机 - UnKnowHostException");
                                }
                            } catch (SocketTimeoutException e4) {
                                this.u.b(a(e4));
                                HttpURLConnection httpURLConnection18 = httpURLConnection3;
                                this.u.a(2);
                                HttpURLConnection httpURLConnection19 = httpURLConnection3;
                                throw new hn("socket 连接超时 - SocketTimeoutException");
                            } catch (IOException e5) {
                                HttpURLConnection httpURLConnection20 = httpURLConnection11;
                                this.u.a(7);
                                HttpURLConnection httpURLConnection21 = httpURLConnection11;
                                throw new hn("IO 操作异常 - IOException");
                            }
                        } catch (MalformedURLException e6) {
                            HttpURLConnection httpURLConnection22 = httpURLConnection8;
                            this.u.a(8);
                            HttpURLConnection httpURLConnection23 = httpURLConnection8;
                            throw new hn("url异常 - MalformedURLException");
                        } catch (SocketException e7) {
                            this.u.b(a(e7));
                            HttpURLConnection httpURLConnection24 = httpURLConnection4;
                            this.u.a(6);
                            HttpURLConnection httpURLConnection25 = httpURLConnection4;
                            throw new hn(AMapException.ERROR_SOCKET);
                        }
                    } catch (ConnectException e8) {
                        this.u.b(a(e8));
                        HttpURLConnection httpURLConnection26 = httpURLConnection7;
                        this.u.a(6);
                        HttpURLConnection httpURLConnection27 = httpURLConnection7;
                        throw new hn(AMapException.ERROR_CONNECTION);
                    } catch (SSLException e9) {
                        e9.printStackTrace();
                        HttpURLConnection httpURLConnection28 = httpURLConnection6;
                        this.u.b(a(e9));
                        HttpURLConnection httpURLConnection29 = httpURLConnection6;
                        this.u.a(4);
                        HttpURLConnection httpURLConnection30 = httpURLConnection6;
                        throw new hn("IO 操作异常 - IOException");
                    }
                } catch (ConnectTimeoutException e10) {
                    e10.printStackTrace();
                    HttpURLConnection httpURLConnection31 = httpURLConnection5;
                    this.u.b(a(e10));
                    HttpURLConnection httpURLConnection32 = httpURLConnection5;
                    this.u.a(2);
                    HttpURLConnection httpURLConnection33 = httpURLConnection5;
                    throw new hn("IO 操作异常 - IOException");
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    HttpURLConnection httpURLConnection34 = httpURLConnection;
                    this.u.a(9);
                    HttpURLConnection httpURLConnection35 = httpURLConnection;
                    throw new hn(AMapException.ERROR_UNKNOWN);
                }
            } catch (hn e11) {
                if (!e11.i()) {
                    HttpURLConnection httpURLConnection36 = httpURLConnection2;
                    if (e11.g() != 10) {
                        HttpURLConnection httpURLConnection37 = httpURLConnection2;
                        this.u.a(e11.f());
                    }
                }
                HttpURLConnection httpURLConnection38 = httpURLConnection2;
                throw e11;
            }
        } catch (Throwable th3) {
            if (kbVar != false) {
                try {
                    kbVar.disconnect();
                } catch (Throwable th4) {
                    it.a(th4, "ht", "mgr");
                }
            }
            this.u.d();
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j) {
        this.e = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0078, code lost:
        if (r0.length == 0) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.amap.api.col.p0003sl.kc c(com.amap.api.col.p0003sl.kb r6) throws com.amap.api.col.p0003sl.hn {
        /*
            Method dump skipped, instructions count: 994
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.jy.c(com.amap.api.col.3sl.kb):com.amap.api.col.3sl.kc");
    }
}
