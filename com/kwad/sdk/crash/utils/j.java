package com.kwad.sdk.crash.utils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/j.class */
public final class j {
    public static String Z(long j) {
        String valueOf;
        String valueOf2;
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        if (j2 < 10) {
            valueOf = "0" + j2;
        } else {
            valueOf = String.valueOf(j2);
        }
        if (j3 < 10) {
            valueOf2 = "0" + j3;
        } else {
            valueOf2 = String.valueOf(j3);
        }
        return valueOf + ":" + valueOf2;
    }
}
