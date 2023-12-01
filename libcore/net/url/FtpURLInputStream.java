package libcore.net.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import libcore.io.IoUtils;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/url/FtpURLInputStream.class */
class FtpURLInputStream extends InputStream {
    private Socket controlSocket;
    private InputStream is;

    public FtpURLInputStream(InputStream inputStream, Socket socket) {
        this.is = inputStream;
        this.controlSocket = socket;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.is.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IoUtils.closeQuietly(this.is);
        IoUtils.closeQuietly(this.controlSocket);
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            this.is.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.is.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.is.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.is.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            this.is.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.is.skip(j);
    }
}
