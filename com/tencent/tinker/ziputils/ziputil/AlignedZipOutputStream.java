package com.tencent.tinker.ziputils.ziputil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/ziputils/ziputil/AlignedZipOutputStream.class */
public class AlignedZipOutputStream extends DeflaterOutputStream {
    private static final long CENSIG = 33639248;
    public static final int DEFLATED = 8;
    private static final long ENDSIG = 101010256;
    private static final int EXTHDR = 16;
    private static final long EXTSIG = 134695760;
    private static final int GPBF_DATA_DESCRIPTOR_FLAG = 8;
    private static final int GPBF_UTF8_FLAG = 2048;
    private static final int LOCHDR = 30;
    private static final long LOCSIG = 67324752;
    private static final int MOD_DATE_CONST = 33;
    public static final int STORED = 0;
    private static final int TIME_CONST = 0;
    private static final int ZIPLocalHeaderVersionNeeded = 20;
    private final int alignBytes;
    private ByteArrayOutputStream cDir;
    private boolean closed;
    private byte[] commentBytes;
    private int compressionLevel;
    private final CRC32 crc;
    private long crcDataSize;
    private ZipEntry currentEntry;
    private int defaultCompressionMethod;
    private final HashSet<String> entries;
    private boolean finished;
    private byte[] nameBytes;
    private int nameLength;
    private int offset;
    private int padding;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final byte[] ONE_ELEM_BYTE_ARRAY = {0};

    public AlignedZipOutputStream(OutputStream outputStream) {
        this(outputStream, 4);
    }

    public AlignedZipOutputStream(OutputStream outputStream, int i) {
        super(outputStream, new Deflater(-1, true));
        this.commentBytes = EMPTY_BYTE_ARRAY;
        this.entries = new HashSet<>();
        this.defaultCompressionMethod = 8;
        this.compressionLevel = -1;
        this.cDir = new ByteArrayOutputStream();
        this.crc = new CRC32();
        this.crcDataSize = 0L;
        this.offset = 0;
        this.finished = false;
        this.closed = false;
        this.padding = 0;
        this.alignBytes = i;
    }

