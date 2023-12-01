package org.apache.harmony.security.x509;

import java.util.Arrays;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.AlgNameMapper;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/AlgorithmIdentifier.class */
public final class AlgorithmIdentifier {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Oid.getInstance(), ASN1Any.getInstance()}) { // from class: org.apache.harmony.security.x509.AlgorithmIdentifier.1
        {
            setOptional(1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new AlgorithmIdentifier(ObjectIdentifier.toString((int[]) objArr[0]), (byte[]) objArr[1]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            AlgorithmIdentifier algorithmIdentifier = (AlgorithmIdentifier) obj;
            objArr[0] = ObjectIdentifier.toIntArray(algorithmIdentifier.getAlgorithm());
            objArr[1] = algorithmIdentifier.getParameters();
        }
    };
    private String algorithm;
    private String algorithmName;
    private byte[] encoding;
    private byte[] parameters;

    public AlgorithmIdentifier(String str) {
        this(str, null, null);
    }

    public AlgorithmIdentifier(String str, String str2) {
        this(str, null, null);
        this.algorithmName = str2;
    }

    public AlgorithmIdentifier(String str, byte[] bArr) {
        this(str, bArr, null);
    }

    private AlgorithmIdentifier(String str, byte[] bArr, byte[] bArr2) {
        this.algorithm = str;
        this.parameters = bArr;
        this.encoding = bArr2;
    }

    public void dumpValue(StringBuilder sb) {
        sb.append(getAlgorithmName());
        if (this.parameters == null) {
            sb.append(", no params, ");
        } else {
            sb.append(", params unparsed, ");
        }
        sb.append("OID = ");
        sb.append(getAlgorithm());
    }

    public boolean equals(Object obj) {
        if (obj instanceof AlgorithmIdentifier) {
            AlgorithmIdentifier algorithmIdentifier = (AlgorithmIdentifier) obj;
            if (this.algorithm.equals(algorithmIdentifier.algorithm)) {
                return this.parameters == null ? algorithmIdentifier.parameters == null : Arrays.equals(this.parameters, algorithmIdentifier.parameters);
            }
            return false;
        }
        return false;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getAlgorithmName() {
        if (this.algorithmName == null) {
            this.algorithmName = AlgNameMapper.map2AlgName(this.algorithm);
            if (this.algorithmName == null) {
                this.algorithmName = this.algorithm;
            }
        }
        return this.algorithmName;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public byte[] getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return (this.parameters != null ? Arrays.hashCode(this.parameters) : 0) + (this.algorithm.hashCode() * 37);
    }
}
