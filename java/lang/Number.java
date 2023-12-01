package java.lang;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Number.class */
public abstract class Number implements Serializable {
    private static final long serialVersionUID = -8742448824652078965L;

    public byte byteValue() {
        return (byte) intValue();
    }

    public abstract double doubleValue();

    public abstract float floatValue();

    public abstract int intValue();

    public abstract long longValue();

    public short shortValue() {
        return (short) intValue();
    }
}
