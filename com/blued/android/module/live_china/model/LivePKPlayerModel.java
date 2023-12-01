package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePKPlayerModel.class */
public class LivePKPlayerModel implements Serializable {
    public String anim_code;
    public String ar_url;
    public String avatar;
    public String name;
    public List<Integer> pk_result;
    public int score;
    public int target_beans;
    public int target_streak;
    public int total_beans;
    public long uid;
    public int win_count;
    public int win_streak;

    public String toString() {
        return "LivePKPlayerModel{uid=" + this.uid + ", avatar='" + this.avatar + "', score=" + this.score + ", ar_url='" + this.ar_url + "', anim_code='" + this.anim_code + "', win_streak=" + this.win_streak + ", win_count=" + this.win_count + ", pk_result=" + this.pk_result + ", target_streak=" + this.target_streak + ", target_beans=" + this.target_beans + ", total_beans=" + this.total_beans + '}';
    }
}
