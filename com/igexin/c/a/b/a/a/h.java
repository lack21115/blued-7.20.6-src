package com.igexin.c.a.b.a.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedInputStream f9626a;

    public h(InputStream inputStream) throws IOException {
        this.f9626a = new BufferedInputStream(inputStream);
    }

    private h(Socket socket) throws IOException {
        this.f9626a = new BufferedInputStream(socket.getInputStream());
    }

    private int a() throws IOException {
        return this.f9626a.read();
    }

    private int a(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = i5;
            if (i4 >= i2) {
                break;
            }
            i5 = this.f9626a.read(bArr, i + i4, i2 - i4);
            i3 = i5;
            if (i5 <= 0) {
                break;
            }
            i4 += i5;
        }
        return i3;
    }

    private int b(byte[] bArr) throws IOException {
        return this.f9626a.read(bArr);
    }

    private void b() throws IOException {
        this.f9626a.close();
    }

    public final int a(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            i2 = this.f9626a.read(bArr, i, length - i);
            if (i2 <= 0) {
                throw new IOException("read = -1, end of stream !");
            }
            i += i2;
        }
        return i2;
    }
}
