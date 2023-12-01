package com.ksad.download;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.h;
import com.kwad.sdk.utils.q;
import com.kwai.filedownloader.e.c;
import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/* loaded from: source-7994992-dex2jar.jar:com/ksad/download/f.class */
public final class f implements com.kwai.filedownloader.kwai.b {
    private Request bA;
    private Response bB;
    private final OkHttpClient by;
    private final Request.Builder bz;

    /* loaded from: source-7994992-dex2jar.jar:com/ksad/download/f$a.class */
    public static class a implements c.b {
        private OkHttpClient.Builder bC;
        private volatile OkHttpClient by;

        public a() {
        }

        public a(boolean z) {
            this.bC = z ? f.aa() : f.ab();
        }

        @Override // com.kwai.filedownloader.e.c.b
        public final com.kwai.filedownloader.kwai.b q(String str) {
            if (this.by == null) {
                synchronized (a.class) {
                    try {
                        if (this.by == null) {
                            this.by = this.bC != null ? this.bC.build() : new OkHttpClient();
                            this.bC = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return new f(str, this.by, (byte) 0);
        }
    }

    private f(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }

    /* synthetic */ f(String str, OkHttpClient okHttpClient, byte b) {
        this(str, okHttpClient);
    }

    private f(Request.Builder builder, OkHttpClient okHttpClient) {
        this.bz = builder;
        this.by = okHttpClient;
    }

    private static OkHttpClient.Builder Y() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.a.a()).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    private static OkHttpClient.Builder Z() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.a.a()).protocols(Util.a(new Protocol[]{Protocol.HTTP_1_1})).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    static /* synthetic */ OkHttpClient.Builder aa() {
        return Z();
    }

    static /* synthetic */ OkHttpClient.Builder ab() {
        return Y();
    }

    private String p(String str) {
        String str2;
        String o = o("Content-Type");
        String extension = q.getExtension(str);
        if (TextUtils.isEmpty(o) || !TextUtils.isEmpty(extension)) {
            String str3 = str;
            if (TextUtils.isEmpty(str)) {
                str3 = System.currentTimeMillis() + ".apk";
            }
            return str3;
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(o);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        if (TextUtils.isEmpty(extensionFromMimeType)) {
            str2 = ".apk";
        } else {
            str2 = "." + extensionFromMimeType;
        }
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> V() {
        if (this.bA == null) {
            this.bA = this.bz.build();
        }
        return this.bA.headers().toMultimap();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> W() {
        Response response = this.bB;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void X() {
        this.bA = null;
        Response response = this.bB;
        if (response != null && response.body() != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) this.bB.body());
        }
        this.bB = null;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void addHeader(String str, String str2) {
        this.bz.addHeader(str, str2);
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void execute() {
        if (this.bA == null) {
            this.bA = this.bz.build();
        }
        this.bB = this.by.newCall(this.bA).execute();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final InputStream getInputStream() {
        Response response = this.bB;
        if (response != null) {
            return ((h) ServiceProvider.get(h.class)).wrapInputStream(response.body().byteStream());
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final int getResponseCode() {
        Response response = this.bB;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final String o(String str) {
        String str2;
        if (!"Content-Disposition".equals(str)) {
            Response response = this.bB;
            if (response == null) {
                return null;
            }
            return response.header(str);
        }
        try {
        } catch (Exception e) {
            str2 = "";
        }
        if (TextUtils.isEmpty(com.kwai.filedownloader.e.f.fC(this.bB.header(str)))) {
            List pathSegments = this.bB.request().url().pathSegments();
            str2 = (String) pathSegments.get(pathSegments.size() - 1);
            return "attachment; filename=\"" + p(str2) + "\"";
        }
        return this.bB.header(str);
    }
}
