package com.tencent.qcloud.core.http;

import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/QCloudHttpRetryHandler.class */
public abstract class QCloudHttpRetryHandler {
    public static QCloudHttpRetryHandler DEFAULT = new QCloudHttpRetryHandler() { // from class: com.tencent.qcloud.core.http.QCloudHttpRetryHandler.1
        @Override // com.tencent.qcloud.core.http.QCloudHttpRetryHandler
        public boolean shouldRetry(Request request, Response response, Exception exc) {
            return true;
        }
    };

    public abstract boolean shouldRetry(Request request, Response response, Exception exc);
}
