package okhttp3.internal.platform;

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
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/Platform.class */
public class Platform {

    /* renamed from: a  reason: collision with root package name */
    private static final Platform f43978a = a();
    private static final Logger b = Logger.getLogger(OkHttpClient.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
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

    public static List<String> a(List<Protocol> list) {
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

    private static Platform a() {
        return h() ? d() : b();
    }

    private static Platform b() {
        ConscryptPlatform a2;
        if (!g() || (a2 = ConscryptPlatform.a()) == null) {
            Jdk9Platform a3 = Jdk9Platform.a();
            if (a3 != null) {
                return a3;
            }
            Platform a4 = JdkWithJettyBootPlatform.a();
            return a4 != null ? a4 : new Platform();
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(List<Protocol> list) {
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

    private static Platform d() {
        Platform a2 = Android10Platform.a();
        if (a2 != null) {
            return a2;
        }
        Platform b2 = AndroidPlatform.b();
        if (b2 != null) {
            return b2;
        }
        throw new NullPointerException("No platform found on Android");
    }

    public static Platform e() {
        return f43978a;
    }

    public static boolean g() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public static boolean h() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public Object a(String str) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    @Nullable
    public String a(SSLSocket sSLSocket) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
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

    public CertificateChainCleaner a(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(b(x509TrustManager));
    }

    public void a(int i, String str, @Nullable Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void a(String str, Object obj) {
        String str2 = str;
        if (obj == null) {
            str2 = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str2, (Throwable) obj);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) throws IOException {
    }

    public TrustRootIndex b(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void b(SSLSocket sSLSocket) {
    }

    public void b(SSLSocketFactory sSLSocketFactory) {
    }

    public boolean b(String str) {
        return true;
    }

    public SSLContext c() {
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

    public CertificateChainCleaner c(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager a2 = a(sSLSocketFactory);
        if (a2 != null) {
            return a(a2);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + e() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public String f() {
        return "OkHttp";
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
