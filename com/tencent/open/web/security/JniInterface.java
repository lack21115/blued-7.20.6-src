package com.tencent.open.web.security;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/web/security/JniInterface.class */
public class JniInterface {
    public static native boolean BackSpaceChar(boolean z, int i);

    public static native boolean clearAllPWD();

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i, String str, int i2);
}
