package com.blued.android.core.net.http.ssl;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.conscrypt.FileClientSessionCache;
import org.conscrypt.SSLClientSessionCache;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/ssl/InternalSSLSessionCache.class */
public final class InternalSSLSessionCache {
    public final SSLClientSessionCache a;

    public InternalSSLSessionCache(Context context) {
        SSLClientSessionCache sSLClientSessionCache;
        File dir = context.getDir("sslcache", 0);
        try {
            sSLClientSessionCache = FileClientSessionCache.usingDirectory(dir);
        } catch (IOException e) {
            Log.w("SSLSessionCache", "Unable to create SSL session cache in " + dir, e);
            sSLClientSessionCache = null;
        }
        this.a = sSLClientSessionCache;
    }
}
