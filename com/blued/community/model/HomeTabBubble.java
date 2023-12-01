package com.blued.community.model;

import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/HomeTabBubble.class */
public class HomeTabBubble {
    public String bubble_click;
    public String bubble_experiment_text;
    public int bubble_group;
    public String bubble_id;
    public String bubble_img;
    public int bubble_position;
    public int bubble_source;
    public String bubble_text;
    public BubbleKV bubble_tid;
    public int bubble_type;
    public BubbleKV bubble_uid;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/HomeTabBubble$BubbleKV.class */
    public static class BubbleKV {
        public String name;
        public String value;
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/HomeTabBubble$FEED_BUBBLE_TYPE.class */
    public interface FEED_BUBBLE_TYPE {
        public static final int BODY_TYPE_YOU_MAY_LIKE = 6;
        public static final int CHATTED_UPDATED = 3;
        public static final int FOLLOW_UPDATED = 2;
        public static final int HOME_TAB_BY_SERVER = 1102;
        public static final int LIVE_GUIDE_PIC = 5;
        public static final int NOTED_UPDATED = 4;
        public static final int SECRET_FOLLOW_UPDATED = 1;
        public static final int SIGN_FEED_COMMON_GUIDE = 1101;
        public static final int WATCHED_AUTHOR_UPDATED = 7;
    }

    public int getFeedBubbleStringId() {
        int i = this.bubble_source;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return 0;
                    }
                    return R.string.your_remarked_updated;
                }
                return R.string.recently_chatted_updated;
            }
            return R.string.your_following_updated;
        }
        return R.string.quietly_following_updated;
    }
}
