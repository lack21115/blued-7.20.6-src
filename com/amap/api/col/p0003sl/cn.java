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

    /* renamed from: a  reason: collision with root package name */
    private static Paint f4812a = new Paint();
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
        f4812a.setTypeface(textOptions.getTypeface());
        f4812a.setSubpixelText(true);
        f4812a.setAntiAlias(true);
        f4812a.setStrokeWidth(5.0f);
        f4812a.setStrokeCap(Paint.Cap.ROUND);
        f4812a.setTextSize(textOptions.getFontSize());
        f4812a.setTextAlign(Paint.Align.CENTER);
        f4812a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = f4812a.getFontMetrics();
        int i = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i2 = (int) (((i - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            f4812a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), b);
        }
        Bitmap createBitmap = Bitmap.createBitmap(b.width() + 6, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), b.centerX() + 3, i2, f4812a);
        }
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
