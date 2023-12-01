package java.util.zip;

import android.widget.ExpandableListView;
import com.android.org.conscrypt.NativeCrypto;
import com.anythink.core.common.b.g;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import dalvik.system.CloseGuard;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import libcore.io.BufferIterator;
import libcore.io.HeapBufferIterator;
import libcore.io.IoUtils;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/zip/ZipFile.class */
public class ZipFile implements Closeable, ZipConstants {
    static final int GPBF_DATA_DESCRIPTOR_FLAG = 8;
    static final int GPBF_ENCRYPTED_FLAG = 1;
    static final int GPBF_UNSUPPORTED_MASK = 1;
    static final int GPBF_UTF8_FLAG = 2048;
    public static final int OPEN_DELETE = 4;
    public static final int OPEN_READ = 1;
    private String comment;
    private final LinkedHashMap<String, ZipEntry> entries;
    private File fileToDeleteOnClose;
    private final String filename;
    private final CloseGuard guard;
    private RandomAccessFile raf;

    /* loaded from: source-2895416-dex2jar.jar:java/util/zip/ZipFile$RAFStream.class */
    public static class RAFStream extends InputStream {
        private long endOffset;
        private long offset;
        private final RandomAccessFile sharedRaf;

        public RAFStream(RandomAccessFile randomAccessFile, long j) throws IOException {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public RAFStream(RandomAccessFile randomAccessFile, long j, long j2) {
            this.sharedRaf = randomAccessFile;
            this.offset = j;
            this.endOffset = j2;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.offset < this.endOffset ? 1 : 0;
        }

        public int fill(Inflater inflater, int i) throws IOException {
            int min;
            synchronized (this.sharedRaf) {
                min = Math.min((int) (this.endOffset - this.offset), i);
                skip(inflater.setFileInput(this.sharedRaf.getFD(), this.offset, i));
            }
            return min;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return Streams.readSingleByte(this);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            synchronized (this.sharedRaf) {
                long j = this.endOffset - this.offset;
                int i3 = i2;
                if (i2 > j) {
                    i3 = (int) j;
                }
                this.sharedRaf.seek(this.offset);
                int read = this.sharedRaf.read(bArr, i, i3);
                if (read > 0) {
                    this.offset += read;
                    return read;
                }
                return -1;
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = j;
            if (j > this.endOffset - this.offset) {
                j2 = this.endOffset - this.offset;
            }
            this.offset += j2;
            return j2;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/zip/ZipFile$ZipInflaterInputStream.class */
    public static class ZipInflaterInputStream extends InflaterInputStream {
        private long bytesRead;
        private final ZipEntry entry;

        public ZipInflaterInputStream(InputStream inputStream, Inflater inflater, int i, ZipEntry zipEntry) {
            super(inputStream, inflater, i);
            this.bytesRead = 0L;
            this.entry = zipEntry;
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            if (this.closed || super.available() == 0) {
                return 0;
            }
            return (int) (this.entry.getSize() - this.bytesRead);
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            try {
                int read = super.read(bArr, i, i2);
                if (read != -1) {
                    this.bytesRead += read;
                } else if (this.entry.size != this.bytesRead) {
                    throw new IOException("Size mismatch on inflated file: " + this.bytesRead + " vs " + this.entry.size);
                }
                return read;
            } catch (IOException e) {
                throw new IOException("Error reading data for " + this.entry.getName() + " near offset " + this.bytesRead, e);
            }
        }
    }

    public ZipFile(File file) throws ZipException, IOException {
        this(file, 1);
    }

    public ZipFile(File file, int i) throws IOException {
        this.entries = new LinkedHashMap<>();
        this.guard = CloseGuard.get();
        this.filename = file.getPath();
        if (i != 1 && i != 5) {
            throw new IllegalArgumentException("Bad mode: " + i);
        }
        if ((i & 4) != 0) {
            this.fileToDeleteOnClose = file;
            this.fileToDeleteOnClose.deleteOnExit();
        } else {
            this.fileToDeleteOnClose = null;
        }
        this.raf = new RandomAccessFile(this.filename, g.o.o);
        try {
            readCentralDir();
            if (0 != 0) {
                IoUtils.closeQuietly(this.raf);
            }
            this.guard.open(LoaderConstants.CLOSE);
        } catch (Throwable th) {
            if (1 != 0) {
                IoUtils.closeQuietly(this.raf);
            }
            throw th;
        }
    }

    public ZipFile(String str) throws IOException {
        this(new File(str), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNotClosed() {
        if (this.raf == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    private void readCentralDir() throws IOException {
        long j;
        long length = this.raf.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.raf.length());
        }
        this.raf.seek(0L);
        int reverseBytes = Integer.reverseBytes(this.raf.readInt());
        if (reverseBytes == ZipConstants.ENDSIG) {
            throw new ZipException("Empty zip archive not supported");
        }
        if (reverseBytes != ZipConstants.LOCSIG) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - NativeCrypto.SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION;
        long j3 = length;
        long j4 = j2;
        if (j2 < 0) {
            j4 = 0;
            j3 = length;
        }
        do {
            this.raf.seek(j3);
            if (Integer.reverseBytes(this.raf.readInt()) == ZipConstants.ENDSIG) {
                byte[] bArr = new byte[18];
                this.raf.readFully(bArr);
                BufferIterator it = HeapBufferIterator.iterator(bArr, 0, bArr.length, ByteOrder.LITTLE_ENDIAN);
                short readShort = it.readShort();
                short readShort2 = it.readShort();
                int readShort3 = it.readShort() & 65535;
                short readShort4 = it.readShort();
                it.skip(4);
                long readInt = it.readInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                int readShort5 = it.readShort() & 65535;
                if (readShort3 != (readShort4 & 65535) || (readShort & 65535) != 0 || (readShort2 & 65535) != 0) {
                    throw new ZipException("Spanned archives not supported");
                }
                if (readShort5 > 0) {
                    byte[] bArr2 = new byte[readShort5];
                    this.raf.readFully(bArr2);
                    this.comment = new String(bArr2, 0, bArr2.length, StandardCharsets.UTF_8);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new RAFStream(this.raf, readInt), 4096);
                byte[] bArr3 = new byte[46];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readShort3) {
                        return;
                    }
                    ZipEntry zipEntry = new ZipEntry(bArr3, bufferedInputStream, StandardCharsets.UTF_8);
                    if (zipEntry.localHeaderRelOffset >= readInt) {
                        throw new ZipException("Local file header offset is after central directory");
                    }
                    String name = zipEntry.getName();
                    if (this.entries.put(name, zipEntry) != null) {
                        throw new ZipException("Duplicate entry name: " + name);
                    }
                    i = i2 + 1;
                }
            } else {
                j = j3 - 1;
                j3 = j;
            }
        } while (j >= j4);
        throw new ZipException("End Of Central Directory signature not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwZipException(String str, int i) throws ZipException {
        throw new ZipException(str + " signature not found; was " + IntegralToString.intToHexString(i, true, 8));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.guard.close();
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.raf = null;
                randomAccessFile.close();
            }
            if (this.fileToDeleteOnClose != null) {
                this.fileToDeleteOnClose.delete();
                this.fileToDeleteOnClose = null;
            }
        }
    }

    public Enumeration<? extends ZipEntry> entries() {
        checkNotClosed();
        final Iterator<ZipEntry> it = this.entries.values().iterator();
        return new Enumeration<ZipEntry>() { // from class: java.util.zip.ZipFile.1
            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                ZipFile.this.checkNotClosed();
                return it.hasNext();
            }

            @Override // java.util.Enumeration
            public ZipEntry nextElement() {
                ZipFile.this.checkNotClosed();
                return (ZipEntry) it.next();
            }
        };
    }

    protected void finalize() throws IOException {
        AssertionError assertionError;
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
            try {
                super.finalize();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.finalize();
                throw th;
            } finally {
            }
        }
    }

