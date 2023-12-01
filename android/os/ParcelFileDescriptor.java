package android.os;

import android.os.Parcelable;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;
import com.alipay.sdk.util.i;
import com.anythink.expressad.d.a.b;
import com.baidu.mobads.sdk.api.IAdInterListener;
import dalvik.system.CloseGuard;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramSocket;
import java.net.Socket;
import java.nio.ByteOrder;
import libcore.io.IoUtils;
import libcore.io.Memory;

/* loaded from: source-9557208-dex2jar.jar:android/os/ParcelFileDescriptor.class */
public class ParcelFileDescriptor implements Parcelable, Closeable {
    public static final Parcelable.Creator<ParcelFileDescriptor> CREATOR = new Parcelable.Creator<ParcelFileDescriptor>() { // from class: android.os.ParcelFileDescriptor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelFileDescriptor createFromParcel(Parcel parcel) {
            FileDescriptor readRawFileDescriptor = parcel.readRawFileDescriptor();
            FileDescriptor fileDescriptor = null;
            if (parcel.readInt() != 0) {
                fileDescriptor = parcel.readRawFileDescriptor();
            }
            return new ParcelFileDescriptor(readRawFileDescriptor, fileDescriptor);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelFileDescriptor[] newArray(int i) {
            return new ParcelFileDescriptor[i];
        }
    };
    private static final int MAX_STATUS = 1024;
    public static final int MODE_APPEND = 33554432;
    public static final int MODE_CREATE = 134217728;
    public static final int MODE_READ_ONLY = 268435456;
    public static final int MODE_READ_WRITE = 805306368;
    public static final int MODE_TRUNCATE = 67108864;
    @Deprecated
    public static final int MODE_WORLD_READABLE = 1;
    @Deprecated
    public static final int MODE_WORLD_WRITEABLE = 2;
    public static final int MODE_WRITE_ONLY = 536870912;
    private static final String TAG = "ParcelFileDescriptor";
    private volatile boolean mClosed;
    private FileDescriptor mCommFd;
    private final FileDescriptor mFd;
    private final CloseGuard mGuard;
    private Status mStatus;
    private byte[] mStatusBuf;
    private final ParcelFileDescriptor mWrapped;

    /* loaded from: source-9557208-dex2jar.jar:android/os/ParcelFileDescriptor$AutoCloseInputStream.class */
    public static class AutoCloseInputStream extends FileInputStream {
        private final ParcelFileDescriptor mPfd;

        public AutoCloseInputStream(ParcelFileDescriptor parcelFileDescriptor) {
            super(parcelFileDescriptor.getFileDescriptor());
            this.mPfd = parcelFileDescriptor;
        }

