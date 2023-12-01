package com.igexin.c.a.b.a.a;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    final BufferedOutputStream f9627a;

    public i(OutputStream outputStream) throws IOException {
        this.f9627a = new BufferedOutputStream(outputStream);
    }

    private i(Socket socket) throws IOException {
        this.f9627a = new BufferedOutputStream(socket.getOutputStream());
    }

    private void a() throws IOException {
        this.f9627a.close();
    }

    private void a(byte[] bArr) throws IOException {
        this.f9627a.write(bArr, 0, bArr.length);
        this.f9627a.flush();
    }

    private void a(byte[] bArr, int i, int i2) throws IOException {
        this.f9627a.write(bArr, i, i2);
        this.f9627a.flush();
    }
}
