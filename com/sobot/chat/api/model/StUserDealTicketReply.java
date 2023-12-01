package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/StUserDealTicketReply.class */
public class StUserDealTicketReply implements Serializable {
    private String replyContent;
    private long replyTime;
    private int startType;

    public String getReplyContent() {
        return this.replyContent;
    }

    public long getReplyTime() {
        return this.replyTime;
    }

    public int getStartType() {
        return this.startType;
    }

    public void setReplyContent(String str) {
        this.replyContent = str;
    }

    public void setReplyTime(long j) {
        this.replyTime = j;
    }

    public void setStartType(int i) {
        this.startType = i;
    }
}
