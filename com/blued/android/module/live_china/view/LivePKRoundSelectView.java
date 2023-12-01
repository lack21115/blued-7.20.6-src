package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.CircleProgressView;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundSelectView.class */
public class LivePKRoundSelectView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public OnEventCallbck f14808a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f14809c;
    private View d;
    private ImageView e;
    private ImageView f;
    private boolean g;
    private CircleProgressView h;
    private TextView i;
    private CountDownTimer j;
    private ActivityFragmentActive k;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundSelectView$OnEventCallbck.class */
    public interface OnEventCallbck {
        void a();

        void a(int i);
    }

    public LivePKRoundSelectView(Context context) {
        this(context, null);
    }

    public LivePKRoundSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = true;
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_select_view, this);
        this.d = findViewById(R.id.tv_confirm);
        this.b = findViewById(R.id.sl_one);
        this.f14809c = findViewById(R.id.sl_three);
        this.e = (ImageView) findViewById(R.id.iv_one_checked);
        this.f = (ImageView) findViewById(R.id.iv_three_checked);
        this.i = (TextView) findViewById(R.id.tv_progress);
        CircleProgressView circleProgressView = (CircleProgressView) findViewById(R.id.circle_view);
        this.h = circleProgressView;
        circleProgressView.setBarColor(getResources().getColor(R.color.syc_dark_fac905));
        this.h.setRimWidth(DensityUtils.a(getContext(), 2.5f));
        this.h.setRimColor(getResources().getColor(R.color.syc_dark_f5f5f5));
        this.h.setBarWidth(DensityUtils.a(getContext(), 2.5f));
        this.h.setBarStrokeCap(Paint.Cap.ROUND);
        this.h.setShowPercentAsAutoValue(false);
        this.h.setValue(100.0f);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundSelectView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LivePKRoundSelectView.this.g = true;
                LivePKRoundSelectView.this.e.setImageResource(LivePKRoundSelectView.this.g ? R.drawable.live_pk_round_checked : R.drawable.live_pk_round_unchecked);
                LivePKRoundSelectView.this.f.setImageResource(LivePKRoundSelectView.this.g ? R.drawable.live_pk_round_unchecked : R.drawable.live_pk_round_checked);
            }
        });
        this.f14809c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundSelectView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LivePKRoundSelectView.this.g = false;
                LivePKRoundSelectView.this.e.setImageResource(LivePKRoundSelectView.this.g ? R.drawable.live_pk_round_checked : R.drawable.live_pk_round_unchecked);
                LivePKRoundSelectView.this.f.setImageResource(LivePKRoundSelectView.this.g ? R.drawable.live_pk_round_unchecked : R.drawable.live_pk_round_checked);
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundSelectView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (LivePKRoundSelectView.this.f14808a != null) {
                    LivePKRoundSelectView.this.f14808a.a(!LivePKRoundSelectView.this.g ? 1 : 0);
                }
            }
        });
    }

    public void a() {
        CountDownTimer countDownTimer = this.j;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void a(long j) {
        CountDownTimer countDownTimer = new CountDownTimer(j * 1000, 1000L) { // from class: com.blued.android.module.live_china.view.LivePKRoundSelectView.4
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (LivePKRoundSelectView.this.f14808a != null) {
                    LivePKRoundSelectView.this.f14808a.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                TextView textView = LivePKRoundSelectView.this.i;
                textView.setText(((j2 / 1000) + 1) + "s");
            }
        };
        this.j = countDownTimer;
        countDownTimer.start();
    }

    public void a(ActivityFragmentActive activityFragmentActive, OnEventCallbck onEventCallbck) {
        this.k = activityFragmentActive;
        this.f14808a = onEventCallbck;
    }

    public void b(final long j) {
        setVisibility(8);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        clearAnimation();
        startAnimation(scaleAnimation);
        setVisibility(0);
        this.h.setValue(100.0f);
        this.h.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKRoundSelectView.5
            @Override // java.lang.Runnable
            public void run() {
                LivePKRoundSelectView.this.h.a(0.0f, j * 1000);
            }
        }, 500L);
        a(j);
    }
}
