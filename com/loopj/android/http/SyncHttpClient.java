package com.loopj.android.http;

import android.content.Context;
import com.blued.das.live.LiveProtos;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/* loaded from: source-7994992-dex2jar.jar:com/loopj/android/http/SyncHttpClient.class */
public class SyncHttpClient extends AsyncHttpClient {
    public SyncHttpClient() {
        super(false, 80, LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE);
    }

    public SyncHttpClient(int i) {
        super(false, i, LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK_VALUE);
    }

    public SyncHttpClient(int i, int i2) {
        super(false, i, i2);
    }

    public SyncHttpClient(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }

    public SyncHttpClient(boolean z, int i, int i2) {
        super(z, i, i2);
    }

    @Override // com.loopj.android.http.AsyncHttpClient
    protected RequestHandle sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ResponseHandlerInterface responseHandlerInterface, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        responseHandlerInterface.setUseSynchronousMode(true);
        newAsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, str, responseHandlerInterface, context).run();
        return new RequestHandle(null);
    }
}
