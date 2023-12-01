package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.QCloudHttpRequest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/QCloudSigner.class */
public interface QCloudSigner {
    void sign(QCloudHttpRequest qCloudHttpRequest, QCloudCredentials qCloudCredentials) throws QCloudClientException;
}
