package com.baidu.aip.face.stat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/stat/NetUtil.class */
public class NetUtil {
    private static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.baidu.aip.face.stat.NetUtil.2
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
    private static final String TAG = "NetUtil";

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/stat/NetUtil$RequestAdapter.class */
    public static abstract class RequestAdapter<T> {
        private static final int CONNECT_TIMEOUT = 5000;
        private static final int READ_TIMEOUT = 5000;
        private static final String REQUEST_METHOD = "POST";
        public static final int RESPONSE_STATUS_ERROR_IO = 2;
        public static final int RESPONSE_STATUS_ERROR_PARSE_JSON = 3;
        public static final int RESPONSE_STATUS_ERROR_RESPONSE_CODE = 4;
        public static final int RESPONSE_STATUS_ERROR_TIMEOUT = 1;
        public static final int RESPONSE_STATUS_ERROR_UNKNOWN = 5;
        public static final int RESPONSE_STATUS_NORMAL = 0;
        private static final int RETRY_COUNT = 2;

        public int getConnectTimeout() {
            return 5000;
        }

        public int getReadTimeout() {
            return 5000;
        }

        public String getRequestMethod() {
            return "POST";
        }

        public abstract String getRequestString();

        public int getRetryCount() {
            return 0;
        }

        public abstract String getURL();

        public abstract void parseResponse(InputStream inputStream) throws IOException, JSONException;
    }

    private NetUtil() {
        throw new RuntimeException("This class instance can not be created.");
    }

    public static boolean isConnected(Context context) {
        if (context == null) {
            return false;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT > 23) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            z = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(16);
        }
        return z;
    }

    private static void trustAllHosts() {
        X509TrustManager x509TrustManager = new X509TrustManager() { // from class: com.baidu.aip.face.stat.NetUtil.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x050c A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> void uploadData(com.baidu.aip.face.stat.NetUtil.RequestAdapter<T> r4) {
        /*
            Method dump skipped, instructions count: 1392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.aip.face.stat.NetUtil.uploadData(com.baidu.aip.face.stat.NetUtil$RequestAdapter):void");
    }
}
