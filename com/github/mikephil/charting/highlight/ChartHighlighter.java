package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/highlight/ChartHighlighter.class */
public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {

    /* renamed from: a  reason: collision with root package name */
    protected T f22148a;
    protected List<Highlight> b = new ArrayList();

    public ChartHighlighter(T t) {
        this.f22148a = t;
    }

    protected float a(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f - f3, f2 - f4);
    }

    protected float a(Highlight highlight) {
        return highlight.d();
    }

    protected float a(List<Highlight> list, float f, YAxis.AxisDependency axisDependency) {
        float f2 = Float.MAX_VALUE;
        int i = 0;
        while (i < list.size()) {
            Highlight highlight = list.get(i);
            float f3 = f2;
            if (highlight.h() == axisDependency) {
                float abs = Math.abs(a(highlight) - f);
                f3 = f2;
                if (abs < f2) {
                    f3 = abs;
                }
            }
            i++;
            f2 = f3;
        }
        return f2;
    }

    protected BarLineScatterCandleBubbleData a() {
        return this.f22148a.getData();
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight a(float f, float f2) {
        MPPointD b = b(f, f2);
        MPPointD.a(b);
        return a((float) b.f22202a, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Highlight a(float f, float f2, float f3) {
        List<Highlight> b = b(f, f2, f3);
        if (b.isEmpty()) {
            return null;
        }
        return a(b, f2, f3, a(b, f3, YAxis.AxisDependency.LEFT) < a(b, f3, YAxis.AxisDependency.RIGHT) ? YAxis.AxisDependency.LEFT : YAxis.AxisDependency.RIGHT, this.f22148a.getMaxHighlightDistance());
    }

    public Highlight a(List<Highlight> list, float f, float f2, YAxis.AxisDependency axisDependency, float f3) {
        Highlight highlight;
        float f4;
        Highlight highlight2 = null;
        int i = 0;
        while (i < list.size()) {
            Highlight highlight3 = list.get(i);
            if (axisDependency != null) {
                highlight = highlight2;
                f4 = f3;
                if (highlight3.h() != axisDependency) {
                    i++;
                    highlight2 = highlight;
                    f3 = f4;
                }
            }
            float a2 = a(f, f2, highlight3.c(), highlight3.d());
            highlight = highlight2;
            f4 = f3;
            if (a2 < f3) {
                highlight = highlight3;
                f4 = a2;
            }
            i++;
            highlight2 = highlight;
            f3 = f4;
        }
        return highlight2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Highlight> a(IDataSet iDataSet, int i, float f, DataSet.Rounding rounding) {
        ArrayList arrayList = new ArrayList();
        List b = iDataSet.b(f);
        List<Entry> list = b;
        if (b.size() == 0) {
            Entry a2 = iDataSet.a(f, Float.NaN, rounding);
            list = b;
            if (a2 != null) {
                list = iDataSet.b(a2.i());
            }
        }
        if (list.size() == 0) {
            return arrayList;
        }
        for (Entry entry : list) {
            MPPointD b2 = this.f22148a.a(iDataSet.C()).b(entry.i(), entry.b());
            arrayList.add(new Highlight(entry.i(), entry.b(), (float) b2.f22202a, (float) b2.b, i, iDataSet.C()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MPPointD b(float f, float f2) {
        return this.f22148a.a(YAxis.AxisDependency.LEFT).a(f, f2);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    protected List<Highlight> b(float f, float f2, float f3) {
        this.b.clear();
        BarLineScatterCandleBubbleData a2 = a();
        if (a2 == null) {
            return this.b;
        }
        int d = a2.d();
        for (int i = 0; i < d; i++) {
            ?? a3 = a2.a(i);
            if (a3.p()) {
                this.b.addAll(a((IDataSet) a3, i, f, DataSet.Rounding.CLOSEST));
            }
        }
        return this.b;
    }
}
