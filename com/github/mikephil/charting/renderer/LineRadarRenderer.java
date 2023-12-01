package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/LineRadarRenderer.class */
public abstract class LineRadarRenderer extends LineScatterCandleRadarRenderer {
    public LineRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    private boolean b() {
        return Utils.d() >= 18;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Canvas canvas, Path path, int i, int i2) {
        int i3 = (i & 16777215) | (i2 << 24);
        if (b()) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i3);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.h.getStyle();
        int color = this.h.getColor();
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(i3);
        canvas.drawPath(path, this.h);
        this.h.setColor(color);
        this.h.setStyle(style);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Canvas canvas, Path path, Drawable drawable) {
        if (!b()) {
            throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + Utils.d() + ".");
        }
        int save = canvas.save();
        canvas.clipPath(path);
        drawable.setBounds((int) this.o.f(), (int) this.o.e(), (int) this.o.g(), (int) this.o.h());
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }
}
