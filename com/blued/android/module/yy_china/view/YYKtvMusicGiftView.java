package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewKtvGiftProBinding;
import com.blued.android.module.yy_china.view.YYKtvPro2View;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYKtvMusicGiftView.class */
public final class YYKtvMusicGiftView extends FrameLayout implements YYKtvPro2View.OnKtvProChangeNumHeightListening {

    /* renamed from: a  reason: collision with root package name */
    private ViewKtvGiftProBinding f18270a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f18271c;
    private ArrayList<Integer> d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYKtvMusicGiftView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYKtvMusicGiftView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYKtvMusicGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewKtvGiftProBinding a2 = ViewKtvGiftProBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(\n            Lay…ontext), this, true\n    )");
        this.f18270a = a2;
        a2.e.setOnKtvProChangeNumHeightListening(this);
        this.f18271c = "0";
        this.d = CollectionsKt.d(Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_0), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_1), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_2), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_3), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_4), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_5), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_6), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_7), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_8), Integer.valueOf(R.drawable.yy_icon_ktv_gift_up_9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvMusicGiftView this$0, float f) {
        Intrinsics.e(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.f18270a.f16861c.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        this$0.f18270a.getRoot().removeView(this$0.f18270a.f16861c);
        layoutParams2.topMargin = this$0.getResources().getDimensionPixelSize(R.dimen.dp_16) + ((int) f);
        this$0.f18270a.getRoot().addView(this$0.f18270a.f16861c, layoutParams2);
    }

    private final void setProgress(int i) {
        int currentProgress = getCurrentProgress() + i;
        this.f18270a.f16861c.setText(CommonStringUtils.b(currentProgress));
        if (currentProgress <= getMaxProgressBar()) {
            this.f18270a.e.setPro(currentProgress);
            return;
        }
        setNum(String.valueOf(currentProgress));
        this.f18270a.e.setPro(getMaxProgressBar());
    }

    @Override // com.blued.android.module.yy_china.view.YYKtvPro2View.OnKtvProChangeNumHeightListening
    public void a(final float f) {
        post(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYKtvMusicGiftView$rlcM4ZTZpx_qlXT_EeR4gI64JIg
            @Override // java.lang.Runnable
            public final void run() {
                YYKtvMusicGiftView.a(YYKtvMusicGiftView.this, f);
            }
        });
    }

    public final void a(int i) {
        this.f18270a.b.setText(Intrinsics.a("+", (Object) Integer.valueOf(i)));
        setProgress(i);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18270a.b, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f18270a.b, "translationY", 80.0f, -10.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(800L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.yy_china.view.YYKtvMusicGiftView$addProgressWithAnimation$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int i2;
                int i3;
                YYKtvMusicGiftView.this.getBinding().b.setAlpha(0.0f);
                YYKtvMusicGiftView yYKtvMusicGiftView = YYKtvMusicGiftView.this;
                i2 = yYKtvMusicGiftView.b;
                yYKtvMusicGiftView.b = i2 - 1;
                i3 = YYKtvMusicGiftView.this.b;
                if (i3 <= 0) {
                    YYKtvMusicGiftView.this.getBinding().f16861c.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                int i2;
                YYKtvMusicGiftView yYKtvMusicGiftView = YYKtvMusicGiftView.this;
                i2 = yYKtvMusicGiftView.b;
                yYKtvMusicGiftView.b = i2 + 1;
                YYKtvMusicGiftView.this.getBinding().f16861c.setAlpha(0.0f);
            }
        });
        animatorSet.start();
    }

    public final boolean a() {
        return this.f18270a.e.getPro() >= this.f18270a.e.getMaxPro();
    }

    public final void b() {
        this.f18270a.d.removeAllViews();
        this.f18270a.e.setMaxPro(100);
        this.f18270a.e.setPro(0);
        this.f18270a.f16861c.setText("0");
        this.b = 0;
    }

    public final void b(int i) {
        this.f18270a.f16861c.setText(String.valueOf(i));
        if (i <= getMaxProgressBar()) {
            this.f18270a.e.setPro(i);
            return;
        }
        setNum(String.valueOf(i));
        this.f18270a.e.setPro(getMaxProgressBar());
    }

    public final ViewKtvGiftProBinding getBinding() {
        return this.f18270a;
    }

    public final int getCurrentProgress() {
        return a() ? getMaxProgressBar() : this.f18270a.e.getPro();
    }

    public final ArrayList<Integer> getIms() {
        return this.d;
    }

    public final int getMaxProgressBar() {
        return StringUtils.a(this.f18271c, 0);
    }

    public final String getNumStr() {
        return this.f18271c;
    }

    public final void setBinding(ViewKtvGiftProBinding viewKtvGiftProBinding) {
        Intrinsics.e(viewKtvGiftProBinding, "<set-?>");
        this.f18270a = viewKtvGiftProBinding;
    }

    public final void setIms(ArrayList<Integer> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.d = arrayList;
    }

    public final void setMaxGiftBar(int i) {
        this.f18270a.e.setMaxPro(i);
        setNum(String.valueOf(i));
    }

    public final void setNum(String num) {
        Intrinsics.e(num, "num");
        this.f18271c = num;
        this.f18270a.d.removeAllViews();
        int length = num.length();
        int i = 0;
        while (i < length) {
            char charAt = num.charAt(i);
            i++;
            ImageView imageView = new ImageView(getContext());
            Integer num2 = this.d.get(CommonStringUtils.a(String.valueOf(charAt), 0));
            Intrinsics.c(num2, "ims[CommonStringUtils.St…oInteger(i.toString(),0)]");
            imageView.setImageResource(num2.intValue());
            this.f18270a.d.addView(imageView);
        }
    }

    public final void setNumStr(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f18271c = str;
    }
}
