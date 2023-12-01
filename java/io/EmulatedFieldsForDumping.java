package java.io;

import java.io.EmulatedFields;
import java.io.ObjectOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/io/EmulatedFieldsForDumping.class */
public class EmulatedFieldsForDumping extends ObjectOutputStream.PutField {
    private EmulatedFields emulatedFields;
    private final ObjectOutputStream oos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmulatedFieldsForDumping(ObjectOutputStream objectOutputStream, ObjectStreamClass objectStreamClass) {
        this.oos = objectOutputStream;
        this.emulatedFields = new EmulatedFields(objectStreamClass.fields(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmulatedFields emulatedFields() {
        return this.emulatedFields;
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, byte b) {
        this.emulatedFields.put(str, b);
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, char c) {
        this.emulatedFields.put(str, c);
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, double d) {
        this.emulatedFields.put(str, d);
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, float f) {
        this.emulatedFields.put(str, f);
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, int i) {
        this.emulatedFields.put(str, i);
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, long j) {
        this.emulatedFields.put(str, j);
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, Object obj) {
        this.emulatedFields.put(str, obj);
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, short s) {
        this.emulatedFields.put(str, s);
    }

    @Override // java.io.ObjectOutputStream.PutField
    public void put(String str, boolean z) {
        this.emulatedFields.put(str, z);
    }

    @Override // java.io.ObjectOutputStream.PutField
    @Deprecated
    public void write(ObjectOutput objectOutput) throws IOException {
        if (!objectOutput.equals(this.oos)) {
            throw new IllegalArgumentException("Attempting to write to a different stream than the one that created this PutField");
        }
        EmulatedFields.ObjectSlot[] slots = this.emulatedFields.slots();
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
                objectOutput.writeInt(fieldValue != null ? ((Integer) fieldValue).intValue() : 0);
            } else if (type == Byte.TYPE) {
                objectOutput.writeByte(fieldValue != null ? ((Byte) fieldValue).byteValue() : (byte) 0);
            } else if (type == Character.TYPE) {
                objectOutput.writeChar(fieldValue != null ? ((Character) fieldValue).charValue() : (char) 0);
            } else if (type == Short.TYPE) {
                objectOutput.writeShort(fieldValue != null ? ((Short) fieldValue).shortValue() : (short) 0);
            } else if (type == Boolean.TYPE) {
                objectOutput.writeBoolean(fieldValue != null ? ((Boolean) fieldValue).booleanValue() : false);
            } else if (type == Long.TYPE) {
                objectOutput.writeLong(fieldValue != null ? ((Long) fieldValue).longValue() : 0L);
            } else if (type == Float.TYPE) {
                objectOutput.writeFloat(fieldValue != null ? ((Float) fieldValue).floatValue() : 0.0f);
            } else if (type == Double.TYPE) {
                objectOutput.writeDouble(fieldValue != null ? ((Double) fieldValue).doubleValue() : 0.0d);
            } else {
                objectOutput.writeObject(fieldValue);
            }
            i = i2 + 1;
        }
    }
}
