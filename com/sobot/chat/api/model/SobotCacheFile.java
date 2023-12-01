package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotCacheFile.class */
public class SobotCacheFile implements Serializable {
    private String fileName;
    private String filePath;
    private String fileSize;
    private int fileType;
    private boolean isCache;
    private String msgId;
    private int progress;
    private String snapshot;
    private int status = 0;
    private String url;

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getSnapshot() {
        return this.snapshot;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public void setCache(boolean z) {
        this.isCache = z;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileSize(String str) {
        this.fileSize = str;
    }

    public void setFileType(int i) {
        this.fileType = i;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setSnapshot(String str) {
        this.snapshot = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "SobotCacheFile{msgId='" + this.msgId + "', filePath='" + this.filePath + "', fileName='" + this.fileName + "', fileType=" + this.fileType + ", progress=" + this.progress + ", url='" + this.url + "', fileSize='" + this.fileSize + "', isCache=" + this.isCache + ", status=" + this.status + '}';
    }
}
