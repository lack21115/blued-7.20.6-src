package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/AndroidPlatform.class */
public class AndroidPlatform extends Platform {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f43965a;
    private final OptionalMethod<Socket> b;

    /* renamed from: c  reason: collision with root package name */
    private final OptionalMethod<Socket> f43966c;
    private final OptionalMethod<Socket> d;
    private final OptionalMethod<Socket> e;
    private final CloseGuard f = CloseGuard.a();

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/AndroidPlatform$AndroidCertificateChainCleaner.class */
    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

        /* renamed from: a  reason: collision with root package name */
        private final Object f43967a;
        private final Method b;

        AndroidCertificateChainCleaner(Object obj, Method method) {
            this.f43967a = obj;
            this.b = method;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.b.invoke(this.f43967a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/AndroidPlatform$AndroidTrustRootIndex.class */
    static final class AndroidTrustRootIndex implements TrustRootIndex {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f43968a;
        private final Method b;

        AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.b = method;
            this.f43968a = x509TrustManager;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.b.invoke(this.f43968a, x509Certificate);
                X509Certificate x509Certificate2 = null;
                if (trustAnchor != null) {
                    x509Certificate2 = trustAnchor.getTrustedCert();
                }
                return x509Certificate2;
            } catch (IllegalAccessException e) {
                throw Util.a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException e2) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof AndroidTrustRootIndex) {
                AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
                return this.f43968a.equals(androidTrustRootIndex.f43968a) && this.b.equals(androidTrustRootIndex.b);
            }
            return false;
        }

        public int hashCode() {
            return this.f43968a.hashCode() + (this.b.hashCode() * 31);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/platform/AndroidPlatform$CloseGuard.class */
    static final class CloseGuard {

        /* renamed from: a  reason: collision with root package name */
        private final Method f43969a;
        private final Method b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f43970c;

        CloseGuard(Method method, Method method2, Method method3) {
            this.f43969a = method;
            this.b = method2;
            this.f43970c = method3;
        }

        static CloseGuard a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception e) {
                method = null;
                method2 = null;
            }
            return new CloseGuard(method3, method2, method);
        }

        Object a(String str) {
            Method method = this.f43969a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.b.invoke(invoke, str);
                    return invoke;
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        }

        boolean a(Object obj) {
            boolean z = false;
            if (obj != null) {
                try {
                    this.f43970c.invoke(obj, new Object[0]);
                    z = true;
                } catch (Exception e) {
                    return false;
                }
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f43965a = cls;
        this.b = optionalMethod;
        this.f43966c = optionalMethod2;
        this.d = optionalMethod3;
        this.e = optionalMethod4;
    }

    private static boolean a() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException e) {
            return b(str, cls, obj);
        }
    }

    public static Platform b() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        try {
            if (Platform.h()) {
                try {
                    cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                } catch (ClassNotFoundException e) {
                    cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
                }
                OptionalMethod optionalMethod3 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
                OptionalMethod optionalMethod4 = new OptionalMethod(null, "setHostname", String.class);
                if (a()) {
                    optionalMethod = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    optionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                } else {
                    optionalMethod = null;
                    optionalMethod2 = null;
                }
                return new AndroidPlatform(cls, optionalMethod3, optionalMethod4, optionalMethod, optionalMethod2);
            }
            return null;
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException e) {
            return super.b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError e) {
            return 0;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public Object a(String str) {
        return this.f.a(str);
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String a(SSLSocket sSLSocket) {
        OptionalMethod<Socket> optionalMethod = this.d;
        if (optionalMethod != null && optionalMethod.a((OptionalMethod<Socket>) sSLSocket)) {
            byte[] bArr = (byte[]) this.d.d(sSLSocket, new Object[0]);
            String str = null;
            if (bArr != null) {
                str = new String(bArr, Util.e);
            }
            return str;
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    protected X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        Object a2 = a(sSLSocketFactory, this.f43965a, "sslParameters");
        Object obj = a2;
        if (a2 == null) {
            try {
                obj = a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException e) {
                return super.a(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) a(obj, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) a(obj, X509TrustManager.class, "trustManager");
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception e) {
            return super.a(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void a(int i, String str, @Nullable Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        String str2 = str;
        if (th != null) {
            str2 = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str2.length();
        while (i3 < length) {
            int indexOf = str2.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str2.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void a(String str, Object obj) {
        if (this.f.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    @Override // okhttp3.internal.platform.Platform
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!Util.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        if (str != null) {
            this.b.b(sSLSocket, true);
            this.f43966c.b(sSLSocket, str);
        }
        OptionalMethod<Socket> optionalMethod = this.e;
        if (optionalMethod == null || !optionalMethod.a((OptionalMethod<Socket>) sSLSocket)) {
            return;
        }
        this.e.d(sSLSocket, b(list));
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException e) {
            return super.b(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean b(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return super.b(str);
        }
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw Util.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw Util.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw Util.a("unable to determine cleartext support", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (android.os.Build.VERSION.SDK_INT < 22) goto L8;
     */
    @Override // okhttp3.internal.platform.Platform
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.net.ssl.SSLContext c() {
        /*
            r5 = this;
            r0 = 1
            r6 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> L3f
            r1 = 16
            if (r0 < r1) goto L17
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoClassDefFoundError -> L3f
            r7 = r0
            r0 = r7
            r1 = 22
            if (r0 >= r1) goto L17
            goto L1c
        L17:
            r0 = 0
            r6 = r0
            goto L1c
        L1c:
            r0 = r6
            if (r0 == 0) goto L29
            java.lang.String r0 = "TLSv1.2"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L43
            r8 = r0
            r0 = r8
            return r0
        L29:
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L32
            r8 = r0
            r0 = r8
            return r0
        L32:
            r8 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "No TLS provider"
            r3 = r8
            r1.<init>(r2, r3)
            throw r0
        L3f:
            r8 = move-exception
            goto L1c
        L43:
            r8 = move-exception
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.AndroidPlatform.c():javax.net.ssl.SSLContext");
    }
}
