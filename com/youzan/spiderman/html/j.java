package com.youzan.spiderman.html;

import com.youzan.spiderman.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/j.class */
public final class j extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private HtmlHeader f41841a;
    private g b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f41842c;
    private e e;
    private ByteArrayOutputStream d = new ByteArrayOutputStream();
    private boolean f = false;

    public j(HtmlHeader htmlHeader, g gVar, InputStream inputStream, e eVar) {
        this.f41841a = htmlHeader;
        this.b = gVar;
        this.f41842c = inputStream;
        this.e = eVar;
    }

    public final byte[] a() {
        return this.d.toByteArray();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        try {
            if (this.f) {
                return;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = this.f41842c.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    this.d.write(bArr, 0, read);
                }
                this.e.a(this.f41841a, this.b, this.d.toByteArray());
            } catch (IOException e) {
                Logger.e("HtmlInputStream", "close exception", e);
            }
        } finally {
            this.f41842c.close();
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            int read = this.f41842c.read();
            if (read != -1) {
                this.d.write(read);
            }
            return read;
        } catch (IOException e) {
            this.f = true;
            Logger.e("HtmlInputStream", "read exception", e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.f41842c.read(bArr, i, i2);
            if (read != -1) {
                this.d.write(bArr, i, read);
            }
            return read;
        } catch (IOException e) {
            this.f = true;
            Logger.e("HtmlInputStream", "read buf exception", e);
            throw e;
        }
    }
}
