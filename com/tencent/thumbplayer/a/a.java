package com.tencent.thumbplayer.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/a/a.class */
public class a {
    public static Bitmap a(TPVideoFrame tPVideoFrame) {
        if (tPVideoFrame.data.length <= 0 || tPVideoFrame.height == 0 || tPVideoFrame.width == 0) {
            return null;
        }
        return a(tPVideoFrame.data[0], tPVideoFrame.width, tPVideoFrame.height, tPVideoFrame.rotation);
    }

    private static Bitmap a(byte[] bArr, int i, int i2, int i3) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
        createBitmap.copyPixelsFromBuffer(wrap);
        Bitmap bitmap = createBitmap;
        if (i3 != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i3);
            bitmap = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
        }
        return bitmap;
    }

    public static Bitmap[] b(TPVideoFrame tPVideoFrame) {
        if (tPVideoFrame.data.length <= 0 || tPVideoFrame.height == 0 || tPVideoFrame.width == 0) {
            return null;
        }
        Bitmap[] bitmapArr = new Bitmap[tPVideoFrame.data.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= tPVideoFrame.data.length) {
                return bitmapArr;
            }
            bitmapArr[i2] = a(tPVideoFrame.data[i2], tPVideoFrame.width, tPVideoFrame.height, tPVideoFrame.rotation);
            i = i2 + 1;
        }
    }
}
