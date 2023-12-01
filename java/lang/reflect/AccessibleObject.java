package java.lang.reflect;

import java.lang.annotation.Annotation;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/AccessibleObject.class */
public class AccessibleObject implements AnnotatedElement {
    private boolean flag = false;

    public static void setAccessible(AccessibleObject[] accessibleObjectArr, boolean z) {
        int length = accessibleObjectArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            accessibleObjectArr[i2].flag = z;
            i = i2 + 1;
        }
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        throw new UnsupportedOperationException();
    }

    public boolean isAccessible() {
        return this.flag;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        throw new UnsupportedOperationException();
    }

    public void setAccessible(boolean z) {
        try {
            if (equals(Class.class.getDeclaredConstructor(new Class[0]))) {
                throw new SecurityException("Can't make class constructor accessible");
            }
            this.flag = z;
        } catch (NoSuchMethodException e) {
            throw new AssertionError("Couldn't find class constructor");
        }
    }
}
