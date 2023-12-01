package com.blued.android.module.yy_china.model;

import android.text.TextUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYChatRoomFollowedModel.class */
public class YYChatRoomFollowedModel {
    public String avatar;
    public String create_time;
    public YYClubLevelInfoModel fans_group_info;
    public boolean isUpload;
    public String is_on_live;
    public String label_link;
    public String last_on_time;
    public String name;
    public String room_desc;
    public String room_id;
    public String room_member_count;
    public String room_name;
    public String room_type;
    public String type_id;
    public String uid;

    public boolean isOnLive() {
        return TextUtils.equals("1", this.is_on_live);
    }
}
