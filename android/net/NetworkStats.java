package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import com.android.internal.util.ArrayUtils;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import libcore.util.EmptyArray;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkStats.class */
public class NetworkStats implements Parcelable {
    public static final int SET_ALL = -1;
    public static final int SET_DEFAULT = 0;
    public static final int SET_FOREGROUND = 1;
    public static final int TAG_ALL = -1;
    public static final int TAG_NONE = 0;
    public static final int UID_ALL = -1;
    private int capacity;
    private long elapsedRealtime;
    private String[] iface;
    private long[] operations;
    private long[] rxBytes;
    private long[] rxPackets;
    private int[] set;
    private int size;
    private int[] tag;
    private long[] txBytes;
    private long[] txPackets;
    private int[] uid;
    public static final String IFACE_ALL = null;
    public static final Parcelable.Creator<NetworkStats> CREATOR = new Parcelable.Creator<NetworkStats>() { // from class: android.net.NetworkStats.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkStats createFromParcel(Parcel parcel) {
            return new NetworkStats(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkStats[] newArray(int i) {
            return new NetworkStats[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkStats$Entry.class */
    public static class Entry {
        public String iface;
        public long operations;
        public long rxBytes;
        public long rxPackets;
        public int set;
        public int tag;
        public long txBytes;
        public long txPackets;
        public int uid;

        public Entry() {
            this(NetworkStats.IFACE_ALL, -1, 0, 0, 0L, 0L, 0L, 0L, 0L);
        }

        public Entry(long j, long j2, long j3, long j4, long j5) {
            this(NetworkStats.IFACE_ALL, -1, 0, 0, j, j2, j3, j4, j5);
        }

        public Entry(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
            this.iface = str;
            this.uid = i;
            this.set = i2;
            this.tag = i3;
            this.rxBytes = j;
            this.rxPackets = j2;
            this.txBytes = j3;
            this.txPackets = j4;
            this.operations = j5;
        }

        public void add(Entry entry) {
            this.rxBytes += entry.rxBytes;
            this.rxPackets += entry.rxPackets;
            this.txBytes += entry.txBytes;
            this.txPackets += entry.txPackets;
            this.operations += entry.operations;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                z = false;
                if (this.uid == entry.uid) {
                    z = false;
                    if (this.set == entry.set) {
                        z = false;
                        if (this.tag == entry.tag) {
                            z = false;
                            if (this.rxBytes == entry.rxBytes) {
                                z = false;
                                if (this.rxPackets == entry.rxPackets) {
                                    z = false;
                                    if (this.txBytes == entry.txBytes) {
                                        z = false;
                                        if (this.txPackets == entry.txPackets) {
                                            z = false;
                                            if (this.operations == entry.operations) {
                                                z = false;
                                                if (this.iface.equals(entry.iface)) {
                                                    z = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }

        public boolean isEmpty() {
            return this.rxBytes == 0 && this.rxPackets == 0 && this.txBytes == 0 && this.txPackets == 0 && this.operations == 0;
        }

        public boolean isNegative() {
            return this.rxBytes < 0 || this.rxPackets < 0 || this.txBytes < 0 || this.txPackets < 0 || this.operations < 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("iface=").append(this.iface);
            sb.append(" uid=").append(this.uid);
            sb.append(" set=").append(NetworkStats.setToString(this.set));
            sb.append(" tag=").append(NetworkStats.tagToString(this.tag));
            sb.append(" rxBytes=").append(this.rxBytes);
            sb.append(" rxPackets=").append(this.rxPackets);
            sb.append(" txBytes=").append(this.txBytes);
            sb.append(" txPackets=").append(this.txPackets);
            sb.append(" operations=").append(this.operations);
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkStats$NonMonotonicObserver.class */
    public interface NonMonotonicObserver<C> {
        void foundNonMonotonic(NetworkStats networkStats, int i, NetworkStats networkStats2, int i2, C c2);
    }

    public NetworkStats(long j, int i) {
        this.elapsedRealtime = j;
        this.size = 0;
        if (i >= 0) {
            this.capacity = i;
            this.iface = new String[i];
            this.uid = new int[i];
            this.set = new int[i];
            this.tag = new int[i];
            this.rxBytes = new long[i];
            this.rxPackets = new long[i];
            this.txBytes = new long[i];
            this.txPackets = new long[i];
            this.operations = new long[i];
            return;
        }
        this.capacity = 0;
        this.iface = EmptyArray.STRING;
        this.uid = EmptyArray.INT;
        this.set = EmptyArray.INT;
        this.tag = EmptyArray.INT;
        this.rxBytes = EmptyArray.LONG;
        this.rxPackets = EmptyArray.LONG;
        this.txBytes = EmptyArray.LONG;
        this.txPackets = EmptyArray.LONG;
        this.operations = EmptyArray.LONG;
    }

    public NetworkStats(Parcel parcel) {
        this.elapsedRealtime = parcel.readLong();
        this.size = parcel.readInt();
        this.capacity = parcel.readInt();
        this.iface = parcel.createStringArray();
        this.uid = parcel.createIntArray();
        this.set = parcel.createIntArray();
        this.tag = parcel.createIntArray();
        this.rxBytes = parcel.createLongArray();
        this.rxPackets = parcel.createLongArray();
        this.txBytes = parcel.createLongArray();
        this.txPackets = parcel.createLongArray();
        this.operations = parcel.createLongArray();
    }

    private Entry getTotal(Entry entry, HashSet<String> hashSet, int i, boolean z) {
        if (entry == null) {
            entry = new Entry();
        }
        entry.iface = IFACE_ALL;
        entry.uid = i;
        entry.set = -1;
        entry.tag = 0;
        entry.rxBytes = 0L;
        entry.rxPackets = 0L;
        entry.txBytes = 0L;
        entry.txPackets = 0L;
        entry.operations = 0L;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.size) {
                return entry;
            }
            boolean z2 = i == -1 || i == this.uid[i3];
            boolean z3 = hashSet == null || hashSet.contains(this.iface[i3]);
            if (z2 && z3 && (this.tag[i3] == 0 || z)) {
                entry.rxBytes += this.rxBytes[i3];
                entry.rxPackets += this.rxPackets[i3];
                entry.txBytes += this.txBytes[i3];
                entry.txPackets += this.txPackets[i3];
                entry.operations += this.operations[i3];
            }
            i2 = i3 + 1;
        }
    }

    public static String setToCheckinString(int i) {
        switch (i) {
            case -1:
                return "all";
            case 0:
                return "def";
            case 1:
                return "fg";
            default:
                return "unk";
        }
    }

    public static String setToString(int i) {
        switch (i) {
            case -1:
                return Rule.ALL;
            case 0:
                return "DEFAULT";
            case 1:
                return "FOREGROUND";
            default:
                return "UNKNOWN";
        }
    }

    public static <C> NetworkStats subtract(NetworkStats networkStats, NetworkStats networkStats2, NonMonotonicObserver<C> nonMonotonicObserver, C c2) {
        return subtract(networkStats, networkStats2, nonMonotonicObserver, c2, null);
    }

    public static <C> NetworkStats subtract(NetworkStats networkStats, NetworkStats networkStats2, NonMonotonicObserver<C> nonMonotonicObserver, C c2, NetworkStats networkStats3) {
        long j = networkStats.elapsedRealtime - networkStats2.elapsedRealtime;
        long j2 = j;
        if (j < 0) {
            if (nonMonotonicObserver != null) {
                nonMonotonicObserver.foundNonMonotonic(networkStats, -1, networkStats2, -1, c2);
            }
            j2 = 0;
        }
        Entry entry = new Entry();
        if (networkStats3 == null || networkStats3.capacity < networkStats.size) {
            networkStats3 = new NetworkStats(j2, networkStats.size);
        } else {
            networkStats3.size = 0;
            networkStats3.elapsedRealtime = j2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= networkStats.size) {
                return networkStats3;
            }
            entry.iface = networkStats.iface[i2];
            entry.uid = networkStats.uid[i2];
            entry.set = networkStats.set[i2];
            entry.tag = networkStats.tag[i2];
            int findIndexHinted = networkStats2.findIndexHinted(entry.iface, entry.uid, entry.set, entry.tag, i2);
            if (findIndexHinted == -1) {
                entry.rxBytes = networkStats.rxBytes[i2];
                entry.rxPackets = networkStats.rxPackets[i2];
                entry.txBytes = networkStats.txBytes[i2];
                entry.txPackets = networkStats.txPackets[i2];
                entry.operations = networkStats.operations[i2];
            } else {
                entry.rxBytes = networkStats.rxBytes[i2] - networkStats2.rxBytes[findIndexHinted];
                entry.rxPackets = networkStats.rxPackets[i2] - networkStats2.rxPackets[findIndexHinted];
                entry.txBytes = networkStats.txBytes[i2] - networkStats2.txBytes[findIndexHinted];
                entry.txPackets = networkStats.txPackets[i2] - networkStats2.txPackets[findIndexHinted];
                entry.operations = networkStats.operations[i2] - networkStats2.operations[findIndexHinted];
                if (entry.rxBytes < 0 || entry.rxPackets < 0 || entry.txBytes < 0 || entry.txPackets < 0 || entry.operations < 0) {
                    if (nonMonotonicObserver != null) {
                        nonMonotonicObserver.foundNonMonotonic(networkStats, i2, networkStats2, findIndexHinted, c2);
                    }
                    entry.rxBytes = Math.max(entry.rxBytes, 0L);
                    entry.rxPackets = Math.max(entry.rxPackets, 0L);
                    entry.txBytes = Math.max(entry.txBytes, 0L);
                    entry.txPackets = Math.max(entry.txPackets, 0L);
                    entry.operations = Math.max(entry.operations, 0L);
                }
            }
            networkStats3.addValues(entry);
            i = i2 + 1;
        }
    }

    public static String tagToString(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public NetworkStats addIfaceValues(String str, long j, long j2, long j3, long j4) {
        return addValues(str, -1, 0, 0, j, j2, j3, j4, 0L);
    }

    public NetworkStats addValues(Entry entry) {
        if (this.size >= this.capacity) {
            int max = (Math.max(this.size, 10) * 3) / 2;
            this.iface = (String[]) Arrays.copyOf(this.iface, max);
            this.uid = Arrays.copyOf(this.uid, max);
            this.set = Arrays.copyOf(this.set, max);
            this.tag = Arrays.copyOf(this.tag, max);
            this.rxBytes = Arrays.copyOf(this.rxBytes, max);
            this.rxPackets = Arrays.copyOf(this.rxPackets, max);
            this.txBytes = Arrays.copyOf(this.txBytes, max);
            this.txPackets = Arrays.copyOf(this.txPackets, max);
            this.operations = Arrays.copyOf(this.operations, max);
            this.capacity = max;
        }
        this.iface[this.size] = entry.iface;
        this.uid[this.size] = entry.uid;
        this.set[this.size] = entry.set;
        this.tag[this.size] = entry.tag;
        this.rxBytes[this.size] = entry.rxBytes;
        this.rxPackets[this.size] = entry.rxPackets;
        this.txBytes[this.size] = entry.txBytes;
        this.txPackets[this.size] = entry.txPackets;
        this.operations[this.size] = entry.operations;
        this.size++;
        return this;
    }

    public NetworkStats addValues(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
        return addValues(new Entry(str, i, i2, i3, j, j2, j3, j4, j5));
    }

    /* renamed from: clone */
    public NetworkStats m555clone() {
        NetworkStats networkStats = new NetworkStats(this.elapsedRealtime, this.size);
        Entry entry = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return networkStats;
            }
            entry = getValues(i2, entry);
            networkStats.addValues(entry);
            i = i2 + 1;
        }
    }

    public void combineAllValues(NetworkStats networkStats) {
        Entry entry = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= networkStats.size) {
                return;
            }
            entry = networkStats.getValues(i2, entry);
            combineValues(entry);
            i = i2 + 1;
        }
    }

    public NetworkStats combineValues(Entry entry) {
        int findIndex = findIndex(entry.iface, entry.uid, entry.set, entry.tag);
        if (findIndex == -1) {
            addValues(entry);
            return this;
        }
        long[] jArr = this.rxBytes;
        jArr[findIndex] = jArr[findIndex] + entry.rxBytes;
        long[] jArr2 = this.rxPackets;
        jArr2[findIndex] = jArr2[findIndex] + entry.rxPackets;
        long[] jArr3 = this.txBytes;
        jArr3[findIndex] = jArr3[findIndex] + entry.txBytes;
        long[] jArr4 = this.txPackets;
        jArr4[findIndex] = jArr4[findIndex] + entry.txPackets;
        long[] jArr5 = this.operations;
        jArr5[findIndex] = jArr5[findIndex] + entry.operations;
        return this;
    }

    public NetworkStats combineValues(String str, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5) {
        return combineValues(new Entry(str, i, i2, i3, j, j2, j3, j4, j5));
    }

    @Deprecated
    public NetworkStats combineValues(String str, int i, int i2, long j, long j2, long j3, long j4, long j5) {
        return combineValues(str, i, 0, i2, j, j2, j3, j4, j5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("NetworkStats: elapsedRealtime=");
        printWriter.println(this.elapsedRealtime);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return;
            }
            printWriter.print(str);
            printWriter.print("  [");
            printWriter.print(i2);
            printWriter.print("]");
            printWriter.print(" iface=");
            printWriter.print(this.iface[i2]);
            printWriter.print(" uid=");
            printWriter.print(this.uid[i2]);
            printWriter.print(" set=");
            printWriter.print(setToString(this.set[i2]));
            printWriter.print(" tag=");
            printWriter.print(tagToString(this.tag[i2]));
            printWriter.print(" rxBytes=");
            printWriter.print(this.rxBytes[i2]);
            printWriter.print(" rxPackets=");
            printWriter.print(this.rxPackets[i2]);
            printWriter.print(" txBytes=");
            printWriter.print(this.txBytes[i2]);
            printWriter.print(" txPackets=");
            printWriter.print(this.txPackets[i2]);
            printWriter.print(" operations=");
            printWriter.println(this.operations[i2]);
            i = i2 + 1;
        }
    }

    public int findIndex(String str, int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.size) {
                return -1;
            }
            if (i == this.uid[i5] && i2 == this.set[i5] && i3 == this.tag[i5] && Objects.equals(str, this.iface[i5])) {
                return i5;
            }
            i4 = i5 + 1;
        }
    }

    public int findIndexHinted(String str, int i, int i2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.size) {
                return -1;
            }
            int i7 = i6 / 2;
            int i8 = i6 % 2 == 0 ? (i4 + i7) % this.size : (((this.size + i4) - i7) - 1) % this.size;
            if (i == this.uid[i8] && i2 == this.set[i8] && i3 == this.tag[i8] && Objects.equals(str, this.iface[i8])) {
                return i8;
            }
            i5 = i6 + 1;
        }
    }

    public long getElapsedRealtime() {
        return this.elapsedRealtime;
    }

    public long getElapsedRealtimeAge() {
        return SystemClock.elapsedRealtime() - this.elapsedRealtime;
    }

    public Entry getTotal(Entry entry) {
        return getTotal(entry, null, -1, false);
    }

    public Entry getTotal(Entry entry, int i) {
        return getTotal(entry, null, i, false);
    }

    public Entry getTotal(Entry entry, HashSet<String> hashSet) {
        return getTotal(entry, hashSet, -1, false);
    }

    public long getTotalBytes() {
        Entry total = getTotal(null);
        return total.rxBytes + total.txBytes;
    }

    public Entry getTotalIncludingTags(Entry entry) {
        return getTotal(entry, null, -1, true);
    }

    public long getTotalPackets() {
        long j = 0;
        int i = this.size;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return j;
            }
            j += this.rxPackets[i2] + this.txPackets[i2];
            i = i2;
        }
    }

    public String[] getUniqueIfaces() {
        HashSet hashSet = new HashSet();
        String[] strArr = this.iface;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
            String str = strArr[i2];
            if (str != IFACE_ALL) {
                hashSet.add(str);
            }
            i = i2 + 1;
        }
    }

    public int[] getUniqueUids() {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = this.uid;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            sparseBooleanArray.put(iArr[i2], true);
            i = i2 + 1;
        }
        int size = sparseBooleanArray.size();
        int[] iArr2 = new int[size];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return iArr2;
            }
            iArr2[i4] = sparseBooleanArray.keyAt(i4);
            i3 = i4 + 1;
        }
    }

    public Entry getValues(int i, Entry entry) {
        if (entry == null) {
            entry = new Entry();
        }
        entry.iface = this.iface[i];
        entry.uid = this.uid[i];
        entry.set = this.set[i];
        entry.tag = this.tag[i];
        entry.rxBytes = this.rxBytes[i];
        entry.rxPackets = this.rxPackets[i];
        entry.txBytes = this.txBytes[i];
        entry.txPackets = this.txPackets[i];
        entry.operations = this.operations[i];
        return entry;
    }

    public NetworkStats groupedByIface() {
        NetworkStats networkStats = new NetworkStats(this.elapsedRealtime, 10);
        Entry entry = new Entry();
        entry.uid = -1;
        entry.set = -1;
        entry.tag = 0;
        entry.operations = 0L;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return networkStats;
            }
            if (this.tag[i2] == 0) {
                entry.iface = this.iface[i2];
                entry.rxBytes = this.rxBytes[i2];
                entry.rxPackets = this.rxPackets[i2];
                entry.txBytes = this.txBytes[i2];
                entry.txPackets = this.txPackets[i2];
                networkStats.combineValues(entry);
            }
            i = i2 + 1;
        }
    }

    public NetworkStats groupedByUid() {
        NetworkStats networkStats = new NetworkStats(this.elapsedRealtime, 10);
        Entry entry = new Entry();
        entry.iface = IFACE_ALL;
        entry.set = -1;
        entry.tag = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return networkStats;
            }
            if (this.tag[i2] == 0) {
                entry.uid = this.uid[i2];
                entry.rxBytes = this.rxBytes[i2];
                entry.rxPackets = this.rxPackets[i2];
                entry.txBytes = this.txBytes[i2];
                entry.txPackets = this.txPackets[i2];
                entry.operations = this.operations[i2];
                networkStats.combineValues(entry);
            }
            i = i2 + 1;
        }
    }

    public int internalSize() {
        return this.capacity;
    }

    public void setElapsedRealtime(long j) {
        this.elapsedRealtime = j;
    }

    public int size() {
        return this.size;
    }

    public void spliceOperationsFrom(NetworkStats networkStats) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return;
            }
            int findIndex = networkStats.findIndex(this.iface[i2], this.uid[i2], this.set[i2], this.tag[i2]);
            if (findIndex == -1) {
                this.operations[i2] = 0;
            } else {
                this.operations[i2] = networkStats.operations[findIndex];
            }
            i = i2 + 1;
        }
    }

    public NetworkStats subtract(NetworkStats networkStats) {
        return subtract(this, networkStats, null, null);
    }

    public String toString() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        dump("", new PrintWriter(charArrayWriter));
        return charArrayWriter.toString();
    }

    public NetworkStats withoutUids(int[] iArr) {
        NetworkStats networkStats = new NetworkStats(this.elapsedRealtime, 10);
        Entry entry = new Entry();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return networkStats;
            }
            entry = getValues(i2, entry);
            if (!ArrayUtils.contains(iArr, entry.uid)) {
                networkStats.addValues(entry);
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.elapsedRealtime);
        parcel.writeInt(this.size);
        parcel.writeInt(this.capacity);
        parcel.writeStringArray(this.iface);
        parcel.writeIntArray(this.uid);
        parcel.writeIntArray(this.set);
        parcel.writeIntArray(this.tag);
        parcel.writeLongArray(this.rxBytes);
        parcel.writeLongArray(this.rxPackets);
        parcel.writeLongArray(this.txBytes);
        parcel.writeLongArray(this.txPackets);
        parcel.writeLongArray(this.operations);
    }
}
