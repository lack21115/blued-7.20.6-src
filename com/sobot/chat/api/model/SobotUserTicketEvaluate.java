package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotUserTicketEvaluate.class */
public class SobotUserTicketEvaluate implements Serializable {
    private boolean isEvalution;
    private boolean isOpen;
    private String remark;
    private int score;
    private List<TicketScoreInfooListBean> ticketScoreInfooList;
    private boolean txtFlag;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotUserTicketEvaluate$TicketScoreInfooListBean.class */
    public static class TicketScoreInfooListBean implements Serializable {
        private String companyId;
        private String configId;
        private String createId;
        private long createTime;
        private int score;
        private String scoreExplain;
        private String scoreId;
        private String updateId;
        private long updateTime;

        public String getCompanyId() {
            return this.companyId;
        }

        public String getConfigId() {
            return this.configId;
        }

        public String getCreateId() {
            return this.createId;
        }

        public long getCreateTime() {
            return this.createTime;
        }

        public int getScore() {
            return this.score;
        }

        public String getScoreExplain() {
            return this.scoreExplain;
        }

        public String getScoreId() {
            return this.scoreId;
        }

        public String getUpdateId() {
            return this.updateId;
        }

        public long getUpdateTime() {
            return this.updateTime;
        }

        public void setCompanyId(String str) {
            this.companyId = str;
        }

        public void setConfigId(String str) {
            this.configId = str;
        }

        public void setCreateId(String str) {
            this.createId = str;
        }

        public void setCreateTime(long j) {
            this.createTime = j;
        }

        public void setScore(int i) {
            this.score = i;
        }

        public void setScoreExplain(String str) {
            this.scoreExplain = str;
        }

        public void setScoreId(String str) {
            this.scoreId = str;
        }

        public void setUpdateId(String str) {
            this.updateId = str;
        }

        public void setUpdateTime(long j) {
            this.updateTime = j;
        }
    }

    public String getRemark() {
        return this.remark;
    }

    public int getScore() {
        return this.score;
    }

    public List<TicketScoreInfooListBean> getTicketScoreInfooList() {
        return this.ticketScoreInfooList;
    }

    public boolean isEvalution() {
        return this.isEvalution;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public boolean isTxtFlag() {
        return this.txtFlag;
    }

    public void setEvalution(boolean z) {
        this.isEvalution = z;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setScore(int i) {
        this.score = i;
    }

    public void setTicketScoreInfooList(List<TicketScoreInfooListBean> list) {
        this.ticketScoreInfooList = list;
    }

    public void setTxtFlag(boolean z) {
        this.txtFlag = z;
    }
}
