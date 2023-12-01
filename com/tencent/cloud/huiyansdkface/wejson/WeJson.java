package com.tencent.cloud.huiyansdkface.wejson;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wejson/WeJson.class */
public class WeJson {
    private static final String EMPTY_ARR = "[]";
    private static final String EMPTY_MAP = "{}";
    private static final String[] replacementArr = new String[128];
    private boolean cutLongStr = false;
    private int longStringLength = 262144;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wejson/WeJson$TypeToken.class */
    public static class TypeToken<T> {
        public Type type() {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            }
            throw new RuntimeException("weJson:get type failed");
        }
    }

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 31) {
                String[] strArr = replacementArr;
                strArr[34] = "\\\"";
                strArr[92] = "\\\\";
                strArr[9] = "\\t";
                strArr[8] = "\\b";
                strArr[10] = "\\n";
                strArr[13] = "\\r";
                strArr[12] = "\\f";
                return;
            }
            replacementArr[i2] = String.format("\\u%04x", Integer.valueOf(i2));
            i = i2 + 1;
        }
    }

    private <T> T fromArr(JSONArray jSONArray, Class cls) throws WeJsonException {
        T t = (T) Array.newInstance(cls, jSONArray.length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return t;
            }
            Array.set(t, i2, fromJsonData(getObject(jSONArray, i2), cls));
            i = i2 + 1;
        }
    }

    private <T> T fromArr(JSONArray jSONArray, GenericArrayType genericArrayType) throws WeJsonException {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        T t = (T) Array.newInstance(getClassOfType(genericComponentType), jSONArray.length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return t;
            }
            Array.set(t, i2, fromJsonData(getObject(jSONArray, i2), genericComponentType));
            i = i2 + 1;
        }
    }

    private Object fromJsonData(Object obj, Type type) throws WeJsonException {
        if (obj instanceof JSONArray) {
            return fromJsonArr((JSONArray) obj, type);
        }
        Object obj2 = obj;
        if (obj instanceof JSONObject) {
            obj2 = fromJsonObj((JSONObject) obj, type);
        }
        return obj2;
    }

    private List fromList(JSONArray jSONArray, Class<List> cls, Type type) throws WeJsonException {
        ArrayList newInstance;
        Object obj;
        if (cls.getName().equals("java.util.List")) {
            newInstance = new ArrayList();
        } else {
            try {
                newInstance = cls.newInstance();
            } catch (Exception e) {
                throw new WeJsonException("创建List类型失败,该列表不支持无参实例化", e);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return newInstance;
            }
            Object object = getObject(jSONArray, i2);
            if (type == null && !(object instanceof JSONObject) && !(object instanceof JSONArray)) {
                obj = object;
            } else if (object instanceof JSONArray) {
                obj = fromJsonArr((JSONArray) object, type);
            } else {
                obj = object;
                if (object instanceof JSONObject) {
                    obj = fromJsonObj((JSONObject) object, type);
                }
            }
            newInstance.add(obj);
            i = i2 + 1;
        }
    }

    private Map fromMap(JSONObject jSONObject, Class<Map> cls, Type type) throws WeJsonException {
        HashMap newInstance;
        Object obj;
        if (cls.getName().equals("java.util.Map")) {
            newInstance = new HashMap();
        } else {
            try {
                newInstance = cls.newInstance();
            } catch (Exception e) {
                throw new WeJsonException("创建Map类型失败,该Map不支持无参实例化", e);
            }
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object object = getObject(jSONObject, next);
            if (object == null) {
                obj = null;
            } else if (type != null || (object instanceof JSONObject) || (object instanceof JSONArray)) {
                obj = fromJsonData(object, ((object instanceof JSONObject) && type == null) ? Map.class : ((object instanceof JSONArray) && type == null) ? List.class : type);
            } else {
                obj = object;
            }
            newInstance.put(next, obj);
        }
        return newInstance;
    }

    private Object fromPojo(JSONObject jSONObject, Type type) throws WeJsonException {
        Double valueOf;
        ArrayList arrayList = new ArrayList();
        Class classOfType = getClassOfType(type);
        Class cls = classOfType;
        while (true) {
            Class cls2 = cls;
            if (cls2 == null || cls2.equals(Object.class)) {
                break;
            }
            Field[] declaredFields = cls2.getDeclaredFields();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < declaredFields.length) {
                    arrayList.add(declaredFields[i2]);
                    i = i2 + 1;
                }
            }
            cls = cls2.getSuperclass();
        }
        if (arrayList.size() == 0) {
            return null;
        }
        try {
            Object newInstance = classOfType.newInstance();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= arrayList.size()) {
                    return newInstance;
                }
                Field field = (Field) arrayList.get(i4);
                String name = field.getName();
                if (!name.contains("$")) {
                    int modifiers = field.getModifiers();
                    Object opt = jSONObject.opt(name);
                    if (opt == null) {
                        continue;
                    } else {
                        Object fromJsonData = fromJsonData(opt, getMemberType(type, field, opt));
                        Object obj = fromJsonData;
                        if (JSONObject.NULL.equals(fromJsonData)) {
                            obj = null;
                        }
                        Class<?> type2 = field.getType();
                        boolean z = type2.equals(Double.class) || type2.equals(Double.TYPE);
                        boolean z2 = type2.equals(Float.class) || type2.equals(Float.TYPE);
                        boolean z3 = type2.equals(Long.class) || type2.equals(Long.TYPE);
                        if ((modifiers & 1) != 0) {
                            try {
                                if (obj instanceof Number) {
                                    if (z) {
                                        valueOf = Double.valueOf(((Number) obj).doubleValue());
                                    } else if (z2) {
                                        valueOf = Float.valueOf(((Number) obj).floatValue());
                                    } else if (z3) {
                                        valueOf = Long.valueOf(((Number) obj).longValue());
                                    }
                                    field.set(newInstance, valueOf);
                                }
                                field.set(newInstance, obj);
                            } catch (IllegalAccessException e) {
                                throw new WeJsonException("设置成员变量值失败.", e);
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("set");
                            sb.append(name.substring(0, 1).toUpperCase());
                            sb.append(name.length() == 1 ? "" : name.substring(1));
                            try {
                                Method method = classOfType.getMethod(sb.toString(), type2);
                                try {
                                    if (!(obj instanceof Number)) {
                                        method.invoke(newInstance, obj);
                                    } else if (z) {
                                        method.invoke(newInstance, Double.valueOf(((Number) obj).doubleValue()));
                                    } else if (z2) {
                                        method.invoke(newInstance, Float.valueOf(((Number) obj).floatValue()));
                                    } else if (z3) {
                                        method.invoke(newInstance, Long.valueOf(((Number) obj).longValue()));
                                    } else {
                                        method.invoke(newInstance, obj);
                                    }
                                } catch (IllegalAccessException e2) {
                                    throw new WeJsonException("调用set方法失败.", e2);
                                } catch (InvocationTargetException e3) {
                                    throw new WeJsonException("调用set方法失败.", e3);
                                }
                            } catch (NoSuchMethodException e4) {
                            }
                        }
                    }
                }
                i3 = i4 + 1;
            }
        } catch (Exception e5) {
            throw new WeJsonException("必须为该类型提供一个无参构造方法:" + classOfType.getName(), e5);
        }
    }

    private Class getClassOfType(Type type) {
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        boolean z = type instanceof TypeVariable;
        return null;
    }

    private Type getComponentTypeOfList(Type type, JSONArray jSONArray) throws WeJsonException {
        Class cls;
        while (true) {
            if (type instanceof Class) {
                cls = (Class) type;
                Type typeOfList = getTypeOfList(type, "java.util.List", jSONArray);
                if (typeOfList != null) {
                    return typeOfList;
                }
            } else if (!(type instanceof ParameterizedType)) {
                throw new WeJsonException("unsupported type:" + type);
            } else {
                cls = (Class) ((ParameterizedType) type).getRawType();
                Type typeOfList2 = getTypeOfList(type, "java.util.List", jSONArray);
                if (typeOfList2 != null) {
                    return typeOfList2;
                }
            }
            type = cls.getGenericSuperclass();
        }
    }

    private <T> Type getMemberType(Type type, Field field, Object obj) throws WeJsonException {
        Type genericType = field.getGenericType();
        if (genericType instanceof TypeVariable) {
            Class classOfType = getClassOfType(type);
            if (type instanceof ParameterizedType) {
                return ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Type genericSuperclass = classOfType.getGenericSuperclass();
            return genericSuperclass instanceof ParameterizedType ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : getValueType(obj);
        }
        if (!(genericType instanceof ParameterizedType) && !(genericType instanceof Class) && !(genericType instanceof GenericArrayType)) {
            throw new WeJsonException("unsupported member type:" + genericType);
        }
        return genericType;
    }

    private Object getObject(JSONArray jSONArray, int i) throws WeJsonException {
        try {
            return jSONArray.get(i);
        } catch (JSONException e) {
            throw new WeJsonException("JSONArray.get() cause JSONException", e);
        }
    }

    private Object getObject(JSONObject jSONObject, String str) throws WeJsonException {
        try {
            return jSONObject.get(str);
        } catch (JSONException e) {
            throw new WeJsonException("JSONObject.get() cause JSONException", e);
        }
    }

    private <T> Type getSubType(Type type, Field field, Object obj) throws WeJsonException {
        Type genericType = field.getGenericType();
        Class classOfType = getClassOfType(type);
        if (genericType instanceof TypeVariable) {
            Type genericSuperclass = classOfType.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                throw new WeJsonException("缺少泛型信息:" + classOfType);
            }
            Type type2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            if (!(type2 instanceof Class)) {
                if (type2 instanceof ParameterizedType) {
                    Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                    if (type3 instanceof Class) {
                        return (Class) type3;
                    }
                    throw new WeJsonException("不支持这种嵌套模式");
                }
                throw new WeJsonException("不支持嵌套泛型");
            }
            Type genericSuperclass2 = ((Class) type2).getGenericSuperclass();
            if (genericSuperclass2 instanceof ParameterizedType) {
                Type type4 = ((ParameterizedType) genericSuperclass2).getActualTypeArguments()[0];
                if (type4 instanceof Class) {
                    return (Class) type4;
                }
                throw new WeJsonException("不支持这种嵌套模式");
            }
            return null;
        } else if (List.class.isAssignableFrom(field.getType())) {
            if (!(genericType instanceof ParameterizedType)) {
                throw new WeJsonException("缺少泛型类型声明:" + field.getName());
            }
            Type type5 = ((ParameterizedType) genericType).getActualTypeArguments()[0];
            if (type5 instanceof Class) {
                return (Class) type5;
            }
            throw new WeJsonException("不支持嵌套泛型:" + field.getName());
        } else if (Map.class.isAssignableFrom(field.getType())) {
            if (!(genericType instanceof ParameterizedType)) {
                throw new WeJsonException("缺少泛型类型声明:" + field.getName());
            }
            Type type6 = ((ParameterizedType) genericType).getActualTypeArguments()[1];
            if (type6 instanceof Class) {
                return (Class) type6;
            }
            throw new WeJsonException("不支持嵌套泛型:" + field.getName());
        } else if (genericType instanceof ParameterizedType) {
            Type type7 = ((ParameterizedType) genericType).getActualTypeArguments()[0];
            if (type7 instanceof Class) {
                return (Class) type7;
            }
            throw new WeJsonException("不支持嵌套泛型:" + field.getName());
        } else if (genericType instanceof WildcardType) {
            throw new WeJsonException("不支持WildcardType类型的泛型:" + field.getName());
        } else if (genericType instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) genericType).getGenericComponentType();
            return genericComponentType instanceof ParameterizedType ? (Class) ((ParameterizedType) genericComponentType).getRawType() : (Class) genericComponentType;
        } else {
            return null;
        }
    }

    private Type getTypeOfList(Type type, String str, JSONArray jSONArray) throws WeJsonException {
        Class cls;
        boolean z = type instanceof Class;
        if (z) {
            cls = (Class) type;
        } else if (!(type instanceof ParameterizedType)) {
            throw new WeJsonException("unsupported type of list:" + type);
        } else {
            cls = (Class) ((ParameterizedType) type).getRawType();
        }
        if (cls.equals(List.class) || cls.equals(ArrayList.class) || cls.equals(LinkedList.class)) {
            if (z) {
                return getValueType(jSONArray.opt(0));
            }
            Type type2 = null;
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            return type2;
        }
        return null;
    }

    private Type getValueType(Object obj) {
        return obj == null ? String.class : obj instanceof JSONObject ? Map.class : obj instanceof JSONArray ? List.class : obj instanceof String ? String.class : obj instanceof Integer ? Integer.class : obj instanceof Long ? Long.class : obj instanceof Boolean ? Boolean.class : obj instanceof Double ? Double.class : String.class;
    }

    private <T> boolean isPrimitivePackageType(T t) {
        return (t instanceof Integer) || (t instanceof Short) || (t instanceof Long) || (t instanceof Byte) || (t instanceof Boolean) || (t instanceof Float) || (t instanceof Double) || (t instanceof Character);
    }

    private <T> void process(StringBuilder sb, T t) {
        if (!t.getClass().isPrimitive()) {
            if (t instanceof String) {
                String str = (String) t;
                String str2 = str;
                if (this.cutLongStr) {
                    str2 = str;
                    if (str.length() > this.longStringLength) {
                        str2 = str.substring(0, 256) + "....." + (str.length() - 512) + "........." + str.substring(str.length() - 256);
                    }
                }
                string(sb, str2);
                return;
            } else if (!isPrimitivePackageType(t)) {
                if (t.getClass().isArray()) {
                    processArr(sb, (Object[]) t);
                    return;
                } else if (t instanceof Iterable) {
                    processIterable(sb, (Iterable) t);
                    return;
                } else if (t instanceof Map) {
                    processMap(sb, (Map) t);
                    return;
                } else {
                    processObj(sb, t);
                    return;
                }
            }
        }
        sb.append(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void processArr(StringBuilder sb, Object[] objArr) {
        if (objArr.length == 0) {
            sb.append(EMPTY_ARR);
            return;
        }
        sb.append('[');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                break;
            }
            if (objArr[i2] != null) {
                process(sb, objArr[i2]);
                if (i2 < objArr.length - 1) {
                    sb.append(',');
                }
            }
            i = i2 + 1;
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']');
    }

    private void processIterable(StringBuilder sb, Iterable iterable) {
        sb.append('[');
        for (Object obj : iterable) {
            if (obj != null) {
                process(sb, obj);
                sb.append(',');
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']');
    }

    private void processMap(StringBuilder sb, Map<String, Object> map) {
        if (map.size() == 0) {
            sb.append(EMPTY_MAP);
            return;
        }
        sb.append('{');
        int i = 0;
        int size = map.size();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (key != null && !key.equals("") && value != null && (!(value instanceof String) || !entry.equals(""))) {
                sb.append('\"');
                sb.append(key);
                sb.append('\"');
                sb.append(':');
                process(sb, value);
                if (i < size - 1) {
                    sb.append(',');
                }
                i++;
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append('}');
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void processObj(StringBuilder sb, T t) {
        StringBuilder sb2;
        String message;
        Object invoke;
        ArrayList arrayList = new ArrayList();
        Class<?> cls = t.getClass();
        Class<?> cls2 = cls;
        while (true) {
            Class<?> cls3 = cls2;
            if (cls3 == null || cls3.equals(Object.class)) {
                break;
            }
            for (Field field : cls3.getDeclaredFields()) {
                arrayList.add(field);
            }
            cls2 = cls3.getSuperclass();
        }
        if (arrayList.size() == 0) {
            sb.append(EMPTY_MAP);
            return;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            Field field2 = (Field) arrayList.get(i2);
            int modifiers = field2.getModifiers();
            if ((modifiers & 8) == 0) {
                String name = field2.getName();
                if (!name.contains("$")) {
                    if ((modifiers & 1) != 0) {
                        Object obj = null;
                        try {
                            obj = field2.get(t);
                        } catch (IllegalAccessException e) {
                            Log.w("WeJson", "read public field value failed:" + e.getMessage());
                        }
                        if (obj != null) {
                            hashMap.put(name, obj);
                        }
                    } else {
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(MonitorConstants.CONNECT_TYPE_GET);
                            sb3.append(name.substring(0, 1).toUpperCase());
                            sb3.append(name.length() == 1 ? "" : name.substring(1));
                            Method method = cls.getMethod(sb3.toString(), new Class[0]);
                            if (method != null && (invoke = method.invoke(t, new Object[0])) != null) {
                                hashMap.put(name, invoke);
                            }
                        } catch (IllegalAccessException e2) {
                            sb2 = new StringBuilder();
                            sb2.append("read field value by getter method failed:");
                            message = e2.getMessage();
                            sb2.append(message);
                            Log.w("WeJson", sb2.toString());
                        } catch (NoSuchMethodException e3) {
                        } catch (InvocationTargetException e4) {
                            sb2 = new StringBuilder();
                            sb2.append("read field value by getter method failed:");
                            message = e4.getMessage();
                            sb2.append(message);
                            Log.w("WeJson", sb2.toString());
                        }
                    }
                }
            }
            i = i2 + 1;
        }
        sb.append('{');
        int size = hashMap.size();
        int i3 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            int i4 = i3 + 1;
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                i3 = i4;
            } else {
                sb.append('\"');
                sb.append(str);
                sb.append('\"');
                sb.append(':');
                process(sb, value);
                i3 = i4;
                if (i4 < size) {
                    sb.append(',');
                    i3 = i4;
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append('}');
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void string(java.lang.StringBuilder r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String[] r0 = com.tencent.cloud.huiyansdkface.wejson.WeJson.replacementArr
            r15 = r0
            r0 = r6
            java.lang.String r1 = "\""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            int r0 = r0.length()
            r11 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r9 = r0
        L18:
            r0 = r8
            r1 = r11
            if (r0 >= r1) goto L8b
            r0 = r7
            r1 = r8
            char r0 = r0.charAt(r1)
            r12 = r0
            r0 = r12
            r1 = 128(0x80, float:1.794E-43)
            if (r0 >= r1) goto L44
            r0 = r15
            r1 = r12
            r0 = r0[r1]
            r14 = r0
            r0 = r14
            r13 = r0
            r0 = r14
            if (r0 != 0) goto L65
            r0 = r9
            r10 = r0
            goto L80
        L44:
            r0 = r12
            r1 = 8232(0x2028, float:1.1535E-41)
            if (r0 != r1) goto L54
            java.lang.String r0 = "\\u2028"
            r13 = r0
            goto L65
        L54:
            r0 = r9
            r10 = r0
            r0 = r12
            r1 = 8233(0x2029, float:1.1537E-41)
            if (r0 != r1) goto L80
            java.lang.String r0 = "\\u2029"
            r13 = r0
        L65:
            r0 = r9
            r1 = r8
            if (r0 >= r1) goto L74
            r0 = r6
            r1 = r7
            r2 = r9
            r3 = r8
            java.lang.StringBuilder r0 = r0.append(r1, r2, r3)
        L74:
            r0 = r6
            r1 = r13
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
        L80:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r10
            r9 = r0
            goto L18
        L8b:
            r0 = r9
            r1 = r11
            if (r0 >= r1) goto L9c
            r0 = r6
            r1 = r7
            r2 = r9
            r3 = r11
            java.lang.StringBuilder r0 = r0.append(r1, r2, r3)
        L9c:
            r0 = r6
            java.lang.String r1 = "\""
            java.lang.StringBuilder r0 = r0.append(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.wejson.WeJson.string(java.lang.StringBuilder, java.lang.String):void");
    }

    public <T> T fromJson(String str, Class<T> cls) throws WeJsonException {
        return (T) fromJson(str, (Type) cls);
    }

    public <T> T fromJson(String str, Type type) throws WeJsonException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (type != null) {
            String trim = str.trim();
            if (trim.startsWith("[")) {
                try {
                    T t = (T) fromJsonArr(new JSONArray(trim), type);
                    if (t != null) {
                        return t;
                    }
                } catch (Exception e) {
                    throw new WeJsonException("json resolve err:" + e.getMessage(), e);
                }
            } else if (trim.startsWith("{")) {
                try {
                    return (T) fromJsonObj(new JSONObject(trim), type);
                } catch (Exception e2) {
                    throw new WeJsonException("json resolve err:" + e2.getMessage(), e2);
                }
            }
            throw new WeJsonException("illegal json format");
        }
        throw new WeJsonException("必须指定typeOfT");
    }

    public <T> T fromJsonArr(JSONArray jSONArray, Type type) throws WeJsonException {
        Type type2 = type;
        if (type == null) {
            type2 = List.class;
        }
        if (type2 instanceof ParameterizedType) {
            Class<List> cls = (Class) ((ParameterizedType) type2).getRawType();
            if (List.class.isAssignableFrom(cls)) {
                return (T) fromList(jSONArray, cls, getComponentTypeOfList(type2, jSONArray));
            }
            throw new WeJsonException("unsupported type:" + cls);
        } else if (type2 instanceof GenericArrayType) {
            return (T) fromArr(jSONArray, (GenericArrayType) type2);
        } else {
            if (type2 instanceof Class) {
                Class<List> cls2 = (Class) type2;
                if (cls2.isArray()) {
                    return (T) fromArr(jSONArray, cls2.getComponentType());
                }
                if (List.class.isAssignableFrom(cls2)) {
                    return (T) fromList(jSONArray, cls2, getComponentTypeOfList(cls2, jSONArray));
                }
            }
            throw new WeJsonException("unsupported type:" + type2);
        }
    }

    public Object fromJsonObj(JSONObject jSONObject, Type type) throws WeJsonException {
        Type type2 = type;
        if (type == null) {
            type2 = Map.class;
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            Class<Map> cls = (Class) parameterizedType.getRawType();
            return (Map.class.isAssignableFrom(cls) || HashMap.class.isAssignableFrom(cls)) ? fromMap(jSONObject, cls, parameterizedType.getActualTypeArguments()[1]) : fromPojo(jSONObject, type2);
        } else if (type2 instanceof Class) {
            return (type2.equals(Map.class) || type2.equals(HashMap.class)) ? fromMap(jSONObject, (Class) type2, null) : fromPojo(jSONObject, type2);
        } else {
            throw new WeJsonException("unsupported type:" + type2);
        }
    }

    public void setCutLongStr(boolean z) {
        this.cutLongStr = z;
    }

    public void setLongStringLength(int i) {
        int i2 = i;
        if (i < 600) {
            i2 = 600;
        }
        this.longStringLength = i2;
    }

    public <T> String toJson(T t) {
        return toJson(t, 0);
    }

    public <T> String toJson(T t, int i) {
        if (t == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        process(sb, t);
        return sb.toString();
    }
}
