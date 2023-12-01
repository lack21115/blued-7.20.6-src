package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/LineScatterCandleRadarRenderer.class */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: a  reason: collision with root package name */
    private Path f22190a;

    public LineScatterCandleRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f22190a = new Path();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Canvas canvas, float f, float f2, ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet) {
        this.i.setColor(iLineScatterCandleRadarDataSet.h());
        this.i.setStrokeWidth(iLineScatterCandleRadarDataSet.V());
        this.i.setPathEffect(iLineScatterCandleRadarDataSet.W());
        if (iLineScatterCandleRadarDataSet.T()) {
            this.f22190a.reset();
            this.f22190a.moveTo(f, this.o.e());
            this.f22190a.lineTo(f, this.o.h());
            canvas.drawPath(this.f22190a, this.i);
        }
        if (iLineScatterCandleRadarDataSet.U()) {
            this.f22190a.reset();
            this.f22190a.moveTo(this.o.f(), f2);
            this.f22190a.lineTo(this.o.g(), f2);
            canvas.drawPath(this.f22190a, this.i);
        }
    }
}
