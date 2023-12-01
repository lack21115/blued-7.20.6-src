package com.tencent.qcloud.core.auth;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/QCloudLifecycleCredentials.class */
public interface QCloudLifecycleCredentials extends QCloudCredentials {
    String getKeyTime();

    String getSignKey();

    boolean isValid();
}
