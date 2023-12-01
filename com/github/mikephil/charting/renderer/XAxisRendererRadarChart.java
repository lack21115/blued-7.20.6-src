package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/XAxisRendererRadarChart.class */
public class XAxisRendererRadarChart extends XAxisRenderer {
    private RadarChart n;

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, null);
        this.n = radarChart;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void a(Canvas canvas) {
        if (!this.g.z() || !this.g.h()) {
            return;
        }
        float B = this.g.B();
        MPPointF a2 = MPPointF.a(0.5f, 0.25f);
        this.d.setTypeface(this.g.w());
        this.d.setTextSize(this.g.x());
        this.d.setColor(this.g.y());
        float sliceAngle = this.n.getSliceAngle();
        float factor = this.n.getFactor();
        MPPointF centerOffsets = this.n.getCenterOffsets();
        MPPointF a3 = MPPointF.a(0.0f, 0.0f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ((RadarData) this.n.getData()).k().H()) {
                MPPointF.b(centerOffsets);
                MPPointF.b(a3);
                MPPointF.b(a2);
                return;
            }
            float f = i2;
            String a4 = this.g.q().a(f, this.g);
            Utils.a(centerOffsets, (this.n.getYRange() * factor) + (this.g.E / 2.0f), ((f * sliceAngle) + this.n.getRotationAngle()) % 360.0f, a3);
            a(canvas, a4, a3.f8597a, a3.b - (this.g.F / 2.0f), a2, B);
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void d(Canvas canvas) {
    }
}
