package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/PieRadarChartBase.class */
public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {

    /* renamed from: a  reason: collision with root package name */
    private float f22077a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f22078c;
    protected float d;

    /* renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/PieRadarChartBase$1.class */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PieRadarChartBase f22079a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f22079a.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$2  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/PieRadarChartBase$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22080a;
        static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f22081c;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0069 -> B:35:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006d -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0071 -> B:41:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0075 -> B:37:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0079 -> B:13:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007d -> B:43:0x005d). Please submit an issue!!! */
        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            f22081c = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22081c[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
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
            f22080a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22080a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22077a = 270.0f;
        this.b = 270.0f;
        this.f22078c = true;
        this.d = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22077a = 270.0f;
        this.b = 270.0f;
        this.f22078c = true;
        this.d = 0.0f;
    }

    public abstract int a(float f);

    public MPPointF a(MPPointF mPPointF, float f, float f2) {
        MPPointF a2 = MPPointF.a(0.0f, 0.0f);
        a(mPPointF, f, f2, a2);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void a() {
        super.a();
        this.M = new PieRadarChartTouchListener(this);
    }

    public void a(MPPointF mPPointF, float f, float f2, MPPointF mPPointF2) {
        double d = f;
        double d2 = f2;
        mPPointF2.f22204a = (float) (mPPointF.f22204a + (Math.cos(Math.toRadians(d2)) * d));
        mPPointF2.b = (float) (mPPointF.b + (d * Math.sin(Math.toRadians(d2))));
    }

    public float b(float f, float f2) {
        MPPointF centerOffsets = getCenterOffsets();
        double d = f - centerOffsets.f22204a;
        double d2 = f2 - centerOffsets.b;
        float degrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d * d) + (d2 * d2))));
        float f3 = degrees;
        if (f > centerOffsets.f22204a) {
            f3 = 360.0f - degrees;
        }
        float f4 = f3 + 90.0f;
        float f5 = f4;
        if (f4 > 360.0f) {
            f5 = f4 - 360.0f;
        }
        MPPointF.b(centerOffsets);
        return f5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public void b() {
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.M instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) this.M).b();
        }
    }

    public float d(float f, float f2) {
        MPPointF centerOffsets = getCenterOffsets();
        float sqrt = (float) Math.sqrt(Math.pow(f > centerOffsets.f22204a ? f - centerOffsets.f22204a : centerOffsets.f22204a - f, 2.0d) + Math.pow(f2 > centerOffsets.b ? f2 - centerOffsets.b : centerOffsets.b - f2, 2.0d));
        MPPointF.b(centerOffsets);
        return sqrt;
    }

    public float getDiameter() {
        RectF k = this.Q.k();
        k.left += getExtraLeftOffset();
        k.top += getExtraTopOffset();
        k.right -= getExtraRightOffset();
        k.bottom -= getExtraBottomOffset();
        return Math.min(k.width(), k.height());
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.C.j();
    }

    public float getMinOffset() {
        return this.d;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.b;
    }

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.f22077a;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void h() {
        if (this.C == null) {
            return;
        }
        b();
        if (this.K != null) {
            this.N.a(this.C);
        }
        j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0082, code lost:
        if (r7.K.e() == com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM) goto L33;
     */
    @Override // com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j() {
        /*
            Method dump skipped, instructions count: 910
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.j():void");
    }

    public boolean k() {
        return this.f22078c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (!this.I || this.M == null) ? super.onTouchEvent(motionEvent) : this.M.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f) {
        this.d = f;
    }

    public void setRotationAngle(float f) {
        this.b = f;
        this.f22077a = Utils.c(f);
    }

    public void setRotationEnabled(boolean z) {
        this.f22078c = z;
    }
}
