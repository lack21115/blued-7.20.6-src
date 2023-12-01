package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/CandleStickChartRenderer.class */
public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected CandleDataProvider f8569a;
    private float[] b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f8570c;
    private float[] d;
    private float[] e;
    private float[] l;

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.b = new float[8];
        this.f8570c = new float[4];
        this.d = new float[4];
        this.e = new float[4];
        this.l = new float[4];
        this.f8569a = candleDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas) {
        for (T t : this.f8569a.getCandleData().i()) {
            if (t.B()) {
                a(canvas, t);
            }
        }
    }

    protected void a(Canvas canvas, ICandleDataSet iCandleDataSet) {
        Transformer a2 = this.f8569a.a(iCandleDataSet.C());
        float a3 = this.g.a();
        float a4 = iCandleDataSet.a();
        boolean c2 = iCandleDataSet.c();
        this.f.a(this.f8569a, iCandleDataSet);
        this.h.setStrokeWidth(iCandleDataSet.b());
        int i = this.f.f8565a;
        while (true) {
            int i2 = i;
            if (i2 > this.f.f8566c + this.f.f8565a) {
                return;
            }
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.e(i2);
            if (candleEntry != null) {
                float i3 = candleEntry.i();
                float e = candleEntry.e();
                float d = candleEntry.d();
                float a5 = candleEntry.a();
                float c3 = candleEntry.c();
                if (c2) {
                    float[] fArr = this.b;
                    fArr[0] = i3;
                    fArr[2] = i3;
                    fArr[4] = i3;
                    fArr[6] = i3;
                    int i4 = (e > d ? 1 : (e == d ? 0 : -1));
                    if (i4 > 0) {
                        fArr[1] = a5 * a3;
                        fArr[3] = e * a3;
                        fArr[5] = c3 * a3;
                        fArr[7] = d * a3;
                    } else if (e < d) {
                        fArr[1] = a5 * a3;
                        fArr[3] = d * a3;
                        fArr[5] = c3 * a3;
                        fArr[7] = e * a3;
                    } else {
                        fArr[1] = a5 * a3;
                        fArr[3] = e * a3;
                        fArr[5] = c3 * a3;
                        fArr[7] = fArr[3];
                    }
                    a2.a(this.b);
                    if (!iCandleDataSet.F()) {
                        this.h.setColor(iCandleDataSet.E() == 1122867 ? iCandleDataSet.a(i2) : iCandleDataSet.E());
                    } else if (i4 > 0) {
                        this.h.setColor(iCandleDataSet.f() == 1122867 ? iCandleDataSet.a(i2) : iCandleDataSet.f());
                    } else if (e < d) {
                        this.h.setColor(iCandleDataSet.e() == 1122867 ? iCandleDataSet.a(i2) : iCandleDataSet.e());
                    } else {
                        this.h.setColor(iCandleDataSet.d() == 1122867 ? iCandleDataSet.a(i2) : iCandleDataSet.d());
                    }
                    this.h.setStyle(Paint.Style.STROKE);
                    canvas.drawLines(this.b, this.h);
                    float[] fArr2 = this.f8570c;
                    fArr2[0] = (i3 - 0.5f) + a4;
                    fArr2[1] = d * a3;
                    fArr2[2] = (i3 + 0.5f) - a4;
                    fArr2[3] = e * a3;
                    a2.a(fArr2);
                    if (i4 > 0) {
                        if (iCandleDataSet.f() == 1122867) {
                            this.h.setColor(iCandleDataSet.a(i2));
                        } else {
                            this.h.setColor(iCandleDataSet.f());
                        }
                        this.h.setStyle(iCandleDataSet.D());
                        float[] fArr3 = this.f8570c;
                        canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.h);
                    } else if (e < d) {
                        if (iCandleDataSet.e() == 1122867) {
                            this.h.setColor(iCandleDataSet.a(i2));
                        } else {
                            this.h.setColor(iCandleDataSet.e());
                        }
                        this.h.setStyle(iCandleDataSet.g());
                        float[] fArr4 = this.f8570c;
                        canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.h);
                    } else {
                        if (iCandleDataSet.d() == 1122867) {
                            this.h.setColor(iCandleDataSet.a(i2));
                        } else {
                            this.h.setColor(iCandleDataSet.d());
                        }
                        float[] fArr5 = this.f8570c;
                        canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.h);
                    }
                } else {
                    float[] fArr6 = this.d;
                    fArr6[0] = i3;
                    fArr6[1] = a5 * a3;
                    fArr6[2] = i3;
                    fArr6[3] = c3 * a3;
                    float[] fArr7 = this.e;
                    fArr7[0] = (i3 - 0.5f) + a4;
                    float f = e * a3;
                    fArr7[1] = f;
                    fArr7[2] = i3;
                    fArr7[3] = f;
                    float[] fArr8 = this.l;
                    fArr8[0] = (0.5f + i3) - a4;
                    float f2 = d * a3;
                    fArr8[1] = f2;
                    fArr8[2] = i3;
                    fArr8[3] = f2;
                    a2.a(fArr6);
                    a2.a(this.e);
                    a2.a(this.l);
                    this.h.setColor(e > d ? iCandleDataSet.f() == 1122867 ? iCandleDataSet.a(i2) : iCandleDataSet.f() : e < d ? iCandleDataSet.e() == 1122867 ? iCandleDataSet.a(i2) : iCandleDataSet.e() : iCandleDataSet.d() == 1122867 ? iCandleDataSet.a(i2) : iCandleDataSet.d());
                    float[] fArr9 = this.d;
                    canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.h);
                    float[] fArr10 = this.e;
                    canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.h);
                    float[] fArr11 = this.l;
                    canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.h);
                }
            }
            i = i2 + 1;
        }
    }

    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.k.setColor(i);
        canvas.drawText(str, f, f2, this.k);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas, Highlight[] highlightArr) {
        CandleData candleData = this.f8569a.getCandleData();
        int length = highlightArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Highlight highlight = highlightArr[i2];
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (ICandleDataSet) candleData.a(highlight.f());
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.p()) {
                CandleEntry candleEntry = (CandleEntry) iLineScatterCandleRadarDataSet.b(highlight.a(), highlight.b());
                if (a(candleEntry, iLineScatterCandleRadarDataSet)) {
                    MPPointD b = this.f8569a.a(iLineScatterCandleRadarDataSet.C()).b(candleEntry.i(), ((candleEntry.c() * this.g.a()) + (candleEntry.a() * this.g.a())) / 2.0f);
                    highlight.a((float) b.f8595a, (float) b.b);
                    a(canvas, (float) b.f8595a, (float) b.b, iLineScatterCandleRadarDataSet);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        if (!a(this.f8569a)) {
            return;
        }
        List<T> i = this.f8569a.getCandleData().i();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i.size()) {
                return;
            }
            ICandleDataSet iCandleDataSet = (ICandleDataSet) i.get(i3);
            if (a(iCandleDataSet) && iCandleDataSet.H() >= 1) {
                b(iCandleDataSet);
                Transformer a2 = this.f8569a.a(iCandleDataSet.C());
                this.f.a(this.f8569a, iCandleDataSet);
                float[] a3 = a2.a(iCandleDataSet, this.g.b(), this.g.a(), this.f.f8565a, this.f.b);
                float a4 = Utils.a(5.0f);
                ValueFormatter q = iCandleDataSet.q();
                MPPointF a5 = MPPointF.a(iCandleDataSet.A());
                a5.f8597a = Utils.a(a5.f8597a);
                a5.b = Utils.a(a5.b);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= a3.length) {
                        break;
                    }
                    float f = a3[i5];
                    float f2 = a3[i5 + 1];
                    if (!this.o.h(f)) {
                        break;
                    }
                    if (this.o.g(f) && this.o.f(f2)) {
                        int i6 = i5 / 2;
                        CandleEntry candleEntry = (CandleEntry) iCandleDataSet.e(this.f.f8565a + i6);
                        if (iCandleDataSet.y()) {
                            a(canvas, q.a(candleEntry), f, f2 - a4, iCandleDataSet.d(i6));
                        }
                        if (candleEntry.g() != null && iCandleDataSet.z()) {
                            Drawable g = candleEntry.g();
                            Utils.a(canvas, g, (int) (f + a5.f8597a), (int) (f2 + a5.b), g.getIntrinsicWidth(), g.getIntrinsicHeight());
                        }
                    }
                    i4 = i5 + 2;
                }
                MPPointF.b(a5);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
    }
}
