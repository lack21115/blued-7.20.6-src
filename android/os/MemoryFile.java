package android.os;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: source-9557208-dex2jar.jar:android/os/MemoryFile.class */
public class MemoryFile {
    private static final int PROT_READ = 1;
    private static final int PROT_WRITE = 2;
    private static String TAG = "MemoryFile";
    private long mAddress;
    private boolean mAllowPurging = false;
    private FileDescriptor mFD;
    private int mLength;

    /* loaded from: source-9557208-dex2jar.jar:android/os/MemoryFile$MemoryInputStream.class */
    private class MemoryInputStream extends InputStream {
        private int mMark;
        private int mOffset;
        private byte[] mSingleByte;

        private MemoryInputStream() {
            this.mMark = 0;
            this.mOffset = 0;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (this.mOffset >= MemoryFile.this.mLength) {
                return 0;
            }
            return MemoryFile.this.mLength - this.mOffset;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.mMark = this.mOffset;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.mSingleByte == null) {
                this.mSingleByte = new byte[1];
            }
            if (read(this.mSingleByte, 0, 1) != 1) {
                return -1;
            }
            return this.mSingleByte[0];
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            int min = Math.min(i2, available());
            if (min < 1) {
                i3 = -1;
            } else {
                int readBytes = MemoryFile.this.readBytes(bArr, this.mOffset, i, min);
                i3 = readBytes;
                if (readBytes > 0) {
                    this.mOffset += readBytes;
                    return readBytes;
                }
            }
            return i3;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            this.mOffset = this.mMark;
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = j;
            if (this.mOffset + j > MemoryFile.this.mLength) {
                j2 = MemoryFile.this.mLength - this.mOffset;
            }
            this.mOffset = (int) (this.mOffset + j2);
            return j2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/MemoryFile$MemoryOutputStream.class */
    private class MemoryOutputStream extends OutputStream {
        private int mOffset;
        private byte[] mSingleByte;

        private MemoryOutputStream() {
            this.mOffset = 0;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.mSingleByte == null) {
                this.mSingleByte = new byte[1];
            }
            this.mSingleByte[0] = (byte) i;
            write(this.mSingleByte, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            MemoryFile.this.writeBytes(bArr, i, this.mOffset, i2);
            this.mOffset += i2;
        }
    }

    public MemoryFile(String str, int i) throws IOException {
        this.mLength = i;
        if (i < 0) {
            throw new IOException("Invalid length: " + i);
        }
        this.mFD = native_open(str, i);
        if (i > 0) {
            this.mAddress = native_mmap(this.mFD, i, 3);
        } else {
            this.mAddress = 0L;
        }
    }

    public static int getSize(FileDescriptor fileDescriptor) throws IOException {
        return native_get_size(fileDescriptor);
    }

    private boolean isClosed() {
        return !this.mFD.valid();
    }

    private boolean isDeactivated() {
        return this.mAddress == 0;
    }

    private static native void native_close(FileDescriptor fileDescriptor);

    private static native int native_get_size(FileDescriptor fileDescriptor) throws IOException;

    private static native long native_mmap(FileDescriptor fileDescriptor, int i, int i2) throws IOException;

    private static native void native_munmap(long j, int i) throws IOException;

    private static native FileDescriptor native_open(String str, int i) throws IOException;

    private static native void native_pin(FileDescriptor fileDescriptor, boolean z) throws IOException;

    private static native int native_read(FileDescriptor fileDescriptor, long j, byte[] bArr, int i, int i2, int i3, boolean z) throws IOException;

    private static native void native_write(FileDescriptor fileDescriptor, long j, byte[] bArr, int i, int i2, int i3, boolean z) throws IOException;

    public boolean allowPurging(boolean z) throws IOException {
        boolean z2;
        synchronized (this) {
            z2 = this.mAllowPurging;
            if (z2 != z) {
                native_pin(this.mFD, !z);
                this.mAllowPurging = z;
            }
        }
        return z2;
    }

    public void close() {
        deactivate();
        if (isClosed()) {
            return;
        }
        native_close(this.mFD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deactivate() {
        if (isDeactivated()) {
            return;
        }
        try {
            native_munmap(this.mAddress, this.mLength);
            this.mAddress = 0L;
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }
    }

    protected void finalize() {
        if (isClosed()) {
            return;
        }
        Log.e(TAG, "MemoryFile.finalize() called while ashmem still open");
        close();
    }

    public FileDescriptor getFileDescriptor() throws IOException {
        return this.mFD;
    }

    public InputStream getInputStream() {
        return new MemoryInputStream();
    }

    public OutputStream getOutputStream() {
        return new MemoryOutputStream();
    }

    public boolean isPurgingAllowed() {
        return this.mAllowPurging;
    }

    public int length() {
        return this.mLength;
    }

    public int readBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
        if (isDeactivated()) {
            throw new IOException("Can't read from deactivated memory file.");
        }
        if (i2 < 0 || i2 > bArr.length || i3 < 0 || i3 > bArr.length - i2 || i < 0 || i > this.mLength || i3 > this.mLength - i) {
            throw new IndexOutOfBoundsException();
        }
        return native_read(this.mFD, this.mAddress, bArr, i, i2, i3, this.mAllowPurging);
    }

    public void writeBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
        if (isDeactivated()) {
            throw new IOException("Can't write to deactivated memory file.");
        }
        if (i < 0 || i > bArr.length || i3 < 0 || i3 > bArr.length - i || i2 < 0 || i2 > this.mLength || i3 > this.mLength - i2) {
            throw new IndexOutOfBoundsException();
        }
        native_write(this.mFD, this.mAddress, bArr, i, i2, i3, this.mAllowPurging);
    }
}
