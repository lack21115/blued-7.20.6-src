package java.text;

import libcore.icu.CollationElementIteratorICU;

/* loaded from: source-2895416-dex2jar.jar:java/text/CollationElementIterator.class */
public final class CollationElementIterator {
    public static final int NULLORDER = -1;
    private CollationElementIteratorICU icuIterator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CollationElementIterator(CollationElementIteratorICU collationElementIteratorICU) {
        this.icuIterator = collationElementIteratorICU;
    }

    public static final int primaryOrder(int i) {
        return CollationElementIteratorICU.primaryOrder(i);
    }

    public static final short secondaryOrder(int i) {
        return (short) CollationElementIteratorICU.secondaryOrder(i);
    }

    public static final short tertiaryOrder(int i) {
        return (short) CollationElementIteratorICU.tertiaryOrder(i);
    }

    public int getMaxExpansion(int i) {
        return this.icuIterator.getMaxExpansion(i);
    }

    public int getOffset() {
        return this.icuIterator.getOffset();
    }

    public int next() {
        return this.icuIterator.next();
    }

    public int previous() {
        return this.icuIterator.previous();
    }

    public void reset() {
        this.icuIterator.reset();
    }

    public void setOffset(int i) {
        this.icuIterator.setOffset(i);
    }

    public void setText(String str) {
        this.icuIterator.setText(str);
    }

    public void setText(CharacterIterator characterIterator) {
        this.icuIterator.setText(characterIterator);
    }
}
