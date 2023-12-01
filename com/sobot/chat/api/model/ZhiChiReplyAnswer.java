package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiReplyAnswer.class */
public class ZhiChiReplyAnswer implements Serializable {
    private static final long serialVersionUID = 1;
    private SobotCacheFile cacheFile;
    private String duration;
    private String id;
    private List<Map<String, String>> interfaceRetList;
    private SobotLocationModel locationData;
    private String msg;
    private String msgStripe;
    private String msgTransfer;
    private String msgType;
    private SobotMultiDiaRespInfo multiDiaRespInfo;
    private SobotQuestionRecommend questionRecommend;
    private int remindType = 0;
    private List<ChatMessageRichListModel> richList;

    public SobotCacheFile getCacheFile() {
        return this.cacheFile;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getId() {
        return this.id;
    }

    public List<Map<String, String>> getInterfaceRetList() {
        return this.interfaceRetList;
    }

    public SobotLocationModel getLocationData() {
        return this.locationData;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getMsgStripe() {
        return this.msgStripe;
    }

    public String getMsgTransfer() {
        return this.msgTransfer;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public SobotMultiDiaRespInfo getMultiDiaRespInfo() {
        return this.multiDiaRespInfo;
    }

    public SobotQuestionRecommend getQuestionRecommend() {
        return this.questionRecommend;
    }

    public int getRemindType() {
        return this.remindType;
    }

    public List<ChatMessageRichListModel> getRichList() {
        return this.richList;
    }

    public void setCacheFile(SobotCacheFile sobotCacheFile) {
        this.cacheFile = sobotCacheFile;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInterfaceRetList(List<Map<String, String>> list) {
        this.interfaceRetList = list;
    }

    public void setLocationData(SobotLocationModel sobotLocationModel) {
        this.locationData = sobotLocationModel;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setMsgStripe(String str) {
        this.msgStripe = str;
    }

    public void setMsgTransfer(String str) {
        this.msgTransfer = str;
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }

    public void setMultiDiaRespInfo(SobotMultiDiaRespInfo sobotMultiDiaRespInfo) {
        this.multiDiaRespInfo = sobotMultiDiaRespInfo;
    }

    public void setQuestionRecommend(SobotQuestionRecommend sobotQuestionRecommend) {
        this.questionRecommend = sobotQuestionRecommend;
    }

    public void setRemindType(int i) {
        this.remindType = i;
    }

    public void setRichList(List<ChatMessageRichListModel> list) {
        this.richList = list;
    }

    public String toString() {
        return "ZhiChiReplyAnswer{id='" + this.id + "', msgType='" + this.msgType + "', msg='" + this.msg + "', duration='" + this.duration + "', msgStripe='" + this.msgStripe + "', msgTransfer='" + this.msgTransfer + "', remindType=" + this.remindType + ", multiDiaRespInfo=" + this.multiDiaRespInfo + ", interfaceRetList=" + this.interfaceRetList + ", questionRecommend=" + this.questionRecommend + ", cacheFile=" + this.cacheFile + ", locationData=" + this.locationData + ", richList=" + this.richList + '}';
    }
}
