package com.alibaba.mtl.log.sign;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.j;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/sign/BaseRequestAuth.class */
public class BaseRequestAuth implements IRequestAuth {
    private String Y;
    private String b;

    public BaseRequestAuth(String str, String str2) {
        this.b = null;
        this.Y = null;
        this.b = str;
        this.Y = str2;
    }

    public String getAppSecret() {
        return this.Y;
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getAppkey() {
        return this.b;
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getSign(String str) {
        if (this.b == null || this.Y == null) {
            i.a("BaseRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            return j.a(j.m8629a((str + this.Y).getBytes()));
        }
    }
}
