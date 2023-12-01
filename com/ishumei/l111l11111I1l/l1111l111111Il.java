package com.ishumei.l111l11111I1l;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111I1l/l1111l111111Il.class */
public class l1111l111111Il {
    private static String l1111l111111Il = "sm";
    private static int l111l11111I1l = 2;
    private static int l111l11111Il = 3;
    private static int l111l11111lIl = 1;
    private static int l111l1111l1Il = 4;
    private static int l111l1111lI1l = 7;
    private static int l111l1111llIl = 6;
    private static int[] l111l1111lIl = {1, 2, 4, 6, 7};
    private static l1111l111111Il l11l1111I1l = null;
    private Map<Long, Integer> l11l1111lIIl = new HashMap();
    private SparseArray<Handler> l11l1111I11l = new SparseArray<>();

    private l1111l111111Il() {
        int[] iArr = l111l1111lIl;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                Handler handler = new Handler(Looper.getMainLooper());
                this.l11l1111lIIl.put(Long.valueOf(handler.getLooper().getThread().getId()), 3);
                this.l11l1111I11l.put(3, handler);
                return;
            }
            int i3 = iArr[i2];
            HandlerThread handlerThread = new HandlerThread("sm-thread-" + i3);
            handlerThread.start();
            Handler handler2 = new Handler(handlerThread.getLooper());
            this.l11l1111lIIl.put(Long.valueOf(handlerThread.getLooper().getThread().getId()), Integer.valueOf(i3));
            this.l11l1111I11l.put(i3, handler2);
            i = i2 + 1;
        }
    }

    private int l1111l111111Il(long j) {
        return this.l11l1111lIIl.get(Long.valueOf(j)).intValue();
    }

    public static void l111l11111I1l() {
        synchronized (l1111l111111Il.class) {
            try {
                if (l11l1111I1l != null) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    for (Map.Entry<Long, Integer> entry : l11l1111I1l.l11l1111lIIl.entrySet()) {
                        if (entry.getKey().longValue() != handler.getLooper().getThread().getId()) {
                            Handler l1111l111111Il2 = l11l1111I1l.l1111l111111Il(entry.getValue().intValue());
                            l1111l111111Il2.removeCallbacksAndMessages(null);
                            if (Build.VERSION.SDK_INT >= 18) {
                                l1111l111111Il2.getLooper().quitSafely();
                            } else {
                                l1111l111111Il2.getLooper().quit();
                            }
                        }
                    }
                    l11l1111I1l.l11l1111lIIl.clear();
                    l11l1111I1l.l11l1111I11l.clear();
                    l11l1111I1l = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static l1111l111111Il l111l11111lIl() {
        l1111l111111Il l1111l111111il;
        synchronized (l1111l111111Il.class) {
            try {
                if (l11l1111I1l == null) {
                    synchronized (l1111l111111Il.class) {
                        if (l11l1111I1l == null) {
                            l11l1111I1l = new l1111l111111Il();
                        }
                    }
                }
                l1111l111111il = l11l1111I1l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return l1111l111111il;
    }

    public final int l1111l111111Il() {
        return this.l11l1111lIIl.get(Long.valueOf(Thread.currentThread().getId())).intValue();
    }

    public final Handler l1111l111111Il(int i) {
        return this.l11l1111I11l.get(i);
    }

    public final void l1111l111111Il(Runnable runnable, int i) {
        l1111l111111Il(runnable, i, false, 0L, false);
    }

    public final void l1111l111111Il(Runnable runnable, int i, long j, boolean z) {
        l1111l111111Il(runnable, i, false, j, z);
    }

    public final void l1111l111111Il(Runnable runnable, int i, boolean z, long j, boolean z2) {
        Handler l1111l111111Il2 = l1111l111111Il(i);
        if (l1111l111111Il2 == null) {
            return;
        }
        if (z2) {
            l1111l111111Il2.removeCallbacks(runnable);
        }
        if (z) {
            l1111l111111Il2.postAtFrontOfQueue(runnable);
        } else {
            l1111l111111Il2.postDelayed(runnable, j);
        }
    }
}