        @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.mPfd.close();
            } finally {
                super.close();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/ParcelFileDescriptor$AutoCloseOutputStream.class */
    public static class AutoCloseOutputStream extends FileOutputStream {
        private final ParcelFileDescriptor mPfd;

        public AutoCloseOutputStream(ParcelFileDescriptor parcelFileDescriptor) {
            super(parcelFileDescriptor.getFileDescriptor());
            this.mPfd = parcelFileDescriptor;
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.mPfd.close();
            } finally {
                super.close();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/ParcelFileDescriptor$FileDescriptorDetachedException.class */
    public static class FileDescriptorDetachedException extends IOException {
        private static final long serialVersionUID = 955542466045L;

        public FileDescriptorDetachedException() {
            super("Remote side is detached");
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/ParcelFileDescriptor$ListenerBridge.class */
    private static final class ListenerBridge extends Thread {
        private FileDescriptor mCommFd;
        private final Handler mHandler;

        public ListenerBridge(FileDescriptor fileDescriptor, Looper looper, final OnCloseListener onCloseListener) {
            this.mCommFd = fileDescriptor;
            this.mHandler = new Handler(looper) { // from class: android.os.ParcelFileDescriptor.ListenerBridge.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Status status = (Status) message.obj;
                    onCloseListener.onClose(status != null ? status.asIOException() : null);
                }
            };
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.mHandler.obtainMessage(0, ParcelFileDescriptor.readCommStatus(this.mCommFd, new byte[1024])).sendToTarget();
            } finally {
                IoUtils.closeQuietly(this.mCommFd);
                this.mCommFd = null;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/os/ParcelFileDescriptor$OnCloseListener.class */
    public interface OnCloseListener {
        void onClose(IOException iOException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/ParcelFileDescriptor$Status.class */
    public static class Status {
        public static final int DEAD = -2;
        public static final int DETACHED = 2;
        public static final int ERROR = 1;
        public static final int LEAKED = 3;
        public static final int OK = 0;
        public static final int SILENCE = -1;
        public final String msg;
        public final int status;

        public Status(int i) {
            this(i, null);
        }

        public Status(int i, String str) {
            this.status = i;
            this.msg = str;
        }

        public IOException asIOException() {
            switch (this.status) {
                case -2:
                    return new IOException("Remote side is dead");
                case -1:
                default:
                    return new IOException("Unknown status: " + this.status);
                case 0:
                    return null;
                case 1:
                    return new IOException("Remote error: " + this.msg);
                case 2:
                    return new FileDescriptorDetachedException();
                case 3:
                    return new IOException("Remote side was leaked");
            }
        }
    }

    public ParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        this.mGuard = CloseGuard.get();
        this.mWrapped = parcelFileDescriptor;
        this.mFd = null;
        this.mCommFd = null;
        this.mClosed = true;
    }

    public ParcelFileDescriptor(FileDescriptor fileDescriptor) {
        this(fileDescriptor, null);
    }

    public ParcelFileDescriptor(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2) {
        this.mGuard = CloseGuard.get();
        if (fileDescriptor == null) {
            throw new NullPointerException("FileDescriptor must not be null");
        }
        this.mWrapped = null;
        this.mFd = fileDescriptor;
        this.mCommFd = fileDescriptor2;
        this.mGuard.open("close");
    }

    public static ParcelFileDescriptor adoptFd(int i) {
        FileDescriptor fileDescriptor = new FileDescriptor();
        fileDescriptor.setInt$(i);
        return new ParcelFileDescriptor(fileDescriptor);
    }

    private void closeWithStatus(int i, String str) {
        if (this.mClosed) {
            return;
        }
        this.mClosed = true;
        this.mGuard.close();
        writeCommStatusAndClose(i, str);
        IoUtils.closeQuietly(this.mFd);
        releaseResources();
    }

    private static FileDescriptor[] createCommSocketPair() throws IOException {
        try {
            FileDescriptor fileDescriptor = new FileDescriptor();
            FileDescriptor fileDescriptor2 = new FileDescriptor();
            Os.socketpair(OsConstants.AF_UNIX, OsConstants.SOCK_STREAM, 0, fileDescriptor, fileDescriptor2);
            IoUtils.setBlocking(fileDescriptor, false);
            IoUtils.setBlocking(fileDescriptor2, false);
            return new FileDescriptor[]{fileDescriptor, fileDescriptor2};
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public static ParcelFileDescriptor[] createPipe() throws IOException {
        try {
            FileDescriptor[] pipe = Os.pipe();
            return new ParcelFileDescriptor[]{new ParcelFileDescriptor(pipe[0]), new ParcelFileDescriptor(pipe[1])};
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public static ParcelFileDescriptor[] createReliablePipe() throws IOException {
        try {
            FileDescriptor[] createCommSocketPair = createCommSocketPair();
            FileDescriptor[] pipe = Os.pipe();
            return new ParcelFileDescriptor[]{new ParcelFileDescriptor(pipe[0], createCommSocketPair[0]), new ParcelFileDescriptor(pipe[1], createCommSocketPair[1])};
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public static ParcelFileDescriptor[] createReliableSocketPair() throws IOException {
        try {
            FileDescriptor[] createCommSocketPair = createCommSocketPair();
            FileDescriptor fileDescriptor = new FileDescriptor();
            FileDescriptor fileDescriptor2 = new FileDescriptor();
            Os.socketpair(OsConstants.AF_UNIX, OsConstants.SOCK_STREAM, 0, fileDescriptor, fileDescriptor2);
            return new ParcelFileDescriptor[]{new ParcelFileDescriptor(fileDescriptor, createCommSocketPair[0]), new ParcelFileDescriptor(fileDescriptor2, createCommSocketPair[1])};
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public static ParcelFileDescriptor[] createSocketPair() throws IOException {
        try {
            FileDescriptor fileDescriptor = new FileDescriptor();
            FileDescriptor fileDescriptor2 = new FileDescriptor();
            Os.socketpair(OsConstants.AF_UNIX, OsConstants.SOCK_STREAM, 0, fileDescriptor, fileDescriptor2);
            return new ParcelFileDescriptor[]{new ParcelFileDescriptor(fileDescriptor), new ParcelFileDescriptor(fileDescriptor2)};
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public static ParcelFileDescriptor dup(FileDescriptor fileDescriptor) throws IOException {
        try {
            return new ParcelFileDescriptor(Os.dup(fileDescriptor));
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    @Deprecated
    public static ParcelFileDescriptor fromData(byte[] bArr, String str) throws IOException {
        if (bArr == null) {
            return null;
        }
        MemoryFile memoryFile = new MemoryFile(str, bArr.length);
        if (bArr.length > 0) {
            memoryFile.writeBytes(bArr, 0, 0, bArr.length);
        }
        memoryFile.deactivate();
        FileDescriptor fileDescriptor = memoryFile.getFileDescriptor();
        if (fileDescriptor != null) {
            return new ParcelFileDescriptor(fileDescriptor);
        }
        return null;
    }

    public static ParcelFileDescriptor fromDatagramSocket(DatagramSocket datagramSocket) {
        FileDescriptor fileDescriptor$ = datagramSocket.getFileDescriptor$();
        if (fileDescriptor$ != null) {
            return new ParcelFileDescriptor(fileDescriptor$);
        }
        return null;
    }

    public static ParcelFileDescriptor fromFd(int i) throws IOException {
        FileDescriptor fileDescriptor = new FileDescriptor();
        fileDescriptor.setInt$(i);
        try {
            return new ParcelFileDescriptor(Os.dup(fileDescriptor));
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public static ParcelFileDescriptor fromSocket(Socket socket) {
        FileDescriptor fileDescriptor$ = socket.getFileDescriptor$();
        if (fileDescriptor$ != null) {
            return new ParcelFileDescriptor(fileDescriptor$);
        }
        return null;
    }

    private byte[] getOrCreateStatusBuffer() {
        if (this.mStatusBuf == null) {
            this.mStatusBuf = new byte[1024];
        }
        return this.mStatusBuf;
    }

    public static ParcelFileDescriptor open(File file, int i) throws FileNotFoundException {
        FileDescriptor openInternal = openInternal(file, i);
        if (openInternal == null) {
            return null;
        }
        return new ParcelFileDescriptor(openInternal);
    }

    public static ParcelFileDescriptor open(File file, int i, Handler handler, OnCloseListener onCloseListener) throws IOException {
        if (handler == null) {
            throw new IllegalArgumentException("Handler must not be null");
        }
        if (onCloseListener == null) {
            throw new IllegalArgumentException("Listener must not be null");
        }
        FileDescriptor openInternal = openInternal(file, i);
        if (openInternal == null) {
            return null;
        }
        FileDescriptor[] createCommSocketPair = createCommSocketPair();
        ParcelFileDescriptor parcelFileDescriptor = new ParcelFileDescriptor(openInternal, createCommSocketPair[0]);
        IoUtils.setBlocking(createCommSocketPair[1], true);
        new ListenerBridge(createCommSocketPair[1], handler.getLooper(), onCloseListener).start();
        return parcelFileDescriptor;
    }

    private static FileDescriptor openInternal(File file, int i) throws FileNotFoundException {
        if ((805306368 & i) == 0) {
            throw new IllegalArgumentException("Must specify MODE_READ_ONLY, MODE_WRITE_ONLY, or MODE_READ_WRITE");
        }
        return Parcel.openFileDescriptor(file.getPath(), i);
    }

    public static int parseMode(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if (IAdInterListener.AdReqParam.WIDTH.equals(str) || b.R.equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Bad mode '" + str + "'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status readCommStatus(FileDescriptor fileDescriptor, byte[] bArr) {
        try {
            int read = Os.read(fileDescriptor, bArr, 0, bArr.length);
            if (read == 0) {
                return new Status(-2);
            }
            int peekInt = Memory.peekInt(bArr, 0, ByteOrder.BIG_ENDIAN);
            return peekInt == 1 ? new Status(peekInt, new String(bArr, 4, read - 4)) : new Status(peekInt);
        } catch (ErrnoException e) {
            if (e.errno == OsConstants.EAGAIN) {
                return null;
            }
            Log.d(TAG, "Failed to read status; assuming dead: " + e);
            return new Status(-2);
        } catch (InterruptedIOException e2) {
            Log.d(TAG, "Failed to read status; assuming dead: " + e2);
            return new Status(-2);
        }
    }

    private void writeCommStatusAndClose(int i, String str) {
        if (this.mCommFd == null) {
            if (str != null) {
                Log.w(TAG, "Unable to inform peer: " + str);
                return;
            }
            return;
        }
        if (i == 2) {
            Log.w(TAG, "Peer expected signal when closed; unable to deliver after detach");
        }
        if (i == -1) {
            return;
        }
        try {
            this.mStatus = readCommStatus(this.mCommFd, getOrCreateStatusBuffer());
            if (this.mStatus != null) {
                return;
            }
            try {
                try {
                    byte[] orCreateStatusBuffer = getOrCreateStatusBuffer();
                    Memory.pokeInt(orCreateStatusBuffer, 0, i, ByteOrder.BIG_ENDIAN);
                    int i2 = 0 + 4;
                    int i3 = i2;
                    if (str != null) {
                        byte[] bytes = str.getBytes();
                        int min = Math.min(bytes.length, orCreateStatusBuffer.length - 4);
                        System.arraycopy(bytes, 0, orCreateStatusBuffer, i2, min);
                        i3 = min + 4;
                    }
                    Os.write(this.mCommFd, orCreateStatusBuffer, 0, i3);
                } catch (InterruptedIOException e) {
                    Log.w(TAG, "Failed to report status: " + e);
                }
            } catch (ErrnoException e2) {
                Log.w(TAG, "Failed to report status: " + e2);
            }
        } finally {
            IoUtils.closeQuietly(this.mCommFd);
            this.mCommFd = null;
        }
    }

    public boolean canDetectErrors() {
        return this.mWrapped != null ? this.mWrapped.canDetectErrors() : this.mCommFd != null;
    }

    public void checkError() throws IOException {
        if (this.mWrapped != null) {
            this.mWrapped.checkError();
            return;
        }
        if (this.mStatus == null) {
            if (this.mCommFd == null) {
                Log.w(TAG, "Peer didn't provide a comm channel; unable to check for errors");
                return;
            }
            this.mStatus = readCommStatus(this.mCommFd, getOrCreateStatusBuffer());
        }
        if (this.mStatus != null && this.mStatus.status != 0) {
            throw this.mStatus.asIOException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mWrapped == null) {
            closeWithStatus(0, null);
            return;
        }
        try {
            this.mWrapped.close();
        } finally {
            releaseResources();
        }
    }

    public void closeWithError(String str) throws IOException {
        if (this.mWrapped != null) {
            try {
                this.mWrapped.closeWithError(str);
            } finally {
                releaseResources();
            }
        } else if (str == null) {
            throw new IllegalArgumentException("Message must not be null");
        } else {
            closeWithStatus(1, str);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        if (this.mWrapped != null) {
            return this.mWrapped.describeContents();
        }
        return 1;
    }

    public int detachFd() {
        if (this.mWrapped != null) {
            return this.mWrapped.detachFd();
        }
        if (this.mClosed) {
            throw new IllegalStateException("Already closed");
        }
        int fd = getFd();
        Parcel.clearFileDescriptor(this.mFd);
        writeCommStatusAndClose(2, null);
        return fd;
    }

    public ParcelFileDescriptor dup() throws IOException {
        return this.mWrapped != null ? this.mWrapped.dup() : dup(getFileDescriptor());
    }

    protected void finalize() throws Throwable {
        if (this.mWrapped != null) {
            releaseResources();
        }
        if (this.mGuard != null) {
            this.mGuard.warnIfOpen();
        }
        try {
            if (!this.mClosed) {
                closeWithStatus(3, null);
            }
        } finally {
            super.finalize();
        }
    }

    public int getFd() {
        if (this.mWrapped != null) {
            return this.mWrapped.getFd();
        }
        if (this.mClosed) {
            throw new IllegalStateException("Already closed");
        }
        return this.mFd.getInt$();
    }

    public FileDescriptor getFileDescriptor() {
        return this.mWrapped != null ? this.mWrapped.getFileDescriptor() : this.mFd;
    }

    public long getStatSize() {
        long j = -1;
        if (this.mWrapped != null) {
            j = this.mWrapped.getStatSize();
        } else {
            try {
                StructStat fstat = Os.fstat(this.mFd);
                if (OsConstants.S_ISREG(fstat.st_mode) || OsConstants.S_ISLNK(fstat.st_mode)) {
                    return fstat.st_size;
                }
            } catch (ErrnoException e) {
                Log.w(TAG, "fstat() failed: " + e);
                return -1L;
            }
        }
        return j;
    }

    public void releaseResources() {
    }

    public long seekTo(long j) throws IOException {
        if (this.mWrapped != null) {
            return this.mWrapped.seekTo(j);
        }
        try {
            return Os.lseek(this.mFd, j, OsConstants.SEEK_SET);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    public String toString() {
        return this.mWrapped != null ? this.mWrapped.toString() : "{ParcelFileDescriptor: " + this.mFd + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.mWrapped != null) {
            try {
                this.mWrapped.writeToParcel(parcel, i);
                return;
            } finally {
                releaseResources();
            }
        }
        parcel.writeFileDescriptor(this.mFd);
        if (this.mCommFd != null) {
            parcel.writeInt(1);
            parcel.writeFileDescriptor(this.mCommFd);
        } else {
            parcel.writeInt(0);
        }
        if ((i & 1) == 0 || this.mClosed) {
            return;
        }
        closeWithStatus(-1, null);
    }
}
