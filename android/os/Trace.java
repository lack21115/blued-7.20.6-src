package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/Trace.class */
public final class Trace {
    private static final int MAX_SECTION_NAME_LEN = 127;
    private static final String TAG = "Trace";
    public static final long TRACE_TAG_ACTIVITY_MANAGER = 64;
    public static final long TRACE_TAG_ALWAYS = 1;
    public static final long TRACE_TAG_APP = 4096;
    public static final long TRACE_TAG_AUDIO = 256;
    public static final long TRACE_TAG_BIONIC = 65536;
    public static final long TRACE_TAG_CAMERA = 1024;
    public static final long TRACE_TAG_DALVIK = 16384;
    public static final long TRACE_TAG_GRAPHICS = 2;
    public static final long TRACE_TAG_HAL = 2048;
    public static final long TRACE_TAG_INPUT = 4;
    public static final long TRACE_TAG_NEVER = 0;
    private static final long TRACE_TAG_NOT_READY = Long.MIN_VALUE;
    public static final long TRACE_TAG_POWER = 131072;
    public static final long TRACE_TAG_RESOURCES = 8192;
    public static final long TRACE_TAG_RS = 32768;
    public static final long TRACE_TAG_SYNC_MANAGER = 128;
    public static final long TRACE_TAG_VIDEO = 512;
    public static final long TRACE_TAG_VIEW = 8;
    public static final long TRACE_TAG_WEBVIEW = 16;
    public static final long TRACE_TAG_WINDOW_MANAGER = 32;
    private static volatile long sEnabledTags = Long.MIN_VALUE;

    static {
        SystemProperties.addChangeCallback(new Runnable() { // from class: android.os.Trace.1
            @Override // java.lang.Runnable
            public void run() {
                Trace.access$000();
            }
        });
    }

    private Trace() {
    }

    static /* synthetic */ long access$000() {
        return cacheEnabledTags();
    }

    public static void asyncTraceBegin(long j, String str, int i) {
        if (isTagEnabled(j)) {
            nativeAsyncTraceBegin(j, str, i);
        }
    }

    public static void asyncTraceEnd(long j, String str, int i) {
        if (isTagEnabled(j)) {
            nativeAsyncTraceEnd(j, str, i);
        }
    }

    public static void beginSection(String str) {
        if (isTagEnabled(4096L)) {
            if (str.length() > 127) {
                throw new IllegalArgumentException("sectionName is too long");
            }
            nativeTraceBegin(4096L, str);
        }
    }

    private static long cacheEnabledTags() {
        long nativeGetEnabledTags = nativeGetEnabledTags();
        sEnabledTags = nativeGetEnabledTags;
        return nativeGetEnabledTags;
    }

    public static void endSection() {
        if (isTagEnabled(4096L)) {
            nativeTraceEnd(4096L);
        }
    }

    public static boolean isTagEnabled(long j) {
        long j2 = sEnabledTags;
        long j3 = j2;
        if (j2 == Long.MIN_VALUE) {
            j3 = cacheEnabledTags();
        }
        return (j3 & j) != 0;
    }

    private static native void nativeAsyncTraceBegin(long j, String str, int i);

    private static native void nativeAsyncTraceEnd(long j, String str, int i);

    private static native long nativeGetEnabledTags();

    private static native void nativeSetAppTracingAllowed(boolean z);

    private static native void nativeSetTracingEnabled(boolean z);

    private static native void nativeTraceBegin(long j, String str);

    private static native void nativeTraceCounter(long j, String str, int i);

    private static native void nativeTraceEnd(long j);

    public static void setAppTracingAllowed(boolean z) {
        nativeSetAppTracingAllowed(z);
        cacheEnabledTags();
    }

    public static void setTracingEnabled(boolean z) {
        nativeSetTracingEnabled(z);
        cacheEnabledTags();
    }

    public static void traceBegin(long j, String str) {
        if (isTagEnabled(j)) {
            nativeTraceBegin(j, str);
        }
    }

    public static void traceCounter(long j, String str, int i) {
        if (isTagEnabled(j)) {
            nativeTraceCounter(j, str, i);
        }
    }

    public static void traceEnd(long j) {
        if (isTagEnabled(j)) {
            nativeTraceEnd(j);
        }
    }
}
