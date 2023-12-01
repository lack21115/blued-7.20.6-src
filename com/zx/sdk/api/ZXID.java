package com.zx.sdk.api;

import android.text.TextUtils;
import com.zx.a.I8b7.z1;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/sdk/api/ZXID.class */
public class ZXID implements Serializable {
    private String aids;
    private long expiredTime;
    private String openid;
    private String tags;
    private String value;
    private String version;

    public JSONObject getAids() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.aids)) {
                return new JSONObject(this.aids);
            }
        } catch (Exception e) {
            z1.a(e);
        }
        return jSONObject;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public String getOpenid() {
        return this.openid;
    }

    public String getTags() {
        return this.tags;
    }

    public String getValue() {
        return this.value;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() / 1000 >= this.expiredTime;
    }

    public void setAids(String str) {
        this.aids = str;
    }

    public void setExpiredTime(long j) {
        this.expiredTime = j;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return getValue();
    }
}
