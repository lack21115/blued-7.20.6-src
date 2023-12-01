package java.net;

import com.alipay.sdk.cons.b;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.net.Proxy;
import java.util.Collections;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:java/net/ProxySelectorImpl.class */
final class ProxySelectorImpl extends ProxySelector {
    private int getSystemPropertyInt(String str, int i) {
        String property = System.getProperty(str);
        int i2 = i;
        if (property != null) {
            try {
                i2 = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i2;
    }

    private boolean isNonProxyHost(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str2.length()) {
                return str.matches(sb.toString());
            }
            char charAt = str2.charAt(i2);
            switch (charAt) {
                case '*':
                    sb.append(".*");
                    break;
                case '.':
                    sb.append("\\.");
                    break;
                default:
                    sb.append(charAt);
                    break;
            }
            i = i2 + 1;
        }
    }

    private Proxy lookupProxy(String str, String str2, Proxy.Type type, int i) {
        String property = System.getProperty(str);
        if (property == null || property.isEmpty()) {
            return null;
        }
        return new Proxy(type, InetSocketAddress.createUnresolved(property, getSystemPropertyInt(str2, i)));
    }

    private Proxy selectOneProxy(URI uri) {
        Proxy lookupProxy;
        if (uri == null) {
            throw new IllegalArgumentException("uri == null");
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            throw new IllegalArgumentException("scheme == null");
        }
        int i = -1;
        Proxy proxy = null;
        String str = null;
        boolean z = true;
        if ("http".equalsIgnoreCase(scheme)) {
            i = 80;
            str = "http.nonProxyHosts";
            proxy = lookupProxy("http.proxyHost", "http.proxyPort", Proxy.Type.HTTP, 80);
        } else if (b.a.equalsIgnoreCase(scheme)) {
            i = 443;
            str = "https.nonProxyHosts";
            proxy = lookupProxy("https.proxyHost", "https.proxyPort", Proxy.Type.HTTP, GrpcUtil.DEFAULT_PORT_SSL);
        } else if ("ftp".equalsIgnoreCase(scheme)) {
            i = 80;
            str = "ftp.nonProxyHosts";
            proxy = lookupProxy("ftp.proxyHost", "ftp.proxyPort", Proxy.Type.HTTP, 80);
        } else if (!"socket".equalsIgnoreCase(scheme)) {
            return Proxy.NO_PROXY;
        } else {
            z = false;
        }
        if (str == null || !isNonProxyHost(uri.getHost(), System.getProperty(str))) {
            if (proxy != null) {
                return proxy;
            }
            if (!z || (lookupProxy = lookupProxy("proxyHost", "proxyPort", Proxy.Type.HTTP, i)) == null) {
                Proxy lookupProxy2 = lookupProxy("socksProxyHost", "socksProxyPort", Proxy.Type.SOCKS, 1080);
                return lookupProxy2 != null ? lookupProxy2 : Proxy.NO_PROXY;
            }
            return lookupProxy;
        }
        return Proxy.NO_PROXY;
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        if (uri == null || socketAddress == null || iOException == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return Collections.singletonList(selectOneProxy(uri));
    }
}
