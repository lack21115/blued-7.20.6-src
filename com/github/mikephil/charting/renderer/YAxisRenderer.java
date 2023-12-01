package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
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

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/YAxisRenderer.class */
public class YAxisRenderer extends AxisRenderer {
    protected YAxis g;
    protected Paint h;
    protected Path i;
    protected RectF j;
    protected float[] k;
    protected Path l;
    protected RectF m;
    protected Path n;
    protected float[] p;
    protected RectF q;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer, yAxis);
        this.i = new Path();
        this.j = new RectF();
        this.k = new float[2];
        this.l = new Path();
        this.m = new RectF();
        this.n = new Path();
        this.p = new float[2];
        this.q = new RectF();
        this.g = yAxis;
        if (this.o != null) {
            this.d.setColor(-16777216);
            this.d.setTextSize(Utils.a(10.0f));
            Paint paint = new Paint(1);
            this.h = paint;
            paint.setColor(Color.GRAY);
            this.h.setStrokeWidth(1.0f);
            this.h.setStyle(Paint.Style.STROKE);
        }
    }

    protected Path a(Path path, int i, float[] fArr) {
        int i2 = i + 1;
        path.moveTo(this.o.a(), fArr[i2]);
        path.lineTo(this.o.g(), fArr[i2]);
        return path;
    }

    public void a(Canvas canvas) {
        float g;
        float g2;
        float f;
        if (this.g.z() && this.g.h()) {
            float[] c2 = c();
            this.d.setTypeface(this.g.w());
            this.d.setTextSize(this.g.x());
            this.d.setColor(this.g.y());
            float u = this.g.u();
            float b = Utils.b(this.d, "A") / 2.5f;
            float v = this.g.v();
            YAxis.AxisDependency A = this.g.A();
            YAxis.YAxisLabelPosition D = this.g.D();
            if (A == YAxis.AxisDependency.LEFT) {
                if (D == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.d.setTextAlign(Paint.Align.RIGHT);
                    g = this.o.a();
                    f = g - u;
                } else {
                    this.d.setTextAlign(Paint.Align.LEFT);
                    g2 = this.o.a();
                    f = g2 + u;
                }
            } else if (D == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.d.setTextAlign(Paint.Align.LEFT);
                g2 = this.o.g();
                f = g2 + u;
            } else {
                this.d.setTextAlign(Paint.Align.RIGHT);
                g = this.o.g();
                f = g - u;
            }
            a(canvas, f, c2, b + v);
        }
    }

    protected void a(Canvas canvas, float f, float[] fArr, float f2) {
        int i = this.g.E() ? this.g.d : this.g.d - 1;
        for (int i2 = !this.g.F(); i2 < i; i2++) {
            canvas.drawText(this.g.b(i2), f, fArr[(i2 * 2) + 1] + f2, this.d);
        }
    }

    public RectF b() {
        this.j.set(this.o.k());
        this.j.inset(0.0f, -this.f22168a.f());
        return this.j;
    }

    public void b(Canvas canvas) {
        if (this.g.z() && this.g.b()) {
            this.e.setColor(this.g.g());
            this.e.setStrokeWidth(this.g.e());
            if (this.g.A() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.o.f(), this.o.e(), this.o.f(), this.o.h(), this.e);
            } else {
                canvas.drawLine(this.o.g(), this.o.e(), this.o.g(), this.o.h(), this.e);
            }
        }
    }

    public void c(Canvas canvas) {
        if (this.g.z()) {
            if (this.g.a()) {
                int save = canvas.save();
                canvas.clipRect(b());
                float[] c2 = c();
                this.f22169c.setColor(this.g.d());
                this.f22169c.setStrokeWidth(this.g.f());
                this.f22169c.setPathEffect(this.g.r());
                Path path = this.i;
                path.reset();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= c2.length) {
                        break;
                    }
                    canvas.drawPath(a(path, i2, c2), this.f22169c);
                    path.reset();
                    i = i2 + 2;
                }
                canvas.restoreToCount(save);
            }
            if (this.g.J()) {
                d(canvas);
            }
        }
    }

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
            fArr[i2 + 1] = this.g.b[i2 / 2];
            i = i2 + 2;
        }
    }

    protected void d(Canvas canvas) {
        int save = canvas.save();
        this.m.set(this.o.k());
        this.m.inset(0.0f, -this.g.L());
        canvas.clipRect(this.m);
        MPPointD b = this.b.b(0.0f, 0.0f);
        this.h.setColor(this.g.K());
        this.h.setStrokeWidth(this.g.L());
        Path path = this.l;
        path.reset();
        path.moveTo(this.o.f(), (float) b.b);
        path.lineTo(this.o.g(), (float) b.b);
        canvas.drawPath(path, this.h);
        canvas.restoreToCount(save);
    }

    public void e(Canvas canvas) {
        List<LimitLine> m = this.g.m();
        if (m == null || m.size() <= 0) {
            return;
        }
        float[] fArr = this.p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.n;
        path.reset();
        for (int i = 0; i < m.size(); i++) {
            LimitLine limitLine = m.get(i);
            if (limitLine.z()) {
                int save = canvas.save();
                this.q.set(this.o.k());
                this.q.inset(0.0f, -limitLine.b());
                canvas.clipRect(this.q);
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
                    this.f.setTypeface(limitLine.w());
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