    private void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException("length=" + i + "; regionStart=" + i2 + "; regionLength=" + i3);
        }
    }

    private void checkOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream is closed");
        }
    }

    private int getPaddingByteCount(ZipEntry zipEntry, int i) {
        int i2;
        if (zipEntry.getMethod() != 0 || (i2 = this.alignBytes) == 0) {
            return 0;
        }
        return (i2 - (i % i2)) % i2;
    }

    private void makePaddingToStream(OutputStream outputStream, int i) throws IOException {
        if (i <= 0) {
            return;
        }
        for (int i2 = i; i2 > 0; i2--) {
            outputStream.write(0);
        }
    }

    private long writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    private int writeShort(OutputStream outputStream, int i) throws IOException {
        if (i <= 65535) {
            outputStream.write(i & 255);
            outputStream.write((i >> 8) & 255);
            return i;
        }
        throw new IllegalArgumentException("value " + i + " is too large for type 'short'.");
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        finish();
        this.def.end();
        this.out.close();
        this.out = null;
        this.closed = true;
    }

    public void closeEntry() throws IOException {
        int writeLong;
        checkOpen();
        ZipEntry zipEntry = this.currentEntry;
        if (zipEntry == null) {
            return;
        }
        if (zipEntry.getMethod() == 8) {
            super.finish();
        }
        if (this.currentEntry.getMethod() == 0) {
            if (this.crc.getValue() != this.currentEntry.getCrc()) {
                throw new ZipException("CRC mismatch");
            }
            if (this.currentEntry.getSize() != this.crcDataSize) {
                throw new ZipException("Size mismatch");
            }
        }
        int i = 30;
        if (this.currentEntry.getMethod() != 0) {
            i = 46;
            writeLong(this.out, 134695760L);
            this.currentEntry.setCrc(this.crc.getValue());
            writeLong(this.out, this.currentEntry.getCrc());
            this.currentEntry.setCompressedSize(this.def.getTotalOut());
            writeLong(this.out, this.currentEntry.getCompressedSize());
            this.currentEntry.setSize(this.def.getTotalIn());
            writeLong(this.out, this.currentEntry.getSize());
        }
        int i2 = this.currentEntry.getMethod() == 0 ? 0 : 8;
        writeLong(this.cDir, 33639248L);
        writeShort(this.cDir, 20);
        writeShort(this.cDir, 20);
        writeShort(this.cDir, i2 | 2048);
        writeShort(this.cDir, this.currentEntry.getMethod());
        writeShort(this.cDir, 0);
        writeShort(this.cDir, 33);
        writeLong(this.cDir, this.crc.getValue());
        if (this.currentEntry.getMethod() == 8) {
            writeLong = (int) (i + writeLong(this.cDir, this.def.getTotalOut()));
            writeLong(this.cDir, this.def.getTotalIn());
        } else {
            writeLong = (int) (i + writeLong(this.cDir, this.crcDataSize));
            writeLong(this.cDir, this.crcDataSize);
        }
        int writeShort = writeLong + writeShort(this.cDir, this.nameLength);
        if (this.currentEntry.getExtra() != null) {
            writeShort += writeShort(this.cDir, this.currentEntry.getExtra().length);
        } else {
            writeShort(this.cDir, 0);
        }
        String comment = this.currentEntry.getComment();
        byte[] bArr = EMPTY_BYTE_ARRAY;
        if (comment != null) {
            bArr = comment.getBytes(Charset.forName("UTF-8"));
        }
        writeShort(this.cDir, bArr.length);
        writeShort(this.cDir, 0);
        writeShort(this.cDir, 0);
        writeLong(this.cDir, 0L);
        writeLong(this.cDir, this.offset);
        this.cDir.write(this.nameBytes);
        this.nameBytes = null;
        if (this.currentEntry.getExtra() != null) {
            this.cDir.write(this.currentEntry.getExtra());
        }
        this.offset += writeShort + this.padding;
        this.padding = 0;
        if (bArr.length > 0) {
            this.cDir.write(bArr);
        }
        this.currentEntry = null;
        this.crc.reset();
        this.crcDataSize = 0L;
        this.def.reset();
    }

    @Override // java.util.zip.DeflaterOutputStream
    public void finish() throws IOException {
        checkOpen();
        if (this.finished) {
            return;
        }
        if (this.entries.isEmpty()) {
            throw new ZipException("No entries");
        }
        if (this.currentEntry != null) {
            closeEntry();
        }
        int size = this.cDir.size();
        writeLong(this.cDir, 101010256L);
        writeShort(this.cDir, 0);
        writeShort(this.cDir, 0);
        writeShort(this.cDir, this.entries.size());
        writeShort(this.cDir, this.entries.size());
        writeLong(this.cDir, size);
        writeLong(this.cDir, this.offset + this.padding);
        writeShort(this.cDir, this.commentBytes.length);
        byte[] bArr = this.commentBytes;
        if (bArr.length > 0) {
            this.cDir.write(bArr);
        }
        this.cDir.writeTo(this.out);
        this.cDir = null;
        this.finished = true;
    }

    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        if (this.currentEntry != null) {
            closeEntry();
        }
        int method = zipEntry.getMethod();
        int i = method;
        if (method == -1) {
            i = this.defaultCompressionMethod;
        }
        if (i == 0) {
            if (zipEntry.getCompressedSize() == -1) {
                zipEntry.setCompressedSize(zipEntry.getSize());
            } else if (zipEntry.getSize() == -1) {
                zipEntry.setSize(zipEntry.getCompressedSize());
            }
            if (zipEntry.getCrc() == -1) {
                throw new ZipException("STORED entry missing CRC");
            }
            if (zipEntry.getSize() == -1) {
                throw new ZipException("STORED entry missing size");
            }
            if (zipEntry.getSize() != zipEntry.getCompressedSize()) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        checkOpen();
        if (this.entries.contains(zipEntry.getName())) {
            throw new ZipException("Entry already exists: " + zipEntry.getName());
        } else if (this.entries.size() == 65535) {
            throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
        } else {
            byte[] bytes = zipEntry.getName().getBytes(Charset.forName("UTF-8"));
            this.nameBytes = bytes;
            int length = bytes.length;
            this.nameLength = length;
            if (length > 65535) {
                throw new IllegalArgumentException("Name too long: " + this.nameLength + " UTF-8 bytes");
            }
            this.def.setLevel(this.compressionLevel);
            zipEntry.setMethod(i);
            this.currentEntry = zipEntry;
            this.entries.add(zipEntry.getName());
            int i2 = i == 0 ? 0 : 8;
            writeLong(this.out, 67324752L);
            writeShort(this.out, 20);
            writeShort(this.out, i2 | 2048);
            writeShort(this.out, i);
            if (this.currentEntry.getTime() == -1) {
                this.currentEntry.setTime(System.currentTimeMillis());
            }
            writeShort(this.out, 0);
            writeShort(this.out, 33);
            if (i == 0) {
                writeLong(this.out, this.currentEntry.getCrc());
                writeLong(this.out, this.currentEntry.getSize());
                writeLong(this.out, this.currentEntry.getSize());
            } else {
                writeLong(this.out, 0L);
                writeLong(this.out, 0L);
                writeLong(this.out, 0L);
            }
            writeShort(this.out, this.nameLength);
            int i3 = this.offset;
            int i4 = this.nameLength;
            int i5 = 0;
            if (this.currentEntry.getExtra() != null) {
                i5 = this.currentEntry.getExtra().length;
            }
            this.padding = getPaddingByteCount(this.currentEntry, i3 + 30 + i4 + i5);
            if (this.currentEntry.getExtra() != null) {
                writeShort(this.out, this.currentEntry.getExtra().length + this.padding);
            } else {
                writeShort(this.out, this.padding);
            }
            this.out.write(this.nameBytes);
            if (this.currentEntry.getExtra() != null) {
                this.out.write(this.currentEntry.getExtra());
            }
            makePaddingToStream(this.out, this.padding);
        }
    }

    public void setComment(String str) {
        if (str == null) {
            this.commentBytes = null;
            return;
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes.length <= 65535) {
            this.commentBytes = bytes;
            return;
        }
        throw new IllegalArgumentException("Comment too long: " + bytes.length + " bytes");
    }

    public void setLevel(int i) {
        if (i >= -1 && i <= 9) {
            this.compressionLevel = i;
            return;
        }
        throw new IllegalArgumentException("Bad level: " + i);
    }

    public void setMethod(int i) {
        if (i == 0 || i == 8) {
            this.defaultCompressionMethod = i;
            return;
        }
        throw new IllegalArgumentException("Bad method: " + i);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = ONE_ELEM_BYTE_ARRAY;
        bArr[0] = (byte) (i & 255);
        write(bArr, 0, 1);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkOffsetAndCount(bArr.length, i, i2);
        ZipEntry zipEntry = this.currentEntry;
        if (zipEntry == null) {
            throw new ZipException("No active entry");
        }
        if (zipEntry.getMethod() == 0) {
            this.out.write(bArr, i, i2);
        } else {
            super.write(bArr, i, i2);
        }
        this.crc.update(bArr, i, i2);
        this.crcDataSize += i2;
    }
}
