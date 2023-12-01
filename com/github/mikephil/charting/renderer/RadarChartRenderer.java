package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/RadarChartRenderer.class */
public class RadarChartRenderer extends LineRadarRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected RadarChart f22193a;
    protected Paint b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f22194c;
    protected Path d;
    protected Path e;

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.d = new Path();
        this.e = new Path();
        this.f22193a = radarChart;
        this.i = new Paint(1);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(2.0f);
        this.i.setColor(Color.rgb(255, 187, 115));
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f22194c = new Paint(1);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas) {
        RadarData radarData = (RadarData) this.f22193a.getData();
        int H = radarData.k().H();
        for (IRadarDataSet iRadarDataSet : radarData.i()) {
            if (iRadarDataSet.B()) {
                a(canvas, iRadarDataSet, H);
            }
        }
    }

    protected void a(Canvas canvas, IRadarDataSet iRadarDataSet, int i) {
        float b = this.g.b();
        float a2 = this.g.a();
        float sliceAngle = this.f22193a.getSliceAngle();
        float factor = this.f22193a.getFactor();
        MPPointF centerOffsets = this.f22193a.getCenterOffsets();
        MPPointF a3 = MPPointF.a(0.0f, 0.0f);
        Path path = this.d;
        path.reset();
        boolean z = false;
        for (int i2 = 0; i2 < iRadarDataSet.H(); i2++) {
            this.h.setColor(iRadarDataSet.a(i2));
            Utils.a(centerOffsets, (((RadarEntry) iRadarDataSet.e(i2)).b() - this.f22193a.getYChartMin()) * factor * a2, (i2 * sliceAngle * b) + this.f22193a.getRotationAngle(), a3);
            if (!Float.isNaN(a3.f22204a)) {
                if (z) {
                    path.lineTo(a3.f22204a, a3.b);
                } else {
                    path.moveTo(a3.f22204a, a3.b);
                    z = true;
                }
            }
        }
        if (iRadarDataSet.H() > i) {
            path.lineTo(centerOffsets.f22204a, centerOffsets.b);
        }
        path.close();
        if (iRadarDataSet.S()) {
            Drawable P = iRadarDataSet.P();
            if (P != null) {
                a(canvas, path, P);
            } else {
                a(canvas, path, iRadarDataSet.O(), iRadarDataSet.Q());
            }
        }
        this.h.setStrokeWidth(iRadarDataSet.R());
        this.h.setStyle(Paint.Style.STROKE);
        if (!iRadarDataSet.S() || iRadarDataSet.Q() < 255) {
            canvas.drawPath(path, this.h);
        }
        MPPointF.b(centerOffsets);
        MPPointF.b(a3);
    }

    public void a(Canvas canvas, MPPointF mPPointF, float f, float f2, int i, int i2, float f3) {
        canvas.save();
        float a2 = Utils.a(f2);
        float a3 = Utils.a(f);
        if (i != 1122867) {
            Path path = this.e;
            path.reset();
            path.addCircle(mPPointF.f22204a, mPPointF.b, a2, Path.Direction.CW);
            if (a3 > 0.0f) {
                path.addCircle(mPPointF.f22204a, mPPointF.b, a3, Path.Direction.CCW);
            }
            this.f22194c.setColor(i);
            this.f22194c.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.f22194c);
        }
        if (i2 != 1122867) {
            this.f22194c.setColor(i2);
            this.f22194c.setStyle(Paint.Style.STROKE);
            this.f22194c.setStrokeWidth(Utils.a(f3));
            canvas.drawCircle(mPPointF.f22204a, mPPointF.b, a2, this.f22194c);
        }
        canvas.restore();
    }

    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.k.setColor(i);
        canvas.drawText(str, f, f2, this.k);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas, Highlight[] highlightArr) {
        float sliceAngle = this.f22193a.getSliceAngle();
        float factor = this.f22193a.getFactor();
        MPPointF centerOffsets = this.f22193a.getCenterOffsets();
        MPPointF a2 = MPPointF.a(0.0f, 0.0f);
        RadarData radarData = (RadarData) this.f22193a.getData();
        int length = highlightArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                MPPointF.b(centerOffsets);
                MPPointF.b(a2);
                return;
            }
            Highlight highlight = highlightArr[i2];
            IRadarDataSet a3 = radarData.a(highlight.f());
            if (a3 != null && a3.p()) {
                Entry entry = (RadarEntry) a3.e((int) highlight.a());
                if (a(entry, a3)) {
                    Utils.a(centerOffsets, (entry.b() - this.f22193a.getYChartMin()) * factor * this.g.a(), (highlight.a() * sliceAngle * this.g.b()) + this.f22193a.getRotationAngle(), a2);
                    highlight.a(a2.f22204a, a2.b);
                    a(canvas, a2.f22204a, a2.b, a3);
                    if (a3.a() && !Float.isNaN(a2.f22204a) && !Float.isNaN(a2.b)) {
                        int c2 = a3.c();
                        int i3 = c2;
                        if (c2 == 1122867) {
                            i3 = a3.a(0);
                        }
                        int i4 = i3;
                        if (a3.d() < 255) {
                            i4 = ColorTemplate.a(i3, a3.d());
                        }
                        a(canvas, a2, a3.e(), a3.f(), a3.b(), i4, a3.g());
                    }
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        float b = this.g.b();
        float a2 = this.g.a();
        float sliceAngle = this.f22193a.getSliceAngle();
        float factor = this.f22193a.getFactor();
        MPPointF centerOffsets = this.f22193a.getCenterOffsets();
        MPPointF a3 = MPPointF.a(0.0f, 0.0f);
        MPPointF a4 = MPPointF.a(0.0f, 0.0f);
        float a5 = Utils.a(5.0f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ((RadarData) this.f22193a.getData()).d()) {
                MPPointF.b(centerOffsets);
                MPPointF.b(a3);
                MPPointF.b(a4);
                return;
            }
            IRadarDataSet a6 = ((RadarData) this.f22193a.getData()).a(i2);
            if (a(a6)) {
                b(a6);
                ValueFormatter q = a6.q();
                MPPointF a7 = MPPointF.a(a6.A());
                a7.f22204a = Utils.a(a7.f22204a);
                a7.b = Utils.a(a7.b);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= a6.H()) {
                        break;
                    }
                    RadarEntry radarEntry = (RadarEntry) a6.e(i4);
                    float f = i4 * sliceAngle * b;
                    Utils.a(centerOffsets, (radarEntry.b() - this.f22193a.getYChartMin()) * factor * a2, f + this.f22193a.getRotationAngle(), a3);
                    if (a6.y()) {
                        a(canvas, q.a(radarEntry), a3.f22204a, a3.b - a5, a6.d(i4));
                    }
                    if (radarEntry.g() != null && a6.z()) {
                        Drawable g = radarEntry.g();
                        Utils.a(centerOffsets, (radarEntry.b() * factor * a2) + a7.b, f + this.f22193a.getRotationAngle(), a4);
                        a4.b += a7.f22204a;
                        Utils.a(canvas, g, (int) a4.f22204a, (int) a4.b, g.getIntrinsicWidth(), g.getIntrinsicHeight());
                    }
                    i3 = i4 + 1;
                }
                MPPointF.b(a7);
            }
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        d(canvas);
    }

    protected void d(Canvas canvas) {
        float sliceAngle = this.f22193a.getSliceAngle();
        float factor = this.f22193a.getFactor();
        float rotationAngle = this.f22193a.getRotationAngle();
        MPPointF centerOffsets = this.f22193a.getCenterOffsets();
        this.b.setStrokeWidth(this.f22193a.getWebLineWidth());
        this.b.setColor(this.f22193a.getWebColor());
        this.b.setAlpha(this.f22193a.getWebAlpha());
        int skipWebLineCount = this.f22193a.getSkipWebLineCount();
        int H = ((RadarData) this.f22193a.getData()).k().H();
        MPPointF a2 = MPPointF.a(0.0f, 0.0f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= H) {
                break;
            }
            Utils.a(centerOffsets, this.f22193a.getYRange() * factor, (i2 * sliceAngle) + rotationAngle, a2);
            canvas.drawLine(centerOffsets.f22204a, centerOffsets.b, a2.f22204a, a2.b, this.b);
            i = i2 + skipWebLineCount + 1;
        }
        MPPointF.b(a2);
        this.b.setStrokeWidth(this.f22193a.getWebLineWidthInner());
        this.b.setColor(this.f22193a.getWebColorInner());
        this.b.setAlpha(this.f22193a.getWebAlpha());
        int i3 = this.f22193a.getYAxis().d;
        MPPointF a3 = MPPointF.a(0.0f, 0.0f);
        MPPointF a4 = MPPointF.a(0.0f, 0.0f);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                MPPointF.b(a3);
                MPPointF.b(a4);
                return;
            }
            int i6 = 0;
            while (i6 < ((RadarData) this.f22193a.getData()).j()) {
                float yChartMin = (this.f22193a.getYAxis().b[i5] - this.f22193a.getYChartMin()) * factor;
                Utils.a(centerOffsets, yChartMin, (i6 * sliceAngle) + rotationAngle, a3);
                i6++;
                Utils.a(centerOffsets, yChartMin, (i6 * sliceAngle) + rotationAngle, a4);
                canvas.drawLine(a3.f22204a, a3.b, a4.f22204a, a4.b, this.b);
            }
            i4 = i5 + 1;
        }
    }
}
