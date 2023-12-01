package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/BaseDataSet.class */
public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f8514a;
    protected List<Integer> b;

    /* renamed from: c  reason: collision with root package name */
    protected GradientColor f8515c;
    protected List<GradientColor> d;
    protected List<Integer> e;
    protected YAxis.AxisDependency f;
    protected boolean g;
    protected transient ValueFormatter h;
    protected Typeface i;
    protected boolean j;
    protected boolean k;
    protected MPPointF l;
    protected float m;
    protected boolean n;
    private Legend.LegendForm o;
    private float p;
    private float q;
    private DashPathEffect r;

    public BaseDataSet() {
        this.b = null;
        this.f8515c = null;
        this.d = null;
        this.e = null;
        this.f8514a = "DataSet";
        this.f = YAxis.AxisDependency.LEFT;
        this.g = true;
        this.o = Legend.LegendForm.DEFAULT;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = null;
        this.j = true;
        this.k = true;
        this.l = new MPPointF();
        this.m = 17.0f;
        this.n = true;
        this.b = new ArrayList();
        this.e = new ArrayList();
        this.b.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.e.add(-16777216);
    }

    public BaseDataSet(String str) {
        this();
        this.f8514a = str;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public MPPointF A() {
        return this.l;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean B() {
        return this.n;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public YAxis.AxisDependency C() {
        return this.f;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int a(int i) {
        List<Integer> list = this.b;
        return list.get(i % list.size()).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void a(float f) {
        this.m = Utils.a(f);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void a(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            return;
        }
        this.h = valueFormatter;
    }

    public void a(boolean z) {
        this.g = z;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public GradientColor b(int i) {
        List<GradientColor> list = this.d;
        return list.get(i % list.size());
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void b(boolean z) {
        this.j = z;
    }

    public void c(int i) {
        n();
        this.b.add(Integer.valueOf(i));
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int d(int i) {
        List<Integer> list = this.e;
        return list.get(i % list.size()).intValue();
    }

    public void i() {
        G();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<Integer> j() {
        return this.b;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int k() {
        return this.b.get(0).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public GradientColor l() {
        return this.f8515c;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<GradientColor> m() {
        return this.d;
    }

    public void n() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.clear();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public String o() {
        return this.f8514a;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean p() {
        return this.g;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public ValueFormatter q() {
        return r() ? Utils.a() : this.h;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean r() {
        return this.h == null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Typeface s() {
        return this.i;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float t() {
        return this.m;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public Legend.LegendForm u() {
        return this.o;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float v() {
        return this.p;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float w() {
        return this.q;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public DashPathEffect x() {
        return this.r;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean y() {
        return this.j;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean z() {
        return this.k;
    }
}
