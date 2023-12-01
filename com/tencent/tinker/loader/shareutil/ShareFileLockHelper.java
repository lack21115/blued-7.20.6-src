package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareFileLockHelper.class */
public class ShareFileLockHelper implements Closeable {
    public static final int LOCK_WAIT_EACH_TIME = 10;
    public static final int MAX_LOCK_ATTEMPTS = 3;
    private static final String TAG = "Tinker.FileLockHelper";
    private final FileLock fileLock;
    private final FileOutputStream outputStream;

    private ShareFileLockHelper(File file) throws IOException {
        FileLock fileLock;
        this.outputStream = new FileOutputStream(file);
        FileLock fileLock2 = null;
        Exception exc = null;
        int i = 0;
        while (true) {
            int i2 = i;
            fileLock = fileLock2;
            if (i2 >= 3) {
                break;
            }
            int i3 = i2 + 1;
            try {
                fileLock = this.outputStream.getChannel().lock();
                fileLock2 = fileLock;
                e = exc;
                if (fileLock != null) {
                    break;
                }
            } catch (Exception e) {
                e = e;
                ShareTinkerLog.e(TAG, "getInfoLock Thread failed time:10", new Object[0]);
            }
            try {
                Thread.sleep(10L);
                exc = e;
                i = i3;
            } catch (Exception e2) {
                ShareTinkerLog.e(TAG, "getInfoLock Thread sleep exception", e2);
                exc = e;
                i = i3;
            }
        }
        if (fileLock != null) {
            this.fileLock = fileLock;
            return;
        }
        throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + file.getAbsolutePath(), exc);
    }

    public static ShareFileLockHelper getFileLock(File file) throws IOException {
        return new ShareFileLockHelper(file);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (this.fileLock != null) {
                this.fileLock.release();
            }
        } finally {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
