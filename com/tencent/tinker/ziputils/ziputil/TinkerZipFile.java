package com.tencent.tinker.ziputils.ziputil;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/ziputils/ziputil/TinkerZipFile.class */
public class TinkerZipFile implements ZipConstants, Closeable {
    static final int GPBF_DATA_DESCRIPTOR_FLAG = 8;
    static final int GPBF_ENCRYPTED_FLAG = 1;
    static final int GPBF_UNSUPPORTED_MASK = 1;
    static final int GPBF_UTF8_FLAG = 2048;
    public static final int OPEN_DELETE = 4;
    public static final int OPEN_READ = 1;
    private String comment;
    private final LinkedHashMap<String, TinkerZipEntry> entries;
    private File fileToDeleteOnClose;
    private final String filename;
    private RandomAccessFile raf;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/ziputils/ziputil/TinkerZipFile$EocdRecord.class */
    static class EocdRecord {
        final long centralDirOffset;
        final int commentLength;
        final long numEntries;

        EocdRecord(long j, long j2, int i) {
            this.numEntries = j;
            this.centralDirOffset = j2;
            this.commentLength = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/ziputils/ziputil/TinkerZipFile$RAFStream.class */
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
            long j2 = this.endOffset;
            long j3 = this.offset;
            long j4 = j;
            if (j > j2 - j3) {
                j4 = j2 - j3;
            }
            this.offset += j4;
            return j4;
        }
    }

    public TinkerZipFile(File file) throws ZipException, IOException {
        this(file, 1);
    }

    public TinkerZipFile(File file, int i) throws IOException {
        this.entries = new LinkedHashMap<>();
        this.filename = file.getPath();
        if (i != 1 && i != 5) {
            throw new IllegalArgumentException("Bad mode: " + i);
        }
        if ((i & 4) != 0) {
            this.fileToDeleteOnClose = file;
            file.deleteOnExit();
        } else {
            this.fileToDeleteOnClose = null;
        }
        this.raf = new RandomAccessFile(this.filename, "r");
        readCentralDir();
    }

