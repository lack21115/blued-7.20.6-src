package com.kwai.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/d.class */
public final class d implements Handler.Callback {
    private volatile Thread aGB;
    private final a aHN;
    private final int aHO;
    private final int aHP;
    private final int aHQ;
    private long aHR;
    private HandlerThread aHS;
    private volatile boolean aHV;
    private final com.kwai.filedownloader.c.c aHf;
    private Handler handler;
    private volatile boolean aHT = false;
    private volatile long aHz = 0;
    private final AtomicLong aHU = new AtomicLong();
    private boolean aHW = true;
    private final com.kwai.filedownloader.a.a aHa = b.HF().HH();

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/d$a.class */
    public static final class a {
        private boolean aHX;
        private Exception aHY;
        private int aHZ;

        public final int Gu() {
            return this.aHZ;
        }

        public final boolean Ig() {
            return this.aHX;
        }

        final void bT(boolean z) {
            this.aHX = z;
        }

        final void cS(int i) {
            this.aHZ = i;
        }

        final void g(Exception exc) {
            this.aHY = exc;
        }

        public final Exception getException() {
            return this.aHY;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.kwai.filedownloader.c.c cVar, int i, int i2, int i3) {
        this.aHf = cVar;
        this.aHP = i2 < 5 ? 5 : i2;
        this.aHQ = i3;
        this.aHN = new a();
        this.aHO = i;
    }

    private void Ic() {
        String HT = this.aHf.HT();
        String targetFilePath = this.aHf.getTargetFilePath();
        File file = new File(HT);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwai.filedownloader.e.f.j("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                com.kwai.filedownloader.e.d.h(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwai.filedownloader.e.f.j("Can't rename the  temp downloaded file(%s) to the target file(%s)", HT, targetFilePath));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwai.filedownloader.e.d.h(this, "delete the temp file(%s) failed, on completed downloading.", HT);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwai.filedownloader.e.d.h(this, "delete the temp file(%s) failed, on completed downloading.", HT);
            }
            throw th;
        }
    }

    private void Id() {
        Ic();
        this.aHf.e((byte) -3);
        this.aHa.f(this.aHf.getId(), this.aHf.getTotal());
        this.aHa.cK(this.aHf.getId());
        d((byte) -3);
        if (com.kwai.filedownloader.e.e.Jb().aJx) {
            com.kwai.filedownloader.services.f.f(this.aHf);
        }
    }

