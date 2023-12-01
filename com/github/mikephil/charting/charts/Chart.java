package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/Chart.class */
public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    protected boolean B;
    protected T C;
    protected boolean D;
    protected DefaultValueFormatter E;
    protected Paint F;
    protected Paint G;
    protected XAxis H;
    protected boolean I;
    protected Description J;
    protected Legend K;
    protected OnChartValueSelectedListener L;
    protected ChartTouchListener M;
    protected LegendRenderer N;
    protected DataRenderer O;
    protected IHighlighter P;
    protected ViewPortHandler Q;
    protected ChartAnimator R;
    protected Highlight[] S;
    protected float T;
    protected boolean U;
    protected IMarker V;
    protected ArrayList<Runnable> W;

    /* renamed from: a  reason: collision with root package name */
    private boolean f8462a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private String f8463c;
    private OnChartGestureListener d;
    private float e;
    private float f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;

    /* renamed from: com.github.mikephil.charting.charts.Chart$2  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/charts/Chart$2.class */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8465a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            f8465a = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8465a[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8465a[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public Chart(Context context) {
        super(context);
        this.B = false;
        this.C = null;
        this.D = true;
        this.f8462a = true;
        this.b = 0.9f;
        this.E = new DefaultValueFormatter(0);
        this.I = true;
        this.f8463c = "No chart data available.";
        this.Q = new ViewPortHandler();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = false;
        this.T = 0.0f;
        this.U = true;
        this.W = new ArrayList<>();
        this.j = false;
        a();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = false;
        this.C = null;
        this.D = true;
        this.f8462a = true;
        this.b = 0.9f;
        this.E = new DefaultValueFormatter(0);
        this.I = true;
        this.f8463c = "No chart data available.";
        this.Q = new ViewPortHandler();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = false;
        this.T = 0.0f;
        this.U = true;
        this.W = new ArrayList<>();
        this.j = false;
        a();
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = false;
        this.C = null;
        this.D = true;
        this.f8462a = true;
        this.b = 0.9f;
        this.E = new DefaultValueFormatter(0);
        this.I = true;
        this.f8463c = "No chart data available.";
        this.Q = new ViewPortHandler();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = false;
        this.T = 0.0f;
        this.U = true;
        this.W = new ArrayList<>();
        this.j = false;
        a();
    }

    private void a(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                viewGroup.removeAllViews();
                return;
            } else {
                a(viewGroup.getChildAt(i2));
                i = i2 + 1;
            }
        }
    }

    public void A() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void B() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public boolean C() {
        return this.U;
    }

    public Highlight a(float f, float f2) {
        if (this.C == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        return getHighlighter().a(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        setWillNotDraw(false);
        this.R = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.Chart.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chart.this.postInvalidate();
            }
        });
        Utils.a(getContext());
        this.T = Utils.a(500.0f);
        this.J = new Description();
        Legend legend = new Legend();
        this.K = legend;
        this.N = new LegendRenderer(this.Q, legend);
        this.H = new XAxis();
        this.F = new Paint(1);
        Paint paint = new Paint(1);
        this.G = paint;
        paint.setColor(Color.rgb(247, 189, 51));
        this.G.setTextAlign(Paint.Align.CENTER);
        this.G.setTextSize(Utils.a(12.0f));
        if (this.B) {
            Log.i("", "Chart.init()");
        }
    }

    public void a(Highlight highlight, boolean z) {
        Entry entry = null;
        if (highlight == null) {
            this.S = null;
        } else {
            if (this.B) {
                Log.i("MPAndroidChart", "Highlighted: " + highlight.toString());
            }
            entry = this.C.a(highlight);
            if (entry == null) {
                this.S = null;
                highlight = null;
            } else {
                this.S = new Highlight[]{highlight};
            }
        }
        setLastHighlighted(this.S);
        if (z && this.L != null) {
            if (x()) {
                this.L.a(entry, highlight);
            } else {
                this.L.a();
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] a(Highlight highlight) {
        return new float[]{highlight.i(), highlight.j()};
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Canvas canvas) {
        float f;
        float f2;
        Description description = this.J;
        if (description == null || !description.z()) {
            return;
        }
        MPPointF b = this.J.b();
        this.F.setTypeface(this.J.w());
        this.F.setTextSize(this.J.x());
        this.F.setColor(this.J.y());
        this.F.setTextAlign(this.J.c());
        if (b == null) {
            f = (getWidth() - this.Q.b()) - this.J.u();
            f2 = (getHeight() - this.Q.d()) - this.J.v();
        } else {
            f = b.f8597a;
            f2 = b.b;
        }
        canvas.drawText(this.J.a(), f, f2, this.F);
    }

    protected void c(float f, float f2) {
        T t = this.C;
        this.E.a(Utils.b((t == null || t.j() < 2) ? Math.max(Math.abs(f), Math.abs(f2)) : Math.abs(f2 - f)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Canvas canvas) {
        if (this.V == null || !C() || !x()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            Highlight[] highlightArr = this.S;
            if (i2 >= highlightArr.length) {
                return;
            }
            Highlight highlight = highlightArr[i2];
            IDataSet a2 = this.C.a(highlight.f());
            Entry a3 = this.C.a(this.S[i2]);
            int d = a2.d((IDataSet) a3);
            if (a3 != null && d <= a2.H() * this.R.b()) {
                float[] a4 = a(highlight);
                if (this.Q.b(a4[0], a4[1])) {
                    this.V.a(a3, highlight);
                    this.V.a(canvas, a4[0], a4[1]);
                }
            }
            i = i2 + 1;
        }
    }

    public ChartAnimator getAnimator() {
        return this.R;
    }

    public MPPointF getCenter() {
        return MPPointF.a(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public MPPointF getCenterOfView() {
        return getCenter();
    }

    public MPPointF getCenterOffsets() {
        return this.Q.l();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.Q.k();
    }

    public T getData() {
        return this.C;
    }

    public ValueFormatter getDefaultValueFormatter() {
        return this.E;
    }

    public Description getDescription() {
        return this.J;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.b;
    }

    public float getExtraBottomOffset() {
        return this.g;
    }

    public float getExtraLeftOffset() {
        return this.h;
    }

    public float getExtraRightOffset() {
        return this.f;
    }

    public float getExtraTopOffset() {
        return this.e;
    }

    public Highlight[] getHighlighted() {
        return this.S;
    }

    public IHighlighter getHighlighter() {
        return this.P;
    }

    public ArrayList<Runnable> getJobs() {
        return this.W;
    }

    public Legend getLegend() {
        return this.K;
    }

    public LegendRenderer getLegendRenderer() {
        return this.N;
    }

    public IMarker getMarker() {
        return this.V;
    }

    @Deprecated
    public IMarker getMarkerView() {
        return getMarker();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getMaxHighlightDistance() {
        return this.T;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.d;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.M;
    }

    public DataRenderer getRenderer() {
        return this.O;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.Q;
    }

    public XAxis getXAxis() {
        return this.H;
    }

    public float getXChartMax() {
        return this.H.t;
    }

    public float getXChartMin() {
        return this.H.u;
    }

    public float getXRange() {
        return this.H.v;
    }

    public float getYMax() {
        return this.C.f();
    }

    public float getYMin() {
        return this.C.e();
    }

    public abstract void h();

    protected abstract void j();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j) {
            a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.C == null) {
            if (!TextUtils.isEmpty(this.f8463c)) {
                MPPointF center = getCenter();
                canvas.drawText(this.f8463c, center.f8597a, center.b, this.G);
            }
        } else if (this.i) {
        } else {
            j();
            this.i = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= getChildCount()) {
                return;
            }
            getChildAt(i6).layout(i, i2, i3, i4);
            i5 = i6 + 1;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int a2 = (int) Utils.a(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), resolveSize(a2, i)), Math.max(getSuggestedMinimumHeight(), resolveSize(a2, i2)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.B) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            if (this.B) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            this.Q.a(i, i2);
        } else if (this.B) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i + ", height: " + i2);
        }
        h();
        Iterator<Runnable> it = this.W.iterator();
        while (it.hasNext()) {
            post(it.next());
        }
        this.W.clear();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setData(T t) {
        this.C = t;
        this.i = false;
        if (t == null) {
            return;
        }
        c(t.e(), t.f());
        for (IDataSet iDataSet : this.C.i()) {
            if (iDataSet.r() || iDataSet.q() == this.E) {
                iDataSet.a(this.E);
            }
        }
        h();
        if (this.B) {
            Log.i("MPAndroidChart", "Data is set.");
        }
    }

    public void setDescription(Description description) {
        this.J = description;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.f8462a = z;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = f2;
        if (f2 >= 1.0f) {
            f3 = 0.999f;
        }
        this.b = f3;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z) {
        setDrawMarkers(z);
    }

    public void setDrawMarkers(boolean z) {
        this.U = z;
    }

    public void setExtraBottomOffset(float f) {
        this.g = Utils.a(f);
    }

    public void setExtraLeftOffset(float f) {
        this.h = Utils.a(f);
    }

    public void setExtraRightOffset(float f) {
        this.f = Utils.a(f);
    }

    public void setExtraTopOffset(float f) {
        this.e = Utils.a(f);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.D = z;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.P = chartHighlighter;
    }

    protected void setLastHighlighted(Highlight[] highlightArr) {
        if (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) {
            this.M.a((Highlight) null);
        } else {
            this.M.a(highlightArr[0]);
        }
    }

    public void setLogEnabled(boolean z) {
        this.B = z;
    }

    public void setMarker(IMarker iMarker) {
        this.V = iMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker iMarker) {
        setMarker(iMarker);
    }

    public void setMaxHighlightDistance(float f) {
        this.T = Utils.a(f);
    }

    public void setNoDataText(String str) {
        this.f8463c = str;
    }

    public void setNoDataTextColor(int i) {
        this.G.setColor(i);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.G.setTypeface(typeface);
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.d = onChartGestureListener;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.L = onChartValueSelectedListener;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.M = chartTouchListener;
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.O = dataRenderer;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.I = z;
    }

    public void setUnbindEnabled(boolean z) {
        this.j = z;
    }

    public boolean w() {
        return this.D;
    }

    public boolean x() {
        Highlight[] highlightArr = this.S;
        boolean z = false;
        if (highlightArr != null) {
            z = false;
            if (highlightArr.length > 0) {
                if (highlightArr[0] == null) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }

    public boolean y() {
        return this.f8462a;
    }

    public boolean z() {
        return this.B;
    }
}
