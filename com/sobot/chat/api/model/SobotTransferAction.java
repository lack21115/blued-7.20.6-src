package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotTransferAction.class */
public class SobotTransferAction implements Serializable {
    private String actionType;
    private String deciId;
    private String optionId;
    private String spillId;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotTransferAction$Builder.class */
    public static class Builder {
        private String actionType = "to_group";
        private String deciId;
        private String optionId;
        private String spillId;

        public SobotTransferAction Build() {
            return new SobotTransferAction(this);
        }

        public Builder conditionIntelligentudgement() {
            this.spillId = "7";
            return this;
        }

        public Builder conditionServiceBusy() {
            this.spillId = "5";
            return this;
        }

        public Builder conditionServiceOffWork() {
            this.spillId = "6";
            return this;
        }

        public Builder conditionServiceOffline() {
            this.spillId = "4";
            return this;
        }

        public Builder designatedSkillId(String str) {
            this.deciId = str;
            return this;
        }

        public Builder no_overflow() {
            this.optionId = "4";
            return this;
        }

        public Builder overflow() {
            this.optionId = "3";
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotTransferAction$ServiceBuilder.class */
    public static class ServiceBuilder {
        private String actionType = "to_service";
        private String deciId;
        private String optionId;
        private String spillId;

        public SobotTransferAction ServiceBuilder() {
            return new SobotTransferAction(this);
        }

        public ServiceBuilder conditionIntelligentudgement() {
            this.spillId = "3";
            return this;
        }

        public ServiceBuilder conditionServiceBusy() {
            this.spillId = "2";
            return this;
        }

        public ServiceBuilder conditionServiceOffline() {
            this.spillId = "1";
            return this;
        }

        public ServiceBuilder designatedServiceId(String str) {
            this.deciId = str;
            return this;
        }

        public ServiceBuilder no_overflow() {
            this.optionId = "2";
            return this;
        }

        public ServiceBuilder overflow() {
            this.optionId = "1";
            return this;
        }
    }

    private SobotTransferAction() {
    }

    private SobotTransferAction(Builder builder) {
        this.actionType = builder.actionType;
        this.optionId = builder.optionId;
        this.deciId = builder.deciId;
        this.spillId = builder.spillId;
    }

    private SobotTransferAction(ServiceBuilder serviceBuilder) {
        this.actionType = serviceBuilder.actionType;
        this.optionId = serviceBuilder.optionId;
        this.deciId = serviceBuilder.deciId;
        this.spillId = serviceBuilder.spillId;
    }

    public String getActionType() {
        return this.actionType;
    }

    public String getDeciId() {
        return this.deciId;
    }

    public String getOptionId() {
        return this.optionId;
    }

    public String getSpillId() {
        return this.spillId;
    }

    public void setActionType(String str) {
        this.actionType = str;
    }

    public void setDeciId(String str) {
        this.deciId = str;
    }

    public void setOptionId(String str) {
        this.optionId = str;
    }

    public void setSpillId(String str) {
        this.spillId = str;
    }
}
