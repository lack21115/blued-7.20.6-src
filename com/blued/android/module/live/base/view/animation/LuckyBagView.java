package com.blued.android.module.live.base.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.view.animation.LuckyBagView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/LuckyBagView.class */
public class LuckyBagView extends BaseLiveAnimationView {
    private Context b;
    private String c;
    private String d;
    private LayoutInflater e;
    private View f;
    private View g;
    private ImageView h;
    private ImageView i;
    private LinearInterpolator j = new LinearInterpolator();
    private float k = 1.1f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live.base.view.animation.LuckyBagView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/animation/LuckyBagView$1.class */
    public class AnonymousClass1 extends ImageLoadResult {
        AnonymousClass1(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            LuckyBagView.this.c();
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a() {
            super.a();
            LuckyBagView.this.f.post(new Runnable() { // from class: com.blued.android.module.live.base.view.animation.-$$Lambda$LuckyBagView$1$DZCJuKPw_vztW0NUSGEqctZMrQ8
                @Override // java.lang.Runnable
                public final void run() {
                    LuckyBagView.AnonymousClass1.this.d();
                }
            });
        }
    }

    public LuckyBagView(Context context) {
        this.b = context;
        b();
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.e = from;
        View inflate = from.inflate(R.layout.layout_lucky_bag_anim, (ViewGroup) null);
        this.f = inflate;
        this.g = inflate.findViewById(R.id.sl_lucky_bag_bg);
        this.h = (ImageView) this.f.findViewById(R.id.iv_lucky_bag);
        this.i = (ImageView) this.f.findViewById(R.id.iv_gift);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        View view = this.g;
        view.setPivotY(view.getHeight() / 2);
        ImageView imageView = this.h;
        imageView.setPivotX(imageView.getWidth() / 2);
        ImageView imageView2 = this.h;
        imageView2.setPivotY(imageView2.getHeight() / 2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(d()).with(g()).with(h());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live.base.view.animation.LuckyBagView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (LuckyBagView.this.a != null) {
                    LuckyBagView.this.a.b();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (LuckyBagView.this.a != null) {
                    LuckyBagView.this.a.a();
                }
            }
        });
        animatorSet.start();
    }

    private AnimatorSet d() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(e()).with(f());
        return animatorSet;
    }

    private AnimatorSet e() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h, "Alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.j);
        ofFloat.setDuration(this.k * 330.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.h, "ScaleX", 0.0f, 1.0f);
        ofFloat2.setInterpolator(this.j);
        ofFloat2.setDuration(this.k * 330.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.h, "ScaleY", 0.0f, 1.0f);
        ofFloat3.setInterpolator(this.j);
        ofFloat3.setDuration(this.k * 330.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.h, "TranslationY", this.h.getTranslationY() + (this.h.getHeight() * 0.017f), this.h.getTranslationY());
        ofFloat4.setInterpolator(this.j);
        ofFloat4.setDuration(this.k * 150.0f);
        ofFloat4.setStartDelay(this.k * 180.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        return animatorSet;
    }

    private AnimatorSet f() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h, "ScaleY", 1.0f, 0.87f, 1.0f);
        ofFloat.setInterpolator(this.j);
        ofFloat.setDuration(this.k * 240.0f);
        ofFloat.setStartDelay(this.k * 600.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.h, "Rotation", 0.0f, 10.0f, -5.0f, 10.0f, -5.0f, 0.0f);
        ofFloat2.setInterpolator(this.j);
        ofFloat2.setDuration(this.k * 600.0f);
        ofFloat2.setStartDelay(this.k * 600.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.h, "ScaleY", 1.0f, 0.87f);
        ofFloat3.setInterpolator(this.j);
        ofFloat3.setDuration(this.k * 90.0f);
        ofFloat3.setStartDelay(this.k * 1800.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.h, "Alpha", 1.0f, 0.0f);
        ofFloat4.setInterpolator(this.j);
        ofFloat4.setDuration(this.k * 360.0f);
        ofFloat4.setStartDelay(this.k * 1800.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        return animatorSet;
    }

    private AnimatorSet g() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.g, "Alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.j);
        ofFloat.setDuration(this.k * 180.0f);
        ofFloat.setStartDelay(this.k * 1890.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.g, "ScaleX", 0.63f, 1.16f);
        ofFloat2.setInterpolator(this.j);
        ofFloat2.setDuration(this.k * 180.0f);
        ofFloat2.setStartDelay(this.k * 1890.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.g, "ScaleY", 0.63f, 1.16f);
        ofFloat3.setInterpolator(this.j);
        ofFloat3.setDuration(this.k * 180.0f);
        ofFloat3.setStartDelay(this.k * 1890.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.g, "Rotation", 0.0f, 10.0f);
        ofFloat4.setInterpolator(this.j);
        ofFloat4.setDuration(this.k * 1140.0f);
        ofFloat4.setStartDelay(this.k * 1890.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        return animatorSet;
    }

    private AnimatorSet h() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i, "Alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.j);
        ofFloat.setDuration(1L);
        ofFloat.setStartDelay(this.k * 1920.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.i, "ScaleX", 0.0f, 1.0f);
        ofFloat2.setInterpolator(this.j);
        ofFloat2.setDuration(this.k * 150.0f);
        ofFloat2.setStartDelay(this.k * 1920.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.i, "ScaleY", 0.0f, 1.0f);
        ofFloat3.setInterpolator(this.j);
        ofFloat3.setDuration(this.k * 150.0f);
        ofFloat3.setStartDelay(this.k * 1920.0f);
        float translationY = this.i.getTranslationY();
        float translationY2 = this.i.getTranslationY() + (this.i.getHeight() * 0.01f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.i, "TranslationY", translationY, translationY2);
        ofFloat4.setInterpolator(this.j);
        ofFloat4.setDuration(this.k * 150.0f);
        ofFloat4.setStartDelay(this.k * 1920.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.i, "TranslationY", translationY2, translationY);
        ofFloat5.setInterpolator(this.j);
        ofFloat5.setDuration(this.k * 90.0f);
        ofFloat5.setStartDelay(this.k * 2070.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5);
        return animatorSet;
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public View a() {
        return this.f;
    }

    @Override // com.blued.android.module.live.base.view.animation.BaseLiveAnimationView
    public void a(IRequestHost iRequestHost) {
        this.g.setAlpha(0.0f);
        this.h.setAlpha(0.0f);
        this.i.setAlpha(0.0f);
        if (!TextUtils.isEmpty(this.d)) {
            ImageLoader.a((IRequestHost) null, this.d).b(R.drawable.user_bg_round).a(this.h);
        }
        ImageLoader.a((IRequestHost) null, this.c).a(new AnonymousClass1(null)).a(this.i);
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.d = str;
    }
}
