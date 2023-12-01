package com.kwai.filedownloader.download;

import android.os.SystemClock;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/e.class */
public final class e {
    private final String RZ;
    private final int aGL;
    private final long aGT;
    long aGU;
    private final long aGV;
    private final f aHI;
    private final int aHK;
    private final com.kwai.filedownloader.a.a aHa;
    private final boolean aHi;
    private final c aIa;
    private final com.kwai.filedownloader.kwai.b aIb;
    private com.kwai.filedownloader.d.a aIc;
    private volatile long aId;
    private volatile long aIe;
    private final long contentLength;
    private volatile boolean lh;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/e$a.class */
    public static final class a {
        String RZ;
        Integer aGR;
        com.kwai.filedownloader.download.a aGS;
        Boolean aHF;
        f aHI;
        Integer aHM;
        com.kwai.filedownloader.kwai.b aIb;
        c aIf;

        public final e Ii() {
            com.kwai.filedownloader.kwai.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            if (this.aHF == null || (bVar = this.aIb) == null || (aVar = this.aGS) == null || this.aHI == null || this.RZ == null || (num = this.aGR) == null || this.aHM == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.aIf, num.intValue(), this.aHM.intValue(), this.aHF.booleanValue(), this.aHI, this.RZ, (byte) 0);
        }

        public final a a(c cVar) {
            this.aIf = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.aHI = fVar;
            return this;
        }

        public final a bU(boolean z) {
            this.aHF = Boolean.valueOf(z);
            return this;
        }

        public final a c(com.kwai.filedownloader.download.a aVar) {
            this.aGS = aVar;
            return this;
        }

        public final a cT(int i) {
            this.aHM = Integer.valueOf(i);
            return this;
        }

        public final a cU(int i) {
            this.aGR = Integer.valueOf(i);
            return this;
        }

        public final a d(com.kwai.filedownloader.kwai.b bVar) {
            this.aIb = bVar;
            return this;
        }

        public final a ft(String str) {
            this.RZ = str;
            return this;
        }
    }

    private e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.aId = 0L;
        this.aIe = 0L;
        this.aHI = fVar;
        this.RZ = str;
        this.aIb = bVar;
        this.aHi = z;
        this.aIa = cVar;
        this.aHK = i2;
        this.aGL = i;
        this.aHa = b.HF().HH();
        this.aGT = aVar.aGT;
        this.aGV = aVar.aGV;
        this.aGU = aVar.aGU;
        this.contentLength = aVar.contentLength;
    }

    /* synthetic */ e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    private void Ih() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwai.filedownloader.e.f.h(this.aGU - this.aId, elapsedRealtime - this.aIe)) {
            sync();
            this.aId = this.aGU;
            this.aIe = elapsedRealtime;
        }
    }

    private void sync() {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.aIc.IX();
            z = true;
        } catch (IOException e) {
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.aIa != null) {
                this.aHa.a(this.aGL, this.aHK, this.aGU);
            } else {
                this.aHI.HQ();
            }
            if (com.kwai.filedownloader.e.d.aJq) {
                com.kwai.filedownloader.e.d.g(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.aGL), Integer.valueOf(this.aHK), Long.valueOf(this.aGU), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public final void pause() {
        this.lh = true;
    }

    public final void run() {
        com.kwai.filedownloader.d.a aVar;
        if (this.lh) {
            return;
        }
        long b = com.kwai.filedownloader.e.f.b(this.aHK, this.aIb);
        if (b == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.aGL), Integer.valueOf(this.aHK)));
        }
        long j = this.contentLength;
        if (j > 0 && b != j) {
            throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.aGV == 0 ? com.kwai.filedownloader.e.f.j("range[%d-)", Long.valueOf(this.aGU)) : com.kwai.filedownloader.e.f.j("range[%d-%d)", Long.valueOf(this.aGU), Long.valueOf(this.aGV)), Long.valueOf(this.contentLength), Long.valueOf(b), Integer.valueOf(this.aGL), Integer.valueOf(this.aHK)));
        }
        long j2 = this.aGU;
        Closeable closeable = null;
        try {
            boolean HJ = b.HF().HJ();
            if (this.aIa != null && !HJ) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVar = com.kwai.filedownloader.e.f.fH(this.RZ);
            closeable = null;
            try {
                this.aIc = aVar;
                if (HJ) {
                    aVar.seek(this.aGU);
                }
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.g(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.aHK), Long.valueOf(this.aGT), Long.valueOf(this.aGV), Long.valueOf(this.aGU));
                }
                InputStream inputStream = this.aIb.getInputStream();
                byte[] bArr = new byte[4096];
                if (this.lh) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    return;
                }
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    aVar.write(bArr, 0, read);
                    long j3 = read;
                    this.aGU += j3;
                    this.aHI.onProgress(j3);
                    Ih();
                    if (this.lh) {
                        break;
                    } else if (this.aHi && com.kwai.filedownloader.e.f.Jg()) {
                        throw new FileDownloadNetworkPolicyException();
                    }
                }
                if (aVar != null) {
                    sync();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                long j4 = this.aGU - j2;
                if (b != -1 && b != j4) {
                    throw new FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", Long.valueOf(j4), Long.valueOf(b), Long.valueOf(this.aGT), Long.valueOf(this.aGV), Long.valueOf(this.aGU), Long.valueOf(j2)));
                }
                this.aHI.a(this.aIa, this.aGT, this.aGV);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            aVar = null;
        }
    }
}
