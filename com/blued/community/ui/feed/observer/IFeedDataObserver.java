package com.blued.community.ui.feed.observer;

import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.model.FeedRepost;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/IFeedDataObserver.class */
public interface IFeedDataObserver {
    void a(BluedIngSelfFeed bluedIngSelfFeed);

    void a(FeedComment feedComment);

    void a(BusFeedInteractModel busFeedInteractModel);

    void a(FeedRepost feedRepost);

    void a(String str, int i);

    void a(String str, String str2);

    void b(BluedIngSelfFeed bluedIngSelfFeed);

    void b(String str, int i);

    void b(String str, String str2);

    void c(int i);

    void c(String str);

    void c(String str, int i);

    void d(int i);

    void d(String str, int i);
}
