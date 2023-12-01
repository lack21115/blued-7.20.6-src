package com.tencent.qcloud.core.auth;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/StaticCredentialProvider.class */
public class StaticCredentialProvider implements QCloudCredentialProvider {
    private QCloudCredentials mCredentials;

    public StaticCredentialProvider() {
    }

    public StaticCredentialProvider(QCloudCredentials qCloudCredentials) {
        this.mCredentials = qCloudCredentials;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentialProvider
    public QCloudCredentials getCredentials() {
        return this.mCredentials;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentialProvider
    public void refresh() {
    }

    public void update(QCloudCredentials qCloudCredentials) {
        this.mCredentials = qCloudCredentials;
    }
}
