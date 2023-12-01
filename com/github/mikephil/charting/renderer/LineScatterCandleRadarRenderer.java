package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/LineScatterCandleRadarRenderer.class */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: a  reason: collision with root package name */
    private Path f8583a;

    public LineScatterCandleRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f8583a = new Path();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Canvas canvas, float f, float f2, ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet) {
        this.i.setColor(iLineScatterCandleRadarDataSet.h());
        this.i.setStrokeWidth(iLineScatterCandleRadarDataSet.V());
        this.i.setPathEffect(iLineScatterCandleRadarDataSet.W());
        if (iLineScatterCandleRadarDataSet.T()) {
            this.f8583a.reset();
            this.f8583a.moveTo(f, this.o.e());
            this.f8583a.lineTo(f, this.o.h());
            canvas.drawPath(this.f8583a, this.i);
        }
        if (iLineScatterCandleRadarDataSet.U()) {
            this.f8583a.reset();
            this.f8583a.moveTo(this.o.f(), f2);
            this.f8583a.lineTo(this.o.g(), f2);
            canvas.drawPath(this.f8583a, this.i);
        }
    }
}
