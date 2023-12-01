package android.media;

import android.media.IMediaHTTPService;
import android.os.IBinder;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaHTTPService.class */
public class MediaHTTPService extends IMediaHTTPService.Stub {
    private static final String TAG = "MediaHTTPService";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBinder createHttpServiceBinderIfNecessary(String str) {
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("widevine://")) {
            return new MediaHTTPService().asBinder();
        }
        return null;
    }

    @Override // android.media.IMediaHTTPService
    public IMediaHTTPConnection makeHTTPConnection() {
        return new MediaHTTPConnection();
    }
}
