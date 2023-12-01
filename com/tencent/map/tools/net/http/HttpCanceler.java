package com.tencent.map.tools.net.http;

import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetAdapter;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/http/HttpCanceler.class */
public class HttpCanceler {
    private Callback<Boolean> mCancelCallback;
    private boolean mCanceled;
    private NetAdapter mConnection;

    public void cancel() {
        NetAdapter netAdapter = this.mConnection;
        if (netAdapter != null && netAdapter.cancel()) {
            this.mCanceled = true;
        }
        Callback<Boolean> callback = this.mCancelCallback;
        if (callback != null) {
            callback.callback(Boolean.valueOf(this.mCanceled));
        }
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public void setHttpAccessRequest(NetAdapter netAdapter, Callback<Boolean> callback) {
        this.mConnection = netAdapter;
        this.mCancelCallback = callback;
    }
}
