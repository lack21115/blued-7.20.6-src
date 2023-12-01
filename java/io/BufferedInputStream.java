package java.io;

/* loaded from: source-2895416-dex2jar.jar:java/io/BufferedInputStream.class */
public class BufferedInputStream extends FilterInputStream {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    protected volatile byte[] buf;
    protected int count;
    protected int marklimit;
    protected int markpos;
    protected int pos;

    public BufferedInputStream(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public BufferedInputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.markpos = -1;
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.buf = new byte[i];
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        byte[] bArr2;
        int i = 0;
        if (this.markpos == -1 || this.pos - this.markpos >= this.marklimit) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.markpos = -1;
                this.pos = 0;
                if (read != -1) {
                    i = read;
                }
                this.count = i;
            }
            return read;
        }
        if (this.markpos != 0 || this.marklimit <= bArr.length) {
            bArr2 = bArr;
            if (this.markpos > 0) {
                System.arraycopy(bArr, this.markpos, bArr, 0, bArr.length - this.markpos);
                bArr2 = bArr;
            }
        } else {
            int length = bArr.length * 2;
            int i2 = length;
            if (length > this.marklimit) {
                i2 = this.marklimit;
            }
            bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buf = bArr2;
        }
        this.pos -= this.markpos;
        this.markpos = 0;
        this.count = 0;
        int read2 = inputStream.read(bArr2, this.pos, bArr2.length - this.pos);
        this.count = read2 <= 0 ? this.pos : this.pos + read2;
        return read2;
    }

    private IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i;
        int i2;
        int available;
        synchronized (this) {
            InputStream inputStream = this.in;
            if (this.buf == null || inputStream == null) {
                throw streamClosed();
            }
            i = this.count;
            i2 = this.pos;
            available = inputStream.available();
        }
        return (i - i2) + available;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.buf = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            this.marklimit = i;
            this.markpos = this.pos;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = -1;
        synchronized (this) {
            byte[] bArr = this.buf;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                throw streamClosed();
            }
            if (this.pos < this.count || fillbuf(inputStream, bArr) != -1) {
                byte[] bArr2 = bArr;
                if (bArr != this.buf) {
                    byte[] bArr3 = this.buf;
                    bArr2 = bArr3;
                    if (bArr3 == null) {
                        throw streamClosed();
                    }
                }
                if (this.count - this.pos > 0) {
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    i = bArr2[i2] & 255;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0140 A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0010, B:7:0x0014, B:13:0x001a, B:20:0x002b, B:22:0x0036, B:23:0x003a, B:25:0x003c, B:27:0x0046, B:31:0x0056, B:34:0x0074, B:38:0x008d, B:40:0x0095, B:42:0x009d, B:69:0x0140, B:48:0x00c7, B:55:0x00e8, B:57:0x00f1, B:60:0x0100, B:61:0x0104, B:63:0x0106, B:67:0x0117, B:68:0x0132, B:37:0x007f), top: B:79:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0186 A[SYNTHETIC] */
    @Override // java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedInputStream.read(byte[], int, int):int");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            if (this.buf == null) {
                throw new IOException("Stream is closed");
            }
            if (this.markpos == -1) {
                throw new IOException("Mark has been invalidated.");
            }
            this.pos = this.markpos;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        synchronized (this) {
            byte[] bArr = this.buf;
            InputStream inputStream = this.in;
            if (bArr == null) {
                throw streamClosed();
            }
            if (j < 1) {
                j = 0;
            } else if (inputStream == null) {
                throw streamClosed();
            } else {
                if (this.count - this.pos >= j) {
                    this.pos = (int) (this.pos + j);
                } else {
                    long j2 = this.count - this.pos;
                    this.pos = this.count;
                    if (this.markpos == -1 || j > this.marklimit) {
                        j = j2 + inputStream.skip(j - j2);
                    } else if (fillbuf(inputStream, bArr) == -1) {
                        j = j2;
                    } else if (this.count - this.pos >= j - j2) {
                        this.pos = (int) (this.pos + (j - j2));
                    } else {
                        long j3 = this.count - this.pos;
                        this.pos = this.count;
                        j = j2 + j3;
                    }
                }
            }
        }
        return j;
    }
}
