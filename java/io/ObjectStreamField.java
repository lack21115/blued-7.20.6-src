package java.io;

import java.lang.ref.WeakReference;

/* loaded from: source-2895416-dex2jar.jar:java/io/ObjectStreamField.class */
public class ObjectStreamField implements Comparable<Object> {
    private boolean isDeserialized;
    private String name;
    int offset;
    private Object type;
    private String typeString;
    private boolean unshared;

    public ObjectStreamField(String str, Class<?> cls) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (cls == null) {
            throw new NullPointerException("cl == null");
        }
        this.name = str;
        this.type = new WeakReference(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.ref.WeakReference] */
    public ObjectStreamField(String str, Class<?> cls, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (cls == null) {
            throw new NullPointerException("cl == null");
        }
        this.name = str;
        this.type = cls.getClassLoader() != null ? new WeakReference(cls) : cls;
        this.unshared = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectStreamField(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("name == null");
        }
        this.name = str2;
        this.typeString = str.replace('.', '/').intern();
        defaultResolve();
        this.isDeserialized = true;
    }

    private boolean defaultResolve() {
        switch (this.typeString.charAt(0)) {
            case 'B':
                this.type = Byte.TYPE;
                return true;
            case 'C':
                this.type = Character.TYPE;
                return true;
            case 'D':
                this.type = Double.TYPE;
                return true;
            case 'F':
                this.type = Float.TYPE;
                return true;
            case 'I':
                this.type = Integer.TYPE;
                return true;
            case 'J':
                this.type = Long.TYPE;
                return true;
            case 'S':
                this.type = Short.TYPE;
                return true;
            case 'Z':
                this.type = Boolean.TYPE;
                return true;
            default:
                this.type = Object.class;
                return false;
        }
    }

    private char typeCodeOf(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return 'I';
        }
        if (cls == Byte.TYPE) {
            return 'B';
        }
        if (cls == Character.TYPE) {
            return 'C';
        }
        if (cls == Short.TYPE) {
            return 'S';
        }
        if (cls == Boolean.TYPE) {
            return 'Z';
        }
        if (cls == Long.TYPE) {
            return 'J';
        }
        if (cls == Float.TYPE) {
            return 'F';
        }
        if (cls == Double.TYPE) {
            return 'D';
        }
        return cls.isArray() ? '[' : 'L';
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        ObjectStreamField objectStreamField = (ObjectStreamField) obj;
        boolean isPrimitive = isPrimitive();
        return isPrimitive != objectStreamField.isPrimitive() ? isPrimitive ? -1 : 1 : getName().compareTo(objectStreamField.getName());
    }

    public String getName() {
        return this.name;
    }

    public int getOffset() {
        return this.offset;
    }

    public Class<?> getType() {
        Class<?> typeInternal = getTypeInternal();
        Class<?> cls = typeInternal;
        if (this.isDeserialized) {
            cls = typeInternal;
            if (!typeInternal.isPrimitive()) {
                cls = Object.class;
            }
        }
        return cls;
    }

    public char getTypeCode() {
        return typeCodeOf(getTypeInternal());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> getTypeInternal() {
        return this.type instanceof WeakReference ? (Class) ((WeakReference) this.type).get() : (Class) this.type;
    }

    public String getTypeString() {
        if (isPrimitive()) {
            return null;
        }
        if (this.typeString == null) {
            Class<?> typeInternal = getTypeInternal();
            String replace = typeInternal.getName().replace('.', '/');
            if (!typeInternal.isArray()) {
                replace = "L" + replace + ';';
            }
            this.typeString = replace.intern();
        }
        return this.typeString;
    }

    public boolean isPrimitive() {
        Class<?> typeInternal = getTypeInternal();
        return typeInternal != null && typeInternal.isPrimitive();
    }

    public boolean isUnshared() {
        return this.unshared;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.ref.WeakReference] */
    public void resolve(ClassLoader classLoader) {
        if (this.typeString == null && isPrimitive()) {
            this.typeString = String.valueOf(getTypeCode());
        }
        if (this.typeString.length() == 1 && defaultResolve()) {
            return;
        }
        String replace = this.typeString.replace('/', '.');
        String str = replace;
        if (replace.charAt(0) == 'L') {
            str = replace.substring(1, replace.length() - 1);
        }
        try {
            Class<?> cls = Class.forName(str, false, classLoader);
            if (cls.getClassLoader() != null) {
                cls = new WeakReference(cls);
            }
            this.type = cls;
        } catch (ClassNotFoundException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOffset(int i) {
        this.offset = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUnshared(boolean z) {
        this.unshared = z;
    }

    public String toString() {
        return getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean writeField(DataOutputStream dataOutputStream) throws IOException {
        Class<?> typeInternal = getTypeInternal();
        dataOutputStream.writeByte(typeCodeOf(typeInternal));
        dataOutputStream.writeUTF(this.name);
        return typeInternal != null && typeInternal.isPrimitive();
    }
}
