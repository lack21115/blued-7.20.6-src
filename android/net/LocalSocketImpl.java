package android.net;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/net/LocalSocketImpl.class */
public class LocalSocketImpl {
    private FileDescriptor fd;
    private SocketInputStream fis;
    private SocketOutputStream fos;
    FileDescriptor[] inboundFileDescriptors;
    private boolean mFdCreatedInternally;
    FileDescriptor[] outboundFileDescriptors;
    private Object readMonitor = new Object();
    private Object writeMonitor = new Object();
    private boolean mFdCreatedExternally = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/LocalSocketImpl$SocketInputStream.class */
    public class SocketInputStream extends InputStream {
        SocketInputStream() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            FileDescriptor fileDescriptor = LocalSocketImpl.this.fd;
            if (fileDescriptor == null) {
                throw new IOException("socket closed");
            }
            return LocalSocketImpl.this.available_native(fileDescriptor);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            LocalSocketImpl.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read_native;
            synchronized (LocalSocketImpl.this.readMonitor) {
                FileDescriptor fileDescriptor = LocalSocketImpl.this.fd;
                if (fileDescriptor == null) {
                    throw new IOException("socket closed");
                }
                read_native = LocalSocketImpl.this.read_native(fileDescriptor);
            }
            return read_native;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int readba_native;
            synchronized (LocalSocketImpl.this.readMonitor) {
                FileDescriptor fileDescriptor = LocalSocketImpl.this.fd;
                if (fileDescriptor == null) {
                    throw new IOException("socket closed");
                }
                if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                readba_native = LocalSocketImpl.this.readba_native(bArr, i, i2, fileDescriptor);
            }
            return readba_native;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/LocalSocketImpl$SocketOutputStream.class */
    public class SocketOutputStream extends OutputStream {
        SocketOutputStream() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            LocalSocketImpl.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            FileDescriptor fileDescriptor = LocalSocketImpl.this.fd;
            if (fileDescriptor == null) {
                throw new IOException("socket closed");
            }
            while (LocalSocketImpl.this.pending_native(fileDescriptor) > 0) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            synchronized (LocalSocketImpl.this.writeMonitor) {
                FileDescriptor fileDescriptor = LocalSocketImpl.this.fd;
                if (fileDescriptor == null) {
                    throw new IOException("socket closed");
                }
                LocalSocketImpl.this.write_native(i, fileDescriptor);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            synchronized (LocalSocketImpl.this.writeMonitor) {
                FileDescriptor fileDescriptor = LocalSocketImpl.this.fd;
                if (fileDescriptor == null) {
                    throw new IOException("socket closed");
                }
                if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                LocalSocketImpl.this.writeba_native(bArr, i, i2, fileDescriptor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalSocketImpl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalSocketImpl(FileDescriptor fileDescriptor) throws IOException {
        this.fd = fileDescriptor;
    }

    private native FileDescriptor accept(FileDescriptor fileDescriptor, LocalSocketImpl localSocketImpl) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    public native int available_native(FileDescriptor fileDescriptor) throws IOException;

    private native void bindLocal(FileDescriptor fileDescriptor, String str, int i) throws IOException;

    private native void connectLocal(FileDescriptor fileDescriptor, String str, int i) throws IOException;

    private native int getOption_native(FileDescriptor fileDescriptor, int i) throws IOException;

    private native Credentials getPeerCredentials_native(FileDescriptor fileDescriptor) throws IOException;

    private native void listen_native(FileDescriptor fileDescriptor, int i) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    public native int pending_native(FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    public native int read_native(FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    public native int readba_native(byte[] bArr, int i, int i2, FileDescriptor fileDescriptor) throws IOException;

    private native void setOption_native(FileDescriptor fileDescriptor, int i, int i2, int i3) throws IOException;

    private native void shutdown(FileDescriptor fileDescriptor, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void write_native(int i, FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    public native void writeba_native(byte[] bArr, int i, int i2, FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void accept(LocalSocketImpl localSocketImpl) throws IOException {
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        localSocketImpl.fd = accept(this.fd, localSocketImpl);
        localSocketImpl.mFdCreatedInternally = true;
    }

    protected int available() throws IOException {
        return getInputStream().available();
    }

    public void bind(LocalSocketAddress localSocketAddress) throws IOException {
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        bindLocal(this.fd, localSocketAddress.getName(), localSocketAddress.getNamespace().getId());
    }

    public void close() throws IOException {
        synchronized (this) {
            if (this.fd == null || !(this.mFdCreatedInternally || this.mFdCreatedExternally)) {
                this.fd = null;
                return;
            }
            try {
                Os.close(this.fd);
            } catch (ErrnoException e) {
                e.rethrowAsIOException();
            }
            this.fd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeExternalFd() throws IOException {
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        this.mFdCreatedExternally = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void connect(LocalSocketAddress localSocketAddress, int i) throws IOException {
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        connectLocal(this.fd, localSocketAddress.getName(), localSocketAddress.getNamespace().getId());
    }

    public void create(int i) throws IOException {
        int i2;
        if (this.fd == null) {
            switch (i) {
                case 1:
                    i2 = OsConstants.SOCK_DGRAM;
                    break;
                case 2:
                    i2 = OsConstants.SOCK_STREAM;
                    break;
                case 3:
                    i2 = OsConstants.SOCK_SEQPACKET;
                    break;
                default:
                    throw new IllegalStateException("unknown sockType");
            }
            try {
                this.fd = Os.socket(OsConstants.AF_UNIX, i2, 0);
                this.mFdCreatedInternally = true;
            } catch (ErrnoException e) {
                e.rethrowAsIOException();
            }
        }
    }

    protected void finalize() throws IOException {
        close();
    }

    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        FileDescriptor[] fileDescriptorArr;
        synchronized (this.readMonitor) {
            fileDescriptorArr = this.inboundFileDescriptors;
            this.inboundFileDescriptors = null;
        }
        return fileDescriptorArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FileDescriptor getFileDescriptor() {
        return this.fd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InputStream getInputStream() throws IOException {
        SocketInputStream socketInputStream;
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        synchronized (this) {
            if (this.fis == null) {
                this.fis = new SocketInputStream();
            }
            socketInputStream = this.fis;
        }
        return socketInputStream;
    }

    public Object getOption(int i) throws IOException {
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        if (i == 4102) {
            return 0;
        }
        int option_native = getOption_native(this.fd, i);
        switch (i) {
            case 4097:
            case 4098:
                return Integer.valueOf(option_native);
            default:
                return Integer.valueOf(option_native);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OutputStream getOutputStream() throws IOException {
        SocketOutputStream socketOutputStream;
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        synchronized (this) {
            if (this.fos == null) {
                this.fos = new SocketOutputStream();
            }
            socketOutputStream = this.fos;
        }
        return socketOutputStream;
    }

    public Credentials getPeerCredentials() throws IOException {
        return getPeerCredentials_native(this.fd);
    }

    public LocalSocketAddress getSockAddress() throws IOException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void listen(int i) throws IOException {
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        listen_native(this.fd, i);
    }

    protected void sendUrgentData(int i) throws IOException {
        throw new RuntimeException("not impled");
    }

    public void setFileDescriptorsForSend(FileDescriptor[] fileDescriptorArr) {
        synchronized (this.writeMonitor) {
            this.outboundFileDescriptors = fileDescriptorArr;
        }
    }

    public void setOption(int i, Object obj) throws IOException {
        int i2 = -1;
        int i3 = 0;
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        if (obj instanceof Integer) {
            i3 = ((Integer) obj).intValue();
        } else if (!(obj instanceof Boolean)) {
            throw new IOException("bad value: " + obj);
        } else {
            i2 = ((Boolean) obj).booleanValue() ? 1 : 0;
        }
        setOption_native(this.fd, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void shutdownInput() throws IOException {
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        shutdown(this.fd, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void shutdownOutput() throws IOException {
        if (this.fd == null) {
            throw new IOException("socket not created");
        }
        shutdown(this.fd, false);
    }

    protected boolean supportsUrgentData() {
        return false;
    }

    public String toString() {
        return super.toString() + " fd:" + this.fd;
    }
}
