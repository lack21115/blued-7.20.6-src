package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qb.class */
public class qb extends ib {
    private NetResponse b;

    public InputStream a(InputStream inputStream) {
        return inputStream;
    }

    @Override // com.tencent.mapsdk.internal.ib
    public void a() {
        super.a();
        NetResponse netResponse = this.b;
        if (netResponse != null) {
            ha.a((Closeable) netResponse.getInputStream());
        }
    }

    public void a(NetRequest.NetRequestBuilder netRequestBuilder) {
    }

    public void a(NetResponse netResponse) {
    }

    @Override // com.tencent.mapsdk.internal.ib
    public InputStream f(String str) {
        InputStream inputStream;
        NetRequest.NetRequestBuilder url = NetManager.getInstance().builder().url(str);
        a(url);
        NetResponse doStream = url.doStream();
        this.b = doStream;
        if (doStream != null) {
            inputStream = doStream.getInputStream();
            a(this.b);
        } else {
            a(new NetResponse(url.getNetRequest()));
            inputStream = null;
        }
        return a(inputStream);
    }
}
