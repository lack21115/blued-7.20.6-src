package libcore.net.url;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/url/FileHandler.class */
public class FileHandler extends URLStreamHandler {
    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url) throws IOException {
        return openConnection(url, null);
    }

    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }
        String host = url.getHost();
        if (host == null || host.isEmpty() || host.equalsIgnoreCase("localhost")) {
            return new FileURLConnection(url);
        }
        URL url2 = new URL("ftp", host, url.getFile());
        return proxy == null ? url2.openConnection() : url2.openConnection(proxy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public void parseURL(URL url, String str, int i, int i2) {
        if (i2 < i) {
            return;
        }
        String replace = i < i2 ? str.substring(i, i2).replace('\\', '/') : "";
        super.parseURL(url, replace, 0, replace.length());
    }
}
