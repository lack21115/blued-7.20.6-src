package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.efs.sdk.base.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/q.class */
public final class q implements Callable<u> {
    private static final HttpRequestRetryHandler e = new ad();
    protected l a;
    protected Context b;
    protected o c;
    String d;
    private HttpUriRequest f;
    private CookieManager i;
    private AbstractHttpEntity j;
    private HttpHost k;
    private URL l;
    private String q;
    private HttpContext g = new BasicHttpContext();
    private CookieStore h = new BasicCookieStore();
    private int m = 0;
    private boolean n = false;
    private boolean o = false;
    private String p = null;

    public q(l lVar, o oVar) {
        this.a = lVar;
        this.b = lVar.a;
        this.c = oVar;
    }

    private static long a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return 0L;
            }
            if ("max-age".equalsIgnoreCase(strArr[i2])) {
                int i3 = i2 + 1;
                if (strArr[i3] != null) {
                    try {
                        return Long.parseLong(strArr[i3]);
                    } catch (Exception e2) {
                    }
                } else {
                    continue;
                }
            }
            i = i2 + 1;
        }
    }

    private static HttpUrlHeader a(HttpResponse httpResponse) {
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        Header[] allHeaders = httpResponse.getAllHeaders();
        int length = allHeaders.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return httpUrlHeader;
            }
            Header header = allHeaders[i2];
            httpUrlHeader.setHead(header.getName(), header.getValue());
            i = i2 + 1;
        }
    }

    private u a(HttpResponse httpResponse, int i, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        String str3;
        new StringBuilder("开始handle，handleResponse-1,").append(Thread.currentThread().getId());
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
            if (entity == null) {
                httpResponse.getStatusLine().getStatusCode();
                return null;
            }
            return null;
        }
        new StringBuilder("200，开始处理，handleResponse-2,threadid = ").append(Thread.currentThread().getId());
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                a(entity, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                this.o = false;
                this.a.c(System.currentTimeMillis() - currentTimeMillis);
                this.a.a(byteArray.length);
                new StringBuilder("res:").append(byteArray.length);
                p pVar = new p(a(httpResponse), i, str, byteArray);
                long b = b(httpResponse);
                Header contentType = httpResponse.getEntity().getContentType();
                if (contentType != null) {
                    HashMap<String, String> a = a(contentType.getValue());
                    str2 = a.get("charset");
                    str3 = a.get("Content-Type");
                } else {
                    str2 = null;
                    str3 = null;
                }
                pVar.b(str3);
                pVar.a(str2);
                pVar.a(System.currentTimeMillis());
                pVar.b(b);
                try {
                    byteArrayOutputStream2.close();
                    return pVar;
                } catch (IOException e2) {
                    throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    private static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split(com.alipay.sdk.util.i.b);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            String str2 = split[i2];
            String[] split2 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split2[0], split2[1]);
            i = i2 + 1;
        }
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a = b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a.read(bArr);
                    if (read == -1 || this.c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    if (this.c.f() != null) {
                    }
                }
                outputStream.flush();
                r.a(a);
            } catch (Exception e2) {
                e2.getCause();
                throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
            }
        } catch (Throwable th) {
            r.a(a);
            throw th;
        }
    }

    private static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException e2) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private URI b() {
        String a = this.c.a();
        String str = this.d;
        if (str != null) {
            a = str;
        }
        if (a != null) {
            return new URI(a);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] b = this.c.b();
            String b2 = this.c.b(Constants.CP_GZIP);
            if (b != null) {
                if (TextUtils.equals(b2, "true")) {
                    this.j = b.a(b);
                } else {
                    this.j = new ByteArrayEntity(b);
                }
                this.j.setContentType(this.c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f = httpPost;
        } else {
            this.f = new HttpGet(b());
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[Catch: Exception -> 0x03ab, NullPointerException -> 0x03d9, IOException -> 0x0410, UnknownHostException -> 0x044c, HttpHostConnectException -> 0x0488, NoHttpResponseException -> 0x04b7, SocketTimeoutException -> 0x04f2, ConnectTimeoutException -> 0x052d, ConnectionPoolTimeoutException -> 0x0568, SSLException -> 0x05a3, SSLPeerUnverifiedException -> 0x05df, SSLHandshakeException -> 0x061a, URISyntaxException -> 0x0655, HttpException -> 0x0667, TRY_ENTER, TRY_LEAVE, TryCatch #9 {HttpHostConnectException -> 0x0488, ConnectionPoolTimeoutException -> 0x0568, NoHttpResponseException -> 0x04b7, blocks: (B:2:0x0000, B:6:0x001c, B:12:0x0032, B:14:0x003a, B:20:0x004b, B:22:0x0059, B:24:0x0061, B:26:0x006a, B:28:0x0072, B:29:0x008c, B:32:0x012d, B:34:0x0135, B:36:0x0143, B:39:0x0157, B:41:0x0165, B:45:0x0177, B:47:0x018b, B:50:0x01b8, B:52:0x01c0, B:54:0x01d1, B:56:0x020c, B:58:0x0215, B:60:0x021d, B:62:0x0228, B:64:0x0230, B:66:0x0246, B:70:0x0299, B:71:0x02c1, B:77:0x02ef, B:78:0x0311, B:80:0x0313, B:82:0x0322, B:84:0x032a, B:87:0x033f, B:89:0x0347, B:91:0x0350, B:93:0x035e, B:95:0x036b, B:97:0x0375, B:48:0x0194, B:99:0x039c, B:100:0x03aa), top: B:198:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018b A[Catch: Exception -> 0x03ab, NullPointerException -> 0x03d9, IOException -> 0x0410, UnknownHostException -> 0x044c, HttpHostConnectException -> 0x0488, NoHttpResponseException -> 0x04b7, SocketTimeoutException -> 0x04f2, ConnectTimeoutException -> 0x052d, ConnectionPoolTimeoutException -> 0x0568, SSLException -> 0x05a3, SSLPeerUnverifiedException -> 0x05df, SSLHandshakeException -> 0x061a, URISyntaxException -> 0x0655, HttpException -> 0x0667, TRY_LEAVE, TryCatch #9 {HttpHostConnectException -> 0x0488, ConnectionPoolTimeoutException -> 0x0568, NoHttpResponseException -> 0x04b7, blocks: (B:2:0x0000, B:6:0x001c, B:12:0x0032, B:14:0x003a, B:20:0x004b, B:22:0x0059, B:24:0x0061, B:26:0x006a, B:28:0x0072, B:29:0x008c, B:32:0x012d, B:34:0x0135, B:36:0x0143, B:39:0x0157, B:41:0x0165, B:45:0x0177, B:47:0x018b, B:50:0x01b8, B:52:0x01c0, B:54:0x01d1, B:56:0x020c, B:58:0x0215, B:60:0x021d, B:62:0x0228, B:64:0x0230, B:66:0x0246, B:70:0x0299, B:71:0x02c1, B:77:0x02ef, B:78:0x0311, B:80:0x0313, B:82:0x0322, B:84:0x032a, B:87:0x033f, B:89:0x0347, B:91:0x0350, B:93:0x035e, B:95:0x036b, B:97:0x0375, B:48:0x0194, B:99:0x039c, B:100:0x03aa), top: B:198:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0194 A[Catch: Exception -> 0x03ab, NullPointerException -> 0x03d9, IOException -> 0x0410, UnknownHostException -> 0x044c, HttpHostConnectException -> 0x0488, NoHttpResponseException -> 0x04b7, SocketTimeoutException -> 0x04f2, ConnectTimeoutException -> 0x052d, ConnectionPoolTimeoutException -> 0x0568, SSLException -> 0x05a3, SSLPeerUnverifiedException -> 0x05df, SSLHandshakeException -> 0x061a, URISyntaxException -> 0x0655, HttpException -> 0x0667, TRY_ENTER, TryCatch #9 {HttpHostConnectException -> 0x0488, ConnectionPoolTimeoutException -> 0x0568, NoHttpResponseException -> 0x04b7, blocks: (B:2:0x0000, B:6:0x001c, B:12:0x0032, B:14:0x003a, B:20:0x004b, B:22:0x0059, B:24:0x0061, B:26:0x006a, B:28:0x0072, B:29:0x008c, B:32:0x012d, B:34:0x0135, B:36:0x0143, B:39:0x0157, B:41:0x0165, B:45:0x0177, B:47:0x018b, B:50:0x01b8, B:52:0x01c0, B:54:0x01d1, B:56:0x020c, B:58:0x0215, B:60:0x021d, B:62:0x0228, B:64:0x0230, B:66:0x0246, B:70:0x0299, B:71:0x02c1, B:77:0x02ef, B:78:0x0311, B:80:0x0313, B:82:0x0322, B:84:0x032a, B:87:0x033f, B:89:0x0347, B:91:0x0350, B:93:0x035e, B:95:0x036b, B:97:0x0375, B:48:0x0194, B:99:0x039c, B:100:0x03aa), top: B:198:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c0 A[Catch: Exception -> 0x03ab, NullPointerException -> 0x03d9, IOException -> 0x0410, UnknownHostException -> 0x044c, HttpHostConnectException -> 0x0488, NoHttpResponseException -> 0x04b7, SocketTimeoutException -> 0x04f2, ConnectTimeoutException -> 0x052d, ConnectionPoolTimeoutException -> 0x0568, SSLException -> 0x05a3, SSLPeerUnverifiedException -> 0x05df, SSLHandshakeException -> 0x061a, URISyntaxException -> 0x0655, HttpException -> 0x0667, TryCatch #9 {HttpHostConnectException -> 0x0488, ConnectionPoolTimeoutException -> 0x0568, NoHttpResponseException -> 0x04b7, blocks: (B:2:0x0000, B:6:0x001c, B:12:0x0032, B:14:0x003a, B:20:0x004b, B:22:0x0059, B:24:0x0061, B:26:0x006a, B:28:0x0072, B:29:0x008c, B:32:0x012d, B:34:0x0135, B:36:0x0143, B:39:0x0157, B:41:0x0165, B:45:0x0177, B:47:0x018b, B:50:0x01b8, B:52:0x01c0, B:54:0x01d1, B:56:0x020c, B:58:0x0215, B:60:0x021d, B:62:0x0228, B:64:0x0230, B:66:0x0246, B:70:0x0299, B:71:0x02c1, B:77:0x02ef, B:78:0x0311, B:80:0x0313, B:82:0x0322, B:84:0x032a, B:87:0x033f, B:89:0x0347, B:91:0x0350, B:93:0x035e, B:95:0x036b, B:97:0x0375, B:48:0x0194, B:99:0x039c, B:100:0x03aa), top: B:198:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x020c A[Catch: Exception -> 0x03ab, NullPointerException -> 0x03d9, IOException -> 0x0410, UnknownHostException -> 0x044c, HttpHostConnectException -> 0x0488, NoHttpResponseException -> 0x04b7, SocketTimeoutException -> 0x04f2, ConnectTimeoutException -> 0x052d, ConnectionPoolTimeoutException -> 0x0568, SSLException -> 0x05a3, SSLPeerUnverifiedException -> 0x05df, SSLHandshakeException -> 0x061a, URISyntaxException -> 0x0655, HttpException -> 0x0667, TryCatch #9 {HttpHostConnectException -> 0x0488, ConnectionPoolTimeoutException -> 0x0568, NoHttpResponseException -> 0x04b7, blocks: (B:2:0x0000, B:6:0x001c, B:12:0x0032, B:14:0x003a, B:20:0x004b, B:22:0x0059, B:24:0x0061, B:26:0x006a, B:28:0x0072, B:29:0x008c, B:32:0x012d, B:34:0x0135, B:36:0x0143, B:39:0x0157, B:41:0x0165, B:45:0x0177, B:47:0x018b, B:50:0x01b8, B:52:0x01c0, B:54:0x01d1, B:56:0x020c, B:58:0x0215, B:60:0x021d, B:62:0x0228, B:64:0x0230, B:66:0x0246, B:70:0x0299, B:71:0x02c1, B:77:0x02ef, B:78:0x0311, B:80:0x0313, B:82:0x0322, B:84:0x032a, B:87:0x033f, B:89:0x0347, B:91:0x0350, B:93:0x035e, B:95:0x036b, B:97:0x0375, B:48:0x0194, B:99:0x039c, B:100:0x03aa), top: B:198:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021d A[Catch: Exception -> 0x03ab, NullPointerException -> 0x03d9, IOException -> 0x0410, UnknownHostException -> 0x044c, HttpHostConnectException -> 0x0488, NoHttpResponseException -> 0x04b7, SocketTimeoutException -> 0x04f2, ConnectTimeoutException -> 0x052d, ConnectionPoolTimeoutException -> 0x0568, SSLException -> 0x05a3, SSLPeerUnverifiedException -> 0x05df, SSLHandshakeException -> 0x061a, URISyntaxException -> 0x0655, HttpException -> 0x0667, TryCatch #9 {HttpHostConnectException -> 0x0488, ConnectionPoolTimeoutException -> 0x0568, NoHttpResponseException -> 0x04b7, blocks: (B:2:0x0000, B:6:0x001c, B:12:0x0032, B:14:0x003a, B:20:0x004b, B:22:0x0059, B:24:0x0061, B:26:0x006a, B:28:0x0072, B:29:0x008c, B:32:0x012d, B:34:0x0135, B:36:0x0143, B:39:0x0157, B:41:0x0165, B:45:0x0177, B:47:0x018b, B:50:0x01b8, B:52:0x01c0, B:54:0x01d1, B:56:0x020c, B:58:0x0215, B:60:0x021d, B:62:0x0228, B:64:0x0230, B:66:0x0246, B:70:0x0299, B:71:0x02c1, B:77:0x02ef, B:78:0x0311, B:80:0x0313, B:82:0x0322, B:84:0x032a, B:87:0x033f, B:89:0x0347, B:91:0x0350, B:93:0x035e, B:95:0x036b, B:97:0x0375, B:48:0x0194, B:99:0x039c, B:100:0x03aa), top: B:198:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x039c A[Catch: Exception -> 0x03ab, NullPointerException -> 0x03d9, IOException -> 0x0410, UnknownHostException -> 0x044c, HttpHostConnectException -> 0x0488, NoHttpResponseException -> 0x04b7, SocketTimeoutException -> 0x04f2, ConnectTimeoutException -> 0x052d, ConnectionPoolTimeoutException -> 0x0568, SSLException -> 0x05a3, SSLPeerUnverifiedException -> 0x05df, SSLHandshakeException -> 0x061a, URISyntaxException -> 0x0655, HttpException -> 0x0667, TRY_ENTER, TryCatch #9 {HttpHostConnectException -> 0x0488, ConnectionPoolTimeoutException -> 0x0568, NoHttpResponseException -> 0x04b7, blocks: (B:2:0x0000, B:6:0x001c, B:12:0x0032, B:14:0x003a, B:20:0x004b, B:22:0x0059, B:24:0x0061, B:26:0x006a, B:28:0x0072, B:29:0x008c, B:32:0x012d, B:34:0x0135, B:36:0x0143, B:39:0x0157, B:41:0x0165, B:45:0x0177, B:47:0x018b, B:50:0x01b8, B:52:0x01c0, B:54:0x01d1, B:56:0x020c, B:58:0x0215, B:60:0x021d, B:62:0x0228, B:64:0x0230, B:66:0x0246, B:70:0x0299, B:71:0x02c1, B:77:0x02ef, B:78:0x0311, B:80:0x0313, B:82:0x0322, B:84:0x032a, B:87:0x033f, B:89:0x0347, B:91:0x0350, B:93:0x035e, B:95:0x036b, B:97:0x0375, B:48:0x0194, B:99:0x039c, B:100:0x03aa), top: B:198:0x0000 }] */
    @Override // java.util.concurrent.Callable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.android.phone.mrpc.core.u call() {
        /*
            Method dump skipped, instructions count: 1737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.q.call():com.alipay.android.phone.mrpc.core.u");
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (TextUtils.isEmpty(this.q)) {
            String b = this.c.b("operationType");
            this.q = b;
            return b;
        }
        return this.q;
    }

    private int g() {
        URL h = h();
        return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
    }

    private URL h() {
        URL url = this.l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.c.a());
        this.l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.i = cookieManager2;
        return cookieManager2;
    }

    public final o a() {
        return this.c;
    }
}
