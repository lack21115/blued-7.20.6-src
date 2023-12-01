package javax.net.ssl;

import java.io.IOException;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.net.SocketFactory;
import org.apache.harmony.security.fortress.Services;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLSocketFactory.class */
public abstract class SSLSocketFactory extends SocketFactory {
    private static SocketFactory defaultSocketFactory;
    private static int lastCacheVersion = -1;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x009d -> B:28:0x006c). Please submit an issue!!! */
    public static SocketFactory getDefault() {
        SSLContext sSLContext;
        SocketFactory socketFactory;
        synchronized (SSLSocketFactory.class) {
            try {
                int cacheVersion = Services.getCacheVersion();
                if (defaultSocketFactory == null || lastCacheVersion != cacheVersion) {
                    lastCacheVersion = cacheVersion;
                    String property = Security.getProperty("ssl.SocketFactory.provider");
                    if (property != null) {
                        if (defaultSocketFactory != null) {
                            if (property.equals(defaultSocketFactory.getClass().getName())) {
                                socketFactory = defaultSocketFactory;
                            } else {
                                defaultSocketFactory = null;
                            }
                        }
                        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                        ClassLoader classLoader = contextClassLoader;
                        if (contextClassLoader == null) {
                            classLoader = ClassLoader.getSystemClassLoader();
                        }
                        try {
                            defaultSocketFactory = (SocketFactory) Class.forName(property, true, classLoader).newInstance();
                        } catch (Exception e) {
                            System.logW("Could not create " + property + " with ClassLoader " + classLoader.toString() + ": " + e.getMessage());
                        }
                    } else {
                        defaultSocketFactory = null;
                    }
                    if (defaultSocketFactory == null) {
                        try {
                            sSLContext = SSLContext.getDefault();
                        } catch (NoSuchAlgorithmException e2) {
                            sSLContext = null;
                        }
                        if (sSLContext != null) {
                            defaultSocketFactory = sSLContext.getSocketFactory();
                        }
                    }
                    if (defaultSocketFactory == null) {
                        defaultSocketFactory = new DefaultSSLSocketFactory("No SSLSocketFactory installed");
                    }
                    socketFactory = defaultSocketFactory;
                } else {
                    socketFactory = defaultSocketFactory;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return socketFactory;
    }

    public abstract Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException;

    public abstract String[] getDefaultCipherSuites();

    public abstract String[] getSupportedCipherSuites();
}
