package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/BarLineScatterCandleBubbleRenderer.class */
public abstract class BarLineScatterCandleBubbleRenderer extends DataRenderer {
    protected XBounds f;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/BarLineScatterCandleBubbleRenderer$XBounds.class */
    public class XBounds {

        /* renamed from: a  reason: collision with root package name */
        public int f8565a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f8566c;

        protected XBounds() {
        }

        public void a(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
            float max = Math.max(0.0f, Math.min(1.0f, BarLineScatterCandleBubbleRenderer.this.g.b()));
            float lowestVisibleX = barLineScatterCandleBubbleDataProvider.getLowestVisibleX();
            float highestVisibleX = barLineScatterCandleBubbleDataProvider.getHighestVisibleX();
            T a2 = iBarLineScatterCandleBubbleDataSet.a(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            T a3 = iBarLineScatterCandleBubbleDataSet.a(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            this.f8565a = a2 == 0 ? 0 : iBarLineScatterCandleBubbleDataSet.d((IBarLineScatterCandleBubbleDataSet) a2);
            int d = a3 == 0 ? 0 : iBarLineScatterCandleBubbleDataSet.d((IBarLineScatterCandleBubbleDataSet) a3);
            this.b = d;
            this.f8566c = (int) ((d - this.f8565a) * max);
        }
    }

    public BarLineScatterCandleBubbleRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f = new XBounds();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Entry entry, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
        if (entry == null) {
            return false;
        }
        return entry != null && ((float) iBarLineScatterCandleBubbleDataSet.d((IBarLineScatterCandleBubbleDataSet) entry)) < ((float) iBarLineScatterCandleBubbleDataSet.H()) * this.g.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(IDataSet iDataSet) {
        if (iDataSet.B()) {
            return iDataSet.y() || iDataSet.z();
        }
        return false;
    }
}
