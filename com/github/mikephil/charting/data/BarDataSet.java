package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/BarDataSet.class */
public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
    private int o;
    private int p;
    private float q;
    private int r;
    private int s;
    private String[] t;

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int a() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public void a(BarEntry barEntry) {
        if (barEntry == null || Float.isNaN(barEntry.b())) {
            return;
        }
        if (barEntry.a() == null) {
            if (barEntry.b() < this.w) {
                this.w = barEntry.b();
            }
            if (barEntry.b() > this.v) {
                this.v = barEntry.b();
            }
        } else {
            if ((-barEntry.f()) < this.w) {
                this.w = -barEntry.f();
            }
            if (barEntry.e() > this.v) {
                this.v = barEntry.e();
            }
        }
        c((BarDataSet) barEntry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public boolean b() {
        return this.o > 1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int c() {
        return this.p;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public float d() {
        return this.q;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int e() {
        return this.r;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int f() {
        return this.s;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public String[] g() {
        return this.t;
    }
}
