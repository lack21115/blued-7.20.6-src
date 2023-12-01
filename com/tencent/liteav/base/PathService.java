package com.tencent.liteav.base;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/PathService.class */
public abstract class PathService {
    public static final int DIR_MODULE = 3;

    private PathService() {
    }

    private static native void nativeOverride(int i, String str);

    public static void override(int i, String str) {
        nativeOverride(i, str);
    }
}
