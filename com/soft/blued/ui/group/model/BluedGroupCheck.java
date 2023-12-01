package com.soft.blued.ui.group.model;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/BluedGroupCheck.class */
public class BluedGroupCheck {
    String able;
    public GroupFailureReason reason;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/BluedGroupCheck$AccountFailure.class */
    public static class AccountFailure {
        public String able;
        public String reason;

        public String getAble() {
            return this.able;
        }

        public String getReason() {
            return this.reason;
        }

        public void setAble(String str) {
            this.able = str;
        }

        public void setReason(String str) {
            this.reason = str;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/BluedGroupCheck$GroupFailure.class */
    public static class GroupFailure {
        public String able;
        public List<String> reason;

        public String getAble() {
            return this.able;
        }

        public List<String> getReason() {
            return this.reason;
        }

        public void setAble(String str) {
            this.able = str;
        }

        public void setReason(List<String> list) {
            this.reason = list;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/BluedGroupCheck$GroupFailureReason.class */
    public static class GroupFailureReason {
        public AccountFailure days;
        public GroupFailure num;

        public AccountFailure getDays() {
            return this.days;
        }

        public GroupFailure getNum() {
            return this.num;
        }

        public void setDays(AccountFailure accountFailure) {
            this.days = accountFailure;
        }

        public void setNum(GroupFailure groupFailure) {
            this.num = groupFailure;
        }
    }

    public String getAble() {
        return this.able;
    }

    public GroupFailureReason getReason() {
        return this.reason;
    }

    public void setAble(String str) {
        this.able = str;
    }

    public void setReason(GroupFailureReason groupFailureReason) {
        this.reason = groupFailureReason;
    }
}
