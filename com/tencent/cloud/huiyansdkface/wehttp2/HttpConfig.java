package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.MockInterceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.RetryInterceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.WeConfig;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/HttpConfig.class */
public class HttpConfig implements PinProvider {
    private String A;
    private WeDns B;
    private volatile String f;
    private volatile PinVerifyListener h;
    private String i;
    private RetryInterceptor.RetryStrategy o;
    private WeCookie q;
    private TypeAdapter r;
    private Proxy s;
    private List<MockInterceptor.Mock> t;
    private EventListener u;
    private List<Interceptor> v;
    private List<Interceptor> w;
    private Context x;
    private String y;
    private String z;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f36081c = false;
    private volatile boolean d = false;
    private volatile PinCheckMode e = PinCheckMode.ENABLE;
    private PinManager g = new PinManager();

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f36080a = new HashMap();
    Map<String, String> b = new HashMap();
    private int j = 10000;
    private int k = 10000;
    private int l = 10000;
    private int m = 0;
    private int n = 0;
    private WeLog.Builder p = new WeLog.Builder();
    private WeConfig.IpStrategy C = WeConfig.IpStrategy.DNS_ORDER;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/HttpConfig$ConfigInheritSwitch.class */
    public static class ConfigInheritSwitch {
        private static ConfigInheritSwitch s = new ConfigInheritSwitch();

        /* renamed from: a  reason: collision with root package name */
        public boolean f36082a = true;
        public boolean b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36083c = true;
        public boolean d = true;
        public boolean e = true;
        public boolean f = true;
        public boolean g = true;
        public boolean h = true;
        public boolean i = true;
        public boolean j = true;
        public boolean k = true;
        public boolean l = false;
        public boolean m = true;
        public boolean n = true;
        public boolean o = true;
        public boolean p = true;
        public boolean q = true;
        public boolean r = true;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/HttpConfig$LogConfig.class */
    public static class LogConfig {

        /* renamed from: a  reason: collision with root package name */
        private boolean f36084a = false;
        private boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f36085c = false;
        private int d = 3072;
        private WeLog.Level e = WeLog.Level.NONE;

        public WeLog.Level getLevel() {
            return this.e;
        }

        public int getLongStrLength() {
            return this.d;
        }

        public boolean isCutLongStr() {
            return this.f36085c;
        }

        public boolean isLogWithTag() {
            return this.b;
        }

