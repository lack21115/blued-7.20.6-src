package com.blued.android.module.live_china.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveDotModel;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKRoundDotView.class */
public class LivePKRoundDotView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    Runnable f14804a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f14805c;
    private boolean d;

    public LivePKRoundDotView(Context context) {
        this(context, null);
    }

    public LivePKRoundDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.f14804a = new Runnable() { // from class: com.blued.android.module.live_china.view.LivePKRoundDotView.1
            @Override // java.lang.Runnable
            public void run() {
                LivePKRoundDotView.this.setVisibility(0);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKRoundDotView.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LivePKRoundDotView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.setDuration(300L);
                ofFloat.start();
            }
        };
        b();
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(LiveDotModel liveDotModel, ImageView imageView) {
        if (liveDotModel == null) {
            imageView.setImageResource(R.drawable.live_pk_round_dot);
        } else if (liveDotModel.win == 1) {
            imageView.setImageResource(R.drawable.live_pk_round_dot_green);
        } else if (liveDotModel.win == 2 || liveDotModel.win == 3) {
            imageView.setImageResource(R.drawable.live_pk_round_dot_red);
        } else {
            imageView.setImageResource(R.drawable.live_pk_round_dot);
        }
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_dot_view, this);
        this.b = (LinearLayout) findViewById(R.id.ll_left);
        this.f14805c = (LinearLayout) findViewById(R.id.ll_right);
        setVisibility(8);
        c();
    }

    private void c() {
        this.b.removeAllViews();
        this.f14805c.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return;
            }
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_dot_item_view, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(getContext(), 16.0f), a(getContext(), 16.0f));
            layoutParams.rightMargin = a(getContext(), 6.0f);
            layoutParams.gravity = 16;
            this.b.addView(inflate, layoutParams);
            View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.live_pk_round_dot_item_view, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = a(getContext(), 6.0f);
            layoutParams2.gravity = 16;
            this.f14805c.addView(inflate2, layoutParams2);
            i = i2 + 1;
        }
    }

    private void setLeftData(List<LiveDotModel> list) {
        int childCount = this.b.getChildCount();
        if (list == null || list.size() != childCount) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            a(list.get(i2), (ImageView) this.b.getChildAt(i2).findViewById(R.id.iv_dot));
            i = i2 + 1;
        }
    }

    private void setRightData(List<LiveDotModel> list) {
        int childCount = this.f14805c.getChildCount();
        if (list == null || list.size() != childCount) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            a(list.get(i2), (ImageView) this.f14805c.getChildAt(i2).findViewById(R.id.iv_dot));
            i = i2 + 1;
        }
    }

    public void a() {
        removeCallbacks(this.f14804a);
        if (getVisibility() == 0) {
            setVisibility(8);
        }
    }

    public void a(List<LiveDotModel> list, List<LiveDotModel> list2) {
        setVisibility(8);
        setLeftData(list);
        setRightData(list2);
        postDelayed(this.f14804a, 600L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }
}
