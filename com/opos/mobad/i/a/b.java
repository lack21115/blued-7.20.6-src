package com.opos.mobad.i.a;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a/b.class */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private File f12523a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private c[] f12524c;
    private volatile boolean d = false;

    public b(File file, int i, c[] cVarArr) {
        setName("download_monitor_" + file.getName());
        setPriority(5);
        this.f12523a = file;
        this.b = i;
        this.f12524c = cVarArr;
    }

    private void a(File file, int i, c[] cVarArr) {
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "writePosInfoToFile start");
        if (file != null && cVarArr != null && cVarArr.length > 0) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                try {
                    dataOutputStream.writeInt(i);
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= cVarArr.length) {
                            break;
                        }
                        dataOutputStream.writeLong(cVarArr[i3].a());
                        dataOutputStream.writeLong(cVarArr[i3].b());
                        i2 = i3 + 1;
                    }
                    dataOutputStream.close();
                    fileOutputStream.close();
                } finally {
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadMonitorThread", "writePosInfoToFile", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "writePosInfoToFile end");
    }

    public void a() {
        this.d = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StringBuilder sb;
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread start running.");
        e eVar = new e(this.f12523a);
        try {
            try {
                if (eVar.a()) {
                    while (!this.d) {
                        a(this.f12523a, this.b, this.f12524c);
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
                com.opos.cmn.an.f.a.a("DownloadMonitorThread", "DownloadMonitorThread run", (Throwable) e2);
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                sb = new StringBuilder();
            }
            sb.append("posInfoFile releaseFileLock success.");
            sb.append(this.f12523a);
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", sb.toString());
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
            eVar.b();
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "posInfoFile releaseFileLock success." + this.f12523a);
            throw th;
        }
    }
}
