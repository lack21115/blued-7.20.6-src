package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/StDocModel.class */
public class StDocModel implements Serializable {
    private String companyId;
    private String docId;
    private String questionId;
    private String questionTitle;

    public String getCompanyId() {
        return this.companyId;
    }

    public String getDocId() {
        return this.docId;
    }

    public String getQuestionId() {
        return this.questionId;
    }

    public String getQuestionTitle() {
        return this.questionTitle;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setDocId(String str) {
        this.docId = str;
    }

    public void setQuestionId(String str) {
        this.questionId = str;
    }

    public void setQuestionTitle(String str) {
        this.questionTitle = str;
    }

    public String toString() {
        return "StDocModel{companyId='" + this.companyId + "', docId='" + this.docId + "', questionId='" + this.questionId + "', questionTitle='" + this.questionTitle + "'}";
    }
}
