package com.sobot.network.http.builder;

import com.sobot.network.http.request.OtherRequest;
import com.sobot.network.http.request.RequestCall;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/builder/HeadBuilder.class */
public class HeadBuilder extends GetBuilder {
    @Override // com.sobot.network.http.builder.GetBuilder, com.sobot.network.http.builder.OkHttpRequestBuilder
    public RequestCall build() {
        return new OtherRequest(null, null, "HEAD", this.url, this.tag, this.params, this.headers).build();
    }
}
