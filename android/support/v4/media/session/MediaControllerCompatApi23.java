package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: source-8756600-dex2jar.jar:android/support/v4/media/session/MediaControllerCompatApi23.class */
class MediaControllerCompatApi23 {

    /* loaded from: source-8756600-dex2jar.jar:android/support/v4/media/session/MediaControllerCompatApi23$TransportControls.class */
    public static class TransportControls {
        private TransportControls() {
        }

        public static void playFromUri(Object obj, Uri uri, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromUri(uri, bundle);
        }
    }

    private MediaControllerCompatApi23() {
    }
}
