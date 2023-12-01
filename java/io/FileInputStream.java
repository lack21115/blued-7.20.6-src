package java.io;

import android.system.ErrnoException;
import android.system.OsConstants;
import dalvik.system.CloseGuard;
import java.nio.NioUtils;
import java.nio.channels.FileChannel;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/io/FileInputStream.class */
public class FileInputStream extends InputStream {
    private FileChannel channel;
    private FileDescriptor fd;
    private final CloseGuard guard;
    private final boolean shouldClose;

    public FileInputStream(File file) throws FileNotFoundException {
        this.guard = CloseGuard.get();
        if (file == null) {
            throw new NullPointerException("file == null");
        }
        this.fd = IoBridge.open(file.getPath(), OsConstants.O_RDONLY);
        this.shouldClose = true;
        this.guard.open("close");
    }

    public FileInputStream(FileDescriptor fileDescriptor) {
        this.guard = CloseGuard.get();
        if (fileDescriptor == null) {
            throw new NullPointerException("fd == null");
        }
        this.fd = fileDescriptor;
        this.shouldClose = false;
    }

    public FileInputStream(String str) throws FileNotFoundException {
        this(new File(str));
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return IoBridge.available(this.fd);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.guard.close();
        synchronized (this) {
            if (this.channel != null) {
                this.channel.close();
            }
            if (this.shouldClose) {
                IoBridge.closeAndSignalBlockedThreads(this.fd);
            } else {
                this.fd = new FileDescriptor();
            }
        }
    }

    protected void finalize() throws IOException {
        AssertionError assertionError;
        try {
            if (this.guard != null) {
                this.guard.warnIfOpen();
            }
            close();
            try {
                super.finalize();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.finalize();
                throw th;
            } finally {
            }
        }
    }

    public FileChannel getChannel() {
        FileChannel fileChannel;
        synchronized (this) {
            if (this.channel == null) {
                this.channel = NioUtils.newFileChannel(this, this.fd, OsConstants.O_RDONLY);
            }
            fileChannel = this.channel;
        }
        return fileChannel;
    }

    public final FileDescriptor getFD() throws IOException {
        return this.fd;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return Streams.readSingleByte(this);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return IoBridge.read(this.fd, bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IOException("byteCount < 0: " + j);
        }
        try {
            Libcore.os.lseek(this.fd, j, OsConstants.SEEK_CUR);
            return j;
        } catch (ErrnoException e) {
            if (e.errno == OsConstants.ESPIPE) {
                return super.skip(j);
            }
            throw e.rethrowAsIOException();
        }
    }
}
