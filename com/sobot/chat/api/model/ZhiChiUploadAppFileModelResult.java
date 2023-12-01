package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiUploadAppFileModelResult.class */
public class ZhiChiUploadAppFileModelResult implements Serializable {
    private String fileLocalPath;
    private String fileUrl;
    private int viewState = 0;

    public String getFileLocalPath() {
        return this.fileLocalPath;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public int getViewState() {
        return this.viewState;
    }

    public void setFileLocalPath(String str) {
        this.fileLocalPath = str;
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public void setViewState(int i) {
        this.viewState = i;
    }
}
