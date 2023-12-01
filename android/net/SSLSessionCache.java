package android.net;

import android.content.Context;
import android.util.Log;
import com.android.org.conscrypt.ClientSessionContext;
import com.android.org.conscrypt.FileClientSessionCache;
import com.android.org.conscrypt.SSLClientSessionCache;
import java.io.File;
import java.io.IOException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;

/* loaded from: source-9557208-dex2jar.jar:android/net/SSLSessionCache.class */
public final class SSLSessionCache {
    private static final String TAG = "SSLSessionCache";
    final SSLClientSessionCache mSessionCache;

    public SSLSessionCache(Context context) {
        File dir = context.getDir("sslcache", 0);
        SSLClientSessionCache sSLClientSessionCache = null;
        try {
            sSLClientSessionCache = FileClientSessionCache.usingDirectory(dir);
        } catch (IOException e) {
            Log.w(TAG, "Unable to create SSL session cache in " + dir, e);
        }
        this.mSessionCache = sSLClientSessionCache;
    }

    public SSLSessionCache(File file) throws IOException {
        this.mSessionCache = FileClientSessionCache.usingDirectory(file);
    }

    public SSLSessionCache(Object obj) {
        this.mSessionCache = (SSLClientSessionCache) obj;
    }

    public static void install(SSLSessionCache sSLSessionCache, SSLContext sSLContext) {
        SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
        if (!(clientSessionContext instanceof ClientSessionContext)) {
            throw new IllegalArgumentException("Incompatible SSLContext: " + sSLContext);
        }
        ((ClientSessionContext) clientSessionContext).setPersistentCache(sSLSessionCache == null ? null : sSLSessionCache.mSessionCache);
    }
}
