package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.repackage.a.a.a.a;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/a/a/a/a/b.class */
public class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f44102a;

    public b(c cVar) {
        this.f44102a = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f44102a.f44103a = a.AbstractBinderC1133a.a(iBinder);
        synchronized (this.f44102a.d) {
            this.f44102a.d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f44102a.f44103a = null;
    }
}
