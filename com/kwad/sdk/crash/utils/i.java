package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/i.class */
public final class i {
    private static SimpleDateFormat ath = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String Y(long j) {
        return j <= 0 ? "unknown" : ath.format(new Date(j));
    }
}
