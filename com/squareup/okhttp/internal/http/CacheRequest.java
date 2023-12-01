package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/internal/http/CacheRequest.class */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
