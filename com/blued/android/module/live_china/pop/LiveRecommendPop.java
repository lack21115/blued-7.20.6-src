package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveRecommendPop.class */
public class LiveRecommendPop extends AttachPopupView {
    private int t;

    public LiveRecommendPop(Context context) {
        super(context);
        this.t = 5000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        if (t()) {
            return;
        }
        p();
    }

    public void a(View view, XPopupCallback xPopupCallback) {
        if (LiveRoomPreferences.d()) {
            int a2 = DensityUtils.a(getContext(), 33.0f);
            new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.ScaleAlphaFromCenter).d((Boolean) false).a(PopupPosition.Bottom).b(true).a(view).b(a2).c(DensityUtils.a(getContext(), 5.0f)).a((BasePopupView) this).h();
            LiveRoomPreferences.e();
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveRecommendPop$il-LympVT0-VrB1NymMz42JuhKk
            @Override // java.lang.Runnable
            public final void run() {
                LiveRecommendPop.this.z();
            }
        }, this.t);
    }

    public void b(View view) {
        a(view, (XPopupCallback) null);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_recommend;
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
