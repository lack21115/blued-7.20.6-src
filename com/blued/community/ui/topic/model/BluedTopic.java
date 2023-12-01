package com.blued.community.ui.topic.model;

import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.square.model.DiscoverRecommendModel;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/model/BluedTopic.class */
public class BluedTopic extends DiscoverRecommendModel implements MultiItemEntity, Serializable {
    private static final long serialVersionUID = 1;
    public String avatar;
    public int back_topics_type;
    public String bg_color;
    public List<BluedTopic> bluedTopicList;
    public String color;
    public String creator;
    public String creator_name;
    public String description;
    public int insert_floor;
    public boolean invalid;
    public boolean isShowUrlVisited;
    public int is_anonym;
    public int is_audited;
    public boolean is_chosen;
    public int is_follow;
    public int is_hot;
    public int is_hot_topics;
    public boolean is_local_2b_created;
    public int is_new;
    public int is_questionnaire_topics;
    public int is_support_vote;
    public int is_topic;
    public String join_total;
    public String last_contents;
    public String name;
    public String ranking;
    public String super_did;
    public String super_insert_floor;
    public String super_ranking;
    public int ticktocks_total;
    public String timestamp;
    public int topicType;
    public int topic_type;
    public String topics_msg;
    public List<BluedIngSelfFeed> tt;
    public String tt_ids;
    public List<String> tt_image;
    public int visited_total;

    public BluedTopic() {
        this.isShowUrlVisited = false;
        this.bg_color = "";
        this.is_hot_topics = 0;
        this.topic_type = 0;
    }

    public BluedTopic(String str, int i) {
        this.isShowUrlVisited = false;
        this.bg_color = "";
        this.is_hot_topics = 0;
        this.topic_type = 0;
        this.super_did = "0";
        this.name = str;
        this.is_anonym = i;
    }

    public BluedTopic(String str, String str2) {
        this.isShowUrlVisited = false;
        this.bg_color = "";
        this.is_hot_topics = 0;
        this.topic_type = 0;
        this.super_did = str;
        this.name = str2;
    }

    public BluedTopic(String str, String str2, int i) {
        this.isShowUrlVisited = false;
        this.bg_color = "";
        this.is_hot_topics = 0;
        this.topic_type = 0;
        this.super_did = str;
        this.name = str2;
        this.is_anonym = i;
    }

    public int getItemType() {
        return 0;
    }
}
