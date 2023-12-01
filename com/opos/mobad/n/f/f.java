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

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/f.class */
public class f extends RelativeLayout implements com.opos.mobad.n.f.a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.n.a.b f26695a;
    private com.opos.mobad.n.c.h b;

    /* renamed from: c  reason: collision with root package name */
    private View f26696c;
    private View d;
    private TextView e;
    private i f;
    private com.opos.mobad.n.a.k g;
    private com.opos.mobad.n.c.h h;
    private TextView i;
    private int j;
    private boolean k;
    private a.InterfaceC0708a l;
    private RelativeLayout m;
    private RelativeLayout n;
    private com.opos.mobad.n.d.d o;
    private AnimatorSet p;
    private ObjectAnimator q;
    private AnimatorSet r;
    private AnimatorSet s;
    private com.opos.mobad.n.c.g t;

    /* renamed from: com.opos.mobad.n.f.f$4  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/f$4.class */
    class AnonymousClass4 extends com.opos.mobad.n.c.g {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(final View view, final int[] iArr) {
            f.this.a(new a() { // from class: com.opos.mobad.n.f.f.4.1
                @Override // com.opos.mobad.n.f.f.a
                public void a() {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.l != null) {
                                f.this.l.d(view, iArr);
                            }
                        }
                    });
                }
            });
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/f/f$a.class */
    public interface a {
        void a();
    }

    public f(Context context, int i, boolean z) {
        super(context);
        this.t = new AnonymousClass4();
        this.j = i;
        this.k = z;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        this.b.setVisibility(8);
        this.e.setVisibility(8);
        this.m.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        if (layoutParams.width != i || layoutParams.height != i2) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        this.n.setVisibility(0);
        View view = this.d;
        if (view != null) {
            view.setVisibility(0);
            this.i.setVisibility(0);
            Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.1f, 1.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(133L);
            ofFloat.setInterpolator(create);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.n.f.f.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    f.this.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
    }

    private void a(com.opos.mobad.n.d.a aVar) {
        String str;
        if (aVar == null) {
            str = "app info is null";
        } else if (this.o == null) {
            if (indexOfChild(this.f26695a) < 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(14);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
                addView(this.f26695a, layoutParams);
            }
            this.f26695a.a(this.j, aVar.f26626a, aVar.b);
            return;
        } else {
            str = "app info has render";
        }
        com.opos.cmn.an.f.a.b("InterstitialViewFrame", str);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        RelativeLayout.LayoutParams layoutParams;
        int a2;
        if (!this.k) {
            if (this.b.indexOfChild(this.g) < 0) {
                this.g.a(this.l);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
                layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
                layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
                this.b.addView(this.g, layoutParams2);
                this.g.bringToFront();
            }
            this.g.a(dVar.r, dVar.i, dVar.j, dVar.k);
            return;
        }
        if (indexOfChild(this.f) < 0) {
            this.f.a(this.l);
            if (this.j == 1) {
                layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.c(getContext()) - com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                layoutParams.addRule(10);
                a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                layoutParams.addRule(10);
                a2 = com.opos.cmn.an.h.f.a.a(getContext(), 38.0f);
            }
            layoutParams.topMargin = a2;
            addView(this.f, layoutParams);
            this.f.bringToFront();
        }
        this.f.a(dVar.r, dVar.B, dVar.s, dVar.i, dVar.j, dVar.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        this.q = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.q.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.9f, 1.0f));
        this.q.setDuration(150L);
        this.q.start();
        this.q.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.n.f.f.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.q.removeListener(this);
                if (aVar != null) {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.1.1
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
        this.m = new RelativeLayout(getContext());
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(getContext());
        this.b = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.b.setId(View.generateViewId());
        this.b.setBackgroundColor(-1);
        int i = 489;
        int i2 = this.k ? this.j == 1 ? 489 : 275 : this.j == 1 ? 272 : 258;
        if (!this.k) {
            i = this.j == 1 ? 262 : 401;
        } else if (this.j == 1) {
            i = 275;
        }
        this.m.addView(this.b, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), i2), com.opos.cmn.an.h.f.a.a(getContext(), i)));
        TextView textView = new TextView(getContext());
        this.e = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.e.setOnClickListener(this.t);
        this.e.setOnTouchListener(this.t);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 48.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        if (this.j == 1) {
            layoutParams.addRule(1, this.b.getId());
            layoutParams.addRule(15);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        } else {
            layoutParams.addRule(3, this.b.getId());
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        }
        this.m.addView(this.e, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.m, layoutParams2);
        this.f26695a = new com.opos.mobad.n.a.b(getContext());
        if (this.k) {
            this.f = new i(getContext());
        } else {
            this.g = com.opos.mobad.n.a.k.b(getContext());
        }
        d();
    }

    private void d() {
        int i = this.j == 0 ? 320 : 489;
        int i2 = this.j == 0 ? 619 : 275;
        this.n = new RelativeLayout(getContext());
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(getContext());
        this.h = hVar;
        hVar.a();
        this.h.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.h.setId(View.generateViewId());
        this.h.setBackgroundColor(-1);
        this.h.setVisibility(0);
        this.n.addView(this.h, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), i), com.opos.cmn.an.h.f.a.a(getContext(), i2)));
        TextView textView = new TextView(getContext());
        this.i = textView;
        textView.setVisibility(0);
        this.i.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.i.setOnClickListener(this.t);
        this.i.setOnTouchListener(this.t);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 48.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        if (this.j == 1) {
            layoutParams.addRule(1, this.h.getId());
            layoutParams.addRule(15);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        } else {
            layoutParams.addRule(3, this.h.getId());
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        }
        this.n.addView(this.i, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.n.setVisibility(4);
        addView(this.n, layoutParams2);
    }

    private void e() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.1f, 1.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", 0.8f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.b, "scaleX", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.p = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        this.p.setDuration(250L);
        this.p.start();
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
        this.f26696c = view;
        if (this.b.indexOfChild(view) < 0) {
            this.b.removeAllViews();
            this.b.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.opos.mobad.n.f.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.l = interfaceC0708a;
        this.f26695a.a(interfaceC0708a);
    }

    @Override // com.opos.mobad.n.f.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0708a interfaceC0708a;
        if (hVar == null) {
            com.opos.cmn.an.f.a.d("", "render builder with data null");
            interfaceC0708a = this.l;
            if (interfaceC0708a == null) {
                return;
            }
        } else {
            com.opos.mobad.n.d.d b = this.k ? hVar.b() : hVar.a();
            if (b != null) {
                a(b.v);
                a(b);
                if (this.o == null) {
                    e();
                }
                this.o = b;
                return;
            }
            com.opos.cmn.an.f.a.d("InterstitialViewFrame", "render with data null");
            interfaceC0708a = this.l;
            if (interfaceC0708a == null) {
                return;
            }
        }
        interfaceC0708a.b(1);
    }

    @Override // com.opos.mobad.n.f.a
    public void b() {
        int i = this.j == 0 ? 320 : 489;
        int i2 = this.j == 0 ? 619 : 275;
        final int a2 = com.opos.cmn.an.h.f.a.a(getContext(), i);
        final int a3 = com.opos.cmn.an.h.f.a.a(getContext(), i2);
        int width = this.b.getWidth();
        int height = this.b.getHeight();
        float f = a2 / width;
        float f2 = a3 / height;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "scaleX", 1.0f, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", 1.0f, f2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.e, this.j == 1 ? "translationX" : "translationY", 0.0f, (this.j == 1 ? a2 - width : a3 - height) / 2);
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.k ? this.f : this.g, "alpha", 1.0f, 0.0f);
        ofFloat4.setInterpolator(create);
        ofFloat4.setDuration(133L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f26695a, "alpha", 1.0f, 0.0f);
        ofFloat5.setInterpolator(create);
        ofFloat5.setDuration(133L);
        Interpolator create2 = PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f26696c, "scaleX", 1.0f, 1.266f);
        ofFloat6.setInterpolator(create2);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f26696c, "scaleY", 1.0f, 1.266f);
        ofFloat7.setInterpolator(create2);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f26696c, "alpha", 1.0f, 0.0f);
        ofFloat8.setInterpolator(create);
        ofFloat5.setDuration(133L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.r = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat6, ofFloat7);
        this.r.setDuration(267L);
        this.r.start();
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.s = animatorSet2;
        animatorSet2.playTogether(ofFloat4, ofFloat5, ofFloat8);
        this.s.setDuration(133L);
        this.s.start();
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.n.f.f.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.r.removeListener(this);
                if (f.this.f != null) {
                    f.this.f.setVisibility(8);
                }
                if (f.this.g != null) {
                    f.this.g.setVisibility(8);
                }
                f.this.f26695a.setVisibility(8);
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.a(a2, a3);
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
