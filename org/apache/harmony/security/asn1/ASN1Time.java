package org.apache.harmony.security.asn1;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1Time.class */
public abstract class ASN1Time extends ASN1StringType {
    public ASN1Time(int i) {
        super(i);
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.set(1, berInputStream.times[0]);
        gregorianCalendar.set(2, berInputStream.times[1] - 1);
        gregorianCalendar.set(5, berInputStream.times[2]);
        gregorianCalendar.set(11, berInputStream.times[3]);
        gregorianCalendar.set(12, berInputStream.times[4]);
        gregorianCalendar.set(13, berInputStream.times[5]);
        gregorianCalendar.set(14, berInputStream.times[6]);
        return gregorianCalendar.getTime();
    }
}
