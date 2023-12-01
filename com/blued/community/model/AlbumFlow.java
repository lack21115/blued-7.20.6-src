package com.blued.community.model;

import com.blued.community.manager.CommunityManager;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/AlbumFlow.class */
public class AlbumFlow extends BluedIngSelfFeed {
    public String album_pic;
    public int album_pics_num;
    public int album_status;
    public int isFeed;
    public boolean isOccupyModel;
    public boolean isSelf;
    public String lockText;
    public String pid;
    public boolean showApply;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/AlbumFlow$ALBUM_STATUS.class */
    public interface ALBUM_STATUS {
        public static final int LOCKED = 0;
        public static final int UNLOCKED = 1;
    }

    public AlbumFlow() {
        this.isFeed = 1;
        this.album_status = 1;
    }

    public AlbumFlow(BluedIngSelfFeed bluedIngSelfFeed) {
        this.isFeed = 1;
        this.album_status = 1;
        if (bluedIngSelfFeed != null) {
            this.feed_id = bluedIngSelfFeed.feed_id;
            this.feed_uid = bluedIngSelfFeed.feed_uid;
            this.user_name = bluedIngSelfFeed.user_name;
            this.vbadge = bluedIngSelfFeed.vbadge;
            this.feed_pics = bluedIngSelfFeed.feed_pics;
            this.feed_pics_width = bluedIngSelfFeed.feed_pics_width;
            this.feed_pics_height = bluedIngSelfFeed.feed_pics_height;
            this.is_videos = bluedIngSelfFeed.is_videos;
            this.feed_videos = bluedIngSelfFeed.feed_videos;
            this.feed_video_size = bluedIngSelfFeed.feed_video_size;
            this.feed_videos_width = bluedIngSelfFeed.feed_videos_width;
            this.feed_videos_height = bluedIngSelfFeed.feed_videos_height;
            this.note = bluedIngSelfFeed.note;
            this.feed_content = bluedIngSelfFeed.feed_content;
            this.feed_comment = bluedIngSelfFeed.feed_comment;
            this.feed_dig = bluedIngSelfFeed.feed_dig;
            this.iliked = bluedIngSelfFeed.iliked;
            this.location = bluedIngSelfFeed.location;
            this.distance = bluedIngSelfFeed.distance;
            this.age = bluedIngSelfFeed.age;
            this.height = bluedIngSelfFeed.height;
            this.weight = bluedIngSelfFeed.weight;
            this.feed_time = bluedIngSelfFeed.feed_time;
            this.feed_timestamp = bluedIngSelfFeed.feed_timestamp;
            this.relationship = bluedIngSelfFeed.relationship;
            this.user_avatar = bluedIngSelfFeed.user_avatar;
            this.is_show_vip_page = bluedIngSelfFeed.is_show_vip_page;
            this.super_did = bluedIngSelfFeed.super_did;
            this.is_super_topics = bluedIngSelfFeed.is_super_topics;
            this.super_topics_name = bluedIngSelfFeed.super_topics_name;
            this.forceShowFollowedStatus = bluedIngSelfFeed.forceShowFollowedStatus;
            this.is_hide_distance = bluedIngSelfFeed.is_hide_distance;
            this.vip_grade = bluedIngSelfFeed.vip_grade;
            this.is_vip_annual = bluedIngSelfFeed.is_vip_annual;
            this.is_hide_vip_look = bluedIngSelfFeed.is_hide_vip_look;
            this.vip_exp_lvl = bluedIngSelfFeed.vip_exp_lvl;
            this.disallow_share = bluedIngSelfFeed.disallow_share;
            this.feed_is_delete = bluedIngSelfFeed.feed_is_delete;
            this.is_top_hot = bluedIngSelfFeed.is_top_hot;
            this.is_feed_anonym = bluedIngSelfFeed.is_feed_anonym;
            this.kol_name = bluedIngSelfFeed.kol_name;
            this.strong_insert_data = bluedIngSelfFeed.strong_insert_data;
            this.is_recommend_ticktocks = bluedIngSelfFeed.is_recommend_ticktocks;
            this.feed_views = bluedIngSelfFeed.feed_views;
            this.location_lot = bluedIngSelfFeed.location_lot;
            this.location_lat = bluedIngSelfFeed.location_lat;
            this.feed_status = bluedIngSelfFeed.feed_status;
            this.imagemogr2_long_pic = bluedIngSelfFeed.imagemogr2_long_pic;
            this.face_point = bluedIngSelfFeed.face_point;
            this.duration = bluedIngSelfFeed.duration;
            this.feed_videos_duration = bluedIngSelfFeed.feed_videos_duration;
            this.isPlayLikeAnim = bluedIngSelfFeed.isPlayLikeAnim;
            this.feed_phone = bluedIngSelfFeed.feed_phone;
            this.comments = bluedIngSelfFeed.comments;
            this.hot_comments = bluedIngSelfFeed.hot_comments;
            this.hot_comments_more = bluedIngSelfFeed.hot_comments_more;
            this.feed_date = bluedIngSelfFeed.feed_date;
            this.feed_month = bluedIngSelfFeed.feed_month;
            this.feed_year = bluedIngSelfFeed.feed_year;
            this.point_state = bluedIngSelfFeed.point_state;
            this.date_visible = bluedIngSelfFeed.date_visible;
            this.oldest_feed = bluedIngSelfFeed.oldest_feed;
            this.allow_comments = bluedIngSelfFeed.allow_comments;
            this.reading_scope = bluedIngSelfFeed.reading_scope;
            this.feed_show = bluedIngSelfFeed.feed_show;
            this.feed_limit_desc = bluedIngSelfFeed.feed_limit_desc;
            this.is_repost = bluedIngSelfFeed.is_repost;
            this.repost_count = bluedIngSelfFeed.repost_count;
            this.repost = bluedIngSelfFeed.repost;
            this.super_topics_status = bluedIngSelfFeed.super_topics_status;
            this.anonym_comment = bluedIngSelfFeed.anonym_comment;
            this.must_anonym_reply = bluedIngSelfFeed.must_anonym_reply;
            this.anonym_avatar = bluedIngSelfFeed.anonym_avatar;
            this.online_state = bluedIngSelfFeed.online_state;
            this.theme_id = bluedIngSelfFeed.theme_id;
            this.theme_pendant = bluedIngSelfFeed.theme_pendant;
            this.repost_also_comment = bluedIngSelfFeed.repost_also_comment;
            this.role = bluedIngSelfFeed.role;
            this.is_followed = bluedIngSelfFeed.is_followed;
            this.activity_data = bluedIngSelfFeed.activity_data;
            this.is_new_face = bluedIngSelfFeed.is_new_face;
            this.tips_text = bluedIngSelfFeed.tips_text;
            this.recommend_time = bluedIngSelfFeed.recommend_time;
            this.is_vote = bluedIngSelfFeed.is_vote;
            if (bluedIngSelfFeed.feed_pics != null && bluedIngSelfFeed.feed_pics.length > 0) {
                this.album_pic = bluedIngSelfFeed.feed_pics[0];
            }
            this.isSelf = CommunityManager.a.a().c(bluedIngSelfFeed.feed_uid);
            this.isFeed = 1;
        }
    }
}
