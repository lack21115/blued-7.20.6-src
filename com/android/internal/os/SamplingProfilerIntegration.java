package com.android.internal.os;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemProperties;
import android.util.Log;
import dalvik.system.profiler.BinaryHprofWriter;
import dalvik.system.profiler.SamplingProfiler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import libcore.io.IoUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/SamplingProfilerIntegration.class */
public class SamplingProfilerIntegration {
    public static final String SNAPSHOT_DIR = "/data/snapshots";
    private static final String TAG = "SamplingProfilerIntegration";
    private static final boolean enabled;
    private static SamplingProfiler samplingProfiler;
    private static final Executor snapshotWriter;
    private static long startMillis;
    private static final AtomicBoolean pending = new AtomicBoolean(false);
    private static final int samplingProfilerMilliseconds = SystemProperties.getInt("persist.sys.profiler_ms", 0);
    private static final int samplingProfilerDepth = SystemProperties.getInt("persist.sys.profiler_depth", 4);

    static {
        if (samplingProfilerMilliseconds <= 0) {
            snapshotWriter = null;
            enabled = false;
            Log.i(TAG, "Profiling disabled.");
            return;
        }
        File file = new File(SNAPSHOT_DIR);
        file.mkdirs();
        file.setWritable(true, false);
        file.setExecutable(true, false);
        if (file.isDirectory()) {
            snapshotWriter = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.android.internal.os.SamplingProfilerIntegration.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, SamplingProfilerIntegration.TAG);
                }
            });
            enabled = true;
            Log.i(TAG, "Profiling enabled. Sampling interval ms: " + samplingProfilerMilliseconds);
            return;
        }
        snapshotWriter = null;
        enabled = true;
        Log.w(TAG, "Profiling setup failed. Could not create /data/snapshots");
    }

    private static void generateSnapshotHeader(String str, PackageInfo packageInfo, PrintStream printStream) {
        printStream.println("Version: 3");
        printStream.println("Process: " + str);
        if (packageInfo != null) {
            printStream.println("Package: " + packageInfo.packageName);
            printStream.println("Package-Version: " + packageInfo.versionCode);
        }
        printStream.println("Build: " + Build.FINGERPRINT);
        printStream.println();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void start() {
        if (enabled) {
            if (samplingProfiler != null) {
                Log.e(TAG, "SamplingProfilerIntegration already started at " + new Date(startMillis));
                return;
            }
            samplingProfiler = new SamplingProfiler(samplingProfilerDepth, SamplingProfiler.newThreadGroupThreadSet(Thread.currentThread().getThreadGroup()));
            samplingProfiler.start(samplingProfilerMilliseconds);
            startMillis = System.currentTimeMillis();
        }
    }

    public static void writeSnapshot(final String str, final PackageInfo packageInfo) {
        if (enabled) {
            if (samplingProfiler == null) {
                Log.e(TAG, "SamplingProfilerIntegration is not started");
            } else if (pending.compareAndSet(false, true)) {
                snapshotWriter.execute(new Runnable() { // from class: com.android.internal.os.SamplingProfilerIntegration.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SamplingProfilerIntegration.writeSnapshotFile(String.this, packageInfo);
                            SamplingProfilerIntegration.pending.set(false);
                        } catch (Throwable th) {
                            SamplingProfilerIntegration.pending.set(false);
                            throw th;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeSnapshotFile(String str, PackageInfo packageInfo) {
        BufferedOutputStream bufferedOutputStream;
        if (!enabled) {
            return;
        }
        samplingProfiler.stop();
        String replaceAll = str.replaceAll(":", ".");
        String str2 = "/data/snapshots/" + replaceAll + "-" + startMillis + ".snapshot";
        long currentTimeMillis = System.currentTimeMillis();
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    PrintStream printStream = new PrintStream(bufferedOutputStream3);
                    generateSnapshotHeader(replaceAll, packageInfo, printStream);
                    if (printStream.checkError()) {
                        throw new IOException();
                    }
                    BinaryHprofWriter.write(samplingProfiler.getHprofData(), bufferedOutputStream3);
                    IoUtils.closeQuietly(bufferedOutputStream3);
                    new File(str2).setReadable(true, false);
                    Log.i(TAG, "Wrote snapshot " + str2 + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                    samplingProfiler.start(samplingProfilerMilliseconds);
                } catch (IOException e) {
                    bufferedOutputStream = bufferedOutputStream3;
                    e = e;
                    Log.e(TAG, "Error writing snapshot to " + str2, e);
                    IoUtils.closeQuietly(bufferedOutputStream);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream2 = bufferedOutputStream3;
                    IoUtils.closeQuietly(bufferedOutputStream2);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void writeZygoteSnapshot() {
        if (enabled) {
            writeSnapshotFile(Process.ZYGOTE_SOCKET, null);
            samplingProfiler.shutdown();
            samplingProfiler = null;
            startMillis = 0L;
        }
    }
}
