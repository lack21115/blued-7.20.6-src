package com.opos.mobad.i.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f12525a;
    private com.opos.mobad.i.a b;

    /* renamed from: c  reason: collision with root package name */
    private long f12526c;
    private long d;
    private CountDownLatch e;
    private boolean f = false;
    private long g;
    private int h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a/c$a.class */
    public class a {
        private RandomAccessFile b;

        public a(File file, long j) {
            if (file == null || -1 == j) {
                return;
            }
            com.opos.cmn.an.f.a.b("DownloadThread", "seekPos=" + j);
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                this.b = randomAccessFile;
                randomAccessFile.seek(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
            }
        }

        public int a(byte[] bArr, int i, int i2) {
            synchronized (this) {
                if (this.b != null) {
                    try {
                        this.b.write(bArr, i, i2);
                    } catch (IOException e) {
                        com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
                    }
                }
                i2 = -1;
            }
            return i2;
        }

        public void a() {
            synchronized (this) {
                if (this.b != null) {
                    try {
                        this.b.close();
                    } catch (IOException e) {
                        com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
                    }
                }
            }
        }
    }

    public c(Context context, com.opos.mobad.i.a aVar, long j, long j2, long j3, CountDownLatch countDownLatch) {
        this.h = -1;
        this.f12525a = context.getApplicationContext();
        this.b = aVar;
        this.g = j;
        this.f12526c = j2;
        this.d = j3;
        this.e = countDownLatch;
        this.h = hashCode();
    }

    public long a() {
        return this.f12526c;
    }

    public long b() {
        return this.d;
    }

    public boolean c() {
        return this.f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x033e, code lost:
        if (0 == 0) goto L90;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x031c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 1081
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.i.a.c.run():void");
    }
}
