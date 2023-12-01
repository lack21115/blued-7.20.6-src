package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.internal.da;
import com.tencent.mapsdk.internal.p4;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh.class */
public class qh extends n4 {
    private static final int n0 = 6;
    private static final float o0 = 0.7f;
    private static final float p0 = 1.3f;
    private float[] A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private TextView H;
    private final List<uh> I;
    private final ConcurrentHashMap<String, Bitmap> J;
    private final List<String> K;
    private String L;
    private int M;
    private final float[] N;
    private float O;
    private String P;
    private int Q;
    private int R;
    private float S;
    private int T;
    private double U;
    private l V;
    private boolean W;
    private boolean X;
    private LinearLayout Y;
    private LinearLayout Z;
    private final int a0;
    private final int b0;
    private float c0;
    private Animation d0;
    private List<j> e0;
    private Bitmap f;
    private int f0;
    private Rect g;
    private int g0;
    private boolean h;
    private int h0;
    private volatile boolean i;
    private int i0;
    private w5 j;
    private eg j0;
    private boolean k;
    private da.a k0;
    private Context l;
    private a1 l0;
    private ImageView m;
    private boolean m0;
    private Bitmap n;
    private Bitmap o;
    private ViewGroup s;
    private int[] w;
    private int[] x;
    private float[] y;
    private float[] z;
    private final int d = 500;
    private final int e = 1000;
    private p4.b p = p4.b.RIGHT_BOTTOM;
    private p4.b q = p4.b.LEFT_BOTTOM;
    private boolean r = true;
    private float[] t = {-1.0f, -1.0f, -1.0f, -1.0f};
    private int[] u = {-1, -1, -1, -1};
    private int[] v = {-1, -1, -1, -1};

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$a.class */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (qh.this.k0 == null) {
                qh qhVar = qh.this;
                qhVar.k0 = da.a(qhVar.l);
            }
            na.a(qh.this.l, qh.this.k0);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$b.class */
    public class b implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ yi f37723a;

