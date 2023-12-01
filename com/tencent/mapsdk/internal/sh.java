package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ZoomControls;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.mapsdk.internal.l1;
import com.tencent.mapsdk.internal.p4;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sh.class */
public class sh extends n4 {
    private Context d;
    private ZoomControls e;
    private yi i;
    private boolean k;
    private boolean l;
    private LinearLayout m;
    private ViewGroup n;
    public Bitmap o;
    public Bitmap p;
    public Bitmap q;
    public Bitmap r;
    private rh f = null;
    private p4.b g = p4.b.RIGHT_BOTTOM;
    private l1.d h = null;
    private int j = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sh$a.class */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            sh.this.i.getMap().a((Runnable) null);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sh$b.class */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            sh.this.i.getMap().b((Runnable) null);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sh$c.class */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (sh.this.h != null) {
                sh.this.h.a();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sh$d.class */
    public class d implements Runnable {
        public final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f38010c;

        public d(boolean z, boolean z2) {
            this.b = z;
            this.f38010c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            sh.this.e.setIsZoomInEnabled(this.b);
            sh.this.e.setIsZoomOutEnabled(this.f38010c);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sh$e.class */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38011a;

        static {
            p4.b.values();
            int[] iArr = new int[6];
            f38011a = iArr;
            try {
                p4.b bVar = p4.b.LEFT_BOTTOM;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f38011a;
                p4.b bVar2 = p4.b.CENTER_BOTTOM;
                iArr2[1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f38011a;
                p4.b bVar3 = p4.b.RIGHT_BOTTOM;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f38011a;
                p4.b bVar4 = p4.b.LEFT_TOP;
                iArr4[3] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = f38011a;
                p4.b bVar5 = p4.b.CENTER_TOP;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = f38011a;
                p4.b bVar6 = p4.b.RIGHT_TOP;
                iArr6[5] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public sh(Context context, yi yiVar) {
        this.d = context;
        this.i = yiVar;
    }

    private void a(Context context) {
        this.f = new rh(context);
        Bitmap a2 = b7.a(b7.c(this.d, "location_enable.png"));
        this.f.setScaleType(ImageView.ScaleType.CENTER);
        this.f.setImageBitmap(a2);
        this.f.setOnClickListener(new c());
        g();
    }

    private void b(Context context) {
        try {
            ZoomControls zoomControls = new ZoomControls(context);
            this.e = zoomControls;
            if (Build.VERSION.SDK_INT >= 17) {
                zoomControls.setId(View.generateViewId());
            } else {
                zoomControls.setId(-570425343);
            }
            this.e.setOnZoomInClickListener(new a());
            this.e.setOnZoomOutClickListener(new b());
            h();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c(boolean z) {
        if (this.f == null) {
            return;
        }
        if (z) {
            Bitmap bitmap = this.q;
            if (bitmap == null || bitmap.isRecycled()) {
                this.q = b7.a(b7.c(this.d, "location_state_dark_normal.png"));
            }
            Bitmap bitmap2 = this.r;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.r = b7.a(b7.c(this.d, "location_state_dark_selected.png"));
            }
        } else {
            Bitmap bitmap3 = this.o;
            if (bitmap3 == null || bitmap3.isRecycled()) {
                this.o = b7.a(b7.c(this.d, "location_state_normal.png"));
            }
            Bitmap bitmap4 = this.p;
            if (bitmap4 == null || bitmap4.isRecycled()) {
                this.p = b7.a(b7.c(this.d, "location_state_selected.png"));
            }
        }
        this.f.a(this.d, z ? this.q : this.o, z ? this.r : this.p);
        this.f.setVisibility(this.k ? 0 : 8);
    }

    private FrameLayout.LayoutParams e() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int a2 = z9.a(this.d, 5);
        int ordinal = this.g.ordinal();
        if (ordinal == 0) {
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = a2 * 2;
            layoutParams.leftMargin = a2;
            return layoutParams;
        } else if (ordinal == 1) {
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = a2;
            return layoutParams;
        } else if (ordinal == 2) {
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = a2 * 6;
            layoutParams.rightMargin = a2;
            return layoutParams;
        } else if (ordinal == 3) {
            layoutParams.gravity = 51;
            layoutParams.topMargin = a2;
            layoutParams.leftMargin = a2;
            return layoutParams;
        } else if (ordinal == 4) {
            layoutParams.gravity = 49;
            layoutParams.topMargin = a2;
            return layoutParams;
        } else if (ordinal == 5) {
            layoutParams.gravity = 53;
            layoutParams.topMargin = a2;
            layoutParams.rightMargin = a2;
            return layoutParams;
        } else {
            na.b("Unknown position:" + this.g);
            return layoutParams;
        }
    }

    private void g() {
        yi yiVar;
        if (this.m == null || this.f == null || (yiVar = this.i) == null || yiVar.getMap() == null) {
            return;
        }
        c(this.i.getMapContext().a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.m.indexOfChild(this.f) >= 0) {
            this.m.updateViewLayout(this.f, layoutParams);
            return;
        }
        ZoomControls zoomControls = this.e;
        if (zoomControls == null || this.m.indexOfChild(zoomControls) < 0) {
            this.m.addView(this.f, layoutParams);
            return;
        }
        this.m.removeViewInLayout(this.e);
        this.m.addView(this.f, layoutParams);
        this.m.addView(this.e, layoutParams);
    }

    private void h() {
        if (this.m == null || this.e == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.m.indexOfChild(this.e) < 0) {
            this.m.addView(this.e, layoutParams);
        } else {
            this.m.updateViewLayout(this.e, layoutParams);
        }
    }

    @Override // com.tencent.mapsdk.internal.p4
    public void a() {
        rh rhVar = this.f;
        if (rhVar != null) {
            rhVar.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.i5
    public void a(int i, int i2) {
    }

    public void a(l1.d dVar) {
        this.h = dVar;
    }

    @Override // com.tencent.mapsdk.internal.p4
    public void a(p4.b bVar) {
        if (this.g != bVar) {
            this.g = bVar;
            a(this.n, (Bundle) null);
        }
    }

    public void a(boolean z) {
        this.k = z;
        if (z && this.f == null) {
            a(this.d);
        }
        rh rhVar = this.f;
        if (rhVar != null) {
            rhVar.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z, boolean z2) {
        if (this.e != null) {
            ca.b(new d(z, z2));
        }
    }

    @Override // com.tencent.mapsdk.internal.p4
    public boolean a(ViewGroup viewGroup, Bundle bundle) {
        if (viewGroup == null) {
            return false;
        }
        this.n = viewGroup;
        LinearLayout linearLayout = this.m;
        if (linearLayout == null || linearLayout.getParent() != viewGroup) {
            LinearLayout linearLayout2 = new LinearLayout(this.d);
            this.m = linearLayout2;
            linearLayout2.setOrientation(1);
            viewGroup.addView(this.m);
        }
        FrameLayout.LayoutParams e2 = e();
        this.m.setGravity(e2.gravity);
        this.m.setLayoutParams(e2);
        if (this.l && this.e == null) {
            b(this.d);
        } else {
            h();
        }
        if (this.k && this.f == null) {
            a(this.d);
        } else {
            g();
        }
        int i = -1;
        if (bundle != null) {
            i = bundle.getInt(l1.q, -1);
        }
        c(this.i.getMapContext().d(i));
        this.m.requestLayout();
        return true;
    }

    public void b(boolean z) {
        this.l = z;
        if (z && this.e == null) {
            b(this.d);
        }
        ZoomControls zoomControls = this.e;
        if (zoomControls != null) {
            zoomControls.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.tencent.mapsdk.internal.n4
    public View[] c() {
        return new View[]{this.e, this.f};
    }

    @Override // com.tencent.mapsdk.internal.n4, com.tencent.mapsdk.internal.p4
    public Rect d() {
        Rect rect = new Rect();
        ZoomControls zoomControls = this.e;
        if (zoomControls != null && this.f != null) {
            rect.bottom = Math.min(zoomControls.getBottom(), this.f.getBottom());
            rect.right = Math.max(this.e.getRight(), this.f.getRight());
            rect.left = Math.min(this.e.getLeft(), this.f.getLeft());
            rect.top = Math.min(this.e.getTop(), this.f.getTop());
        }
        return rect;
    }

    public boolean f() {
        ZoomControls zoomControls = this.e;
        boolean z = false;
        if (zoomControls == null) {
            return false;
        }
        if (zoomControls.getVisibility() == 0) {
            z = true;
        }
        return z;
    }

    @Override // com.tencent.mapsdk.internal.p4
    public p4.b getPosition() {
        return this.g;
    }
}
