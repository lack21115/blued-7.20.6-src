package com.soft.blued.ui.msg_group.model;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/ReportJsonModel.class */
public class ReportJsonModel {
    public String[] attachments;
    public int check_attachments;
    public List<ReportMsgContent> contexts;
    public long group_id;
    public String reason;
    public String reason_desc;
    public int report_type;
    public long report_uid;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/ReportJsonModel$ReportMsgContent.class */
    public static class ReportMsgContent {
        public String contents;
        public long createdAt;
        public long messageId;
        public int report;
        public String type;
        public long uid;
        public String url;

        public void setMsgTypeString(int i) {
            if (i == 1) {
                this.type = "TEXT";
            } else if (i == 2) {
                this.type = "IMAGE";
            } else if (i == 3) {
                this.type = "SOUND";
            } else if (i == 5) {
                this.type = "VIDEO";
            } else {
                this.type = i + "";
            }
        }
    }
}
