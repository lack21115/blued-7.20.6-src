package java.io;

import java.io.EmulatedFields;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import java.util.List;
import libcore.io.Memory;

/* loaded from: source-2895416-dex2jar.jar:java/io/ObjectOutputStream.class */
public class ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants {
    private static final byte NOT_SC_BLOCK_DATA = -9;
    private ObjectStreamClass currentClass;
    private int currentHandle;
    private Object currentObject;
    private EmulatedFieldsForDumping currentPutField;
    private boolean enableReplace;
    private int nestedLevels;
    private SerializationHandleMap objectsWritten;
    private DataOutputStream output;
    private DataOutputStream primitiveTypes;
    private ByteArrayOutputStream primitiveTypesBuffer;
    private int protocolVersion;
    private final ObjectStreamClass proxyClassDesc;
    private boolean subclassOverridingImplementation;

    /* loaded from: source-2895416-dex2jar.jar:java/io/ObjectOutputStream$PutField.class */
    public static abstract class PutField {
        public abstract void put(String str, byte b);

        public abstract void put(String str, char c);

        public abstract void put(String str, double d);

        public abstract void put(String str, float f);

        public abstract void put(String str, int i);

        public abstract void put(String str, long j);

        public abstract void put(String str, Object obj);

        public abstract void put(String str, short s);

        public abstract void put(String str, boolean z);

        @Deprecated
        public abstract void write(ObjectOutput objectOutput) throws IOException;
    }

    protected ObjectOutputStream() throws IOException {
        this.proxyClassDesc = ObjectStreamClass.lookup(Proxy.class);
        this.subclassOverridingImplementation = true;
    }

    public ObjectOutputStream(OutputStream outputStream) throws IOException {
        this.proxyClassDesc = ObjectStreamClass.lookup(Proxy.class);
        this.output = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        this.enableReplace = false;
        this.protocolVersion = 2;
        this.subclassOverridingImplementation = false;
        resetState();
        this.primitiveTypes = this.output;
        writeStreamHeader();
        this.primitiveTypes = null;
    }

    private void checkWritePrimitiveTypes() {
        if (this.primitiveTypes == null) {
            this.primitiveTypesBuffer = new ByteArrayOutputStream(128);
            this.primitiveTypes = new DataOutputStream(this.primitiveTypesBuffer);
        }
    }

    private void computePutField() {
        this.currentPutField = new EmulatedFieldsForDumping(this, this.currentClass);
    }

    private int dumpCycle(Object obj) throws IOException {
        int i = this.objectsWritten.get(obj);
        if (i != -1) {
            writeCyclicReference(i);
            return i;
        }
        return -1;
    }

    private int nextHandle() {
        int i = this.currentHandle;
        this.currentHandle = i + 1;
        return i;
    }

    private int registerObjectWritten(Object obj) {
        int nextHandle = nextHandle();
        this.objectsWritten.put(obj, nextHandle);
        return nextHandle;
    }

    private void removeUnsharedReference(Object obj, int i) {
        if (i != -1) {
            this.objectsWritten.put(obj, i);
        } else {
            this.objectsWritten.remove(obj);
        }
    }

    private void resetSeenObjects() {
        this.objectsWritten = new SerializationHandleMap();
        this.currentHandle = ObjectStreamConstants.baseWireHandle;
    }

    private void resetState() {
        resetSeenObjects();
        this.nestedLevels = 0;
    }

