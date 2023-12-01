package com.soft.blued.customview;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.blued.android.core.AppInfo;
import com.blued.android.module_share_china.R;
import com.soft.blued.customview.PopMenu;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/PopMenuFromBottom.class */
public class PopMenuFromBottom extends PopMenu {
    private Float h;

    public PopMenuFromBottom(Context context, View view) {
        super(context, view);
        this.h = Float.valueOf(0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if ((this.d instanceof ComponentActivity) && ((ComponentActivity) this.d).getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        this.e.a();
    }

    @Override // com.soft.blued.customview.PopMenu
    public void a(View view) {
        if ((this.d instanceof FragmentActivity) && ((FragmentActivity) this.d).getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        this.b.clearAnimation();
        this.f28469c.clearAnimation();
        if (this.e.isShowing()) {
            this.e.a();
        }
        PopMenu.MyPopupWindow myPopupWindow = this.e;
        View view2 = view;
        if (view == null) {
            view2 = this.b;
        }
        myPopupWindow.showAtLocation(view2, 81, 0, 0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, this.h.floatValue());
        alphaAnimation.setDuration(400L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f28469c.setVisibility(0);
        this.f28469c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.pop_down_in));
    }

    @Override // com.soft.blued.customview.PopMenu
    public RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.soft.blued.customview.PopMenu
    public int c() {
        return 0;
    }

    @Override // com.soft.blued.customview.PopMenu
    public void d() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(this.h.floatValue(), 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.f28469c.setVisibility(8);
        this.f28469c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.pop_down_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.customview.-$$Lambda$PopMenuFromBottom$IK6A8-otKZI1uiQf1nO_j7GTL-8
            @Override // java.lang.Runnable
            public final void run() {
                PopMenuFromBottom.this.f();
            }
        }, 320L);
    }

    public void e() {
        a((View) null);
    }
}
