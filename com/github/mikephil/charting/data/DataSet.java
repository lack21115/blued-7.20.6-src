package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/DataSet.class */
public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> u;
    protected float v;
    protected float w;
    protected float x;
    protected float y;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/DataSet$Rounding.class */
    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.u = null;
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        this.x = -3.4028235E38f;
        this.y = Float.MAX_VALUE;
        this.u = list;
        if (list == null) {
            this.u = new ArrayList();
        }
        G();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void G() {
        List<T> list = this.u;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        this.x = -3.4028235E38f;
        this.y = Float.MAX_VALUE;
        for (T t : this.u) {
            a((DataSet<T>) t);
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int H() {
        return this.u.size();
    }

    public String I() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(o() == null ? "" : o());
        sb.append(", entries: ");
        sb.append(this.u.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float J() {
        return this.w;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float K() {
        return this.v;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float L() {
        return this.y;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float M() {
        return this.x;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T a(float f, float f2, Rounding rounding) {
        int b = b(f, f2, rounding);
        if (b > -1) {
            return this.u.get(b);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void a(float f, float f2) {
        List<T> list = this.u;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        int b = b(f2, Float.NaN, Rounding.UP);
        for (int b2 = b(f, Float.NaN, Rounding.DOWN); b2 <= b; b2++) {
            b((DataSet<T>) this.u.get(b2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        if (t == null) {
            return;
        }
        c((DataSet<T>) t);
        b((DataSet<T>) t);
    }

    public void a(List<T> list) {
        this.u = list;
        i();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int b(float f, float f2, Rounding rounding) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a34 = a26\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.Ir2JRegAssignTransformer.transform(Ir2JRegAssignTransformer.java:182)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:164)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.an.SimpleLiveAnalyze.onUseLocal(SimpleLiveAnalyze.java:89)\r\n\tat com.googlecode.dex2jar.ir.ts.an.SimpleLiveAnalyze.onUseLocal(SimpleLiveAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T b(float f, float f2) {
        return a(f, f2, Rounding.CLOSEST);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public List<T> b(float f) {
        int i;
        ArrayList arrayList = new ArrayList();
        int size = this.u.size() - 1;
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            }
            int i3 = (size + i2) / 2;
            T t = this.u.get(i3);
            if (f == t.i()) {
                int i4 = i3;
                while (true) {
                    i = i4;
                    if (i <= 0 || this.u.get(i - 1).i() != f) {
                        break;
                    }
                    i4 = i - 1;
                }
                int size2 = this.u.size();
                while (i < size2) {
                    T t2 = this.u.get(i);
                    if (t2.i() != f) {
                        break;
                    }
                    arrayList.add(t2);
                    i++;
                }
            } else if (f > t.i()) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(T t) {
        if (t.b() < this.w) {
            this.w = t.b();
        }
        if (t.b() > this.v) {
            this.v = t.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(T t) {
        if (t.i() < this.y) {
            this.y = t.i();
        }
        if (t.i() > this.x) {
            this.x = t.i();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int d(Entry entry) {
        return this.u.indexOf(entry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T e(int i) {
        return this.u.get(i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(I());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.u.size()) {
                return stringBuffer.toString();
            }
            stringBuffer.append(this.u.get(i2).toString() + " ");
            i = i2 + 1;
        }
    }
}
