package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/scatter/CircleShapeRenderer.class */
public class CircleShapeRenderer implements IShapeRenderer {
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
            canvas.drawCircle(f, f2, f3, paint);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f4);
        canvas.drawCircle(f, f2, f5 + a3, paint);
        if (d != 1122867) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(d);
            canvas.drawCircle(f, f2, a3, paint);
        }
    }
}
