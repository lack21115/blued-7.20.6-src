package com.ut.mini.core.sign;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.j;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/core/sign/UTBaseRequestAuthentication.class */
public class UTBaseRequestAuthentication implements IUTRequestAuthentication {
    private String Y;
    private String b;

    public UTBaseRequestAuthentication(String str, String str2) {
        this.b = null;
        this.Y = null;
        this.b = str;
        this.Y = str2;
    }

    public String getAppSecret() {
        return this.Y;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.b;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        if (this.b == null || this.Y == null) {
            i.a("UTBaseRequestAuthentication", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            return j.a(j.a((str + this.Y).getBytes()));
        }
    }
}
