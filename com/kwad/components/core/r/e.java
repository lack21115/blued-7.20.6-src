package com.kwad.components.core.r;

import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/e.class */
public final class e {
    public static String a(long j, boolean z) {
        if (j > 1) {
            double d = j;
            int log = (int) (Math.log(d) / Math.log(1024.0d));
            return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(j > 1024 ? d / Math.pow(1024.0d, log) : d / 1024.0d), new String[]{" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"}[log]);
        }
        return j + "B";
    }
}
