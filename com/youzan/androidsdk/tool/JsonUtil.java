package com.youzan.androidsdk.tool;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.igexin.push.core.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/JsonUtil.class */
public class JsonUtil {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Gson f1138;

    static {
        JsonUtil.class.getSimpleName();
        f1138 = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ").setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) f1138.fromJson(str, (Class<Object>) cls);
    }

    public static <T> T fromJson(String str, Type type) {
        return (T) f1138.fromJson(str, type);
    }

    public static <T> T fromJsonObj(JSONObject jSONObject, Class<T> cls) {
        return (T) fromJson(jSONObject.toString(), (Class<Object>) cls);
    }

    public static HashMap<String, String> fromJsonToMap(String str) {
        return (HashMap) f1138.fromJson(str, new TypeToken<HashMap<String, String>>() { // from class: com.youzan.androidsdk.tool.JsonUtil.1
        }.getType());
    }

    public static <T> List<T> getObjectListFromJsonArray(JsonArray jsonArray, Class<T> cls) {
        if (jsonArray == null || b.l.equals(jsonArray.toString())) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(jsonArray.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jsonArray.size()) {
                return arrayList;
            }
            arrayList.add(f1138.fromJson(jsonArray.get(i2), (Class<Object>) cls));
            i = i2 + 1;
        }
    }

    public static <T> List<T> getObjectListFromStr(String str, Class<T> cls) {
        return getObjectListFromJsonArray((JsonArray) fromJson(str, (Class<Object>) JsonArray.class), cls);
    }

    public static String mapToJson(Map<String, String> map) {
        return new GsonBuilder().enableComplexMapKeySerialization().create().toJson(map);
    }

    public static JSONObject readJSONObject(JsonReader jsonReader) throws IOException, JSONException {
        JSONArray m12245;
        jsonReader.beginObject();
        JSONObject jSONObject = new JSONObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                m12245 = new JSONArray();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    m12245.put(m12245(jsonReader));
                }
                jsonReader.endArray();
            } else {
                m12245 = m12245(jsonReader);
            }
            jSONObject.put(nextName, m12245);
        }
        jsonReader.endObject();
        return jSONObject;
    }

    public static <T> List<T> toArrayList(JSONArray jSONArray) {
        return jSONArray == null ? new ArrayList() : (List) f1138.fromJson(jSONArray.toString(), new TypeToken<List<T>>() { // from class: com.youzan.androidsdk.tool.JsonUtil.2
        }.getType());
    }

    public static String toJson(Object obj) {
        return f1138.toJson(obj);
    }

    public static String toJson(Object obj, Type type) {
        return f1138.toJson(obj, type);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Object m12245(JsonReader jsonReader) throws IOException, JSONException {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_OBJECT) {
            return readJSONObject(jsonReader);
        }
        if (peek == JsonToken.BOOLEAN) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (peek == JsonToken.NUMBER) {
            return Long.valueOf(jsonReader.nextLong());
        }
        if (peek == JsonToken.STRING) {
            return jsonReader.nextString();
        }
        if (peek == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        jsonReader.skipValue();
        return null;
    }
}
