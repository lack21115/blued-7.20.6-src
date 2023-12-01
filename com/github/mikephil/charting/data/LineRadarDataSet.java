package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/LineRadarDataSet.class */
public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {
    protected Drawable o;
    private int p;
    private int q;
    private float r;
    private boolean s;

    public LineRadarDataSet(List<T> list, String str) {
        super(list, str);
        this.p = Color.rgb(140, 234, 255);
        this.q = 85;
        this.r = 2.5f;
        this.s = false;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public int O() {
        return this.p;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public Drawable P() {
        return this.o;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public int Q() {
        return this.q;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public float R() {
        return this.r;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public boolean S() {
        return this.s;
    }

    public void a(Drawable drawable) {
        this.o = drawable;
    }

    public void d(boolean z) {
        this.s = z;
    }

    public void e(float f) {
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = f2;
        if (f2 > 10.0f) {
            f3 = 10.0f;
        }
        this.r = Utils.a(f3);
    }

    public void g(int i) {
        this.q = i;
    }
}
