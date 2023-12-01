package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudAuthenticationException;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.http.RequestBodySerializer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/STSScopeLimitCredentialProvider.class */
public class STSScopeLimitCredentialProvider extends BasicScopeLimitCredentialProvider {
    private HttpRequest.Builder<String> requestBuilder;

    public STSScopeLimitCredentialProvider(HttpRequest.Builder<String> builder) {
        this.requestBuilder = builder;
    }

    protected HttpRequest<String> buildRequest(HttpRequest.Builder<String> builder) {
        return builder.build();
    }

    @Override // com.tencent.qcloud.core.auth.BasicScopeLimitCredentialProvider
    public SessionQCloudCredentials fetchNewCredentials(STSCredentialScope[] sTSCredentialScopeArr) throws QCloudClientException {
        this.requestBuilder.body(RequestBodySerializer.string("application/json", STSCredentialScope.jsonify(sTSCredentialScopeArr))).method("POST");
        try {
            HttpResult executeNow = QCloudHttpClient.getDefault().resolveRequest(buildRequest(this.requestBuilder)).executeNow();
            if (executeNow.isSuccessful()) {
                return parseServerResponse((String) executeNow.content());
            }
            throw new QCloudClientException("fetch new credentials error ", new QCloudAuthenticationException(executeNow.asException().getMessage()));
        } catch (QCloudServiceException e) {
            throw new QCloudClientException("fetch new credentials error ", new QCloudAuthenticationException(e.getMessage()));
        }
    }

    protected SessionQCloudCredentials parseServerResponse(String str) throws QCloudClientException {
        return SessionCredentialProvider.parseStandardSTSJsonResponse(str);
    }
}
