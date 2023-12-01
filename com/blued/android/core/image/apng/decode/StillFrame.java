package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blued.android.core.image.apng.io.APNGReader;
import com.blued.android.core.image.apng.io.APNGWriter;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/decode/StillFrame.class */
public class StillFrame extends Frame<APNGReader, APNGWriter> {
    static final /* synthetic */ boolean a = !StillFrame.class.desiredAssertionStatus();

    public StillFrame(APNGReader aPNGReader) {
        super(aPNGReader);
    }

    @Override // com.blued.android.core.image.apng.decode.Frame
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, APNGWriter aPNGWriter) {
        Bitmap bitmap2;
        Bitmap decodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        try {
            ((APNGReader) this.g).reset();
            decodeStream = BitmapFactory.decodeStream(((APNGReader) this.g).o_(), null, options);
        } catch (IOException e) {
            e = e;
            bitmap2 = null;
        }
        try {
            if (a || decodeStream != null) {
                paint.setXfermode(null);
                canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
                return decodeStream;
            }
            throw new AssertionError();
        } catch (IOException e2) {
            e = e2;
            bitmap2 = decodeStream;
            e.printStackTrace();
            return bitmap2;
        }
    }
}
