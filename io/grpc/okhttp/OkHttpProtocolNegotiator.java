package io.grpc.okhttp;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.common.base.Preconditions;
import io.grpc.internal.GrpcUtil;
import io.grpc.okhttp.internal.OptionalMethod;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.Protocol;
import io.grpc.okhttp.internal.Util;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/OkHttpProtocolNegotiator.class */
public class OkHttpProtocolNegotiator {
    protected final Platform platform;
    private static final Logger logger = Logger.getLogger(OkHttpProtocolNegotiator.class.getName());
    private static final Platform DEFAULT_PLATFORM = Platform.get();
    private static OkHttpProtocolNegotiator NEGOTIATOR = createNegotiator(OkHttpProtocolNegotiator.class.getClassLoader());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/OkHttpProtocolNegotiator$AndroidNegotiator.class */
    public static final class AndroidNegotiator extends OkHttpProtocolNegotiator {
        private static final Method GET_APPLICATION_PROTOCOL;
        private static final Method GET_APPLICATION_PROTOCOLS;
        private static final Method SET_APPLICATION_PROTOCOLS;
        private static final Method SET_SERVER_NAMES;
        private static final Constructor<?> SNI_HOST_NAME;
        private static final Method SSL_SOCKETS_IS_SUPPORTED_SOCKET;
        private static final Method SSL_SOCKETS_SET_USE_SESSION_TICKET;
        private static final OptionalMethod<Socket> SET_USE_SESSION_TICKETS = new OptionalMethod<>(null, "setUseSessionTickets", Boolean.TYPE);
        private static final OptionalMethod<Socket> SET_HOSTNAME = new OptionalMethod<>(null, "setHostname", String.class);
        private static final OptionalMethod<Socket> GET_ALPN_SELECTED_PROTOCOL = new OptionalMethod<>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
        private static final OptionalMethod<Socket> SET_ALPN_PROTOCOLS = new OptionalMethod<>(null, "setAlpnProtocols", byte[].class);
        private static final OptionalMethod<Socket> GET_NPN_SELECTED_PROTOCOL = new OptionalMethod<>(byte[].class, "getNpnSelectedProtocol", new Class[0]);
        private static final OptionalMethod<Socket> SET_NPN_PROTOCOLS = new OptionalMethod<>(null, "setNpnProtocols", byte[].class);

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            NoSuchMethodException e;
            ClassNotFoundException e2;
            Method method5;
            Method method6;
            Method method7;
            Method method8;
            Constructor<?> constructor;
            Class<?> cls;
            try {
                method6 = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                try {
                    method = SSLParameters.class.getMethod("getApplicationProtocols", new Class[0]);
                    try {
                        method3 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                        try {
                            cls = Class.forName("android.net.ssl.SSLSockets");
                            method5 = cls.getMethod("isSupportedSocket", SSLSocket.class);
                        } catch (ClassNotFoundException e3) {
                            e2 = e3;
                            method2 = method6;
                            method4 = null;
                        } catch (NoSuchMethodException e4) {
                            e = e4;
                            method2 = method6;
                            method4 = null;
                        }
                    } catch (ClassNotFoundException e5) {
                        e = e5;
                        method2 = method6;
                        method3 = null;
                        method4 = null;
                        e2 = e;
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e2);
                        method5 = method4;
                        method6 = method2;
                        method7 = null;
                        SET_APPLICATION_PROTOCOLS = method6;
                        GET_APPLICATION_PROTOCOLS = method;
                        GET_APPLICATION_PROTOCOL = method3;
                        SSL_SOCKETS_IS_SUPPORTED_SOCKET = method5;
                        SSL_SOCKETS_SET_USE_SESSION_TICKET = method7;
                        method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                        try {
                            constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        } catch (ClassNotFoundException e6) {
                            e = e6;
                            OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                            constructor = null;
                            SET_SERVER_NAMES = method8;
                            SNI_HOST_NAME = constructor;
                        } catch (NoSuchMethodException e7) {
                            e = e7;
                            OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                            constructor = null;
                            SET_SERVER_NAMES = method8;
                            SNI_HOST_NAME = constructor;
                        }
                        SET_SERVER_NAMES = method8;
                        SNI_HOST_NAME = constructor;
                    } catch (NoSuchMethodException e8) {
                        e = e8;
                        method2 = method6;
                        method3 = null;
                        method4 = null;
                        e = e;
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = method4;
                        method6 = method2;
                        method7 = null;
                        SET_APPLICATION_PROTOCOLS = method6;
                        GET_APPLICATION_PROTOCOLS = method;
                        GET_APPLICATION_PROTOCOL = method3;
                        SSL_SOCKETS_IS_SUPPORTED_SOCKET = method5;
                        SSL_SOCKETS_SET_USE_SESSION_TICKET = method7;
                        method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        SET_SERVER_NAMES = method8;
                        SNI_HOST_NAME = constructor;
                    }
                    try {
                        method7 = cls.getMethod("setUseSessionTickets", SSLSocket.class, Boolean.TYPE);
                    } catch (ClassNotFoundException e9) {
                        e2 = e9;
                        method2 = method6;
                        method4 = method5;
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e2);
                        method5 = method4;
                        method6 = method2;
                        method7 = null;
                        SET_APPLICATION_PROTOCOLS = method6;
                        GET_APPLICATION_PROTOCOLS = method;
                        GET_APPLICATION_PROTOCOL = method3;
                        SSL_SOCKETS_IS_SUPPORTED_SOCKET = method5;
                        SSL_SOCKETS_SET_USE_SESSION_TICKET = method7;
                        method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        SET_SERVER_NAMES = method8;
                        SNI_HOST_NAME = constructor;
                    } catch (NoSuchMethodException e10) {
                        e = e10;
                        method2 = method6;
                        method4 = method5;
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = method4;
                        method6 = method2;
                        method7 = null;
                        SET_APPLICATION_PROTOCOLS = method6;
                        GET_APPLICATION_PROTOCOLS = method;
                        GET_APPLICATION_PROTOCOL = method3;
                        SSL_SOCKETS_IS_SUPPORTED_SOCKET = method5;
                        SSL_SOCKETS_SET_USE_SESSION_TICKET = method7;
                        method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        SET_SERVER_NAMES = method8;
                        SNI_HOST_NAME = constructor;
                    }
                } catch (ClassNotFoundException e11) {
                    e = e11;
                    method = null;
                    method2 = method6;
                } catch (NoSuchMethodException e12) {
                    e = e12;
                    method = null;
                    method2 = method6;
                }
            } catch (ClassNotFoundException e13) {
                e = e13;
                method = null;
                method2 = null;
            } catch (NoSuchMethodException e14) {
                e = e14;
                method = null;
                method2 = null;
            }
            SET_APPLICATION_PROTOCOLS = method6;
            GET_APPLICATION_PROTOCOLS = method;
            GET_APPLICATION_PROTOCOL = method3;
            SSL_SOCKETS_IS_SUPPORTED_SOCKET = method5;
            SSL_SOCKETS_SET_USE_SESSION_TICKET = method7;
            try {
                method8 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e15) {
                e = e15;
                method8 = null;
            } catch (NoSuchMethodException e16) {
                e = e16;
                method8 = null;
            }
            SET_SERVER_NAMES = method8;
            SNI_HOST_NAME = constructor;
        }

        AndroidNegotiator(Platform platform) {
            super(platform);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0151  */
        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected void configureTlsExtensions(javax.net.ssl.SSLSocket r12, java.lang.String r13, java.util.List<io.grpc.okhttp.internal.Protocol> r14) {
            /*
                Method dump skipped, instructions count: 383
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpProtocolNegotiator.AndroidNegotiator.configureTlsExtensions(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public String getSelectedProtocol(SSLSocket sSLSocket) {
            Method method = GET_APPLICATION_PROTOCOL;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    if (!(e2.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e2);
                    }
                    OkHttpProtocolNegotiator.logger.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) GET_ALPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, Util.UTF_8);
                    }
                } catch (Exception e3) {
                    OkHttpProtocolNegotiator.logger.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e3);
                }
            }
            if (this.platform.getTlsExtensionType() != Platform.TlsExtensionType.NONE) {
                try {
                    byte[] bArr2 = (byte[]) GET_NPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(sSLSocket, new Object[0]);
                    if (bArr2 != null) {
                        return new String(bArr2, Util.UTF_8);
                    }
                    return null;
                } catch (Exception e4) {
                    OkHttpProtocolNegotiator.logger.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e4);
                    return null;
                }
            }
            return null;
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public String negotiate(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
            String selectedProtocol = getSelectedProtocol(sSLSocket);
            String str2 = selectedProtocol;
            if (selectedProtocol == null) {
                str2 = super.negotiate(sSLSocket, str, list);
            }
            return str2;
        }
    }

    OkHttpProtocolNegotiator(Platform platform) {
        this.platform = (Platform) Preconditions.checkNotNull(platform, "platform");
    }

    static OkHttpProtocolNegotiator createNegotiator(ClassLoader classLoader) {
        boolean z;
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e2) {
                logger.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e2);
                z = false;
            }
        }
        z = true;
        return z ? new AndroidNegotiator(DEFAULT_PLATFORM) : new OkHttpProtocolNegotiator(DEFAULT_PLATFORM);
    }

    public static OkHttpProtocolNegotiator get() {
        return NEGOTIATOR;
    }

    static boolean isValidHostName(String str) {
        if (str.contains(BridgeUtil.UNDERLINE_STR)) {
            return false;
        }
        try {
            GrpcUtil.checkAuthority(str);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] protocolIds(List<Protocol> list) {
        ArrayList arrayList = new ArrayList();
        for (Protocol protocol : list) {
            arrayList.add(protocol.toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    protected void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        this.platform.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return this.platform.getSelectedProtocol(sSLSocket);
    }

    public String negotiate(SSLSocket sSLSocket, String str, @Nullable List<Protocol> list) throws IOException {
        if (list != null) {
            configureTlsExtensions(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String selectedProtocol = getSelectedProtocol(sSLSocket);
            if (selectedProtocol != null) {
                return selectedProtocol;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } finally {
            this.platform.afterHandshake(sSLSocket);
        }
    }
}
