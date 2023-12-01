package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotFileModel.class */
public class SobotFileModel implements Serializable {
    private String companyId;
    private String createServiceId;
    private String createTime;
    private String dealLogId;
    private String fileId;
    private String fileName;
    private String fileType;
    private String fileUrl;
    private String ticketId;

    public String getCompanyId() {
        return this.companyId;
    }

    public String getCreateServiceId() {
        return this.createServiceId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDealLogId() {
        return this.dealLogId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setCreateServiceId(String str) {
        this.createServiceId = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDealLogId(String str) {
        this.dealLogId = str;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public void setTicketId(String str) {
        this.ticketId = str;
    }
}
