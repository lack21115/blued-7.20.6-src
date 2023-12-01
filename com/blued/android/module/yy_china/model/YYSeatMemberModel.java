package com.blued.android.module.yy_china.model;

import java.io.Serializable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYSeatMemberModel.class */
public class YYSeatMemberModel extends YYAudienceModel implements Serializable {
    public String apngUrl;
    public String captain;
    public YyWealthModel current_wealth;
    public String election;
    public YYImModel emojiModel;
    public String gift_value;
    private int hit_count;
    private long hit_id;
    public boolean isSelected;
    public int is_open_mic;
    public String likeNum;
    public YyWealthModel next_wealth;
    public int position_status;
    public String publish_url;
    public String team_num;
    public String value_order;
    public boolean isVoted = false;
    public boolean isVip = false;
    public boolean isBoss = false;
    public boolean isFirstToMicsInTeam = true;

    @Override // com.blued.android.module.yy_china.model.YYAudienceModel
    public YYSeatMemberModel copy() {
        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
        yYSeatMemberModel.setUid(getUid());
        yYSeatMemberModel.setName(getName());
        yYSeatMemberModel.setAvatar(getAvatar());
        yYSeatMemberModel.role = this.role;
        yYSeatMemberModel.chat_anchor = this.chat_anchor;
        yYSeatMemberModel.relationship = this.relationship;
        yYSeatMemberModel.mic_position = this.mic_position;
        yYSeatMemberModel.invited = this.invited;
        yYSeatMemberModel.age = this.age;
        yYSeatMemberModel.height = this.height;
        yYSeatMemberModel.is_mic = this.is_mic;
        yYSeatMemberModel.weight = this.weight;
        yYSeatMemberModel.position_status = this.position_status;
        yYSeatMemberModel.is_open_mic = this.is_open_mic;
        yYSeatMemberModel.publish_url = this.publish_url;
        yYSeatMemberModel.apngUrl = this.apngUrl;
        yYSeatMemberModel.emojiModel = this.emojiModel;
        yYSeatMemberModel.isVoted = this.isVoted;
        yYSeatMemberModel.likeNum = this.likeNum;
        yYSeatMemberModel.chat_anchor = this.chat_anchor;
        yYSeatMemberModel.election = this.election;
        yYSeatMemberModel.team_num = this.team_num;
        yYSeatMemberModel.gift_value = this.gift_value;
        yYSeatMemberModel.captain = this.captain;
        yYSeatMemberModel.value_order = this.value_order;
        yYSeatMemberModel.next_wealth = this.next_wealth;
        yYSeatMemberModel.current_wealth = this.current_wealth;
        yYSeatMemberModel.isSelected = this.isSelected;
        yYSeatMemberModel.isVip = this.isVip;
        yYSeatMemberModel.isBoss = this.isBoss;
        yYSeatMemberModel.hit_count = this.hit_count;
        yYSeatMemberModel.hit_id = this.hit_id;
        yYSeatMemberModel.isFirstToMicsInTeam = this.isFirstToMicsInTeam;
        return yYSeatMemberModel;
    }

    public int getHit_count() {
        return this.hit_count;
    }

    public long getHit_id() {
        return this.hit_id;
    }

    public void setHit_count(int i) {
        this.hit_count = i;
    }

    public void setHit_id(long j) {
        this.hit_id = j;
    }
}
