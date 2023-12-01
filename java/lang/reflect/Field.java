package java.lang.reflect;

import java.lang.annotation.Annotation;
import java.util.Comparator;
import java.util.List;
import libcore.reflect.AnnotationAccess;
import libcore.reflect.GenericSignatureParser;
import libcore.reflect.Types;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/Field.class */
public final class Field extends AccessibleObject implements Member {
    public static final Comparator<Field> ORDER_BY_NAME_AND_DECLARING_CLASS = new Comparator<Field>() { // from class: java.lang.reflect.Field.1
        @Override // java.util.Comparator
        public int compare(Field field, Field field2) {
            int i;
            if (field == field2) {
                i = 0;
            } else {
                int compareTo = field.getName().compareTo(field2.getName());
                i = compareTo;
                if (compareTo == 0) {
                    Class<?> declaringClass = field.getDeclaringClass();
                    Class<?> declaringClass2 = field2.getDeclaringClass();
                    if (declaringClass == declaringClass2) {
                        return 0;
                    }
                    return declaringClass.getName().compareTo(declaringClass2.getName());
                }
            }
            return i;
        }
    };
    private final ArtField artField;

    public Field(ArtField artField) {
        if (artField == null) {
            throw new NullPointerException("artField == null");
        }
        this.artField = artField;
    }

    private native Object get(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native boolean getBoolean(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native byte getByte(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native char getChar(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native double getDouble(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native float getFloat(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native int getInt(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native long getLong(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native short getShort(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private String getSignature() {
        return Types.getSignature(getType());
    }

    private native void set(Object obj, Object obj2, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native void setBoolean(Object obj, boolean z, boolean z2) throws IllegalAccessException, IllegalArgumentException;

    private native void setByte(Object obj, byte b, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native void setChar(Object obj, char c, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native void setDouble(Object obj, double d, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native void setFloat(Object obj, float f, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native void setInt(Object obj, int i, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native void setLong(Object obj, long j, boolean z) throws IllegalAccessException, IllegalArgumentException;

    private native void setShort(Object obj, short s, boolean z) throws IllegalAccessException, IllegalArgumentException;

    public boolean equals(Object obj) {
        return (obj instanceof Field) && this.artField == ((Field) obj).artField;
    }

    public Object get(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return get(obj, isAccessible());
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        if (cls == null) {
            throw new NullPointerException("annotationType == null");
        }
        return (A) AnnotationAccess.getDeclaredAnnotation(this, cls);
    }

    public boolean getBoolean(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return getBoolean(obj, isAccessible());
    }

    public byte getByte(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return getByte(obj, isAccessible());
    }

    public char getChar(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return getChar(obj, isAccessible());
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        List<Annotation> declaredAnnotations = AnnotationAccess.getDeclaredAnnotations(this);
        return (Annotation[]) declaredAnnotations.toArray(new Annotation[declaredAnnotations.size()]);
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.artField.getDeclaringClass();
    }

    public int getDexFieldIndex() {
        return this.artField.getDexFieldIndex();
    }

    public double getDouble(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return getDouble(obj, isAccessible());
    }

    public float getFloat(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return getFloat(obj, isAccessible());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.reflect.Type] */
    public Type getGenericType() {
        String signature = AnnotationAccess.getSignature(this);
        Class<?> declaringClass = getDeclaringClass();
        GenericSignatureParser genericSignatureParser = new GenericSignatureParser(declaringClass.getClassLoader());
        genericSignatureParser.parseForField(declaringClass, signature);
        ?? r0 = genericSignatureParser.fieldType;
        Class<?> cls = r0;
        if (r0 == 0) {
            cls = getType();
        }
        return cls;
    }

    public int getInt(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return getInt(obj, isAccessible());
    }

    public long getLong(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return getLong(obj, isAccessible());
    }

    @Override // java.lang.reflect.Member
    public int getModifiers() {
        return this.artField.getAccessFlags() & 65535;
    }

    @Override // java.lang.reflect.Member
    public String getName() {
        return this.artField.getName();
    }

    public int getOffset() {
        return this.artField.getOffset();
    }

    public short getShort(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return getShort(obj, isAccessible());
    }

    public Class<?> getType() {
        return this.artField.getType();
    }

    public int hashCode() {
        return getDeclaringClass().getName().hashCode() ^ getName().hashCode();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        if (cls == null) {
            throw new NullPointerException("annotationType == null");
        }
        return AnnotationAccess.isDeclaredAnnotationPresent(this, cls);
    }

    public boolean isEnumConstant() {
        return (this.artField.getAccessFlags() & 16384) != 0;
    }

    @Override // java.lang.reflect.Member
    public boolean isSynthetic() {
        return (this.artField.getAccessFlags() & 4096) != 0;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        set(obj, obj2, isAccessible());
    }

    public void setBoolean(Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException {
        setBoolean(obj, z, isAccessible());
    }

    public void setByte(Object obj, byte b) throws IllegalAccessException, IllegalArgumentException {
        setByte(obj, b, isAccessible());
    }

    public void setChar(Object obj, char c) throws IllegalAccessException, IllegalArgumentException {
        setChar(obj, c, isAccessible());
    }

    public void setDouble(Object obj, double d) throws IllegalAccessException, IllegalArgumentException {
        setDouble(obj, d, isAccessible());
    }

    public void setFloat(Object obj, float f) throws IllegalAccessException, IllegalArgumentException {
        setFloat(obj, f, isAccessible());
    }

    public void setInt(Object obj, int i) throws IllegalAccessException, IllegalArgumentException {
        setInt(obj, i, isAccessible());
    }

    public void setLong(Object obj, long j) throws IllegalAccessException, IllegalArgumentException {
        setLong(obj, j, isAccessible());
    }

    public void setShort(Object obj, short s) throws IllegalAccessException, IllegalArgumentException {
        setShort(obj, s, isAccessible());
    }

    public String toGenericString() {
        StringBuilder sb = new StringBuilder(80);
        int modifiers = getModifiers();
        if (modifiers != 0) {
            sb.append(Modifier.toString(modifiers)).append(' ');
        }
        Types.appendGenericType(sb, getGenericType());
        sb.append(' ');
        sb.append(getDeclaringClass().getName()).append('.').append(getName());
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Modifier.toString(getModifiers()));
        if (sb.length() != 0) {
            sb.append(' ');
        }
        Types.appendTypeName(sb, getType());
        sb.append(' ');
        sb.append(getDeclaringClass().getName());
        sb.append('.');
        sb.append(getName());
        return sb.toString();
    }
}
