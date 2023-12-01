package java.util.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/ZipOutputStream.class */
public class ZipOutputStream extends DeflaterOutputStream implements ZipConstants {
    public static final int DEFLATED = 8;
    public static final int STORED = 0;
    private static final int ZIP_VERSION_2_0 = 20;
    private ByteArrayOutputStream cDir;
    private byte[] commentBytes;
    private int compressionLevel;
    private final CRC32 crc;
    private int curOffset;
    private ZipEntry currentEntry;
    private int defaultCompressionMethod;
    private final HashSet<String> entries;
    private byte[] entryCommentBytes;
    private byte[] nameBytes;
    private int offset;

    public ZipOutputStream(OutputStream outputStream) {
        super(outputStream, new Deflater(-1, true));
        this.commentBytes = EmptyArray.BYTE;
        this.entries = new HashSet<>();
        this.defaultCompressionMethod = 8;
        this.compressionLevel = -1;
        this.cDir = new ByteArrayOutputStream();
        this.crc = new CRC32();
        this.offset = 0;
        this.curOffset = 0;
    }

    private void checkOpen() throws IOException {
        if (this.cDir == null) {
            throw new IOException("Stream is closed");
        }
    }

    private void checkSizeIsWithinShort(String str, byte[] bArr) {
        if (bArr.length > 65535) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
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
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.out != null) {
            finish();
            this.def.end();
            this.out.close();
            this.out = null;
        }
    }

    public void closeEntry() throws IOException {
        checkOpen();
        if (this.currentEntry == null) {
            return;
        }
        if (this.currentEntry.getMethod() == 8) {
            super.finish();
        }
        if (this.currentEntry.getMethod() == 0) {
            if (this.crc.getValue() != this.currentEntry.crc) {
                throw new ZipException("CRC mismatch");
            }
            if (this.currentEntry.size != this.crc.tbytes) {
                throw new ZipException("Size mismatch");
            }
        }
        this.curOffset = 30;
        if (this.currentEntry.getMethod() != 0) {
            this.curOffset += 16;
            writeLong(this.out, ZipConstants.EXTSIG);
            OutputStream outputStream = this.out;
            ZipEntry zipEntry = this.currentEntry;
            long value = this.crc.getValue();
            zipEntry.crc = value;
            writeLong(outputStream, value);
            OutputStream outputStream2 = this.out;
            ZipEntry zipEntry2 = this.currentEntry;
            long totalOut = this.def.getTotalOut();
            zipEntry2.compressedSize = totalOut;
            writeLong(outputStream2, totalOut);
            OutputStream outputStream3 = this.out;
            ZipEntry zipEntry3 = this.currentEntry;
            long totalIn = this.def.getTotalIn();
            zipEntry3.size = totalIn;
            writeLong(outputStream3, totalIn);
        }
        int i = this.currentEntry.getMethod() == 0 ? 0 : 8;
        writeLong(this.cDir, ZipConstants.CENSIG);
        writeShort(this.cDir, 20);
        writeShort(this.cDir, 20);
        writeShort(this.cDir, i | 2048);
        writeShort(this.cDir, this.currentEntry.getMethod());
        writeShort(this.cDir, this.currentEntry.time);
        writeShort(this.cDir, this.currentEntry.modDate);
        writeLong(this.cDir, this.crc.getValue());
        if (this.currentEntry.getMethod() == 8) {
            this.curOffset = (int) (this.curOffset + writeLong(this.cDir, this.def.getTotalOut()));
            writeLong(this.cDir, this.def.getTotalIn());
        } else {
            this.curOffset = (int) (this.curOffset + writeLong(this.cDir, this.crc.tbytes));
            writeLong(this.cDir, this.crc.tbytes);
        }
        this.curOffset += writeShort(this.cDir, this.nameBytes.length);
        if (this.currentEntry.extra != null) {
            this.curOffset += writeShort(this.cDir, this.currentEntry.extra.length);
        } else {
            writeShort(this.cDir, 0);
        }
        writeShort(this.cDir, this.entryCommentBytes.length);
        writeShort(this.cDir, 0);
        writeShort(this.cDir, 0);
        writeLong(this.cDir, 0L);
        writeLong(this.cDir, this.offset);
        this.cDir.write(this.nameBytes);
        this.nameBytes = null;
        if (this.currentEntry.extra != null) {
            this.cDir.write(this.currentEntry.extra);
        }
        this.offset += this.curOffset;
        if (this.entryCommentBytes.length > 0) {
            this.cDir.write(this.entryCommentBytes);
            this.entryCommentBytes = EmptyArray.BYTE;
        }
        this.currentEntry = null;
        this.crc.reset();
        this.def.reset();
        this.done = false;
    }

    @Override // java.util.zip.DeflaterOutputStream
    public void finish() throws IOException {
        if (this.out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.cDir == null) {
            return;
        }
        if (this.entries.isEmpty()) {
            throw new ZipException("No entries");
        }
        if (this.currentEntry != null) {
            closeEntry();
        }
        int size = this.cDir.size();
        writeLong(this.cDir, ZipConstants.ENDSIG);
        writeShort(this.cDir, 0);
        writeShort(this.cDir, 0);
        writeShort(this.cDir, this.entries.size());
        writeShort(this.cDir, this.entries.size());
        writeLong(this.cDir, size);
        writeLong(this.cDir, this.offset);
        writeShort(this.cDir, this.commentBytes.length);
        if (this.commentBytes.length > 0) {
            this.cDir.write(this.commentBytes);
        }
        this.cDir.writeTo(this.out);
        this.cDir = null;
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
            if (zipEntry.size != zipEntry.compressedSize) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        checkOpen();
        if (this.entries.contains(zipEntry.name)) {
            throw new ZipException("Entry already exists: " + zipEntry.name);
        }
        if (this.entries.size() == 65535) {
            throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
        }
        this.nameBytes = zipEntry.name.getBytes(StandardCharsets.UTF_8);
        checkSizeIsWithinShort("Name", this.nameBytes);
        this.entryCommentBytes = EmptyArray.BYTE;
        if (zipEntry.comment != null) {
            this.entryCommentBytes = zipEntry.comment.getBytes(StandardCharsets.UTF_8);
            checkSizeIsWithinShort("Comment", this.entryCommentBytes);
        }
        this.def.setLevel(this.compressionLevel);
        zipEntry.setMethod(i);
        this.currentEntry = zipEntry;
        this.entries.add(this.currentEntry.name);
        int i2 = i == 0 ? 0 : 8;
        writeLong(this.out, ZipConstants.LOCSIG);
        writeShort(this.out, 20);
        writeShort(this.out, i2 | 2048);
        writeShort(this.out, i);
        if (this.currentEntry.getTime() == -1) {
            this.currentEntry.setTime(System.currentTimeMillis());
        }
        writeShort(this.out, this.currentEntry.time);
        writeShort(this.out, this.currentEntry.modDate);
        if (i == 0) {
            writeLong(this.out, this.currentEntry.crc);
            writeLong(this.out, this.currentEntry.size);
            writeLong(this.out, this.currentEntry.size);
        } else {
            writeLong(this.out, 0L);
            writeLong(this.out, 0L);
            writeLong(this.out, 0L);
        }
        writeShort(this.out, this.nameBytes.length);
        if (this.currentEntry.extra != null) {
            writeShort(this.out, this.currentEntry.extra.length);
        } else {
            writeShort(this.out, 0);
        }
        this.out.write(this.nameBytes);
        if (this.currentEntry.extra != null) {
            this.out.write(this.currentEntry.extra);
        }
    }

    public void setComment(String str) {
        if (str == null) {
            this.commentBytes = EmptyArray.BYTE;
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        checkSizeIsWithinShort("Comment", bytes);
        this.commentBytes = bytes;
    }

    public void setLevel(int i) {
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException("Bad level: " + i);
        }
        this.compressionLevel = i;
    }

    public void setMethod(int i) {
        if (i != 0 && i != 8) {
            throw new IllegalArgumentException("Bad method: " + i);
        }
        this.defaultCompressionMethod = i;
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (this.currentEntry == null) {
            throw new ZipException("No active entry");
        }
        if (this.currentEntry.getMethod() == 0) {
            this.out.write(bArr, i, i2);
        } else {
            super.write(bArr, i, i2);
        }
        this.crc.update(bArr, i, i2);
    }
}
