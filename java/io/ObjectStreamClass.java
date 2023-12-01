package java.io;

import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/io/ObjectStreamClass.class */
public class ObjectStreamClass implements Serializable {
    static final Class<?> ARRAY_OF_FIELDS;
    static final Class<?> CLASSCLASS;
    private static final int CLASS_MODIFIERS_MASK = 1553;
    private static final int CLINIT_MODIFIERS = 8;
    private static final String CLINIT_NAME = "<clinit>";
    private static final String CLINIT_SIGNATURE = "()V";
    static final long CONSTRUCTOR_IS_NOT_RESOLVED = -1;
    private static final Class<Externalizable> EXTERNALIZABLE;
    private static final int FIELD_MODIFIERS_MASK = 223;
    private static final int METHOD_MODIFIERS_MASK = 3391;
    static final Class<ObjectStreamClass> OBJECTSTREAMCLASSCLASS;
    private static final Class<Serializable> SERIALIZABLE;
    static final Class<String> STRINGCLASS;
    private static final String UID_FIELD_NAME = "serialVersionUID";
    private static final long serialVersionUID = -6120832682080437368L;
    private static SoftReference<ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>> storage;
    private transient boolean arePropertiesResolved;
    private volatile transient List<ObjectStreamClass> cachedHierarchy;
    private transient String className;
    private transient ObjectStreamField[] fields;
    private transient byte flags;
    private transient boolean isEnum;
    private transient boolean isExternalizable;
    private transient boolean isProxy;
    private transient boolean isSerializable;
    private transient ObjectStreamField[] loadFields;
    private transient Method methodReadObject;
    private transient Method methodReadObjectNoData;
    private transient Method methodReadResolve;
    private transient Method methodWriteObject;
    private transient Method methodWriteReplace;
    private transient Class<?> resolvedClass;
    private transient Class<?> resolvedConstructorClass;
    private transient long resolvedConstructorMethodId;
    private transient ObjectStreamClass superclass;
    private transient long svUID;
    private static final Class<?>[] READ_PARAM_TYPES = {ObjectInputStream.class};
    private static final Class<?>[] WRITE_PARAM_TYPES = {ObjectOutputStream.class};
    public static final ObjectStreamField[] NO_FIELDS = new ObjectStreamField[0];
    private transient HashMap<ObjectStreamField, Field> reflectionFields = new HashMap<>();
    private transient long constructor = -1;

