package org.apache.harmony.security.pkcs7;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.Name;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/pkcs7/SignerInfo.class */
public final class SignerInfo {
    private final AuthenticatedAttributes authenticatedAttributes;
    private final AlgorithmIdentifier digestAlgorithm;
    private final AlgorithmIdentifier digestEncryptionAlgorithm;
    private final byte[] encryptedDigest;
    private final X500Principal issuer;
    private final BigInteger serialNumber;
    private final List<?> unauthenticatedAttributes;
    private final int version;
    public static final ASN1Sequence ISSUER_AND_SERIAL_NUMBER = new ASN1Sequence(new ASN1Type[]{Name.ASN1, ASN1Integer.getInstance()}) { // from class: org.apache.harmony.security.pkcs7.SignerInfo.1
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            Object[] objArr2 = (Object[]) obj;
            objArr[0] = objArr2[0];
            objArr[1] = objArr2[1];
        }
    };
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), ISSUER_AND_SERIAL_NUMBER, AlgorithmIdentifier.ASN1, new ASN1Implicit(0, AuthenticatedAttributes.ASN1), AlgorithmIdentifier.ASN1, ASN1OctetString.getInstance(), new ASN1Implicit(1, new ASN1SetOf(AttributeTypeAndValue.ASN1))}) { // from class: org.apache.harmony.security.pkcs7.SignerInfo.2
        {
            setOptional(3);
            setOptional(6);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new SignerInfo(ASN1Integer.toIntValue(objArr[0]), (Object[]) objArr[1], (AlgorithmIdentifier) objArr[2], (AuthenticatedAttributes) objArr[3], (AlgorithmIdentifier) objArr[4], (byte[]) objArr[5], (List) objArr[6]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            SignerInfo signerInfo = (SignerInfo) obj;
            byte[] bArr = new byte[1];
            bArr[0] = (byte) signerInfo.version;
            objArr[0] = bArr;
            try {
                Object[] objArr2 = new Object[2];
                objArr2[0] = new Name(signerInfo.issuer.getName());
                objArr2[1] = signerInfo.serialNumber.toByteArray();
                objArr[1] = objArr2;
                objArr[2] = signerInfo.digestAlgorithm;
                objArr[3] = signerInfo.authenticatedAttributes;
                objArr[4] = signerInfo.digestEncryptionAlgorithm;
                objArr[5] = signerInfo.encryptedDigest;
                objArr[6] = signerInfo.unauthenticatedAttributes;
            } catch (IOException e) {
                throw new RuntimeException("Failed to encode issuer name", e);
            }
        }
    };

    private SignerInfo(int i, Object[] objArr, AlgorithmIdentifier algorithmIdentifier, AuthenticatedAttributes authenticatedAttributes, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, List<?> list) {
        this.version = i;
        this.issuer = ((Name) objArr[0]).getX500Principal();
        this.serialNumber = ASN1Integer.toBigIntegerValue(objArr[1]);
        this.digestAlgorithm = algorithmIdentifier;
        this.authenticatedAttributes = authenticatedAttributes;
        this.digestEncryptionAlgorithm = algorithmIdentifier2;
        this.encryptedDigest = bArr;
        this.unauthenticatedAttributes = list;
    }

    public List<AttributeTypeAndValue> getAuthenticatedAttributes() {
        if (this.authenticatedAttributes == null) {
            return null;
        }
        return this.authenticatedAttributes.getAttributes();
    }

    public String getDigestAlgorithm() {
        return this.digestAlgorithm.getAlgorithm();
    }

    public String getDigestAlgorithmName() {
        return this.digestAlgorithm.getAlgorithmName();
    }

    public String getDigestEncryptionAlgorithm() {
        return this.digestEncryptionAlgorithm.getAlgorithm();
    }

    public String getDigestEncryptionAlgorithmName() {
        return this.digestEncryptionAlgorithm.getAlgorithmName();
    }

    public byte[] getEncodedAuthenticatedAttributes() {
        if (this.authenticatedAttributes == null) {
            return null;
        }
        return AuthenticatedAttributes.ASN1.encode(this.authenticatedAttributes.getAttributes());
    }

    public byte[] getEncryptedDigest() {
        return this.encryptedDigest;
    }

    public X500Principal getIssuer() {
        return this.issuer;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- SignerInfo:");
        sb.append("\n version : ");
        sb.append(this.version);
        sb.append("\nissuerAndSerialNumber:  ");
        sb.append(this.issuer);
        sb.append("   ");
        sb.append(this.serialNumber);
        sb.append("\ndigestAlgorithm:  ");
        sb.append(this.digestAlgorithm.toString());
        sb.append("\nauthenticatedAttributes:  ");
        if (this.authenticatedAttributes != null) {
            sb.append(this.authenticatedAttributes.toString());
        }
        sb.append("\ndigestEncryptionAlgorithm: ");
        sb.append(this.digestEncryptionAlgorithm.toString());
        sb.append("\nunauthenticatedAttributes: ");
        if (this.unauthenticatedAttributes != null) {
            sb.append(this.unauthenticatedAttributes.toString());
        }
        sb.append("\n-- SignerInfo End\n");
        return sb.toString();
    }
}
