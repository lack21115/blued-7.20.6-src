package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.RadarHighlighter;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/RadarChart.class */
public class RadarChart extends PieRadarChartBase<RadarData> {

    /* renamed from: a  reason: collision with root package name */
    protected YAxisRendererRadarChart f8475a;
    protected XAxisRendererRadarChart b;
    private float e;
    private float f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private YAxis l;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 2.5f;
        this.f = 1.5f;
        this.g = Color.rgb(122, 122, 122);
        this.h = Color.rgb(122, 122, 122);
        this.i = 150;
        this.j = true;
        this.k = 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 2.5f;
        this.f = 1.5f;
        this.g = Color.rgb(122, 122, 122);
        this.h = Color.rgb(122, 122, 122);
        this.i = 150;
        this.j = true;
        this.k = 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int a(float f) {
        float c2 = Utils.c(f - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int H = ((RadarData) this.C).k().H();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= H) {
                return 0;
            }
            int i3 = i2 + 1;
            if ((i3 * sliceAngle) - (sliceAngle / 2.0f) > c2) {
                return i2;
            }
            i = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void a() {
        super.a();
        this.l = new YAxis(YAxis.AxisDependency.LEFT);
        this.e = Utils.a(1.5f);
        this.f = Utils.a(0.75f);
        this.O = new RadarChartRenderer(this, this.R, this.Q);
        this.f8475a = new YAxisRendererRadarChart(this.Q, this.l, this);
        this.b = new XAxisRendererRadarChart(this.Q, this.H, this);
        this.P = new RadarHighlighter(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void b() {
        super.b();
        this.l.a(((RadarData) this.C).a(YAxis.AxisDependency.LEFT), ((RadarData) this.C).b(YAxis.AxisDependency.LEFT));
        this.H.a(0.0f, ((RadarData) this.C).k().H());
    }

    public float getFactor() {
        RectF k = this.Q.k();
        return Math.min(k.width() / 2.0f, k.height() / 2.0f) / this.l.v;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF k = this.Q.k();
        return Math.min(k.width() / 2.0f, k.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return (this.H.z() && this.H.h()) ? this.H.E : Utils.a(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.N.a().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.k;
    }

    public float getSliceAngle() {
        return 360.0f / ((RadarData) this.C).k().H();
    }

    public int getWebAlpha() {
        return this.i;
    }

    public int getWebColor() {
        return this.g;
    }

    public int getWebColorInner() {
        return this.h;
    }

    public float getWebLineWidth() {
        return this.e;
    }

    public float getWebLineWidthInner() {
        return this.f;
    }

    public YAxis getYAxis() {
        return this.l;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return this.l.t;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return this.l.u;
    }

    public float getYRange() {
        return this.l.v;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void h() {
        if (this.C == 0) {
            return;
        }
        b();
        this.f8475a.a(this.l.u, this.l.t, this.l.G());
        this.b.a(this.H.u, this.H.t, false);
        if (this.K != null && !this.K.c()) {
            this.N.a(this.C);
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C == 0) {
            return;
        }
        if (this.H.z()) {
            this.b.a(this.H.u, this.H.t, false);
        }
        this.b.a(canvas);
        if (this.j) {
            this.O.c(canvas);
        }
        if (this.l.z() && this.l.n()) {
            this.f8475a.e(canvas);
        }
        this.O.a(canvas);
        if (x()) {
            this.O.a(canvas, this.S);
        }
        if (this.l.z() && !this.l.n()) {
            this.f8475a.e(canvas);
        }
        this.f8475a.a(canvas);
        this.O.b(canvas);
        this.N.a(canvas);
        b(canvas);
        c(canvas);
    }

    public void setDrawWeb(boolean z) {
        this.j = z;
    }

    public void setSkipWebLineCount(int i) {
        this.k = Math.max(0, i);
    }

    public void setWebAlpha(int i) {
        this.i = i;
    }

    public void setWebColor(int i) {
        this.g = i;
    }

    public void setWebColorInner(int i) {
        this.h = i;
    }

    public void setWebLineWidth(float f) {
        this.e = Utils.a(f);
    }

    public void setWebLineWidthInner(float f) {
        this.f = Utils.a(f);
    }
}
