package com.tencent.liteav;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.o;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/LiveSettingJni.class */
public class LiveSettingJni {
    static {
        o.a();
    }

    public static native void nativeSetAppId(String str);

    public static native void nativeSetUserId(String str);
}
