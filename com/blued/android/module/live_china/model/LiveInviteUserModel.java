package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import com.blued.android.framework.utils.StringUtils;
import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveInviteUserModel.class */
public class LiveInviteUserModel implements Serializable {
    public int animCode;
    public boolean animing;
    public String avatar;
    public int buff_remain_time;
    public int buff_time;
    public int duration;
    public int durationRemain = 0;
    public int durationRemainPKEnd = 0;
    public int fb_time;
    public String first_kill_avatar;
    public boolean first_kill_hide;
    public String first_kill_message;
    public String first_kill_name;
    public String first_kill_uid;
    public String group_id;
    public double group_score;
    public int incr_score;
    public String interaction_text;
    public int is_multi_pk_end;
    public String lid;
    public String msg;
    public String mvp_avatar;
    public boolean mvp_hide;
    public String mvp_name;
    public String mvp_uid;
    public int my_count;
    public String my_group_id;
    public String name;
    public int other_count;
    public int rank;
    public int result;
    public double score;
    public boolean scoreChanged;
    public boolean show_btm;
    public int status;
    public String stream_id;
    public String uid;
    public int voice_disable;
    public int win_streak;

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.uid);
    }

    public boolean isGroup() {
        return StringUtils.a(this.my_group_id, 0) > 0;
    }

    public boolean isMyGroup() {
        return StringUtils.a(this.group_id, 0) == StringUtils.a(this.my_group_id, 0);
    }

    public String toString() {
        return "LiveInviteUserModel{uid=" + this.uid + ", name='" + this.name + "', avatar='" + this.avatar + "', stream_id='" + this.stream_id + "'}";
    }
}
