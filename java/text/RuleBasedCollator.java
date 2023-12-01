package java.text;

import libcore.icu.RuleBasedCollatorICU;

/* loaded from: source-2895416-dex2jar.jar:java/text/RuleBasedCollator.class */
public class RuleBasedCollator extends Collator {
    public RuleBasedCollator(String str) throws ParseException {
        if (str == null) {
            throw new NullPointerException("rules == null");
        }
        try {
            this.icuColl = new RuleBasedCollatorICU(str);
        } catch (Exception e) {
            if (!(e instanceof ParseException)) {
                throw new ParseException(e.getMessage(), -1);
            }
            throw ((ParseException) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RuleBasedCollator(RuleBasedCollatorICU ruleBasedCollatorICU) {
        super(ruleBasedCollatorICU);
    }

    @Override // java.text.Collator
    public Object clone() {
        return (RuleBasedCollator) super.clone();
    }

    @Override // java.text.Collator
    public int compare(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("source == null");
        }
        if (str2 == null) {
            throw new NullPointerException("target == null");
        }
        return this.icuColl.compare(str, str2);
    }

    @Override // java.text.Collator, java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof Collator) {
            return super.equals(obj);
        }
        return false;
    }

    public CollationElementIterator getCollationElementIterator(String str) {
        if (str == null) {
            throw new NullPointerException("source == null");
        }
        return new CollationElementIterator(this.icuColl.getCollationElementIterator(str));
    }

    public CollationElementIterator getCollationElementIterator(CharacterIterator characterIterator) {
        if (characterIterator == null) {
            throw new NullPointerException("source == null");
        }
        return new CollationElementIterator(this.icuColl.getCollationElementIterator(characterIterator));
    }

    @Override // java.text.Collator
    public CollationKey getCollationKey(String str) {
        return this.icuColl.getCollationKey(str);
    }

    public String getRules() {
        return this.icuColl.getRules();
    }

    @Override // java.text.Collator
    public int hashCode() {
        return this.icuColl.getRules().hashCode();
    }
}
