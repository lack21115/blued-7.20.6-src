package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.PopAnchorBadge;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopAnchorBadgeCenter.class */
public class PopAnchorBadgeCenter extends PopAnchorBadge {
    public PopAnchorBadgeCenter(Context context, String str, IRequestHost iRequestHost, PopAnchorBadge.DismissLisnter dismissLisnter) {
        super(context, str, iRequestHost, dismissLisnter);
    }

    public static void b(Context context, String str, String str2, String str3, PopAnchorBadge.DismissLisnter dismissLisnter, IRequestHost iRequestHost) {
        new PopAnchorBadgeCenter(context, str2, iRequestHost, dismissLisnter).a(str3, str);
    }

    @Override // com.blued.android.module.live_china.view.PopAnchorBadge
    public void a() {
        this.f14995a = this.e.inflate(R.layout.anchor_badge_center, (ViewGroup) null);
    }

    @Override // com.blued.android.module.live_china.view.PopAnchorBadge
    public View b() {
        return this.e.inflate(R.layout.item_anchor_badge_center, (ViewGroup) null);
    }

    @Override // com.blued.android.module.live_china.view.PopAnchorBadge
    public void c() {
        this.f14996c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopAnchorBadgeCenter.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PopAnchorBadgeCenter.this.d();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(alphaAnimation);
    }

    @Override // com.blued.android.module.live_china.view.PopAnchorBadge
    public void f() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f14996c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
    }
}
