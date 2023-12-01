package com.opos.cmn.func.b.a;

import android.content.Context;
import android.net.SSLSessionCache;
import android.text.TextUtils;
import com.heytap.baselib.cloudctrl.database.AreaCode;
import com.heytap.common.LogLevel;
import com.heytap.common.iinterface.IAccountCallback;
import com.heytap.httpdns.env.ApiEnv;
import com.heytap.httpdns.env.HttpDnsConfig;
import com.heytap.nearx.okhttp.extension.HeyConfig;
import com.heytap.nearx.okhttp.extension.api.IPv6Config;
import com.heytap.nearx.okhttp3.Call;
import com.heytap.nearx.okhttp3.Callback;
import com.heytap.nearx.okhttp3.Headers;
import com.heytap.nearx.okhttp3.MediaType;
import com.heytap.nearx.okhttp3.OkHttpClient;
import com.heytap.nearx.okhttp3.Request;
import com.heytap.nearx.okhttp3.RequestBody;
import com.heytap.nearx.okhttp3.Response;
import com.heytap.nearx.taphttp.statitics.HttpStatConfig;
import com.heytap.nearx.taphttp.statitics.StatisticCallback;
import com.heytap.trace.AppTraceConfig;
import com.opos.cmn.func.b.b.a.b;
import com.opos.cmn.func.b.b.a.d;
import com.opos.cmn.func.b.b.a.e;
import com.opos.cmn.func.b.b.a.g;
import com.opos.cmn.func.b.b.e;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/b.class */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static OkHttpClient f24818a;
    private OkHttpClient b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Long, Call> f24819c = new HashMap<>();
    private Object d = new Object();
    private Object e = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.cmn.func.b.a.b$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/b$1.class */
    public class AnonymousClass1 implements Callback {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.cmn.func.b.a.b$4  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/b$4.class */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24822a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[b.a.values().length];
            f24822a = iArr;
            try {
                iArr[b.a.CN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24822a[b.a.EU.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24822a[b.a.SA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f24822a[b.a.SEA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/b$a.class */
    public static class a<K, V> extends HashMap<K, V> {

        /* renamed from: a  reason: collision with root package name */
        Headers f24823a;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(Headers headers) {
            this.f24823a = headers;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (obj == null) {
                return null;
            }
            String str = (String) obj;
            Headers headers = this.f24823a;
            if (headers == null) {
                return (V) super.get(obj);
            }
            String str2 = headers.get(str);
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "HeaderMap name:" + str + " value:" + str2);
            String str3 = null;
            if (str2 != null) {
                str3 = str2;
            }
            return str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.cmn.func.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/b$b.class */
    public static class C0637b implements com.opos.cmn.func.b.b.a {

        /* renamed from: a  reason: collision with root package name */
        private Headers f24824a;
        private Map<String, String> b;

        public C0637b(Headers headers) {
            this.b = null;
            this.f24824a = headers;
            if (headers != null) {
                try {
                    this.b = new HashMap();
                    for (String str : this.f24824a.names()) {
                        if (str != null) {
                            this.b.put(str, this.f24824a.get(str));
                        }
                    }
                } catch (Exception e) {
                }
            }
        }

        @Override // com.opos.cmn.func.b.b.a
        public String a(String str) {
            Headers headers = this.f24824a;
            if (headers == null || str == null) {
                return null;
            }
            return headers.get(str);
        }
    }

    private static AreaCode a(b.a aVar, Context context) {
        b.a aVar2 = aVar;
        if (aVar == null) {
            aVar2 = com.opos.cmn.func.b.a.a.b.d(context);
        }
        int i = AnonymousClass4.f24822a[aVar2.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return AreaCode.EU;
            }
            if (i == 3) {
                return AreaCode.SA;
            }
            if (i == 4) {
                return AreaCode.SEA;
            }
        }
        return AreaCode.CN;
    }

    private static HttpDnsConfig a(final com.opos.cmn.func.b.b.a.c cVar, Context context) {
        if (cVar == null) {
            return null;
        }
        String str = cVar.b;
        String str2 = cVar.f24841c;
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = com.opos.cmn.func.b.a.a.b.c(context);
        }
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            str4 = com.opos.cmn.func.b.a.a.b.b(context);
        }
        HttpDnsConfig httpDnsConfig = new HttpDnsConfig(cVar.f24840a, str3, str4, cVar.d);
        if (cVar.e != null && !cVar.e.isEmpty()) {
            httpDnsConfig.setInnerWhiteList(cVar.e);
        }
        if (cVar.f != null) {
            httpDnsConfig.setSsoCallback(new IAccountCallback() { // from class: com.opos.cmn.func.b.a.b.3
            });
        }
        return httpDnsConfig;
    }

    public static HeyConfig.Builder a(com.opos.cmn.func.b.b.a.d dVar, Context context) {
        StringBuilder sb;
        LogLevel logLevel;
        final e.a aVar;
        com.opos.cmn.func.b.b.a.d dVar2 = dVar;
        if (dVar == null) {
            dVar2 = new d.a().a();
        }
        HeyConfig.Builder builder = new HeyConfig.Builder();
        builder.defaultUserAgent(com.opos.cmn.func.b.a.a.c.a());
        ApiEnv b = b();
        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set ApiEnv " + b);
        builder.setEnv(b);
        if (dVar2.b != null) {
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set" + dVar2.b.toString());
            HttpDnsConfig a2 = a(dVar2.b, context);
            if (a2 != null) {
                builder.useHttpDns(a2);
            }
        }
        if (dVar2.f) {
            builder.setLogLevel(LogLevel.LEVEL_NONE);
            sb = new StringBuilder();
            sb.append("config set LogLevel ");
            logLevel = LogLevel.LEVEL_NONE;
        } else {
            builder.setLogLevel(LogLevel.LEVEL_VERBOSE);
            sb = new StringBuilder();
            sb.append("config set LogLevel ");
            logLevel = LogLevel.LEVEL_VERBOSE;
        }
        sb.append(logLevel);
        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", sb.toString());
        if (dVar2.e != null && (aVar = dVar2.e.f24848a) != null) {
            builder.useHttpStat(new HttpStatConfig(true, new StatisticCallback() { // from class: com.opos.cmn.func.b.a.b.2
            }, dVar2.e.b));
        }
        if (dVar2.f24844a != null) {
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set" + dVar2.f24844a.toString());
            if (dVar2.f24844a.f24834a) {
                builder.setCloudConfig(dVar2.f24844a.b, a(dVar2.f24844a.f24835c, context));
            }
            return builder;
        }
        if (dVar2.f24845c != null) {
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set" + dVar2.f24845c);
            AppTraceConfig a3 = a(dVar2.f24845c);
            if (a3 != null) {
                builder.useAppTrace(a3);
            }
        }
        if (dVar2.d != null) {
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set" + dVar2.d);
            IPv6Config a4 = a(dVar2.d);
            if (a4 != null) {
                builder.useIPv6Switch(a4);
            }
        }
        try {
            builder.setSSLSessionCache(new SSLSessionCache(context.getDir("ads_ssl_session", 0)));
            return builder;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "", e);
        }
    }

    private static IPv6Config a(com.opos.cmn.func.b.b.a.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new IPv6Config(fVar.f24849a, fVar.b, fVar.f24850c, fVar.d);
    }

    private Call a(long j) {
        try {
            synchronized (this.d) {
                Call call = this.f24819c.get(Long.valueOf(j));
                if (call != null) {
                    this.f24819c.remove(Long.valueOf(j));
                    return call;
                }
                return null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "removeRequestFromMap fail", e);
            return null;
        }
    }

    private static OkHttpClient.Builder a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30000L, TimeUnit.MILLISECONDS);
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS);
        return builder;
    }

    private static OkHttpClient.Builder a(Context context, OkHttpClient.Builder builder, g gVar) {
        if (gVar != null) {
            if (gVar.f24854c != null) {
                com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set sslSocketFactory");
                if (gVar.e != null) {
                    builder.sslSocketFactory(gVar.f24854c, gVar.e);
                } else {
                    builder.sslSocketFactory(gVar.f24854c);
                }
            }
            if (gVar.d != null) {
                com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set hostnameVerifier");
                builder.hostnameVerifier(gVar.d);
            }
            builder.readTimeout(gVar.b, TimeUnit.MILLISECONDS).connectTimeout(gVar.f24853a, TimeUnit.MILLISECONDS);
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set readTimeout=" + gVar.b);
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "config set connectTimeout=" + gVar.f24853a);
            HeyConfig.Builder a2 = a(gVar.f, context);
            if (a2 != null) {
                builder.config(a2.build(context));
            }
        }
        return builder;
    }

    private static AppTraceConfig a(com.opos.cmn.func.b.b.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new AppTraceConfig(aVar.f24832a, aVar.b);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00e3 -> B:18:0x00b1). Please submit an issue!!! */
    private com.opos.cmn.func.b.b.e a(Response response) {
        if (response == null) {
            return null;
        }
        int code = response.code();
        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "code=" + code);
        String message = response.message();
        StringBuilder sb = new StringBuilder();
        sb.append("msg=");
        sb.append(message != null ? message : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", sb.toString());
        InputStream inputStream = null;
        if (response.body() != null) {
            inputStream = response.body().byteStream();
        }
        Headers build = response.headers().newBuilder().build();
        long j = -1;
        if (build != null) {
            String str = build.get("Content-Length");
            j = -1;
            if (!TextUtils.isEmpty(str)) {
                try {
                    j = Long.parseLong(str);
                } catch (Exception e) {
                    j = -1;
                }
            }
        }
        return new e.a().a(code).a(message).a(j).a(a(build)).a(new C0637b(build)).a(inputStream).a();
    }

    private Map<String, String> a(Headers headers) {
        if (headers == null) {
            return null;
        }
        try {
            a aVar = new a(null);
            aVar.a(headers);
            for (String str : headers.names()) {
                if (str != null) {
                    aVar.put(str, headers.get(str));
                }
            }
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }

    private void a(long j, Call call) {
        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "putCall requestId=" + j);
        if (call != null) {
            synchronized (this.d) {
                this.f24819c.put(Long.valueOf(j), call);
                com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "putCall mCallsMap.size()=" + this.f24819c.size());
            }
        }
    }

    private void a(Context context, g gVar) {
        if (this.b == null) {
            synchronized (this.e) {
                if (this.b == null) {
                    Context applicationContext = context.getApplicationContext();
                    long currentTimeMillis = System.currentTimeMillis();
                    this.b = b(applicationContext, gVar);
                    com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "getOkHttpClient cost time:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    private static ApiEnv b() {
        return com.opos.cmn.func.b.a.f24812a.booleanValue() ? ApiEnv.RELEASE : ApiEnv.DEV;
    }

    private static OkHttpClient b(Context context) {
        OkHttpClient okHttpClient;
        OkHttpClient okHttpClient2 = f24818a;
        if (okHttpClient2 != null) {
            return okHttpClient2;
        }
        synchronized (b.class) {
            try {
                if (f24818a == null) {
                    try {
                        g a2 = com.opos.cmn.func.b.a.a.b.a(context);
                        OkHttpClient.Builder a3 = a();
                        a(context, a3, a2);
                        f24818a = a3.build();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "init fail", e);
                    }
                }
                okHttpClient = f24818a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return okHttpClient;
    }

    private static OkHttpClient b(Context context, g gVar) {
        try {
            OkHttpClient b = b(context);
            if (gVar == null) {
                return b;
            }
            if (b != null) {
                OkHttpClient.Builder newBuilder = b.newBuilder();
                a(context, newBuilder, gVar);
                return newBuilder.build();
            }
            return null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "getOkHttpClient", e);
            return null;
        }
    }

    private Request b(Context context, com.opos.cmn.func.b.b.d dVar) {
        Request.Builder url;
        if (dVar == null) {
            return null;
        }
        com.opos.cmn.func.b.b.d a2 = com.opos.cmn.func.b.a.a.b.a(context, dVar);
        Request.Builder builder = new Request.Builder();
        if (a2.f24859c != null) {
            for (String str : a2.f24859c.keySet()) {
                builder.addHeader(str, a2.f24859c.get(str));
            }
        }
        if (a2.f24858a == "GET") {
            url = builder.url(a2.b).get();
        } else {
            if (a2.f24858a == "POST") {
                builder.post(a2.d != null ? RequestBody.create((MediaType) null, a2.d) : RequestBody.create((MediaType) null, new byte[0]));
            }
            url = builder.url(a2.b);
        }
        return url.build();
    }

    @Override // com.opos.cmn.func.b.a.e
    public com.opos.cmn.func.b.b.e a(Context context, com.opos.cmn.func.b.b.d dVar) {
        Request b;
        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "execSync");
        if (dVar != null) {
            try {
                if (context == null) {
                    return null;
                }
                try {
                    Context applicationContext = context.getApplicationContext();
                    a(applicationContext, (g) null);
                    if (this.b != null && (b = b(applicationContext, dVar)) != null) {
                        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", b.toString());
                        Call newCall = this.b.newCall(b);
                        a(dVar.e, newCall);
                        com.opos.cmn.func.b.b.e a2 = a(newCall.execute());
                        StringBuilder sb = new StringBuilder();
                        sb.append("onResponse,");
                        sb.append(a2 == null ? com.igexin.push.core.b.l : a2.toString());
                        com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", sb.toString());
                        return a2;
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("HttpTapExternalHttpImpl", "execSync fail", e);
                }
                a(dVar.e);
                return null;
            } finally {
                a(dVar.e);
            }
        }
        return null;
    }

    @Override // com.opos.cmn.func.b.a.d
    public void a(Context context) {
        a(context, (g) null);
    }
}
