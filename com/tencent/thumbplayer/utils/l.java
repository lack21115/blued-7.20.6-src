package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/l.class */
public class l implements com.tencent.thumbplayer.common.a.a {

    /* renamed from: a  reason: collision with root package name */
    protected final Properties f39441a;

    public l() {
        this(null);
    }

    public l(Properties properties) {
        this.f39441a = new Properties();
        if (properties != null) {
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                a((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public Properties a() {
        return this.f39441a;
    }

    @Override // com.tencent.thumbplayer.common.a.a
    public void a(String str, float f) {
        if (str != null) {
            this.f39441a.put(str, String.valueOf(f));
        }
    }

    @Override // com.tencent.thumbplayer.common.a.a
    public void a(String str, int i) {
        if (str != null) {
            this.f39441a.put(str, String.valueOf(i));
        }
    }

    @Override // com.tencent.thumbplayer.common.a.a
    public void a(String str, long j) {
        if (str != null) {
            this.f39441a.put(str, String.valueOf(j));
        }
    }

    @Override // com.tencent.thumbplayer.common.a.a
    public void a(String str, String str2) {
        if (str != null) {
            if (TextUtils.isEmpty(str2)) {
                this.f39441a.put(str, "");
            } else {
                this.f39441a.put(str, str2);
            }
        }
    }

    @Override // com.tencent.thumbplayer.common.a.a
    public void a(Map<String, String> map) {
        if (map == null) {
            throw new IllegalArgumentException("map must not be null!");
        }
        for (Map.Entry<Object, Object> entry : this.f39441a.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                map.put(key.toString(), "");
            } else {
                map.put(key.toString(), value.toString());
            }
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject(this.f39441a);
        if (jSONObject.has("data")) {
            try {
                String string = jSONObject.getString("data");
                jSONObject.remove("data");
                jSONObject.put("data", new JSONObject(string));
            } catch (JSONException e) {
                TPLogUtil.e("TPProperties", e);
            }
        }
        return jSONObject.toString();
    }
}
