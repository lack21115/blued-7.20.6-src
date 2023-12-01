package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/Internal__InternalKt.class */
public final /* synthetic */ class Internal__InternalKt {
    private static final String ESCAPED_CHARS = ",[]{}\\";

    /* renamed from: -redactElements  reason: not valid java name */
    public static final <T> List<T> m6714redactElements(List<? extends T> list, ProtoAdapter<T> protoAdapter) {
        Intrinsics.e(list, "<this>");
        Intrinsics.e(protoAdapter, "adapter");
        List<? extends T> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.a(list2, 10));
        for (T t : list2) {
            arrayList.add(protoAdapter.redact(t));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: -redactElements  reason: not valid java name */
    public static final <K, V> Map<K, V> m6715redactElements(Map<K, ? extends V> map, ProtoAdapter<V> protoAdapter) {
        Intrinsics.e(map, "<this>");
        Intrinsics.e(protoAdapter, "adapter");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.b(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), protoAdapter.redact(entry.getValue()));
        }
        return linkedHashMap;
    }

    public static final String boxedOneOfClassName(String str) {
        Intrinsics.e(str, "oneOfName");
        return StringsKt.d(str);
    }

    public static final String boxedOneOfKeyFieldName(String str, String str2) {
        Intrinsics.e(str, "oneOfName");
        Intrinsics.e(str2, "fieldName");
        String upperCase = (str + '_' + str2).toUpperCase();
        Intrinsics.c(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public static final String boxedOneOfKeysFieldName(String str) {
        Intrinsics.e(str, "oneOfName");
        String upperCase = Intrinsics.a(str, "_keys").toUpperCase();
        Intrinsics.c(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public static final void checkElementsNotNull(List<?> list) {
        Intrinsics.e(list, "list");
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            if (list.get(i2) == null) {
                throw new NullPointerException("Element at index " + i2 + " is null");
            }
            i = i2 + 1;
        }
    }

    public static final void checkElementsNotNull(Map<?, ?> map) {
        Intrinsics.e(map, "map");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (value == null) {
                throw new NullPointerException("Value for key " + key + " is null");
            }
        }
    }

    @Deprecated
    public static final <T> List<T> copyOf(String str, List<? extends T> list) {
        Intrinsics.e(str, "name");
        Intrinsics.a(list);
        return Internal.copyOf(list);
    }

    public static final <T> List<T> copyOf(List<? extends T> list) {
        Intrinsics.e(list, "list");
        return (list == CollectionsKt.b() || (list instanceof ImmutableList)) ? (List) new MutableOnWriteList(list) : new ArrayList(list);
    }

    @Deprecated
    public static final <K, V> Map<K, V> copyOf(String str, Map<K, ? extends V> map) {
        Intrinsics.e(str, "name");
        Intrinsics.a(map);
        return Internal.copyOf(map);
    }

    public static final <K, V> Map<K, V> copyOf(Map<K, ? extends V> map) {
        Intrinsics.e(map, "map");
        return new LinkedHashMap(map);
    }

    public static final int countNonNull(Object obj, Object obj2) {
        int i = 1;
        int i2 = obj != null ? 1 : 0;
        if (obj2 == null) {
            i = 0;
        }
        return i2 + i;
    }

    public static final int countNonNull(Object obj, Object obj2, Object obj3) {
        int i = 1;
        int i2 = obj != null ? 1 : 0;
        int i3 = obj2 != null ? 1 : 0;
        if (obj3 == null) {
            i = 0;
        }
        return i2 + i3 + i;
    }

    public static final int countNonNull(Object obj, Object obj2, Object obj3, Object obj4, Object... objArr) {
        Intrinsics.e(objArr, "rest");
        int i = obj != null ? 1 : 0;
        int i2 = i;
        if (obj2 != null) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (obj3 != null) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (obj4 != null) {
            i4 = i3 + 1;
        }
        int length = objArr.length;
        int i5 = i4;
        int i6 = 0;
        while (i6 < length) {
            Object obj5 = objArr[i6];
            int i7 = i6 + 1;
            i6 = i7;
            if (obj5 != null) {
                i5++;
                i6 = i7;
            }
        }
        return i5;
    }

    public static final boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && Intrinsics.a(obj, obj2);
        }
        return true;
    }

    private static final KClass<? extends Object> getTypeName$Internal__InternalKt(Object obj) {
        return Reflection.b(obj.getClass());
    }

    public static final <T> List<T> immutableCopyOf(String str, List<? extends T> list) {
        Intrinsics.e(str, "name");
        Intrinsics.e(list, "list");
        List<T> list2 = list;
        if (list instanceof MutableOnWriteList) {
            list2 = ((MutableOnWriteList) list).getMutableList$wire_runtime();
        }
        if (list2 != CollectionsKt.b() && !(list2 instanceof ImmutableList)) {
            ImmutableList immutableList = new ImmutableList(list2);
            if (!immutableList.contains(null)) {
                return (List) immutableList;
            }
            throw new IllegalArgumentException(Intrinsics.a(str, ".contains(null)").toString());
        }
        return (List<T>) list2;
    }

    public static final <K, V> Map<K, V> immutableCopyOf(String str, Map<K, ? extends V> map) {
        Intrinsics.e(str, "name");
        Intrinsics.e(map, "map");
        if (map.isEmpty()) {
            return MapsKt.a();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (!linkedHashMap.keySet().contains(null)) {
            if (!linkedHashMap.values().contains(null)) {
                Map<K, V> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
                Intrinsics.c(unmodifiableMap, "unmodifiableMap(this)");
                return unmodifiableMap;
            }
            throw new IllegalArgumentException(Intrinsics.a(str, ".containsValue(null)").toString());
        }
        throw new IllegalArgumentException(Intrinsics.a(str, ".containsKey(null)").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> immutableCopyOfMapWithStructValues(String str, Map<K, ? extends V> map) {
        Intrinsics.e(str, "name");
        Intrinsics.e(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (!(key != null)) {
                throw new IllegalArgumentException(Intrinsics.a(str, ".containsKey(null)").toString());
            }
            linkedHashMap.put(key, Internal.immutableCopyOfStruct(str, value));
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.c(unmodifiableMap, "unmodifiableMap(this)");
        return unmodifiableMap;
    }

    public static final <T> T immutableCopyOfStruct(String str, T t) {
        Intrinsics.e(str, "name");
        if (t != null && !(t instanceof Boolean) && !(t instanceof Double) && !(t instanceof String)) {
            if (t instanceof List) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : (List) t) {
                    arrayList.add(Internal.immutableCopyOfStruct(str, obj));
                }
                List unmodifiableList = Collections.unmodifiableList(arrayList);
                Intrinsics.c(unmodifiableList, "unmodifiableList(this)");
                return (T) unmodifiableList;
            } else if (!(t instanceof Map)) {
                throw new IllegalArgumentException("struct value " + str + " must be a JSON type (null, Boolean, Double, String, List, or Map) but was " + getTypeName$Internal__InternalKt(t) + ": " + t);
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : ((Map) t).entrySet()) {
                    linkedHashMap.put(Internal.immutableCopyOfStruct(str, entry.getKey()), Internal.immutableCopyOfStruct(str, entry.getValue()));
                }
                Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
                Intrinsics.c(unmodifiableMap, "unmodifiableMap(this)");
                return (T) unmodifiableMap;
            }
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0044, code lost:
        if (r0 > r0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.IllegalStateException missingRequiredFields(java.lang.Object... r5) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.internal.Internal__InternalKt.missingRequiredFields(java.lang.Object[]):java.lang.IllegalStateException");
    }

    public static final <T> List<T> newMutableList() {
        return (List) new MutableOnWriteList(CollectionsKt.b());
    }

    public static final <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    public static final String sanitize(String str) {
        Intrinsics.e(str, "value");
        StringBuilder sb = new StringBuilder(str.length());
        String str2 = str;
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            i++;
            if (StringsKt.a(ESCAPED_CHARS, charAt, false, 2, (Object) null)) {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final String sanitize(List<String> list) {
        Intrinsics.e(list, "values");
        return CollectionsKt.a(list, (CharSequence) null, "[", "]", 0, (CharSequence) null, Internal__InternalKt$sanitize$2.INSTANCE, 25, (Object) null);
    }
}
