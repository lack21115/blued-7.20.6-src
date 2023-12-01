package java.util.zip;

import android.widget.ExpandableListView;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import java.util.Arrays;
import libcore.io.Memory;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/ZipInputStream.class */
public class ZipInputStream extends InflaterInputStream implements ZipConstants {
    private static final int ZIPLocalHeaderVersionNeeded = 20;
    private final CRC32 crc;
    private ZipEntry currentEntry;
    private boolean entriesEnd;
    private int entryIn;
    private boolean hasDD;
    private final byte[] hdrBuf;
    private int inRead;
    private int lastRead;
    private byte[] stringBytesBuf;
    private char[] stringCharBuf;

    public ZipInputStream(InputStream inputStream) {
        super(new PushbackInputStream(inputStream, 512), new Inflater(true));
        this.entriesEnd = false;
        this.hasDD = false;
        this.entryIn = 0;
        this.lastRead = 0;
        this.hdrBuf = new byte[26];
        this.crc = new CRC32();
        this.stringBytesBuf = new byte[256];
        this.stringCharBuf = new char[256];
        if (inputStream == null) {
            throw new NullPointerException("stream == null");
        }
    }

    private void checkClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Stream is closed");
        }
    }

    private int peekShort(int i) {
        return Memory.peekShort(this.hdrBuf, i, ByteOrder.LITTLE_ENDIAN) & 65535;
    }

    private void readAndVerifyDataDescriptor(int i, int i2) throws IOException {
        if (this.hasDD) {
            Streams.readFully(this.in, this.hdrBuf, 0, 16);
            int peekInt = Memory.peekInt(this.hdrBuf, 0, ByteOrder.LITTLE_ENDIAN);
            if (peekInt != 134695760) {
                throw new ZipException(String.format("unknown format (EXTSIG=%x)", Integer.valueOf(peekInt)));
            }
            this.currentEntry.crc = Memory.peekInt(this.hdrBuf, 4, ByteOrder.LITTLE_ENDIAN) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
            this.currentEntry.compressedSize = Memory.peekInt(this.hdrBuf, 8, ByteOrder.LITTLE_ENDIAN) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
            this.currentEntry.size = Memory.peekInt(this.hdrBuf, 12, ByteOrder.LITTLE_ENDIAN) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        }
        if (this.currentEntry.crc != this.crc.getValue()) {
            throw new ZipException("CRC mismatch");
        }
        if (this.currentEntry.compressedSize != i || this.currentEntry.size != i2) {
            throw new ZipException("Size mismatch");
        }
    }

    private String readString(int i) throws IOException {
        if (i > this.stringBytesBuf.length) {
            this.stringBytesBuf = new byte[i];
        }
        Streams.readFully(this.in, this.stringBytesBuf, 0, i);
        if (i > this.stringCharBuf.length) {
            this.stringCharBuf = new char[i];
        }
        return ModifiedUtf8.decode(this.stringBytesBuf, this.stringCharBuf, 0, i);
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        checkClosed();
        return (this.currentEntry == null || ((long) this.inRead) < this.currentEntry.size) ? 1 : 0;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        closeEntry();
        super.close();
    }

    public void closeEntry() throws IOException {
        int i;
        int i2;
        Exception exc;
        checkClosed();
        if (this.currentEntry == null) {
            return;
        }
        Exception e = null;
        try {
            Streams.skipAll(this);
        } catch (Exception e2) {
            e = e2;
        }
        if (this.currentEntry.compressionMethod == 8) {
            i = this.inf.getTotalIn();
            i2 = this.inf.getTotalOut();
        } else {
            i = this.inRead;
            i2 = this.inRead;
        }
        int i3 = this.entryIn - i;
        if (i3 != 0) {
            ((PushbackInputStream) this.in).unread(this.buf, this.len - i3, i3);
        }
        try {
            readAndVerifyDataDescriptor(i, i2);
            exc = e;
        } catch (Exception e3) {
            exc = e;
            if (e == null) {
                exc = e3;
            }
        }
        this.inf.reset();
        this.len = 0;
        this.entryIn = 0;
        this.inRead = 0;
        this.lastRead = 0;
        this.crc.reset();
        this.currentEntry = null;
        if (exc != null) {
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof RuntimeException) {
                throw ((RuntimeException) exc);
            }
            AssertionError assertionError = new AssertionError();
            assertionError.initCause(exc);
            throw assertionError;
        }
    }

    protected ZipEntry createZipEntry(String str) {
        return new ZipEntry(str);
    }

    public ZipEntry getNextEntry() throws IOException {
        closeEntry();
        if (this.entriesEnd) {
            return null;
        }
        Streams.readFully(this.in, this.hdrBuf, 0, 4);
        int peekInt = Memory.peekInt(this.hdrBuf, 0, ByteOrder.LITTLE_ENDIAN);
        if (peekInt == ZipConstants.CENSIG) {
            this.entriesEnd = true;
            return null;
        } else if (peekInt != ZipConstants.LOCSIG) {
            return null;
        } else {
            Streams.readFully(this.in, this.hdrBuf, 0, 26);
            int peekShort = peekShort(0) & 255;
            if (peekShort > 20) {
                throw new ZipException("Cannot read local header version " + peekShort);
            }
            int peekShort2 = peekShort(2);
            if ((peekShort2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: " + peekShort2);
            }
            this.hasDD = (peekShort2 & 8) != 0;
            int peekShort3 = peekShort(6);
            int peekShort4 = peekShort(8);
            int peekShort5 = peekShort(4);
            long j = 0;
            long j2 = 0;
            long j3 = -1;
            if (!this.hasDD) {
                j = Memory.peekInt(this.hdrBuf, 10, ByteOrder.LITTLE_ENDIAN) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                j2 = Memory.peekInt(this.hdrBuf, 14, ByteOrder.LITTLE_ENDIAN) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                j3 = Memory.peekInt(this.hdrBuf, 18, ByteOrder.LITTLE_ENDIAN) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
            }
            int peekShort6 = peekShort(22);
            if (peekShort6 == 0) {
                throw new ZipException("Entry is not named");
            }
            int peekShort7 = peekShort(24);
            this.currentEntry = createZipEntry(readString(peekShort6));
            this.currentEntry.time = peekShort3;
            this.currentEntry.modDate = peekShort4;
            this.currentEntry.setMethod(peekShort5);
            if (j3 != -1) {
                this.currentEntry.setCrc(j);
                this.currentEntry.setSize(j3);
                this.currentEntry.setCompressedSize(j2);
            }
            if (peekShort7 > 0) {
                byte[] bArr = new byte[peekShort7];
                Streams.readFully(this.in, bArr, 0, peekShort7);
                this.currentEntry.setExtra(bArr);
            }
            return this.currentEntry;
        }
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        checkClosed();
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (this.inf.finished() || this.currentEntry == null) {
            return -1;
        }
        if (this.currentEntry.compressionMethod != 0) {
            if (this.inf.needsInput()) {
                fill();
                if (this.len > 0) {
                    this.entryIn += this.len;
                }
            }
            try {
                int inflate = this.inf.inflate(bArr, i, i2);
                if (inflate == 0 && this.inf.finished()) {
                    return -1;
                }
                this.crc.update(bArr, i, inflate);
                return inflate;
            } catch (DataFormatException e) {
                throw new ZipException(e.getMessage());
            }
        }
        int i3 = (int) this.currentEntry.size;
        if (this.inRead < i3) {
            if (this.lastRead >= this.len) {
                this.lastRead = 0;
                int read = this.in.read(this.buf);
                this.len = read;
                if (read == -1) {
                    this.eof = true;
                    return -1;
                }
                this.entryIn += this.len;
            }
            if (i2 > this.len - this.lastRead) {
                i2 = this.len - this.lastRead;
            }
            int i4 = i2;
            if (i3 - this.inRead < i2) {
                i4 = i3 - this.inRead;
            }
            System.arraycopy(this.buf, this.lastRead, bArr, i, i4);
            this.lastRead += i4;
            this.inRead += i4;
            this.crc.update(bArr, i, i4);
            return i4;
        }
        return -1;
    }
}
