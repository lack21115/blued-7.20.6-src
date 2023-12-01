package com.tencent.turingface.sdk.mfa;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/JF943.class */
public final class JF943 {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Field>> f26196a;
    public static HashMap<Class<?>, HashMap<String, Method>> b;

    static {
        new HashMap();
        f26196a = new HashMap<>();
        b = new HashMap<>();
    }

    public static Object a(Class<?> cls, String str, Object obj) {
        try {
            HashMap<String, Field> hashMap = f26196a.get(cls);
            HashMap<String, Field> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
                f26196a.put(cls, hashMap2);
            }
            Field field = hashMap2.get(str);
            Field field2 = field;
            if (field == null) {
                field2 = cls.getDeclaredField(str);
            }
            if (field2 == null) {
                field2 = null;
            } else {
                field2.setAccessible(true);
                hashMap2.put(str, field2);
            }
            if (field2 == null) {
                return null;
            }
            return field2.get(obj);
        }
    }

    public static Method a(Class cls) {
        try {
            if (TextUtils.isEmpty("getAccessibilityInteractionController")) {
                return null;
            }
            String stringBuffer = new StringBuffer("getAccessibilityInteractionController").toString();
            HashMap<String, Method> hashMap = b.get(cls);
            HashMap<String, Method> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
                b.put(cls, hashMap2);
            }
            Method method = hashMap2.get(stringBuffer);
            Method method2 = method;
            if (method == null) {
                method2 = cls.getDeclaredMethod("getAccessibilityInteractionController", null);
            }
            if (method2 == null) {
                return null;
            }
            method2.setAccessible(true);
            hashMap2.put(stringBuffer, method2);
            return method2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
