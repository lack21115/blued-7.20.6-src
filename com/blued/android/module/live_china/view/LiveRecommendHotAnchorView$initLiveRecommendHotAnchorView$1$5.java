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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LayoutLiveHotRedBinding f14907a;
    final /* synthetic */ LiveRecommendHotAnchorView b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BluedLiveListData f14908c;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        int displayedChild = this.f14907a.f12096c.getDisplayedChild();
        this.b.a(displayedChild);
        if (displayedChild >= this.f14908c.carousel.size()) {
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_ROOM_SHOW, this.f14908c.carousel.get(displayedChild).lid, this.f14908c.carousel.get(displayedChild).uid, this.f14908c.weight, this.f14908c.recommend_type);
    }
}
