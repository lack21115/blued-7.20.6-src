package com.tencent.cloud.huiyansdkface.b;

import com.tencent.youtu.liveness.YTCommonInterface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/b/a.class */
public class a {
    static {
        System.loadLibrary("YTCommonLiveness");
    }

    public static int a(String str) {
        return YTCommonInterface.a(str, "");
    }
}
