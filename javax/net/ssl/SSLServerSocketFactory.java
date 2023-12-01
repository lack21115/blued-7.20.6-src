package javax.net.ssl;

import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.net.ServerSocketFactory;
import org.apache.harmony.security.fortress.Services;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLServerSocketFactory.class */
public abstract class SSLServerSocketFactory extends ServerSocketFactory {
    private static String defaultName;
    private static ServerSocketFactory defaultServerSocketFactory;
    private static int lastCacheVersion = -1;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x009b -> B:24:0x005f). Please submit an issue!!! */
    public static ServerSocketFactory getDefault() {
        SSLContext sSLContext;
        ServerSocketFactory serverSocketFactory;
        synchronized (SSLServerSocketFactory.class) {
            try {
                int cacheVersion = Services.getCacheVersion();
                if (lastCacheVersion != cacheVersion) {
                    defaultServerSocketFactory = null;
                    defaultName = null;
                    lastCacheVersion = cacheVersion;
                }
                if (defaultServerSocketFactory != null) {
                    serverSocketFactory = defaultServerSocketFactory;
                } else {
                    if (defaultName == null) {
                        defaultName = Security.getProperty("ssl.ServerSocketFactory.provider");
                        if (defaultName != null) {
                            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                            ClassLoader classLoader = contextClassLoader;
                            if (contextClassLoader == null) {
                                classLoader = ClassLoader.getSystemClassLoader();
                            }
                            try {
                                defaultServerSocketFactory = (ServerSocketFactory) Class.forName(defaultName, true, classLoader).newInstance();
                            } catch (Exception e) {
                            }
                        }
                    }
                    if (defaultServerSocketFactory == null) {
                        try {
                            sSLContext = SSLContext.getDefault();
                        } catch (NoSuchAlgorithmException e2) {
                            sSLContext = null;
                        }
                        if (sSLContext != null) {
                            defaultServerSocketFactory = sSLContext.getServerSocketFactory();
                        }
                    }
                    if (defaultServerSocketFactory == null) {
                        defaultServerSocketFactory = new DefaultSSLServerSocketFactory("No ServerSocketFactory installed");
                    }
                    serverSocketFactory = defaultServerSocketFactory;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return serverSocketFactory;
    }

    public abstract String[] getDefaultCipherSuites();

    public abstract String[] getSupportedCipherSuites();
}
