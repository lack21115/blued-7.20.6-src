package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/am.class */
public class am {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9309a = "OAdURLConnection";
    public static final String b = "POST";

    /* renamed from: c  reason: collision with root package name */
    public static final String f9310c = "GET";
    public static final String d = "application/json";
    public static final String e = "text/plain";
    private HttpURLConnection f;
    private bq g;
    private b h;
    private c i;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private boolean p;
    private Uri.Builder q;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/am$a.class */
    class a extends h {
        a() {
        }

        @Override // com.baidu.mobads.sdk.internal.h
        public Object i() {
            am.this.e();
            am.this.f();
            return null;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/am$b.class */
    public interface b {
        void a(String str, int i);

        void a(String str, String str2);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/am$c.class */
    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i);
    }

    public am(String str) {
        this(str, "GET");
    }

    public am(String str, String str2) {
        this.g = bq.a();
        this.h = null;
        this.i = null;
        this.m = "text/plain";
        this.n = 10000;
        this.o = 10000;
        this.p = false;
        this.q = null;
        this.j = str;
        this.k = str2;
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        HttpURLConnection httpURLConnection2;
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302) {
                    httpURLConnection2 = httpURLConnection;
                    if (responseCode != 301) {
                        break;
                    }
                }
                httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                return httpURLConnection;
            }
        }
        return httpURLConnection2;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th) {
                th = th;
                bufferedWriter = null;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (TextUtils.isEmpty(this.j)) {
            return;
        }
        try {
            HttpURLConnection a2 = cn.a().a(new URL(this.j));
            this.f = a2;
            a2.setConnectTimeout(this.n);
            if (Integer.parseInt(bj.a((Context) null).b()) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f.setRequestMethod(this.k);
            this.f.setUseCaches(this.p);
            if (!TextUtils.isEmpty(this.l)) {
                this.f.setRequestProperty("User-Agent", this.l);
            }
            this.f.setRequestProperty("Content-type", this.m);
            this.f.setRequestProperty("Connection", "keep-alive");
            this.f.setRequestProperty("Cache-Control", "no-cache");
            if (this.k.equals("POST")) {
                this.f.setDoInput(true);
                this.f.setDoOutput(true);
                if (this.q != null) {
                    a(this.q.build().getEncodedQuery(), this.f);
                }
            }
        } catch (Exception e2) {
            b bVar = this.h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0058, code lost:
        if (r0 == 301) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f() {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.am.f():void");
    }

    public String a() {
        e();
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        return null;
                    }
                    return null;
                }
                String c2 = c();
                HttpURLConnection httpURLConnection3 = this.f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c2;
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection4 = this.f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    public void a(int i) {
        this.n = i;
    }

    public void a(Uri.Builder builder) {
        this.q = builder;
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public void a(c cVar) {
        this.i = cVar;
    }

    public void a(String str) {
        this.m = str;
    }

    public void a(Map<String, String> map) {
        if (this.f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public void b() {
        try {
            ba.a().a((h) new a());
        } catch (Exception e2) {
        }
    }

    public void b(int i) {
        this.o = i;
    }

    public String c() {
        InputStream inputStream = null;
        try {
            InputStream inputStream2 = this.f.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream2.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            inputStream = inputStream2;
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (inputStream2 != null) {
                inputStream2.close();
            }
            return byteArrayOutputStream2;
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                av.h(f9309a).f(e2.toString());
            }
        }
    }
}
