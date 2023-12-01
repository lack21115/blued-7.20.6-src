package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import okhttp3.Response;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/NetworkProxy.class */
public abstract class NetworkProxy<T> {
    protected String identifier;
    protected QCloudProgressListener mProgressListener;
    protected HttpTaskMetrics metrics;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void cancel();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract HttpResult<T> convertResponse(HttpRequest<T> httpRequest, Response response) throws QCloudClientException, QCloudServiceException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract HttpResult<T> executeHttpRequest(HttpRequest<T> httpRequest) throws QCloudClientException, QCloudServiceException;
}
