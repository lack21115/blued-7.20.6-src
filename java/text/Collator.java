package java.text;

import java.util.Comparator;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.RuleBasedCollatorICU;

/* loaded from: source-2895416-dex2jar.jar:java/text/Collator.class */
public abstract class Collator implements Comparator<Object>, Cloneable {
    public static final int CANONICAL_DECOMPOSITION = 1;
    public static final int FULL_DECOMPOSITION = 2;
    public static final int IDENTICAL = 3;
    public static final int NO_DECOMPOSITION = 0;
    public static final int PRIMARY = 0;
    public static final int SECONDARY = 1;
    public static final int TERTIARY = 2;
    RuleBasedCollatorICU icuColl;

    /* JADX INFO: Access modifiers changed from: protected */
    public Collator() {
        this.icuColl = new RuleBasedCollatorICU(Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collator(RuleBasedCollatorICU ruleBasedCollatorICU) {
        this.icuColl = ruleBasedCollatorICU;
    }

    private int decompositionMode_ICU_Java(int i) {
        switch (i) {
            case 16:
                return 0;
            case 17:
                return 1;
            default:
                return i;
        }
    }

    private int decompositionMode_Java_ICU(int i) {
        switch (i) {
            case 0:
                return 16;
            case 1:
                return 17;
            default:
                throw new IllegalArgumentException("Bad mode: " + i);
        }
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableCollatorLocales();
    }

    public static Collator getInstance() {
        return getInstance(Locale.getDefault());
    }

    public static Collator getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        return new RuleBasedCollator(new RuleBasedCollatorICU(locale));
    }

    private int strength_ICU_Java(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 15:
                return 3;
            default:
                return i;
        }
    }

    private int strength_Java_ICU(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 15;
            default:
                throw new IllegalArgumentException("Bad strength: " + i);
        }
    }

    public Object clone() {
        try {
            Collator collator = (Collator) super.clone();
            collator.icuColl = (RuleBasedCollatorICU) this.icuColl.clone();
            return collator;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return compare((String) obj, (String) obj2);
    }

    public abstract int compare(String str, String str2);

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof Collator) {
            Collator collator = (Collator) obj;
            return this.icuColl == null ? collator.icuColl == null : this.icuColl.equals(collator.icuColl);
        }
        return false;
    }

    public boolean equals(String str, String str2) {
        return compare(str, str2) == 0;
    }

    public abstract CollationKey getCollationKey(String str);

    public int getDecomposition() {
        return decompositionMode_ICU_Java(this.icuColl.getDecomposition());
    }

    public int getStrength() {
        return strength_ICU_Java(this.icuColl.getStrength());
    }

    public abstract int hashCode();

    public void setDecomposition(int i) {
        this.icuColl.setDecomposition(decompositionMode_Java_ICU(i));
    }

    public void setStrength(int i) {
        this.icuColl.setStrength(strength_Java_ICU(i));
    }
}
