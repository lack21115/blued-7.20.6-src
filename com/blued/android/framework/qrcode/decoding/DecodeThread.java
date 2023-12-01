package com.blued.android.framework.qrcode.decoding;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.DecodeHintType;
import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/DecodeThread.class */
final class DecodeThread extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final OnCaptureHandlerListener f6670a;

    /* renamed from: c  reason: collision with root package name */
    private Handler f6671c;
    private final CountDownLatch d = new CountDownLatch(1);
    private final Hashtable<DecodeHintType, Object> b = new Hashtable<>(3);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (r7.isEmpty() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DecodeThread(com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener r6, java.util.Vector<com.google.zxing.BarcodeFormat> r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = r5
            r0.<init>()
            r0 = r5
            r1 = r6
            r0.f6670a = r1
            r0 = r5
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch
            r2 = r1
            r3 = 1
            r2.<init>(r3)
            r0.d = r1
            r0 = r5
            java.util.Hashtable r1 = new java.util.Hashtable
            r2 = r1
            r3 = 3
            r2.<init>(r3)
            r0.b = r1
            r0 = r7
            if (r0 == 0) goto L2e
            r0 = r7
            r6 = r0
            r0 = r7
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L4e
        L2e:
            java.util.Vector r0 = new java.util.Vector
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.util.Vector<com.google.zxing.BarcodeFormat> r1 = com.blued.android.framework.qrcode.decoding.DecodeFormatManager.b
            boolean r0 = r0.addAll(r1)
            r0 = r6
            java.util.Vector<com.google.zxing.BarcodeFormat> r1 = com.blued.android.framework.qrcode.decoding.DecodeFormatManager.f6667c
            boolean r0 = r0.addAll(r1)
            r0 = r6
            java.util.Vector<com.google.zxing.BarcodeFormat> r1 = com.blued.android.framework.qrcode.decoding.DecodeFormatManager.d
            boolean r0 = r0.addAll(r1)
        L4e:
            r0 = r5
            java.util.Hashtable<com.google.zxing.DecodeHintType, java.lang.Object> r0 = r0.b
            com.google.zxing.DecodeHintType r1 = com.google.zxing.DecodeHintType.POSSIBLE_FORMATS
            r2 = r6
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r8
            if (r0 == 0) goto L6a
            r0 = r5
            java.util.Hashtable<com.google.zxing.DecodeHintType, java.lang.Object> r0 = r0.b
            com.google.zxing.DecodeHintType r1 = com.google.zxing.DecodeHintType.CHARACTER_SET
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.qrcode.decoding.DecodeThread.<init>(com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener, java.util.Vector, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler a() {
        try {
            this.d.await();
        } catch (InterruptedException e) {
        }
        return this.f6671c;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f6671c = new DecodeHandler(this.f6670a, this.b);
        this.d.countDown();
        Looper.loop();
    }
}
