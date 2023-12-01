package com.opos.mobad.i.a;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a/e.class */
public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f12528a;
    private FileChannel b;

    /* renamed from: c  reason: collision with root package name */
    private FileLock f12529c;

    public e(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f12528a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "FileLockEngine", (Throwable) e);
        }
    }

    public e(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f12528a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "FileLockEngine", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.i.a.f
    public boolean a() {
        boolean z;
        FileChannel fileChannel = this.b;
        if (fileChannel != null) {
            try {
                this.f12529c = fileChannel.lock();
                z = true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("FileLockEngine", "acquireFileLock", (Throwable) e);
            }
            com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
        return z;
    }

    @Override // com.opos.mobad.i.a.f
    public void b() {
        try {
            if (this.f12529c != null) {
                this.f12529c.release();
            }
            if (this.b != null) {
                this.b.close();
            }
            if (this.f12528a != null) {
                this.f12528a.close();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "releaseFileLock", (Throwable) e);
        }
    }
}
