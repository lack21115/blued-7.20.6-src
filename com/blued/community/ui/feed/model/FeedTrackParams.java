package com.blued.community.ui.feed.model;

import com.blued.community.ui.event.manager.EventConstants;
import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/model/FeedTrackParams.class */
public class FeedTrackParams implements Serializable {
    public EventConstants.EVENT_FROM_PAGE eventFrom;
    public int feedFrom = -1;
    public boolean isStagger = false;
    public int is_new_face;
    public int is_subject_recommend_feed;
    public int is_top_feed;
    public String mode;
    public String recommend_time;
    public String strong_insert_data;
    public int tips;
    public String tips_text;
}
