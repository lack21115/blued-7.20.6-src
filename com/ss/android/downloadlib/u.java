package com.ss.android.downloadlib;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/u.class */
public class u {
    private static volatile u mb;
    private com.ss.android.download.api.config.u ox = null;

    private u() {
    }

    public static u mb() {
        if (mb == null) {
            synchronized (u.class) {
                try {
                    if (mb == null) {
                        mb = new u();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    public com.ss.android.download.api.config.u ox() {
        return this.ox;
    }
}
