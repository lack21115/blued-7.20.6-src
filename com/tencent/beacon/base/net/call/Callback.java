package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.NetException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/Callback.class */
public interface Callback<T> {
    void onFailure(com.tencent.beacon.base.net.d dVar);

    void onResponse(T t) throws NetException;
}
