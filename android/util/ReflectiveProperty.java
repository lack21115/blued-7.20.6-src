package android.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/util/ReflectiveProperty.class */
class ReflectiveProperty<T, V> extends Property<T, V> {
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    public ReflectiveProperty(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        try {
            this.mGetter = cls.getMethod("get" + str2, null);
        } catch (NoSuchMethodException e) {
            try {
                this.mGetter = cls.getMethod("is" + str2, null);
            } catch (NoSuchMethodException e2) {
                try {
                    this.mField = cls.getField(str);
                    Class<?> type = this.mField.getType();
                    if (typesMatch(cls2, type)) {
                        return;
                    }
                    throw new NoSuchPropertyException("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                } catch (NoSuchFieldException e3) {
                    throw new NoSuchPropertyException("No accessor method or field found for property with name " + str);
                }
            }
        }
        Class<?> returnType = this.mGetter.getReturnType();
        if (!typesMatch(cls2, returnType)) {
            throw new NoSuchPropertyException("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
        }
        try {
            this.mSetter = cls.getMethod(PREFIX_SET + str2, returnType);
        } catch (NoSuchMethodException e4) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
        if (r4 == java.lang.Character.class) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean typesMatch(java.lang.Class<V> r4, java.lang.Class r5) {
        /*
            r3 = this;
            r0 = 0
            r7 = r0
            r0 = r5
            r1 = r4
            if (r0 == r1) goto L84
            r0 = r7
            r6 = r0
            r0 = r5
            boolean r0 = r0.isPrimitive()
            if (r0 == 0) goto L82
            r0 = r5
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.TYPE
            if (r0 != r1) goto L1f
            r0 = r4
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            if (r0 == r1) goto L80
        L1f:
            r0 = r5
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.TYPE
            if (r0 != r1) goto L2c
            r0 = r4
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            if (r0 == r1) goto L80
        L2c:
            r0 = r5
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.TYPE
            if (r0 != r1) goto L39
            r0 = r4
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            if (r0 == r1) goto L80
        L39:
            r0 = r5
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.TYPE
            if (r0 != r1) goto L46
            r0 = r4
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            if (r0 == r1) goto L80
        L46:
            r0 = r5
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.TYPE
            if (r0 != r1) goto L53
            r0 = r4
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            if (r0 == r1) goto L80
        L53:
            r0 = r5
            java.lang.Class<java.lang.Short> r1 = java.lang.Short.TYPE
            if (r0 != r1) goto L60
            r0 = r4
            java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
            if (r0 == r1) goto L80
        L60:
            r0 = r5
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.TYPE
            if (r0 != r1) goto L6d
            r0 = r4
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
            if (r0 == r1) goto L80
        L6d:
            r0 = r7
            r6 = r0
            r0 = r5
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.TYPE
            if (r0 != r1) goto L82
            r0 = r7
            r6 = r0
            r0 = r4
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            if (r0 != r1) goto L82
        L80:
            r0 = 1
            r6 = r0
        L82:
            r0 = r6
            return r0
        L84:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.util.ReflectiveProperty.typesMatch(java.lang.Class, java.lang.Class):boolean");
    }

    @Override // android.util.Property
    public V get(T t) {
        if (this.mGetter != null) {
            try {
                return (V) this.mGetter.invoke(t, null);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.mField != null) {
            try {
                return (V) this.mField.get(t);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // android.util.Property
    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }

    @Override // android.util.Property
    public void set(T t, V v) {
        if (this.mSetter != null) {
            try {
                this.mSetter.invoke(t, v);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.mField == null) {
            throw new UnsupportedOperationException("Property " + getName() + " is read-only");
        } else {
            try {
                this.mField.set(t, v);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        }
    }
}