    private int writeClassDesc(ObjectStreamClass objectStreamClass, boolean z) throws IOException {
        int i;
        if (objectStreamClass == null) {
            writeNull();
            i = -1;
        } else {
            int i2 = -1;
            if (!z) {
                i2 = dumpCycle(objectStreamClass);
            }
            i = i2;
            if (i2 == -1) {
                Class<?> forClass = objectStreamClass.forClass();
                int i3 = -1;
                if (z) {
                    i3 = this.objectsWritten.get(objectStreamClass);
                }
                int registerObjectWritten = registerObjectWritten(objectStreamClass);
                if (objectStreamClass.isProxy()) {
                    this.output.writeByte(125);
                    Class<?>[] interfaces = forClass.getInterfaces();
                    this.output.writeInt(interfaces.length);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= interfaces.length) {
                            break;
                        }
                        this.output.writeUTF(interfaces[i5].getName());
                        i4 = i5 + 1;
                    }
                    annotateProxyClass(forClass);
                    this.output.writeByte(120);
                    writeClassDesc(this.proxyClassDesc, false);
                    i = registerObjectWritten;
                    if (z) {
                        removeUnsharedReference(objectStreamClass, i3);
                        return registerObjectWritten;
                    }
                } else {
                    this.output.writeByte(114);
                    if (this.protocolVersion == 1) {
                        writeNewClassDesc(objectStreamClass);
                    } else {
                        this.primitiveTypes = this.output;
                        writeClassDescriptor(objectStreamClass);
                        this.primitiveTypes = null;
                    }
                    annotateClass(forClass);
                    drain();
                    this.output.writeByte(120);
                    writeClassDesc(objectStreamClass.getSuperclass(), z);
                    i = registerObjectWritten;
                    if (z) {
                        removeUnsharedReference(objectStreamClass, i3);
                        return registerObjectWritten;
                    }
                }
            }
        }
        return i;
    }

    private void writeCyclicReference(int i) throws IOException {
        this.output.writeByte(113);
        this.output.writeInt(i);
    }

    private ObjectStreamClass writeEnumDesc(ObjectStreamClass objectStreamClass, boolean z) throws IOException {
        objectStreamClass.setFlags((byte) 18);
        int i = -1;
        if (z) {
            i = this.objectsWritten.get(objectStreamClass);
        }
        int i2 = -1;
        if (!z) {
            i2 = dumpCycle(objectStreamClass);
        }
        if (i2 == -1) {
            Class<?> forClass = objectStreamClass.forClass();
            registerObjectWritten(objectStreamClass);
            this.output.writeByte(114);
            if (this.protocolVersion == 1) {
                writeNewClassDesc(objectStreamClass);
            } else {
                this.primitiveTypes = this.output;
                writeClassDescriptor(objectStreamClass);
                this.primitiveTypes = null;
            }
            annotateClass(forClass);
            drain();
            this.output.writeByte(120);
            ObjectStreamClass superclass = objectStreamClass.getSuperclass();
            if (superclass != null) {
                superclass.setFlags((byte) 18);
                writeEnumDesc(superclass, z);
            } else {
                this.output.writeByte(112);
            }
            if (z) {
                removeUnsharedReference(objectStreamClass, i);
            }
        }
        return objectStreamClass;
    }

    private void writeFieldDescriptors(ObjectStreamClass objectStreamClass, boolean z) throws IOException {
        Class<?> forClass = objectStreamClass.forClass();
        int i = 0;
        ObjectStreamField[] objectStreamFieldArr = null;
        if (!z) {
            i = 0;
            objectStreamFieldArr = null;
            if (forClass != ObjectStreamClass.STRINGCLASS) {
                objectStreamFieldArr = objectStreamClass.fields();
                i = objectStreamFieldArr.length;
            }
        }
        this.output.writeShort(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            ObjectStreamField objectStreamField = objectStreamFieldArr[i3];
            if (!objectStreamField.writeField(this.output)) {
                writeObject(objectStreamField.getTypeString());
            }
            i2 = i3 + 1;
        }
    }

    private void writeFieldValues(EmulatedFieldsForDumping emulatedFieldsForDumping) throws IOException {
        EmulatedFields.ObjectSlot[] slots = emulatedFieldsForDumping.emulatedFields().slots();
        int length = slots.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            EmulatedFields.ObjectSlot objectSlot = slots[i2];
            Object fieldValue = objectSlot.getFieldValue();
            Class<?> type = objectSlot.getField().getType();
            if (type == Integer.TYPE) {
                this.output.writeInt(fieldValue != null ? ((Integer) fieldValue).intValue() : 0);
            } else if (type == Byte.TYPE) {
                this.output.writeByte(fieldValue != null ? ((Byte) fieldValue).byteValue() : (byte) 0);
            } else if (type == Character.TYPE) {
                this.output.writeChar(fieldValue != null ? ((Character) fieldValue).charValue() : (char) 0);
            } else if (type == Short.TYPE) {
                this.output.writeShort(fieldValue != null ? ((Short) fieldValue).shortValue() : (short) 0);
            } else if (type == Boolean.TYPE) {
                this.output.writeBoolean(fieldValue != null ? ((Boolean) fieldValue).booleanValue() : false);
            } else if (type == Long.TYPE) {
                this.output.writeLong(fieldValue != null ? ((Long) fieldValue).longValue() : 0L);
            } else if (type == Float.TYPE) {
                this.output.writeFloat(fieldValue != null ? ((Float) fieldValue).floatValue() : 0.0f);
            } else if (type == Double.TYPE) {
                this.output.writeDouble(fieldValue != null ? ((Double) fieldValue).doubleValue() : 0.0d);
            } else {
                writeObject(fieldValue);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x005e, code lost:
        throw new java.io.InvalidClassException(r7.getName() + " doesn't have a serializable field " + r0.getName() + " of type " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeFieldValues(java.lang.Object r6, java.io.ObjectStreamClass r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.ObjectOutputStream.writeFieldValues(java.lang.Object, java.io.ObjectStreamClass):void");
    }

    private void writeHierarchy(Object obj, ObjectStreamClass objectStreamClass) throws IOException, NotActiveException {
        if (obj == null) {
            throw new NotActiveException();
        }
        List<ObjectStreamClass> hierarchy = objectStreamClass.getHierarchy();
        int size = hierarchy.size();
        for (int i = 0; i < size; i++) {
            ObjectStreamClass objectStreamClass2 = hierarchy.get(i);
            this.currentObject = obj;
            this.currentClass = objectStreamClass2;
            boolean z = false;
            try {
                if (objectStreamClass2.hasMethodWriteObject()) {
                    try {
                        objectStreamClass2.getMethodWriteObject().invoke(obj, this);
                        z = true;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e.toString());
                    } catch (InvocationTargetException e2) {
                        Throwable targetException = e2.getTargetException();
                        if (targetException instanceof RuntimeException) {
                            throw ((RuntimeException) targetException);
                        }
                        if (!(targetException instanceof Error)) {
                            throw ((IOException) targetException);
                        }
                        throw ((Error) targetException);
                    }
                }
                if (z) {
                    drain();
                    this.output.writeByte(120);
                } else {
                    defaultWriteObject();
                }
                this.currentObject = null;
                this.currentClass = null;
                this.currentPutField = null;
            } catch (Throwable th) {
                this.currentObject = null;
                this.currentClass = null;
                this.currentPutField = null;
                throw th;
            }
        }
    }

    private int writeNewArray(Object obj, Class<?> cls, ObjectStreamClass objectStreamClass, Class<?> cls2, boolean z) throws IOException {
        this.output.writeByte(117);
        writeClassDesc(objectStreamClass, false);
        int nextHandle = nextHandle();
        if (!z) {
            this.objectsWritten.put(obj, nextHandle);
        }
        if (!cls2.isPrimitive()) {
            Object[] objArr = (Object[]) obj;
            this.output.writeInt(objArr.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= objArr.length) {
                    break;
                }
                writeObject(objArr[i2]);
                i = i2 + 1;
            }
        } else if (cls2 == Integer.TYPE) {
            int[] iArr = (int[]) obj;
            this.output.writeInt(iArr.length);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= iArr.length) {
                    break;
                }
                this.output.writeInt(iArr[i4]);
                i3 = i4 + 1;
            }
        } else if (cls2 == Byte.TYPE) {
            byte[] bArr = (byte[]) obj;
            this.output.writeInt(bArr.length);
            this.output.write(bArr, 0, bArr.length);
        } else if (cls2 == Character.TYPE) {
            char[] cArr = (char[]) obj;
            this.output.writeInt(cArr.length);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= cArr.length) {
                    break;
                }
                this.output.writeChar(cArr[i6]);
                i5 = i6 + 1;
            }
        } else if (cls2 == Short.TYPE) {
            short[] sArr = (short[]) obj;
            this.output.writeInt(sArr.length);
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= sArr.length) {
                    break;
                }
                this.output.writeShort(sArr[i8]);
                i7 = i8 + 1;
            }
        } else if (cls2 == Boolean.TYPE) {
            boolean[] zArr = (boolean[]) obj;
            this.output.writeInt(zArr.length);
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= zArr.length) {
                    break;
                }
                this.output.writeBoolean(zArr[i10]);
                i9 = i10 + 1;
            }
        } else if (cls2 == Long.TYPE) {
            long[] jArr = (long[]) obj;
            this.output.writeInt(jArr.length);
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= jArr.length) {
                    break;
                }
                this.output.writeLong(jArr[i12]);
                i11 = i12 + 1;
            }
        } else if (cls2 == Float.TYPE) {
            float[] fArr = (float[]) obj;
            this.output.writeInt(fArr.length);
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= fArr.length) {
                    break;
                }
                this.output.writeFloat(fArr[i14]);
                i13 = i14 + 1;
            }
        } else if (cls2 != Double.TYPE) {
            throw new InvalidClassException("Wrong base type in " + cls.getName());
        } else {
            double[] dArr = (double[]) obj;
            this.output.writeInt(dArr.length);
            int i15 = 0;
            while (true) {
                int i16 = i15;
                if (i16 >= dArr.length) {
                    break;
                }
                this.output.writeDouble(dArr[i16]);
                i15 = i16 + 1;
            }
        }
        return nextHandle;
    }

    private int writeNewClass(Class<?> cls, boolean z) throws IOException {
        this.output.writeByte(118);
        ObjectStreamClass lookupStreamClass = ObjectStreamClass.lookupStreamClass(cls);
        if (lookupStreamClass.isEnum()) {
            writeEnumDesc(lookupStreamClass, z);
        } else {
            writeClassDesc(lookupStreamClass, z);
        }
        int nextHandle = nextHandle();
        if (!z) {
            this.objectsWritten.put(cls, nextHandle);
        }
        return nextHandle;
    }

    private void writeNewClassDesc(ObjectStreamClass objectStreamClass) throws IOException {
        this.output.writeUTF(objectStreamClass.getName());
        this.output.writeLong(objectStreamClass.getSerialVersionUID());
        byte flags = objectStreamClass.getFlags();
        boolean isExternalizable = objectStreamClass.isExternalizable();
        byte b = flags;
        if (isExternalizable) {
            b = this.protocolVersion == 1 ? (byte) (flags & (-9)) : (byte) (flags | 8);
        }
        this.output.writeByte(b);
        if (18 != objectStreamClass.getFlags()) {
            writeFieldDescriptors(objectStreamClass, isExternalizable);
        } else {
            this.output.writeShort(0);
        }
    }

    private int writeNewEnum(Object obj, Class<?> cls, boolean z) throws IOException {
        EmulatedFieldsForDumping emulatedFieldsForDumping = this.currentPutField;
        this.currentPutField = null;
        this.output.writeByte(126);
        while (cls != null && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        ObjectStreamClass lookup = ObjectStreamClass.lookup(cls);
        writeEnumDesc(lookup, z);
        int i = -1;
        if (z) {
            i = this.objectsWritten.get(obj);
        }
        int registerObjectWritten = registerObjectWritten(obj);
        ObjectStreamField[] fields = lookup.getSuperclass().fields();
        if (fields != null && fields.length > 1) {
            Field checkAndGetReflectionField = lookup.getSuperclass().checkAndGetReflectionField(fields[1]);
            if (checkAndGetReflectionField == null) {
                throw new NoSuchFieldError();
            }
            try {
                String str = (String) checkAndGetReflectionField.get(obj);
                int i2 = -1;
                if (!z) {
                    i2 = dumpCycle(str);
                }
                if (i2 == -1) {
                    writeNewString(str, z);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
        if (z) {
            removeUnsharedReference(obj, i);
        }
        this.currentPutField = emulatedFieldsForDumping;
        return registerObjectWritten;
    }

    private void writeNewException(Exception exc) throws IOException {
        this.output.writeByte(123);
        resetSeenObjects();
        writeObjectInternal(exc, false, false, false);
        resetSeenObjects();
    }

    private int writeNewObject(Object obj, Class<?> cls, ObjectStreamClass objectStreamClass, boolean z) throws IOException {
        boolean z2 = true;
        EmulatedFieldsForDumping emulatedFieldsForDumping = this.currentPutField;
        this.currentPutField = null;
        boolean isExternalizable = objectStreamClass.isExternalizable();
        boolean isSerializable = objectStreamClass.isSerializable();
        if (isExternalizable || isSerializable) {
            this.output.writeByte(115);
            writeClassDesc(objectStreamClass, false);
            int i = -1;
            if (z) {
                i = this.objectsWritten.get(obj);
            }
            int registerObjectWritten = registerObjectWritten(obj);
            this.currentObject = obj;
            this.currentClass = objectStreamClass;
            try {
                if (isExternalizable) {
                    if (this.protocolVersion != 1) {
                        z2 = false;
                    }
                    if (z2) {
                        this.primitiveTypes = this.output;
                    }
                    ((Externalizable) obj).writeExternal(this);
                    if (z2) {
                        this.primitiveTypes = null;
                    } else {
                        drain();
                        this.output.writeByte(120);
                    }
                } else {
                    writeHierarchy(obj, this.currentClass);
                }
                return registerObjectWritten;
            } finally {
                if (z) {
                    removeUnsharedReference(obj, i);
                }
                this.currentObject = null;
                this.currentClass = null;
                this.currentPutField = emulatedFieldsForDumping;
            }
        }
        throw new NotSerializableException(cls.getName());
    }

    private int writeNewString(String str, boolean z) throws IOException {
        byte[] bArr;
        int i;
        long countBytes = ModifiedUtf8.countBytes(str, false);
        if (countBytes <= 65535) {
            bArr = new byte[((int) countBytes) + 3];
            int i2 = 0 + 1;
            bArr[0] = 116;
            Memory.pokeShort(bArr, i2, (short) countBytes, ByteOrder.BIG_ENDIAN);
            i = i2 + 2;
        } else {
            bArr = new byte[((int) countBytes) + 9];
            int i3 = 0 + 1;
            bArr[0] = 124;
            Memory.pokeLong(bArr, i3, countBytes, ByteOrder.BIG_ENDIAN);
            i = i3 + 8;
        }
        ModifiedUtf8.encode(bArr, i, str);
        this.output.write(bArr, 0, bArr.length);
        int nextHandle = nextHandle();
        if (!z) {
            this.objectsWritten.put(str, nextHandle);
        }
        return nextHandle;
    }

    private void writeNull() throws IOException {
        this.output.writeByte(112);
    }

    private void writeObject(Object obj, boolean z) throws IOException {
        boolean z2 = true;
        if (this.primitiveTypes != this.output) {
            z2 = false;
        }
        if (z2) {
            this.primitiveTypes = null;
        }
        if (this.subclassOverridingImplementation && !z) {
            writeObjectOverride(obj);
            return;
        }
        try {
            drain();
            writeObjectInternal(obj, z, true, true);
            if (z2) {
                this.primitiveTypes = this.output;
            }
        } catch (IOException e) {
            if (this.nestedLevels == 0) {
                try {
                    writeNewException(e);
                } catch (IOException e2) {
                }
            }
            throw e;
        }
    }

    private int writeObjectInternal(Object obj, boolean z, boolean z2, boolean z3) throws IOException {
        Object obj2;
        int dumpCycle;
        if (obj == null) {
            writeNull();
            return -1;
        } else if (z || (dumpCycle = dumpCycle(obj)) == -1) {
            Class<?> cls = obj.getClass();
            ObjectStreamClass lookupStreamClass = ObjectStreamClass.lookupStreamClass(cls);
            this.nestedLevels++;
            try {
                if (!this.enableReplace || !z3) {
                    if (cls == ObjectStreamClass.CLASSCLASS) {
                        return writeNewClass((Class) obj, z);
                    }
                    if (cls == ObjectStreamClass.OBJECTSTREAMCLASSCLASS) {
                        return writeClassDesc((ObjectStreamClass) obj, z);
                    }
                }
                if (lookupStreamClass.isSerializable() && z2 && lookupStreamClass.hasMethodWriteReplace()) {
                    try {
                        obj2 = lookupStreamClass.getMethodWriteReplace().invoke(obj, null);
                    } catch (IllegalAccessException e) {
                        obj2 = obj;
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
                    if (obj2 != obj) {
                        int writeObjectInternal = writeObjectInternal(obj2, false, false, z3);
                        if (writeObjectInternal != -1) {
                            this.objectsWritten.put(obj, writeObjectInternal);
                        }
                        return writeObjectInternal;
                    }
                }
                if (this.enableReplace && z3) {
                    Object replaceObject = replaceObject(obj);
                    if (replaceObject != obj) {
                        int writeObjectInternal2 = writeObjectInternal(replaceObject, false, z2, false);
                        if (writeObjectInternal2 != -1) {
                            this.objectsWritten.put(obj, writeObjectInternal2);
                        }
                        return writeObjectInternal2;
                    }
                }
                return cls == ObjectStreamClass.CLASSCLASS ? writeNewClass((Class) obj, z) : cls == ObjectStreamClass.OBJECTSTREAMCLASSCLASS ? writeClassDesc((ObjectStreamClass) obj, z) : cls == ObjectStreamClass.STRINGCLASS ? writeNewString((String) obj, z) : cls.isArray() ? writeNewArray(obj, cls, lookupStreamClass, cls.getComponentType(), z) : obj instanceof Enum ? writeNewEnum(obj, cls, z) : writeNewObject(obj, cls, lookupStreamClass, z);
            } finally {
                this.nestedLevels--;
            }
        } else {
            return dumpCycle;
        }
    }

    protected void annotateClass(Class<?> cls) throws IOException {
    }

    protected void annotateProxyClass(Class<?> cls) throws IOException {
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.output.close();
    }

    public void defaultWriteObject() throws IOException {
        if (this.currentObject == null) {
            throw new NotActiveException();
        }
        writeFieldValues(this.currentObject, this.currentClass);
    }

    protected void drain() throws IOException {
        if (this.primitiveTypes == null || this.primitiveTypesBuffer == null) {
            return;
        }
        int i = 0;
        byte[] byteArray = this.primitiveTypesBuffer.toByteArray();
        while (i < byteArray.length) {
            int length = byteArray.length - i > 1024 ? 1024 : byteArray.length - i;
            if (length < 256) {
                this.output.writeByte(119);
                this.output.writeByte((byte) length);
            } else {
                this.output.writeByte(122);
                this.output.writeInt(length);
            }
            this.output.write(byteArray, i, length);
            i += length;
        }
        this.primitiveTypes = null;
        this.primitiveTypesBuffer = null;
    }

    protected boolean enableReplaceObject(boolean z) {
        boolean z2 = this.enableReplace;
        this.enableReplace = z;
        return z2;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        drain();
        this.output.flush();
    }

    public PutField putFields() throws IOException {
        if (this.currentObject == null) {
            throw new NotActiveException();
        }
        if (this.currentPutField == null) {
            computePutField();
        }
        return this.currentPutField;
    }

    protected Object replaceObject(Object obj) throws IOException {
        return obj;
    }

    public void reset() throws IOException {
        drain();
        this.output.writeByte(121);
        resetState();
    }

    public void useProtocolVersion(int i) throws IOException {
        if (!this.objectsWritten.isEmpty()) {
            throw new IllegalStateException("Cannot set protocol version when stream in use");
        }
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Unknown protocol: " + i);
        }
        this.protocolVersion = i;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.write(bArr, i, i2);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeBoolean(z);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeByte(i);
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeChar(i);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeChars(str);
    }

    protected void writeClassDescriptor(ObjectStreamClass objectStreamClass) throws IOException {
        writeNewClassDesc(objectStreamClass);
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeDouble(d);
    }

    public void writeFields() throws IOException {
        if (this.currentPutField == null) {
            throw new NotActiveException();
        }
        writeFieldValues(this.currentPutField);
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeFloat(f);
    }

    @Override // java.io.DataOutput
    public void writeInt(int i) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeInt(i);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeLong(j);
    }

    @Override // java.io.ObjectOutput
    public final void writeObject(Object obj) throws IOException {
        writeObject(obj, false);
    }

    protected void writeObjectOverride(Object obj) throws IOException {
        if (!this.subclassOverridingImplementation) {
            throw new IOException();
        }
    }

    @Override // java.io.DataOutput
    public void writeShort(int i) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeShort(i);
    }

    protected void writeStreamHeader() throws IOException {
        this.output.writeShort(ObjectStreamConstants.STREAM_MAGIC);
        this.output.writeShort(5);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        checkWritePrimitiveTypes();
        this.primitiveTypes.writeUTF(str);
    }

    public void writeUnshared(Object obj) throws IOException {
        writeObject(obj, true);
    }
}
