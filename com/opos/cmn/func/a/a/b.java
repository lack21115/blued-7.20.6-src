package com.opos.cmn.func.a.a;

import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a/b.class */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private File f11112a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private c[] f11113c;
    private volatile boolean d = false;

    public b(File file, int i, c[] cVarArr) {
        setName("download_monitor_" + file.getName());
        setPriority(5);
        this.f11112a = file;
        this.b = i;
        this.f11113c = cVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8 A[Catch: IOException -> 0x00f5, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x00f5, blocks: (B:43:0x00cc, B:46:0x00d8), top: B:56:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.io.File r5, int r6, com.opos.cmn.func.a.a.c[] r7) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.b.a(java.io.File, int, com.opos.cmn.func.a.a.c[]):void");
    }

    public void a() {
        this.d = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StringBuilder sb;
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread start running.");
        e eVar = new e(this.f11112a);
        try {
            try {
                if (eVar.a()) {
                    while (!this.d) {
                        a(this.f11112a, this.b, this.f11113c);
                        try {
                            sleep(500L);
                        } catch (InterruptedException e) {
                            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "", e);
                        }
                    }
                }
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                sb = new StringBuilder();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("DownloadMonitorThread", "DownloadMonitorThread run", e2);
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                sb = new StringBuilder();
            }
            sb.append("posInfoFile releaseFileLock success.");
            sb.append(this.f11112a);
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", sb.toString());
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
            eVar.b();
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "posInfoFile releaseFileLock success." + this.f11112a);
            throw th;
        }
    }
}
