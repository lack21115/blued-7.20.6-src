package java.lang;

import com.android.dex.Dex;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import dalvik.system.VMStack;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.ArtField;
import java.lang.reflect.ArtMethod;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import libcore.reflect.AnnotationAccess;
import libcore.reflect.GenericSignatureParser;
import libcore.reflect.InternalNames;
import libcore.reflect.Types;
import libcore.util.BasicLruCache;
import libcore.util.CollectionUtils;
import libcore.util.EmptyArray;
import libcore.util.SneakyThrow;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Class.class */
public final class Class<T> implements Serializable, AnnotatedElement, GenericDeclaration, Type {
    private static final long serialVersionUID = 3206093459760846163L;
    private transient int accessFlags;
    private transient ClassLoader classLoader;
    private transient int classSize;
    private transient int clinitThreadId;
    private transient Class<?> componentType;
    private transient DexCache dexCache;
    private transient String[] dexCacheStrings;
    private transient int dexClassDefIndex;
    private volatile transient int dexTypeIndex;
    private transient ArtMethod[] directMethods;
    private transient ArtField[] iFields;
    private transient Object[] ifTable;
    private transient String name;
    private transient int numReferenceInstanceFields;
    private transient int numReferenceStaticFields;
    private transient int objectSize;
    private transient int primitiveType;
    private transient int referenceInstanceOffsets;
    private transient int referenceStaticOffsets;
    private transient ArtField[] sFields;
    private transient int status;
    private transient Class<? super T> superClass;
    private transient Class<?> verifyErrorClass;
    private transient ArtMethod[] virtualMethods;
    private transient ArtMethod[] vtable;

    /* loaded from: source-2895416-dex2jar.jar:java/lang/Class$Caches.class */
    private static class Caches {
        private static final BasicLruCache<Class, Type[]> genericInterfaces = new BasicLruCache<>(8);

        private Caches() {
        }
    }

    private Class() {
    }

    private boolean canAccess(Class<?> cls) {
        if (Modifier.isPublic(cls.accessFlags)) {
            return true;
        }
        return inSamePackage(cls);
    }

    private boolean canAccessMember(Class<?> cls, int i) {
        if (cls == this || Modifier.isPublic(i)) {
            return true;
        }
        if (Modifier.isPrivate(i)) {
            return false;
        }
        if (Modifier.isProtected(i)) {
            Class<?> cls2 = this.superClass;
            while (true) {
                Class<?> cls3 = cls2;
                if (cls3 == null) {
                    break;
                } else if (cls3 == cls) {
                    return true;
                } else {
                    cls2 = cls3.superClass;
                }
            }
        }
        return inSamePackage(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native Class<?> classForName(String str, boolean z, ClassLoader classLoader) throws ClassNotFoundException;

    private boolean classNameImpliesTopLevel() {
        return !getName().contains("$");
    }

    private static ArtField findByName(String str, ArtField[] artFieldArr) {
        int i = 0;
        int length = artFieldArr.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            ArtField artField = artFieldArr[i2];
            int compareTo = artField.getName().compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo == 0) {
                return artField;
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public static Class<?> forName(String str) throws ClassNotFoundException {
        return forName(str, true, VMStack.getCallingClassLoader());
    }

    public static Class<?> forName(String str, boolean z, ClassLoader classLoader) throws ClassNotFoundException {
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = ClassLoader.getSystemClassLoader();
        }
        try {
            return classForName(str, z, classLoader2);
        } catch (ClassNotFoundException e) {
            Throwable cause = e.getCause();
            if (cause instanceof LinkageError) {
                throw ((LinkageError) cause);
            }
            throw e;
        }
    }

    private Constructor<T> getConstructor(Class<?>[] clsArr, boolean z) throws NoSuchMethodException {
        Class<?>[] clsArr2 = clsArr;
        if (clsArr == null) {
            clsArr2 = EmptyArray.CLASS;
        }
        int length = clsArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Constructor<T> declaredConstructorInternal = getDeclaredConstructorInternal(clsArr2);
                if (declaredConstructorInternal == null || (z && !Modifier.isPublic(declaredConstructorInternal.getAccessFlags()))) {
                    throw new NoSuchMethodException("<init> " + Arrays.toString(clsArr2));
                }
                return declaredConstructorInternal;
            } else if (clsArr2[i2] == null) {
                throw new NoSuchMethodException("parameter type is null");
            } else {
                i = i2 + 1;
            }
        }
    }

