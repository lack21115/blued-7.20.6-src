package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/AsyncHttpRequest.class */
public class AsyncHttpRequest implements Runnable {
    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private boolean isCancelled;
    private boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        this.client = abstractHttpClient;
        this.context = httpContext;
        this.request = httpUriRequest;
        this.responseHandler = responseHandlerInterface;
    }

    private void makeRequest() throws IOException {
        ResponseHandlerInterface responseHandlerInterface;
        if (isCancelled()) {
            return;
        }
        if (this.request.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
        }
        HttpResponse execute = this.client.execute(this.request, this.context);
        if (isCancelled() || (responseHandlerInterface = this.responseHandler) == null) {
            return;
        }
        responseHandlerInterface.onPreProcessResponse(responseHandlerInterface, execute);
        if (isCancelled()) {
            return;
        }
        this.responseHandler.sendResponseMessage(execute);
        if (isCancelled()) {
            return;
        }
        ResponseHandlerInterface responseHandlerInterface2 = this.responseHandler;
        responseHandlerInterface2.onPostProcessResponse(responseHandlerInterface2, execute);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x000e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void makeRequestWithRetries() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.AsyncHttpRequest.makeRequestWithRetries():void");
    }

    private void sendCancelNotification() {
        synchronized (this) {
            if (!this.isFinished && this.isCancelled && !this.cancelIsNotified) {
                this.cancelIsNotified = true;
                if (this.responseHandler != null) {
                    this.responseHandler.sendCancelMessage();
                }
            }
        }
    }

    public boolean cancel(boolean z) {
        this.isCancelled = true;
        this.request.abort();
        return isCancelled();
    }

    public boolean isCancelled() {
        if (this.isCancelled) {
            sendCancelNotification();
        }
        return this.isCancelled;
    }

    public boolean isDone() {
        return isCancelled() || this.isFinished;
    }

    public void onPostProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    public void onPreProcessRequest(AsyncHttpRequest asyncHttpRequest) {
    }

    @Override // java.lang.Runnable
    public void run() {
        ResponseHandlerInterface responseHandlerInterface;
        if (isCancelled()) {
            return;
        }
        if (!this.isRequestPreProcessed) {
            this.isRequestPreProcessed = true;
            onPreProcessRequest(this);
        }
        if (isCancelled()) {
            return;
        }
        ResponseHandlerInterface responseHandlerInterface2 = this.responseHandler;
        if (responseHandlerInterface2 != null) {
            responseHandlerInterface2.sendStartMessage();
        }
        if (isCancelled()) {
            return;
        }
        try {
            makeRequestWithRetries();
        } catch (IOException e) {
            if (isCancelled() || (responseHandlerInterface = this.responseHandler) == null) {
                Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", e);
            } else {
                responseHandlerInterface.sendFailureMessage(0, null, null, e);
            }
        }
        if (isCancelled()) {
            return;
        }
        ResponseHandlerInterface responseHandlerInterface3 = this.responseHandler;
        if (responseHandlerInterface3 != null) {
            responseHandlerInterface3.sendFinishMessage();
        }
        if (isCancelled()) {
            return;
        }
        onPostProcessRequest(this);
        this.isFinished = true;
    }
}
