package androidx.media;

import android.Manifest;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaSessionManagerImplBase.class */
public class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3165a = MediaSessionManager.f3160a;
    Context b;

    /* renamed from: c  reason: collision with root package name */
    ContentResolver f3166c;

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaSessionManagerImplBase$RemoteUserInfoImplBase.class */
    static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {

        /* renamed from: a  reason: collision with root package name */
        private String f3167a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f3168c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemoteUserInfoImplBase(String str, int i, int i2) {
            this.f3167a = str;
            this.b = i;
            this.f3168c = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfoImplBase) {
                RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
                return TextUtils.equals(this.f3167a, remoteUserInfoImplBase.f3167a) && this.b == remoteUserInfoImplBase.b && this.f3168c == remoteUserInfoImplBase.f3168c;
            }
            return false;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.f3167a;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.b;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.f3168c;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f3167a, Integer.valueOf(this.b), Integer.valueOf(this.f3168c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaSessionManagerImplBase(Context context) {
        this.b = context;
        this.f3166c = context.getContentResolver();
    }

    private boolean a(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl, String str) {
        return remoteUserInfoImpl.getPid() < 0 ? this.b.getPackageManager().checkPermission(str, remoteUserInfoImpl.getPackageName()) == 0 : this.b.checkPermission(str, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
    }

    boolean a(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        String string = Settings.Secure.getString(this.f3166c, Settings.Secure.ENABLED_NOTIFICATION_LISTENERS);
        if (string == null) {
            return false;
        }
        String[] split = string.split(":");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return false;
            }
            ComponentName unflattenFromString = ComponentName.unflattenFromString(split[i2]);
            if (unflattenFromString != null && unflattenFromString.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public Context getContext() {
        return this.b;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        boolean z = false;
        try {
            if (this.b.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0).uid == remoteUserInfoImpl.getUid()) {
                if (a(remoteUserInfoImpl, Manifest.permission.STATUS_BAR_SERVICE) || a(remoteUserInfoImpl, Manifest.permission.MEDIA_CONTENT_CONTROL) || remoteUserInfoImpl.getUid() == 1000 || a(remoteUserInfoImpl)) {
                    z = true;
                }
                return z;
            } else if (f3165a) {
                Log.d("MediaSessionManager", "Package name " + remoteUserInfoImpl.getPackageName() + " doesn't match with the uid " + remoteUserInfoImpl.getUid());
                return false;
            } else {
                return false;
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (f3165a) {
                Log.d("MediaSessionManager", "Package " + remoteUserInfoImpl.getPackageName() + " doesn't exist");
                return false;
            }
            return false;
        }
    }
}
