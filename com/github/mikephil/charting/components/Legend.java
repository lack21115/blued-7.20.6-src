package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/Legend.class */
public class Legend extends ComponentBase {
    private LegendEntry[] f;
    private LegendEntry[] e = new LegendEntry[0];
    private boolean g = false;
    private LegendHorizontalAlignment h = LegendHorizontalAlignment.LEFT;
    private LegendVerticalAlignment i = LegendVerticalAlignment.BOTTOM;
    private LegendOrientation j = LegendOrientation.HORIZONTAL;
    private boolean k = false;
    private LegendDirection l = LegendDirection.LEFT_TO_RIGHT;
    private LegendForm m = LegendForm.SQUARE;
    private float n = 8.0f;
    private float o = 3.0f;
    private DashPathEffect p = null;
    private float q = 6.0f;
    private float r = 0.0f;
    private float s = 5.0f;
    private float t = 3.0f;
    private float u = 0.95f;

    /* renamed from: a  reason: collision with root package name */
    public float f8482a = 0.0f;
    public float b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f8483c = 0.0f;
    public float d = 0.0f;
    private boolean v = false;
    private List<FSize> C = new ArrayList(16);
    private List<Boolean> D = new ArrayList(16);
    private List<FSize> E = new ArrayList(16);

    /* renamed from: com.github.mikephil.charting.components.Legend$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/Legend$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8484a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[LegendOrientation.values().length];
            f8484a = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8484a[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/Legend$LegendDirection.class */
    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/Legend$LegendForm.class */
    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/Legend$LegendHorizontalAlignment.class */
    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/Legend$LegendOrientation.class */
    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/Legend$LegendVerticalAlignment.class */
    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.A = Utils.a(10.0f);
        this.x = Utils.a(5.0f);
        this.y = Utils.a(3.0f);
    }

    public float a(Paint paint) {
        float f;
        float a2 = Utils.a(this.s);
        LegendEntry[] legendEntryArr = this.e;
        int length = legendEntryArr.length;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = 0;
        while (i < length) {
            LegendEntry legendEntry = legendEntryArr[i];
            float a3 = Utils.a(Float.isNaN(legendEntry.f8496c) ? this.n : legendEntry.f8496c);
            float f4 = f3;
            if (a3 > f3) {
                f4 = a3;
            }
            String str = legendEntry.f8495a;
            if (str == null) {
                f = f2;
            } else {
                float a4 = Utils.a(paint, str);
                f = f2;
                if (a4 > f2) {
                    f = a4;
                }
            }
            i++;
            f2 = f;
            f3 = f4;
        }
        return f2 + f3 + a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x01a4, code lost:
        if (r23 == (r0 - 1)) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0389  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.graphics.Paint r6, com.github.mikephil.charting.utils.ViewPortHandler r7) {
        /*
            Method dump skipped, instructions count: 1017
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.a(android.graphics.Paint, com.github.mikephil.charting.utils.ViewPortHandler):void");
    }

    public void a(List<LegendEntry> list) {
        this.e = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public LegendEntry[] a() {
        return this.e;
    }

    public float b(Paint paint) {
        float f;
        LegendEntry[] legendEntryArr = this.e;
        int length = legendEntryArr.length;
        float f2 = 0.0f;
        int i = 0;
        while (i < length) {
            String str = legendEntryArr[i].f8495a;
            if (str == null) {
                f = f2;
            } else {
                float b = Utils.b(paint, str);
                f = f2;
                if (b > f2) {
                    f = b;
                }
            }
            i++;
            f2 = f;
        }
        return f2;
    }

    public LegendEntry[] b() {
        return this.f;
    }

    public boolean c() {
        return this.g;
    }

    public LegendHorizontalAlignment d() {
        return this.h;
    }

    public LegendVerticalAlignment e() {
        return this.i;
    }

    public LegendOrientation f() {
        return this.j;
    }

    public boolean g() {
        return this.k;
    }

    public LegendDirection h() {
        return this.l;
    }

    public LegendForm i() {
        return this.m;
    }

    public float j() {
        return this.n;
    }

    public float k() {
        return this.o;
    }

    public DashPathEffect l() {
        return this.p;
    }

    public float m() {
        return this.q;
    }

    public float n() {
        return this.r;
    }

    public float o() {
        return this.s;
    }

    public float p() {
        return this.t;
    }

    public float q() {
        return this.u;
    }

    public List<FSize> r() {
        return this.C;
    }

    public List<Boolean> s() {
        return this.D;
    }

    public List<FSize> t() {
        return this.E;
    }
}
