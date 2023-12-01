package java.io;

import dalvik.system.VMStack;
import java.io.EmulatedFields;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/io/ObjectInputStream.class */
public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants {
    private static final ClassLoader bootstrapLoader;
    private static final ClassLoader systemLoader;
    private HashMap<Class<?>, List<Class<?>>> cachedSuperclasses;
    private ClassLoader callerClassLoader;
    private ObjectStreamClass currentClass;
    private Object currentObject;
    private int descriptorHandle;
    private InputStream emptyStream;
    private boolean enableResolve;
    private boolean hasPushbackTC;
    private DataInputStream input;
    private boolean mustResolve;
    private int nestedLevels;
    private int nextHandle;
    private ArrayList<Object> objectsRead;
    private InputStream primitiveData;
    private DataInputStream primitiveTypes;
    private byte pushbackTC;
    private boolean subclassOverridingImplementation;
    private InputValidationDesc[] validations;
    private static final Object UNSHARED_OBJ = new Object();
    private static final HashMap<String, Class<?>> PRIMITIVE_CLASSES = new HashMap<>();

    /* loaded from: source-2895416-dex2jar.jar:java/io/ObjectInputStream$GetField.class */
    public static abstract class GetField {
        public abstract boolean defaulted(String str) throws IOException, IllegalArgumentException;

        public abstract byte get(String str, byte b) throws IOException, IllegalArgumentException;

        public abstract char get(String str, char c) throws IOException, IllegalArgumentException;

        public abstract double get(String str, double d) throws IOException, IllegalArgumentException;

        public abstract float get(String str, float f) throws IOException, IllegalArgumentException;

        public abstract int get(String str, int i) throws IOException, IllegalArgumentException;

        public abstract long get(String str, long j) throws IOException, IllegalArgumentException;

        public abstract Object get(String str, Object obj) throws IOException, IllegalArgumentException;

        public abstract short get(String str, short s) throws IOException, IllegalArgumentException;

        public abstract boolean get(String str, boolean z) throws IOException, IllegalArgumentException;

        public abstract ObjectStreamClass getObjectStreamClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/io/ObjectInputStream$InputValidationDesc.class */
    public static class InputValidationDesc {
        int priority;
        ObjectInputValidation validator;

        InputValidationDesc() {
        }
    }

    static {
        PRIMITIVE_CLASSES.put("boolean", Boolean.TYPE);
        PRIMITIVE_CLASSES.put("byte", Byte.TYPE);
        PRIMITIVE_CLASSES.put("char", Character.TYPE);
        PRIMITIVE_CLASSES.put("double", Double.TYPE);
        PRIMITIVE_CLASSES.put("float", Float.TYPE);
        PRIMITIVE_CLASSES.put("int", Integer.TYPE);
        PRIMITIVE_CLASSES.put("long", Long.TYPE);
        PRIMITIVE_CLASSES.put("short", Short.TYPE);
        PRIMITIVE_CLASSES.put("void", Void.TYPE);
        bootstrapLoader = Object.class.getClassLoader();
        systemLoader = ClassLoader.getSystemClassLoader();
    }

    protected ObjectInputStream() throws IOException {
        this.emptyStream = new ByteArrayInputStream(EmptyArray.BYTE);
        this.primitiveData = this.emptyStream;
        this.mustResolve = true;
        this.descriptorHandle = -1;
        this.cachedSuperclasses = new HashMap<>();
        this.subclassOverridingImplementation = true;
    }

    public ObjectInputStream(InputStream inputStream) throws StreamCorruptedException, IOException {
        this.emptyStream = new ByteArrayInputStream(EmptyArray.BYTE);
        this.primitiveData = this.emptyStream;
        this.mustResolve = true;
        this.descriptorHandle = -1;
        this.cachedSuperclasses = new HashMap<>();
        this.input = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        this.primitiveTypes = new DataInputStream(this);
        this.enableResolve = false;
        this.subclassOverridingImplementation = false;
        resetState();
        this.nestedLevels = 0;
        this.primitiveData = this.input;
        readStreamHeader();
        this.primitiveData = this.emptyStream;
    }

    private List<Class<?>> cacheSuperclassesFor(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        Class<?> cls2 = cls;
        while (true) {
            Class<?> cls3 = cls2;
            if (cls3 == null) {
                this.cachedSuperclasses.put(cls, arrayList);
                return arrayList;
            }
            Class<? super Object> superclass = cls3.getSuperclass();
            if (superclass != null) {
                arrayList.add(0, cls3);
            }
            cls2 = superclass;
        }
    }

    private void checkReadPrimitiveTypes() throws IOException {
        if (this.primitiveData == this.input || this.primitiveData.available() > 0) {
            return;
        }
        while (true) {
            int i = 0;
            if (this.hasPushbackTC) {
                this.hasPushbackTC = false;
            } else {
                i = this.input.read();
                this.pushbackTC = (byte) i;
            }
            switch (this.pushbackTC) {
                case 119:
                    this.primitiveData = new ByteArrayInputStream(readBlockData());
                    return;
                case 120:
                default:
                    if (i != -1) {
                        pushbackTC();
                        return;
                    }
                    return;
                case 121:
                    resetState();
                case 122:
                    this.primitiveData = new ByteArrayInputStream(readBlockDataLong());
                    return;
            }
        }
    }

    private static void checkedSetSuperClassDesc(ObjectStreamClass objectStreamClass, ObjectStreamClass objectStreamClass2) throws StreamCorruptedException {
        if (objectStreamClass.equals(objectStreamClass2)) {
            throw new StreamCorruptedException();
        }
        objectStreamClass.setSuperclass(objectStreamClass2);
    }

    private StreamCorruptedException corruptStream(byte b) throws StreamCorruptedException {
        throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(b & 255));
    }

    private void discardData() throws ClassNotFoundException, IOException {
        this.primitiveData = this.emptyStream;
        boolean z = this.mustResolve;
        this.mustResolve = false;
        while (true) {
            byte nextTC = nextTC();
            if (nextTC == 120) {
                this.mustResolve = z;
                return;
            }
            readContent(nextTC);
        }
    }

    private int findStreamSuperclass(Class<?> cls, List<ObjectStreamClass> list, int i) {
        int size = list.size();
        while (i < size) {
            ObjectStreamClass objectStreamClass = list.get(i);
            String name = objectStreamClass.forClass().getName();
            if (objectStreamClass.getName().equals(name)) {
                if (cls.getName().equals(objectStreamClass.getName())) {
                    return i;
                }
                i++;
            } else if (cls.getName().equals(name)) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    private static String formatClassSig(String str) {
        int i = 0;
        int length = str.length();
        int i2 = length;
        if (length > 0) {
            while (str.startsWith("[L", i) && str.charAt(i2 - 1) == ';') {
                i += 2;
                i2--;
            }
            if (i > 0) {
                return str.substring(i - 2, i2 + 1);
            }
        }
        return str;
    }

    private static String getBaseName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf == str.length() - 1) ? str : str.substring(lastIndexOf + 1);
    }

    private InvalidClassException missingClassDescriptor() throws InvalidClassException {
        throw new InvalidClassException("Read null attempting to read class descriptor for object");
    }

    private int nextHandle() {
        int i = this.nextHandle;
        this.nextHandle = i + 1;
        return i;
    }

    private byte nextTC() throws IOException {
        if (this.hasPushbackTC) {
            this.hasPushbackTC = false;
        } else {
            this.pushbackTC = this.input.readByte();
        }
        return this.pushbackTC;
    }

    private void pushbackTC() {
        this.hasPushbackTC = true;
    }

    private byte[] readBlockData() throws IOException {
        byte[] bArr = new byte[this.input.readByte() & 255];
        this.input.readFully(bArr);
        return bArr;
    }

    private byte[] readBlockDataLong() throws IOException {
        byte[] bArr = new byte[this.input.readInt()];
        this.input.readFully(bArr);
        return bArr;
    }

    private ObjectStreamClass readClassDesc() throws ClassNotFoundException, IOException {
        byte nextTC = nextTC();
        switch (nextTC) {
            case 112:
                return null;
            case 113:
                return (ObjectStreamClass) readCyclicReference();
            case 114:
                return readNewClassDesc(false);
            case 125:
                ObjectStreamClass lookup = ObjectStreamClass.lookup(readNewProxyClassDesc());
                lookup.setLoadFields(ObjectStreamClass.NO_FIELDS);
                registerObjectRead(lookup, nextHandle(), false);
                checkedSetSuperClassDesc(lookup, readClassDesc());
                return lookup;
            default:
                throw corruptStream(nextTC);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Object readContent(byte b) throws ClassNotFoundException, IOException {
        byte[] bArr = null;
        switch (b) {
            case 112:
                break;
            case 113:
                return readCyclicReference();
            case 114:
                return readNewClassDesc(false);
            case 115:
                return readNewObject(false);
            case 116:
                return readNewString(false);
            case 117:
                return readNewArray(false);
            case 118:
                return readNewClass(false);
            case 119:
                bArr = readBlockData();
                break;
            case 120:
            default:
                throw corruptStream(b);
            case 121:
                resetState();
                return null;
            case 122:
                return readBlockDataLong();
            case 123:
                throw new WriteAbortedException("Read an exception", readException());
            case 124:
                return readNewLongString(false);
        }
        return bArr;
    }

    private Object readCyclicReference() throws InvalidObjectException, IOException {
        return registeredObjectRead(readNewHandle());
    }

    private Object readEnum(boolean z) throws OptionalDataException, ClassNotFoundException, IOException {
        String str;
        Class<?> checkAndGetTcEnumClass = readEnumDesc().checkAndGetTcEnumClass();
        int nextHandle = nextHandle();
        byte nextTC = nextTC();
        switch (nextTC) {
            case 113:
                if (!z) {
                    str = (String) readCyclicReference();
                    break;
                } else {
                    readNewHandle();
                    throw new InvalidObjectException("Unshared read of back reference");
                }
            case 114:
            case 115:
            default:
                throw corruptStream(nextTC);
            case 116:
                str = (String) readNewString(z);
                break;
        }
        try {
            Enum valueOf = Enum.valueOf(checkAndGetTcEnumClass, str);
            registerObjectRead(valueOf, nextHandle, z);
            return valueOf;
        } catch (IllegalArgumentException e) {
            InvalidObjectException invalidObjectException = new InvalidObjectException(e.getMessage());
            invalidObjectException.initCause(e);
            throw invalidObjectException;
        }
    }

    private ObjectStreamClass readEnumDesc() throws IOException, ClassNotFoundException {
        byte nextTC = nextTC();
        switch (nextTC) {
            case 112:
                return null;
            case 113:
                return (ObjectStreamClass) readCyclicReference();
            case 114:
                return readEnumDescInternal();
            default:
                throw corruptStream(nextTC);
        }
    }

    private ObjectStreamClass readEnumDescInternal() throws IOException, ClassNotFoundException {
        this.primitiveData = this.input;
        int i = this.descriptorHandle;
        this.descriptorHandle = nextHandle();
        ObjectStreamClass readClassDescriptor = readClassDescriptor();
        registerObjectRead(readClassDescriptor, this.descriptorHandle, false);
        this.descriptorHandle = i;
        this.primitiveData = this.emptyStream;
        readClassDescriptor.setClass(resolveClass(readClassDescriptor));
        discardData();
        ObjectStreamClass readClassDesc = readClassDesc();
        checkedSetSuperClassDesc(readClassDescriptor, readClassDesc);
        if (0 == readClassDescriptor.getSerialVersionUID() && 0 == readClassDesc.getSerialVersionUID()) {
            if (nextTC() == 120) {
                readClassDesc.setSuperclass(readClassDesc());
                return readClassDescriptor;
            }
            pushbackTC();
            return readClassDescriptor;
        }
        throw new InvalidClassException(readClassDesc.getName(), "Incompatible class (SUID): " + readClassDesc + " but expected " + readClassDesc);
    }

    private Exception readException() throws WriteAbortedException, OptionalDataException, ClassNotFoundException, IOException {
        resetSeenObjects();
        Exception exc = (Exception) readObject();
        resetSeenObjects();
        return exc;
    }

    private void readFieldDescriptors(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        String str;
        int readShort = this.input.readShort();
        ObjectStreamField[] objectStreamFieldArr = new ObjectStreamField[readShort];
        objectStreamClass.setLoadFields(objectStreamFieldArr);
        short s = 0;
        while (true) {
            short s2 = s;
            if (s2 >= readShort) {
                return;
            }
            char readByte = (char) this.input.readByte();
            String readUTF = this.input.readUTF();
            if (ObjectStreamClass.isPrimitiveType(readByte)) {
                str = String.valueOf(readByte);
            } else {
                boolean z = this.enableResolve;
                try {
                    this.enableResolve = false;
                    str = (String) readObject();
                } finally {
                    this.enableResolve = z;
                }
            }
            objectStreamFieldArr[s2] = new ObjectStreamField(formatClassSig(str), readUTF);
            s = (short) (s2 + 1);
        }
    }

    private void readFieldValues(EmulatedFieldsForLoading emulatedFieldsForLoading) throws OptionalDataException, InvalidClassException, IOException {
        EmulatedFields.ObjectSlot[] slots = emulatedFieldsForLoading.emulatedFields().slots();
        int length = slots.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            EmulatedFields.ObjectSlot objectSlot = slots[i2];
            objectSlot.defaulted = false;
            Class<?> type = objectSlot.field.getType();
            if (type == Integer.TYPE) {
                objectSlot.fieldValue = Integer.valueOf(this.input.readInt());
            } else if (type == Byte.TYPE) {
                objectSlot.fieldValue = Byte.valueOf(this.input.readByte());
            } else if (type == Character.TYPE) {
                objectSlot.fieldValue = Character.valueOf(this.input.readChar());
            } else if (type == Short.TYPE) {
                objectSlot.fieldValue = Short.valueOf(this.input.readShort());
            } else if (type == Boolean.TYPE) {
                objectSlot.fieldValue = Boolean.valueOf(this.input.readBoolean());
            } else if (type == Long.TYPE) {
                objectSlot.fieldValue = Long.valueOf(this.input.readLong());
            } else if (type == Float.TYPE) {
                objectSlot.fieldValue = Float.valueOf(this.input.readFloat());
            } else if (type == Double.TYPE) {
                objectSlot.fieldValue = Double.valueOf(this.input.readDouble());
            } else {
                try {
                    objectSlot.fieldValue = readObject();
                } catch (ClassNotFoundException e) {
                    throw new InvalidClassException(e.toString());
                }
            }
            i = i2 + 1;
        }
    }

    private void readFieldValues(Object obj, ObjectStreamClass objectStreamClass) throws OptionalDataException, ClassNotFoundException, IOException {
        ObjectStreamField[] loadFields = objectStreamClass.getLoadFields();
        ObjectStreamField[] objectStreamFieldArr = loadFields;
        if (loadFields == null) {
            objectStreamFieldArr = ObjectStreamClass.NO_FIELDS;
        }
        if (objectStreamClass.forClass() == null && this.mustResolve) {
            throw new ClassNotFoundException(objectStreamClass.getName());
        }
        int length = objectStreamFieldArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            ObjectStreamField objectStreamField = objectStreamFieldArr[i2];
            Field checkAndGetReflectionField = objectStreamClass.checkAndGetReflectionField(objectStreamField);
            try {
                Class<?> typeInternal = objectStreamField.getTypeInternal();
                if (typeInternal == Byte.TYPE) {
                    byte readByte = this.input.readByte();
                    if (checkAndGetReflectionField != null) {
                        checkAndGetReflectionField.setByte(obj, readByte);
                    }
                } else if (typeInternal == Character.TYPE) {
                    char readChar = this.input.readChar();
                    if (checkAndGetReflectionField != null) {
                        checkAndGetReflectionField.setChar(obj, readChar);
                    }
                } else if (typeInternal == Double.TYPE) {
                    double readDouble = this.input.readDouble();
                    if (checkAndGetReflectionField != null) {
                        checkAndGetReflectionField.setDouble(obj, readDouble);
                    }
                } else if (typeInternal == Float.TYPE) {
                    float readFloat = this.input.readFloat();
                    if (checkAndGetReflectionField != null) {
                        checkAndGetReflectionField.setFloat(obj, readFloat);
                    }
                } else if (typeInternal == Integer.TYPE) {
                    int readInt = this.input.readInt();
                    if (checkAndGetReflectionField != null) {
                        checkAndGetReflectionField.setInt(obj, readInt);
                    }
                } else if (typeInternal == Long.TYPE) {
                    long readLong = this.input.readLong();
                    if (checkAndGetReflectionField != null) {
                        checkAndGetReflectionField.setLong(obj, readLong);
                    }
                } else if (typeInternal == Short.TYPE) {
                    short readShort = this.input.readShort();
                    if (checkAndGetReflectionField != null) {
                        checkAndGetReflectionField.setShort(obj, readShort);
                    }
                } else if (typeInternal == Boolean.TYPE) {
                    boolean readBoolean = this.input.readBoolean();
                    if (checkAndGetReflectionField != null) {
                        checkAndGetReflectionField.setBoolean(obj, readBoolean);
                    }
                } else {
                    Object readUnshared = objectStreamField.isUnshared() ? readUnshared() : readObject();
                    if (readUnshared != null) {
                        String name = objectStreamField.getName();
                        Class<?> typeInternal2 = objectStreamClass.getField(name).getTypeInternal();
                        Class<?> cls = readUnshared.getClass();
                        if (!typeInternal2.isAssignableFrom(cls)) {
                            throw new ClassCastException(objectStreamClass.getName() + "." + name + " - " + typeInternal2 + " not compatible with " + cls);
                            break;
                        } else if (checkAndGetReflectionField != null) {
                            checkAndGetReflectionField.set(obj, readUnshared);
                        }
                    } else {
                        continue;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (NoSuchFieldError e2) {
            }
            i = i2 + 1;
        }
    }

    private void readHierarchy(Object obj, ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException, NotActiveException {
        if (obj == null && this.mustResolve) {
            throw new NotActiveException();
        }
        List<ObjectStreamClass> hierarchy = objectStreamClass.getHierarchy();
        if (obj == null) {
            for (ObjectStreamClass objectStreamClass2 : hierarchy) {
                readObjectForClass(null, objectStreamClass2);
            }
            return;
        }
        List<Class<?>> list = this.cachedSuperclasses.get(obj.getClass());
        List<Class<?>> list2 = list;
        if (list == null) {
            list2 = cacheSuperclassesFor(obj.getClass());
        }
        int i = 0;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Class<?> cls = list2.get(i2);
            int findStreamSuperclass = findStreamSuperclass(cls, hierarchy, i);
            if (findStreamSuperclass == -1) {
                readObjectNoData(obj, cls, ObjectStreamClass.lookupStreamClass(cls));
            } else {
                while (i <= findStreamSuperclass) {
                    readObjectForClass(obj, hierarchy.get(i));
                    i++;
                }
                i = findStreamSuperclass + 1;
            }
        }
    }

    private Object readNewArray(boolean z) throws OptionalDataException, ClassNotFoundException, IOException {
        ObjectStreamClass readClassDesc = readClassDesc();
        if (readClassDesc == null) {
            throw missingClassDescriptor();
        }
        int nextHandle = nextHandle();
        int readInt = this.input.readInt();
        Class<?> componentType = readClassDesc.forClass().getComponentType();
        Object newInstance = Array.newInstance(componentType, readInt);
        registerObjectRead(newInstance, nextHandle, z);
        if (!componentType.isPrimitive()) {
            Object[] objArr = (Object[]) newInstance;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                objArr[i2] = readObject();
                i = i2 + 1;
            }
        } else if (componentType == Integer.TYPE) {
            int[] iArr = (int[]) newInstance;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= readInt) {
                    break;
                }
                iArr[i4] = this.input.readInt();
                i3 = i4 + 1;
            }
        } else if (componentType == Byte.TYPE) {
            this.input.readFully((byte[]) newInstance, 0, readInt);
        } else if (componentType == Character.TYPE) {
            char[] cArr = (char[]) newInstance;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= readInt) {
                    break;
                }
                cArr[i6] = this.input.readChar();
                i5 = i6 + 1;
            }
        } else if (componentType == Short.TYPE) {
            short[] sArr = (short[]) newInstance;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= readInt) {
                    break;
                }
                sArr[i8] = this.input.readShort();
                i7 = i8 + 1;
            }
        } else if (componentType == Boolean.TYPE) {
            boolean[] zArr = (boolean[]) newInstance;
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= readInt) {
                    break;
                }
                zArr[i10] = this.input.readBoolean();
                i9 = i10 + 1;
            }
        } else if (componentType == Long.TYPE) {
            long[] jArr = (long[]) newInstance;
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= readInt) {
                    break;
                }
                jArr[i12] = this.input.readLong();
                i11 = i12 + 1;
            }
        } else if (componentType == Float.TYPE) {
            float[] fArr = (float[]) newInstance;
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= readInt) {
                    break;
                }
                fArr[i14] = this.input.readFloat();
                i13 = i14 + 1;
            }
        } else if (componentType != Double.TYPE) {
            throw new ClassNotFoundException("Wrong base type in " + readClassDesc.getName());
        } else {
            double[] dArr = (double[]) newInstance;
            int i15 = 0;
            while (true) {
                int i16 = i15;
                if (i16 >= readInt) {
                    break;
                }
                dArr[i16] = this.input.readDouble();
                i15 = i16 + 1;
            }
        }
        Object obj = newInstance;
        if (this.enableResolve) {
            obj = resolveObject(newInstance);
            registerObjectRead(obj, nextHandle, false);
        }
        return obj;
    }

    private Class<?> readNewClass(boolean z) throws ClassNotFoundException, IOException {
        ObjectStreamClass readClassDesc = readClassDesc();
        if (readClassDesc == null) {
            throw missingClassDescriptor();
        }
        Class<?> forClass = readClassDesc.forClass();
        if (forClass != null) {
            registerObjectRead(forClass, nextHandle(), z);
        }
        return forClass;
    }

    private ObjectStreamClass readNewClassDesc(boolean z) throws ClassNotFoundException, IOException {
        this.primitiveData = this.input;
        int i = this.descriptorHandle;
        this.descriptorHandle = nextHandle();
        ObjectStreamClass readClassDescriptor = readClassDescriptor();
        registerObjectRead(readClassDescriptor, this.descriptorHandle, z);
        this.descriptorHandle = i;
        this.primitiveData = this.emptyStream;
        try {
            readClassDescriptor.setClass(resolveClass(readClassDescriptor));
            verifyAndInit(readClassDescriptor);
        } catch (ClassNotFoundException e) {
            if (this.mustResolve) {
                throw e;
            }
        }
        ObjectStreamField[] loadFields = readClassDescriptor.getLoadFields();
        ObjectStreamField[] objectStreamFieldArr = loadFields;
        if (loadFields == null) {
            objectStreamFieldArr = ObjectStreamClass.NO_FIELDS;
        }
        ClassLoader classLoader = readClassDescriptor.forClass() == null ? this.callerClassLoader : readClassDescriptor.forClass().getClassLoader();
        int length = objectStreamFieldArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                discardData();
                checkedSetSuperClassDesc(readClassDescriptor, readClassDesc());
                return readClassDescriptor;
            }
            objectStreamFieldArr[i3].resolve(classLoader);
            i2 = i3 + 1;
        }
    }

    private int readNewHandle() throws IOException {
        return this.input.readInt();
    }

    private Object readNewLongString(boolean z) throws IOException {
        String decodeUTF = this.input.decodeUTF((int) this.input.readLong());
        String str = decodeUTF;
        if (this.enableResolve) {
            str = resolveObject(decodeUTF);
        }
        registerObjectRead(str, nextHandle(), z);
        return str;
    }

    private Object readNewObject(boolean z) throws OptionalDataException, ClassNotFoundException, IOException {
        Externalizable externalizable;
        ObjectStreamClass readClassDesc = readClassDesc();
        if (readClassDesc == null) {
            throw missingClassDescriptor();
        }
        Class<?> checkAndGetTcObjectClass = readClassDesc.checkAndGetTcObjectClass();
        int nextHandle = nextHandle();
        Externalizable externalizable2 = null;
        if (checkAndGetTcObjectClass != null) {
            externalizable = readClassDesc.newInstance(checkAndGetTcObjectClass);
            registerObjectRead(externalizable, nextHandle, z);
            externalizable2 = externalizable;
        } else {
            externalizable = null;
        }
        try {
            this.currentObject = externalizable;
            this.currentClass = readClassDesc;
            if ((readClassDesc.getFlags() & 4) != 0) {
                boolean z2 = (readClassDesc.getFlags() & 8) != 0;
                if (!z2) {
                    this.primitiveData = this.input;
                }
                if (this.mustResolve) {
                    externalizable.readExternal(this);
                }
                if (z2) {
                    discardData();
                } else {
                    this.primitiveData = this.emptyStream;
                }
            } else {
                readHierarchy(externalizable, readClassDesc);
            }
            this.currentObject = null;
            this.currentClass = null;
            Externalizable externalizable3 = externalizable;
            if (checkAndGetTcObjectClass != null) {
                externalizable3 = externalizable;
                if (readClassDesc.hasMethodReadResolve()) {
                    try {
                        externalizable3 = readClassDesc.getMethodReadResolve().invoke(externalizable, null);
                    } catch (IllegalAccessException e) {
                        externalizable3 = externalizable;
                    } catch (InvocationTargetException e2) {
                        Throwable targetException = e2.getTargetException();
                        if (targetException instanceof ObjectStreamException) {
                            throw ((ObjectStreamException) targetException);
                        }
                        if (targetException instanceof Error) {
                            throw ((Error) targetException);
                        }
                        throw ((RuntimeException) targetException);
                    }
                }
            }
            Externalizable externalizable4 = externalizable3;
            if (externalizable3 != null) {
                externalizable4 = externalizable3;
                if (this.enableResolve) {
                    externalizable4 = resolveObject(externalizable3);
                }
            }
            if (externalizable2 != externalizable4) {
                registerObjectRead(externalizable4, nextHandle, z);
            }
            return externalizable4;
        } catch (Throwable th) {
            this.currentObject = null;
            this.currentClass = null;
            throw th;
        }
    }

    private Class<?> readNewProxyClassDesc() throws ClassNotFoundException, IOException {
        int readInt = this.input.readInt();
        String[] strArr = new String[readInt];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                Class<?> resolveProxyClass = resolveProxyClass(strArr);
                discardData();
                return resolveProxyClass;
            }
            strArr[i2] = this.input.readUTF();
            i = i2 + 1;
        }
    }

    private Object readNewString(boolean z) throws IOException {
        String readUTF = this.input.readUTF();
        String str = readUTF;
        if (this.enableResolve) {
            str = resolveObject(readUTF);
        }
        registerObjectRead(str, nextHandle(), z);
        return str;
    }

    private Object readNonPrimitiveContent(boolean z) throws ClassNotFoundException, IOException {
        checkReadPrimitiveTypes();
        if (this.primitiveData.available() > 0) {
            OptionalDataException optionalDataException = new OptionalDataException();
            optionalDataException.length = this.primitiveData.available();
            throw optionalDataException;
        }
        while (true) {
            byte nextTC = nextTC();
            switch (nextTC) {
                case 112:
                    return null;
                case 113:
                    if (z) {
                        readNewHandle();
                        throw new InvalidObjectException("Unshared read of back reference");
                    }
                    return readCyclicReference();
                case 114:
                    return readNewClassDesc(z);
                case 115:
                    return readNewObject(z);
                case 116:
                    return readNewString(z);
                case 117:
                    return readNewArray(z);
                case 118:
                    return readNewClass(z);
                case 119:
                case 122:
                case 125:
                default:
                    throw corruptStream(nextTC);
                case 120:
                    pushbackTC();
                    OptionalDataException optionalDataException2 = new OptionalDataException();
                    optionalDataException2.eof = true;
                    throw optionalDataException2;
                case 121:
                    resetState();
                case 123:
                    throw new WriteAbortedException("Read an exception", readException());
                case 124:
                    return readNewLongString(z);
                case 126:
                    return readEnum(z);
            }
        }
    }

    private Object readObject(boolean z) throws OptionalDataException, ClassNotFoundException, IOException {
        Object obj;
        boolean z2 = this.primitiveData == this.input;
        if (z2) {
            this.primitiveData = this.emptyStream;
        }
        if (!this.subclassOverridingImplementation || z) {
            try {
                int i = this.nestedLevels + 1;
                this.nestedLevels = i;
                if (i == 1) {
                    this.callerClassLoader = VMStack.getClosestUserClassLoader(bootstrapLoader, systemLoader);
                }
                Object readNonPrimitiveContent = readNonPrimitiveContent(z);
                if (z2) {
                    this.primitiveData = this.input;
                }
                obj = readNonPrimitiveContent;
                if (this.nestedLevels == 0) {
                    obj = readNonPrimitiveContent;
                    if (this.validations != null) {
                        try {
                            InputValidationDesc[] inputValidationDescArr = this.validations;
                            int length = inputValidationDescArr.length;
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= length) {
                                    return readNonPrimitiveContent;
                                }
                                inputValidationDescArr[i3].validator.validateObject();
                                i2 = i3 + 1;
                            }
                        } finally {
                            this.validations = null;
                        }
                    }
                }
            } finally {
                int i4 = this.nestedLevels - 1;
                this.nestedLevels = i4;
                if (i4 == 0) {
                    this.callerClassLoader = null;
                }
            }
        } else {
            obj = readObjectOverride();
        }
        return obj;
    }

    private void readObjectForClass(Object obj, ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException, NotActiveException {
        boolean z = true;
        this.currentObject = obj;
        this.currentClass = objectStreamClass;
        if ((objectStreamClass.getFlags() & 1) == 0) {
            z = false;
        }
        Method methodReadObject = (objectStreamClass.forClass() == null || !this.mustResolve) ? null : objectStreamClass.getMethodReadObject();
        try {
            if (methodReadObject != null) {
                methodReadObject.setAccessible(true);
                try {
                    methodReadObject.invoke(obj, this);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e.toString());
                } catch (InvocationTargetException e2) {
                    Throwable targetException = e2.getTargetException();
                    if (targetException instanceof ClassNotFoundException) {
                        throw ((ClassNotFoundException) targetException);
                    }
                    if (targetException instanceof RuntimeException) {
                        throw ((RuntimeException) targetException);
                    }
                    if (!(targetException instanceof Error)) {
                        throw ((IOException) targetException);
                    }
                    throw ((Error) targetException);
                }
            } else {
                defaultReadObject();
            }
            if (z) {
                discardData();
            }
        } finally {
            this.currentObject = null;
            this.currentClass = null;
        }
    }

    private void readObjectNoData(Object obj, Class<?> cls, ObjectStreamClass objectStreamClass) throws ObjectStreamException {
        if (objectStreamClass.isSerializable() && objectStreamClass.hasMethodReadObjectNoData()) {
            try {
                objectStreamClass.getMethodReadObjectNoData().invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.toString());
            } catch (InvocationTargetException e2) {
                Throwable targetException = e2.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
                if (!(targetException instanceof Error)) {
                    throw ((ObjectStreamException) targetException);
                }
                throw ((Error) targetException);
            }
        }
    }

    private void registerObjectRead(Object obj, int i, boolean z) throws IOException {
        int i2;
        if (z) {
            obj = UNSHARED_OBJ;
        }
        int i3 = i - ObjectStreamConstants.baseWireHandle;
        int size = this.objectsRead.size();
        while (true) {
            i2 = size;
            if (i3 <= i2) {
                break;
            }
            this.objectsRead.add(null);
            size = i2 + 1;
        }
        if (i3 == i2) {
            this.objectsRead.add(obj);
        } else {
            this.objectsRead.set(i3, obj);
        }
    }

    private Object registeredObjectRead(int i) throws InvalidObjectException {
        Object obj = this.objectsRead.get(i - ObjectStreamConstants.baseWireHandle);
        if (obj == UNSHARED_OBJ) {
            throw new InvalidObjectException("Cannot read back reference to unshared object");
        }
        return obj;
    }

    private void resetSeenObjects() {
        this.objectsRead = new ArrayList<>();
        this.nextHandle = ObjectStreamConstants.baseWireHandle;
        this.primitiveData = this.emptyStream;
    }

    private void resetState() {
        resetSeenObjects();
        this.hasPushbackTC = false;
        this.pushbackTC = (byte) 0;
    }

    private void verifyAndInit(ObjectStreamClass objectStreamClass) throws InvalidClassException {
        ObjectStreamClass lookupStreamClass = ObjectStreamClass.lookupStreamClass(objectStreamClass.forClass());
        if (objectStreamClass.getSerialVersionUID() != lookupStreamClass.getSerialVersionUID()) {
            throw new InvalidClassException(objectStreamClass.getName(), "Incompatible class (SUID): " + objectStreamClass + " but expected " + lookupStreamClass);
        }
        String baseName = getBaseName(objectStreamClass.getName());
        String baseName2 = getBaseName(lookupStreamClass.getName());
        if (!baseName.equals(baseName2)) {
            throw new InvalidClassException(objectStreamClass.getName(), String.format("Incompatible class (base name): %s but expected %s", baseName, baseName2));
        }
        objectStreamClass.initPrivateFields(lookupStreamClass);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        checkReadPrimitiveTypes();
        return this.primitiveData.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    public void defaultReadObject() throws IOException, ClassNotFoundException, NotActiveException {
        if (this.currentObject == null && this.mustResolve) {
            throw new NotActiveException();
        }
        readFieldValues(this.currentObject, this.currentClass);
    }

    protected boolean enableResolveObject(boolean z) {
        boolean z2 = this.enableResolve;
        this.enableResolve = z;
        return z2;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        checkReadPrimitiveTypes();
        return this.primitiveData.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (i2 == 0) {
            return 0;
        }
        checkReadPrimitiveTypes();
        return this.primitiveData.read(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.primitiveTypes.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.primitiveTypes.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.primitiveTypes.readChar();
    }

    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass objectStreamClass = new ObjectStreamClass();
        String readUTF = this.input.readUTF();
        if (readUTF.length() == 0) {
            throw new IOException("The stream is corrupted");
        }
        objectStreamClass.setName(readUTF);
        objectStreamClass.setSerialVersionUID(this.input.readLong());
        objectStreamClass.setFlags(this.input.readByte());
        if (this.descriptorHandle == -1) {
            this.descriptorHandle = nextHandle();
        }
        registerObjectRead(objectStreamClass, this.descriptorHandle, false);
        readFieldDescriptors(objectStreamClass);
        return objectStreamClass;
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.primitiveTypes.readDouble();
    }

    public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
        if (this.currentObject == null) {
            throw new NotActiveException();
        }
        EmulatedFieldsForLoading emulatedFieldsForLoading = new EmulatedFieldsForLoading(this.currentClass);
        readFieldValues(emulatedFieldsForLoading);
        return emulatedFieldsForLoading;
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.primitiveTypes.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.primitiveTypes.readFully(bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.primitiveTypes.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.primitiveTypes.readInt();
    }

    @Override // java.io.DataInput
    @Deprecated
    public String readLine() throws IOException {
        return this.primitiveTypes.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.primitiveTypes.readLong();
    }

    @Override // java.io.ObjectInput
    public final Object readObject() throws OptionalDataException, ClassNotFoundException, IOException {
        return readObject(false);
    }

    protected Object readObjectOverride() throws OptionalDataException, ClassNotFoundException, IOException {
        if (this.input == null) {
            return null;
        }
        throw new IOException();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.primitiveTypes.readShort();
    }

    protected void readStreamHeader() throws IOException, StreamCorruptedException {
        if (this.input.readShort() != -21267 || this.input.readShort() != 5) {
            throw new StreamCorruptedException();
        }
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.primitiveTypes.readUTF();
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        return readObject(true);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.primitiveTypes.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.primitiveTypes.readUnsignedShort();
    }

    public void registerValidation(ObjectInputValidation objectInputValidation, int i) throws NotActiveException, InvalidObjectException {
        int i2;
        synchronized (this) {
            if (this.currentObject == null && this.nestedLevels == 0) {
                throw new NotActiveException();
            }
            if (objectInputValidation == null) {
                throw new InvalidObjectException("Callback object cannot be null");
            }
            InputValidationDesc inputValidationDesc = new InputValidationDesc();
            inputValidationDesc.validator = objectInputValidation;
            inputValidationDesc.priority = i;
            if (this.validations == null) {
                this.validations = new InputValidationDesc[1];
                this.validations[0] = inputValidationDesc;
            } else {
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= this.validations.length || i >= this.validations[i2].priority) {
                        break;
                    }
                    i3 = i2 + 1;
                }
                InputValidationDesc[] inputValidationDescArr = this.validations;
                int length = inputValidationDescArr.length;
                this.validations = new InputValidationDesc[length + 1];
                System.arraycopy(inputValidationDescArr, 0, this.validations, 0, i2);
                System.arraycopy(inputValidationDescArr, i2, this.validations, i2 + 1, length - i2);
                this.validations[i2] = inputValidationDesc;
            }
        }
    }

    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        Class<?> forClass = objectStreamClass.forClass();
        Class<?> cls = forClass;
        if (forClass == null) {
            String name = objectStreamClass.getName();
            Class<?> cls2 = PRIMITIVE_CLASSES.get(name);
            cls = cls2;
            if (cls2 == null) {
                cls = Class.forName(name, false, this.callerClassLoader);
            }
        }
        return cls;
    }

    protected Object resolveObject(Object obj) throws IOException {
        return obj;
    }

    protected Class<?> resolveProxyClass(String[] strArr) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = this.callerClassLoader;
        Class[] clsArr = new Class[strArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                try {
                    return Proxy.getProxyClass(classLoader, clsArr);
                } catch (IllegalArgumentException e) {
                    throw new ClassNotFoundException(e.toString(), e);
                }
            }
            clsArr[i2] = Class.forName(strArr[i2], false, classLoader);
            i = i2 + 1;
        }
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        if (this.input == null) {
            throw new NullPointerException("source stream is null");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return i;
            }
            checkReadPrimitiveTypes();
            long skip = this.primitiveData.skip(i - i3);
            if (skip == 0) {
                return i3;
            }
            i2 = i3 + ((int) skip);
        }
    }
}
