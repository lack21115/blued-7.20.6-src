package com.blued.android.module.yy_china.model;

import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRetryRoomModel.class */
public class YYRetryRoomModel extends YYRoomModel {
    public List<BlindPublishModel> blind_publish;
    public String game_captain;
    public String is_mic;
    public int is_open_mic;
    public long pk_countdown;
    public long vote_countdown;

    public String toString() {
        return "YYRetryRoomModel{is_open_mic=" + this.is_open_mic + ", chat_anchor='" + this.chat_anchor + "', is_mic='" + this.is_mic + "', room_id='" + this.room_id + "', room_name='" + this.room_name + "', mute='" + this.mute + "', vote_countdown='" + this.vote_countdown + "', pk_countdown='" + this.pk_countdown + "'}";
    }
}
