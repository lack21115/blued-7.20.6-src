package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/YAxisRendererHorizontalBarChart.class */
public class YAxisRendererHorizontalBarChart extends YAxisRenderer {
    protected Path r;
    protected Path s;
    protected float[] t;

    public YAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, yAxis, transformer);
        this.r = new Path();
        this.s = new Path();
        this.t = new float[4];
        this.f.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected Path a(Path path, int i, float[] fArr) {
        path.moveTo(fArr[i], this.o.e());
        path.lineTo(fArr[i], this.o.h());
        return path;
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        float f4 = f;
        float f5 = f2;
        if (this.o.j() > 10.0f) {
            f4 = f;
            f5 = f2;
            if (!this.o.u()) {
                MPPointD a2 = this.b.a(this.o.f(), this.o.e());
                MPPointD a3 = this.b.a(this.o.g(), this.o.e());
                if (z) {
                    f3 = (float) a3.f22202a;
                    d = a2.f22202a;
                } else {
                    f3 = (float) a2.f22202a;
                    d = a3.f22202a;
                }
                f5 = (float) d;
                MPPointD.a(a2);
                MPPointD.a(a3);
                f4 = f3;
            }
        }
        a(f4, f5);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void a(Canvas canvas) {
        float h;
        if (this.g.z() && this.g.h()) {
            float[] c2 = c();
            this.d.setTypeface(this.g.w());
            this.d.setTextSize(this.g.x());
            this.d.setColor(this.g.y());
            this.d.setTextAlign(Paint.Align.CENTER);
            float a2 = Utils.a(2.5f);
            float b = Utils.b(this.d, "Q");
            YAxis.AxisDependency A = this.g.A();
            YAxis.YAxisLabelPosition D = this.g.D();
            if (A == YAxis.AxisDependency.LEFT) {
                h = (D == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.o.e() : this.o.e()) - a2;
            } else {
                h = (D == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.o.h() : this.o.h()) + b + a2;
            }
            a(canvas, h, c2, this.g.v());
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void a(Canvas canvas, float f, float[] fArr, float f2) {
        this.d.setTypeface(this.g.w());
        this.d.setTextSize(this.g.x());
        this.d.setColor(this.g.y());
        int i = this.g.E() ? this.g.d : this.g.d - 1;
        for (int i2 = !this.g.F(); i2 < i; i2++) {
            canvas.drawText(this.g.b(i2), fArr[i2 * 2], f - f2, this.d);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public RectF b() {
        this.j.set(this.o.k());
        this.j.inset(-this.f22168a.f(), 0.0f);
        return this.j;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void b(Canvas canvas) {
        if (this.g.z() && this.g.b()) {
            this.e.setColor(this.g.g());
            this.e.setStrokeWidth(this.g.e());
            if (this.g.A() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.o.f(), this.o.e(), this.o.g(), this.o.e(), this.e);
            } else {
                canvas.drawLine(this.o.f(), this.o.h(), this.o.g(), this.o.h(), this.e);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected float[] c() {
        if (this.k.length != this.g.d * 2) {
            this.k = new float[this.g.d * 2];
        }
        float[] fArr = this.k;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                this.b.a(fArr);
                return fArr;
            }
            fArr[i2] = this.g.b[i2 / 2];
            i = i2 + 2;
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void d(Canvas canvas) {
        int save = canvas.save();
        this.m.set(this.o.k());
        this.m.inset(-this.g.L(), 0.0f);
        canvas.clipRect(this.q);
        MPPointD b = this.b.b(0.0f, 0.0f);
        this.h.setColor(this.g.K());
        this.h.setStrokeWidth(this.g.L());
        Path path = this.r;
        path.reset();
        path.moveTo(((float) b.f22202a) - 1.0f, this.o.e());
        path.lineTo(((float) b.f22202a) - 1.0f, this.o.h());
        canvas.drawPath(path, this.h);
        canvas.restoreToCount(save);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void e(Canvas canvas) {
        List<LimitLine> m = this.g.m();
        if (m == null || m.size() <= 0) {
            return;
        }
        float[] fArr = this.t;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        Path path = this.s;
        path.reset();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m.size()) {
                return;
            }
            LimitLine limitLine = m.get(i2);
            if (limitLine.z()) {
                int save = canvas.save();
                this.q.set(this.o.k());
                this.q.inset(-limitLine.b(), 0.0f);
                canvas.clipRect(this.q);
                fArr[0] = limitLine.a();
                fArr[2] = limitLine.a();
                this.b.a(fArr);
                fArr[1] = this.o.e();
                fArr[3] = this.o.h();
                path.moveTo(fArr[0], fArr[1]);
                path.lineTo(fArr[2], fArr[3]);
                this.f.setStyle(Paint.Style.STROKE);
                this.f.setColor(limitLine.c());
                this.f.setPathEffect(limitLine.d());
                this.f.setStrokeWidth(limitLine.b());
                canvas.drawPath(path, this.f);
                path.reset();
                String g = limitLine.g();
                if (g != null && !g.equals("")) {
                    this.f.setStyle(limitLine.e());
                    this.f.setPathEffect(null);
                    this.f.setColor(limitLine.y());
                    this.f.setTypeface(limitLine.w());
                    this.f.setStrokeWidth(0.5f);
                    this.f.setTextSize(limitLine.x());
                    float b = limitLine.b() + limitLine.u();
                    float a2 = Utils.a(2.0f) + limitLine.v();
                    LimitLine.LimitLabelPosition f = limitLine.f();
                    if (f == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        float b2 = Utils.b(this.f, g);
                        this.f.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(g, fArr[0] + b, this.o.e() + a2 + b2, this.f);
                    } else if (f == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.f.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(g, fArr[0] + b, this.o.h() - a2, this.f);
                    } else if (f == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.f.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(g, fArr[0] - b, this.o.e() + a2 + Utils.b(this.f, g), this.f);
                    } else {
                        this.f.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(g, fArr[0] - b, this.o.h() - a2, this.f);
                    }
                }
                canvas.restoreToCount(save);
            }
            i = i2 + 1;
        }
    }
}
