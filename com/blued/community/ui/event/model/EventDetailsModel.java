package com.blued.community.ui.event.model;

import com.blued.android.module.common.login.model.UserBasicModel;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/model/EventDetailsModel.class */
public class EventDetailsModel extends EventPostModel implements Serializable {
    private static final long serialVersionUID = 1;
    public String activity_evaluate;
    public String activity_name;
    public int activity_score;
    public int apply_status;
    public long create_time;
    public String distance;
    public int evaluate_status;
    public String group_id;
    public String id;
    public String ip_location;
    public int is_can_share;
    public int is_creator_send_feed;
    public int is_first;
    public int is_official;
    public int is_sign_in;
    public int is_subscribe;
    public int is_sure_sign_in;
    public int join_num;
    public List<UserBasicModel> joiners;
    public String max_evaluate;
    public String other_tips;
    public int publish_activity_count;
    public List<QuickEvaluate> quick_evaluate;
    public List<EventDetailsModel> rear_activity_data;
    public String recommend_text;
    public String[] scene_images;
    public float score;
    public int show_distance;
    public int status;
    public String type_name;
    public String uid;
    public UserBasicModel user_info;
    public int wait_audit;
    public boolean isShowUrlVisited = false;
    public int activity_sign_num = 0;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/model/EventDetailsModel$QuickEvaluate.class */
    public static class QuickEvaluate implements Serializable {
        public String id;
        public String name;
    }
}
