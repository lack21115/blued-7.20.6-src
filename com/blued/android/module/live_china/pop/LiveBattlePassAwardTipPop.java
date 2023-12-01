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
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveBattlePassAwardTipPop.class */
public final class LiveBattlePassAwardTipPop extends AttachPopupView {
    private final BattlePassLevelAwardDataModel t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveBattlePassAwardTipPop(Context context, BattlePassLevelAwardDataModel model) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(model, "model");
        this.t = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattlePassAwardTipPop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    public final void a(View view, XPopupCallback xPopupCallback, String from) {
        Intrinsics.e(from, "from");
        new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.ScrollAlphaFromBottom).d((Boolean) false).a(PopupPosition.Top).b(true).a(view).c(0 - DensityUtils.a(getContext(), 20.0f)).a((BasePopupView) this).h();
        EventTrackLive.c(LiveProtos.Event.LIVE_BATTLE_PASS_COMMON_EXPLAIN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), from);
    }

    public final void a(View view, String from) {
        Intrinsics.e(from, "from");
        a(view, null, from);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
        if (r0.length() == 0) goto L39;
     */
    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.pop.LiveBattlePassAwardTipPop.b():void");
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_battle_pass_award_tips;
    }

    public final BattlePassLevelAwardDataModel getModel() {
        return this.t;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }
}
