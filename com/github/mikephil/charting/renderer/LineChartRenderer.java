package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/LineChartRenderer.class */
public class LineChartRenderer extends LineRadarRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected LineDataProvider f22185a;
    protected Paint b;

    /* renamed from: c  reason: collision with root package name */
    protected WeakReference<Bitmap> f22186c;
    protected Canvas d;
    protected Bitmap.Config e;
    protected Path l;
    protected Path m;
    protected Path n;
    private float[] p;
    private HashMap<IDataSet, DataSetImageCache> q;
    private float[] r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/LineChartRenderer$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22187a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[LineDataSet.Mode.values().length];
            f22187a = iArr;
            try {
                iArr[LineDataSet.Mode.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22187a[LineDataSet.Mode.STEPPED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22187a[LineDataSet.Mode.CUBIC_BEZIER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22187a[LineDataSet.Mode.HORIZONTAL_BEZIER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/LineChartRenderer$DataSetImageCache.class */
    public class DataSetImageCache {
        private Path b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap[] f22189c;

        private DataSetImageCache() {
            this.b = new Path();
        }

        /* synthetic */ DataSetImageCache(LineChartRenderer lineChartRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }

        protected Bitmap a(int i) {
            Bitmap[] bitmapArr = this.f22189c;
            return bitmapArr[i % bitmapArr.length];
        }

        protected void a(ILineDataSet iLineDataSet, boolean z, boolean z2) {
            int D = iLineDataSet.D();
            float c2 = iLineDataSet.c();
            float d = iLineDataSet.d();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= D) {
                    return;
                }
                int i3 = (int) (c2 * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                this.f22189c[i2] = createBitmap;
                LineChartRenderer.this.h.setColor(iLineDataSet.f(i2));
                if (z2) {
                    this.b.reset();
                    this.b.addCircle(c2, c2, c2, Path.Direction.CW);
                    this.b.addCircle(c2, c2, d, Path.Direction.CCW);
                    canvas.drawPath(this.b, LineChartRenderer.this.h);
                } else {
                    canvas.drawCircle(c2, c2, c2, LineChartRenderer.this.h);
                    if (z) {
                        canvas.drawCircle(c2, c2, d, LineChartRenderer.this.b);
                    }
                }
                i = i2 + 1;
            }
        }

        protected boolean a(ILineDataSet iLineDataSet) {
            int D = iLineDataSet.D();
            Bitmap[] bitmapArr = this.f22189c;
            if (bitmapArr == null) {
                this.f22189c = new Bitmap[D];
                return true;
            } else if (bitmapArr.length != D) {
                this.f22189c = new Bitmap[D];
                return true;
            } else {
                return false;
            }
        }
    }

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.e = Bitmap.Config.ARGB_8888;
        this.l = new Path();
        this.m = new Path();
        this.p = new float[4];
        this.n = new Path();
        this.q = new HashMap<>();
        this.r = new float[2];
        this.f22185a = lineDataProvider;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.b.setColor(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.github.mikephil.charting.data.Entry] */
    private void a(ILineDataSet iLineDataSet, int i, int i2, Path path) {
        float fillLinePosition = iLineDataSet.N().getFillLinePosition(iLineDataSet, this.f22185a);
        float a2 = this.g.a();
        boolean z = iLineDataSet.a() == LineDataSet.Mode.STEPPED;
        path.reset();
        Entry e = iLineDataSet.e(i);
        path.moveTo(e.i(), fillLinePosition);
        path.lineTo(e.i(), e.b() * a2);
        Entry entry = null;
        int i3 = i + 1;
        while (i3 <= i2) {
            entry = iLineDataSet.e(i3);
            if (z) {
                path.lineTo(entry.i(), e.b() * a2);
            }
            path.lineTo(entry.i(), entry.b() * a2);
            i3++;
            e = entry;
        }
        if (entry != null) {
            path.lineTo(entry.i(), fillLinePosition);
        }
        path.close();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
        if (r10.getHeight() != r0) goto L24;
     */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.graphics.Canvas r7) {
        /*
            r6 = this;
            r0 = r6
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r0.o
            float r0 = r0.n()
            int r0 = (int) r0
            r8 = r0
            r0 = r6
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r0.o
            float r0 = r0.m()
            int r0 = (int) r0
            r9 = r0
            r0 = r6
            java.lang.ref.WeakReference<android.graphics.Bitmap> r0 = r0.f22186c
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L23
            r0 = 0
            r10 = r0
            goto L2d
        L23:
            r0 = r10
            java.lang.Object r0 = r0.get()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r10 = r0
        L2d:
            r0 = r10
            if (r0 == 0) goto L48
            r0 = r10
            int r0 = r0.getWidth()
            r1 = r8
            if (r0 != r1) goto L48
            r0 = r10
            r11 = r0
            r0 = r10
            int r0 = r0.getHeight()
            r1 = r9
            if (r0 == r1) goto L75
        L48:
            r0 = r8
            if (r0 <= 0) goto Lc4
            r0 = r9
            if (r0 <= 0) goto Lc4
            r0 = r8
            r1 = r9
            r2 = r6
            android.graphics.Bitmap$Config r2 = r2.e
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            r11 = r0
            r0 = r6
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r2 = r1
            r3 = r11
            r2.<init>(r3)
            r0.f22186c = r1
            r0 = r6
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r2 = r1
            r3 = r11
            r2.<init>(r3)
            r0.d = r1
        L75:
            r0 = r11
            r1 = 0
            r0.eraseColor(r1)
            r0 = r6
            com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider r0 = r0.f22185a
            com.github.mikephil.charting.data.LineData r0 = r0.getLineData()
            java.util.List r0 = r0.i()
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
        L8e:
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lb8
            r0 = r10
            java.lang.Object r0 = r0.next()
            com.github.mikephil.charting.interfaces.datasets.ILineDataSet r0 = (com.github.mikephil.charting.interfaces.datasets.ILineDataSet) r0
            r12 = r0
            r0 = r12
            boolean r0 = r0.B()
            if (r0 == 0) goto L8e
            r0 = r6
            r1 = r7
            r2 = r12
            r0.a(r1, r2)
            goto L8e
        Lb8:
            r0 = r7
            r1 = r11
            r2 = 0
            r3 = 0
            r4 = r6
            android.graphics.Paint r4 = r4.h
            r0.drawBitmap(r1, r2, r3, r4)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LineChartRenderer.a(android.graphics.Canvas):void");
    }

    protected void a(Canvas canvas, ILineDataSet iLineDataSet) {
        if (iLineDataSet.H() < 1) {
            return;
        }
        this.h.setStrokeWidth(iLineDataSet.R());
        this.h.setPathEffect(iLineDataSet.f());
        int i = AnonymousClass1.f22187a[iLineDataSet.a().ordinal()];
        if (i == 3) {
            b(iLineDataSet);
        } else if (i != 4) {
            b(canvas, iLineDataSet);
        } else {
            a(iLineDataSet);
        }
        this.h.setPathEffect(null);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.github.mikephil.charting.data.Entry] */
    protected void a(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        float fillLinePosition = iLineDataSet.N().getFillLinePosition(iLineDataSet, this.f22185a);
        path.lineTo(iLineDataSet.e(xBounds.f22172a + xBounds.f22173c).i(), fillLinePosition);
        path.lineTo(iLineDataSet.e(xBounds.f22172a).i(), fillLinePosition);
        path.close();
        transformer.a(path);
        Drawable P = iLineDataSet.P();
        if (P != null) {
            a(canvas, path, P);
        } else {
            a(canvas, path, iLineDataSet.O(), iLineDataSet.Q());
        }
    }

    protected void a(Canvas canvas, ILineDataSet iLineDataSet, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        int i;
        int i2;
        Path path = this.n;
        int i3 = xBounds.f22172a;
        int i4 = xBounds.f22173c + xBounds.f22172a;
        int i5 = 0;
        do {
            i = (i5 * 128) + i3;
            int i6 = i + 128;
            i2 = i6;
            if (i6 > i4) {
                i2 = i4;
            }
            if (i <= i2) {
                a(iLineDataSet, i, i2, path);
                transformer.a(path);
                Drawable P = iLineDataSet.P();
                if (P != null) {
                    a(canvas, path, P);
                } else {
                    a(canvas, path, iLineDataSet.O(), iLineDataSet.Q());
                }
            }
            i5++;
        } while (i <= i2);
    }

    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.k.setColor(i);
        canvas.drawText(str, f, f2, this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void a(Canvas canvas, Highlight[] highlightArr) {
        LineData lineData = this.f22185a.getLineData();
        int length = highlightArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Highlight highlight = highlightArr[i2];
            ILineDataSet iLineDataSet = (ILineDataSet) lineData.a(highlight.f());
            if (iLineDataSet != null && iLineDataSet.p()) {
                ?? b = iLineDataSet.b(highlight.a(), highlight.b());
                if (a((Entry) b, iLineDataSet)) {
                    MPPointD b2 = this.f22185a.a(iLineDataSet.C()).b(b.i(), b.b() * this.g.a());
                    highlight.a((float) b2.f22202a, (float) b2.b);
                    a(canvas, (float) b2.f22202a, (float) b2.b, iLineDataSet);
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r0v40, types: [com.github.mikephil.charting.data.Entry] */
    protected void a(ILineDataSet iLineDataSet) {
        float a2 = this.g.a();
        Transformer a3 = this.f22185a.a(iLineDataSet.C());
        this.f.a(this.f22185a, iLineDataSet);
        this.l.reset();
        if (this.f.f22173c >= 1) {
            Entry e = iLineDataSet.e(this.f.f22172a);
            this.l.moveTo(e.i(), e.b() * a2);
            int i = this.f.f22172a + 1;
            while (i <= this.f.f22173c + this.f.f22172a) {
                ?? e2 = iLineDataSet.e(i);
                float i2 = e.i() + ((e2.i() - e.i()) / 2.0f);
                this.l.cubicTo(i2, e.b() * a2, i2, e2.b() * a2, e2.i(), e2.b() * a2);
                i++;
                e = e2;
            }
        }
        if (iLineDataSet.S()) {
            this.m.reset();
            this.m.addPath(this.l);
            a(this.d, iLineDataSet, this.m, a3, this.f);
        }
        this.h.setColor(iLineDataSet.k());
        this.h.setStyle(Paint.Style.STROKE);
        a3.a(this.l);
        this.d.drawPath(this.l, this.h);
        this.h.setPathEffect(null);
    }

    public void b() {
        Canvas canvas = this.d;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.d = null;
        }
        WeakReference<Bitmap> weakReference = this.f22186c;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f22186c.clear();
            this.f22186c = null;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        if (!a(this.f22185a)) {
            return;
        }
        List<T> i = this.f22185a.getLineData().i();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i.size()) {
                return;
            }
            ILineDataSet iLineDataSet = (ILineDataSet) i.get(i3);
            if (a((IDataSet) iLineDataSet) && iLineDataSet.H() >= 1) {
                b((IDataSet) iLineDataSet);
                Transformer a2 = this.f22185a.a(iLineDataSet.C());
                int c2 = (int) (iLineDataSet.c() * 1.75f);
                int i4 = c2;
                if (!iLineDataSet.g()) {
                    i4 = c2 / 2;
                }
                this.f.a(this.f22185a, iLineDataSet);
                float[] a3 = a2.a(iLineDataSet, this.g.b(), this.g.a(), this.f.f22172a, this.f.b);
                ValueFormatter q = iLineDataSet.q();
                MPPointF a4 = MPPointF.a(iLineDataSet.A());
                a4.f22204a = Utils.a(a4.f22204a);
                a4.b = Utils.a(a4.b);
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= a3.length) {
                        break;
                    }
                    float f = a3[i6];
                    float f2 = a3[i6 + 1];
                    if (!this.o.h(f)) {
                        break;
                    }
                    if (this.o.g(f) && this.o.f(f2)) {
                        int i7 = i6 / 2;
                        Entry e = iLineDataSet.e(this.f.f22172a + i7);
                        if (iLineDataSet.y()) {
                            a(canvas, q.a(e), f, f2 - i4, iLineDataSet.d(i7));
                        }
                        if (e.g() != null && iLineDataSet.z()) {
                            Drawable g = e.g();
                            Utils.a(canvas, g, (int) (f + a4.f22204a), (int) (f2 + a4.b), g.getIntrinsicWidth(), g.getIntrinsicHeight());
                        }
                    }
                    i5 = i6 + 2;
                }
                MPPointF.b(a4);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v122, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r0v152, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r0v54, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r0v56, types: [com.github.mikephil.charting.data.Entry] */
    protected void b(Canvas canvas, ILineDataSet iLineDataSet) {
        int i;
        int H = iLineDataSet.H();
        boolean z = iLineDataSet.a() == LineDataSet.Mode.STEPPED;
        int i2 = z ? 4 : 2;
        Transformer a2 = this.f22185a.a(iLineDataSet.C());
        float a3 = this.g.a();
        this.h.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = iLineDataSet.e() ? this.d : canvas;
        this.f.a(this.f22185a, iLineDataSet);
        if (iLineDataSet.S() && H > 0) {
            a(canvas, iLineDataSet, a2, this.f);
        }
        if (iLineDataSet.j().size() > 1) {
            int i3 = i2 * 2;
            if (this.p.length <= i3) {
                this.p = new float[i2 * 4];
            }
            int i4 = this.f.f22172a;
            while (true) {
                int i5 = i4;
                if (i5 > this.f.f22173c + this.f.f22172a) {
                    break;
                }
                ?? e = iLineDataSet.e(i5);
                if (e != 0) {
                    this.p[0] = e.i();
                    this.p[1] = e.b() * a3;
                    if (i5 < this.f.b) {
                        ?? e2 = iLineDataSet.e(i5 + 1);
                        if (e2 == 0) {
                            break;
                        } else if (z) {
                            this.p[2] = e2.i();
                            float[] fArr = this.p;
                            fArr[3] = fArr[1];
                            fArr[4] = fArr[2];
                            fArr[5] = fArr[3];
                            fArr[6] = e2.i();
                            this.p[7] = e2.b() * a3;
                        } else {
                            this.p[2] = e2.i();
                            this.p[3] = e2.b() * a3;
                        }
                    } else {
                        float[] fArr2 = this.p;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    a2.a(this.p);
                    if (!this.o.h(this.p[0])) {
                        break;
                    } else if (this.o.g(this.p[2]) && (this.o.i(this.p[1]) || this.o.j(this.p[3]))) {
                        this.h.setColor(iLineDataSet.a(i5));
                        canvas2.drawLines(this.p, 0, i3, this.h);
                    }
                }
                i4 = i5 + 1;
            }
        } else {
            int i6 = H * i2;
            if (this.p.length < Math.max(i6, i2) * 2) {
                this.p = new float[Math.max(i6, i2) * 4];
            }
            if (iLineDataSet.e(this.f.f22172a) != 0) {
                int i7 = this.f.f22172a;
                int i8 = 0;
                while (true) {
                    i = i8;
                    if (i7 > this.f.f22173c + this.f.f22172a) {
                        break;
                    }
                    ?? e3 = iLineDataSet.e(i7 == 0 ? 0 : i7 - 1);
                    ?? e4 = iLineDataSet.e(i7);
                    int i9 = i;
                    if (e3 != 0) {
                        if (e4 == 0) {
                            i9 = i;
                        } else {
                            int i10 = i + 1;
                            this.p[i] = e3.i();
                            int i11 = i10 + 1;
                            this.p[i10] = e3.b() * a3;
                            int i12 = i11;
                            if (z) {
                                int i13 = i11 + 1;
                                this.p[i11] = e4.i();
                                int i14 = i13 + 1;
                                this.p[i13] = e3.b() * a3;
                                int i15 = i14 + 1;
                                this.p[i14] = e4.i();
                                i12 = i15 + 1;
                                this.p[i15] = e3.b() * a3;
                            }
                            int i16 = i12 + 1;
                            this.p[i12] = e4.i();
                            this.p[i16] = e4.b() * a3;
                            i9 = i16 + 1;
                        }
                    }
                    i7++;
                    i8 = i9;
                }
                if (i > 0) {
                    a2.a(this.p);
                    int max = Math.max((this.f.f22173c + 1) * i2, i2);
                    this.h.setColor(iLineDataSet.k());
                    canvas2.drawLines(this.p, 0, max * 2, this.h);
                }
            }
        }
        this.h.setPathEffect(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r0v45, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r0v61, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r0v87, types: [com.github.mikephil.charting.data.Entry] */
    protected void b(ILineDataSet iLineDataSet) {
        float a2 = this.g.a();
        Transformer a3 = this.f22185a.a(iLineDataSet.C());
        this.f.a(this.f22185a, iLineDataSet);
        float b = iLineDataSet.b();
        this.l.reset();
        if (this.f.f22173c >= 1) {
            int i = this.f.f22172a + 1;
            int i2 = this.f.f22172a;
            int i3 = this.f.f22173c;
            Entry e = iLineDataSet.e(Math.max(i - 2, 0));
            Entry e2 = iLineDataSet.e(Math.max(i - 1, 0));
            int i4 = -1;
            if (e2 == null) {
                return;
            }
            this.l.moveTo(e2.i(), e2.b() * a2);
            int i5 = this.f.f22172a + 1;
            Entry entry = e2;
            while (i5 <= this.f.f22173c + this.f.f22172a) {
                if (i4 != i5) {
                    e2 = iLineDataSet.e(i5);
                }
                int i6 = i5 + 1;
                if (i6 < iLineDataSet.H()) {
                    i5 = i6;
                }
                ?? e3 = iLineDataSet.e(i5);
                this.l.cubicTo(entry.i() + ((e2.i() - e.i()) * b), (entry.b() + ((e2.b() - e.b()) * b)) * a2, e2.i() - ((e3.i() - entry.i()) * b), (e2.b() - ((e3.b() - entry.b()) * b)) * a2, e2.i(), e2.b() * a2);
                e = entry;
                entry = e2;
                e2 = e3;
                i4 = i5;
                i5 = i6;
            }
        }
        if (iLineDataSet.S()) {
            this.m.reset();
            this.m.addPath(this.l);
            a(this.d, iLineDataSet, this.m, a3, this.f);
        }
        this.h.setColor(iLineDataSet.k());
        this.h.setStyle(Paint.Style.STROKE);
        a3.a(this.l);
        this.d.drawPath(this.l, this.h);
        this.h.setPathEffect(null);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        d(canvas);
    }

    /* JADX WARN: Type inference failed for: r0v64, types: [com.github.mikephil.charting.data.Entry] */
    protected void d(Canvas canvas) {
        DataSetImageCache dataSetImageCache;
        ?? e;
        Bitmap a2;
        this.h.setStyle(Paint.Style.FILL);
        float a3 = this.g.a();
        float[] fArr = this.r;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List<T> i = this.f22185a.getLineData().i();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i.size()) {
                return;
            }
            ILineDataSet iLineDataSet = (ILineDataSet) i.get(i3);
            if (iLineDataSet.B() && iLineDataSet.g() && iLineDataSet.H() != 0) {
                this.b.setColor(iLineDataSet.E());
                Transformer a4 = this.f22185a.a(iLineDataSet.C());
                this.f.a(this.f22185a, iLineDataSet);
                float c2 = iLineDataSet.c();
                float d = iLineDataSet.d();
                boolean z = iLineDataSet.F() && d < c2 && d > 0.0f;
                boolean z2 = z && iLineDataSet.E() == 1122867;
                if (this.q.containsKey(iLineDataSet)) {
                    dataSetImageCache = this.q.get(iLineDataSet);
                } else {
                    dataSetImageCache = new DataSetImageCache(this, null);
                    this.q.put(iLineDataSet, dataSetImageCache);
                }
                if (dataSetImageCache.a(iLineDataSet)) {
                    dataSetImageCache.a(iLineDataSet, z, z2);
                }
                int i4 = this.f.f22173c;
                int i5 = this.f.f22172a;
                int i6 = this.f.f22172a;
                while (true) {
                    int i7 = i6;
                    if (i7 <= i4 + i5 && (e = iLineDataSet.e(i7)) != 0) {
                        this.r[0] = e.i();
                        this.r[1] = e.b() * a3;
                        a4.a(this.r);
                        if (!this.o.h(this.r[0])) {
                            break;
                        }
                        if (this.o.g(this.r[0]) && this.o.f(this.r[1]) && (a2 = dataSetImageCache.a(i7)) != null) {
                            float[] fArr2 = this.r;
                            canvas.drawBitmap(a2, fArr2[0] - c2, fArr2[1] - c2, (Paint) null);
                        }
                        i6 = i7 + 1;
                    }
                }
            }
            i2 = i3 + 1;
        }
    }
}
