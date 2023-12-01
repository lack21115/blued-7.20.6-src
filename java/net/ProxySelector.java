package java.net;

import java.io.IOException;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:java/net/ProxySelector.class */
public abstract class ProxySelector {
    private static ProxySelector defaultSelector = new ProxySelectorImpl();

    public static ProxySelector getDefault() {
        return defaultSelector;
    }

    public static void setDefault(ProxySelector proxySelector) {
        defaultSelector = proxySelector;
    }

    public abstract void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException);

    public abstract List<Proxy> select(URI uri);
}
