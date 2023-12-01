package javax.crypto;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/EncryptedPrivateKeyInfo.class */
public class EncryptedPrivateKeyInfo {
    private String algName;
    private final AlgorithmParameters algParameters;
    private volatile byte[] encoded;
    private final byte[] encryptedData;
    private String oid;
    private static final byte[] nullParam = {5, 0};
    private static final ASN1Sequence asn1 = new ASN1Sequence(new ASN1Type[]{AlgorithmIdentifier.ASN1, ASN1OctetString.getInstance()}) { // from class: javax.crypto.EncryptedPrivateKeyInfo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.apache.harmony.security.asn1.ASN1TypeCollection
        public void getValues(Object obj, Object[] objArr) {
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = (EncryptedPrivateKeyInfo) obj;
            try {
                objArr[0] = new AlgorithmIdentifier(encryptedPrivateKeyInfo.oid, encryptedPrivateKeyInfo.algParameters == null ? EncryptedPrivateKeyInfo.nullParam : encryptedPrivateKeyInfo.algParameters.getEncoded());
                objArr[1] = encryptedPrivateKeyInfo.encryptedData;
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    };
    private static final ASN1SetOf ASN1Attributes = new ASN1SetOf(ASN1Any.getInstance());
    private static final ASN1Sequence ASN1PrivateKeyInfo = new ASN1Sequence(new ASN1Type[]{ASN1Integer.getInstance(), AlgorithmIdentifier.ASN1, ASN1OctetString.getInstance(), new ASN1Implicit(0, ASN1Attributes)}) { // from class: javax.crypto.EncryptedPrivateKeyInfo.2
        {
            setOptional(3);
        }
    };

    public EncryptedPrivateKeyInfo(String str, byte[] bArr) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("encryptionAlgorithmName == null");
        }
        this.algName = str;
        if (!mapAlgName()) {
            throw new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
        }
        if (bArr == null) {
            throw new NullPointerException("encryptedData == null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("encryptedData.length == 0");
        }
        this.encryptedData = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.encryptedData, 0, bArr.length);
        this.algParameters = null;
    }

    public EncryptedPrivateKeyInfo(AlgorithmParameters algorithmParameters, byte[] bArr) throws NoSuchAlgorithmException {
        if (algorithmParameters == null) {
            throw new NullPointerException("algParams == null");
        }
        this.algParameters = algorithmParameters;
        if (bArr == null) {
            throw new NullPointerException("encryptedData == null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("encryptedData.length == 0");
        }
        this.encryptedData = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.encryptedData, 0, bArr.length);
        this.algName = this.algParameters.getAlgorithm();
        if (!mapAlgName()) {
            throw new NoSuchAlgorithmException("Unsupported algorithm: " + this.algName);
        }
    }

