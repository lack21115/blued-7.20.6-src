package com.android.org.conscrypt;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructTimeval;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.ECParameterSpec;
import javax.net.ssl.X509TrustManager;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.utils.AlgNameMapperSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/Platform.class */
public class Platform {

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/Platform$NoPreloadHolder.class */
    private static class NoPreloadHolder {
        public static final Platform MAPPER = new Platform();

        private NoPreloadHolder() {
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/Platform$OpenSSLMapper.class */
    private static class OpenSSLMapper implements AlgNameMapperSource {
        private OpenSSLMapper() {
        }

        @Override // org.apache.harmony.security.utils.AlgNameMapperSource
        public String mapNameToOid(String str) {
            return NativeCrypto.OBJ_txt2nid_oid(str);
        }

        @Override // org.apache.harmony.security.utils.AlgNameMapperSource
        public String mapOidToName(String str) {
            return NativeCrypto.OBJ_txt2nid_longName(str);
        }
    }

    private Platform() {
        AlgNameMapper.setSource(new OpenSSLMapper());
    }

    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        if (x509TrustManager instanceof TrustManagerImpl) {
            ((TrustManagerImpl) x509TrustManager).checkServerTrusted(x509CertificateArr, str, str2);
        } else {
            x509TrustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    public static String getCurveName(ECParameterSpec eCParameterSpec) {
        return eCParameterSpec.getCurveName();
    }

    public static FileDescriptor getFileDescriptor(Socket socket) {
        return socket.getFileDescriptor$();
    }

    public static FileDescriptor getFileDescriptorFromSSLSocket(OpenSSLSocketImpl openSSLSocketImpl) {
        try {
            Field declaredField = Socket.class.getDeclaredField("impl");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(openSSLSocketImpl);
            Field declaredField2 = SocketImpl.class.getDeclaredField("fd");
            declaredField2.setAccessible(true);
            return (FileDescriptor) declaredField2.get(obj);
        } catch (Exception e) {
            throw new RuntimeException("Can't get FileDescriptor from socket", e);
        }
    }

    public static boolean isLiteralIpAddress(String str) {
        return InetAddress.isNumeric(str);
    }

    public static boolean isSniEnabledByDefault() {
        return false;
    }

    public static void logEvent(String str) {
        try {
            Class<?> cls = Class.forName("android.os.Process");
            int intValue = ((Integer) cls.getMethod("myUid", null).invoke(cls.newInstance(), new Object[0])).intValue();
            Class<?> cls2 = Class.forName("android.util.EventLog");
            cls2.getMethod("writeEvent", Integer.TYPE, Object[].class).invoke(cls2.newInstance(), 1397638484, new Object[]{"conscrypt", Integer.valueOf(intValue), str});
        } catch (Exception e) {
        }
    }

    private void ping() {
    }

    public static void setCurveName(ECParameterSpec eCParameterSpec, String str) {
        eCParameterSpec.setCurveName(str);
    }

    public static void setSocketWriteTimeout(Socket socket, long j) throws SocketException {
        try {
            Os.setsockoptTimeval(socket.getFileDescriptor$(), OsConstants.SOL_SOCKET, OsConstants.SO_SNDTIMEO, StructTimeval.fromMillis(j));
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    public static void setup() {
        NoPreloadHolder.MAPPER.ping();
    }

    public static OpenSSLKey wrapRsaKey(PrivateKey privateKey) {
        return null;
    }
}
