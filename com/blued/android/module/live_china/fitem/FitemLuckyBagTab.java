package com.blued.android.module.live_china.fitem;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemLuckyBagTab.class */
public final class FitemLuckyBagTab extends FreedomItem {
    private final int b;
    private final String c;
    private boolean d;
    private final boolean e;
    private boolean f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;

    public FitemLuckyBagTab(int i, String name, boolean z, boolean z2) {
        Intrinsics.e(name, "name");
        this.b = i;
        this.c = name;
        this.d = z;
        this.e = z2;
        this.g = 12.0f;
        this.h = 14.0f;
        this.k = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ConstraintLayout.LayoutParams tvParams, FitemLuckyBagTab this$0, TextView textView, ConstraintLayout.LayoutParams indicateParams, View view, DecelerateInterpolator interpolator, ValueAnimator animation) {
        Intrinsics.e(tvParams, "$tvParams");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(indicateParams, "$indicateParams");
        Intrinsics.e(interpolator, "$interpolator");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        float f = this$0.i;
        tvParams.bottomMargin = (int) (f + ((this$0.j - f) * floatValue));
        textView.setLayoutParams((ViewGroup.LayoutParams) tvParams);
        float f2 = this$0.g;
        textView.setTextSize(f2 + ((this$0.h - f2) * floatValue));
        float f3 = this$0.k;
        indicateParams.width = (int) (f3 + ((this$0.l - f3) * floatValue));
        view.setLayoutParams((ViewGroup.LayoutParams) indicateParams);
        float f4 = this$0.m;
        view.setTranslationY(f4 + ((this$0.n - f4) * interpolator.getInterpolation(floatValue)));
    }

    private final void h() {
        if (this.i == 0.0f) {
            this.i = DensityUtils.a(this.a.a.b, 7.0f);
            this.j = DensityUtils.a(this.a.a.b, 13.0f);
            this.l = DensityUtils.a(this.a.a.b, 14.0f);
            this.m = DensityUtils.a(this.a.a.b, 9.0f);
        }
    }

    private final void i() {
        if (this.a == null) {
            return;
        }
        final TextView textView = (TextView) this.a.a(R.id.tv_name);
        ConstraintLayout.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        final ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
        final View a = this.a.a(R.id.view_indicate);
        ConstraintLayout.LayoutParams layoutParams3 = a.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        final ConstraintLayout.LayoutParams layoutParams4 = layoutParams3;
        final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(1.5f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f ? 0.0f : 1.0f, this.f ? 1.0f : 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemLuckyBagTab$-PdoA5ZVJikUs9x2AAWF5GyOa1c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FitemLuckyBagTab.a(layoutParams2, this, textView, layoutParams4, a, decelerateInterpolator, valueAnimator);
            }
        });
        ofFloat.start();
        ObjectAnimator.ofArgb(textView, "TextColor", this.f ? ContextCompat.getColor(this.a.a.b, R.color.white) : ContextCompat.getColor(this.a.a.b, R.color.syc_dark_B542D7), this.f ? ContextCompat.getColor(this.a.a.b, R.color.syc_dark_B542D7) : ContextCompat.getColor(this.a.a.b, R.color.white)).setDuration(400L).start();
        textView.getPaint().setFakeBoldText(this.f);
        this.a.itemView.setElevation(this.f ? 1.0f : 0.0f);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_lucky_bag_tab;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        TextView textView = (TextView) this.a.a(R.id.tv_name);
        textView.setText(this.c);
        if (this.d) {
            vh.c(R.id.iv_tag, R.drawable.live_lucky_bag_tag_new);
        } else if (this.e) {
            vh.c(R.id.iv_tag, R.drawable.live_lucky_bag_tag_luck);
        } else {
            vh.c(R.id.iv_tag, R.color.transparent);
        }
        ConstraintLayout.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
        View a = this.a.a(R.id.view_indicate);
        ConstraintLayout.LayoutParams layoutParams3 = a.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams4 = layoutParams3;
        h();
        layoutParams2.bottomMargin = (int) (this.f ? this.j : this.i);
        textView.setLayoutParams((ViewGroup.LayoutParams) layoutParams2);
        textView.setTextSize(this.f ? this.h : this.g);
        textView.getPaint().setFakeBoldText(this.f);
        textView.setTextColor(ContextCompat.getColor(this.a.a.b, this.f ? R.color.syc_dark_B542D7 : R.color.white));
        layoutParams4.width = (int) (this.f ? this.l : this.k);
        a.setLayoutParams((ViewGroup.LayoutParams) layoutParams4);
        a.setTranslationY(this.f ? this.n : this.m);
        this.a.itemView.setElevation(this.f ? 1.0f : 0.0f);
    }

    public final void e() {
        if (this.f) {
            return;
        }
        this.f = true;
        i();
        if (this.d) {
            this.d = false;
            if (this.e) {
                BaseViewHolder baseViewHolder = this.a;
                if (baseViewHolder != null) {
                    baseViewHolder.c(R.id.iv_tag, R.drawable.live_lucky_bag_tag_luck);
                }
            } else {
                BaseViewHolder baseViewHolder2 = this.a;
                if (baseViewHolder2 != null) {
                    baseViewHolder2.c(R.id.iv_tag, R.color.transparent);
                }
            }
            LiveRoomHttpUtils.b(this.b);
        }
    }

    public final void f() {
        if (this.f) {
            this.f = false;
            i();
        }
    }

    public final int g() {
        if (this.a == null) {
            return 0;
        }
        return this.a.itemView.getLeft();
    }
}
