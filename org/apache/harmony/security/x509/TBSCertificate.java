package org.apache.harmony.security.x509;

import java.math.BigInteger;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.x501.Name;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/TBSCertificate.class */
public final class TBSCertificate {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{new ASN1Explicit(0, ASN1Integer.getInstance()), ASN1Integer.getInstance(), AlgorithmIdentifier.ASN1, Name.ASN1, Validity.ASN1, Name.ASN1, SubjectPublicKeyInfo.ASN1, new ASN1Implicit(1, ASN1BitString.getInstance()), new ASN1Implicit(2, ASN1BitString.getInstance()), new ASN1Explicit(3, Extensions.ASN1)}) { // from class: org.apache.harmony.security.x509.TBSCertificate.1
        {
            setDefault(new byte[]{0}, 0);
            setOptional(7);
            setOptional(8);
            setOptional(9);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new TBSCertificate(ASN1Integer.toIntValue(objArr[0]), new BigInteger((byte[]) objArr[1]), (AlgorithmIdentifier) objArr[2], (Name) objArr[3], (Validity) objArr[4], (Name) objArr[5], (SubjectPublicKeyInfo) objArr[6], objArr[7] == null ? null : ((BitString) objArr[7]).toBooleanArray(), objArr[8] == null ? null : ((BitString) objArr[8]).toBooleanArray(), (Extensions) objArr[9], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            TBSCertificate tBSCertificate = (TBSCertificate) obj;
            objArr[0] = ASN1Integer.fromIntValue(tBSCertificate.version);
            objArr[1] = tBSCertificate.serialNumber.toByteArray();
            objArr[2] = tBSCertificate.signature;
            objArr[3] = tBSCertificate.issuer;
            objArr[4] = tBSCertificate.validity;
            objArr[5] = tBSCertificate.subject;
            objArr[6] = tBSCertificate.subjectPublicKeyInfo;
            if (tBSCertificate.issuerUniqueID != null) {
                objArr[7] = new BitString(tBSCertificate.issuerUniqueID);
            }
            if (tBSCertificate.subjectUniqueID != null) {
                objArr[8] = new BitString(tBSCertificate.subjectUniqueID);
            }
            objArr[9] = tBSCertificate.extensions;
        }
    };
    private byte[] encoding;
    private final Extensions extensions;
    private final Name issuer;
    private final boolean[] issuerUniqueID;
    private final BigInteger serialNumber;
    private final AlgorithmIdentifier signature;
    private final Name subject;
    private final SubjectPublicKeyInfo subjectPublicKeyInfo;
    private final boolean[] subjectUniqueID;
    private final Validity validity;
    private final int version;

    public TBSCertificate(int i, BigInteger bigInteger, AlgorithmIdentifier algorithmIdentifier, Name name, Validity validity, Name name2, SubjectPublicKeyInfo subjectPublicKeyInfo, boolean[] zArr, boolean[] zArr2, Extensions extensions) {
        this.version = i;
        this.serialNumber = bigInteger;
        this.signature = algorithmIdentifier;
        this.issuer = name;
        this.validity = validity;
        this.subject = name2;
        this.subjectPublicKeyInfo = subjectPublicKeyInfo;
        this.issuerUniqueID = zArr;
        this.subjectUniqueID = zArr2;
        this.extensions = extensions;
    }

    private TBSCertificate(int i, BigInteger bigInteger, AlgorithmIdentifier algorithmIdentifier, Name name, Validity validity, Name name2, SubjectPublicKeyInfo subjectPublicKeyInfo, boolean[] zArr, boolean[] zArr2, Extensions extensions, byte[] bArr) {
        this(i, bigInteger, algorithmIdentifier, name, validity, name2, subjectPublicKeyInfo, zArr, zArr2, extensions);
        this.encoding = bArr;
    }

    public void dumpValue(StringBuilder sb) {
        sb.append('[');
        sb.append("\n  Version: V").append(this.version + 1);
        sb.append("\n  Subject: ").append(this.subject.getName(X500Principal.RFC2253));
        sb.append("\n  Signature Algorithm: ");
        this.signature.dumpValue(sb);
        sb.append("\n  Key: ").append(this.subjectPublicKeyInfo.getPublicKey().toString());
        sb.append("\n  Validity: [From: ").append(this.validity.getNotBefore());
        sb.append("\n               To: ").append(this.validity.getNotAfter()).append(']');
        sb.append("\n  Issuer: ").append(this.issuer.getName(X500Principal.RFC2253));
        sb.append("\n  Serial Number: ").append(this.serialNumber);
        if (this.issuerUniqueID != null) {
            sb.append("\n  Issuer Id: ");
            boolean[] zArr = this.issuerUniqueID;
            int length = zArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(zArr[i2] ? '1' : '0');
                i = i2 + 1;
            }
        }
        if (this.subjectUniqueID != null) {
            sb.append("\n  Subject Id: ");
            boolean[] zArr2 = this.subjectUniqueID;
            int length2 = zArr2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                sb.append(zArr2[i4] ? '1' : '0');
                i3 = i4 + 1;
            }
        }
        if (this.extensions != null) {
            sb.append("\n\n  Extensions: ");
            sb.append("[\n");
            this.extensions.dumpValue(sb, "    ");
            sb.append("  ]");
        }
        sb.append("\n]");
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public Name getIssuer() {
        return this.issuer;
    }

    public boolean[] getIssuerUniqueID() {
        return this.issuerUniqueID;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Name getSubject() {
        return this.subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPublicKeyInfo;
    }

    public boolean[] getSubjectUniqueID() {
        return this.subjectUniqueID;
    }

    public Validity getValidity() {
        return this.validity;
    }

    public int getVersion() {
        return this.version;
    }
}
