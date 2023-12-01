package com.soft.blued.ui.find.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/ImageLineChartRenderer.class */
public class ImageLineChartRenderer extends LineChartRenderer {
    private final LineChart p;
    private final Bitmap q;

    public ImageLineChartRenderer(LineChart lineChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler, Bitmap bitmap) {
        super(lineChart, chartAnimator, viewPortHandler);
        this.p = lineChart;
        this.q = bitmap;
    }

    private Bitmap a(int i) {
        return Bitmap.createScaledBitmap(this.q, i, i, false);
    }

    @Override // com.github.mikephil.charting.renderer.LineChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        super.c(canvas);
        Highlight[] highlighted = this.p.getHighlighted();
        if (highlighted == null) {
            return;
        }
        float a2 = this.g.a();
        float[] fArr = {0.0f, 0.0f};
        LineData lineData = this.f8578a.getLineData();
        List<T> i = this.f8578a.getLineData().i();
        Bitmap[] bitmapArr = new Bitmap[i.size()];
        float[] fArr2 = new float[i.size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i.size()) {
                break;
            }
            float c2 = ((ILineDataSet) i.get(i3)).c();
            fArr2[i3] = c2 / 2.0f;
            bitmapArr[i3] = a((int) c2);
            i2 = i3 + 1;
        }
        int length = highlighted.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                return;
            }
            Highlight highlight = highlighted[i5];
            int f = highlight.f();
            ILineDataSet iLineDataSet = (ILineDataSet) lineData.a(f);
            Transformer a3 = this.p.a(iLineDataSet.C());
            if (iLineDataSet != null && iLineDataSet.p()) {
                Entry b = iLineDataSet.b(highlight.a(), highlight.b());
                if (a(b, iLineDataSet)) {
                    fArr[0] = b.i();
                    fArr[1] = b.b() * a2;
                    a3.a(fArr);
                    canvas.drawBitmap(bitmapArr[f], fArr[0] - fArr2[f], fArr[1] - fArr2[f], this.h);
                }
            }
            i4 = i5 + 1;
        }
    }
}
