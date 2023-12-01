package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6704a = "http.loader";
    public i m;
    protected boolean n;
    protected String o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.g.a$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/a$1.class */
    public final class AnonymousClass1 extends com.anythink.core.common.k.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6707a;

        AnonymousClass1(int i) {
            this.f6707a = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.net.HttpURLConnection] */
        private void b(String str) {
            Throwable th;
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            int i;
            String a2;
            byte[] d;
            HttpURLConnection httpURLConnection3 = null;
            try {
            } catch (Throwable th2) {
                httpURLConnection3 = str;
                th = th2;
            }
            try {
                try {
                    a.this.o = str;
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (StackOverflowError e) {
                    e = e;
                    httpURLConnection = null;
                } catch (ConnectException e2) {
                    e = e2;
                    httpURLConnection = null;
                } catch (SocketTimeoutException e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (UnknownHostException e4) {
                    e = e4;
                    httpURLConnection = null;
                } catch (ConnectTimeoutException e5) {
                    e = e5;
                    httpURLConnection2 = null;
                } catch (Exception e6) {
                    e = e6;
                    httpURLConnection = null;
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    httpURLConnection = null;
                } catch (Error e8) {
                    e = e8;
                    httpURLConnection = null;
                }
                try {
                    int a3 = a.this.a();
                    i = a3;
                    if (a3 != 1) {
                        i = a3;
                        if (a3 != 2) {
                            i = 2;
                        }
                    }
                    if (i == 1) {
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setUseCaches(false);
                    }
                    if (i == 2) {
                        httpURLConnection.setInstanceFollowRedirects(false);
                    }
                    Map<String, String> c2 = a.this.c();
                    if (c2 != null && c2.size() > 0) {
                        for (String str2 : c2.keySet()) {
                            httpURLConnection.addRequestProperty(str2, c2.get(str2));
                        }
                    }
                } catch (ConnectException e9) {
                    e = e9;
                    a.this.a(ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    HttpURLConnection httpURLConnection4 = httpURLConnection;
                    a.this.a(this.f6707a, -1001, "Connect error.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    HttpURLConnection httpURLConnection5 = httpURLConnection;
                    new StringBuilder("http connect error! ").append(e.toString());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    a.this.a(this.f6707a, -1002, "Connect timeout.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (ConnectTimeoutException e11) {
                    httpURLConnection2 = httpURLConnection;
                    e = e11;
                    httpURLConnection3 = httpURLConnection2;
                    a.this.a(this.f6707a, e);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        return;
                    }
                } catch (Exception e12) {
                    e = e12;
                    String message = e.getMessage();
                    HttpURLConnection httpURLConnection6 = httpURLConnection;
                    if (e.getMessage() != null) {
                        HttpURLConnection httpURLConnection7 = httpURLConnection;
                        message = e.getMessage();
                    }
                    HttpURLConnection httpURLConnection8 = httpURLConnection;
                    a.this.a(this.f6707a, g.g, message, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (OutOfMemoryError e13) {
                    e = e13;
                    System.gc();
                    HttpURLConnection httpURLConnection9 = httpURLConnection;
                    String message2 = e.getMessage();
                    HttpURLConnection httpURLConnection10 = httpURLConnection;
                    if (e.getMessage() != null) {
                        HttpURLConnection httpURLConnection11 = httpURLConnection;
                        message2 = e.getMessage();
                    }
                    HttpURLConnection httpURLConnection12 = httpURLConnection;
                    a.this.a(this.f6707a, -1004, message2, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (StackOverflowError e14) {
                    e = e14;
                    System.gc();
                    HttpURLConnection httpURLConnection13 = httpURLConnection;
                    String message3 = e.getMessage();
                    HttpURLConnection httpURLConnection14 = httpURLConnection;
                    if (e.getMessage() != null) {
                        HttpURLConnection httpURLConnection15 = httpURLConnection;
                        message3 = e.getMessage();
                    }
                    HttpURLConnection httpURLConnection16 = httpURLConnection;
                    a.this.a(this.f6707a, -1005, message3, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (Error e15) {
                    e = e15;
                    System.gc();
                    HttpURLConnection httpURLConnection17 = httpURLConnection;
                    String message4 = e.getMessage();
                    HttpURLConnection httpURLConnection18 = httpURLConnection;
                    if (e.getMessage() != null) {
                        HttpURLConnection httpURLConnection19 = httpURLConnection;
                        message4 = e.getMessage();
                    }
                    HttpURLConnection httpURLConnection20 = httpURLConnection;
                    a.this.a(this.f6707a, -9999, message4, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } catch (UnknownHostException e16) {
                    e = e16;
                    a.this.a(ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    HttpURLConnection httpURLConnection21 = httpURLConnection;
                    a.this.a(this.f6707a, -1000, "UnknownHostException", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    HttpURLConnection httpURLConnection22 = httpURLConnection;
                    new StringBuilder("UnknownHostException ").append(e.toString());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                if (a.this.n) {
                    a.this.c(this.f6707a);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                if (n.a().c("ua")) {
                    httpURLConnection.addRequestProperty("User-Agent", com.anythink.core.common.k.g.a());
                }
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.connect();
                if (i == 1 && (d = a.this.d()) != null) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(d);
                    outputStream.flush();
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (!a.this.a(responseCode) && responseCode != 200) {
                    if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                        a.this.a(this.f6707a, responseCode, "Http respond status code is ".concat(String.valueOf(responseCode)), ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(responseCode), httpURLConnection.getResponseMessage()));
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    if (a.this.n) {
                        a.this.c(this.f6707a);
                    } else {
                        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                        if (headerField != null && headerField.toLowerCase().startsWith("http")) {
                            b(headerField);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } else if (a.this.n) {
                    a.this.c(this.f6707a);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } else {
                    InputStream a4 = a.a(httpURLConnection);
                    InputStreamReader inputStreamReader = new InputStreamReader(a4);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    if (a4 != null) {
                        a4.close();
                    }
                    if (a.this.n()) {
                        a2 = sb.toString().trim();
                        JSONObject jSONObject = new JSONObject(a2);
                        int optInt = jSONObject.optInt("code");
                        if (optInt == 0) {
                            JSONObject optJSONObject = jSONObject.optJSONObject(g.c.d);
                            JSONObject jSONObject2 = optJSONObject;
                            if (optJSONObject == null) {
                                jSONObject2 = new JSONObject();
                            }
                            String jSONObject3 = jSONObject2.toString();
                            a aVar = a.this;
                            httpURLConnection.getHeaderFields();
                            a2 = aVar.a(jSONObject3);
                            a.this.a(this.f6707a, a2);
                        } else {
                            a.this.a(this.f6707a, -10000, a2, ErrorCode.getErrorCode(ErrorCode.statuError, String.valueOf(optInt), a2));
                        }
                    } else {
                        a aVar2 = a.this;
                        httpURLConnection.getHeaderFields();
                        a2 = aVar2.a(sb.toString());
                        a.this.a(this.f6707a, a2);
                    }
                    httpURLConnection3 = a2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // com.anythink.core.common.k.b.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r7 = this;
                r0 = r7
                com.anythink.core.common.g.a r0 = com.anythink.core.common.g.a.this     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
                com.anythink.core.common.g.i r0 = r0.m     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
                if (r0 == 0) goto L1a
                r0 = r7
                com.anythink.core.common.g.a r0 = com.anythink.core.common.g.a.this     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
                com.anythink.core.common.g.i r0 = r0.m     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
                r1 = r7
                int r1 = r1.f6707a     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
                r0.onLoadStart(r1)     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
            L1a:
                r0 = r7
                r1 = r7
                com.anythink.core.common.g.a r1 = com.anythink.core.common.g.a.this     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
                java.lang.String r1 = r1.b()     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
                r0.b(r1)     // Catch: java.lang.Exception -> L26 java.lang.StackOverflowError -> L61 java.lang.OutOfMemoryError -> L65
                return
            L26:
                r9 = move-exception
                r0 = r9
                java.lang.String r0 = r0.getMessage()
                r8 = r0
                r0 = r9
                java.lang.String r0 = r0.getMessage()
                if (r0 == 0) goto L38
                r0 = r9
                java.lang.String r0 = r0.getMessage()
                r8 = r0
            L38:
                r0 = r7
                com.anythink.core.common.g.a r0 = com.anythink.core.common.g.a.this
                com.anythink.core.common.g.i r0 = r0.m
                if (r0 == 0) goto L60
                r0 = r7
                com.anythink.core.common.g.a r0 = com.anythink.core.common.g.a.this
                com.anythink.core.common.g.i r0 = r0.m
                r1 = r7
                int r1 = r1.f6707a
                r2 = r8
                java.lang.String r3 = "9999"
                java.lang.String r4 = "9999"
                r5 = r9
                java.lang.String r5 = r5.getMessage()
                com.anythink.core.api.AdError r3 = com.anythink.core.api.ErrorCode.getErrorCode(r3, r4, r5)
                r0.onLoadError(r1, r2, r3)
            L60:
                return
            L61:
                r8 = move-exception
                goto L66
            L65:
                r8 = move-exception
            L66:
                java.lang.System.gc()
                r0 = r8
                java.lang.String r0 = r0.getMessage()
                r9 = r0
                r0 = r8
                java.lang.String r0 = r0.getMessage()
                if (r0 == 0) goto L7a
                r0 = r8
                java.lang.String r0 = r0.getMessage()
                r9 = r0
            L7a:
                r0 = r7
                com.anythink.core.common.g.a r0 = com.anythink.core.common.g.a.this
                com.anythink.core.common.g.i r0 = r0.m
                if (r0 == 0) goto La2
                r0 = r7
                com.anythink.core.common.g.a r0 = com.anythink.core.common.g.a.this
                com.anythink.core.common.g.i r0 = r0.m
                r1 = r7
                int r1 = r1.f6707a
                r2 = r9
                java.lang.String r3 = "9999"
                java.lang.String r4 = "9999"
                r5 = r8
                java.lang.String r5 = r5.getMessage()
                com.anythink.core.api.AdError r3 = com.anythink.core.api.ErrorCode.getErrorCode(r3, r4, r5)
                r0.onLoadError(r1, r2, r3)
            La2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.g.a.AnonymousClass1.a():void");
        }
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = httpURLConnection.getInputStream();
        } catch (Exception e) {
        }
        BufferedInputStream bufferedInputStream2 = bufferedInputStream;
        if ("gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            try {
                byte[] bArr = new byte[2];
                bufferedInputStream2 = new BufferedInputStream(bufferedInputStream);
                bufferedInputStream2.mark(2);
                int read = bufferedInputStream2.read(bArr);
                bufferedInputStream2.reset();
                byte b = bArr[0];
                byte b2 = bArr[1];
                if (read != -1 && (((b2 & 255) << 8) | (b & 255)) == 35615) {
                    return new GZIPInputStream(bufferedInputStream2);
                }
            } catch (Exception e2) {
                return bufferedInputStream;
            }
        }
        return bufferedInputStream2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] c(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void d(int i) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i);
        if (o()) {
            com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) anonymousClass1, 1);
        } else {
            com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) anonymousClass1, 2);
        }
    }

    private void p() {
        this.n = true;
    }

    protected abstract int a();

    protected abstract Object a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i, int i2, String str, AdError adError) {
        i iVar = this.m;
        if (iVar != null) {
            iVar.onLoadError(i, str, adError);
        }
        b(adError);
        b(i2);
    }

    public void a(int i, i iVar) {
        this.n = false;
        this.m = iVar;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(i);
        if (o()) {
            com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) anonymousClass1, 1);
        } else {
            com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) anonymousClass1, 2);
        }
    }

    public void a(int i, Object obj) {
        i iVar = this.m;
        if (iVar != null) {
            iVar.onLoadFinish(i, obj);
        }
    }

    protected final void a(int i, ConnectTimeoutException connectTimeoutException) {
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, connectTimeoutException.getMessage());
        i iVar = this.m;
        if (iVar != null) {
            iVar.onLoadError(i, "Connect timeout.", errorCode);
        }
        b(errorCode);
        b(-1001);
    }

    protected abstract void a(AdError adError);

    protected abstract boolean a(int i);

    protected abstract String b();

    protected void b(int i) {
    }

    protected abstract void b(AdError adError);

    protected abstract Map<String, String> c();

    protected final void c(int i) {
        i iVar = this.m;
        if (iVar != null) {
            iVar.onLoadCanceled(i);
        }
    }

    protected abstract byte[] d();

    public JSONObject e() {
        return c.a(m());
    }

    public JSONObject f() {
        return c.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g() {
        HashMap hashMap = new HashMap();
        String a2 = com.anythink.core.common.k.c.a(e().toString());
        String a3 = com.anythink.core.common.k.c.a(f().toString());
        hashMap.put(c.O, "1.0");
        hashMap.put("p", a2);
        hashMap.put(c.X, a3);
        ArrayList<String> arrayList = new ArrayList(hashMap.size());
        arrayList.addAll(hashMap.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(hashMap.get(str));
        }
        new StringBuilder(" sorted value list:").append(sb.toString());
        hashMap.put("sign", com.anythink.core.common.k.f.c(j() + sb.toString()));
        if (l() != null) {
            hashMap.putAll(l());
        }
        Set<String> keySet = hashMap.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : keySet) {
                jSONObject.put(str2, String.valueOf(hashMap.get(str2)));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        } catch (OutOfMemoryError e2) {
            System.gc();
            return null;
        }
    }

    protected abstract String h();

    protected abstract Context i();

    protected abstract String j();

    protected abstract String k();

    protected abstract Map<String, Object> l();

    protected int m() {
        return 0;
    }

    protected boolean n() {
        return false;
    }

    protected boolean o() {
        return false;
    }
}
