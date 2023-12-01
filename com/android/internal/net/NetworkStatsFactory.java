package com.android.internal.net;

import android.net.NetworkStats;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.ArrayMap;
import com.android.internal.annotations.GuardedBy;
import com.android.internal.util.ProcFileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import libcore.io.IoUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/net/NetworkStatsFactory.class */
public class NetworkStatsFactory {
    private static final boolean SANITY_CHECK_NATIVE = false;
    private static final String TAG = "NetworkStatsFactory";
    private static final boolean USE_NATIVE_PARSING = true;
    @GuardedBy("sStackedIfaces")
    private static final ArrayMap<String, String> sStackedIfaces = new ArrayMap<>();
    private final File mStatsXtIfaceAll;
    private final File mStatsXtIfaceFmt;
    private final File mStatsXtUid;

    public NetworkStatsFactory() {
        this(new File("/proc/"));
    }

    public NetworkStatsFactory(File file) {
        this.mStatsXtIfaceAll = new File(file, "net/xt_qtaguid/iface_stat_all");
        this.mStatsXtIfaceFmt = new File(file, "net/xt_qtaguid/iface_stat_fmt");
        this.mStatsXtUid = new File(file, "net/xt_qtaguid/stats");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0071, code lost:
        r10 = r12;
        r11 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009e, code lost:
        throw new java.net.ProtocolException("inconsistent idx=" + r12 + " after lastIdx=" + r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.NetworkStats javaReadNetworkStatsDetail(java.io.File r6, int r7, java.lang.String[] r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.net.NetworkStatsFactory.javaReadNetworkStatsDetail(java.io.File, int, java.lang.String[], int):android.net.NetworkStats");
    }

    public static native int nativeReadNetworkStatsDetail(NetworkStats networkStats, String str, int i, String[] strArr, int i2);

    public static void noteStackedIface(String str, String str2) {
        synchronized (sStackedIfaces) {
            if (str2 != null) {
                sStackedIfaces.put(str, str2);
            } else {
                sStackedIfaces.remove(str);
            }
        }
    }

    private NetworkStats readNetworkStatsDetailInternal(int i, String[] strArr, int i2, NetworkStats networkStats) throws IOException {
        if (networkStats != null) {
            networkStats.setElapsedRealtime(SystemClock.elapsedRealtime());
        } else {
            networkStats = new NetworkStats(SystemClock.elapsedRealtime(), -1);
        }
        if (nativeReadNetworkStatsDetail(networkStats, this.mStatsXtUid.getAbsolutePath(), i, strArr, i2) != 0) {
            throw new IOException("Failed to parse network stats");
        }
        return networkStats;
    }

    public void assertEquals(NetworkStats networkStats, NetworkStats networkStats2) {
        if (networkStats.size() != networkStats2.size()) {
            throw new AssertionError("Expected size " + networkStats.size() + ", actual size " + networkStats2.size());
        }
        NetworkStats.Entry entry = null;
        NetworkStats.Entry entry2 = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= networkStats.size()) {
                return;
            }
            entry = networkStats.getValues(i2, entry);
            entry2 = networkStats2.getValues(i2, entry2);
            if (!entry.equals(entry2)) {
                throw new AssertionError("Expected row " + i2 + ": " + entry + ", actual row " + entry2);
            }
            i = i2 + 1;
        }
    }

    public NetworkStats readNetworkStatsDetail() throws IOException {
        return readNetworkStatsDetail(-1, null, -1, null);
    }

