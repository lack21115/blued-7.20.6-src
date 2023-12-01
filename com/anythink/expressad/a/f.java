package com.anythink.expressad.a;

import android.content.IntentFilter;
import android.provider.Downloads;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.anythink.expressad.foundation.h.o;
import com.google.common.net.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4127a = f.class.getSimpleName();
    private static final int b = 60000;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.d.a f4128c;
    private String d;
    private boolean e = true;
    private final int f = IntentFilter.MATCH_CATEGORY_HOST;
    private a g;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f4129a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f4130c;
        public String d;
        public int e;
        public int f;
        public String g;
        public String h;

        public final String a() {
            return "statusCode=" + this.f + ", location=" + this.f4129a + ", contentType=" + this.b + ", contentLength=" + this.e + ", contentEncoding=" + this.f4130c + ", referer=" + this.d;
        }

        public final String toString() {
            return "http响应头：...\nstatusCode=" + this.f + ", location=" + this.f4129a + ", contentType=" + this.b + ", contentLength=" + this.e + ", contentEncoding=" + this.f4130c + ", referer=" + this.d;
        }
    }

    public f() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
        this.f4128c = b2;
        if (b2 == null) {
            com.anythink.expressad.d.b.a();
            this.f4128c = com.anythink.expressad.d.b.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009c A[Catch: Exception -> 0x00a3, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x00a3, blocks: (B:36:0x009c, B:13:0x004a), top: B:48:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.io.InputStream r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.f.a(java.io.InputStream, boolean):java.lang.String");
    }

    private void a(boolean z) {
        this.e = z;
    }

    public final a a(String str, boolean z, boolean z2, com.anythink.expressad.foundation.d.c cVar) {
        HttpURLConnection httpURLConnection;
        byte[] bytes;
        if (URLUtil.isNetworkUrl(str)) {
            String replace = str.replace(" ", "%20");
            URLUtil.isHttpsUrl(replace);
            o.b(f4127a, replace);
            this.g = new a();
            try {
                httpURLConnection = (HttpURLConnection) new URL(replace).openConnection();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setRequestMethod("GET");
                if ((!z && !z2) || cVar == null) {
                    httpURLConnection.setRequestProperty("User-Agent", com.anythink.core.common.k.d.i());
                }
                if (z && cVar != null && cVar.E() == 1) {
                    httpURLConnection.setRequestProperty("User-Agent", com.anythink.core.common.k.d.i());
                }
                if (z2 && cVar != null && cVar.D() == 1) {
                    httpURLConnection.setRequestProperty("User-Agent", com.anythink.core.common.k.d.i());
                }
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (this.f4128c.v() && !TextUtils.isEmpty(this.d)) {
                    httpURLConnection.setRequestProperty(Downloads.Impl.COLUMN_REFERER, this.d);
                }
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.connect();
                this.g.f4129a = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                this.g.d = httpURLConnection.getHeaderField(HttpHeaders.REFERER);
                this.g.f = httpURLConnection.getResponseCode();
                this.g.b = httpURLConnection.getContentType();
                this.g.e = httpURLConnection.getContentLength();
                this.g.f4130c = httpURLConnection.getContentEncoding();
                o.b(f4127a, this.g.toString());
                boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(this.g.f4130c);
                if (this.g.f == 200 && this.e && this.g.e > 0 && this.g.e < 3145728 && !TextUtils.isEmpty(replace) && !replace.endsWith(".apk")) {
                    try {
                        String a2 = a(httpURLConnection.getInputStream(), equalsIgnoreCase);
                        if (!TextUtils.isEmpty(a2) && (bytes = a2.getBytes()) != null && bytes.length > 0 && bytes.length < 3145728) {
                            this.g.g = a2.trim();
                        }
                    } catch (Throwable th2) {
                    }
                }
                this.d = replace;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return this.g;
            } catch (Throwable th3) {
                th = th3;
                try {
                    this.g.h = th.getMessage();
                    o.c("http jump", "connecting");
                    a aVar = this.g;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return aVar;
                } catch (Throwable th4) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th4;
                }
            }
        }
        return null;
    }
}
