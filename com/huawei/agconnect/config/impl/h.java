package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.baidu.mobads.sdk.internal.ci;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/config/impl/h.class */
class h implements d {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f22337a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(InputStream inputStream) {
        this.f22337a = a(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(InputStream inputStream, String str) {
        this.f22337a = a(inputStream);
        a(str);
    }

    private JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException e) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException e2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    private void a(String str) {
        try {
            JSONObject b = b(str);
            if (b == null) {
                return;
            }
            String a2 = a("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal(ci.d);
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(a2));
            } catch (NumberFormatException e) {
                Log.d("InputStreamReader", "configuration_version to double error");
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f22337a.getJSONObject("client").put("app_id", b.getString("app_id"));
            } else if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                Iterator<String> keys = b.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!"package_name".equals(next)) {
                        a(next, b.get(next), this.f22337a);
                    }
                }
            }
        } catch (JSONException e2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    private void a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    private JSONObject b(String str) throws JSONException {
        JSONArray jSONArray = this.f22337a.getJSONArray("appInfos");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return null;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
            i = i2 + 1;
        }
    }

    @Override // com.huawei.agconnect.config.impl.d
    public String a(String str, String str2) {
        if (str.endsWith(BridgeUtil.SPLIT_MARK)) {
            return str2;
        }
        String[] split = str.split(BridgeUtil.SPLIT_MARK);
        try {
            JSONObject jSONObject = this.f22337a;
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    break;
                } else if (i2 == split.length - 1) {
                    return jSONObject.get(split[i2]).toString();
                } else {
                    jSONObject = jSONObject.getJSONObject(split[i2]);
                    i = i2 + 1;
                }
            }
        } catch (JSONException e) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f22337a.toString().hashCode() + '}';
    }
}
