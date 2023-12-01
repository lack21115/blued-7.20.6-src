package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/XAxisRendererHorizontalBarChart.class */
public class XAxisRendererHorizontalBarChart extends XAxisRenderer {
    protected BarChart n;
    protected Path p;

    public XAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer, BarChart barChart) {
        super(viewPortHandler, xAxis, transformer);
        this.p = new Path();
        this.n = barChart;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        float f4 = f;
        float f5 = f2;
        if (this.o.i() > 10.0f) {
            f4 = f;
            f5 = f2;
            if (!this.o.t()) {
                MPPointD a2 = this.b.a(this.o.f(), this.o.h());
                MPPointD a3 = this.b.a(this.o.f(), this.o.e());
                if (z) {
                    f3 = (float) a3.b;
                    d = a2.b;
                } else {
                    f3 = (float) a2.b;
                    d = a3.b;
                }
                f5 = (float) d;
                MPPointD.a(a2);
                MPPointD.a(a3);
                f4 = f3;
            }
        }
        a(f4, f5);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void a(Canvas canvas) {
        if (this.g.z() && this.g.h()) {
            float u = this.g.u();
            this.d.setTypeface(this.g.w());
            this.d.setTextSize(this.g.x());
            this.d.setColor(this.g.y());
            MPPointF a2 = MPPointF.a(0.0f, 0.0f);
            if (this.g.A() == XAxis.XAxisPosition.TOP) {
                a2.f8597a = 0.0f;
                a2.b = 0.5f;
                a(canvas, this.o.g() + u, a2);
            } else if (this.g.A() == XAxis.XAxisPosition.TOP_INSIDE) {
                a2.f8597a = 1.0f;
                a2.b = 0.5f;
                a(canvas, this.o.g() - u, a2);
            } else if (this.g.A() == XAxis.XAxisPosition.BOTTOM) {
                a2.f8597a = 1.0f;
                a2.b = 0.5f;
                a(canvas, this.o.f() - u, a2);
            } else if (this.g.A() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                a2.f8597a = 1.0f;
                a2.b = 0.5f;
                a(canvas, this.o.f() + u, a2);
            } else {
                a2.f8597a = 0.0f;
                a2.b = 0.5f;
                a(canvas, this.o.g() + u, a2);
                a2.f8597a = 1.0f;
                a2.b = 0.5f;
                a(canvas, this.o.f() - u, a2);
            }
            MPPointF.b(a2);
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void a(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(this.o.g(), f2);
        path.lineTo(this.o.f(), f2);
        canvas.drawPath(path, this.f8562c);
        path.reset();
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void a(Canvas canvas, float f, MPPointF mPPointF) {
        float B = this.g.B();
        boolean c2 = this.g.c();
        int i = this.g.d * 2;
        float[] fArr = new float[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            if (c2) {
                fArr[i3 + 1] = this.g.f8479c[i3 / 2];
            } else {
                fArr[i3 + 1] = this.g.b[i3 / 2];
            }
            i2 = i3 + 2;
        }
        this.b.a(fArr);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                return;
            }
            float f2 = fArr[i5 + 1];
            if (this.o.f(f2)) {
                a(canvas, this.g.q().a(this.g.b[i5 / 2], this.g), f, f2, mPPointF, B);
            }
            i4 = i5 + 2;
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void b(Canvas canvas) {
        if (this.g.b() && this.g.z()) {
            this.e.setColor(this.g.g());
            this.e.setStrokeWidth(this.g.e());
            if (this.g.A() == XAxis.XAxisPosition.TOP || this.g.A() == XAxis.XAxisPosition.TOP_INSIDE || this.g.A() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.o.g(), this.o.e(), this.o.g(), this.o.h(), this.e);
            }
            if (this.g.A() == XAxis.XAxisPosition.BOTTOM || this.g.A() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.g.A() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.o.f(), this.o.e(), this.o.f(), this.o.h(), this.e);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void c() {
        this.d.setTypeface(this.g.w());
        this.d.setTextSize(this.g.x());
        FSize c2 = Utils.c(this.d, this.g.p());
        float u = (int) (c2.f8593a + (this.g.u() * 3.5f));
        float f = c2.b;
        FSize a2 = Utils.a(c2.f8593a, f, this.g.B());
        this.g.C = Math.round(u);
        this.g.D = Math.round(f);
        this.g.E = (int) (a2.f8593a + (this.g.u() * 3.5f));
        this.g.F = Math.round(a2.b);
        FSize.a(a2);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public RectF d() {
        this.j.set(this.o.k());
        this.j.inset(0.0f, -this.f8561a.f());
        return this.j;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void d(Canvas canvas) {
        List<LimitLine> m = this.g.m();
        if (m == null || m.size() <= 0) {
            return;
        }
        float[] fArr = this.k;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.p;
        path.reset();
        for (int i = 0; i < m.size(); i++) {
            LimitLine limitLine = m.get(i);
            if (limitLine.z()) {
                int save = canvas.save();
                this.l.set(this.o.k());
                this.l.inset(0.0f, -limitLine.b());
                canvas.clipRect(this.l);
                this.f.setStyle(Paint.Style.STROKE);
                this.f.setColor(limitLine.c());
                this.f.setStrokeWidth(limitLine.b());
                this.f.setPathEffect(limitLine.d());
                fArr[1] = limitLine.a();
                this.b.a(fArr);
                path.moveTo(this.o.f(), fArr[1]);
                path.lineTo(this.o.g(), fArr[1]);
                canvas.drawPath(path, this.f);
                path.reset();
                String g = limitLine.g();
                if (g != null && !g.equals("")) {
                    this.f.setStyle(limitLine.e());
                    this.f.setPathEffect(null);
                    this.f.setColor(limitLine.y());
                    this.f.setStrokeWidth(0.5f);
                    this.f.setTextSize(limitLine.x());
                    float b = Utils.b(this.f, g);
                    float a2 = Utils.a(4.0f) + limitLine.u();
                    float b2 = limitLine.b() + b + limitLine.v();
                    LimitLine.LimitLabelPosition f = limitLine.f();
                    if (f == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        this.f.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(g, this.o.g() - a2, (fArr[1] - b2) + b, this.f);
                    } else if (f == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.f.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(g, this.o.g() - a2, fArr[1] + b2, this.f);
                    } else if (f == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.f.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(g, this.o.f() + a2, (fArr[1] - b2) + b, this.f);
                    } else {
                        this.f.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(g, this.o.a() + a2, fArr[1] + b2, this.f);
                    }
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
