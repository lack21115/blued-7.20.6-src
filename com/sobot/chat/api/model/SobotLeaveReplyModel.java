package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotLeaveReplyModel.class */
public class SobotLeaveReplyModel implements Serializable {
    public String customerId;
    public String replyContent;
    public long replyTime;
    public String serviceNick;
    public String ticketId;
    public String ticketTitle;

    public String getCustomerId() {
        return this.customerId;
    }

    public String getReplyContent() {
        return this.replyContent;
    }

    public long getReplyTime() {
        return this.replyTime;
    }

    public String getServiceNick() {
        return this.serviceNick;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public String getTicketTitle() {
        return this.ticketTitle;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setReplyContent(String str) {
        this.replyContent = str;
    }

    public void setReplyTime(long j) {
        this.replyTime = j;
    }

    public void setServiceNick(String str) {
        this.serviceNick = str;
    }

    public void setTicketId(String str) {
        this.ticketId = str;
    }

    public void setTicketTitle(String str) {
        this.ticketTitle = str;
    }

    public String toString() {
        return "SobotLeaveReplyModel{ticketId='" + this.ticketId + "', ticketTitle='" + this.ticketTitle + "', replyContent='" + this.replyContent + "', replyTime='" + this.replyTime + "', customerId='" + this.customerId + "', serviceNick='" + this.serviceNick + "'}";
    }
}
