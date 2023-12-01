package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiPushMessage.class */
public class ZhiChiPushMessage implements Serializable {
    private static final long serialVersionUID = 1;
    private String adminHelloWord;
    private String aface;
    private String aname;
    private ZhiChiReplyAnswer answer;
    private String appId;
    private ConsultingContent consultingContent;
    private String content;
    private String count;
    private String face;
    private int isQuestionFlag;
    private int lockType;
    private String message;
    private String msgId;
    private String msgType;
    private String name;
    private OrderCardContentModel orderCardContent;
    private String puid;
    private String queueDoc;
    private String revokeMsgId;
    private String serviceEndPushMsg;
    private String serviceOutDoc;
    private String serviceOutTime;
    private String status;
    private String sysType;
    private int type;

    public String getAdminHelloWord() {
        return this.adminHelloWord;
    }

    public String getAface() {
        return this.aface;
    }

    public String getAname() {
        return this.aname;
    }

    public ZhiChiReplyAnswer getAnswer() {
        return this.answer;
    }

    public String getAppId() {
        return this.appId;
    }

    public ConsultingContent getConsultingContent() {
        return this.consultingContent;
    }

    public String getContent() {
        return this.content;
    }

    public String getCount() {
        return this.count;
    }

    public String getFace() {
        return this.face;
    }

    public int getIsQuestionFlag() {
        return this.isQuestionFlag;
    }

    public int getLockType() {
        return this.lockType;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public String getName() {
        return this.name;
    }

    public OrderCardContentModel getOrderCardContent() {
        return this.orderCardContent;
    }

    public String getPuid() {
        return this.puid;
    }

    public String getQueueDoc() {
        return this.queueDoc;
    }

    public String getRevokeMsgId() {
        return this.revokeMsgId;
    }

    public String getServiceEndPushMsg() {
        return this.serviceEndPushMsg;
    }

    public String getServiceOutDoc() {
        return this.serviceOutDoc;
    }

    public String getServiceOutTime() {
        return this.serviceOutTime;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSysType() {
        return this.sysType;
    }

    public int getType() {
        return this.type;
    }

    public void setAdminHelloWord(String str) {
        this.adminHelloWord = str;
    }

    public void setAface(String str) {
        this.aface = str;
    }

    public void setAname(String str) {
        this.aname = str;
    }

    public void setAnswer(ZhiChiReplyAnswer zhiChiReplyAnswer) {
        this.answer = zhiChiReplyAnswer;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setConsultingContent(ConsultingContent consultingContent) {
        this.consultingContent = consultingContent;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setFace(String str) {
        this.face = str;
    }

    public void setIsQuestionFlag(int i) {
        this.isQuestionFlag = i;
    }

    public void setLockType(int i) {
        this.lockType = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrderCardContent(OrderCardContentModel orderCardContentModel) {
        this.orderCardContent = orderCardContentModel;
    }

    public void setPuid(String str) {
        this.puid = str;
    }

    public void setQueueDoc(String str) {
        this.queueDoc = str;
    }

    public void setRevokeMsgId(String str) {
        this.revokeMsgId = str;
    }

    public void setServiceEndPushMsg(String str) {
        this.serviceEndPushMsg = str;
    }

    public void setServiceOutDoc(String str) {
        this.serviceOutDoc = str;
    }

    public void setServiceOutTime(String str) {
        this.serviceOutTime = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSysType(String str) {
        this.sysType = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "ZhiChiPushMessage{type=" + this.type + ", aname='" + this.aname + "', aface='" + this.aface + "', content='" + this.content + "', status='" + this.status + "', msgType='" + this.msgType + "', count='" + this.count + "', name='" + this.name + "', face='" + this.face + "', isQuestionFlag=" + this.isQuestionFlag + ", adminHelloWord='" + this.adminHelloWord + "', serviceEndPushMsg='" + this.serviceEndPushMsg + "', serviceOutTime='" + this.serviceOutTime + "', serviceOutDoc='" + this.serviceOutDoc + "', queueDoc='" + this.queueDoc + "', appId='" + this.appId + "', lockType=" + this.lockType + ", msgId='" + this.msgId + "', revokeMsgId='" + this.revokeMsgId + "', answer=" + this.answer + ", consultingContent=" + this.consultingContent + ", orderCardContent=" + this.orderCardContent + ", message='" + this.message + "', sysType='" + this.sysType + "', puid='" + this.puid + "'}";
    }
}
