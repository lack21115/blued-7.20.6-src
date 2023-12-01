package libcore.reflect;

import com.android.dex.Dex;
import com.android.dex.EncodedValueReader;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/AnnotationAccess.class */
public final class AnnotationAccess {
    private static final Class<?>[] NO_ARGUMENTS = null;
    private static final byte VISIBILITY_BUILD = 0;
    private static final byte VISIBILITY_RUNTIME = 1;
    private static final byte VISIBILITY_SYSTEM = 2;

    private AnnotationAccess() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.util.List] */
    private static List<Annotation> annotationSetToAnnotations(Class<?> cls, int i) {
        ArrayList arrayList;
        Class<? extends Annotation> annotationClass;
        if (i != 0) {
            Dex dex = cls.getDex();
            Dex.Section open = dex.open(i);
            int readInt = open.readInt();
            ArrayList arrayList2 = new ArrayList(readInt);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                arrayList = arrayList2;
                if (i3 >= readInt) {
                    break;
                }
                com.android.dex.Annotation readAnnotation = dex.open(open.readInt()).readAnnotation();
                if (readAnnotation.getVisibility() == 1 && (annotationClass = getAnnotationClass(cls, dex, readAnnotation.getTypeIndex())) != null) {
                    arrayList2.add(toAnnotationInstance(cls, dex, annotationClass, readAnnotation.getReader()));
                }
                i2 = i3 + 1;
            }
        } else {
            arrayList = Collections.emptyList();
        }
        return arrayList;
    }

    private static Object decodeValue(Class<?> cls, Class<?> cls2, Dex dex, EncodedValueReader encodedValueReader) {
        Object obj;
        if (cls2.isArray()) {
            int readArray = encodedValueReader.readArray();
            Class<?> componentType = cls2.getComponentType();
            Object newInstance = Array.newInstance(componentType, readArray);
            int i = 0;
            while (true) {
                int i2 = i;
                obj = newInstance;
                if (i2 >= readArray) {
                    break;
                }
                Array.set(newInstance, i2, decodeValue(cls, componentType, dex, encodedValueReader));
                i = i2 + 1;
            }
        } else if (!cls2.isEnum()) {
            if (cls2.isAnnotation()) {
                return toAnnotationInstance(cls, dex, cls2, encodedValueReader);
            }
            if (cls2 == String.class) {
                return cls.getDexCacheString(dex, encodedValueReader.readString());
            }
            if (cls2 == Class.class) {
                return cls.getDexCacheType(dex, encodedValueReader.readType());
            }
            if (cls2 == Byte.TYPE) {
                return Byte.valueOf(encodedValueReader.readByte());
            }
            if (cls2 == Short.TYPE) {
                return Short.valueOf(encodedValueReader.readShort());
            }
            if (cls2 == Integer.TYPE) {
                return Integer.valueOf(encodedValueReader.readInt());
            }
            if (cls2 == Long.TYPE) {
                return Long.valueOf(encodedValueReader.readLong());
            }
            if (cls2 == Float.TYPE) {
                return Float.valueOf(encodedValueReader.readFloat());
            }
            if (cls2 == Double.TYPE) {
                return Double.valueOf(encodedValueReader.readDouble());
            }
            if (cls2 == Character.TYPE) {
                return Character.valueOf(encodedValueReader.readChar());
            }
            if (cls2 == Boolean.TYPE) {
                return Boolean.valueOf(encodedValueReader.readBoolean());
            }
            throw new AssertionError("Unexpected annotation value type: " + cls2);
        } else {
            try {
                obj = cls2.getDeclaredField(dex.strings().get(dex.fieldIds().get(encodedValueReader.readEnum()).getNameIndex())).get(null);
            } catch (IllegalAccessException e) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e);
                throw illegalAccessError;
            } catch (NoSuchFieldException e2) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e2);
                throw noSuchFieldError;
            }
        }
        return obj;
    }

    private static com.android.dex.Annotation getAnnotation(AnnotatedElement annotatedElement, Class<? extends Annotation> cls) {
        com.android.dex.Annotation annotation;
        int annotationSetOffset = getAnnotationSetOffset(annotatedElement);
        if (annotationSetOffset != 0) {
            Dex dex = getDexClass(annotatedElement).getDex();
            Dex.Section open = dex.open(annotationSetOffset);
            String internalName = InternalNames.getInternalName(cls);
            int readInt = open.readInt();
            for (int i = 0; i < readInt; i++) {
                com.android.dex.Annotation readAnnotation = dex.open(open.readInt()).readAnnotation();
                annotation = readAnnotation;
                if (!dex.typeNames().get(readAnnotation.getTypeIndex()).equals(internalName)) {
                }
            }
            return null;
        }
        annotation = null;
        return annotation;
    }

    public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> cls2) {
        if (cls2 == null) {
            throw new NullPointerException("annotationType == null");
        }
        A a = (A) getDeclaredAnnotation(cls, cls2);
        if (a != null) {
            return a;
        }
        if (!isInherited(cls2)) {
            return null;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (true) {
            Class<? super Object> cls3 = superclass;
            if (cls3 == null) {
                return null;
            }
            A a2 = (A) getDeclaredAnnotation(cls3, cls2);
            if (a2 != null) {
                return a2;
            }
            superclass = cls3.getSuperclass();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Class<? extends Annotation> getAnnotationClass(Class<?> cls, Dex dex, int i) {
        Class<?> cls2;
        try {
            Class<?> dexCacheType = cls.getDexCacheType(dex, i);
            cls2 = dexCacheType;
            if (!dexCacheType.isAnnotation()) {
                throw new IncompatibleClassChangeError("Expected annotation: " + dexCacheType.getName());
            }
        } catch (NoClassDefFoundError e) {
            cls2 = null;
        }
        return cls2;
    }

    private static EncodedValueReader getAnnotationReader(Dex dex, AnnotatedElement annotatedElement, String str, int i) {
        com.android.dex.Annotation annotation;
        EncodedValueReader encodedValueReader;
        int annotationSetOffset = getAnnotationSetOffset(annotatedElement);
        if (annotationSetOffset == 0) {
            encodedValueReader = null;
        } else {
            Dex.Section open = dex.open(annotationSetOffset);
            int i2 = 0;
            int readInt = open.readInt();
            while (true) {
                annotation = null;
                if (i2 >= readInt) {
                    break;
                }
                annotation = dex.open(open.readInt()).readAnnotation();
                if (str.equals(dex.typeNames().get(annotation.getTypeIndex()))) {
                    break;
                }
                i2++;
            }
            if (annotation == null) {
                return null;
            }
            EncodedValueReader reader = annotation.getReader();
            int readAnnotation = reader.readAnnotation();
            if (!dex.typeNames().get(reader.getAnnotationType()).equals(str)) {
                throw new AssertionError();
            }
            encodedValueReader = reader;
            if (readAnnotation != i) {
                return null;
            }
        }
        return encodedValueReader;
    }

    private static int getAnnotationSetOffset(AnnotatedElement annotatedElement) {
        int readInt;
        Class<?> dexClass = getDexClass(annotatedElement);
        int dexAnnotationDirectoryOffset = dexClass.getDexAnnotationDirectoryOffset();
        if (dexAnnotationDirectoryOffset == 0) {
            readInt = 0;
        } else {
            Dex.Section open = dexClass.getDex().open(dexAnnotationDirectoryOffset);
            int readInt2 = open.readInt();
            if (annotatedElement instanceof Class) {
                return readInt2;
            }
            int readInt3 = open.readInt();
            int readInt4 = open.readInt();
            open.readInt();
            if (annotatedElement instanceof Field) {
                int dexFieldIndex = ((Field) annotatedElement).getDexFieldIndex();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt3) {
                        return 0;
                    }
                    int readInt5 = open.readInt();
                    readInt = open.readInt();
                    if (readInt5 == dexFieldIndex) {
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                open.skip(readInt3 * 8);
                int dexMethodIndex = annotatedElement instanceof Method ? ((Method) annotatedElement).getDexMethodIndex() : ((Constructor) annotatedElement).getDexMethodIndex();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= readInt4) {
                        return 0;
                    }
                    int readInt6 = open.readInt();
                    readInt = open.readInt();
                    if (readInt6 == dexMethodIndex) {
                        break;
                    }
                    i3 = i4 + 1;
                }
            }
        }
        return readInt;
    }

    public static Annotation[] getAnnotations(Class<?> cls) {
        HashMap hashMap = new HashMap();
        for (Annotation annotation : getDeclaredAnnotations(cls)) {
            hashMap.put(annotation.annotationType(), annotation);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (true) {
            Class<? super Object> cls2 = superclass;
            if (cls2 == null) {
                Collection values = hashMap.values();
                return (Annotation[]) values.toArray(new Annotation[values.size()]);
            }
            for (Annotation annotation2 : getDeclaredAnnotations(cls2)) {
                Class<? extends Annotation> annotationType = annotation2.annotationType();
                if (!hashMap.containsKey(annotationType) && isInherited(annotationType)) {
                    hashMap.put(annotationType, annotation2);
                }
            }
            superclass = cls2.getSuperclass();
        }
    }

    public static <A extends Annotation> A getDeclaredAnnotation(AnnotatedElement annotatedElement, Class<A> cls) {
        com.android.dex.Annotation annotation = getAnnotation(annotatedElement, cls);
        if (annotation != null) {
            return (A) toAnnotationInstance(getDexClass(annotatedElement), cls, annotation);
        }
        return null;
    }

    public static List<Annotation> getDeclaredAnnotations(AnnotatedElement annotatedElement) {
        return annotationSetToAnnotations(getDexClass(annotatedElement), getAnnotationSetOffset(annotatedElement));
    }

    public static Object getDefaultValue(Method method) {
        Class<?> declaringClass = method.getDeclaringClass();
        Dex dex = declaringClass.getDex();
        EncodedValueReader onlyAnnotationValue = getOnlyAnnotationValue(dex, declaringClass, "Ldalvik/annotation/AnnotationDefault;");
        if (onlyAnnotationValue == null) {
            return null;
        }
        int readAnnotation = onlyAnnotationValue.readAnnotation();
        if (onlyAnnotationValue.getAnnotationType() != declaringClass.getDexTypeIndex()) {
            throw new AssertionError("annotation value type != annotation class");
        }
        int findStringIndex = dex.findStringIndex(method.getName());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readAnnotation) {
                return null;
            }
            if (onlyAnnotationValue.readAnnotationName() == findStringIndex) {
                return decodeValue(declaringClass, method.getReturnType(), dex, onlyAnnotationValue);
            }
            onlyAnnotationValue.skipValue();
            i = i2 + 1;
        }
    }

    private static Class<?> getDexClass(AnnotatedElement annotatedElement) {
        return annotatedElement instanceof Class ? (Class) annotatedElement : ((Member) annotatedElement).getDeclaringClass();
    }

    public static Class<?> getEnclosingClass(Class<?> cls) {
        Dex dex = cls.getDex();
        EncodedValueReader onlyAnnotationValue = getOnlyAnnotationValue(dex, cls, "Ldalvik/annotation/EnclosingClass;");
        if (onlyAnnotationValue == null) {
            return null;
        }
        return cls.getDexCacheType(dex, onlyAnnotationValue.readType());
    }

    public static AccessibleObject getEnclosingMethodOrConstructor(Class<?> cls) {
        Dex dex = cls.getDex();
        EncodedValueReader onlyAnnotationValue = getOnlyAnnotationValue(dex, cls, "Ldalvik/annotation/EnclosingMethod;");
        if (onlyAnnotationValue == null) {
            return null;
        }
        return indexToMethod(cls, dex, onlyAnnotationValue.readMethod());
    }

    public static Class<?>[] getExceptions(AnnotatedElement annotatedElement) {
        Class<?> dexClass = getDexClass(annotatedElement);
        Dex dex = dexClass.getDex();
        EncodedValueReader onlyAnnotationValue = getOnlyAnnotationValue(dex, annotatedElement, "Ldalvik/annotation/Throws;");
        return onlyAnnotationValue == null ? EmptyArray.CLASS : (Class[]) decodeValue(dexClass, Class[].class, dex, onlyAnnotationValue);
    }

    public static int getInnerClassFlags(Class<?> cls, int i) {
        EncodedValueReader annotationReader = getAnnotationReader(cls.getDex(), cls, "Ldalvik/annotation/InnerClass;", 2);
        if (annotationReader == null) {
            return i;
        }
        annotationReader.readAnnotationName();
        return annotationReader.readInt();
    }

    public static String getInnerClassName(Class<?> cls) {
        Dex dex = cls.getDex();
        EncodedValueReader annotationReader = getAnnotationReader(dex, cls, "Ldalvik/annotation/InnerClass;", 2);
        if (annotationReader == null) {
            return null;
        }
        annotationReader.readAnnotationName();
        annotationReader.readInt();
        annotationReader.readAnnotationName();
        if (annotationReader.peek() != 30) {
            return (String) decodeValue(cls, String.class, dex, annotationReader);
        }
        return null;
    }

    public static Class<?>[] getMemberClasses(Class<?> cls) {
        Dex dex = cls.getDex();
        EncodedValueReader onlyAnnotationValue = getOnlyAnnotationValue(dex, cls, "Ldalvik/annotation/MemberClasses;");
        return onlyAnnotationValue == null ? EmptyArray.CLASS : (Class[]) decodeValue(cls, Class[].class, dex, onlyAnnotationValue);
    }

    private static EncodedValueReader getOnlyAnnotationValue(Dex dex, AnnotatedElement annotatedElement, String str) {
        EncodedValueReader annotationReader = getAnnotationReader(dex, annotatedElement, str, 1);
        if (annotationReader == null) {
            return null;
        }
        annotationReader.readAnnotationName();
        return annotationReader;
    }

    /* JADX WARN: Type inference failed for: r0v46, types: [java.lang.annotation.Annotation[], java.lang.annotation.Annotation[][]] */
    public static Annotation[][] getParameterAnnotations(Class<?> cls, int i) {
        Dex dex = cls.getDex();
        int length = dex.readTypeList(dex.protoIds().get(dex.methodIds().get(i).getProtoIndex()).getParametersOffset()).getTypes().length;
        int dexAnnotationDirectoryOffset = cls.getDexAnnotationDirectoryOffset();
        if (dexAnnotationDirectoryOffset == 0) {
            return (Annotation[][]) Array.newInstance(Annotation.class, length, 0);
        }
        Dex.Section open = dex.open(dexAnnotationDirectoryOffset);
        open.readInt();
        int readInt = open.readInt();
        int readInt2 = open.readInt();
        int readInt3 = open.readInt();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= readInt) {
                break;
            }
            open.readInt();
            open.readInt();
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= readInt2) {
                break;
            }
            open.readInt();
            open.readInt();
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= readInt3) {
                return (Annotation[][]) Array.newInstance(Annotation.class, length, 0);
            }
            int readInt4 = open.readInt();
            int readInt5 = open.readInt();
            if (readInt4 != i) {
                i6 = i7 + 1;
            } else {
                Dex.Section open2 = dex.open(readInt5);
                int readInt6 = open2.readInt();
                ?? r0 = new Annotation[readInt6];
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    if (i9 >= readInt6) {
                        return r0;
                    }
                    List<Annotation> annotationSetToAnnotations = annotationSetToAnnotations(cls, open2.readInt());
                    r0[i9] = (Annotation[]) annotationSetToAnnotations.toArray(new Annotation[annotationSetToAnnotations.size()]);
                    i8 = i9 + 1;
                }
            }
        }
    }

    public static String getSignature(AnnotatedElement annotatedElement) {
        Class<?> dexClass = getDexClass(annotatedElement);
        Dex dex = dexClass.getDex();
        EncodedValueReader onlyAnnotationValue = getOnlyAnnotationValue(dex, annotatedElement, "Ldalvik/annotation/Signature;");
        if (onlyAnnotationValue == null) {
            return null;
        }
        String[] strArr = (String[]) decodeValue(dexClass, String[].class, dex, onlyAnnotationValue);
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            sb.append(strArr[i2]);
            i = i2 + 1;
        }
    }

    private static AccessibleObject indexToMethod(Class<?> cls, Dex dex, int i) {
        Class<?> dexCacheType = cls.getDexCacheType(dex, dex.declaringClassIndexFromMethodIndex(i));
        String dexCacheString = cls.getDexCacheString(dex, dex.nameIndexFromMethodIndex(i));
        short[] parameterTypeIndicesFromMethodIndex = dex.parameterTypeIndicesFromMethodIndex(i);
        Class<?>[] clsArr = new Class[parameterTypeIndicesFromMethodIndex.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= parameterTypeIndicesFromMethodIndex.length) {
                try {
                    break;
                } catch (NoSuchMethodException e) {
                    throw new IncompatibleClassChangeError("Couldn't find " + dexCacheType.getName() + "." + dexCacheString + Arrays.toString(clsArr));
                }
            }
            clsArr[i3] = cls.getDexCacheType(dex, parameterTypeIndicesFromMethodIndex[i3]);
            i2 = i3 + 1;
        }
        return dexCacheString.equals("<init>") ? dexCacheType.getDeclaredConstructor(clsArr) : dexCacheType.getDeclaredMethod(dexCacheString, clsArr);
    }

    public static boolean isAnnotationPresent(Class<?> cls, Class<? extends Annotation> cls2) {
        if (cls2 == null) {
            throw new NullPointerException("annotationType == null");
        }
        if (isDeclaredAnnotationPresent(cls, cls2)) {
            return true;
        }
        if (!isInherited(cls2)) {
            return false;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (true) {
            Class<? super Object> cls3 = superclass;
            if (cls3 == null) {
                return false;
            }
            if (isDeclaredAnnotationPresent(cls3, cls2)) {
                return true;
            }
            superclass = cls3.getSuperclass();
        }
    }

    public static boolean isAnonymousClass(Class<?> cls) {
        EncodedValueReader annotationReader = getAnnotationReader(cls.getDex(), cls, "Ldalvik/annotation/InnerClass;", 2);
        if (annotationReader == null) {
            return false;
        }
        annotationReader.readAnnotationName();
        annotationReader.readInt();
        annotationReader.readAnnotationName();
        return annotationReader.peek() == 30;
    }

    public static boolean isDeclaredAnnotationPresent(AnnotatedElement annotatedElement, Class<? extends Annotation> cls) {
        return getAnnotation(annotatedElement, cls) != null;
    }

    private static boolean isInherited(Class<? extends Annotation> cls) {
        return isDeclaredAnnotationPresent(cls, Inherited.class);
    }

    private static <A extends Annotation> A toAnnotationInstance(Class<?> cls, Dex dex, Class<A> cls2, EncodedValueReader encodedValueReader) {
        int readAnnotation = encodedValueReader.readAnnotation();
        if (cls2 != cls.getDexCacheType(dex, encodedValueReader.getAnnotationType())) {
            throw new AssertionError("annotation value type != return type");
        }
        AnnotationMember[] annotationMemberArr = new AnnotationMember[readAnnotation];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readAnnotation) {
                return (A) AnnotationFactory.createAnnotation(cls2, annotationMemberArr);
            }
            String str = dex.strings().get(encodedValueReader.readAnnotationName());
            try {
                Method method = cls2.getMethod(str, NO_ARGUMENTS);
                Class<?> returnType = method.getReturnType();
                annotationMemberArr[i2] = new AnnotationMember(str, decodeValue(cls, returnType, dex, encodedValueReader), returnType, method);
                i = i2 + 1;
            } catch (NoSuchMethodException e) {
                throw new IncompatibleClassChangeError("Couldn't find " + cls2.getName() + "." + str);
            }
        }
    }

    private static <A extends Annotation> A toAnnotationInstance(Class<?> cls, Class<A> cls2, com.android.dex.Annotation annotation) {
        return (A) toAnnotationInstance(cls, cls.getDex(), cls2, annotation.getReader());
    }
}
