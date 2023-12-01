package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.r.g;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.bm;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/widget/KsAuthorIconView.class */
public class KsAuthorIconView extends FrameLayout implements bm.a {
    private ViewGroup Am;
    private KSCornerImageView An;
    private KSCornerImageView Ao;
    private KSCornerImageView Ap;
    private TextView Aq;
    private View Ar;
    private View As;
    private ImageView At;
    private View Au;
    private View Av;
    private View Aw;
    private View Ax;
    private final bm gK;
    private KSCornerImageView yX;

    public KsAuthorIconView(Context context) {
        super(context);
        this.gK = new bm(this);
        Q(context);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gK = new bm(this);
        Q(context);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gK = new bm(this);
        Q(context);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.gK = new bm(this);
        Q(context);
    }

    private void Q(Context context) {
        k.inflate(context, R.layout.ksad_author_icon, this);
        this.Am = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.yX = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.An = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.Ao = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.Ap = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.Aq = (TextView) findViewById(R.id.ksad_fans_count);
        this.As = findViewById(R.id.ksad_fans_hot_icon);
        this.Ar = findViewById(R.id.ksad_author_btn_follow);
        this.At = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.Av = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.Au = findViewById(R.id.ksad_top_layout);
        this.Ax = findViewById(R.id.ksad_author_icon_layout);
        this.Aw = findViewById(R.id.ksad_top_flag_layout);
    }

    private Animator a(View view, long j) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_icon_width));
        ofFloat.addUpdateListener(f(view, false));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(create);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private void a(e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), eVar.rB());
        }
    }

    private static Animator e(View view, boolean z) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f = 0.9f * width;
        b.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f);
        ofFloat.addUpdateListener(f(view, false));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f, width);
        ofFloat2.addUpdateListener(f(view, false));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private static ValueAnimator.AnimatorUpdateListener f(final View view, final boolean z) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.width = i;
                    if (!z) {
                        layoutParams.height = i;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    private static Animator i(View view, int i) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(create);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(create2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        b.d("KsAuthorIconView", "handleMsg MSG_CHECKING");
        final Animator a2 = a(this.Ao, 900L);
        final Animator a3 = a(this.Ap, 1000L);
        final Animator e = e(this.yX, false);
        final Animator i = i(this.Au, 500);
        if (i == null || a2 == null || a3 == null || e == null) {
            this.gK.sendEmptyMessageDelayed(1, 500L);
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(e, a2, a3);
        animatorSet.start();
        e.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a2.start();
                a3.start();
                e.start();
                i.start();
            }
        });
    }

    public final void a(e eVar) {
        g.a(eVar, this);
        this.At.setImageResource(R.drawable.ksad_reward_follow_arrow_down);
        a(eVar, this.Ao.getBackground());
        a(eVar, this.An.getBackground());
        a(eVar, this.Ap.getBackground());
        a(eVar, this.Am.getBackground());
    }

    public final void bindView(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        String bM = a.bM(cb);
        if (!TextUtils.isEmpty(bM)) {
            KSImageLoader.loadImage(this.yX, bM, adTemplate);
        }
        int aX = a.aX(cb);
        if (a.cq(d.cb(adTemplate))) {
            this.Aq.setText("直播中");
            this.As.setVisibility(8);
            this.Ar.setVisibility(8);
            if (aX == 8) {
                this.Aw.setVisibility(8);
                this.At.setVisibility(8);
                this.Av.setVisibility(0);
            } else {
                this.Av.setVisibility(8);
                this.At.setVisibility(0);
                this.Av.setVisibility(8);
            }
        } else {
            this.Aq.setText(a.cl(cb));
        }
        this.gK.sendEmptyMessageAtTime(1, 500L);
    }
}
