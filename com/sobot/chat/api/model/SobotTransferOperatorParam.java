package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotTransferOperatorParam.class */
public class SobotTransferOperatorParam implements Serializable {
    private ConsultingContent consultingContent;
    private String groupId;
    private String groupName;
    private boolean isShowTips;
    private String keyword;
    private String keywordId;
    private Map<String, String> summaryParams;
    private Map<String, String> summary_params;
    private int transferType;

    public ConsultingContent getConsultingContent() {
        return this.consultingContent;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getKeywordId() {
        return this.keywordId;
    }

    @Deprecated
    public Map<String, String> getSummaryParams() {
        return this.summaryParams;
    }

    public Map<String, String> getSummary_params() {
        return this.summary_params;
    }

    public int getTransferType() {
        return this.transferType;
    }

    public boolean isShowTips() {
        return this.isShowTips;
    }

    public void setConsultingContent(ConsultingContent consultingContent) {
        this.consultingContent = consultingContent;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setKeywordId(String str) {
        this.keywordId = str;
    }

    public void setShowTips(boolean z) {
        this.isShowTips = z;
    }

    @Deprecated
    public void setSummaryParams(Map<String, String> map) {
        this.summaryParams = map;
        this.summary_params = map;
    }

    public void setSummary_params(Map<String, String> map) {
        this.summary_params = map;
        this.summaryParams = map;
    }

    public void setTransferType(int i) {
        this.transferType = i;
    }
}
