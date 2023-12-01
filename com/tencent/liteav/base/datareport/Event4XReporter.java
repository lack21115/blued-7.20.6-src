package com.tencent.liteav.base.datareport;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/datareport/Event4XReporter.class */
public class Event4XReporter {
    private static final int INVALID_INSTANCE = 0;
    public static final int REPORT_EVENT = 1;
    public static final int REPORT_STATUS = 2;
    private static final String TAG = "Event4XReporter";
    private long mNativeEvent4XReporterAndroid;

    public Event4XReporter(int i, int i2, String str, boolean z, int i3) {
        this.mNativeEvent4XReporterAndroid = 0L;
        this.mNativeEvent4XReporterAndroid = nativeCreate(i, i2, str, z, i3);
    }

    private static native long nativeCreate(int i, int i2, String str, boolean z, int i3);

    private static native void nativeDestroy(long j);

    private static native int nativeGetColdDownTime(long j);

    private static native void nativeSendReport(long j);

    private static native void nativeSetCommonIntValue(long j, String str, long j2);

    private static native void nativeSetCommonStringValue(long j, String str, String str2);

    private static native void nativeSetEventIntValue(long j, String str, long j2);

    private static native void nativeSetEventStringValue(long j, String str, String str2);

    public int GetColdDownTime() {
        long j = this.mNativeEvent4XReporterAndroid;
        if (j == 0) {
            return 10000;
        }
        return nativeGetColdDownTime(j);
    }

    public void ReportDau(int i, int i2, String str) {
        long j = this.mNativeEvent4XReporterAndroid;
        if (j == 0) {
            return;
        }
        nativeSetEventStringValue(j, "event_id", String.valueOf(i));
        nativeSetEventStringValue(this.mNativeEvent4XReporterAndroid, "err_code", String.valueOf(i2));
        nativeSetEventStringValue(this.mNativeEvent4XReporterAndroid, "err_info", str);
        nativeSendReport(this.mNativeEvent4XReporterAndroid);
    }

    public void SendReport() {
        long j = this.mNativeEvent4XReporterAndroid;
        if (j == 0) {
            return;
        }
        nativeSendReport(j);
    }

    public void SetCommonIntValue(String str, long j) {
        long j2 = this.mNativeEvent4XReporterAndroid;
        if (j2 == 0 || str == null) {
            return;
        }
        nativeSetCommonIntValue(j2, str, j);
    }

    public void SetCommonStringValue(String str, String str2) {
        long j = this.mNativeEvent4XReporterAndroid;
        if (j == 0 || str == null || str2 == null) {
            return;
        }
        nativeSetCommonStringValue(j, str, str2);
    }

    public void SetEventIntValue(String str, long j) {
        long j2 = this.mNativeEvent4XReporterAndroid;
        if (j2 == 0 || str == null) {
            return;
        }
        nativeSetEventIntValue(j2, str, j);
    }

    public void SetEventStringValue(String str, String str2) {
        long j = this.mNativeEvent4XReporterAndroid;
        if (j == 0 || str == null || str2 == null) {
            return;
        }
        nativeSetEventStringValue(j, str, str2);
    }

    public void destroy() {
        synchronized (this) {
            if (this.mNativeEvent4XReporterAndroid == 0) {
                return;
            }
            nativeDestroy(this.mNativeEvent4XReporterAndroid);
            this.mNativeEvent4XReporterAndroid = 0L;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroy();
    }
}
