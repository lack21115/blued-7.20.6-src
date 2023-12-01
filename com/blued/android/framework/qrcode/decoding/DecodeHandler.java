package com.blued.android.framework.qrcode.decoding;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/DecodeHandler.class */
final class DecodeHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6668a = DecodeHandler.class.getSimpleName();
    private final MultiFormatReader b;

    /* renamed from: c  reason: collision with root package name */
    private final OnCaptureHandlerListener f6669c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeHandler(OnCaptureHandlerListener onCaptureHandlerListener, Hashtable<DecodeHintType, Object> hashtable) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.b = multiFormatReader;
        multiFormatReader.setHints(hashtable);
        this.f6669c = onCaptureHandlerListener;
    }

    private static void a(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] renderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap createBitmap = Bitmap.createBitmap(renderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, new ByteArrayOutputStream());
        bundle.putParcelable("barcode_bitmap", createBitmap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006a, code lost:
        if (r8 < (r0.top + r0.height())) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(byte[] r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.qrcode.decoding.DecodeHandler.a(byte[], int, int):void");
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 2000) {
            a((byte[]) message.obj, message.arg1, message.arg2);
        } else if (i != 4002) {
        } else {
            Looper.myLooper().quit();
        }
    }
}
