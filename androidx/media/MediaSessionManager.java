package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaSessionManager.class */
public final class MediaSessionManager {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f3160a = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f3161c = new Object();
    private static volatile MediaSessionManager d;
    MediaSessionManagerImpl b;

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaSessionManager$MediaSessionManagerImpl.class */
    interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaSessionManager$RemoteUserInfo.class */
    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";

        /* renamed from: a  reason: collision with root package name */
        RemoteUserInfoImpl f3162a;

        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f3162a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }

        public RemoteUserInfo(String str, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f3162a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i, i2);
            } else {
                this.f3162a = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i, i2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfo) {
                return this.f3162a.equals(((RemoteUserInfo) obj).f3162a);
            }
            return false;
        }

        public String getPackageName() {
            return this.f3162a.getPackageName();
        }

        public int getPid() {
            return this.f3162a.getPid();
        }

        public int getUid() {
            return this.f3162a.getUid();
        }

        public int hashCode() {
            return this.f3162a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaSessionManager$RemoteUserInfoImpl.class */
    public interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    private MediaSessionManager(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = new MediaSessionManagerImplApi28(context);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.b = new MediaSessionManagerImplApi21(context);
        } else {
            this.b = new MediaSessionManagerImplBase(context);
        }
    }

    public static MediaSessionManager getSessionManager(Context context) {
        MediaSessionManager mediaSessionManager;
        MediaSessionManager mediaSessionManager2 = d;
        if (mediaSessionManager2 == null) {
            synchronized (f3161c) {
                MediaSessionManager mediaSessionManager3 = d;
                mediaSessionManager = mediaSessionManager3;
                if (mediaSessionManager3 == null) {
                    d = new MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = d;
                }
            }
            return mediaSessionManager;
        }
        return mediaSessionManager2;
    }

    Context getContext() {
        return this.b.getContext();
    }

    public boolean isTrustedForMediaControl(RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.b.isTrustedForMediaControl(remoteUserInfo.f3162a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
