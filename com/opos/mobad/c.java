package com.opos.mobad;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/c.class */
public class c implements com.opos.mobad.c.a.b {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f12116a;
    private FileChannel b;

    /* renamed from: c  reason: collision with root package name */
    private FileLock f12117c;

    public c(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f12116a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "FileLockEngine", (Throwable) e);
        }
    }

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = str + File.separator + "lock.lk";
        a(new File(str2));
        return new c(str2);
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        try {
            if (!com.opos.cmn.an.d.b.a.b(com.opos.cmn.an.d.b.a.d(file))) {
                com.opos.cmn.an.d.b.a.c(file);
            }
            file.createNewFile();
        } catch (IOException e) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.c.a.b
    public boolean a() {
        boolean z;
        FileChannel fileChannel = this.b;
        if (fileChannel != null) {
            try {
                this.f12117c = fileChannel.lock();
                z = true;
            } catch (OverlappingFileLockException e) {
                com.opos.cmn.an.f.a.a("FileLockedEngine", "acquireFileLock but has acquire by other thread");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("FileLockedEngine", "acquireFileLock", (Throwable) e2);
            }
            com.opos.cmn.an.f.a.b("FileLockedEngine", "acquireFileLock result=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("FileLockedEngine", "acquireFileLock result=" + z);
        return z;
    }

    @Override // com.opos.mobad.c.a.b
    public void b() {
        try {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseFileLock");
            if (this.f12117c != null) {
                this.f12117c.release();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseFileLock", (Throwable) e);
        }
        try {
            if (this.b != null) {
                this.b.close();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releasemFileChannel", (Throwable) e2);
        }
        try {
            if (this.f12116a != null) {
                this.f12116a.close();
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseRandomAccessFile", (Throwable) e3);
        }
    }
}
