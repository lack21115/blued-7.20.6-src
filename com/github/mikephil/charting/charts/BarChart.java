package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/BarChart.class */
public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f22062a;
    private boolean aa;
    private boolean ab;
    private boolean ac;

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22062a = false;
        this.aa = true;
        this.ab = false;
        this.ac = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22062a = false;
        this.aa = true;
        this.ab = false;
        this.ac = false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight a(float f, float f2) {
        if (this.C == 0) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        Highlight a2 = getHighlighter().a(f, f2);
        if (a2 != null && e()) {
            return new Highlight(a2.a(), a2.b(), a2.c(), a2.d(), a2.f(), -1, a2.h());
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void a() {
        super.a();
        this.O = new BarChartRenderer(this, this.R, this.Q);
        setHighlighter(new BarHighlighter(this));
        getXAxis().c(0.5f);
        getXAxis().d(0.5f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void b() {
        if (this.ac) {
            this.H.a(((BarData) this.C).g() - (((BarData) this.C).a() / 2.0f), ((BarData) this.C).h() + (((BarData) this.C).a() / 2.0f));
        } else {
            this.H.a(((BarData) this.C).g(), ((BarData) this.C).h());
        }
        this.o.a(((BarData) this.C).a(YAxis.AxisDependency.LEFT), ((BarData) this.C).b(YAxis.AxisDependency.LEFT));
        this.p.a(((BarData) this.C).a(YAxis.AxisDependency.RIGHT), ((BarData) this.C).b(YAxis.AxisDependency.RIGHT));
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean c() {
        return this.aa;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean d() {
        return this.ab;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean e() {
        return this.f22062a;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        return (BarData) this.C;
    }

    public void setDrawBarShadow(boolean z) {
        this.ab = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.aa = z;
    }

    public void setFitBars(boolean z) {
        this.ac = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.f22062a = z;
    }
}
