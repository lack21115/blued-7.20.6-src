package com.tencent.qcloud.core.auth;

import com.huawei.openalliance.ad.constant.t;
import com.tencent.qcloud.core.http.HttpConfiguration;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/SessionQCloudCredentials.class */
public class SessionQCloudCredentials implements QCloudLifecycleCredentials, QCloudRawCredentials {
    private final long expiredTime;
    private final String secretId;
    private final String secretKey;
    private final long startTime;
    private final String token;

    public SessionQCloudCredentials(String str, String str2, String str3, long j) {
        this(str, str2, str3, HttpConfiguration.getDeviceTimeWithOffset(), j);
    }

    public SessionQCloudCredentials(String str, String str2, String str3, long j, long j2) {
        if (str == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("secretKey cannot be null.");
        }
        if (str3 == null) {
            throw new IllegalArgumentException("token cannot be null.");
        }
        if (j >= j2) {
            throw new IllegalArgumentException("beginTime must be less than expiredTime.");
        }
        this.secretId = str;
        this.secretKey = str2;
        this.startTime = j;
        this.expiredTime = j2;
        this.token = str3;
    }

    public SessionQCloudCredentials(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("secretKey cannot be null.");
        }
        if (str3 == null) {
            throw new IllegalArgumentException("token cannot be null.");
        }
        if (str4 == null) {
            throw new IllegalArgumentException("keyTime cannot be null.");
        }
        this.secretId = str;
        this.secretKey = str2;
        this.token = str3;
        long[] parseKeyTimes = Utils.parseKeyTimes(str4);
        this.startTime = parseKeyTimes[0];
        this.expiredTime = parseKeyTimes[1];
    }

    private String getKeyTime(long j, long j2) {
        return Utils.handleTimeAccuracy(j) + t.aE + Utils.handleTimeAccuracy(j2);
    }

    private String getSignKey(String str, String str2) {
        byte[] hmacSha1 = Utils.hmacSha1(str2, str);
        if (hmacSha1 != null) {
            return new String(Utils.encodeHex(hmacSha1));
        }
        return null;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudLifecycleCredentials
    public String getKeyTime() {
        return Utils.handleTimeAccuracy(this.startTime) + t.aE + Utils.handleTimeAccuracy(this.expiredTime);
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentials
    public String getSecretId() {
        return this.secretId;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudRawCredentials
    public String getSecretKey() {
        return this.secretKey;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudLifecycleCredentials
    public String getSignKey() {
        return getSignKey(this.secretKey, getKeyTime());
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getToken() {
        return this.token;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudLifecycleCredentials
    public boolean isValid() {
        long deviceTimeWithOffset = HttpConfiguration.getDeviceTimeWithOffset();
        return deviceTimeWithOffset >= this.startTime && deviceTimeWithOffset <= this.expiredTime - 60;
    }
}
