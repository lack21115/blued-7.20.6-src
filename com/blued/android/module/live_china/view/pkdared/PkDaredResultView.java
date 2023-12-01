package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import java.net.HttpURLConnection;
import java.text.DecimalFormat;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredResultView.class */
public class PkDaredResultView extends RelativeLayout {
    private IRequestHost a;
    private final int b;
    private final int c;
    private final int d;
    private int e;
    private TextView f;
    private View g;
    private View h;
    private View i;
    private View j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private int r;
    private int s;
    private int t;
    private int u;
    private Runnable v;
    private int w;
    private boolean x;
    private OvershootInterpolator y;

    public PkDaredResultView(Context context) {
        super(context);
        this.b = 11;
        this.c = 21;
        this.d = 31;
        this.e = 0;
        this.r = 5000;
        this.s = 5000;
        this.t = 5000;
        this.u = 30;
        this.y = new OvershootInterpolator(1.5f);
        a(context);
    }

    public PkDaredResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 11;
        this.c = 21;
        this.d = 31;
        this.e = 0;
        this.r = 5000;
        this.s = 5000;
        this.t = 5000;
        this.u = 30;
        this.y = new OvershootInterpolator(1.5f);
        a(context);
    }

    public PkDaredResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 11;
        this.c = 21;
        this.d = 31;
        this.e = 0;
        this.r = 5000;
        this.s = 5000;
        this.t = 5000;
        this.u = 30;
        this.y = new OvershootInterpolator(1.5f);
        a(context);
    }

    public PkDaredResultView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = 11;
        this.c = 21;
        this.d = 31;
        this.e = 0;
        this.r = 5000;
        this.s = 5000;
        this.t = 5000;
        this.u = 30;
        this.y = new OvershootInterpolator(1.5f);
        a(context);
    }

    private void a(int i) {
        if (this.v != null) {
            AppInfo.n().removeCallbacks(this.v);
            this.v = null;
        }
        Handler n = AppInfo.n();
        Runnable runnable = new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredResultView$PbJNcSNwPs__uqNLVvq_8KJPJjc
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredResultView.this.l();
            }
        };
        this.v = runnable;
        n.postDelayed(runnable, i <= 0 ? 5000L : i);
    }

    private void a(View view, int i, int i2) {
        view.animate().translationY(0.0f).setDuration(i).setStartDelay(i2).setInterpolator(this.y);
    }

    private String b(int i) {
        if (i < 10000) {
            return String.valueOf(i);
        }
        return new DecimalFormat("#0.00w").format(i / 10000.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void l() {
        b();
        int i = this.e;
        if (i == 11) {
            c();
        } else if (i == 21) {
            d();
        } else if (i != 31) {
        } else {
            PkDaredObserver.a().f(this.u);
        }
    }

    private void f() {
        this.e = 11;
        this.g.setAlpha(0.0f);
        this.h.setAlpha(0.0f);
        this.f.setAlpha(0.0f);
        this.f.setTextColor(ContextCompat.getColor(getContext(), R.color.syc_dark_FFB119));
        this.f.setText(R.string.live_pk_dared_kill_succeed);
        this.f.setScaleX(3.0f);
        this.f.setScaleY(3.0f);
        this.f.setTranslationY(-30.0f);
        this.f.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(450L).setInterpolator(this.y);
        a(this.r);
    }

    private void g() {
        this.i.setAlpha(0.0f);
        this.i.setBackgroundResource(R.drawable.live_pk_dared_result_win_background);
        this.k.setAlpha(0.0f);
        this.k.setScaleX(0.44f);
        this.k.setScaleY(0.44f);
        this.k.setImageResource(R.drawable.live_pk_dared_result_win_icon);
        this.g.setAlpha(1.0f);
        if (this.a != null) {
            this.l.setVisibility(0);
            ImageLoader.c(this.a, "live_pk_dared_win_star.png").e(this.l.hashCode()).g(-1).a(this.l);
        } else {
            this.l.setVisibility(8);
        }
        this.i.animate().alpha(1.0f).setDuration(100L);
        this.k.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(320L).setInterpolator(this.y).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredResultView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (PkDaredResultView.this.a != null) {
                    ImageLoader.c(PkDaredResultView.this.a, "live_pk_dared_win_highlight.png").e(PkDaredResultView.this.m.hashCode()).g(1).a(PkDaredResultView.this.m);
                }
            }
        });
    }

    private void h() {
        this.i.setAlpha(0.0f);
        this.i.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.syc_dark_2c2c2c));
        this.k.setAlpha(0.0f);
        this.k.setScaleX(0.44f);
        this.k.setScaleY(0.44f);
        this.k.setImageResource(R.drawable.live_pk_dared_result_lose_icon);
        this.g.setAlpha(1.0f);
        this.l.setVisibility(8);
        this.i.animate().alpha(1.0f).setDuration(100L);
        this.k.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(320L).setInterpolator(this.y).setListener(null);
    }

    private void i() {
        this.i.setAlpha(0.0f);
        this.i.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.syc_dark_2c2c2c));
        this.k.setAlpha(0.0f);
        this.k.setScaleX(0.44f);
        this.k.setScaleY(0.44f);
        this.k.setImageResource(R.drawable.live_pk_dared_result_tie_icon);
        this.g.setAlpha(1.0f);
        this.l.setVisibility(8);
        this.i.animate().alpha(1.0f).setDuration(100L);
        this.k.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(320L).setInterpolator(this.y).setListener(null);
    }

    private void j() {
        this.j.setAlpha(0.0f);
        this.q.setPivotY(0.0f);
        this.q.setRotationX(270.0f);
        float f = -DensityUtils.a(getContext(), 57.0f);
        this.n.setTranslationY(f);
        this.o.setTranslationY(f);
        this.p.setTranslationY(f);
        this.h.setAlpha(1.0f);
        this.j.animate().alpha(1.0f).setDuration(200L);
        this.q.animate().rotationX(0.0f).setDuration(1200L).setInterpolator(this.y);
        a(this.n, HttpURLConnection.HTTP_BAD_REQUEST, HttpURLConnection.HTTP_BAD_REQUEST);
        a(this.o, 520, 500);
        a(this.p, 640, 600);
    }

    private void k() {
        this.f.setTextColor(ContextCompat.getColor(getContext(), R.color.syc_dark_b));
        this.f.setText(R.string.live_pk_dared_not_mvp);
        this.f.setScaleX(3.0f);
        this.f.setScaleY(3.0f);
        this.f.setTranslationY(-30.0f);
        this.f.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(450L).setInterpolator(this.y);
        this.f.setVisibility(0);
    }

    public void a() {
        b();
        this.f.setText("");
        this.g.setAlpha(0.0f);
        this.h.setAlpha(0.0f);
        setVisibility(8);
    }

    public void a(int i, boolean z, String str, int i2, String str2, IRequestHost iRequestHost, int i3, int i4, int i5, int i6) {
        this.a = iRequestHost;
        this.r = i3 * 1000;
        this.s = i4 * 1000;
        this.t = i5 * 1000;
        this.w = i;
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (str == null || str.isEmpty()) {
            this.x = false;
        } else {
            this.x = true;
            this.o.setText(str);
            this.p.setText(String.format(getContext().getResources().getString(R.string.live_pk_dared_mvp_contribution), b(i2)));
            if (str2 != null && !str2.isEmpty()) {
                ImageLoader.a(iRequestHost, str2).c().a(this.n);
            }
        }
        this.u = i6;
        if (i != 1) {
            if (i == 2 || i == 3) {
                c();
            }
        } else if (z) {
            f();
        } else {
            c();
        }
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_result, this);
        this.f = (TextView) findViewById(R.id.tv_center_text);
        this.g = findViewById(R.id.rl_pk_root);
        this.h = findViewById(R.id.rl_mvp_root);
        this.i = findViewById(R.id.view_pk_result_background);
        this.k = (ImageView) findViewById(R.id.iv_pk_result_icon);
        this.l = (ImageView) findViewById(R.id.iv_pk_result_icon_star);
        this.m = (ImageView) findViewById(R.id.iv_pk_result_icon_highlight);
        this.j = findViewById(R.id.view_mvp_background);
        this.n = (ImageView) findViewById(R.id.iv_mvp_avatar);
        this.o = (TextView) findViewById(R.id.tv_mvp_nickname);
        this.p = (TextView) findViewById(R.id.tv_mvp_score);
        this.q = (TextView) findViewById(R.id.tv_mvp_label);
        this.f.getPaint().setFakeBoldText(true);
        this.o.getPaint().setFakeBoldText(true);
    }

    public void b() {
        if (this.v != null) {
            AppInfo.n().removeCallbacks(this.v);
            this.v = null;
        }
    }

    public void c() {
        this.e = 21;
        this.g.setAlpha(0.0f);
        this.h.setAlpha(0.0f);
        if (this.f.getAlpha() != 0.0f) {
            this.f.animate().alpha(0.0f).scaleX(0.3f).scaleY(0.3f).setDuration(100L).setInterpolator(this.y);
        }
        int i = this.w;
        if (i == 1) {
            g();
        } else if (i == 2) {
            h();
        } else if (i == 3) {
            i();
        }
        a(this.s);
    }

    public void d() {
        this.e = 31;
        this.g.animate().alpha(0.0f).setDuration(150L);
        this.h.setAlpha(0.0f);
        this.f.setAlpha(0.0f);
        if (this.x) {
            j();
        } else {
            k();
        }
        a(this.t);
    }
}
