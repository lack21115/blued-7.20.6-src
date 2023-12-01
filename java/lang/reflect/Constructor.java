package java.lang.reflect;

import java.lang.annotation.Annotation;
import java.util.Comparator;
import java.util.List;
import libcore.reflect.AnnotationAccess;
import libcore.reflect.Types;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/Constructor.class */
public final class Constructor<T> extends AbstractMethod implements GenericDeclaration, Member {
    private static final Comparator<Method> ORDER_BY_SIGNATURE = null;

    public Constructor(ArtMethod artMethod) {
        super(artMethod);
    }

    @Override // java.lang.reflect.AbstractMethod
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        if (cls == null) {
            throw new NullPointerException("annotationType == null");
        }
        return (A) AnnotationAccess.getDeclaredAnnotation(this, cls);
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return super.getAnnotations();
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        List<Annotation> declaredAnnotations = AnnotationAccess.getDeclaredAnnotations(this);
        return (Annotation[]) declaredAnnotations.toArray(new Annotation[declaredAnnotations.size()]);
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.Member
    public Class<T> getDeclaringClass() {
        return (Class<T>) super.getDeclaringClass();
    }

    public Class<?>[] getExceptionTypes() {
        return AnnotationAccess.getExceptions(this);
    }

    @Override // java.lang.reflect.AbstractMethod
    public Type[] getGenericExceptionTypes() {
        return super.getGenericExceptionTypes();
    }

    @Override // java.lang.reflect.AbstractMethod
    public Type[] getGenericParameterTypes() {
        return super.getGenericParameterTypes();
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.Member
    public int getModifiers() {
        return super.getModifiers();
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.Member
    public String getName() {
        return getDeclaringClass().getName();
    }

    @Override // java.lang.reflect.AbstractMethod
    public Annotation[][] getParameterAnnotations() {
        return this.artMethod.getParameterAnnotations();
    }

    @Override // java.lang.reflect.AbstractMethod
    public Class<?>[] getParameterTypes() {
        return super.getParameterTypes();
    }

    @Override // java.lang.reflect.AbstractMethod
    String getSignature() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        Class<?>[] parameterTypes = getParameterTypes();
        int length = parameterTypes.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append(")V");
                return sb.toString();
            }
            sb.append(Types.getSignature(parameterTypes[i2]));
            i = i2 + 1;
        }
    }

    @Override // java.lang.reflect.GenericDeclaration
    public TypeVariable<Constructor<T>>[] getTypeParameters() {
        return (TypeVariable[]) getMethodOrConstructorGenericInfo().formalTypeParameters.clone();
    }

    public int hashCode() {
        return getDeclaringClass().getName().hashCode();
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        if (cls == null) {
            throw new NullPointerException("annotationType == null");
        }
        return AnnotationAccess.isDeclaredAnnotationPresent(this, cls);
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.Member
    public boolean isSynthetic() {
        return super.isSynthetic();
    }

    @Override // java.lang.reflect.AbstractMethod
    public boolean isVarArgs() {
        return super.isVarArgs();
    }

    public T newInstance(Object... objArr) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return newInstance(objArr, isAccessible());
    }

    public native T newInstance(Object[] objArr, boolean z) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    @Override // java.lang.reflect.AbstractMethod
    public String toGenericString() {
        return super.toGenericString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Modifier.toString(getModifiers()));
        if (sb.length() != 0) {
            sb.append(' ');
        }
        sb.append(getDeclaringClass().getName());
        sb.append("(");
        sb.append(Types.toString(getParameterTypes()));
        sb.append(")");
        Class<?>[] exceptionTypes = getExceptionTypes();
        if (exceptionTypes.length > 0) {
            sb.append(" throws ");
            sb.append(Types.toString(exceptionTypes));
        }
        return sb.toString();
    }
}
