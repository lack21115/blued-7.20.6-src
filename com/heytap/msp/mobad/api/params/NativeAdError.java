package com.heytap.msp.mobad.api.params;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/NativeAdError.class */
public class NativeAdError {
    public int code;
    public String msg;

    public NativeAdError(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "NativeAdError{code=" + this.code + ", msg='" + this.msg + "'}";
    }
}
