package com.android.internal.os;

import android.os.FileUtils;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Slog;
import com.android.internal.os.BatteryStatsImpl;
import com.android.internal.util.FastPrintWriter;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import libcore.io.IoUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/ProcessCpuTracker.class */
public class ProcessCpuTracker {
    private static final boolean DEBUG = false;
    static final int PROCESS_FULL_STAT_BLOCKIO = 6;
    static final int PROCESS_FULL_STAT_MAJOR_FAULTS = 2;
    static final int PROCESS_FULL_STAT_MINOR_FAULTS = 1;
    static final int PROCESS_FULL_STAT_STIME = 4;
    static final int PROCESS_FULL_STAT_UTIME = 3;
    static final int PROCESS_FULL_STAT_VSIZE = 5;
    static final int PROCESS_STAT_BLOCKIO = 4;
    static final int PROCESS_STAT_MAJOR_FAULTS = 1;
    static final int PROCESS_STAT_MINOR_FAULTS = 0;
    static final int PROCESS_STAT_STIME = 3;
    static final int PROCESS_STAT_UTIME = 2;
    private static final String TAG = "ProcessCpuTracker";
    private static final boolean localLOGV = false;
    private long mBaseIdleTime;
    private long mBaseIoWaitTime;
    private long mBaseIrqTime;
    private long mBaseSoftIrqTime;
    private long mBaseSystemTime;
    private long mBaseUserTime;
    private long[] mCpuSpeedTimes;
    private long[] mCpuSpeeds;
    private int[] mCurPids;
    private int[] mCurThreadPids;
    private long mCurrentSampleRealTime;
    private long mCurrentSampleTime;
    private final boolean mIncludeThreads;
    private long mLastSampleRealTime;
    private long mLastSampleTime;
    private long[] mRelCpuSpeedTimes;
    private int mRelIdleTime;
    private int mRelIoWaitTime;
    private int mRelIrqTime;
    private int mRelSoftIrqTime;
    private int mRelSystemTime;
    private int mRelUserTime;
    private boolean mWorkingProcsSorted;
    private static final int[] PROCESS_STATS_FORMAT = {32, 544, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 8224};
    private static final int[] PROCESS_FULL_STATS_FORMAT = {32, 4640, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 8224};
    private static final int[] SYSTEM_CPU_FORMAT = {288, 8224, 8224, 8224, 8224, 8224, 8224, 8224};
    private static final int[] LOAD_AVERAGE_FORMAT = {16416, 16416, 16416};
    private static final Comparator<Stats> sLoadComparator = new Comparator<Stats>() { // from class: com.android.internal.os.ProcessCpuTracker.1
        @Override // java.util.Comparator
        public final int compare(Stats stats, Stats stats2) {
            int i = stats.rel_utime + stats.rel_stime + stats.rel_iowait;
            int i2 = stats2.rel_utime + stats2.rel_stime + stats2.rel_iowait;
            if (i != i2) {
                return i > i2 ? -1 : 1;
            } else if (stats.added != stats2.added) {
                return !stats.added ? 1 : -1;
            } else if (stats.removed != stats2.removed) {
                return !stats.added ? 1 : -1;
            } else {
                return 0;
            }
        }
    };
    private final long[] mProcessStatsData = new long[5];
    private final long[] mSinglePidStatsData = new long[5];
    private final String[] mProcessFullStatsStringData = new String[7];
    private final long[] mProcessFullStatsData = new long[7];
    private final long[] mSystemCpuData = new long[7];
    private final float[] mLoadAverageData = new float[3];
    private float mLoad1 = 0.0f;
    private float mLoad5 = 0.0f;
    private float mLoad15 = 0.0f;
    private final ArrayList<Stats> mProcStats = new ArrayList<>();
    private final ArrayList<Stats> mWorkingProcs = new ArrayList<>();
    private boolean mFirst = true;
    private byte[] mBuffer = new byte[4096];

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/ProcessCpuTracker$Stats.class */
    public static class Stats {
        public boolean active;
        public boolean added;
        public String baseName;
        public long base_iowait;
        public long base_majfaults;
        public long base_minfaults;
        public long base_stime;
        public long base_uptime;
        public long base_utime;
        public BatteryStatsImpl.Uid.Proc batteryStats;
        final String cmdlineFile;
        public boolean interesting;
        public String name;
        public int nameWidth;
        public final int pid;
        public int rel_iowait;
        public int rel_majfaults;
        public int rel_minfaults;
        public int rel_stime;
        public long rel_uptime;
        public int rel_utime;
        public boolean removed;
        final String statFile;
        final ArrayList<Stats> threadStats;
        final String threadsDir;
        public final int uid;
        public long vsize;
        public boolean working;
        final ArrayList<Stats> workingThreads;

