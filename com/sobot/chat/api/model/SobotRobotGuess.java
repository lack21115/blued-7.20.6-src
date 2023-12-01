package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotRobotGuess.class */
public class SobotRobotGuess implements Serializable {
    private String originQuestion;
    private List<RespInfoListBean> respInfoList;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotRobotGuess$RespInfoListBean.class */
    public static class RespInfoListBean {
        private String docId;
        private String highlight;
        private String question;

        public String getDocId() {
            return this.docId;
        }

        public String getHighlight() {
            return this.highlight;
        }

        public String getQuestion() {
            return this.question;
        }

        public void setDocId(String str) {
            this.docId = str;
        }

        public void setHighlight(String str) {
            this.highlight = str;
        }

        public void setQuestion(String str) {
            this.question = str;
        }
    }

    public String getOriginQuestion() {
        return this.originQuestion;
    }

    public List<RespInfoListBean> getRespInfoList() {
        return this.respInfoList;
    }

    public void setOriginQuestion(String str) {
        this.originQuestion = str;
    }

    public void setRespInfoList(List<RespInfoListBean> list) {
        this.respInfoList = list;
    }
}
