package java.lang.reflect;

import java.lang.annotation.Annotation;
import java.util.Comparator;
import java.util.List;
import libcore.reflect.AnnotationAccess;
import libcore.reflect.Types;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/Method.class */
public final class Method extends AbstractMethod implements GenericDeclaration, Member {
    public static final Comparator<Method> ORDER_BY_SIGNATURE = new Comparator<Method>() { // from class: java.lang.reflect.Method.1
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            int i;
            if (method == method2) {
                i = 0;
            } else {
                int compareTo = method.getName().compareTo(method2.getName());
                i = compareTo;
                if (compareTo == 0) {
                    int compareParameters = method.artMethod.findOverriddenMethodIfProxy().compareParameters(method2.getParameterTypes());
                    i = compareParameters;
                    if (compareParameters == 0) {
                        Class<?> returnType = method.getReturnType();
                        Class<?> returnType2 = method2.getReturnType();
                        if (returnType == returnType2) {
                            return 0;
                        }
                        return returnType.getName().compareTo(returnType2.getName());
                    }
                }
            }
            return i;
        }
    };

    public Method(ArtMethod artMethod) {
        super(artMethod);
    }

    private native Class<?>[] getExceptionTypesNative();

    private native Object invoke(Object obj, Object[] objArr, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean equalNameAndParameters(Method method) {
        return getName().equals(method.getName()) && ArtMethod.equalMethodParameters(this.artMethod, method.getParameterTypes());
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArtMethod getArtMethod() {
        return this.artMethod;
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        List<Annotation> declaredAnnotations = AnnotationAccess.getDeclaredAnnotations(this);
        return (Annotation[]) declaredAnnotations.toArray(new Annotation[declaredAnnotations.size()]);
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return super.getDeclaringClass();
    }

    public Object getDefaultValue() {
        return AnnotationAccess.getDefaultValue(this);
    }

    public Class<?>[] getExceptionTypes() {
        return getDeclaringClass().isProxy() ? getExceptionTypesNative() : AnnotationAccess.getExceptions(this);
    }

    @Override // java.lang.reflect.AbstractMethod
    public Type[] getGenericExceptionTypes() {
        return Types.getTypeArray(getMethodOrConstructorGenericInfo().genericExceptionTypes, false);
    }

    @Override // java.lang.reflect.AbstractMethod
    public Type[] getGenericParameterTypes() {
        return Types.getTypeArray(getMethodOrConstructorGenericInfo().genericParameterTypes, false);
    }

    public Type getGenericReturnType() {
        return Types.getType(getMethodOrConstructorGenericInfo().genericReturnType);
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.Member
    public int getModifiers() {
        return super.getModifiers();
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.Member
    public String getName() {
        return ArtMethod.getMethodName(this.artMethod);
    }

    @Override // java.lang.reflect.AbstractMethod
    public Annotation[][] getParameterAnnotations() {
        return this.artMethod.findOverriddenMethodIfProxy().getParameterAnnotations();
    }

    @Override // java.lang.reflect.AbstractMethod
    public Class<?>[] getParameterTypes() {
        return this.artMethod.findOverriddenMethodIfProxy().getParameterTypes();
    }

    public Class<?> getReturnType() {
        return this.artMethod.findOverriddenMethodIfProxy().getReturnType();
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
                sb.append(')');
                sb.append(Types.getSignature(getReturnType()));
                return sb.toString();
            }
            sb.append(Types.getSignature(parameterTypes[i2]));
            i = i2 + 1;
        }
    }

    @Override // java.lang.reflect.GenericDeclaration
    public TypeVariable<Method>[] getTypeParameters() {
        return (TypeVariable[]) getMethodOrConstructorGenericInfo().formalTypeParameters.clone();
    }

    public int hashCode() {
        return getDeclaringClass().getName().hashCode() ^ getName().hashCode();
    }

    public Object invoke(Object obj, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return invoke(obj, objArr, isAccessible());
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        if (cls == null) {
            throw new NullPointerException("annotationType == null");
        }
        return AnnotationAccess.isDeclaredAnnotationPresent(this, cls);
    }

    @Override // java.lang.reflect.AbstractMethod
    public boolean isBridge() {
        return super.isBridge();
    }

    @Override // java.lang.reflect.AbstractMethod, java.lang.reflect.Member
    public boolean isSynthetic() {
        return super.isSynthetic();
    }

    @Override // java.lang.reflect.AbstractMethod
    public boolean isVarArgs() {
        return super.isVarArgs();
    }

    @Override // java.lang.reflect.AbstractMethod
    public String toGenericString() {
        return super.toGenericString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Modifier.toString(getModifiers()));
        if (sb.length() != 0) {
            sb.append(' ');
        }
        sb.append(getReturnType().getName());
        sb.append(' ');
        sb.append(getDeclaringClass().getName());
        sb.append('.');
        sb.append(getName());
        sb.append("(");
        sb.append(Types.toString(getParameterTypes()));
        sb.append(")");
        Class<?>[] exceptionTypes = getExceptionTypes();
        if (exceptionTypes.length != 0) {
            sb.append(" throws ");
            sb.append(Types.toString(exceptionTypes));
        }
        return sb.toString();
    }
}
