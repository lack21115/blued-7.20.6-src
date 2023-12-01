package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaSessionManagerImplApi28.class */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

    /* renamed from: a  reason: collision with root package name */
    android.media.session.MediaSessionManager f3115a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaSessionManagerImplApi28$RemoteUserInfoImplApi28.class */
    static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {

        /* renamed from: a  reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f3116a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f3116a = remoteUserInfo;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemoteUserInfoImplApi28(String str, int i, int i2) {
            this.f3116a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfoImplApi28) {
                return this.f3116a.equals(((RemoteUserInfoImplApi28) obj).f3116a);
            }
            return false;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.f3116a.getPackageName();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.f3116a.getPid();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.f3116a.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f3116a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.f3115a = (android.media.session.MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        if (remoteUserInfoImpl instanceof RemoteUserInfoImplApi28) {
            return this.f3115a.isTrustedForMediaControl(((RemoteUserInfoImplApi28) remoteUserInfoImpl).f3116a);
        }
        return false;
    }
}
