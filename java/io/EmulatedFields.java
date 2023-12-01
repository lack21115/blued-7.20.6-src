package java.io;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/io/EmulatedFields.class */
public class EmulatedFields {
    private ObjectStreamField[] declaredFields;
    private ObjectSlot[] slotsToSerialize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/io/EmulatedFields$ObjectSlot.class */
    public static class ObjectSlot {
        boolean defaulted = true;
        ObjectStreamField field;
        Object fieldValue;

        ObjectSlot() {
        }

        public ObjectStreamField getField() {
            return this.field;
        }

        public Object getFieldValue() {
            return this.fieldValue;
        }
    }

    public EmulatedFields(ObjectStreamField[] objectStreamFieldArr, ObjectStreamField[] objectStreamFieldArr2) {
        buildSlots(objectStreamFieldArr);
        this.declaredFields = objectStreamFieldArr2;
    }

    private void buildSlots(ObjectStreamField[] objectStreamFieldArr) {
        this.slotsToSerialize = new ObjectSlot[objectStreamFieldArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objectStreamFieldArr.length) {
                return;
            }
            ObjectSlot objectSlot = new ObjectSlot();
            this.slotsToSerialize[i2] = objectSlot;
            objectSlot.field = objectStreamFieldArr[i2];
            i = i2 + 1;
        }
    }

    private ObjectSlot findMandatorySlot(String str, Class<?> cls) {
        ObjectSlot findSlot = findSlot(str, cls);
        if (findSlot == null || (cls == null && findSlot.field.getType().isPrimitive())) {
            throw new IllegalArgumentException("no field '" + str + "' of type " + cls);
        }
        return findSlot;
    }

    private ObjectSlot findSlot(String str, Class<?> cls) {
        ObjectStreamField objectStreamField;
        ObjectSlot objectSlot;
        boolean z = cls != null && cls.isPrimitive();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.slotsToSerialize.length) {
                if (this.declaredFields != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= this.declaredFields.length) {
                            return null;
                        }
                        objectStreamField = this.declaredFields[i4];
                        if (objectStreamField.getName().equals(str)) {
                            if (!z) {
                                if (cls == null || objectStreamField.getType().isAssignableFrom(cls)) {
                                    break;
                                }
                            } else if (cls == objectStreamField.getType()) {
                                break;
                            }
                        }
                        i3 = i4 + 1;
                    }
                    ObjectSlot objectSlot2 = new ObjectSlot();
                    objectSlot2.field = objectStreamField;
                    objectSlot2.defaulted = true;
                    return objectSlot2;
                }
                return null;
            }
            objectSlot = this.slotsToSerialize[i2];
            if (objectSlot.field.getName().equals(str)) {
                if (!z) {
                    if (cls == null || objectSlot.field.getType().isAssignableFrom(cls)) {
                        break;
                    }
                } else if (objectSlot.field.getType() == cls) {
                    break;
                }
            }
            i = i2 + 1;
        }
        return objectSlot;
    }

    public boolean defaulted(String str) throws IllegalArgumentException {
        ObjectSlot findSlot = findSlot(str, null);
        if (findSlot == null) {
            throw new IllegalArgumentException("no field '" + str + "'");
        }
        return findSlot.defaulted;
    }

    public byte get(String str, byte b) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Byte.TYPE);
        return findMandatorySlot.defaulted ? b : ((Byte) findMandatorySlot.fieldValue).byteValue();
    }

    public char get(String str, char c) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Character.TYPE);
        return findMandatorySlot.defaulted ? c : ((Character) findMandatorySlot.fieldValue).charValue();
    }

    public double get(String str, double d) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Double.TYPE);
        return findMandatorySlot.defaulted ? d : ((Double) findMandatorySlot.fieldValue).doubleValue();
    }

    public float get(String str, float f) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Float.TYPE);
        return findMandatorySlot.defaulted ? f : ((Float) findMandatorySlot.fieldValue).floatValue();
    }

    public int get(String str, int i) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Integer.TYPE);
        return findMandatorySlot.defaulted ? i : ((Integer) findMandatorySlot.fieldValue).intValue();
    }

    public long get(String str, long j) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Long.TYPE);
        return findMandatorySlot.defaulted ? j : ((Long) findMandatorySlot.fieldValue).longValue();
    }

    public Object get(String str, Object obj) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, null);
        return findMandatorySlot.defaulted ? obj : findMandatorySlot.fieldValue;
    }

    public short get(String str, short s) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Short.TYPE);
        return findMandatorySlot.defaulted ? s : ((Short) findMandatorySlot.fieldValue).shortValue();
    }

    public boolean get(String str, boolean z) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Boolean.TYPE);
        return findMandatorySlot.defaulted ? z : ((Boolean) findMandatorySlot.fieldValue).booleanValue();
    }

    public void put(String str, byte b) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Byte.TYPE);
        findMandatorySlot.fieldValue = Byte.valueOf(b);
        findMandatorySlot.defaulted = false;
    }

    public void put(String str, char c) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Character.TYPE);
        findMandatorySlot.fieldValue = Character.valueOf(c);
        findMandatorySlot.defaulted = false;
    }

    public void put(String str, double d) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Double.TYPE);
        findMandatorySlot.fieldValue = Double.valueOf(d);
        findMandatorySlot.defaulted = false;
    }

    public void put(String str, float f) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Float.TYPE);
        findMandatorySlot.fieldValue = Float.valueOf(f);
        findMandatorySlot.defaulted = false;
    }

    public void put(String str, int i) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Integer.TYPE);
        findMandatorySlot.fieldValue = Integer.valueOf(i);
        findMandatorySlot.defaulted = false;
    }

    public void put(String str, long j) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Long.TYPE);
        findMandatorySlot.fieldValue = Long.valueOf(j);
        findMandatorySlot.defaulted = false;
    }

    public void put(String str, Object obj) throws IllegalArgumentException {
        Class<?> cls = null;
        if (obj != null) {
            cls = obj.getClass();
        }
        ObjectSlot findMandatorySlot = findMandatorySlot(str, cls);
        findMandatorySlot.fieldValue = obj;
        findMandatorySlot.defaulted = false;
    }

    public void put(String str, short s) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Short.TYPE);
        findMandatorySlot.fieldValue = Short.valueOf(s);
        findMandatorySlot.defaulted = false;
    }

    public void put(String str, boolean z) throws IllegalArgumentException {
        ObjectSlot findMandatorySlot = findMandatorySlot(str, Boolean.TYPE);
        findMandatorySlot.fieldValue = Boolean.valueOf(z);
        findMandatorySlot.defaulted = false;
    }

    public ObjectSlot[] slots() {
        return this.slotsToSerialize;
    }
}
