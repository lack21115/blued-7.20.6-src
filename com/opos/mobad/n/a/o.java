package com.opos.mobad.n.a;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/o.class */
public class o implements f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26538a = false;
    private com.opos.mobad.n.c.h b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.n.c.e f26539c;
    private Context d;
    private RelativeLayout e;
    private TextView f;
    private Animator g;
    private Animator h;
    private Animator i;
    private Animator j;
    private m k;
    private RelativeLayout l;

    public o(Context context, m mVar) {
        this.d = context;
        this.k = mVar;
        this.l = new RelativeLayout(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.d, 96.0f));
        this.e = new RelativeLayout(context);
        layoutParams.addRule(13);
        this.l.addView(this.e, layoutParams);
        g();
        h();
    }

    private void g() {
        TextView a2 = q.a(this.d);
        this.f = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 324.0f), com.opos.cmn.an.h.f.a.a(this.d, 66.0f));
        layoutParams.addRule(13);
        this.e.addView(this.f, layoutParams);
        if (this.k == m.BREATH) {
            this.f26539c = new com.opos.mobad.n.c.e(this.d);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.d, 346.0f), com.opos.cmn.an.h.f.a.a(this.d, 88.0f));
            layoutParams2.addRule(13);
            this.f26539c.setImageResource(R.drawable.opos_mobad_btn_fading);
            this.f26539c.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f26539c.b(com.opos.cmn.an.h.f.a.a(this.d, 88.0f));
            this.f26539c.a(com.opos.cmn.an.h.f.a.a(this.d, 30.0f));
            this.e.addView(this.f26539c, layoutParams2);
        }
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.b = new com.opos.mobad.n.c.h(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5, this.f.getId());
        layoutParams.addRule(7, this.f.getId());
        layoutParams.addRule(6, this.f.getId());
        layoutParams.addRule(8, this.f.getId());
        layoutParams.addRule(13);
        this.b.setBackgroundColor(0);
        this.b.a(com.opos.cmn.an.h.f.a.a(this.d, 60.0f));
        this.e.addView(this.b, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.i == null) {
            Animator a2 = n.a(this.f26539c);
            this.i = a2;
            a2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.h == null) {
            Animator a2 = n.a((RelativeLayout) this.b);
            this.h = a2;
            a2.start();
        }
    }

    @Override // com.opos.mobad.n.a.f
    public View a() {
        return this.l;
    }

    @Override // com.opos.mobad.n.a.f
    public void a(com.opos.mobad.n.c.g gVar) {
        this.f.setOnTouchListener(gVar);
        this.f.setOnClickListener(gVar);
    }

    @Override // com.opos.mobad.n.a.f
    public void a(String str, int i, int i2) {
        this.f.setText(str);
    }

    @Override // com.opos.mobad.n.a.f
    public void b() {
        if (Build.VERSION.SDK_INT >= 21 && this.k != m.NONE) {
            Animator animator = this.g;
            if (animator == null || !animator.isRunning()) {
                if (this.j == null) {
                    this.j = n.c(this.l);
                }
                this.j.start();
            }
        }
    }

    @Override // com.opos.mobad.n.a.f
    public void c() {
        if (Build.VERSION.SDK_INT < 21 || this.k == m.NONE || this.f26538a) {
            return;
        }
        this.f26538a = true;
        Animator a2 = n.a((View) this.l);
        this.g = a2;
        a2.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.n.a.o.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (o.this.k == m.BREATH) {
                    o.this.i();
                } else if (o.this.k == m.SPLASH) {
                    o.this.j();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.g.start();
    }

    @Override // com.opos.mobad.n.a.f
    public void d() {
    }

    @Override // com.opos.mobad.n.a.f
    public void e() {
    }

    @Override // com.opos.mobad.n.a.f
    public void f() {
        Animator animator = this.g;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.i;
        if (animator2 != null) {
            animator2.end();
        }
        Animator animator3 = this.h;
        if (animator3 != null) {
            animator3.end();
        }
        Animator animator4 = this.j;
        if (animator4 != null) {
            animator4.end();
        }
    }
}
