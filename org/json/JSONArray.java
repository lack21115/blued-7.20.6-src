package org.json;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONStringer;

/* loaded from: source-2895416-dex2jar.jar:org/json/JSONArray.class */
public class JSONArray {
    private final List<Object> values;

    public JSONArray() {
        this.values = new ArrayList();
    }

    public JSONArray(Object obj) throws JSONException {
        if (!obj.getClass().isArray()) {
            throw new JSONException("Not a primitive array: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        this.values = new ArrayList(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            put(JSONObject.wrap(Array.get(obj, i2)));
            i = i2 + 1;
        }
    }

    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONArray(Collection collection) {
        this();
        if (collection != null) {
            for (Object obj : collection) {
                put(JSONObject.wrap(obj));
            }
        }
    }

    public JSONArray(JSONTokener jSONTokener) throws JSONException {
        Object nextValue = jSONTokener.nextValue();
        if (!(nextValue instanceof JSONArray)) {
            throw JSON.typeMismatch(nextValue, "JSONArray");
        }
        this.values = ((JSONArray) nextValue).values;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkedPut(Object obj) throws JSONException {
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        put(obj);
    }

    public boolean equals(Object obj) {
        return (obj instanceof JSONArray) && ((JSONArray) obj).values.equals(this.values);
    }

    public Object get(int i) throws JSONException {
        try {
            Object obj = this.values.get(i);
            if (obj == null) {
                throw new JSONException("Value at " + i + " is null.");
            }
            return obj;
        } catch (IndexOutOfBoundsException e) {
            throw new JSONException("Index " + i + " out of range [0.." + this.values.size() + ")");
        }
    }

    public boolean getBoolean(int i) throws JSONException {
        Object obj = get(i);
        Boolean bool = JSON.toBoolean(obj);
        if (bool == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, TypedValues.Custom.S_BOOLEAN);
        }
        return bool.booleanValue();
    }

    public double getDouble(int i) throws JSONException {
        Object obj = get(i);
        Double d = JSON.toDouble(obj);
        if (d == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, "double");
        }
        return d.doubleValue();
    }

    public int getInt(int i) throws JSONException {
        Object obj = get(i);
        Integer integer = JSON.toInteger(obj);
        if (integer == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        }
        return integer.intValue();
    }

    public JSONArray getJSONArray(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "JSONArray");
    }

    public JSONObject getJSONObject(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "JSONObject");
    }

    public long getLong(int i) throws JSONException {
        Object obj = get(i);
        Long l = JSON.toLong(obj);
        if (l == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, "long");
        }
        return l.longValue();
    }

    public String getString(int i) throws JSONException {
        Object obj = get(i);
        String json = JSON.toString(obj);
        if (json == null) {
            throw JSON.typeMismatch(Integer.valueOf(i), obj, "String");
        }
        return json;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public boolean isNull(int i) {
        Object opt = opt(i);
        return opt == null || opt == JSONObject.NULL;
    }

    public String join(String str) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer();
        jSONStringer.open(JSONStringer.Scope.NULL, "");
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                jSONStringer.out.append(str);
            }
            jSONStringer.value(this.values.get(i));
        }
        jSONStringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
        return jSONStringer.out.toString();
    }

    public int length() {
        return this.values.size();
    }

    public Object opt(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.get(i);
    }

    public boolean optBoolean(int i) {
        return optBoolean(i, false);
    }

    public boolean optBoolean(int i, boolean z) {
        Boolean bool = JSON.toBoolean(opt(i));
        if (bool != null) {
            z = bool.booleanValue();
        }
        return z;
    }

    public double optDouble(int i) {
        return optDouble(i, Double.NaN);
    }

    public double optDouble(int i, double d) {
        Double d2 = JSON.toDouble(opt(i));
        if (d2 != null) {
            d = d2.doubleValue();
        }
        return d;
    }

    public int optInt(int i) {
        return optInt(i, 0);
    }

    public int optInt(int i, int i2) {
        Integer integer = JSON.toInteger(opt(i));
        if (integer != null) {
            i2 = integer.intValue();
        }
        return i2;
    }

    public JSONArray optJSONArray(int i) {
        Object opt = opt(i);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(int i) {
        Object opt = opt(i);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(int i) {
        return optLong(i, 0L);
    }

    public long optLong(int i, long j) {
        Long l = JSON.toLong(opt(i));
        if (l != null) {
            j = l.longValue();
        }
        return j;
    }

    public String optString(int i) {
        return optString(i, "");
    }

    public String optString(int i, String str) {
        String json = JSON.toString(opt(i));
        return json != null ? json : str;
    }

    public JSONArray put(double d) throws JSONException {
        this.values.add(Double.valueOf(JSON.checkDouble(d)));
        return this;
    }

    public JSONArray put(int i) {
        this.values.add(Integer.valueOf(i));
        return this;
    }

    public JSONArray put(int i, double d) throws JSONException {
        return put(i, Double.valueOf(d));
    }

    public JSONArray put(int i, int i2) throws JSONException {
        return put(i, Integer.valueOf(i2));
    }

    public JSONArray put(int i, long j) throws JSONException {
        return put(i, Long.valueOf(j));
    }

    public JSONArray put(int i, Object obj) throws JSONException {
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        while (this.values.size() <= i) {
            this.values.add(null);
        }
        this.values.set(i, obj);
        return this;
    }

    public JSONArray put(int i, boolean z) throws JSONException {
        return put(i, Boolean.valueOf(z));
    }

    public JSONArray put(long j) {
        this.values.add(Long.valueOf(j));
        return this;
    }

    public JSONArray put(Object obj) {
        this.values.add(obj);
        return this;
    }

    public JSONArray put(boolean z) {
        this.values.add(Boolean.valueOf(z));
        return this;
    }

    public Object remove(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.remove(i);
    }

    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        int min = Math.min(jSONArray.length(), this.values.size());
        if (min != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                jSONObject = jSONObject2;
                if (i2 >= min) {
                    break;
                }
                jSONObject2.put(JSON.toString(jSONArray.opt(i2)), opt(i2));
                i = i2 + 1;
            }
        } else {
            jSONObject = null;
        }
        return jSONObject;
    }

    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            writeTo(jSONStringer);
            return jSONStringer.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    public String toString(int i) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer(i);
        writeTo(jSONStringer);
        return jSONStringer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(JSONStringer jSONStringer) throws JSONException {
        jSONStringer.array();
        for (Object obj : this.values) {
            jSONStringer.value(obj);
        }
        jSONStringer.endArray();
    }
}
