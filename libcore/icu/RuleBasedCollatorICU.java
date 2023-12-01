package libcore.icu;

import java.text.CharacterIterator;
import java.text.CollationKey;
import java.text.ParseException;
import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/RuleBasedCollatorICU.class */
public final class RuleBasedCollatorICU implements Cloneable {
    public static final int ALTERNATE_HANDLING = 1;
    public static final int CASE_FIRST = 2;
    public static final int CASE_LEVEL = 3;
    public static final int DECOMPOSITION_MODE = 4;
    public static final int FRENCH_COLLATION = 0;
    public static final int STRENGTH = 5;
    public static final int VALUE_ATTRIBUTE_VALUE_COUNT = 29;
    public static final int VALUE_DEFAULT = -1;
    public static final int VALUE_DEFAULT_STRENGTH = 2;
    public static final int VALUE_IDENTICAL = 15;
    public static final int VALUE_LOWER_FIRST = 24;
    public static final int VALUE_NON_IGNORABLE = 21;
    public static final int VALUE_OFF = 16;
    public static final int VALUE_ON = 17;
    public static final int VALUE_ON_WITHOUT_HANGUL = 28;
    public static final int VALUE_PRIMARY = 0;
    public static final int VALUE_QUATERNARY = 3;
    public static final int VALUE_SECONDARY = 1;
    public static final int VALUE_SHIFTED = 20;
    public static final int VALUE_TERTIARY = 2;
    public static final int VALUE_UPPER_FIRST = 25;
    private final long address;

    private RuleBasedCollatorICU(long j) {
        this.address = j;
    }

    public RuleBasedCollatorICU(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("rules == null");
        }
        this.address = NativeCollation.openCollatorFromRules(str, 16, 2);
    }

    public RuleBasedCollatorICU(Locale locale) {
        this.address = NativeCollation.openCollator(locale);
    }

    private String characterIteratorToString(CharacterIterator characterIterator) {
        StringBuilder sb = new StringBuilder();
        char current = characterIterator.current();
        while (true) {
            char c2 = current;
            if (c2 == 65535) {
                return sb.toString();
            }
            sb.append(c2);
            current = characterIterator.next();
        }
    }

    public Object clone() {
        return new RuleBasedCollatorICU(NativeCollation.safeClone(this.address));
    }

    public int compare(String str, String str2) {
        return NativeCollation.compare(this.address, str, str2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RuleBasedCollatorICU) {
            RuleBasedCollatorICU ruleBasedCollatorICU = (RuleBasedCollatorICU) obj;
            return getRules().equals(ruleBasedCollatorICU.getRules()) && getStrength() == ruleBasedCollatorICU.getStrength() && getDecomposition() == ruleBasedCollatorICU.getDecomposition();
        }
        return false;
    }

    public boolean equals(String str, String str2) {
        return compare(str, str2) == 0;
    }

    protected void finalize() throws Throwable {
        try {
            NativeCollation.closeCollator(this.address);
        } finally {
            super.finalize();
        }
    }

    public int getAttribute(int i) {
        return NativeCollation.getAttribute(this.address, i);
    }

    public CollationElementIteratorICU getCollationElementIterator(String str) {
        return CollationElementIteratorICU.getInstance(this.address, str);
    }

    public CollationElementIteratorICU getCollationElementIterator(CharacterIterator characterIterator) {
        return getCollationElementIterator(characterIteratorToString(characterIterator));
    }

    public CollationKey getCollationKey(String str) {
        byte[] sortKey;
        if (str == null || (sortKey = NativeCollation.getSortKey(this.address, str)) == null) {
            return null;
        }
        return new CollationKeyICU(str, sortKey);
    }

    public int getDecomposition() {
        return NativeCollation.getAttribute(this.address, 4);
    }

    public String getRules() {
        return NativeCollation.getRules(this.address);
    }

    public int getStrength() {
        return NativeCollation.getAttribute(this.address, 5);
    }

    public int hashCode() {
        return 42;
    }

    public void setAttribute(int i, int i2) {
        NativeCollation.setAttribute(this.address, i, i2);
    }

    public void setDecomposition(int i) {
        NativeCollation.setAttribute(this.address, 4, i);
    }

    public void setStrength(int i) {
        NativeCollation.setAttribute(this.address, 5, i);
    }
}
