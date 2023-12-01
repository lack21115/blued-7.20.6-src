package java.lang;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Boolean.class */
public final class Boolean implements Serializable, Comparable<Boolean> {
    private static final long serialVersionUID = -3665804199014368530L;
    private final boolean value;
    public static final Class<Boolean> TYPE = boolean[].class.getComponentType();
    public static final Boolean TRUE = new Boolean(true);
    public static final Boolean FALSE = new Boolean(false);

    public Boolean(String str) {
        this(parseBoolean(str));
    }

    public Boolean(boolean z) {
        this.value = z;
    }

    public static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static boolean getBoolean(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return parseBoolean(System.getProperty(str));
    }

    public static boolean parseBoolean(String str) {
        return "true".equalsIgnoreCase(str);
    }

    public static String toString(boolean z) {
        return String.valueOf(z);
    }

    public static Boolean valueOf(String str) {
        return parseBoolean(str) ? TRUE : FALSE;
    }

    public static Boolean valueOf(boolean z) {
        return z ? TRUE : FALSE;
    }

    public boolean booleanValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Boolean bool) {
        return compare(this.value, bool.value);
    }

    @FindBugsSuppressWarnings({"RC_REF_COMPARISON_BAD_PRACTICE_BOOLEAN"})
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Boolean) && ((Boolean) obj).value == this.value;
        }
        return true;
    }

    public int hashCode() {
        return this.value ? 1231 : 1237;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
