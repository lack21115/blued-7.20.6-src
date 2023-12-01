package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.services.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/o.class */
public final class o implements e.a, u {
    private static Class<?> aFY;
    private final ArrayList<Runnable> aFZ = new ArrayList<>();
    private com.kwai.filedownloader.services.e aGa;

    private static Class<?> Hk() {
        if (aFY == null) {
            aFY = FileDownloadService.SharedMainProcessService.class;
        }
        return aFY;
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, Hk()));
    }

    @Override // com.kwai.filedownloader.services.e.a
    public final void a(com.kwai.filedownloader.services.e eVar) {
        this.aGa = eVar;
        List<Runnable> list = (List) this.aFZ.clone();
        this.aFZ.clear();
        for (Runnable runnable : list) {
            runnable.run();
        }
        f.GU().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, Hk()));
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        if (isConnected()) {
            this.aGa.b(str, str2, z, i, i2, i3, z2, bVar, z3);
            return true;
        }
        return com.kwai.filedownloader.e.a.l(str, str2, z);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cB(int i) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cB(i) : this.aGa.cB(i);
    }

    @Override // com.kwai.filedownloader.u
    public final byte cC(int i) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cC(i) : this.aGa.cC(i);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cD(int i) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cD(i) : this.aGa.cD(i);
    }

    @Override // com.kwai.filedownloader.u
    public final void dr(Context context) {
        a(context, null);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        return this.aGa != null;
    }

    @Override // com.kwai.filedownloader.services.e.a
    public final void onDisconnected() {
        this.aGa = null;
        f.GU().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, Hk()));
    }
}
