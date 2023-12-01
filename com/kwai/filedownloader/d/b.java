package com.kwai.filedownloader.d;

import com.kwai.filedownloader.e.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/d/b.class */
public final class b implements com.kwai.filedownloader.d.a {
    private final BufferedOutputStream aJl;
    private final RandomAccessFile aJm;
    private final FileDescriptor fd;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/d/b$a.class */
    public static final class a implements c.e {
        @Override // com.kwai.filedownloader.e.c.e
        public final com.kwai.filedownloader.d.a ac(File file) {
            return new b(file);
        }
    }

    b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.aJm = randomAccessFile;
        this.fd = randomAccessFile.getFD();
        this.aJl = new BufferedOutputStream(new FileOutputStream(this.aJm.getFD()));
    }

    @Override // com.kwai.filedownloader.d.a
    public final void IX() {
        this.aJl.flush();
        this.fd.sync();
    }

    @Override // com.kwai.filedownloader.d.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.aJl.close();
        this.aJm.close();
    }

    @Override // com.kwai.filedownloader.d.a
    public final void seek(long j) {
        this.aJm.seek(j);
    }

    @Override // com.kwai.filedownloader.d.a
    public final void setLength(long j) {
        this.aJm.setLength(j);
    }

    @Override // com.kwai.filedownloader.d.a
    public final void write(byte[] bArr, int i, int i2) {
        this.aJl.write(bArr, 0, i2);
    }
}
