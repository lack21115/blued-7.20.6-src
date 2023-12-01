package com.igexin.c.a.b.a.a;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    final BufferedOutputStream f23235a;

    public i(OutputStream outputStream) throws IOException {
        this.f23235a = new BufferedOutputStream(outputStream);
    }

    private i(Socket socket) throws IOException {
        this.f23235a = new BufferedOutputStream(socket.getOutputStream());
    }

    private void a() throws IOException {
        this.f23235a.close();
    }

    private void a(byte[] bArr) throws IOException {
        this.f23235a.write(bArr, 0, bArr.length);
        this.f23235a.flush();
    }

    private void a(byte[] bArr, int i, int i2) throws IOException {
        this.f23235a.write(bArr, i, i2);
        this.f23235a.flush();
    }
}
