package android.net.http;

import android.os.SystemClock;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/Timer.class */
class Timer {
    private long mLast;
    private long mStart;

    public Timer() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mLast = uptimeMillis;
        this.mStart = uptimeMillis;
    }

    public void mark(String str) {
        this.mLast = SystemClock.uptimeMillis();
    }
}
