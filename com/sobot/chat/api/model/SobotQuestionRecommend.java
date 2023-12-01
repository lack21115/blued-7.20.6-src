package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotQuestionRecommend.class */
public class SobotQuestionRecommend implements Serializable {
    private String guide;
    private List<SobotQRMsgBean> msg;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotQuestionRecommend$SobotQRMsgBean.class */
    public static class SobotQRMsgBean {
        private String icon;
        private String id;
        private String question;
        private String title;
        private String url;

        public String getIcon() {
            return this.icon;
        }

        public String getId() {
            return this.id;
        }

        public String getQuestion() {
            return this.question;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setQuestion(String str) {
            this.question = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public String getGuide() {
        return this.guide;
    }

    public List<SobotQRMsgBean> getMsg() {
        return this.msg;
    }

    public void setGuide(String str) {
        this.guide = str;
    }

    public void setMsg(List<SobotQRMsgBean> list) {
        this.msg = list;
    }
}