        Stats(int i, int i2, boolean z) {
            this.pid = i;
            if (i2 < 0) {
                File file = new File("/proc", Integer.toString(this.pid));
                this.statFile = new File(file, "stat").toString();
                this.cmdlineFile = new File(file, "cmdline").toString();
                this.threadsDir = new File(file, "task").toString();
                if (z) {
                    this.threadStats = new ArrayList<>();
                    this.workingThreads = new ArrayList<>();
                } else {
                    this.threadStats = null;
                    this.workingThreads = null;
                }
            } else {
                this.statFile = new File(new File(new File(new File("/proc", Integer.toString(i2)), "task"), Integer.toString(this.pid)), "stat").toString();
                this.cmdlineFile = null;
                this.threadsDir = null;
                this.threadStats = null;
                this.workingThreads = null;
            }
            this.uid = FileUtils.getUid(this.statFile.toString());
        }
    }

    public ProcessCpuTracker(boolean z) {
        this.mIncludeThreads = z;
    }

    private int[] collectStats(String str, int i, boolean z, int[] iArr, ArrayList<Stats> arrayList) {
        int i2;
        int i3;
        int i4;
        int[] pids = Process.getPids(str, iArr);
        int length = pids == null ? 0 : pids.length;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i2 = size;
            if (i6 >= length) {
                break;
            }
            int i7 = pids[i6];
            if (i7 < 0) {
                i2 = size;
                break;
            }
            Stats stats = i5 < size ? arrayList.get(i5) : null;
            if (stats != null && stats.pid == i7) {
                stats.added = false;
                stats.working = false;
                int i8 = i5 + 1;
                i3 = size;
                i5 = i8;
                i4 = i6;
                if (stats.interesting) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    long[] jArr = this.mProcessStatsData;
                    if (Process.readProcFile(stats.statFile.toString(), PROCESS_STATS_FORMAT, null, jArr, null)) {
                        long j = jArr[0];
                        long j2 = jArr[1];
                        long j3 = jArr[2];
                        long j4 = jArr[3];
                        long j5 = jArr[4];
                        if (j3 == stats.base_utime && j4 == stats.base_stime) {
                            stats.rel_utime = 0;
                            stats.rel_stime = 0;
                            stats.rel_minfaults = 0;
                            stats.rel_majfaults = 0;
                            stats.rel_iowait = 0;
                            i3 = size;
                            i5 = i8;
                            i4 = i6;
                            if (stats.active) {
                                stats.active = false;
                                i3 = size;
                                i5 = i8;
                                i4 = i6;
                            }
                        } else {
                            if (!stats.active) {
                                stats.active = true;
                            }
                            if (i < 0) {
                                getName(stats, stats.cmdlineFile);
                                if (stats.threadStats != null) {
                                    this.mCurThreadPids = collectStats(stats.threadsDir, i7, false, this.mCurThreadPids, stats.threadStats);
                                }
                            }
                            stats.rel_uptime = uptimeMillis - stats.base_uptime;
                            stats.base_uptime = uptimeMillis;
                            stats.rel_utime = (int) (j3 - stats.base_utime);
                            stats.rel_stime = (int) (j4 - stats.base_stime);
                            stats.base_utime = j3;
                            stats.base_stime = j4;
                            stats.rel_minfaults = (int) (j - stats.base_minfaults);
                            stats.rel_majfaults = (int) (j2 - stats.base_majfaults);
                            stats.base_minfaults = j;
                            stats.base_majfaults = j2;
                            stats.rel_iowait = (int) (j5 - stats.base_iowait);
                            stats.base_iowait = j5;
                            stats.working = true;
                            i3 = size;
                            i5 = i8;
                            i4 = i6;
                        }
                    } else {
                        i4 = i6;
                        i5 = i8;
                        i3 = size;
                    }
                }
            } else if (stats == null || stats.pid > i7) {
                Stats stats2 = new Stats(i7, i, this.mIncludeThreads);
                arrayList.add(i5, stats2);
                int i9 = i5 + 1;
                int i10 = size + 1;
                String[] strArr = this.mProcessFullStatsStringData;
                long[] jArr2 = this.mProcessFullStatsData;
                stats2.base_uptime = SystemClock.uptimeMillis();
                if (Process.readProcFile(stats2.statFile.toString(), PROCESS_FULL_STATS_FORMAT, strArr, jArr2, null)) {
                    stats2.vsize = jArr2[5];
                    stats2.interesting = true;
                    stats2.baseName = strArr[0];
                    stats2.base_minfaults = jArr2[1];
                    stats2.base_majfaults = jArr2[2];
                    stats2.base_utime = jArr2[3];
                    stats2.base_stime = jArr2[4];
                    stats2.base_iowait = jArr2[6];
                } else {
                    Slog.w(TAG, "Skipping unknown process pid " + i7);
                    stats2.baseName = "<unknown>";
                    stats2.base_stime = 0L;
                    stats2.base_utime = 0L;
                    stats2.base_majfaults = 0L;
                    stats2.base_minfaults = 0L;
                    stats2.base_iowait = 0L;
                }
                if (i < 0) {
                    getName(stats2, stats2.cmdlineFile);
                    if (stats2.threadStats != null) {
                        this.mCurThreadPids = collectStats(stats2.threadsDir, i7, true, this.mCurThreadPids, stats2.threadStats);
                    }
                } else if (stats2.interesting) {
                    stats2.name = stats2.baseName;
                    stats2.nameWidth = onMeasureProcessName(stats2.name);
                }
                stats2.rel_utime = 0;
                stats2.rel_stime = 0;
                stats2.rel_minfaults = 0;
                stats2.rel_majfaults = 0;
                stats2.rel_iowait = 0;
                stats2.added = true;
                i3 = i10;
                i5 = i9;
                i4 = i6;
                if (!z) {
                    i3 = i10;
                    i5 = i9;
                    i4 = i6;
                    if (stats2.interesting) {
                        stats2.working = true;
                        i3 = i10;
                        i5 = i9;
                        i4 = i6;
                    }
                }
            } else {
                stats.rel_utime = 0;
                stats.rel_stime = 0;
                stats.rel_minfaults = 0;
                stats.rel_majfaults = 0;
                stats.rel_iowait = 0;
                stats.removed = true;
                stats.working = true;
                arrayList.remove(i5);
                i3 = size - 1;
                i4 = i6 - 1;
            }
            i6 = i4 + 1;
            size = i3;
        }
        while (i5 < i2) {
            Stats stats3 = arrayList.get(i5);
            stats3.rel_utime = 0;
            stats3.rel_stime = 0;
            stats3.rel_minfaults = 0;
            stats3.rel_majfaults = 0;
            stats3.rel_iowait = 0;
            stats3.removed = true;
            stats3.working = true;
            arrayList.remove(i5);
            i2--;
        }
        return pids;
    }

    private long[] getCpuSpeedTimes(long[] jArr) {
        long parseLong;
        long[] jArr2 = jArr;
        long[] jArr3 = this.mCpuSpeeds;
        if (jArr == null) {
            jArr2 = new long[60];
            jArr3 = new long[60];
        }
        int i = 0;
        int i2 = 0;
        String readFile = readFile("/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state", (char) 0);
        if (readFile != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(readFile, "\n ");
            while (true) {
                i = i2;
                if (!stringTokenizer.hasMoreElements()) {
                    break;
                }
                try {
                    parseLong = Long.parseLong(stringTokenizer.nextToken());
                } catch (NumberFormatException e) {
                    Slog.i(TAG, "Unable to parse time_in_state");
                }
                if (i2 >= jArr3.length) {
                    i = i2;
                    break;
                }
                jArr3[i2] = parseLong;
                jArr2[i2] = Long.parseLong(stringTokenizer.nextToken());
                i = i2 + 1;
                i2 = i;
                if (i == 60) {
                    break;
                }
            }
        }
        long[] jArr4 = jArr;
        if (jArr == null) {
            jArr4 = new long[i];
            this.mCpuSpeeds = new long[i];
            System.arraycopy(jArr3, 0, this.mCpuSpeeds, 0, i);
            System.arraycopy(jArr2, 0, jArr4, 0, i);
        }
        return jArr4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (r5.name.equals("<pre-initialized>") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getName(com.android.internal.os.ProcessCpuTracker.Stats r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r0 = r0.name
            r9 = r0
            r0 = r5
            java.lang.String r0 = r0.name
            if (r0 == 0) goto L2b
            r0 = r5
            java.lang.String r0 = r0.name
            java.lang.String r1 = "app_process"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2b
            r0 = r9
            r8 = r0
            r0 = r5
            java.lang.String r0 = r0.name
            java.lang.String r1 = "<pre-initialized>"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
        L2b:
            r0 = r4
            r1 = r6
            r2 = 0
            java.lang.String r0 = r0.readFile(r1, r2)
            r8 = r0
            r0 = r9
            r6 = r0
            r0 = r8
            if (r0 == 0) goto L6e
            r0 = r9
            r6 = r0
            r0 = r8
            int r0 = r0.length()
            r1 = 1
            if (r0 <= r1) goto L6e
            r0 = r8
            java.lang.String r1 = "/"
            int r0 = r0.lastIndexOf(r1)
            r7 = r0
            r0 = r8
            r6 = r0
            r0 = r7
            if (r0 <= 0) goto L6e
            r0 = r8
            r6 = r0
            r0 = r7
            r1 = r8
            int r1 = r1.length()
            r2 = 1
            int r1 = r1 - r2
            if (r0 >= r1) goto L6e
            r0 = r8
            r1 = r7
            r2 = 1
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r1)
            r6 = r0
        L6e:
            r0 = r6
            r8 = r0
            r0 = r6
            if (r0 != 0) goto L7b
            r0 = r5
            java.lang.String r0 = r0.baseName
            r8 = r0
        L7b:
            r0 = r5
            java.lang.String r0 = r0.name
            if (r0 == 0) goto L8e
            r0 = r8
            r1 = r5
            java.lang.String r1 = r1.name
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto La0
        L8e:
            r0 = r5
            r1 = r8
            r0.name = r1
            r0 = r5
            r1 = r4
            r2 = r5
            java.lang.String r2 = r2.name
            int r1 = r1.onMeasureProcessName(r2)
            r0.nameWidth = r1
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.ProcessCpuTracker.getName(com.android.internal.os.ProcessCpuTracker$Stats, java.lang.String):void");
    }

    private void printProcessCPU(PrintWriter printWriter, String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        printWriter.print(str);
        int i10 = i2;
        if (i2 == 0) {
            i10 = 1;
        }
        printRatio(printWriter, i3 + i4 + i5 + i6 + i7, i10);
        printWriter.print("% ");
        if (i >= 0) {
            printWriter.print(i);
            printWriter.print(BridgeUtil.SPLIT_MARK);
        }
        printWriter.print(str2);
        printWriter.print(": ");
        printRatio(printWriter, i3, i10);
        printWriter.print("% user + ");
        printRatio(printWriter, i4, i10);
        printWriter.print("% kernel");
        if (i5 > 0) {
            printWriter.print(" + ");
            printRatio(printWriter, i5, i10);
            printWriter.print("% iowait");
        }
        if (i6 > 0) {
            printWriter.print(" + ");
            printRatio(printWriter, i6, i10);
            printWriter.print("% irq");
        }
        if (i7 > 0) {
            printWriter.print(" + ");
            printRatio(printWriter, i7, i10);
            printWriter.print("% softirq");
        }
        if (i8 > 0 || i9 > 0) {
            printWriter.print(" / faults:");
            if (i8 > 0) {
                printWriter.print(" ");
                printWriter.print(i8);
                printWriter.print(" minor");
            }
            if (i9 > 0) {
                printWriter.print(" ");
                printWriter.print(i9);
                printWriter.print(" major");
            }
        }
        printWriter.println();
    }

    private void printRatio(PrintWriter printWriter, long j, long j2) {
        long j3 = (1000 * j) / j2;
        long j4 = j3 / 10;
        printWriter.print(j4);
        if (j4 < 10) {
            long j5 = j3 - (j4 * 10);
            if (j5 != 0) {
                printWriter.print('.');
                printWriter.print(j5);
            }
        }
    }

    private String readFile(String str, char c) {
        FileInputStream fileInputStream;
        int i;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                int read = fileInputStream.read(this.mBuffer);
                fileInputStream.close();
                if (read <= 0) {
                    IoUtils.closeQuietly(fileInputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    return null;
                }
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= read || this.mBuffer[i] == c) {
                        break;
                    }
                    i2 = i + 1;
                }
                String str2 = new String(this.mBuffer, 0, i);
                IoUtils.closeQuietly(fileInputStream);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return str2;
            } catch (FileNotFoundException e) {
                IoUtils.closeQuietly(fileInputStream);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            } catch (IOException e2) {
                IoUtils.closeQuietly(fileInputStream);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly(fileInputStream);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            fileInputStream = null;
        } catch (IOException e4) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    final void buildWorkingProcs() {
        if (this.mWorkingProcsSorted) {
            return;
        }
        this.mWorkingProcs.clear();
        int size = this.mProcStats.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                Collections.sort(this.mWorkingProcs, sLoadComparator);
                this.mWorkingProcsSorted = true;
                return;
            }
            Stats stats = this.mProcStats.get(i2);
            if (stats.working) {
                this.mWorkingProcs.add(stats);
                if (stats.threadStats != null && stats.threadStats.size() > 1) {
                    stats.workingThreads.clear();
                    int size2 = stats.threadStats.size();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= size2) {
                            break;
                        }
                        Stats stats2 = stats.threadStats.get(i4);
                        if (stats2.working) {
                            stats.workingThreads.add(stats2);
                        }
                        i3 = i4 + 1;
                    }
                    Collections.sort(stats.workingThreads, sLoadComparator);
                }
            }
            i = i2 + 1;
        }
    }

    public final int countStats() {
        return this.mProcStats.size();
    }

    public final int countWorkingStats() {
        buildWorkingProcs();
        return this.mWorkingProcs.size();
    }

    public long getCpuTimeForPid(int i) {
        synchronized (this.mSinglePidStatsData) {
            String str = "/proc/" + i + "/stat";
            long[] jArr = this.mSinglePidStatsData;
            if (Process.readProcFile(str, PROCESS_STATS_FORMAT, null, jArr, null)) {
                return jArr[2] + jArr[3];
            }
            return 0L;
        }
    }

    public long[] getLastCpuSpeedTimes() {
        if (this.mCpuSpeedTimes != null) {
            getCpuSpeedTimes(this.mRelCpuSpeedTimes);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mCpuSpeedTimes.length) {
                    break;
                }
                long j = this.mRelCpuSpeedTimes[i2];
                long[] jArr = this.mRelCpuSpeedTimes;
                jArr[i2] = jArr[i2] - this.mCpuSpeedTimes[i2];
                this.mCpuSpeedTimes[i2] = j;
                i = i2 + 1;
            }
        } else {
            this.mCpuSpeedTimes = getCpuSpeedTimes(null);
            this.mRelCpuSpeedTimes = new long[this.mCpuSpeedTimes.length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mCpuSpeedTimes.length) {
                    break;
                }
                this.mRelCpuSpeedTimes[i4] = 1;
                i3 = i4 + 1;
            }
        }
        return this.mRelCpuSpeedTimes;
    }

    public final int getLastIdleTime() {
        return this.mRelIdleTime;
    }

    public final int getLastIoWaitTime() {
        return this.mRelIoWaitTime;
    }

    public final int getLastIrqTime() {
        return this.mRelIrqTime;
    }

    public final int getLastSoftIrqTime() {
        return this.mRelSoftIrqTime;
    }

    public final int getLastSystemTime() {
        return this.mRelSystemTime;
    }

    public final int getLastUserTime() {
        return this.mRelUserTime;
    }

    public final Stats getStats(int i) {
        return this.mProcStats.get(i);
    }

    public final float getTotalCpuPercent() {
        int i = this.mRelUserTime + this.mRelSystemTime + this.mRelIrqTime + this.mRelIdleTime;
        if (i <= 0) {
            return 0.0f;
        }
        return (((this.mRelUserTime + this.mRelSystemTime) + this.mRelIrqTime) * 100.0f) / i;
    }

    public final Stats getWorkingStats(int i) {
        return this.mWorkingProcs.get(i);
    }

    public void init() {
        this.mFirst = true;
        update();
    }

    public void onLoadChanged(float f, float f2, float f3) {
    }

    public int onMeasureProcessName(String str) {
        return 0;
    }

    public final String printCurrentLoad() {
        StringWriter stringWriter = new StringWriter();
        FastPrintWriter fastPrintWriter = new FastPrintWriter((Writer) stringWriter, false, 128);
        fastPrintWriter.print("Load: ");
        fastPrintWriter.print(this.mLoad1);
        fastPrintWriter.print(" / ");
        fastPrintWriter.print(this.mLoad5);
        fastPrintWriter.print(" / ");
        fastPrintWriter.println(this.mLoad15);
        fastPrintWriter.flush();
        return stringWriter.toString();
    }

    public final String printCurrentState(long j) {
        buildWorkingProcs();
        StringWriter stringWriter = new StringWriter();
        FastPrintWriter fastPrintWriter = new FastPrintWriter((Writer) stringWriter, false, 1024);
        fastPrintWriter.print("CPU usage from ");
        if (j > this.mLastSampleTime) {
            fastPrintWriter.print(j - this.mLastSampleTime);
            fastPrintWriter.print("ms to ");
            fastPrintWriter.print(j - this.mCurrentSampleTime);
            fastPrintWriter.print("ms ago");
        } else {
            fastPrintWriter.print(this.mLastSampleTime - j);
            fastPrintWriter.print("ms to ");
            fastPrintWriter.print(this.mCurrentSampleTime - j);
            fastPrintWriter.print("ms later");
        }
        long j2 = this.mCurrentSampleTime;
        long j3 = this.mLastSampleTime;
        long j4 = this.mCurrentSampleRealTime - this.mLastSampleRealTime;
        long j5 = j4 > 0 ? (100 * (j2 - j3)) / j4 : 0L;
        if (j5 != 100) {
            fastPrintWriter.print(" with ");
            fastPrintWriter.print(j5);
            fastPrintWriter.print("% awake");
        }
        fastPrintWriter.println(":");
        int i = this.mRelUserTime;
        int i2 = this.mRelSystemTime;
        int i3 = this.mRelIoWaitTime;
        int i4 = this.mRelIrqTime;
        int i5 = this.mRelSoftIrqTime;
        int i6 = this.mRelIdleTime;
        int size = this.mWorkingProcs.size();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= size) {
                printProcessCPU(fastPrintWriter, "", -1, "TOTAL", i + i2 + i3 + i4 + i5 + i6, this.mRelUserTime, this.mRelSystemTime, this.mRelIoWaitTime, this.mRelIrqTime, this.mRelSoftIrqTime, 0, 0);
                fastPrintWriter.flush();
                return stringWriter.toString();
            }
            Stats stats = this.mWorkingProcs.get(i8);
            printProcessCPU(fastPrintWriter, stats.added ? " +" : stats.removed ? " -" : "  ", stats.pid, stats.name, ((int) ((stats.rel_uptime + stats.rel_iowait) + 5)) / 10, stats.rel_utime, stats.rel_stime, stats.rel_iowait, 0, 0, stats.rel_minfaults, stats.rel_majfaults);
            if (!stats.removed && stats.workingThreads != null) {
                int size2 = stats.workingThreads.size();
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < size2) {
                        Stats stats2 = stats.workingThreads.get(i10);
                        printProcessCPU(fastPrintWriter, stats2.added ? "   +" : stats2.removed ? "   -" : "    ", stats2.pid, stats2.name, ((int) ((stats.rel_uptime + stats.rel_iowait) + 5)) / 10, stats2.rel_utime, stats2.rel_stime, stats2.rel_iowait, 0, 0, 0, 0);
                        i9 = i10 + 1;
                    }
                }
            }
            i7 = i8 + 1;
        }
    }

    public void update() {
        this.mLastSampleTime = this.mCurrentSampleTime;
        this.mCurrentSampleTime = SystemClock.uptimeMillis();
        this.mLastSampleRealTime = this.mCurrentSampleRealTime;
        this.mCurrentSampleRealTime = SystemClock.elapsedRealtime();
        long[] jArr = this.mSystemCpuData;
        if (Process.readProcFile("/proc/stat", SYSTEM_CPU_FORMAT, null, jArr, null)) {
            long j = jArr[0] + jArr[1];
            long j2 = jArr[2];
            long j3 = jArr[3];
            long j4 = jArr[4];
            long j5 = jArr[5];
            long j6 = jArr[6];
            this.mRelUserTime = (int) (j - this.mBaseUserTime);
            this.mRelSystemTime = (int) (j2 - this.mBaseSystemTime);
            this.mRelIoWaitTime = (int) (j4 - this.mBaseIoWaitTime);
            this.mRelIrqTime = (int) (j5 - this.mBaseIrqTime);
            this.mRelSoftIrqTime = (int) (j6 - this.mBaseSoftIrqTime);
            this.mRelIdleTime = (int) (j3 - this.mBaseIdleTime);
            this.mBaseUserTime = j;
            this.mBaseSystemTime = j2;
            this.mBaseIoWaitTime = j4;
            this.mBaseIrqTime = j5;
            this.mBaseSoftIrqTime = j6;
            this.mBaseIdleTime = j3;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            this.mCurPids = collectStats("/proc", -1, this.mFirst, this.mCurPids, this.mProcStats);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            float[] fArr = this.mLoadAverageData;
            if (Process.readProcFile("/proc/loadavg", LOAD_AVERAGE_FORMAT, null, null, fArr)) {
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2];
                if (f != this.mLoad1 || f2 != this.mLoad5 || f3 != this.mLoad15) {
                    this.mLoad1 = f;
                    this.mLoad5 = f2;
                    this.mLoad15 = f3;
                    onLoadChanged(f, f2, f3);
                }
            }
            this.mWorkingProcsSorted = false;
            this.mFirst = false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }
}
