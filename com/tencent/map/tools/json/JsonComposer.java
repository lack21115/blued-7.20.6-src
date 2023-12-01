package com.tencent.map.tools.json;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.json.annotation.JsonType;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/json/JsonComposer.class */
public abstract class JsonComposer implements JsonEncoder, JsonParser {
    private static Map<Class, Map<Field, String>> sClassJsonMap = new ConcurrentHashMap();
    private String mFieldNamePrefix;
    private Map<Field, String> mJsonFields;
    private FieldNameStyle mFieldNameStyle = FieldNameStyle.HUMP;
    private boolean mAllowEmpty = true;
    private Map<Field, JsonParser.Deserializer> mFieldDeserializer = new HashMap();
    private Map<Class, JsonParser.Deserializer> mClassDeserializer = new HashMap();

    private void checkJsonComposerElements() {
        ArrayList<Field> keySet;
        synchronized (this) {
            JsonType jsonType = (JsonType) getClass().getAnnotation(JsonType.class);
            if (jsonType != null) {
                this.mAllowEmpty = jsonType.allowEmpty();
                this.mFieldNameStyle = jsonType.fieldNameStyle();
                this.mFieldNamePrefix = jsonType.fieldNamePrefix();
                Class<? extends JsonParser.Deserializer> deserializer = jsonType.deserializer();
                if (deserializer != JsonParser.Deserializer.class) {
                    this.mClassDeserializer.put(getClass(), (JsonParser.Deserializer) Util.newInstance(deserializer, new Object[0]));
                }
            }
            this.mJsonFields = sClassJsonMap.get(getClass());
            ArrayList arrayList = new ArrayList();
            Map<Field, String> map = this.mJsonFields;
            if (map == null) {
                this.mJsonFields = new ConcurrentHashMap();
                for (Class<? super Object> cls = getClass(); cls != JsonComposer.class; cls = cls.getSuperclass()) {
                    arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
                }
                sClassJsonMap.put(getClass(), this.mJsonFields);
                keySet = arrayList;
            } else {
                keySet = map.keySet();
            }
            for (Field field : keySet) {
                if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                    JsonType jsonType2 = (JsonType) field.getType().getAnnotation(JsonType.class);
                    if (jsonType2 != null) {
                        Class<? extends JsonParser.Deserializer> deserializer2 = jsonType2.deserializer();
                        if (deserializer2 != JsonParser.Deserializer.class) {
                            this.mFieldDeserializer.put(field, (JsonParser.Deserializer) Util.newInstance(deserializer2, new Object[0]));
                        }
                    }
                    Json json = (Json) field.getAnnotation(Json.class);
                    if (json != null) {
                        if (!json.ignore()) {
                            if (TextUtils.isEmpty(json.name())) {
                                this.mJsonFields.put(field, translateFieldName(field.getName()));
                            } else {
                                this.mJsonFields.put(field, json.name());
                            }
                        }
                        Class<? extends JsonParser.Deserializer> deserializer3 = json.deserializer();
                        if (deserializer3 != JsonParser.Deserializer.class) {
                            this.mFieldDeserializer.put(field, (JsonParser.Deserializer) Util.newInstance(deserializer3, new Object[0]));
                        }
                    } else if (!field.getName().contains("this")) {
                        this.mJsonFields.put(field, translateFieldName(field.getName()));
                    }
                }
            }
        }
    }

    private String pickString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(SimpleComparison.LESS_THAN_OPERATION);
        int lastIndexOf = str.lastIndexOf(SimpleComparison.GREATER_THAN_OPERATION);
        int i = indexOf;
        if (indexOf < 0) {
            i = 0;
        }
        int i2 = lastIndexOf;
        if (lastIndexOf < 0) {
            i2 = str.length();
        }
        String str2 = str;
        if (i2 > i) {
            String substring = str.substring(i + 1, i2);
            str2 = substring;
            if (substring.contains(SimpleComparison.LESS_THAN_OPERATION)) {
                str2 = substring;
                if (substring.contains(SimpleComparison.GREATER_THAN_OPERATION)) {
                    str2 = pickString(substring);
                }
            }
        }
        return str2;
    }

    private String translateFieldName(String str) {
        String str2 = this.mFieldNamePrefix;
        String str3 = str;
        if (str2 != null) {
            str3 = str;
            if (str.startsWith(str2)) {
                String substring = str.substring(this.mFieldNamePrefix.length(), this.mFieldNamePrefix.length() + 1);
                str3 = substring.toLowerCase() + str.substring(this.mFieldNamePrefix.length() + 1);
            }
        }
        String str4 = str3;
        if (this.mFieldNameStyle == FieldNameStyle.UNDERLINE) {
            Matcher matcher = Pattern.compile("[A-Z]").matcher(str3);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, BridgeUtil.UNDERLINE_STR + matcher.group(0).toLowerCase());
            }
            matcher.appendTail(stringBuffer);
            str4 = stringBuffer.toString();
        }
        return str4;
    }

    public Object getFieldValueByJsonName(String str) throws IllegalAccessException {
        Map<Field, String> map = this.mJsonFields;
        if (map != null) {
            for (Map.Entry<Field, String> entry : map.entrySet()) {
                if (entry.getValue().equals(str)) {
                    return entry.getKey().get(this);
                }
            }
            return null;
        }
        return null;
    }

    public boolean onEachItemParse(String str, Object obj) {
        return false;
    }

    public boolean onEachItemToJson(JSONObject jSONObject, String str, Object obj) {
        return false;
    }

    @Override // com.tencent.map.tools.json.JsonParser
    public void parse(JSONObject jSONObject) {
        Class findClass;
        checkJsonComposerElements();
        JsonParser.Deserializer deserializer = this.mClassDeserializer.get(getClass());
        if (deserializer != null) {
            try {
                deserializer.deserialize(this, getClass().getName(), jSONObject);
                return;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (Map.Entry<Field, String> entry : this.mJsonFields.entrySet()) {
            Field key = entry.getKey();
            key.setAccessible(true);
            Class<?> type = key.getType();
            Object opt = jSONObject.opt(entry.getValue());
            JsonParser.Deserializer deserializer2 = this.mFieldDeserializer.get(key);
            if (deserializer2 != null) {
                try {
                    key.set(this, deserializer2.deserialize(this, entry.getValue(), opt));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (!onEachItemParse(entry.getValue(), opt)) {
                if (opt instanceof JSONArray) {
                    Type genericType = key.getGenericType();
                    if (genericType instanceof ParameterizedType) {
                        String pickString = pickString(genericType.toString());
                        try {
                            if (!TextUtils.isEmpty(pickString) && (findClass = Util.findClass(pickString, getClass().getClassLoader())) != null) {
                                Collection collection = null;
                                if (Set.class.isAssignableFrom(key.getType())) {
                                    collection = JsonUtils.parseTo(HashSet.class, (JSONArray) opt, findClass, new Object[0]);
                                } else if (List.class.isAssignableFrom(key.getType())) {
                                    collection = JsonUtils.parseTo(ArrayList.class, (JSONArray) opt, findClass, new Object[0]);
                                }
                                key.set(this, collection);
                            }
                        } catch (IllegalAccessException e3) {
                            e3.printStackTrace();
                        }
                    } else {
                        Class cls = (Class) genericType;
                        if (cls.isArray()) {
                            try {
                                key.set(this, JsonUtils.parseToArray((JSONArray) opt, cls.getComponentType()));
                            } catch (IllegalAccessException e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                } else if (opt instanceof JSONObject) {
                    try {
                        key.set(this, JsonUtils.parseToModel((JSONObject) opt, key.getType(), new Object[0]));
                    } catch (IllegalAccessException e5) {
                        e5.printStackTrace();
                    }
                } else if (type == String.class) {
                    try {
                        key.set(this, String.valueOf(opt));
                    } catch (IllegalAccessException e6) {
                        e6.printStackTrace();
                    }
                } else {
                    try {
                        if (type == Boolean.TYPE) {
                            if (opt instanceof Boolean) {
                                key.setBoolean(this, ((Boolean) opt).booleanValue());
                            } else if (opt instanceof String) {
                                if (opt.equals("false")) {
                                    key.setBoolean(this, false);
                                } else if (opt.equals("true")) {
                                    key.setBoolean(this, true);
                                }
                            }
                        } else if (type == Byte.TYPE) {
                            if (opt instanceof Byte) {
                                key.setByte(this, ((Byte) opt).byteValue());
                            } else if (opt instanceof Number) {
                                key.setByte(this, ((Number) opt).byteValue());
                            }
                        } else if (type == Character.TYPE) {
                            if (opt instanceof Character) {
                                key.setChar(this, ((Character) opt).charValue());
                            } else if (opt instanceof Integer) {
                                if (Character.isLetter(((Integer) opt).intValue())) {
                                    key.setChar(this, Character.toChars(((Integer) opt).intValue())[0]);
                                } else if (10 > ((Integer) opt).intValue() && ((Integer) opt).intValue() >= 0) {
                                    key.setChar(this, Character.forDigit(((Integer) opt).intValue(), 10));
                                }
                            }
                        } else if (type == Double.TYPE) {
                            if (opt instanceof Number) {
                                key.setDouble(this, ((Number) opt).doubleValue());
                            } else if (opt instanceof String) {
                                key.setDouble(this, Double.parseDouble((String) opt));
                            }
                        } else if (type == Float.TYPE) {
                            if (opt instanceof Number) {
                                key.setFloat(this, ((Number) opt).floatValue());
                            } else if (opt instanceof String) {
                                key.setFloat(this, Float.parseFloat((String) opt));
                            }
                        } else if (type == Integer.TYPE) {
                            if (opt instanceof Number) {
                                key.setInt(this, ((Number) opt).intValue());
                            } else if (opt instanceof String) {
                                key.setInt(this, Integer.parseInt((String) opt));
                            }
                        } else if (type == Long.TYPE) {
                            if (opt instanceof Number) {
                                key.setLong(this, ((Number) opt).longValue());
                            } else if (opt instanceof String) {
                                key.setLong(this, Long.parseLong((String) opt));
                            }
                        } else if (type == Short.TYPE) {
                            if (opt instanceof Number) {
                                key.setShort(this, ((Number) opt).shortValue());
                            } else if (opt instanceof String) {
                                key.setShort(this, Short.parseShort((String) opt));
                            }
                        } else if (opt != null) {
                            key.set(this, opt);
                        }
                    } catch (IllegalAccessException e7) {
                        e7.printStackTrace();
                    } catch (NumberFormatException e8) {
                        e8.printStackTrace();
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.tencent.map.tools.json.JsonEncoder
    public JSONObject toJson() {
        Object obj;
        Object obj2;
        checkJsonComposerElements();
        Set<Map.Entry<Field, String>> entrySet = this.mJsonFields.entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Field, String> entry : entrySet) {
            Field key = entry.getKey();
            key.setAccessible(true);
            Class<?> type = key.getType();
            try {
                obj = key.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                obj = null;
            }
            if (!onEachItemToJson(jSONObject, entry.getValue(), obj)) {
                if (Collection.class.isAssignableFrom(type)) {
                    try {
                        Collection collection = (Collection) key.get(this);
                        JSONArray jSONArray = new JSONArray();
                        if (collection != null && !collection.isEmpty()) {
                            for (Object obj3 : collection) {
                                if (obj3 instanceof JsonEncoder) {
                                    jSONArray.put(JsonUtils.modelToJson(obj3));
                                }
                            }
                        }
                        String value = entry.getValue();
                        if (!this.mAllowEmpty) {
                            obj2 = null;
                            if (collection != null) {
                                obj2 = null;
                                if (!collection.isEmpty()) {
                                }
                            }
                            jSONObject.put(value, obj2);
                        }
                        obj2 = jSONArray;
                        jSONObject.put(value, obj2);
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    try {
                        Object obj4 = key.get(this);
                        if (obj4 instanceof Double) {
                            jSONObject.put(entry.getValue(), ((Double) obj4).doubleValue());
                        } else if (obj4 instanceof Long) {
                            jSONObject.put(entry.getValue(), ((Long) obj4).longValue());
                        } else if (obj4 instanceof Integer) {
                            jSONObject.put(entry.getValue(), ((Integer) obj4).intValue());
                        } else if (obj4 instanceof Boolean) {
                            jSONObject.put(entry.getValue(), ((Boolean) obj4).booleanValue());
                        } else if (obj4 instanceof JsonEncoder) {
                            jSONObject.put(entry.getValue(), JsonUtils.modelToJson(obj4));
                        } else if (obj4 == null || !obj4.getClass().isArray()) {
                            String value2 = entry.getValue();
                            Object obj5 = obj4;
                            if (obj4 == null) {
                                obj5 = obj4;
                                if (this.mAllowEmpty) {
                                    obj5 = "";
                                }
                            }
                            jSONObject.put(value2, obj5);
                        } else if (Build.VERSION.SDK_INT >= 19) {
                            jSONObject.put(entry.getValue(), new JSONArray(obj4));
                        } else {
                            int length = Array.getLength(obj4);
                            JSONArray jSONArray2 = new JSONArray();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= length) {
                                    break;
                                }
                                jSONArray2.put(i2, Array.get(obj4, i2));
                                i = i2 + 1;
                            }
                            jSONObject.put(entry.getValue(), jSONArray2);
                        }
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }
}
