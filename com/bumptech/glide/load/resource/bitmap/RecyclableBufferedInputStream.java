package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.class */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f7359a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7360c;
    private int d;
    private int e;
    private final ArrayPool f;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream$InvalidMarkException.class */
    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool, int i) {
        super(inputStream);
        this.d = -1;
        this.f = arrayPool;
        this.f7359a = (byte[]) arrayPool.a(i, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        byte[] bArr2;
        int i = this.d;
        if (i != -1) {
            int i2 = this.e;
            int i3 = this.f7360c;
            if (i2 - i < i3) {
                if (i == 0 && i3 > bArr.length && this.b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    bArr2 = (byte[]) this.f.a(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f7359a = bArr2;
                    this.f.a((ArrayPool) bArr);
                } else {
                    int i4 = this.d;
                    bArr2 = bArr;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                        bArr2 = bArr;
                    }
                }
                int i5 = this.e - this.d;
                this.e = i5;
                this.d = 0;
                this.b = 0;
                int read = inputStream.read(bArr2, i5, bArr2.length - i5);
                int i6 = this.e;
                if (read > 0) {
                    i6 += read;
                }
                this.b = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.d = -1;
            this.e = 0;
            this.b = read2;
        }
        return read2;
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public void a() {
        synchronized (this) {
            this.f7360c = this.f7359a.length;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i;
        int i2;
        int available;
        synchronized (this) {
            InputStream inputStream = this.in;
            if (this.f7359a == null || inputStream == null) {
                throw c();
            }
            i = this.b;
            i2 = this.e;
            available = inputStream.available();
        }
        return (i - i2) + available;
    }

    public void b() {
        synchronized (this) {
            if (this.f7359a != null) {
                this.f.a((ArrayPool) this.f7359a);
                this.f7359a = null;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f7359a != null) {
            this.f.a((ArrayPool) this.f7359a);
            this.f7359a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            this.f7360c = Math.max(this.f7360c, i);
            this.d = this.e;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        synchronized (this) {
            byte[] bArr = this.f7359a;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                throw c();
            }
            if (this.e < this.b || a(inputStream, bArr) != -1) {
                byte[] bArr2 = bArr;
                if (bArr != this.f7359a) {
                    bArr2 = this.f7359a;
                    if (bArr2 == null) {
                        throw c();
                    }
                }
                if (this.b - this.e > 0) {
                    int i = this.e;
                    this.e = i + 1;
                    return bArr2[i] & 255;
                }
                return -1;
            }
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        synchronized (this) {
            byte[] bArr2 = this.f7359a;
            if (bArr2 == null) {
                throw c();
            }
            if (i2 == 0) {
                return 0;
            }
            InputStream inputStream = this.in;
            if (inputStream == null) {
                throw c();
            }
            if (this.e < this.b) {
                int i6 = this.b - this.e >= i2 ? i2 : this.b - this.e;
                System.arraycopy(bArr2, this.e, bArr, i, i6);
                this.e += i6;
                if (i6 == i2 || inputStream.available() == 0) {
                    return i6;
                }
                int i7 = i + i6;
                i4 = i2 - i6;
                i3 = i7;
            } else {
                i3 = i;
                i4 = i2;
            }
            while (true) {
                int i8 = -1;
                if (this.d == -1 && i4 >= bArr2.length) {
                    int read = inputStream.read(bArr, i3, i4);
                    i5 = read;
                    if (read == -1) {
                        if (i4 != i2) {
                            i8 = i2 - i4;
                        }
                        return i8;
                    }
                } else if (a(inputStream, bArr2) == -1) {
                    if (i4 != i2) {
                        i8 = i2 - i4;
                    }
                    return i8;
                } else {
                    byte[] bArr3 = bArr2;
                    if (bArr2 != this.f7359a) {
                        bArr3 = this.f7359a;
                        if (bArr3 == null) {
                            throw c();
                        }
                    }
                    int i9 = this.b - this.e >= i4 ? i4 : this.b - this.e;
                    System.arraycopy(bArr3, this.e, bArr, i3, i9);
                    this.e += i9;
                    i5 = i9;
                    bArr2 = bArr3;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i4;
                }
                i3 += i5;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            if (this.f7359a == null) {
                throw new IOException("Stream is closed");
            }
            if (-1 == this.d) {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.f7360c);
            }
            this.e = this.d;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        synchronized (this) {
            if (j < 1) {
                return 0L;
            }
            byte[] bArr = this.f7359a;
            if (bArr != null) {
                InputStream inputStream = this.in;
                if (inputStream != null) {
                    if (this.b - this.e >= j) {
                        this.e = (int) (this.e + j);
                        return j;
                    }
                    long j2 = this.b - this.e;
                    this.e = this.b;
                    if (this.d == -1 || j > this.f7360c) {
                        return j2 + inputStream.skip(j - j2);
                    } else if (a(inputStream, bArr) == -1) {
                        return j2;
                    } else {
                        if (this.b - this.e >= j - j2) {
                            this.e = (int) ((this.e + j) - j2);
                            return j;
                        }
                        long j3 = this.b;
                        long j4 = this.e;
                        this.e = this.b;
                        return (j2 + j3) - j4;
                    }
                }
                throw c();
            }
            throw c();
        }
    }
}
