package org.apache.harmony.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.Array;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/Extension.class */
public final class Extension implements java.security.cert.Extension {
    public static final boolean CRITICAL = true;
    public static final boolean NON_CRITICAL = false;
    private final boolean critical;
    private byte[] encoding;
    private final int[] extnID;
    private String extnID_str;
    private final byte[] extnValue;
    protected ExtensionValue extnValueObject;
    private byte[] rawExtnValue;
    private volatile boolean valueDecoded;
    static final int[] SUBJ_DIRECTORY_ATTRS = {2, 5, 29, 9};
    static final int[] SUBJ_KEY_ID = {2, 5, 29, 14};
    static final int[] KEY_USAGE = {2, 5, 29, 15};
    static final int[] PRIVATE_KEY_USAGE_PERIOD = {2, 5, 29, 16};
    static final int[] SUBJECT_ALT_NAME = {2, 5, 29, 17};
    static final int[] ISSUER_ALTERNATIVE_NAME = {2, 5, 29, 18};
    static final int[] BASIC_CONSTRAINTS = {2, 5, 29, 19};
    static final int[] NAME_CONSTRAINTS = {2, 5, 29, 30};
    static final int[] CRL_DISTR_POINTS = {2, 5, 29, 31};
    static final int[] CERTIFICATE_POLICIES = {2, 5, 29, 32};
    static final int[] POLICY_MAPPINGS = {2, 5, 29, 33};
    static final int[] AUTH_KEY_ID = {2, 5, 29, 35};
    static final int[] POLICY_CONSTRAINTS = {2, 5, 29, 36};
    static final int[] EXTENDED_KEY_USAGE = {2, 5, 29, 37};
    static final int[] FRESHEST_CRL = {2, 5, 29, 46};
    static final int[] INHIBIT_ANY_POLICY = {2, 5, 29, 54};
    static final int[] AUTHORITY_INFO_ACCESS = {1, 3, 6, 1, 5, 5, 7, 1, 1};
    static final int[] SUBJECT_INFO_ACCESS = {1, 3, 6, 1, 5, 5, 7, 1, 11};
    static final int[] ISSUING_DISTR_POINT = {2, 5, 29, 28};
    static final int[] CRL_NUMBER = {2, 5, 29, 20};
    static final int[] CERTIFICATE_ISSUER = {2, 5, 29, 29};
    static final int[] INVALIDITY_DATE = {2, 5, 29, 24};
    static final int[] REASON_CODE = {2, 5, 29, 21};
    static final int[] ISSUING_DISTR_POINTS = {2, 5, 29, 28};
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Oid.getInstance(), ASN1Boolean.getInstance(), new ASN1OctetString() { // from class: org.apache.harmony.security.x509.Extension.1
        @Override // org.apache.harmony.security.asn1.ASN1OctetString, org.apache.harmony.security.asn1.ASN1StringType, org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            return new Object[]{super.getDecodedObject(berInputStream), berInputStream.getEncoded()};
        }
    }}) { // from class: org.apache.harmony.security.x509.Extension.2
        {
            setDefault(Boolean.FALSE, 1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) throws IOException {
            Object[] objArr = (Object[]) berInputStream.content;
            int[] iArr = (int[]) objArr[0];
            byte[] bArr = (byte[]) ((Object[]) objArr[2])[0];
            byte[] bArr2 = (byte[]) ((Object[]) objArr[2])[1];
            ExtensionValue extensionValue = null;
            if (Arrays.equals(iArr, Extension.KEY_USAGE)) {
                extensionValue = new KeyUsage(bArr);
            } else if (Arrays.equals(iArr, Extension.BASIC_CONSTRAINTS)) {
                extensionValue = new BasicConstraints(bArr);
            }
            return new Extension((int[]) objArr[0], ((Boolean) objArr[1]).booleanValue(), bArr, bArr2, berInputStream.getEncoded(), extensionValue);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            Extension extension = (Extension) obj;
            objArr[0] = extension.extnID;
            objArr[1] = extension.critical ? Boolean.TRUE : Boolean.FALSE;
            objArr[2] = extension.extnValue;
        }
    };

    public Extension(String str, boolean z, ExtensionValue extensionValue) {
        this.valueDecoded = false;
        this.extnID_str = str;
        this.extnID = ObjectIdentifier.toIntArray(str);
        this.critical = z;
        this.extnValueObject = extensionValue;
        this.valueDecoded = true;
        this.extnValue = extensionValue.getEncoded();
    }

    public Extension(String str, boolean z, byte[] bArr) {
        this.valueDecoded = false;
        this.extnID_str = str;
        this.extnID = ObjectIdentifier.toIntArray(str);
        this.critical = z;
        this.extnValue = bArr;
    }

    public Extension(String str, byte[] bArr) {
        this(str, false, bArr);
    }

    public Extension(int[] iArr, boolean z, byte[] bArr) {
        this.valueDecoded = false;
        this.extnID = iArr;
        this.critical = z;
        this.extnValue = bArr;
    }

    private Extension(int[] iArr, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, ExtensionValue extensionValue) {
        this(iArr, z, bArr);
        this.rawExtnValue = bArr2;
        this.encoding = bArr3;
        this.extnValueObject = extensionValue;
        this.valueDecoded = extensionValue != null;
    }

    public Extension(int[] iArr, byte[] bArr) {
        this(iArr, false, bArr);
    }

    private void decodeExtensionValue() throws IOException {
        if (this.valueDecoded) {
            return;
        }
        if (Arrays.equals(this.extnID, SUBJ_KEY_ID)) {
            this.extnValueObject = SubjectKeyIdentifier.decode(this.extnValue);
        } else if (Arrays.equals(this.extnID, KEY_USAGE)) {
            this.extnValueObject = new KeyUsage(this.extnValue);
        } else if (Arrays.equals(this.extnID, SUBJECT_ALT_NAME)) {
            this.extnValueObject = new AlternativeName(true, this.extnValue);
        } else if (Arrays.equals(this.extnID, ISSUER_ALTERNATIVE_NAME)) {
            this.extnValueObject = new AlternativeName(true, this.extnValue);
        } else if (Arrays.equals(this.extnID, BASIC_CONSTRAINTS)) {
            this.extnValueObject = new BasicConstraints(this.extnValue);
        } else if (Arrays.equals(this.extnID, NAME_CONSTRAINTS)) {
            this.extnValueObject = NameConstraints.decode(this.extnValue);
        } else if (Arrays.equals(this.extnID, CERTIFICATE_POLICIES)) {
            this.extnValueObject = CertificatePolicies.decode(this.extnValue);
        } else if (Arrays.equals(this.extnID, AUTH_KEY_ID)) {
            this.extnValueObject = AuthorityKeyIdentifier.decode(this.extnValue);
        } else if (Arrays.equals(this.extnID, POLICY_CONSTRAINTS)) {
            this.extnValueObject = new PolicyConstraints(this.extnValue);
        } else if (Arrays.equals(this.extnID, EXTENDED_KEY_USAGE)) {
            this.extnValueObject = new ExtendedKeyUsage(this.extnValue);
        } else if (Arrays.equals(this.extnID, INHIBIT_ANY_POLICY)) {
            this.extnValueObject = new InhibitAnyPolicy(this.extnValue);
        } else if (Arrays.equals(this.extnID, CERTIFICATE_ISSUER)) {
            this.extnValueObject = new CertificateIssuer(this.extnValue);
        } else if (Arrays.equals(this.extnID, CRL_DISTR_POINTS)) {
            this.extnValueObject = CRLDistributionPoints.decode(this.extnValue);
        } else if (Arrays.equals(this.extnID, CERTIFICATE_ISSUER)) {
            this.extnValueObject = new ReasonCode(this.extnValue);
        } else if (Arrays.equals(this.extnID, INVALIDITY_DATE)) {
            this.extnValueObject = new InvalidityDate(this.extnValue);
        } else if (Arrays.equals(this.extnID, REASON_CODE)) {
            this.extnValueObject = new ReasonCode(this.extnValue);
        } else if (Arrays.equals(this.extnID, CRL_NUMBER)) {
            this.extnValueObject = new CRLNumber(this.extnValue);
        } else if (Arrays.equals(this.extnID, ISSUING_DISTR_POINTS)) {
            this.extnValueObject = IssuingDistributionPoint.decode(this.extnValue);
        } else if (Arrays.equals(this.extnID, AUTHORITY_INFO_ACCESS)) {
            this.extnValueObject = InfoAccessSyntax.decode(this.extnValue);
        } else if (Arrays.equals(this.extnID, SUBJECT_INFO_ACCESS)) {
            this.extnValueObject = InfoAccessSyntax.decode(this.extnValue);
        }
        this.valueDecoded = true;
    }

    public void dumpValue(StringBuilder sb, String str) {
        sb.append("OID: ").append(getId()).append(", Critical: ").append(this.critical).append('\n');
        if (!this.valueDecoded) {
            try {
                decodeExtensionValue();
            } catch (IOException e) {
            }
        }
        if (this.extnValueObject != null) {
            this.extnValueObject.dumpValue(sb, str);
            return;
        }
        sb.append(str);
        if (Arrays.equals(this.extnID, SUBJ_DIRECTORY_ATTRS)) {
            sb.append("Subject Directory Attributes Extension");
        } else if (Arrays.equals(this.extnID, SUBJ_KEY_ID)) {
            sb.append("Subject Key Identifier Extension");
        } else if (Arrays.equals(this.extnID, KEY_USAGE)) {
            sb.append("Key Usage Extension");
        } else if (Arrays.equals(this.extnID, PRIVATE_KEY_USAGE_PERIOD)) {
            sb.append("Private Key Usage Period Extension");
        } else if (Arrays.equals(this.extnID, SUBJECT_ALT_NAME)) {
            sb.append("Subject Alternative Name Extension");
        } else if (Arrays.equals(this.extnID, ISSUER_ALTERNATIVE_NAME)) {
            sb.append("Issuer Alternative Name Extension");
        } else if (Arrays.equals(this.extnID, BASIC_CONSTRAINTS)) {
            sb.append("Basic Constraints Extension");
        } else if (Arrays.equals(this.extnID, NAME_CONSTRAINTS)) {
            sb.append("Name Constraints Extension");
        } else if (Arrays.equals(this.extnID, CRL_DISTR_POINTS)) {
            sb.append("CRL Distribution Points Extension");
        } else if (Arrays.equals(this.extnID, CERTIFICATE_POLICIES)) {
            sb.append("Certificate Policies Extension");
        } else if (Arrays.equals(this.extnID, POLICY_MAPPINGS)) {
            sb.append("Policy Mappings Extension");
        } else if (Arrays.equals(this.extnID, AUTH_KEY_ID)) {
            sb.append("Authority Key Identifier Extension");
        } else if (Arrays.equals(this.extnID, POLICY_CONSTRAINTS)) {
            sb.append("Policy Constraints Extension");
        } else if (Arrays.equals(this.extnID, EXTENDED_KEY_USAGE)) {
            sb.append("Extended Key Usage Extension");
        } else if (Arrays.equals(this.extnID, INHIBIT_ANY_POLICY)) {
            sb.append("Inhibit Any-Policy Extension");
        } else if (Arrays.equals(this.extnID, AUTHORITY_INFO_ACCESS)) {
            sb.append("Authority Information Access Extension");
        } else if (Arrays.equals(this.extnID, SUBJECT_INFO_ACCESS)) {
            sb.append("Subject Information Access Extension");
        } else if (Arrays.equals(this.extnID, INVALIDITY_DATE)) {
            sb.append("Invalidity Date Extension");
        } else if (Arrays.equals(this.extnID, CRL_NUMBER)) {
            sb.append("CRL Number Extension");
        } else if (Arrays.equals(this.extnID, REASON_CODE)) {
            sb.append("Reason Code Extension");
        } else {
            sb.append("Unknown Extension");
        }
        sb.append('\n').append(str).append("Unparsed Extension Value:\n");
        sb.append(Array.toString(this.extnValue, str));
    }

    @Override // java.security.cert.Extension
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Extension) {
            Extension extension = (Extension) obj;
            return Arrays.equals(this.extnID, extension.extnID) && this.critical == extension.critical && Arrays.equals(this.extnValue, extension.extnValue);
        }
        return false;
    }

    public BasicConstraints getBasicConstraintsValue() {
        if (!this.valueDecoded) {
            try {
                decodeExtensionValue();
            } catch (IOException e) {
            }
        }
        if (this.extnValueObject instanceof BasicConstraints) {
            return (BasicConstraints) this.extnValueObject;
        }
        return null;
    }

    public ExtensionValue getDecodedExtensionValue() throws IOException {
        if (!this.valueDecoded) {
            decodeExtensionValue();
        }
        return this.extnValueObject;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    @Override // java.security.cert.Extension
    public String getId() {
        if (this.extnID_str == null) {
            this.extnID_str = ObjectIdentifier.toString(this.extnID);
        }
        return this.extnID_str;
    }

    public KeyUsage getKeyUsageValue() {
        if (!this.valueDecoded) {
            try {
                decodeExtensionValue();
            } catch (IOException e) {
            }
        }
        if (this.extnValueObject instanceof KeyUsage) {
            return (KeyUsage) this.extnValueObject;
        }
        return null;
    }

    public byte[] getRawExtnValue() {
        if (this.rawExtnValue == null) {
            this.rawExtnValue = ASN1OctetString.getInstance().encode(this.extnValue);
        }
        return this.rawExtnValue;
    }

    @Override // java.security.cert.Extension
    public byte[] getValue() {
        return this.extnValue;
    }

    public int hashCode() {
        return (((this.critical ? 1 : 0) + (Arrays.hashCode(this.extnID) * 37)) * 37) + Arrays.hashCode(this.extnValue);
    }

    @Override // java.security.cert.Extension
    public boolean isCritical() {
        return this.critical;
    }
}
