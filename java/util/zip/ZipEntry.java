package java.util.zip;

import android.widget.ExpandableListView;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import libcore.io.BufferIterator;
import libcore.io.HeapBufferIterator;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/ZipEntry.class */
public class ZipEntry implements ZipConstants, Cloneable {
    public static final int DEFLATED = 8;
    public static final int STORED = 0;
    String comment;
    long compressedSize;
    int compressionMethod;
    long crc;
    long dataOffset;
    byte[] extra;
    long localHeaderRelOffset;
    int modDate;
    String name;
    int nameLength;
    long size;
    int time;

    public ZipEntry(String str) {
        this.crc = -1L;
        this.compressedSize = -1L;
        this.size = -1L;
        this.compressionMethod = -1;
        this.time = -1;
        this.modDate = -1;
        this.nameLength = -1;
        this.localHeaderRelOffset = -1L;
        this.dataOffset = -1L;
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        validateStringLength("Name", str);
        this.name = str;
    }

    ZipEntry(String str, String str2, long j, long j2, long j3, int i, int i2, int i3, byte[] bArr, int i4, long j4, long j5) {
        this.crc = -1L;
        this.compressedSize = -1L;
        this.size = -1L;
        this.compressionMethod = -1;
        this.time = -1;
        this.modDate = -1;
        this.nameLength = -1;
        this.localHeaderRelOffset = -1L;
        this.dataOffset = -1L;
        this.name = str;
        this.comment = str2;
        this.crc = j;
        this.compressedSize = j2;
        this.size = j3;
        this.compressionMethod = i;
        this.time = i2;
        this.modDate = i3;
        this.extra = bArr;
        this.nameLength = i4;
        this.localHeaderRelOffset = j4;
        this.dataOffset = j5;
    }

    public ZipEntry(ZipEntry zipEntry) {
        this.crc = -1L;
        this.compressedSize = -1L;
        this.size = -1L;
        this.compressionMethod = -1;
        this.time = -1;
        this.modDate = -1;
        this.nameLength = -1;
        this.localHeaderRelOffset = -1L;
        this.dataOffset = -1L;
        this.name = zipEntry.name;
        this.comment = zipEntry.comment;
        this.time = zipEntry.time;
        this.size = zipEntry.size;
        this.compressedSize = zipEntry.compressedSize;
        this.crc = zipEntry.crc;
        this.compressionMethod = zipEntry.compressionMethod;
        this.modDate = zipEntry.modDate;
        this.extra = zipEntry.extra;
        this.nameLength = zipEntry.nameLength;
        this.localHeaderRelOffset = zipEntry.localHeaderRelOffset;
        this.dataOffset = zipEntry.dataOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZipEntry(byte[] bArr, InputStream inputStream, Charset charset) throws IOException {
        this.crc = -1L;
        this.compressedSize = -1L;
        this.size = -1L;
        this.compressionMethod = -1;
        this.time = -1;
        this.modDate = -1;
        this.nameLength = -1;
        this.localHeaderRelOffset = -1L;
        this.dataOffset = -1L;
        Streams.readFully(inputStream, bArr, 0, bArr.length);
        BufferIterator it = HeapBufferIterator.iterator(bArr, 0, bArr.length, ByteOrder.LITTLE_ENDIAN);
        int readInt = it.readInt();
        if (readInt != ZipConstants.CENSIG) {
            ZipFile.throwZipException("Central Directory Entry", readInt);
        }
        it.seek(8);
        int readShort = it.readShort() & 65535;
        if ((readShort & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: " + readShort);
        }
        Charset charset2 = (readShort & 2048) != 0 ? StandardCharsets.UTF_8 : charset;
        this.compressionMethod = it.readShort() & 65535;
        this.time = it.readShort() & 65535;
        this.modDate = it.readShort() & 65535;
        this.crc = it.readInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        this.compressedSize = it.readInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        this.size = it.readInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        this.nameLength = it.readShort() & 65535;
        int readShort2 = it.readShort() & 65535;
        int readShort3 = it.readShort() & 65535;
        it.seek(42);
        this.localHeaderRelOffset = it.readInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        byte[] bArr2 = new byte[this.nameLength];
        Streams.readFully(inputStream, bArr2, 0, bArr2.length);
        if (containsNulByte(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.name = new String(bArr2, 0, bArr2.length, charset2);
        if (readShort2 > 0) {
            this.extra = new byte[readShort2];
            Streams.readFully(inputStream, this.extra, 0, readShort2);
        }
        if (readShort3 > 0) {
            byte[] bArr3 = new byte[readShort3];
            Streams.readFully(inputStream, bArr3, 0, readShort3);
            this.comment = new String(bArr3, 0, bArr3.length, charset2);
        }
    }

    private static boolean containsNulByte(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (bArr[i2] == 0) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static void validateStringLength(String str, String str2) {
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > 65535) {
            throw new IllegalArgumentException(str + " too long: " + bytes.length);
        }
    }

    public Object clone() {
        try {
            ZipEntry zipEntry = (ZipEntry) super.clone();
            zipEntry.extra = this.extra != null ? (byte[]) this.extra.clone() : null;
            return zipEntry;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public String getComment() {
        return this.comment;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public long getCrc() {
        return this.crc;
    }

    public long getDataOffset() {
        return this.dataOffset;
    }

    public byte[] getExtra() {
        return this.extra;
    }

    public int getMethod() {
        return this.compressionMethod;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public long getTime() {
        if (this.time != -1) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(14, 0);
            gregorianCalendar.set(((this.modDate >> 9) & 127) + 1980, ((this.modDate >> 5) & 15) - 1, this.modDate & 31, (this.time >> 11) & 31, (this.time >> 5) & 63, (this.time & 31) << 1);
            return gregorianCalendar.getTime().getTime();
        }
        return -1L;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean isDirectory() {
        return this.name.charAt(this.name.length() - 1) == '/';
    }

    public void setComment(String str) {
        if (str == null) {
            this.comment = null;
            return;
        }
        validateStringLength("Comment", str);
        this.comment = str;
    }

    public void setCompressedSize(long j) {
        this.compressedSize = j;
    }

    public void setCrc(long j) {
        if (j < 0 || j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            throw new IllegalArgumentException("Bad CRC32: " + j);
        }
        this.crc = j;
    }

    public void setDataOffset(long j) {
        this.dataOffset = j;
    }

    public void setExtra(byte[] bArr) {
        if (bArr != null && bArr.length > 65535) {
            throw new IllegalArgumentException("Extra data too long: " + bArr.length);
        }
        this.extra = bArr;
    }

    public void setMethod(int i) {
        if (i != 0 && i != 8) {
            throw new IllegalArgumentException("Bad method: " + i);
        }
        this.compressionMethod = i;
    }

    public void setSize(long j) {
        if (j < 0 || j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            throw new IllegalArgumentException("Bad size: " + j);
        }
        this.size = j;
    }

    public void setTime(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date(j));
        if (gregorianCalendar.get(1) < 1980) {
            this.modDate = 33;
            this.time = 0;
            return;
        }
        this.modDate = gregorianCalendar.get(5);
        this.modDate = ((gregorianCalendar.get(2) + 1) << 5) | this.modDate;
        this.modDate = ((gregorianCalendar.get(1) - 1980) << 9) | this.modDate;
        this.time = gregorianCalendar.get(13) >> 1;
        this.time = (gregorianCalendar.get(12) << 5) | this.time;
        this.time = (gregorianCalendar.get(11) << 11) | this.time;
    }

    public String toString() {
        return this.name;
    }
}
