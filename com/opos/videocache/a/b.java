package com.opos.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/b.class */
public class b implements com.opos.videocache.a {

    /* renamed from: a  reason: collision with root package name */
    public File f13741a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f13742c;

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
            this.f13741a = file2;
            this.f13742c = new RandomAccessFile(this.f13741a, exists ? "r" : "rw");
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
                this.f13742c.seek(j);
                read = this.f13742c.read(bArr, 0, i);
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
                length = (int) this.f13742c.length();
            } catch (IOException e) {
                throw new com.opos.videocache.g("Error reading length of file " + this.f13741a, e);
            }
        }
        return length;
    }

    @Override // com.opos.videocache.a
    public void a(byte[] bArr, int i) {
        synchronized (this) {
            try {
                if (d()) {
                    throw new com.opos.videocache.g("Error append cache: cache file " + this.f13741a + " is completed!");
                }
                this.f13742c.seek(a());
                this.f13742c.write(bArr, 0, i);
            } catch (IOException e) {
                throw new com.opos.videocache.g(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.f13742c, Integer.valueOf(bArr.length)), e);
            }
        }
    }

    @Override // com.opos.videocache.a
    public void b() {
        synchronized (this) {
            try {
                this.f13742c.close();
                this.b.a(this.f13741a);
            } catch (IOException e) {
                throw new com.opos.videocache.g("Error closing file " + this.f13741a, e);
            }
        }
    }

    @Override // com.opos.videocache.a
    public void c() {
        synchronized (this) {
            if (!d()) {
                b();
                File file = new File(this.f13741a.getParentFile(), this.f13741a.getName().substring(0, this.f13741a.getName().length() - 9));
                if (!this.f13741a.renameTo(file)) {
                    com.opos.cmn.an.f.a.a("FileCache", "Error renaming file " + this.f13741a + " to " + file + " for completion!");
                    throw new com.opos.videocache.g("Error renaming file " + this.f13741a + " to " + file + " for completion!");
                }
                if (!this.f13741a.delete()) {
                    com.opos.cmn.an.f.a.a("FileCache", "delete .download cache file fail!");
                }
                this.f13741a = file;
                try {
                    this.f13742c = new RandomAccessFile(this.f13741a, "r");
                    this.b.a(this.f13741a);
                } catch (IOException e) {
                    com.opos.cmn.an.f.a.a("FileCache", "Error opening " + this.f13741a + " as disc cache", (Throwable) e);
                    throw new com.opos.videocache.g("Error opening " + this.f13741a + " as disc cache", e);
                }
            }
        }
    }

    @Override // com.opos.videocache.a
    public boolean d() {
        boolean a2;
        synchronized (this) {
            a2 = a(this.f13741a);
        }
        return !a2;
    }
}
