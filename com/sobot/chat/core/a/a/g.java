package com.sobot.chat.core.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/g.class */
public class g extends Reader {

    /* renamed from: a  reason: collision with root package name */
    final g f14520a;
    private InputStream b;

    public g(InputStream inputStream) {
        super(inputStream);
        this.f14520a = this;
        this.b = inputStream;
    }

    public static void a(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException("arrayLength=" + i + "; offset=" + i2 + "; count=" + i3);
        }
    }

    private boolean a() {
        return this.b != null;
    }

    public byte[] a(int i) throws IOException {
        int i2;
        if (i <= 0) {
            return null;
        }
        synchronized (this.lock) {
            if (a()) {
                try {
                    byte[] bArr = new byte[i];
                    int i3 = 0;
                    do {
                        int read = this.b.read(bArr, i3, i - i3);
                        i2 = i3 + read;
                        if (read == -1) {
                            break;
                        }
                        i3 = i2;
                    } while (i2 < i);
                    if (i2 != i) {
                        return null;
                    }
                    return bArr;
                } catch (IOException e) {
                    return null;
                }
            }
            throw new IOException("InputStreamReader is closed");
        }
    }

    public byte[] a(byte[] bArr, boolean z) throws IOException {
        int i;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        synchronized (this.lock) {
            if (!a()) {
                throw new IOException("InputStreamReader is closed");
            }
            try {
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                do {
                    int read = this.b.read();
                    if (-1 == read) {
                        break;
                    }
                    arrayList.add(Byte.valueOf((byte) read));
                    i = read == (bArr[i2] & 255) ? i2 + 1 : 0;
                    i2 = i;
                } while (i != bArr.length);
                if (arrayList.size() == 0) {
                    return null;
                }
                int size = arrayList.size() - (z ? 0 : bArr.length);
                byte[] bArr2 = new byte[size];
                Iterator it = arrayList.iterator();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        return bArr2;
                    }
                    bArr2[i4] = ((Byte) it.next()).byteValue();
                    i3 = i4 + 1;
                }
            } catch (IOException e) {
                return null;
            }
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            if (this.b != null) {
                this.b.close();
                this.b = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        throw new IOException("read() is not support for SocketInputReader, try readBytes().");
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        boolean z;
        synchronized (this.lock) {
            if (this.b == null) {
                throw new IOException("InputStreamReader is closed");
            }
            z = false;
            try {
                if (this.b.available() > 0) {
                    z = true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return z;
    }
}
