package com.bytedance.applog.network;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/network/RangersHttpException.class */
public class RangersHttpException extends Exception {
    public int mResponseCode;

    public RangersHttpException(int i, String str) {
        super(str);
        this.mResponseCode = i;
    }

    public RangersHttpException(int i, Throwable th) {
        super(th);
        this.mResponseCode = i;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
