package com.soft.blued.ui.setting.model;

import com.blued.android.module.common.login.model.UserBasicModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/BluedBlackList.class */
public class BluedBlackList extends UserBasicModel implements Cloneable {
    public String black_time;
    public String city_settled;
    public String status;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/BluedBlackList$privacySettingEntity.class */
    public class privacySettingEntity {
        public int avatar_location_status;
        public int black_allowed_count;
        public int black_count;
        public int forbid_selected_viewing;
        public int is_access_followers;
        public int is_access_follows;
        public int is_access_groups;
        public int is_global_view_secretly;
        public int is_hide_city_settled;
        public int is_hide_distance;
        public int is_hide_last_operate;
        public int is_invisible_all;
        public int is_invisible_half;
        public int is_invisible_map;
        public int is_live_push;
        public int is_open_individuality_recommend;
        public int is_open_private_photos;
        public int is_sync_avatar;
        public int is_traceless_access;
        public int is_un_disturb;
        public String stealth_distance;

        public privacySettingEntity() {
        }
    }

    public Object clone() {
        try {
            return (BluedBlackList) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
