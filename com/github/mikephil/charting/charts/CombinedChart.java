package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/CombinedChart.class */
public class CombinedChart extends BarLineChartBase<CombinedData> implements CombinedDataProvider {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f8466a;
    protected DrawOrder[] aa;
    private boolean ab;
    private boolean ac;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/CombinedChart$DrawOrder.class */
    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ab = true;
        this.f8466a = false;
        this.ac = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ab = true;
        this.f8466a = false;
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
        this.aa = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new CombinedHighlighter(this, this));
        setHighlightFullBarEnabled(true);
        this.O = new CombinedChartRenderer(this, this.R, this.Q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void c(Canvas canvas) {
        if (this.V == null || !C() || !x()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.S.length) {
                return;
            }
            Highlight highlight = this.S[i2];
            IBarLineScatterCandleBubbleDataSet<? extends Entry> b = ((CombinedData) this.C).b(highlight);
            Entry a2 = ((CombinedData) this.C).a(highlight);
            if (a2 != null && b.d((IBarLineScatterCandleBubbleDataSet<? extends Entry>) a2) <= b.H() * this.R.b()) {
                float[] a3 = a(highlight);
                if (this.Q.b(a3[0], a3[1])) {
                    this.V.a(a2, highlight);
                    this.V.a(canvas, a3[0], a3[1]);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean c() {
        return this.ab;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean d() {
        return this.ac;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean e() {
        return this.f8466a;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        if (this.C == 0) {
            return null;
        }
        return ((CombinedData) this.C).m();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider
    public BubbleData getBubbleData() {
        if (this.C == 0) {
            return null;
        }
        return ((CombinedData) this.C).a();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider
    public CandleData getCandleData() {
        if (this.C == 0) {
            return null;
        }
        return ((CombinedData) this.C).o();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider
    public CombinedData getCombinedData() {
        return (CombinedData) this.C;
    }

    public DrawOrder[] getDrawOrder() {
        return this.aa;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
    public LineData getLineData() {
        if (this.C == 0) {
            return null;
        }
        return ((CombinedData) this.C).l();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider
    public ScatterData getScatterData() {
        if (this.C == 0) {
            return null;
        }
        return ((CombinedData) this.C).n();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setData(CombinedData combinedData) {
        super.setData((CombinedChart) combinedData);
        setHighlighter(new CombinedHighlighter(this, this));
        ((CombinedChartRenderer) this.O).b();
        this.O.a();
    }

    public void setDrawBarShadow(boolean z) {
        this.ac = z;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.aa = drawOrderArr;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.ab = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.f8466a = z;
    }
}
