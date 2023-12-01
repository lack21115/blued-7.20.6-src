package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z.class */
public abstract class z {
    private static final char I = ',';
    private static final String Z = "__";
    private static final Class[] Code = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Character.class, Boolean.class};
    private static final Class[] V = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Boolean.class};
    private static final String B = z.class.getSimpleName();
    private static final Map<Class, h> C = new HashMap();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z$a.class */
    static class a implements h<Boolean, Object> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code */
        public Boolean V(Object obj) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof String) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
            return null;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z$b.class */
    static class b implements h<Byte, Number> {
        private b() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code */
        public Byte V(Number number) {
            return Byte.valueOf(number.byteValue());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z$c.class */
    static class c implements h<Double, Number> {
        private c() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code */
        public Double V(Number number) {
            return Double.valueOf(number.doubleValue());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z$d.class */
    static class d implements h<Float, Number> {
        private d() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code */
        public Float V(Number number) {
            return Float.valueOf(number.floatValue());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z$e.class */
    static class e implements h<Integer, Number> {
        private e() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code */
        public Integer V(Number number) {
            return Integer.valueOf(number.intValue());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z$f.class */
    static class f implements h<Long, Number> {
        private f() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code */
        public Long V(Number number) {
            return Long.valueOf(number.longValue());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z$g.class */
    static class g implements h<Short, Number> {
        private g() {
        }

        @Override // com.huawei.openalliance.ad.utils.z.h
        /* renamed from: Code */
        public Short V(Number number) {
            return Short.valueOf(number.shortValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/z$h.class */
    public interface h<D, S> {
        D V(S s);
    }

    static {
        e eVar = new e();
        C.put(Integer.TYPE, eVar);
        C.put(Integer.class, eVar);
        f fVar = new f();
        C.put(Long.TYPE, fVar);
        C.put(Long.class, fVar);
        d dVar = new d();
        C.put(Float.TYPE, dVar);
        C.put(Float.class, dVar);
        c cVar = new c();
        C.put(Double.TYPE, cVar);
        C.put(Double.class, cVar);
        g gVar = new g();
        C.put(Short.TYPE, gVar);
        C.put(Short.class, gVar);
        b bVar = new b();
        C.put(Byte.TYPE, bVar);
        C.put(Byte.class, bVar);
        a aVar = new a();
        C.put(Boolean.TYPE, aVar);
        C.put(Boolean.class, aVar);
    }

    private static Object Code(Class cls, Class cls2, Object obj) {
        if (V(cls)) {
            return Code(cls, obj);
        }
        if (List.class.isAssignableFrom(cls)) {
            return V(cls, cls2, obj);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return Code(cls, cls2, null, obj);
        }
        if (obj instanceof JSONObject) {
            return Code((JSONObject) obj, cls, new Class[]{cls2});
        }
        if (obj instanceof JSONArray) {
            return Code((JSONArray) obj, cls, new Class[]{cls2});
        }
        throw Code("value from json error, field class: %s", cls);
    }

    private static Object Code(Class cls, Object obj) {
        h hVar;
        if (String.class == cls) {
            return au.Code(obj);
        }
        if ((cls.isPrimitive() || Number.class.isAssignableFrom(cls)) && (obj instanceof Number)) {
            obj = (Number) obj;
            h hVar2 = C.get(cls);
            if (hVar2 == null) {
                ge.I(B, "cannot find value reader for: %s", cls);
                return null;
            }
            hVar = hVar2;
        } else if (cls != Boolean.class) {
            return obj;
        } else {
            h hVar3 = C.get(cls);
            if (hVar3 == null) {
                ge.I(B, "cannot find value reader for: %s", cls);
                return null;
            }
            hVar = hVar3;
        }
        return hVar.V(obj);
    }

    public static <T> T Code(String str, Class<T> cls, Class... clsArr) {
        if (TextUtils.isEmpty(str)) {
            throw Code(false, "Input json string cannot be empty!", new Object[0]);
        }
        Code((Class) cls);
        return (T) I(str, cls, clsArr);
    }

    private static <T> T Code(JSONArray jSONArray, Class<T> cls, Class[] clsArr) {
        if (List.class.isAssignableFrom(cls)) {
            Class cls2 = null;
            if (clsArr != null) {
                cls2 = null;
                if (clsArr.length > 0) {
                    cls2 = clsArr[0];
                }
            }
            return (T) V(cls, cls2, jSONArray);
        }
        throw Code("Obj class (%s) is not List type", cls);
    }

    private static <T> T Code(JSONObject jSONObject, Class<T> cls, Class[] clsArr) {
        Class cls2;
        if (Collection.class.isAssignableFrom(cls)) {
            throw Code("Obj class %s is Collection type which mismatches with JsonObject", cls);
        }
        if (cls.isArray()) {
            throw Code("Obj class %s is array type which mismatches with JsonObject", cls);
        }
        if (!Map.class.isAssignableFrom(cls)) {
            try {
                return (T) Code(jSONObject, cls.getConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception e2) {
                throw Code("New instance failed for %s", cls);
            }
        }
        Class cls3 = null;
        if (clsArr == null || clsArr.length <= 0) {
            cls3 = null;
            cls2 = null;
        } else {
            Class cls4 = clsArr[0];
            if (clsArr.length > 1) {
                cls3 = clsArr[1];
            }
            cls2 = cls4;
        }
        return (T) Code(cls, cls2, cls3, jSONObject);
    }

    private static <T> T Code(JSONObject jSONObject, T t) {
        Object opt;
        Field[] Code2 = an.Code(t.getClass());
        int length = Code2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return t;
            }
            Field Code3 = an.Code(Code2[i2], true);
            if (V(Code3) && (opt = jSONObject.opt(Code(Code3))) != null && JSONObject.NULL != opt) {
                Code(t, Code3, opt);
            }
            i = i2 + 1;
        }
    }

    public static <T> T Code(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            ge.Code(B, "%s is not exist or Json object is null", str);
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return (T) jSONObject.get(str);
            }
            return null;
        } catch (Throwable th) {
            ge.I(B, "getFromJsonObject JSONException");
            return null;
        }
    }

    public static String Code(Object obj) {
        try {
            return Code(obj, false);
        } catch (IllegalAccessException e2) {
            throw Code("toJson error", new Object[0]);
        }
    }

    private static String Code(Object obj, boolean z) {
        if (obj == null) {
            return "";
        }
        Code((Class) obj.getClass());
        return obj instanceof List ? Code((List) obj, z) : obj instanceof Map ? Code((Map) obj, z) : V(obj, z);
    }

    private static String Code(Field field) {
        com.huawei.openalliance.ad.annotations.c cVar = (com.huawei.openalliance.ad.annotations.c) field.getAnnotation(com.huawei.openalliance.ad.annotations.c.class);
        if (cVar == null || TextUtils.isEmpty(cVar.Code())) {
            String name = field.getName();
            String str = name;
            if (name.endsWith(Z)) {
                str = name.substring(0, name.length() - 2);
            }
            return str;
        }
        return cVar.Code();
    }

    private static String Code(List list, boolean z) {
        if (list.size() <= 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                Code(sb);
                sb.append(']');
                return sb.toString();
            }
            String I2 = I(list.get(i2), z);
            if (I2 != null) {
                sb.append(I2);
                sb.append(',');
            }
            i = i2 + 1;
        }
    }

    private static String Code(Map map, boolean z) {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Set<Map.Entry> entrySet = map.entrySet();
        int i = 0;
        int size = entrySet.size();
        for (Map.Entry entry : entrySet) {
            int i2 = i + 1;
            String str = (String) entry.getKey();
            String I2 = I(entry.getValue(), z);
            if (I2 != null) {
                sb.append('\"');
                sb.append(str);
                sb.append("\":");
                sb.append(I2);
            }
            i = i2;
            if (i2 < size) {
                i = i2;
                if (I2 != null) {
                    sb.append(',');
                    i = i2;
                }
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private static Map Code(Class cls, Class cls2, Class cls3, Object obj) {
        LinkedHashMap linkedHashMap;
        Class cls4 = cls2;
        if (cls2 == null) {
            cls4 = String.class;
        }
        Class cls5 = cls3;
        if (cls3 == null) {
            cls5 = String.class;
        }
        if (obj instanceof JSONObject) {
            if (Map.class == cls) {
                linkedHashMap = new LinkedHashMap();
            } else if (!Map.class.isAssignableFrom(cls)) {
                throw Code("%s is not Map type", cls);
            } else {
                try {
                    linkedHashMap = (Map) cls.newInstance();
                } catch (IllegalAccessException e2) {
                    throw Code("Fail to initiate %s", cls);
                } catch (InstantiationException e3) {
                    throw Code("Fail to initiate %s", cls);
                }
            }
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object Code2 = Code(cls4, cls5, jSONObject.get(next));
                if (Code2 != null) {
                    if (cls4.isAssignableFrom(Code2.getClass())) {
                        linkedHashMap.put(next, Code2);
                    } else {
                        String str = B;
                        ge.Z(str, "mapFromJson err, memberC:" + cls4 + ", valueC:" + Code2.getClass());
                    }
                }
            }
            return linkedHashMap;
        }
        throw Code("jsonVal not JSONObject", new Object[0]);
    }

    public static Map<String, String> Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(trim);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next).toString().trim());
            }
            return hashMap;
        } catch (JSONException e2) {
            return null;
        }
    }

    private static JSONException Code(String str, Object... objArr) {
        return Code(true, str, objArr);
    }

    private static JSONException Code(boolean z, String str, Object... objArr) {
        String format = String.format(Locale.ENGLISH, str, objArr);
        if (z) {
            ge.I(B, format);
        }
        return new JSONException(format);
    }

    private static void Code(Class cls) {
        if (cls.isPrimitive()) {
            throw Code("Root obj class (%s) cannot be primitive type!", cls);
        }
        int length = Code.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            if (cls == Code[i2]) {
                throw Code("Root obj class (%s) is invalid", cls);
            }
            i = i2 + 1;
        }
    }

    private static void Code(Object obj, Field field, Object obj2) {
        Object obj3 = null;
        try {
            Object Code2 = Code(field.getType(), an.Code(field), obj2);
            obj3 = Code2;
            field.set(obj, Code2);
        } catch (RuntimeException e2) {
            ge.I(B, obj.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + field);
        } catch (Exception e3) {
            ge.I(B, obj.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + field);
            V(obj, field, obj3);
        }
    }

    private static void Code(StringBuilder sb) {
        int length = sb.length();
        if (length > 0) {
            int i = length - 1;
            if (sb.charAt(i) == ',') {
                sb.delete(i, length);
            }
        }
    }

    private static <T> T I(String str, Class<T> cls, Class[] clsArr) {
        try {
            return (T) Code(new JSONObject(str), cls, clsArr);
        } catch (JSONException e2) {
            try {
                return (T) Code(new JSONArray(str), cls, clsArr);
            } catch (JSONException e3) {
                throw Code("Input string is not valid json string!", new Object[0]);
            }
        }
    }

    private static String I(Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof String) && !(obj instanceof Character)) {
            return I(obj) ? obj.toString() : obj instanceof List ? Code((List) obj, z) : obj instanceof Map ? Code((Map) obj, z) : obj.getClass().isArray() ? Z(obj, z) : Code(obj, z);
        }
        return "\"" + au.Z(obj.toString()) + "\"";
    }

    private static boolean I(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Double) || (obj instanceof Short);
    }

    public static <T> T V(String str, Class<T> cls, Class... clsArr) {
        String str2;
        StringBuilder sb;
        try {
            return (T) Code(str, cls, clsArr);
        } catch (JSONException e2) {
            e = e2;
            str2 = B;
            sb = new StringBuilder();
            sb.append("toObject ");
            sb.append(e.getClass().getSimpleName());
            ge.I(str2, sb.toString());
            return null;
        } catch (Exception e3) {
            e = e3;
            str2 = B;
            sb = new StringBuilder();
            sb.append("toObject ");
            sb.append(e.getClass().getSimpleName());
            ge.I(str2, sb.toString());
            return null;
        }
    }

    public static String V(Object obj) {
        try {
            return Code(obj);
        } catch (JSONException e2) {
            ge.I(B, "toJson jsex");
            return "";
        }
    }

    private static String V(Object obj, boolean z) {
        Field[] Code2 = an.Code(obj.getClass());
        if (Code2.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        int length = Code2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Code(sb);
                sb.append('}');
                return sb.toString();
            }
            Code2[i2] = an.Code(Code2[i2], true);
            if (V(Code2[i2])) {
                String Code3 = Code(Code2[i2]);
                Object obj2 = Code2[i2].get(obj);
                String I2 = (z && Code2[i2].isAnnotationPresent(com.huawei.openalliance.ad.annotations.a.class)) ? obj2 != null ? "\"******\"" : null : I(obj2, z);
                if (I2 != null) {
                    sb.append('\"');
                    sb.append(Code3);
                    sb.append("\":");
                    sb.append(I2);
                    if (i2 < length - 1) {
                        sb.append(',');
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private static List V(Class cls, Class cls2, Object obj) {
        ArrayList arrayList;
        Class cls3 = cls2;
        if (cls2 == null) {
            cls3 = String.class;
        }
        if (obj instanceof JSONArray) {
            if (cls == List.class) {
                arrayList = new ArrayList();
            } else if (!List.class.isAssignableFrom(cls)) {
                throw Code("%s is not List type", cls);
            } else {
                try {
                    arrayList = (List) cls.newInstance();
                } catch (IllegalAccessException e2) {
                    throw Code("Fail to initiate %s", cls);
                } catch (InstantiationException e3) {
                    throw Code("Fail to initiate %s", cls);
                }
            }
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Object Code2 = Code(cls3, (Class) null, jSONArray.get(i));
                if (Code2 != null) {
                    if (cls3.isAssignableFrom(Code2.getClass())) {
                        arrayList.add(Code2);
                    } else {
                        ge.Z(B, "listFromJson error, memberC:" + cls3 + ", valueC:" + Code2.getClass());
                    }
                }
            }
            return arrayList;
        }
        throw Code("jsonobj is not JSONArray", new Object[0]);
    }

    private static void V(Object obj, Field field, Object obj2) {
        Integer valueOf;
        if (obj2 == null || !(obj2 instanceof String)) {
            return;
        }
        try {
            Class<?> type = field.getType();
            if (type.isPrimitive()) {
                if (Integer.TYPE == type) {
                    valueOf = Integer.valueOf(Integer.parseInt((String) obj2));
                } else if (Float.TYPE == type) {
                    valueOf = Float.valueOf(Float.parseFloat((String) obj2));
                } else if (Long.TYPE == type) {
                    valueOf = Long.valueOf(Long.parseLong((String) obj2));
                } else if (Boolean.TYPE == type) {
                    valueOf = Boolean.valueOf(Boolean.parseBoolean((String) obj2));
                } else if (Double.TYPE == type) {
                    valueOf = Double.valueOf(Double.parseDouble((String) obj2));
                } else if (Short.TYPE == type) {
                    valueOf = Short.valueOf(Short.parseShort((String) obj2));
                } else if (Byte.TYPE == type) {
                    valueOf = Byte.valueOf(Byte.parseByte((String) obj2));
                } else if (Character.TYPE != type) {
                    return;
                } else {
                    valueOf = Character.valueOf(((String) obj2).charAt(0));
                }
                field.set(obj, valueOf);
            }
        } catch (Throwable th) {
            ge.Z(B, "processValueError");
        }
    }

    private static boolean V(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        int length = V.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (cls == V[i2]) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean V(Field field) {
        boolean z = false;
        if (field != null) {
            String name = field.getName();
            z = false;
            if (!Modifier.isStatic(field.getModifiers())) {
                z = false;
                if (name != null) {
                    z = false;
                    if (!name.contains("$")) {
                        z = false;
                        if (!field.isAnnotationPresent(com.huawei.openalliance.ad.annotations.d.class)) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    private static String Z(Object obj, boolean z) {
        int length = Array.getLength(obj);
        if (length <= 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Code(sb);
                sb.append(']');
                return sb.toString();
            }
            String I2 = I(Array.get(obj, i2), z);
            if (I2 != null) {
                sb.append(I2);
                sb.append(',');
            }
            i = i2 + 1;
        }
    }
}
