package com.sdk.tencent.base.framework.bean;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/framework/bean/DataInfo.class */
public class DataInfo extends JSONObject {
    public DataInfo() {
        try {
            put("r", System.currentTimeMillis());
        } catch (JSONException e) {
        }
    }

    public JSONObject putData(String str, Object obj) {
        try {
            return super.put(str, obj);
        } catch (Exception e) {
            return this;
        }
    }

    public String toAESString() {
        return "";
    }
}
