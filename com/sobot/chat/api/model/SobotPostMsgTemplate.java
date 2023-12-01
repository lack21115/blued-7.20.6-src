package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotPostMsgTemplate.class */
public class SobotPostMsgTemplate implements Serializable {
    private String templateId;
    private String templateName;

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
    }

    public String toString() {
        return "SobotPostMsgTemplate{templateName='" + this.templateName + "', templateId='" + this.templateId + "'}";
    }
}
