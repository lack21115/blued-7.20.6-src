package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/highlight/PieRadarHighlighter.class */
public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {

    /* renamed from: a  reason: collision with root package name */
    protected T f22152a;
    protected List<Highlight> b = new ArrayList();

    public PieRadarHighlighter(T t) {
        this.f22152a = t;
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight a(float f, float f2) {
        if (this.f22152a.d(f, f2) > this.f22152a.getRadius()) {
            return null;
        }
        float b = this.f22152a.b(f, f2);
        T t = this.f22152a;
        float f3 = b;
        if (t instanceof PieChart) {
            f3 = b / t.getAnimator().a();
        }
        int a2 = this.f22152a.a(f3);
        if (a2 < 0 || a2 >= this.f22152a.getData().k().H()) {
            return null;
        }
        return a(a2, f, f2);
    }

    protected abstract Highlight a(int i, float f, float f2);
}
