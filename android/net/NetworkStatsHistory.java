package android.net;

import android.net.NetworkStats;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.MathUtils;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IndentingPrintWriter;
import java.io.CharArrayWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ProtocolException;
import java.util.Arrays;
import java.util.Random;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkStatsHistory.class */
public class NetworkStatsHistory implements Parcelable {
    public static final Parcelable.Creator<NetworkStatsHistory> CREATOR = new Parcelable.Creator<NetworkStatsHistory>() { // from class: android.net.NetworkStatsHistory.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkStatsHistory createFromParcel(Parcel parcel) {
            return new NetworkStatsHistory(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkStatsHistory[] newArray(int i) {
            return new NetworkStatsHistory[i];
        }
    };
    public static final int FIELD_ACTIVE_TIME = 1;
    public static final int FIELD_ALL = -1;
    public static final int FIELD_OPERATIONS = 32;
    public static final int FIELD_RX_BYTES = 2;
    public static final int FIELD_RX_PACKETS = 4;
    public static final int FIELD_TX_BYTES = 8;
    public static final int FIELD_TX_PACKETS = 16;
    private static final int VERSION_ADD_ACTIVE = 3;
    private static final int VERSION_ADD_PACKETS = 2;
    private static final int VERSION_INIT = 1;
    private long[] activeTime;
    private int bucketCount;
    private long bucketDuration;
    private long[] bucketStart;
    private long[] operations;
    private long[] rxBytes;
    private long[] rxPackets;
    private long totalBytes;
    private long[] txBytes;
    private long[] txPackets;

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkStatsHistory$DataStreamUtils.class */
    public static class DataStreamUtils {
        @Deprecated
        public static long[] readFullLongArray(DataInputStream dataInputStream) throws IOException {
            int readInt = dataInputStream.readInt();
            if (readInt < 0) {
                throw new ProtocolException("negative array size");
            }
            long[] jArr = new long[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jArr.length) {
                    return jArr;
                }
                jArr[i2] = dataInputStream.readLong();
                i = i2 + 1;
            }
        }

        public static long readVarLong(DataInputStream dataInputStream) throws IOException {
            byte readByte;
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (readByte & Byte.MAX_VALUE) << i;
                if ((dataInputStream.readByte() & 128) == 0) {
                    return j;
                }
            }
            throw new ProtocolException("malformed long");
        }

