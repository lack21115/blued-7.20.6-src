package com.loopj.android.http;

import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/RequestHandle.class */
public class RequestHandle {
    private final WeakReference<AsyncHttpRequest> request;

    public RequestHandle(AsyncHttpRequest asyncHttpRequest) {
        this.request = new WeakReference<>(asyncHttpRequest);
    }

    public boolean cancel(boolean z) {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.cancel(z);
    }

    public boolean isCancelled() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isCancelled();
    }

    public boolean isFinished() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isDone();
    }

    public boolean shouldBeGarbageCollected() {
        boolean z = isCancelled() || isFinished();
        if (z) {
            this.request.clear();
        }
        return z;
    }
}