    public NetworkStats readNetworkStatsDetail(int i, String[] strArr, int i2, NetworkStats networkStats) throws IOException {
        NetworkStats readNetworkStatsDetailInternal = readNetworkStatsDetailInternal(i, strArr, i2, networkStats);
        synchronized (sStackedIfaces) {
            int size = sStackedIfaces.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                String keyAt = sStackedIfaces.keyAt(i4);
                NetworkStats.Entry entry = new NetworkStats.Entry(sStackedIfaces.valueAt(i4), 0, 0, 0, 0L, 0L, 0L, 0L, 0L);
                NetworkStats.Entry entry2 = null;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= readNetworkStatsDetailInternal.size()) {
                        break;
                    }
                    entry2 = readNetworkStatsDetailInternal.getValues(i6, entry2);
                    if (Objects.equals(entry2.iface, keyAt)) {
                        entry.txBytes -= entry2.txBytes;
                        entry.txPackets -= entry2.txPackets;
                    }
                    i5 = i6 + 1;
                }
                readNetworkStatsDetailInternal.combineValues(entry);
                i3 = i4 + 1;
            }
        }
        NetworkStats.Entry entry3 = null;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= readNetworkStatsDetailInternal.size()) {
                return readNetworkStatsDetailInternal;
            }
            entry3 = readNetworkStatsDetailInternal.getValues(i8, entry3);
            if (entry3.iface != null && entry3.iface.startsWith("clat")) {
                entry3.rxBytes = entry3.rxPackets * 20;
                entry3.rxPackets = 0L;
                entry3.txBytes = 0L;
                entry3.txPackets = 0L;
                readNetworkStatsDetailInternal.combineValues(entry3);
            }
            i7 = i8 + 1;
        }
    }

    public NetworkStats readNetworkStatsSummaryDev() throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        NetworkStats networkStats = new NetworkStats(SystemClock.elapsedRealtime(), 6);
        NetworkStats.Entry entry = new NetworkStats.Entry();
        ProcFileReader procFileReader = null;
        try {
            try {
                ProcFileReader procFileReader2 = new ProcFileReader(new FileInputStream(this.mStatsXtIfaceAll));
                while (procFileReader2.hasMoreData()) {
                    try {
                        entry.iface = procFileReader2.nextString();
                        entry.uid = -1;
                        entry.set = -1;
                        entry.tag = 0;
                        boolean z = procFileReader2.nextInt() != 0;
                        entry.rxBytes = procFileReader2.nextLong();
                        entry.rxPackets = procFileReader2.nextLong();
                        entry.txBytes = procFileReader2.nextLong();
                        entry.txPackets = procFileReader2.nextLong();
                        if (z) {
                            entry.rxBytes += procFileReader2.nextLong();
                            entry.rxPackets += procFileReader2.nextLong();
                            entry.txBytes += procFileReader2.nextLong();
                            entry.txPackets += procFileReader2.nextLong();
                        }
                        networkStats.addValues(entry);
                        procFileReader2.finishLine();
                    } catch (NullPointerException e) {
                        e = e;
                        throw new ProtocolException("problem parsing stats", e);
                    } catch (NumberFormatException e2) {
                        e = e2;
                        throw new ProtocolException("problem parsing stats", e);
                    } catch (Throwable th) {
                        procFileReader = procFileReader2;
                        th = th;
                        IoUtils.closeQuietly(procFileReader);
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
                IoUtils.closeQuietly(procFileReader2);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return networkStats;
            } catch (NullPointerException e3) {
                e = e3;
            } catch (NumberFormatException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public NetworkStats readNetworkStatsSummaryXt() throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (!this.mStatsXtIfaceFmt.exists()) {
            return null;
        }
        NetworkStats networkStats = new NetworkStats(SystemClock.elapsedRealtime(), 6);
        NetworkStats.Entry entry = new NetworkStats.Entry();
        ProcFileReader procFileReader = null;
        try {
            try {
                ProcFileReader procFileReader2 = new ProcFileReader(new FileInputStream(this.mStatsXtIfaceFmt));
                try {
                    procFileReader2.finishLine();
                    while (procFileReader2.hasMoreData()) {
                        entry.iface = procFileReader2.nextString();
                        entry.uid = -1;
                        entry.set = -1;
                        entry.tag = 0;
                        entry.rxBytes = procFileReader2.nextLong();
                        entry.rxPackets = procFileReader2.nextLong();
                        entry.txBytes = procFileReader2.nextLong();
                        entry.txPackets = procFileReader2.nextLong();
                        networkStats.addValues(entry);
                        procFileReader2.finishLine();
                    }
                    IoUtils.closeQuietly(procFileReader2);
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    return networkStats;
                } catch (NullPointerException e) {
                    e = e;
                    throw new ProtocolException("problem parsing stats", e);
                } catch (NumberFormatException e2) {
                    e = e2;
                    throw new ProtocolException("problem parsing stats", e);
                } catch (Throwable th) {
                    procFileReader = procFileReader2;
                    th = th;
                    IoUtils.closeQuietly(procFileReader);
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw th;
                }
            } catch (NullPointerException e3) {
                e = e3;
            } catch (NumberFormatException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
