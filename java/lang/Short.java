package java.lang;

@FindBugsSuppressWarnings({"DM_NUMBER_CTOR"})
/* loaded from: source-2895416-dex2jar.jar:java/lang/Short.class */
public final class Short extends Number implements Comparable<Short> {
    public static final short MAX_VALUE = Short.MAX_VALUE;
    public static final short MIN_VALUE = Short.MIN_VALUE;
    public static final int SIZE = 16;
    private static final Short[] SMALL_VALUES = null;
    public static final Class<Short> TYPE = null;
    private static final long serialVersionUID = 7515723908773894738L;
    private final short value;

    static {
        throw new VerifyError("bad dex opcode");
    }

    public Short(String str) throws NumberFormatException {
        this(parseShort(str));
    }

    public Short(short s) {
        this.value = s;
    }

    public static int compare(short s, short s2) {
        if (s > s2) {
            return 1;
        }
        return s < s2 ? -1 : 0;
    }

    public static Short decode(String str) throws NumberFormatException {
        int intValue = Integer.decode(str).intValue();
        short s = (short) intValue;
        if (s == intValue) {
            return valueOf(s);
        }
        throw new NumberFormatException("Value out of range for short: \"" + str + "\"");
    }

    public static short parseShort(String str) throws NumberFormatException {
        return parseShort(str, 10);
    }

    public static short parseShort(String str, int i) throws NumberFormatException {
        int parseInt = Integer.parseInt(str, i);
        short s = (short) parseInt;
        if (s == parseInt) {
            return s;
        }
        throw new NumberFormatException("Value out of range for short: \"" + str + "\"");
    }

    public static short reverseBytes(short s) {
        return (short) ((s << 8) | ((s >>> 8) & 255));
    }

    public static String toString(short s) {
        return Integer.toString(s);
    }

    public static Short valueOf(String str) throws NumberFormatException {
        return valueOf(parseShort(str));
    }

    public static Short valueOf(String str, int i) throws NumberFormatException {
        return valueOf(parseShort(str, i));
    }

    public static Short valueOf(short s) {
        return (s < -128 || s >= 128) ? new Short(s) : SMALL_VALUES[s + 128];
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Short sh) {
        return compare(this.value, sh.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Short) && ((Short) obj).value == this.value;
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
