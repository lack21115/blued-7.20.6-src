package org.apache.harmony.security.x501;

import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x501/DirectoryString.class */
public final class DirectoryString {
    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[]{ASN1StringType.TELETEXSTRING, ASN1StringType.PRINTABLESTRING, ASN1StringType.UNIVERSALSTRING, ASN1StringType.UTF8STRING, ASN1StringType.BMPSTRING}) { // from class: org.apache.harmony.security.x501.DirectoryString.1
        @Override // org.apache.harmony.security.asn1.ASN1Choice
        public int getIndex(Object obj) {
            return 1;
        }

        @Override // org.apache.harmony.security.asn1.ASN1Choice
        public Object getObjectToEncode(Object obj) {
            return obj;
        }
    };
}
