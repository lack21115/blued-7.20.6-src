package com.amap.api.col.p0003sl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

/* renamed from: com.amap.api.col.3sl.cn  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cn.class */
public final class cn {
    private static Paint a = new Paint();
    private static Rect b = new Rect();

    public static float a(int i, boolean z) {
        float f = 1.0f;
        if (z) {
            if (i == 1) {
                f = 0.0f;
            } else if (i != 2) {
                return 0.5f;
            }
            return f;
        }
        if (i == 8) {
            f = 0.0f;
        } else if (i != 16) {
            return 0.5f;
        }
        return f;
    }

    public static MarkerOptions a(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(b(textOptions));
        markerOptions.anchor(a(textOptions.getAlignX(), true), a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    public static BitmapDescriptor b(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        a.setTypeface(textOptions.getTypeface());
        a.setSubpixelText(true);
        a.setAntiAlias(true);
        a.setStrokeWidth(5.0f);
        a.setStrokeCap(Paint.Cap.ROUND);
        a.setTextSize(textOptions.getFontSize());
        a.setTextAlign(Paint.Align.CENTER);
        a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = a.getFontMetrics();
        int i = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i2 = (int) (((i - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), b);
        }
        Bitmap createBitmap = Bitmap.createBitmap(b.width() + 6, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), b.centerX() + 3, i2, a);
        }
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
