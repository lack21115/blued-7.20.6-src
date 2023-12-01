package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/ScatterChartRenderer.class */
public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected ScatterDataProvider f22195a;
    float[] b;

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.b = new float[2];
        this.f22195a = scatterDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas) {
        for (IScatterDataSet iScatterDataSet : this.f22195a.getScatterData().i()) {
            if (iScatterDataSet.B()) {
                a(canvas, iScatterDataSet);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [com.github.mikephil.charting.data.Entry] */
    protected void a(Canvas canvas, IScatterDataSet iScatterDataSet) {
        if (iScatterDataSet.H() < 1) {
            return;
        }
        ViewPortHandler viewPortHandler = this.o;
        Transformer a2 = this.f22195a.a(iScatterDataSet.C());
        float a3 = this.g.a();
        IShapeRenderer b = iScatterDataSet.b();
        if (b == null) {
            Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
            return;
        }
        int min = (int) Math.min(Math.ceil(iScatterDataSet.H() * this.g.b()), iScatterDataSet.H());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                return;
            }
            ?? e = iScatterDataSet.e(i2);
            this.b[0] = e.i();
            this.b[1] = e.b() * a3;
            a2.a(this.b);
            if (!viewPortHandler.h(this.b[0])) {
                return;
            }
            if (viewPortHandler.g(this.b[0]) && viewPortHandler.f(this.b[1])) {
                this.h.setColor(iScatterDataSet.a(i2 / 2));
                ViewPortHandler viewPortHandler2 = this.o;
                float[] fArr = this.b;
                b.a(canvas, iScatterDataSet, viewPortHandler2, fArr[0], fArr[1], this.h);
            }
            i = i2 + 1;
        }
    }

    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.k.setColor(i);
        canvas.drawText(str, f, f2, this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.f22195a.getScatterData();
        int length = highlightArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Highlight highlight = highlightArr[i2];
            IScatterDataSet iScatterDataSet = (IScatterDataSet) scatterData.a(highlight.f());
            if (iScatterDataSet != null && iScatterDataSet.p()) {
                ?? b = iScatterDataSet.b(highlight.a(), highlight.b());
                if (a((Entry) b, iScatterDataSet)) {
                    MPPointD b2 = this.f22195a.a(iScatterDataSet.C()).b(b.i(), b.b() * this.g.a());
                    highlight.a((float) b2.f22202a, (float) b2.b);
                    a(canvas, (float) b2.f22202a, (float) b2.b, iScatterDataSet);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        if (!a(this.f22195a)) {
            return;
        }
        List<T> i = this.f22195a.getScatterData().i();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f22195a.getScatterData().d()) {
                return;
            }
            IScatterDataSet iScatterDataSet = (IScatterDataSet) i.get(i3);
            if (a(iScatterDataSet) && iScatterDataSet.H() >= 1) {
                b(iScatterDataSet);
                this.f.a(this.f22195a, iScatterDataSet);
                float[] a2 = this.f22195a.a(iScatterDataSet.C()).a(iScatterDataSet, this.g.b(), this.g.a(), this.f.f22172a, this.f.b);
                float a3 = Utils.a(iScatterDataSet.a());
                ValueFormatter q = iScatterDataSet.q();
                MPPointF a4 = MPPointF.a(iScatterDataSet.A());
                a4.f22204a = Utils.a(a4.f22204a);
                a4.b = Utils.a(a4.b);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= a2.length || !this.o.h(a2[i5])) {
                        break;
                    }
                    if (this.o.g(a2[i5])) {
                        int i6 = i5 + 1;
                        if (this.o.f(a2[i6])) {
                            int i7 = i5 / 2;
                            Entry e = iScatterDataSet.e(this.f.f22172a + i7);
                            if (iScatterDataSet.y()) {
                                a(canvas, q.a(e), a2[i5], a2[i6] - a3, iScatterDataSet.d(i7 + this.f.f22172a));
                            }
                            if (e.g() != null && iScatterDataSet.z()) {
                                Drawable g = e.g();
                                Utils.a(canvas, g, (int) (a2[i5] + a4.f22204a), (int) (a2[i6] + a4.b), g.getIntrinsicWidth(), g.getIntrinsicHeight());
                            }
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
