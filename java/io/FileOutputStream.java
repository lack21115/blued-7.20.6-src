package java.io;

import android.system.OsConstants;
import com.blued.android.module.common.web.LoaderConstants;
import dalvik.system.CloseGuard;
import java.nio.NioUtils;
import java.nio.channels.FileChannel;
import libcore.io.IoBridge;

/* loaded from: source-2895416-dex2jar.jar:java/io/FileOutputStream.class */
public class FileOutputStream extends OutputStream {
    private FileChannel channel;
    private FileDescriptor fd;
    private final CloseGuard guard;
    private final int mode;
    private final boolean shouldClose;

    public FileOutputStream(File file) throws FileNotFoundException {
        this(file, false);
    }

    public FileOutputStream(File file, boolean z) throws FileNotFoundException {
        this.guard = CloseGuard.get();
        if (file == null) {
            throw new NullPointerException("file == null");
        }
        int i = OsConstants.O_WRONLY;
        this.mode = (z ? OsConstants.O_APPEND : OsConstants.O_TRUNC) | OsConstants.O_CREAT | i;
        this.fd = IoBridge.open(file.getPath(), this.mode);
        this.shouldClose = true;
        this.guard.open(LoaderConstants.CLOSE);
    }

    public FileOutputStream(FileDescriptor fileDescriptor) {
        this.guard = CloseGuard.get();
        if (fileDescriptor == null) {
            throw new NullPointerException("fd == null");
        }
        this.fd = fileDescriptor;
        this.shouldClose = false;
        this.mode = OsConstants.O_WRONLY;
        this.channel = NioUtils.newFileChannel(this, fileDescriptor, this.mode);
    }

    public FileOutputStream(String str) throws FileNotFoundException {
        this(str, false);
    }

    public FileOutputStream(String str, boolean z) throws FileNotFoundException {
        this(new File(str), z);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
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
                this.channel = NioUtils.newFileChannel(this, this.fd, this.mode);
            }
            fileChannel = this.channel;
        }
        return fileChannel;
    }

    public final FileDescriptor getFD() throws IOException {
        return this.fd;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        IoBridge.write(this.fd, bArr, i, i2);
    }
}
