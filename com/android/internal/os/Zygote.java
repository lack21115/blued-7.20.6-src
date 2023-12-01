package com.android.internal.os;

import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Slog;
import dalvik.system.ZygoteHooks;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/Zygote.class */
public final class Zygote {
    public static final int DEBUG_ENABLE_ASSERT = 4;
    public static final int DEBUG_ENABLE_CHECKJNI = 2;
    public static final int DEBUG_ENABLE_DEBUGGER = 1;
    public static final int DEBUG_ENABLE_JNI_LOGGING = 16;
    public static final int DEBUG_ENABLE_SAFEMODE = 8;
    public static final int MOUNT_EXTERNAL_MULTIUSER = 2;
    public static final int MOUNT_EXTERNAL_MULTIUSER_ALL = 3;
    public static final int MOUNT_EXTERNAL_NONE = 0;
    public static final int MOUNT_EXTERNAL_SINGLEUSER = 1;
    private static final String TAG = "Zygote";
    private static final ZygoteHooks VM_HOOKS = new ZygoteHooks();

    private Zygote() {
    }

    public static void appendQuotedShellArgs(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            sb.append(" '").append(strArr[i2].replace("'", "'\\''")).append("'");
            i = i2 + 1;
        }
    }

    private static void callPostForkChildHooks(int i, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        VM_HOOKS.postForkChild(i, str);
        checkTime(elapsedRealtime, "Zygote.callPostForkChildHooks");
    }

    private static void checkTime(long j, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - j > 1000) {
            Slog.w(TAG, "Slow operation: " + (elapsedRealtime - j) + "ms so far, now at " + str);
        }
    }

    public static void execShell(String str) {
        String[] strArr = {"/system/bin/sh", "-c", str};
        try {
            Os.execv(strArr[0], strArr);
        } catch (ErrnoException e) {
            throw new RuntimeException(e);
        }
    }

    public static int forkAndSpecialize(int i, int i2, int[] iArr, int i3, int[][] iArr2, int i4, String str, String str2, int[] iArr3, String str3, String str4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        VM_HOOKS.preFork();
        checkTime(elapsedRealtime, "Zygote.preFork");
        int nativeForkAndSpecialize = nativeForkAndSpecialize(i, i2, iArr, i3, iArr2, i4, str, str2, iArr3, str3, str4);
        checkTime(elapsedRealtime, "Zygote.nativeForkAndSpecialize");
        VM_HOOKS.postForkCommon();
        checkTime(elapsedRealtime, "Zygote.postForkCommon");
        return nativeForkAndSpecialize;
    }

    public static int forkSystemServer(int i, int i2, int[] iArr, int i3, int[][] iArr2, long j, long j2) {
        VM_HOOKS.preFork();
        int nativeForkSystemServer = nativeForkSystemServer(i, i2, iArr, i3, iArr2, j, j2);
        VM_HOOKS.postForkCommon();
        return nativeForkSystemServer;
    }

    private static native int nativeForkAndSpecialize(int i, int i2, int[] iArr, int i3, int[][] iArr2, int i4, String str, String str2, int[] iArr3, String str3, String str4);

    private static native int nativeForkSystemServer(int i, int i2, int[] iArr, int i3, int[][] iArr2, long j, long j2);
}
