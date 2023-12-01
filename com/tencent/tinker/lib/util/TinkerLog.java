package com.tencent.tinker.lib.util;

import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/util/TinkerLog.class */
public class TinkerLog {
    private static final String TAG = "Tinker.TinkerLog";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/util/TinkerLog$TinkerLogImp.class */
    public interface TinkerLogImp extends ShareTinkerLog.TinkerLogImp {
    }

    public static void d(String str, String str2, Object... objArr) {
        ShareTinkerLog.v(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        ShareTinkerLog.v(str, str2, objArr);
    }

    public static ShareTinkerLog.TinkerLogImp getImpl() {
        return ShareTinkerLog.getImpl();
    }

    public static void i(String str, String str2, Object... objArr) {
        ShareTinkerLog.v(str, str2, objArr);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        ShareTinkerLog.printErrStackTrace(str, th, str2, objArr);
    }

    public static void printPendingLogs() {
        ShareTinkerLog.printPendingLogs();
    }

    public static void setTinkerLogImp(TinkerLogImp tinkerLogImp) {
        ShareTinkerLog.setTinkerLogImp(tinkerLogImp);
    }

    public static void v(String str, String str2, Object... objArr) {
        ShareTinkerLog.v(str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        ShareTinkerLog.v(str, str2, objArr);
    }
}
