package com.tencent.liteav.base.http;

import android.net.wifi.WifiEnterpriseConfig;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLException;

@JNINamespace("liteav")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/HttpClientAndroid.class */
public class HttpClientAndroid {
    private static final int ERROR_CODE_INVALID_REQUEST = 0;
    private static final String HTTPS_PREFIX = "https://";
    private static final String HTTP_PREFIX = "http://";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final int READ_STREAM_SIZE = 1388;
    private static final String TAG = "HttpClientAndroid";
    private HttpURLConnection mConnection;
    private final b mHttpConfig;
    private final Handler mHttpHandler;
    private String mLastRequestURL;
    private long mNativeHttpClientAndroidJni;
    private final ConcurrentHashMap<Long, d> mRunningRequestMap = new ConcurrentHashMap<>();
    private final Object mLocker = new Object();
    private volatile c mInternalState = c.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/HttpClientAndroid$a.class */
    public static final class a extends Authenticator {

        /* renamed from: a  reason: collision with root package name */
        String f36283a;
        String b;

        a(String str, String str2) {
            this.f36283a = str;
            this.b = str2;
        }

        @Override // java.net.Authenticator
        protected final PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.f36283a, this.b.toCharArray());
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/HttpClientAndroid$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f36284a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f36285c;
        boolean d;
        int e;
        String f;
        String g;
        String h;