        public static long[] readVarLongArray(DataInputStream dataInputStream) throws IOException {
            long[] jArr;
            int readInt = dataInputStream.readInt();
            if (readInt != -1) {
                if (readInt >= 0) {
                    long[] jArr2 = new long[readInt];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        jArr = jArr2;
                        if (i2 >= jArr2.length) {
                            break;
                        }
                        jArr2[i2] = readVarLong(dataInputStream);
                        i = i2 + 1;
                    }
                } else {
                    throw new ProtocolException("negative array size");
                }
            } else {
                jArr = null;
            }
            return jArr;
        }

        public static void writeVarLong(DataOutputStream dataOutputStream, long j) throws IOException {
            while (((-128) & j) != 0) {
                dataOutputStream.writeByte((((int) j) & 127) | 128);
                j >>>= 7;
            }
            dataOutputStream.writeByte((int) j);
        }

        public static void writeVarLongArray(DataOutputStream dataOutputStream, long[] jArr, int i) throws IOException {
            if (jArr == null) {
                dataOutputStream.writeInt(-1);
            } else if (i > jArr.length) {
                throw new IllegalArgumentException("size larger than length");
            } else {
                dataOutputStream.writeInt(i);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        return;
                    }
                    writeVarLong(dataOutputStream, jArr[i3]);
                    i2 = i3 + 1;
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkStatsHistory$Entry.class */
    public static class Entry {
        public static final long UNKNOWN = -1;
        public long activeTime;
        public long bucketDuration;
        public long bucketStart;
        public long operations;
        public long rxBytes;
        public long rxPackets;
        public long txBytes;
        public long txPackets;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkStatsHistory$ParcelUtils.class */
    public static class ParcelUtils {
        public static long[] readLongArray(Parcel parcel) {
            long[] jArr;
            int readInt = parcel.readInt();
            if (readInt != -1) {
                long[] jArr2 = new long[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    jArr = jArr2;
                    if (i2 >= jArr2.length) {
                        break;
                    }
                    jArr2[i2] = parcel.readLong();
                    i = i2 + 1;
                }
            } else {
                jArr = null;
            }
            return jArr;
        }

        public static void writeLongArray(Parcel parcel, long[] jArr, int i) {
            if (jArr == null) {
                parcel.writeInt(-1);
            } else if (i > jArr.length) {
                throw new IllegalArgumentException("size larger than length");
            } else {
                parcel.writeInt(i);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= i) {
                        return;
                    }
                    parcel.writeLong(jArr[i3]);
                    i2 = i3 + 1;
                }
            }
        }
    }

    public NetworkStatsHistory(long j) {
        this(j, 10, -1);
    }

    public NetworkStatsHistory(long j, int i) {
        this(j, i, -1);
    }

    public NetworkStatsHistory(long j, int i, int i2) {
        this.bucketDuration = j;
        this.bucketStart = new long[i];
        if ((i2 & 1) != 0) {
            this.activeTime = new long[i];
        }
        if ((i2 & 2) != 0) {
            this.rxBytes = new long[i];
        }
        if ((i2 & 4) != 0) {
            this.rxPackets = new long[i];
        }
        if ((i2 & 8) != 0) {
            this.txBytes = new long[i];
        }
        if ((i2 & 16) != 0) {
            this.txPackets = new long[i];
        }
        if ((i2 & 32) != 0) {
            this.operations = new long[i];
        }
        this.bucketCount = 0;
        this.totalBytes = 0L;
    }

    public NetworkStatsHistory(NetworkStatsHistory networkStatsHistory, long j) {
        this(j, networkStatsHistory.estimateResizeBuckets(j));
        recordEntireHistory(networkStatsHistory);
    }

    public NetworkStatsHistory(Parcel parcel) {
        this.bucketDuration = parcel.readLong();
        this.bucketStart = ParcelUtils.readLongArray(parcel);
        this.activeTime = ParcelUtils.readLongArray(parcel);
        this.rxBytes = ParcelUtils.readLongArray(parcel);
        this.rxPackets = ParcelUtils.readLongArray(parcel);
        this.txBytes = ParcelUtils.readLongArray(parcel);
        this.txPackets = ParcelUtils.readLongArray(parcel);
        this.operations = ParcelUtils.readLongArray(parcel);
        this.bucketCount = this.bucketStart.length;
        this.totalBytes = parcel.readLong();
    }

    public NetworkStatsHistory(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        switch (readInt) {
            case 1:
                this.bucketDuration = dataInputStream.readLong();
                this.bucketStart = DataStreamUtils.readFullLongArray(dataInputStream);
                this.rxBytes = DataStreamUtils.readFullLongArray(dataInputStream);
                this.rxPackets = new long[this.bucketStart.length];
                this.txBytes = DataStreamUtils.readFullLongArray(dataInputStream);
                this.txPackets = new long[this.bucketStart.length];
                this.operations = new long[this.bucketStart.length];
                this.bucketCount = this.bucketStart.length;
                this.totalBytes = ArrayUtils.total(this.rxBytes) + ArrayUtils.total(this.txBytes);
                break;
            case 2:
            case 3:
                this.bucketDuration = dataInputStream.readLong();
                this.bucketStart = DataStreamUtils.readVarLongArray(dataInputStream);
                this.activeTime = readInt >= 3 ? DataStreamUtils.readVarLongArray(dataInputStream) : new long[this.bucketStart.length];
                this.rxBytes = DataStreamUtils.readVarLongArray(dataInputStream);
                this.rxPackets = DataStreamUtils.readVarLongArray(dataInputStream);
                this.txBytes = DataStreamUtils.readVarLongArray(dataInputStream);
                this.txPackets = DataStreamUtils.readVarLongArray(dataInputStream);
                this.operations = DataStreamUtils.readVarLongArray(dataInputStream);
                this.bucketCount = this.bucketStart.length;
                this.totalBytes = ArrayUtils.total(this.rxBytes) + ArrayUtils.total(this.txBytes);
                break;
            default:
                throw new ProtocolException("unexpected version: " + readInt);
        }
        if (this.bucketStart.length != this.bucketCount || this.rxBytes.length != this.bucketCount || this.rxPackets.length != this.bucketCount || this.txBytes.length != this.bucketCount || this.txPackets.length != this.bucketCount || this.operations.length != this.bucketCount) {
            throw new ProtocolException("Mismatched history lengths");
        }
    }

    private static void addLong(long[] jArr, int i, long j) {
        if (jArr != null) {
            jArr[i] = jArr[i] + j;
        }
    }

    private void ensureBuckets(long j, long j2) {
        long j3 = this.bucketDuration;
        long j4 = this.bucketDuration;
        long j5 = this.bucketDuration;
        long j6 = this.bucketDuration;
        long j7 = j - (j % j3);
        while (true) {
            long j8 = j7;
            if (j8 >= j2 + ((j4 - (j2 % j5)) % j6)) {
                return;
            }
            int binarySearch = Arrays.binarySearch(this.bucketStart, 0, this.bucketCount, j8);
            if (binarySearch < 0) {
                insertBucket(binarySearch ^ (-1), j8);
            }
            j7 = j8 + this.bucketDuration;
        }
    }

    private static long getLong(long[] jArr, int i, long j) {
        if (jArr != null) {
            j = jArr[i];
        }
        return j;
    }

    private void insertBucket(int i, long j) {
        if (this.bucketCount >= this.bucketStart.length) {
            int max = (Math.max(this.bucketStart.length, 10) * 3) / 2;
            this.bucketStart = Arrays.copyOf(this.bucketStart, max);
            if (this.activeTime != null) {
                this.activeTime = Arrays.copyOf(this.activeTime, max);
            }
            if (this.rxBytes != null) {
                this.rxBytes = Arrays.copyOf(this.rxBytes, max);
            }
            if (this.rxPackets != null) {
                this.rxPackets = Arrays.copyOf(this.rxPackets, max);
            }
            if (this.txBytes != null) {
                this.txBytes = Arrays.copyOf(this.txBytes, max);
            }
            if (this.txPackets != null) {
                this.txPackets = Arrays.copyOf(this.txPackets, max);
            }
            if (this.operations != null) {
                this.operations = Arrays.copyOf(this.operations, max);
            }
        }
        if (i < this.bucketCount) {
            int i2 = i + 1;
            int i3 = this.bucketCount - i;
            System.arraycopy(this.bucketStart, i, this.bucketStart, i2, i3);
            if (this.activeTime != null) {
                System.arraycopy(this.activeTime, i, this.activeTime, i2, i3);
            }
            if (this.rxBytes != null) {
                System.arraycopy(this.rxBytes, i, this.rxBytes, i2, i3);
            }
            if (this.rxPackets != null) {
                System.arraycopy(this.rxPackets, i, this.rxPackets, i2, i3);
            }
            if (this.txBytes != null) {
                System.arraycopy(this.txBytes, i, this.txBytes, i2, i3);
            }
            if (this.txPackets != null) {
                System.arraycopy(this.txPackets, i, this.txPackets, i2, i3);
            }
            if (this.operations != null) {
                System.arraycopy(this.operations, i, this.operations, i2, i3);
            }
        }
        this.bucketStart[i] = j;
        setLong(this.activeTime, i, 0L);
        setLong(this.rxBytes, i, 0L);
        setLong(this.rxPackets, i, 0L);
        setLong(this.txBytes, i, 0L);
        setLong(this.txPackets, i, 0L);
        setLong(this.operations, i, 0L);
        this.bucketCount++;
    }

    public static long randomLong(Random random, long j, long j2) {
        return ((float) j) + (random.nextFloat() * ((float) (j2 - j)));
    }

    private static void setLong(long[] jArr, int i, long j) {
        if (jArr != null) {
            jArr[i] = j;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(IndentingPrintWriter indentingPrintWriter, boolean z) {
        int i = 0;
        indentingPrintWriter.print("NetworkStatsHistory: bucketDuration=");
        indentingPrintWriter.println(this.bucketDuration / 1000);
        indentingPrintWriter.increaseIndent();
        if (!z) {
            i = Math.max(0, this.bucketCount - 32);
        }
        if (i > 0) {
            indentingPrintWriter.print("(omitting ");
            indentingPrintWriter.print(i);
            indentingPrintWriter.println(" buckets)");
        }
        while (i < this.bucketCount) {
            indentingPrintWriter.print("st=");
            indentingPrintWriter.print(this.bucketStart[i] / 1000);
            if (this.rxBytes != null) {
                indentingPrintWriter.print(" rb=");
                indentingPrintWriter.print(this.rxBytes[i]);
            }
            if (this.rxPackets != null) {
                indentingPrintWriter.print(" rp=");
                indentingPrintWriter.print(this.rxPackets[i]);
            }
            if (this.txBytes != null) {
                indentingPrintWriter.print(" tb=");
                indentingPrintWriter.print(this.txBytes[i]);
            }
            if (this.txPackets != null) {
                indentingPrintWriter.print(" tp=");
                indentingPrintWriter.print(this.txPackets[i]);
            }
            if (this.operations != null) {
                indentingPrintWriter.print(" op=");
                indentingPrintWriter.print(this.operations[i]);
            }
            indentingPrintWriter.println();
            i++;
        }
        indentingPrintWriter.decreaseIndent();
    }

    public void dumpCheckin(PrintWriter printWriter) {
        printWriter.print("d,");
        printWriter.print(this.bucketDuration / 1000);
        printWriter.println();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bucketCount) {
                return;
            }
            printWriter.print("b,");
            printWriter.print(this.bucketStart[i2] / 1000);
            printWriter.print(',');
            if (this.rxBytes != null) {
                printWriter.print(this.rxBytes[i2]);
            } else {
                printWriter.print(PhoneConstants.APN_TYPE_ALL);
            }
            printWriter.print(',');
            if (this.rxPackets != null) {
                printWriter.print(this.rxPackets[i2]);
            } else {
                printWriter.print(PhoneConstants.APN_TYPE_ALL);
            }
            printWriter.print(',');
            if (this.txBytes != null) {
                printWriter.print(this.txBytes[i2]);
            } else {
                printWriter.print(PhoneConstants.APN_TYPE_ALL);
            }
            printWriter.print(',');
            if (this.txPackets != null) {
                printWriter.print(this.txPackets[i2]);
            } else {
                printWriter.print(PhoneConstants.APN_TYPE_ALL);
            }
            printWriter.print(',');
            if (this.operations != null) {
                printWriter.print(this.operations[i2]);
            } else {
                printWriter.print(PhoneConstants.APN_TYPE_ALL);
            }
            printWriter.println();
            i = i2 + 1;
        }
    }

    public int estimateResizeBuckets(long j) {
        return (int) ((size() * getBucketDuration()) / j);
    }

    @Deprecated
    public void generateRandom(long j, long j2, long j3) {
        Random random = new Random();
        float nextFloat = random.nextFloat();
        long j4 = ((float) j3) * nextFloat;
        long j5 = ((float) j3) * (1.0f - nextFloat);
        generateRandom(j, j2, j4, j4 / 1024, j5, j5 / 1024, j4 / 2048, random);
    }

    @Deprecated
    public void generateRandom(long j, long j2, long j3, long j4, long j5, long j6, long j7, Random random) {
        ensureBuckets(j, j2);
        NetworkStats.Entry entry = new NetworkStats.Entry(NetworkStats.IFACE_ALL, -1, 0, 0, 0L, 0L, 0L, 0L, 0L);
        while (true) {
            if (j3 <= 1024 && j4 <= 128 && j5 <= 1024 && j6 <= 128 && j7 <= 32) {
                return;
            }
            long randomLong = randomLong(random, j, j2);
            long randomLong2 = randomLong(random, 0L, (j2 - randomLong) / 2);
            entry.rxBytes = randomLong(random, 0L, j3);
            entry.rxPackets = randomLong(random, 0L, j4);
            entry.txBytes = randomLong(random, 0L, j5);
            entry.txPackets = randomLong(random, 0L, j6);
            entry.operations = randomLong(random, 0L, j7);
            j3 -= entry.rxBytes;
            j4 -= entry.rxPackets;
            j5 -= entry.txBytes;
            j6 -= entry.txPackets;
            j7 -= entry.operations;
            recordData(randomLong, randomLong + randomLong2, entry);
        }
    }

    public long getBucketDuration() {
        return this.bucketDuration;
    }

    public long getEnd() {
        if (this.bucketCount > 0) {
            return this.bucketStart[this.bucketCount - 1] + this.bucketDuration;
        }
        return Long.MIN_VALUE;
    }

    public int getIndexAfter(long j) {
        int binarySearch = Arrays.binarySearch(this.bucketStart, 0, this.bucketCount, j);
        return MathUtils.constrain(binarySearch < 0 ? binarySearch ^ (-1) : binarySearch + 1, 0, this.bucketCount - 1);
    }

    public int getIndexBefore(long j) {
        int binarySearch = Arrays.binarySearch(this.bucketStart, 0, this.bucketCount, j);
        return MathUtils.constrain(binarySearch < 0 ? (binarySearch ^ (-1)) - 1 : binarySearch - 1, 0, this.bucketCount - 1);
    }

    public long getStart() {
        if (this.bucketCount > 0) {
            return this.bucketStart[0];
        }
        return Long.MAX_VALUE;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public Entry getValues(int i, Entry entry) {
        if (entry == null) {
            entry = new Entry();
        }
        entry.bucketStart = this.bucketStart[i];
        entry.bucketDuration = this.bucketDuration;
        entry.activeTime = getLong(this.activeTime, i, -1L);
        entry.rxBytes = getLong(this.rxBytes, i, -1L);
        entry.rxPackets = getLong(this.rxPackets, i, -1L);
        entry.txBytes = getLong(this.txBytes, i, -1L);
        entry.txPackets = getLong(this.txPackets, i, -1L);
        entry.operations = getLong(this.operations, i, -1L);
        return entry;
    }

    public Entry getValues(long j, long j2, long j3, Entry entry) {
        long j4;
        if (entry == null) {
            entry = new Entry();
        }
        entry.bucketDuration = j2 - j;
        entry.bucketStart = j;
        entry.activeTime = this.activeTime != null ? 0L : -1L;
        entry.rxBytes = this.rxBytes != null ? 0L : -1L;
        entry.rxPackets = this.rxPackets != null ? 0L : -1L;
        entry.txBytes = this.txBytes != null ? 0L : -1L;
        entry.txPackets = this.txPackets != null ? 0L : -1L;
        entry.operations = this.operations != null ? 0L : -1L;
        int indexAfter = getIndexAfter(j2);
        while (true) {
            int i = indexAfter;
            if (i < 0) {
                break;
            }
            long j5 = this.bucketStart[i];
            long j6 = j5 + this.bucketDuration;
            if (j6 <= j) {
                break;
            }
            if (j5 < j2) {
                if (j5 < j3 && j6 > j3) {
                    j4 = this.bucketDuration;
                } else {
                    if (j6 >= j2) {
                        j6 = j2;
                    }
                    if (j5 <= j) {
                        j5 = j;
                    }
                    j4 = j6 - j5;
                }
                if (j4 > 0) {
                    if (this.activeTime != null) {
                        entry.activeTime += (this.activeTime[i] * j4) / this.bucketDuration;
                    }
                    if (this.rxBytes != null) {
                        entry.rxBytes += (this.rxBytes[i] * j4) / this.bucketDuration;
                    }
                    if (this.rxPackets != null) {
                        entry.rxPackets += (this.rxPackets[i] * j4) / this.bucketDuration;
                    }
                    if (this.txBytes != null) {
                        entry.txBytes += (this.txBytes[i] * j4) / this.bucketDuration;
                    }
                    if (this.txPackets != null) {
                        entry.txPackets += (this.txPackets[i] * j4) / this.bucketDuration;
                    }
                    if (this.operations != null) {
                        entry.operations += (this.operations[i] * j4) / this.bucketDuration;
                    }
                }
            }
            indexAfter = i - 1;
        }
        return entry;
    }

    public Entry getValues(long j, long j2, Entry entry) {
        return getValues(j, j2, Long.MAX_VALUE, entry);
    }

    public boolean intersects(long j, long j2) {
        long start = getStart();
        long end = getEnd();
        if (j < start || j > end) {
            if (j2 < start || j2 > end) {
                if (start < j || start > j2) {
                    return end >= j && end <= j2;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    @Deprecated
    public void recordData(long j, long j2, long j3, long j4) {
        recordData(j, j2, new NetworkStats.Entry(NetworkStats.IFACE_ALL, -1, 0, 0, j3, 0L, j4, 0L, 0L));
    }

    public void recordData(long j, long j2, NetworkStats.Entry entry) {
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9 = entry.rxBytes;
        long j10 = entry.rxPackets;
        long j11 = entry.txBytes;
        long j12 = entry.txPackets;
        long j13 = entry.operations;
        if (entry.isNegative()) {
            throw new IllegalArgumentException("tried recording negative data");
        }
        if (entry.isEmpty()) {
            return;
        }
        ensureBuckets(j, j2);
        long j14 = j2 - j;
        int indexAfter = getIndexAfter(j2);
        while (indexAfter >= 0) {
            long j15 = this.bucketStart[indexAfter];
            long j16 = j15 + this.bucketDuration;
            if (j16 < j) {
                break;
            }
            if (j15 > j2) {
                j8 = j12;
                j7 = j11;
                j6 = j10;
                j5 = j9;
                j4 = j13;
                j3 = j14;
            } else {
                long min = Math.min(j16, j2) - Math.max(j15, j);
                j3 = j14;
                j4 = j13;
                j5 = j9;
                j6 = j10;
                j7 = j11;
                j8 = j12;
                if (min > 0) {
                    long j17 = (j9 * min) / j14;
                    long j18 = (j10 * min) / j14;
                    long j19 = (j11 * min) / j14;
                    long j20 = (j12 * min) / j14;
                    long j21 = (j13 * min) / j14;
                    addLong(this.activeTime, indexAfter, min);
                    addLong(this.rxBytes, indexAfter, j17);
                    j5 = j9 - j17;
                    addLong(this.rxPackets, indexAfter, j18);
                    j6 = j10 - j18;
                    addLong(this.txBytes, indexAfter, j19);
                    j7 = j11 - j19;
                    addLong(this.txPackets, indexAfter, j20);
                    j8 = j12 - j20;
                    addLong(this.operations, indexAfter, j21);
                    j4 = j13 - j21;
                    j3 = j14 - min;
                }
            }
            indexAfter--;
            j14 = j3;
            j13 = j4;
            j9 = j5;
            j10 = j6;
            j11 = j7;
            j12 = j8;
        }
        this.totalBytes += entry.rxBytes + entry.txBytes;
    }

    public void recordEntireHistory(NetworkStatsHistory networkStatsHistory) {
        recordHistory(networkStatsHistory, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public void recordHistory(NetworkStatsHistory networkStatsHistory, long j, long j2) {
        NetworkStats.Entry entry = new NetworkStats.Entry(NetworkStats.IFACE_ALL, -1, 0, 0, 0L, 0L, 0L, 0L, 0L);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= networkStatsHistory.bucketCount) {
                return;
            }
            long j3 = networkStatsHistory.bucketStart[i2];
            long j4 = j3 + networkStatsHistory.bucketDuration;
            if (j3 >= j && j4 <= j2) {
                entry.rxBytes = getLong(networkStatsHistory.rxBytes, i2, 0L);
                entry.rxPackets = getLong(networkStatsHistory.rxPackets, i2, 0L);
                entry.txBytes = getLong(networkStatsHistory.txBytes, i2, 0L);
                entry.txPackets = getLong(networkStatsHistory.txPackets, i2, 0L);
                entry.operations = getLong(networkStatsHistory.operations, i2, 0L);
                recordData(j3, j4, entry);
            }
            i = i2 + 1;
        }
    }

    @Deprecated
    public void removeBucketsBefore(long j) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.bucketCount || this.bucketStart[i] + this.bucketDuration > j) {
                break;
            }
            i2 = i + 1;
        }
        if (i > 0) {
            int length = this.bucketStart.length;
            this.bucketStart = Arrays.copyOfRange(this.bucketStart, i, length);
            if (this.activeTime != null) {
                this.activeTime = Arrays.copyOfRange(this.activeTime, i, length);
            }
            if (this.rxBytes != null) {
                this.rxBytes = Arrays.copyOfRange(this.rxBytes, i, length);
            }
            if (this.rxPackets != null) {
                this.rxPackets = Arrays.copyOfRange(this.rxPackets, i, length);
            }
            if (this.txBytes != null) {
                this.txBytes = Arrays.copyOfRange(this.txBytes, i, length);
            }
            if (this.txPackets != null) {
                this.txPackets = Arrays.copyOfRange(this.txPackets, i, length);
            }
            if (this.operations != null) {
                this.operations = Arrays.copyOfRange(this.operations, i, length);
            }
            this.bucketCount -= i;
        }
    }

    public int size() {
        return this.bucketCount;
    }

    public String toString() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        dump(new IndentingPrintWriter(charArrayWriter, "  "), false);
        return charArrayWriter.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.bucketDuration);
        ParcelUtils.writeLongArray(parcel, this.bucketStart, this.bucketCount);
        ParcelUtils.writeLongArray(parcel, this.activeTime, this.bucketCount);
        ParcelUtils.writeLongArray(parcel, this.rxBytes, this.bucketCount);
        ParcelUtils.writeLongArray(parcel, this.rxPackets, this.bucketCount);
        ParcelUtils.writeLongArray(parcel, this.txBytes, this.bucketCount);
        ParcelUtils.writeLongArray(parcel, this.txPackets, this.bucketCount);
        ParcelUtils.writeLongArray(parcel, this.operations, this.bucketCount);
        parcel.writeLong(this.totalBytes);
    }

    public void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(3);
        dataOutputStream.writeLong(this.bucketDuration);
        DataStreamUtils.writeVarLongArray(dataOutputStream, this.bucketStart, this.bucketCount);
        DataStreamUtils.writeVarLongArray(dataOutputStream, this.activeTime, this.bucketCount);
        DataStreamUtils.writeVarLongArray(dataOutputStream, this.rxBytes, this.bucketCount);
        DataStreamUtils.writeVarLongArray(dataOutputStream, this.rxPackets, this.bucketCount);
        DataStreamUtils.writeVarLongArray(dataOutputStream, this.txBytes, this.bucketCount);
        DataStreamUtils.writeVarLongArray(dataOutputStream, this.txPackets, this.bucketCount);
        DataStreamUtils.writeVarLongArray(dataOutputStream, this.operations, this.bucketCount);
    }
}
