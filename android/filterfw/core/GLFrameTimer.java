package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/GLFrameTimer.class */
class GLFrameTimer {
    private static StopWatchMap mTimer = null;

    GLFrameTimer() {
    }

    public static StopWatchMap get() {
        if (mTimer == null) {
            mTimer = new StopWatchMap();
        }
        return mTimer;
    }
}
