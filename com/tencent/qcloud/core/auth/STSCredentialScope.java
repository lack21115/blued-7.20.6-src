package com.tencent.qcloud.core.auth;

import android.media.TtmlUtils;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/auth/STSCredentialScope.class */
public class STSCredentialScope {
    static final STSCredentialScope NONE = new STSCredentialScope(null, null, null, null);
    public final String action;
    public final String bucket;
    public final String prefix;
    public final String region;

    public STSCredentialScope(String str, String str2, String str3, String str4) {
        this.action = str;
        this.bucket = str2;
        this.region = str3;
        if (str4 == null || str4.charAt(0) != '/') {
            this.prefix = str4;
        } else {
            this.prefix = str4.substring(1);
        }
    }

    public static String jsonify(STSCredentialScope[] sTSCredentialScopeArr) {
        JSONArray jSONArray = new JSONArray();
        int length = sTSCredentialScopeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return jSONArray.toString();
            }
            STSCredentialScope sTSCredentialScope = sTSCredentialScopeArr[i2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", sTSCredentialScope.action);
                jSONObject.put("bucket", sTSCredentialScope.bucket);
                jSONObject.put("prefix", sTSCredentialScope.prefix);
                jSONObject.put(TtmlUtils.TAG_REGION, sTSCredentialScope.region);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
            i = i2 + 1;
        }
    }

    public static STSCredentialScope[] toArray(STSCredentialScope... sTSCredentialScopeArr) {
        return sTSCredentialScopeArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof STSCredentialScope) {
            STSCredentialScope sTSCredentialScope = (STSCredentialScope) obj;
            boolean z = false;
            if (TextUtils.equals(this.action, sTSCredentialScope.action)) {
                z = false;
                if (TextUtils.equals(this.bucket, sTSCredentialScope.bucket)) {
                    z = false;
                    if (TextUtils.equals(this.prefix, sTSCredentialScope.prefix)) {
                        z = false;
                        if (TextUtils.equals(this.region, sTSCredentialScope.region)) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public STSCredentialScope[] toArray() {
        return toArray(this);
    }
}
