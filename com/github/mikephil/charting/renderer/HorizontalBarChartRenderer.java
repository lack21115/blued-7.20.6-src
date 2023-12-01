package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/HorizontalBarChartRenderer.class */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF l;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.l = new RectF();
        this.k.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
        BarData barData = this.f22170a.getBarData();
        this.f22171c = new HorizontalBarBuffer[barData.d()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f22171c.length) {
                return;
            }
            IBarDataSet iBarDataSet = (IBarDataSet) barData.a(i2);
            this.f22171c[i2] = new HorizontalBarBuffer(iBarDataSet.H() * 4 * (iBarDataSet.b() ? iBarDataSet.a() : 1), barData.d(), iBarDataSet.b());
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void a(float f, float f2, float f3, float f4, Transformer transformer) {
        this.b.set(f2, f - f4, f3, f + f4);
        transformer.b(this.b, this.g.a());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void a(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer a2 = this.f22170a.a(iBarDataSet.C());
        this.e.setColor(iBarDataSet.e());
        this.e.setStrokeWidth(Utils.a(iBarDataSet.d()));
        boolean z = iBarDataSet.d() > 0.0f;
        float b = this.g.b();
        float a3 = this.g.a();
        if (this.f22170a.d()) {
            this.d.setColor(iBarDataSet.c());
            float a4 = this.f22170a.getBarData().a() / 2.0f;
            int min = Math.min((int) Math.ceil(iBarDataSet.H() * b), iBarDataSet.H());
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= min) {
                    break;
                }
                float i4 = ((BarEntry) iBarDataSet.e(i3)).i();
                this.l.top = i4 - a4;
                this.l.bottom = i4 + a4;
                a2.a(this.l);
                if (this.o.i(this.l.bottom)) {
                    if (!this.o.j(this.l.top)) {
                        break;
                    }
                    this.l.left = this.o.f();
                    this.l.right = this.o.g();
                    canvas.drawRect(this.l, this.d);
                }
                i2 = i3 + 1;
            }
        }
        BarBuffer barBuffer = this.f22171c[i];
        barBuffer.a(b, a3);
        barBuffer.a(i);
        barBuffer.a(this.f22170a.c(iBarDataSet.C()));
        barBuffer.a(this.f22170a.getBarData().a());
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
            int i6 = i5 + 3;
            if (!viewPortHandler.i(fArr[i6])) {
                return;
            }
            ViewPortHandler viewPortHandler2 = this.o;
            float[] fArr2 = barBuffer.b;
            int i7 = i5 + 1;
            if (viewPortHandler2.j(fArr2[i7])) {
                if (!z2) {
                    this.h.setColor(iBarDataSet.a(i5 / 4));
                }
                float f = barBuffer.b[i5];
                float f2 = barBuffer.b[i7];
                float[] fArr3 = barBuffer.b;
                int i8 = i5 + 2;
                canvas.drawRect(f, f2, fArr3[i8], barBuffer.b[i6], this.h);
                if (z) {
                    canvas.drawRect(barBuffer.b[i5], barBuffer.b[i7], barBuffer.b[i8], barBuffer.b[i6], this.e);
                }
            }
            i5 += 4;
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.k.setColor(i);
        canvas.drawText(str, f, f2, this.k);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void a(Highlight highlight, RectF rectF) {
        highlight.a(rectF.centerY(), rectF.right);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public boolean a(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().j()) < ((float) chartInterface.getMaxVisibleCount()) * this.o.r();
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        MPPointF mPPointF;
        float f;
        float f2;
        int i;
        int length;
        if (!a(this.f22170a)) {
            return;
        }
        List i2 = this.f22170a.getBarData().i();
        float a2 = Utils.a(5.0f);
        boolean c2 = this.f22170a.c();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.f22170a.getBarData().d()) {
                return;
            }
            IBarDataSet iBarDataSet = (IBarDataSet) i2.get(i4);
            if (a(iBarDataSet)) {
                boolean c3 = this.f22170a.c(iBarDataSet.C());
                b(iBarDataSet);
                float b = Utils.b(this.k, "10") / 2.0f;
                ValueFormatter q = iBarDataSet.q();
                BarBuffer barBuffer = this.f22171c[i4];
                float a3 = this.g.a();
                MPPointF a4 = MPPointF.a(iBarDataSet.A());
                a4.f22204a = Utils.a(a4.f22204a);
                a4.b = Utils.a(a4.b);
                if (iBarDataSet.b()) {
                    List list = i2;
                    Transformer a5 = this.f22170a.a(iBarDataSet.C());
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        mPPointF = a4;
                        i2 = list;
                        i4 = i4;
                        if (i5 >= iBarDataSet.H() * this.g.b()) {
                            break;
                        }
                        BarEntry barEntry = (BarEntry) iBarDataSet.e(i5);
                        int d = iBarDataSet.d(i5);
                        float[] a6 = barEntry.a();
                        if (a6 == null) {
                            ViewPortHandler viewPortHandler = this.o;
                            float[] fArr = barBuffer.b;
                            int i7 = i6 + 1;
                            if (!viewPortHandler.i(fArr[i7])) {
                                mPPointF = a4;
                                i2 = list;
                                i4 = i4;
                                break;
                            } else if (this.o.e(barBuffer.b[i6]) && this.o.j(barBuffer.b[i7])) {
                                String a7 = q.a(barEntry);
                                float a8 = Utils.a(this.k, a7);
                                float f3 = c2 ? a2 : -(a8 + a2);
                                float f4 = c2 ? -(a8 + a2) : a2;
                                float f5 = f3;
                                float f6 = f4;
                                if (c3) {
                                    f5 = (-f3) - a8;
                                    f6 = (-f4) - a8;
                                }
                                float f7 = f5;
                                if (iBarDataSet.y()) {
                                    a(canvas, a7, barBuffer.b[i6 + 2] + (barEntry.b() >= 0.0f ? f7 : f6), barBuffer.b[i7] + b, d);
                                }
                                if (barEntry.g() != null && iBarDataSet.z()) {
                                    Drawable g = barEntry.g();
                                    float f8 = barBuffer.b[i6 + 2];
                                    if (barEntry.b() < 0.0f) {
                                        f7 = f6;
                                    }
                                    Utils.a(canvas, g, (int) (f8 + f7 + a4.f22204a), (int) (barBuffer.b[i7] + a4.b), g.getIntrinsicWidth(), g.getIntrinsicHeight());
                                }
                            }
                        } else {
                            int length2 = a6.length * 2;
                            float[] fArr2 = new float[length2];
                            float f9 = -barEntry.f();
                            int i8 = 0;
                            int i9 = 0;
                            float f10 = 0.0f;
                            while (true) {
                                f = f10;
                                if (i8 >= length2) {
                                    break;
                                }
                                float f11 = a6[i9];
                                int i10 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
                                if (i10 == 0 && (f == 0.0f || f9 == 0.0f)) {
                                    f2 = f;
                                } else if (i10 >= 0) {
                                    f2 = f + f11;
                                    f11 = f2;
                                } else {
                                    float f12 = f9 - f11;
                                    f2 = f;
                                    f11 = f9;
                                    f9 = f12;
                                }
                                fArr2[i8] = f11 * a3;
                                i8 += 2;
                                i9++;
                                f10 = f2;
                            }
                            a5.a(fArr2);
                            for (int i11 = 0; i11 < length2; i11 += 2) {
                                float f13 = a6[i11 / 2];
                                String a9 = q.a(f13, barEntry);
                                float a10 = Utils.a(this.k, a9);
                                float f14 = c2 ? a2 : -(a10 + a2);
                                float f15 = c2 ? -(a10 + a2) : a2;
                                float f16 = f14;
                                float f17 = f15;
                                if (c3) {
                                    f16 = (-f14) - a10;
                                    f17 = (-f15) - a10;
                                }
                                boolean z = (f13 == 0.0f && f9 == 0.0f && f > 0.0f) || f13 < 0.0f;
                                float f18 = fArr2[i11];
                                if (z) {
                                    f16 = f17;
                                }
                                float f19 = f18 + f16;
                                float f20 = (barBuffer.b[i6 + 1] + barBuffer.b[i6 + 3]) / 2.0f;
                                if (!this.o.i(f20)) {
                                    break;
                                }
                                if (this.o.e(f19) && this.o.j(f20)) {
                                    if (iBarDataSet.y()) {
                                        a(canvas, a9, f19, f20 + b, d);
                                    }
                                    if (barEntry.g() != null && iBarDataSet.z()) {
                                        Drawable g2 = barEntry.g();
                                        Utils.a(canvas, g2, (int) (f19 + a4.f22204a), (int) (f20 + a4.b), g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                    }
                                }
                            }
                        }
                        if (a6 == null) {
                            i = i6;
                            length = 4;
                        } else {
                            i = i6;
                            length = a6.length * 4;
                        }
                        i5++;
                        i6 = i + length;
                    }
                } else {
                    List list2 = i2;
                    for (int i12 = 0; i12 < barBuffer.b.length * this.g.b(); i12 += 4) {
                        float[] fArr3 = barBuffer.b;
                        int i13 = i12 + 1;
                        float f21 = (fArr3[i13] + barBuffer.b[i12 + 3]) / 2.0f;
                        if (!this.o.i(barBuffer.b[i13])) {
                            break;
                        }
                        if (this.o.e(barBuffer.b[i12]) && this.o.j(barBuffer.b[i13])) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.e(i12 / 4);
                            float b2 = barEntry2.b();
                            String a11 = q.a(barEntry2);
                            float a12 = Utils.a(this.k, a11);
                            float f22 = c2 ? a2 : -(a12 + a2);
                            float f23 = c2 ? -(a12 + a2) : a2;
                            float f24 = f22;
                            float f25 = f23;
                            if (c3) {
                                f24 = (-f22) - a12;
                                f25 = (-f23) - a12;
                            }
                            float f26 = f24;
                            if (iBarDataSet.y()) {
                                a(canvas, a11, barBuffer.b[i12 + 2] + (b2 >= 0.0f ? f26 : f25), f21 + b, iBarDataSet.d(i12 / 2));
                            }
                            if (barEntry2.g() != null && iBarDataSet.z()) {
                                Drawable g3 = barEntry2.g();
                                float f27 = barBuffer.b[i12 + 2];
                                if (b2 < 0.0f) {
                                    f26 = f25;
                                }
                                Utils.a(canvas, g3, (int) (f27 + f26 + a4.f22204a), (int) (f21 + a4.b), g3.getIntrinsicWidth(), g3.getIntrinsicHeight());
                            }
                        }
                    }
                    mPPointF = a4;
                    i2 = list2;
                }
                MPPointF.b(mPPointF);
            }
            i3 = i4 + 1;
        }
    }
}
