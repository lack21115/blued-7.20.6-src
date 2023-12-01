package com.tencent.cloud.huiyansdkface.okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.TrustRootIndex;
import com.tencent.thumbplayer.api.TPErrorCode;
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
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/platform/AndroidPlatform.class */
public class AndroidPlatform extends Platform {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f22328a;
    private final OptionalMethod<Socket> b;

    /* renamed from: c  reason: collision with root package name */
    private final OptionalMethod<Socket> f22329c;
    private final OptionalMethod<Socket> d;
    private final OptionalMethod<Socket> e;
    private final CloseGuard f = CloseGuard.a();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/platform/AndroidPlatform$AndroidCertificateChainCleaner.class */
    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

        /* renamed from: a  reason: collision with root package name */
        private final Object f22330a;
        private final Method b;

        AndroidCertificateChainCleaner(Object obj, Method method) {
            this.f22330a = obj;
            this.b = method;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner
        public List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.b.invoke(this.f22330a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
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

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/platform/AndroidPlatform$AndroidTrustRootIndex.class */
    static final class AndroidTrustRootIndex implements TrustRootIndex {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f22331a;
        private final Method b;

        AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.b = method;
            this.f22331a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof AndroidTrustRootIndex) {
                AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
                return this.f22331a.equals(androidTrustRootIndex.f22331a) && this.b.equals(androidTrustRootIndex.b);
            }
            return false;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.b.invoke(this.f22331a, x509Certificate);
                X509Certificate x509Certificate2 = null;
                if (trustAnchor != null) {
                    x509Certificate2 = trustAnchor.getTrustedCert();
                }
                return x509Certificate2;
            } catch (IllegalAccessException e) {
                throw Util.assertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException e2) {
                return null;
            }
        }

        public int hashCode() {
            return this.f22331a.hashCode() + (this.b.hashCode() * 31);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/platform/AndroidPlatform$CloseGuard.class */
    static final class CloseGuard {

        /* renamed from: a  reason: collision with root package name */
        private final Method f22332a;
        private final Method b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f22333c;

        CloseGuard(Method method, Method method2, Method method3) {
            this.f22332a = method;
            this.b = method2;
            this.f22333c = method3;
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
            Method method = this.f22332a;
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
                    this.f22333c.invoke(obj, new Object[0]);
                    z = true;
                } catch (Exception e) {
                    return false;
                }
            }
            return z;
        }
    }

    AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f22328a = cls;
        this.b = optionalMethod;
        this.f22329c = optionalMethod2;
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

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException e) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    public static Platform buildIfSupported() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        try {
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
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        Object a2 = a(sSLSocketFactory, this.f22328a, "sslParameters");
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

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new AndroidCertificateChainCleaner(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception e) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException e) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.b.invokeOptionalWithoutCheckedException(sSLSocket, true);
            this.f22329c.invokeOptionalWithoutCheckedException(sSLSocket, str);
        }
        OptionalMethod<Socket> optionalMethod = this.e;
        if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket)) {
            return;
        }
        this.e.invokeWithoutCheckedException(sSLSocket, a(list));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!Util.isAndroidGetsocknameError(e)) {
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

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (android.os.Build.VERSION.SDK_INT < 22) goto L8;
     */
    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.net.ssl.SSLContext getSSLContext() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.AndroidPlatform.getSSLContext():javax.net.ssl.SSLContext");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        OptionalMethod<Socket> optionalMethod = this.d;
        if (optionalMethod != null && optionalMethod.isSupported(sSLSocket)) {
            byte[] bArr = (byte[]) this.d.invokeWithoutCheckedException(sSLSocket, new Object[0]);
            String str = null;
            if (bArr != null) {
                str = new String(bArr, Util.e);
            }
            return str;
        }
        return null;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String str) {
        return this.f.a(str);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw Util.assertionError("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw Util.assertionError("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw Util.assertionError("unable to determine cleartext support", e);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public void log(int i, String str, Throwable th) {
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
                min = Math.min(indexOf, i3 + TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY);
                Log.println(i2, "OkHttp", str2.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform
    public void logCloseableLeak(String str, Object obj) {
        if (this.f.a(obj)) {
            return;
        }
        log(5, str, null);
    }
}
