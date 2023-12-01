package com.youzan.spiderman.utils;

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

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/JsonUtil.class */
public class JsonUtil {
    private static final String TAG = JsonUtil.class.getSimpleName();
    private static Gson sGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ").setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) sGson.fromJson(str, (Class<Object>) cls);
    }

    public static <T> T fromJson(String str, Type type) {
        return (T) sGson.fromJson(str, type);
    }

    public static <T> T fromJsonObj(JSONObject jSONObject, Class<T> cls) {
        return (T) fromJson(jSONObject.toString(), (Class<Object>) cls);
    }

    public static HashMap<String, String> fromJsonToMap(String str) {
        return (HashMap) sGson.fromJson(str, new TypeToken<HashMap<String, String>>() { // from class: com.youzan.spiderman.utils.JsonUtil.1
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
            arrayList.add(sGson.fromJson(jsonArray.get(i2), (Class<Object>) cls));
            i = i2 + 1;
        }
    }

    public static <T> List<T> getObjectListFromStr(String str, Class<T> cls) {
        return getObjectListFromJsonArray((JsonArray) fromJson(str, (Class<Object>) JsonArray.class), cls);
    }

    public static String mapToJson(Map<String, String> map) {
        return new GsonBuilder().enableComplexMapKeySerialization().create().toJson(map);
    }

    private static Object nextValue(JsonReader jsonReader) throws IOException, JSONException {
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

    public static JSONObject readJSONObject(JsonReader jsonReader) throws IOException, JSONException {
        JSONArray nextValue;
        jsonReader.beginObject();
        JSONObject jSONObject = new JSONObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                nextValue = new JSONArray();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    nextValue.put(nextValue(jsonReader));
                }
                jsonReader.endArray();
            } else {
                nextValue = nextValue(jsonReader);
            }
            jSONObject.put(nextName, nextValue);
        }
        jsonReader.endObject();
        return jSONObject;
    }

    public static <T> List<T> toArrayList(JSONArray jSONArray) {
        return jSONArray == null ? new ArrayList() : (List) sGson.fromJson(jSONArray.toString(), new TypeToken<List<T>>() { // from class: com.youzan.spiderman.utils.JsonUtil.2
        }.getType());
    }

    public static String toJson(Object obj) {
        return sGson.toJson(obj);
    }

    public static String toJson(Object obj, Type type) {
        return sGson.toJson(obj, type);
    }
}
