package org.apache.harmony.security.x501;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.harmony.security.utils.ObjectIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x501/AttributeTypeAndValueComparator.class */
public class AttributeTypeAndValueComparator implements Comparator<AttributeTypeAndValue>, Serializable {
    private static final long serialVersionUID = -1286471842007103132L;

    private static int compateOids(ObjectIdentifier objectIdentifier, ObjectIdentifier objectIdentifier2) {
        if (objectIdentifier == objectIdentifier2) {
            return 0;
        }
        int[] oid = objectIdentifier.getOid();
        int[] oid2 = objectIdentifier2.getOid();
        int length = oid.length < oid2.length ? oid.length : oid2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            if (oid[i2] < oid2[i2]) {
                return -1;
            }
            if (oid[i2] > oid2[i2]) {
                return 1;
            }
            if (i2 + 1 == oid.length && i2 + 1 < oid2.length) {
                return -1;
            }
            if (i2 + 1 < oid.length && i2 + 1 == oid2.length) {
                return 1;
            }
            i = i2 + 1;
        }
    }

    @Override // java.util.Comparator
    public int compare(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return 0;
        }
        String name = attributeTypeAndValue.getType().getName();
        String name2 = attributeTypeAndValue2.getType().getName();
        if (name == null || name2 != null) {
            if (name != null || name2 == null) {
                return (name == null || name2 == null) ? compateOids(attributeTypeAndValue.getType(), attributeTypeAndValue2.getType()) : name.compareTo(name2);
            }
            return 1;
        }
        return -1;
    }
}
