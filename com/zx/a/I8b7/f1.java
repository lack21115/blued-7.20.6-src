package com.zx.a.I8b7;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/f1.class */
public abstract class f1 implements Closeable {

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/f1$a.class */
    public class a extends f1 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n0 f28436a;
        public final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InputStream f28437c;

        public a(n0 n0Var, long j, InputStream inputStream) {
            this.f28436a = n0Var;
            this.b = j;
            this.f28437c = inputStream;
        }
    }

    public static f1 a(n0 n0Var, long j, InputStream inputStream) {
        if (inputStream != null) {
            return new a(n0Var, j, inputStream);
        }
        throw new NullPointerException("byte stream is null");
    }

    public final byte[] a() throws IOException {
        a aVar = (a) this;
        long j = aVar.b;
        if (j > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + j);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = aVar.f28437c;
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                l1.a(inputStream);
                throw th;
            }
        }
        l1.a(inputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (j != -1 && j != byteArray.length) {
            throw new IOException("Content-Length (" + j + ") and stream length (" + byteArray.length + ") disagree");
        }
        return byteArray;
    }

    public final String b() throws IOException {
        return new String(a(), StandardCharsets.UTF_8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        l1.a(((a) this).f28437c);
    }
}
