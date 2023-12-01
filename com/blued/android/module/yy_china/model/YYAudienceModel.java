package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYAudienceModel.class */
public class YYAudienceModel implements MultiItemEntity {
    public String age;
    public int anchor_level;
    public String avatar_frame;
    public String chat_anchor;
    public String enter_effects;
    public String enter_effects_forward;
    public String fans_group_level;
    public String fans_group_name;
    public int fans_group_status;
    public YYClubLevelInfoModel fans_info;
    public String height;
    public String invited;
    public int is_idol;
    public String is_mic;
    public int is_on_mic;
    public String message_bubble_icon;
    public String message_bubble_img;
    public ArrayList<YYRoomBasicPropItemMode> message_user_title;
    public int mic_position;
    public String mounts_icon;
    public String mounts_img;
    public String relationship;
    public String role;
    public String room_id;
    public YYRoomBasicPropItemMode speech_ripple;
    public int wealth_level;
    public String weight;
    private String uid = "";
    private String name = "";
    private String avatar = "";
    public int itemType = 0;
    public int is_top_fans = 0;

    public YYAudienceModel copy() {
        YYAudienceModel yYAudienceModel = new YYAudienceModel();
        yYAudienceModel.uid = getUid();
        yYAudienceModel.name = getName();
        yYAudienceModel.avatar = getAvatar();
        yYAudienceModel.role = this.role;
        yYAudienceModel.age = this.age;
        yYAudienceModel.height = this.height;
        yYAudienceModel.relationship = this.relationship;
        yYAudienceModel.is_mic = this.is_mic;
        yYAudienceModel.invited = this.invited;
        yYAudienceModel.chat_anchor = this.chat_anchor;
        yYAudienceModel.weight = this.weight;
        yYAudienceModel.mic_position = this.mic_position;
        yYAudienceModel.itemType = this.itemType;
        yYAudienceModel.wealth_level = this.wealth_level;
        yYAudienceModel.anchor_level = this.anchor_level;
        yYAudienceModel.avatar_frame = this.avatar_frame;
        yYAudienceModel.enter_effects = this.enter_effects;
        yYAudienceModel.enter_effects_forward = this.enter_effects_forward;
        yYAudienceModel.message_bubble_icon = this.message_bubble_icon;
        yYAudienceModel.message_bubble_img = this.message_bubble_img;
        yYAudienceModel.fans_group_name = this.fans_group_name;
        yYAudienceModel.fans_group_level = this.fans_group_level;
        yYAudienceModel.fans_group_status = this.fans_group_status;
        yYAudienceModel.is_top_fans = this.is_top_fans;
        yYAudienceModel.fans_info = this.fans_info;
        yYAudienceModel.is_idol = this.is_idol;
        yYAudienceModel.is_on_mic = this.is_on_mic;
        yYAudienceModel.room_id = this.room_id;
        return yYAudienceModel;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getChatAnchorName() {
        return "1".equals(this.chat_anchor) ? "房主" : "2".equals(this.chat_anchor) ? "场控" : "";
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getName() {
        return this.name;
    }

    public String getUid() {
        if (TextUtils.isEmpty(this.uid)) {
            this.uid = "";
        }
        return this.uid;
    }

    public void setAnchor_level(int i) {
        this.anchor_level = i;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatr_frame(String str) {
        this.avatar_frame = str;
    }

    public void setEnter_effects(String str) {
        this.enter_effects = str;
    }

    public void setEnter_effects_forward(String str) {
        this.enter_effects_forward = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setWealth_level(int i) {
        this.wealth_level = i;
    }
}
