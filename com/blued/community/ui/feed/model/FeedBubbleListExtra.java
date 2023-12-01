package com.blued.community.ui.feed.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/model/FeedBubbleListExtra.class */
public final class FeedBubbleListExtra extends BluedEntityBaseExtra {
    private int is_today_sent;
    private FeedBubbleListGuideExtra tick_state_popup;
    private FeedBubbleListGuideExtra tick_state_release;

    public final FeedBubbleListGuideExtra getTick_state_popup() {
        return this.tick_state_popup;
    }

    public final FeedBubbleListGuideExtra getTick_state_release() {
        return this.tick_state_release;
    }

    public final int is_today_sent() {
        return this.is_today_sent;
    }

    public final void setTick_state_popup(FeedBubbleListGuideExtra feedBubbleListGuideExtra) {
        this.tick_state_popup = feedBubbleListGuideExtra;
    }

    public final void setTick_state_release(FeedBubbleListGuideExtra feedBubbleListGuideExtra) {
        this.tick_state_release = feedBubbleListGuideExtra;
    }

    public final void set_today_sent(int i) {
        this.is_today_sent = i;
    }
}
