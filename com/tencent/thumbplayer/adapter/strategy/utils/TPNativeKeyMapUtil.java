package com.tencent.thumbplayer.adapter.strategy.utils;

import android.util.SparseArray;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.thumbplayer.adapter.a.b.c;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.tplayer.TPOptionalIDInternal;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMapUtil.class */
public class TPNativeKeyMapUtil {
    private static final String REVERSE_MAP_NAME_SUFFIX = ".reverseMap";
    private static final String TAG = "TPNativeKeyMapUtil";
    private static final Map<String, Map<Number, Number>> sNameToMap = new ConcurrentHashMap();
    private static final Map<Class<?>, AtomicBoolean> sHasThisAnnotationInitMap = new ConcurrentHashMap();
    private static final SparseArray<c.a> sToNativeOptionalIdMap = new SparseArray<>();
    private static final SparseArray<String> sOptionalIdKeyToNameMap = new SparseArray<>();
    private static final AtomicBoolean sHasOptionalIdMapInit = new AtomicBoolean(false);

    private static <T extends Annotation> void buildBiDirectionMapForAnnotation(Class<T> cls) {
        AtomicBoolean atomicBoolean;
        TPLogUtil.i(TAG, "buildBiDirectionMapForAnnotation, clazz=".concat(String.valueOf(cls)));
        synchronized (sHasThisAnnotationInitMap) {
            AtomicBoolean atomicBoolean2 = sHasThisAnnotationInitMap.get(cls);
            atomicBoolean = atomicBoolean2;
            if (atomicBoolean2 == null) {
                atomicBoolean = new AtomicBoolean(false);
                sHasThisAnnotationInitMap.put(cls, atomicBoolean);
            }
        }
        synchronized (atomicBoolean) {
            try {
                if (!atomicBoolean.get()) {
                    searchClassToFillMap(cls);
                    atomicBoolean.set(true);
                    return;
                }
                TPLogUtil.i(TAG, "className=" + cls.getSimpleName() + " already init");
            } catch (Throwable th) {
                AtomicBoolean atomicBoolean3 = atomicBoolean;
                throw th;
            }
        }
    }

