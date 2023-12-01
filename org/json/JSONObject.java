package org.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONStringer;

/* loaded from: source-2895416-dex2jar.jar:org/json/JSONObject.class */
public class JSONObject {
    private static final Double NEGATIVE_ZERO = Double.valueOf(0.0d);
    public static final Object NULL = new Object() { // from class: org.json.JSONObject.1
        public boolean equals(Object obj) {
            return obj == this || obj == null;
        }

        public String toString() {
            return "null";
        }
    };
    private final LinkedHashMap<String, Object> nameValuePairs;

    public JSONObject() {
        this.nameValuePairs = new LinkedHashMap<>();
    }

    public JSONObject(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONObject(Map map) {
        this();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new NullPointerException("key == null");
            }
            this.nameValuePairs.put(str, wrap(entry.getValue()));
        }
    }

    public JSONObject(JSONObject jSONObject, String[] strArr) throws JSONException {
        this();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            Object opt = jSONObject.opt(str);
            if (opt != null) {
                this.nameValuePairs.put(str, opt);
            }
            i = i2 + 1;
        }
    }

    public JSONObject(JSONTokener jSONTokener) throws JSONException {
        Object nextValue = jSONTokener.nextValue();
        if (!(nextValue instanceof JSONObject)) {
            throw JSON.typeMismatch(nextValue, "JSONObject");
        }
        this.nameValuePairs = ((JSONObject) nextValue).nameValuePairs;
    }

    public static String numberToString(Number number) throws JSONException {
        if (number == null) {
            throw new JSONException("Number must be non-null");
        }
        double doubleValue = number.doubleValue();
        JSON.checkDouble(doubleValue);
        if (number.equals(NEGATIVE_ZERO)) {
            return "-0";
        }
        long longValue = number.longValue();
        return doubleValue == ((double) longValue) ? Long.toString(longValue) : number.toString();
    }

    public static String quote(String str) {
        if (str == null) {
            return "\"\"";
        }
        try {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.open(JSONStringer.Scope.NULL, "");
            jSONStringer.value(str);
            jSONStringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
            return jSONStringer.toString();
        } catch (JSONException e) {
            throw new AssertionError();
        }
    }

    public static Object wrap(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = NULL;
        } else {
            obj2 = obj;
            if (!(obj instanceof JSONArray)) {
                obj2 = obj;
                if (!(obj instanceof JSONObject)) {
                    obj2 = obj;
                    if (!obj.equals(NULL)) {
                        try {
                            if (obj instanceof Collection) {
                                return new JSONArray((Collection) obj);
                            }
                            if (obj.getClass().isArray()) {
                                return new JSONArray(obj);
                            }
                            if (obj instanceof Map) {
                                return new JSONObject((Map) obj);
                            }
                            obj2 = obj;
                            if (!(obj instanceof Boolean)) {
                                obj2 = obj;
                                if (!(obj instanceof Byte)) {
                                    obj2 = obj;
                                    if (!(obj instanceof Character)) {
                                        obj2 = obj;
                                        if (!(obj instanceof Double)) {
                                            obj2 = obj;
                                            if (!(obj instanceof Float)) {
                                                obj2 = obj;
                                                if (!(obj instanceof Integer)) {
                                                    obj2 = obj;
                                                    if (!(obj instanceof Long)) {
                                                        obj2 = obj;
                                                        if (!(obj instanceof Short)) {
                                                            obj2 = obj;
                                                            if (!(obj instanceof String)) {
                                                                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                                                                    return obj.toString();
                                                                }
                                                                return null;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            return null;
                        }
                    }
                }
            }
        }
        return obj2;
    }

    public JSONObject accumulate(String str, Object obj) throws JSONException {
        Object obj2 = this.nameValuePairs.get(checkName(str));
        if (obj2 == null) {
            return put(str, obj);
        }
        if (obj2 instanceof JSONArray) {
            ((JSONArray) obj2).checkedPut(obj);
            return this;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.checkedPut(obj2);
        jSONArray.checkedPut(obj);
        this.nameValuePairs.put(str, jSONArray);
        return this;
    }

    public JSONObject append(String str, Object obj) throws JSONException {
        JSONArray jSONArray;
        Object obj2 = this.nameValuePairs.get(checkName(str));
        if (obj2 instanceof JSONArray) {
            jSONArray = (JSONArray) obj2;
        } else if (obj2 != null) {
            throw new JSONException("Key " + str + " is not a JSONArray");
        } else {
            JSONArray jSONArray2 = new JSONArray();
            this.nameValuePairs.put(str, jSONArray2);
            jSONArray = jSONArray2;
        }
        jSONArray.checkedPut(obj);
        return this;
    }

    String checkName(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Names must be non-null");
        }
        return str;
    }

    public Object get(String str) throws JSONException {
        Object obj = this.nameValuePairs.get(str);
        if (obj == null) {
            throw new JSONException("No value for " + str);
        }
        return obj;
    }

    public boolean getBoolean(String str) throws JSONException {
        Object obj = get(str);
        Boolean bool = JSON.toBoolean(obj);
        if (bool == null) {
            throw JSON.typeMismatch(str, obj, "boolean");
        }
        return bool.booleanValue();
    }

    public double getDouble(String str) throws JSONException {
        Object obj = get(str);
        Double d = JSON.toDouble(obj);
        if (d == null) {
            throw JSON.typeMismatch(str, obj, "double");
        }
        return d.doubleValue();
    }

    public int getInt(String str) throws JSONException {
        Object obj = get(str);
        Integer integer = JSON.toInteger(obj);
        if (integer == null) {
            throw JSON.typeMismatch(str, obj, "int");
        }
        return integer.intValue();
    }

    public JSONArray getJSONArray(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(str, obj, "JSONArray");
    }

    public JSONObject getJSONObject(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(str, obj, "JSONObject");
    }

    public long getLong(String str) throws JSONException {
        Object obj = get(str);
        Long l = JSON.toLong(obj);
        if (l == null) {
            throw JSON.typeMismatch(str, obj, "long");
        }
        return l.longValue();
    }

    public String getString(String str) throws JSONException {
        Object obj = get(str);
        String json = JSON.toString(obj);
        if (json == null) {
            throw JSON.typeMismatch(str, obj, "String");
        }
        return json;
    }

    public boolean has(String str) {
        return this.nameValuePairs.containsKey(str);
    }

    public boolean isNull(String str) {
        Object obj = this.nameValuePairs.get(str);
        return obj == null || obj == NULL;
    }

    public Set<String> keySet() {
        return this.nameValuePairs.keySet();
    }

    public Iterator<String> keys() {
        return this.nameValuePairs.keySet().iterator();
    }

    public int length() {
        return this.nameValuePairs.size();
    }

    public JSONArray names() {
        if (this.nameValuePairs.isEmpty()) {
            return null;
        }
        return new JSONArray((Collection) new ArrayList(this.nameValuePairs.keySet()));
    }

    public Object opt(String str) {
        return this.nameValuePairs.get(str);
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean bool = JSON.toBoolean(opt(str));
        if (bool != null) {
            z = bool.booleanValue();
        }
        return z;
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public double optDouble(String str, double d) {
        Double d2 = JSON.toDouble(opt(str));
        if (d2 != null) {
            d = d2.doubleValue();
        }
        return d;
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer integer = JSON.toInteger(opt(str));
        if (integer != null) {
            i = integer.intValue();
        }
        return i;
    }

    public JSONArray optJSONArray(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(String str) {
        Object opt = opt(str);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(String str) {
        return optLong(str, 0L);
    }

    public long optLong(String str, long j) {
        Long l = JSON.toLong(opt(str));
        if (l != null) {
            j = l.longValue();
        }
        return j;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String json = JSON.toString(opt(str));
        return json != null ? json : str2;
    }

    public JSONObject put(String str, double d) throws JSONException {
        this.nameValuePairs.put(checkName(str), Double.valueOf(JSON.checkDouble(d)));
        return this;
    }

    public JSONObject put(String str, int i) throws JSONException {
        this.nameValuePairs.put(checkName(str), Integer.valueOf(i));
        return this;
    }

    public JSONObject put(String str, long j) throws JSONException {
        this.nameValuePairs.put(checkName(str), Long.valueOf(j));
        return this;
    }

    public JSONObject put(String str, Object obj) throws JSONException {
        if (obj == null) {
            this.nameValuePairs.remove(str);
            return this;
        }
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        this.nameValuePairs.put(checkName(str), obj);
        return this;
    }

    public JSONObject put(String str, boolean z) throws JSONException {
        this.nameValuePairs.put(checkName(str), Boolean.valueOf(z));
        return this;
    }

    public JSONObject putOpt(String str, Object obj) throws JSONException {
        return (str == null || obj == null) ? this : put(str, obj);
    }

    public Object remove(String str) {
        return this.nameValuePairs.remove(str);
    }

    public JSONArray toJSONArray(JSONArray jSONArray) throws JSONException {
        JSONArray jSONArray2;
        JSONArray jSONArray3 = new JSONArray();
        if (jSONArray != null) {
            int length = jSONArray.length();
            if (length != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    jSONArray2 = jSONArray3;
                    if (i2 >= length) {
                        break;
                    }
                    jSONArray3.put(opt(JSON.toString(jSONArray.opt(i2))));
                    i = i2 + 1;
                }
            } else {
                return null;
            }
        } else {
            jSONArray2 = null;
        }
        return jSONArray2;
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
        jSONStringer.object();
        for (Map.Entry<String, Object> entry : this.nameValuePairs.entrySet()) {
            jSONStringer.key(entry.getKey()).value(entry.getValue());
        }
        jSONStringer.endObject();
    }
}
