package libcore.net.url;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/url/FtpHandler.class */
public class FtpHandler extends URLStreamHandler {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public int getDefaultPort() {
        return 21;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url) throws IOException {
        return new FtpURLConnection(url);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if (url == null || proxy == null) {
            throw new IllegalArgumentException("url == null || proxy == null");
        }
        return new FtpURLConnection(url, proxy);
    }
}
