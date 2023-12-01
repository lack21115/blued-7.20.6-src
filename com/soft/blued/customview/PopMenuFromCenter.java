package com.soft.blued.customview;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module_share_china.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PopMenuFromCenter.class */
public class PopMenuFromCenter extends PopMenuFromBottom {
    public DismissListner h;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PopMenuFromCenter$DismissListner.class */
    public interface DismissListner {
        void dissmiss(boolean z);
    }

    public PopMenuFromCenter(Context context, View view) {
        super(context, view);
    }

    public void a(DismissListner dismissListner) {
        this.h = dismissListner;
    }

    public void a(final boolean z) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f28469c.setVisibility(8);
        this.f28469c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.customview.PopMenuFromCenter.1
            @Override // java.lang.Runnable
            public void run() {
                PopMenuFromCenter.this.e.a();
                if (PopMenuFromCenter.this.h != null) {
                    PopMenuFromCenter.this.h.dissmiss(z);
                }
            }
        }, 320L);
    }

    @Override // com.soft.blued.customview.PopMenuFromBottom, com.soft.blued.customview.PopMenu
    public RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        return layoutParams;
    }

    @Override // com.soft.blued.customview.PopMenuFromBottom, com.soft.blued.customview.PopMenu
    public void d() {
        a(false);
    }

    @Override // com.soft.blued.customview.PopMenuFromBottom
    public void e() {
        this.b.clearAnimation();
        this.f28469c.clearAnimation();
        if (this.e.isShowing()) {
            this.e.a();
        }
        this.e.showAtLocation(this.b, 17, 0, 0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(400L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f28469c.setVisibility(0);
        this.f28469c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
    }
}