        public b(yi yiVar) {
            this.f37723a = yiVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return g6.a(this.f37723a.getMapContext());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$c.class */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            qh.this.d(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            qh.this.d(true);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$d.class */
    public class d implements Runnable {
        public final /* synthetic */ boolean b;

        public d(boolean z) {
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (qh.this.V == null) {
                return;
            }
            qh.this.V.a(this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$e.class */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qh.this.H.setText(qh.this.P);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$f.class */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qh.this.l0.b(qh.this.O);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$g.class */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37726a;

        static {
            p4.b.values();
            int[] iArr = new int[6];
            f37726a = iArr;
            try {
                p4.b bVar = p4.b.LEFT_BOTTOM;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f37726a;
                p4.b bVar2 = p4.b.CENTER_BOTTOM;
                iArr2[1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f37726a;
                p4.b bVar3 = p4.b.RIGHT_BOTTOM;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f37726a;
                p4.b bVar4 = p4.b.LEFT_TOP;
                iArr4[3] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = f37726a;
                p4.b bVar5 = p4.b.CENTER_TOP;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = f37726a;
                p4.b bVar6 = p4.b.RIGHT_TOP;
                iArr6[5] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$h.class */
    public static class h extends ca.i<Bitmap> {

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<qh> f37727c;
        private String d;
        private String e;

        public h(qh qhVar, String str, String str2) {
            this.f37727c = new WeakReference<>(qhVar);
            this.d = str;
            this.e = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() throws Exception {
            WeakReference<qh> weakReference = this.f37727c;
            Bitmap bitmap = null;
            if (weakReference != null) {
                qh qhVar = weakReference.get();
                if (qhVar == null) {
                    return null;
                }
                File file = new File(qhVar.c(this.e));
                na.c(ma.v, "Logo[" + this.e + "] request url[" + this.d + "]...");
                na.c(ma.v, "Logo[" + this.e + "] save to[" + file + "]...");
                NetResponse downloadTo = NetManager.getInstance().builder().url(this.d).downloadTo(file);
                bitmap = null;
                if (downloadTo != null) {
                    bitmap = null;
                    if (downloadTo.available()) {
                        byte[] bArr = downloadTo.data;
                        int length = bArr.length;
                        na.c(ma.v, "Logo[" + this.e + "] request url ok! bitmap size[" + length + "]...");
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, length);
                        bitmap = decodeByteArray;
                        if (decodeByteArray != null) {
                            qhVar.J.put(this.e, decodeByteArray);
                            bitmap = decodeByteArray;
                        }
                    }
                }
            }
            return bitmap;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$i.class */
    public static class i extends ca.c<Bitmap> {
        private WeakReference<qh> b;

        /* renamed from: c  reason: collision with root package name */
        private String f37728c;

        public i(qh qhVar, String str) {
            this.b = new WeakReference<>(qhVar);
            this.f37728c = str;
        }

        @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(Bitmap bitmap) {
            WeakReference<qh> weakReference;
            qh qhVar;
            if (bitmap == null || (weakReference = this.b) == null || (qhVar = weakReference.get()) == null) {
                return;
            }
            ga.b(new File(qhVar.c(this.f37728c)), new File(qhVar.b(this.f37728c)));
            if (this.f37728c.equals(qhVar.L)) {
                na.c(ma.v, "Logo[" + this.f37728c + "] set from net");
                qhVar.a(bitmap);
            }
            qhVar.K.remove(this.f37728c);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$j.class */
    public interface j {
        void a(View view, Rect rect, boolean z);

        void a(qh qhVar);

        void b(View view, Rect rect, boolean z);

        void b(qh qhVar);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$k.class */
    public enum k {
        WORLD,
        TENCENT
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$l.class */
    public class l extends View {
        private static final int k = -16777216;
        private static final int l = -7368817;
        private static final int m = 35;
        private Paint g;
        private Paint h;
        private int i;

        public l(Context context) {
            super(context);
            this.i = -16777216;
            Paint paint = new Paint();
            this.g = paint;
            paint.setAntiAlias(true);
            this.g.setStrokeWidth(qh.this.S * 1.0f);
            this.g.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint(65);
            this.h = paint2;
            paint2.setStyle(Paint.Style.FILL);
            this.h.setColor(0);
        }

        private void a(Canvas canvas, int i) {
            int i2 = (int) (qh.this.S * 6.0f);
            int i3 = i / 2;
            canvas.drawPaint(this.h);
            float f = i2;
            float f2 = i3;
            canvas.drawLine(f, f2, qh.this.R + i2, f2, this.g);
            float f3 = i3 + 1;
            canvas.drawLine(f, f2 - (qh.this.S * 3.0f), f, f3, this.g);
            canvas.drawLine(qh.this.R + i2, f2 - (qh.this.S * 3.0f), i2 + qh.this.R, f3, this.g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            int i = z ? l : -16777216;
            if (i != this.i) {
                this.i = i;
                if (qh.this.H != null) {
                    qh.this.H.setTextColor(i);
                }
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            this.g.setColor(this.i);
            a(canvas, getHeight());
        }

        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            setMeasuredDimension(Math.min(Math.round(qh.this.R + (qh.this.S * 12.0f)), qh.this.B / 2), Math.round(qh.this.Q * qh.this.S));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qh$m.class */
    public static class m implements Runnable {
        private WeakReference<qh> b;

        public m(qh qhVar) {
            this.b = new WeakReference<>(qhVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            qh qhVar;
            WeakReference<qh> weakReference = this.b;
            if (weakReference == null || (qhVar = weakReference.get()) == null) {
                return;
            }
            qhVar.a(qhVar.s, (Bundle) null);
        }
    }

    public qh(Context context, yi yiVar, int i2) {
        p4.a.values();
        this.w = new int[4];
        p4.a.values();
        this.x = new int[4];
        this.y = new float[]{0.02f, 0.02f, 0.012f, 0.012f};
        this.z = new float[]{0.022f, 0.022f, 0.0125f, 0.0125f};
        this.A = new float[]{0.0185f, 0.0185f, 0.0104f, 0.0104f};
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.I = new CopyOnWriteArrayList();
        this.J = new ConcurrentHashMap<>();
        this.K = new CopyOnWriteArrayList();
        this.L = null;
        this.M = 0;
        this.N = new float[]{1000000.0f, 500000.0f, 200000.0f, 100000.0f, 50000.0f, 25000.0f, 20000.0f, 10000.0f, 5000.0f, 2000.0f, 1000.0f, 500.0f, 200.0f, 100.0f, 50.0f, 20.0f, 10.0f, 5.0f, 2.0f, 1.0f};
        this.O = 0.0f;
        this.P = "50米";
        this.Q = 11;
        this.R = 109;
        this.S = 1.0f;
        this.W = true;
        this.X = false;
        this.b0 = 18;
        this.c0 = Float.MIN_VALUE;
        this.e0 = new ArrayList();
        this.f0 = -1;
        this.g0 = -1;
        this.h0 = -1;
        this.i0 = -1;
        this.m0 = true;
        this.l = context;
        this.l0 = yiVar;
        this.a0 = i2;
        this.S = context.getResources().getDisplayMetrics().density;
        this.m = new ImageView(context);
        this.V = new l(this.l);
        oc ocVar = new oc(this.l, yiVar.getMapContext());
        this.H = ocVar;
        ocVar.setText(this.P);
        this.H.setContentDescription(AccessibleTouchItem.MAP_DEFAULT_CONTENT_DESCRIPTION);
        this.H.setTextSize(12.0f);
        this.H.setTextColor(-16777216);
        this.H.setGravity(1);
        if (this.S <= 0.0f) {
            this.S = 1.0f;
        }
        LinearLayout linearLayout = new LinearLayout(this.l);
        this.Y = linearLayout;
        linearLayout.setOrientation(1);
        this.Y.setGravity(16);
        this.Y.setOnClickListener(new a());
        this.Y.setOnLongClickListener(new b(yiVar));
        LinearLayout linearLayout2 = new LinearLayout(this.l);
        this.Z = linearLayout2;
        linearLayout2.setOrientation(1);
        this.Z.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        this.Z.addView(this.H, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 3;
        this.Z.addView(this.V, layoutParams2);
        this.Z.setVisibility(8);
        k();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 3;
        this.Y.addView(this.m, layoutParams3);
        vh u = yiVar.u();
        if (u != null) {
            a(u.h());
        }
    }

    private Bitmap a(String str) {
        FileInputStream fileInputStream;
        try {
            File file = new File(b(str));
            if (!file.exists()) {
                ha.a((Closeable) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                ha.a((Closeable) fileInputStream);
                return decodeStream;
            } catch (Throwable th) {
                ha.a((Closeable) fileInputStream);
                return null;
            }
        } catch (Throwable th2) {
            fileInputStream = null;
        }
    }

    private void a(float f2) {
        if (this.O != f2) {
            this.O = f2;
            ca.b(new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        try {
            this.n = bitmap;
            if (bitmap != null) {
                this.D = bitmap.getWidth();
                this.E = this.n.getHeight();
                this.i = true;
            }
            p();
            r();
        } catch (Exception e2) {
        }
    }

    private void a(String str, String str2) {
        if (this.K.contains(str2)) {
            na.c(ma.v, "Logo[" + str2 + "] is downloading.");
            return;
        }
        this.K.add(str2);
        na.c(ma.v, "Logo[" + str2 + "] start download..");
        ca.a((ca.i) new h(this, str, str2)).a((ca.d.b) null, (ca.c<ca.d.b>) new i(this, str2));
    }

    private FrameLayout.LayoutParams b(int i2, int i3) {
        eg egVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (i2 != 0) {
            if (i3 == 0) {
                return layoutParams;
            }
            int ordinal = this.p.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    layoutParams.gravity = 81;
                    int i4 = this.w[p4.a.BOTTOM.b];
                    layoutParams.bottomMargin = i4;
                    this.g0 = (this.C - i4) - i3;
                    this.f0 = (this.B - i2) / 2;
                    return layoutParams;
                } else if (ordinal == 2) {
                    layoutParams.gravity = 85;
                    int[] iArr = this.w;
                    layoutParams.bottomMargin = iArr[p4.a.BOTTOM.b];
                    layoutParams.rightMargin = iArr[p4.a.RIGHT.b];
                    if (mi.f37650c.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE) && (egVar = this.j0) != null) {
                        egVar.a(layoutParams.bottomMargin + (i3 * 2));
                    }
                    this.g0 = (this.C - layoutParams.bottomMargin) - i3;
                    this.f0 = (this.B - layoutParams.rightMargin) - i2;
                    return layoutParams;
                } else if (ordinal == 3) {
                    layoutParams.gravity = 51;
                    int[] iArr2 = this.w;
                    int i5 = iArr2[p4.a.TOP.b];
                    layoutParams.topMargin = i5;
                    int i6 = iArr2[p4.a.LEFT.b];
                    layoutParams.leftMargin = i6;
                    this.g0 = i5;
                    this.f0 = i6;
                    return layoutParams;
                } else if (ordinal == 4) {
                    layoutParams.gravity = 49;
                    int i7 = this.w[p4.a.TOP.b];
                    layoutParams.topMargin = i7;
                    this.g0 = i7;
                    this.f0 = (this.B - i2) / 2;
                    return layoutParams;
                } else if (ordinal != 5) {
                    na.b("Unknown position:" + this.p);
                    return layoutParams;
                } else {
                    layoutParams.gravity = 53;
                    int[] iArr3 = this.w;
                    int i8 = iArr3[p4.a.TOP.b];
                    layoutParams.topMargin = i8;
                    int i9 = iArr3[p4.a.RIGHT.b];
                    layoutParams.rightMargin = i9;
                    this.g0 = i8;
                    this.f0 = (this.B - i9) - i2;
                    return layoutParams;
                }
            }
            layoutParams.gravity = 83;
            int[] iArr4 = this.w;
            int i10 = iArr4[p4.a.BOTTOM.b];
            layoutParams.bottomMargin = i10;
            int i11 = iArr4[p4.a.LEFT.b];
            layoutParams.leftMargin = i11;
            this.g0 = (this.C - i10) - i3;
            this.f0 = i11;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        String g2 = g();
        ha.b(g2);
        return g2 + BridgeUtil.SPLIT_MARK + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        return b(str) + ".tmp";
    }

    private int[] c(int i2, int i3) {
        float f2 = this.c0;
        if (f2 == Float.MIN_VALUE) {
            int i4 = this.M;
            f2 = i4 != -3 ? i4 != -2 ? i4 != -1 ? i4 != 1 ? 1.0f : 1.2f : 0.8333333f : 0.8f : 0.7f;
        }
        return new int[]{(int) (i2 * f2), (int) (i3 * f2)};
    }

    private void d(int i2, int i3) {
        String str;
        float f2;
        float[] fArr = this.N;
        int length = fArr.length;
        int i4 = this.T - this.a0;
        int i5 = i4;
        if (i4 < 0) {
            i5 = 0;
        }
        int i6 = i5;
        if (i5 >= length) {
            i6 = length - 1;
        }
        float f3 = fArr[i6];
        a(f3);
        float f4 = i2;
        double d2 = this.U;
        if (d2 != 0.0d) {
            f4 = (float) (f3 / d2);
        }
        int round = Math.round(f4);
        this.R = round;
        if (round > i3) {
            this.R = i3;
        } else if (round < i2) {
            this.R = i2;
        }
        if (f3 >= 1000.0f) {
            f2 = f3 / 1000.0f;
            str = "公里";
        } else {
            str = "米";
            f2 = f3;
        }
        this.P = ((int) f2) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        LinearLayout linearLayout = this.Z;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
            this.Z.requestLayout();
            this.Z.invalidate();
        }
        l lVar = this.V;
        if (lVar != null) {
            lVar.invalidate();
        }
    }

    private String g() {
        return this.l.getFilesDir().getAbsolutePath() + "/tencentMapSdk/logos";
    }

    private String h() {
        return this.l.getFilesDir().getAbsolutePath() + "/tencentMapSdk/oldLogos";
    }

    private FrameLayout.LayoutParams j() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout = this.Z;
        if (linearLayout == null) {
            return layoutParams;
        }
        int measuredWidth = linearLayout.getMeasuredWidth();
        int measuredHeight = this.Z.getMeasuredHeight();
        int ordinal = this.q.ordinal();
        if (ordinal == 0) {
            layoutParams.gravity = 83;
            int[] iArr = this.x;
            int i2 = iArr[p4.a.BOTTOM.b];
            layoutParams.bottomMargin = i2;
            int i3 = iArr[p4.a.LEFT.b];
            layoutParams.leftMargin = i3;
            this.i0 = (this.C - i2) - measuredHeight;
            this.h0 = i3;
            return layoutParams;
        } else if (ordinal == 1) {
            layoutParams.gravity = 81;
            int i4 = this.x[p4.a.BOTTOM.b];
            layoutParams.bottomMargin = i4;
            this.i0 = (this.C - i4) - measuredHeight;
            this.h0 = (this.B - measuredWidth) / 2;
            return layoutParams;
        } else if (ordinal == 2) {
            layoutParams.gravity = 85;
            int[] iArr2 = this.x;
            int i5 = iArr2[p4.a.BOTTOM.b];
            layoutParams.bottomMargin = i5;
            int i6 = iArr2[p4.a.RIGHT.b];
            layoutParams.rightMargin = i6;
            this.i0 = (this.C - i5) - measuredHeight;
            this.h0 = (this.B - i6) - measuredWidth;
            return layoutParams;
        } else if (ordinal == 3) {
            layoutParams.gravity = 51;
            int[] iArr3 = this.x;
            int i7 = iArr3[p4.a.TOP.b];
            layoutParams.topMargin = i7;
            int i8 = iArr3[p4.a.LEFT.b];
            layoutParams.leftMargin = i8;
            this.i0 = i7;
            this.h0 = i8;
            return layoutParams;
        } else if (ordinal == 4) {
            layoutParams.gravity = 49;
            int i9 = this.x[p4.a.TOP.b];
            layoutParams.topMargin = i9;
            this.i0 = i9;
            this.h0 = (this.B - measuredWidth) / 2;
            return layoutParams;
        } else if (ordinal != 5) {
            na.b("Unknown positionScale:" + this.q);
            return layoutParams;
        } else {
            layoutParams.gravity = 53;
            int[] iArr4 = this.x;
            int i10 = iArr4[p4.a.TOP.b];
            layoutParams.topMargin = i10;
            int i11 = iArr4[p4.a.RIGHT.b];
            layoutParams.rightMargin = i11;
            this.i0 = i10;
            this.h0 = (this.B - i11) - measuredWidth;
            return layoutParams;
        }
    }

    private void k() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.d0 = alphaAnimation;
        alphaAnimation.setDuration(1000L);
        this.d0.setStartOffset(500L);
        this.d0.setAnimationListener(new c());
    }

    private void o() {
        this.J.clear();
    }

    private void p() {
        if (this.B == 0 || this.C == 0) {
            return;
        }
        float f2 = this.D;
        float f3 = this.S;
        int i2 = (int) ((f2 * f3) / 3.0f);
        int i3 = (int) ((this.E * f3) / 3.0f);
        int[] c2 = c(i2, i3);
        if (this.F != c2[0] || this.G != c2[1]) {
            this.F = c2[0];
            this.G = c2[1];
            this.i = true;
        }
        float[] fArr = this.y;
        int i4 = this.B;
        if (i4 >= 1080) {
            fArr = this.A;
        } else if (i4 >= 720) {
            fArr = this.z;
        }
        int i5 = p4.a.LEFT.b;
        float f4 = fArr[i5];
        float[] fArr2 = this.t;
        if (fArr2[i5] >= 0.0f) {
            f4 = fArr2[i5];
        }
        int[] iArr = this.w;
        float f5 = i4;
        iArr[i5] = (int) (f4 * f5);
        if (this.m0) {
            this.v[p4.a.BOTTOM.b] = i3;
        }
        int[] iArr2 = this.u;
        if (iArr2[i5] >= 0 && iArr2[i5] < i4 - i2) {
            iArr[i5] = iArr2[i5];
        }
        int i6 = p4.a.RIGHT.b;
        float f6 = fArr[i6];
        if (fArr2[i6] >= 0.0f) {
            f6 = fArr2[i6];
        }
        iArr[i6] = (int) (f5 * f6);
        if (iArr2[i6] >= 0 && iArr2[i6] < i4 - i2) {
            iArr[i6] = iArr2[i6];
        }
        int i7 = p4.a.BOTTOM.b;
        float f7 = fArr[i7];
        if (fArr2[i7] >= 0.0f) {
            f7 = fArr2[i7];
        }
        int i8 = this.C;
        float f8 = i8;
        iArr[i7] = (int) (f7 * f8);
        if (iArr2[i7] >= 0 && iArr2[i7] < i8 - i3) {
            iArr[i7] = iArr2[i7];
        }
        int i9 = p4.a.TOP.b;
        float f9 = fArr[i9];
        if (fArr2[i9] >= 0.0f) {
            f9 = fArr2[i9];
        }
        iArr[i9] = (int) (f8 * f9);
        if (iArr2[i9] >= 0 && iArr2[i9] < i8 - i3) {
            iArr[i9] = iArr2[i9];
        }
        y();
    }

    private void r() {
        if (this.B == 0 || this.C == 0) {
            return;
        }
        int measuredHeight = this.Z.getMeasuredHeight();
        int measuredWidth = this.Z.getMeasuredWidth();
        float[] fArr = this.y;
        int i2 = this.B;
        if (i2 >= 1080) {
            fArr = this.A;
        } else if (i2 >= 720) {
            fArr = this.z;
        }
        int i3 = p4.a.LEFT.b;
        float f2 = fArr[i3];
        float[] fArr2 = this.t;
        if (fArr2[i3] >= 0.0f) {
            f2 = fArr2[i3];
        }
        int[] iArr = this.x;
        float f3 = i2;
        iArr[i3] = (int) (f2 * f3);
        int[] iArr2 = this.v;
        if (iArr2[i3] >= 0 && iArr2[i3] < i2 - measuredWidth) {
            iArr[i3] = iArr2[i3];
        }
        int i4 = p4.a.RIGHT.b;
        float f4 = fArr[i4];
        if (fArr2[i4] >= 0.0f) {
            f4 = fArr2[i4];
        }
        iArr[i4] = (int) (f3 * f4);
        if (iArr2[i4] >= 0 && iArr2[i4] < i2 - measuredWidth) {
            iArr[i4] = iArr2[i4];
        }
        int i5 = p4.a.BOTTOM.b;
        float f5 = fArr[i5];
        if (fArr2[i5] >= 0.0f) {
            f5 = fArr2[i5];
        }
        int i6 = this.C;
        float f6 = i6;
        iArr[i5] = (int) (f5 * f6);
        if (iArr2[i5] >= 0 && iArr2[i5] < i6 - measuredHeight) {
            iArr[i5] = iArr2[i5];
        }
        int i7 = p4.a.TOP.b;
        float f7 = fArr[i7];
        if (fArr2[i7] >= 0.0f) {
            f7 = fArr2[i7];
        }
        iArr[i7] = (int) (f6 * f7);
        if (iArr2[i7] >= 0 && iArr2[i7] < i6 - measuredHeight) {
            iArr[i7] = iArr2[i7];
        }
        y();
    }

    private void t() {
        int width = this.m.getWidth();
        int i2 = width;
        if (width <= 0) {
            i2 = 1000;
        }
        d((int) Math.ceil(i2 / 4.0f), (int) (Math.ceil((this.B * 3.0f) / 8.0f) - (this.S * 6.0f)));
        ca.b(new e());
    }

    private void v() {
        w();
        this.Z.startAnimation(this.d0);
    }

    private void w() {
        LinearLayout linearLayout = this.Z;
        if (linearLayout == null || this.d0 == null) {
            return;
        }
        linearLayout.clearAnimation();
        this.d0.reset();
    }

    private void x() {
        if (!this.W) {
            d(false);
        } else if (this.X) {
            d(true);
            w();
        } else {
            d(true);
            v();
        }
    }

    private void y() {
        ca.b(new m(this));
    }

    public int a(p4.a aVar) {
        return this.u[aVar.b];
    }

    @Override // com.tencent.mapsdk.internal.p4
    public void a() {
        Iterator<Map.Entry<String, Bitmap>> it = this.J.entrySet().iterator();
        while (it.hasNext()) {
            ha.a(it.next().getValue());
        }
        ha.a(this.n);
        ha.a(this.o);
    }

    @Deprecated
    public void a(int i2) {
        this.M = i2;
        this.c0 = Float.MIN_VALUE;
        q();
    }

    public void a(int i2, double d2) {
        this.T = i2;
        this.U = d2;
        t();
        y();
    }

    @Override // com.tencent.mapsdk.internal.i5
    public void a(int i2, int i3) {
        this.B = i2;
        this.C = i3;
        p();
        r();
    }

    public void a(eg egVar) {
        this.j0 = egVar;
    }

    public void a(p4.a aVar, float f2) {
        float f3 = f2;
        if (f2 < 0.0f) {
            f3 = 0.0f;
        }
        float f4 = f3;
        if (f3 > 1.0f) {
            f4 = 1.0f;
        }
        this.t[aVar.b] = f4;
        p();
    }

    public void a(p4.a aVar, int i2) {
        this.u[aVar.b] = i2;
    }

    @Override // com.tencent.mapsdk.internal.p4
    public void a(p4.b bVar) {
        if (this.p != bVar) {
            y();
        }
        this.p = bVar;
    }

    public void a(j jVar) {
        List<j> list = this.e0;
        if (list == null || jVar == null) {
            return;
        }
        list.add(jVar);
    }

    public void a(w5 w5Var, boolean z) {
        uh uhVar;
        if (this.n == null || w5Var.a(this.j) || this.k != z) {
            this.j = w5Var.clone();
            this.k = z;
            int d2 = (int) w5Var.d();
            int i2 = d2;
            if (d2 > 18) {
                i2 = 18;
            }
            Iterator<uh> it = this.I.iterator();
            uh uhVar2 = null;
            while (true) {
                uhVar = uhVar2;
                if (!it.hasNext()) {
                    break;
                }
                uhVar = it.next();
                if (i2 >= uhVar.b() && i2 <= uhVar.a()) {
                    Object[] a2 = uhVar.a(w5Var, z);
                    if (a2 != null) {
                        String str = (String) a2[0];
                        String str2 = (String) a2[1];
                        Bitmap bitmap = (Bitmap) a2[2];
                        if (bitmap != null) {
                            a(bitmap);
                            this.L = str;
                            break;
                        } else if (!f7.c(str, this.L)) {
                            na.c(ma.v, "Logo[" + str + "] changed! old=" + this.L + "|dark=" + z + "|level=" + i2);
                            Bitmap bitmap2 = this.J.get(str);
                            if (bitmap2 != null) {
                                if (!bitmap2.isRecycled()) {
                                    a(bitmap2);
                                    this.L = str;
                                    na.c(ma.v, "Logo[" + str + "] set from mem cache");
                                    return;
                                }
                                this.J.remove(str);
                            }
                            Bitmap a3 = a(str);
                            if (a3 != null) {
                                this.L = str;
                                this.J.put(str, a3);
                                a(a3);
                                na.c(ma.v, "Logo[" + str + "] set from file cache");
                                return;
                            }
                            this.L = null;
                            a(str2, str);
                        }
                    }
                    uhVar2 = uhVar;
                }
            }
            if (uhVar == null) {
                Bitmap bitmap3 = this.f;
                if (bitmap3 == null || bitmap3.isRecycled()) {
                    this.f = b7.c(this.l, "default_tencent_map_logo.png");
                }
                Bitmap bitmap4 = this.f;
                if (bitmap4 != null) {
                    a(bitmap4);
                }
            }
        }
    }

    public void a(List<zh> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.I.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return;
            }
            zh zhVar = list.get(i3);
            int[] a2 = zhVar.a();
            this.I.add(new uh(a2[0], a2[1], zhVar.b()));
            i2 = i3 + 1;
        }
    }

    public void a(boolean z) {
        this.r = z;
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.tencent.mapsdk.internal.p4
    public boolean a(ViewGroup viewGroup, Bundle bundle) {
        if (viewGroup == null) {
            return false;
        }
        this.s = viewGroup;
        if (this.i) {
            ha.a(this.o);
            Bitmap a2 = b7.a(this.n, this.l, this.F, this.G);
            this.o = a2;
            this.m.setImageBitmap(a2);
        }
        FrameLayout.LayoutParams b2 = b(this.F, this.G);
        if (viewGroup.indexOfChild(this.Y) < 0) {
            viewGroup.addView(this.Y, b2);
        } else {
            viewGroup.updateViewLayout(this.Y, b2);
        }
        FrameLayout.LayoutParams j2 = j();
        if (viewGroup.indexOfChild(this.Z) < 0) {
            viewGroup.addView(this.Z, j2);
        } else {
            viewGroup.updateViewLayout(this.Z, j2);
        }
        TextView textView = this.H;
        if (textView != null && this.V != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int width = this.H.getWidth();
            int i2 = width;
            if (width == 0) {
                i2 = (int) this.H.getPaint().measureText(this.H.getText().toString());
            }
            layoutParams.leftMargin = (int) ((this.S * 6.0f) + ((this.R - i2) / 2));
            this.Z.updateViewLayout(this.H, layoutParams);
            LinearLayout linearLayout = this.Z;
            l lVar = this.V;
            linearLayout.updateViewLayout(lVar, lVar.getLayoutParams());
            x();
        }
        this.m.setVisibility(this.r ? 0 : 4);
        if (this.e0 != null) {
            this.Y.requestLayout();
            this.Z.requestLayout();
            for (j jVar : this.e0) {
                if (this.g != null && !this.i && this.h == this.r) {
                    Rect rect = this.g;
                    int i3 = rect.left;
                    int i4 = this.f0;
                    if (i3 == i4 && rect.right == this.g0 && rect.top == i4 + this.Y.getMeasuredWidth() && this.g.bottom == this.g0 + this.Y.getMeasuredHeight()) {
                        jVar.a(this.Z, new Rect(this.h0, this.i0, 0, 0), this.W);
                    }
                }
                this.h = this.r;
                int i5 = this.f0;
                Rect rect2 = new Rect(i5, this.g0, this.Y.getMeasuredWidth() + i5, this.g0 + this.Y.getMeasuredHeight());
                this.g = rect2;
                jVar.b(this.Y, rect2, this.r);
                jVar.a(this.Z, new Rect(this.h0, this.i0, 0, 0), this.W);
            }
        }
        this.i = false;
        viewGroup.requestLayout();
        return true;
    }

    public float b(p4.a aVar) {
        return this.t[aVar.b];
    }

    public void b(float f2) {
        float f3 = f2;
        if (f2 > 1.3f) {
            f3 = 1.3f;
        }
        float f4 = f3;
        if (f3 < 0.7f) {
            f4 = 0.7f;
        }
        this.M = 0;
        this.c0 = f4;
        q();
    }

    public void b(p4.a aVar, int i2) {
        if (this.m0) {
            this.m0 = false;
        }
        this.v[aVar.b] = i2;
        r();
    }

    public void b(p4.b bVar) {
        if (this.q != bVar) {
            y();
        }
        this.q = bVar;
    }

    public void b(boolean z) {
        if (this.W != z) {
            this.W = z;
            List<j> list = this.e0;
            if (list != null) {
                for (j jVar : list) {
                    jVar.a(this.Z, new Rect(this.h0, this.i0, 0, 0), this.W);
                }
            }
        }
        x();
    }

    public int c(p4.a aVar) {
        return this.v[aVar.b];
    }

    public void c(boolean z) {
        this.X = !z;
        x();
    }

    @Override // com.tencent.mapsdk.internal.n4
    public View[] c() {
        return new View[]{this.Y, this.Z};
    }

    public int d(p4.a aVar) {
        return this.w[aVar.b];
    }

    @Override // com.tencent.mapsdk.internal.n4, com.tencent.mapsdk.internal.p4
    public Rect d() {
        Rect rect = new Rect();
        LinearLayout linearLayout = this.Y;
        if (linearLayout != null) {
            rect.left = linearLayout.getLeft();
            rect.bottom = this.Y.getBottom();
            rect.right = this.Y.getRight();
            rect.top = this.Y.getTop();
        }
        return rect;
    }

    public void e() {
        na.c(ma.v, "clearLogoCache..");
        o();
        this.K.clear();
        try {
            File file = new File(g());
            if (file.exists()) {
                File file2 = new File(h());
                if (file.renameTo(file2)) {
                    ha.a(file2.getAbsolutePath());
                } else {
                    ha.a(file.getAbsolutePath());
                }
            }
        } catch (Throwable th) {
        }
    }

    public void e(boolean z) {
        ca.b(new d(z));
    }

    public Bitmap f() {
        Drawable drawable;
        ImageView imageView = this.m;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    @Override // com.tencent.mapsdk.internal.p4
    public p4.b getPosition() {
        return this.p;
    }

    public p4.b i() {
        return this.q;
    }

    public boolean l() {
        return this.W;
    }

    public void m() {
        List<j> list = this.e0;
        if (list != null) {
            for (j jVar : list) {
                jVar.a(this);
            }
        }
    }

    public void n() {
        List<j> list = this.e0;
        if (list != null) {
            for (j jVar : list) {
                jVar.b(this);
            }
        }
    }

    public void q() {
        p();
    }

    public void s() {
        r();
    }

    public boolean u() {
        boolean z = true;
        if (f7.b(this.L)) {
            return true;
        }
        if (!this.L.contains("tencent")) {
            if (this.L.contains(th.k)) {
                return true;
            }
            z = false;
        }
        return z;
    }
}
