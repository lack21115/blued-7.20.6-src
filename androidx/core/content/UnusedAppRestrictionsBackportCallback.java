package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/UnusedAppRestrictionsBackportCallback.class */
public class UnusedAppRestrictionsBackportCallback {

    /* renamed from: a  reason: collision with root package name */
    private IUnusedAppRestrictionsBackportCallback f2361a;

    public UnusedAppRestrictionsBackportCallback(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        this.f2361a = iUnusedAppRestrictionsBackportCallback;
    }

    public void onResult(boolean z, boolean z2) throws RemoteException {
        this.f2361a.onIsPermissionRevocationEnabledForAppResult(z, z2);
    }
}
