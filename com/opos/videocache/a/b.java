package com.opos.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/b.class */
public class b implements com.opos.videocache.a {

    /* renamed from: a  reason: collision with root package name */
    public File f27429a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f27430c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.b = aVar;
            h.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                File parentFile = file.getParentFile();
                file2 = new File(parentFile, file.getName() + ".download");
            }
            this.f27429a = file2;
            this.f27430c = new RandomAccessFile(this.f27429a, exists ? "r" : "rw");
        } catch (IOException e) {
            throw new com.opos.videocache.g("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.opos.videocache.a
    public int a(byte[] bArr, long j, int i) {
        int read;
        synchronized (this) {
            try {
                this.f27430c.seek(j);
                read = this.f27430c.read(bArr, 0, i);
            } catch (IOException e) {
                throw new com.opos.videocache.g(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
            }
        }
        return read;
    }

    @Override // com.opos.videocache.a
    public long a() {
        long length;
        synchronized (this) {
            try {
                length = (int) this.f27430c.length();
            } catch (IOException e) {
                throw new com.opos.videocache.g("Error reading length of file " + this.f27429a, e);
            }
        }
        return length;
    }

    @Override // com.opos.videocache.a
    public void a(byte[] bArr, int i) {
        synchronized (this) {
            try {
                if (d()) {
                    throw new com.opos.videocache.g("Error append cache: cache file " + this.f27429a + " is completed!");
                }
                this.f27430c.seek(a());
                this.f27430c.write(bArr, 0, i);
            } catch (IOException e) {
                throw new com.opos.videocache.g(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.f27430c, Integer.valueOf(bArr.length)), e);
            }
        }
    }

    @Override // com.opos.videocache.a
    public void b() {
        synchronized (this) {
            try {
                this.f27430c.close();
                this.b.a(this.f27429a);
            } catch (IOException e) {
                throw new com.opos.videocache.g("Error closing file " + this.f27429a, e);
            }
        }
    }

    @Override // com.opos.videocache.a
    public void c() {
        synchronized (this) {
            if (!d()) {
                b();
                File file = new File(this.f27429a.getParentFile(), this.f27429a.getName().substring(0, this.f27429a.getName().length() - 9));
                if (!this.f27429a.renameTo(file)) {
                    com.opos.cmn.an.f.a.a("FileCache", "Error renaming file " + this.f27429a + " to " + file + " for completion!");
                    throw new com.opos.videocache.g("Error renaming file " + this.f27429a + " to " + file + " for completion!");
                }
                if (!this.f27429a.delete()) {
                    com.opos.cmn.an.f.a.a("FileCache", "delete .download cache file fail!");
                }
                this.f27429a = file;
                try {
                    this.f27430c = new RandomAccessFile(this.f27429a, "r");
                    this.b.a(this.f27429a);
                } catch (IOException e) {
                    com.opos.cmn.an.f.a.a("FileCache", "Error opening " + this.f27429a + " as disc cache", (Throwable) e);
                    throw new com.opos.videocache.g("Error opening " + this.f27429a + " as disc cache", e);
                }
            }
        }
    }

    @Override // com.opos.videocache.a
    public boolean d() {
        boolean a2;
        synchronized (this) {
            a2 = a(this.f27429a);
        }
        return !a2;
    }
}
