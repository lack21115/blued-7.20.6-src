package libcore.reflect;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/AnnotationMember.class */
public final class AnnotationMember implements Serializable {
    protected static final char ARRAY = '[';
    protected static final char ERROR = '!';
    protected static final Object NO_VALUE = DefaultValues.NO_VALUE;
    protected static final char OTHER = '*';
    protected transient Method definingMethod;
    protected transient Class<?> elementType;
    protected final String name;
    protected final char tag;
    protected final Object value;

    /* loaded from: source-2895416-dex2jar.jar:libcore/reflect/AnnotationMember$DefaultValues.class */
    private enum DefaultValues {
        NO_VALUE
    }

    public AnnotationMember(String str, Object obj) {
        this.name = str;
        this.value = obj == null ? NO_VALUE : obj;
        if (this.value instanceof Throwable) {
            this.tag = '!';
        } else if (this.value.getClass().isArray()) {
            this.tag = '[';
        } else {
            this.tag = '*';
        }
    }

    public AnnotationMember(String str, Object obj, Class cls, Method method) {
        this(str, obj);
        this.definingMethod = method;
        if (cls == Integer.TYPE) {
            this.elementType = Integer.class;
        } else if (cls == Boolean.TYPE) {
            this.elementType = Boolean.class;
        } else if (cls == Character.TYPE) {
            this.elementType = Character.class;
        } else if (cls == Float.TYPE) {
            this.elementType = Float.class;
        } else if (cls == Double.TYPE) {
            this.elementType = Double.class;
        } else if (cls == Long.TYPE) {
            this.elementType = Long.class;
        } else if (cls == Short.TYPE) {
            this.elementType = Short.class;
        } else if (cls == Byte.TYPE) {
            this.elementType = Byte.class;
        } else {
            this.elementType = cls;
        }
    }

    public Object copyValue() throws Throwable {
        if (this.tag != '[' || Array.getLength(this.value) == 0) {
            return this.value;
        }
        Class<?> cls = this.value.getClass();
        return cls == int[].class ? ((int[]) this.value).clone() : cls == byte[].class ? ((byte[]) this.value).clone() : cls == short[].class ? ((short[]) this.value).clone() : cls == long[].class ? ((long[]) this.value).clone() : cls == char[].class ? ((char[]) this.value).clone() : cls == boolean[].class ? ((boolean[]) this.value).clone() : cls == float[].class ? ((float[]) this.value).clone() : cls == double[].class ? ((double[]) this.value).clone() : ((Object[]) this.value).clone();
    }

    public boolean equalArrayValue(Object obj) {
        boolean z;
        if ((this.value instanceof Object[]) && (obj instanceof Object[])) {
            z = Arrays.equals((Object[]) this.value, (Object[]) obj);
        } else {
            Class<?> cls = this.value.getClass();
            z = false;
            if (cls == obj.getClass()) {
                if (cls == int[].class) {
                    return Arrays.equals((int[]) this.value, (int[]) obj);
                }
                if (cls == byte[].class) {
                    return Arrays.equals((byte[]) this.value, (byte[]) obj);
                }
                if (cls == short[].class) {
                    return Arrays.equals((short[]) this.value, (short[]) obj);
                }
                if (cls == long[].class) {
                    return Arrays.equals((long[]) this.value, (long[]) obj);
                }
                if (cls == char[].class) {
                    return Arrays.equals((char[]) this.value, (char[]) obj);
                }
                if (cls == boolean[].class) {
                    return Arrays.equals((boolean[]) this.value, (boolean[]) obj);
                }
                if (cls == float[].class) {
                    return Arrays.equals((float[]) this.value, (float[]) obj);
                }
                z = false;
                if (cls == double[].class) {
                    return Arrays.equals((double[]) this.value, (double[]) obj);
                }
            }
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            z = true;
        } else {
            z = false;
            if (obj instanceof AnnotationMember) {
                AnnotationMember annotationMember = (AnnotationMember) obj;
                z = false;
                if (this.name.equals(annotationMember.name)) {
                    z = false;
                    if (this.tag == annotationMember.tag) {
                        if (this.tag == '[') {
                            return equalArrayValue(annotationMember.value);
                        }
                        z = false;
                        if (this.tag != '!') {
                            return this.value.equals(annotationMember.value);
                        }
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 127;
        if (this.tag == '[') {
            Class<?> cls = this.value.getClass();
            return cls == int[].class ? Arrays.hashCode((int[]) this.value) ^ hashCode : cls == byte[].class ? Arrays.hashCode((byte[]) this.value) ^ hashCode : cls == short[].class ? Arrays.hashCode((short[]) this.value) ^ hashCode : cls == long[].class ? Arrays.hashCode((long[]) this.value) ^ hashCode : cls == char[].class ? Arrays.hashCode((char[]) this.value) ^ hashCode : cls == boolean[].class ? Arrays.hashCode((boolean[]) this.value) ^ hashCode : cls == float[].class ? Arrays.hashCode((float[]) this.value) ^ hashCode : cls == double[].class ? Arrays.hashCode((double[]) this.value) ^ hashCode : Arrays.hashCode((Object[]) this.value) ^ hashCode;
        }
        return this.value.hashCode() ^ hashCode;
    }

    public void rethrowError() throws Throwable {
        if (this.tag == '!') {
            if (this.value instanceof TypeNotPresentException) {
                TypeNotPresentException typeNotPresentException = (TypeNotPresentException) this.value;
                throw new TypeNotPresentException(typeNotPresentException.typeName(), typeNotPresentException.getCause());
            } else if (this.value instanceof EnumConstantNotPresentException) {
                EnumConstantNotPresentException enumConstantNotPresentException = (EnumConstantNotPresentException) this.value;
                throw new EnumConstantNotPresentException(enumConstantNotPresentException.enumType(), enumConstantNotPresentException.constantName());
            } else if (this.value instanceof ArrayStoreException) {
                throw new ArrayStoreException(((ArrayStoreException) this.value).getMessage());
            } else {
                Throwable th = (Throwable) this.value;
                StackTraceElement[] stackTrace = th.getStackTrace();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(stackTrace == null ? 512 : (stackTrace.length + 1) * 80);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(th);
                objectOutputStream.flush();
                objectOutputStream.close();
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                Throwable th2 = (Throwable) objectInputStream.readObject();
                objectInputStream.close();
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AnnotationMember setDefinition(AnnotationMember annotationMember) {
        this.definingMethod = annotationMember.definingMethod;
        this.elementType = annotationMember.elementType;
        return this;
    }

    public String toString() {
        if (this.tag != '[') {
            return this.name + "=" + this.value;
        }
        StringBuilder sb = new StringBuilder(80);
        sb.append(this.name).append("=[");
        int length = Array.getLength(this.value);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.append("]").toString();
            }
            if (i2 != 0) {
                sb.append(", ");
            }
            sb.append(Array.get(this.value, i2));
            i = i2 + 1;
        }
    }

    public Object validateValue() throws Throwable {
        if (this.tag == '!') {
            rethrowError();
        }
        if (this.value == NO_VALUE) {
            return null;
        }
        if (this.elementType == this.value.getClass() || this.elementType.isInstance(this.value)) {
            return copyValue();
        }
        throw new AnnotationTypeMismatchException(this.definingMethod, this.value.getClass().getName());
    }
}
