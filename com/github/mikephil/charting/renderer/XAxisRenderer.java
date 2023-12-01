package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/XAxisRenderer.class */
public class XAxisRenderer extends AxisRenderer {
    protected XAxis g;
    protected Path h;
    protected float[] i;
    protected RectF j;
    protected float[] k;
    protected RectF l;
    float[] m;
    private Path n;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer, xAxis);
        this.h = new Path();
        this.i = new float[2];
        this.j = new RectF();
        this.k = new float[2];
        this.l = new RectF();
        this.m = new float[4];
        this.n = new Path();
        this.g = xAxis;
        this.d.setColor(-16777216);
        this.d.setTextAlign(Paint.Align.CENTER);
        this.d.setTextSize(Utils.a(10.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void a(float f, float f2) {
        super.a(f, f2);
        c();
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        float f4 = f;
        float f5 = f2;
        if (this.o.i() > 10.0f) {
            f4 = f;
            f5 = f2;
            if (!this.o.u()) {
                MPPointD a2 = this.b.a(this.o.f(), this.o.e());
                MPPointD a3 = this.b.a(this.o.g(), this.o.e());
                if (z) {
                    f3 = (float) a3.f8595a;
                    d = a2.f8595a;
                } else {
                    f3 = (float) a2.f8595a;
                    d = a3.f8595a;
                }
                f5 = (float) d;
                MPPointD.a(a2);
                MPPointD.a(a3);
                f4 = f3;
            }
        }
        a(f4, f5);
    }

    public void a(Canvas canvas) {
        if (this.g.z() && this.g.h()) {
            float v = this.g.v();
            this.d.setTypeface(this.g.w());
            this.d.setTextSize(this.g.x());
            this.d.setColor(this.g.y());
            MPPointF a2 = MPPointF.a(0.0f, 0.0f);
            if (this.g.A() == XAxis.XAxisPosition.TOP) {
                a2.f8597a = 0.5f;
                a2.b = 1.0f;
                a(canvas, this.o.e() - v, a2);
            } else if (this.g.A() == XAxis.XAxisPosition.TOP_INSIDE) {
                a2.f8597a = 0.5f;
                a2.b = 1.0f;
                a(canvas, this.o.e() + v + this.g.F, a2);
            } else if (this.g.A() == XAxis.XAxisPosition.BOTTOM) {
                a2.f8597a = 0.5f;
                a2.b = 0.0f;
                a(canvas, this.o.h() + v, a2);
            } else if (this.g.A() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                a2.f8597a = 0.5f;
                a2.b = 0.0f;
                a(canvas, (this.o.h() - v) - this.g.F, a2);
            } else {
                a2.f8597a = 0.5f;
                a2.b = 1.0f;
                a(canvas, this.o.e() - v, a2);
                a2.f8597a = 0.5f;
                a2.b = 0.0f;
                a(canvas, this.o.h() + v, a2);
            }
            MPPointF.b(a2);
        }
    }

    protected void a(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(f, this.o.h());
        path.lineTo(f, this.o.e());
        canvas.drawPath(path, this.f8562c);
        path.reset();
    }

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
                fArr[i3] = this.g.f8479c[i3 / 2];
            } else {
                fArr[i3] = this.g.b[i3 / 2];
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
            float f2 = fArr[i5];
            if (this.o.e(f2)) {
                int i6 = i5 / 2;
                String a2 = this.g.q().a(this.g.b[i6], this.g);
                float f3 = f2;
                if (this.g.C()) {
                    if (i6 != this.g.d - 1 || this.g.d <= 1) {
                        f3 = f2;
                        if (i5 == 0) {
                            f3 = f2 + (Utils.a(this.d, a2) / 2.0f);
                        }
                    } else {
                        float a3 = Utils.a(this.d, a2);
                        f3 = f2;
                        if (a3 > this.o.b() * 2.0f) {
                            f3 = f2;
                            if (f2 + a3 > this.o.n()) {
                                f3 = f2 - (a3 / 2.0f);
                            }
                        }
                    }
                }
                a(canvas, a2, f3, f, mPPointF, B);
            }
            i4 = i5 + 2;
        }
    }

    public void a(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.m;
        fArr2[0] = fArr[0];
        fArr2[1] = this.o.e();
        float[] fArr3 = this.m;
        fArr3[2] = fArr[0];
        fArr3[3] = this.o.h();
        this.n.reset();
        Path path = this.n;
        float[] fArr4 = this.m;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.n;
        float[] fArr5 = this.m;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setColor(limitLine.c());
        this.f.setStrokeWidth(limitLine.b());
        this.f.setPathEffect(limitLine.d());
        canvas.drawPath(this.n, this.f);
    }

    public void a(Canvas canvas, LimitLine limitLine, float[] fArr, float f) {
        String g = limitLine.g();
        if (g == null || g.equals("")) {
            return;
        }
        this.f.setStyle(limitLine.e());
        this.f.setPathEffect(null);
        this.f.setColor(limitLine.y());
        this.f.setStrokeWidth(0.5f);
        this.f.setTextSize(limitLine.x());
        float b = limitLine.b() + limitLine.u();
        LimitLine.LimitLabelPosition f2 = limitLine.f();
        if (f2 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
            float b2 = Utils.b(this.f, g);
            this.f.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(g, fArr[0] + b, this.o.e() + f + b2, this.f);
        } else if (f2 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
            this.f.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(g, fArr[0] + b, this.o.h() - f, this.f);
        } else if (f2 != LimitLine.LimitLabelPosition.LEFT_TOP) {
            this.f.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(g, fArr[0] - b, this.o.h() - f, this.f);
        } else {
            this.f.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(g, fArr[0] - b, this.o.e() + f + Utils.b(this.f, g), this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Canvas canvas, String str, float f, float f2, MPPointF mPPointF, float f3) {
        Utils.a(canvas, str, f, f2, this.d, mPPointF, f3);
    }

    protected void b() {
        this.f8562c.setColor(this.g.d());
        this.f8562c.setStrokeWidth(this.g.f());
        this.f8562c.setPathEffect(this.g.r());
    }

    public void b(Canvas canvas) {
        if (this.g.b() && this.g.z()) {
            this.e.setColor(this.g.g());
            this.e.setStrokeWidth(this.g.e());
            this.e.setPathEffect(this.g.s());
            if (this.g.A() == XAxis.XAxisPosition.TOP || this.g.A() == XAxis.XAxisPosition.TOP_INSIDE || this.g.A() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.o.f(), this.o.e(), this.o.g(), this.o.e(), this.e);
            }
            if (this.g.A() == XAxis.XAxisPosition.BOTTOM || this.g.A() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.g.A() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.o.f(), this.o.h(), this.o.g(), this.o.h(), this.e);
            }
        }
    }

    protected void c() {
        String p = this.g.p();
        this.d.setTypeface(this.g.w());
        this.d.setTextSize(this.g.x());
        FSize c2 = Utils.c(this.d, p);
        float f = c2.f8593a;
        float b = Utils.b(this.d, "Q");
        FSize a2 = Utils.a(f, b, this.g.B());
        this.g.C = Math.round(f);
        this.g.D = Math.round(b);
        this.g.E = Math.round(a2.f8593a);
        this.g.F = Math.round(a2.b);
        FSize.a(a2);
        FSize.a(c2);
    }

    public void c(Canvas canvas) {
        if (!this.g.a() || !this.g.z()) {
            return;
        }
        int save = canvas.save();
        canvas.clipRect(d());
        if (this.i.length != this.f8561a.d * 2) {
            this.i = new float[this.g.d * 2];
        }
        float[] fArr = this.i;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                break;
            }
            int i3 = i2 / 2;
            fArr[i2] = this.g.b[i3];
            fArr[i2 + 1] = this.g.b[i3];
            i = i2 + 2;
        }
        this.b.a(fArr);
        b();
        Path path = this.h;
        path.reset();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= fArr.length) {
                canvas.restoreToCount(save);
                return;
            } else {
                a(canvas, fArr[i5], fArr[i5 + 1], path);
                i4 = i5 + 2;
            }
        }
    }

    public RectF d() {
        this.j.set(this.o.k());
        this.j.inset(-this.f8561a.f(), 0.0f);
        return this.j;
    }

    public void d(Canvas canvas) {
        List<LimitLine> m = this.g.m();
        if (m == null || m.size() <= 0) {
            return;
        }
        float[] fArr = this.k;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m.size()) {
                return;
            }
            LimitLine limitLine = m.get(i2);
            if (limitLine.z()) {
                int save = canvas.save();
                this.l.set(this.o.k());
                this.l.inset(-limitLine.b(), 0.0f);
                canvas.clipRect(this.l);
                fArr[0] = limitLine.a();
                fArr[1] = 0.0f;
                this.b.a(fArr);
                a(canvas, limitLine, fArr);
                a(canvas, limitLine, fArr, limitLine.v() + 2.0f);
                canvas.restoreToCount(save);
            }
            i = i2 + 1;
        }
    }
}
