package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.utils.ao;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/h.class */
public final class h implements l {
    private m anS;
    private HttpURLConnection anT;
    private InputStream anU;
    private final com.kwad.sdk.core.videocache.c.b anw;
    private final com.kwad.sdk.core.videocache.a.b anx;

    public h(h hVar) {
        this.anS = hVar.anS;
        this.anw = hVar.anw;
        this.anx = hVar.anx;
    }

    public h(String str, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.anw = (com.kwad.sdk.core.videocache.c.b) ao.checkNotNull(bVar);
        this.anx = (com.kwad.sdk.core.videocache.a.b) ao.checkNotNull(bVar2);
        m db = bVar.db(str);
        this.anS = db != null ? db : new m(str, -2147483648L, k.cZ(str));
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long c2 = c(httpURLConnection);
        return i == 200 ? c2 : i == 206 ? c2 + j : this.anS.aoh;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.anx.yM().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static long c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private HttpURLConnection c(long j, int i) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.anS.url;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.kwad.sdk.core.d.b.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            s.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str2);
            if (i3 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            q.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            int i4 = i2;
            if (z) {
                str2 = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                i4 = i2 + 1;
                httpURLConnection.disconnect();
            }
            if (i4 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i4);
            }
            i2 = i4;
        } while (z);
        return httpURLConnection;
    }

    private void yE() {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        com.kwad.sdk.core.d.b.d("HttpUrlSource", "Read content info from " + this.anS.url);
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
                httpURLConnection2 = c(0L, 10000);
                inputStream = null;
            } catch (IOException e) {
                httpURLConnection2 = null;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                throw th;
            }
            try {
                long c2 = c(httpURLConnection2);
                String contentType = httpURLConnection2.getContentType();
                InputStream inputStream3 = httpURLConnection2.getInputStream();
                m mVar = new m(this.anS.url, c2, contentType);
                this.anS = mVar;
                this.anw.a(mVar.url, this.anS);
                StringBuilder sb = new StringBuilder("Source info fetched: ");
                sb.append(this.anS);
                httpURLConnection = httpURLConnection2;
                inputStream2 = inputStream3;
                inputStream = inputStream3;
                com.kwad.sdk.core.d.b.d("HttpUrlSource", sb.toString());
                inputStream = inputStream3;
            } catch (IOException e2) {
                StringBuilder sb2 = new StringBuilder("Error fetching info from ");
                HttpURLConnection httpURLConnection3 = httpURLConnection2;
                sb2.append(this.anS.url);
                httpURLConnection = httpURLConnection2;
                inputStream2 = inputStream;
                com.kwad.sdk.core.d.b.e("HttpUrlSource", sb2.toString());
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void V(long j) {
        try {
            HttpURLConnection c2 = c(j, -1);
            this.anT = c2;
            String contentType = c2.getContentType();
            this.anU = new BufferedInputStream(this.anT.getInputStream(), 8192);
            m mVar = new m(this.anS.url, a(this.anT, j, this.anT.getResponseCode()), contentType);
            this.anS = mVar;
            this.anw.a(mVar.url, this.anS);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.anS.url + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void close() {
        HttpURLConnection httpURLConnection = this.anT;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                com.kwad.sdk.core.d.b.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final long length() {
        long j;
        synchronized (this) {
            if (this.anS.aoh == -2147483648L) {
                yE();
            }
            j = this.anS.aoh;
        }
        return j;
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final int read(byte[] bArr) {
        InputStream inputStream = this.anU;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.anS.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 8192);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.anS.url + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.anS.url, e2);
        }
    }

    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.anS + "}";
    }

    public final String yF() {
        String str;
        synchronized (this) {
            if (TextUtils.isEmpty(this.anS.aoi)) {
                yE();
            }
            str = this.anS.aoi;
        }
        return str;
    }
}
