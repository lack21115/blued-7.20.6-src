package com.alipay.sdk.app;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/EnvUtils.class */
public class EnvUtils {
    private static EnvEnum mEnv = EnvEnum.ONLINE;

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/EnvUtils$EnvEnum.class */
    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    public static EnvEnum geEnv() {
        return mEnv;
    }

    public static boolean isSandBox() {
        return mEnv == EnvEnum.SANDBOX;
    }

    public static void setEnv(EnvEnum envEnum) {
        mEnv = envEnum;
    }
}
