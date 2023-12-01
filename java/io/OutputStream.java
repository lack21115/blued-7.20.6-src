package java.io;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/io/OutputStream.class */
public abstract class OutputStream implements Closeable, Flushable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkError() {
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public void flush() throws IOException {
    }

    public abstract void write(int i) throws IOException;

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return;
            }
            write(bArr[i4]);
            i3 = i4 + 1;
        }
    }
}
