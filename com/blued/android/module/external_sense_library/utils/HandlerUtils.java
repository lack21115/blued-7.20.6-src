package com.blued.android.module.external_sense_library.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.nio.ByteBuffer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/HandlerUtils.class */
public class HandlerUtils {

    /* renamed from: a  reason: collision with root package name */
    private Handler f11314a = new Handler(Looper.getMainLooper()) { // from class: com.blued.android.module.external_sense_library.utils.HandlerUtils.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 150) {
                return;
            }
            ByteBuffer byteBuffer = (ByteBuffer) message.obj;
            Bundle data = message.getData();
            HandlerUtils.this.a(byteBuffer, FileUtils.a(message.arg1), data.getInt("imageWidth"), data.getInt("imageHeight"));
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.BufferedOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.File r6, android.graphics.Bitmap r7) {
        /*
            r0 = 0
            r8 = r0
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L2e java.io.FileNotFoundException -> L32
            r1 = r0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2e java.io.FileNotFoundException -> L32
            r3 = r2
            r4 = r6
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L2e java.io.FileNotFoundException -> L32
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2e java.io.FileNotFoundException -> L32
            r9 = r0
            r0 = r9
            r8 = r0
            r0 = r7
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L83
            r2 = 90
            r3 = r9
            boolean r0 = r0.compress(r1, r2, r3)     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L83
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L46
            goto L4b
        L26:
            r8 = move-exception
            r0 = r9
            r7 = r0
            r0 = r8
            r9 = r0
            goto L35
        L2e:
            r6 = move-exception
            goto L84
        L32:
            r9 = move-exception
            r0 = 0
            r7 = r0
        L35:
            r0 = r7
            r8 = r0
            r0 = r9
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L83
            r0 = r7
            if (r0 == 0) goto L4b
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L46
            goto L4b
        L46:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L4b:
            r0 = r6
            java.lang.String r0 = r0.getAbsolutePath()
            r7 = r0
            android.content.Intent r0 = new android.content.Intent
            r1 = r0
            java.lang.String r2 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r1.<init>(r2)
            r8 = r0
            r0 = r8
            r1 = r6
            android.net.Uri r1 = android.net.Uri.fromFile(r1)
            android.content.Intent r0 = r0.setData(r1)
            android.content.Context r0 = com.blued.android.core.AppInfo.d()
            r1 = r8
            r0.sendBroadcast(r1)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L82
            android.content.Context r0 = com.blued.android.core.AppInfo.d()
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4
            r2 = 0
            r3 = 0
            android.media.MediaScannerConnection.scanFile(r0, r1, r2, r3)
        L82:
            return
        L83:
            r6 = move-exception
        L84:
            r0 = r8
            if (r0 == 0) goto L94
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L8f
            goto L94
        L8f:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L94:
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.external_sense_library.utils.HandlerUtils.a(java.io.File, android.graphics.Bitmap):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ByteBuffer byteBuffer, File file, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        byteBuffer.position(0);
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        a(file, createBitmap);
        createBitmap.recycle();
    }

    public Handler a() {
        return this.f11314a;
    }
}
