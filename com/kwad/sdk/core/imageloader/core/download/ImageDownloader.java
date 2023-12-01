package com.kwad.sdk.core.imageloader.core.download;

import android.content.ContentResolver;
import com.anythink.expressad.foundation.h.i;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/core/download/ImageDownloader.class */
public interface ImageDownloader {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/core/download/ImageDownloader$Scheme.class */
    public enum Scheme {
        HTTP("http"),
        HTTPS("https"),
        FILE(ContentResolver.SCHEME_FILE),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE(i.f5112c),
        UNKNOWN("");
        
        private String scheme;
        private String uriPrefix;

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            if (str != null) {
                Scheme[] values = values();
                int length = values.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Scheme scheme = values[i2];
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                    i = i2 + 1;
                }
            }
            return UNKNOWN;
        }

        public final String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
        }

        public final String wrap(String str) {
            return this.uriPrefix + str;
        }
    }

    InputStream getStream(String str, Object obj);
}
