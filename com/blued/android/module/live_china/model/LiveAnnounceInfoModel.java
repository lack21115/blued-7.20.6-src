package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveAnnounceInfoModel.class */
public class LiveAnnounceInfoModel implements Serializable {
    public int controller;
    public int fans_group_controller;
    public String fans_group_id;
    public List<LiveAnnounceFansModel> fans_group_info;
    public int fans_group_remind_time;
    public long live_time;
    public int live_time_controller;
    public String live_week_time;
    public String notice;
    public int notice_controller;
}
