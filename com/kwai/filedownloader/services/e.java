package com.kwai.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.n;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/e.class */
public final class e extends b.a implements i {
    private final g aJc;
    private final WeakReference<FileDownloadServiceProxy> aJd;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/e$a.class */
    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.aJd = weakReference;
        this.aJc = gVar;
    }

    @Override // com.kwai.filedownloader.services.i
    public final void IR() {
        n.Hi().a(this);
    }

    @Override // com.kwai.filedownloader.services.i
    public final IBinder IS() {
        return null;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void Il() {
        this.aJc.Il();
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a(com.kwai.filedownloader.b.a aVar) {
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean am(String str, String str2) {
        return this.aJc.ao(str, str2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(com.kwai.filedownloader.b.a aVar) {
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        this.aJc.b(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cB(int i) {
        return this.aJc.cB(i);
    }

    @Override // com.kwai.filedownloader.b.b
    public final byte cC(int i) {
        return this.aJc.cC(i);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cD(int i) {
        return this.aJc.cD(i);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cV(int i) {
        return this.aJc.cV(i);
    }

    @Override // com.kwai.filedownloader.b.b
    public final long cW(int i) {
        return this.aJc.dh(i);
    }

    @Override // com.kwai.filedownloader.b.b
    public final long cX(int i) {
        return this.aJc.cX(i);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean isIdle() {
        return this.aJc.isIdle();
    }

    @Override // com.kwai.filedownloader.services.i
    public final void onDestroy() {
        n.Hi().onDisconnected();
    }

    @Override // com.kwai.filedownloader.b.b
    public final void pauseAllTasks() {
        this.aJc.IT();
    }

    @Override // com.kwai.filedownloader.b.b
    public final void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aJd;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.aJd.get().context.startForeground(i, notification);
    }

    @Override // com.kwai.filedownloader.b.b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aJd;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.aJd.get().context.stopForeground(z);
    }
}
