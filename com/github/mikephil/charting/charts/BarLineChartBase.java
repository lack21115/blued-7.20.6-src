package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/BarLineChartBase.class */
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
    protected float[] A;

    /* renamed from: a  reason: collision with root package name */
    private boolean f22063a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private long ad;
    private long ae;
    private RectF af;
    private boolean ag;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f22064c;
    protected boolean d;
    protected boolean e;
    protected boolean f;
    protected Paint g;
    protected Paint h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    protected float l;
    protected boolean m;
    protected OnDrawListener n;
    protected YAxis o;
    protected YAxis p;
    protected YAxisRenderer q;
    protected YAxisRenderer r;
    protected Transformer s;
    protected Transformer t;
    protected XAxisRenderer u;
    protected Matrix v;
    protected Matrix w;
    protected float[] x;
    protected MPPointD y;
    protected MPPointD z;

    /* renamed from: com.github.mikephil.charting.charts.BarLineChartBase$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/BarLineChartBase$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f22065a;
        final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f22066c;
        final /* synthetic */ float d;
        final /* synthetic */ BarLineChartBase e;

        @Override // java.lang.Runnable
        public void run() {
            this.e.Q.a(this.f22065a, this.b, this.f22066c, this.d);
            this.e.g();
            this.e.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.charts.BarLineChartBase$2  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/BarLineChartBase$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22067a;
        static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f22068c;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0069 -> B:35:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006d -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0071 -> B:41:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0075 -> B:37:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0079 -> B:13:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007d -> B:43:0x005d). Please submit an issue!!! */
        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            f22068c = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22068c[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            b = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f22067a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22067a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public BarLineChartBase(Context context) {
        super(context);
        this.b = 100;
        this.f22064c = false;
        this.d = false;
        this.e = true;
        this.f = true;
        this.f22063a = true;
        this.aa = true;
        this.ab = true;
        this.ac = true;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = 15.0f;
        this.m = false;
        this.ad = 0L;
        this.ae = 0L;
        this.af = new RectF();
        this.v = new Matrix();
        this.w = new Matrix();
        this.ag = false;
        this.x = new float[2];
        this.y = MPPointD.a(0.0d, 0.0d);
        this.z = MPPointD.a(0.0d, 0.0d);
        this.A = new float[2];
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 100;
        this.f22064c = false;
        this.d = false;
        this.e = true;
        this.f = true;
        this.f22063a = true;
        this.aa = true;
        this.ab = true;
        this.ac = true;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = 15.0f;
        this.m = false;
        this.ad = 0L;
        this.ae = 0L;
        this.af = new RectF();
        this.v = new Matrix();
        this.w = new Matrix();
        this.ag = false;
        this.x = new float[2];
        this.y = MPPointD.a(0.0d, 0.0d);
        this.z = MPPointD.a(0.0d, 0.0d);
        this.A = new float[2];
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 100;
        this.f22064c = false;
        this.d = false;
        this.e = true;
        this.f = true;
        this.f22063a = true;
        this.aa = true;
        this.ab = true;
        this.ac = true;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = 15.0f;
        this.m = false;
        this.ad = 0L;
        this.ae = 0L;
        this.af = new RectF();
        this.v = new Matrix();
        this.w = new Matrix();
        this.ag = false;
        this.x = new float[2];
        this.y = MPPointD.a(0.0d, 0.0d);
        this.z = MPPointD.a(0.0d, 0.0d);
        this.A = new float[2];
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public Transformer a(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.s : this.t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void a() {
        super.a();
        this.o = new YAxis(YAxis.AxisDependency.LEFT);
        this.p = new YAxis(YAxis.AxisDependency.RIGHT);
        this.s = new Transformer(this.Q);
        this.t = new Transformer(this.Q);
        this.q = new YAxisRenderer(this.Q, this.o, this.s);
        this.r = new YAxisRenderer(this.Q, this.p, this.t);
        this.u = new XAxisRenderer(this.Q, this.H, this.s);
        setHighlighter(new ChartHighlighter(this));
        this.M = new BarLineChartTouchListener(this, this.Q.p(), 3.0f);
        Paint paint = new Paint();
        this.g = paint;
        paint.setStyle(Paint.Style.FILL);
        this.g.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.h.setColor(-16777216);
        this.h.setStrokeWidth(Utils.a(1.0f));
    }

    public void a(float f, float f2, float f3, float f4) {
        this.Q.a(f, f2, f3, -f4, this.v);
        this.Q.a(this.v, (View) this, false);
        j();
        postInvalidate();
    }

    protected void a(Canvas canvas) {
        if (this.i) {
            canvas.drawRect(this.Q.k(), this.g);
        }
        if (this.j) {
            canvas.drawRect(this.Q.k(), this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        if (this.K == null || !this.K.z() || this.K.g()) {
            return;
        }
        int i = AnonymousClass2.f22068c[this.K.f().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            int i2 = AnonymousClass2.f22067a[this.K.e().ordinal()];
            if (i2 == 1) {
                rectF.top += Math.min(this.K.b, this.Q.m() * this.K.q()) + this.K.v();
                return;
            } else if (i2 != 2) {
                return;
            } else {
                rectF.bottom += Math.min(this.K.b, this.Q.m() * this.K.q()) + this.K.v();
                return;
            }
        }
        int i3 = AnonymousClass2.b[this.K.d().ordinal()];
        if (i3 == 1) {
            rectF.left += Math.min(this.K.f22089a, this.Q.n() * this.K.q()) + this.K.u();
        } else if (i3 == 2) {
            rectF.right += Math.min(this.K.f22089a, this.Q.n() * this.K.q()) + this.K.u();
        } else if (i3 != 3) {
        } else {
            int i4 = AnonymousClass2.f22067a[this.K.e().ordinal()];
            if (i4 == 1) {
                rectF.top += Math.min(this.K.b, this.Q.m() * this.K.q()) + this.K.v();
            } else if (i4 != 2) {
            } else {
                rectF.bottom += Math.min(this.K.b, this.Q.m() * this.K.q()) + this.K.v();
            }
        }
    }

    public YAxis b(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.o : this.p;
    }

    public IBarLineScatterCandleBubbleDataSet b(float f, float f2) {
        Highlight a2 = a(f, f2);
        if (a2 != null) {
            return (IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.C).a(a2.f());
        }
        return null;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void b() {
        this.H.a(((BarLineScatterCandleBubbleData) this.C).g(), ((BarLineScatterCandleBubbleData) this.C).h());
        this.o.a(((BarLineScatterCandleBubbleData) this.C).a(YAxis.AxisDependency.LEFT), ((BarLineScatterCandleBubbleData) this.C).b(YAxis.AxisDependency.LEFT));
        this.p.a(((BarLineScatterCandleBubbleData) this.C).a(YAxis.AxisDependency.RIGHT), ((BarLineScatterCandleBubbleData) this.C).b(YAxis.AxisDependency.RIGHT));
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public boolean c(YAxis.AxisDependency axisDependency) {
        return b(axisDependency).G();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.M instanceof BarLineChartTouchListener) {
            ((BarLineChartTouchListener) this.M).b();
        }
    }

    protected void f() {
        if (this.B) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.H.u + ", xmax: " + this.H.t + ", xdelta: " + this.H.v);
        }
        this.t.a(this.H.u, this.H.v, this.p.v, this.p.u);
        this.s.a(this.H.u, this.H.v, this.o.v, this.o.u);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.t.a(this.p.G());
        this.s.a(this.o.G());
    }

    public YAxis getAxisLeft() {
        return this.o;
    }

    public YAxis getAxisRight() {
        return this.p;
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public /* bridge */ /* synthetic */ BarLineScatterCandleBubbleData getData() {
        return (BarLineScatterCandleBubbleData) super.getData();
    }

    public OnDrawListener getDrawListener() {
        return this.n;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).a(this.Q.g(), this.Q.h(), this.z);
        return (float) Math.min(this.H.t, this.z.f22202a);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).a(this.Q.f(), this.Q.h(), this.y);
        return (float) Math.max(this.H.u, this.y.f22202a);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.b;
    }

    public float getMinOffset() {
        return this.l;
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.q;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.r;
    }

    public XAxisRenderer getRendererXAxis() {
        return this.u;
    }

    @Override // android.view.View
    public float getScaleX() {
        if (this.Q == null) {
            return 1.0f;
        }
        return this.Q.q();
    }

    @Override // android.view.View
    public float getScaleY() {
        if (this.Q == null) {
            return 1.0f;
        }
        return this.Q.r();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return Math.max(this.o.t, this.p.t);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return Math.min(this.o.u, this.p.u);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void h() {
        if (this.C == 0) {
            if (this.B) {
                Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.B) {
            Log.i("MPAndroidChart", "Preparing...");
        }
        if (this.O != null) {
            this.O.a();
        }
        b();
        this.q.a(this.o.u, this.o.t, this.o.G());
        this.r.a(this.p.u, this.p.t, this.p.G());
        this.u.a(this.H.u, this.H.t, false);
        if (this.K != null) {
            this.N.a(this.C);
        }
        j();
    }

    protected void i() {
        ((BarLineScatterCandleBubbleData) this.C).a(getLowestVisibleX(), getHighestVisibleX());
        this.H.a(((BarLineScatterCandleBubbleData) this.C).g(), ((BarLineScatterCandleBubbleData) this.C).h());
        if (this.o.z()) {
            this.o.a(((BarLineScatterCandleBubbleData) this.C).a(YAxis.AxisDependency.LEFT), ((BarLineScatterCandleBubbleData) this.C).b(YAxis.AxisDependency.LEFT));
        }
        if (this.p.z()) {
            this.p.a(((BarLineScatterCandleBubbleData) this.C).a(YAxis.AxisDependency.RIGHT), ((BarLineScatterCandleBubbleData) this.C).b(YAxis.AxisDependency.RIGHT));
        }
        j();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void j() {
        if (!this.ag) {
            a(this.af);
            float f = this.af.left + 0.0f;
            float f2 = this.af.top + 0.0f;
            float f3 = this.af.right + 0.0f;
            float f4 = this.af.bottom + 0.0f;
            float f5 = f;
            if (this.o.M()) {
                f5 = f + this.o.a(this.q.a());
            }
            float f6 = f3;
            if (this.p.M()) {
                f6 = f3 + this.p.a(this.r.a());
            }
            float f7 = f2;
            float f8 = f4;
            if (this.H.z()) {
                f7 = f2;
                f8 = f4;
                if (this.H.h()) {
                    float v = this.H.F + this.H.v();
                    if (this.H.A() == XAxis.XAxisPosition.BOTTOM) {
                        f8 = f4 + v;
                        f7 = f2;
                    } else {
                        if (this.H.A() == XAxis.XAxisPosition.TOP) {
                            f8 = f4;
                        } else {
                            f7 = f2;
                            f8 = f4;
                            if (this.H.A() == XAxis.XAxisPosition.BOTH_SIDED) {
                                f8 = f4 + v;
                            }
                        }
                        f7 = f2 + v;
                    }
                }
            }
            float extraTopOffset = f7 + getExtraTopOffset();
            float extraRightOffset = f6 + getExtraRightOffset();
            float extraBottomOffset = f8 + getExtraBottomOffset();
            float extraLeftOffset = f5 + getExtraLeftOffset();
            float a2 = Utils.a(this.l);
            this.Q.a(Math.max(a2, extraLeftOffset), Math.max(a2, extraTopOffset), Math.max(a2, extraRightOffset), Math.max(a2, extraBottomOffset));
            if (this.B) {
                Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb = new StringBuilder();
                sb.append("Content: ");
                sb.append(this.Q.k().toString());
                Log.i("MPAndroidChart", sb.toString());
            }
        }
        g();
        f();
    }

    public boolean k() {
        return this.f;
    }

    public boolean l() {
        return this.f22063a || this.aa;
    }

    public boolean m() {
        return this.f22063a;
    }

    public boolean n() {
        return this.aa;
    }

    public boolean o() {
        return this.ab;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a(canvas);
        if (this.f22064c) {
            i();
        }
        if (this.o.z()) {
            this.q.a(this.o.u, this.o.t, this.o.G());
        }
        if (this.p.z()) {
            this.r.a(this.p.u, this.p.t, this.p.G());
        }
        if (this.H.z()) {
            this.u.a(this.H.u, this.H.t, false);
        }
        this.u.b(canvas);
        this.q.b(canvas);
        this.r.b(canvas);
        if (this.H.o()) {
            this.u.c(canvas);
        }
        if (this.o.o()) {
            this.q.c(canvas);
        }
        if (this.p.o()) {
            this.r.c(canvas);
        }
        if (this.H.z() && this.H.n()) {
            this.u.d(canvas);
        }
        if (this.o.z() && this.o.n()) {
            this.q.e(canvas);
        }
        if (this.p.z() && this.p.n()) {
            this.r.e(canvas);
        }
        int save = canvas.save();
        canvas.clipRect(this.Q.k());
        this.O.a(canvas);
        if (!this.H.o()) {
            this.u.c(canvas);
        }
        if (!this.o.o()) {
            this.q.c(canvas);
        }
        if (!this.p.o()) {
            this.r.c(canvas);
        }
        if (x()) {
            this.O.a(canvas, this.S);
        }
        canvas.restoreToCount(save);
        this.O.c(canvas);
        if (this.H.z() && !this.H.n()) {
            this.u.d(canvas);
        }
        if (this.o.z() && !this.o.n()) {
            this.q.e(canvas);
        }
        if (this.p.z() && !this.p.n()) {
            this.r.e(canvas);
        }
        this.u.a(canvas);
        this.q.a(canvas);
        this.r.a(canvas);
        if (r()) {
            int save2 = canvas.save();
            canvas.clipRect(this.Q.k());
            this.O.b(canvas);
            canvas.restoreToCount(save2);
        } else {
            this.O.b(canvas);
        }
        this.N.a(canvas);
        b(canvas);
        c(canvas);
        if (this.B) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long j = this.ad + currentTimeMillis2;
            this.ad = j;
            long j2 = this.ae + 1;
            this.ae = j2;
            long j3 = j / j2;
            Log.i("MPAndroidChart", "Drawtime: " + currentTimeMillis2 + " ms, average: " + j3 + " ms, cycles: " + this.ae);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = this.A;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.m) {
            fArr[0] = this.Q.f();
            this.A[1] = this.Q.e();
            a(YAxis.AxisDependency.LEFT).b(this.A);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (!this.m) {
            this.Q.a(this.Q.p(), (View) this, true);
            return;
        }
        a(YAxis.AxisDependency.LEFT).a(this.A);
        this.Q.a(this.A, this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.M == null || this.C == 0 || !this.I) {
            return false;
        }
        return this.M.onTouch(this, motionEvent);
    }

    public boolean p() {
        return this.ac;
    }

    public boolean q() {
        return this.e;
    }

    public boolean r() {
        return this.k;
    }

    public boolean s() {
        return this.Q.s();
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.f22064c = z;
    }

    public void setBorderColor(int i) {
        this.h.setColor(i);
    }

    public void setBorderWidth(float f) {
        this.h.setStrokeWidth(Utils.a(f));
    }

    public void setClipValuesToContent(boolean z) {
        this.k = z;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.e = z;
    }

    public void setDragEnabled(boolean z) {
        this.f22063a = z;
        this.aa = z;
    }

    public void setDragOffsetX(float f) {
        this.Q.k(f);
    }

    public void setDragOffsetY(float f) {
        this.Q.l(f);
    }

    public void setDragXEnabled(boolean z) {
        this.f22063a = z;
    }

    public void setDragYEnabled(boolean z) {
        this.aa = z;
    }

    public void setDrawBorders(boolean z) {
        this.j = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.i = z;
    }

    public void setGridBackgroundColor(int i) {
        this.g.setColor(i);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.f = z;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.m = z;
    }

    public void setMaxVisibleValueCount(int i) {
        this.b = i;
    }

    public void setMinOffset(float f) {
        this.l = f;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.n = onDrawListener;
    }

    public void setPinchZoom(boolean z) {
        this.d = z;
    }

    public void setRendererLeftYAxis(YAxisRenderer yAxisRenderer) {
        this.q = yAxisRenderer;
    }

    public void setRendererRightYAxis(YAxisRenderer yAxisRenderer) {
        this.r = yAxisRenderer;
    }

    public void setScaleEnabled(boolean z) {
        this.ab = z;
        this.ac = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.ab = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.ac = z;
    }

    public void setVisibleXRangeMaximum(float f) {
        this.Q.a(this.H.v / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.Q.b(this.H.v / f);
    }

    public void setXAxisRenderer(XAxisRenderer xAxisRenderer) {
        this.u = xAxisRenderer;
    }

    public boolean t() {
        return this.d;
    }

    public boolean u() {
        return this.Q.v();
    }

    public boolean v() {
        return this.o.G() || this.p.G();
    }
}
