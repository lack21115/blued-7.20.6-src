package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveInviteUpdateModel.class */
public class LiveInviteUpdateModel implements Serializable {
    public int action;
    public int action_type;
    public LiveInviteUserModel action_users;
    public String first_kill_message;
    public LiveInviteMvpModel mvp;
    public List<LiveInviteUserModel> users;
}
