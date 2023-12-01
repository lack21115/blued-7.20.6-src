package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/UnusedAppRestrictionsBackportServiceConnection.class */
public class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    ResolvableFuture<Integer> b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f2413c;

    /* renamed from: a  reason: collision with root package name */
    IUnusedAppRestrictionsBackportService f2412a = null;
    private boolean d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnusedAppRestrictionsBackportServiceConnection(Context context) {
        this.f2413c = context;
    }

    private IUnusedAppRestrictionsBackportCallback a() {
        return new IUnusedAppRestrictionsBackportCallback.Stub() { // from class: androidx.core.content.UnusedAppRestrictionsBackportServiceConnection.1
            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) throws RemoteException {
                if (!z) {
                    UnusedAppRestrictionsBackportServiceConnection.this.b.set(0);
                    Log.e(PackageManagerCompat.LOG_TAG, "Unable to retrieve the permission revocation setting from the backport");
                } else if (z2) {
                    UnusedAppRestrictionsBackportServiceConnection.this.b.set(3);
                } else {
                    UnusedAppRestrictionsBackportServiceConnection.this.b.set(2);
                }
            }
        };
    }

    public void connectAndFetchResult(ResolvableFuture<Integer> resolvableFuture) {
        if (this.d) {
            throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
        }
        this.d = true;
        this.b = resolvableFuture;
        this.f2413c.bindService(new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.f2413c.getPackageManager())), this, 1);
    }

    public void disconnectFromService() {
        if (!this.d) {
            throw new IllegalStateException("bindService must be called before unbind");
        }
        this.d = false;
        this.f2413c.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService asInterface = IUnusedAppRestrictionsBackportService.Stub.asInterface(iBinder);
        this.f2412a = asInterface;
        try {
            asInterface.isPermissionRevocationEnabledForApp(a());
        } catch (RemoteException e) {
            this.b.set(0);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f2412a = null;
    }
}
