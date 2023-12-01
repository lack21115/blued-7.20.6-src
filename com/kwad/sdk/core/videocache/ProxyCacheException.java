package com.kwad.sdk.core.videocache;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/ProxyCacheException.class */
public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 3.3.40";

    public ProxyCacheException(String str) {
        super(str + LIBRARY_VERSION);
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 3.3.40", th);
    }
}
