package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/highlight/RadarHighlighter.class */
public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight a(int i, float f, float f2) {
        List<Highlight> a2 = a(i);
        float d = ((RadarChart) this.f22152a).d(f, f2) / ((RadarChart) this.f22152a).getFactor();
        Highlight highlight = null;
        float f3 = Float.MAX_VALUE;
        int i2 = 0;
        while (i2 < a2.size()) {
            Highlight highlight2 = a2.get(i2);
            float abs = Math.abs(highlight2.b() - d);
            float f4 = f3;
            if (abs < f3) {
                highlight = highlight2;
                f4 = abs;
            }
            i2++;
            f3 = f4;
        }
        return highlight;
    }

    /* JADX WARN: Type inference failed for: r0v35, types: [com.github.mikephil.charting.data.Entry] */
    protected List<Highlight> a(int i) {
        this.b.clear();
        float b = ((RadarChart) this.f22152a).getAnimator().b();
        float a2 = ((RadarChart) this.f22152a).getAnimator().a();
        float sliceAngle = ((RadarChart) this.f22152a).getSliceAngle();
        float factor = ((RadarChart) this.f22152a).getFactor();
        MPPointF a3 = MPPointF.a(0.0f, 0.0f);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= ((RadarData) ((RadarChart) this.f22152a).getData()).d()) {
                return this.b;
            }
            IRadarDataSet a4 = ((RadarData) ((RadarChart) this.f22152a).getData()).a(i3);
            ?? e = a4.e(i);
            float f = i;
            Utils.a(((RadarChart) this.f22152a).getCenterOffsets(), (e.b() - ((RadarChart) this.f22152a).getYChartMin()) * factor * a2, (sliceAngle * f * b) + ((RadarChart) this.f22152a).getRotationAngle(), a3);
            this.b.add(new Highlight(f, e.b(), a3.f22204a, a3.b, i3, a4.C()));
            i2 = i3 + 1;
        }
    }
}
