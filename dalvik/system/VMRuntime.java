package dalvik.system;

import com.bun.miitmdid.core.Utils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/VMRuntime.class */
public final class VMRuntime {
    private int targetSdkVersion;
    private static final VMRuntime THE_ONE = new VMRuntime();
    private static final Map<String, String> ABI_TO_INSTRUCTION_SET_MAP = new HashMap();

    static {
        ABI_TO_INSTRUCTION_SET_MAP.put("armeabi", "arm");
        ABI_TO_INSTRUCTION_SET_MAP.put("armeabi-v7a", "arm");
        ABI_TO_INSTRUCTION_SET_MAP.put("mips", "mips");
        ABI_TO_INSTRUCTION_SET_MAP.put("mips64", "mips64");
        ABI_TO_INSTRUCTION_SET_MAP.put(Utils.CPU_ABI_X86, Utils.CPU_ABI_X86);
        ABI_TO_INSTRUCTION_SET_MAP.put("x86_64", "x86_64");
        ABI_TO_INSTRUCTION_SET_MAP.put("arm64-v8a", "arm64");
    }

    private VMRuntime() {
    }

    public static native String getCurrentInstructionSet();

    public static String getInstructionSet(String str) {
        String str2 = ABI_TO_INSTRUCTION_SET_MAP.get(str);
        if (str2 == null) {
            throw new IllegalArgumentException("Unsupported ABI: " + str);
        }
        return str2;
    }

    public static VMRuntime getRuntime() {
        return THE_ONE;
    }

    public static boolean is64BitAbi(String str) {
        return is64BitInstructionSet(getInstructionSet(str));
    }

    public static boolean is64BitInstructionSet(String str) {
        return "arm64".equals(str) || "x86_64".equals(str) || "mips64".equals(str);
    }

    public static native boolean isBootClassPathOnDisk(String str);

    private native void nativeSetTargetHeapUtilization(float f);

    public static native void registerAppInfo(String str, String str2, String str3);

    private native void setTargetSdkVersionNative(int i);

    public native long addressOf(Object obj);

    public native String bootClassPath();

    public native String classPath();

    public native void clearGrowthLimit();

    public native void concurrentGC();

    public native void disableJitCompilation();

    @Deprecated
    public void gcSoftReferences() {
    }

    @Deprecated
    public long getExternalBytesAllocated() {
        return 0L;
    }

    @Deprecated
    public long getMinimumHeapSize() {
        return 0L;
    }

    public native float getTargetHeapUtilization();

    public int getTargetSdkVersion() {
        int i;
        synchronized (this) {
            i = this.targetSdkVersion;
        }
        return i;
    }

    public native boolean is64Bit();

    public native boolean isCheckJniEnabled();

    public native boolean isDebuggerActive();

    public native Object newNonMovableArray(Class<?> cls, int i);

    public native Object newUnpaddedArray(Class<?> cls, int i);

    public native void preloadDexCaches();

    public native String[] properties();

    public native void registerNativeAllocation(int i);

    public native void registerNativeFree(int i);

    @Deprecated
    public void runFinalizationSync() {
        System.runFinalization();
    }

    @Deprecated
    public long setMinimumHeapSize(long j) {
        return 0L;
    }

    public float setTargetHeapUtilization(float f) {
        float targetHeapUtilization;
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException(f + " out of range (0,1)");
        }
        synchronized (this) {
            targetHeapUtilization = getTargetHeapUtilization();
            nativeSetTargetHeapUtilization(f);
        }
        return targetHeapUtilization;
    }

    public void setTargetSdkVersion(int i) {
        synchronized (this) {
            this.targetSdkVersion = i;
            setTargetSdkVersionNative(this.targetSdkVersion);
        }
    }

    public native void startJitCompilation();

    @Deprecated
    public boolean trackExternalAllocation(long j) {
        return true;
    }

    @Deprecated
    public void trackExternalFree(long j) {
    }

    public native void trimHeap();

    public native void updateProcessState(int i);

    public native String vmInstructionSet();

    public native String vmLibrary();

    public native String vmVersion();
}
