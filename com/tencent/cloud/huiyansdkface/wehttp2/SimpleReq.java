package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/SimpleReq.class */
public class SimpleReq extends BaseReq<SimpleReq> {
    public SimpleReq(WeOkHttp weOkHttp, String str, String str2) {
        super(weOkHttp, str, str2);
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.BaseReq
    protected Call c() {
        HttpUrl build = b().build();
        this.e.url(build).method(this.f22374a, null).tag(LogTag.class, new LogTag(this.d.config().iLogTag().tag(build, this.e.tag())));
        return this.d.client().newCall(this.e.build());
    }
}
