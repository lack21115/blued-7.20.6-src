package com.mokee.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mokee.volley.Cache;
import com.mokee.volley.NetworkResponse;
import com.mokee.volley.Request;
import com.mokee.volley.Response;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/ClearCacheRequest.class */
public class ClearCacheRequest extends Request<Object> {
    private final Cache p;
    private final Runnable q;

    public ClearCacheRequest(Cache cache, Runnable runnable) {
        super(0, null, null);
        this.p = cache;
        this.q = runnable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.Request
    public void deliverResponse(Object obj) {
    }

    @Override // com.mokee.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.IMMEDIATE;
    }

    @Override // com.mokee.volley.Request
    public boolean isCanceled() {
        this.p.clear();
        if (this.q != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.q);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mokee.volley.Request
    public Response<Object> parseNetworkResponse(NetworkResponse networkResponse) {
        return null;
    }
}
