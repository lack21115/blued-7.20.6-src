package com.igexin.c.a.b;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a.class */
public final class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f23218a;
    private int[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f23219c = 0;
    private boolean d = false;

    public a(InputStream inputStream) {
        this.f23218a = inputStream;
    }

    private void a() throws IOException {
        int i;
        int i2;
        int i3;
        boolean z;
        char[] cArr = new char[4];
        int i4 = 0;
        do {
            int read = this.f23218a.read();
            if (read == -1) {
                if (i4 != 0) {
                    throw new IOException("Bad base64 stream");
                }
                this.b = new int[0];
                this.d = true;
                return;
            }
            char c2 = (char) read;
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c2) != -1 || c2 == '=') {
                cArr[i4] = c2;
                i = i4 + 1;
            } else {
                i = i4;
                if (c2 != '\r') {
                    if (c2 != '\n') {
                        throw new IOException("Bad base64 stream");
                    }
                    i = i4;
                }
            }
            i4 = i;
        } while (i < 4);
        int i5 = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (i5 < 4) {
                if (cArr[i5] == '=') {
                    z = z3;
                    if (!z3) {
                        z = true;
                    }
                } else if (z3) {
                    throw new IOException("Bad base64 stream");
                } else {
                    z = z3;
                }
                i5++;
                z2 = z;
            } else {
                if (cArr[3] != '=') {
                    i2 = 3;
                } else if (this.f23218a.read() != -1) {
                    throw new IOException("Bad base64 stream");
                } else {
                    this.d = true;
                    i2 = cArr[2] == '=' ? 1 : 2;
                }
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    i3 = i7;
                    if (i6 >= 4) {
                        break;
                    }
                    int i8 = i3;
                    if (cArr[i6] != '=') {
                        i8 = i3 | ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(cArr[i6]) << ((3 - i6) * 6));
                    }
                    i6++;
                    i7 = i8;
                }
                this.b = new int[i2];
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= i2) {
                        return;
                    }
                    this.b[i10] = (i3 >>> ((2 - i10) * 8)) & 255;
                    i9 = i10 + 1;
                }
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f23218a.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0174, code lost:
        if (r6.b.length != 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0177, code lost:
        r6.b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017d, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017e, code lost:
        r6.f23219c = 0;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int read() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.b.a.read():int");
    }
}
