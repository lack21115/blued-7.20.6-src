package android.filterfw.core;

import android.os.SystemClock;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/StopWatch.class */
class StopWatch {
    private String mName;
    private int STOP_WATCH_LOGGING_PERIOD = 200;
    private String TAG = "MFF";
    private long mStartTime = -1;
    private long mTotalTime = 0;
    private int mNumCalls = 0;

    public StopWatch(String str) {
        this.mName = str;
    }

    public void start() {
        if (this.mStartTime != -1) {
            throw new RuntimeException("Calling start with StopWatch already running");
        }
        this.mStartTime = SystemClock.elapsedRealtime();
    }

    public void stop() {
        if (this.mStartTime == -1) {
            throw new RuntimeException("Calling stop with StopWatch already stopped");
        }
        this.mTotalTime += SystemClock.elapsedRealtime() - this.mStartTime;
        this.mNumCalls++;
        this.mStartTime = -1L;
        if (this.mNumCalls % this.STOP_WATCH_LOGGING_PERIOD == 0) {
            Log.i(this.TAG, "AVG ms/call " + this.mName + ": " + String.format("%.1f", Float.valueOf((((float) this.mTotalTime) * 1.0f) / this.mNumCalls)));
            this.mTotalTime = 0L;
            this.mNumCalls = 0;
        }
    }
}
