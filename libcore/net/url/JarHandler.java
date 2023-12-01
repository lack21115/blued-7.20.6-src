package libcore.net.url;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* loaded from: source-2895416-dex2jar.jar:libcore/net/url/JarHandler.class */
public class JarHandler extends URLStreamHandler {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL url) throws IOException {
        return new JarURLConnectionImpl(url);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public void parseURL(URL url, String str, int i, int i2) {
        String file = url.getFile();
        String str2 = file;
        if (file == null) {
            str2 = "";
        }
        String substring = i2 > i ? str.substring(i, i2) : "";
        if (substring.indexOf("!/") == -1 && str2.indexOf("!/") == -1) {
            throw new NullPointerException("Cannot find \"!/\"");
        }
        if (!str2.isEmpty()) {
            if (substring.charAt(0) == '/') {
                substring = str2.substring(0, str2.indexOf(33) + 1) + substring;
            } else {
                int indexOf = str2.indexOf(33);
                substring = str2.substring(0, indexOf + 1) + UrlUtils.canonicalizePath(str2.substring(indexOf + 1, str2.lastIndexOf(47) + 1) + substring, true);
            }
        }
        try {
            new URL(substring);
            setURL(url, ShareConstants.DEXMODE_JAR, "", -1, null, null, substring, null, null);
        } catch (MalformedURLException e) {
            throw new NullPointerException(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public String toExternalForm(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append("jar:");
        sb.append(url.getFile());
        String ref = url.getRef();
        if (ref != null) {
            sb.append(ref);
        }
        return sb.toString();
    }
}
