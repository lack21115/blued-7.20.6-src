package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/model/RandomAccessOutputStream.class */
public class RandomAccessOutputStream implements Closeable {
    private static final int MAX_FLUSH_BUFFER_SIZE = 131072;
    private static final int MIN_FLUSH_BUFFER_SIZE = 8192;
    private FileDescriptor fd;
    private BufferedOutputStream outputStream;
    private RandomAccessFile randomAccess;

    public RandomAccessOutputStream(File file, int i) throws BaseException {
        int i2;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.randomAccess = randomAccessFile;
            this.fd = randomAccessFile.getFD();
            if (i <= 0) {
                this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()));
                return;
            }
            if (i < 8192) {
                i2 = 8192;
            } else {
                i2 = i;
                if (i > 131072) {
                    i2 = 131072;
                }
            }
            this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()), i2);
        } catch (IOException e) {
            throw new BaseException((int) DownloadErrorCode.ERROR_OUTPUT_STREAM_CREATE_IO, e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        DownloadUtils.safeClose(this.randomAccess, this.outputStream);
    }

    public void flush() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.outputStream;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void flushAndSync() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.outputStream;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.fd;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void seek(long j) throws IOException {
        this.randomAccess.seek(j);
    }

    public void setLength(long j) throws IOException {
        this.randomAccess.setLength(j);
    }

    public void sync() throws IOException {
        FileDescriptor fileDescriptor = this.fd;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.outputStream.write(bArr, i, i2);
    }
}
