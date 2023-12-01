package com.huawei.hms.support.api.client;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/client/SubAppInfo.class */
public class SubAppInfo {
    private String subAppID;

    public SubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.subAppID = subAppInfo.getSubAppID();
        }
    }

    public SubAppInfo(String str) {
        this.subAppID = str;
    }

    public String getSubAppID() {
        return this.subAppID;
    }

    public void setSubAppInfoID(String str) {
        this.subAppID = str;
    }
}
