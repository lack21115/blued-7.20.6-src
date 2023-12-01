package android.security;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-9557208-dex2jar.jar:android/security/KeyPairGeneratorSpec.class */
public final class KeyPairGeneratorSpec implements AlgorithmParameterSpec {
    private static final int DSA_DEFAULT_KEY_SIZE = 1024;
    private static final int DSA_MAX_KEY_SIZE = 8192;
    private static final int DSA_MIN_KEY_SIZE = 512;
    private static final int EC_DEFAULT_KEY_SIZE = 256;
    private static final int EC_MAX_KEY_SIZE = 521;
    private static final int EC_MIN_KEY_SIZE = 192;
    private static final int RSA_DEFAULT_KEY_SIZE = 2048;
    private static final int RSA_MAX_KEY_SIZE = 8192;
    private static final int RSA_MIN_KEY_SIZE = 512;
    private final Context mContext;
    private final Date mEndDate;
    private final int mFlags;
    private final int mKeySize;
    private final String mKeyType;
    private final String mKeystoreAlias;
    private final BigInteger mSerialNumber;
    private final AlgorithmParameterSpec mSpec;
    private final Date mStartDate;
    private final X500Principal mSubjectDN;

    /* loaded from: source-9557208-dex2jar.jar:android/security/KeyPairGeneratorSpec$Builder.class */
    public static final class Builder {
        private final Context mContext;
        private Date mEndDate;
        private int mFlags;
        private String mKeystoreAlias;
        private BigInteger mSerialNumber;
        private AlgorithmParameterSpec mSpec;
        private Date mStartDate;
        private X500Principal mSubjectDN;
        private String mKeyType = "RSA";
        private int mKeySize = -1;

        public Builder(Context context) {
            if (context == null) {
                throw new NullPointerException("context == null");
            }
            this.mContext = context;
        }

        public KeyPairGeneratorSpec build() {
            return new KeyPairGeneratorSpec(this.mContext, this.mKeystoreAlias, this.mKeyType, this.mKeySize, this.mSpec, this.mSubjectDN, this.mSerialNumber, this.mStartDate, this.mEndDate, this.mFlags);
        }

