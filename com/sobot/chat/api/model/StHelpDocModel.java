package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/StHelpDocModel.class */
public class StHelpDocModel implements Serializable {
    private String answerDesc;
    private String companyId;
    private String docId;
    private String questionTitle;

    public String getAnswerDesc() {
        return this.answerDesc;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public String getDocId() {
        return this.docId;
    }

    public String getQuestionTitle() {
        return this.questionTitle;
    }

    public void setAnswerDesc(String str) {
        this.answerDesc = str;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setDocId(String str) {
        this.docId = str;
    }

    public void setQuestionTitle(String str) {
        this.questionTitle = str;
    }
}
