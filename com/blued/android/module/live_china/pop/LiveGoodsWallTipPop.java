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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveGoodsWallTipPop.class */
public final class LiveGoodsWallTipPop extends AttachPopupView {
    private boolean t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGoodsWallTipPop(Context context, boolean z) {
        super(context);
        Intrinsics.e(context, "context");
        this.t = z;
    }

    public final void a(View view, XPopupCallback xPopupCallback) {
        new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.ScrollAlphaFromTop).d((Boolean) false).a(PopupPosition.Bottom).b(true).a(view).c(0 - DensityUtils.a(getContext(), 3.0f)).a((BasePopupView) this).h();
    }

    public final void b(View view) {
        a(view, (XPopupCallback) null);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return this.t ? R.layout.pop_goods_wall_first : R.layout.pop_goods_wall_most;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }

    public final void setFirst(boolean z) {
        this.t = z;
    }
}