    public TinkerZipFile(String str) throws IOException {
        this(new File(str), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNotClosed() {
        if (this.raf == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static EocdRecord parseEocdRecord(RandomAccessFile randomAccessFile, long j, boolean z) throws IOException {
        long j2;
        long j3;
        randomAccessFile.seek(j);
        byte[] bArr = new byte[18];
        randomAccessFile.readFully(bArr);
        BufferIterator it = HeapBufferIterator.iterator(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
        if (z) {
            it.skip(16);
            j3 = -1;
            j2 = -1;
        } else {
            short readShort = it.readShort();
            short readShort2 = it.readShort();
            long readShort3 = it.readShort() & 65535;
            short readShort4 = it.readShort();
            it.skip(4);
            long readInt = it.readInt();
            if (readShort3 != (readShort4 & 65535) || (readShort & 65535) != 0 || (readShort2 & 65535) != 0) {
                throw new ZipException("Spanned archives not supported");
            }
            j2 = readInt & 4294967295L;
            j3 = readShort3;
        }
        return new EocdRecord(j3, j2, it.readShort() & 65535);
    }

    private void readCentralDir() throws IOException {
        long length = this.raf.length() - 22;
        long j = 0;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.raf.length());
        }
        this.raf.seek(0L);
        if (Integer.reverseBytes(this.raf.readInt()) != ZipConstants.LOCSIG) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        do {
            this.raf.seek(length);
            if (Integer.reverseBytes(this.raf.readInt()) == ZipConstants.ENDSIG) {
                byte[] bArr = new byte[18];
                this.raf.readFully(bArr);
                BufferIterator it = HeapBufferIterator.iterator(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
                short readShort = it.readShort();
                short readShort2 = it.readShort();
                int readShort3 = it.readShort() & 65535;
                short readShort4 = it.readShort();
                it.skip(4);
                long readInt = it.readInt() & 4294967295L;
                int readShort5 = it.readShort() & 65535;
                if (readShort3 != (readShort4 & 65535) || (readShort & 65535) != 0 || (readShort2 & 65535) != 0) {
                    throw new ZipException("Spanned archives not supported");
                }
                if (readShort5 > 0) {
                    byte[] bArr2 = new byte[readShort5];
                    this.raf.readFully(bArr2);
                    this.comment = new String(bArr2, 0, readShort5, StandardCharsets.UTF_8);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new RAFStream(this.raf, readInt), 4096);
                byte[] bArr3 = new byte[46];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readShort3) {
                        return;
                    }
                    TinkerZipEntry tinkerZipEntry = new TinkerZipEntry(bArr3, bufferedInputStream, StandardCharsets.UTF_8, false);
                    if (tinkerZipEntry.localHeaderRelOffset >= readInt) {
                        throw new ZipException("Local file header offset is after central directory");
                    }
                    String name = tinkerZipEntry.getName();
                    if (this.entries.put(name, tinkerZipEntry) != null) {
                        throw new ZipException("Duplicate entry name: " + name);
                    }
                    i = i2 + 1;
                }
            } else {
                length--;
            }
        } while (length >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void throwZipException(String str, long j, String str2, long j2, String str3, int i) throws ZipException {
        String hexString = Integer.toHexString(i);
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + hexString);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.raf = null;
                randomAccessFile.close();
            }
            File file = this.fileToDeleteOnClose;
            if (file != null) {
                file.delete();
                this.fileToDeleteOnClose = null;
            }
        }
    }

    public Enumeration<? extends TinkerZipEntry> entries() {
        checkNotClosed();
        final Iterator<TinkerZipEntry> it = this.entries.values().iterator();
        return new Enumeration<TinkerZipEntry>() { // from class: com.tencent.tinker.ziputils.ziputil.TinkerZipFile.1
            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                TinkerZipFile.this.checkNotClosed();
                return it.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Enumeration
            public TinkerZipEntry nextElement() {
                TinkerZipFile.this.checkNotClosed();
                return (TinkerZipEntry) it.next();
            }
        };
    }

    public String getComment() {
        checkNotClosed();
        return this.comment;
    }

    public TinkerZipEntry getEntry(String str) {
        checkNotClosed();
        if (str != null) {
            TinkerZipEntry tinkerZipEntry = this.entries.get(str);
            TinkerZipEntry tinkerZipEntry2 = tinkerZipEntry;
            if (tinkerZipEntry == null) {
                LinkedHashMap<String, TinkerZipEntry> linkedHashMap = this.entries;
                tinkerZipEntry2 = linkedHashMap.get(str + "/");
            }
            return tinkerZipEntry2;
        }
        throw new NullPointerException("entryName == null");
    }

    public InputStream getInputStream(TinkerZipEntry tinkerZipEntry) throws IOException {
        RAFStream rAFStream;
        TinkerZipEntry entry = getEntry(tinkerZipEntry.getName());
        if (entry == null) {
            return null;
        }
        RandomAccessFile randomAccessFile = this.raf;
        synchronized (randomAccessFile) {
            rAFStream = new RAFStream(randomAccessFile, entry.localHeaderRelOffset);
            DataInputStream dataInputStream = new DataInputStream(rAFStream);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (reverseBytes != ZipConstants.LOCSIG) {
                throwZipException(this.filename, randomAccessFile.length(), entry.getName(), entry.localHeaderRelOffset, "Local File Header", reverseBytes);
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
            rAFStream.skip((reverseBytes3 & 65535) + (65535 & reverseBytes4));
            if (entry.compressionMethod == 0) {
                rAFStream.endOffset = rAFStream.offset + entry.size;
            } else {
                rAFStream.endOffset = rAFStream.offset + entry.compressedSize;
            }
        }
        return rAFStream;
    }

    public String getName() {
        return this.filename;
    }

    public int size() {
        checkNotClosed();
        return this.entries.size();
    }
}
