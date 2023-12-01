package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.ConnectInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.BridgeInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.CallServerInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RealInterceptorChain;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.AsyncTimeout;
import com.tencent.cloud.huiyansdkface.okio.Timeout;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/RealCall.class */
public final class RealCall implements Call {

    /* renamed from: a  reason: collision with root package name */
    final OkHttpClient f22186a;
    final RetryAndFollowUpInterceptor b;

    /* renamed from: c  reason: collision with root package name */
    final AsyncTimeout f22187c;
    final Request d;
    final boolean e;
    private EventListener f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/RealCall$AsyncCall.class */
    public final class AsyncCall extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f22189a = !RealCall.class.desiredAssertionStatus();
        private final Callback d;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.c());
            this.d = callback;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return RealCall.this.d.url().host();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            if (!f22189a && Thread.holdsLock(RealCall.this.f22186a.dispatcher())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    RealCall.this.f.callFailed(RealCall.this, interruptedIOException);
                    this.d.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.f22186a.dispatcher().b(this);
                }
            } catch (Throwable th) {
                RealCall.this.f22186a.dispatcher().b(this);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RealCall b() {
            return RealCall.this;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
        public void execute() {
            Response d;
            RealCall.this.f22187c.enter();
            boolean z = true;
            try {
                try {
                    d = RealCall.this.d();
                } finally {
                    RealCall.this.f22186a.dispatcher().b(this);
                }
            } catch (IOException e) {
                e = e;
                z = false;
            }
            try {
                if (RealCall.this.b.isCanceled()) {
                    this.d.onFailure(RealCall.this, new IOException("Canceled"));
                } else {
                    this.d.onResponse(RealCall.this, d);
                }
            } catch (IOException e2) {
                e = e2;
                IOException a2 = RealCall.this.a(e);
                if (z) {
                    Platform.get().log(4, "Callback failure for " + RealCall.this.b(), a2);
                } else {
                    RealCall.this.f.callFailed(RealCall.this, a2);
                    this.d.onFailure(RealCall.this, a2);
                }
            }
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.f22186a = okHttpClient;
        this.d = request;
        this.e = z;
        this.b = new RetryAndFollowUpInterceptor(okHttpClient, z);
        AsyncTimeout asyncTimeout = new AsyncTimeout() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.RealCall.1
            @Override // com.tencent.cloud.huiyansdkface.okio.AsyncTimeout
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        this.f22187c = asyncTimeout;
        asyncTimeout.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RealCall a(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.f = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    private void e() {
        this.b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamAllocation a() {
        return this.b.streamAllocation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IOException a(IOException iOException) {
        if (this.f22187c.exit()) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
            return interruptedIOException;
        }
        return iOException;
    }

    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(c());
        return sb.toString();
    }

    String c() {
        return this.d.url().redact();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public void cancel() {
        this.b.cancel();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    /* renamed from: clone */
    public RealCall m7058clone() {
        return a(this.f22186a, this.d, this.e);
    }

    Response d() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f22186a.interceptors());
        arrayList.add(this.b);
        arrayList.add(new BridgeInterceptor(this.f22186a.cookieJar()));
        arrayList.add(new CacheInterceptor(this.f22186a.a()));
        arrayList.add(new ConnectInterceptor(this.f22186a));
        if (!this.e) {
            arrayList.addAll(this.f22186a.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.e));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.d, this, this.f, this.f22186a.connectTimeoutMillis(), this.f22186a.readTimeoutMillis(), this.f22186a.writeTimeoutMillis()).proceed(this.d);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        e();
        this.f.callStart(this);
        this.f22186a.dispatcher().a(new AsyncCall(callback));
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        e();
        this.f22187c.enter();
        this.f.callStart(this);
        try {
            try {
                this.f22186a.dispatcher().a(this);
                Response d = d();
                if (d == null) {
                    throw new IOException("Canceled");
                }
                this.f22186a.dispatcher().b(this);
                return d;
            } catch (IOException e) {
                IOException a2 = a(e);
                this.f.callFailed(this, a2);
                throw a2;
            }
        } catch (Throwable th) {
            this.f22186a.dispatcher().b(this);
            throw th;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public boolean isCanceled() {
        return this.b.isCanceled();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public boolean isExecuted() {
        boolean z;
        synchronized (this) {
            z = this.g;
        }
        return z;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public Request request() {
        return this.d;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Call
    public Timeout timeout() {
        return this.f22187c;
    }
}
