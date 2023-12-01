package com.blued.community.model;

import android.text.TextUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/FeedNotice.class */
public class FeedNotice extends UserBasicModel implements MultiItemEntity {
    public int admin_level;
    public int allow_join;
    public String circle_id;
    public String circle_title;
    public int comment_deleted;
    public String comment_id;
    public String content;
    public String cover;
    public int expression_id;
    public String feed_content;
    public String feed_id;
    public String[] feed_pics;
    public String[] feed_pics_height;
    public String[] feed_pics_width;
    public String[] feed_videos;
    public String format_timestamp;
    public int from;
    public int from_top;
    public int has_read;
    public int id;
    public String interaction_id;
    public int is_anonym;
    public int is_applied;
    public int is_comment_type;
    public int is_comments_liked;
    public int is_expression;
    public int is_feed_anonym;
    public int is_negative_comment;
    public int is_posts_vote;
    public int is_user_anonym;
    public String is_videos;
    public int must_anonym_reply;
    public long notification_id;
    public String time;
    public String timestamp;
    public int type;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        int i = this.type;
        return (i == 7 || i == 8 || i == 10) ? 1 : 0;
    }

    public CircleJoinState getJoinState() {
        return new CircleJoinState(this.circle_id, this.circle_title, this.cover, this.admin_level, this.allow_join, this.is_applied);
    }

    public void setJoinState(CircleJoinState circleJoinState) {
        if (circleJoinState == null || TextUtils.isEmpty(this.circle_id) || !this.circle_id.equals(circleJoinState.circle_id)) {
            return;
        }
        this.admin_level = circleJoinState.admin_level;
        this.allow_join = circleJoinState.allow_join;
        this.is_applied = circleJoinState.is_applied;
    }
}
