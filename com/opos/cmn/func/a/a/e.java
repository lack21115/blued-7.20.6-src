package com.opos.cmn.func.a.a;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a/e.class */
public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f24805a;
    private FileChannel b;

    /* renamed from: c  reason: collision with root package name */
    private FileLock f24806c;

    public e(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f24805a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileLockEngine", "FileLockEngine", e);
        }
    }

    public e(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f24805a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileLockEngine", "FileLockEngine", e);
        }
    }

    @Override // com.opos.cmn.func.a.a.f
    public boolean a() {
        boolean z;
        FileChannel fileChannel = this.b;
        if (fileChannel != null) {
            try {
                this.f24806c = fileChannel.lock();
                z = true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("FileLockEngine", "acquireFileLock", e);
            }
            com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
        return z;
    }

    @Override // com.opos.cmn.func.a.a.f
    public void b() {
        try {
            if (this.f24806c != null) {
                this.f24806c.release();
            }
            if (this.b != null) {
                this.b.close();
            }
            if (this.f24805a != null) {
                this.f24805a.close();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileLockEngine", "releaseFileLock", e);
        }
    }
}
