package com.tencent.thumbplayer.core.common;

import android.os.Process;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPThreadUtil.class */
public class TPThreadUtil {
    private static final String TAG = "PlayerCore.TPThreadUtil";

    public static void setThreadName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Thread.currentThread().setName(str);
    }

    public static void setThreadPriority(int i) {
        if (i < -19 || i > 19) {
            TPNativeLog.printLog(4, "setThreadPriority error, priority range:[-19,20], priority:".concat(String.valueOf(i)));
            return;
        }
        try {
            if (Process.getThreadPriority(0) != i) {
                Process.setThreadPriority(i);
            }
            TPNativeLog.printLog(2, "setThreadPriority, priority:".concat(String.valueOf(i)));
        } catch (Exception e) {
            TPNativeLog.printLog(4, TAG, e.toString());
        }
    }
}
