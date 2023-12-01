package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.utils.ay;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/a.class */
public final class a {
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* renamed from: com.kwad.sdk.core.download.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/a$a.class */
    public static final class C0389a implements c {
        final OutputStream aeV;

        public C0389a(File file, boolean z) {
            this.aeV = new FileOutputStream(file, z);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.aeV.close();
        }

        @Override // com.kwad.sdk.core.download.a.c
        public final void write(byte[] bArr, int i, int i2) {
            this.aeV.write(bArr, 0, i2);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/a$b.class */
    public interface b {
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/a$c.class */
    public interface c extends Closeable {
        void write(byte[] bArr, int i, int i2);
    }

    public static String A(AdInfo adInfo) {
        if (mContext == null) {
            return "";
        }
        DownloadParams transform = DownloadParams.transform(adInfo);
        if (TextUtils.isEmpty(transform.mFileUrl)) {
            return null;
        }
        return av.cB(mContext) + File.separator + bL(transform.mFileUrl);
    }

    public static void B(AdInfo adInfo) {
        a(adInfo, false);
    }

    private static InputStream a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        boolean z;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                Iterator<String> it = value.iterator();
                while (true) {
                    z = false;
                    if (it.hasNext()) {
                        if ("gzip".equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    try {
                        return new GZIPInputStream(inputStream);
                    } catch (IOException e) {
                    }
                } else {
                    continue;
                }
            }
        }
        return inputStream;
    }

    private static URLConnection a(String str, int i, int i2, boolean z) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            s.wrapHttpURLConnection(openConnection);
            openConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, ay.Code);
            openConnection.setConnectTimeout(10000);
            if (i2 > 0) {
                openConnection.setReadTimeout(i2);
            }
            openConnection.setUseCaches(false);
            openConnection.setDoInput(true);
            openConnection.setRequestProperty("Connection", "keep-alive");
            openConnection.setRequestProperty("Charset", "UTF-8");
            return openConnection;
        } catch (MalformedURLException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return null;
        }
    }

    private static void a(AdInfo adInfo, boolean z) {
        Context context = mContext;
        if (context == null) {
            return;
        }
        if (!ag.isNetworkConnected(context)) {
            Context context2 = mContext;
            v.H(context2, w.bN(context2));
            return;
        }
        DownloadParams transform = DownloadParams.transform(adInfo);
        transform.requestInstallPermission = false;
        String str = transform.mFileUrl;
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            return;
        }
        DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(transform.mFileUrl);
        downloadRequest.setDestinationFileName(bL(str));
        downloadRequest.setTag(transform);
        downloadRequest.setDownloadEnablePause(transform.downloadEnablePause);
        int i = 0;
        if (ServiceProvider.CB().showNotification) {
            i = 0;
            if (aL(mContext)) {
                i = 3;
            }
        }
        downloadRequest.setNotificationVisibility(i);
        com.ksad.download.kwai.a.a(mContext, transform.mDownloadid, downloadRequest);
    }

    private static boolean a(String str, File file, b bVar, int i) {
        C0389a c0389a;
        try {
            C0389a c0389a2 = new C0389a(file, false);
            try {
                boolean a2 = a(str, (String) null, c0389a2, (b) null, 0);
                com.kwad.sdk.crash.utils.b.closeQuietly(c0389a2);
                return a2;
            } catch (Throwable th) {
                c0389a = c0389a2;
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(c0389a);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            c0389a = null;
        }
    }

    public static boolean a(String str, File file, b bVar, int i, boolean z) {
        C0389a c0389a;
        C0389a c0389a2;
        try {
            c0389a2 = new C0389a(file, true);
        } catch (Throwable th) {
            th = th;
            c0389a = null;
        }
        try {
            boolean a2 = a(str, (String) null, (c) c0389a2, (b) null, -1, file.length(), -1L, true);
            com.kwad.sdk.crash.utils.b.closeQuietly(c0389a2);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            c0389a = c0389a2;
            com.kwad.sdk.crash.utils.b.closeQuietly(c0389a);
            throw th;
        }
    }

    private static boolean a(String str, String str2, c cVar, b bVar, int i) {
        return a(str, (String) null, cVar, bVar, i, -1L, -1L, false);
    }

    private static boolean a(String str, String str2, c cVar, b bVar, int i, long j, long j2, boolean z) {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) a(str, 10000, i > 0 ? i : 120000, false);
            try {
                if (httpURLConnection != null) {
                    boolean a2 = a(httpURLConnection, str2, cVar, bVar, i, j, -1L, z);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return a2;
                }
                throw new IOException("Fail to createUrlConnection");
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:93:0x024a A[Catch: all -> 0x028b, TRY_LEAVE, TryCatch #5 {all -> 0x028b, blocks: (B:91:0x0243, B:93:0x024a, B:96:0x028a, B:94:0x0252), top: B:121:0x0243 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0252 A[Catch: all -> 0x028b, TRY_ENTER, TryCatch #5 {all -> 0x028b, blocks: (B:91:0x0243, B:93:0x024a, B:96:0x028a, B:94:0x0252), top: B:121:0x0243 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.net.HttpURLConnection r9, java.lang.String r10, com.kwad.sdk.core.download.a.c r11, com.kwad.sdk.core.download.a.b r12, int r13, long r14, long r16, boolean r18) {
        /*
            Method dump skipped, instructions count: 736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a(java.net.HttpURLConnection, java.lang.String, com.kwad.sdk.core.download.a$c, com.kwad.sdk.core.download.a$b, int, long, long, boolean):boolean");
    }

    public static void aK(Context context) {
        synchronized (a.class) {
            if (context != null) {
                try {
                    if (!mHasInit) {
                        mContext = context;
                        com.ksad.download.c.M().init(context);
                        com.kwad.sdk.core.download.c.vu().init(context);
                        mHasInit = true;
                    }
                } finally {
                }
            }
        }
    }

    private static boolean aL(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static String bL(String str) {
        return ad.eC(str) + ".apk";
    }

    public static void bM(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.ksad.download.kwai.a.e(mContext, str);
    }

    public static void c(int i, AdTemplate adTemplate) {
        com.kwad.sdk.core.download.b bVar = (com.kwad.sdk.core.download.b) ServiceProvider.get(com.kwad.sdk.core.download.b.class);
        if (bVar != null) {
            bVar.b(1, adTemplate);
        }
    }

    public static boolean c(String str, File file) {
        try {
            return a(str, file, (b) null, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }
}
