package com.tencent.qcloud.core.common;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/common/QCloudResultListener.class */
public interface QCloudResultListener<T> {
    void onFailure(QCloudClientException qCloudClientException, QCloudServiceException qCloudServiceException);

    void onSuccess(T t);
}
