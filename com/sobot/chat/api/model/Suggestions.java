package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/Suggestions.class */
public class Suggestions implements Serializable {
    private String answer;
    private String docId;
    private String question;

    public String getAnswer() {
        return this.answer;
    }

    public String getDocId() {
        return this.docId;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public void setDocId(String str) {
        this.docId = str;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public String toString() {
        return "Suggestions{question='" + this.question + "', docId='" + this.docId + "', answer='" + this.answer + "'}";
    }
}
