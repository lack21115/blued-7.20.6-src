package android.app;

import android.content.Intent;
import android.content.pm.IPackageDeleteObserver2;

/* loaded from: source-9557208-dex2jar.jar:android/app/PackageDeleteObserver.class */
public class PackageDeleteObserver {
    private final IPackageDeleteObserver2.Stub mBinder = new IPackageDeleteObserver2.Stub() { // from class: android.app.PackageDeleteObserver.1
        @Override // android.content.pm.IPackageDeleteObserver2
        public void onPackageDeleted(String str, int i, String str2) {
            PackageDeleteObserver.this.onPackageDeleted(str, i, str2);
        }

        @Override // android.content.pm.IPackageDeleteObserver2
        public void onUserActionRequired(Intent intent) {
            PackageDeleteObserver.this.onUserActionRequired(intent);
        }
    };

    public IPackageDeleteObserver2 getBinder() {
        return this.mBinder;
    }

    public void onPackageDeleted(String str, int i, String str2) {
    }

    public void onUserActionRequired(Intent intent) {
    }
}
