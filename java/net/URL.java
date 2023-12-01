package java.net;

import android.content.ContentResolver;
import com.cdo.oaps.ad.OapsKey;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import libcore.net.url.FileHandler;
import libcore.net.url.FtpHandler;
import libcore.net.url.JarHandler;
import libcore.net.url.UrlUtils;

/* loaded from: source-2895416-dex2jar.jar:java/net/URL.class */
public final class URL implements Serializable {
    private static final long serialVersionUID = -7627629688361524110L;
    private static URLStreamHandlerFactory streamHandlerFactory;
    private static final Hashtable<String, URLStreamHandler> streamHandlers = new Hashtable<>();
    private String authority;
    private String file;
    private transient int hashCode;
    private String host;
    private transient String path;
    private int port;
    private String protocol;
    private transient String query;
    private String ref;
    transient URLStreamHandler streamHandler;
    private transient String userInfo;

    public URL(String str) throws MalformedURLException {
        this((URL) null, str, (URLStreamHandler) null);
    }

    public URL(String str, String str2, int i, String str3) throws MalformedURLException {
        this(str, str2, i, str3, null);
    }

    public URL(String str, String str2, int i, String str3, URLStreamHandler uRLStreamHandler) throws MalformedURLException {
        this.port = -1;
        if (i < -1) {
            throw new MalformedURLException("port < -1: " + i);
        }
        if (str == null) {
            throw new NullPointerException("protocol == null");
        }
        String str4 = str2;
        if (str2 != null) {
            str4 = str2;
            if (str2.contains(":")) {
                str4 = str2;
                if (str2.charAt(0) != '[') {
                    str4 = "[" + str2 + "]";
                }
            }
        }
        this.protocol = str;
        this.host = str4;
        this.port = i;
        String authoritySafePath = UrlUtils.authoritySafePath(str4, str3);
        int indexOf = authoritySafePath.indexOf("#");
        if (indexOf != -1) {
            this.file = authoritySafePath.substring(0, indexOf);
            this.ref = authoritySafePath.substring(indexOf + 1);
        } else {
            this.file = authoritySafePath;
        }
        fixURL(false);
        if (uRLStreamHandler != null) {
            this.streamHandler = uRLStreamHandler;
            return;
        }
        setupStreamHandler();
        if (this.streamHandler == null) {
            throw new MalformedURLException("Unknown protocol: " + str);
        }
    }

    public URL(String str, String str2, String str3) throws MalformedURLException {
        this(str, str2, -1, str3, null);
    }

    public URL(URL url, String str) throws MalformedURLException {
        this(url, str, (URLStreamHandler) null);
    }

