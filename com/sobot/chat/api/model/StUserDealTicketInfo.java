package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/StUserDealTicketInfo.class */
public class StUserDealTicketInfo implements Serializable {
    private String content;
    private SobotUserTicketEvaluate evaluate;
    private ArrayList<SobotFileModel> fileList;
    private int flag;
    private StUserDealTicketReply reply;
    private int startType;
    private String time;
    private String timeStr;

    public String getContent() {
        return this.content;
    }

    public SobotUserTicketEvaluate getEvaluate() {
        return this.evaluate;
    }

    public ArrayList<SobotFileModel> getFileList() {
        return this.fileList;
    }

    public int getFlag() {
        return this.flag;
    }

    public StUserDealTicketReply getReply() {
        return this.reply;
    }

    public int getStartType() {
        return this.startType;
    }

    public String getTime() {
        return this.time;
    }

    public String getTimeStr() {
        return this.timeStr;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEvaluate(SobotUserTicketEvaluate sobotUserTicketEvaluate) {
        this.evaluate = sobotUserTicketEvaluate;
    }

    public void setFileList(ArrayList<SobotFileModel> arrayList) {
        this.fileList = arrayList;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setReply(StUserDealTicketReply stUserDealTicketReply) {
        this.reply = stUserDealTicketReply;
    }

    public void setStartType(int i) {
        this.startType = i;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setTimeStr(String str) {
        this.timeStr = str;
    }
}
