package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.text.DecimalFormat;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredBodyView.class */
public class PkDaredBodyView extends FrameLayout {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private OvershootInterpolator F;

    /* renamed from: a  reason: collision with root package name */
    public int f15371a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f15372c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private View j;
    private View k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private View q;
    private TextView r;
    private TextView s;
    private PkDaredProgressView t;
    private ValueAnimator u;
    private ValueAnimator v;
    private CountDownTimer w;
    private int x;
    private int y;
    private int z;

    public PkDaredBodyView(Context context) {
        super(context);
        this.d = 1;
        this.e = 2;
        this.f = 3;
        this.g = 4;
        this.h = 5;
        this.i = 6;
        this.F = new OvershootInterpolator(1.5f);
        a(context);
    }

    public PkDaredBodyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1;
        this.e = 2;
        this.f = 3;
        this.g = 4;
        this.h = 5;
        this.i = 6;
        this.F = new OvershootInterpolator(1.5f);
        a(context);
    }

    public PkDaredBodyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 1;
        this.e = 2;
        this.f = 3;
        this.g = 4;
        this.h = 5;
        this.i = 6;
        this.F = new OvershootInterpolator(1.5f);
        a(context);
    }

    public PkDaredBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = 1;
        this.e = 2;
        this.f = 3;
        this.g = 4;
        this.h = 5;
        this.i = 6;
        this.F = new OvershootInterpolator(1.5f);
        a(context);
    }

    private void a(int i, int i2, final TextView textView, ValueAnimator valueAnimator) {
        if (i == i2) {
            textView.setText(f(i2));
        } else if (valueAnimator == null) {
            textView.setText(f(i2));
        } else {
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.setIntValues(i, i2);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$UvnHlrKwwrVYJmQNx-Xef4Fj6aQ
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    PkDaredBodyView.this.a(textView, valueAnimator2);
                }
            };
            valueAnimator.setTarget(null);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.start();
        }
    }

    private void a(View view, int i, int i2) {
        a(view, i, i2, (Runnable) null);
    }

    private void a(View view, int i, int i2, final Runnable runnable) {
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight());
        view.setRotationX(90.0f);
        view.setTranslationY(-view.getHeight());
        view.setAlpha(1.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).rotationX(0.0f).translationY(0.0f).setDuration(i).setStartDelay(i2).setInterpolator(new OvershootInterpolator(2.0f)).start();
        if (runnable == null) {
            view.animate().setListener(null);
        } else {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredBodyView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, int i, long j) {
        textView.setText(String.format(getContext().getResources().getString(i), Long.valueOf(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, int i, String str, int i2, int i3) {
        SpannableString spannableString = new SpannableString(String.format(getContext().getResources().getString(i), str));
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.syc_dark_FFAD00)), i2, spannableString.length() - i3, 17);
        textView.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TextView textView, ValueAnimator valueAnimator) {
        textView.setText(f(((Integer) valueAnimator.getAnimatedValue()).intValue()));
    }

    private void b(View view, int i, int i2, final Runnable runnable) {
        view.animate().alpha(0.0f).rotationX(0.0f).translationY(view.getHeight()).setDuration(i * 0.35f).setStartDelay(i2 * 0.35f).setInterpolator(new AccelerateInterpolator(1.0f)).start();
        if (runnable == null) {
            view.animate().setListener(null);
        } else {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredBodyView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    runnable.run();
                }
            });
        }
    }

    private void d() {
        setAlpha(0.0f);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.u = valueAnimator;
        valueAnimator.setDuration(300L);
        this.u.setInterpolator(new DecelerateInterpolator(1.5f));
        this.u.setEvaluator(null);
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.v = valueAnimator2;
        valueAnimator2.setDuration(300L);
        this.v.setInterpolator(new DecelerateInterpolator(1.5f));
        this.v.setEvaluator(null);
    }

    private void e() {
        animate().alpha(1.0f).setDuration(100L);
        this.m.animate().translationX(0.0f).setDuration(320L).setInterpolator(this.F);
        this.o.animate().translationX(0.0f).setDuration(350L).setStartDelay(60L).setInterpolator(this.F);
        this.n.animate().translationX(0.0f).setDuration(320L).setInterpolator(this.F);
        this.p.animate().translationX(0.0f).setDuration(350L).setStartDelay(80L).setInterpolator(this.F);
        this.k.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setStartDelay(500L).setStartDelay(450L).setInterpolator(this.F).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredBodyView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ImageLoader.c(PkDaredBodyView.this.f15372c, "live_pk_dared_vs.png").e(PkDaredBodyView.this.l.hashCode()).g(-1).a(PkDaredBodyView.this.l);
            }
        });
        this.t.animate().translationY(0.0f).setDuration(350L).setStartDelay(200L).setInterpolator(this.F);
    }

    private String f(int i) {
        if (i < 10000) {
            return String.valueOf(i);
        }
        return new DecimalFormat("#0.00w").format(i / 10000.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        b(this.r, 390, 100, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$gGPv5VD8JOWbqN3clqSgOEBWy5s
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.h();
            }
        });
        b(this.s, 450, 150, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$jflPfLjCcK8f6Tpq16z2qyn99n4
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.s.setText("");
        a(this.s, 6, this.D);
        a((View) this.s, 450, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(final int i) {
        b(this.r, 390, 100, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$rdbwhO2VwX6KZRqwZWJZ5r4p8Xo
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.j();
            }
        });
        b(this.s, 450, 150, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$99wwcHs_7IYiNOg_jCNVczoF9e8
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.h(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.r.setText(R.string.live_pk_dared_about_kill_opposite_title);
        a((View) this.r, 390, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(int i) {
        a(this.s, R.string.live_pk_dared_about_kill_content, f(i), 4, 4);
        a((View) this.s, 450, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        this.j.animate().alpha(0.0f).setDuration(300L);
        this.q.animate().alpha(1.0f).setDuration(300L);
        a((View) this.r, 390, 100);
        a((View) this.s, 450, 150);
        a(this.s, 6, this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(final int i) {
        b(this.r, 390, 100, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$lhVn4Veg5TjoQqjZG_-aEm0vvrQ
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.l();
            }
        });
        b(this.s, 450, 150, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$pMJQ1Vh7V8msRkZAKmKeCahDkqk
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.j(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.r.setText("");
        a(this.r, 5, this.C);
        a((View) this.r, 390, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i) {
        a(this.s, R.string.live_pk_dared_not_activate_kill_content, f(i), 2, 4);
        a((View) this.s, 450, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.j.animate().alpha(0.0f).setDuration(300L);
        this.q.animate().alpha(1.0f).setDuration(300L);
        a((View) this.r, 390, 100);
        a((View) this.s, 450, 150);
        a(this.r, 5, this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.r.setText(R.string.live_pk_dared_not_activate_kill_title);
        a((View) this.r, 390, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.j.animate().alpha(0.0f).setDuration(300L);
        this.q.animate().alpha(1.0f).setDuration(300L);
        a((View) this.r, 390, 100);
        a((View) this.s, 450, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        b(this.r, 390, 100, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$9Msd4ExUG6hdPaIJW5Udcxj0Crg
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.p();
            }
        });
        b(this.s, 450, 150, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$LDmc3ZfB9bWh2Y5ckH1bB7bWL9A
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.o();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        this.s.setText("");
        a(this.s, 4, this.B);
        a((View) this.s, 450, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.r.setText(R.string.live_pk_dared_jion_kill_title);
        a((View) this.r, 390, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        this.j.animate().alpha(0.0f).setDuration(300L);
        this.q.animate().alpha(1.0f).setDuration(300L);
        a((View) this.r, 390, 100);
        a((View) this.s, 450, 150);
        a(this.s, 4, this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        b(this.r, 390, 100, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$YVFuFnQNLvTfL6wSgDBGGqGrNz4
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.t();
            }
        });
        b(this.s, 450, 150, new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$t3sTakBUdmdv0F9sGmYaPR6jNuQ
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.s();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        this.s.setText("");
        a(this.s, 2, this.y);
        a((View) this.s, 450, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.r.setText(R.string.live_pk_dared_egg_title);
        a((View) this.r, 390, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.j.animate().alpha(0.0f).setDuration(300L);
        this.q.animate().alpha(1.0f).setDuration(300L);
        a((View) this.r, 390, 100);
        a((View) this.s, 450, 150);
        a(this.s, 2, this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        this.m.setTranslationX((-getWidth()) / 2);
        this.o.setTranslationX((-getWidth()) / 2);
        this.n.setTranslationX(getWidth() / 2);
        this.p.setTranslationX(getWidth() / 2);
        this.k.setScaleX(2.7f);
        this.k.setScaleY(2.7f);
        this.k.setAlpha(0.0f);
        this.t.setTranslationY(getHeight() / 2);
        e();
    }

    public void a() {
        b();
        c();
        this.o.setText("0");
        this.n.setText("");
        this.p.setText("0");
        b(0, 0);
        setVisibility(8);
    }

    public void a(int i) {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        this.y = i;
        if (this.q.getAlpha() >= 0.99d) {
            this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$pjp_pw-ZA6Gmy7bl88u8BJzDdnY
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredBodyView.this.r();
                }
            });
            return;
        }
        this.q.setAlpha(0.0f);
        this.q.setVisibility(0);
        this.r.setText(R.string.live_pk_dared_egg_title);
        this.s.setText("");
        this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$phuagXASsZDY5-TiN75ScH0mL5E
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.u();
            }
        });
    }

    public void a(int i, int i2) {
        this.E = i;
        this.A = i2;
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_body, this);
        this.j = findViewById(R.id.rl_info_root);
        this.k = findViewById(R.id.iv_pk_icon);
        this.l = (ImageView) findViewById(R.id.iv_pk_icon_apng);
        this.m = (TextView) findViewById(R.id.tv_name_our);
        this.n = (TextView) findViewById(R.id.tv_name_opposite);
        this.o = (TextView) findViewById(R.id.tv_score_our);
        this.p = (TextView) findViewById(R.id.tv_score_opposite);
        this.q = findViewById(R.id.rl_hint_root);
        this.r = (TextView) findViewById(R.id.tv_hint_title);
        this.s = (TextView) findViewById(R.id.tv_hint_content);
        this.t = (PkDaredProgressView) findViewById(R.id.ppv_progress);
        this.m.getPaint().setFakeBoldText(true);
        this.n.getPaint().setFakeBoldText(true);
        this.o.getPaint().setFakeBoldText(true);
        this.p.getPaint().setFakeBoldText(true);
        this.r.getPaint().setFakeBoldText(true);
        b(0, 0);
        d();
    }

    public void a(final TextView textView, final int i, int i2) {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        this.w = new CountDownTimer(i2 * 1000, 1000L) { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredBodyView.4
            @Override // android.os.CountDownTimer
            public void onFinish() {
                switch (i) {
                    case 1:
                        PkDaredObserver.a().b(PkDaredBodyView.this.y);
                        break;
                    case 2:
                        PkDaredObserver.a().a(0, 0, PkDaredBodyView.this.E, PkDaredBodyView.this.A, PkDaredBodyView.this.A);
                        break;
                    case 3:
                        PkDaredObserver.a().c(PkDaredBodyView.this.B);
                        break;
                    case 4:
                        LiveRoomHttpUtils.a(2);
                        break;
                    case 5:
                        LiveRoomHttpUtils.a(3);
                        break;
                    case 6:
                        LiveRoomHttpUtils.a(3);
                        break;
                }
                if (PkDaredBodyView.this.w != null) {
                    PkDaredBodyView.this.w.cancel();
                    PkDaredBodyView.this.w = null;
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                long round = Math.round(j / 1000.0d);
                int i3 = i;
                if (i3 == 2) {
                    PkDaredBodyView.this.a(textView, R.string.live_pk_dared_egg_prediction, round);
                } else if (i3 == 4) {
                    PkDaredBodyView.this.a(textView, R.string.live_pk_dared_jion_kill_content, round);
                } else if (i3 == 5) {
                    PkDaredBodyView.this.a(textView, R.string.live_pk_dared_about_kill_title, round);
                } else if (i3 != 6) {
                } else {
                    PkDaredBodyView.this.a(textView, R.string.live_pk_dared_about_kill_opposite_content, String.valueOf(round), 2, 4);
                }
            }
        }.start();
    }

    public void a(String str, int i, int i2, int i3, int i4, IRequestHost iRequestHost) {
        this.f15372c = iRequestHost;
        setAlpha(0.0f);
        a();
        setVisibility(0);
        setTimeProgressMax(i2);
        setTimeProgress(i);
        setOppositeName(str);
        this.x = i3;
        this.y = i4;
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$nhzsXAaUdweYZMdDaHEkrj8tS5Q
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.v();
            }
        });
        c(i3, i4);
    }

    public void b() {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        this.t.a();
    }

    public void b(int i) {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        this.B = i;
        if (this.q.getAlpha() >= 0.99d) {
            this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$tkuSSuEL7bkePSg0LP2ADUN33Rg
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredBodyView.this.n();
                }
            });
            return;
        }
        this.q.setAlpha(0.0f);
        this.q.setVisibility(0);
        this.r.setText(R.string.live_pk_dared_jion_kill_title);
        this.s.setText("");
        this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$OPYOtO72_0w4_JirglyIKR11kH8
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.q();
            }
        });
    }

    public void b(int i, int i2) {
        a(this.f15371a, i, this.o, this.u);
        a(this.b, i2, this.p, this.v);
        this.f15371a = i;
        this.b = i2;
        PkDaredProgressView pkDaredProgressView = this.t;
        if (pkDaredProgressView == null) {
            return;
        }
        pkDaredProgressView.a(i, i2);
    }

    public void c() {
        this.q.setAlpha(0.0f);
        this.q.setVisibility(8);
        this.j.setAlpha(1.0f);
    }

    public void c(final int i) {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        if (this.q.getAlpha() >= 0.99d) {
            this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$-ya1LKk4qJ2TYFh-_nB15uDWsm0
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredBodyView.this.i(i);
                }
            });
            return;
        }
        this.q.setAlpha(0.0f);
        this.q.setVisibility(0);
        this.r.setText(R.string.live_pk_dared_not_activate_kill_title);
        a(this.s, R.string.live_pk_dared_not_activate_kill_content, f(i), 2, 4);
        this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$MyChaJ2IDKl1IlAwylpOoNGjqFs
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.m();
            }
        });
    }

    public void c(int i, int i2) {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        c();
        this.x = i;
        this.y = i2;
        if (i2 > 0 || i > 0) {
            a(this.s, 1, this.x);
        }
    }

    public void d(int i) {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        this.D = i;
        if (this.q.getAlpha() >= 0.99d) {
            this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$FJWAvdAv4ERG8xnwTnOlB8TOOCU
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredBodyView.this.f();
                }
            });
            return;
        }
        this.q.setAlpha(0.0f);
        this.q.setVisibility(0);
        this.r.setText(R.string.live_pk_dared_about_kill_opposite_title);
        this.s.setText("");
        this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$Af3XeV030pgg-OM8YA2FepCTqf8
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.i();
            }
        });
    }

    public void d(int i, int i2) {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        c();
        this.z = i;
        this.B = i2;
        if (i2 > 0 || i > 0) {
            a(this.s, 3, this.z);
        }
    }

    public void e(int i) {
        this.t.a(i);
    }

    public void e(int i, final int i2) {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        this.C = i;
        if (this.q.getAlpha() >= 0.99d) {
            this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$feQmiY-fLv_x7n92AHiuCvXDVrc
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredBodyView.this.g(i2);
                }
            });
            return;
        }
        this.q.setAlpha(0.0f);
        this.q.setVisibility(0);
        this.r.setText("");
        a(this.s, R.string.live_pk_dared_about_kill_content, f(i2), 4, 4);
        this.q.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredBodyView$GX7X1U4Gh0guft20wMcHBwUyoDU
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredBodyView.this.k();
            }
        });
    }

    public void setOppositeName(String str) {
        this.n.setText(str);
    }

    public void setTimeProgress(int i) {
        this.t.setTimeProgress(i);
    }

    public void setTimeProgressMax(int i) {
        this.t.setTimeProgressMax(i);
    }
}
