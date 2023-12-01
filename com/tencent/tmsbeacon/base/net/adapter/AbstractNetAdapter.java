package com.tencent.tmsbeacon.base.net.adapter;

import com.tencent.tmsbeacon.base.net.BResponse;
import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.base.net.call.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/adapter/AbstractNetAdapter.class */
public abstract class AbstractNetAdapter {
    public static final int CONNECT_TIMEOUT = 30000;
    public static final int READ_TIMEOUT = 10000;

    public abstract void request(JceRequestEntity jceRequestEntity, Callback<byte[]> callback);

    public abstract void request(e eVar, Callback<BResponse> callback);
}
