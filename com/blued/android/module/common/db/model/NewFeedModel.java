package com.blued.android.module.common.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;

@DatabaseTable(tableName = "NewFeedModel")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/model/NewFeedModel.class */
public class NewFeedModel implements Serializable {
    public static final int FORWARD_HEADER = 0;
    public static final int FORWARD_IMAGE = 1;
    @DatabaseField
    public String activity_id;
    @DatabaseField
    public String address;
    @DatabaseField
    public int allow_comments;
    @DatabaseField
    public int anonym_avatar;
    @DatabaseField
    public int anonym_comment;
    public String bubbleClassifyId;
    @DatabaseField
    public String circle_header;
    @DatabaseField
    public String circle_id;
    @DatabaseField
    public String circle_title;
    @DatabaseField
    private String content;
    @DatabaseField
    public float duration;
    @DatabaseField
    public String event_evaluate;
    @DatabaseField
    public int event_score;
    @DatabaseField
    public String extraJSON;
    @DatabaseField
    public String feed_id;
    @DatabaseField
    public String feed_pics_height;
    @DatabaseField
    public String feed_pics_width;
    @DatabaseField
    public String forwardContent;
    @DatabaseField
    public String forwardImage;
    @DatabaseField
    public String forwardName;
    @DatabaseField
    public String frames_data;
    @DatabaseField
    public String h5_topic_id;
    @DatabaseField
    public String h5_topic_name;
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;
    @DatabaseField
    public int isForwardHeader;
    @DatabaseField
    public int isVideo;
    @DatabaseField
    public int is_ads;
    @DatabaseField
    public int is_anonym;
    @DatabaseField
    public int is_attention_show_dot;
    @DatabaseField
    public int is_circle_comment;
    @DatabaseField
    public int is_draft;
    @DatabaseField
    public int is_evaluate_activity;
    @DatabaseField
    public int is_join_circle;
    public int is_label;
    @DatabaseField
    public int is_posts_vote;
    @DatabaseField
    public int is_questionnaire;
    @DatabaseField
    public int is_repost;
    @DatabaseField
    public int is_share_activity;
    @DatabaseField
    public int is_share_circle;
    @DatabaseField
    public int is_share_super_topics;
    @DatabaseField
    public int is_super_topics;
    @DatabaseField
    public int is_url;
    @DatabaseField
    public int is_vote;
    @DatabaseField
    public int join_circle_id;
    @DatabaseField
    public String join_circle_title;
    @DatabaseField
    private String lat;
    @DatabaseField
    private String lng;
    @DatabaseField(index = true)
    private long loadName;
    @DatabaseField
    public String localPath;
    @DatabaseField
    public String localVideoPath;
    @DatabaseField
    public String music_id;
    @DatabaseField
    public String option;
    @DatabaseField
    private String pics;
    @DatabaseField
    public String posts_vote_title;
    @DatabaseField
    private int progress;
    @DatabaseField
    public int reading_scope;
    @DatabaseField
    public int repost_also_comment;
    @DatabaseField
    public String share_activity_id;
    @DatabaseField
    public String share_activity_location;
    @DatabaseField
    public int share_activity_mode_id;
    @DatabaseField
    public String share_activity_time;
    @DatabaseField
    public String share_circle_id;
    @DatabaseField
    public String share_posting_id;
    @DatabaseField
    public String share_s_t_did;
    @DatabaseField
    public int share_super_topics_anonym;
    @DatabaseField
    public String sign_state_id;
    @DatabaseField
    private int size;
    @DatabaseField
    private int state;
    public String state_types;
    @DatabaseField
    public String super_did;
    @DatabaseField
    public int super_topics_anonym;
    @DatabaseField
    public String super_topics_avatar;
    @DatabaseField
    public String super_topics_name;
    @DatabaseField
    private long time;
    @DatabaseField
    public int tt_type;
    @DatabaseField
    public int videoHeight;
    @DatabaseField
    public String videoPath;
    @DatabaseField
    public long videoSize;
    @DatabaseField
    public String videoTaskID;
    @DatabaseField
    public int videoWidth;
    public boolean isResend = false;
    public int showNotificationWhenSend = 0;
    public boolean dontNeedCompress = false;

    public String getContent() {
        return this.content;
    }

    public int getId() {
        return this.id;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public long getLoadName() {
        return this.loadName;
    }

    public String getPics() {
        return this.pics;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getRepostAlsoComment() {
        return this.repost_also_comment;
    }

    public int getSize() {
        return this.size;
    }

    public int getState() {
        return this.state;
    }

    public long getTime() {
        return this.time;
    }

    public long getVideoSize() {
        return this.videoSize;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsJoinCircle(int i) {
        this.is_join_circle = i;
    }

    public void setJoinCircleId(int i) {
        this.join_circle_id = i;
    }

    public void setJoinCircleTitle(String str) {
        this.join_circle_title = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setLoadName(long j) {
        this.loadName = j;
    }

    public void setPics(String str) {
        this.pics = str;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setRepostAlsoComment(int i) {
        this.repost_also_comment = i;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setVideoSize(long j) {
        this.videoSize = j;
    }
}
