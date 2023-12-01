package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* loaded from: source-8756600-dex2jar.jar:android/support/v4/media/MediaDescriptionCompatApi23.class */
class MediaDescriptionCompatApi23 {

    /* loaded from: source-8756600-dex2jar.jar:android/support/v4/media/MediaDescriptionCompatApi23$Builder.class */
    static class Builder {
        private Builder() {
        }

        public static void setMediaUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    private MediaDescriptionCompatApi23() {
    }

    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
