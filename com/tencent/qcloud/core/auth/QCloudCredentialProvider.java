package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/QCloudCredentialProvider.class */
public interface QCloudCredentialProvider {
    QCloudCredentials getCredentials() throws QCloudClientException;

    void refresh() throws QCloudClientException;
}