        public Builder setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec == null) {
                throw new NullPointerException("spec == null");
            }
            this.mSpec = algorithmParameterSpec;
            return this;
        }

        public Builder setAlias(String str) {
            if (str == null) {
                throw new NullPointerException("alias == null");
            }
            this.mKeystoreAlias = str;
            return this;
        }

        public Builder setEncryptionRequired() {
            this.mFlags |= 1;
            return this;
        }

        public Builder setEndDate(Date date) {
            if (date == null) {
                throw new NullPointerException("endDate == null");
            }
            this.mEndDate = date;
            return this;
        }

        public Builder setKeySize(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("keySize < 0");
            }
            this.mKeySize = i;
            return this;
        }

        public Builder setKeyType(String str) throws NoSuchAlgorithmException {
            if (str == null) {
                throw new NullPointerException("keyType == null");
            }
            try {
                KeyStore.getKeyTypeForAlgorithm(str);
                this.mKeyType = str;
                return this;
            } catch (IllegalArgumentException e) {
                throw new NoSuchAlgorithmException("Unsupported key type: " + str);
            }
        }

        public Builder setSerialNumber(BigInteger bigInteger) {
            if (bigInteger == null) {
                throw new NullPointerException("serialNumber == null");
            }
            this.mSerialNumber = bigInteger;
            return this;
        }

        public Builder setStartDate(Date date) {
            if (date == null) {
                throw new NullPointerException("startDate == null");
            }
            this.mStartDate = date;
            return this;
        }

        public Builder setSubject(X500Principal x500Principal) {
            if (x500Principal == null) {
                throw new NullPointerException("subject == null");
            }
            this.mSubjectDN = x500Principal;
            return this;
        }
    }

    public KeyPairGeneratorSpec(Context context, String str, String str2, int i, AlgorithmParameterSpec algorithmParameterSpec, X500Principal x500Principal, BigInteger bigInteger, Date date, Date date2, int i2) {
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("keyStoreAlias must not be empty");
        }
        if (x500Principal == null) {
            throw new IllegalArgumentException("subjectDN == null");
        }
        if (bigInteger == null) {
            throw new IllegalArgumentException("serialNumber == null");
        }
        if (date == null) {
            throw new IllegalArgumentException("startDate == null");
        }
        if (date2 == null) {
            throw new IllegalArgumentException("endDate == null");
        }
        if (date2.before(date)) {
            throw new IllegalArgumentException("endDate < startDate");
        }
        int keyTypeForAlgorithm = KeyStore.getKeyTypeForAlgorithm(str2);
        int defaultKeySizeForType = i == -1 ? getDefaultKeySizeForType(keyTypeForAlgorithm) : i;
        checkCorrectParametersSpec(keyTypeForAlgorithm, defaultKeySizeForType, algorithmParameterSpec);
        checkValidKeySize(keyTypeForAlgorithm, defaultKeySizeForType);
        this.mContext = context;
        this.mKeystoreAlias = str;
        this.mKeyType = str2;
        this.mKeySize = defaultKeySizeForType;
        this.mSpec = algorithmParameterSpec;
        this.mSubjectDN = x500Principal;
        this.mSerialNumber = bigInteger;
        this.mStartDate = date;
        this.mEndDate = date2;
        this.mFlags = i2;
    }

    private static void checkCorrectParametersSpec(int i, int i2, AlgorithmParameterSpec algorithmParameterSpec) {
        if (i == 116 && algorithmParameterSpec != null) {
            if (!(algorithmParameterSpec instanceof DSAParameterSpec)) {
                throw new IllegalArgumentException("DSA keys must have DSAParameterSpec specified");
            }
        } else if (i != 6 || algorithmParameterSpec == null) {
        } else {
            if (!(algorithmParameterSpec instanceof RSAKeyGenParameterSpec)) {
                throw new IllegalArgumentException("RSA may only use RSAKeyGenParameterSpec");
            }
            RSAKeyGenParameterSpec rSAKeyGenParameterSpec = (RSAKeyGenParameterSpec) algorithmParameterSpec;
            if (i2 != -1 && i2 != rSAKeyGenParameterSpec.getKeysize()) {
                throw new IllegalArgumentException("RSA key size must match: " + i2 + " vs " + rSAKeyGenParameterSpec.getKeysize());
            }
        }
    }

    private static void checkValidKeySize(int i, int i2) {
        if (i == 116) {
            if (i2 < 512 || i2 > 8192) {
                throw new IllegalArgumentException("DSA keys must be >= 512 and <= 8192");
            }
        } else if (i == 408) {
            if (i2 < 192 || i2 > 521) {
                throw new IllegalArgumentException("EC keys must be >= 192 and <= 521");
            }
        } else if (i != 6) {
            throw new IllegalArgumentException("Invalid key type " + i);
        } else {
            if (i2 < 512 || i2 > 8192) {
                throw new IllegalArgumentException("RSA keys must be >= 512 and <= 8192");
            }
        }
    }

    private static int getDefaultKeySizeForType(int i) {
        if (i == 116) {
            return 1024;
        }
        if (i == 408) {
            return 256;
        }
        if (i == 6) {
            return 2048;
        }
        throw new IllegalArgumentException("Invalid key type " + i);
    }

    public AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return this.mSpec;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Date getEndDate() {
        return this.mEndDate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFlags() {
        return this.mFlags;
    }

    public int getKeySize() {
        return this.mKeySize;
    }

    public String getKeyType() {
        return this.mKeyType;
    }

    public String getKeystoreAlias() {
        return this.mKeystoreAlias;
    }

    public BigInteger getSerialNumber() {
        return this.mSerialNumber;
    }

    public Date getStartDate() {
        return this.mStartDate;
    }

    public X500Principal getSubjectDN() {
        return this.mSubjectDN;
    }

    public boolean isEncryptionRequired() {
        return (this.mFlags & 1) != 0;
    }
}
