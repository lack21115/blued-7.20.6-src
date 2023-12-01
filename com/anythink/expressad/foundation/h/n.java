package com.anythink.expressad.foundation.h;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/n.class */
public final class n {
    public static Bitmap a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return null;
                }
                int width = bitmap.getWidth();
                Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                canvas.drawCircle(width / 2, width / 2, width / 2, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                return createBitmap;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 0) {
            return bitmap;
        }
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            bitmap2 = null;
            if (!bitmap.isRecycled()) {
                Bitmap bitmap3 = null;
                try {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                    Canvas canvas = new Canvas(bitmap2);
                    Paint paint = new Paint();
                    Rect rect = new Rect(0, 0, width, height);
                    RectF rectF = new RectF(rect);
                    float f = i;
                    paint.setAntiAlias(true);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                    canvas.drawARGB(0, 0, 0, 0);
                    paint.setColor(-12434878);
                    canvas.drawRoundRect(rectF, f, f, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    bitmap3 = bitmap2;
                    canvas.drawBitmap(bitmap, rect, rect, paint);
                } catch (Error | Exception e) {
                    return bitmap3;
                }
            }
        }
        return bitmap2;
    }

    public static Bitmap b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return null;
                }
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                RenderScript create = RenderScript.create(com.anythink.core.common.b.n.a().g());
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(25.0f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                create.destroy();
                return createBitmap;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }
}
