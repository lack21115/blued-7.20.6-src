package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/RadarDataSet.class */
public class RadarDataSet extends LineRadarDataSet<RadarEntry> implements IRadarDataSet {
    protected float D;
    protected float E;
    protected boolean p;
    protected int q;
    protected int r;
    protected int s;
    protected float t;

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public boolean a() {
        return this.p;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int b() {
        return this.q;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int c() {
        return this.r;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int d() {
        return this.s;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float e() {
        return this.t;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float f() {
        return this.D;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float g() {
        return this.E;
    }
}