    private Constructor<T> getDeclaredConstructorInternal(Class<?>[] clsArr) {
        if (this.directMethods == null) {
            return null;
        }
        ArtMethod[] artMethodArr = this.directMethods;
        int length = artMethodArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            ArtMethod artMethod = artMethodArr[i2];
            int accessFlags = artMethod.getAccessFlags();
            if (!Modifier.isStatic(accessFlags) && Modifier.isConstructor(accessFlags) && ArtMethod.equalConstructorParameters(artMethod, clsArr)) {
                return new Constructor<>(artMethod);
            }
            i = i2 + 1;
        }
    }

    private void getDeclaredConstructors(boolean z, List<Constructor<T>> list) {
        if (this.directMethods == null) {
            return;
        }
        ArtMethod[] artMethodArr = this.directMethods;
        int length = artMethodArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            ArtMethod artMethod = artMethodArr[i2];
            int accessFlags = artMethod.getAccessFlags();
            if ((!z || Modifier.isPublic(accessFlags)) && !Modifier.isStatic(accessFlags) && Modifier.isConstructor(accessFlags)) {
                list.add(new Constructor<>(artMethod));
            }
            i = i2 + 1;
        }
    }

    private Field getDeclaredFieldInternal(String str) {
        ArtField findByName;
        ArtField findByName2;
        if (this.iFields == null || (findByName2 = findByName(str, this.iFields)) == null) {
            if (this.sFields == null || (findByName = findByName(str, this.sFields)) == null) {
                return null;
            }
            return new Field(findByName);
        }
        return new Field(findByName2);
    }

    private Method getDeclaredMethodInternal(String str, Class<?>[] clsArr) {
        ArtMethod artMethod;
        ArtMethod artMethod2;
        ArtMethod artMethod3 = null;
        ArtMethod artMethod4 = null;
        if (this.virtualMethods != null) {
            ArtMethod[] artMethodArr = this.virtualMethods;
            int length = artMethodArr.length;
            int i = 0;
            while (true) {
                artMethod3 = artMethod4;
                if (i >= length) {
                    break;
                }
                ArtMethod artMethod5 = artMethodArr[i];
                if (str.equals(ArtMethod.getMethodName(artMethod5))) {
                    artMethod2 = artMethod4;
                    if (ArtMethod.equalMethodParameters(artMethod5, clsArr)) {
                        int accessFlags = artMethod5.getAccessFlags();
                        if ((accessFlags & 2101248) == 0) {
                            return new Method(artMethod5);
                        }
                        artMethod2 = artMethod4;
                        if ((2097152 & accessFlags) == 0) {
                            artMethod2 = artMethod5;
                        }
                    } else {
                        continue;
                    }
                } else {
                    artMethod2 = artMethod4;
                }
                i++;
                artMethod4 = artMethod2;
            }
        }
        ArtMethod artMethod6 = artMethod3;
        if (artMethod3 == null) {
            artMethod6 = artMethod3;
            if (this.directMethods != null) {
                ArtMethod[] artMethodArr2 = this.directMethods;
                int length2 = artMethodArr2.length;
                int i2 = 0;
                while (true) {
                    artMethod6 = artMethod3;
                    if (i2 >= length2) {
                        break;
                    }
                    ArtMethod artMethod7 = artMethodArr2[i2];
                    int accessFlags2 = artMethod7.getAccessFlags();
                    if (Modifier.isConstructor(accessFlags2)) {
                        artMethod = artMethod3;
                    } else {
                        artMethod = artMethod3;
                        if (str.equals(ArtMethod.getMethodName(artMethod7))) {
                            artMethod = artMethod3;
                            if (!ArtMethod.equalMethodParameters(artMethod7, clsArr)) {
                                continue;
                            } else if ((accessFlags2 & 2101248) == 0) {
                                return new Method(artMethod7);
                            } else {
                                artMethod = artMethod7;
                            }
                        } else {
                            continue;
                        }
                    }
                    i2++;
                    artMethod3 = artMethod;
                }
            }
        }
        if (artMethod6 == null) {
            return null;
        }
        return new Method(artMethod6);
    }

    private String getInnerClassName() {
        return AnnotationAccess.getInnerClassName(this);
    }

    private Method getMethod(String str, Class<?>[] clsArr, boolean z) throws NoSuchMethodException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        Class<?>[] clsArr2 = clsArr;
        if (clsArr == null) {
            clsArr2 = EmptyArray.CLASS;
        }
        int length = clsArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Method publicMethodRecursive = z ? getPublicMethodRecursive(str, clsArr2) : getDeclaredMethodInternal(str, clsArr2);
                if (publicMethodRecursive == null || (z && !Modifier.isPublic(publicMethodRecursive.getAccessFlags()))) {
                    throw new NoSuchMethodException(str + " " + Arrays.toString(clsArr2));
                }
                return publicMethodRecursive;
            } else if (clsArr2[i2] == null) {
                throw new NoSuchMethodException("parameter type is null");
            } else {
                i = i2 + 1;
            }
        }
    }

    private native String getNameNative();

    private native Class<?>[] getProxyInterfaces();

    private Field getPublicFieldRecursive(String str) {
        Field field;
        Class cls = this;
        while (true) {
            Class cls2 = cls;
            if (cls2 != null) {
                Field declaredFieldInternal = cls2.getDeclaredFieldInternal(str);
                if (declaredFieldInternal != null && (declaredFieldInternal.getModifiers() & 1) != 0) {
                    field = declaredFieldInternal;
                    break;
                }
                cls = cls2.superClass;
            } else if (this.ifTable == null) {
                return null;
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.ifTable.length) {
                        return null;
                    }
                    Field publicFieldRecursive = ((Class) this.ifTable[i2]).getPublicFieldRecursive(str);
                    if (publicFieldRecursive != null) {
                        field = publicFieldRecursive;
                        if ((publicFieldRecursive.getModifiers() & 1) != 0) {
                            break;
                        }
                    }
                    i = i2 + 2;
                }
            }
        }
        return field;
    }

    private void getPublicFieldsRecursive(List<Field> list) {
        Class cls = this;
        while (true) {
            Class cls2 = cls;
            if (cls2 == null) {
                break;
            }
            cls2.getDeclaredFieldsUnchecked(true, list);
            cls = cls2.superClass;
        }
        Object[] objArr = this.ifTable;
        if (objArr == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return;
            }
            ((Class) objArr[i2]).getDeclaredFieldsUnchecked(true, list);
            i = i2 + 2;
        }
    }

    private Method getPublicMethodRecursive(String str, Class<?>[] clsArr) {
        Method method;
        Class<T> cls = this;
        while (true) {
            Class<T> cls2 = cls;
            if (cls2 != null) {
                Method declaredMethodInternal = cls2.getDeclaredMethodInternal(str, clsArr);
                if (declaredMethodInternal != null && Modifier.isPublic(declaredMethodInternal.getAccessFlags())) {
                    method = declaredMethodInternal;
                    break;
                }
                cls = cls2.getSuperclass();
            } else {
                Object[] objArr = this.ifTable;
                if (objArr == null) {
                    return null;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= objArr.length) {
                        return null;
                    }
                    Method publicMethodRecursive = ((Class) objArr[i2]).getPublicMethodRecursive(str, clsArr);
                    if (publicMethodRecursive != null) {
                        method = publicMethodRecursive;
                        if (Modifier.isPublic(publicMethodRecursive.getAccessFlags())) {
                            break;
                        }
                    }
                    i = i2 + 2;
                }
            }
        }
        return method;
    }

    private void getPublicMethodsInternal(List<Method> list) {
        getDeclaredMethodsUnchecked(true, list);
        if (!isInterface()) {
            Class<? super T> cls = this.superClass;
            while (true) {
                Class<? super T> cls2 = cls;
                if (cls2 == null) {
                    break;
                }
                cls2.getDeclaredMethodsUnchecked(true, list);
                cls = cls2.superClass;
            }
        }
        Object[] objArr = this.ifTable;
        if (objArr == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return;
            }
            ((Class) objArr[i2]).getDeclaredMethodsUnchecked(true, list);
            i = i2 + 2;
        }
    }

    private boolean inSamePackage(Class<?> cls) {
        if (this.classLoader != cls.classLoader) {
            return false;
        }
        String packageName$ = getPackageName$();
        String packageName$2 = cls.getPackageName$();
        if (packageName$ == null) {
            return packageName$2 == null;
        } else if (packageName$2 != null) {
            return packageName$.equals(packageName$2);
        } else {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <U> Class<? extends U> asSubclass(Class<U> cls) {
        if (cls.isAssignableFrom(this)) {
            return this;
        }
        String name = getName();
        throw new ClassCastException(name + " cannot be cast to " + cls.getName());
    }

    public T cast(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            obj2 = obj;
            if (!isInstance(obj)) {
                throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + getName());
            }
        }
        return (T) obj2;
    }

    public boolean desiredAssertionStatus() {
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) AnnotationAccess.getAnnotation((Class<?>) this, (Class<Annotation>) cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return AnnotationAccess.getAnnotations(this);
    }

    public String getCanonicalName() {
        if (isLocalClass() || isAnonymousClass()) {
            return null;
        }
        if (isArray()) {
            String canonicalName = getComponentType().getCanonicalName();
            if (canonicalName != null) {
                return canonicalName + "[]";
            }
            return null;
        } else if (isMemberClass()) {
            String canonicalName2 = getDeclaringClass().getCanonicalName();
            if (canonicalName2 != null) {
                return canonicalName2 + "." + getSimpleName();
            }
            return null;
        } else {
            return getName();
        }
    }

    public ClassLoader getClassLoader() {
        ClassLoader classLoader;
        if (isPrimitive()) {
            classLoader = null;
        } else {
            ClassLoader classLoaderImpl = getClassLoaderImpl();
            classLoader = classLoaderImpl;
            if (classLoaderImpl == null) {
                return BootClassLoader.getInstance();
            }
        }
        return classLoader;
    }

    ClassLoader getClassLoaderImpl() {
        ClassLoader classLoader = this.classLoader;
        BootClassLoader bootClassLoader = classLoader;
        if (classLoader == null) {
            bootClassLoader = BootClassLoader.getInstance();
        }
        return bootClassLoader;
    }

    public Class<?>[] getClasses() {
        ArrayList arrayList = new ArrayList();
        Class cls = this;
        while (true) {
            Class cls2 = cls;
            if (cls2 == null) {
                return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
            }
            Class<?>[] declaredClasses = cls2.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    Class<?> cls3 = declaredClasses[i2];
                    if (Modifier.isPublic(cls3.getModifiers())) {
                        arrayList.add(cls3);
                    }
                    i = i2 + 1;
                }
            }
            cls = cls2.superClass;
        }
    }

    public Class<?> getComponentType() {
        return this.componentType;
    }

    public Constructor<T> getConstructor(Class<?>... clsArr) throws NoSuchMethodException {
        return getConstructor(clsArr, true);
    }

    public Constructor<?>[] getConstructors() {
        List<Constructor<T>> arrayList = new ArrayList<>();
        getDeclaredConstructors(true, arrayList);
        return (Constructor[]) arrayList.toArray(new Constructor[arrayList.size()]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        List<Annotation> declaredAnnotations = AnnotationAccess.getDeclaredAnnotations(this);
        return (Annotation[]) declaredAnnotations.toArray(new Annotation[declaredAnnotations.size()]);
    }

    public Class<?>[] getDeclaredClasses() {
        return AnnotationAccess.getMemberClasses(this);
    }

    public Constructor<T> getDeclaredConstructor(Class<?>... clsArr) throws NoSuchMethodException {
        return getConstructor(clsArr, false);
    }

    public Constructor<?>[] getDeclaredConstructors() {
        List<Constructor<T>> arrayList = new ArrayList<>();
        getDeclaredConstructors(false, arrayList);
        return (Constructor[]) arrayList.toArray(new Constructor[arrayList.size()]);
    }

    public Field getDeclaredField(String str) throws NoSuchFieldException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        Field declaredFieldInternal = getDeclaredFieldInternal(str);
        if (declaredFieldInternal == null) {
            throw new NoSuchFieldException(str);
        }
        declaredFieldInternal.getType();
        return declaredFieldInternal;
    }

    public Field[] getDeclaredFields() {
        List<Field> arrayList = new ArrayList<>((this.sFields == null ? 0 : this.sFields.length) + (this.iFields == null ? 0 : this.iFields.length));
        getDeclaredFieldsUnchecked(false, arrayList);
        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[arrayList.size()]);
        int length = fieldArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return fieldArr;
            }
            fieldArr[i2].getType();
            i = i2 + 1;
        }
    }

    public void getDeclaredFieldsUnchecked(boolean z, List<Field> list) {
        if (this.iFields != null) {
            ArtField[] artFieldArr = this.iFields;
            int length = artFieldArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                ArtField artField = artFieldArr[i2];
                if (!z || Modifier.isPublic(artField.getAccessFlags())) {
                    list.add(new Field(artField));
                }
                i = i2 + 1;
            }
        }
        if (this.sFields == null) {
            return;
        }
        ArtField[] artFieldArr2 = this.sFields;
        int length2 = artFieldArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            ArtField artField2 = artFieldArr2[i4];
            if (!z || Modifier.isPublic(artField2.getAccessFlags())) {
                list.add(new Field(artField2));
            }
            i3 = i4 + 1;
        }
    }

    public Method getDeclaredMethod(String str, Class<?>... clsArr) throws NoSuchMethodException {
        return getMethod(str, clsArr, false);
    }

    public Method[] getDeclaredMethods() {
        List<Method> arrayList = new ArrayList<>((this.virtualMethods == null ? 0 : this.virtualMethods.length) + (this.directMethods == null ? 0 : this.directMethods.length));
        getDeclaredMethodsUnchecked(false, arrayList);
        Method[] methodArr = (Method[]) arrayList.toArray(new Method[arrayList.size()]);
        int length = methodArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return methodArr;
            }
            Method method = methodArr[i2];
            method.getReturnType();
            method.getParameterTypes();
            i = i2 + 1;
        }
    }

    public void getDeclaredMethodsUnchecked(boolean z, List<Method> list) {
        if (this.virtualMethods != null) {
            ArtMethod[] artMethodArr = this.virtualMethods;
            int length = artMethodArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                ArtMethod artMethod = artMethodArr[i2];
                int accessFlags = artMethod.getAccessFlags();
                if ((!z || Modifier.isPublic(accessFlags)) && (2097152 & accessFlags) == 0) {
                    list.add(new Method(artMethod));
                }
                i = i2 + 1;
            }
        }
        if (this.directMethods == null) {
            return;
        }
        ArtMethod[] artMethodArr2 = this.directMethods;
        int length2 = artMethodArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            ArtMethod artMethod2 = artMethodArr2[i4];
            int accessFlags2 = artMethod2.getAccessFlags();
            if ((!z || Modifier.isPublic(accessFlags2)) && !Modifier.isConstructor(accessFlags2)) {
                list.add(new Method(artMethod2));
            }
            i3 = i4 + 1;
        }
    }

    public Class<?> getDeclaringClass() {
        if (AnnotationAccess.isAnonymousClass(this)) {
            return null;
        }
        return AnnotationAccess.getEnclosingClass(this);
    }

    public Dex getDex() {
        if (this.dexCache == null) {
            return null;
        }
        return this.dexCache.getDex();
    }

    public int getDexAnnotationDirectoryOffset() {
        int dexClassDefIndex;
        Dex dex = getDex();
        if (dex != null && (dexClassDefIndex = getDexClassDefIndex()) >= 0) {
            return dex.annotationDirectoryOffsetFromClassDefIndex(dexClassDefIndex);
        }
        return 0;
    }

    public String getDexCacheString(Dex dex, int i) {
        String str = this.dexCacheStrings[i];
        String str2 = str;
        if (str == null) {
            str2 = dex.strings().get(i).intern();
            this.dexCacheStrings[i] = str2;
        }
        return str2;
    }

    public Class<?> getDexCacheType(Dex dex, int i) {
        Class<?>[] clsArr = this.dexCache.resolvedTypes;
        Class<?> cls = clsArr[i];
        Class<?> cls2 = cls;
        if (cls == null) {
            cls2 = InternalNames.getClass(getClassLoader(), getDexCacheString(dex, dex.typeIds().get(i).intValue()));
            clsArr[i] = cls2;
        }
        return cls2;
    }

    public int getDexClassDefIndex() {
        if (this.dexClassDefIndex == 65535) {
            return -1;
        }
        return this.dexClassDefIndex;
    }

    public int getDexTypeIndex() {
        int i;
        int i2 = this.dexTypeIndex;
        if (i2 != 65535) {
            return i2;
        }
        synchronized (this) {
            int i3 = this.dexTypeIndex;
            i = i3;
            if (i3 == 65535) {
                if (this.dexClassDefIndex >= 0) {
                    i = getDex().typeIndexFromClassDefIndex(this.dexClassDefIndex);
                } else {
                    int findTypeIndex = getDex().findTypeIndex(InternalNames.getInternalName(this));
                    i = findTypeIndex;
                    if (findTypeIndex < 0) {
                        i = -1;
                    }
                }
                this.dexTypeIndex = i;
            }
        }
        return i;
    }

    public Class<?> getEnclosingClass() {
        Class<?> declaringClass = getDeclaringClass();
        if (declaringClass != null) {
            return declaringClass;
        }
        AccessibleObject enclosingMethodOrConstructor = AnnotationAccess.getEnclosingMethodOrConstructor(this);
        return enclosingMethodOrConstructor != null ? ((Member) enclosingMethodOrConstructor).getDeclaringClass() : AnnotationAccess.getEnclosingClass(this);
    }

    public Constructor<?> getEnclosingConstructor() {
        if (classNameImpliesTopLevel()) {
            return null;
        }
        AccessibleObject enclosingMethodOrConstructor = AnnotationAccess.getEnclosingMethodOrConstructor(this);
        return enclosingMethodOrConstructor instanceof Constructor ? (Constructor) enclosingMethodOrConstructor : null;
    }

    public Method getEnclosingMethod() {
        if (classNameImpliesTopLevel()) {
            return null;
        }
        AccessibleObject enclosingMethodOrConstructor = AnnotationAccess.getEnclosingMethodOrConstructor(this);
        return enclosingMethodOrConstructor instanceof Method ? (Method) enclosingMethodOrConstructor : null;
    }

    public T[] getEnumConstants() {
        if (isEnum()) {
            return (T[]) ((Object[]) Enum.getSharedConstants(this).clone());
        }
        return null;
    }

    public Field getField(String str) throws NoSuchFieldException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        Field publicFieldRecursive = getPublicFieldRecursive(str);
        if (publicFieldRecursive == null) {
            throw new NoSuchFieldException(str);
        }
        publicFieldRecursive.getType();
        return publicFieldRecursive;
    }

    public Field[] getFields() {
        List<Field> arrayList = new ArrayList<>();
        getPublicFieldsRecursive(arrayList);
        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[arrayList.size()]);
        int length = fieldArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return fieldArr;
            }
            fieldArr[i2].getType();
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.reflect.Type[]] */
    public Type[] getGenericInterfaces() {
        Class<?>[] clsArr;
        synchronized (Caches.genericInterfaces) {
            ?? r0 = (Type[]) Caches.genericInterfaces.get(this);
            clsArr = r0;
            if (r0 == 0) {
                String signature = AnnotationAccess.getSignature(this);
                if (signature == null) {
                    clsArr = getInterfaces();
                } else {
                    GenericSignatureParser genericSignatureParser = new GenericSignatureParser(getClassLoader());
                    genericSignatureParser.parseForClass(this, signature);
                    clsArr = Types.getTypeArray(genericSignatureParser.interfaceTypes, false);
                }
                Caches.genericInterfaces.put(this, clsArr);
            }
        }
        return clsArr.length == 0 ? clsArr : (Type[]) clsArr.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.reflect.Type] */
    public Type getGenericSuperclass() {
        Class<? super T> superclass = getSuperclass();
        if (superclass == null) {
            return null;
        }
        String signature = AnnotationAccess.getSignature(this);
        if (signature != null) {
            GenericSignatureParser genericSignatureParser = new GenericSignatureParser(getClassLoader());
            genericSignatureParser.parseForClass(this, signature);
            superclass = genericSignatureParser.superclassType;
        }
        return Types.getType(superclass);
    }

    public Class<?>[] getInterfaces() {
        Class<?>[] clsArr;
        if (!isArray()) {
            if (!isProxy()) {
                Dex dex = getDex();
                if (dex != null) {
                    short[] interfaceTypeIndicesFromClassDefIndex = dex.interfaceTypeIndicesFromClassDefIndex(this.dexClassDefIndex);
                    Class<?>[] clsArr2 = new Class[interfaceTypeIndicesFromClassDefIndex.length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        clsArr = clsArr2;
                        if (i2 >= interfaceTypeIndicesFromClassDefIndex.length) {
                            break;
                        }
                        clsArr2[i2] = getDexCacheType(dex, interfaceTypeIndicesFromClassDefIndex[i2]);
                        i = i2 + 1;
                    }
                } else {
                    return EmptyArray.CLASS;
                }
            } else {
                return getProxyInterfaces();
            }
        } else {
            clsArr = new Class[]{Cloneable.class, Serializable.class};
        }
        return clsArr;
    }

    public Method getMethod(String str, Class<?>... clsArr) throws NoSuchMethodException {
        return getMethod(str, clsArr, true);
    }

    public Method[] getMethods() {
        List<Method> arrayList = new ArrayList<>();
        getPublicMethodsInternal(arrayList);
        CollectionUtils.removeDuplicates(arrayList, Method.ORDER_BY_SIGNATURE);
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    public int getModifiers() {
        if (isArray()) {
            int modifiers = getComponentType().getModifiers();
            int i = modifiers;
            if ((modifiers & 512) != 0) {
                i = modifiers & (-521);
            }
            return i | 1040;
        }
        return AnnotationAccess.getInnerClassFlags(this, this.accessFlags & 65535) & 65535;
    }

    public String getName() {
        String str = this.name;
        String str2 = str;
        if (str == null) {
            str2 = getNameNative();
            this.name = str2;
        }
        return str2;
    }

    public Package getPackage() {
        ClassLoader classLoader = getClassLoader();
        Package r4 = null;
        if (classLoader != null) {
            String packageName$ = getPackageName$();
            r4 = null;
            if (packageName$ != null) {
                r4 = classLoader.getPackage(packageName$);
            }
        }
        return r4;
    }

    public String getPackageName$() {
        String name = getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return null;
        }
        return name.substring(0, lastIndexOf);
    }

    public ProtectionDomain getProtectionDomain() {
        return null;
    }

    public URL getResource(String str) {
        String name;
        int lastIndexOf;
        String str2;
        if (str.startsWith(BridgeUtil.SPLIT_MARK)) {
            str2 = str.substring(1);
        } else {
            str2 = (getName().lastIndexOf(46) != -1 ? name.substring(0, lastIndexOf).replace('.', '/') : "") + BridgeUtil.SPLIT_MARK + str;
        }
        ClassLoader classLoader = getClassLoader();
        return classLoader != null ? classLoader.getResource(str2) : ClassLoader.getSystemResource(str2);
    }

    public InputStream getResourceAsStream(String str) {
        String name;
        int lastIndexOf;
        String str2;
        if (str.startsWith(BridgeUtil.SPLIT_MARK)) {
            str2 = str.substring(1);
        } else {
            str2 = (getName().lastIndexOf(46) != -1 ? name.substring(0, lastIndexOf).replace('.', '/') : "") + BridgeUtil.SPLIT_MARK + str;
        }
        ClassLoader classLoader = getClassLoader();
        return classLoader != null ? classLoader.getResourceAsStream(str2) : ClassLoader.getSystemResourceAsStream(str2);
    }

    public Object[] getSigners() {
        return null;
    }

    public String getSimpleName() {
        String str;
        if (isArray()) {
            str = getComponentType().getSimpleName() + "[]";
        } else if (isAnonymousClass()) {
            return "";
        } else {
            if (isMemberClass() || isLocalClass()) {
                return getInnerClassName();
            }
            String name = getName();
            int lastIndexOf = name.lastIndexOf(46);
            str = name;
            if (lastIndexOf != -1) {
                return name.substring(lastIndexOf + 1);
            }
        }
        return str;
    }

    public Class<? super T> getSuperclass() {
        if (isInterface()) {
            return null;
        }
        return this.superClass;
    }

    @Override // java.lang.reflect.GenericDeclaration
    public TypeVariable<Class<T>>[] getTypeParameters() {
        TypeVariable<Class<T>>[] typeVariableArr;
        synchronized (this) {
            String signature = AnnotationAccess.getSignature(this);
            if (signature == null) {
                typeVariableArr = EmptyArray.TYPE_VARIABLE;
            } else {
                GenericSignatureParser genericSignatureParser = new GenericSignatureParser(getClassLoader());
                genericSignatureParser.parseForClass(this, signature);
                typeVariableArr = genericSignatureParser.formalTypeParameters;
            }
        }
        return typeVariableArr;
    }

    public boolean isAnnotation() {
        return (this.accessFlags & 8192) != 0;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return AnnotationAccess.isAnnotationPresent(this, cls);
    }

    public boolean isAnonymousClass() {
        return AnnotationAccess.isAnonymousClass(this);
    }

    public boolean isArray() {
        return getComponentType() != null;
    }

    public boolean isAssignableFrom(Class<?> cls) {
        if (this == cls) {
            return true;
        }
        if (this == Object.class) {
            return !cls.isPrimitive();
        } else if (isArray()) {
            return cls.isArray() && this.componentType.isAssignableFrom(cls.componentType);
        } else if (isInterface()) {
            Object[] objArr = cls.ifTable;
            if (objArr == null) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= objArr.length) {
                    return false;
                }
                if (((Class) objArr[i2]) == this) {
                    return true;
                }
                i = i2 + 2;
            }
        } else if (cls.isInterface()) {
            return false;
        } else {
            Class<? super T> cls2 = (Class<? super T>) cls.superClass;
            while (true) {
                Class<? super T> cls3 = cls2;
                if (cls3 == null) {
                    return false;
                }
                if (cls3 == this) {
                    return true;
                }
                cls2 = (Class<? super T>) cls3.superClass;
            }
        }
    }

    public boolean isEnum() {
        return getSuperclass() == Enum.class && (this.accessFlags & 16384) != 0;
    }

    public boolean isFinalizable() {
        return (this.accessFlags & Integer.MIN_VALUE) != 0;
    }

    public boolean isInstance(Object obj) {
        if (obj == null) {
            return false;
        }
        return isAssignableFrom(obj.getClass());
    }

    public boolean isInterface() {
        return (this.accessFlags & 512) != 0;
    }

    public boolean isLocalClass() {
        return (classNameImpliesTopLevel() || AnnotationAccess.getEnclosingMethodOrConstructor(this) == null || isAnonymousClass()) ? false : true;
    }

    public boolean isMemberClass() {
        return getDeclaringClass() != null;
    }

    public boolean isPrimitive() {
        return this.primitiveType != 0;
    }

    public boolean isProxy() {
        return (this.accessFlags & 262144) != 0;
    }

    public boolean isSynthetic() {
        return (this.accessFlags & 4096) != 0;
    }

    public T newInstance() throws InstantiationException, IllegalAccessException {
        if (isPrimitive() || isInterface() || isArray() || Modifier.isAbstract(this.accessFlags)) {
            throw new InstantiationException(this + " cannot be instantiated");
        }
        Class<?> stackClass1 = VMStack.getStackClass1();
        if (stackClass1.canAccess(this)) {
            try {
                Constructor<T> declaredConstructor = getDeclaredConstructor(new Class[0]);
                if (stackClass1.canAccessMember(this, declaredConstructor.getAccessFlags())) {
                    try {
                        return declaredConstructor.newInstance(null, declaredConstructor.isAccessible());
                    } catch (InvocationTargetException e) {
                        SneakyThrow.sneakyThrow(e.getCause());
                        return null;
                    }
                }
                throw new IllegalAccessException(declaredConstructor + " is not accessible from " + stackClass1);
            } catch (NoSuchMethodException e2) {
                InstantiationException instantiationException = new InstantiationException(this + " has no zero argument constructor");
                instantiationException.initCause(e2);
                throw instantiationException;
            }
        }
        throw new IllegalAccessException(this + " is not accessible from " + stackClass1);
    }

    public String toString() {
        if (isPrimitive()) {
            return getSimpleName();
        }
        return (isInterface() ? "interface " : "class ") + getName();
    }
}
