package com.huawei.openalliance.ad.msgnotify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.utils.SafeIntent;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/msgnotify/c.class */
public abstract class c {
    private static final String Code = "MsgConverter";

    public static Intent Code(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Intent intent = new Intent();
            String optString = jSONObject.optString(at.t);
            intent.setAction(jSONObject.optString(at.w));
            intent.putExtra(at.t, optString);
            JSONObject optJSONObject = jSONObject.optJSONObject(at.u);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = optJSONObject.get(next);
                    if (obj instanceof Serializable) {
                        intent.putExtra(next, (Serializable) obj);
                    }
                }
            }
            return intent;
        } catch (JSONException e) {
            ge.I(Code, "convertMsgJsonToIntent JSONException");
            return null;
        }
    }

    public static String Code(String str, String str2, Intent intent) {
        SafeIntent safeIntent;
        Bundle extras;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || intent == null || (extras = (safeIntent = new SafeIntent(intent)).getExtras()) == null) {
            return "";
        }
        Set<String> keySet = extras.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str3 : keySet) {
            try {
                jSONObject.putOpt(str3, extras.get(str3));
            } catch (JSONException e) {
                ge.I(Code, "convertMsgToJson - msg json set exception");
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(at.s, str);
            jSONObject2.put(at.t, str2);
            jSONObject2.put(at.u, jSONObject);
            jSONObject2.put(at.w, safeIntent.getAction());
            return jSONObject2.toString();
        } catch (JSONException e2) {
            ge.I(Code, "convertMsgToJson - param json set exception");
            return "";
        }
    }
}
