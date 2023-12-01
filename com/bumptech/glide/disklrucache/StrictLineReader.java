package com.bumptech.glide.disklrucache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/disklrucache/StrictLineReader.class */
public class StrictLineReader implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f20681a;
    private final Charset b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f20682c;
    private int d;
    private int e;

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(Util.f20684a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f20681a = inputStream;
        this.b = charset;
        this.f20682c = new byte[i];
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f20681a;
        byte[] bArr = this.f20682c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = read;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r7.f20682c[r9] == 13) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.StrictLineReader.a():java.lang.String");
    }

    public boolean b() {
        return this.e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f20681a) {
            if (this.f20682c != null) {
                this.f20682c = null;
                this.f20681a.close();
            }
        }
    }
}
