package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/ScopeLimitCredentialProvider.class */
public interface ScopeLimitCredentialProvider extends QCloudCredentialProvider {
    SessionQCloudCredentials getCredentials(STSCredentialScope[] sTSCredentialScopeArr) throws QCloudClientException;
}
