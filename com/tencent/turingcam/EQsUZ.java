package com.tencent.turingcam;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/EQsUZ.class */
public class EQsUZ {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39811a = WOMZP.b("mdNjPO1K7FJ+9CbSnlMtKMQ1GBI=");
    private static final String b = WOMZP.b("atljSFyftxO7USe0FJAEN952jDJYW1+B");

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/EQsUZ$spXPg.class */
    public static class spXPg {

        /* renamed from: a  reason: collision with root package name */
        Object f39812a;

        public <T> T a() {
            return (T) this.f39812a;
        }
    }

    public static boolean a(Object obj, String str, spXPg spxpg) {
        try {
            Field field = (Field) Class.class.getDeclaredMethod(f39811a, String.class).invoke(obj.getClass(), str);
            if (field != null) {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                field.setAccessible(false);
                spxpg.f39812a = obj2;
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method method = (Method) Class.class.getDeclaredMethod(b, String.class, Class[].class).invoke(obj.getClass(), str, clsArr);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj, objArr);
                method.setAccessible(false);
                return true;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
