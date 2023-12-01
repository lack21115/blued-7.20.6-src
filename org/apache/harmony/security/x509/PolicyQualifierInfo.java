package org.apache.harmony.security.x509;

import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/PolicyQualifierInfo.class */
public final class PolicyQualifierInfo {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Oid.getInstance(), ASN1Any.getInstance()}) { // from class: org.apache.harmony.security.x509.PolicyQualifierInfo.1
    };
}