    public URL(URL url, String str, URLStreamHandler uRLStreamHandler) throws MalformedURLException {
        this.port = -1;
        if (str == null) {
            throw new MalformedURLException();
        }
        if (uRLStreamHandler != null) {
            this.streamHandler = uRLStreamHandler;
        }
        String trim = str.trim();
        this.protocol = UrlUtils.getSchemePrefix(trim);
        int length = this.protocol != null ? this.protocol.length() + 1 : 0;
        URL url2 = url;
        if (this.protocol != null) {
            url2 = url;
            if (url != null) {
                url2 = url;
                if (!this.protocol.equals(url.protocol)) {
                    url2 = null;
                }
            }
        }
        if (url2 != null) {
            set(url2.protocol, url2.getHost(), url2.getPort(), url2.getAuthority(), url2.getUserInfo(), url2.getPath(), url2.getQuery(), url2.getRef());
            if (this.streamHandler == null) {
                this.streamHandler = url2.streamHandler;
            }
        } else if (this.protocol == null) {
            throw new MalformedURLException("Protocol not found: " + trim);
        }
        if (this.streamHandler == null) {
            setupStreamHandler();
            if (this.streamHandler == null) {
                throw new MalformedURLException("Unknown protocol: " + this.protocol);
            }
        }
        try {
            this.streamHandler.parseURL(this, trim, length, trim.length());
        } catch (Exception e) {
            throw new MalformedURLException(e.toString());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        try {
            objectInputStream.defaultReadObject();
            if (this.host != null && this.authority == null) {
                fixURL(true);
            } else if (this.authority != null) {
                int lastIndexOf = this.authority.lastIndexOf(64);
                if (lastIndexOf > -1) {
                    this.userInfo = this.authority.substring(0, lastIndexOf);
                }
                if (this.file != null) {
                    int indexOf = this.file.indexOf(63);
                    if (indexOf > -1) {
                        this.query = this.file.substring(indexOf + 1);
                        this.path = this.file.substring(0, indexOf);
                    }
                }
                this.path = this.file;
            }
            setupStreamHandler();
            if (this.streamHandler == null) {
                throw new IOException("Unknown protocol: " + this.protocol);
            }
            this.hashCode = 0;
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    public static void setURLStreamHandlerFactory(URLStreamHandlerFactory uRLStreamHandlerFactory) {
        synchronized (URL.class) {
            try {
                if (streamHandlerFactory != null) {
                    throw new Error("Factory already set");
                }
                streamHandlers.clear();
                streamHandlerFactory = uRLStreamHandlerFactory;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return this.streamHandler.equals(this, (URL) obj);
        }
        return false;
    }

    void fixURL(boolean z) {
        int indexOf;
        int lastIndexOf;
        if (this.host != null && this.host.length() > 0) {
            this.authority = this.host;
            if (this.port != -1) {
                this.authority += ":" + this.port;
            }
        }
        if (z) {
            if (this.host == null || (lastIndexOf = this.host.lastIndexOf(64)) <= -1) {
                this.userInfo = null;
            } else {
                this.userInfo = this.host.substring(0, lastIndexOf);
                this.host = this.host.substring(lastIndexOf + 1);
            }
        }
        if (this.file == null || (indexOf = this.file.indexOf(63)) <= -1) {
            this.query = null;
            this.path = this.file;
            return;
        }
        this.query = this.file.substring(indexOf + 1);
        this.path = this.file.substring(0, indexOf);
    }

    public String getAuthority() {
        return this.authority;
    }

    public final Object getContent() throws IOException {
        return openConnection().getContent();
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        return openConnection().getContent(clsArr);
    }

    public int getDefaultPort() {
        return this.streamHandler.getDefaultPort();
    }

    public int getEffectivePort() {
        return URI.getEffectivePort(this.protocol, this.port);
    }

    public String getFile() {
        return this.file;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getQuery() {
        return this.query;
    }

    public String getRef() {
        return this.ref;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.streamHandler.hashCode(this);
        }
        return this.hashCode;
    }

    public URLConnection openConnection() throws IOException {
        return this.streamHandler.openConnection(this);
    }

    public URLConnection openConnection(Proxy proxy) throws IOException {
        if (proxy == null) {
            throw new IllegalArgumentException("proxy == null");
        }
        return this.streamHandler.openConnection(this, proxy);
    }

    public final InputStream openStream() throws IOException {
        return openConnection().getInputStream();
    }

    public boolean sameFile(URL url) {
        return this.streamHandler.sameFile(this, url);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void set(String str, String str2, int i, String str3, String str4) {
        if (this.protocol == null) {
            this.protocol = str;
        }
        this.host = str2;
        this.file = str3;
        this.port = i;
        this.ref = str4;
        this.hashCode = 0;
        fixURL(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void set(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str5;
        if (str6 != null) {
            str8 = str5;
            if (!str6.isEmpty()) {
                str8 = str5 + "?" + str6;
            }
        }
        set(str, str2, i, str8, str7);
        this.authority = str3;
        this.userInfo = str4;
        this.path = str5;
        this.query = str6;
    }

    void setupStreamHandler() {
        this.streamHandler = streamHandlers.get(this.protocol);
        if (this.streamHandler != null) {
            return;
        }
        if (streamHandlerFactory != null) {
            this.streamHandler = streamHandlerFactory.createURLStreamHandler(this.protocol);
            if (this.streamHandler != null) {
                streamHandlers.put(this.protocol, this.streamHandler);
                return;
            }
        }
        String property = System.getProperty("java.protocol.handler.pkgs");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (property != null && contextClassLoader != null) {
            String[] split = property.split("\\|");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                try {
                    this.streamHandler = (URLStreamHandler) contextClassLoader.loadClass(split[i2] + "." + this.protocol + ".Handler").newInstance();
                    if (this.streamHandler != null) {
                        streamHandlers.put(this.protocol, this.streamHandler);
                        return;
                    }
                    return;
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    i = i2 + 1;
                }
                i = i2 + 1;
            }
        }
        if (this.protocol.equals(ContentResolver.SCHEME_FILE)) {
            this.streamHandler = new FileHandler();
        } else if (this.protocol.equals(OapsKey.KEY_FILE_TYPE)) {
            this.streamHandler = new FtpHandler();
        } else if (this.protocol.equals("http")) {
            try {
                this.streamHandler = (URLStreamHandler) Class.forName("com.android.okhttp.HttpHandler").newInstance();
            } catch (Exception e2) {
                throw new AssertionError(e2);
            }
        } else if (this.protocol.equals("https")) {
            try {
                this.streamHandler = (URLStreamHandler) Class.forName("com.android.okhttp.HttpsHandler").newInstance();
            } catch (Exception e3) {
                throw new AssertionError(e3);
            }
        } else if (this.protocol.equals(ShareConstants.DEXMODE_JAR)) {
            this.streamHandler = new JarHandler();
        }
        if (this.streamHandler != null) {
            streamHandlers.put(this.protocol, this.streamHandler);
        }
    }

    public String toExternalForm() {
        return this.streamHandler == null ? "unknown protocol(" + this.protocol + ")://" + this.host + this.file : this.streamHandler.toExternalForm(this);
    }

    public String toString() {
        return toExternalForm();
    }

    public URI toURI() throws URISyntaxException {
        return new URI(toExternalForm());
    }

    public URI toURILenient() throws URISyntaxException {
        if (this.streamHandler == null) {
            throw new IllegalStateException(this.protocol);
        }
        return new URI(this.streamHandler.toExternalForm(this, true));
    }
}
