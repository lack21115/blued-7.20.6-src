package com.blued.community.utils;

import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/CommEventBusUtil.class */
public final class CommEventBusUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final CommEventBusUtil f6855a = new CommEventBusUtil();

    private CommEventBusUtil() {
    }

    public final void a() {
        LiveEventBus.get("EVENT_NEARBY_GUIDE_POP").postDelay(true, 100L);
    }

    public final void a(int i) {
        LiveEventBus.get("EVENT_CLICK_HOME_TAB_INDEX").post(Integer.valueOf(i));
    }

    public final void a(EventDetailsModel eventDetailsModel) {
        if (eventDetailsModel == null) {
            return;
        }
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SCORED").post(eventDetailsModel);
    }

    public final void a(BusFeedInteractModel busFeedInteractModel) {
        if (busFeedInteractModel == null) {
            return;
        }
        LiveEventBus.get("EVENT_BUS_FEED_INTERACT").post(busFeedInteractModel);
    }

    public final void a(FeedPostSignStateItem feedPostSignStateItem) {
        if (feedPostSignStateItem == null) {
            return;
        }
        LiveEventBus.get("EVENT_BUBBLE_STATE_SELECTED_MODEL").post(feedPostSignStateItem);
    }

    public final void a(String str) {
        if (str == null) {
            return;
        }
        LiveEventBus.get("follow_success").post(str);
    }

    public final void b(EventDetailsModel eventDetailsModel) {
        if (eventDetailsModel == null) {
            return;
        }
        LiveEventBus.get("EVENT_BUS_EVENT_APPLY_SUCC").post(eventDetailsModel);
    }

    public final void b(String str) {
        if (str == null) {
            return;
        }
        LiveEventBus.get("cancel_follow").post(str);
    }

    public final void c(String str) {
        if (str == null) {
            return;
        }
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SIGN_IN_SUCCESS").post(str);
    }

    public final void d(String str) {
        if (str == null) {
            return;
        }
        LiveEventBus.get("EVENT_BUS_ACTIVITY_SUBSCRIBE_SUCCESS").post(str);
    }

    public final void e(String str) {
        if (str == null) {
            return;
        }
        LiveEventBus.get("EVENT_BUS_ACTIVITY_CANCEL_SUBSCRIBE").post(str);
    }
}
