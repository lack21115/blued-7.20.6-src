package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaBrowserServiceCompatApi21.class */
class MediaBrowserServiceCompatApi21 {

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaBrowserServiceCompatApi21$BrowserRoot.class */
    static class BrowserRoot {

        /* renamed from: a  reason: collision with root package name */
        final String f3155a;
        final Bundle b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BrowserRoot(String str, Bundle bundle) {
            this.f3155a = str;
            this.b = bundle;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor.class */
    static class MediaBrowserServiceAdaptor extends MediaBrowserService {

        /* renamed from: a  reason: collision with root package name */
        final ServiceCompatProxy f3156a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.f3156a = serviceCompatProxy;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            BrowserRoot onGetRoot = this.f3156a.onGetRoot(str, i, bundle == null ? null : new Bundle(bundle));
            if (onGetRoot == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(onGetRoot.f3155a, onGetRoot.b);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f3156a.onLoadChildren(str, new ResultWrapper<>(result));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaBrowserServiceCompatApi21$ResultWrapper.class */
    static class ResultWrapper<T> {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f3157a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ResultWrapper(MediaBrowserService.Result result) {
            this.f3157a = result;
        }

        List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        public void detach() {
            this.f3157a.detach();
        }

        public void sendResult(T t) {
            if (t instanceof List) {
                this.f3157a.sendResult(a((List) t));
            } else if (!(t instanceof Parcel)) {
                this.f3157a.sendResult(null);
            } else {
                Parcel parcel = (Parcel) t;
                parcel.setDataPosition(0);
                this.f3157a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/MediaBrowserServiceCompatApi21$ServiceCompatProxy.class */
    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String str, int i, Bundle bundle);

        void onLoadChildren(String str, ResultWrapper<List<Parcel>> resultWrapper);
    }

    private MediaBrowserServiceCompatApi21() {
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static void notifyChildrenChanged(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }

    public static IBinder onBind(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void onCreate(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static void setSessionToken(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }
}
