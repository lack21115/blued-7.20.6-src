package com.taobao.tao.remotebusiness.auth;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/auth/AuthParam.class */
public class AuthParam {
    public String bizId;
    public String failInfo;
    public String sid;

    public AuthParam(String str, String str2, String str3) {
        this.sid = str;
        this.bizId = str2;
        this.failInfo = str3;
    }
}
