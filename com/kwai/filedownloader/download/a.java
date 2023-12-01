package com.kwai.filedownloader.download;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/download/a.class */
public final class a {
    final long aGT;
    final long aGU;
    final long aGV;
    final long contentLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j, long j2, long j3, long j4) {
        this.aGT = j;
        this.aGU = j2;
        this.aGV = j3;
        this.contentLength = j4;
    }

    public final String toString() {
        return com.kwai.filedownloader.e.f.j("range[%d, %d) current offset[%d]", Long.valueOf(this.aGT), Long.valueOf(this.aGV), Long.valueOf(this.aGU));
    }
}
