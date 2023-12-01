package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/scatter/TriangleShapeRenderer.class */
public class TriangleShapeRenderer implements IShapeRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected Path f8589a = new Path();

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f, float f2, Paint paint) {
        float a2 = iScatterDataSet.a();
        float f3 = a2 / 2.0f;
        float a3 = (a2 - (Utils.a(iScatterDataSet.c()) * 2.0f)) / 2.0f;
        int d = iScatterDataSet.d();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.f8589a;
        path.reset();
        float f4 = f2 - f3;
        path.moveTo(f, f4);
        float f5 = f + f3;
        float f6 = f2 + f3;
        path.lineTo(f5, f6);
        float f7 = f - f3;
        path.lineTo(f7, f6);
        int i = (a2 > 0.0d ? 1 : (a2 == 0.0d ? 0 : -1));
        if (i > 0) {
            path.lineTo(f, f4);
            float f8 = f7 + a3;
            float f9 = f6 - a3;
            path.moveTo(f8, f9);
            path.lineTo(f5 - a3, f9);
            path.lineTo(f, f4 + a3);
            path.lineTo(f8, f9);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (i <= 0 || d == 1122867) {
            return;
        }
        paint.setColor(d);
        path.moveTo(f, f4 + a3);
        float f10 = f6 - a3;
        path.lineTo(f5 - a3, f10);
        path.lineTo(f7 + a3, f10);
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
    }
}
