package com.blued.android.module.live_china.pop;

import android.view.MotionEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveWishTipPop.class */
public class LiveWishTipPop extends AttachPopupView {
    private int t;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        if (t()) {
            return;
        }
        p();
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveWishTipPop$TvfveIbNyVitTHl_a2nlYEod9u8
            @Override // java.lang.Runnable
            public final void run() {
                LiveWishTipPop.this.z();
            }
        }, this.t);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_wish_tip;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void u() {
        super.u();
    }
}
