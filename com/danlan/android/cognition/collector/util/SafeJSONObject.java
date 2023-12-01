package com.danlan.android.cognition.collector.util;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/collector/util/SafeJSONObject.class */
public class SafeJSONObject extends JSONObject {
    @Override // org.json.JSONObject
    public JSONObject put(String str, double d) {
        try {
            return super.put(str, d);
        } catch (Exception e) {
            return this;
        }
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i) {
        try {
            return super.put(str, i);
        } catch (Exception e) {
            return this;
        }
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j) {
        try {
            return super.put(str, j);
        } catch (Exception e) {
            return this;
        }
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) {
        Object obj2 = obj;
        if (obj == null) {
            try {
                obj2 = JSONObject.NULL;
            } catch (Exception e) {
                return this;
            }
        }
        try {
            return super.put(str, obj2);
        } catch (Exception e2) {
            return this;
        }
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        try {
            return super.put(str, z);
        } catch (Exception e) {
            return this;
        }
    }
}
