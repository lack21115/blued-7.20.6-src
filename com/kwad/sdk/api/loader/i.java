package com.kwad.sdk.api.loader;

import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.utils.ay;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.sobot.chat.core.channel.Const;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/i.class */
public final class i {
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.lang.String r5, java.io.File r6) {
        /*
            r0 = 0
            r9 = r0
            r0 = r6
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto Le
            r0 = r6
            com.kwad.sdk.api.loader.h.e(r0)     // Catch: java.lang.Throwable -> L6c
        Le:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6c java.lang.Throwable -> L6c
            r1 = r0
            r2 = r6
            r3 = 0
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6c
            r8 = r0
            r0 = r5
            java.net.HttpURLConnection r0 = bb(r0)     // Catch: java.lang.Throwable -> L66
            r9 = r0
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L5d java.lang.Throwable -> L66
            r1 = r0
            r2 = r9
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L5d
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L5d
            r5 = r0
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L59
            r6 = r0
        L31:
            r0 = r5
            r1 = r6
            int r0 = r0.read(r1)     // Catch: java.lang.Throwable -> L59
            r7 = r0
            r0 = r7
            r1 = -1
            if (r0 == r1) goto L46
            r0 = r8
            r1 = r6
            r2 = 0
            r3 = r7
            r0.write(r1, r2, r3)     // Catch: java.lang.Throwable -> L59
            goto L31
        L46:
            r0 = r8
            closeQuietly(r0)
            r0 = r5
            closeQuietly(r0)
            r0 = r9
            if (r0 == 0) goto L58
            r0 = r9
            r0.disconnect()
        L58:
            return
        L59:
            r6 = move-exception
            goto L60
        L5d:
            r6 = move-exception
            r0 = 0
            r5 = r0
        L60:
            r0 = r5
            r10 = r0
            goto L78
        L66:
            r6 = move-exception
            r0 = r8
            r5 = r0
            goto L70
        L6c:
            r6 = move-exception
            r0 = r9
            r5 = r0
        L70:
            r0 = 0
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r5
            r8 = r0
        L78:
            r0 = r8
            closeQuietly(r0)
            r0 = r10
            closeQuietly(r0)
            r0 = r9
            if (r0 == 0) goto L8b
            r0 = r9
            r0.disconnect()
        L8b:
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.i.b(java.lang.String, java.io.File):void");
    }

    private static HttpURLConnection bb(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, ay.Code);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(Const.SOCKET_CHECK_CHANNEL);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
