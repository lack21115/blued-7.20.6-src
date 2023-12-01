package com.blued.android.module.live_china.view;

import android.view.animation.Animation;
import com.blued.android.module.live_china.databinding.LayoutLiveHotRedBinding;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRecommendHotAnchorView$initLiveRecommendHotAnchorView$1$5.class */
public final class LiveRecommendHotAnchorView$initLiveRecommendHotAnchorView$1$5 implements Animation.AnimationListener {
    final /* synthetic */ LayoutLiveHotRedBinding a;
    final /* synthetic */ LiveRecommendHotAnchorView b;
    final /* synthetic */ BluedLiveListData c;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        int displayedChild = this.a.c.getDisplayedChild();
        this.b.a(displayedChild);
        if (displayedChild >= this.c.carousel.size()) {
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_ROOM_SHOW, this.c.carousel.get(displayedChild).lid, this.c.carousel.get(displayedChild).uid, this.c.weight, this.c.recommend_type);
    }
}
