package com.tencent.thumbplayer.core.common;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPNativeLog.class */
public class TPNativeLog {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARN = 3;
    private static final String TAG = "PlayerCore";
    private static ITPNativeLogCallback mLogCallback;

    private static void onPrintLog(int i, byte[] bArr, int i2, byte[] bArr2, int i3) {
        try {
            printLog(i != 0 ? i != 1 ? i != 2 ? i != 3 ? 0 : 1 : 2 : 3 : 4, new String(bArr, 0, i2, "UTF-8"), new String(bArr2, 0, i3, "UTF-8"));
        } catch (Exception e) {
            printLog(4, e.getMessage());
        }
    }

    public static void printLog(int i, String str) {
        printLog(i, TAG, str);
    }

    public static void printLog(int i, String str, String str2) {
        ITPNativeLogCallback iTPNativeLogCallback = mLogCallback;
        if (iTPNativeLogCallback != null) {
            iTPNativeLogCallback.onPrintLog(i, str, str2);
        } else {
            printLogDefault(i, str, str2);
        }
    }

    public static void printLogDefault(int i, String str, String str2) {
        if (i == 0) {
            Log.v(str, str2);
        } else if (i == 1) {
            Log.d(str, str2);
        } else if (i == 2) {
            Log.i(str, str2);
        } else if (i == 3) {
            Log.w(str, str2);
        } else if (i != 4) {
            Log.v(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void setLogCallback(ITPNativeLogCallback iTPNativeLogCallback) {
        mLogCallback = iTPNativeLogCallback;
    }
}
