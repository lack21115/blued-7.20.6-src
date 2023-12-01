package android.os;

import com.google.android.collect.Maps;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/* loaded from: source-9557208-dex2jar.jar:android/os/SystemService.class */
public class SystemService {
    private static HashMap<String, State> sStates = Maps.newHashMap();
    private static Object sPropertyLock = new Object();

    /* loaded from: source-9557208-dex2jar.jar:android/os/SystemService$State.class */
    public enum State {
        RUNNING("running"),
        STOPPING("stopping"),
        STOPPED("stopped"),
        RESTARTING("restarting");

        State(String str) {
            SystemService.sStates.put(str, this);
        }
    }

    static {
        SystemProperties.addChangeCallback(new Runnable() { // from class: android.os.SystemService.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SystemService.sPropertyLock) {
                    SystemService.sPropertyLock.notifyAll();
                }
            }
        });
    }

    public static State getState(String str) {
        State state = sStates.get(SystemProperties.get("init.svc." + str));
        return state != null ? state : State.STOPPED;
    }

    public static boolean isRunning(String str) {
        return State.RUNNING.equals(getState(str));
    }

    public static boolean isStopped(String str) {
        return State.STOPPED.equals(getState(str));
    }

    public static void restart(String str) {
        SystemProperties.set("ctl.restart", str);
    }

    public static void start(String str) {
        SystemProperties.set("ctl.start", str);
    }

    public static void stop(String str) {
        SystemProperties.set("ctl.stop", str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        android.os.SystemService.sPropertyLock.wait();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void waitForAnyStopped(java.lang.String... r3) {
        /*
        L0:
            java.lang.Object r0 = android.os.SystemService.sPropertyLock
            r6 = r0
            r0 = r6
            monitor-enter(r0)
            r0 = r3
            int r0 = r0.length     // Catch: java.lang.Throwable -> L38
            r5 = r0
            r0 = 0
            r4 = r0
        Lb:
            r0 = r4
            r1 = r5
            if (r0 >= r1) goto L2d
            r0 = r3
            r1 = r4
            r0 = r0[r1]
            r7 = r0
            android.os.SystemService$State r0 = android.os.SystemService.State.STOPPED     // Catch: java.lang.Throwable -> L38
            r1 = r7
            android.os.SystemService$State r1 = getState(r1)     // Catch: java.lang.Throwable -> L38
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L26
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            return
        L26:
            r0 = r4
            r1 = 1
            int r0 = r0 + r1
            r4 = r0
            goto Lb
        L2d:
            java.lang.Object r0 = android.os.SystemService.sPropertyLock     // Catch: java.lang.Throwable -> L38 java.lang.InterruptedException -> L3d
            r0.wait()     // Catch: java.lang.Throwable -> L38 java.lang.InterruptedException -> L3d
        L33:
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            goto L0
        L38:
            r3 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            r0 = r3
            throw r0
        L3d:
            r7 = move-exception
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: android.os.SystemService.waitForAnyStopped(java.lang.String[]):void");
    }

    public static void waitForState(String str, State state, long j) throws TimeoutException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            synchronized (sPropertyLock) {
                State state2 = getState(str);
                if (state.equals(state2)) {
                    return;
                }
                if (SystemClock.elapsedRealtime() >= elapsedRealtime + j) {
                    throw new TimeoutException("Service " + str + " currently " + state2 + "; waited " + j + "ms for " + state);
                }
                try {
                    sPropertyLock.wait(j);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
