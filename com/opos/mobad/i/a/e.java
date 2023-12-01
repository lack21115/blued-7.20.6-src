package com.opos.mobad.i.a;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a/e.class */
public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f26216a;
    private FileChannel b;

    /* renamed from: c  reason: collision with root package name */
    private FileLock f26217c;

    public e(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f26216a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "FileLockEngine", (Throwable) e);
        }
    }

    public e(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f26216a = randomAccessFile;
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
                this.f26217c = fileChannel.lock();
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
            if (this.f26217c != null) {
                this.f26217c.release();
            }
            if (this.b != null) {
                this.b.close();
            }
            if (this.f26216a != null) {
                this.f26216a.close();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "releaseFileLock", (Throwable) e);
        }
    }
}
