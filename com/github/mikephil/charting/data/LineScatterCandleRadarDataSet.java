package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/LineScatterCandleRadarDataSet.class */
public abstract class LineScatterCandleRadarDataSet<T extends Entry> extends BarLineScatterCandleBubbleDataSet<T> implements ILineScatterCandleRadarDataSet<T> {
    protected boolean A;
    protected float B;
    protected DashPathEffect C;
    protected boolean z;

    public LineScatterCandleRadarDataSet(List<T> list, String str) {
        super(list, str);
        this.z = true;
        this.A = true;
        this.B = 0.5f;
        this.C = null;
        this.B = Utils.a(0.5f);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public boolean T() {
        return this.z;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public boolean U() {
        return this.A;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public float V() {
        return this.B;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public DashPathEffect W() {
        return this.C;
    }

    public void e(boolean z) {
        this.A = z;
    }

    public void f(boolean z) {
        this.z = z;
    }
}
