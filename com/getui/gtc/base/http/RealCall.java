package com.getui.gtc.base.http;

import com.getui.gtc.base.http.Call;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/RealCall.class */
public class RealCall implements Call {
    private volatile boolean canceled;
    private GtHttpClient client;
    private boolean executed;
    private Request request;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/RealCall$AsyncCall.class */
    public final class AsyncCall implements Runnable {
        private final Call.Callback callback;

        AsyncCall(Call.Callback callback) {
            this.callback = callback;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final RealCall get() {
            return RealCall.this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Response responseWithInterceptorChain;
            try {
                responseWithInterceptorChain = RealCall.this.getResponseWithInterceptorChain();
            } finally {
                try {
                } finally {
                }
            }
            if (RealCall.this.isCanceled()) {
                throw new IOException("Canceled");
            }
            this.callback.onResponse(get(), responseWithInterceptorChain);
        }
    }

    private RealCall(GtHttpClient gtHttpClient, Request request) {
        this.client = gtHttpClient;
        this.request = request;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RealCall newCall(GtHttpClient gtHttpClient, Request request) {
        return new RealCall(gtHttpClient, request);
    }

    @Override // com.getui.gtc.base.http.Call
    public void cancel() {
        this.canceled = true;
    }

    @Override // com.getui.gtc.base.http.Call
    public void enqueue(Call.Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // com.getui.gtc.base.http.Call
    public Response execute() throws Exception {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    Response getResponseWithInterceptorChain() throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors);
        if (this.request.cryptInterceptor() != null) {
            arrayList.add(this.request.cryptInterceptor());
        }
        arrayList.add(new BridgeInterceptor());
        arrayList.add(new ConnectInterceptor(this.client));
        arrayList.add(new CallServerInterceptor());
        return new RealInterceptorChain(arrayList, null, 0, this.request).proceed(this.request);
    }

    @Override // com.getui.gtc.base.http.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // com.getui.gtc.base.http.Call
    public boolean isExecuted() {
        boolean z;
        synchronized (this) {
            z = this.executed;
        }
        return z;
    }

    @Override // com.getui.gtc.base.http.Call
    public Request request() {
        return this.request;
    }
}
