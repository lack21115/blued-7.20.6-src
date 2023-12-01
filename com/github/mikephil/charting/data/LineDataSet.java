package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/LineDataSet.class */
public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
    private float D;
    private DashPathEffect E;
    private IFillFormatter F;
    private boolean G;
    private boolean H;
    private Mode p;
    private List<Integer> q;
    private int r;
    private float s;
    private float t;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/LineDataSet$Mode.class */
    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.p = Mode.LINEAR;
        this.q = null;
        this.r = -1;
        this.s = 8.0f;
        this.t = 4.0f;
        this.D = 0.2f;
        this.E = null;
        this.F = new DefaultFillFormatter();
        this.G = true;
        this.H = true;
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.clear();
        this.q.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int D() {
        return this.q.size();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int E() {
        return this.r;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean F() {
        return this.H;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public IFillFormatter N() {
        return this.F;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public Mode a() {
        return this.p;
    }

    public void a(Mode mode) {
        this.p = mode;
    }

    public void a(IFillFormatter iFillFormatter) {
        if (iFillFormatter == null) {
            this.F = new DefaultFillFormatter();
        } else {
            this.F = iFillFormatter;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float b() {
        return this.D;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float c() {
        return this.s;
    }

    public void c(float f) {
        float f2 = f;
        if (f > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = f2;
        if (f2 < 0.05f) {
            f3 = 0.05f;
        }
        this.D = f3;
    }

    public void c(boolean z) {
        this.G = z;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float d() {
        return this.t;
    }

    public void d(float f) {
        if (f >= 1.0f) {
            this.s = Utils.a(f);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 1");
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean e() {
        return this.E != null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int f(int i) {
        return this.q.get(i).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public DashPathEffect f() {
        return this.E;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean g() {
        return this.G;
    }
}
