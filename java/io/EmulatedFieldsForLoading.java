package java.io;

import java.io.ObjectInputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/io/EmulatedFieldsForLoading.class */
public class EmulatedFieldsForLoading extends ObjectInputStream.GetField {
    private EmulatedFields emulatedFields;
    private ObjectStreamClass streamClass;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmulatedFieldsForLoading(ObjectStreamClass objectStreamClass) {
        this.streamClass = objectStreamClass;
        this.emulatedFields = new EmulatedFields(objectStreamClass.getLoadFields(), objectStreamClass.fields());
    }

    @Override // java.io.ObjectInputStream.GetField
    public boolean defaulted(String str) throws IOException, IllegalArgumentException {
        return this.emulatedFields.defaulted(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmulatedFields emulatedFields() {
        return this.emulatedFields;
    }

    @Override // java.io.ObjectInputStream.GetField
    public byte get(String str, byte b) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, b);
    }

    @Override // java.io.ObjectInputStream.GetField
    public char get(String str, char c2) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, c2);
    }

    @Override // java.io.ObjectInputStream.GetField
    public double get(String str, double d) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, d);
    }

    @Override // java.io.ObjectInputStream.GetField
    public float get(String str, float f) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, f);
    }

    @Override // java.io.ObjectInputStream.GetField
    public int get(String str, int i) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, i);
    }

    @Override // java.io.ObjectInputStream.GetField
    public long get(String str, long j) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, j);
    }

    @Override // java.io.ObjectInputStream.GetField
    public Object get(String str, Object obj) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, obj);
    }

    @Override // java.io.ObjectInputStream.GetField
    public short get(String str, short s) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, s);
    }

    @Override // java.io.ObjectInputStream.GetField
    public boolean get(String str, boolean z) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(str, z);
    }

    @Override // java.io.ObjectInputStream.GetField
    public ObjectStreamClass getObjectStreamClass() {
        return this.streamClass;
    }
}