    private boolean Ie() {
        if (this.aHf.isChunked()) {
            com.kwai.filedownloader.c.c cVar = this.aHf;
            cVar.aq(cVar.IB());
            return false;
        } else if (this.aHf.IB() != this.aHf.getTotal()) {
            d(new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("sofar[%d] not equal total[%d]", Long.valueOf(this.aHf.IB()), Long.valueOf(this.aHf.getTotal()))));
            return true;
        } else {
            return false;
        }
    }

    private void If() {
        this.aHf.e((byte) -2);
        this.aHa.g(this.aHf.getId(), this.aHf.IB());
        d((byte) -2);
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.aHf.getId();
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.aHf.fw(sQLiteFullException.toString());
        this.aHf.e((byte) -1);
        this.aHa.cL(id);
        this.aHa.cK(id);
    }

    private void a(Exception exc, int i) {
        Exception e = e(exc);
        this.aHN.g(e);
        this.aHN.cS(this.aHO - i);
        this.aHf.e((byte) 5);
        this.aHf.fw(e.toString());
        this.aHa.a(this.aHf.getId(), e);
        d((byte) 5);
    }

    private boolean al(long j) {
        if (!this.aHW) {
            return this.aHR != -1 && this.aHU.get() >= this.aHR && j - this.aHz >= ((long) this.aHP);
        }
        this.aHW = false;
        return true;
    }

    private void b(long j, boolean z) {
        if (this.aHf.IB() == this.aHf.getTotal()) {
            this.aHa.e(this.aHf.getId(), this.aHf.IB());
            return;
        }
        if (this.aHV) {
            this.aHV = false;
            this.aHf.e((byte) 3);
        }
        if (z) {
            this.aHz = j;
            d((byte) 3);
            this.aHU.set(0L);
        }
    }

    private void c(Message message) {
        synchronized (this) {
            if (!this.aHS.isAlive()) {
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.g(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                }
                return;
            }
            try {
                this.handler.sendMessage(message);
            } catch (IllegalStateException e) {
                if (this.aHS.isAlive()) {
                    throw e;
                }
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.g(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                }
            }
        }
    }

    private void d(byte b) {
        if (b != -2) {
            com.kwai.filedownloader.message.e.Iv().s(com.kwai.filedownloader.message.f.a(b, this.aHf, this.aHN));
        } else if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.aHf.getId()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (com.kwai.filedownloader.e.e.Jb().aJw != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Exception e(java.lang.Exception r11) {
        /*
            r10 = this;
            r0 = r10
            com.kwai.filedownloader.c.c r0 = r0.aHf
            java.lang.String r0 = r0.HT()
            r17 = r0
            r0 = r10
            com.kwai.filedownloader.c.c r0 = r0.aHf
            boolean r0 = r0.isChunked()
            if (r0 != 0) goto L1f
            r0 = r11
            r16 = r0
            com.kwai.filedownloader.e.e r0 = com.kwai.filedownloader.e.e.Jb()
            boolean r0 = r0.aJw
            if (r0 == 0) goto L9e
        L1f:
            r0 = r11
            r16 = r0
            r0 = r11
            boolean r0 = r0 instanceof java.io.IOException
            if (r0 == 0) goto L9e
            r0 = r11
            r16 = r0
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r17
            r1.<init>(r2)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L9e
            r0 = r17
            long r0 = com.kwad.sdk.crash.utils.h.getAvailableBytes(r0)
            r14 = r0
            r0 = r11
            r16 = r0
            r0 = r14
            r1 = 4096(0x1000, double:2.0237E-320)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L9e
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r17
            r1.<init>(r2)
            r16 = r0
            r0 = r16
            boolean r0 = r0.exists()
            if (r0 != 0) goto L72
            r0 = r10
            r1 = r11
            java.lang.String r2 = "Exception with: free space isn't enough, and the target file not exist."
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.kwai.filedownloader.e.d.a(r0, r1, r2, r3)
            r0 = 0
            r12 = r0
            goto L78
        L72:
            r0 = r16
            long r0 = r0.length()
            r12 = r0
        L78:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 9
            if (r0 < r1) goto L8f
            com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException r0 = new com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException
            r1 = r0
            r2 = r14
            r3 = 4096(0x1000, double:2.0237E-320)
            r4 = r12
            r5 = r11
            r1.<init>(r2, r3, r4, r5)
            return r0
        L8f:
            com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException r0 = new com.kwai.filedownloader.exception.FileDownloadOutOfSpaceException
            r1 = r0
            r2 = r14
            r3 = 4096(0x1000, double:2.0237E-320)
            r4 = r12
            r1.<init>(r2, r3, r4)
            r16 = r0
        L9e:
            r0 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.d.e(java.lang.Exception):java.lang.Exception");
    }

    private void f(Exception exc) {
        Exception e = e(exc);
        if (!(e instanceof SQLiteFullException)) {
            try {
                this.aHf.e((byte) -1);
                this.aHf.fw(exc.toString());
                this.aHa.a(this.aHf.getId(), e, this.aHf.IB());
                e = e;
            } catch (SQLiteFullException e2) {
                e = e2;
            }
            this.aHN.g(e);
            d((byte) -1);
        }
        e = e;
        a((SQLiteFullException) e);
        this.aHN.g(e);
        d((byte) -1);
    }

    private static long g(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / (j2 + 1);
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void HW() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.aHS.quit();
            this.aGB = Thread.currentThread();
            while (this.aHT) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.aGB = null;
        }
    }

    public final void HX() {
        this.aHf.e((byte) 1);
        this.aHa.cM(this.aHf.getId());
        d((byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void HY() {
        this.aHf.e((byte) 6);
        d((byte) 6);
        this.aHa.cH(this.aHf.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void HZ() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.aHS = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.aHS.getLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Ia() {
        If();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Ib() {
        if (Ie()) {
            return;
        }
        Id();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Exception exc, int i, long j) {
        this.aHU.set(0L);
        this.aHf.ap(-j);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i);
        } else {
            c(handler.obtainMessage(5, i, 0, exc));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z, long j, String str, String str2) {
        String IC = this.aHf.IC();
        if (IC != null && !IC.equals(str)) {
            throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, IC));
        }
        this.aHN.bT(z);
        this.aHf.e((byte) 2);
        this.aHf.aq(j);
        this.aHf.fv(str);
        this.aHf.fx(str2);
        this.aHa.a(this.aHf.getId(), j, str, str2);
        d((byte) 2);
        this.aHR = g(j, this.aHQ);
        this.aHV = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(Exception exc) {
        f(exc);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = 1
            r0.aHT = r1
            r0 = r6
            int r0 = r0.what
            r7 = r0
            r0 = r7
            r1 = 3
            if (r0 == r1) goto L29
            r0 = r7
            r1 = 5
            if (r0 == r1) goto L17
            goto L31
        L17:
            r0 = r5
            r1 = r6
            java.lang.Object r1 = r1.obj     // Catch: java.lang.Throwable -> L46
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L46
            r2 = r6
            int r2 = r2.arg1     // Catch: java.lang.Throwable -> L46
            r0.a(r1, r2)     // Catch: java.lang.Throwable -> L46
            goto L31
        L29:
            r0 = r5
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L46
            r2 = 1
            r0.b(r1, r2)     // Catch: java.lang.Throwable -> L46
        L31:
            r0 = r5
            r1 = 0
            r0.aHT = r1
            r0 = r5
            java.lang.Thread r0 = r0.aGB
            if (r0 == 0) goto L44
            r0 = r5
            java.lang.Thread r0 = r0.aGB
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L44:
            r0 = 1
            return r0
        L46:
            r6 = move-exception
            r0 = r5
            r1 = 0
            r0.aHT = r1
            r0 = r5
            java.lang.Thread r0 = r0.aGB
            if (r0 == 0) goto L5a
            r0 = r5
            java.lang.Thread r0 = r0.aGB
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L5a:
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.d.handleMessage(android.os.Message):boolean");
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.aHS;
        return handlerThread != null && handlerThread.isAlive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void onProgress(long j) {
        this.aHU.addAndGet(j);
        this.aHf.ap(j);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean al = al(elapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(elapsedRealtime, al);
        } else if (al) {
            c(handler.obtainMessage(3));
        }
    }
}
