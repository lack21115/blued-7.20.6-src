package android.os;

import android.os.Debug;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/os/PerformanceCollector.class */
public class PerformanceCollector {
    public static final String METRIC_KEY_CPU_TIME = "cpu_time";
    public static final String METRIC_KEY_EXECUTION_TIME = "execution_time";
    public static final String METRIC_KEY_GC_INVOCATION_COUNT = "gc_invocation_count";
    public static final String METRIC_KEY_GLOBAL_ALLOC_COUNT = "global_alloc_count";
    public static final String METRIC_KEY_GLOBAL_ALLOC_SIZE = "global_alloc_size";
    public static final String METRIC_KEY_GLOBAL_FREED_COUNT = "global_freed_count";
    public static final String METRIC_KEY_GLOBAL_FREED_SIZE = "global_freed_size";
    public static final String METRIC_KEY_ITERATIONS = "iterations";
    public static final String METRIC_KEY_JAVA_ALLOCATED = "java_allocated";
    public static final String METRIC_KEY_JAVA_FREE = "java_free";
    public static final String METRIC_KEY_JAVA_PRIVATE_DIRTY = "java_private_dirty";
    public static final String METRIC_KEY_JAVA_PSS = "java_pss";
    public static final String METRIC_KEY_JAVA_SHARED_DIRTY = "java_shared_dirty";
    public static final String METRIC_KEY_JAVA_SIZE = "java_size";
    public static final String METRIC_KEY_LABEL = "label";
    public static final String METRIC_KEY_NATIVE_ALLOCATED = "native_allocated";
    public static final String METRIC_KEY_NATIVE_FREE = "native_free";
    public static final String METRIC_KEY_NATIVE_PRIVATE_DIRTY = "native_private_dirty";
    public static final String METRIC_KEY_NATIVE_PSS = "native_pss";
    public static final String METRIC_KEY_NATIVE_SHARED_DIRTY = "native_shared_dirty";
    public static final String METRIC_KEY_NATIVE_SIZE = "native_size";
    public static final String METRIC_KEY_OTHER_PRIVATE_DIRTY = "other_private_dirty";
    public static final String METRIC_KEY_OTHER_PSS = "other_pss";
    public static final String METRIC_KEY_OTHER_SHARED_DIRTY = "other_shared_dirty";
    public static final String METRIC_KEY_PRE_RECEIVED_TRANSACTIONS = "pre_received_transactions";
    public static final String METRIC_KEY_PRE_SENT_TRANSACTIONS = "pre_sent_transactions";
    public static final String METRIC_KEY_RECEIVED_TRANSACTIONS = "received_transactions";
    public static final String METRIC_KEY_SENT_TRANSACTIONS = "sent_transactions";
    private long mCpuTime;
    private long mExecTime;
    private Bundle mPerfMeasurement;
    private Bundle mPerfSnapshot;
    private PerformanceResultsWriter mPerfWriter;
    private long mSnapshotCpuTime;
    private long mSnapshotExecTime;

    /* loaded from: source-9557208-dex2jar.jar:android/os/PerformanceCollector$PerformanceResultsWriter.class */
    public interface PerformanceResultsWriter {
        void writeBeginSnapshot(String str);

        void writeEndSnapshot(Bundle bundle);

        void writeMeasurement(String str, float f);

        void writeMeasurement(String str, long j);

        void writeMeasurement(String str, String str2);

        void writeStartTiming(String str);

        void writeStopTiming(Bundle bundle);
    }

    public PerformanceCollector() {
    }

    public PerformanceCollector(PerformanceResultsWriter performanceResultsWriter) {
        setPerformanceResultsWriter(performanceResultsWriter);
    }

    private void endPerformanceSnapshot() {
        this.mSnapshotCpuTime = Process.getElapsedCpuTime() - this.mSnapshotCpuTime;
        this.mSnapshotExecTime = SystemClock.uptimeMillis() - this.mSnapshotExecTime;
        stopAllocCounting();
        long nativeHeapSize = Debug.getNativeHeapSize() / 1024;
        long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize() / 1024;
        long nativeHeapFreeSize = Debug.getNativeHeapFreeSize() / 1024;
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        Runtime runtime = Runtime.getRuntime();
        long j = runtime.totalMemory() / 1024;
        long freeMemory = runtime.freeMemory() / 1024;
        Bundle binderCounts = getBinderCounts();
        for (String str : binderCounts.keySet()) {
            this.mPerfSnapshot.putLong(str, binderCounts.getLong(str));
        }
        Bundle allocCounts = getAllocCounts();
        for (String str2 : allocCounts.keySet()) {
            this.mPerfSnapshot.putLong(str2, allocCounts.getLong(str2));
        }
        this.mPerfSnapshot.putLong(METRIC_KEY_EXECUTION_TIME, this.mSnapshotExecTime);
        this.mPerfSnapshot.putLong(METRIC_KEY_CPU_TIME, this.mSnapshotCpuTime);
        this.mPerfSnapshot.putLong(METRIC_KEY_NATIVE_SIZE, nativeHeapSize);
        this.mPerfSnapshot.putLong(METRIC_KEY_NATIVE_ALLOCATED, nativeHeapAllocatedSize);
        this.mPerfSnapshot.putLong(METRIC_KEY_NATIVE_FREE, nativeHeapFreeSize);
        this.mPerfSnapshot.putLong(METRIC_KEY_NATIVE_PSS, memoryInfo.nativePss);
        this.mPerfSnapshot.putLong(METRIC_KEY_NATIVE_PRIVATE_DIRTY, memoryInfo.nativePrivateDirty);
        this.mPerfSnapshot.putLong(METRIC_KEY_NATIVE_SHARED_DIRTY, memoryInfo.nativeSharedDirty);
        this.mPerfSnapshot.putLong(METRIC_KEY_JAVA_SIZE, j);
        this.mPerfSnapshot.putLong(METRIC_KEY_JAVA_ALLOCATED, j - freeMemory);
        this.mPerfSnapshot.putLong(METRIC_KEY_JAVA_FREE, freeMemory);
        this.mPerfSnapshot.putLong(METRIC_KEY_JAVA_PSS, memoryInfo.dalvikPss);
        this.mPerfSnapshot.putLong(METRIC_KEY_JAVA_PRIVATE_DIRTY, memoryInfo.dalvikPrivateDirty);
        this.mPerfSnapshot.putLong(METRIC_KEY_JAVA_SHARED_DIRTY, memoryInfo.dalvikSharedDirty);
        this.mPerfSnapshot.putLong(METRIC_KEY_OTHER_PSS, memoryInfo.otherPss);
        this.mPerfSnapshot.putLong(METRIC_KEY_OTHER_PRIVATE_DIRTY, memoryInfo.otherPrivateDirty);
        this.mPerfSnapshot.putLong(METRIC_KEY_OTHER_SHARED_DIRTY, memoryInfo.otherSharedDirty);
    }

