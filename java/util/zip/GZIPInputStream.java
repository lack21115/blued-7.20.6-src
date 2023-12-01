package java.util.zip;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import libcore.io.Memory;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/GZIPInputStream.class */
public class GZIPInputStream extends InflaterInputStream {
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    public static final int GZIP_MAGIC = 35615;
    private static final int GZIP_TRAILER_SIZE = 8;
    protected CRC32 crc;
    protected boolean eos;

    public GZIPInputStream(InputStream inputStream) throws IOException {
        this(inputStream, 512);
    }

    public GZIPInputStream(InputStream inputStream, int i) throws IOException {
        super(inputStream, new Inflater(true), i);
        this.crc = new CRC32();
        this.eos = false;
        try {
            byte[] readHeader = readHeader(inputStream);
            short peekShort = Memory.peekShort(readHeader, 0, ByteOrder.LITTLE_ENDIAN);
            if (peekShort != -29921) {
                throw new IOException(String.format("unknown format (magic number %x)", Short.valueOf(peekShort)));
            }
            parseGzipHeader(inputStream, readHeader, this.crc, this.buf);
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    private boolean maybeReadNextMember() throws IOException {
        int remaining = this.inf.getRemaining() - 8;
        if (remaining > 0) {
            if (!(this.in instanceof PushbackInputStream)) {
                this.in = new PushbackInputStream(this.in, this.buf.length);
            }
            ((PushbackInputStream) this.in).unread(this.buf, this.inf.getCurrentOffset() + 8, remaining);
        }
        try {
            byte[] readHeader = readHeader(this.in);
            if (Memory.peekShort(readHeader, 0, ByteOrder.LITTLE_ENDIAN) != -29921) {
                return true;
            }
            parseGzipHeader(this.in, readHeader, this.crc, this.buf);
            return false;
        } catch (EOFException e) {
            return true;
        }
    }

    private static void parseGzipHeader(InputStream inputStream, byte[] bArr, CRC32 crc32, byte[] bArr2) throws IOException {
        byte b = bArr[3];
        boolean z = (b & 2) != 0;
        if (z) {
            crc32.update(bArr, 0, bArr.length);
        }
        if ((b & 4) != 0) {
            Streams.readFully(inputStream, bArr, 0, 2);
            if (z) {
                crc32.update(bArr, 0, 2);
            }
            int peekShort = Memory.peekShort(bArr2, 0, ByteOrder.LITTLE_ENDIAN) & 65535;
            while (true) {
                int i = peekShort;
                if (i <= 0) {
                    break;
                }
                int read = inputStream.read(bArr2, 0, i > bArr2.length ? bArr2.length : i);
                if (read == -1) {
                    throw new EOFException();
                }
                if (z) {
                    crc32.update(bArr2, 0, read);
                }
                peekShort = i - read;
            }
        }
        if ((b & 8) != 0) {
            readZeroTerminated(inputStream, crc32, z);
        }
        if ((b & 16) != 0) {
            readZeroTerminated(inputStream, crc32, z);
        }
        if (z) {
            Streams.readFully(inputStream, bArr, 0, 2);
            if (((short) crc32.getValue()) != Memory.peekShort(bArr2, 0, ByteOrder.LITTLE_ENDIAN)) {
                throw new IOException("CRC mismatch");
            }
            crc32.reset();
        }
    }

    private static byte[] readHeader(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[10];
        Streams.readFully(inputStream, bArr, 0, bArr.length);
        return bArr;
    }

    private static void readZeroTerminated(InputStream inputStream, CRC32 crc32, boolean z) throws IOException {
        int read;
        while (true) {
            read = inputStream.read();
            if (read <= 0) {
                break;
            } else if (z) {
                crc32.update(read);
            }
        }
        if (read == -1) {
            throw new EOFException();
        }
        if (z) {
            crc32.update(read);
        }
    }

    private void verifyCrc() throws IOException {
        int i = 8;
        int remaining = this.inf.getRemaining();
        byte[] bArr = new byte[8];
        if (remaining <= 8) {
            i = remaining;
        }
        System.arraycopy(this.buf, this.len - remaining, bArr, 0, i);
        Streams.readFully(this.in, bArr, i, 8 - i);
        if (Memory.peekInt(bArr, 0, ByteOrder.LITTLE_ENDIAN) != ((int) this.crc.getValue())) {
            throw new IOException("CRC mismatch");
        }
        if (Memory.peekInt(bArr, 4, ByteOrder.LITTLE_ENDIAN) != this.inf.getTotalOut()) {
            throw new IOException("Size mismatch");
        }
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.eos = true;
        super.close();
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.closed) {
            throw new IOException("Stream is closed");
        }
        if (this.eos) {
            i3 = -1;
        } else {
            Arrays.checkOffsetAndCount(bArr.length, i, i2);
            try {
                int read = super.read(bArr, i, i2);
                this.eos = this.eof;
                if (read != -1) {
                    this.crc.update(bArr, i, read);
                }
                i3 = read;
                if (this.eos) {
                    verifyCrc();
                    this.eos = maybeReadNextMember();
                    i3 = read;
                    if (!this.eos) {
                        this.crc.reset();
                        this.inf.reset();
                        this.eof = false;
                        this.len = 0;
                        return read;
                    }
                }
            } catch (Throwable th) {
                this.eos = this.eof;
                throw th;
            }
        }
        return i3;
    }
}