    static {
        try {
            ARRAY_OF_FIELDS = Class.forName("[Ljava.io.ObjectStreamField;");
            SERIALIZABLE = Serializable.class;
            EXTERNALIZABLE = Externalizable.class;
            STRINGCLASS = String.class;
            CLASSCLASS = Class.class;
            OBJECTSTREAMCLASSCLASS = ObjectStreamClass.class;
            storage = new SoftReference<>(null);
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x028a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0159 A[Catch: IOException -> 0x024c, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x024c, blocks: (B:22:0x007d, B:27:0x00af, B:31:0x00b8, B:35:0x00c5, B:37:0x00d0, B:39:0x00dd, B:40:0x00ec, B:42:0x00f3, B:47:0x0110, B:49:0x0116, B:50:0x0124, B:54:0x012f, B:56:0x0142, B:58:0x014a, B:63:0x0159, B:64:0x017a, B:66:0x0181, B:68:0x0197, B:70:0x01a1, B:71:0x01af, B:75:0x01ba, B:77:0x01cb, B:78:0x01f0, B:80:0x01fb, B:81:0x0209, B:85:0x0213, B:87:0x0223), top: B:107:0x007d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long computeSerialVersionUID(java.lang.Class<?> r5, java.lang.reflect.Field[] r6) {
        /*
            Method dump skipped, instructions count: 679
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectStreamClass.computeSerialVersionUID(java.lang.Class, java.lang.reflect.Field[]):long");
    }

    private void copyFieldAttributes() {
        if (this.loadFields == null || this.fields == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.loadFields.length) {
                return;
            }
            ObjectStreamField objectStreamField = this.loadFields[i2];
            String name = objectStreamField.getName();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.fields.length) {
                    ObjectStreamField objectStreamField2 = this.fields[i4];
                    if (name.equals(objectStreamField2.getName())) {
                        objectStreamField.setUnshared(objectStreamField2.isUnshared());
                        objectStreamField.setOffset(objectStreamField2.getOffset());
                        break;
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x005b, code lost:
        if (r0 != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.ObjectStreamClass createClassDesc(java.lang.Class<?> r9) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectStreamClass.createClassDesc(java.lang.Class):java.io.ObjectStreamClass");
    }

    private static String descriptorForFieldSignature(String str) {
        return str.replace('.', '/');
    }

    private static String descriptorForSignature(String str) {
        return str.substring(str.indexOf("("));
    }

    static Field fieldSerialPersistentFields(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("serialPersistentFields");
            int modifiers = declaredField.getModifiers();
            if (Modifier.isStatic(modifiers) && Modifier.isPrivate(modifiers) && Modifier.isFinal(modifiers)) {
                if (declaredField.getType() == ARRAY_OF_FIELDS) {
                    return declaredField;
                }
                return null;
            }
            return null;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    static Method findMethod(Class<?> cls, String str) {
        Method declaredMethod;
        Class<? super Object> cls2 = cls;
        while (true) {
            Class<?> cls3 = cls2;
            if (cls3 == null) {
                return null;
            }
            try {
                declaredMethod = cls3.getDeclaredMethod(str, null);
            } catch (NoSuchMethodException e) {
            }
            if (cls3 == cls || (declaredMethod.getModifiers() & 2) == 0) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
            cls2 = cls3.getSuperclass();
        }
    }

    static Method findPrivateMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (Modifier.isPrivate(declaredMethod.getModifiers()) && declaredMethod.getReturnType() == Void.TYPE) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static WeakHashMap<Class<?>, ObjectStreamClass> getCache() {
        ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>> threadLocal = storage.get();
        ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>> threadLocal2 = threadLocal;
        if (threadLocal == null) {
            threadLocal2 = new ThreadLocal<WeakHashMap<Class<?>, ObjectStreamClass>>() { // from class: java.io.ObjectStreamClass.5
                @Override // java.lang.ThreadLocal
                public WeakHashMap<Class<?>, ObjectStreamClass> initialValue() {
                    return new WeakHashMap<>();
                }
            };
            storage = new SoftReference<>(threadLocal2);
        }
        return threadLocal2.get();
    }

    private static native long getConstructorId(Class<?> cls);

    static native String getConstructorSignature(Constructor<?> constructor);

    private static native String getFieldSignature(Field field);

    static native String getMethodSignature(Method method);

    private static native boolean hasClinit(Class<?> cls);

    private boolean inSamePackage(Class<?> cls, Class<?> cls2) {
        String name = cls.getName();
        String name2 = cls2.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != name2.lastIndexOf(46)) {
            return false;
        }
        if (lastIndexOf == -1) {
            return true;
        }
        return name.regionMatches(0, name2, 0, lastIndexOf);
    }

    static boolean isExternalizable(Class<?> cls) {
        return EXTERNALIZABLE.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isPrimitiveType(char c) {
        return (c == '[' || c == 'L') ? false : true;
    }

    static boolean isSerializable(Class<?> cls) {
        return SERIALIZABLE.isAssignableFrom(cls);
    }

    public static ObjectStreamClass lookup(Class<?> cls) {
        ObjectStreamClass lookupStreamClass = lookupStreamClass(cls);
        if (lookupStreamClass.isSerializable() || lookupStreamClass.isExternalizable()) {
            return lookupStreamClass;
        }
        return null;
    }

    public static ObjectStreamClass lookupAny(Class<?> cls) {
        return lookupStreamClass(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ObjectStreamClass lookupStreamClass(Class<?> cls) {
        WeakHashMap<Class<?>, ObjectStreamClass> cache = getCache();
        ObjectStreamClass objectStreamClass = cache.get(cls);
        ObjectStreamClass objectStreamClass2 = objectStreamClass;
        if (objectStreamClass == null) {
            objectStreamClass2 = createClassDesc(cls);
            cache.put(cls, objectStreamClass2);
        }
        return objectStreamClass2;
    }

    private List<ObjectStreamClass> makeHierarchy() {
        ArrayList arrayList = new ArrayList();
        ObjectStreamClass objectStreamClass = this;
        while (true) {
            ObjectStreamClass objectStreamClass2 = objectStreamClass;
            if (objectStreamClass2 == null) {
                return arrayList;
            }
            arrayList.add(0, objectStreamClass2);
            objectStreamClass = objectStreamClass2.getSuperclass();
        }
    }

    private static native Object newInstance(Class<?> cls, long j);

    private int primitiveSize(Class<?> cls) {
        if (cls == Byte.TYPE || cls == Boolean.TYPE) {
            return 1;
        }
        if (cls == Short.TYPE || cls == Character.TYPE) {
            return 2;
        }
        if (cls == Integer.TYPE || cls == Float.TYPE) {
            return 4;
        }
        if (cls == Long.TYPE || cls == Double.TYPE) {
            return 8;
        }
        throw new AssertionError();
    }

    private Class<?> resolveConstructorClass(Class<?> cls) throws InvalidClassException {
        if (this.resolvedConstructorClass != null) {
            return this.resolvedConstructorClass;
        }
        Class<? super Object> cls2 = cls;
        Class<?> cls3 = cls2;
        if ((this.flags & 2) != 0) {
            while (true) {
                cls3 = cls2;
                if (cls2 == null) {
                    break;
                }
                cls3 = cls2;
                if (!isSerializable(cls2)) {
                    break;
                }
                cls2 = cls2.getSuperclass();
            }
        }
        Constructor<?> constructor = null;
        if (cls3 != null) {
            try {
                constructor = cls3.getDeclaredConstructor(EmptyArray.CLASS);
            } catch (NoSuchMethodException e) {
                constructor = null;
            }
        }
        if (constructor == null) {
            throw new InvalidClassException(cls3 != null ? cls3.getName() : null, "IllegalAccessException");
        }
        int modifiers = constructor.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isProtected = Modifier.isProtected(modifiers);
        boolean isPrivate = Modifier.isPrivate(modifiers);
        boolean z = (this.flags & 4) != 0;
        if (isPrivate || (z && !isPublic)) {
            throw new InvalidClassException(cls3.getName(), "IllegalAccessException");
        }
        if (isPublic || isProtected || inSamePackage(cls3, cls)) {
            this.resolvedConstructorClass = cls3;
            this.resolvedConstructorMethodId = getConstructorId(this.resolvedConstructorClass);
            return cls3;
        }
        throw new InvalidClassException(cls3.getName(), "IllegalAccessException");
    }

    private void resolveProperties() {
        if (this.arePropertiesResolved) {
            return;
        }
        Class<?> forClass = forClass();
        this.isProxy = Proxy.isProxyClass(forClass);
        this.isEnum = Enum.class.isAssignableFrom(forClass);
        this.isSerializable = isSerializable(forClass);
        this.isExternalizable = isExternalizable(forClass);
        this.arePropertiesResolved = true;
    }

    void buildFieldDescriptors(Field[] fieldArr) {
        ObjectStreamField[] objectStreamFieldArr;
        Field fieldSerialPersistentFields = fieldSerialPersistentFields(forClass());
        if (fieldSerialPersistentFields == null) {
            ArrayList arrayList = new ArrayList(fieldArr.length);
            int length = fieldArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Field field = fieldArr[i2];
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                    arrayList.add(new ObjectStreamField(field.getName(), field.getType()));
                }
                i = i2 + 1;
            }
            objectStreamFieldArr = arrayList.size() == 0 ? NO_FIELDS : (ObjectStreamField[]) arrayList.toArray(new ObjectStreamField[arrayList.size()]);
        } else {
            fieldSerialPersistentFields.setAccessible(true);
            try {
                objectStreamFieldArr = (ObjectStreamField[]) fieldSerialPersistentFields.get(null);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
        Arrays.sort(objectStreamFieldArr);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= objectStreamFieldArr.length) {
                this.fields = objectStreamFieldArr;
                return;
            }
            Class<?> type = objectStreamFieldArr[i6].getType();
            if (type.isPrimitive()) {
                objectStreamFieldArr[i6].offset = i3;
                i3 += primitiveSize(type);
            } else {
                objectStreamFieldArr[i6].offset = i4;
                i4++;
            }
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Field checkAndGetReflectionField(ObjectStreamField objectStreamField) {
        Field field;
        synchronized (this.reflectionFields) {
            Field field2 = this.reflectionFields.get(objectStreamField);
            if (field2 != null || this.reflectionFields.containsKey(objectStreamField)) {
                return field2;
            }
            try {
                field = forClass().getDeclaredField(objectStreamField.getName());
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)) {
                    field = null;
                } else {
                    field.setAccessible(true);
                }
            } catch (NoSuchFieldException e) {
                field = null;
            }
            synchronized (this.reflectionFields) {
                this.reflectionFields.put(objectStreamField, field);
            }
            return field;
        }
    }

    public Class<?> checkAndGetTcEnumClass() throws InvalidClassException {
        if (isEnum()) {
            return forClass();
        }
        throw new InvalidClassException(getName() + " local class is incompatible: Local class is not an enum, streamed data is tagged with TC_ENUM");
    }

    public Class<?> checkAndGetTcObjectClass() throws InvalidClassException {
        boolean z = (this.flags & 2) != 0;
        boolean z2 = (this.flags & 4) != 0;
        if (z == z2) {
            throw new InvalidClassException(getName() + " stream data is corrupt: SC_SERIALIZABLE=" + z + " SC_EXTERNALIZABLE=" + z2 + ", classDescFlags must have one or the other");
        }
        if (isEnum()) {
            throw new InvalidClassException(getName() + " local class is incompatible: Local class is an enum, streamed data is tagged with TC_OBJECT");
        }
        if (isSerializable()) {
            if (z2 != isExternalizable()) {
                throw new InvalidClassException(getName() + " local class is incompatible: Local class is Serializable, stream data requires Externalizable");
            }
            return forClass();
        }
        throw new InvalidClassException(getName() + " local class is incompatible: Not Serializable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamField[] fields() {
        if (this.fields == null) {
            Class<?> forClass = forClass();
            if (forClass == null || !isSerializable() || forClass.isArray()) {
                setFields(NO_FIELDS);
            } else {
                buildFieldDescriptors(forClass.getDeclaredFields());
            }
        }
        return this.fields;
    }

    public Class<?> forClass() {
        return this.resolvedClass;
    }

    long getConstructor() {
        return this.constructor;
    }

    public ObjectStreamField getField(String str) {
        ObjectStreamField[] fields = getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fields.length) {
                return null;
            }
            ObjectStreamField objectStreamField = fields[i2];
            if (objectStreamField.getName().equals(str)) {
                return objectStreamField;
            }
            i = i2 + 1;
        }
    }

    public ObjectStreamField[] getFields() {
        copyFieldAttributes();
        return this.loadFields == null ? (ObjectStreamField[]) fields().clone() : (ObjectStreamField[]) this.loadFields.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte getFlags() {
        return this.flags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ObjectStreamClass> getHierarchy() {
        List<ObjectStreamClass> list = this.cachedHierarchy;
        List<ObjectStreamClass> list2 = list;
        if (list == null) {
            list2 = makeHierarchy();
            this.cachedHierarchy = list2;
        }
        return list2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamField[] getLoadFields() {
        return this.loadFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Method getMethodReadObject() {
        return this.methodReadObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Method getMethodReadObjectNoData() {
        return this.methodReadObjectNoData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Method getMethodReadResolve() {
        return this.methodReadResolve;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Method getMethodWriteObject() {
        return this.methodWriteObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Method getMethodWriteReplace() {
        return this.methodWriteReplace;
    }

    public String getName() {
        return this.className;
    }

    public long getSerialVersionUID() {
        return this.svUID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamClass getSuperclass() {
        return this.superclass;
    }

    boolean hasMethodReadObject() {
        return this.methodReadObject != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMethodReadObjectNoData() {
        return this.methodReadObjectNoData != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMethodReadResolve() {
        return this.methodReadResolve != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMethodWriteObject() {
        return this.methodWriteObject != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMethodWriteReplace() {
        return this.methodWriteReplace != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initPrivateFields(ObjectStreamClass objectStreamClass) {
        this.methodWriteReplace = objectStreamClass.methodWriteReplace;
        this.methodReadResolve = objectStreamClass.methodReadResolve;
        this.methodWriteObject = objectStreamClass.methodWriteObject;
        this.methodReadObject = objectStreamClass.methodReadObject;
        this.methodReadObjectNoData = objectStreamClass.methodReadObjectNoData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnum() {
        resolveProperties();
        return this.isEnum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isExternalizable() {
        resolveProperties();
        return this.isExternalizable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isProxy() {
        resolveProperties();
        return this.isProxy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSerializable() {
        resolveProperties();
        return this.isSerializable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object newInstance(Class<?> cls) throws InvalidClassException {
        resolveConstructorClass(cls);
        return newInstance(cls, this.resolvedConstructorMethodId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setClass(Class<?> cls) {
        this.resolvedClass = cls;
    }

    void setConstructor(long j) {
        this.constructor = j;
    }

    void setFields(ObjectStreamField[] objectStreamFieldArr) {
        this.fields = objectStreamFieldArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFlags(byte b) {
        this.flags = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoadFields(ObjectStreamField[] objectStreamFieldArr) {
        this.loadFields = objectStreamFieldArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setName(String str) {
        this.className = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSerialVersionUID(long j) {
        this.svUID = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSuperclass(ObjectStreamClass objectStreamClass) {
        this.superclass = objectStreamClass;
    }

    public String toString() {
        return getName() + ": static final long serialVersionUID =" + getSerialVersionUID() + "L;";
    }
}