    public String getComment() {
        checkNotClosed();
        return this.comment;
    }

    public ZipEntry getEntry(String str) {
        checkNotClosed();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        ZipEntry zipEntry = this.entries.get(str);
        ZipEntry zipEntry2 = zipEntry;
        if (zipEntry == null) {
            zipEntry2 = this.entries.get(str + BridgeUtil.SPLIT_MARK);
        }
        return zipEntry2;
    }

    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        ZipEntry entry = getEntry(zipEntry.getName());
        if (entry == null) {
            return null;
        }
        RandomAccessFile randomAccessFile = this.raf;
        synchronized (randomAccessFile) {
            RAFStream rAFStream = new RAFStream(randomAccessFile, entry.localHeaderRelOffset);
            DataInputStream dataInputStream = new DataInputStream(rAFStream);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (reverseBytes != ZipConstants.LOCSIG) {
                throwZipException("Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: " + reverseBytes2);
            }
            dataInputStream.skipBytes(18);
            short reverseBytes3 = Short.reverseBytes(dataInputStream.readShort());
            short reverseBytes4 = Short.reverseBytes(dataInputStream.readShort());
            dataInputStream.close();
            rAFStream.skip((reverseBytes3 & 65535) + (reverseBytes4 & 65535));
            if (entry.compressionMethod == 0) {
                rAFStream.endOffset = rAFStream.offset + entry.size;
                return rAFStream;
            }
            rAFStream.endOffset = rAFStream.offset + entry.compressedSize;
            return new ZipInflaterInputStream(rAFStream, new Inflater(true), Math.max(1024, (int) Math.min(entry.getSize(), 65535L)), entry);
        }
    }

    public String getName() {
        return this.filename;
    }

    public int size() {
        checkNotClosed();
        return this.entries.size();
    }
}
