package external.org.apache.commons.lang3.reflect;

import external.org.apache.commons.lang3.ClassUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/reflect/MemberUtils.class */
public abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    public static int compareParameterTypes(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float totalTransformationCost = getTotalTransformationCost(clsArr3, clsArr);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr3, clsArr2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        return totalTransformationCost2 < totalTransformationCost ? 1 : 0;
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        float f;
        float f2;
        if (cls2.isPrimitive()) {
            f2 = getPrimitivePromotionCost(cls, cls2);
        } else {
            float f3 = 0.0f;
            while (true) {
                f = f3;
                if (cls == null) {
                    break;
                }
                f = f3;
                if (!cls2.equals(cls)) {
                    if (cls2.isInterface() && ClassUtils.isAssignable(cls, cls2)) {
                        f = f3 + 0.25f;
                        break;
                    }
                    f3 += 1.0f;
                    cls = cls.getSuperclass();
                } else {
                    break;
                }
            }
            f2 = f;
            if (cls == null) {
                return f + 1.5f;
            }
        }
        return f2;
    }

    private static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        float f;
        float f2 = 0.0f;
        Class<?> cls3 = cls;
        if (!cls.isPrimitive()) {
            f2 = 0.0f + 0.1f;
            cls3 = ClassUtils.wrapperToPrimitive(cls);
        }
        int i = 0;
        while (true) {
            f = f2;
            if (cls3 == cls2 || i >= ORDERED_PRIMITIVE_TYPES.length) {
                break;
            }
            Class<?> cls4 = cls3;
            f2 = f;
            if (cls3 == ORDERED_PRIMITIVE_TYPES[i]) {
                float f3 = f + 0.1f;
                cls4 = cls3;
                f2 = f3;
                if (i < ORDERED_PRIMITIVE_TYPES.length - 1) {
                    cls4 = ORDERED_PRIMITIVE_TYPES[i + 1];
                    f2 = f3;
                }
            }
            i++;
            cls3 = cls4;
        }
        return f;
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= clsArr.length) {
                return f;
            }
            f += getObjectTransformationCost(clsArr[i2], clsArr2[i2]);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAccessible(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    static boolean isPackageAccess(int i) {
        return (i & 7) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAccessibleWorkaround(AccessibleObject accessibleObject) {
        if (accessibleObject == null || accessibleObject.isAccessible()) {
            return;
        }
        Member member = (Member) accessibleObject;
        if (Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
            }
        }
    }
}
