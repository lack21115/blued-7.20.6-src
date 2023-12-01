package com.blued.android.module.yy_china.model;

import java.io.Serializable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomMemberInfoModel.class */
public class YYRoomMemberInfoModel extends YYSeatMemberModel implements Serializable {
    public int mute;
    public String pk_level_img;
    public String pk_level_name;
    public int seat_type;

    @Override // com.blued.android.module.yy_china.model.YYSeatMemberModel, com.blued.android.module.yy_china.model.YYAudienceModel
    public YYRoomMemberInfoModel copy() {
        YYRoomMemberInfoModel yYRoomMemberInfoModel = new YYRoomMemberInfoModel();
        yYRoomMemberInfoModel.setUid(getUid());
        yYRoomMemberInfoModel.setName(getName());
        yYRoomMemberInfoModel.setAvatar(getAvatar());
        yYRoomMemberInfoModel.role = this.role;
        yYRoomMemberInfoModel.chat_anchor = this.chat_anchor;
        yYRoomMemberInfoModel.relationship = this.relationship;
        yYRoomMemberInfoModel.mic_position = this.mic_position;
        yYRoomMemberInfoModel.invited = this.invited;
        yYRoomMemberInfoModel.age = this.age;
        yYRoomMemberInfoModel.height = this.height;
        yYRoomMemberInfoModel.is_mic = this.is_mic;
        yYRoomMemberInfoModel.weight = this.weight;
        yYRoomMemberInfoModel.position_status = this.position_status;
        yYRoomMemberInfoModel.is_open_mic = this.is_open_mic;
        yYRoomMemberInfoModel.publish_url = this.publish_url;
        yYRoomMemberInfoModel.apngUrl = this.apngUrl;
        yYRoomMemberInfoModel.emojiModel = this.emojiModel;
        yYRoomMemberInfoModel.isVoted = this.isVoted;
        yYRoomMemberInfoModel.likeNum = this.likeNum;
        yYRoomMemberInfoModel.chat_anchor = this.chat_anchor;
        yYRoomMemberInfoModel.election = this.election;
        yYRoomMemberInfoModel.team_num = this.team_num;
        yYRoomMemberInfoModel.gift_value = this.gift_value;
        yYRoomMemberInfoModel.captain = this.captain;
        yYRoomMemberInfoModel.value_order = this.value_order;
        yYRoomMemberInfoModel.next_wealth = this.next_wealth;
        yYRoomMemberInfoModel.current_wealth = this.current_wealth;
        yYRoomMemberInfoModel.isSelected = this.isSelected;
        yYRoomMemberInfoModel.isVip = this.isVip;
        yYRoomMemberInfoModel.setHit_count(getHit_count());
        yYRoomMemberInfoModel.setHit_id(getHit_id());
        yYRoomMemberInfoModel.mute = this.mute;
        yYRoomMemberInfoModel.seat_type = this.seat_type;
        yYRoomMemberInfoModel.pk_level_img = this.pk_level_img;
        yYRoomMemberInfoModel.pk_level_name = this.pk_level_name;
        return yYRoomMemberInfoModel;
    }
}
