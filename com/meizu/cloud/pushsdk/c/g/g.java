package com.meizu.cloud.pushsdk.c.g;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f10454a = Logger.getLogger(g.class.getName());

    private g() {
    }

    public static c a(l lVar) {
        if (lVar != null) {
            return new h(lVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static d a(m mVar) {
        if (mVar != null) {
            return new i(mVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static l a(OutputStream outputStream) {
        return a(outputStream, new n());
    }

    private static l a(final OutputStream outputStream, final n nVar) {
        if (outputStream != null) {
            if (nVar != null) {
                return new l() { // from class: com.meizu.cloud.pushsdk.c.g.g.1
                    @Override // com.meizu.cloud.pushsdk.c.g.l
                    public void a(b bVar, long j) throws IOException {
                        o.a(bVar.b, 0L, j);
                        while (j > 0) {
                            n.this.a();
                            j jVar = bVar.f10449a;
                            int min = (int) Math.min(j, jVar.f10463c - jVar.b);
                            outputStream.write(jVar.f10462a, jVar.b, min);
                            jVar.b += min;
                            long j2 = min;
                            long j3 = j - j2;
                            bVar.b -= j2;
                            j = j3;
                            if (jVar.b == jVar.f10463c) {
                                bVar.f10449a = jVar.a();
                                k.a(jVar);
                                j = j3;
                            }
                        }
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
                    public void close() throws IOException {
                        outputStream.close();
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
                    public void flush() throws IOException {
                        outputStream.flush();
                    }

                    public String toString() {
                        return "sink(" + outputStream + ")";
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static m a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static m a(InputStream inputStream) {
        return a(inputStream, new n());
    }

    private static m a(final InputStream inputStream, final n nVar) {
        if (inputStream != null) {
            if (nVar != null) {
                return new m() { // from class: com.meizu.cloud.pushsdk.c.g.g.2
                    @Override // com.meizu.cloud.pushsdk.c.g.m
                    public long b(b bVar, long j) throws IOException {
                        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                        if (i < 0) {
                            throw new IllegalArgumentException("byteCount < 0: " + j);
                        } else if (i == 0) {
                            return 0L;
                        } else {
                            n.this.a();
                            j c2 = bVar.c(1);
                            int read = inputStream.read(c2.f10462a, c2.f10463c, (int) Math.min(j, 2048 - c2.f10463c));
                            if (read == -1) {
                                return -1L;
                            }
                            c2.f10463c += read;
                            long j2 = read;
                            bVar.b += j2;
                            return j2;
                        }
                    }

                    @Override // com.meizu.cloud.pushsdk.c.g.m, java.lang.AutoCloseable
                    public void close() throws IOException {
                        inputStream.close();
                    }

                    public String toString() {
                        return "source(" + inputStream + ")";
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }
}
