package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hk;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cb.class */
public final class cb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f27970a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hk f994a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(Context context, hk hkVar) {
        this.f27970a = context;
        this.f994a = hkVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        RandomAccessFile randomAccessFile;
        synchronized (ca.f27969a) {
            FileLock fileLock = null;
            RandomAccessFile randomAccessFile2 = null;
            RandomAccessFile randomAccessFile3 = null;
            try {
                try {
                    File file = new File(this.f27970a.getFilesDir(), "tiny_data.lock");
                    com.xiaomi.push.x.m9172a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    fileLock = null;
                } catch (Exception e) {
                    e = e;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile3 = null;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.release();
                        } catch (IOException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                        }
                    }
                    com.xiaomi.push.x.a(randomAccessFile3);
                    throw th;
                }
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    fileLock = lock;
                    randomAccessFile3 = randomAccessFile;
                    ca.c(this.f27970a, this.f994a);
                    randomAccessFile2 = randomAccessFile;
                    if (lock != null) {
                        randomAccessFile2 = randomAccessFile;
                        if (lock.isValid()) {
                            try {
                                lock.release();
                                randomAccessFile2 = randomAccessFile;
                            } catch (IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                                randomAccessFile2 = randomAccessFile;
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    randomAccessFile3 = randomAccessFile;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    randomAccessFile2 = randomAccessFile;
                    if (fileLock != null) {
                        randomAccessFile2 = randomAccessFile;
                        if (fileLock.isValid()) {
                            try {
                                fileLock.release();
                                randomAccessFile2 = randomAccessFile;
                            } catch (IOException e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                                randomAccessFile2 = randomAccessFile;
                            }
                        }
                    }
                    com.xiaomi.push.x.a(randomAccessFile2);
                }
                com.xiaomi.push.x.a(randomAccessFile2);
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null && randomAccessFile2.isValid()) {
                    randomAccessFile2.release();
                }
                com.xiaomi.push.x.a(randomAccessFile3);
                throw th;
            }
        }
    }
}
