package com.blued.community.ui.comment.model;

import com.blued.android.module.common.login.model.UserBasicModel;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/model/FeedComment.class */
public class FeedComment extends UserBasicModel implements MultiItemEntity, Serializable {
    private static final long serialVersionUID = 1;
    public int admin_level;
    public int anchor_point;
    public int circle_active_comment;
    public String circle_id;
    public String comment_allow_delete;
    public String comment_content;
    public String comment_format_timestamp;
    public String comment_id;
    public String[] comment_pics;
    public String[] comment_pics_height;
    public String[] comment_pics_width;
    public String comment_status;
    public String comment_time;
    public String comment_timestamp;
    public String comment_uid;
    public List<FeedComment> comments;
    public int comments_count;
    public String feed_id;
    public String feed_uid;
    public String ip_location;
    public int is_anonym;
    public int is_author;
    public int is_author_comment;
    public int is_author_likeds;
    public int is_comment_anonym;
    public int is_muted;
    public String is_reply;
    public String mute_time;
    public int mute_type;
    public String reply_avatar;
    public String reply_name;
    public String reply_uid;
    public int repost_also_comment;
    public int tick_negative_comment;
    public int user_allow_mute;
    public String user_avatar;
    public int user_is_muted;
    public int user_mute_time;
    public int user_mute_type;
    public String user_name;
    public int user_vbadge;
    public int iliked = 0;
    public int liked_count = 0;
    public boolean isLastHotComment = false;
    public boolean isHasMoreHotComment = false;
    public int itemViewType = 0;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemViewType;
    }
}
