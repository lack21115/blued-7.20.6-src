package org.apache.harmony.security.asn1;

import android.text.format.Time;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1UTCTime.class */
public final class ASN1UTCTime extends ASN1Time {
    private static final ASN1UTCTime ASN1 = new ASN1UTCTime();
    public static final int UTC_HM = 11;
    public static final int UTC_HMS = 13;
    public static final int UTC_LOCAL_HM = 15;
    public static final int UTC_LOCAL_HMS = 17;
    private static final String UTC_PATTERN = "yyMMddHHmmss'Z'";

    public ASN1UTCTime() {
        super(23);
    }

    public static ASN1UTCTime getInstance() {
        return ASN1;
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readUTCTime();
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeUTCTime();
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(UTC_PATTERN, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
        berOutputStream.content = simpleDateFormat.format(berOutputStream.content).getBytes(StandardCharsets.UTF_8);
        berOutputStream.length = ((byte[]) berOutputStream.content).length;
    }
}
