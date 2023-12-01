package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import android.os.Build;
import android.security.KeyChain;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner;
import com.tencent.cloud.huiyansdkface.okhttp3.ConnectionSpec;
import com.tencent.cloud.huiyansdkface.okhttp3.Credentials;
import com.tencent.cloud.huiyansdkface.okhttp3.Dispatcher;
import com.tencent.cloud.huiyansdkface.okhttp3.Dns;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.TlsVersion;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.wehttp2.MockInterceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.RetryInterceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeConfig.class */
public class WeConfig {

    /* renamed from: a  reason: collision with root package name */
    private static int f22420a = -1;
    private KeyManagerFactory A;
    private WeLog.ILogTag B;
    private Dispatcher C;
    private volatile OkHttpClient b;

    /* renamed from: c  reason: collision with root package name */
    private OkHttpClient.Builder f22421c;
    private boolean d;
    private WeConfigLoader e;
    private volatile String f;
    private Map<String, String> g;
    private Map<String, String> h;
    private Object i;
    private volatile boolean j;
    private volatile String k;
    private List<Pin> l;
    private volatile PinProvider m;
    private volatile TypeAdapter n;
    private volatile WeCookie o;
    private volatile WeLog p;
    private volatile WeCookieLog q;
    private volatile MockInterceptor r;
    private volatile RetryInterceptor s;
    private boolean t;
    private volatile IpStrategy u;
    private volatile WeDns v;
    private Context w;
    private String x;
    private String y;
    private String z;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeConfig$IpStrategy.class */
    public enum IpStrategy {
        DNS_ORDER,
        IPV4_FIRST,
        IPV6_FIRST
    }

