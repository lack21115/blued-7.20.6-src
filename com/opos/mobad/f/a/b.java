package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.opos.mobad.f.a.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26058a = b.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f26059c;
    private i d;
    private int e;
    private int f;
    private a i;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private Animation.AnimationListener j = new Animation.AnimationListener() { // from class: com.opos.mobad.f.a.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.f.a.b.1.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.i();
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/b$a.class */
    public class a implements i.a {

        /* renamed from: a  reason: collision with root package name */
        i.a f26062a;

        public a(i.a aVar) {
            this.f26062a = aVar;
        }

        @Override // com.opos.mobad.f.a.i.a
        public void a(int i, int i2) {
            b.this.f = i2;
            b.this.e = i;
            b.this.g = true;
            i.a aVar = this.f26062a;
            if (aVar != null) {
                aVar.a(i, i2);
            }
        }
    }

    public b(Context context, i.a aVar) {
        this.b = context.getApplicationContext();
        this.f26059c = new LinearLayout(this.b);
        int b = com.opos.cmn.an.h.f.a.b(this.b);
        int a2 = com.opos.cmn.an.h.f.a.a(this.b, 60.0f);
        this.e = b;
        this.f = a2;
        this.d = new i(this.b, new i.b(b, b / 2, b / a2));
        a aVar2 = new a(aVar);
        this.i = aVar2;
        this.d.a(aVar2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.f26059c.addView(this.d, layoutParams);
        this.f26059c.setGravity(81);
        e();
        FrameLayout frameLayout = new FrameLayout(this.b);
        FrameLayout frameLayout2 = new FrameLayout(this.b);
        this.d.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
    }

    private void d() {
        if (this.g) {
            e();
            this.g = false;
        }
    }

    private void e() {
        if (this.d != null) {
            f();
            this.d.setInAnimation(g());
            this.d.setOutAnimation(h());
        }
    }

    private void f() {
        i iVar = this.d;
        if (iVar != null) {
            if (iVar.getInAnimation() != null) {
                this.d.getInAnimation().setAnimationListener(null);
                this.d.getInAnimation().cancel();
            }
            if (this.d.getOutAnimation() != null) {
                this.d.getOutAnimation().cancel();
            }
        }
    }

    private Animation g() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.e, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setAnimationListener(this.j);
        return translateAnimation;
    }

    private Animation h() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.e * (-1), 0.0f, 0.0f);
        translateAnimation.setDuration(1000L);
        return translateAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        i iVar = this.d;
        if (iVar == null || iVar.getNextView() == null) {
            return;
        }
        ((ViewGroup) this.d.getNextView()).removeAllViews();
    }

    public View a() {
        return this.f26059c;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.View r6) {
        /*
            r5 = this;
            java.lang.String r0 = com.opos.mobad.f.a.b.f26058a
            r10 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r11
            java.lang.String r1 = "show banner view:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r11
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            if (r0 == 0) goto Lc5
            r0 = r5
            boolean r0 = r0.h
            if (r0 == 0) goto L33
            return
        L33:
            r0 = r5
            r0.d()
            r0 = r5
            com.opos.mobad.f.a.i r0 = r0.d
            android.view.View r0 = r0.getCurrentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r11 = r0
            r0 = r11
            int r0 = r0.getChildCount()
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = r11
            r10 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 <= 0) goto L75
            r0 = r11
            r10 = r0
            r0 = r8
            r7 = r0
            r0 = r11
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            r1 = r6
            if (r0 == r1) goto L75
            r0 = r5
            com.opos.mobad.f.a.i r0 = r0.d
            android.view.View r0 = r0.getNextView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r10 = r0
            r0 = 1
            r7 = r0
        L75:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = r0
            r2 = -1
            r3 = -2
            r1.<init>(r2, r3)
            r11 = r0
            r0 = r11
            r1 = 17
            r0.gravity = r1
            r0 = r6
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto Lad
            r0 = r6
            android.view.ViewParent r0 = r0.getParent()
            r1 = r10
            if (r0 == r1) goto Lba
            r0 = r6
            android.view.ViewParent r0 = r0.getParent()
            boolean r0 = r0 instanceof android.view.ViewGroup
            if (r0 == 0) goto Lc5
            r0 = r6
            android.view.ViewParent r0 = r0.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r1 = r6
            r0.removeView(r1)
        Lad:
            r0 = r10
            r0.removeAllViews()
            r0 = r10
            r1 = r6
            r2 = r11
            r0.addView(r1, r2)
        Lba:
            r0 = r7
            if (r0 == 0) goto Lc5
            r0 = r5
            com.opos.mobad.f.a.i r0 = r0.d
            r0.showNext()
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.f.a.b.a(android.view.View):void");
    }

    public void b() {
        this.h = true;
        this.d.a(null);
        this.f26059c.removeAllViews();
    }

    public boolean c() {
        LinearLayout linearLayout = this.f26059c;
        if (linearLayout != null && linearLayout.isShown() && com.opos.cmn.i.j.a(this.b) && this.f26059c.hasWindowFocus()) {
            com.opos.cmn.an.f.a.b(f26058a, "isBannerShown");
            return true;
        }
        com.opos.cmn.an.f.a.b(f26058a, "isBanner not Shown");
        return false;
    }
}
