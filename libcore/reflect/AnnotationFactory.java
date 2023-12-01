package libcore.reflect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/AnnotationFactory.class */
public final class AnnotationFactory implements InvocationHandler, Serializable {
    private static final transient Map<Class<? extends Annotation>, AnnotationMember[]> cache = new WeakHashMap();
    private AnnotationMember[] elements;
    private final Class<? extends Annotation> klazz;

    private AnnotationFactory(Class<? extends Annotation> cls, AnnotationMember[] annotationMemberArr) {
        this.klazz = cls;
        AnnotationMember[] elementsDescription = getElementsDescription(this.klazz);
        if (annotationMemberArr == null) {
            this.elements = elementsDescription;
            return;
        }
        this.elements = new AnnotationMember[elementsDescription.length];
        int length = this.elements.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return;
            }
            int length2 = annotationMemberArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length2) {
                    this.elements[i] = elementsDescription[i];
                    break;
                }
                AnnotationMember annotationMember = annotationMemberArr[i3];
                if (annotationMember.name.equals(elementsDescription[i].name)) {
                    this.elements[i] = annotationMember.setDefinition(elementsDescription[i]);
                    break;
                }
                i2 = i3 + 1;
            }
            length = i;
        }
    }

    public static <A extends Annotation> A createAnnotation(Class<? extends Annotation> cls, AnnotationMember[] annotationMemberArr) {
        return (A) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new AnnotationFactory(cls, annotationMemberArr));
    }

    public static AnnotationMember[] getElementsDescription(Class<? extends Annotation> cls) {
        synchronized (cache) {
            AnnotationMember[] annotationMemberArr = cache.get(cls);
            if (annotationMemberArr != null) {
                return annotationMemberArr;
            }
            if (!cls.isAnnotation()) {
                throw new IllegalArgumentException("Type is not annotation: " + cls.getName());
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            AnnotationMember[] annotationMemberArr2 = new AnnotationMember[declaredMethods.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= declaredMethods.length) {
                    synchronized (cache) {
                        cache.put(cls, annotationMemberArr2);
                    }
                    return annotationMemberArr2;
                }
                Method method = declaredMethods[i2];
                String name = method.getName();
                Class<?> returnType = method.getReturnType();
                try {
                    annotationMemberArr2[i2] = new AnnotationMember(name, method.getDefaultValue(), returnType, method);
                } catch (Throwable th) {
                    annotationMemberArr2[i2] = new AnnotationMember(name, th, returnType, method);
                }
                i = i2 + 1;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        AnnotationMember[] elementsDescription = getElementsDescription(this.klazz);
        AnnotationMember[] annotationMemberArr = this.elements;
        ArrayList arrayList = new ArrayList(elementsDescription.length + annotationMemberArr.length);
        int length = annotationMemberArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            AnnotationMember annotationMember = annotationMemberArr[i2];
            int length2 = elementsDescription.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    arrayList.add(annotationMember);
                    break;
                } else if (elementsDescription[i4].name.equals(annotationMember.name)) {
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
        int length3 = elementsDescription.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                this.elements = (AnnotationMember[]) arrayList.toArray(new AnnotationMember[arrayList.size()]);
                return;
            }
            AnnotationMember annotationMember2 = elementsDescription[i6];
            int length4 = annotationMemberArr.length;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= length4) {
                    arrayList.add(annotationMember2);
                    break;
                }
                AnnotationMember annotationMember3 = annotationMemberArr[i8];
                if (annotationMember3.name.equals(annotationMember2.name)) {
                    arrayList.add(annotationMember3.setDefinition(annotationMember2));
                    break;
                }
                i7 = i8 + 1;
            }
            i5 = i6 + 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!this.klazz.isInstance(obj)) {
            return false;
        }
        if (Proxy.isProxyClass(obj.getClass())) {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
            if (invocationHandler instanceof AnnotationFactory) {
                AnnotationFactory annotationFactory = (AnnotationFactory) invocationHandler;
                if (this.elements.length != annotationFactory.elements.length) {
                    return false;
                }
                AnnotationMember[] annotationMemberArr = this.elements;
                int length = annotationMemberArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return true;
                    }
                    AnnotationMember annotationMember = annotationMemberArr[i2];
                    AnnotationMember[] annotationMemberArr2 = annotationFactory.elements;
                    int length2 = annotationMemberArr2.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length2) {
                            return false;
                        }
                        if (annotationMember.equals(annotationMemberArr2[i4])) {
                            break;
                        }
                        i3 = i4 + 1;
                    }
                    i = i2 + 1;
                }
            }
        }
        AnnotationMember[] annotationMemberArr3 = this.elements;
        int length3 = annotationMemberArr3.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                return true;
            }
            AnnotationMember annotationMember2 = annotationMemberArr3[i6];
            if (annotationMember2.tag == '!') {
                return false;
            }
            try {
                if (!annotationMember2.definingMethod.isAccessible()) {
                    annotationMember2.definingMethod.setAccessible(true);
                }
                Object invoke = annotationMember2.definingMethod.invoke(obj, new Object[0]);
                if (invoke != null) {
                    if (annotationMember2.tag == '[') {
                        if (!annotationMember2.equalArrayValue(invoke)) {
                            return false;
                        }
                    } else if (!annotationMember2.value.equals(invoke)) {
                        return false;
                    }
                } else if (annotationMember2.value != AnnotationMember.NO_VALUE) {
                    return false;
                }
                i5 = i6 + 1;
            } catch (Throwable th) {
                return false;
            }
        }
    }

    public int hashCode() {
        int i = 0;
        AnnotationMember[] annotationMemberArr = this.elements;
        int length = annotationMemberArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return i;
            }
            i += annotationMemberArr[i3].hashCode();
            i2 = i3 + 1;
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        AnnotationMember annotationMember;
        Class<? extends Annotation> cls;
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 0) {
            if (parameterTypes.length == 1 && parameterTypes[0] == Object.class && "equals".equals(name)) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            throw new IllegalArgumentException("Invalid method for annotation type: " + method);
        }
        if ("annotationType".equals(name)) {
            cls = this.klazz;
        } else if ("toString".equals(name)) {
            return toString();
        } else {
            if ("hashCode".equals(name)) {
                return Integer.valueOf(hashCode());
            }
            AnnotationMember[] annotationMemberArr = this.elements;
            int length = annotationMemberArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                annotationMember = null;
                if (i2 >= length) {
                    break;
                }
                annotationMember = annotationMemberArr[i2];
                if (name.equals(annotationMember.name)) {
                    break;
                }
                i = i2 + 1;
            }
            if (annotationMember == null || !method.equals(annotationMember.definingMethod)) {
                throw new IllegalArgumentException(method.toString());
            }
            Object validateValue = annotationMember.validateValue();
            cls = validateValue;
            if (validateValue == null) {
                throw new IncompleteAnnotationException(this.klazz, name);
            }
        }
        return cls;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        sb.append(this.klazz.getName());
        sb.append('(');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.elements.length) {
                sb.append(')');
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(", ");
            }
            sb.append(this.elements[i2]);
            i = i2 + 1;
        }
    }
}
