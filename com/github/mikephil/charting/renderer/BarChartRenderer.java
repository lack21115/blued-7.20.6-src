package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/BarChartRenderer.class */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected BarDataProvider f8563a;
    protected RectF b;

    /* renamed from: c  reason: collision with root package name */
    protected BarBuffer[] f8564c;
    protected Paint d;
    protected Paint e;
    private RectF l;

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.b = new RectF();
        this.l = new RectF();
        this.f8563a = barDataProvider;
        this.i = new Paint(1);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setColor(Color.rgb(0, 0, 0));
        this.i.setAlpha(120);
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
        BarData barData = this.f8563a.getBarData();
        this.f8564c = new BarBuffer[barData.d()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f8564c.length) {
                return;
            }
            IBarDataSet iBarDataSet = (IBarDataSet) barData.a(i2);
            this.f8564c[i2] = new BarBuffer(iBarDataSet.H() * 4 * (iBarDataSet.b() ? iBarDataSet.a() : 1), barData.d(), iBarDataSet.b());
            i = i2 + 1;
        }
    }

    protected void a(float f, float f2, float f3, float f4, Transformer transformer) {
        this.b.set(f - f4, f2, f + f4, f3);
        transformer.a(this.b, this.g.a());
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas) {
        BarData barData = this.f8563a.getBarData();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= barData.d()) {
                return;
            }
            IBarDataSet iBarDataSet = (IBarDataSet) barData.a(i2);
            if (iBarDataSet.B()) {
                a(canvas, iBarDataSet, i2);
            }
            i = i2 + 1;
        }
    }

    protected void a(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer a2 = this.f8563a.a(iBarDataSet.C());
        this.e.setColor(iBarDataSet.e());
        this.e.setStrokeWidth(Utils.a(iBarDataSet.d()));
        boolean z = iBarDataSet.d() > 0.0f;
        float b = this.g.b();
        float a3 = this.g.a();
        if (this.f8563a.d()) {
            this.d.setColor(iBarDataSet.c());
            float a4 = this.f8563a.getBarData().a() / 2.0f;
            int min = Math.min((int) Math.ceil(iBarDataSet.H() * b), iBarDataSet.H());
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= min) {
                    break;
                }
                float i4 = ((BarEntry) iBarDataSet.e(i3)).i();
                this.l.left = i4 - a4;
                this.l.right = i4 + a4;
                a2.a(this.l);
                if (this.o.g(this.l.right)) {
                    if (!this.o.h(this.l.left)) {
                        break;
                    }
                    this.l.top = this.o.e();
                    this.l.bottom = this.o.h();
                    canvas.drawRect(this.l, this.d);
                }
                i2 = i3 + 1;
            }
        }
        BarBuffer barBuffer = this.f8564c[i];
        barBuffer.a(b, a3);
        barBuffer.a(i);
        barBuffer.a(this.f8563a.c(iBarDataSet.C()));
        barBuffer.a(this.f8563a.getBarData().a());
        barBuffer.a(iBarDataSet);
        a2.a(barBuffer.b);
        boolean z2 = iBarDataSet.j().size() == 1;
        int i5 = 0;
        if (z2) {
            this.h.setColor(iBarDataSet.k());
            i5 = 0;
        }
        while (i5 < barBuffer.b()) {
            ViewPortHandler viewPortHandler = this.o;
            float[] fArr = barBuffer.b;
            int i6 = i5 + 2;
            if (viewPortHandler.g(fArr[i6])) {
                if (!this.o.h(barBuffer.b[i5])) {
                    return;
                }
                if (!z2) {
                    this.h.setColor(iBarDataSet.a(i5 / 4));
                }
                if (iBarDataSet.l() != null) {
                    GradientColor l = iBarDataSet.l();
                    this.h.setShader(new LinearGradient(barBuffer.b[i5], barBuffer.b[i5 + 3], barBuffer.b[i5], barBuffer.b[i5 + 1], l.a(), l.b(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.m() != null) {
                    Paint paint = this.h;
                    float f = barBuffer.b[i5];
                    float f2 = barBuffer.b[i5 + 3];
                    float f3 = barBuffer.b[i5];
                    float f4 = barBuffer.b[i5 + 1];
                    int i7 = i5 / 4;
                    paint.setShader(new LinearGradient(f, f2, f3, f4, iBarDataSet.b(i7).a(), iBarDataSet.b(i7).b(), Shader.TileMode.MIRROR));
                }
                float f5 = barBuffer.b[i5];
                float[] fArr2 = barBuffer.b;
                int i8 = i5 + 1;
                float f6 = fArr2[i8];
                float f7 = barBuffer.b[i6];
                float[] fArr3 = barBuffer.b;
                int i9 = i5 + 3;
                canvas.drawRect(f5, f6, f7, fArr3[i9], this.h);
                if (z) {
                    canvas.drawRect(barBuffer.b[i5], barBuffer.b[i8], barBuffer.b[i6], barBuffer.b[i9], this.e);
                }
            }
            i5 += 4;
        }
    }

    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.k.setColor(i);
        canvas.drawText(str, f, f2, this.k);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas, Highlight[] highlightArr) {
        float b;
        float f;
        BarData barData = this.f8563a.getBarData();
        int length = highlightArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Highlight highlight = highlightArr[i2];
            IBarDataSet iBarDataSet = (IBarDataSet) barData.a(highlight.f());
            if (iBarDataSet != null && iBarDataSet.p()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.b(highlight.a(), highlight.b());
                if (a(barEntry, iBarDataSet)) {
                    Transformer a2 = this.f8563a.a(iBarDataSet.C());
                    this.i.setColor(iBarDataSet.h());
                    this.i.setAlpha(iBarDataSet.f());
                    if (!(highlight.g() >= 0 && barEntry.d())) {
                        b = barEntry.b();
                        f = 0.0f;
                    } else if (this.f8563a.e()) {
                        b = barEntry.e();
                        f = -barEntry.f();
                    } else {
                        Range range = barEntry.c()[highlight.g()];
                        b = range.f8546a;
                        f = range.b;
                    }
                    a(barEntry.i(), b, f, barData.a() / 2.0f, a2);
                    a(highlight, this.b);
                    canvas.drawRect(this.b, this.i);
                }
            }
            i = i2 + 1;
        }
    }

    protected void a(Highlight highlight, RectF rectF) {
        highlight.a(rectF.centerX(), rectF.top);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        MPPointF mPPointF;
        boolean z;
        List list;
        int i;
        int length;
        float f;
        if (a(this.f8563a)) {
            List i2 = this.f8563a.getBarData().i();
            float a2 = Utils.a(4.5f);
            boolean c2 = this.f8563a.c();
            int i3 = 0;
            while (i3 < this.f8563a.getBarData().d()) {
                IBarDataSet iBarDataSet = (IBarDataSet) i2.get(i3);
                if (a(iBarDataSet)) {
                    b(iBarDataSet);
                    boolean c3 = this.f8563a.c(iBarDataSet.C());
                    float b = Utils.b(this.k, "8");
                    float f2 = c2 ? -a2 : b + a2;
                    float f3 = c2 ? b + a2 : -a2;
                    float f4 = f2;
                    float f5 = f3;
                    if (c3) {
                        f4 = (-f2) - b;
                        f5 = (-f3) - b;
                    }
                    BarBuffer barBuffer = this.f8564c[i3];
                    float a3 = this.g.a();
                    ValueFormatter q = iBarDataSet.q();
                    MPPointF a4 = MPPointF.a(iBarDataSet.A());
                    a4.f8597a = Utils.a(a4.f8597a);
                    a4.b = Utils.a(a4.b);
                    if (iBarDataSet.b()) {
                        List list2 = i2;
                        Transformer a5 = this.f8563a.a(iBarDataSet.C());
                        int i4 = 0;
                        int i5 = 0;
                        float f6 = a2;
                        while (true) {
                            mPPointF = a4;
                            a2 = f6;
                            z = c2;
                            list = list2;
                            if (i4 >= iBarDataSet.H() * this.g.b()) {
                                break;
                            }
                            BarEntry barEntry = (BarEntry) iBarDataSet.e(i4);
                            float[] a6 = barEntry.a();
                            float f7 = (barBuffer.b[i5] + barBuffer.b[i5 + 2]) / 2.0f;
                            int d = iBarDataSet.d(i4);
                            if (a6 != null) {
                                int length2 = a6.length * 2;
                                float[] fArr = new float[length2];
                                float f8 = -barEntry.f();
                                int i6 = 0;
                                int i7 = 0;
                                float f9 = 0.0f;
                                while (i6 < length2) {
                                    float f10 = a6[i7];
                                    int i8 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
                                    if (i8 != 0 || (f9 != 0.0f && f8 != 0.0f)) {
                                        if (i8 >= 0) {
                                            f9 += f10;
                                            f10 = f9;
                                        } else {
                                            float f11 = f8 - f10;
                                            f10 = f8;
                                            f8 = f11;
                                        }
                                    }
                                    fArr[i6 + 1] = f10 * a3;
                                    i6 += 2;
                                    i7++;
                                }
                                a5.a(fArr);
                                for (int i9 = 0; i9 < length2; i9 += 2) {
                                    float f12 = a6[i9 / 2];
                                    float f13 = fArr[i9 + 1] + (((f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1)) == 0 && (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1)) == 0 && (f9 > 0.0f ? 1 : (f9 == 0.0f ? 0 : -1)) > 0) || (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1)) < 0 ? f5 : f4);
                                    if (!this.o.h(f7)) {
                                        break;
                                    }
                                    if (this.o.f(f13) && this.o.g(f7)) {
                                        if (iBarDataSet.y()) {
                                            a(canvas, q.a(f12, barEntry), f7, f13, d);
                                        }
                                        if (barEntry.g() != null && iBarDataSet.z()) {
                                            Drawable g = barEntry.g();
                                            Utils.a(canvas, g, (int) (f7 + a4.f8597a), (int) (f13 + a4.b), g.getIntrinsicWidth(), g.getIntrinsicHeight());
                                        }
                                    }
                                }
                            } else if (!this.o.h(f7)) {
                                mPPointF = a4;
                                a2 = f6;
                                z = c2;
                                list = list2;
                                break;
                            } else {
                                ViewPortHandler viewPortHandler = this.o;
                                float[] fArr2 = barBuffer.b;
                                int i10 = i5 + 1;
                                if (viewPortHandler.f(fArr2[i10]) && this.o.g(f7)) {
                                    if (iBarDataSet.y()) {
                                        a(canvas, q.a(barEntry), f7, barBuffer.b[i10] + (barEntry.b() >= 0.0f ? f4 : f5), d);
                                    }
                                    if (barEntry.g() != null && iBarDataSet.z()) {
                                        Drawable g2 = barEntry.g();
                                        Utils.a(canvas, g2, (int) (a4.f8597a + f7), (int) (barBuffer.b[i10] + (barEntry.b() >= 0.0f ? f4 : f5) + a4.b), g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                    }
                                }
                            }
                            if (a6 == null) {
                                i = i5;
                                length = 4;
                            } else {
                                i = i5;
                                length = a6.length * 4;
                            }
                            i5 = i + length;
                            i4++;
                        }
                    } else {
                        list = i2;
                        for (int i11 = 0; i11 < barBuffer.b.length * this.g.b(); i11 += 4) {
                            float f14 = (barBuffer.b[i11] + barBuffer.b[i11 + 2]) / 2.0f;
                            if (!this.o.h(f14)) {
                                break;
                            }
                            ViewPortHandler viewPortHandler2 = this.o;
                            float[] fArr3 = barBuffer.b;
                            int i12 = i11 + 1;
                            if (viewPortHandler2.f(fArr3[i12]) && this.o.g(f14)) {
                                int i13 = i11 / 4;
                                BarEntry barEntry2 = (BarEntry) iBarDataSet.e(i13);
                                float b2 = barEntry2.b();
                                if (iBarDataSet.y()) {
                                    String a7 = q.a(barEntry2);
                                    float[] fArr4 = barBuffer.b;
                                    a(canvas, a7, f14, b2 >= 0.0f ? fArr4[i12] + f4 : fArr4[i11 + 3] + f5, iBarDataSet.d(i13));
                                }
                                if (barEntry2.g() != null && iBarDataSet.z()) {
                                    Drawable g3 = barEntry2.g();
                                    Utils.a(canvas, g3, (int) (f14 + a4.f8597a), (int) ((b2 >= 0.0f ? barBuffer.b[i12] + f4 : barBuffer.b[i11 + 3] + f5) + a4.b), g3.getIntrinsicWidth(), g3.getIntrinsicHeight());
                                }
                            }
                        }
                        mPPointF = a4;
                        z = c2;
                    }
                    f = a2;
                    c2 = z;
                    MPPointF.b(mPPointF);
                } else {
                    f = a2;
                    list = i2;
                }
                i3++;
                i2 = list;
                a2 = f;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
    }
}
