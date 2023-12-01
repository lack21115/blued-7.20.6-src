package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/CandleDataSet.class */
public class CandleDataSet extends LineScatterCandleRadarDataSet<CandleEntry> implements ICandleDataSet {
    private float D;
    private boolean E;
    private float F;
    private boolean G;
    protected Paint.Style o;
    protected Paint.Style p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public Paint.Style D() {
        return this.p;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int E() {
        return this.t;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public boolean F() {
        return this.G;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public float a() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public void a(CandleEntry candleEntry) {
        if (candleEntry.c() < this.w) {
            this.w = candleEntry.c();
        }
        if (candleEntry.a() > this.v) {
            this.v = candleEntry.a();
        }
        c((CandleDataSet) candleEntry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public float b() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public void b(CandleEntry candleEntry) {
        if (candleEntry.a() < this.w) {
            this.w = candleEntry.a();
        }
        if (candleEntry.a() > this.v) {
            this.v = candleEntry.a();
        }
        if (candleEntry.c() < this.w) {
            this.w = candleEntry.c();
        }
        if (candleEntry.c() > this.v) {
            this.v = candleEntry.c();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public boolean c() {
        return this.E;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int d() {
        return this.q;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int e() {
        return this.r;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int f() {
        return this.s;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public Paint.Style g() {
        return this.o;
    }
}
