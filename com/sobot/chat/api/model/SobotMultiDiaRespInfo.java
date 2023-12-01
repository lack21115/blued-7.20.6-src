package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotMultiDiaRespInfo.class */
public class SobotMultiDiaRespInfo implements Serializable {
    private String answer;
    private String answerStrip;
    private int clickFlag;
    private String conversationId;
    private boolean endFlag;
    private List<Map<String, String>> icLists;
    private String[] inputContentList;
    private List<Map<String, String>> interfaceRetList;
    private String leaveTemplateId;
    private int level;
    private String[] outPutParamList;
    private int pageNum = 1;
    private String remindQuestion;
    private String retCode;
    private String retErrorMsg;
    private String template;

    public String getAnswer() {
        return this.answer;
    }

    public String getAnswerStrip() {
        return this.answerStrip;
    }

    public int getClickFlag() {
        return this.clickFlag;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public boolean getEndFlag() {
        return this.endFlag;
    }

    public List<Map<String, String>> getIcLists() {
        return this.icLists;
    }

    public String[] getInputContentList() {
        return this.inputContentList;
    }

    public List<Map<String, String>> getInterfaceRetList() {
        return this.interfaceRetList;
    }

    public String getLeaveTemplateId() {
        return this.leaveTemplateId;
    }

    public int getLevel() {
        return this.level;
    }

    public String[] getOutPutParamList() {
        return this.outPutParamList;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public String getRemindQuestion() {
        return this.remindQuestion;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetErrorMsg() {
        return this.retErrorMsg;
    }

    public String getTemplate() {
        return this.template;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setAnswerStrip(String str) {
        this.answerStrip = str;
    }

    public void setClickFlag(int i) {
        this.clickFlag = i;
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }

    public void setEndFlag(boolean z) {
        this.endFlag = z;
    }

    public void setIcLists(List<Map<String, String>> list) {
        this.icLists = list;
    }

    public void setInputContentList(String[] strArr) {
        this.inputContentList = strArr;
    }

    public void setInterfaceRetList(List<Map<String, String>> list) {
        this.interfaceRetList = list;
    }

    public void setLeaveTemplateId(String str) {
        this.leaveTemplateId = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setOutPutParamList(String[] strArr) {
        this.outPutParamList = strArr;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public void setRemindQuestion(String str) {
        this.remindQuestion = str;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetErrorMsg(String str) {
        this.retErrorMsg = str;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public String toString() {
        return "SobotMultiDiaRespInfo{remindQuestion='" + this.remindQuestion + "', interfaceRetList=" + this.interfaceRetList + ", inputContentList=" + Arrays.toString(this.inputContentList) + ", outPutParamList=" + Arrays.toString(this.outPutParamList) + ", level='" + this.level + "', conversationId='" + this.conversationId + "', retCode='" + this.retCode + "', retErrorMsg='" + this.retErrorMsg + "', endFlag=" + this.endFlag + ", answerStrip='" + this.answerStrip + "', template='" + this.template + "', answer='" + this.answer + "', clickFlag=" + this.clickFlag + ", pageNum=" + this.pageNum + ", icLists=" + this.icLists + '}';
    }
}
