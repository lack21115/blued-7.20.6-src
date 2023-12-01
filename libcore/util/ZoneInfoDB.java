package libcore.util;

import android.system.ErrnoException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import libcore.io.BufferIterator;
import libcore.io.MemoryMappedFile;

/* loaded from: source-2895416-dex2jar.jar:libcore/util/ZoneInfoDB.class */
public final class ZoneInfoDB {
    private static final TzData DATA = null;

    /* loaded from: source-2895416-dex2jar.jar:libcore/util/ZoneInfoDB$TzData.class */
    public static class TzData {
        private static final int CACHE_SIZE = 1;
        private int[] byteOffsets;
        private final BasicLruCache<String, ZoneInfo> cache = new BasicLruCache<String, ZoneInfo>(1) { // from class: libcore.util.ZoneInfoDB.TzData.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // libcore.util.BasicLruCache
            public ZoneInfo create(String str) {
                int binarySearch = Arrays.binarySearch(TzData.this.ids, str);
                if (binarySearch < 0) {
                    return null;
                }
                BufferIterator bigEndianIterator = TzData.this.mappedFile.bigEndianIterator();
                bigEndianIterator.skip(TzData.this.byteOffsets[binarySearch]);
                return ZoneInfo.makeTimeZone(str, bigEndianIterator);
            }
        };
        private String[] ids;
        private MemoryMappedFile mappedFile;
        private int[] rawUtcOffsetsCache;
        private String version;
        private String zoneTab;

        public TzData(String... strArr) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    System.logE("Couldn't find any tzdata!");
                    this.version = "missing";
                    this.zoneTab = "# Emergency fallback data.\n";
                    this.ids = new String[]{"GMT"};
                    int[] iArr = new int[1];
                    this.rawUtcOffsetsCache = iArr;
                    this.byteOffsets = iArr;
                    return;
                } else if (loadData(strArr[i2])) {
                    return;
                } else {
                    i = i2 + 1;
                }
            }
        }

        private int[] getRawUtcOffsets() {
            int[] iArr;
            synchronized (this) {
                if (this.rawUtcOffsetsCache != null) {
                    iArr = this.rawUtcOffsetsCache;
                } else {
                    this.rawUtcOffsetsCache = new int[this.ids.length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.ids.length) {
                            break;
                        }
                        this.rawUtcOffsetsCache[i2] = this.cache.get(this.ids[i2]).getRawOffset();
                        i = i2 + 1;
                    }
                    iArr = this.rawUtcOffsetsCache;
                }
            }
            return iArr;
        }

        private boolean loadData(String str) {
            try {
                this.mappedFile = MemoryMappedFile.mmapRO(str);
                try {
                    readHeader();
                    return true;
                } catch (Exception e) {
                    System.logE("tzdata file \"" + str + "\" was present but invalid!", e);
                    return false;
                }
            } catch (ErrnoException e2) {
                return false;
            }
        }

        private void readHeader() {
            BufferIterator bigEndianIterator = this.mappedFile.bigEndianIterator();
            byte[] bArr = new byte[12];
            bigEndianIterator.readByteArray(bArr, 0, bArr.length);
            if (!new String(bArr, 0, 6, StandardCharsets.US_ASCII).equals("tzdata") || bArr[11] != 0) {
                throw new RuntimeException("bad tzdata magic: " + Arrays.toString(bArr));
            }
            this.version = new String(bArr, 6, 5, StandardCharsets.US_ASCII);
            int readInt = bigEndianIterator.readInt();
            int readInt2 = bigEndianIterator.readInt();
            int readInt3 = bigEndianIterator.readInt();
            readIndex(bigEndianIterator, readInt, readInt2);
            readZoneTab(bigEndianIterator, readInt3, ((int) this.mappedFile.size()) - readInt3);
        }

        private void readIndex(BufferIterator bufferIterator, int i, int i2) {
            bufferIterator.seek(i);
            byte[] bArr = new byte[40];
            int i3 = (i2 - i) / 52;
            char[] cArr = new char[i3 * 40];
            int[] iArr = new int[i3];
            int i4 = 0;
            this.byteOffsets = new int[i3];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < i3) {
                    bufferIterator.readByteArray(bArr, 0, bArr.length);
                    this.byteOffsets[i6] = bufferIterator.readInt();
                    int[] iArr2 = this.byteOffsets;
                    iArr2[i6] = iArr2[i6] + i2;
                    if (bufferIterator.readInt() < 44) {
                        throw new AssertionError("length in index file < sizeof(tzhead)");
                    }
                    bufferIterator.skip(4);
                    int length = bArr.length;
                    int i7 = 0;
                    while (i7 < length && bArr[i7] != 0) {
                        cArr[i4] = (char) (bArr[i7] & 255);
                        i7++;
                        i4++;
                    }
                    iArr[i6] = i4;
                    i5 = i6 + 1;
                } else {
                    String str = new String(cArr, 0, i4);
                    this.ids = new String[i3];
                    int i8 = 0;
                    while (true) {
                        int i9 = i8;
                        if (i9 >= i3) {
                            return;
                        }
                        this.ids[i9] = str.substring(i9 == 0 ? 0 : iArr[i9 - 1], iArr[i9]);
                        i8 = i9 + 1;
                    }
                }
            }
        }

        private void readZoneTab(BufferIterator bufferIterator, int i, int i2) {
            byte[] bArr = new byte[i2];
            bufferIterator.seek(i);
            bufferIterator.readByteArray(bArr, 0, bArr.length);
            this.zoneTab = new String(bArr, 0, bArr.length, StandardCharsets.US_ASCII);
        }

        public String[] getAvailableIDs() {
            return (String[]) this.ids.clone();
        }

        public String[] getAvailableIDs(int i) {
            ArrayList arrayList = new ArrayList();
            int[] rawUtcOffsets = getRawUtcOffsets();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= rawUtcOffsets.length) {
                    return (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
                if (rawUtcOffsets[i3] == i) {
                    arrayList.add(this.ids[i3]);
                }
                i2 = i3 + 1;
            }
        }

        public String getVersion() {
            return this.version;
        }

        public String getZoneTab() {
            return this.zoneTab;
        }

        public ZoneInfo makeTimeZone(String str) throws IOException {
            ZoneInfo zoneInfo = this.cache.get(str);
            if (zoneInfo == null) {
                return null;
            }
            return (ZoneInfo) zoneInfo.clone();
        }
    }

    static {
        String[] strArr = new String[1];
        new StringBuilder();
        System.getenv("ANDROID_ROOT");
        throw new VerifyError("bad dex opcode");
    }

    private ZoneInfoDB() {
    }

    public static TzData getInstance() {
        return DATA;
    }
}
