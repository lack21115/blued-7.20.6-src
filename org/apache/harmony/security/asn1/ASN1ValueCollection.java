package org.apache.harmony.security.asn1;

import java.util.Collection;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1ValueCollection.class */
public abstract class ASN1ValueCollection extends ASN1Constructed {
    public final ASN1Type type;

    public ASN1ValueCollection(int i, ASN1Type aSN1Type) {
        super(i);
        this.type = aSN1Type;
    }

    public Collection<?> getValues(Object obj) {
        return (Collection) obj;
    }
}
