package org.apache.harmony.security.x509;

import java.util.Date;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.ASN1UTCTime;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/Time.class */
public final class Time {
    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[]{ASN1GeneralizedTime.getInstance(), ASN1UTCTime.getInstance()}) { // from class: org.apache.harmony.security.x509.Time.1
        @Override // org.apache.harmony.security.asn1.ASN1Choice
        public int getIndex(Object obj) {
            return ((Date) obj).getTime() < Time.JAN_01_2050 ? 1 : 0;
        }

        @Override // org.apache.harmony.security.asn1.ASN1Choice
        public Object getObjectToEncode(Object obj) {
            return obj;
        }
    };
    private static final long JAN_01_2050 = 2524608000000L;
}
