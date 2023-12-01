package com.kwai.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/services/a.class */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    private volatile INTERFACE aIQ;
    private final Class<?> aIl;
    private final HashMap<String, Object> aIR = new HashMap<>();
    private final List<Context> aIS = new ArrayList();
    private final ArrayList<Runnable> aFZ = new ArrayList<>();
    private final CALLBACK aIP = Hm();

    public a(Class<?> cls) {
        this.aIl = cls;
    }

    private void a(Context context, Runnable runnable) {
        if (com.kwai.filedownloader.e.f.du(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.aIl);
        if (!this.aIS.contains(context)) {
            this.aIS.add(context);
        }
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    private void bV(boolean z) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "release connect resources %s", this.aIQ);
        }
        this.aIQ = null;
        com.kwai.filedownloader.f.GU().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.aIl));
    }

    protected abstract CALLBACK Hm();

    /* JADX INFO: Access modifiers changed from: protected */
    public final INTERFACE IF() {
        return this.aIQ;
    }

    protected abstract void a(INTERFACE r1, CALLBACK callback);

    protected abstract INTERFACE b(IBinder iBinder);

    @Override // com.kwai.filedownloader.u
    public final void dr(Context context) {
        a(context, (Runnable) null);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        return IF() != null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.aIQ = b(iBinder);
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "onServiceConnected %s %s", componentName, this.aIQ);
        }
        try {
            a((a<CALLBACK, INTERFACE>) this.aIQ, (INTERFACE) this.aIP);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        List<Runnable> list = (List) this.aFZ.clone();
        this.aFZ.clear();
        for (Runnable runnable : list) {
            runnable.run();
        }
        com.kwai.filedownloader.f.GU().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.aIl));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwai.filedownloader.e.d.aJq) {
            com.kwai.filedownloader.e.d.g(this, "onServiceDisconnected %s %s", componentName, this.aIQ);
        }
        bV(true);
    }
}
