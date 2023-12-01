package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/CombinedData.class */
public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {
    private LineData j;
    private BarData k;
    private ScatterData l;
    private CandleData m;
    private BubbleData n;

    public BubbleData a() {
        return this.n;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    @Override // com.github.mikephil.charting.data.ChartData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.github.mikephil.charting.data.Entry a(com.github.mikephil.charting.highlight.Highlight r4) {
        /*
            r3 = this;
            r0 = r4
            int r0 = r0.e()
            r1 = r3
            java.util.List r1 = r1.p()
            int r1 = r1.size()
            if (r0 < r1) goto L12
            r0 = 0
            return r0
        L12:
            r0 = r3
            r1 = r4
            int r1 = r1.e()
            com.github.mikephil.charting.data.BarLineScatterCandleBubbleData r0 = r0.b(r1)
            r5 = r0
            r0 = r4
            int r0 = r0.f()
            r1 = r5
            int r1 = r1.d()
            if (r0 < r1) goto L28
            r0 = 0
            return r0
        L28:
            r0 = r5
            r1 = r4
            int r1 = r1.f()
            com.github.mikephil.charting.interfaces.datasets.IDataSet r0 = r0.a(r1)
            r1 = r4
            float r1 = r1.a()
            java.util.List r0 = r0.b(r1)
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L3f:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L6a
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.github.mikephil.charting.data.Entry r0 = (com.github.mikephil.charting.data.Entry) r0
            r6 = r0
            r0 = r6
            float r0 = r0.b()
            r1 = r4
            float r1 = r1.b()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L68
            r0 = r4
            float r0 = r0.b()
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L3f
        L68:
            r0 = r6
            return r0
        L6a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.a(com.github.mikephil.charting.highlight.Highlight):com.github.mikephil.charting.data.Entry");
    }

    public BarLineScatterCandleBubbleData b(int i) {
        return p().get(i);
    }

    public IBarLineScatterCandleBubbleDataSet<? extends Entry> b(Highlight highlight) {
        if (highlight.e() >= p().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData b = b(highlight.e());
        if (highlight.f() >= b.d()) {
            return null;
        }
        return (IBarLineScatterCandleBubbleDataSet) b.i().get(highlight.f());
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public void b() {
        LineData lineData = this.j;
        if (lineData != null) {
            lineData.b();
        }
        BarData barData = this.k;
        if (barData != null) {
            barData.b();
        }
        CandleData candleData = this.m;
        if (candleData != null) {
            candleData.b();
        }
        ScatterData scatterData = this.l;
        if (scatterData != null) {
            scatterData.b();
        }
        BubbleData bubbleData = this.n;
        if (bubbleData != null) {
            bubbleData.b();
        }
        c();
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public void c() {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.clear();
        this.f8521a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.f8522c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        for (BarLineScatterCandleBubbleData barLineScatterCandleBubbleData : p()) {
            barLineScatterCandleBubbleData.c();
            this.i.addAll(barLineScatterCandleBubbleData.i());
            if (barLineScatterCandleBubbleData.f() > this.f8521a) {
                this.f8521a = barLineScatterCandleBubbleData.f();
            }
            if (barLineScatterCandleBubbleData.e() < this.b) {
                this.b = barLineScatterCandleBubbleData.e();
            }
            if (barLineScatterCandleBubbleData.h() > this.f8522c) {
                this.f8522c = barLineScatterCandleBubbleData.h();
            }
            if (barLineScatterCandleBubbleData.g() < this.d) {
                this.d = barLineScatterCandleBubbleData.g();
            }
            if (barLineScatterCandleBubbleData.e > this.e) {
                this.e = barLineScatterCandleBubbleData.e;
            }
            if (barLineScatterCandleBubbleData.f < this.f) {
                this.f = barLineScatterCandleBubbleData.f;
            }
            if (barLineScatterCandleBubbleData.g > this.g) {
                this.g = barLineScatterCandleBubbleData.g;
            }
            if (barLineScatterCandleBubbleData.h < this.h) {
                this.h = barLineScatterCandleBubbleData.h;
            }
        }
    }

    public LineData l() {
        return this.j;
    }

    public BarData m() {
        return this.k;
    }

    public ScatterData n() {
        return this.l;
    }

    public CandleData o() {
        return this.m;
    }

    public List<BarLineScatterCandleBubbleData> p() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.j;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.k;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.l;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.m;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.n;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }
}
