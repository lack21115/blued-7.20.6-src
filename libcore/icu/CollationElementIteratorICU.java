package libcore.icu;

import java.text.CharacterIterator;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/CollationElementIteratorICU.class */
public final class CollationElementIteratorICU {
    private static final int PRIMARY_ORDER_MASK_ = -65536;
    private static final int PRIMARY_ORDER_SHIFT_ = 16;
    private static final int SECONDARY_ORDER_MASK_ = 65280;
    private static final int SECONDARY_ORDER_SHIFT_ = 8;
    private static final int TERTIARY_ORDER_MASK_ = 255;
    private static final int UNSIGNED_16_BIT_MASK_ = 65535;
    private final long address;

    private CollationElementIteratorICU(long j) {
        this.address = j;
    }

    public static CollationElementIteratorICU getInstance(long j, String str) {
        return new CollationElementIteratorICU(NativeCollation.getCollationElementIterator(j, str));
    }

    public static int primaryOrder(int i) {
        return ((PRIMARY_ORDER_MASK_ & i) >> 16) & 65535;
    }

    public static int secondaryOrder(int i) {
        return (SECONDARY_ORDER_MASK_ & i) >> 8;
    }

    public static int tertiaryOrder(int i) {
        return i & 255;
    }

    protected void finalize() throws Throwable {
        try {
            NativeCollation.closeElements(this.address);
        } finally {
            super.finalize();
        }
    }

    public int getMaxExpansion(int i) {
        return NativeCollation.getMaxExpansion(this.address, i);
    }

    public int getOffset() {
        return NativeCollation.getOffset(this.address);
    }

    public int next() {
        return NativeCollation.next(this.address);
    }

    public int previous() {
        return NativeCollation.previous(this.address);
    }

    public void reset() {
        NativeCollation.reset(this.address);
    }

    public void setOffset(int i) {
        NativeCollation.setOffset(this.address, i);
    }

    public void setText(String str) {
        NativeCollation.setText(this.address, str);
    }

    public void setText(CharacterIterator characterIterator) {
        NativeCollation.setText(this.address, characterIterator.toString());
    }
}
