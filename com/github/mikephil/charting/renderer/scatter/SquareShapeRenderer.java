package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/scatter/SquareShapeRenderer.class */
public class SquareShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f, float f2, Paint paint) {
        float a2 = iScatterDataSet.a();
        float f3 = a2 / 2.0f;
        float a3 = Utils.a(iScatterDataSet.c());
        float f4 = (a2 - (a3 * 2.0f)) / 2.0f;
        float f5 = f4 / 2.0f;
        int d = iScatterDataSet.d();
        if (a2 <= 0.0d) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f - f3, f2 - f3, f + f3, f2 + f3, paint);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f4);
        float f6 = f - a3;
        float f7 = f2 - a3;
        float f8 = f + a3;
        float f9 = f2 + a3;
        canvas.drawRect(f6 - f5, f7 - f5, f8 + f5, f9 + f5, paint);
        if (d != 1122867) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(d);
            canvas.drawRect(f6, f7, f8, f9, paint);
        }
    }
}
