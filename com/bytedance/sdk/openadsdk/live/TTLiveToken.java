package com.bytedance.sdk.openadsdk.live;

import java.io.Serializable;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/live/TTLiveToken.class */
public class TTLiveToken implements Serializable {
    public String accessToken;
    public long expireAt;
    public String name;
    public String openId;
    public String refreshToken;

    public TTLiveToken(String str, String str2, String str3, long j, String str4) {
        this.expireAt = 0L;
        this.refreshToken = "";
        this.name = str;
        this.accessToken = str2;
        this.openId = str3;
        this.expireAt = j;
        this.refreshToken = str4;
    }

    public String toString() {
        return "TTLiveToken{accessToken='" + this.accessToken + "', openId='" + this.openId + "', expireAt=" + this.expireAt + ", refreshToken='" + this.refreshToken + "'}";
    }
}
