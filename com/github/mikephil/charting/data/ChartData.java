package com.github.mikephil.charting.data;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/ChartData.class */
public abstract class ChartData<T extends IDataSet<? extends Entry>> {

    /* renamed from: a  reason: collision with root package name */
    protected float f22128a;
    protected float b;

    /* renamed from: c  reason: collision with root package name */
    protected float f22129c;
    protected float d;
    protected float e;
    protected float f;
    protected float g;
    protected float h;
    protected List<T> i;

    public ChartData() {
        this.f22128a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.f22129c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        this.i = new ArrayList();
    }

    public ChartData(T... tArr) {
        this.f22128a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.f22129c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        this.i = a(tArr);
        b();
    }

    private List<T> a(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            arrayList.add(tArr[i2]);
            i = i2 + 1;
        }
    }

    public float a(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f = this.f;
            float f2 = f;
            if (f == Float.MAX_VALUE) {
                f2 = this.h;
            }
            return f2;
        }
        float f3 = this.h;
        float f4 = f3;
        if (f3 == Float.MAX_VALUE) {
            f4 = this.f;
        }
        return f4;
    }

    public Entry a(Highlight highlight) {
        if (highlight.f() >= this.i.size()) {
            return null;
        }
        return this.i.get(highlight.f()).b(highlight.a(), highlight.b());
    }

    public T a(int i) {
        List<T> list = this.i;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.i.get(i);
    }

    protected T a(List<T> list) {
        for (T t : list) {
            if (t.C() == YAxis.AxisDependency.LEFT) {
                return t;
            }
        }
        return null;
    }

    public void a(float f) {
        for (T t : this.i) {
            t.a(f);
        }
    }

    public void a(float f, float f2) {
        for (T t : this.i) {
            t.a(f, f2);
        }
        c();
    }

    protected void a(T t) {
        if (this.f22128a < t.K()) {
            this.f22128a = t.K();
        }
        if (this.b > t.J()) {
            this.b = t.J();
        }
        if (this.f22129c < t.M()) {
            this.f22129c = t.M();
        }
        if (this.d > t.L()) {
            this.d = t.L();
        }
        if (t.C() == YAxis.AxisDependency.LEFT) {
            if (this.e < t.K()) {
                this.e = t.K();
            }
            if (this.f > t.J()) {
                this.f = t.J();
                return;
            }
            return;
        }
        if (this.g < t.K()) {
            this.g = t.K();
        }
        if (this.h > t.J()) {
            this.h = t.J();
        }
    }

    public void a(boolean z) {
        for (T t : this.i) {
            t.b(z);
        }
    }

    public float b(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f = this.e;
            float f2 = f;
            if (f == -3.4028235E38f) {
                f2 = this.g;
            }
            return f2;
        }
        float f3 = this.g;
        float f4 = f3;
        if (f3 == -3.4028235E38f) {
            f4 = this.e;
        }
        return f4;
    }

    public T b(List<T> list) {
        for (T t : list) {
            if (t.C() == YAxis.AxisDependency.RIGHT) {
                return t;
            }
        }
        return null;
    }

    public void b() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        List<T> list = this.i;
        if (list == null) {
            return;
        }
        this.f22128a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.f22129c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        for (T t : list) {
            a((ChartData<T>) t);
        }
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        T a2 = a(this.i);
        if (a2 != null) {
            this.e = a2.K();
            this.f = a2.J();
            for (T t2 : this.i) {
                if (t2.C() == YAxis.AxisDependency.LEFT) {
                    if (t2.J() < this.f) {
                        this.f = t2.J();
                    }
                    if (t2.K() > this.e) {
                        this.e = t2.K();
                    }
                }
            }
        }
        T b = b(this.i);
        if (b != null) {
            this.g = b.K();
            this.h = b.J();
            for (T t3 : this.i) {
                if (t3.C() == YAxis.AxisDependency.RIGHT) {
                    if (t3.J() < this.h) {
                        this.h = t3.J();
                    }
                    if (t3.K() > this.g) {
                        this.g = t3.K();
                    }
                }
            }
        }
    }

    public int d() {
        List<T> list = this.i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public float e() {
        return this.b;
    }

    public float f() {
        return this.f22128a;
    }

    public float g() {
        return this.d;
    }

    public float h() {
        return this.f22129c;
    }

    public List<T> i() {
        return this.i;
    }

    public int j() {
        Iterator<T> it = this.i.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = i2 + it.next().H();
        }
    }

    public T k() {
        List<T> list = this.i;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t = this.i.get(0);
        for (T t2 : this.i) {
            if (t2.H() > t.H()) {
                t = t2;
            }
        }
        return t;
    }
}
