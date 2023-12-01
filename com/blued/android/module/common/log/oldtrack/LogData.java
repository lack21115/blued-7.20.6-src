package com.blued.android.module.common.log.oldtrack;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/log/oldtrack/LogData.class */
public class LogData implements Serializable {
    public String activity_id;
    public String bubble_exhibition_img;
    public String circle_id;
    public String content;
    public String db_id;
    public String destination;
    public String details;
    public String distance;
    public String document_id;
    public int feedFrom;
    public String feed_id;
    public String from;
    public String id;
    public boolean isAddFollow;
    public boolean isFromFeedDetail;
    public boolean isQuietHello;
    public boolean isReactiveRecommend;
    public boolean isShadow;
    public String is_call;
    public boolean is_feed_super_exposure;
    public String is_hello;
    public int is_hot_feed;
    public int is_new_face;
    public int is_questionnaire;
    public String is_self;
    public String is_special;
    public boolean is_super_call;
    public int is_vote;
    public String item_id;
    public String listMode;
    public String logService;
    public String nearby_sortby;
    public String num;
    public String online_time;
    public String pid;
    public String platform;
    public String position;
    public String recommend_time;
    public Long session_id;
    public String show_type;
    public String status;
    public String strong_insert_data;
    public String super_tag_image;
    public String target_uid;
    public String time;
    public int tips;
    public String to;
    public String topic_category;
    public String topic_id;
    public int tt_type;
    public String type;
    public String uid;
    public String url;
    public String userFrom;
    public int vip_selected_reason;
    public String vip_selected_tag;
    public int virtual;

    public LogData() {
        this.num = null;
        this.target_uid = null;
        this.uid = null;
        this.url = null;
        this.platform = null;
        this.destination = null;
        this.from = null;
        this.topic_category = null;
        this.db_id = null;
        this.document_id = null;
        this.type = null;
        this.position = null;
        this.time = null;
        this.id = null;
        this.content = null;
        this.to = null;
        this.is_self = null;
        this.item_id = null;
        this.pid = null;
        this.topic_id = null;
        this.is_hello = null;
        this.is_call = null;
        this.status = null;
        this.is_special = null;
        this.show_type = null;
        this.nearby_sortby = null;
        this.distance = null;
        this.online_time = null;
        this.isShadow = false;
        this.isReactiveRecommend = false;
        this.isQuietHello = false;
        this.userFrom = "";
        this.isAddFollow = false;
        this.logService = "";
        this.feedFrom = 0;
        this.isFromFeedDetail = false;
    }

    public LogData(String str) {
        this.num = null;
        this.target_uid = null;
        this.uid = null;
        this.url = null;
        this.platform = null;
        this.destination = null;
        this.from = null;
        this.topic_category = null;
        this.db_id = null;
        this.document_id = null;
        this.type = null;
        this.position = null;
        this.time = null;
        this.id = null;
        this.content = null;
        this.to = null;
        this.is_self = null;
        this.item_id = null;
        this.pid = null;
        this.topic_id = null;
        this.is_hello = null;
        this.is_call = null;
        this.status = null;
        this.is_special = null;
        this.show_type = null;
        this.nearby_sortby = null;
        this.distance = null;
        this.online_time = null;
        this.isShadow = false;
        this.isReactiveRecommend = false;
        this.isQuietHello = false;
        this.userFrom = "";
        this.isAddFollow = false;
        this.logService = "";
        this.feedFrom = 0;
        this.isFromFeedDetail = false;
        this.logService = str;
    }
}