        b(int i, int i2, int i3, boolean z, int i4, String str, String str2, String str3) {
            this.f36284a = i;
            this.b = i2;
            this.f36285c = i3;
            this.d = z;
            this.e = i4;
            this.f = str;
            this.g = str2;
            this.h = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/HttpClientAndroid$c.class */
    public enum c {
        NONE,
        RUNNING_REPEAT,
        RUNNING_ONCE
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/HttpClientAndroid$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        long f36288a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f36289c;
        byte[] d;
        Map<String, String> e;

        d(String str, String str2, byte[] bArr, Map<String, String> map) {
            this.b = str;
            this.f36289c = str2;
            this.d = bArr;
            this.e = map;
        }

        final boolean a() {
            byte[] bArr = this.d;
            return bArr != null && bArr.length > 0;
        }

        final boolean b() {
            return "POST".equals(c());
        }

        final String c() {
            return TextUtils.isEmpty(this.f36289c) ? "" : "POST".equalsIgnoreCase(this.f36289c) ? "POST" : "GET".equalsIgnoreCase(this.f36289c) ? "GET" : "";
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Request{requestId=");
            sb.append(this.f36288a);
            sb.append(", url='");
            sb.append(this.b);
            sb.append('\'');
            sb.append(", method='");
            sb.append(this.f36289c);
            sb.append('\'');
            sb.append(", body.size=");
            sb.append(a() ? this.d.length : 0);
            sb.append(", headers=");
            sb.append(this.e);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/HttpClientAndroid$e.class */
    public static final class e {

        /* renamed from: c  reason: collision with root package name */
        ByteBuffer f36291c;

        /* renamed from: a  reason: collision with root package name */
        g f36290a = g.kUnknownError;
        String b = "";
        int d = 0;
        String e = "";
        Map<String, String> f = null;
        int g = 0;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/HttpClientAndroid$f.class */
    public enum f {
        CONNECTED(0),
        DISCONNECTED(1),
        FINISHED(2);
        
        int nativeValue;

        f(int i) {
            this.nativeValue = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/HttpClientAndroid$g.class */
    public enum g {
        kHTTP200OK(200),
        kHTTP204NoContent(204),
        kHTTP302Found(302),
        kHTTP304NotModified(304),
        kHTTP403Forbidden(403),
        kHTTP404NotFound(404),
        kHTTP503ServiceUnavailable(503),
        kSystemFileOpenFailed(1001),
        kSystemFileWriteFailed(1002),
        kSystemUnknownHost(1003),
        kSystemConnectHostFailed(1004),
        kSystemCreateSocketFailed(1005),
        kSystemNetworkDisabled(1006),
        kSystemConnectTimeout(1007),
        kSystemConnectRefused(1008),
        kSystemProtocolError(1009),
        kSystemSSLError(1010),
        kUnknownError(WindowManager.LayoutParams.LAST_SUB_WINDOW);
        
        final int nativeValue;

        g(int i) {
            this.nativeValue = i;
        }
    }

    public HttpClientAndroid(int i, int i2, int i3, boolean z, int i4, String str, String str2, String str3, long j) {
        LiteavLog.i(TAG, "Create http client(" + hashCode() + ").");
        this.mHttpConfig = new b(i, i2, i3, z, i4, str, str2, str3);
        this.mNativeHttpClientAndroidJni = j;
        HandlerThread handlerThread = new HandlerThread("HttpClient_" + hashCode());
        handlerThread.start();
        this.mHttpHandler = new Handler(handlerThread.getLooper());
    }

    private boolean checkNativeValid() {
        boolean z;
        synchronized (this.mLocker) {
            z = this.mNativeHttpClientAndroidJni != -1;
        }
        return z;
    }

    private boolean checkRequestValid(long j) {
        return this.mRunningRequestMap.containsKey(Long.valueOf(j));
    }

    private void closeConnectionSafely(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private HttpURLConnection createConnection(d dVar) throws Exception {
        Proxy proxy;
        if (!TextUtils.isEmpty(this.mHttpConfig.f) || this.mHttpConfig.e <= 0) {
            proxy = null;
        } else {
            proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(this.mHttpConfig.f, this.mHttpConfig.e));
            Authenticator.setDefault(new a(this.mHttpConfig.g, this.mHttpConfig.h));
        }
        URL url = new URL(dVar.b.replace(" ", "%20"));
        HttpURLConnection httpURLConnection = proxy != null ? (HttpURLConnection) url.openConnection(proxy) : (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(this.mHttpConfig.f36284a);
        httpURLConnection.setReadTimeout(this.mHttpConfig.b);
        httpURLConnection.setRequestProperty("Accept-Encoding", WifiEnterpriseConfig.IDENTITY_KEY);
        httpURLConnection.setRequestMethod(dVar.c());
        if (dVar.b()) {
            httpURLConnection.setDoOutput(true);
        }
        if (this.mHttpConfig.d) {
            httpURLConnection.setRequestProperty("Connection", com.anythink.expressad.foundation.g.f.g.c.f7906c);
        }
        if (dVar.e != null && !dVar.e.isEmpty()) {
            for (Map.Entry<String, String> entry : dVar.e.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return httpURLConnection;
    }

    private void doCleanById(long j, boolean z) {
        this.mRunningRequestMap.remove(Long.valueOf(j));
        if (this.mRunningRequestMap.size() == 0) {
            synchronized (this.mLocker) {
                this.mInternalState = c.NONE;
            }
        }
        if (z) {
            closeConnectionSafely(this.mConnection);
            this.mConnection = null;
        }
    }

    private void doOnCallback(f fVar, long j, e eVar) {
        synchronized (this.mLocker) {
            if (checkNativeValid() && checkRequestValid(j) && eVar != null) {
                nativeOnCallback(this.mNativeHttpClientAndroidJni, c.RUNNING_REPEAT == this.mInternalState, fVar.nativeValue, j, eVar.f36290a.nativeValue, eVar.b, eVar.g, eVar.f36291c, eVar.e, eVar.f, eVar.d);
            }
        }
    }

    private void doReadData(long j, e eVar) {
        boolean z;
        int read;
        if (!checkRequestValid(j)) {
            LiteavLog.w(TAG, "Do read data failed. Invalid request id. id:".concat(String.valueOf(j)));
            return;
        }
        try {
            InputStream inputStream = this.mConnection.getInputStream();
            synchronized (this.mLocker) {
                z = this.mInternalState == c.RUNNING_ONCE;
            }
            if (z) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[READ_STREAM_SIZE];
                do {
                    try {
                        read = inputStream.read(bArr);
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        LiteavLog.e(TAG, "Do read data failed. Catch error when reading.");
                        eVar.f36290a = getStatusCode(e2);
                        eVar.b = e2.toString();
                        doOnCallback(f.DISCONNECTED, j, eVar);
                        doCleanById(j, true);
                        return;
                    }
                } while (read > 0 && checkRequestValid(j));
                int size = byteArrayOutputStream.size();
                if (size > 0) {
                    eVar.f36291c = ByteBuffer.allocateDirect(size);
                    eVar.f36291c.put(byteArrayOutputStream.toByteArray(), 0, size);
                    eVar.d = size;
                }
            } else {
                byte[] bArr2 = new byte[READ_STREAM_SIZE];
                try {
                    int read2 = inputStream.read(bArr2);
                    if (read2 > 0) {
                        eVar.f36291c = ByteBuffer.allocateDirect(read2);
                        eVar.f36291c.put(bArr2, 0, read2);
                        eVar.d = read2;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    LiteavLog.e(TAG, "Do read data failed. Catch error when reading.");
                    eVar.f36290a = getStatusCode(e3);
                    eVar.b = e3.toString();
                    doOnCallback(f.DISCONNECTED, j, eVar);
                    doCleanById(j, true);
                    return;
                }
            }
            if (eVar.d == 0 && !z) {
                LiteavLog.w(TAG, "Do read data failed. Rsp size is 0.");
                doOnCallback(f.FINISHED, j, eVar);
                doCleanById(j, true);
            } else if (z) {
                doOnCallback(f.FINISHED, j, eVar);
                doCleanById(j, !this.mHttpConfig.d);
            } else {
                doOnCallback(f.CONNECTED, j, eVar);
                this.mHttpHandler.post(com.tencent.liteav.base.http.d.a(this, eVar, j));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            LiteavLog.e(TAG, "Do read data failed. Fail to get InputStream.");
            eVar.f36290a = getStatusCode(e4);
            eVar.b = e4.toString();
            doOnCallback(f.DISCONNECTED, j, eVar);
            doCleanById(j, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequest(d dVar) {
        boolean z;
        if (!checkRequestValid(dVar.f36288a)) {
            LiteavLog.w(TAG, "Do send failed. ignore request when cancelled. request:".concat(String.valueOf(dVar)));
            return;
        }
        e eVar = new e();
        synchronized (this.mLocker) {
            z = this.mInternalState == c.RUNNING_ONCE;
        }
        OutputStream outputStream = null;
        if (z && this.mConnection != null && !dVar.b.equals(this.mLastRequestURL)) {
            closeConnectionSafely(this.mConnection);
            this.mConnection = null;
        }
        this.mLastRequestURL = dVar.b;
        try {
            this.mConnection = createConnection(dVar);
            if (dVar.b() && dVar.a()) {
                try {
                    OutputStream outputStream2 = this.mConnection.getOutputStream();
                    outputStream2.write(dVar.d);
                    outputStream = outputStream2;
                    outputStream2.flush();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    LiteavLog.w(TAG, "Do send body failed.");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            try {
                eVar.f36290a = getStatusCode(this.mConnection.getResponseCode());
                eVar.b = this.mConnection.getResponseMessage();
                eVar.e = parseHostAddress(this.mConnection.getURL().getHost());
                eVar.g = this.mConnection.getURL().getPort();
                eVar.f = getResponseHeaders(this.mConnection.getHeaderFields());
                if (checkRequestValid(dVar.f36288a)) {
                    doReadData(dVar.f36288a, eVar);
                } else {
                    LiteavLog.w(TAG, "Do send failed. Invalid request, abort request.");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                LiteavLog.e(TAG, "Do send failed. Catch error.");
                eVar.f36290a = getStatusCode(e4);
                eVar.b = e4.toString();
                doOnCallback(f.DISCONNECTED, dVar.f36288a, eVar);
                doCleanById(dVar.f36288a, true);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            LiteavLog.e(TAG, "Do send failed. Fail to create http connection.");
            eVar.f36290a = getStatusCode(e5);
            eVar.b = e5.toString();
            doOnCallback(f.DISCONNECTED, dVar.f36288a, eVar);
            doCleanById(dVar.f36288a, true);
        }
    }

    public static HashMap getJavaHashMap(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return new HashMap();
        }
        if (strArr.length != strArr2.length) {
            LiteavLog.w(TAG, "Invalid parameter, keys and values do not match.");
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i2], strArr2[i2]);
            i = i2 + 1;
        }
    }

    public static String[] getMapKeys(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return new String[0];
        }
        Set<String> keySet = map.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }

    public static String[] getMapValue(Map<String, String> map, String[] strArr) {
        if (map == null || map.isEmpty() || strArr == null || strArr.length == 0) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = map.get(strArr[i]);
        }
        return strArr2;
    }

    private Map<String, String> getResponseHeaders(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return hashMap;
    }

    private g getStatusCode(int i) {
        g gVar = g.kUnknownError;
        if (i == 200) {
            return g.kHTTP200OK;
        }
        if (i == 204) {
            return g.kHTTP204NoContent;
        }
        if (i == 302) {
            return g.kHTTP302Found;
        }
        if (i == 304) {
            return g.kHTTP304NotModified;
        }
        if (i == 403) {
            return g.kHTTP403Forbidden;
        }
        if (i == 404) {
            return g.kHTTP404NotFound;
        }
        if (i == 503) {
            return g.kHTTP503ServiceUnavailable;
        }
        Log.w(TAG, "Failed to convert status code：", Integer.valueOf(i));
        return gVar;
    }

    private g getStatusCode(Exception exc) {
        g gVar = g.kUnknownError;
        if (exc instanceof FileNotFoundException) {
            return g.kSystemFileOpenFailed;
        }
        if (exc instanceof EOFException) {
            return g.kSystemFileWriteFailed;
        }
        if (exc instanceof UnknownHostException) {
            return g.kSystemUnknownHost;
        }
        if (exc instanceof NoRouteToHostException) {
            return g.kSystemConnectHostFailed;
        }
        if ((exc instanceof SocketException) || (exc instanceof MalformedURLException)) {
            return g.kSystemCreateSocketFailed;
        }
        if (exc instanceof SocketTimeoutException) {
            return g.kSystemConnectTimeout;
        }
        if (exc instanceof ConnectException) {
            return g.kSystemConnectRefused;
        }
        if (exc instanceof ProtocolException) {
            return g.kSystemProtocolError;
        }
        if (exc instanceof SSLException) {
            return g.kSystemSSLError;
        }
        Log.w(TAG, "Failed to convert status code, exception：", exc.toString());
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$cancelAll$1(HttpClientAndroid httpClientAndroid) {
        httpClientAndroid.closeConnectionSafely(httpClientAndroid.mConnection);
        httpClientAndroid.mConnection = null;
        LiteavLog.i(TAG, "Cancel all finish.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$destroy$2(HttpClientAndroid httpClientAndroid) {
        httpClientAndroid.closeConnectionSafely(httpClientAndroid.mConnection);
        httpClientAndroid.mConnection = null;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            httpClientAndroid.mHttpHandler.getLooper().quitSafely();
        } else {
            httpClientAndroid.mHttpHandler.getLooper().quit();
        }
        LiteavLog.i(TAG, "Quit looper finish.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$doReadData$3(HttpClientAndroid httpClientAndroid, e eVar, long j) {
        e eVar2 = new e();
        eVar2.f36290a = eVar.f36290a;
        httpClientAndroid.doReadData(j, eVar2);
    }

    private static native void nativeOnCallback(long j, boolean z, int i, long j2, int i2, String str, int i3, ByteBuffer byteBuffer, String str2, Map map, int i4);

    private String parseHostAddress(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception e2) {
            LiteavLog.w(TAG, "Parse host error. host:".concat(String.valueOf(str)));
            return "";
        }
    }

    public void cancel(long j) {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "Cancel request failed. Invalid native handle.");
            } else if (this.mRunningRequestMap.size() == 0) {
            } else {
                LiteavLog.i(TAG, "Cancel request. request:".concat(String.valueOf(this.mRunningRequestMap.remove(Long.valueOf(j)))));
                if (this.mRunningRequestMap.size() == 0) {
                    this.mInternalState = c.NONE;
                }
            }
        }
    }

    public void cancelAll() {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "Cancel all request failed. Invalid native handle.");
            } else if (this.mInternalState == c.NONE) {
            } else {
                this.mInternalState = c.NONE;
                LiteavLog.i(TAG, "Cancel all. size:" + this.mRunningRequestMap.size());
                this.mRunningRequestMap.clear();
                this.mHttpHandler.post(com.tencent.liteav.base.http.b.a(this));
            }
        }
    }

    public void destroy() {
        synchronized (this.mLocker) {
            this.mRunningRequestMap.clear();
            this.mNativeHttpClientAndroidJni = -1L;
            LiteavLog.i(TAG, "Destroy http client.");
            this.mHttpHandler.post(com.tencent.liteav.base.http.c.a(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f8 A[Catch: all -> 0x0147, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x00c0, B:28:0x00cf, B:31:0x00db, B:38:0x00f8, B:39:0x0122, B:42:0x0125, B:43:0x0144, B:29:0x00d6, B:33:0x00e6), top: B:52:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0125 A[Catch: all -> 0x0147, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x00c0, B:28:0x00cf, B:31:0x00db, B:38:0x00f8, B:39:0x0122, B:42:0x0125, B:43:0x0144, B:29:0x00d6, B:33:0x00e6), top: B:52:0x00c0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long send(long r8, java.lang.String r10, java.lang.String r11, byte[] r12, java.util.Map<java.lang.String, java.lang.String> r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.http.HttpClientAndroid.send(long, java.lang.String, java.lang.String, byte[], java.util.Map, boolean):long");
    }
}
