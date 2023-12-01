package com.kwad.sdk.core.videocache.kwai;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/kwai/b.class */
public final class b implements com.kwad.sdk.core.videocache.a {
    private final a anv;
    private RandomAccessFile aoj;
    public File file;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.anv = aVar;
            d.p(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.file = file2;
            this.aoj = new RandomAccessFile(this.file, exists ? "r" : "rw");
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }

    private static boolean o(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final int a(byte[] bArr, long j, int i) {
        int read;
        synchronized (this) {
            try {
                this.aoj.seek(j);
                read = this.aoj.read(bArr, 0, i);
            } catch (IOException e) {
                throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(yw()), Integer.valueOf(bArr.length)), e);
            }
        }
        return read;
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final void close() {
        synchronized (this) {
            try {
                this.aoj.close();
                this.anv.n(this.file);
            } catch (IOException e) {
                throw new ProxyCacheException("Error closing file " + this.file, e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final void complete() {
        synchronized (this) {
            if (isCompleted()) {
                return;
            }
            close();
            File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
            if (!this.file.renameTo(file)) {
                throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
            }
            this.file = file;
            try {
                this.aoj = new RandomAccessFile(this.file, "r");
                this.anv.n(this.file);
            } catch (IOException e) {
                throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final void d(byte[] bArr, int i) {
        synchronized (this) {
            try {
                if (isCompleted()) {
                    throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
                }
                this.aoj.seek(yw());
                this.aoj.write(bArr, 0, i);
            } catch (IOException e) {
                throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.aoj, 8192), e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final boolean isCompleted() {
        boolean z;
        synchronized (this) {
            z = !o(this.file);
        }
        return z;
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final long yw() {
        long length;
        synchronized (this) {
            try {
                length = (int) this.aoj.length();
            } catch (IOException e) {
                throw new ProxyCacheException("Error reading length of file " + this.file, e);
            }
        }
        return length;
    }
}
