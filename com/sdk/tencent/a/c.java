package com.sdk.tencent.a;

import android.os.SystemClock;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/c.class */
public class c<T> extends com.sdk.tencent.d.c<Object, Object, Void> implements com.sdk.tencent.c.b {
    public static final b x = new b(102400, 60000);
    public static Map<String, Long> y = new TreeMap();
    public com.sdk.tencent.e.b<T> j;
    public String k;
    public String l;
    public int n;
    public long p;
    public Boolean s;
    public Boolean t;
    public Boolean u;
    public e<T> v;
    public long w;
    public long i = b.a();
    public a m = a.WAITING;
    public boolean o = true;
    public String q = null;
    public boolean r = false;

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/c$a.class */
    public enum a {
        WAITING(0),
        STARTED(1),
        LOADING(2),
        FAILURE(3),
        CANCELLED(4),
        SUCCESS(5);

        a(int i) {
        }
    }

    public c(d<T> dVar) {
        Boolean bool = Boolean.FALSE;
        this.s = bool;
        this.t = bool;
        this.u = bool;
        e<T> a2 = dVar.a();
        this.v = a2;
        if (a2 != null) {
            this.k = a2.b();
            this.l = this.v.d();
            this.n = this.v.c();
            this.j = this.v.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ae A[Catch: Exception -> 0x03c1, TRY_LEAVE, TryCatch #2 {Exception -> 0x03c1, blocks: (B:6:0x0016, B:10:0x006a, B:14:0x00ca, B:16:0x00d2, B:18:0x00db, B:20:0x00e4, B:24:0x0143, B:26:0x014f, B:28:0x0159, B:30:0x0173, B:34:0x019b, B:36:0x01ae, B:37:0x01b6, B:31:0x017f, B:33:0x018f, B:39:0x01d0, B:41:0x01d9, B:43:0x01ee, B:46:0x01f9, B:47:0x0204, B:54:0x0243, B:48:0x0210, B:50:0x0227, B:52:0x0233, B:57:0x024f, B:59:0x0274, B:60:0x0281, B:74:0x02d6, B:77:0x02eb, B:79:0x02f8, B:81:0x0303, B:83:0x0311, B:85:0x031d, B:89:0x033c, B:92:0x034b, B:94:0x0352, B:96:0x0362, B:98:0x036b, B:86:0x0328, B:75:0x02e1), top: B:127:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d6 A[Catch: Exception -> 0x03c1, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x03c1, blocks: (B:6:0x0016, B:10:0x006a, B:14:0x00ca, B:16:0x00d2, B:18:0x00db, B:20:0x00e4, B:24:0x0143, B:26:0x014f, B:28:0x0159, B:30:0x0173, B:34:0x019b, B:36:0x01ae, B:37:0x01b6, B:31:0x017f, B:33:0x018f, B:39:0x01d0, B:41:0x01d9, B:43:0x01ee, B:46:0x01f9, B:47:0x0204, B:54:0x0243, B:48:0x0210, B:50:0x0227, B:52:0x0233, B:57:0x024f, B:59:0x0274, B:60:0x0281, B:74:0x02d6, B:77:0x02eb, B:79:0x02f8, B:81:0x0303, B:83:0x0311, B:85:0x031d, B:89:0x033c, B:92:0x034b, B:94:0x0352, B:96:0x0362, B:98:0x036b, B:86:0x0328, B:75:0x02e1), top: B:127:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02e1 A[Catch: Exception -> 0x03c1, TRY_ENTER, TryCatch #2 {Exception -> 0x03c1, blocks: (B:6:0x0016, B:10:0x006a, B:14:0x00ca, B:16:0x00d2, B:18:0x00db, B:20:0x00e4, B:24:0x0143, B:26:0x014f, B:28:0x0159, B:30:0x0173, B:34:0x019b, B:36:0x01ae, B:37:0x01b6, B:31:0x017f, B:33:0x018f, B:39:0x01d0, B:41:0x01d9, B:43:0x01ee, B:46:0x01f9, B:47:0x0204, B:54:0x0243, B:48:0x0210, B:50:0x0227, B:52:0x0233, B:57:0x024f, B:59:0x0274, B:60:0x0281, B:74:0x02d6, B:77:0x02eb, B:79:0x02f8, B:81:0x0303, B:83:0x0311, B:85:0x031d, B:89:0x033c, B:92:0x034b, B:94:0x0352, B:96:0x0362, B:98:0x036b, B:86:0x0328, B:75:0x02e1), top: B:127:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02f8 A[Catch: Exception -> 0x03c1, TRY_ENTER, TryCatch #2 {Exception -> 0x03c1, blocks: (B:6:0x0016, B:10:0x006a, B:14:0x00ca, B:16:0x00d2, B:18:0x00db, B:20:0x00e4, B:24:0x0143, B:26:0x014f, B:28:0x0159, B:30:0x0173, B:34:0x019b, B:36:0x01ae, B:37:0x01b6, B:31:0x017f, B:33:0x018f, B:39:0x01d0, B:41:0x01d9, B:43:0x01ee, B:46:0x01f9, B:47:0x0204, B:54:0x0243, B:48:0x0210, B:50:0x0227, B:52:0x0233, B:57:0x024f, B:59:0x0274, B:60:0x0281, B:74:0x02d6, B:77:0x02eb, B:79:0x02f8, B:81:0x0303, B:83:0x0311, B:85:0x031d, B:89:0x033c, B:92:0x034b, B:94:0x0352, B:96:0x0362, B:98:0x036b, B:86:0x0328, B:75:0x02e1), top: B:127:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0328 A[Catch: Exception -> 0x03c1, TRY_ENTER, TryCatch #2 {Exception -> 0x03c1, blocks: (B:6:0x0016, B:10:0x006a, B:14:0x00ca, B:16:0x00d2, B:18:0x00db, B:20:0x00e4, B:24:0x0143, B:26:0x014f, B:28:0x0159, B:30:0x0173, B:34:0x019b, B:36:0x01ae, B:37:0x01b6, B:31:0x017f, B:33:0x018f, B:39:0x01d0, B:41:0x01d9, B:43:0x01ee, B:46:0x01f9, B:47:0x0204, B:54:0x0243, B:48:0x0210, B:50:0x0227, B:52:0x0233, B:57:0x024f, B:59:0x0274, B:60:0x0281, B:74:0x02d6, B:77:0x02eb, B:79:0x02f8, B:81:0x0303, B:83:0x0311, B:85:0x031d, B:89:0x033c, B:92:0x034b, B:94:0x0352, B:96:0x0362, B:98:0x036b, B:86:0x0328, B:75:0x02e1), top: B:127:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x033c A[Catch: Exception -> 0x03c1, TRY_ENTER, TryCatch #2 {Exception -> 0x03c1, blocks: (B:6:0x0016, B:10:0x006a, B:14:0x00ca, B:16:0x00d2, B:18:0x00db, B:20:0x00e4, B:24:0x0143, B:26:0x014f, B:28:0x0159, B:30:0x0173, B:34:0x019b, B:36:0x01ae, B:37:0x01b6, B:31:0x017f, B:33:0x018f, B:39:0x01d0, B:41:0x01d9, B:43:0x01ee, B:46:0x01f9, B:47:0x0204, B:54:0x0243, B:48:0x0210, B:50:0x0227, B:52:0x0233, B:57:0x024f, B:59:0x0274, B:60:0x0281, B:74:0x02d6, B:77:0x02eb, B:79:0x02f8, B:81:0x0303, B:83:0x0311, B:85:0x031d, B:89:0x033c, B:92:0x034b, B:94:0x0352, B:96:0x0362, B:98:0x036b, B:86:0x0328, B:75:0x02e1), top: B:127:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x034a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.sdk.tencent.a.f<T> a(com.sdk.tencent.a.d<T> r8, java.net.HttpURLConnection r9) {
        /*
            Method dump skipped, instructions count: 1064
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.tencent.a.c.a(com.sdk.tencent.a.d, java.net.HttpURLConnection):com.sdk.tencent.a.f");
    }

    public void a() {
        this.m = a.CANCELLED;
        if (!this.f14344c.get()) {
            try {
                this.f14344c.set(true);
                this.b.cancel(true);
            } catch (Throwable th) {
                com.sdk.tencent.n.b.a("PriorityAsyncTask", th.getMessage(), this.f);
            }
        }
        com.sdk.tencent.e.b<T> bVar = this.j;
        if (bVar != null) {
            bVar.getClass();
        }
    }

    public boolean a(long j, long j2, boolean z) {
        if (this.j != null && this.m != a.CANCELLED) {
            if (z) {
                a(2, Long.valueOf(j), Long.valueOf(j2));
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                long j3 = this.p;
                this.j.getClass();
                if (uptimeMillis - j3 >= 1000) {
                    this.p = uptimeMillis;
                    a(2, Long.valueOf(j), Long.valueOf(j2));
                }
            }
        }
        return this.m != a.CANCELLED;
    }

    public final f<T> b(d<T> dVar, HttpURLConnection httpURLConnection) {
        f<T> fVar;
        b bVar;
        String a2;
        try {
            bVar = x;
        } catch (Throwable th) {
            com.sdk.tencent.n.c.b(th.toString());
            com.sdk.tencent.n.b.a("PriorityAsyncTask", "网络访问异常：" + th.toString(), this.f);
            int i = this.n;
            fVar = null;
            if (i > 0) {
                this.n = i - 1;
                fVar = b(dVar, httpURLConnection);
            }
        }
        if (!bVar.b(this.k) || (a2 = bVar.a(this.l)) == null) {
            if (this.s.booleanValue() && this.r) {
                File file = new File(this.q);
                long length = (file.isFile() && file.exists()) ? file.length() : 0L;
                if (length > 0) {
                    httpURLConnection.setRequestProperty("RANGE", "bytes=" + length + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            fVar = null;
            if (!this.f14344c.get()) {
                this.w = System.currentTimeMillis();
                fVar = a(dVar, dVar.a(httpURLConnection));
            }
            f<T> fVar2 = fVar;
            if (fVar == null) {
                fVar2 = new f<>(1, "网络访问异常", false);
            }
            return fVar2;
        }
        return new f<>(0, a2, true);
    }

    public final String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("status", 102001);
            jSONObject.put("msg", "选择流量通道失败");
            return jSONObject.toString();
        } catch (JSONException e) {
            return null;
        }
    }
}
