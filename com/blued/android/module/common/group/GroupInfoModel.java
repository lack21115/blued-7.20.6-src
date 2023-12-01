package com.blued.android.module.common.group;

import android.os.Build;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/group/GroupInfoModel.class */
public class GroupInfoModel implements MultiItemEntity, Serializable {
    public List<GroupMemberModel> admin;
    public int allow_join;
    public Anchor anchor;
    public String announcement;
    public int apply_status;
    public int at_message_is_mute;
    public int auditing;
    public int belong_circle;
    public int category;
    public String category_zh;
    public Circle circle;
    public String city;
    public Event event;
    public String group_cover;
    public String group_desc;
    public int group_id;
    public int group_max_admin;
    public int group_max_population;
    public int group_now_population;
    public int group_role;
    public int group_status;
    public String group_title;
    public long group_uid;
    public boolean isSelected;
    public int is_super;
    public int itemType;
    public List<Label> label;
    public String lock_time;
    public int max_join;
    public int message_is_mute;
    public int nearby_or_recommend;
    public int notice_is_mute;
    public int online;
    public List<Integer> report_reason;
    public int type;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/group/GroupInfoModel$Anchor.class */
    public static class Anchor implements Serializable {
        public String avatar;
        public String name;
        public int uid;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/group/GroupInfoModel$Circle.class */
    public static class Circle implements Serializable {
        public int id;
        public long latest_update;
        public String title;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/group/GroupInfoModel$Event.class */
    public static class Event implements Serializable {
        public String announcement;
        public int id;
        public int is_rate;
        public String name;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/group/GroupInfoModel$Label.class */
    public static class Label implements Serializable {
        public String color;
        public String label;

        public Label(String str, String str2) {
            this.label = str;
            this.color = str2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.group_id == ((GroupInfoModel) obj).group_id;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(Integer.valueOf(this.group_id)) : this.group_id;
    }
}
