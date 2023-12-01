package java.lang.reflect;

import java.lang.annotation.Annotation;
import java.util.List;
import libcore.reflect.AnnotationAccess;
import libcore.reflect.GenericSignatureParser;
import libcore.reflect.ListOfTypes;
import libcore.reflect.Types;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/AbstractMethod.class */
public abstract class AbstractMethod extends AccessibleObject {
    protected final ArtMethod artMethod;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/AbstractMethod$GenericInfo.class */
    public static final class GenericInfo {
        final TypeVariable<?>[] formalTypeParameters;
        final ListOfTypes genericExceptionTypes;
        final ListOfTypes genericParameterTypes;
        final Type genericReturnType;

        GenericInfo(ListOfTypes listOfTypes, ListOfTypes listOfTypes2, Type type, TypeVariable<?>[] typeVariableArr) {
            this.genericExceptionTypes = listOfTypes;
            this.genericParameterTypes = listOfTypes2;
            this.genericReturnType = type;
            this.formalTypeParameters = typeVariableArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMethod(ArtMethod artMethod) {
        if (artMethod == null) {
            throw new NullPointerException("artMethod == null");
        }
        this.artMethod = artMethod;
    }

    private static int fixMethodFlags(int i) {
        int i2 = i;
        if ((i & 1024) != 0) {
            i2 = i & (-257);
        }
        int i3 = i2 & (-33);
        int i4 = i3;
        if ((i3 & 131072) != 0) {
            i4 = i3 | 32;
        }
        return 65535 & i4;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractMethod) && this.artMethod == ((AbstractMethod) obj).artMethod;
    }

    public final int getAccessFlags() {
        return this.artMethod.getAccessFlags();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) super.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return super.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        List<Annotation> declaredAnnotations = AnnotationAccess.getDeclaredAnnotations(this);
        return (Annotation[]) declaredAnnotations.toArray(new Annotation[declaredAnnotations.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> getDeclaringClass() {
        return this.artMethod.getDeclaringClass();
    }

    public final int getDexMethodIndex() {
        return this.artMethod.getDexMethodIndex();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type[] getGenericExceptionTypes() {
        return Types.getTypeArray(getMethodOrConstructorGenericInfo().genericExceptionTypes, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type[] getGenericParameterTypes() {
        return Types.getTypeArray(getMethodOrConstructorGenericInfo().genericParameterTypes, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final GenericInfo getMethodOrConstructorGenericInfo() {
        Constructor constructor;
        Class<?>[] exceptionTypes;
        String signature = AnnotationAccess.getSignature(this);
        boolean z = this instanceof Method;
        if (z) {
            Method method = (Method) this;
            constructor = method;
            exceptionTypes = method.getExceptionTypes();
        } else {
            Constructor constructor2 = (Constructor) this;
            constructor = constructor2;
            exceptionTypes = constructor2.getExceptionTypes();
        }
        GenericSignatureParser genericSignatureParser = new GenericSignatureParser(constructor.getDeclaringClass().getClassLoader());
        if (z) {
            genericSignatureParser.parseForMethod((GenericDeclaration) this, signature, exceptionTypes);
        } else {
            genericSignatureParser.parseForConstructor((GenericDeclaration) this, signature, exceptionTypes);
        }
        return new GenericInfo(genericSignatureParser.exceptionTypes, genericSignatureParser.parameterTypes, genericSignatureParser.returnType, genericSignatureParser.formalTypeParameters);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getModifiers() {
        return fixMethodFlags(this.artMethod.getAccessFlags());
    }

    public abstract String getName();

    public abstract Annotation[][] getParameterAnnotations();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?>[] getParameterTypes() {
        return this.artMethod.getParameterTypes();
    }

    abstract String getSignature();

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        if (cls == null) {
            throw new NullPointerException("annotationType == null");
        }
        return AnnotationAccess.isDeclaredAnnotationPresent(this, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBridge() {
        return (this.artMethod.getAccessFlags() & 64) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSynthetic() {
        return (this.artMethod.getAccessFlags() & 4096) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isVarArgs() {
        return (this.artMethod.getAccessFlags() & 128) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toGenericString() {
        return toGenericStringHelper();
    }

    final String toGenericStringHelper() {
        StringBuilder sb = new StringBuilder(80);
        GenericInfo methodOrConstructorGenericInfo = getMethodOrConstructorGenericInfo();
        int modifiers = ((Member) this).getModifiers();
        if (modifiers != 0) {
            sb.append(Modifier.toString(modifiers & (-129))).append(' ');
        }
        if (methodOrConstructorGenericInfo.formalTypeParameters != null && methodOrConstructorGenericInfo.formalTypeParameters.length > 0) {
            sb.append('<');
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= methodOrConstructorGenericInfo.formalTypeParameters.length) {
                    break;
                }
                Types.appendGenericType(sb, methodOrConstructorGenericInfo.formalTypeParameters[i2]);
                if (i2 < methodOrConstructorGenericInfo.formalTypeParameters.length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            sb.append("> ");
        }
        Class<?> declaringClass = ((Member) this).getDeclaringClass();
        if (this instanceof Constructor) {
            Types.appendTypeName(sb, declaringClass);
        } else {
            Types.appendGenericType(sb, Types.getType(methodOrConstructorGenericInfo.genericReturnType));
            sb.append(' ');
            Types.appendTypeName(sb, declaringClass);
            sb.append(".").append(((Method) this).getName());
        }
        sb.append('(');
        Types.appendArrayGenericType(sb, methodOrConstructorGenericInfo.genericParameterTypes.getResolvedTypes());
        sb.append(')');
        Type[] typeArray = Types.getTypeArray(methodOrConstructorGenericInfo.genericExceptionTypes, false);
        if (typeArray.length > 0) {
            sb.append(" throws ");
            Types.appendArrayGenericType(sb, typeArray);
        }
        return sb.toString();
    }
}
