package com.opos.exoplayer.a;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.f.j;
import com.opos.exoplayer.core.g.g;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.ApicFrame;
import com.opos.exoplayer.core.q;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/a/c.class */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f11305a;
    private final com.opos.exoplayer.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private View f11306c;
    private final a d;
    private final View e;
    private final ImageView f;
    private final d g;
    private final b h;
    private final FrameLayout i;
    private q j;
    private boolean k;
    private boolean l;
    private Bitmap m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/a/c$a.class */
    final class a extends q.a implements View.OnLayoutChangeListener, j, com.opos.exoplayer.core.video.e {
        private a() {
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a() {
            if (c.this.e != null) {
                c.this.e.setVisibility(4);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
            if (r6 == 270) goto L23;
         */
        @Override // com.opos.exoplayer.core.video.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r4, int r5, int r6, float r7) {
            /*
                r3 = this;
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                com.opos.exoplayer.a.a r0 = com.opos.exoplayer.a.c.b(r0)
                if (r0 != 0) goto Lb
                return
            Lb:
                r0 = r5
                if (r0 == 0) goto L23
                r0 = r4
                if (r0 != 0) goto L16
                goto L23
            L16:
                r0 = r4
                float r0 = (float) r0
                r1 = r7
                float r0 = r0 * r1
                r1 = r5
                float r1 = (float) r1
                float r0 = r0 / r1
                r7 = r0
                goto L26
            L23:
                r0 = 1065353216(0x3f800000, float:1.0)
                r7 = r0
            L26:
                r0 = r7
                r8 = r0
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                android.view.View r0 = com.opos.exoplayer.a.c.c(r0)
                boolean r0 = r0 instanceof android.view.TextureView
                if (r0 == 0) goto L95
                r0 = r6
                r1 = 90
                if (r0 == r1) goto L48
                r0 = r7
                r8 = r0
                r0 = r6
                r1 = 270(0x10e, float:3.78E-43)
                if (r0 != r1) goto L4e
            L48:
                r0 = 1065353216(0x3f800000, float:1.0)
                r1 = r7
                float r0 = r0 / r1
                r8 = r0
            L4e:
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                int r0 = com.opos.exoplayer.a.c.d(r0)
                if (r0 == 0) goto L63
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                android.view.View r0 = com.opos.exoplayer.a.c.c(r0)
                r1 = r3
                r0.removeOnLayoutChangeListener(r1)
            L63:
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                r1 = r6
                int r0 = com.opos.exoplayer.a.c.a(r0, r1)
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                int r0 = com.opos.exoplayer.a.c.d(r0)
                if (r0 == 0) goto L81
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                android.view.View r0 = com.opos.exoplayer.a.c.c(r0)
                r1 = r3
                r0.addOnLayoutChangeListener(r1)
            L81:
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                android.view.View r0 = com.opos.exoplayer.a.c.c(r0)
                android.view.TextureView r0 = (android.view.TextureView) r0
                r1 = r3
                com.opos.exoplayer.a.c r1 = com.opos.exoplayer.a.c.this
                int r1 = com.opos.exoplayer.a.c.d(r1)
                com.opos.exoplayer.a.c.a(r0, r1)
            L95:
                r0 = r3
                com.opos.exoplayer.a.c r0 = com.opos.exoplayer.a.c.this
                com.opos.exoplayer.a.a r0 = com.opos.exoplayer.a.c.b(r0)
                r1 = r8
                r0.a(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.c.a.a(int, int, int, float):void");
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(m mVar, g gVar) {
            c.this.e();
        }

        @Override // com.opos.exoplayer.core.f.j
        public void a(List<com.opos.exoplayer.core.f.b> list) {
            if (c.this.g != null) {
                c.this.g.a(list);
            }
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(boolean z, int i) {
            if (c.this.d() && c.this.p) {
                c.this.a();
            } else {
                c.this.b(false);
            }
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void b(int i) {
            if (c.this.d() && c.this.p) {
                c.this.a();
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            c.b((TextureView) view, c.this.r);
        }
    }

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11305a = 2;
        if (isInEditMode()) {
            this.b = null;
            this.d = null;
            this.f11306c = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            ImageView imageView = new ImageView(context);
            if (u.f11822a >= 23) {
                a(getResources(), imageView);
            } else {
                b(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        this.d = new a();
        setDescendantFocusability(262144);
        this.b = new com.opos.exoplayer.a.a(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.b, layoutParams);
        com.opos.exoplayer.a.a aVar = this.b;
        if (aVar != null) {
            a(aVar, 0);
        }
        View view = new View(context);
        this.e = view;
        view.setBackgroundColor(-16777216);
        this.b.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
        if (this.b == null || this.f11305a == 0) {
            this.f11306c = null;
        } else {
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            View textureView = this.f11305a == 2 ? new TextureView(context) : new SurfaceView(context);
            this.f11306c = textureView;
            textureView.setLayoutParams(layoutParams2);
            this.b.addView(this.f11306c, 0);
        }
        this.i = new FrameLayout(context);
        addView(this.i, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(context);
        this.f = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        this.b.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        this.l = this.f != null;
        this.g = new d(context);
        this.b.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        d dVar = this.g;
        if (dVar != null) {
            dVar.b();
            this.g.a();
        }
        View view2 = new View(context);
        addView(view2, new FrameLayout.LayoutParams(-1, -1));
        b bVar = new b(context, null, 0, attributeSet);
        this.h = bVar;
        bVar.setLayoutParams(view2.getLayoutParams());
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        int indexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeView(view2);
        viewGroup.addView(this.h, indexOfChild);
        this.n = this.h != null ? this.n : 0;
        this.q = true;
        this.o = true;
        this.p = true;
        this.k = this.h != null;
        a();
    }

    private static void a(Resources resources, ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#FFF4F3F0"));
    }

    private static void a(com.opos.exoplayer.a.a aVar, int i) {
        aVar.a(i);
    }

    private boolean a(Bitmap bitmap) {
        boolean z = false;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            z = false;
            if (width > 0) {
                z = false;
                if (height > 0) {
                    com.opos.exoplayer.a.a aVar = this.b;
                    if (aVar != null) {
                        aVar.a(width / height);
                    }
                    this.f.setImageBitmap(bitmap);
                    this.f.setVisibility(0);
                    z = true;
                }
            }
        }
        return z;
    }

    private boolean a(Metadata metadata) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= metadata.a()) {
                return false;
            }
            Metadata.Entry a2 = metadata.a(i2);
            if (a2 instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) a2).d;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
            i = i2 + 1;
        }
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#FFF4F3F0"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TextureView textureView, int i) {
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width == 0.0f || height == 0.0f || i == 0) {
            textureView.setTransform(null);
            return;
        }
        Matrix matrix = new Matrix();
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        matrix.postRotate(i, f, f2);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        textureView.setTransform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!(d() && this.p) && this.k) {
            boolean z2 = this.h.d() && this.h.a() <= 0;
            boolean c2 = c();
            if (z || z2 || c2) {
                c(c2);
            }
            if (z || c2) {
                c(c2);
            }
        }
    }

    private void c(boolean z) {
        if (this.k) {
            this.h.a(z ? 0 : this.n);
            this.h.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r3.j.d() != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c() {
        /*
            r3 = this;
            r0 = r3
            com.opos.exoplayer.core.q r0 = r0.j
            r7 = r0
            r0 = 1
            r6 = r0
            r0 = r7
            if (r0 != 0) goto Lf
            r0 = 1
            return r0
        Lf:
            r0 = r7
            int r0 = r0.c()
            r4 = r0
            r0 = r3
            boolean r0 = r0.o
            if (r0 == 0) goto L3a
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L3c
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 4
            if (r0 == r1) goto L3c
            r0 = r6
            r5 = r0
            r0 = r3
            com.opos.exoplayer.core.q r0 = r0.j
            boolean r0 = r0.d()
            if (r0 == 0) goto L3c
        L3a:
            r0 = 0
            r5 = r0
        L3c:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.c.c():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        q qVar = this.j;
        return qVar != null && qVar.o() && this.j.d();
    }

    private boolean d(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r3 = this;
            r0 = r3
            com.opos.exoplayer.core.q r0 = r0.j
            r6 = r0
            r0 = r6
            if (r0 != 0) goto La
            return
        La:
            r0 = r6
            com.opos.exoplayer.core.g.g r0 = r0.g()
            r6 = r0
            r0 = 0
            r4 = r0
        L13:
            r0 = r4
            r1 = r6
            int r1 = r1.f11747a
            if (r0 >= r1) goto L3b
            r0 = r3
            com.opos.exoplayer.core.q r0 = r0.j
            r1 = r4
            int r0 = r0.b(r1)
            r1 = 2
            if (r0 != r1) goto L34
            r0 = r6
            r1 = r4
            com.opos.exoplayer.core.g.f r0 = r0.a(r1)
            if (r0 == 0) goto L34
            goto Laa
        L34:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            goto L13
        L3b:
            r0 = r3
            android.view.View r0 = r0.e
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L4c
            r0 = r7
            r1 = 0
            r0.setVisibility(r1)
        L4c:
            r0 = r3
            boolean r0 = r0.l
            if (r0 == 0) goto Laa
            r0 = 0
            r4 = r0
        L55:
            r0 = r4
            r1 = r6
            int r1 = r1.f11747a
            if (r0 >= r1) goto L9f
            r0 = r6
            r1 = r4
            com.opos.exoplayer.core.g.f r0 = r0.a(r1)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L98
            r0 = 0
            r5 = r0
        L6b:
            r0 = r5
            r1 = r7
            int r1 = r1.e()
            if (r0 >= r1) goto L98
            r0 = r7
            r1 = r5
            com.opos.exoplayer.core.Format r0 = r0.a(r1)
            com.opos.exoplayer.core.metadata.Metadata r0 = r0.d
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L91
            r0 = r3
            r1 = r8
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto Lae
        L91:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L6b
        L98:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            goto L55
        L9f:
            r0 = r3
            r1 = r3
            android.graphics.Bitmap r1 = r1.m
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto Lae
        Laa:
            r0 = r3
            r0.f()
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.c.e():void");
    }

    private void f() {
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f.setVisibility(4);
        }
    }

    public void a() {
        b bVar = this.h;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void a(int i) {
        if (this.f11305a == i || this.j == null || this.b == null) {
            return;
        }
        View view = this.f11306c;
        this.f11305a = i;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View surfaceView = this.f11305a == 1 ? new SurfaceView(getContext()) : new TextureView(getContext());
        this.f11306c = surfaceView;
        surfaceView.setLayoutParams(layoutParams);
        q.d a2 = this.j.a();
        if (a2 != null) {
            if (view != null) {
                this.b.removeView(view);
                if (view instanceof TextureView) {
                    a2.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    a2.b((SurfaceView) view);
                }
            }
            View view2 = this.f11306c;
            if (view2 != null) {
                this.b.addView(view2, 0);
                View view3 = this.f11306c;
                if (view3 instanceof TextureView) {
                    a2.a((TextureView) view3);
                } else if (view3 instanceof SurfaceView) {
                    a2.a((SurfaceView) view3);
                }
            }
        }
    }

    public void a(q qVar) {
        q qVar2 = this.j;
        if (qVar2 == qVar) {
            return;
        }
        if (qVar2 != null) {
            qVar2.b(this.d);
            q.d a2 = this.j.a();
            if (a2 != null) {
                a2.b(this.d);
                View view = this.f11306c;
                if (view instanceof TextureView) {
                    a2.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    a2.b((SurfaceView) view);
                }
            }
            q.c b = this.j.b();
            if (b != null) {
                b.b(this.d);
            }
        }
        this.j = qVar;
        if (this.k) {
            this.h.a(qVar);
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        d dVar = this.g;
        if (dVar != null) {
            dVar.b(null);
        }
        if (qVar == null) {
            a();
            f();
            return;
        }
        q.d a3 = qVar.a();
        if (a3 != null) {
            View view3 = this.f11306c;
            if (view3 instanceof TextureView) {
                a3.a((TextureView) view3);
            } else if (view3 instanceof SurfaceView) {
                a3.a((SurfaceView) view3);
            }
            a3.a(this.d);
        }
        q.c b2 = qVar.b();
        if (b2 != null) {
            b2.a(this.d);
        }
        qVar.a(this.d);
        b(false);
        e();
    }

    public void a(boolean z) {
        b bVar;
        q qVar;
        com.opos.exoplayer.core.i.a.b((z && this.h == null) ? false : true);
        if (this.k == z) {
            return;
        }
        this.k = z;
        if (z) {
            bVar = this.h;
            qVar = this.j;
        } else {
            b bVar2 = this.h;
            if (bVar2 == null) {
                return;
            }
            bVar2.c();
            bVar = this.h;
            qVar = null;
        }
        bVar.a(qVar);
    }

    public boolean a(KeyEvent keyEvent) {
        return this.k && this.h.a(keyEvent);
    }

    public View b() {
        return this.f11306c;
    }

    public void b(int i) {
        com.opos.exoplayer.core.i.a.b(this.b != null);
        this.b.a(i);
    }

    public void c(int i) {
        View view = this.e;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        q qVar = this.j;
        boolean z = false;
        if (qVar != null && qVar.o()) {
            this.i.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z2 = d(keyEvent.getKeyCode()) && this.k && !this.h.d();
        b(true);
        if (z2 || a(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            z = true;
        }
        return z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (!this.k || this.j == null || motionEvent.getActionMasked() != 0) {
            z = false;
        } else if (!this.h.d()) {
            b(true);
            return true;
        } else if (this.q) {
            this.h.c();
            return true;
        }
        return z;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.k || this.j == null) {
            return false;
        }
        b(true);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f11306c;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }
}
