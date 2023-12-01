package org.apache.harmony.security.x509;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/x509/SubjectPublicKeyInfo.class */
public final class SubjectPublicKeyInfo {
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]{AlgorithmIdentifier.ASN1, ASN1BitString.getInstance()}) { // from class: org.apache.harmony.security.x509.SubjectPublicKeyInfo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1Type
        public Object getDecodedObject(BerInputStream berInputStream) {
            Object[] objArr = (Object[]) berInputStream.content;
            return new SubjectPublicKeyInfo((AlgorithmIdentifier) objArr[0], ((BitString) objArr[1]).bytes, ((BitString) objArr[1]).unusedBits, berInputStream.getEncoded());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            SubjectPublicKeyInfo subjectPublicKeyInfo = (SubjectPublicKeyInfo) obj;
            objArr[0] = subjectPublicKeyInfo.algorithmID;
            objArr[1] = new BitString(subjectPublicKeyInfo.subjectPublicKey, subjectPublicKeyInfo.unusedBits);
        }
    };
    private AlgorithmIdentifier algorithmID;
    private byte[] encoding;
    private PublicKey publicKey;
    private byte[] subjectPublicKey;
    private int unusedBits;

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this(algorithmIdentifier, bArr, 0);
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, int i) {
        this(algorithmIdentifier, bArr, 0, null);
    }

    private SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, int i, byte[] bArr2) {
        this.algorithmID = algorithmIdentifier;
        this.subjectPublicKey = bArr;
        this.unusedBits = i;
        this.encoding = bArr2;
    }

    private static PublicKey generateKeyForAlgorithm(KeySpec keySpec, String str) {
        try {
            return KeyFactory.getInstance(str).generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return null;
        }
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algorithmID;
    }

    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = ASN1.encode(this);
        }
        return this.encoding;
    }

    public PublicKey getPublicKey() {
        if (this.publicKey == null) {
            byte[] encoded = getEncoded();
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(encoded);
            String algorithmName = this.algorithmID.getAlgorithmName();
            this.publicKey = generateKeyForAlgorithm(x509EncodedKeySpec, algorithmName);
            String algorithm = this.algorithmID.getAlgorithm();
            if (this.publicKey == null && !algorithm.equals(algorithmName)) {
                this.publicKey = generateKeyForAlgorithm(x509EncodedKeySpec, algorithm);
            }
            if (this.publicKey == null) {
                this.publicKey = new X509PublicKey(algorithm, encoded, this.subjectPublicKey);
            }
        }
        return this.publicKey;
    }

    public byte[] getSubjectPublicKey() {
        return this.subjectPublicKey;
    }
}
