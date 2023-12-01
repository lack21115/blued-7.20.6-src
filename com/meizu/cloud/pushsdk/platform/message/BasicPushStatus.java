package com.meizu.cloud.pushsdk.platform.message;

import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/platform/message/BasicPushStatus.class */
public abstract class BasicPushStatus implements Serializable {
    public static final String SUCCESS_CODE = "200";
    public static final String TAG = "BasicPushStatus";
    public String code;
    public String message;

    public BasicPushStatus() {
    }

    public BasicPushStatus(String str) {
        JSONObject parse = parse(str);
        if (parse == null || !SUCCESS_CODE.equals(this.code) || parse.isNull("value")) {
            return;
        }
        try {
            parseValueData(parse.getJSONObject("value"));
        } catch (JSONException e) {
            DebugLogger.e(TAG, "parse value data error " + e.getMessage() + " json " + str);
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    protected JSONObject parse(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
                try {
                    if (!jSONObject.isNull("code")) {
                        setCode(jSONObject.getString("code"));
                    }
                    if (!jSONObject.isNull("message")) {
                        setMessage(jSONObject.getString("message"));
                    }
                    return jSONObject;
                } catch (JSONException e) {
                    e = e;
                    DebugLogger.e(TAG, "covert json error " + e.getMessage());
                    jSONObject2 = jSONObject;
                    return jSONObject2;
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = null;
            }
        }
        return jSONObject2;
    }

    public abstract void parseValueData(JSONObject jSONObject) throws JSONException;

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "BasicPushStatus{code='" + this.code + "', message='" + this.message + "'}";
    }
}
