package dalvik.system;

import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/VMDebug.class */
public final class VMDebug {
    private static final int KIND_ALLOCATED_BYTES = 2;
    private static final int KIND_ALLOCATED_OBJECTS = 1;
    public static final int KIND_ALL_COUNTS = -1;
    private static final int KIND_CLASS_INIT_COUNT = 32;
    private static final int KIND_CLASS_INIT_TIME = 64;
    private static final int KIND_EXT_ALLOCATED_BYTES = 8192;
    private static final int KIND_EXT_ALLOCATED_OBJECTS = 4096;
    private static final int KIND_EXT_FREED_BYTES = 32768;
    private static final int KIND_EXT_FREED_OBJECTS = 16384;
    private static final int KIND_FREED_BYTES = 8;
    private static final int KIND_FREED_OBJECTS = 4;
    private static final int KIND_GC_INVOCATIONS = 16;
    public static final int KIND_GLOBAL_ALLOCATED_BYTES = 2;
    public static final int KIND_GLOBAL_ALLOCATED_OBJECTS = 1;
    public static final int KIND_GLOBAL_CLASS_INIT_COUNT = 32;
    public static final int KIND_GLOBAL_CLASS_INIT_TIME = 64;
    public static final int KIND_GLOBAL_EXT_ALLOCATED_BYTES = 8192;
    public static final int KIND_GLOBAL_EXT_ALLOCATED_OBJECTS = 4096;
    public static final int KIND_GLOBAL_EXT_FREED_BYTES = 32768;
    public static final int KIND_GLOBAL_EXT_FREED_OBJECTS = 16384;
    public static final int KIND_GLOBAL_FREED_BYTES = 8;
    public static final int KIND_GLOBAL_FREED_OBJECTS = 4;
    public static final int KIND_GLOBAL_GC_INVOCATIONS = 16;
    public static final int KIND_THREAD_ALLOCATED_BYTES = 131072;
    public static final int KIND_THREAD_ALLOCATED_OBJECTS = 65536;
    public static final int KIND_THREAD_CLASS_INIT_COUNT = 2097152;
    public static final int KIND_THREAD_CLASS_INIT_TIME = 4194304;
    public static final int KIND_THREAD_EXT_ALLOCATED_BYTES = 536870912;
    public static final int KIND_THREAD_EXT_ALLOCATED_OBJECTS = 268435456;
    public static final int KIND_THREAD_EXT_FREED_BYTES = Integer.MIN_VALUE;
    public static final int KIND_THREAD_EXT_FREED_OBJECTS = 1073741824;
    public static final int KIND_THREAD_FREED_BYTES = 524288;
    public static final int KIND_THREAD_FREED_OBJECTS = 262144;
    public static final int KIND_THREAD_GC_INVOCATIONS = 1048576;
    public static final int TRACE_COUNT_ALLOCS = 1;

    private VMDebug() {
    }

    public static native boolean cacheRegisterMap(String str);

    private static int checkBufferSize(int i) {
        int i2 = i;
        if (i == 0) {
            i2 = 8388608;
        }
        if (i2 < 1024) {
            throw new IllegalArgumentException("buffer size < 1024: " + i2);
        }
        return i2;
    }

    public static native long countInstancesOfClass(Class cls, boolean z);

    public static native void crash();

    public static void dumpHprofData(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("filename == null");
        }
        dumpHprofData(str, null);
    }

    public static native void dumpHprofData(String str, FileDescriptor fileDescriptor) throws IOException;

    public static native void dumpHprofDataDdms();

    public static native void dumpReferenceTables();

    public static native int getAllocCount(int i);

    public static native void getHeapSpaceStats(long[] jArr);

    public static native void getInstructionCount(int[] iArr);

    public static native int getLoadedClassCount();

    public static native int getMethodTracingMode();

    public static native String[] getVmFeatureList();

    public static native void infopoint(int i);

    public static native boolean isDebuggerConnected();

    public static native boolean isDebuggingEnabled();

    public static native long lastDebuggerActivity();

    public static native void printLoadedClasses(int i);

    public static native void resetAllocCount(int i);

    public static native void resetInstructionCount();

    @Deprecated
    public static int setAllocationLimit(int i) {
        return -1;
    }

    @Deprecated
    public static int setGlobalAllocationLimit(int i) {
        return -1;
    }

    public static native void startAllocCounting();

    private static void startClassPrep() {
    }

    public static native void startEmulatorTracing();

    private static void startGC() {
    }

    public static native void startInstructionCounting();

    @Deprecated
    public static void startMethodTracing() {
        throw new UnsupportedOperationException();
    }

    public static void startMethodTracing(String str, int i, int i2, boolean z, int i3) {
        startMethodTracingFilename(str, checkBufferSize(i), i2, z, i3);
    }

    public static void startMethodTracing(String str, FileDescriptor fileDescriptor, int i, int i2, boolean z, int i3) {
        if (fileDescriptor == null) {
            throw new NullPointerException("fd == null");
        }
        startMethodTracingFd(str, fileDescriptor, checkBufferSize(i), i2, z, i3);
    }

    public static void startMethodTracingDdms(int i, int i2, boolean z, int i3) {
        startMethodTracingDdmsImpl(checkBufferSize(i), i2, z, i3);
    }

    private static native void startMethodTracingDdmsImpl(int i, int i2, boolean z, int i3);

    private static native void startMethodTracingFd(String str, FileDescriptor fileDescriptor, int i, int i2, boolean z, int i3);

    private static native void startMethodTracingFilename(String str, int i, int i2, boolean z, int i3);

    public static native void stopAllocCounting();

    public static native void stopEmulatorTracing();

    public static native void stopInstructionCounting();

    public static native void stopMethodTracing();

    public static native long threadCpuTimeNanos();
}
