package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/HorizontalBarChart.class */
public class HorizontalBarChart extends BarChart {
    protected float[] aa;
    private RectF ab;

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ab = new RectF();
        this.aa = new float[2];
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ab = new RectF();
        this.aa = new float[2];
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public Highlight a(float f, float f2) {
        if (this.C == 0) {
            if (this.B) {
                Log.e("MPAndroidChart", "Can't select by touch. No data set.");
                return null;
            }
            return null;
        }
        return getHighlighter().a(f2, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void a() {
        this.Q = new HorizontalViewPortHandler();
        super.a();
        this.s = new TransformerHorizontalBarChart(this.Q);
        this.t = new TransformerHorizontalBarChart(this.Q);
        this.O = new HorizontalBarChartRenderer(this, this.R, this.Q);
        setHighlighter(new HorizontalBarHighlighter(this));
        this.q = new YAxisRendererHorizontalBarChart(this.Q, this.o, this.s);
        this.r = new YAxisRendererHorizontalBarChart(this.Q, this.p, this.t);
        this.u = new XAxisRendererHorizontalBarChart(this.Q, this.H, this.s, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public float[] a(Highlight highlight) {
        return new float[]{highlight.j(), highlight.i()};
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void f() {
        this.t.a(this.p.u, this.p.v, this.H.v, this.H.u);
        this.s.a(this.o.u, this.o.v, this.H.v, this.H.u);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).a(this.Q.f(), this.Q.e(), this.z);
        return (float) Math.min(this.H.t, this.z.b);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).a(this.Q.f(), this.Q.h(), this.y);
        return (float) Math.max(this.H.u, this.y.b);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void j() {
        a(this.ab);
        float f = this.ab.left + 0.0f;
        float f2 = this.ab.top + 0.0f;
        float f3 = this.ab.right + 0.0f;
        float f4 = this.ab.bottom + 0.0f;
        float f5 = f2;
        if (this.o.M()) {
            f5 = f2 + this.o.b(this.q.a());
        }
        float f6 = f4;
        if (this.p.M()) {
            f6 = f4 + this.p.b(this.r.a());
        }
        float f7 = this.H.E;
        float f8 = f;
        float f9 = f3;
        if (this.H.z()) {
            if (this.H.A() == XAxis.XAxisPosition.BOTTOM) {
                f8 = f + f7;
                f9 = f3;
            } else {
                if (this.H.A() == XAxis.XAxisPosition.TOP) {
                    f8 = f;
                } else {
                    f8 = f;
                    f9 = f3;
                    if (this.H.A() == XAxis.XAxisPosition.BOTH_SIDED) {
                        f8 = f + f7;
                    }
                }
                f9 = f3 + f7;
            }
        }
        float extraTopOffset = f5 + getExtraTopOffset();
        float extraRightOffset = f9 + getExtraRightOffset();
        float extraBottomOffset = f6 + getExtraBottomOffset();
        float extraLeftOffset = f8 + getExtraLeftOffset();
        float a2 = Utils.a(this.l);
        this.Q.a(Math.max(a2, extraLeftOffset), Math.max(a2, extraTopOffset), Math.max(a2, extraRightOffset), Math.max(a2, extraBottomOffset));
        if (this.B) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder();
            sb.append("Content: ");
            sb.append(this.Q.k().toString());
            Log.i("MPAndroidChart", sb.toString());
        }
        g();
        f();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float f) {
        this.Q.c(this.H.v / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float f) {
        this.Q.d(this.H.v / f);
    }
}
