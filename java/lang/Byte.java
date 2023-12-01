package java.lang;

@FindBugsSuppressWarnings({"DM_NUMBER_CTOR"})
/* loaded from: source-2895416-dex2jar.jar:java/lang/Byte.class */
public final class Byte extends Number implements Comparable<Byte> {
    public static final byte MAX_VALUE = Byte.MAX_VALUE;
    public static final byte MIN_VALUE = Byte.MIN_VALUE;
    public static final int SIZE = 8;
    public static final Class<Byte> TYPE = null;
    private static final Byte[] VALUES = null;
    private static final long serialVersionUID = -7183698231559129828L;
    private final byte value;

    static {
        throw new VerifyError("bad dex opcode");
    }

    public Byte(byte b) {
        this.value = b;
    }

    public Byte(String str) throws NumberFormatException {
        this(parseByte(str));
    }

    public static int compare(byte b, byte b2) {
        if (b > b2) {
            return 1;
        }
        return b < b2 ? -1 : 0;
    }

    public static Byte decode(String str) throws NumberFormatException {
        int intValue = Integer.decode(str).intValue();
        byte b = (byte) intValue;
        if (b == intValue) {
            return valueOf(b);
        }
        throw new NumberFormatException("Value out of range for byte: \"" + str + "\"");
    }

    public static byte parseByte(String str) throws NumberFormatException {
        return parseByte(str, 10);
    }

    public static byte parseByte(String str, int i) throws NumberFormatException {
        int parseInt = Integer.parseInt(str, i);
        byte b = (byte) parseInt;
        if (b == parseInt) {
            return b;
        }
        throw new NumberFormatException("Value out of range for byte: \"" + str + "\"");
    }

    public static String toHexString(byte b, boolean z) {
        return IntegralToString.byteToHexString(b, z);
    }

    public static String toString(byte b) {
        return Integer.toString(b);
    }

    public static Byte valueOf(byte b) {
        return VALUES[b + 128];
    }

    public static Byte valueOf(String str) throws NumberFormatException {
        return valueOf(parseByte(str));
    }

    public static Byte valueOf(String str, int i) throws NumberFormatException {
        return valueOf(parseByte(str, i));
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Byte b) {
        return compare(this.value, b.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    @FindBugsSuppressWarnings({"RC_REF_COMPARISON"})
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Byte) && ((Byte) obj).value == this.value;
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
