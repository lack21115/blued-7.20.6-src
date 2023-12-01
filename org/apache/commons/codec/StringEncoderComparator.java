package org.apache.commons.codec;

import java.util.Comparator;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/StringEncoderComparator.class */
public class StringEncoderComparator implements Comparator {
    private final StringEncoder stringEncoder;

    public StringEncoderComparator() {
        this.stringEncoder = null;
    }

    public StringEncoderComparator(StringEncoder stringEncoder) {
        this.stringEncoder = stringEncoder;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            return ((Comparable) this.stringEncoder.encode(obj)).compareTo((Comparable) this.stringEncoder.encode(obj2));
        } catch (EncoderException e) {
            return 0;
        }
    }
}
