package com.tencent.tmsbeacon.base.net.call;

import com.tencent.tmsbeacon.base.net.NetException;
import com.tencent.tmsbeacon.base.net.d;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/Callback.class */
public interface Callback<T> {
    void onFailure(d dVar);

    void onResponse(T t) throws NetException;
}
