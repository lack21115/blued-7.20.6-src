package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotUserTicketInfo.class */
public class SobotUserTicketInfo implements Serializable {
    private String content;
    private ArrayList<SobotFileModel> fileList;
    private int flag;
    private boolean newFlag;
    private String ticketCode;
    private String ticketId;
    private String time;
    private String timeStr;

    public String getContent() {
        return this.content;
    }

    public ArrayList<SobotFileModel> getFileList() {
        return this.fileList;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getTicketCode() {
        return this.ticketCode;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public String getTime() {
        return this.time;
    }

    public String getTimeStr() {
        return this.timeStr;
    }

    public boolean isNewFlag() {
        return this.newFlag;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFileList(ArrayList<SobotFileModel> arrayList) {
        this.fileList = arrayList;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setNewFlag(boolean z) {
        this.newFlag = z;
    }

    public void setTicketCode(String str) {
        this.ticketCode = str;
    }

    public void setTicketId(String str) {
        this.ticketId = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setTimeStr(String str) {
        this.timeStr = str;
    }
}
