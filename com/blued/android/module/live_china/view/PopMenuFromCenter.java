package com.blued.android.module.live_china.view;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.res_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMenuFromCenter.class */
public class PopMenuFromCenter extends PopMenuFromBottom {
    public DismissListner g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMenuFromCenter$DismissListner.class */
    public interface DismissListner {
        void a(boolean z);
    }

    @Override // com.blued.android.module.live_china.view.PopMenuFromBottom, com.blued.android.module.live_china.view.PopMenu
    public void a() {
        a(false);
    }

    public void a(final boolean z) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        this.a.startAnimation(alphaAnimation);
        this.b.setVisibility(8);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopMenuFromCenter.1
            @Override // java.lang.Runnable
            public void run() {
                PopMenuFromCenter.this.d.a();
                if (PopMenuFromCenter.this.g != null) {
                    PopMenuFromCenter.this.g.a(z);
                }
            }
        }, 320L);
    }
}
