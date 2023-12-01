package com.tencent.cloud.huiyansdkface.okhttp3.internal.http;

import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http/RealResponseBody.class */
public final class RealResponseBody extends ResponseBody {

    /* renamed from: a  reason: collision with root package name */
    private final String f35954a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final BufferedSource f35955c;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        this.f35954a = str;
        this.b = j;
        this.f35955c = bufferedSource;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
    public long contentLength() {
        return this.b;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.f35954a;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
    public BufferedSource source() {
        return this.f35955c;
    }
}
