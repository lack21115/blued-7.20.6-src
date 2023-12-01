package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/cache/CacheRequest.class */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
