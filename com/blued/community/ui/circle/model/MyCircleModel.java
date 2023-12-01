package com.blued.community.ui.circle.model;

import android.text.TextUtils;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.community.ui.square.model.DiscoverRecommendModel;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/MyCircleModel.class */
public class MyCircleModel extends DiscoverRecommendModel implements MultiItemEntity, Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public int active_list_is_show;
    public int active_list_open;
    public String[] active_list_top;
    public int admin_level;
    public int all_groups_full;
    public int allow_join;
    public List<MyCircleModel> circleModelList;
    public String circle_id;
    public int classify_id;
    public String cover;
    public int cover_is_auditing;
    public String description;
    public String feed_big_num;
    public int feed_num;
    public List<GroupInfoModel> groups;
    public int has_mute;
    public boolean isDraw;
    public boolean isHotBase;
    public boolean isShowUrlVisited;
    public int is_applied;
    public int is_backflow_user;
    public int is_disclosure;
    public int is_essence;
    @Deprecated
    public int is_member;
    public int label;
    public String last_update_time;
    public String members_big_num;
    public int members_num;
    public int show_groups;
    public String title;
    public int user_mute_time;
    public int user_mute_type;

    public MyCircleModel() {
    }

    public MyCircleModel(String str, boolean z) {
        this.title = str;
        this.isHotBase = z;
    }

    public Object clone() {
        try {
            return (MyCircleModel) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 0;
    }

    public CircleJoinState getJoinState() {
        return new CircleJoinState(this.circle_id, this.title, this.cover, this.admin_level, this.allow_join, this.is_applied);
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

    public boolean isNotMember() {
        return this.admin_level == 3;
    }

    public boolean isOwner() {
        return this.admin_level == 1;
    }

    public boolean isPrivateCircle() {
        return this.allow_join == 0 && this.is_disclosure == 0;
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
}
