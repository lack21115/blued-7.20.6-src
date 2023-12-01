package java.net;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-2895416-dex2jar.jar:java/net/CacheRequest.class */
public abstract class CacheRequest {
    public abstract void abort();

    public abstract OutputStream getBody() throws IOException;
}
