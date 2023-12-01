package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/BubbleChartRenderer.class */
public class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected BubbleDataProvider f8567a;
    private float[] b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f8568c;
    private float[] d;

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.b = new float[4];
        this.f8568c = new float[2];
        this.d = new float[3];
        this.f8567a = bubbleDataProvider;
        this.h.setStyle(Paint.Style.FILL);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(Utils.a(1.5f));
    }

    protected float a(float f, float f2, float f3, boolean z) {
        float f4 = f;
        if (z) {
            f4 = f2 == 0.0f ? 1.0f : (float) Math.sqrt(f / f2);
        }
        return f3 * f4;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas) {
        for (T t : this.f8567a.getBubbleData().i()) {
            if (t.B()) {
                a(canvas, t);
            }
        }
    }

    protected void a(Canvas canvas, IBubbleDataSet iBubbleDataSet) {
        if (iBubbleDataSet.H() < 1) {
            return;
        }
        Transformer a2 = this.f8567a.a(iBubbleDataSet.C());
        float a3 = this.g.a();
        this.f.a(this.f8567a, iBubbleDataSet);
        float[] fArr = this.b;
        fArr[0] = 0.0f;
        fArr[2] = 1.0f;
        a2.a(fArr);
        boolean c2 = iBubbleDataSet.c();
        float[] fArr2 = this.b;
        float min = Math.min(Math.abs(this.o.h() - this.o.e()), Math.abs(fArr2[2] - fArr2[0]));
        int i = this.f.f8565a;
        while (true) {
            int i2 = i;
            if (i2 > this.f.f8566c + this.f.f8565a) {
                return;
            }
            BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.e(i2);
            this.f8568c[0] = bubbleEntry.i();
            this.f8568c[1] = bubbleEntry.b() * a3;
            a2.a(this.f8568c);
            float a4 = a(bubbleEntry.a(), iBubbleDataSet.b(), min, c2) / 2.0f;
            if (this.o.i(this.f8568c[1] + a4) && this.o.j(this.f8568c[1] - a4) && this.o.g(this.f8568c[0] + a4)) {
                if (!this.o.h(this.f8568c[0] - a4)) {
                    return;
                }
                this.h.setColor(iBubbleDataSet.a((int) bubbleEntry.i()));
                float[] fArr3 = this.f8568c;
                canvas.drawCircle(fArr3[0], fArr3[1], a4, this.h);
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
        BubbleData bubbleData = this.f8567a.getBubbleData();
        float a2 = this.g.a();
        int length = highlightArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Highlight highlight = highlightArr[i2];
            IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) bubbleData.a(highlight.f());
            if (iBubbleDataSet != null && iBubbleDataSet.p()) {
                BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.b(highlight.a(), highlight.b());
                if (bubbleEntry.b() == highlight.b() && a(bubbleEntry, iBubbleDataSet)) {
                    Transformer a3 = this.f8567a.a(iBubbleDataSet.C());
                    float[] fArr = this.b;
                    fArr[0] = 0.0f;
                    fArr[2] = 1.0f;
                    a3.a(fArr);
                    boolean c2 = iBubbleDataSet.c();
                    float[] fArr2 = this.b;
                    float min = Math.min(Math.abs(this.o.h() - this.o.e()), Math.abs(fArr2[2] - fArr2[0]));
                    this.f8568c[0] = bubbleEntry.i();
                    this.f8568c[1] = bubbleEntry.b() * a2;
                    a3.a(this.f8568c);
                    float[] fArr3 = this.f8568c;
                    highlight.a(fArr3[0], fArr3[1]);
                    float a4 = a(bubbleEntry.a(), iBubbleDataSet.b(), min, c2) / 2.0f;
                    if (this.o.i(this.f8568c[1] + a4) && this.o.j(this.f8568c[1] - a4) && this.o.g(this.f8568c[0] + a4)) {
                        if (!this.o.h(this.f8568c[0] - a4)) {
                            return;
                        }
                        int a5 = iBubbleDataSet.a((int) bubbleEntry.i());
                        Color.RGBToHSV(Color.red(a5), Color.green(a5), Color.blue(a5), this.d);
                        float[] fArr4 = this.d;
                        fArr4[2] = fArr4[2] * 0.5f;
                        this.i.setColor(Color.HSVToColor(Color.alpha(a5), this.d));
                        this.i.setStrokeWidth(iBubbleDataSet.a());
                        float[] fArr5 = this.f8568c;
                        canvas.drawCircle(fArr5[0], fArr5[1], a4, this.i);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        BubbleData bubbleData = this.f8567a.getBubbleData();
        if (bubbleData == null || !a(this.f8567a)) {
            return;
        }
        List<T> i = bubbleData.i();
        float b = Utils.b(this.k, "1");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i.size()) {
                return;
            }
            IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) i.get(i3);
            if (a(iBubbleDataSet) && iBubbleDataSet.H() >= 1) {
                b(iBubbleDataSet);
                float max = Math.max(0.0f, Math.min(1.0f, this.g.b()));
                float a2 = this.g.a();
                this.f.a(this.f8567a, iBubbleDataSet);
                float[] a3 = this.f8567a.a(iBubbleDataSet.C()).a(iBubbleDataSet, a2, this.f.f8565a, this.f.b);
                if (max == 1.0f) {
                    max = a2;
                }
                ValueFormatter q = iBubbleDataSet.q();
                MPPointF a4 = MPPointF.a(iBubbleDataSet.A());
                a4.f8597a = Utils.a(a4.f8597a);
                a4.b = Utils.a(a4.b);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= a3.length) {
                        break;
                    }
                    int i6 = i5 / 2;
                    int d = iBubbleDataSet.d(this.f.f8565a + i6);
                    int argb = Color.argb(Math.round(255.0f * max), Color.red(d), Color.green(d), Color.blue(d));
                    float f = a3[i5];
                    float f2 = a3[i5 + 1];
                    if (!this.o.h(f)) {
                        break;
                    }
                    if (this.o.g(f) && this.o.f(f2)) {
                        BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.e(i6 + this.f.f8565a);
                        if (iBubbleDataSet.y()) {
                            a(canvas, q.a(bubbleEntry), f, f2 + (0.5f * b), argb);
                        }
                        if (bubbleEntry.g() != null && iBubbleDataSet.z()) {
                            Drawable g = bubbleEntry.g();
                            Utils.a(canvas, g, (int) (f + a4.f8597a), (int) (f2 + a4.b), g.getIntrinsicWidth(), g.getIntrinsicHeight());
                        }
                    }
                    i4 = i5 + 2;
                }
                MPPointF.b(a4);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
    }
}
