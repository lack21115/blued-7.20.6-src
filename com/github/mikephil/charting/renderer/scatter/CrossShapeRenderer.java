package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/scatter/CrossShapeRenderer.class */
public class CrossShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f, float f2, Paint paint) {
        float a2 = iScatterDataSet.a() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.a(1.0f));
        canvas.drawLine(f - a2, f2, f + a2, f2, paint);
        canvas.drawLine(f, f2 - a2, f, f2 + a2, paint);
    }
}
