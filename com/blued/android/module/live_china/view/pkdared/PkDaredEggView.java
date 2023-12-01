package com.blued.android.module.live_china.view.pkdared;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.text.DecimalFormat;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredEggView.class */
public class PkDaredEggView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f15380a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private View f15381c;
    private PkDaredEggProgressView d;
    private PkDaredEggProgressView e;
    private TextView f;
    private TextView g;
    private ValueAnimator h;
    private ValueAnimator i;
    private ImageView j;
    private PkDaredEggProgressView k;
    private View l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private View p;
    private TextView q;
    private TextView r;
    private CountDownTimer s;
    private int t;

    public PkDaredEggView(Context context) {
        super(context);
        a(context);
    }

    public PkDaredEggView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PkDaredEggView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public PkDaredEggView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, int i2, int i3, int i4, int i5) {
        this.j.setImageDrawable(null);
        this.j.setImageResource(R.drawable.live_pk_dared_egg_static);
        setTargetScore(i);
        a(i2, i3);
        this.k.setProgressMax(i4 * 100);
        this.k.setProgress(i5 * 100);
        a(i5);
        setTranslationY(getHeight());
        setScaleX(0.8f);
        setScaleY(0.8f);
        setAlpha(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "TranslationY", getTranslationY(), 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new OvershootInterpolator(1.5f));
        ofFloat.start();
        animate().scaleX(1.0f).scaleY(1.0f).setDuration(450L).setInterpolator(new AccelerateInterpolator(1.5f));
    }

    private void a(int i, int i2, final TextView textView, ValueAnimator valueAnimator) {
        if (i == i2) {
            textView.setText(b(i2));
        } else if (valueAnimator == null) {
            textView.setText(b(i2));
        } else {
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.setIntValues(i, i2);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredEggView$56zlPUlgeZ20B2K7htdQkdXHtKs
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    PkDaredEggView.this.a(textView, valueAnimator2);
                }
            };
            valueAnimator.setTarget(null);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void b(int i, String str, String str2, String str3, int i2) {
        b();
        if (i == 1) {
            a(str, str2, str3);
        } else if (i == 2) {
            a(str2);
        } else if (i == 3) {
            d();
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredEggView$Yrqlcc2v74DpQJBE-lgDVuul4HY
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredEggView.e();
            }
        }, i2 <= 0 ? 5000L : i2 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TextView textView, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        textView.setText(b(intValue) + BridgeUtil.SPLIT_MARK + b(this.t));
    }

    private void a(String str) {
        this.r.setText(String.format(getContext().getResources().getString(R.string.live_pk_dared_opposite_get_prop), str));
        this.r.setVisibility(0);
        this.p.animate().alpha(1.0f).setDuration(300L);
    }

    private void a(String str, String str2, String str3) {
        this.m.setText(str);
        ImageLoader.a(this.f15380a, str3).a(this.o);
        SpannableString spannableString = new SpannableString(String.format(getContext().getResources().getString(R.string.live_pk_dared_get_prop), str2));
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.syc_dark_FFB119)), 2, spannableString.length(), 17);
        this.n.setText(spannableString);
        this.f15381c.animate().alpha(0.0f).setDuration(300L);
        this.l.animate().alpha(1.0f).setDuration(300L);
    }

    private String b(int i) {
        if (i < 10000) {
            return String.valueOf(i);
        }
        return new DecimalFormat("#0.00w").format(i / 10000.0f);
    }

    private void d() {
        this.r.setVisibility(8);
        this.p.animate().alpha(1.0f).setDuration(300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e() {
        PkDaredObserver.a().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.b.setText(R.string.live_pk_dared_fight_egg);
        this.f.setText("");
        this.g.setText("");
        this.d.setProgress(0);
        this.e.setProgress(0);
        this.f15381c.setAlpha(1.0f);
        this.l.setAlpha(0.0f);
        this.p.setAlpha(0.0f);
    }

    public void a() {
        b();
        setVisibility(8);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredEggView$V1FhMSJNUB6_UX85C9NbGUn8wsg
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredEggView.this.f();
            }
        });
    }

    public void a(int i) {
        CountDownTimer countDownTimer = this.s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.s = null;
        }
        this.s = new CountDownTimer(1000 * i, 1000L) { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredEggView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                PkDaredEggView.this.b();
                LiveRoomHttpUtils.a(1);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(PkDaredEggView.this.k, "progress", PkDaredEggView.this.k.getProgress(), ((int) (Math.round(j / 1000.0d) - 1)) * 100);
                ofInt.setDuration(1000L);
                ofInt.setInterpolator(new LinearInterpolator());
                ofInt.start();
            }
        }.start();
    }

    public void a(int i, int i2) {
        if (this.d.getProgress() != i) {
            int progress = this.d.getProgress();
            if (progress < this.d.b) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this.d, "progress", progress, i);
                ofInt.setDuration(700L);
                ofInt.setInterpolator(new DecelerateInterpolator(1.5f));
                ofInt.start();
            }
            a(progress, i, this.f, this.h);
        }
        if (this.e.getProgress() != i2) {
            int progress2 = this.e.getProgress();
            if (progress2 < this.e.b) {
                ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this.e, "progress", progress2, i2);
                ofInt2.setDuration(700L);
                ofInt2.setInterpolator(new DecelerateInterpolator(1.5f));
                ofInt2.start();
            }
            a(progress2, i2, this.g, this.i);
        }
        if (this.f15380a != null) {
            if (i >= this.d.b || i2 >= this.e.b) {
                ImageLoader.c(this.f15380a, "live_pk_dared_egg.png").g().g(1).a(this.j);
            }
        }
    }

    public void a(final int i, final int i2, final int i3, final int i4, final int i5, IRequestHost iRequestHost) {
        this.f15380a = iRequestHost;
        setAlpha(0.0f);
        setVisibility(0);
        this.f15381c.setAlpha(1.0f);
        this.l.setAlpha(0.0f);
        this.p.setAlpha(0.0f);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredEggView$3gVXCocEAz9Tw9Ds1AbxJBRTrXY
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredEggView.this.a(i3, i, i2, i5, i4);
            }
        });
    }

    public void a(final int i, final String str, int i2, final String str2, final String str3, final int i3) {
        if (this.k.getProgress() == 0) {
            b(i, str, str2, str3, i3);
        } else {
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredEggView$EZv4CHBGJkQOFf_9XlOo2PfEWeI
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredEggView.this.b(i, str, str2, str3, i3);
                }
            }, 1000L);
        }
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_egg, this);
        this.b = (TextView) findViewById(R.id.tv_egg_title);
        this.f15381c = findViewById(R.id.rl_egg_fight_ing);
        this.d = (PkDaredEggProgressView) findViewById(R.id.pdep_our);
        this.e = (PkDaredEggProgressView) findViewById(R.id.pdep_opposite);
        this.f = (TextView) findViewById(R.id.tv_egg_score_our);
        this.g = (TextView) findViewById(R.id.tv_egg_score_opposite);
        this.j = (ImageView) findViewById(R.id.iv_egg_apng);
        this.k = (PkDaredEggProgressView) findViewById(R.id.pdep_egg_time_progress);
        this.l = findViewById(R.id.rl_egg_fight_win);
        this.m = (TextView) findViewById(R.id.tv_egg_win_nickname);
        this.n = (TextView) findViewById(R.id.tv_egg_win_prop_name);
        this.o = (ImageView) findViewById(R.id.iv_egg_prop_icon);
        this.p = findViewById(R.id.rl_egg_fight_lose);
        this.q = (TextView) findViewById(R.id.tv_lose_title);
        this.r = (TextView) findViewById(R.id.tv_lose_content);
        this.b.getPaint().setFakeBoldText(true);
        this.q.getPaint().setFakeBoldText(true);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.h = valueAnimator;
        valueAnimator.setDuration(500L);
        this.h.setInterpolator(new DecelerateInterpolator(1.5f));
        this.h.setEvaluator(null);
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.i = valueAnimator2;
        valueAnimator2.setDuration(500L);
        this.i.setInterpolator(new DecelerateInterpolator(1.5f));
        this.i.setEvaluator(null);
    }

    public void b() {
        CountDownTimer countDownTimer = this.s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.s = null;
        }
    }

    public void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "TranslationY", getTranslationY(), getHeight());
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AnticipateInterpolator(1.5f));
        ofFloat.start();
        animate().scaleX(0.8f).scaleY(0.8f).setDuration(450L).setStartDelay(50L).setInterpolator(new DecelerateInterpolator(1.5f));
    }

    public void setTargetScore(int i) {
        this.t = i;
        this.d.setProgressMax(i);
        this.e.setProgressMax(this.t);
        TextView textView = this.f;
        textView.setText(b(this.d.getProgress()) + BridgeUtil.SPLIT_MARK + b(i));
        TextView textView2 = this.g;
        textView2.setText(b(this.e.getProgress()) + BridgeUtil.SPLIT_MARK + b(i));
    }
}
