package com.tencent.map.tools.json;

import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.annotation.JsonType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/json/JsonUtils.class */
public class JsonUtils {
    public static <T> String collectionToJson(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (T t : collection) {
            if (t instanceof JsonEncoder) {
                jSONArray.put(((JsonEncoder) t).toJson());
            } else {
                jSONArray.put((Object) null);
            }
        }
        return jSONArray.toString();
    }

    public static <T> JSONObject modelToJson(T t) {
        if (t instanceof JsonEncoder) {
            return ((JsonEncoder) t).toJson();
        }
        return null;
    }

    public static <T> String modelToJsonString(T t) {
        JSONObject modelToJson = modelToJson(t);
        if (modelToJson != null) {
            return modelToJson.toString();
        }
        return null;
    }

    public static <C extends Collection> C parseTo(Class<C> cls, JSONArray jSONArray, Class cls2, Object... objArr) {
        C c2 = (C) Util.newInstance(cls, new Object[0]);
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object opt = jSONArray.opt(i);
                if (opt instanceof JSONArray) {
                    c2.add(parseTo(cls, (JSONArray) opt, cls2, objArr));
                } else if (opt instanceof JSONObject) {
                    c2.add(parseToModel((JSONObject) opt, cls2, objArr));
                } else if (opt.getClass() == cls2) {
                    c2.add(opt);
                } else if (opt instanceof Integer) {
                    if (cls2 == Double.class) {
                        c2.add(Double.valueOf(((Integer) opt).doubleValue()));
                    } else if (cls2 == Long.class) {
                        c2.add(Long.valueOf(((Integer) opt).longValue()));
                    } else if (cls2 == Float.class) {
                        c2.add(Float.valueOf(((Integer) opt).floatValue()));
                    } else if (cls2 == String.class) {
                        c2.add(opt.toString());
                    }
                } else if (opt instanceof Double) {
                    if (cls2 == Integer.class) {
                        c2.add(Integer.valueOf(((Double) opt).intValue()));
                    } else if (cls2 == Long.class) {
                        c2.add(Long.valueOf(((Double) opt).longValue()));
                    } else if (cls2 == Float.class) {
                        c2.add(Float.valueOf(((Double) opt).floatValue()));
                    } else if (cls2 == String.class) {
                        c2.add(opt.toString());
                    }
                } else if (opt instanceof Long) {
                    if (cls2 == Integer.class) {
                        c2.add(Integer.valueOf(((Long) opt).intValue()));
                    } else if (cls2 == Double.class) {
                        c2.add(Double.valueOf(((Long) opt).doubleValue()));
                    } else if (cls2 == Float.class) {
                        c2.add(Float.valueOf(((Long) opt).floatValue()));
                    } else if (cls2 == String.class) {
                        c2.add(opt.toString());
                    }
                }
            }
        }
        return c2;
    }

    public static Object parseToArray(JSONArray jSONArray, Class cls) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        Object newInstance = Array.newInstance(cls, length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return newInstance;
            }
            try {
                Array.set(newInstance, i2, jSONArray.get(i2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    public static <T> List<T> parseToList(JSONArray jSONArray, Class<T> cls, Object... objArr) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                arrayList.add(parseToModel(jSONArray.optJSONObject(i2), cls, objArr));
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public static <T> T parseToModel(String str, Class<T> cls, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (T) parseToModel(new JSONObject(str), cls, objArr);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T parseToModel(JSONObject jSONObject, Class<T> cls, Object... objArr) {
        JsonType jsonType = (JsonType) cls.getAnnotation(JsonType.class);
        T t = null;
        if (jsonType != null) {
            Class<? extends JsonParser.Deserializer> deserializer = jsonType.deserializer();
            t = null;
            if (deserializer != JsonParser.Deserializer.class) {
                try {
                    Object deserialize = ((JsonParser.Deserializer) Util.newInstance(deserializer, new Object[0])).deserialize(null, "", jSONObject);
                    t = null;
                    if (deserialize != 0) {
                        t = null;
                        if (cls.isAssignableFrom(deserialize.getClass())) {
                            t = deserialize;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    t = null;
                }
            }
        }
        T t2 = t;
        if (t == null) {
            t2 = Util.newInstance(cls, objArr);
        }
        if (t2 instanceof JsonParser) {
            ((JsonParser) t2).parse(jSONObject);
        }
        return t2;
    }
}