    private static Bundle getAllocCounts() {
        Bundle bundle = new Bundle();
        bundle.putLong(METRIC_KEY_GLOBAL_ALLOC_COUNT, Debug.getGlobalAllocCount());
        bundle.putLong(METRIC_KEY_GLOBAL_ALLOC_SIZE, Debug.getGlobalAllocSize());
        bundle.putLong(METRIC_KEY_GLOBAL_FREED_COUNT, Debug.getGlobalFreedCount());
        bundle.putLong(METRIC_KEY_GLOBAL_FREED_SIZE, Debug.getGlobalFreedSize());
        bundle.putLong(METRIC_KEY_GC_INVOCATION_COUNT, Debug.getGlobalGcInvocationCount());
        return bundle;
    }

    private static Bundle getBinderCounts() {
        Bundle bundle = new Bundle();
        bundle.putLong(METRIC_KEY_SENT_TRANSACTIONS, Debug.getBinderSentTransactions());
        bundle.putLong(METRIC_KEY_RECEIVED_TRANSACTIONS, Debug.getBinderReceivedTransactions());
        return bundle;
    }

    private static void startAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.resetAllCounts();
        Debug.startAllocCounting();
    }

    private void startPerformanceSnapshot() {
        this.mPerfSnapshot = new Bundle();
        Bundle binderCounts = getBinderCounts();
        for (String str : binderCounts.keySet()) {
            this.mPerfSnapshot.putLong("pre_" + str, binderCounts.getLong(str));
        }
        startAllocCounting();
        this.mSnapshotExecTime = SystemClock.uptimeMillis();
        this.mSnapshotCpuTime = Process.getElapsedCpuTime();
    }

    private static void stopAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.stopAllocCounting();
    }

    public Bundle addIteration(String str) {
        this.mCpuTime = Process.getElapsedCpuTime() - this.mCpuTime;
        this.mExecTime = SystemClock.uptimeMillis() - this.mExecTime;
        Bundle bundle = new Bundle();
        bundle.putString("label", str);
        bundle.putLong(METRIC_KEY_EXECUTION_TIME, this.mExecTime);
        bundle.putLong(METRIC_KEY_CPU_TIME, this.mCpuTime);
        this.mPerfMeasurement.getParcelableArrayList(METRIC_KEY_ITERATIONS).add(bundle);
        this.mExecTime = SystemClock.uptimeMillis();
        this.mCpuTime = Process.getElapsedCpuTime();
        return bundle;
    }

    public void addMeasurement(String str, float f) {
        if (this.mPerfWriter != null) {
            this.mPerfWriter.writeMeasurement(str, f);
        }
    }

    public void addMeasurement(String str, long j) {
        if (this.mPerfWriter != null) {
            this.mPerfWriter.writeMeasurement(str, j);
        }
    }

    public void addMeasurement(String str, String str2) {
        if (this.mPerfWriter != null) {
            this.mPerfWriter.writeMeasurement(str, str2);
        }
    }

    public void beginSnapshot(String str) {
        if (this.mPerfWriter != null) {
            this.mPerfWriter.writeBeginSnapshot(str);
        }
        startPerformanceSnapshot();
    }

    public Bundle endSnapshot() {
        endPerformanceSnapshot();
        if (this.mPerfWriter != null) {
            this.mPerfWriter.writeEndSnapshot(this.mPerfSnapshot);
        }
        return this.mPerfSnapshot;
    }

    public void setPerformanceResultsWriter(PerformanceResultsWriter performanceResultsWriter) {
        this.mPerfWriter = performanceResultsWriter;
    }

    public void startTiming(String str) {
        if (this.mPerfWriter != null) {
            this.mPerfWriter.writeStartTiming(str);
        }
        this.mPerfMeasurement = new Bundle();
        this.mPerfMeasurement.putParcelableArrayList(METRIC_KEY_ITERATIONS, new ArrayList<>());
        this.mExecTime = SystemClock.uptimeMillis();
        this.mCpuTime = Process.getElapsedCpuTime();
    }

    public Bundle stopTiming(String str) {
        addIteration(str);
        if (this.mPerfWriter != null) {
            this.mPerfWriter.writeStopTiming(this.mPerfMeasurement);
        }
        return this.mPerfMeasurement;
    }
}
