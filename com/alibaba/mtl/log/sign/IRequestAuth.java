package com.alibaba.mtl.log.sign;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/sign/IRequestAuth.class */
public interface IRequestAuth {
    String getAppkey();

    String getSign(String str);
}
