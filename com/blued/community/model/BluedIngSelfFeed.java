package com.blued.community.model;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.model.FeedBubbleListGuideExtra;
import com.blued.community.ui.send.model.FeedEventModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.video.model.VideoScanMusic;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.widget.vote.text.model.CircleTextVote;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/BluedIngSelfFeed.class */
public class BluedIngSelfFeed extends BluedADExtra implements MultiItemEntity, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public int a_vote_count;
    public String activity_city;
    public FeedEventModel activity_data;
    public long activity_date;
    public String activity_guide_tag;
    public String activity_guide_text;
    public int activity_guide_type;
    public String activity_id;
    public int activity_join_num;
    public List<UserBasicModel> activity_joiners;
    public String activity_location;
    public String activity_max_evaluate;
    public int activity_mode_id;
    public String activity_name;
    public String activity_online_text;
    public String activity_pic;
    public int activity_quota_num;
    public String activity_uid;
    public int admin_level;
    public int age;
    public int allow_comments;
    public int allow_join;
    public int anchor_admin_level;
    public String anchor_comment_id;
    public String anonym_avatar;
    public int anonym_comment;
    public int b_vote_count;
    public FeedBubbleListGuideExtra bubbleInsertGuideExtra;
    @SerializedName("is_complete")
    public int bubbleSignComplete;
    public String bubble_state;
    public List<UserBasicModel> bubble_state_avatars;
    public String bubble_state_count;
    public String bubble_state_icon;
    public String bubble_state_id;
    public String bubble_state_name;
    public String bubble_state_tt_id;
    public int bubble_tt_click_count;
    public List<UserBasicModel> bubble_tt_click_uid_info;
    public int can_promotion;
    public FeedChatRoom chat_room;
    public int circle_active_posting;
    public int circle_active_shared_posting;
    public String circle_id;
    public String circle_title;
    public int circle_uid;
    public int classify_id;
    public List<FeedComment> comments;
    public String complete_bubble;
    public String complete_image;
    public String complete_style;
    public String complete_subtitle;
    public String complete_title;
    public String cover;
    public String current_track_subject_id;
    public int dataType;
    public boolean date_visible;
    public int disallow_share;
    public String distance;
    public double duration;
    public int expire_type;
    public int expression_id;
    public String[] face_point;
    public transient FeedParse feedParse;
    public int feed_bubble_type;
    public int feed_comment;
    public String feed_content;
    public String feed_date;
    public int feed_dig;
    public FeedExtra feed_extras;
    public String feed_id;
    public int feed_is_delete;
    public String feed_limit_desc;
    public String feed_month;
    public String feed_origin_content;
    public String feed_phone;
    public String[] feed_pics;
    public String[] feed_pics_height;
    public String[] feed_pics_width;
    public String feed_pure_content;
    public long feed_show;
    public int feed_status;
    public String feed_time;
    public String feed_timestamp;
    public String feed_uid;
    public String feed_video_size;
    public String[] feed_videos;
    public double feed_videos_duration;
    public String[] feed_videos_height;
    public String[] feed_videos_width;
    public int feed_views;
    public String feed_year;
    public List<UserBasicModel> followed_joiners;
    public boolean forceShowFollowedStatus;
    public String hash_id;
    public String head;
    public int height;
    public List<FeedComment> hot_comments;
    public int hot_comments_more;
    public int iliked;
    public ImageMogr imagemogr2_long_pic;
    public int in_promotion;
    public BluedTopic insertSubjectPostGuide;
    public String interact_desc;
    public int interaction_count;
    public int interaction_id;
    public String ip_location;
    public boolean isAfterRecommendRefreshGuide;
    public boolean isPlayLikeAnim;
    public boolean isRecommendRefreshGuideFeed;
    public int is_activity;
    public int is_anonym;
    public int is_applied;
    public int is_bubble_ticktock;
    public int is_bubble_tt_click;
    public int is_chatroom_data;
    public int is_disclosure;
    public int is_essence;
    public int is_expression;
    public int is_feed_anonym;
    public int is_hide_distance;
    public int is_hide_last_operate;
    public int is_hide_vip_look;
    public int is_hot_feed;
    public int is_join_circle;
    public int is_live_data;
    public int is_markdown;
    public int is_muted;
    public int is_new_face;
    public int is_op_recommend;
    public int is_posts_vote;
    public int is_questionnaire;
    public int is_recommend;
    public int is_recommend_ticktocks;
    public int is_repost;
    public int is_say_hello;
    public int is_share_activity;
    public int is_share_circle;
    public int is_share_posting;
    public int is_share_super_topics;
    public int is_show_vip_page;
    public int is_strong_insert;
    public int is_subscribe;
    public int is_super_topics;
    public int is_third_ads;
    public int is_top;
    public int is_top_feed;
    public int is_top_hot;
    public int is_top_new;
    public int is_url;
    public int is_video_posts;
    public String is_videos;
    public int is_vip_annual;
    public int is_vote;
    public int ivoted;
    public String join_circle_description;
    public String join_circle_id;
    public String join_circle_pic;
    public String join_circle_title;
    public String kol_name;
    public String last_comment_time;
    public String last_operate;
    public String lid;
    public int link_type;
    public int live;
    public String live_tag;
    public String location;
    public String location_lat;
    public String location_lot;
    public int members_num;
    public VideoScanMusic music;
    public int must_anonym_reply;
    public String mute_time;
    public int mute_type;
    public String note;
    public String note_from;
    public boolean oldest_feed;
    public int online_state;
    public List<CircleTextVote> option_count;
    public int pk;
    public int point_state;
    public int posting_allow_delete;
    public String posts_vote_title;
    public String promotion_bubble;
    public int promotion_bubble_type;
    public int promotion_status;
    public String promotion_url;
    public String promotion_url_option;
    public int reading_scope;
    public String realtime_count;
    public String recall_type;
    public String recommend_text;
    public String recommend_time;
    public String recommendation;
    public String recommendation_new;
    public String relationship;
    public BluedIngSelfFeed repost;
    public int repost_also_comment;
    public int repost_count;
    public String role;
    public String room_id;
    public String room_name;
    public String room_pic;
    public String room_type;
    public String score;
    public int see_limit;
    public String see_limit_desc;
    public String share_activity_address;
    public int share_activity_apply_status;
    public String share_activity_id;
    public int share_activity_is_all;
    public int share_activity_mode_id;
    public String share_activity_pic;
    public int share_activity_status;
    public long share_activity_time;
    public String share_activity_title;
    public String share_circle_posting_content;
    public String share_circle_posting_id;
    public String share_circle_posting_pic;
    public String share_circle_title;
    public String share_s_t_avatar;
    public String share_s_t_des;
    public String share_s_t_did;
    public String share_s_t_name;
    public int show_expression_id;
    public int show_hot_entry;
    public List<BluedIngSelfFeed> signStateList;
    public String strong_insert_data;
    public String super_did;
    public BluedTopic super_insert_floor;
    public String super_tag_image;
    public String super_topics_name;
    public int super_topics_status;
    public int theme_id;
    public int theme_pendant;
    public int tips;
    public String tips_text;
    public int today_complete;
    public String tt_click_sum;
    public int tt_type;
    public String uid;
    public String user_avatar;
    public int user_is_muted;
    public int user_mute_time;
    public int user_mute_type;
    public String user_name;
    public int vbadge;
    public int vip_exp_lvl;
    public int vip_grade;
    public int vote_count;
    public int weight;
    public int is_followed = 0;
    public int feed_type = -99;
    public int playAnimType = 0;
    public int showNotificationWhenSend = 0;
    public boolean isFeedClickPhotoTracked = false;

    public BluedIngSelfFeed() {
    }

    public BluedIngSelfFeed(String str) {
        this.feed_id = str;
    }

    public static BluedIngSelfFeed convertFromFeed(NewFeedModel newFeedModel) {
        if (newFeedModel == null) {
            return null;
        }
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        bluedIngSelfFeed.feed_id = newFeedModel.feed_id;
        bluedIngSelfFeed.is_videos = String.valueOf(newFeedModel.isVideo);
        if (newFeedModel.isVideo == 1) {
            String[] strArr = new String[2];
            bluedIngSelfFeed.feed_videos = strArr;
            strArr[0] = newFeedModel.localPath;
            bluedIngSelfFeed.feed_videos[1] = newFeedModel.videoPath;
        }
        bluedIngSelfFeed.feed_pics = r0;
        String[] strArr2 = {newFeedModel.localPath};
        bluedIngSelfFeed.circle_id = newFeedModel.circle_id;
        bluedIngSelfFeed.circle_title = newFeedModel.circle_title;
        bluedIngSelfFeed.dataType = 1;
        if (!TextUtils.isEmpty(newFeedModel.sign_state_id)) {
            bluedIngSelfFeed.is_bubble_ticktock = 1;
        }
        bluedIngSelfFeed.bubble_state_id = newFeedModel.sign_state_id;
        bluedIngSelfFeed.showNotificationWhenSend = newFeedModel.showNotificationWhenSend;
        return bluedIngSelfFeed;
    }

    private void setCircleServiceUpgraded() {
        if (this.is_share_posting == 1 || (isRepost() && this.repost.is_share_posting == 1)) {
            setServiceUpgraded(R.string.common_circle_service_upgraded);
        }
        if (this.is_join_circle == 1 || (isRepost() && this.repost.is_join_circle == 1)) {
            setServiceUpgraded(R.string.common_circle_service_upgraded);
        }
        if (this.is_share_circle == 1 || (isRepost() && this.repost.is_share_circle == 1)) {
            setServiceUpgraded(R.string.common_circle_service_upgraded);
        }
    }

    private void setServiceUpgraded(int i) {
        this.feed_is_delete = 1;
        this.feed_limit_desc = AppUtils.a(i);
    }

    private void setTopicServiceUpgraded() {
        if (this.is_share_super_topics == 1 || (isRepost() && this.repost.is_share_super_topics == 1)) {
            setServiceUpgraded(R.string.common_topic_service_upgraded);
        }
    }

    public Object clone() {
        BluedIngSelfFeed bluedIngSelfFeed;
        try {
            bluedIngSelfFeed = (BluedIngSelfFeed) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            bluedIngSelfFeed = null;
        }
        bluedIngSelfFeed.feed_type = -99;
        return bluedIngSelfFeed;
    }

    public BluedIngSelfFeed getContentData() {
        return isRepost() ? this.repost : this;
    }

    public int getFeedBubbleStringID() {
        int i = this.feed_bubble_type;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return 0;
                    }
                    return R.string.your_remarked;
                }
                return R.string.recently_chatted;
            }
            return R.string.your_following;
        }
        return R.string.quietly_following;
    }

    public FeedParse getFeedParse(Context context, int i) {
        if (this.feedParse == null) {
            this.feedParse = new FeedParse(context, this, i);
        }
        return this.feedParse;
    }

    public String getImageMogr(boolean z) {
        return getImageMogr(z, 0);
    }

    public String getImageMogr(boolean z, int i) {
        ImageMogr imageMogr = this.imagemogr2_long_pic;
        return imageMogr != null ? z ? (imageMogr.multiple == null || this.imagemogr2_long_pic.multiple.length <= i || TextUtils.isEmpty(this.imagemogr2_long_pic.multiple[i])) ? "" : this.imagemogr2_long_pic.multiple[i] : !TextUtils.isEmpty(imageMogr.single) ? this.imagemogr2_long_pic.single : "" : "";
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        int i = this.feed_type;
        if (i != -99) {
            return i;
        }
        if (!CommunityServiceManager.a().z()) {
            setCircleServiceUpgraded();
        }
        if (!CommunityServiceManager.a().A()) {
            setTopicServiceUpgraded();
        }
        if (this.is_questionnaire == 1 || (isRepost() && this.repost.is_questionnaire == 1)) {
            this.feed_type = 28;
            return 28;
        } else if (this.super_insert_floor != null) {
            this.feed_type = 27;
            return 27;
        } else {
            int i2 = this.dataType;
            if (i2 == 4) {
                this.feed_type = 9;
                return 9;
            } else if (i2 == 5) {
                this.feed_type = 14;
                return 14;
            } else if (i2 == 7) {
                this.feed_type = 22;
                return 22;
            } else if (i2 == 3) {
                this.feed_type = 6;
                return 6;
            } else if (this.is_third_ads == 1) {
                this.feed_type = 21;
                return 21;
            } else if (this.feed_is_delete == 1 || (isRepost() && this.repost.feed_is_delete == 1)) {
                this.feed_type = -2;
                return -2;
            } else if (this.see_limit == 1) {
                this.feed_type = -1;
                return -1;
            } else if (this.is_live_data == 1) {
                this.feed_type = 16;
                return 16;
            } else if (this.is_chatroom_data == 1) {
                this.feed_type = 26;
                return 26;
            } else if (this.is_vote == 1 || (isRepost() && this.repost.is_vote == 1)) {
                this.feed_type = 8;
                return 8;
            } else if (getContentData().is_url == 1 && getContentData().feed_extras != null) {
                this.feed_type = 4;
                return 4;
            } else if ("1".equals(getContentData().is_videos)) {
                this.feed_type = 3;
                return 3;
            } else if (this.is_share_super_topics == 1 || (isRepost() && this.repost.is_share_super_topics == 1)) {
                this.feed_type = 10;
                return 10;
            } else if (this.is_share_posting == 1 || (isRepost() && this.repost.is_share_posting == 1)) {
                this.feed_type = 15;
                return 15;
            } else if (this.is_join_circle == 1 || (isRepost() && this.repost.is_join_circle == 1)) {
                this.feed_type = 17;
                return 17;
            } else if (this.is_share_circle == 1 || (isRepost() && this.repost.is_share_circle == 1)) {
                this.feed_type = 17;
                return 17;
            } else if (this.is_share_activity == 1 || (isRepost() && this.repost.is_share_activity == 1)) {
                this.feed_type = 20;
                return 20;
            } else if (this.is_activity == 1) {
                this.feed_type = 23;
                return 23;
            } else if (getContentData().feed_pics == null || getContentData().feed_pics.length <= 0) {
                if (this.is_bubble_ticktock != 1) {
                    this.feed_type = 0;
                    return 0;
                }
                if (TypeUtils.a((List<?>) this.signStateList)) {
                    this.feed_type = 24;
                } else {
                    this.feed_type = 25;
                }
                return this.feed_type;
            } else if (getContentData().feed_pics.length == 1) {
                if (getContentData().is_ads == 1) {
                    this.feed_type = 5;
                } else {
                    this.feed_type = 0;
                }
                return this.feed_type;
            } else if (getContentData().feed_pics.length == 2 || getContentData().feed_pics.length == 4) {
                this.feed_type = 1;
                return 1;
            } else {
                this.feed_type = 2;
                return 2;
            }
        }
    }

    public CircleJoinState getJoinState() {
        return new CircleJoinState(this.circle_id, this.circle_title, this.cover, this.admin_level, this.allow_join, this.is_applied);
    }

    public boolean getYYLiving() {
        FeedChatRoom feedChatRoom = this.chat_room;
        return feedChatRoom != null && feedChatRoom.room_id > 0;
    }

    public boolean hasDynamicSkin() {
        return this.theme_id != 0;
    }

    public boolean isAnonymous() {
        return this.is_feed_anonym == 1;
    }

    public boolean isCirclePost() {
        return this.dataType <= 1 && CircleMethods.a(this);
    }

    public boolean isDeleted() {
        return this.feed_is_delete == 1;
    }

    public boolean isFeed() {
        return this.dataType <= 1;
    }

    public boolean isJoin() {
        return this.admin_level != 3;
    }

    public boolean isManager() {
        return this.admin_level == 2;
    }

    public boolean isMember() {
        return this.admin_level == 0;
    }

    public boolean isMyFeed() {
        return TextUtils.equals(UserInfoUtils.c(), this.feed_uid);
    }

    public boolean isNewFace() {
        return this.is_new_face == 1;
    }

    public boolean isNotMember() {
        return this.admin_level == 3;
    }

    public boolean isOwner() {
        return this.admin_level == 1;
    }

    public boolean isPrivateCircle() {
        return this.allow_join == 0 && this.is_disclosure == 0;
    }

    public boolean isPublicCircle() {
        return this.allow_join == 1 && this.is_disclosure == 1;
    }

    public boolean isRepost() {
        return this.is_repost == 1 && this.repost != null;
    }

    public boolean isRepostAndDeleted() {
        return isRepost() && this.repost.feed_is_delete == 1;
    }

    public boolean isSelfFeed() {
        return UserInfo.getInstance().getLoginUserInfo().uid.equals(this.feed_uid);
    }

    public void setExitJoin() {
        this.admin_level = 3;
    }

    public void setJoin() {
        this.admin_level = 0;
    }

    public void setJoinState(CircleJoinState circleJoinState) {
        if (circleJoinState == null || TextUtils.isEmpty(this.circle_id) || !this.circle_id.equals(circleJoinState.circle_id)) {
            return;
        }
        this.admin_level = circleJoinState.admin_level;
        this.allow_join = circleJoinState.allow_join;
        this.is_applied = circleJoinState.is_applied;
    }

    public void setManager() {
        this.admin_level = 2;
    }

    public void setMember() {
        this.admin_level = 0;
    }

    @Override // com.blued.android.module.common.login.model.BluedADExtra
    public String toString() {
        return "BluedIngSelfFeed{feed_id='" + this.feed_id + "', feed_uid='" + this.feed_uid + "', feed_status='" + this.feed_status + "', feed_content='" + this.feed_content + "', feed_pics=" + Arrays.toString(this.feed_pics) + ", imagemogr2_long_pic=" + this.imagemogr2_long_pic + ", feed_comment=" + this.feed_comment + ", user_name='" + this.user_name + "'}";
    }
}
