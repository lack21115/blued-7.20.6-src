package android.net.http;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/HttpResponseCache.class */
public final class HttpResponseCache extends ResponseCache implements Closeable {
    private final com.android.okhttp.HttpResponseCache delegate;

    private HttpResponseCache(com.android.okhttp.HttpResponseCache httpResponseCache) {
        this.delegate = httpResponseCache;
    }

    public static HttpResponseCache getInstalled() {
        com.android.okhttp.HttpResponseCache httpResponseCache = ResponseCache.getDefault();
        if (httpResponseCache instanceof com.android.okhttp.HttpResponseCache) {
            return new HttpResponseCache(httpResponseCache);
        }
        return null;
    }

    public static HttpResponseCache install(File file, long j) throws IOException {
        com.android.okhttp.HttpResponseCache httpResponseCache = ResponseCache.getDefault();
        if (httpResponseCache instanceof com.android.okhttp.HttpResponseCache) {
            com.android.okhttp.HttpResponseCache httpResponseCache2 = httpResponseCache;
            if (httpResponseCache2.getDirectory().equals(file) && httpResponseCache2.getMaxSize() == j && !httpResponseCache2.isClosed()) {
                return new HttpResponseCache(httpResponseCache2);
            }
            httpResponseCache2.close();
        }
        com.android.okhttp.HttpResponseCache httpResponseCache3 = new com.android.okhttp.HttpResponseCache(file, j);
        ResponseCache.setDefault(httpResponseCache3);
        return new HttpResponseCache(httpResponseCache3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (ResponseCache.getDefault() == this.delegate) {
            ResponseCache.setDefault(null);
        }
        this.delegate.close();
    }

    public void delete() throws IOException {
        if (ResponseCache.getDefault() == this.delegate) {
            ResponseCache.setDefault(null);
        }
        this.delegate.delete();
    }

    public void flush() {
        try {
            this.delegate.flush();
        } catch (IOException e) {
        }
    }

    @Override // java.net.ResponseCache
    public CacheResponse get(URI uri, String str, Map<String, List<String>> map) throws IOException {
        return this.delegate.get(uri, str, map);
    }

    public int getHitCount() {
        return this.delegate.getHitCount();
    }

    public int getNetworkCount() {
        return this.delegate.getNetworkCount();
    }

    public int getRequestCount() {
        return this.delegate.getRequestCount();
    }

    public long maxSize() {
        return this.delegate.getMaxSize();
    }

    @Override // java.net.ResponseCache
    public CacheRequest put(URI uri, URLConnection uRLConnection) throws IOException {
        return this.delegate.put(uri, uRLConnection);
    }

    public long size() {
        return this.delegate.getSize();
    }
}
