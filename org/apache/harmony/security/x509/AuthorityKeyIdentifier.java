package org.apache.harmony.security.x509;

import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.utils.Array;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/AuthorityKeyIdentifier.class */
public final class AuthorityKeyIdentifier extends ExtensionValue {
    public static final ASN1Type ASN1 = new ASN1Sequence(new ASN1Type[]{new ASN1Implicit(0, ASN1OctetString.getInstance()), new ASN1Implicit(1, GeneralNames.ASN1), new ASN1Implicit(2, ASN1Integer.getInstance())}) { // from class: org.apache.harmony.security.x509.AuthorityKeyIdentifier.1
        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            Object[] objArr = (Object[]) berInputStream.content;
            byte[] bArr = (byte[]) objArr[2];
            BigInteger bigInteger = null;
            if (bArr != null) {
                bigInteger = new BigInteger(bArr);
            }
            return new AuthorityKeyIdentifier((byte[]) objArr[0], (GeneralNames) objArr[1], bigInteger);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            AuthorityKeyIdentifier authorityKeyIdentifier = (AuthorityKeyIdentifier) obj;
            objArr[0] = authorityKeyIdentifier.keyIdentifier;
            objArr[1] = authorityKeyIdentifier.authorityCertIssuer;
            if (authorityKeyIdentifier.authorityCertSerialNumber != null) {
                objArr[2] = authorityKeyIdentifier.authorityCertSerialNumber.toByteArray();
            }
        }
    };
    private final GeneralNames authorityCertIssuer;
    private final BigInteger authorityCertSerialNumber;
    private final byte[] keyIdentifier;

    public AuthorityKeyIdentifier(byte[] bArr, GeneralNames generalNames, BigInteger bigInteger) {
        this.keyIdentifier = bArr;
        this.authorityCertIssuer = generalNames;
        this.authorityCertSerialNumber = bigInteger;
    }

    public static AuthorityKeyIdentifier decode(byte[] bArr) throws IOException {
        AuthorityKeyIdentifier authorityKeyIdentifier = (AuthorityKeyIdentifier) ASN1.decode(bArr);
        authorityKeyIdentifier.encoding = bArr;
        return authorityKeyIdentifier;
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public void dumpValue(StringBuilder sb, String str) {
        sb.append(str).append("AuthorityKeyIdentifier [\n");
        if (this.keyIdentifier != null) {
            sb.append(str).append("  keyIdentifier:\n");
            sb.append(Array.toString(this.keyIdentifier, str + "    "));
        }
        if (this.authorityCertIssuer != null) {
            sb.append(str).append("  authorityCertIssuer: [\n");
            this.authorityCertIssuer.dumpValue(sb, str + "    ");
            sb.append(str).append("  ]\n");
        }
        if (this.authorityCertSerialNumber != null) {
            sb.append(str).append("  authorityCertSerialNumber: ");
            sb.append(this.authorityCertSerialNumber).append('\n');
        }
        sb.append(str).append("]\n");
    }

    public GeneralNames getAuthorityCertIssuer() {
        return this.authorityCertIssuer;
    }

    public BigInteger getAuthorityCertSerialNumber() {
        return this.authorityCertSerialNumber;
    }

    @Override // org.apache.harmony.security.x509.ExtensionValue
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public byte[] getKeyIdentifier() {
        return this.keyIdentifier;
    }
}
