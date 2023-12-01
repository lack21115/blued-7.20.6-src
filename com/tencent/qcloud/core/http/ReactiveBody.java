package com.tencent.qcloud.core.http;

import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/ReactiveBody.class */
public interface ReactiveBody {
    <T> void end(HttpResult<T> httpResult) throws IOException;

    void prepare() throws IOException;
}
