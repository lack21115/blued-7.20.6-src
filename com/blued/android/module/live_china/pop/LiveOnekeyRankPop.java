package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveOnekeyRankPop.class */
public class LiveOnekeyRankPop extends AttachPopupView {
    public LiveOnekeyRankPop(Context context) {
        super(context);
    }

    public void a(View view, XPopupCallback xPopupCallback) {
        new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.ScaleAlphaFromRightBottom).d((Boolean) false).a(PopupPosition.Top).b(true).a(view).b(DensityUtils.a(getContext(), 60.0f)).a((BasePopupView) this).h();
    }

    public void b(View view) {
        a(view, (XPopupCallback) null);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_onekey_rank;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }
}
