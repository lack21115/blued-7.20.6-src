package com.soft.blued.ui.notify.manager;

import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedNotice;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/manager/NotifyMethods.class */
public class NotifyMethods {
    public static BluedIngSelfFeed a(FeedNotice feedNotice) {
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        bluedIngSelfFeed.feed_id = feedNotice.feed_id;
        bluedIngSelfFeed.feed_content = feedNotice.feed_content;
        bluedIngSelfFeed.feed_pics = feedNotice.feed_pics;
        bluedIngSelfFeed.is_feed_anonym = feedNotice.is_feed_anonym;
        return bluedIngSelfFeed;
    }
}
