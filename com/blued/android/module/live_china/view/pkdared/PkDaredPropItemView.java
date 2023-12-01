package com.blued.android.module.live_china.view.pkdared;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.PropModule;
import com.blued.android.module.live_china.observer.PkDaredObserver;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredPropItemView.class */
public class PkDaredPropItemView extends FrameLayout {
    private ImageView a;
    private PkDaredPropProgressView b;
    private CountDownTimer c;
    private PropModule d;

    public PkDaredPropItemView(Context context) {
        super(context);
        a(context);
    }

    public PkDaredPropItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PkDaredPropItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private int a(RelativeLayout relativeLayout, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            if (i3 >= relativeLayout.getChildCount()) {
                return i4;
            }
            i = i4;
            if (relativeLayout.getChildAt(i3).getTag() != null) {
                i = i4;
                if (relativeLayout.getChildAt(i3).getTag() instanceof Integer) {
                    int intValue = ((Integer) relativeLayout.getChildAt(i3).getTag()).intValue();
                    i = this.d.isOur ? Math.max(i4, intValue) : Math.min(i4, intValue);
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        setScaleX(0.7f);
        setScaleY(0.7f);
        animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new OvershootInterpolator(1.5f));
    }

    public void a() {
        CountDownTimer countDownTimer = this.c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.c = null;
        }
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_prop_item, this);
        this.a = (ImageView) findViewById(R.id.iv_prop_icon);
        this.b = (PkDaredPropProgressView) findViewById(R.id.pdpp_prop_time);
    }

    /* renamed from: a */
    public void b(RelativeLayout relativeLayout) {
        int i;
        int height = relativeLayout.getHeight();
        int a = a(relativeLayout, this.d.isOur ? -height : relativeLayout.getWidth());
        if (this.d.isOur) {
            i = a + height;
        } else {
            i = a;
            if (!this.d.isOur) {
                i = a - height;
            }
        }
        relativeLayout.addView(this);
        setTranslationX(i);
        setTag(Integer.valueOf(i));
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredPropItemView$_KulLFd-C_t_pAjWPrtALWIOc8A
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredPropItemView.this.c();
            }
        });
    }

    public void a(IRequestHost iRequestHost, final RelativeLayout relativeLayout, PropModule propModule) {
        this.d = propModule;
        setAlpha(0.0f);
        setColor(ContextCompat.getColor(getContext(), propModule.isOur ? R.color.syc_dark_81B5FF : R.color.syc_dark_FB54AD));
        setProgressMax(propModule.totalTime);
        setProgress(propModule.countDown);
        ImageLoader.a(iRequestHost, propModule.propIcon).a(this.a);
        relativeLayout.post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredPropItemView$TghVQCb7Wk1RF_rRVCSdJoRpliM
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredPropItemView.this.b(relativeLayout);
            }
        });
    }

    public void b() {
        animate().alpha(0.0f).scaleX(0.7f).scaleY(0.7f).setDuration(300L).setStartDelay(0L).setInterpolator(new DecelerateInterpolator(2.0f)).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredPropItemView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                PkDaredObserver.a().a(PkDaredPropItemView.this.d.isOur, PkDaredPropItemView.this);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) getParent();
        if (relativeLayout == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= relativeLayout.getChildCount() || relativeLayout == null) {
                return;
            }
            View childAt = relativeLayout.getChildAt(i2);
            if (this.d.isOur && childAt.getTranslationX() > getTranslationX()) {
                int intValue = childAt.getTag() == null ? 0 : ((Integer) childAt.getTag()).intValue() - getWidth();
                childAt.setTag(Integer.valueOf(intValue));
                childAt.animate().translationX(intValue).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.0f));
            } else if (!this.d.isOur && childAt.getTranslationX() < getTranslationX()) {
                int intValue2 = childAt.getTag() == null ? 0 : ((Integer) childAt.getTag()).intValue() + getWidth();
                childAt.setTag(Integer.valueOf(intValue2));
                childAt.animate().translationX(intValue2).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.0f));
            }
            i = i2 + 1;
        }
    }

    public void setColor(int i) {
        this.b.setColor(i);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.blued.android.module.live_china.view.pkdared.PkDaredPropItemView$1] */
    public void setProgress(float f) {
        this.b.setProgress(((int) f) * 10);
        CountDownTimer countDownTimer = this.c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.c = null;
        }
        this.c = new CountDownTimer(1000 * f, 1000L) { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredPropItemView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                PkDaredPropItemView.this.a();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                long round = Math.round(j / 1000.0d) - 1;
                ObjectAnimator ofInt = ObjectAnimator.ofInt(PkDaredPropItemView.this.b, "progress", PkDaredPropItemView.this.b.getProgress(), ((int) round) * 10);
                ofInt.setDuration(1000L);
                ofInt.setInterpolator(new DecelerateInterpolator(1.5f));
                if (round <= 0) {
                    ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredPropItemView.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            PkDaredPropItemView.this.b();
                        }
                    });
                }
                ofInt.start();
            }
        }.start();
    }

    public void setProgressMax(int i) {
        this.b.setProgressMax(i * 10);
    }
}
