package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/PieChart.class */
public class PieChart extends PieRadarChartBase<PieData> {

    /* renamed from: a  reason: collision with root package name */
    protected float f22076a;
    protected float b;
    private RectF e;
    private boolean f;
    private float[] g;
    private float[] h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private CharSequence m;
    private MPPointF n;
    private float o;
    private boolean p;
    private float q;
    private float r;

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new RectF();
        this.f = true;
        this.g = new float[1];
        this.h = new float[1];
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = "";
        this.n = MPPointF.a(0.0f, 0.0f);
        this.o = 50.0f;
        this.f22076a = 55.0f;
        this.p = true;
        this.q = 100.0f;
        this.b = 360.0f;
        this.r = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new RectF();
        this.f = true;
        this.g = new float[1];
        this.h = new float[1];
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = "";
        this.n = MPPointF.a(0.0f, 0.0f);
        this.o = 50.0f;
        this.f22076a = 55.0f;
        this.p = true;
        this.q = 100.0f;
        this.b = 360.0f;
        this.r = 0.0f;
    }

    private float e(float f, float f2) {
        return (f / f2) * this.b;
    }

    private void l() {
        int j = ((PieData) this.C).j();
        if (this.g.length == j) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= j) {
                    break;
                }
                this.g[i2] = 0.0f;
                i = i2 + 1;
            }
        } else {
            this.g = new float[j];
        }
        if (this.h.length == j) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= j) {
                    break;
                }
                this.h[i4] = 0.0f;
                i3 = i4 + 1;
            }
        } else {
            this.h = new float[j];
        }
        float l = ((PieData) this.C).l();
        List<IPieDataSet> i5 = ((PieData) this.C).i();
        float f = this.r;
        boolean z = f != 0.0f && ((float) j) * f <= this.b;
        float[] fArr = new float[j];
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i6 = 0;
        for (int i7 = 0; i7 < ((PieData) this.C).d(); i7++) {
            IPieDataSet iPieDataSet = i5.get(i7);
            int i8 = 0;
            while (i8 < iPieDataSet.H()) {
                float e = e(Math.abs(iPieDataSet.e(i8).b()), l);
                float f4 = f2;
                float f5 = f3;
                if (z) {
                    float f6 = this.r;
                    float f7 = e - f6;
                    if (f7 <= 0.0f) {
                        fArr[i6] = f6;
                        f4 = f2 + (-f7);
                        f5 = f3;
                    } else {
                        fArr[i6] = e;
                        f5 = f3 + f7;
                        f4 = f2;
                    }
                }
                float[] fArr2 = this.g;
                fArr2[i6] = e;
                if (i6 == 0) {
                    this.h[i6] = fArr2[i6];
                } else {
                    float[] fArr3 = this.h;
                    fArr3[i6] = fArr3[i6 - 1] + fArr2[i6];
                }
                i6++;
                i8++;
                f2 = f4;
                f3 = f5;
            }
        }
        if (!z) {
            return;
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= j) {
                this.g = fArr;
                return;
            }
            fArr[i10] = fArr[i10] - (((fArr[i10] - this.r) / f3) * f2);
            if (i10 == 0) {
                this.h[0] = fArr[0];
            } else {
                float[] fArr4 = this.h;
                fArr4[i10] = fArr4[i10 - 1] + fArr[i10];
            }
            i9 = i10 + 1;
        }
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int a(float f) {
        float c2 = Utils.c(f - getRotationAngle());
        int i = 0;
        while (true) {
            int i2 = i;
            float[] fArr = this.h;
            if (i2 >= fArr.length) {
                return -1;
            }
            if (fArr[i2] > c2) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void a() {
        super.a();
        this.O = new PieChartRenderer(this, this.R, this.Q);
        this.H = null;
        this.P = new PieHighlighter(this);
    }

    public boolean a(int i) {
        if (!x()) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.S.length) {
                return false;
            }
            if (((int) this.S[i3].a()) == i) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public float[] a(Highlight highlight) {
        int a2;
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f = (radius / 10.0f) * 3.6f;
        if (d()) {
            f = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float rotationAngle = getRotationAngle();
        float f2 = this.g[(int) highlight.a()] / 2.0f;
        double d = radius - f;
        float cos = (float) ((Math.cos(Math.toRadians(((this.h[a2] + rotationAngle) - f2) * this.R.a())) * d) + centerCircleBox.f22204a);
        float sin = (float) ((d * Math.sin(Math.toRadians(((rotationAngle + this.h[a2]) - f2) * this.R.a()))) + centerCircleBox.b);
        MPPointF.b(centerCircleBox);
        return new float[]{cos, sin};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void b() {
        l();
    }

    public boolean c() {
        return this.j;
    }

    public boolean d() {
        return this.i;
    }

    public boolean e() {
        return this.p;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.l;
    }

    public float[] getAbsoluteAngles() {
        return this.h;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.a(this.e.centerX(), this.e.centerY());
    }

    public CharSequence getCenterText() {
        return this.m;
    }

    public MPPointF getCenterTextOffset() {
        return MPPointF.a(this.n.f22204a, this.n.b);
    }

    public float getCenterTextRadiusPercent() {
        return this.q;
    }

    public RectF getCircleBox() {
        return this.e;
    }

    public float[] getDrawAngles() {
        return this.g;
    }

    public float getHoleRadius() {
        return this.o;
    }

    public float getMaxAngle() {
        return this.b;
    }

    public float getMinAngleForSlices() {
        return this.r;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.e;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.e.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.N.a().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.f22076a;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    public boolean i() {
        return this.k;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void j() {
        super.j();
        if (this.C == 0) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        MPPointF centerOffsets = getCenterOffsets();
        float c2 = ((PieData) this.C).a().c();
        this.e.set((centerOffsets.f22204a - diameter) + c2, (centerOffsets.b - diameter) + c2, (centerOffsets.f22204a + diameter) - c2, (centerOffsets.b + diameter) - c2);
        MPPointF.b(centerOffsets);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (this.O != null && (this.O instanceof PieChartRenderer)) {
            ((PieChartRenderer) this.O).f();
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C == 0) {
            return;
        }
        this.O.a(canvas);
        if (x()) {
            this.O.a(canvas, this.S);
        }
        this.O.c(canvas);
        this.O.b(canvas);
        this.N.a(canvas);
        b(canvas);
        c(canvas);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.m = "";
        } else {
            this.m = charSequence;
        }
    }

    public void setCenterTextColor(int i) {
        ((PieChartRenderer) this.O).d().setColor(i);
    }

    public void setCenterTextRadiusPercent(float f) {
        this.q = f;
    }

    public void setCenterTextSize(float f) {
        ((PieChartRenderer) this.O).d().setTextSize(Utils.a(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((PieChartRenderer) this.O).d().setTextSize(f);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.O).d().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.p = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.f = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.i = z;
    }

    public void setDrawRoundedSlices(boolean z) {
        this.l = z;
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.f = z;
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.j = z;
    }

    public void setEntryLabelColor(int i) {
        ((PieChartRenderer) this.O).e().setColor(i);
    }

    public void setEntryLabelTextSize(float f) {
        ((PieChartRenderer) this.O).e().setTextSize(Utils.a(f));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.O).e().setTypeface(typeface);
    }

    public void setHoleColor(int i) {
        ((PieChartRenderer) this.O).b().setColor(i);
    }

    public void setHoleRadius(float f) {
        this.o = f;
    }

    public void setMaxAngle(float f) {
        float f2 = f;
        if (f > 360.0f) {
            f2 = 360.0f;
        }
        float f3 = f2;
        if (f2 < 90.0f) {
            f3 = 90.0f;
        }
        this.b = f3;
    }

    public void setMinAngleForSlices(float f) {
        float f2;
        float f3 = this.b;
        if (f > f3 / 2.0f) {
            f2 = f3 / 2.0f;
        } else {
            f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            }
        }
        this.r = f2;
    }

    public void setTransparentCircleAlpha(int i) {
        ((PieChartRenderer) this.O).c().setAlpha(i);
    }

    public void setTransparentCircleColor(int i) {
        Paint c2 = ((PieChartRenderer) this.O).c();
        int alpha = c2.getAlpha();
        c2.setColor(i);
        c2.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f) {
        this.f22076a = f;
    }

    public void setUsePercentValues(boolean z) {
        this.k = z;
    }
}
