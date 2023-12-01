package com.igexin.sdk.message;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/message/GTNotificationMessage.class */
public class GTNotificationMessage extends GTPushMessage {
    private String content;
    private String messageId;
    private String taskId;
    private String title;

    public GTNotificationMessage() {
    }

    public GTNotificationMessage(String str, String str2, String str3, String str4) {
        this.taskId = str;
        this.messageId = str2;
        this.title = str3;
        this.content = str4;
    }

    public String getContent() {
        return this.content;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
