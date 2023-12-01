package com.efs.sdk.base.integrationtesting;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/integrationtesting/IntegrationTestingUtil.class */
public class IntegrationTestingUtil {
    private static boolean sIsInPeriod = false;

    public static boolean isIntegrationTestingInPeriod() {
        return sIsInPeriod;
    }

    public static void setIntegrationTestingInPeriod(boolean z) {
        sIsInPeriod = z;
    }
}
