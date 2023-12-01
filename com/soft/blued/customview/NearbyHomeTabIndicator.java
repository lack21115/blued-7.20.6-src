package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.badge.BadgeDrawable;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/NearbyHomeTabIndicator.class */
public class NearbyHomeTabIndicator extends TabPageIndicatorWithDot {
    private LayoutInflater G;

    public NearbyHomeTabIndicator(Context context) {
        this(context, null);
    }

    public NearbyHomeTabIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyHomeTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, View view) {
        Tracker.onClick(view);
        this.e.setCurrentItem(i);
        if (this.F != null) {
            this.F.onClick(i);
        }
    }

    @Override // com.soft.blued.customview.TabPageIndicatorWithDot
    protected View a(ViewGroup viewGroup) {
        return viewGroup.findViewById(R.id.item_nearby_tab_indicator_tv);
    }

    @Override // com.soft.blued.customview.TabPageIndicatorWithDot
    public void a() {
        super.a();
        this.G = LayoutInflater.from(this.f14830a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.customview.TabPageIndicatorWithDot
    public void a(int i) {
        super.a(i);
    }

    @Override // com.soft.blued.customview.TabPageIndicatorWithDot
    protected void a(final int i, String str) {
        QBadgeContainer inflate = this.G.inflate(R.layout.item_nearby_tab_indicator, (ViewGroup) null);
        View findViewById = inflate.findViewById(2131367999);
        findViewById.setTag(str + i);
        TextView textView = (TextView) inflate.findViewById((int) R.id.item_nearby_tab_indicator_tv);
        textView.setTextSize(0, this.w);
        textView.setText(str);
        int min = Math.min((int) (textView.getPaint().measureText(str) + 0.5f), FeedMethods.c(110));
        View findViewById2 = inflate.findViewById((int) R.id.item_nearby_tab_indicator_content_ly);
        ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
        layoutParams.width = min + FeedMethods.c(25);
        findViewById2.setLayoutParams(layoutParams);
        if (this.C != null) {
            this.C.add(textView);
        }
        View view = (ShapeTextView) inflate.findViewById((int) R.id.item_nearby_tab_indicator_dot);
        view.setVisibility(8);
        if (this.D != null) {
            this.D.add(view);
        }
        inflate.b(BluedSkinUtils.a(this.f14830a, 2131102251));
        inflate.d((int) BadgeDrawable.TOP_END);
        inflate.b(5.0f, true);
        inflate.a(10.0f, true);
        inflate.a(3.0f, 0.0f, true);
        inflate.a("");
        if (this.E != null) {
            this.E.add(inflate);
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$NearbyHomeTabIndicator$FIO7Kh8HZuDW3FV4tc-W0B5X1NA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NearbyHomeTabIndicator.this.a(i, view2);
            }
        });
        this.d.addView(inflate);
    }

    public void a(int i, String str, int i2) {
        if (this.E == null || i < 0 || i >= this.E.size()) {
            return;
        }
        ImageView imageView = (ImageView) this.E.get(i).findViewById((int) R.id.item_nearby_tab_indicator_avatar);
        final TextView textView = (TextView) this.E.get(i).findViewById((int) R.id.item_nearby_tab_indicator_tv);
        if (imageView == null || textView == null) {
            return;
        }
        imageView.setVisibility(0);
        ImageLoader.a((IRequestHost) null, str).b(2131237310).a(i2).a(imageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationX", FeedMethods.c(-22), 0.0f);
        ofFloat.setDuration(300L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(300L);
        ofFloat.start();
        ofFloat2.start();
        textView.setAlpha(1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(textView, "translationX", FeedMethods.c(21));
        ofFloat3.setDuration(300L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(textView, "alpha", 1.0f, 0.0f);
        ofFloat4.setDuration(300L);
        ofFloat4.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.customview.NearbyHomeTabIndicator.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                textView.setAlpha(1.0f);
                textView.setTranslationX(0.0f);
                textView.setVisibility(4);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat3.start();
        ofFloat4.start();
    }

    @Override // com.soft.blued.customview.TabPageIndicatorWithDot
    public void b(int i) {
        if (this.D == null || i < 0 || i >= this.D.size()) {
            return;
        }
        this.D.get(i).setVisibility(0);
    }

    @Override // com.soft.blued.customview.TabPageIndicatorWithDot
    public void c(int i) {
        if (this.D == null || i < 0 || i >= this.D.size()) {
            return;
        }
        this.D.get(i).setVisibility(8);
    }

    public void d(int i) {
        if (this.E == null || i < 0 || i >= this.E.size()) {
            return;
        }
        final ImageView imageView = (ImageView) this.E.get(i).findViewById((int) R.id.item_nearby_tab_indicator_avatar);
        TextView textView = (TextView) this.E.get(i).findViewById((int) R.id.item_nearby_tab_indicator_tv);
        if (imageView == null || textView == null || textView.getVisibility() == 0) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(250L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.customview.NearbyHomeTabIndicator.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                imageView.setVisibility(4);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
        textView.setVisibility(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(250L);
        ofFloat2.start();
    }
}
