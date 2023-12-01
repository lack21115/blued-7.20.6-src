package com.sdk.tencent.base.framework.bean;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/framework/bean/OauthResultMode.class */
public class OauthResultMode implements Serializable {
    private int code;
    private String msg;
    private Object object;
    private String seq;
    private int status;

    public OauthResultMode() {
    }

    public OauthResultMode(int i, String str, int i2) {
        this.code = i;
        this.msg = str;
        this.status = i2;
    }

    public OauthResultMode(int i, String str, int i2, Object obj, String str2) {
        this.code = i;
        this.msg = str;
        this.status = i2;
        this.object = obj;
        this.seq = str2;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getObject() {
        return this.object;
    }

    public String getSeq() {
        return this.seq;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    public void setSeq(String str) {
        this.seq = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "OauthResultMode{code=" + this.code + ", msg='" + this.msg + "', status=" + this.status + ", object=" + this.object + ", seq='" + this.seq + "'}";
    }
}
