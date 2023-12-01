package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.utils.CommonStringUtils;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomUserModel.class */
public class LiveRoomUserModel extends BluedEntityBaseExtra implements Serializable {
    public String age;
    public int allow_active;
    public int anchor_level;
    public String avatar;
    public String avatar_frame;
    public int avatar_frame_type;
    public List<AnchorMedal> badge;
    public int chat_badge_height;
    public int chat_badge_length;
    public String chat_badge_url;
    public String description;
    public String email;
    public String height;
    public String hot;
    public int is_hide_city_settled;
    public int is_hide_distance;
    public int is_hide_last_operate;
    public int is_hide_vip_look;
    public int is_invisible_all;
    public int is_invisible_half;
    public int is_manager;
    public int is_show_vip_page;
    public int is_vip_annual;
    public String last_operate;
    public String liang_id;
    public int liang_type;
    public String location;
    public String name;
    public String note;
    public int rich_level;
    public String role;
    public LiveRankTopOneModel top_one;
    public String uid;
    public int vbadge;
    public int vip_exp_lvl;
    public int vip_grade;
    public String weight;
    public String relationship = "";
    public String city_settled = "";
    public long uidL = 0;
    public int behalf_status = 0;

    public long getUid() {
        if (this.uidL <= 0) {
            this.uidL = CommonStringUtils.c(this.uid);
        }
        return this.uidL;
    }
}
