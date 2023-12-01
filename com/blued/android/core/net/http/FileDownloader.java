package com.blued.android.core.net.http;

import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/FileDownloader.class */
public class FileDownloader {
    public static void a(String str, BinaryHttpResponseHandler binaryHttpResponseHandler) {
        if (HttpManager.c()) {
            Log.a("IMAGE_LOADER", "downloadToMemory(), url:" + str);
        }
        OkHttpUtils.a(str, binaryHttpResponseHandler);
    }

    public static void a(String str, String str2, FileHttpResponseHandler fileHttpResponseHandler) {
        b(str, str2, fileHttpResponseHandler, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
        if (r7 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r5, java.lang.String r6, com.blued.android.core.net.FileHttpResponseHandler r7, com.blued.android.core.net.IRequestHost r8) {
        /*
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Le
            r0 = r7
            r9 = r0
            r0 = r7
            if (r0 != 0) goto L17
        Le:
            com.blued.android.core.net.http.FileDownloader$1 r0 = new com.blued.android.core.net.http.FileDownloader$1
            r1 = r0
            r1.<init>()
            r9 = r0
        L17:
            r0 = r9
            r0.sendStartMessage()
            r0 = r5
            r1 = r6
            r2 = r9
            r3 = r8
            com.blued.android.core.net.http.OkHttpUtils.a(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.net.http.FileDownloader.a(java.lang.String, java.lang.String, com.blued.android.core.net.FileHttpResponseHandler, com.blued.android.core.net.IRequestHost):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
        if (r7 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.lang.String r5, java.lang.String r6, com.blued.android.core.net.FileHttpResponseHandler r7, com.blued.android.core.net.IRequestHost r8) {
        /*
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Le
            r0 = r7
            r9 = r0
            r0 = r7
            if (r0 != 0) goto L17
        Le:
            com.blued.android.core.net.http.FileDownloader$2 r0 = new com.blued.android.core.net.http.FileDownloader$2
            r1 = r0
            r1.<init>()
            r9 = r0
        L17:
            r0 = r9
            r0.sendStartMessage()
            r0 = r5
            r1 = r6
            r2 = r9
            r3 = r8
            com.blued.android.core.net.http.OkHttpUtils.b(r0, r1, r2, r3)     // Catch: com.blued.android.core.net.exception.OkHttpException -> L25
            return
        L25:
            r6 = move-exception
            boolean r0 = com.blued.android.core.net.HttpManager.c()
            if (r0 == 0) goto L58
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "文件下载失败, url:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r1 = ", exception:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "HttpManager"
            r1 = r7
            java.lang.String r1 = r1.toString()
            int r0 = com.blued.android.core.utils.Log.e(r0, r1)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.core.net.http.FileDownloader.b(java.lang.String, java.lang.String, com.blued.android.core.net.FileHttpResponseHandler, com.blued.android.core.net.IRequestHost):void");
    }
}
