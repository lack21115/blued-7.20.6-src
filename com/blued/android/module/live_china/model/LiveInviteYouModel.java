package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveInviteYouModel.class */
public class LiveInviteYouModel implements Serializable {
    public String avatar;
    public String name;
    public int timeout;
    public int type;
    public long uid;
    public List<LiveInviteUserModel> users;

    public String toString() {
        return "LiveInviteModel{uid=" + this.uid + ", name='" + this.name + "', type=" + this.type + ", users=" + this.users + '}';
    }
}
