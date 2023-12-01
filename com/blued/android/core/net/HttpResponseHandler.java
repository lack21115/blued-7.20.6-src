package com.blued.android.core.net;

import com.blued.android.core.net.http.AbstractHttpResponseHandler;
import com.blued.android.core.utils.Log;
import com.igexin.push.core.b;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/HttpResponseHandler.class */
public abstract class HttpResponseHandler<T> extends AbstractHttpResponseHandler<T> {
    private static final String TAG = "HttpResponseHandler";

    public HttpResponseHandler() {
        this(false);
    }

    public HttpResponseHandler(boolean z) {
        super(z);
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onCancel() {
        if (HttpManager.c()) {
            Log.a(TAG, "onCancel()");
        }
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    @Deprecated
    public void onFailure(Throwable th) {
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onFailure(Throwable th, int i, T t) {
        if (HttpManager.c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onFailure(), , content: ");
            sb.append(t != null ? t.toString() : b.l);
            sb.append(", error: ");
            sb.append(th);
            Log.a(TAG, sb.toString());
        }
        onFailure(th);
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onFinish() {
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onProgress(int i, int i2) {
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onStart() {
    }

    @Override // com.blued.android.core.net.http.AbstractHttpResponseHandler
    public abstract void onSuccess(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public void setHttpRequestWrapper(HttpRequestWrapper httpRequestWrapper) {
        this.requestWrapper = httpRequestWrapper;
    }
}
