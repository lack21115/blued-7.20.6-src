package com.blued.android.module.yy_china.model;

import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYReportModel.class */
public class YYReportModel {
    public String anchor;
    public List<String> members;
    public List<YYReportMsg> msg;
    public String reason;
    public int reportType;
    public String room_id;
    public String uid;

    public String toString() {
        return "YYReportModel{room_id='" + this.room_id + "', members=" + this.members + ", reason='" + this.reason + "', uid='" + this.uid + "', msg=" + this.msg + '}';
    }
}
