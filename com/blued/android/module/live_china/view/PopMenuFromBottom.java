package com.blued.android.module.live_china.view;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import com.blued.android.core.AppInfo;
import com.blued.android.module.res_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopMenuFromBottom.class */
public class PopMenuFromBottom extends PopMenu {
    private Float g;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        if ((this.f15087c instanceof ComponentActivity) && ((ComponentActivity) this.f15087c).getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        this.d.a();
    }

    @Override // com.blued.android.module.live_china.view.PopMenu
    public void a() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(this.g.floatValue(), 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        this.f15086a.startAnimation(alphaAnimation);
        this.b.setVisibility(8);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.f15087c, R.anim.pop_down_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopMenuFromBottom$QIJjk8h1NtYn0LUoc_Aozst8PAI
            @Override // java.lang.Runnable
            public final void run() {
                PopMenuFromBottom.this.b();
            }
        }, 320L);
    }
}