    public EncryptedPrivateKeyInfo(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("encoded == null");
        }
        this.encoded = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.encoded, 0, bArr.length);
        Object[] objArr = (Object[]) asn1.decode(bArr);
        AlgorithmIdentifier algorithmIdentifier = (AlgorithmIdentifier) objArr[0];
        this.algName = algorithmIdentifier.getAlgorithm();
        boolean mapAlgName = mapAlgName();
        byte[] parameters = algorithmIdentifier.getParameters();
        AlgorithmParameters algorithmParameters = null;
        if (parameters != null) {
            algorithmParameters = null;
            if (!isNullValue(parameters)) {
                algorithmParameters = null;
                try {
                    AlgorithmParameters algorithmParameters2 = AlgorithmParameters.getInstance(this.algName);
                    algorithmParameters2.init(algorithmIdentifier.getParameters());
                    algorithmParameters = algorithmParameters2;
                    if (!mapAlgName) {
                        algorithmParameters = algorithmParameters2;
                        this.algName = algorithmParameters2.getAlgorithm();
                        algorithmParameters = algorithmParameters2;
                    }
                } catch (NoSuchAlgorithmException e) {
                }
            }
        }
        this.algParameters = algorithmParameters;
        this.encryptedData = (byte[]) objArr[1];
    }

    private InvalidKeyException invalidKey() throws InvalidKeyException {
        throw new InvalidKeyException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
    }

    private static boolean isNullValue(byte[] bArr) {
        return bArr[0] == 5 && bArr[1] == 0;
    }

    private boolean mapAlgName() {
        boolean z;
        if (AlgNameMapper.isOID(this.algName)) {
            this.oid = AlgNameMapper.normalize(this.algName);
            this.algName = AlgNameMapper.map2AlgName(this.oid);
            if (this.algName == null) {
                this.algName = this.oid;
            }
        } else {
            String standardName = AlgNameMapper.getStandardName(this.algName);
            this.oid = AlgNameMapper.map2OID(this.algName);
            if (this.oid == null) {
                z = false;
                if (standardName != null) {
                    this.oid = AlgNameMapper.map2OID(standardName);
                    z = false;
                    if (this.oid != null) {
                        this.algName = standardName;
                    }
                }
                return z;
            } else if (standardName != null) {
                this.algName = standardName;
            }
        }
        z = true;
        return z;
    }

    public String getAlgName() {
        return this.algName;
    }

    public AlgorithmParameters getAlgParameters() {
        return this.algParameters;
    }

    public byte[] getEncoded() throws IOException {
        if (this.encoded == null) {
            this.encoded = asn1.encode(this);
        }
        byte[] bArr = new byte[this.encoded.length];
        System.arraycopy(this.encoded, 0, bArr, 0, this.encoded.length);
        return bArr;
    }

    public byte[] getEncryptedData() {
        byte[] bArr = new byte[this.encryptedData.length];
        System.arraycopy(this.encryptedData, 0, bArr, 0, this.encryptedData.length);
        return bArr;
    }

    public PKCS8EncodedKeySpec getKeySpec(Key key) throws NoSuchAlgorithmException, InvalidKeyException {
        if (key == null) {
            throw new NullPointerException("decryptKey == null");
        }
        try {
            Cipher cipher = Cipher.getInstance(this.algName);
            if (this.algParameters == null) {
                cipher.init(2, key);
            } else {
                cipher.init(2, key, this.algParameters);
            }
            byte[] doFinal = cipher.doFinal(this.encryptedData);
            try {
                ASN1PrivateKeyInfo.verify(doFinal);
                return new PKCS8EncodedKeySpec(doFinal);
            } catch (IOException e) {
                throw invalidKey();
            }
        } catch (IllegalStateException e2) {
            throw new InvalidKeyException(e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            throw new NoSuchAlgorithmException(e3.getMessage());
        } catch (BadPaddingException e4) {
            throw new InvalidKeyException(e4.getMessage());
        } catch (IllegalBlockSizeException e5) {
            throw new InvalidKeyException(e5.getMessage());
        } catch (NoSuchPaddingException e6) {
            throw new NoSuchAlgorithmException(e6.getMessage());
        }
    }

    public PKCS8EncodedKeySpec getKeySpec(Key key, String str) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException {
        if (key == null) {
            throw new NullPointerException("decryptKey == null");
        }
        if (str == null) {
            throw new NullPointerException("providerName == null");
        }
        try {
            Cipher cipher = Cipher.getInstance(this.algName, str);
            if (this.algParameters == null) {
                cipher.init(2, key);
            } else {
                cipher.init(2, key, this.algParameters);
            }
            byte[] doFinal = cipher.doFinal(this.encryptedData);
            try {
                ASN1PrivateKeyInfo.verify(doFinal);
                return new PKCS8EncodedKeySpec(doFinal);
            } catch (IOException e) {
                throw invalidKey();
            }
        } catch (IllegalStateException e2) {
            throw new InvalidKeyException(e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            throw new NoSuchAlgorithmException(e3.getMessage());
        } catch (BadPaddingException e4) {
            throw new InvalidKeyException(e4.getMessage());
        } catch (IllegalBlockSizeException e5) {
            throw new InvalidKeyException(e5.getMessage());
        } catch (NoSuchPaddingException e6) {
            throw new NoSuchAlgorithmException(e6.getMessage());
        }
    }

    public PKCS8EncodedKeySpec getKeySpec(Key key, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        if (key == null) {
            throw new NullPointerException("decryptKey == null");
        }
        if (provider == null) {
            throw new NullPointerException("provider == null");
        }
        try {
            Cipher cipher = Cipher.getInstance(this.algName, provider);
            if (this.algParameters == null) {
                cipher.init(2, key);
            } else {
                cipher.init(2, key, this.algParameters);
            }
            byte[] doFinal = cipher.doFinal(this.encryptedData);
            try {
                ASN1PrivateKeyInfo.verify(doFinal);
                return new PKCS8EncodedKeySpec(doFinal);
            } catch (IOException e) {
                throw invalidKey();
            }
        } catch (IllegalStateException e2) {
            throw new InvalidKeyException(e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            throw new NoSuchAlgorithmException(e3.getMessage());
        } catch (BadPaddingException e4) {
            throw new InvalidKeyException(e4.getMessage());
        } catch (IllegalBlockSizeException e5) {
            throw new InvalidKeyException(e5.getMessage());
        } catch (NoSuchPaddingException e6) {
            throw new NoSuchAlgorithmException(e6.getMessage());
        }
    }

    public PKCS8EncodedKeySpec getKeySpec(Cipher cipher) throws InvalidKeySpecException {
        if (cipher == null) {
            throw new NullPointerException("cipher == null");
        }
        try {
            byte[] doFinal = cipher.doFinal(this.encryptedData);
            try {
                ASN1PrivateKeyInfo.verify(doFinal);
                return new PKCS8EncodedKeySpec(doFinal);
            } catch (IOException e) {
                throw new InvalidKeySpecException("Decrypted data does not represent valid PKCS#8 PrivateKeyInfo");
            }
        } catch (IllegalStateException e2) {
            throw new InvalidKeySpecException(e2.getMessage());
        } catch (BadPaddingException e3) {
            throw new InvalidKeySpecException(e3.getMessage());
        } catch (IllegalBlockSizeException e4) {
            throw new InvalidKeySpecException(e4.getMessage());
        }
    }
}
