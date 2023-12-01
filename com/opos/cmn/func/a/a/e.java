package com.opos.cmn.func.a.a;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a/e.class */
public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f11117a;
    private FileChannel b;

    /* renamed from: c  reason: collision with root package name */
    private FileLock f11118c;

    public e(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f11117a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileLockEngine", "FileLockEngine", e);
        }
    }

    public e(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f11117a = randomAccessFile;
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
                this.f11118c = fileChannel.lock();
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
            if (this.f11118c != null) {
                this.f11118c.release();
            }
            if (this.b != null) {
                this.b.close();
            }
            if (this.f11117a != null) {
                this.f11117a.close();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileLockEngine", "releaseFileLock", e);
        }
    }
}
