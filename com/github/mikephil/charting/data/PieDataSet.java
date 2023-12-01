package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/PieDataSet.class */
public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {
    private float A;
    private float B;
    private float C;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    private float f8528a;
    private boolean o;
    private float p;
    private ValuePosition q;
    private ValuePosition r;
    private boolean s;
    private int t;
    private float z;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/PieDataSet$ValuePosition.class */
    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float D() {
        return this.A;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float E() {
        return this.B;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float F() {
        return this.C;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean N() {
        return this.D;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float a() {
        return this.f8528a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public void a(PieEntry pieEntry) {
        if (pieEntry == null) {
            return;
        }
        b((PieDataSet) pieEntry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean b() {
        return this.o;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float c() {
        return this.p;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition d() {
        return this.q;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition e() {
        return this.r;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean f() {
        return this.s;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public int g() {
        return this.t;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float h() {
        return this.z;
    }
}