        public boolean isPrettyLog() {
            return this.f36084a;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/HttpConfig$PinCheckMode.class */
    public enum PinCheckMode {
        DISABLE,
        ENABLE,
        ERROR
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/HttpConfig$PinVerifyListener.class */
    public interface PinVerifyListener {
        void onPinVerifyFailed(String str, List<String> list);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/HttpConfig$Proxy.class */
    public static class Proxy {

        /* renamed from: a  reason: collision with root package name */
        private String f36088a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private String f36089c;
        private String d;

        public Proxy setIp(String str) {
            this.f36088a = str;
            return this;
        }

        public Proxy setPassword(String str) {
            this.d = str;
            return this;
        }

        public Proxy setPort(int i) {
            this.b = i;
            return this;
        }

        public Proxy setUserName(String str) {
            this.f36089c = str;
            return this;
        }
    }

    private HttpConfig a(Map<String, ?> map, boolean z) {
        if (z) {
            this.f36080a.clear();
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                this.f36080a.put(key, value.toString());
            }
        }
        return this;
    }

    private static String a(List<Cookie> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }

    private void a(WeConfig weConfig, String str, ConfigInheritSwitch configInheritSwitch) {
        List<Interceptor> list;
        List<Interceptor> list2;
        List<MockInterceptor.Mock> list3;
        Context context;
        String str2;
        Proxy proxy;
        TypeAdapter typeAdapter;
        WeCookie weCookie;
        String str3;
        Map<String, String> map;
        ConfigInheritSwitch configInheritSwitch2 = configInheritSwitch;
        if (configInheritSwitch == null) {
            configInheritSwitch2 = ConfigInheritSwitch.s;
        }
        if (configInheritSwitch2.f36083c && (map = this.b) != null) {
            weConfig.params(map);
        }
        if (configInheritSwitch2.b) {
            weConfig.header(this.f36080a);
        }
        if (configInheritSwitch2.e && (str3 = this.i) != null) {
            weConfig.baseUrl(str3);
        }
        if (configInheritSwitch2.d) {
            weConfig.setCertVerify(this.f36081c);
            if (this.d) {
                weConfig.pinProvider(this);
            } else if (str == null) {
                weConfig.addPin4Host(this.f, a(this.f));
            } else {
                weConfig.addPin4Host(str, a(str));
            }
        }
        if (configInheritSwitch2.f) {
            weConfig.timeoutInMillis(this.j, this.k, this.l);
        }
        if (configInheritSwitch2.h) {
            weConfig.retryConfig(this.n, this.o);
        }
        if (configInheritSwitch2.i) {
            weConfig.log(this.p);
        }
        if (configInheritSwitch2.j && (weCookie = this.q) != null) {
            weConfig.cookie(weCookie);
        }
        if (configInheritSwitch2.f36082a && (typeAdapter = this.r) != null) {
            weConfig.adapter(typeAdapter);
        }
        if (configInheritSwitch2.k && (proxy = this.s) != null) {
            weConfig.proxy(proxy.f36088a, this.s.b, this.s.f36089c, this.s.d);
        }
        if (configInheritSwitch2.p && (context = this.x) != null && (str2 = this.y) != null) {
            weConfig.clientCertPath(context, str2, this.z, this.A);
        }
        if (configInheritSwitch2.l && (list3 = this.t) != null && list3.size() > 0) {
            List<MockInterceptor.Mock> list4 = this.t;
            weConfig.addMock((MockInterceptor.Mock[]) list4.toArray(new MockInterceptor.Mock[list4.size()]));
        }
        if (configInheritSwitch2.m && this.u != null) {
            weConfig.clientConfig().eventListener(this.u);
        }
        if (configInheritSwitch2.g && this.m >= 0) {
            weConfig.clientConfig().callTimeout(this.m, TimeUnit.MILLISECONDS);
        }
        if (configInheritSwitch2.n && (list2 = this.v) != null && list2.size() > 0) {
            for (Interceptor interceptor : this.v) {
                if (interceptor != null) {
                    weConfig.clientConfig().addNetworkInterceptor(interceptor);
                }
            }
        }
        if (configInheritSwitch2.o && (list = this.w) != null && list.size() > 0) {
            for (Interceptor interceptor2 : this.w) {
                if (interceptor2 != null) {
                    weConfig.clientConfig().addInterceptor(interceptor2);
                }
            }
        }
        if (configInheritSwitch2.q) {
            weConfig.dns(this.B);
        }
        if (configInheritSwitch2.r) {
            weConfig.ipStrategy(this.C);
        }
    }

    private String[] a(String str) {
        return this.g.getPinArray4HostPattern(str);
    }

    private HttpConfig b(Map<String, ?> map, boolean z) {
        if (z) {
            this.b.clear();
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (key != null && value != null) {
                this.b.put(key, value.toString());
            }
        }
        return this;
    }

    public HttpConfig addCommonHeaders(Map<String, ?> map) {
        return a(map, false);
    }

    public HttpConfig addCommonParams(Map<String, ?> map) {
        return b(map, false);
    }

    public HttpConfig addInterceptor(Interceptor... interceptorArr) {
        if (interceptorArr != null) {
            if (interceptorArr.length == 0) {
                return this;
            }
            if (this.w == null) {
                this.w = new ArrayList();
            }
            this.w.addAll(Arrays.asList(interceptorArr));
        }
        return this;
    }

    public HttpConfig addMock(MockInterceptor.Mock... mockArr) {
        if (mockArr != null) {
            if (mockArr.length != 0) {
                if (this.t == null) {
                    this.t = new ArrayList();
                }
                int length = mockArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    MockInterceptor.Mock mock = mockArr[i2];
                    if (mock != null) {
                        this.t.add(mock);
                    }
                    i = i2 + 1;
                }
            } else {
                return this;
            }
        }
        return this;
    }

    public HttpConfig addNetInterceptor(Interceptor... interceptorArr) {
        if (interceptorArr != null) {
            if (interceptorArr.length == 0) {
                return this;
            }
            if (this.v == null) {
                this.v = new ArrayList();
            }
            this.v.addAll(Arrays.asList(interceptorArr));
        }
        return this;
    }

    @Deprecated
    public HttpConfig addPins(List<byte[]> list) {
        this.g.addPins4Host(this.f, list);
        return this;
    }

    public HttpConfig clientCertPath(Context context, String str, String str2, String str3) {
        this.y = str;
        this.x = context.getApplicationContext();
        this.z = str2;
        this.A = str3;
        return this;
    }

    public WeOkHttp create() {
        return create((WeOkHttp) null, (String) null, (ConfigInheritSwitch) null);
    }

    public WeOkHttp create(WeOkHttp weOkHttp, String str) {
        return create(weOkHttp, str, (ConfigInheritSwitch) null);
    }

    public WeOkHttp create(WeOkHttp weOkHttp, String str, ConfigInheritSwitch configInheritSwitch) {
        WeOkHttp weOkHttp2 = weOkHttp;
        if (weOkHttp == null) {
            weOkHttp2 = new WeOkHttp();
        }
        a(weOkHttp2.config(), str, configInheritSwitch);
        return weOkHttp2;
    }

    public WeOkHttp create(String str) {
        return create((WeOkHttp) null, str, (ConfigInheritSwitch) null);
    }

    public WeOkHttp create(String str, String str2) {
        return create(str, str2, (ConfigInheritSwitch) null);
    }

    public WeOkHttp create(String str, String str2, ConfigInheritSwitch configInheritSwitch) {
        WeOkHttp weOkHttp = new WeOkHttp(str);
        a(weOkHttp.config(), str2, configInheritSwitch);
        return weOkHttp;
    }

    public String getBaseUrl() {
        return this.i;
    }

    public int getCallTimeoutInSeconds() {
        return this.m;
    }

    public Map<String, String> getCommonHeaders() {
        return Collections.unmodifiableMap(this.f36080a);
    }

    public Map<String, String> getCommonParams() {
        return Collections.unmodifiableMap(this.b);
    }

    public int getConnectTimeout() {
        return this.j;
    }

    public int getConnectTimeoutInSeconds() {
        return this.j / 1000;
    }

    public WeCookie getCookie() {
        return this.q;
    }

    public String getCookieHeader() {
        return getCookieHeader(getBaseUrl());
    }

    public String getCookieHeader(String str) {
        return a(this.q.loadForRequest(HttpUrl.parse(str)));
    }

    public WeDns getDns() {
        return this.B;
    }

    public WeConfig.IpStrategy getIpStrategy() {
        return this.C;
    }

    public LogConfig getLogConfig() {
        LogConfig logConfig = new LogConfig();
        WeLog.Builder builder = this.p;
        if (builder == null) {
            return logConfig;
        }
        logConfig.e = builder.e;
        logConfig.f36085c = this.p.f36134c;
        logConfig.b = this.p.b;
        logConfig.f36084a = this.p.f36133a;
        logConfig.d = this.p.d;
        return logConfig;
    }

    @Deprecated
    public String[] getPinArray() {
        return getPinArray4DefHost();
    }

    public String[] getPinArray(String str) {
        List<String> pinList = getPinList(str);
        return (String[]) pinList.toArray(new String[pinList.size()]);
    }

    public String[] getPinArray4DefHost() {
        return a(this.f);
    }

    public PinCheckMode getPinCheckMode() {
        return this.e;
    }

    public String getPinDefHost() {
        return this.g.getPinDefHostPattern();
    }

    public List<String> getPinList(String str) {
        return this.e == PinCheckMode.ENABLE ? this.g.getPins(str) : this.e == PinCheckMode.ERROR ? this.g.getErrorPins(str) : Collections.EMPTY_LIST;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.PinProvider
    public Set<String> getPinSet(String str) {
        List<String> pinList = getPinList(str);
        HashSet hashSet = new HashSet();
        hashSet.addAll(pinList);
        return hashSet;
    }

    public List<String> getPins4DefHost() {
        return this.g.getPinList4HostPattern(this.f);
    }

    public Proxy getProxy() {
        return this.s;
    }

    public int getReadTimeOut() {
        return this.k;
    }

    public int getReadTimeOutInSeconds() {
        return this.k / 1000;
    }

    public TypeAdapter getTypeAdaptor() {
        return this.r;
    }

    public int getWriteTimeOut() {
        return this.l;
    }

    public int getWriteTimeOutInSeconds() {
        return this.l / 1000;
    }

    public boolean isCertVerify() {
        return this.f36081c;
    }

    public boolean isUsePinProvider() {
        return this.d;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.PinProvider
    public void onPinVerifyFailed(String str, List<String> list) {
        PinVerifyListener pinVerifyListener = this.h;
        if (pinVerifyListener != null) {
            pinVerifyListener.onPinVerifyFailed(str, list);
        }
    }

    public PinManager pinManager() {
        return this.g;
    }

    public HttpConfig setBaseUrl(String str) {
        this.i = str;
        return this;
    }

    public HttpConfig setCallTimeoutInSeconds(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        this.m = i2;
        return this;
    }

    public HttpConfig setCertVerify(boolean z) {
        this.f36081c = z;
        return this;
    }

    public HttpConfig setCommonHeaders(Map<String, ?> map) {
        return a(map, true);
    }

    public HttpConfig setCommonParams(Map<String, ?> map) {
        return b(map, true);
    }

    public HttpConfig setCookie(WeCookie weCookie) {
        this.q = weCookie;
        return this;
    }

    public HttpConfig setDns(WeDns weDns) {
        this.B = weDns;
        return this;
    }

    public HttpConfig setEventListener(EventListener eventListener) {
        this.u = eventListener;
        return this;
    }

    public HttpConfig setIpStrategy(WeConfig.IpStrategy ipStrategy) {
        this.C = ipStrategy;
        return this;
    }

    public HttpConfig setLogBuilder(WeLog.Builder builder) {
        if (builder != null) {
            this.p = builder;
        }
        return this;
    }

    public HttpConfig setPinCheckMode(PinCheckMode pinCheckMode) {
        if (this.e != null) {
            this.e = pinCheckMode;
        }
        return this;
    }

    public HttpConfig setPinDefHost(String str) {
        this.f = str;
        this.g.setPinDefHostPattern(str);
        return this;
    }

    public void setPinVerifyListener(PinVerifyListener pinVerifyListener) {
        this.h = pinVerifyListener;
    }

    public HttpConfig setProxy(Proxy proxy) {
        this.s = proxy;
        return this;
    }

    public HttpConfig setRetryCount(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        this.n = i2;
        return this;
    }

    public HttpConfig setRetryStrategy(RetryInterceptor.RetryStrategy retryStrategy) {
        this.o = retryStrategy;
        return this;
    }

    public void setToWeHttp() {
        a(WeHttp.config(), this.f, null);
    }

    public HttpConfig setTypeAdaptor(TypeAdapter typeAdapter) {
        this.r = typeAdapter;
        return this;
    }

    public HttpConfig timeoutInSeconds(int i, int i2, int i3) {
        int i4 = i;
        if (i <= 0) {
            i4 = 10;
        }
        int i5 = i2;
        if (i2 <= 0) {
            i5 = 10;
        }
        int i6 = i3;
        if (i3 <= 0) {
            i6 = 10;
        }
        this.j = i4 * 1000;
        this.k = i5 * 1000;
        this.l = i6 * 1000;
        return this;
    }

    public HttpConfig usePinProvider(boolean z) {
        this.d = z;
        return this;
    }
}
