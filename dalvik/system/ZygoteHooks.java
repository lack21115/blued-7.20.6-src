package dalvik.system;

import java.io.File;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/ZygoteHooks.class */
public final class ZygoteHooks {
    private long token;

    private static native void nativePostForkChild(long j, int i, String str);

    private static native long nativePreFork();

    private static void waitUntilAllThreadsStopped() {
        File file = new File("/proc/self/task");
        while (file.list().length > 1) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
            }
        }
    }

    public void postForkChild(int i, String str) {
        nativePostForkChild(this.token, i, str);
    }

    public void postForkCommon() {
        Daemons.start();
    }

    public void preFork() {
        Daemons.stop();
        waitUntilAllThreadsStopped();
        this.token = nativePreFork();
    }
}
