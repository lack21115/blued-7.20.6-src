package com.igexin.c.a.b;

import com.tencent.qcloud.core.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/b.class */
public final class b extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f23238a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f23239c;
    private int d;
    private int e;

    private b(OutputStream outputStream) {
        this(outputStream, 76);
    }

    public b(OutputStream outputStream, int i) {
        this.f23238a = null;
        this.b = 0;
        this.f23239c = 0;
        this.d = 0;
        this.e = 0;
        this.f23238a = outputStream;
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() throws IOException {
        if (this.f23239c > 0) {
            int i = this.e;
            if (i > 0 && this.d == i) {
                this.f23238a.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
                this.d = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 14) >>> 26);
            char c2 = '=';
            char charAt3 = this.f23239c < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 20) >>> 26);
            if (this.f23239c >= 3) {
                c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 26) >>> 26);
            }
            this.f23238a.write(charAt);
            this.f23238a.write(charAt2);
            this.f23238a.write(charAt3);
            this.f23238a.write(c2);
            this.d += 4;
            this.f23239c = 0;
            this.b = 0;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a();
        this.f23238a.close();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        int i2 = this.f23239c;
        this.b = ((i & 255) << (16 - (i2 * 8))) | this.b;
        int i3 = i2 + 1;
        this.f23239c = i3;
        if (i3 == 3) {
            a();
        }
    }
}
