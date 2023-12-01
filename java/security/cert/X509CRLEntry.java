package java.security.cert;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.x509.ReasonCode;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/X509CRLEntry.class */
public abstract class X509CRLEntry implements X509Extension {
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == this) {
            z = true;
        } else if (obj instanceof X509CRLEntry) {
            try {
                return Arrays.equals(getEncoded(), ((X509CRLEntry) obj).getEncoded());
            } catch (CRLException e) {
                return false;
            }
        }
        return z;
    }

    public X500Principal getCertificateIssuer() {
        return null;
    }

    public abstract byte[] getEncoded() throws CRLException;

    public abstract Date getRevocationDate();

    public CRLReason getRevocationReason() {
        byte[] extensionValue = getExtensionValue("2.5.29.21");
        if (extensionValue == null) {
            return null;
        }
        try {
            return new ReasonCode((byte[]) ASN1OctetString.getInstance().decode(extensionValue)).getReason();
        } catch (IOException e) {
            return null;
        }
    }

    public abstract BigInteger getSerialNumber();

    public abstract boolean hasExtensions();

    public int hashCode() {
        int i;
        int i2 = 0;
        int i3 = 0;
        try {
            byte[] encoded = getEncoded();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i2 = i3;
                i = i3;
                if (i5 >= encoded.length) {
                    break;
                }
                i3 += encoded[i5] & 255;
                i4 = i5 + 1;
            }
        } catch (CRLException e) {
            i = i2;
        }
        return i;
    }

    public abstract String toString();
}