    private static void buildNativeInitConfigMap() {
        TPNativeKeyMap.MapInitConfig mapInitConfig;
        try {
            Class<?> cls = Class.forName(TPOptionalID.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Field field = declaredFields[i2];
                if (field.getType().toString().equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL) && (mapInitConfig = (TPNativeKeyMap.MapInitConfig) field.getAnnotation(TPNativeKeyMap.MapInitConfig.class)) != null) {
                    int i3 = field.getInt(cls);
                    sOptionalIdKeyToNameMap.put(i3, mapInitConfig.keyName());
                    if (mapInitConfig.value() == -1) {
                        sToNativeOptionalIdMap.put(i3, new c.a());
                    } else {
                        field.setAccessible(true);
                        sToNativeOptionalIdMap.put(i3, new c.a(mapInitConfig.type(), mapInitConfig.value()));
                    }
                }
                i = i2 + 1;
            }
        } catch (ClassNotFoundException e) {
            TPLogUtil.e(TAG, e);
        } catch (IllegalAccessException e2) {
            TPLogUtil.e(TAG, e2);
        }
    }

    private static void buildNativeOptionalIdToMapInternal(Class<?> cls) {
        TPNativeKeyMap.MapOptionalId mapOptionalId;
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Field field = declaredFields[i2];
                if (field.getType().toString().equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL) && (mapOptionalId = (TPNativeKeyMap.MapOptionalId) field.getAnnotation(TPNativeKeyMap.MapOptionalId.class)) != null) {
                    int i3 = field.getInt(cls);
                    sOptionalIdKeyToNameMap.put(i3, mapOptionalId.keyName());
                    if (mapOptionalId.value() == -1) {
                        sToNativeOptionalIdMap.put(i3, new c.a());
                    } else {
                        field.setAccessible(true);
                        sToNativeOptionalIdMap.put(i3, new c.a(mapOptionalId.type(), mapOptionalId.value()));
                    }
                }
                i = i2 + 1;
            }
        } catch (IllegalAccessException e) {
            TPLogUtil.e(TAG, e);
        }
    }

    private static void buildOptionalIdMap() {
        synchronized (sHasOptionalIdMapInit) {
            if (sToNativeOptionalIdMap.size() != 0) {
                return;
            }
            if (sHasOptionalIdMapInit.get()) {
                throw new IllegalStateException("构建Map错误，请查看【--keep class com.tencent.thumbplayer.api.** { *; }】是否加入反混淆");
            }
            buildNativeInitConfigMap();
            buildPublicToNativeOptionalIdMap();
            buildPrivateToNativeOptionalIdMap();
            sHasOptionalIdMapInit.set(true);
        }
    }

    private static void buildPrivateToNativeOptionalIdMap() {
        try {
            buildNativeOptionalIdToMapInternal(Class.forName(TPOptionalIDInternal.class.getName()));
        } catch (ClassNotFoundException e) {
            TPLogUtil.e(TAG, e);
        }
    }

    private static void buildPublicToNativeOptionalIdMap() {
        try {
            buildNativeOptionalIdToMapInternal(Class.forName(TPOptionalID.class.getName()));
        } catch (ClassNotFoundException e) {
            TPLogUtil.e(TAG, e);
        }
    }

    private static <T extends Annotation> void checkFillMapValidity(Class<T> cls, Map<Number, Number> map, Map<Number, Number> map2, Class<?> cls2, Number number, Number number2) {
        if (map.containsKey(number2)) {
            throw new IllegalStateException(cls2.getName() + " 配置了重复的成员变量，注解=" + cls.getName() + " 成员变量值=" + number2 + " 请查找一下使用这个注解@" + cls.getName() + "的哪两个成员变量值相等");
        } else if (map2.containsKey(number)) {
            throw new IllegalStateException(cls2.getName() + " 配置了重复的注解值，注解=" + cls.getName() + " 成员变量值=" + number2 + " 请查找一下@" + cls.getName() + "(这个值)在哪里重复了");
        }
    }

    public static c.a convertToNativeOptionalId(@TPCommonEnum.TPOptionalId int i) {
        if (sToNativeOptionalIdMap.size() == 0) {
            buildOptionalIdMap();
        }
        return sToNativeOptionalIdMap.get(i, new c.a());
    }

    public static <T extends Annotation> Set<Map.Entry<Number, Number>> getEntrySetOfToNativeMap(Class<T> cls) {
        return new HashSet(getMapForAnnotation(cls, true).entrySet());
    }

    public static <T extends Annotation> Set<Map.Entry<Number, Number>> getEntrySetOfToTPMap(Class<T> cls) {
        return new HashSet(getMapForAnnotation(cls, false).entrySet());
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0021, code lost:
        if (r0.size() == 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T extends java.lang.annotation.Annotation> java.util.Map<java.lang.Number, java.lang.Number> getMapForAnnotation(java.lang.Class<T> r4, boolean r5) {
        /*
            r0 = r4
            r1 = r5
            java.lang.String r0 = getMapKey(r0, r1)
            r8 = r0
            java.util.Map<java.lang.String, java.util.Map<java.lang.Number, java.lang.Number>> r0 = com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil.sNameToMap
            r1 = r8
            java.lang.Object r0 = r0.get(r1)
            java.util.Map r0 = (java.util.Map) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L24
            r0 = r7
            r6 = r0
            r0 = r7
            int r0 = r0.size()
            if (r0 != 0) goto L36
        L24:
            r0 = r4
            buildBiDirectionMapForAnnotation(r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.Number, java.lang.Number>> r0 = com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil.sNameToMap
            r1 = r8
            java.lang.Object r0 = r0.get(r1)
            java.util.Map r0 = (java.util.Map) r0
            r6 = r0
        L36:
            r0 = r4
            java.lang.Class<com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap$SearchConfig> r1 = com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.SearchConfig.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r1)
            com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap$SearchConfig r0 = (com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.SearchConfig) r0
            if (r0 == 0) goto L77
            r0 = r6
            if (r0 == 0) goto L52
            r0 = r6
            int r0 = r0.size()
            if (r0 == 0) goto L52
            r0 = r6
            return r0
        L52:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            r1 = r4
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = " is null after buildBiDirectionMap"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r2 = r6
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L77:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            r1 = r4
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = "has not SearchConfig annotation"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r6
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil.getMapForAnnotation(java.lang.Class, boolean):java.util.Map");
    }

    private static <T extends Annotation> String getMapKey(Class<T> cls, boolean z) {
        String canonicalName = cls.getCanonicalName();
        if (z) {
            return canonicalName;
        }
        return canonicalName + REVERSE_MAP_NAME_SUFFIX;
    }

    public static String getOptionalIdName(int i) {
        if (!sHasOptionalIdMapInit.get()) {
            buildOptionalIdMap();
        }
        return sOptionalIdKeyToNameMap.get(i, "");
    }

    public static void init() {
        long currentTimeMillis = System.currentTimeMillis();
        Class<?>[] declaredClasses = TPNativeKeyMap.class.getDeclaredClasses();
        TPLogUtil.i(TAG, "init BiDirectionMap for tp&native value");
        int length = declaredClasses.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                long currentTimeMillis2 = System.currentTimeMillis();
                TPLogUtil.i(TAG, "init cost time=" + (currentTimeMillis2 - currentTimeMillis));
                return;
            }
            Class<?> cls = declaredClasses[i2];
            if (cls.isAnnotation() && Modifier.isPublic(cls.getModifiers()) && ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)) != null) {
                buildBiDirectionMapForAnnotation(cls);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0037, code lost:
        if (r0 == null) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T extends java.lang.annotation.Annotation> void searchClassToFillMap(java.lang.Class<T> r7) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil.searchClassToFillMap(java.lang.Class):void");
    }

    public static <T extends Annotation> int toNativeIntValue(Class<T> cls, int i) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, true);
        if (mapForAnnotation.containsKey(Integer.valueOf(i))) {
            return mapForAnnotation.get(Integer.valueOf(i)).intValue();
        }
        TPLogUtil.e(TAG, "toNativeValue, tpValue=" + i + "return default value, clazz" + cls);
        return (int) ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)).nativeDefValue();
    }

    public static <T extends Annotation> long toNativeLongValue(Class<T> cls, long j) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, true);
        if (mapForAnnotation.containsKey(Long.valueOf(j))) {
            return mapForAnnotation.get(Long.valueOf(j)).longValue();
        }
        TPLogUtil.e(TAG, "toNativeValue, tpValue=" + j + "return default value, clazz" + cls);
        return ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)).nativeDefValue();
    }

    public static <T extends Annotation> int toTPIntValue(Class<T> cls, int i) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, false);
        if (mapForAnnotation.containsKey(Integer.valueOf(i))) {
            return mapForAnnotation.get(Integer.valueOf(i)).intValue();
        }
        TPLogUtil.i(TAG, "toTPValue, nativeValue=" + i + "return default value, clazz" + cls);
        return (int) ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)).tpDefValue();
    }

    public static <T extends Annotation> long toTPLongValue(Class<T> cls, long j) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, false);
        if (mapForAnnotation.containsKey(Long.valueOf(j))) {
            return mapForAnnotation.get(Long.valueOf(j)).longValue();
        }
        TPLogUtil.i(TAG, "toTPValue, nativeValue=" + j + "return default value, clazz" + cls);
        return ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)).tpDefValue();
    }
}
