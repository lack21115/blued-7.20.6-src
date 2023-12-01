package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomPkModel.class */
public class LiveRoomPkModel implements Serializable {
    public String avatar;
    public String blued_badge_pic;
    public long buff_countdown;
    public int count;
    public int countdown;
    public int delay;
    public String first_kill_message;
    public long lid;
    public String name;
    public boolean pk_status;
    public int pk_type;
    public List<MuteLiveAudioModel> pk_voice_operate;
    public List<LivePKPlayerModel> records;
    public int rich_level;
    public int status;
    public List<LivePKProgressUserModel> target_top;
    public List<LivePKProgressUserModel> top;
    public int type;
    public String uid;
    public long winner;

    public String toString() {
        return "LiveRoomPkModel{uid='" + this.uid + "', winner=" + this.winner + ", name='" + this.name + "', avatar='" + this.avatar + "', type=" + this.type + ", lid=" + this.lid + ", rich_level=" + this.rich_level + ", blued_badge_pic='" + this.blued_badge_pic + "', buff_countdown=" + this.buff_countdown + ", countdown=" + this.countdown + ", records=" + this.records + ", top=" + this.top + ", target_top=" + this.target_top + ", count=" + this.count + ", pk_status=" + this.pk_status + ", pk_type=" + this.pk_type + ", delay=" + this.delay + ", status=" + this.status + '}';
    }
}
