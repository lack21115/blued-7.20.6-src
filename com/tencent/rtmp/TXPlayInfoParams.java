package com.tencent.rtmp;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXPlayInfoParams.class */
public class TXPlayInfoParams {
    int mAppId;
    String mFileId;
    String mPSign;

    public TXPlayInfoParams(int i, String str, String str2) {
        this.mAppId = i;
        this.mFileId = str;
        this.mPSign = str2;
    }

    public int getAppId() {
        return this.mAppId;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public String getPSign() {
        return this.mPSign;
    }
}
