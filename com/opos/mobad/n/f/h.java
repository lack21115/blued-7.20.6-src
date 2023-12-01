package com.opos.mobad.n.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/h.class */
public class h extends RelativeLayout implements com.opos.mobad.n.f.a {
    private static int n = 280;
    private static int o = 488;

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.n.a.b f13031a;
    private com.opos.mobad.n.c.h b;

    /* renamed from: c  reason: collision with root package name */
    private View f13032c;
    private View d;
    private TextView e;
    private i f;
    private com.opos.mobad.n.a.k g;
    private com.opos.mobad.n.c.h h;
    private TextView i;
    private boolean j;
    private a.InterfaceC0538a k;
    private RelativeLayout l;
    private RelativeLayout m;
    private com.opos.mobad.n.d.d p;
    private AnimatorSet q;
    private ObjectAnimator r;
    private AnimatorSet s;
    private AnimatorSet t;
    private com.opos.mobad.n.c.g u;

    /* renamed from: com.opos.mobad.n.f.h$4  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/h$4.class */
    class AnonymousClass4 extends com.opos.mobad.n.c.g {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(final View view, final int[] iArr) {
            h.this.a(new a() { // from class: com.opos.mobad.n.f.h.4.1
                @Override // com.opos.mobad.n.f.h.a
                public void a() {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.k != null) {
                                h.this.k.d(view, iArr);
                            }
                        }
                    });
                }
            });
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/h$a.class */
    public interface a {
        void a();
    }

    public h(Context context, boolean z) {
        super(context);
        this.u = new AnonymousClass4();
        this.j = z;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        this.b.setVisibility(8);
        this.e.setVisibility(8);
        this.l.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        if (layoutParams.width != i || layoutParams.height != i2) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        this.m.setVisibility(0);
        View view = this.d;
        if (view != null) {
            view.setVisibility(0);
            this.i.setVisibility(0);
            Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.1f, 1.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(133L);
            ofFloat.setInterpolator(create);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.n.f.h.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    h.this.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
    }

    private void a(com.opos.mobad.n.d.a aVar) {
        String str;
        if (aVar == null) {
            str = "app info is null";
        } else if (this.p == null) {
            if (indexOfChild(this.f13031a) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(14);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
                addView(this.f13031a, layoutParams);
            }
            this.f13031a.a(0, aVar.f12938a, aVar.b);
            return;
        } else {
            str = "app info has render";
        }
        com.opos.cmn.an.f.a.b("InterstitialViewFrame", str);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        if (this.j) {
            if (indexOfChild(this.f) < 0) {
                this.f.a(this.k);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                layoutParams.addRule(10);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
                addView(this.f, layoutParams);
                this.f.bringToFront();
            }
            this.f.a(dVar.r, dVar.B, dVar.s, dVar.i, dVar.j, dVar.k);
            return;
        }
        if (this.b.indexOfChild(this.g) < 0) {
            this.g.a(this.k);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            this.b.addView(this.g, layoutParams2);
            this.g.bringToFront();
        }
        this.g.a(dVar.r, dVar.i, dVar.j, dVar.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        this.r = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.r.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.9f, 1.0f));
        this.r.setDuration(150L);
        this.r.start();
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.n.f.h.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                h.this.r.removeListener(this);
                if (aVar != null) {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            }
        });
    }

    private void c() {
        setClipChildren(false);
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        setClickable(true);
        this.l = new RelativeLayout(getContext());
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(getContext());
        this.b = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.b.setId(View.generateViewId());
        this.b.setBackgroundColor(-1);
        this.l.addView(this.b, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.j ? 240 : 258), com.opos.cmn.an.h.f.a.a(getContext(), this.j ? 427 : 401)));
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.e.setOnClickListener(this.u);
        this.e.setOnTouchListener(this.u);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 36.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(3, this.b.getId());
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        this.l.addView(this.e, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.l, layoutParams2);
        this.f13031a = new com.opos.mobad.n.a.b(getContext());
        if (this.j) {
            this.f = new i(getContext());
        } else {
            this.g = com.opos.mobad.n.a.k.b(getContext());
        }
        d();
    }

    private void d() {
        this.m = new RelativeLayout(getContext());
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(getContext());
        this.h = hVar;
        hVar.a();
        this.h.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.h.setId(View.generateViewId());
        this.h.setBackgroundColor(-1);
        this.h.setVisibility(0);
        this.m.addView(this.h, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), n), com.opos.cmn.an.h.f.a.a(getContext(), o)));
        TextView textView = new TextView(getContext());
        this.i = textView;
        textView.setVisibility(0);
        this.i.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.i.setOnClickListener(this.u);
        this.i.setOnTouchListener(this.u);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 36.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(3, this.h.getId());
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        this.m.addView(this.i, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.m.setVisibility(4);
        addView(this.m, layoutParams2);
    }

    private void e() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.1f, 1.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", 0.8f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.b, "scaleX", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.q = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        this.q.setDuration(250L);
        this.q.start();
    }

    @Override // com.opos.mobad.n.f.a
    public ViewGroup a() {
        return this;
    }

    @Override // com.opos.mobad.n.f.a
    public void a(View view) {
        if (view == null) {
            return;
        }
        this.f13032c = view;
        if (this.b.indexOfChild(view) < 0) {
            this.b.removeAllViews();
            this.b.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.opos.mobad.n.f.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.k = interfaceC0538a;
        this.f13031a.a(interfaceC0538a);
    }

    @Override // com.opos.mobad.n.f.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0538a interfaceC0538a;
        if (hVar == null) {
            com.opos.cmn.an.f.a.d("", "render builder with data null");
            interfaceC0538a = this.k;
            if (interfaceC0538a == null) {
                return;
            }
        } else {
            com.opos.mobad.n.d.d b = this.j ? hVar.b() : hVar.a();
            if (b != null) {
                a(b.v);
                a(b);
                if (this.p == null) {
                    e();
                }
                this.p = b;
                return;
            }
            com.opos.cmn.an.f.a.d("InterstitialViewFrame", "render with data null");
            interfaceC0538a = this.k;
            if (interfaceC0538a == null) {
                return;
            }
        }
        interfaceC0538a.b(1);
    }

    @Override // com.opos.mobad.n.f.a
    public void b() {
        final int a2 = com.opos.cmn.an.h.f.a.a(getContext(), n);
        final int a3 = com.opos.cmn.an.h.f.a.a(getContext(), o);
        int width = this.b.getWidth();
        int height = this.b.getHeight();
        float f = a2 / width;
        float f2 = a3 / height;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", 1.0f, f2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.e, "translationY", 0.0f, (a3 - height) / 2);
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.j ? this.f : this.g, "alpha", 1.0f, 0.0f);
        ofFloat4.setInterpolator(create);
        ofFloat4.setDuration(133L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f13031a, "alpha", 1.0f, 0.0f);
        ofFloat5.setInterpolator(create);
        ofFloat5.setDuration(133L);
        Interpolator create2 = PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f13032c, "scaleX", 1.0f, 1.266f);
        ofFloat6.setInterpolator(create2);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f13032c, "scaleY", 1.0f, 1.266f);
        ofFloat7.setInterpolator(create2);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f13032c, "alpha", 1.0f, 0.0f);
        ofFloat8.setInterpolator(create);
        ofFloat5.setDuration(133L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.s = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat6, ofFloat7);
        this.s.setDuration(267L);
        this.s.start();
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.t = animatorSet2;
        animatorSet2.playTogether(ofFloat4, ofFloat5, ofFloat8);
        this.t.setDuration(133L);
        this.t.start();
        this.s.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.n.f.h.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                h.this.s.removeListener(this);
                if (h.this.f != null) {
                    h.this.f.setVisibility(8);
                }
                if (h.this.g != null) {
                    h.this.g.setVisibility(8);
                }
                h.this.f13031a.setVisibility(8);
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.a(a2, a3);
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.n.f.a
    public void b(View view) {
        if (view == null) {
            return;
        }
        this.d = view;
        if (this.h.indexOfChild(view) < 0) {
            if (this.d.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
            this.h.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
