package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/LegendRenderer.class */
public class LegendRenderer extends Renderer {

    /* renamed from: a  reason: collision with root package name */
    protected Paint f22181a;
    protected Paint b;

    /* renamed from: c  reason: collision with root package name */
    protected Legend f22182c;
    protected List<LegendEntry> d;
    protected Paint.FontMetrics e;
    private Path f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/LegendRenderer$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22183a;
        static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f22184c;
        static final /* synthetic */ int[] d;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c0 -> B:84:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c4 -> B:68:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c8 -> B:64:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00cc -> B:76:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00d0 -> B:72:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00d4 -> B:14:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d8 -> B:78:0x0060). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00dc -> B:19:0x006b). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00e0 -> B:82:0x007f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e4 -> B:66:0x008a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00e8 -> B:26:0x0095). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00ec -> B:74:0x00a9). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00f0 -> B:70:0x00b4). Please submit an issue!!! */
        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            d = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                d[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                d[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                d[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                d[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                d[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            f22184c = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f22184c[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            b = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                b[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                b[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            f22183a = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f22183a[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f22183a[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.d = new ArrayList(16);
        this.e = new Paint.FontMetrics();
        this.f = new Path();
        this.f22182c = legend;
        Paint paint = new Paint(1);
        this.f22181a = paint;
        paint.setTextSize(Utils.a(9.0f));
        this.f22181a.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public Paint a() {
        return this.f22181a;
    }

    public void a(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float e;
        float f4;
        float f5;
        float f6;
        if (this.f22182c.z()) {
            Typeface w = this.f22182c.w();
            if (w != null) {
                this.f22181a.setTypeface(w);
            }
            this.f22181a.setTextSize(this.f22182c.x());
            this.f22181a.setColor(this.f22182c.y());
            float a2 = Utils.a(this.f22181a, this.e);
            float b = Utils.b(this.f22181a, this.e) + Utils.a(this.f22182c.n());
            float b2 = a2 - (Utils.b(this.f22181a, "ABC") / 2.0f);
            LegendEntry[] a3 = this.f22182c.a();
            float a4 = Utils.a(this.f22182c.o());
            float a5 = Utils.a(this.f22182c.m());
            Legend.LegendOrientation f7 = this.f22182c.f();
            Legend.LegendHorizontalAlignment d = this.f22182c.d();
            Legend.LegendVerticalAlignment e2 = this.f22182c.e();
            Legend.LegendDirection h = this.f22182c.h();
            float a6 = Utils.a(this.f22182c.j());
            float a7 = Utils.a(this.f22182c.p());
            float v = this.f22182c.v();
            float u = this.f22182c.u();
            int i = AnonymousClass1.f22183a[d.ordinal()];
            if (i == 1) {
                if (f7 != Legend.LegendOrientation.VERTICAL) {
                    u += this.o.f();
                }
                if (h == Legend.LegendDirection.RIGHT_TO_LEFT) {
                    u = this.f22182c.f22089a + u;
                }
            } else if (i == 2) {
                float n = (f7 == Legend.LegendOrientation.VERTICAL ? this.o.n() : this.o.g()) - u;
                u = n;
                if (h == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    u = n - this.f22182c.f22089a;
                }
            } else if (i != 3) {
                u = 0.0f;
            } else {
                float n2 = (f7 == Legend.LegendOrientation.VERTICAL ? this.o.n() / 2.0f : this.o.f() + (this.o.i() / 2.0f)) + (h == Legend.LegendDirection.LEFT_TO_RIGHT ? u : -u);
                if (f7 == Legend.LegendOrientation.VERTICAL) {
                    u = (float) (n2 + (h == Legend.LegendDirection.LEFT_TO_RIGHT ? ((-this.f22182c.f22089a) / 2.0d) + u : (this.f22182c.f22089a / 2.0d) - u));
                } else {
                    u = n2;
                }
            }
            int i2 = AnonymousClass1.f22184c[f7.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                int i3 = AnonymousClass1.b[e2.ordinal()];
                if (i3 == 1) {
                    e = (d == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.o.e()) + v;
                } else if (i3 != 2) {
                    e = i3 != 3 ? 0.0f : ((this.o.m() / 2.0f) - (this.f22182c.b / 2.0f)) + this.f22182c.v();
                } else {
                    e = (d == Legend.LegendHorizontalAlignment.CENTER ? this.o.m() : this.o.h()) - (this.f22182c.b + v);
                }
                float f8 = e;
                boolean z = false;
                int i4 = 0;
                float f9 = 0.0f;
                float f10 = a7;
                float f11 = f8;
                while (i4 < a3.length) {
                    LegendEntry legendEntry = a3[i4];
                    boolean z2 = legendEntry.b != Legend.LegendForm.NONE;
                    float a8 = Float.isNaN(legendEntry.f22103c) ? a6 : Utils.a(legendEntry.f22103c);
                    if (z2) {
                        float f12 = h == Legend.LegendDirection.LEFT_TO_RIGHT ? u + f9 : u - (a8 - f9);
                        a(canvas, f12, f11 + b2, legendEntry, this.f22182c);
                        f4 = f12;
                        if (h == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            f4 = f12 + a8;
                        }
                    } else {
                        f4 = u;
                    }
                    float f13 = f10;
                    if (legendEntry.f22102a != null) {
                        if (!z2 || z) {
                            f6 = f4;
                            if (z) {
                                f6 = u;
                            }
                        } else {
                            f6 = f4 + (h == Legend.LegendDirection.LEFT_TO_RIGHT ? a4 : -a4);
                        }
                        float f14 = f6;
                        if (h == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f14 = f6 - Utils.a(this.f22181a, legendEntry.f22102a);
                        }
                        if (z) {
                            f11 += a2 + b;
                            a(canvas, f14, f11 + a2, legendEntry.f22102a);
                        } else {
                            a(canvas, f14, f11 + a2, legendEntry.f22102a);
                        }
                        f11 += a2 + b;
                        f5 = 0.0f;
                    } else {
                        f5 = f9 + a8 + f13;
                        z = true;
                    }
                    i4++;
                    f10 = f13;
                    f9 = f5;
                }
                return;
            }
            List<FSize> t = this.f22182c.t();
            List<FSize> r = this.f22182c.r();
            List<Boolean> s = this.f22182c.s();
            int i5 = AnonymousClass1.b[e2.ordinal()];
            float f15 = v;
            if (i5 != 1) {
                f15 = i5 != 2 ? i5 != 3 ? 0.0f : v + ((this.o.m() - this.f22182c.b) / 2.0f) : (this.o.m() - v) - this.f22182c.b;
            }
            int length = a3.length;
            float f16 = u;
            int i6 = 0;
            int i7 = 0;
            float f17 = u;
            while (i6 < length) {
                LegendEntry legendEntry2 = a3[i6];
                boolean z3 = legendEntry2.b != Legend.LegendForm.NONE;
                float a9 = Float.isNaN(legendEntry2.f22103c) ? a6 : Utils.a(legendEntry2.f22103c);
                if (i6 >= s.size() || !s.get(i6).booleanValue()) {
                    f = f16;
                } else {
                    f15 += a2 + b;
                    f = f17;
                }
                if (f == f17 && d == Legend.LegendHorizontalAlignment.CENTER && i7 < t.size()) {
                    f += (h == Legend.LegendDirection.RIGHT_TO_LEFT ? t.get(i7).f22200a : -t.get(i7).f22200a) / 2.0f;
                    i7++;
                }
                boolean z4 = legendEntry2.f22102a == null;
                if (z3) {
                    float f18 = f;
                    if (h == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f18 = f - a9;
                    }
                    a(canvas, f18, f15 + b2, legendEntry2, this.f22182c);
                    f = h == Legend.LegendDirection.LEFT_TO_RIGHT ? f18 + a9 : f18;
                }
                if (z4) {
                    float f19 = h == Legend.LegendDirection.RIGHT_TO_LEFT ? -a7 : a7;
                    f2 = f;
                    f3 = f19;
                } else {
                    float f20 = f;
                    if (z3) {
                        f20 = f + (h == Legend.LegendDirection.RIGHT_TO_LEFT ? -a4 : a4);
                    }
                    float f21 = f20;
                    if (h == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f21 = f20 - r.get(i6).f22200a;
                    }
                    a(canvas, f21, f15 + a2, legendEntry2.f22102a);
                    float f22 = f21;
                    if (h == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f22 = f21 + r.get(i6).f22200a;
                    }
                    float f23 = h == Legend.LegendDirection.RIGHT_TO_LEFT ? -a5 : a5;
                    f2 = f22;
                    f3 = f23;
                }
                i6++;
                f16 = f2 + f3;
            }
        }
    }

    protected void a(Canvas canvas, float f, float f2, LegendEntry legendEntry, Legend legend) {
        if (legendEntry.f == 1122868 || legendEntry.f == 1122867 || legendEntry.f == 0) {
            return;
        }
        int save = canvas.save();
        Legend.LegendForm legendForm = legendEntry.b;
        Legend.LegendForm legendForm2 = legendForm;
        if (legendForm == Legend.LegendForm.DEFAULT) {
            legendForm2 = legend.i();
        }
        this.b.setColor(legendEntry.f);
        float a2 = Utils.a(Float.isNaN(legendEntry.f22103c) ? legend.j() : legendEntry.f22103c);
        float f3 = a2 / 2.0f;
        int i = AnonymousClass1.d[legendForm2.ordinal()];
        if (i == 3 || i == 4) {
            this.b.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f + f3, f2, f3, this.b);
        } else if (i == 5) {
            this.b.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, f2 - f3, f + a2, f2 + f3, this.b);
        } else if (i == 6) {
            float a3 = Utils.a(Float.isNaN(legendEntry.d) ? legend.k() : legendEntry.d);
            DashPathEffect l = legendEntry.e == null ? legend.l() : legendEntry.e;
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setStrokeWidth(a3);
            this.b.setPathEffect(l);
            this.f.reset();
            this.f.moveTo(f, f2);
            this.f.lineTo(f + a2, f2);
            canvas.drawPath(this.f, this.b);
        }
        canvas.restoreToCount(save);
    }

    protected void a(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.f22181a);
    }

    /* JADX WARN: Type inference failed for: r0v31, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    /* JADX WARN: Type inference failed for: r0v48, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    public void a(ChartData<?> chartData) {
        ChartData<?> chartData2 = chartData;
        if (!this.f22182c.c()) {
            this.d.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= chartData.d()) {
                    break;
                }
                ?? a2 = chartData2.a(i2);
                List<Integer> j = a2.j();
                int H = a2.H();
                if (a2 instanceof IBarDataSet) {
                    IBarDataSet iBarDataSet = (IBarDataSet) a2;
                    if (iBarDataSet.b()) {
                        String[] g = iBarDataSet.g();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= j.size() || i4 >= iBarDataSet.a()) {
                                break;
                            }
                            this.d.add(new LegendEntry(g[i4 % g.length], a2.u(), a2.v(), a2.w(), a2.x(), j.get(i4).intValue()));
                            i3 = i4 + 1;
                        }
                        if (iBarDataSet.o() != null) {
                            this.d.add(new LegendEntry(a2.o(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867));
                        }
                        i = i2 + 1;
                    }
                }
                if (!(a2 instanceof IPieDataSet)) {
                    if (a2 instanceof ICandleDataSet) {
                        ICandleDataSet iCandleDataSet = (ICandleDataSet) a2;
                        if (iCandleDataSet.f() != 1122867) {
                            int f = iCandleDataSet.f();
                            int e = iCandleDataSet.e();
                            this.d.add(new LegendEntry(null, a2.u(), a2.v(), a2.w(), a2.x(), f));
                            this.d.add(new LegendEntry(a2.o(), a2.u(), a2.v(), a2.w(), a2.x(), e));
                        }
                    }
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= j.size() || i6 >= H) {
                            break;
                        }
                        this.d.add(new LegendEntry((i6 >= j.size() - 1 || i6 >= H - 1) ? chartData.a(i2).o() : null, a2.u(), a2.v(), a2.w(), a2.x(), j.get(i6).intValue()));
                        i5 = i6 + 1;
                    }
                } else {
                    IPieDataSet iPieDataSet = (IPieDataSet) a2;
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= j.size() || i8 >= H) {
                            break;
                        }
                        this.d.add(new LegendEntry(iPieDataSet.e(i8).a(), a2.u(), a2.v(), a2.w(), a2.x(), j.get(i8).intValue()));
                        i7 = i8 + 1;
                    }
                    if (iPieDataSet.o() != null) {
                        this.d.add(new LegendEntry(a2.o(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867));
                    }
                }
                chartData2 = chartData;
                i = i2 + 1;
            }
            if (this.f22182c.b() != null) {
                Collections.addAll(this.d, this.f22182c.b());
            }
            this.f22182c.a(this.d);
        }
        Typeface w = this.f22182c.w();
        if (w != null) {
            this.f22181a.setTypeface(w);
        }
        this.f22181a.setTextSize(this.f22182c.x());
        this.f22181a.setColor(this.f22182c.y());
        this.f22182c.a(this.f22181a, this.o);
    }
}
