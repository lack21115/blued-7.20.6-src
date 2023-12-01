package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiHistorySDKMsg.class */
public class ZhiChiHistorySDKMsg implements Serializable {
    private static final long serialVersionUID = 1;
    private ZhiChiReplyAnswer answer;
    private String answerType;

    public ZhiChiReplyAnswer getAnswer() {
        return this.answer;
    }

    public String getAnswerType() {
        return this.answerType;
    }

    public void setAnswer(ZhiChiReplyAnswer zhiChiReplyAnswer) {
        this.answer = zhiChiReplyAnswer;
    }

    public void setAnswerType(String str) {
        this.answerType = str;
    }

    public String toString() {
        return "ZhiChiHistorySDKMsg{answer=" + this.answer + ", answerType='" + this.answerType + "'}";
    }
}
