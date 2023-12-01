package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConfiguration;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/ShortTimeCredentialProvider.class */
public class ShortTimeCredentialProvider extends BasicLifecycleCredentialProvider {
    private long duration;
    private String secretId;
    private String secretKey;

    @Deprecated
    public ShortTimeCredentialProvider(String str, String str2, long j) {
        this.secretId = str;
        this.secretKey = str2;
        this.duration = j;
    }

    private String secretKey2SignKey(String str, String str2) {
        byte[] hmacSha1 = Utils.hmacSha1(str2, str);
        if (hmacSha1 != null) {
            return new String(Utils.encodeHex(hmacSha1));
        }
        return null;
    }

    @Override // com.tencent.qcloud.core.auth.BasicLifecycleCredentialProvider
    protected QCloudLifecycleCredentials fetchNewCredentials() throws QCloudClientException {
        long deviceTimeWithOffset = HttpConfiguration.getDeviceTimeWithOffset();
        long j = this.duration;
        String str = deviceTimeWithOffset + ";" + (j + deviceTimeWithOffset);
        return new BasicQCloudCredentials(this.secretId, this.secretKey, secretKey2SignKey(this.secretKey, str), str);
    }

    public long getDuration() {
        return this.duration;
    }

    public String getSecretId() {
        return this.secretId;
    }

    public String getSecretKey() {
        return this.secretKey;
    }
}
