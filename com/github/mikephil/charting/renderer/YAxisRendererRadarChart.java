package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/YAxisRendererRadarChart.class */
public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart r;
    private Path s;

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, null);
        this.s = new Path();
        this.r = radarChart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void a(float f, float f2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void a(Canvas canvas) {
        if (this.g.z() && this.g.h()) {
            this.d.setTypeface(this.g.w());
            this.d.setTextSize(this.g.x());
            this.d.setColor(this.g.y());
            MPPointF centerOffsets = this.r.getCenterOffsets();
            MPPointF a2 = MPPointF.a(0.0f, 0.0f);
            float factor = this.r.getFactor();
            int i = this.g.E() ? this.g.d : this.g.d - 1;
            for (int i2 = !this.g.F(); i2 < i; i2++) {
                Utils.a(centerOffsets, (this.g.b[i2] - this.g.u) * factor, this.r.getRotationAngle(), a2);
                canvas.drawText(this.g.b(i2), a2.f8597a + 10.0f, a2.b, this.d);
            }
            MPPointF.b(centerOffsets);
            MPPointF.b(a2);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void e(Canvas canvas) {
        List<LimitLine> m = this.g.m();
        if (m == null) {
            return;
        }
        float sliceAngle = this.r.getSliceAngle();
        float factor = this.r.getFactor();
        MPPointF centerOffsets = this.r.getCenterOffsets();
        MPPointF a2 = MPPointF.a(0.0f, 0.0f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m.size()) {
                MPPointF.b(centerOffsets);
                MPPointF.b(a2);
                return;
            }
            LimitLine limitLine = m.get(i2);
            if (limitLine.z()) {
                this.f.setColor(limitLine.c());
                this.f.setPathEffect(limitLine.d());
                this.f.setStrokeWidth(limitLine.b());
                float a3 = limitLine.a();
                float yChartMin = this.r.getYChartMin();
                Path path = this.s;
                path.reset();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= ((RadarData) this.r.getData()).k().H()) {
                        break;
                    }
                    Utils.a(centerOffsets, (a3 - yChartMin) * factor, (i4 * sliceAngle) + this.r.getRotationAngle(), a2);
                    if (i4 == 0) {
                        path.moveTo(a2.f8597a, a2.b);
                    } else {
                        path.lineTo(a2.f8597a, a2.b);
                    }
                    i3 = i4 + 1;
                }
                path.close();
                canvas.drawPath(path, this.f);
            }
            i = i2 + 1;
        }
    }
}