    public WeConfig() {
        this.d = false;
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new Object();
        this.j = false;
        this.l = new ArrayList();
        this.t = false;
        this.u = IpStrategy.DNS_ORDER;
        this.B = new WeLog.ILogTag() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.ILogTag
            public String tag(HttpUrl httpUrl, Object obj) {
                String str;
                if (obj != null) {
                    return obj.toString();
                }
                List<String> pathSegments = httpUrl.pathSegments();
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (pathSegments == null || pathSegments.size() <= 0) {
                    str = HiAnalyticsConstant.Direction.REQUEST + WeConfig.a();
                } else {
                    str = pathSegments.get(pathSegments.size() - 1);
                }
                sb.append(str);
                sb.append("] ");
                return sb.toString();
            }
        };
    }

    public WeConfig(Context context, String str) {
        this.d = false;
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new Object();
        this.j = false;
        this.l = new ArrayList();
        this.t = false;
        this.u = IpStrategy.DNS_ORDER;
        this.B = new WeLog.ILogTag() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.ILogTag
            public String tag(HttpUrl httpUrl, Object obj) {
                String str2;
                if (obj != null) {
                    return obj.toString();
                }
                List<String> pathSegments = httpUrl.pathSegments();
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (pathSegments == null || pathSegments.size() <= 0) {
                    str2 = HiAnalyticsConstant.Direction.REQUEST + WeConfig.a();
                } else {
                    str2 = pathSegments.get(pathSegments.size() - 1);
                }
                sb.append(str2);
                sb.append("] ");
                return sb.toString();
            }
        };
        Context context2 = context == null ? ContextHelper.getContext() : context.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("savedConfigName is empty");
        }
        if (context2 != null) {
            this.w = context2;
            WeConfigLoader weConfigLoader = new WeConfigLoader(context2, this, str);
            this.e = weConfigLoader;
            weConfigLoader.loadOnce();
        }
    }

    public WeConfig(WeConfigLoader weConfigLoader) {
        this.d = false;
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new Object();
        this.j = false;
        this.l = new ArrayList();
        this.t = false;
        this.u = IpStrategy.DNS_ORDER;
        this.B = new WeLog.ILogTag() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.ILogTag
            public String tag(HttpUrl httpUrl, Object obj) {
                String str2;
                if (obj != null) {
                    return obj.toString();
                }
                List<String> pathSegments = httpUrl.pathSegments();
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (pathSegments == null || pathSegments.size() <= 0) {
                    str2 = HiAnalyticsConstant.Direction.REQUEST + WeConfig.a();
                } else {
                    str2 = pathSegments.get(pathSegments.size() - 1);
                }
                sb.append(str2);
                sb.append("] ");
                return sb.toString();
            }
        };
        if (weConfigLoader == null) {
            throw new IllegalArgumentException("configLoader must not be null");
        }
        weConfigLoader.loadOnce();
        this.e = weConfigLoader;
    }

    public WeConfig(String str) {
        this(null, str);
    }

    static /* synthetic */ int a() {
        return b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<InetAddress> a(String str) throws UnknownHostException {
        List<InetAddress> lookup = this.v != null ? this.v.lookup(str) : Dns.f22157a.lookup(str);
        if (this.u == null || this.u == IpStrategy.DNS_ORDER || lookup == null) {
            return lookup;
        }
        if (lookup.size() == 0) {
            return lookup;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (InetAddress inetAddress : lookup) {
            if (inetAddress instanceof Inet4Address) {
                arrayList2.add(inetAddress);
            } else {
                arrayList3.add(inetAddress);
            }
        }
        if (this.u == IpStrategy.IPV4_FIRST) {
            arrayList.addAll(arrayList2);
            arrayList.addAll(arrayList3);
            return arrayList;
        } else if (this.u != IpStrategy.IPV6_FIRST) {
            arrayList.addAll(lookup);
            return arrayList;
        } else {
            arrayList.addAll(arrayList3);
            arrayList.addAll(arrayList2);
            return arrayList;
        }
    }

    private void a(OkHttpClient.Builder builder, SSLSocketFactory sSLSocketFactory) {
        if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 21) {
            return;
        }
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        if (sSLSocketFactory == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                sSLSocketFactory2 = sSLContext.getSocketFactory();
            } catch (Exception e) {
                Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", e);
                return;
            }
        }
        builder.sslSocketFactory(new Tls12SocketFactory(sSLSocketFactory2), g());
        ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.b).tlsVersions(TlsVersion.TLS_1_2).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        arrayList.add(ConnectionSpec.f22147c);
        arrayList.add(ConnectionSpec.d);
        builder.connectionSpecs(arrayList);
    }

    private static int b() {
        int i;
        synchronized (WeConfig.class) {
            try {
                i = f22420a + 1;
                f22420a = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private void c() {
        clientConfig().addInterceptor(new Interceptor() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.4
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                WeLog weLog = WeConfig.this.p;
                return weLog == null ? chain.proceed(chain.request()) : weLog.intercept(chain);
            }
        });
        clientConfig().addNetworkInterceptor(new Interceptor() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.5
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return WeConfig.this.q != null ? WeConfig.this.q.intercept(chain) : chain.proceed(chain.request());
            }
        });
    }

    private void d() {
        clientConfig().addInterceptor(new Interceptor() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.6
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return WeConfig.this.s != null ? WeConfig.this.s.intercept(chain) : chain.proceed(chain.request());
            }
        });
    }

    private void e() {
        clientConfig().addInterceptor(new TimeoutInterceptor());
    }

    private void f() {
        clientConfig().addInterceptor(new Interceptor() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.7
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return WeConfig.this.r != null ? WeConfig.this.r.intercept(chain) : chain.proceed(chain.request());
            }
        });
    }

    private X509TrustManager g() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (KeyStoreException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private SSLSocketFactory h() {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            KeyManagerFactory keyManagerFactory = this.A;
            KeyManagerFactory keyManagerFactory2 = keyManagerFactory;
            if (keyManagerFactory == null) {
                keyManagerFactory2 = keyManagerFactory;
                if (this.x != null) {
                    InputStream open = this.w.getAssets().open(this.x);
                    KeyStore keyStore = KeyStore.getInstance(this.y == null ? KeyChain.EXTRA_PKCS12 : this.y);
                    keyStore.load(open, this.z.toCharArray());
                    keyManagerFactory2 = KeyManagerFactory.getInstance("X509");
                    keyManagerFactory2.init(keyStore, this.z.toCharArray());
                }
            }
            sSLContext.init(keyManagerFactory2 == null ? null : keyManagerFactory2.getKeyManagers(), null, null);
            return sSLContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TypeAdapter adapter() {
        if (this.n == null) {
            synchronized (this) {
                if (this.n == null) {
                    this.n = new WeTypeAdapter();
                }
            }
        }
        return this.n;
    }

    public WeConfig adapter(TypeAdapter typeAdapter) {
        this.n = typeAdapter;
        return this;
    }

    public WeConfig addMock(MockInterceptor.Mock... mockArr) {
        mockConfig();
        int length = mockArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return this;
            }
            this.r.addMock(mockArr[i]);
            length = i;
        }
    }

    public WeConfig addPin(Pin... pinArr) {
        if (pinArr == null || pinArr.length <= 0) {
            return this;
        }
        synchronized (this.i) {
            int length = pinArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    Pin pin = pinArr[i2];
                    if (pin != null && pin.getPattern() != null && pin.getPin() != null) {
                        this.l.add(pin);
                    }
                    i = i2 + 1;
                }
            }
        }
        return this;
    }

    public WeConfig addPin4DefHost(String... strArr) {
        return addPin4Host(this.k, strArr);
    }

    public WeConfig addPin4Host(String str, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            if (str != null) {
                synchronized (this.i) {
                    if (strArr != null) {
                        if (strArr.length == 1) {
                            this.l.add(new Pin(str, strArr[0]));
                            return this;
                        }
                    }
                    this.l.addAll(Pin.create(str, strArr));
                    return this;
                }
            }
            throw new IllegalArgumentException("host cannot be null");
        }
        return this;
    }

    public WeConfig baseUrl(String str) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (!str.endsWith("/")) {
                str2 = str + "/";
            }
        }
        this.f = str2;
        return this;
    }

    public WeConfig callTimeoutInMillis(long j) {
        clientConfig().callTimeout(j, TimeUnit.MILLISECONDS);
        return this;
    }

    public WeConfig clearPin4Host(String str) {
        synchronized (this.i) {
            Iterator<Pin> it = this.l.iterator();
            while (it.hasNext()) {
                if (it.next().getPattern().equals(str)) {
                    it.remove();
                }
            }
        }
        return this;
    }

    public OkHttpClient client() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    clientConfig().dns(new Dns() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.2
                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.Dns
                        public List<InetAddress> lookup(String str) throws UnknownHostException {
                            return WeConfig.this.a(str);
                        }
                    });
                    clientConfig().certificatePinner(new CertificatePinner.Builder().pinProvider(new CertificatePinner.CertificatePinProvider() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.3
                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner.CertificatePinProvider
                        public Set<String> getPins(String str) {
                            return WeConfig.this.getPins(str);
                        }

                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner.CertificatePinProvider
                        public void onPinVerifyFailed(String str, List<String> list) {
                            if (WeConfig.this.m != null) {
                                WeConfig.this.m.onPinVerifyFailed(str, list);
                            }
                        }
                    }).build());
                    e();
                    d();
                    c();
                    f();
                    if (Build.VERSION.SDK_INT < 16 || Build.VERSION.SDK_INT >= 21 || !this.t) {
                        if (this.x != null) {
                            clientConfig().sslSocketFactory(h(), g());
                        }
                    } else if (this.x != null) {
                        a(clientConfig(), h());
                    } else {
                        a(clientConfig(), (SSLSocketFactory) null);
                    }
                    this.b = clientConfig().build();
                    if (this.e != null) {
                        this.e.save();
                    }
                    this.d = true;
                }
            }
        }
        return this.b;
    }

    public WeConfig clientCertPath(Context context, String str, String str2, String str3) {
        this.x = str;
        this.w = context.getApplicationContext();
        this.y = str2;
        this.z = str3;
        return this;
    }

    public OkHttpClient.Builder clientConfig() {
        if (this.f22421c == null) {
            this.f22421c = new OkHttpClient.Builder();
        }
        if (this.d) {
            Log.w("WeConfig", "config after request");
        }
        return this.f22421c;
    }

    public WeConfig clientKeyManagerFactory(KeyManagerFactory keyManagerFactory) {
        this.A = keyManagerFactory;
        return this;
    }

    public WeConfig cookie(WeCookie weCookie) {
        this.o = weCookie;
        if (weCookie != null) {
            clientConfig().cookieJar(weCookie);
        }
        return this;
    }

    public WeCookie cookie() {
        return this.o;
    }

    public WeConfig cookieMemory() {
        this.o = new MemoryCookieJar();
        clientConfig().cookieJar(this.o);
        return this;
    }

    public WeConfig cookieWebView(Context context) {
        this.o = new WeWebViewCookie(context);
        clientConfig().cookieJar(this.o);
        return this;
    }

    public WeConfig dispatcherConfig(int i, int i2, Runnable runnable) {
        if (this.C == null) {
            this.C = new Dispatcher();
            clientConfig().dispatcher(this.C);
        }
        this.C.setIdleCallback(runnable);
        this.C.setMaxRequests(i);
        this.C.setMaxRequestsPerHost(i2);
        return this;
    }

    public WeConfig dns(WeDns weDns) {
        this.v = weDns;
        return this;
    }

    public String getBaseUrl() {
        return this.f;
    }

    public WeConfigLoader getConfigLoader() {
        return this.e;
    }

    public Map<String, String> getHeaders() {
        return this.g;
    }

    public Map<String, String> getParams() {
        return this.h;
    }

    public List<String> getPin4HostPattern(String str) {
        ArrayList arrayList;
        synchronized (this.i) {
            arrayList = new ArrayList();
            for (Pin pin : this.l) {
                if (pin.getPattern().equals(str)) {
                    arrayList.add(pin.getPin());
                }
            }
        }
        return arrayList;
    }

    public List<Pin> getPinList() {
        List<Pin> unmodifiableList;
        synchronized (this.i) {
            unmodifiableList = Collections.unmodifiableList(this.l);
        }
        return unmodifiableList;
    }

    public Set<String> getPins(String str) {
        Set<String> pinSet;
        if (this.j) {
            HashSet hashSet = new HashSet();
            if (this.m != null && (pinSet = this.m.getPinSet(str)) != null && pinSet.size() > 0) {
                hashSet.addAll(pinSet);
            }
            synchronized (this.i) {
                for (Pin pin : this.l) {
                    if (pin.match(str)) {
                        hashSet.add(pin.getPin());
                    }
                }
            }
            return hashSet;
        }
        return Collections.emptySet();
    }

    public String getUrl(String str) {
        if (str == null) {
            return this.f;
        }
        String trim = str.trim();
        String str2 = trim;
        if (!trim.startsWith("https://")) {
            if (trim.startsWith("http://")) {
                return trim;
            }
            String str3 = trim;
            if (trim.startsWith("/")) {
                str3 = trim.substring(1);
            }
            str2 = this.f + str3;
        }
        return str2;
    }

    public WeConfig header(String str, String str2) {
        this.g.put(str, str2);
        return this;
    }

    public WeConfig header(Map<String, String> map) {
        if (map != null) {
            if (map.size() == 0) {
                return this;
            }
            this.g.putAll(map);
        }
        return this;
    }

    public WeLog.ILogTag iLogTag() {
        return this.B;
    }

    public WeConfig ipStrategy(IpStrategy ipStrategy) {
        if (ipStrategy != null) {
            this.u = ipStrategy;
        }
        return this;
    }

    public boolean isCertVerify() {
        return this.j;
    }

    public WeConfig log(WeLog.Builder builder) {
        if (this.p != null) {
            this.p.setLevel(builder.e).prettyLog(builder.f22442a).logTag(builder.b).setLogger(builder.g);
            this.p.cutLongStr(builder.f22443c);
            this.p.longStrLength(builder.d);
        }
        this.p = builder.build();
        this.q = new WeCookieLog(this.p);
        if (builder.f != null) {
            this.B = builder.f;
        }
        return this;
    }

    public WeConfig log(WeLog.Level level) {
        return log(level, WeLog.f22439a);
    }

    public WeConfig log(WeLog.Level level, WeLog.Logger logger) {
        return log(level, false, false, null, logger);
    }

    public WeConfig log(WeLog.Level level, boolean z, boolean z2, WeLog.ILogTag iLogTag, WeLog.Logger logger) {
        if (this.p != null) {
            this.p.setLevel(level).prettyLog(z).logTag(z2).setLogger(logger);
            return this;
        }
        this.p = new WeLog.Builder().setLevel(level).setPrettyLog(z).setLogWithTag(z2).setLogger(logger).build();
        if (iLogTag != null) {
            this.B = iLogTag;
        }
        return this;
    }

    public MockInterceptor mockConfig() {
        if (this.r == null) {
            this.r = new MockInterceptor();
        }
        return this.r;
    }

    public WeConfig params(String str, String str2) {
        this.h.put(str, str2);
        return this;
    }

    public WeConfig params(Map<String, String> map) {
        if (map != null) {
            if (map.isEmpty()) {
                return this;
            }
            this.h.putAll(map);
        }
        return this;
    }

    public WeConfig pinCheckHost(String str) {
        if (str == null) {
            return this;
        }
        this.k = str;
        return this;
    }

    public String pinListToString() {
        return pinListToString(null);
    }

    public String pinListToString(String str) {
        String trim;
        synchronized (this.i) {
            HashMap hashMap = new HashMap();
            for (Pin pin : this.l) {
                String pattern = pin.getPattern();
                if (str == null || str.equals(pattern)) {
                    List list = (List) hashMap.get(pattern);
                    ArrayList arrayList = list;
                    if (list == null) {
                        arrayList = new ArrayList();
                        hashMap.put(pattern, arrayList);
                    }
                    arrayList.add(pin.getPin());
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : hashMap.entrySet()) {
                sb.append(((String) entry.getKey()) + ":\n");
                for (String str2 : (List) entry.getValue()) {
                    sb.append("\t" + str2);
                }
                sb.append("\n");
            }
            trim = sb.toString().trim();
        }
        return trim;
    }

    public WeConfig pinProvider(PinProvider pinProvider) {
        this.m = pinProvider;
        return this;
    }

    public WeConfig proxy(String str, int i, String str2, String str3) {
        clientConfig().proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i)));
        header(HttpHeaders.PROXY_AUTHORIZATION, Credentials.basic(str2, str3));
        return this;
    }

    public WeConfig retryConfig(int i, RetryInterceptor.RetryStrategy retryStrategy) {
        if (this.s == null) {
            this.s = new RetryInterceptor(i, retryStrategy);
        }
        this.s.setRetryStrategy(retryStrategy);
        this.s.setMaxRetryCount(i);
        return this;
    }

    public WeConfig retryCount(int i) {
        return retryConfig(i, null);
    }

    public WeConfig saveConfig() {
        WeConfigLoader weConfigLoader = this.e;
        if (weConfigLoader != null) {
            weConfigLoader.save();
            return this;
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public WeConfig setCertVerify(boolean z) {
        this.j = z;
        return this;
    }

    @Deprecated
    public WeConfig setPin4DefHost(String... strArr) {
        return addPin4DefHost(strArr);
    }

    @Deprecated
    public WeConfig setPin4Host(String str, String... strArr) {
        return addPin4Host(str, strArr);
    }

    public WeConfig supportTls12Before5(boolean z) {
        this.t = z;
        return this;
    }

    public WeConfig timeout(long j, long j2, long j3) {
        clientConfig().connectTimeout(j, TimeUnit.SECONDS).readTimeout(j2, TimeUnit.SECONDS).writeTimeout(j3, TimeUnit.SECONDS);
        return this;
    }

    public WeConfig timeoutInMillis(long j, long j2, long j3) {
        clientConfig().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j2, TimeUnit.MILLISECONDS).writeTimeout(j3, TimeUnit.MILLISECONDS);
        return this;
    }
}
