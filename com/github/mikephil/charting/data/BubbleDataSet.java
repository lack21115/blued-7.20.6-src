package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/BubbleDataSet.class */
public class BubbleDataSet extends BarLineScatterCandleBubbleDataSet<BubbleEntry> implements IBubbleDataSet {
    protected float o;
    protected boolean p;
    private float q;

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public float a() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public void a(BubbleEntry bubbleEntry) {
        super.a((BubbleDataSet) bubbleEntry);
        float a2 = bubbleEntry.a();
        if (a2 > this.o) {
            this.o = a2;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public float b() {
        return this.o;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public boolean c() {
        return this.p;
    }
}
