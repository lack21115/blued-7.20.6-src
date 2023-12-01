package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredFogView.class */
public class PkDaredFogView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f15383a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f15384c;
    private CountDownTimer d;

    public PkDaredFogView(Context context) {
        super(context);
        a(context);
    }

    public PkDaredFogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PkDaredFogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public PkDaredFogView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(1.5f);
        this.f15384c.animate().alpha(0.0f).setDuration(200L).setStartDelay(0L).setInterpolator(accelerateInterpolator);
        this.f15383a.animate().translationX(-this.f15383a.getWidth()).setDuration(400L).setStartDelay(200L).setInterpolator(accelerateInterpolator);
        this.b.animate().translationX(this.b.getWidth()).setDuration(400L).setStartDelay(200L).setInterpolator(accelerateInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredFogView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PkDaredFogView.this.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        View view = this.f15383a;
        view.setTranslationX(-view.getWidth());
        View view2 = this.b;
        view2.setTranslationX(view2.getWidth());
        this.f15384c.setAlpha(0.0f);
        setAlpha(1.0f);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(1.5f);
        this.f15384c.animate().alpha(1.0f).setDuration(200L).setStartDelay(520L).setInterpolator(decelerateInterpolator);
        this.f15383a.animate().translationX(0.0f).setDuration(600L).setStartDelay(200L).setInterpolator(decelerateInterpolator);
        this.b.animate().translationX(0.0f).setDuration(600L).setStartDelay(200L).setInterpolator(decelerateInterpolator).setListener(null);
    }

    public void a() {
        b();
        View view = this.f15383a;
        view.setTranslationX(-view.getWidth());
        View view2 = this.b;
        view2.setTranslationX(view2.getWidth());
        this.f15384c.setAlpha(0.0f);
        setAlpha(1.0f);
        setVisibility(8);
    }

    public void a(int i) {
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.d = null;
        }
        this.d = new CountDownTimer(i * 1000, 1000L) { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredFogView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (PkDaredFogView.this.d != null) {
                    PkDaredFogView.this.d.cancel();
                    PkDaredFogView.this.d = null;
                }
                PkDaredFogView.this.c();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                PkDaredFogView.this.f15384c.setText(String.format(PkDaredFogView.this.getContext().getResources().getString(R.string.live_pk_dared_fog_hide), Long.valueOf(Math.round(j / 1000.0d))));
            }
        }.start();
        setAlpha(0.0f);
        setVisibility(0);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredFogView$DzNfLemVR4GEKjIBM9trS4PUNu8
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredFogView.this.d();
            }
        });
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_fog, this);
        this.f15383a = findViewById(R.id.iv_fog_left);
        this.b = findViewById(R.id.iv_fog_right);
        this.f15384c = (TextView) findViewById(R.id.tv_fog_time);
    }

    public void b() {
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.d = null;
        }
    }
}
