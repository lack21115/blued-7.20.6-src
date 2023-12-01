package com.youzan.jsbridge.method;

import com.google.gson.annotations.SerializedName;
import com.youzan.jsbridge.jsondata.JsonDataValue;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/method/JsMethod.class */
public class JsMethod implements Method {
    @SerializedName("callback_id")
    public String callbackId;
    @SerializedName("method")
    public String name;
    @SerializedName("data")
    public Map<String, JsonDataValue> params;

    @Override // com.youzan.jsbridge.method.Method
    public String getCallback() {
        return this.callbackId;
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    @Override // com.youzan.jsbridge.method.Method
    public String getName() {
        return this.name;
    }

    public Map<String, JsonDataValue> getParams() {
        return this.params;
    }
}
