package com.blued.android.module.live_china.pop;

import android.view.MotionEvent;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveCloakingExplainPop.class */
public class LiveCloakingExplainPop extends AttachPopupView {
    private boolean t;

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return this.t ? R.layout.pop_cloaking_explain : R.layout.pop_cloaking_explain_bottom;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }
}
