package org.apache.harmony.security.pkcs8;

import java.util.List;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/pkcs8/PrivateKeyInfo.class */
public final class PrivateKeyInfo {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), AlgorithmIdentifier.ASN1, ASN1OctetString.getInstance(), new ASN1Implicit(0, new ASN1SetOf(AttributeTypeAndValue.ASN1))}) { // from class: org.apache.harmony.security.pkcs8.PrivateKeyInfo.1
        {
            setOptional(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new PrivateKeyInfo(ASN1Integer.toIntValue(objArr[0]), (AlgorithmIdentifier) objArr[1], (byte[]) objArr[2], (List) objArr[3], berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) obj;
            objArr[0] = ASN1Integer.fromIntValue(privateKeyInfo.version);
            objArr[1] = privateKeyInfo.privateKeyAlgorithm;
            objArr[2] = privateKeyInfo.privateKey;
            objArr[3] = privateKeyInfo.attributes;
        }
    };
    private final List<?> attributes;
    private byte[] encoding;
    private final byte[] privateKey;
    private final AlgorithmIdentifier privateKeyAlgorithm;
    private final int version;

    public PrivateKeyInfo(int i, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, List list) {
        this.version = i;
        this.privateKeyAlgorithm = algorithmIdentifier;
        this.privateKey = bArr;
        this.attributes = list;
    }

    private PrivateKeyInfo(int i, AlgorithmIdentifier algorithmIdentifier, byte[] bArr, List list, byte[] bArr2) {
        this(i, algorithmIdentifier, bArr, list);
        this.encoding = bArr2;
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.privateKeyAlgorithm;
    }

    public List getAttributes() {
        return this.attributes;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public byte[] getPrivateKey() {
        return this.privateKey;
    }

    public int getVersion() {
        return this.version;
    }
}
