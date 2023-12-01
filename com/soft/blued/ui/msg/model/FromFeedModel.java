package com.soft.blued.ui.msg.model;

import com.blued.community.model.BluedIngSelfFeed;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/FromFeedModel.class */
public class FromFeedModel {
    public String bubble_state_id;
    public String feedId;
    public int is_bubble_ticktock;
    public String pic;
    public String text;

    public FromFeedModel(BluedIngSelfFeed bluedIngSelfFeed) {
        this.feedId = bluedIngSelfFeed.feed_id;
        this.text = bluedIngSelfFeed.feed_content;
        if (bluedIngSelfFeed.is_bubble_ticktock == 1) {
            this.pic = bluedIngSelfFeed.bubble_state_icon;
        } else if (bluedIngSelfFeed.feed_pics != null && bluedIngSelfFeed.feed_pics.length > 0) {
            this.pic = bluedIngSelfFeed.feed_pics[0];
        }
        this.is_bubble_ticktock = bluedIngSelfFeed.is_bubble_ticktock;
        this.bubble_state_id = bluedIngSelfFeed.bubble_state_id;
    }
}
