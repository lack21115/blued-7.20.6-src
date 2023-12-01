package java.io;

import java.util.Arrays;
import libcore.util.SneakyThrow;

/* loaded from: source-2895416-dex2jar.jar:java/io/FilterOutputStream.class */
public class FilterOutputStream extends OutputStream {
    protected OutputStream out;

    public FilterOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th;
        Throwable th2 = null;
        try {
            flush();
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            this.out.close();
            th = th2;
        } catch (Throwable th4) {
            th = th2;
            if (th2 == null) {
                th = th4;
            }
        }
        if (th != null) {
            SneakyThrow.sneakyThrow(th);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            write(bArr[i + i4]);
            i3 = i4 + 1;
        }
    }
}
