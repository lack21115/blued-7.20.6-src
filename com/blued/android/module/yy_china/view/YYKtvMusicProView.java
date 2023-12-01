package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewKtvMusicProBinding;
import com.blued.android.module.yy_china.utils.YYResourcesUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYKtvMusicProView.class */
public final class YYKtvMusicProView extends FrameLayout {
    private String a;
    private ViewKtvMusicProBinding b;
    private int c;
    private final int[] d;
    private final int[] e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYKtvMusicProView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYKtvMusicProView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYKtvMusicProView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = "YYKtvMusicProView";
        ViewKtvMusicProBinding a = ViewKtvMusicProBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.b = a;
        this.c = -1;
        this.d = new int[]{R.drawable.yy_ktv_style_1, R.drawable.yy_ktv_style_2, R.drawable.yy_ktv_style_3, R.drawable.yy_ktv_style_4};
        this.e = new int[]{R.color.white, R.color.white, R.color.white, R.color.white};
    }

    private final void b(int i) {
        LogUtils.d(this.a, Intrinsics.a("level: ", (Object) Integer.valueOf(i)));
        this.b.c.setImageResource(YYResourcesUtils.a.a(i));
    }

    private final void b(int i, int i2) {
        int i3 = (i >= this.d.length || i < 0) ? 0 : i;
        this.c = i3;
        this.b.a.setImageResource(this.d[i3]);
        this.b.g.setText(Intrinsics.a("x ", (Object) Integer.valueOf(i2)));
        this.b.h.setText(Intrinsics.a("x ", (Object) Integer.valueOf(i2)));
        if (i == this.d.length - 1) {
            ImageLoader.c(null, "icon_ktv_perfect.png").f().g(1).a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.yy_china.view.YYKtvMusicProView$addStyleAni$1
                @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                public void a() {
                    ViewKtvMusicProBinding viewKtvMusicProBinding;
                    viewKtvMusicProBinding = YYKtvMusicProView.this.b;
                    viewKtvMusicProBinding.e.setAlpha(1.0f);
                }

                @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                public void b() {
                    ViewKtvMusicProBinding viewKtvMusicProBinding;
                    viewKtvMusicProBinding = YYKtvMusicProView.this.b;
                    viewKtvMusicProBinding.e.setAlpha(0.0f);
                }
            }).a(this.b.b);
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b.d, "scaleX", 1.0f, 0.0f).setDuration(100L);
        Intrinsics.c(duration, "ofFloat(binding.llKtvMes…f, 0.0f).setDuration(100)");
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.b.d, "scaleY", 1.0f, 0.0f).setDuration(100L);
        Intrinsics.c(duration2, "ofFloat(binding.llKtvMes…f, 0.0f).setDuration(100)");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.b.d, "scaleX", 0.0f, 1.0f).setDuration(800L);
        Intrinsics.c(duration3, "ofFloat(binding.llKtvMes…f, 1.0f).setDuration(800)");
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(this.b.d, "scaleY", 0.0f, 1.0f).setDuration(800L);
        Intrinsics.c(duration4, "ofFloat(binding.llKtvMes…f, 1.0f).setDuration(800)");
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration3, duration4);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(this.b.d, "alpha", 0.0f, 1.0f).setDuration(800L);
        Intrinsics.c(duration5, "ofFloat(binding.llKtvMes…f, 1.0f).setDuration(800)");
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(this.b.d, "alpha", 1.0f, 0.0f).setDuration(100L);
        Intrinsics.c(duration6, "ofFloat(binding.llKtvMes…f, 0.0f).setDuration(100)");
        AnimatorSet animatorSet3 = new AnimatorSet();
        AnimatorSet animatorSet4 = new AnimatorSet();
        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet4.playTogether(duration5, animatorSet2);
        animatorSet5.play(animatorSet4).after(animatorSet);
        animatorSet3.play(duration6).after(1300L).after(animatorSet5);
        animatorSet3.start();
    }

    public final void a() {
        this.b.i.setMaxPro(100);
        this.b.i.setPro(0);
        this.b.c.setImageResource(R.color.transparent);
        this.c = -1;
    }

    public final void a(int i) {
        YYKtvPro2View yYKtvPro2View = this.b.i;
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        yYKtvPro2View.setPro(i2);
    }

    public final void a(int i, int i2) {
        this.b.f.setText(Intrinsics.a("+", (Object) Integer.valueOf(i)));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b.f, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b.f, "translationY", 80.0f, -10.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(800L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.view.YYKtvMusicProView$addProgressWithAnimation$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewKtvMusicProBinding viewKtvMusicProBinding;
                viewKtvMusicProBinding = YYKtvMusicProView.this.b;
                viewKtvMusicProBinding.f.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
        int pro = this.b.i.getPro();
        LogUtils.d(this.a, Intrinsics.a("progress bar current length: ", (Object) Integer.valueOf(pro)));
        if (pro < getMaxProgressBar()) {
            this.b.i.setPro(pro + i);
        }
        b(i >= 90 ? 3 : i >= 80 ? 2 : i >= 70 ? 1 : 0, i2);
    }

    public final boolean b() {
        return this.b.i.getMaxPro() == this.b.i.getPro();
    }

    public final int getCurrentProgress() {
        return this.b.i.getPro();
    }

    public final int getMaxProgressBar() {
        return this.b.i.getMaxPro();
    }

    public final void setKtvLeve(int i) {
        LogUtils.d(this.a, Intrinsics.a("averageScore: ", (Object) Integer.valueOf(i)));
        b(i);
    }

    public final void setMaxProgress(int i) {
        LogUtils.d(this.a, Intrinsics.a("progress bar max length: ", (Object) Integer.valueOf(i)));
        this.b.i.setMaxPro(i);
    }
}
