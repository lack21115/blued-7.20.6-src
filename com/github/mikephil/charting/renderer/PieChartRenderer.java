package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/PieChartRenderer.class */
public class PieChartRenderer extends DataRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected PieChart f22191a;
    protected Paint b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f22192c;
    protected Paint d;
    protected WeakReference<Bitmap> e;
    protected Canvas f;
    protected Path l;
    protected RectF m;
    private TextPaint n;
    private Paint p;
    private StaticLayout q;
    private CharSequence r;
    private RectF s;
    private RectF[] t;
    private Path u;
    private RectF v;
    private Path w;

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.s = new RectF();
        this.t = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.u = new Path();
        this.v = new RectF();
        this.w = new Path();
        this.l = new Path();
        this.m = new RectF();
        this.f22191a = pieChart;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(-1);
        this.b.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f22192c = paint2;
        paint2.setColor(-1);
        this.f22192c.setStyle(Paint.Style.FILL);
        this.f22192c.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.n = textPaint;
        textPaint.setColor(-16777216);
        this.n.setTextSize(Utils.a(12.0f));
        this.k.setTextSize(Utils.a(13.0f));
        this.k.setColor(-1);
        this.k.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.p = paint3;
        paint3.setColor(-1);
        this.p.setTextAlign(Paint.Align.CENTER);
        this.p.setTextSize(Utils.a(13.0f));
        Paint paint4 = new Paint(1);
        this.d = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    protected float a(IPieDataSet iPieDataSet) {
        if (iPieDataSet.b() && iPieDataSet.a() / this.o.o() > (iPieDataSet.J() / ((PieData) this.f22191a.getData()).l()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.a();
    }

    protected float a(MPPointF mPPointF, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float cos = mPPointF.f22204a + (((float) Math.cos(d)) * f);
        float sin = mPPointF.b + (((float) Math.sin(d)) * f);
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        return (float) ((f - ((float) ((Math.sqrt(Math.pow(cos - f3, 2.0d) + Math.pow(sin - f4, 2.0d)) / 2.0d) * Math.tan(((180.0d - f2) / 2.0d) * 0.017453292519943295d)))) - Math.sqrt(Math.pow((mPPointF.f22204a + (((float) Math.cos(d2)) * f)) - ((cos + f3) / 2.0f), 2.0d) + Math.pow((mPPointF.b + (((float) Math.sin(d2)) * f)) - ((sin + f4) / 2.0f), 2.0d)));
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
        if (r9.getHeight() != r0) goto L27;
     */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.graphics.Canvas r6) {
        /*
            r5 = this;
            r0 = r5
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r0.o
            float r0 = r0.n()
            int r0 = (int) r0
            r7 = r0
            r0 = r5
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r0.o
            float r0 = r0.m()
            int r0 = (int) r0
            r8 = r0
            r0 = r5
            java.lang.ref.WeakReference<android.graphics.Bitmap> r0 = r0.e
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L23
            r0 = 0
            r9 = r0
            goto L2d
        L23:
            r0 = r9
            java.lang.Object r0 = r0.get()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r9 = r0
        L2d:
            r0 = r9
            if (r0 == 0) goto L48
            r0 = r9
            int r0 = r0.getWidth()
            r1 = r7
            if (r0 != r1) goto L48
            r0 = r9
            r10 = r0
            r0 = r9
            int r0 = r0.getHeight()
            r1 = r8
            if (r0 == r1) goto L74
        L48:
            r0 = r7
            if (r0 <= 0) goto Lc2
            r0 = r8
            if (r0 <= 0) goto Lc2
            r0 = r7
            r1 = r8
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_4444
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            r10 = r0
            r0 = r5
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r2 = r1
            r3 = r10
            r2.<init>(r3)
            r0.e = r1
            r0 = r5
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r2 = r1
            r3 = r10
            r2.<init>(r3)
            r0.f = r1
        L74:
            r0 = r10
            r1 = 0
            r0.eraseColor(r1)
            r0 = r5
            com.github.mikephil.charting.charts.PieChart r0 = r0.f22191a
            com.github.mikephil.charting.data.ChartData r0 = r0.getData()
            com.github.mikephil.charting.data.PieData r0 = (com.github.mikephil.charting.data.PieData) r0
            java.util.List r0 = r0.i()
            java.util.Iterator r0 = r0.iterator()
            r9 = r0
        L8e:
            r0 = r9
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lc2
            r0 = r9
            java.lang.Object r0 = r0.next()
            com.github.mikephil.charting.interfaces.datasets.IPieDataSet r0 = (com.github.mikephil.charting.interfaces.datasets.IPieDataSet) r0
            r10 = r0
            r0 = r10
            boolean r0 = r0.B()
            if (r0 == 0) goto L8e
            r0 = r10
            int r0 = r0.H()
            if (r0 <= 0) goto L8e
            r0 = r5
            r1 = r6
            r2 = r10
            r0.a(r1, r2)
            goto L8e
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.PieChartRenderer.a(android.graphics.Canvas):void");
    }

    protected void a(Canvas canvas, IPieDataSet iPieDataSet) {
        int i;
        RectF rectF;
        PieChartRenderer pieChartRenderer;
        MPPointF mPPointF;
        MPPointF mPPointF2;
        float f;
        float f2;
        PieChartRenderer pieChartRenderer2 = this;
        float rotationAngle = pieChartRenderer2.f22191a.getRotationAngle();
        float b = pieChartRenderer2.g.b();
        float a2 = pieChartRenderer2.g.a();
        RectF circleBox = pieChartRenderer2.f22191a.getCircleBox();
        int H = iPieDataSet.H();
        float[] drawAngles = pieChartRenderer2.f22191a.getDrawAngles();
        MPPointF centerCircleBox = pieChartRenderer2.f22191a.getCenterCircleBox();
        float radius = pieChartRenderer2.f22191a.getRadius();
        boolean z = pieChartRenderer2.f22191a.d() && !pieChartRenderer2.f22191a.c();
        float holeRadius = z ? (pieChartRenderer2.f22191a.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((pieChartRenderer2.f22191a.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF2 = new RectF();
        boolean z2 = z && pieChartRenderer2.f22191a.g();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= H) {
                break;
            }
            int i4 = i;
            if (Math.abs(iPieDataSet.e(i2).b()) > Utils.b) {
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        float a3 = i <= 1 ? 0.0f : pieChartRenderer2.a(iPieDataSet);
        int i5 = 0;
        float f3 = 0.0f;
        while (i5 < H) {
            float f4 = drawAngles[i5];
            if (Math.abs(iPieDataSet.e(i5).b()) > Utils.b && (!pieChartRenderer2.f22191a.a(i5) || z2)) {
                boolean z3 = a3 > 0.0f && f4 <= 180.0f;
                pieChartRenderer2.h.setColor(iPieDataSet.a(i5));
                float f5 = i == 1 ? 0.0f : a3 / (radius * 0.017453292f);
                float f6 = rotationAngle + ((f3 + (f5 / 2.0f)) * a2);
                float f7 = (f4 - f5) * a2;
                float f8 = f7;
                if (f7 < 0.0f) {
                    f8 = 0.0f;
                }
                pieChartRenderer2.u.reset();
                if (z2) {
                    float f9 = radius - holeRadius2;
                    double d = f6 * 0.017453292f;
                    float cos = centerCircleBox.f22204a + (((float) Math.cos(d)) * f9);
                    float sin = centerCircleBox.b + (f9 * ((float) Math.sin(d)));
                    rectF2.set(cos - holeRadius2, sin - holeRadius2, cos + holeRadius2, sin + holeRadius2);
                }
                double d2 = f6 * 0.017453292f;
                float cos2 = centerCircleBox.f22204a + (((float) Math.cos(d2)) * radius);
                float sin2 = centerCircleBox.b + (((float) Math.sin(d2)) * radius);
                int i6 = (f8 > 360.0f ? 1 : (f8 == 360.0f ? 0 : -1));
                if (i6 < 0 || f8 % 360.0f > Utils.b) {
                    if (z2) {
                        pieChartRenderer2.u.arcTo(rectF2, f6 + 180.0f, -180.0f);
                    }
                    pieChartRenderer2.u.arcTo(circleBox, f6, f8);
                } else {
                    pieChartRenderer2.u.addCircle(centerCircleBox.f22204a, centerCircleBox.b, radius, Path.Direction.CW);
                }
                pieChartRenderer2.v.set(centerCircleBox.f22204a - holeRadius, centerCircleBox.b - holeRadius, centerCircleBox.f22204a + holeRadius, centerCircleBox.b + holeRadius);
                if (!z || (holeRadius <= 0.0f && !z3)) {
                    MPPointF mPPointF3 = centerCircleBox;
                    rectF = rectF2;
                    pieChartRenderer = pieChartRenderer2;
                    mPPointF = mPPointF3;
                    if (f8 % 360.0f > Utils.b) {
                        if (z3) {
                            rectF = rectF2;
                            float a4 = a(mPPointF3, radius, f4 * a2, cos2, sin2, f6, f8);
                            float f10 = mPPointF3.f22204a;
                            double d3 = (f6 + (f8 / 2.0f)) * 0.017453292f;
                            pieChartRenderer2.u.lineTo(f10 + (((float) Math.cos(d3)) * a4), mPPointF3.b + (a4 * ((float) Math.sin(d3))));
                            mPPointF2 = mPPointF3;
                        } else {
                            rectF = rectF2;
                            pieChartRenderer2.u.lineTo(mPPointF3.f22204a, mPPointF3.b);
                            mPPointF2 = mPPointF3;
                        }
                        pieChartRenderer2.u.close();
                        pieChartRenderer2.f.drawPath(pieChartRenderer2.u, pieChartRenderer2.h);
                        f = f3 + (f4 * b);
                    }
                } else {
                    if (z3) {
                        float a5 = a(centerCircleBox, radius, f4 * a2, cos2, sin2, f6, f8);
                        float f11 = a5;
                        if (a5 < 0.0f) {
                            f11 = -a5;
                        }
                        f2 = Math.max(holeRadius, f11);
                    } else {
                        f2 = holeRadius;
                    }
                    float f12 = f2;
                    float f13 = (i == 1 || f12 == 0.0f) ? 0.0f : a3 / (f12 * 0.017453292f);
                    float f14 = f13 / 2.0f;
                    float f15 = (f4 - f13) * a2;
                    float f16 = f15;
                    if (f15 < 0.0f) {
                        f16 = 0.0f;
                    }
                    float f17 = rotationAngle + ((f3 + f14) * a2) + f16;
                    if (i6 < 0 || f8 % 360.0f > Utils.b) {
                        if (z2) {
                            float f18 = radius - holeRadius2;
                            double d4 = f17 * 0.017453292f;
                            float cos3 = centerCircleBox.f22204a + (((float) Math.cos(d4)) * f18);
                            float sin3 = centerCircleBox.b + (f18 * ((float) Math.sin(d4)));
                            RectF rectF3 = rectF2;
                            rectF3.set(cos3 - holeRadius2, sin3 - holeRadius2, cos3 + holeRadius2, sin3 + holeRadius2);
                            this.u.arcTo(rectF3, f17, 180.0f);
                        } else {
                            double d5 = f17 * 0.017453292f;
                            this.u.lineTo(centerCircleBox.f22204a + (((float) Math.cos(d5)) * f12), centerCircleBox.b + (f12 * ((float) Math.sin(d5))));
                        }
                        this.u.arcTo(this.v, f17, -f16);
                    } else {
                        this.u.addCircle(centerCircleBox.f22204a, centerCircleBox.b, f12, Path.Direction.CCW);
                    }
                    pieChartRenderer = this;
                    mPPointF = centerCircleBox;
                    rectF = rectF2;
                }
                mPPointF2 = mPPointF;
                pieChartRenderer2 = pieChartRenderer;
                pieChartRenderer2.u.close();
                pieChartRenderer2.f.drawPath(pieChartRenderer2.u, pieChartRenderer2.h);
                f = f3 + (f4 * b);
            } else {
                f = f3 + (f4 * b);
                MPPointF mPPointF4 = centerCircleBox;
                rectF = rectF2;
                mPPointF2 = mPPointF4;
            }
            i5++;
            MPPointF mPPointF5 = mPPointF2;
            rectF2 = rectF;
            centerCircleBox = mPPointF5;
            f3 = f;
        }
        MPPointF.b(centerCircleBox);
    }

    protected void a(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.p);
    }

    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.k.setColor(i);
        canvas.drawText(str, f, f2, this.k);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas, Highlight[] highlightArr) {
        IPieDataSet a2;
        int i;
        float f;
        float f2;
        boolean z = this.f22191a.d() && !this.f22191a.c();
        if (z && this.f22191a.g()) {
            return;
        }
        float b = this.g.b();
        float a3 = this.g.a();
        float rotationAngle = this.f22191a.getRotationAngle();
        float[] drawAngles = this.f22191a.getDrawAngles();
        float[] absoluteAngles = this.f22191a.getAbsoluteAngles();
        MPPointF centerCircleBox = this.f22191a.getCenterCircleBox();
        float radius = this.f22191a.getRadius();
        float holeRadius = z ? (this.f22191a.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF = this.m;
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= highlightArr.length) {
                MPPointF.b(centerCircleBox);
                return;
            }
            int a4 = (int) highlightArr[i3].a();
            if (a4 < drawAngles.length && (a2 = ((PieData) this.f22191a.getData()).a(highlightArr[i3].f())) != null && a2.p()) {
                int H = a2.H();
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    i = i5;
                    if (i4 >= H) {
                        break;
                    }
                    int i6 = i;
                    if (Math.abs(a2.e(i4).b()) > Utils.b) {
                        i6 = i + 1;
                    }
                    i4++;
                    i5 = i6;
                }
                float f3 = a4 == 0 ? 0.0f : absoluteAngles[a4 - 1] * b;
                float a5 = i <= 1 ? 0.0f : a2.a();
                float f4 = drawAngles[a4];
                float c2 = a2.c();
                float f5 = radius + c2;
                rectF.set(this.f22191a.getCircleBox());
                float f6 = -c2;
                rectF.inset(f6, f6);
                boolean z2 = a5 > 0.0f && f4 <= 180.0f;
                this.h.setColor(a2.a(a4));
                float f7 = i == 1 ? 0.0f : a5 / (radius * 0.017453292f);
                float f8 = i == 1 ? 0.0f : a5 / (f5 * 0.017453292f);
                float f9 = rotationAngle + (((f7 / 2.0f) + f3) * a3);
                float f10 = (f4 - f7) * a3;
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                float f11 = (((f8 / 2.0f) + f3) * a3) + rotationAngle;
                float f12 = (f4 - f8) * a3;
                float f13 = f12;
                if (f12 < 0.0f) {
                    f13 = 0.0f;
                }
                this.u.reset();
                int i7 = (f10 > 360.0f ? 1 : (f10 == 360.0f ? 0 : -1));
                if (i7 < 0 || f10 % 360.0f > Utils.b) {
                    Path path = this.u;
                    float f14 = centerCircleBox.f22204a;
                    double d = f11 * 0.017453292f;
                    path.moveTo(f14 + (((float) Math.cos(d)) * f5), centerCircleBox.b + (f5 * ((float) Math.sin(d))));
                    this.u.arcTo(rectF, f11, f13);
                } else {
                    this.u.addCircle(centerCircleBox.f22204a, centerCircleBox.b, f5, Path.Direction.CW);
                }
                if (z2) {
                    float f15 = centerCircleBox.f22204a;
                    double d2 = f9 * 0.017453292f;
                    f = a(centerCircleBox, radius, f4 * a3, (((float) Math.cos(d2)) * radius) + f15, centerCircleBox.b + (((float) Math.sin(d2)) * radius), f9, f10);
                } else {
                    f = 0.0f;
                }
                float f16 = holeRadius;
                this.v.set(centerCircleBox.f22204a - f16, centerCircleBox.b - f16, centerCircleBox.f22204a + f16, centerCircleBox.b + f16);
                if (z && (f16 > 0.0f || z2)) {
                    if (z2) {
                        float f17 = f;
                        if (f < 0.0f) {
                            f17 = -f;
                        }
                        f2 = Math.max(f16, f17);
                    } else {
                        f2 = f16;
                    }
                    float f18 = (i == 1 || f2 == 0.0f) ? 0.0f : a5 / (f2 * 0.017453292f);
                    float f19 = f18 / 2.0f;
                    float f20 = (f4 - f18) * a3;
                    float f21 = f20;
                    if (f20 < 0.0f) {
                        f21 = 0.0f;
                    }
                    float f22 = ((f3 + f19) * a3) + rotationAngle + f21;
                    if (i7 < 0 || f10 % 360.0f > Utils.b) {
                        Path path2 = this.u;
                        float f23 = centerCircleBox.f22204a;
                        double d3 = f22 * 0.017453292f;
                        path2.lineTo(f23 + (((float) Math.cos(d3)) * f2), centerCircleBox.b + (f2 * ((float) Math.sin(d3))));
                        this.u.arcTo(this.v, f22, -f21);
                    } else {
                        this.u.addCircle(centerCircleBox.f22204a, centerCircleBox.b, f2, Path.Direction.CCW);
                    }
                } else if (f10 % 360.0f > Utils.b) {
                    if (z2) {
                        float f24 = centerCircleBox.f22204a;
                        double d4 = (f9 + (f10 / 2.0f)) * 0.017453292f;
                        this.u.lineTo(f24 + (((float) Math.cos(d4)) * f), centerCircleBox.b + (f * ((float) Math.sin(d4))));
                    } else {
                        this.u.lineTo(centerCircleBox.f22204a, centerCircleBox.b);
                    }
                }
                this.u.close();
                this.f.drawPath(this.u, this.h);
            }
            i2 = i3 + 1;
        }
    }

    public Paint b() {
        return this.b;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        float[] fArr;
        float f;
        float f2;
        Canvas canvas2;
        float f3;
        float f4;
        float f5;
        float[] fArr2;
        MPPointF mPPointF;
        float f6;
        float f7;
        float f8;
        Canvas canvas3 = canvas;
        MPPointF centerCircleBox = this.f22191a.getCenterCircleBox();
        float radius = this.f22191a.getRadius();
        float rotationAngle = this.f22191a.getRotationAngle();
        float[] drawAngles = this.f22191a.getDrawAngles();
        float[] absoluteAngles = this.f22191a.getAbsoluteAngles();
        float b = this.g.b();
        float a2 = this.g.a();
        float holeRadius = (radius - ((this.f22191a.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        float holeRadius2 = this.f22191a.getHoleRadius() / 100.0f;
        float f9 = (radius / 10.0f) * 3.6f;
        float f10 = rotationAngle;
        if (this.f22191a.d()) {
            float f11 = (radius - (radius * holeRadius2)) / 2.0f;
            f10 = rotationAngle;
            f9 = f11;
            if (!this.f22191a.c()) {
                f10 = rotationAngle;
                f9 = f11;
                if (this.f22191a.g()) {
                    f10 = (float) (rotationAngle + ((holeRadius * 360.0f) / (radius * 6.283185307179586d)));
                    f9 = f11;
                }
            }
        }
        float f12 = f10;
        float f13 = radius - f9;
        PieData pieData = (PieData) this.f22191a.getData();
        List<IPieDataSet> i = pieData.i();
        float l = pieData.l();
        boolean f14 = this.f22191a.f();
        canvas.save();
        float a3 = Utils.a(5.0f);
        int i2 = 0;
        int i3 = 0;
        float f15 = radius;
        while (i3 < i.size()) {
            IPieDataSet iPieDataSet = i.get(i3);
            boolean y = iPieDataSet.y();
            if (y || f14) {
                PieDataSet.ValuePosition d = iPieDataSet.d();
                PieDataSet.ValuePosition e = iPieDataSet.e();
                b(iPieDataSet);
                float b2 = Utils.b(this.k, "Q") + Utils.a(4.0f);
                ValueFormatter q = iPieDataSet.q();
                int H = iPieDataSet.H();
                this.d.setColor(iPieDataSet.g());
                this.d.setStrokeWidth(Utils.a(iPieDataSet.h()));
                float a4 = a(iPieDataSet);
                MPPointF a5 = MPPointF.a(iPieDataSet.A());
                a5.f22204a = Utils.a(a5.f22204a);
                a5.b = Utils.a(a5.b);
                MPPointF mPPointF2 = centerCircleBox;
                for (int i4 = 0; i4 < H; i4++) {
                    PieEntry e2 = iPieDataSet.e(i4);
                    float f16 = f12 + (((i2 == 0 ? 0.0f : absoluteAngles[i2 - 1] * b) + ((drawAngles[i2] - ((a4 / (f13 * 0.017453292f)) / 2.0f)) / 2.0f)) * a2);
                    String a6 = q.a(this.f22191a.i() ? (e2.b() / l) * 100.0f : e2.b(), e2);
                    String a7 = e2.a();
                    double d2 = f16 * 0.017453292f;
                    float cos = (float) Math.cos(d2);
                    float sin = (float) Math.sin(d2);
                    boolean z = f14 && d == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z2 = y && e == PieDataSet.ValuePosition.OUTSIDE_SLICE;
                    boolean z3 = f14 && d == PieDataSet.ValuePosition.INSIDE_SLICE;
                    boolean z4 = y && e == PieDataSet.ValuePosition.INSIDE_SLICE;
                    if (z || z2) {
                        float E = iPieDataSet.E();
                        float F = iPieDataSet.F();
                        float D = iPieDataSet.D() / 100.0f;
                        if (this.f22191a.d()) {
                            float f17 = f15 * holeRadius2;
                            f6 = ((f15 - f17) * D) + f17;
                        } else {
                            f6 = f15 * D;
                        }
                        float abs = iPieDataSet.N() ? F * f13 * ((float) Math.abs(Math.sin(d2))) : F * f13;
                        float f18 = mPPointF2.f22204a;
                        float f19 = mPPointF2.b;
                        float f20 = (E + 1.0f) * f13;
                        float f21 = (f20 * cos) + mPPointF2.f22204a;
                        float f22 = mPPointF2.b + (f20 * sin);
                        double d3 = f16 % 360.0d;
                        if (d3 < 90.0d || d3 > 270.0d) {
                            f7 = f21 + abs;
                            this.k.setTextAlign(Paint.Align.LEFT);
                            if (z) {
                                this.p.setTextAlign(Paint.Align.LEFT);
                            }
                            f8 = f7 + a3;
                        } else {
                            float f23 = f21 - abs;
                            this.k.setTextAlign(Paint.Align.RIGHT);
                            if (z) {
                                this.p.setTextAlign(Paint.Align.RIGHT);
                            }
                            f7 = f23;
                            f8 = f23 - a3;
                        }
                        if (iPieDataSet.g() != 1122867) {
                            if (iPieDataSet.f()) {
                                this.d.setColor(iPieDataSet.a(i4));
                            }
                            canvas.drawLine((f6 * cos) + f18, (f6 * sin) + f19, f21, f22, this.d);
                            canvas.drawLine(f21, f22, f7, f22, this.d);
                        }
                        if (z && z2) {
                            a(canvas, a6, f8, f22, iPieDataSet.d(i4));
                            if (i4 < pieData.j() && a7 != null) {
                                a(canvas, a7, f8, f22 + b2);
                            }
                        } else if (z) {
                            if (i4 < pieData.j() && a7 != null) {
                                a(canvas, a7, f8, f22 + (b2 / 2.0f));
                            }
                        } else if (z2) {
                            a(canvas, a6, f8, f22 + (b2 / 2.0f), iPieDataSet.d(i4));
                        }
                    }
                    if (z3 || z4) {
                        float f24 = (f13 * cos) + mPPointF2.f22204a;
                        float f25 = (f13 * sin) + mPPointF2.b;
                        this.k.setTextAlign(Paint.Align.CENTER);
                        if (z3 && z4) {
                            a(canvas, a6, f24, f25, iPieDataSet.d(i4));
                            if (i4 < pieData.j() && a7 != null) {
                                a(canvas, a7, f24, f25 + b2);
                            }
                        } else if (z3) {
                            if (i4 < pieData.j() && a7 != null) {
                                a(canvas, a7, f24, f25 + (b2 / 2.0f));
                            }
                        } else if (z4) {
                            a(canvas, a6, f24, f25 + (b2 / 2.0f), iPieDataSet.d(i4));
                        }
                    }
                    if (e2.g() != null && iPieDataSet.z()) {
                        Drawable g = e2.g();
                        Utils.a(canvas, g, (int) (((f13 + a5.b) * cos) + mPPointF2.f22204a), (int) (((f13 + a5.b) * sin) + mPPointF2.b + a5.f22204a), g.getIntrinsicWidth(), g.getIntrinsicHeight());
                    }
                    i2++;
                }
                fArr = absoluteAngles;
                float f26 = b;
                f = a2;
                float f27 = f12;
                f2 = f13;
                canvas2 = canvas;
                MPPointF.b(a5);
                f3 = f15;
                f4 = f27;
                f5 = f26;
                fArr2 = drawAngles;
                mPPointF = mPPointF2;
            } else {
                float f28 = f15;
                float[] fArr3 = drawAngles;
                float[] fArr4 = absoluteAngles;
                float f29 = a2;
                float f30 = f12;
                canvas2 = canvas3;
                mPPointF = centerCircleBox;
                fArr2 = fArr3;
                f2 = f13;
                fArr = fArr4;
                f5 = b;
                f = f29;
                f4 = f30;
                f3 = f28;
            }
            i3++;
            float[] fArr5 = fArr2;
            float f31 = f2;
            float[] fArr6 = fArr;
            float f32 = f;
            float f33 = f4;
            canvas3 = canvas2;
            centerCircleBox = mPPointF;
            f15 = f3;
            drawAngles = fArr5;
            absoluteAngles = fArr6;
            b = f5;
            a2 = f32;
            f12 = f33;
            f13 = f31;
        }
        MPPointF.b(centerCircleBox);
        canvas.restore();
    }

    public Paint c() {
        return this.f22192c;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        d(canvas);
        canvas.drawBitmap(this.e.get(), 0.0f, 0.0f, (Paint) null);
        e(canvas);
    }

    public TextPaint d() {
        return this.n;
    }

    protected void d(Canvas canvas) {
        if (!this.f22191a.d() || this.f == null) {
            return;
        }
        float radius = this.f22191a.getRadius();
        float holeRadius = (this.f22191a.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.f22191a.getCenterCircleBox();
        if (Color.alpha(this.b.getColor()) > 0) {
            this.f.drawCircle(centerCircleBox.f22204a, centerCircleBox.b, holeRadius, this.b);
        }
        if (Color.alpha(this.f22192c.getColor()) > 0 && this.f22191a.getTransparentCircleRadius() > this.f22191a.getHoleRadius()) {
            int alpha = this.f22192c.getAlpha();
            float transparentCircleRadius = this.f22191a.getTransparentCircleRadius() / 100.0f;
            this.f22192c.setAlpha((int) (alpha * this.g.b() * this.g.a()));
            this.w.reset();
            this.w.addCircle(centerCircleBox.f22204a, centerCircleBox.b, radius * transparentCircleRadius, Path.Direction.CW);
            this.w.addCircle(centerCircleBox.f22204a, centerCircleBox.b, holeRadius, Path.Direction.CCW);
            this.f.drawPath(this.w, this.f22192c);
            this.f22192c.setAlpha(alpha);
        }
        MPPointF.b(centerCircleBox);
    }

    public Paint e() {
        return this.p;
    }

    protected void e(Canvas canvas) {
        CharSequence centerText = this.f22191a.getCenterText();
        if (!this.f22191a.e() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.f22191a.getCenterCircleBox();
        MPPointF centerTextOffset = this.f22191a.getCenterTextOffset();
        float f = centerCircleBox.f22204a + centerTextOffset.f22204a;
        float f2 = centerCircleBox.b + centerTextOffset.b;
        float radius = (!this.f22191a.d() || this.f22191a.c()) ? this.f22191a.getRadius() : this.f22191a.getRadius() * (this.f22191a.getHoleRadius() / 100.0f);
        RectF rectF = this.t[0];
        rectF.left = f - radius;
        rectF.top = f2 - radius;
        rectF.right = f + radius;
        rectF.bottom = f2 + radius;
        RectF rectF2 = this.t[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.f22191a.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (!centerText.equals(this.r) || !rectF2.equals(this.s)) {
            this.s.set(rectF2);
            this.r = centerText;
            this.q = new StaticLayout(centerText, 0, centerText.length(), this.n, (int) Math.max(Math.ceil(this.s.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.q.getHeight();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 18) {
            Path path = this.l;
            path.reset();
            path.addOval(rectF, Path.Direction.CW);
            canvas.clipPath(path);
        }
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.q.draw(canvas);
        canvas.restore();
        MPPointF.b(centerCircleBox);
        MPPointF.b(centerTextOffset);
    }

    public void f() {
        Canvas canvas = this.f;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.f = null;
        }
        WeakReference<Bitmap> weakReference = this.e;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.e.clear();
            this.e = null;
        }
    }
}
