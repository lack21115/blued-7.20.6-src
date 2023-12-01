package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SatisfactionSetBase.class */
public class SatisfactionSetBase implements Serializable {
    private String companyId;
    private String configId;
    private String createTime;
    private String groupId;
    private String groupName;
    private String inputLanguage;
    private boolean isInputMust;
    private boolean isQuestionFlag;
    private boolean isTagMust;
    private String labelId;
    private String labelName;
    private String operateType;
    private String score;
    private String scoreExplain;
    private String settingMethod;
    private String tagTips;
    private String updateTime;
    private int defaultType = -1;
    private int scoreFlag = 0;

    public String getCompanyId() {
        return this.companyId;
    }

    public String getConfigId() {
        return this.configId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public int getDefaultType() {
        return this.defaultType;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getInputLanguage() {
        return this.inputLanguage;
    }

    public boolean getIsInputMust() {
        return this.isInputMust;
    }

    public boolean getIsQuestionFlag() {
        return this.isQuestionFlag;
    }

    public boolean getIsTagMust() {
        return this.isTagMust;
    }

    public String getLabelId() {
        return this.labelId;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public String getOperateType() {
        return this.operateType;
    }

    public String getScore() {
        return this.score;
    }

    public String getScoreExplain() {
        return this.scoreExplain;
    }

    public int getScoreFlag() {
        return this.scoreFlag;
    }

    public String getSettingMethod() {
        return this.settingMethod;
    }

    public String getTagTips() {
        return this.tagTips;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setConfigId(String str) {
        this.configId = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDefaultType(int i) {
        this.defaultType = i;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setInputLanguage(String str) {
        this.inputLanguage = str;
    }

    public void setIsInputMust(boolean z) {
        this.isInputMust = z;
    }

    public void setIsQuestionFlag(boolean z) {
        this.isQuestionFlag = z;
    }

    public void setIsTagMust(boolean z) {
        this.isTagMust = z;
    }

    public void setLabelId(String str) {
        this.labelId = str;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void setOperateType(String str) {
        this.operateType = str;
    }

    public void setScore(String str) {
        this.score = str;
    }

    public void setScoreExplain(String str) {
        this.scoreExplain = str;
    }

    public void setScoreFlag(int i) {
        this.scoreFlag = i;
    }

    public void setSettingMethod(String str) {
        this.settingMethod = str;
    }

    public void setTagTips(String str) {
        this.tagTips = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String toString() {
        return "SatisfactionSetBase{configId='" + this.configId + "', companyId='" + this.companyId + "', groupId='" + this.groupId + "', groupName='" + this.groupName + "', labelId='" + this.labelId + "', labelName='" + this.labelName + "', isQuestionFlag=" + this.isQuestionFlag + ", score='" + this.score + "', scoreExplain='" + this.scoreExplain + "', isTagMust=" + this.isTagMust + ", tagTips='" + this.tagTips + "', isInputMust=" + this.isInputMust + ", inputLanguage='" + this.inputLanguage + "', createTime='" + this.createTime + "', settingMethod='" + this.settingMethod + "', updateTime='" + this.updateTime + "', operateType='" + this.operateType + "', defaultType=" + this.defaultType + ", scoreFlag=" + this.scoreFlag + '}';
    }
}
