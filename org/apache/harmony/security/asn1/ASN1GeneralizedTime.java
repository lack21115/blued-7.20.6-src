package org.apache.harmony.security.asn1;

import android.text.format.Time;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/asn1/ASN1GeneralizedTime.class */
public final class ASN1GeneralizedTime extends ASN1Time {
    private static final ASN1GeneralizedTime ASN1 = new ASN1GeneralizedTime();
    private static final String GEN_PATTERN = "yyyyMMddHHmmss.SSS";

    public ASN1GeneralizedTime() {
        super(24);
    }

    public static ASN1GeneralizedTime getInstance() {
        return ASN1;
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public Object decode(BerInputStream berInputStream) throws IOException {
        berInputStream.readGeneralizedTime();
        if (berInputStream.isVerify) {
            return null;
        }
        return getDecodedObject(berInputStream);
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public void encodeContent(BerOutputStream berOutputStream) {
        berOutputStream.encodeGeneralizedTime();
    }

    @Override // org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
    public void setEncodingContent(BerOutputStream berOutputStream) {
        String str;
        int length;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(GEN_PATTERN, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
        String format = simpleDateFormat.format(berOutputStream.content);
        while (true) {
            str = format;
            length = str.length() - 1;
            int lastIndexOf = str.lastIndexOf(48, length);
            if (!(lastIndexOf == length) || !(lastIndexOf != -1)) {
                break;
            }
            format = str.substring(0, lastIndexOf);
        }
        String str2 = str;
        if (str.charAt(length) == '.') {
            str2 = str.substring(0, length);
        }
        berOutputStream.content = (str2 + "Z").getBytes(StandardCharsets.UTF_8);
        berOutputStream.length = ((byte[]) berOutputStream.content).length;
    }
}
