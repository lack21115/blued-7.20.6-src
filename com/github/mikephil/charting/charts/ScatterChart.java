package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.renderer.ScatterChartRenderer;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/ScatterChart.class */
public class ScatterChart extends BarLineChartBase<ScatterData> implements ScatterDataProvider {

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/ScatterChart$ScatterShape.class */
    public enum ScatterShape {
        SQUARE("SQUARE"),
        CIRCLE("CIRCLE"),
        TRIANGLE("TRIANGLE"),
        CROSS("CROSS"),
        X("X"),
        CHEVRON_UP("CHEVRON_UP"),
        CHEVRON_DOWN("CHEVRON_DOWN");
        
        private final String h;

        ScatterShape(String str) {
            this.h = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.h;
        }
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void a() {
        super.a();
        this.O = new ScatterChartRenderer(this, this.R, this.Q);
        getXAxis().c(0.5f);
        getXAxis().d(0.5f);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider
    public ScatterData getScatterData() {
        return (ScatterData) this.C;
    }
}
