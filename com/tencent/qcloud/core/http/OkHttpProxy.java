package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/OkHttpProxy.class */
public class OkHttpProxy<T> extends NetworkProxy<T> {
    private Field eventListenerFiled;
    private Call httpCall;
    private OkHttpClient okHttpClient;

    public OkHttpProxy(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    private boolean isCosResponse(Response response) {
        return response != null && "tencent-cos".equalsIgnoreCase(response.header("Server"));
    }

    private void recordDns(String str, CallMetricsListener callMetricsListener) {
        List<InetAddress> dumpDns;
        if (callMetricsListener == null || (dumpDns = callMetricsListener.dumpDns()) == null) {
            return;
        }
        ConnectionRepository.getInstance().insertDnsRecordCache(str, dumpDns);
    }

    @Override // com.tencent.qcloud.core.http.NetworkProxy
    public void cancel() {
        Call call = this.httpCall;
        if (call != null) {
            call.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.http.NetworkProxy
    public HttpResult<T> convertResponse(HttpRequest<T> httpRequest, Response response) throws QCloudClientException, QCloudServiceException {
        HttpResponse<T> httpResponse = new HttpResponse<>(httpRequest, response);
        ResponseBodyConverter<T> responseBodyConverter = httpRequest.getResponseBodyConverter();
        if (responseBodyConverter instanceof ProgressBody) {
            ((ProgressBody) responseBodyConverter).setProgressListener(this.mProgressListener);
        }
        return new HttpResult<>(httpResponse, responseBodyConverter.convert(httpResponse));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0075  */
    @Override // com.tencent.qcloud.core.http.NetworkProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.qcloud.core.http.HttpResult<T> executeHttpRequest(com.tencent.qcloud.core.http.HttpRequest<T> r5) throws com.tencent.qcloud.core.common.QCloudClientException, com.tencent.qcloud.core.common.QCloudServiceException {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.http.OkHttpProxy.executeHttpRequest(com.tencent.qcloud.core.http.HttpRequest):com.tencent.qcloud.core.http.HttpResult");
    }
}
