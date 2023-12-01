package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Callback;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.wehttp2.BaseReq;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/BaseReq.class */
public abstract class BaseReq<R extends BaseReq> implements WeReq {

    /* renamed from: a  reason: collision with root package name */
    protected String f36065a;
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    protected Map<String, String> f36066c;
    protected WeOkHttp d;
    protected Request.Builder e;
    private Call f;
    private long g = 0;
    private long h = 0;
    private long i = 0;
    private long j = 0;

    public BaseReq(WeOkHttp weOkHttp, String str, String str2) {
        this.d = weOkHttp;
        this.f36065a = str;
        this.b = str2;
        Request.Builder builder = new Request.Builder();
        this.e = builder;
        a(builder, weOkHttp.config().getHeaders());
    }

    private HttpUrl.Builder a(HttpUrl.Builder builder, Map<String, String> map) {
        if (map != null) {
            if (map.size() == 0) {
                return builder;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builder;
    }

    private <T> WeReq a(final Type type, final WeReq.InnerCallback<T> innerCallback) {
        Call d = d();
        innerCallback.onStart(this);
        d.enqueue(new Callback() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.3
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                BaseReq.this.a(innerCallback, WeReq.ErrType.NETWORK, BaseReq.this.b(iOException), BaseReq.this.a(iOException), iOException);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Type type2 = type;
                String str = response;
                if (type2 != Response.class) {
                    if (type2 == Object.class) {
                        str = response;
                    } else if (response.code() < 200 || response.code() >= 300) {
                        BaseReq.this.a(innerCallback, WeReq.ErrType.HTTP, response.code(), response.message(), null);
                        return;
                    } else {
                        try {
                            str = response.body().string();
                            if (type != String.class) {
                                try {
                                    TypeAdapter adapter = BaseReq.this.d.config().adapter();
                                    if (adapter instanceof TypeAdaptor2) {
                                        str = ((TypeAdaptor2) adapter).a(str, type);
                                    } else if (!(type instanceof Class)) {
                                        BaseReq.this.a(innerCallback, WeReq.ErrType.LOCAL, 3, "you need use TypeAdaptor2", null);
                                        return;
                                    } else {
                                        str = adapter.from(str, (Class) type);
                                    }
                                } catch (WeJsonException e) {
                                    BaseReq.this.a(innerCallback, WeReq.ErrType.LOCAL, -1, e.getMessage(), e);
                                    return;
                                }
                            }
                        } catch (IOException e2) {
                            BaseReq.this.a(innerCallback, WeReq.ErrType.LOCAL, -2, e2.getMessage(), e2);
                            return;
                        }
                    }
                }
                BaseReq.this.a((BaseReq) str, (WeReq.InnerCallback<BaseReq>) innerCallback);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(IOException iOException) {
        return iOException.getMessage();
    }

    private void a(Request.Builder builder, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.header(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void a(WeReq.InnerCallback<T> innerCallback, WeReq.ErrType errType, int i, String str, IOException iOException) {
        innerCallback.onFailed(this, errType, i, str, iOException);
        innerCallback.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void a(T t, WeReq.InnerCallback<T> innerCallback) {
        innerCallback.onSuccess(this, t);
        innerCallback.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(IOException iOException) {
        return 0;
    }

    private Call d() {
        if (this.f == null) {
            long j = this.j;
            if (j > 0) {
                header("__wehttp__read_timeout__", String.valueOf(j));
            }
            long j2 = this.i;
            if (j2 > 0) {
                header("__wehttp__write_timeout__", String.valueOf(j2));
            }
            long j3 = this.h;
            if (j3 > 0) {
                header("__wehttp__connect_timeout__", String.valueOf(j3));
            }
            Call c2 = c();
            this.f = c2;
            if (this.g > 0) {
                c2.timeout().timeout(this.g, TimeUnit.MILLISECONDS);
            }
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Request.Builder a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final HttpUrl.Builder b() {
        HttpUrl.Builder newBuilder = HttpUrl.parse(this.d.config().getUrl(this.b)).newBuilder();
        a(newBuilder, this.d.config().getParams());
        return a(newBuilder, this.f36066c);
    }

    protected abstract Call c();

    public final R callTimeoutInMillis(int i) {
        this.g = i;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public void cancel() {
        d().cancel();
    }

    public final R connectTimeoutInMillis(long j) {
        this.h = j;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public WeConfig context() {
        return this.d.config();
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public <T> WeReq execute(final WeReq.Callback<T> callback) {
        final boolean a2 = WeUtils.a(callback);
        final boolean b = WeUtils.b(callback);
        final boolean c2 = WeUtils.c(callback);
        return a(WeUtils.getTypeOfReturn(callback), (WeReq.InnerCallback) new WeReq.InnerCallback<T>() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.2
            private boolean f = false;

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(final WeReq weReq, final WeReq.ErrType errType, final int i, final String str, final IOException iOException) {
                this.f = false;
                if (b) {
                    WeOkHttp.runUi(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onFailed(weReq, errType, i, str, iOException);
                        }
                    });
                } else {
                    callback.onFailed(weReq, errType, i, str, iOException);
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
                if (c2) {
                    WeOkHttp.runUi(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onFinish();
                        }
                    });
                } else if ((this.f && a2) || (!this.f && b)) {
                    throw new IllegalStateException("不支持onFinish()在非主线程执行,但onSuccess或onFailed在主线程执行");
                } else {
                    callback.onFinish();
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
                callback.onStart(weReq);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onSuccess(final WeReq weReq, final T t) {
                this.f = true;
                if (a2) {
                    WeOkHttp.runUi(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.2.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onSuccess(weReq, t);
                        }
                    });
                } else {
                    callback.onSuccess(weReq, t);
                }
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public <T> T execute(Class<T> cls) throws ReqFailException {
        return (T) execute((Type) cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.cloud.huiyansdkface.okhttp3.Call, T] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, com.tencent.cloud.huiyansdkface.okhttp3.Response] */
    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public <T> T execute(Type type) throws ReqFailException {
        if (type != null) {
            ?? r0 = (T) d();
            if (type == Call.class) {
                return r0;
            }
            try {
                ?? r02 = (T) r0.execute();
                if (type != Response.class && type != Object.class) {
                    if (r02.isSuccessful()) {
                        try {
                            ?? r03 = (T) r02.body().string();
                            if (type == String.class) {
                                return r03;
                            }
                            try {
                                TypeAdapter adapter = this.d.config().adapter();
                                if (adapter instanceof TypeAdaptor2) {
                                    return (T) ((TypeAdaptor2) adapter).a(r03, type);
                                }
                                if (type instanceof Class) {
                                    return (T) adapter.from(r03, (Class) type);
                                }
                                throw new ReqFailException(WeReq.ErrType.LOCAL, 3, "you need use TypeAdaptor2", null);
                            } catch (Exception e) {
                                throw new ReqFailException(WeReq.ErrType.LOCAL, -1, "JSON", e);
                            }
                        } catch (IOException e2) {
                            throw new ReqFailException(WeReq.ErrType.LOCAL, -2, e2.getMessage(), e2);
                        }
                    }
                    throw new ReqFailException(WeReq.ErrType.HTTP, r02.code(), r02.message(), null);
                }
                return r02;
            } catch (IOException e3) {
                throw new ReqFailException(WeReq.ErrType.NETWORK, 0, e3.getMessage(), e3);
            }
        }
        throw new IllegalArgumentException("classOfReturn must not be null");
    }

    public final R header(String str, String str2) {
        this.e.header(str, str2);
        return this;
    }

    public final R param(String str, String str2) {
        if (this.f36066c == null) {
            this.f36066c = new HashMap();
        }
        if (str != null) {
            if (str.trim().equals("")) {
                return this;
            }
            this.f36066c.put(str, str2);
        }
        return this;
    }

    public final R param(Map<String, String> map) {
        if (this.f36066c == null) {
            this.f36066c = new HashMap();
        }
        if (map != null) {
            if (map.size() == 0) {
                return this;
            }
            this.f36066c.putAll(map);
        }
        return this;
    }

    public final R readTimeoutInMillis(long j) {
        this.j = j;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq
    public Observable subscribe() {
        return new Observable(this) { // from class: com.tencent.cloud.huiyansdkface.wehttp2.BaseReq.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.Observable
            public void subscribe(WeReq.Callback callback) {
                BaseReq.this.execute(callback);
            }
        };
    }

    public final R tag(Object obj) {
        this.e.tag(obj);
        return this;
    }

    public final R writeTimeoutInMillis(long j) {
        this.i = j;
        return this;
    }
}
