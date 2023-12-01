package com.youzan.jsbridge.method;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bc;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/method/JsMethodCompat.class */
public class JsMethodCompat implements Method {
    public String callback;
    public String name;
    public String params;

    public JsMethodCompat(String str, String str2) {
        this.name = str;
        this.params = str2;
        parseCallback(str2);
    }

    private void parseCallback(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.callback = new JSONObject(str).optString(bc.e.D, null);
                return;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.callback = null;
    }

    @Override // com.youzan.jsbridge.method.Method
    public String getCallback() {
        return this.callback;
    }

    @Override // com.youzan.jsbridge.method.Method
    public String getName() {
        return this.name;
    }

    public String getParams() {
        return this.params;
    }
}
