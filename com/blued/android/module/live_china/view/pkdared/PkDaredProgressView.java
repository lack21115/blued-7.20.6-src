package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.text.DecimalFormat;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredProgressView.class */
public class PkDaredProgressView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private PkDaredScoreProgressView f15403a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private View f15404c;
    private PkDaredTimeProgressView d;
    private TextView e;
    private int f;
    private ValueAnimator g;
    private CountDownTimer h;

    public PkDaredProgressView(Context context) {
        super(context);
        this.f = 0;
        a(context);
    }

    public PkDaredProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        a(context);
    }

    public PkDaredProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        a(context);
    }

    public PkDaredProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f = 0;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        setScoreText(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private String c(int i) {
        if (i < 10000) {
            return String.valueOf(i);
        }
        return new DecimalFormat("#0.00w").format(i / 10000.0f);
    }

    private void setScoreText(int i) {
        if (i == 0) {
            this.b.setText(getContext().getResources().getString(R.string.live_pk_dared_score_fair));
        } else if (i < 0) {
            this.b.setText(String.format(getContext().getResources().getString(R.string.live_pk_dared_score_behind), c(Math.abs(i))));
        } else if (i > 0) {
            this.b.setText(String.format(getContext().getResources().getString(R.string.live_pk_dared_score_lead), c(Math.abs(i))));
        }
    }

    public void a() {
        CountDownTimer countDownTimer = this.h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.h = null;
        }
    }

    public void a(final int i) {
        this.f15404c.animate().alpha(1.0f).setDuration(200L).setStartDelay(0L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredProgressView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PkDaredProgressView.this.b(i * 1000);
            }
        });
    }

    public void a(int i, int i2) {
        if (this.f15403a == null) {
            return;
        }
        float f = i;
        float f2 = f / (i2 + f);
        float f3 = f2;
        if (i == 0) {
            f3 = f2;
            if (i2 == 0) {
                f3 = 0.5f;
            }
        }
        PkDaredScoreProgressView pkDaredScoreProgressView = this.f15403a;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(pkDaredScoreProgressView, "progress", pkDaredScoreProgressView.getProgress(), f3);
        ofFloat.setDuration(700L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        ofFloat.start();
        int i3 = i - i2;
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator == null) {
            this.f = i3;
            setScoreText(i3);
            return;
        }
        valueAnimator.cancel();
        this.g.removeAllUpdateListeners();
        this.g.setIntValues(this.f, i3);
        this.f = i3;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredProgressView$woAHeEAV54USiyJlWq1YwSTsquA
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                PkDaredProgressView.this.a(valueAnimator2);
            }
        };
        this.g.setTarget(null);
        this.g.addUpdateListener(animatorUpdateListener);
        this.g.start();
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_progress_view, this);
        this.f15403a = (PkDaredScoreProgressView) findViewById(R.id.ppsv_score);
        this.b = (TextView) findViewById(R.id.tv_score);
        this.f15404c = findViewById(R.id.view_mask);
        this.d = (PkDaredTimeProgressView) findViewById(R.id.pptv_time);
        this.e = (TextView) findViewById(R.id.tv_time);
        this.b.getPaint().setFakeBoldText(true);
        this.e.getPaint().setFakeBoldText(true);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.g = valueAnimator;
        valueAnimator.setDuration(700L);
        this.g.setInterpolator(new DecelerateInterpolator(2.0f));
        this.g.setEvaluator(null);
        this.f15403a.setProgress(50);
        this.f15403a.setProgressMax(100);
    }

    public void b(int i) {
        this.f15404c.animate().alpha(0.0f).setDuration(200L).setStartDelay(i);
    }

    public void setTimeProgress(int i) {
        this.d.setProgress(i);
        this.e.setText(String.valueOf(i));
        CountDownTimer countDownTimer = this.h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.h = null;
        }
        this.h = new CountDownTimer(i * 1000, 1000L) { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredProgressView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                PkDaredProgressView.this.a();
                LiveRoomHttpUtils.a(3);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                long round = Math.round(j / 1000.0d);
                PkDaredProgressView.this.d.setProgress((int) round);
                PkDaredProgressView.this.e.setText(String.valueOf(round));
            }
        }.start();
    }

    public void setTimeProgressMax(int i) {
        PkDaredTimeProgressView pkDaredTimeProgressView = this.d;
        if (pkDaredTimeProgressView == null) {
            return;
        }
        pkDaredTimeProgressView.setProgressMax(i);
        this.e.setText(String.valueOf(this.d.getProgress()));
    }
}
