package com.blued.community.ui.event.model;

import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/model/EventMemberModel.class */
public class EventMemberModel implements MultiItemEntity {
    public String activity_id;
    public String activity_uid;
    public long audit_time;
    public long create_time;
    public String distance;
    public int evaluate_score;
    public long evaluate_time;
    public List<AlbumFlow> feedPics = new ArrayList();
    public List<BluedIngSelfFeed> feed_image;
    public String id;
    public int is_delete;
    public int is_sign;
    public int join_activity_num;
    public String mode_id;
    public String quick_evaluate_id;
    public long sign_time;
    public int status;
    public String uid;
    public EventUserModel user_info;

    public int getItemType() {
        return 0;
    }
}
