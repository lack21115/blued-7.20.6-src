package android.app;

import android.content.Intent;
import android.content.pm.IPackageInstallObserver2;
import android.os.Bundle;

/* loaded from: source-9557208-dex2jar.jar:android/app/PackageInstallObserver.class */
public class PackageInstallObserver {
    private final IPackageInstallObserver2.Stub mBinder = new IPackageInstallObserver2.Stub() { // from class: android.app.PackageInstallObserver.1
        @Override // android.content.pm.IPackageInstallObserver2
        public void onPackageInstalled(String str, int i, String str2, Bundle bundle) {
            PackageInstallObserver.this.onPackageInstalled(str, i, str2, bundle);
        }

        @Override // android.content.pm.IPackageInstallObserver2
        public void onUserActionRequired(Intent intent) {
            PackageInstallObserver.this.onUserActionRequired(intent);
        }
    };

    public IPackageInstallObserver2 getBinder() {
        return this.mBinder;
    }

    public void onPackageInstalled(String str, int i, String str2, Bundle bundle) {
    }

    public void onUserActionRequired(Intent intent) {
    }
}
