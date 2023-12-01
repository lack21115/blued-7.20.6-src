package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudProgressListener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/ProgressBody.class */
public interface ProgressBody {
    long getBytesTransferred();

    void setProgressListener(QCloudProgressListener qCloudProgressListener);
}
