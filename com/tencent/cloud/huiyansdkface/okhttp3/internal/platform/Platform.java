package com.tencent.cloud.huiyansdkface.okhttp3.internal.platform;

import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.BasicCertificateChainCleaner;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.BasicTrustRootIndex;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.TrustRootIndex;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/platform/Platform.class */
public class Platform {

    /* renamed from: a  reason: collision with root package name */
    private static final Platform f22336a = a();
    private static final Logger b = Logger.getLogger(OkHttpClient.class.getName());

    private static Platform a() {
        Platform buildIfSupported = AndroidPlatform.buildIfSupported();
        return buildIfSupported != null ? buildIfSupported : new Platform();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Object obj, Class<T> cls, String str) {
        Object a2;
        Class<?> cls2 = obj.getClass();
        while (true) {
            Class<?> cls3 = cls2;
            if (cls3 == Object.class) {
                if (str.equals("delegate") || (a2 = a(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) a(a2, cls, str);
            }
            try {
                Field declaredField = cls3.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null || !cls.isInstance(obj2)) {
                    return null;
                }
                return cls.cast(obj2);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (NoSuchFieldException e2) {
                cls2 = cls3.getSuperclass();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return buffer.readByteArray();
            }
            Protocol protocol = list.get(i2);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
            i = i2 + 1;
        }
    }

    public static List<String> alpnProtocolNames(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return arrayList;
            }
            Protocol protocol = list.get(i2);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
            i = i2 + 1;
        }
    }

    public static Platform get() {
        return f22336a;
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object a2 = a(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (a2 == null) {
                return null;
            }
            return (X509TrustManager) a(a2, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager a2 = a(sSLSocketFactory);
        if (a2 != null) {
            return buildCertificateChainCleaner(a2);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void configureSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public SSLContext getSSLContext() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException e) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public Object getStackTraceForCloseable(String str) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public void log(int i, String str, Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void logCloseableLeak(String str, Object obj) {
        String str2 = str;
        if (obj == null) {
            str2 = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str2, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
