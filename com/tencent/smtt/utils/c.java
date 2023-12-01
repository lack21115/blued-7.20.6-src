package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/c.class */
public class c implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessFile f38934a;
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f38935c;
    private boolean d;

    public c(File file) throws FileNotFoundException {
        this.f38935c = new byte[8];
        this.b = file;
        this.f38934a = new RandomAccessFile(this.b, "r");
    }

    public c(String str) throws FileNotFoundException {
        this(new File(str));
    }

    public final int a(byte[] bArr) throws IOException {
        return this.f38934a.read(bArr);
    }

    public final int a(char[] cArr) throws IOException {
        byte[] bArr = new byte[cArr.length];
        int read = this.f38934a.read(bArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= cArr.length) {
                return read;
            }
            cArr[i2] = (char) bArr[i2];
            i = i2 + 1;
        }
    }

    public final short a() throws IOException {
        short readShort = this.f38934a.readShort();
        short s = readShort;
        if (this.d) {
            s = (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
        }
        return s;
    }

    public void a(long j) throws IOException {
        this.f38934a.seek(j);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public final int b() throws IOException {
        int readInt = this.f38934a.readInt();
        int i = readInt;
        if (this.d) {
            i = ((readInt & (-16777216)) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
        }
        return i;
    }

    public final long c() throws IOException {
        if (this.d) {
            this.f38934a.readFully(this.f38935c, 0, 8);
            byte[] bArr = this.f38935c;
            return ((bArr[1] & 255) << 8) | (bArr[7] << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | (bArr[0] & 255);
        }
        return this.f38934a.readLong();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f38934a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
