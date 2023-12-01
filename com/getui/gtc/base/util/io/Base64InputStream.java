package com.getui.gtc.base.util.io;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/util/io/Base64InputStream.class */
public class Base64InputStream extends InputStream {
    private int[] buffer;
    private int bufferCounter = 0;
    private boolean eof = false;
    private InputStream inputStream;

    public Base64InputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private void acquire() throws IOException {
        int i;
        int i2;
        int i3;
        boolean z;
        char[] cArr = new char[4];
        int i4 = 0;
        do {
            int read = this.inputStream.read();
            if (read == -1) {
                if (i4 != 0) {
                    throw new IOException("Bad base64 stream");
                }
                this.buffer = new int[0];
                this.eof = true;
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
                } else if (this.inputStream.read() != -1) {
                    throw new IOException("Bad base64 stream");
                } else {
                    this.eof = true;
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
                this.buffer = new int[i2];
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= i2) {
                        return;
                    }
                    this.buffer[i10] = (i3 >>> ((2 - i10) * 8)) & 255;
                    i9 = i10 + 1;
                }
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inputStream.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int[] iArr = this.buffer;
        if (iArr == null || this.bufferCounter == iArr.length) {
            if (this.eof) {
                return -1;
            }
            acquire();
            if (this.buffer.length == 0) {
                this.buffer = null;
                return -1;
            }
            this.bufferCounter = 0;
        }
        int[] iArr2 = this.buffer;
        int i = this.bufferCounter;
        this.bufferCounter = i + 1;
        return iArr2[i];
    }
}
