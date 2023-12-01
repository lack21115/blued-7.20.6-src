package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotLeaveMsgConfig.class */
public class SobotLeaveMsgConfig implements Serializable {
    private String companyId;
    private boolean emailFlag;
    private boolean emailShowFlag;
    private boolean enclosureFlag;
    private boolean enclosureShowFlag;
    private String msgTmp;
    private String msgTxt;
    private boolean telFlag;
    private boolean telShowFlag;
    private String templateDesc;
    private String templateId;
    private String templateName;
    private boolean ticketShowFlag;
    private boolean ticketStartWay;
    private boolean ticketTitleShowFlag;
    private boolean ticketTypeFlag;
    private String ticketTypeId;
    private ArrayList<SobotTypeModel> type;

    public String getCompanyId() {
        return this.companyId;
    }

    public String getMsgTmp() {
        return this.msgTmp;
    }

    public String getMsgTxt() {
        return this.msgTxt;
    }

    public String getTemplateDesc() {
        return this.templateDesc;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getTicketTypeId() {
        return this.ticketTypeId;
    }

    public ArrayList<SobotTypeModel> getType() {
        return this.type;
    }

    public boolean isEmailFlag() {
        return this.emailFlag;
    }

    public boolean isEmailShowFlag() {
        return this.emailShowFlag;
    }

    public boolean isEnclosureFlag() {
        return this.enclosureFlag;
    }

    public boolean isEnclosureShowFlag() {
        return this.enclosureShowFlag;
    }

    public boolean isTelFlag() {
        return this.telFlag;
    }

    public boolean isTelShowFlag() {
        return this.telShowFlag;
    }

    public boolean isTicketShowFlag() {
        return this.ticketShowFlag;
    }

    public boolean isTicketStartWay() {
        return this.ticketStartWay;
    }

    public boolean isTicketTitleShowFlag() {
        return this.ticketTitleShowFlag;
    }

    public boolean isTicketTypeFlag() {
        return this.ticketTypeFlag;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setEmailFlag(boolean z) {
        this.emailFlag = z;
    }

    public void setEmailShowFlag(boolean z) {
        this.emailShowFlag = z;
    }

    public void setEnclosureFlag(boolean z) {
        this.enclosureFlag = z;
    }

    public void setEnclosureShowFlag(boolean z) {
        this.enclosureShowFlag = z;
    }

    public void setMsgTmp(String str) {
        this.msgTmp = str;
    }

    public void setMsgTxt(String str) {
        this.msgTxt = str;
    }

    public void setTelFlag(boolean z) {
        this.telFlag = z;
    }

    public void setTelShowFlag(boolean z) {
        this.telShowFlag = z;
    }

    public void setTemplateDesc(String str) {
        this.templateDesc = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
    }

    public void setTicketShowFlag(boolean z) {
        this.ticketShowFlag = z;
    }

    public void setTicketStartWay(boolean z) {
        this.ticketStartWay = z;
    }

    public void setTicketTitleShowFlag(boolean z) {
        this.ticketTitleShowFlag = z;
    }

    public void setTicketTypeFlag(boolean z) {
        this.ticketTypeFlag = z;
    }

    public void setTicketTypeId(String str) {
        this.ticketTypeId = str;
    }

    public void setType(ArrayList<SobotTypeModel> arrayList) {
        this.type = arrayList;
    }
}
