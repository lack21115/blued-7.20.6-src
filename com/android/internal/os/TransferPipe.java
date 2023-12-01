package com.android.internal.os;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Slog;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/TransferPipe.class */
public final class TransferPipe implements Runnable {
    static final boolean DEBUG = false;
    static final long DEFAULT_TIMEOUT = 5000;
    static final String TAG = "TransferPipe";
    String mBufferPrefix;
    boolean mComplete;
    long mEndTime;
    String mFailure;
    FileDescriptor mOutFd;
    final Thread mThread = new Thread(this, TAG);
    final ParcelFileDescriptor[] mFds = ParcelFileDescriptor.createPipe();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/TransferPipe$Caller.class */
    public interface Caller {
        void go(IInterface iInterface, FileDescriptor fileDescriptor, String str, String[] strArr) throws RemoteException;
    }

    static void go(Caller caller, IInterface iInterface, FileDescriptor fileDescriptor, String str, String[] strArr) throws IOException, RemoteException {
        go(caller, iInterface, fileDescriptor, str, strArr, DEFAULT_TIMEOUT);
    }

    static void go(Caller caller, IInterface iInterface, FileDescriptor fileDescriptor, String str, String[] strArr, long j) throws IOException, RemoteException {
        if (iInterface.asBinder() instanceof Binder) {
            try {
                caller.go(iInterface, fileDescriptor, str, strArr);
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        TransferPipe transferPipe = new TransferPipe();
        try {
            caller.go(iInterface, transferPipe.getWriteFd().getFileDescriptor(), str, strArr);
            transferPipe.go(fileDescriptor, j);
        } finally {
            transferPipe.kill();
        }
    }

    static void goDump(IBinder iBinder, FileDescriptor fileDescriptor, String[] strArr) throws IOException, RemoteException {
        goDump(iBinder, fileDescriptor, strArr, DEFAULT_TIMEOUT);
    }

    static void goDump(IBinder iBinder, FileDescriptor fileDescriptor, String[] strArr, long j) throws IOException, RemoteException {
        if (iBinder instanceof Binder) {
            try {
                iBinder.dump(fileDescriptor, strArr);
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        TransferPipe transferPipe = new TransferPipe();
        try {
            iBinder.dumpAsync(transferPipe.getWriteFd().getFileDescriptor(), strArr);
            transferPipe.go(fileDescriptor, j);
        } finally {
            transferPipe.kill();
        }
    }

    void closeFd(int i) {
        if (this.mFds[i] != null) {
            try {
                this.mFds[i].close();
            } catch (IOException e) {
            }
            this.mFds[i] = null;
        }
    }

    ParcelFileDescriptor getReadFd() {
        return this.mFds[0];
    }

    public ParcelFileDescriptor getWriteFd() {
        return this.mFds[1];
    }

    public void go(FileDescriptor fileDescriptor) throws IOException {
        go(fileDescriptor, DEFAULT_TIMEOUT);
    }

    public void go(FileDescriptor fileDescriptor, long j) throws IOException {
        try {
            synchronized (this) {
                this.mOutFd = fileDescriptor;
                this.mEndTime = SystemClock.uptimeMillis() + j;
                closeFd(1);
                this.mThread.start();
                while (this.mFailure == null && !this.mComplete) {
                    long uptimeMillis = this.mEndTime - SystemClock.uptimeMillis();
                    if (uptimeMillis <= 0) {
                        this.mThread.interrupt();
                        throw new IOException("Timeout");
                    }
                    try {
                        wait(uptimeMillis);
                    } catch (InterruptedException e) {
                    }
                }
                if (this.mFailure != null) {
                    throw new IOException(this.mFailure);
                }
            }
        } finally {
            kill();
        }
    }

    public void kill() {
        synchronized (this) {
            closeFd(0);
            closeFd(1);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        byte[] bArr = new byte[1024];
        synchronized (this) {
            ParcelFileDescriptor readFd = getReadFd();
            if (readFd == null) {
                Slog.w(TAG, "Pipe has been closed...");
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(readFd.getFileDescriptor());
            FileOutputStream fileOutputStream = new FileOutputStream(this.mOutFd);
            byte[] bArr2 = null;
            boolean z = true;
            if (this.mBufferPrefix != null) {
                bArr2 = this.mBufferPrefix.getBytes();
                z = true;
            }
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        if (this.mThread.isInterrupted()) {
                        }
                        synchronized (this) {
                            this.mComplete = true;
                            notifyAll();
                        }
                        return;
                    } else if (bArr2 == null) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        int i2 = 0;
                        boolean z2 = z;
                        int i3 = 0;
                        while (i3 < read) {
                            int i4 = i3;
                            boolean z3 = z2;
                            int i5 = i2;
                            if (bArr[i3] != 10) {
                                if (i3 > i2) {
                                    fileOutputStream.write(bArr, i2, i3 - i2);
                                }
                                int i6 = i3;
                                int i7 = i3;
                                z3 = z2;
                                if (z2) {
                                    fileOutputStream.write(bArr2);
                                    z3 = false;
                                    i7 = i3;
                                }
                                do {
                                    i = i7 + 1;
                                    if (i >= read) {
                                        break;
                                    }
                                    i7 = i;
                                } while (bArr[i] != 10);
                                i4 = i;
                                i5 = i6;
                                if (i < read) {
                                    z3 = true;
                                    i5 = i6;
                                    i4 = i;
                                }
                            }
                            i3 = i4 + 1;
                            z2 = z3;
                            i2 = i5;
                        }
                        z = z2;
                        if (read > i2) {
                            fileOutputStream.write(bArr, i2, read - i2);
                            z = z2;
                        }
                    }
                } catch (IOException e) {
                    synchronized (this) {
                        this.mFailure = e.toString();
                        notifyAll();
                        return;
                    }
                }
            }
        }
    }

    public void setBufferPrefix(String str) {
        this.mBufferPrefix = str;
    }
}
