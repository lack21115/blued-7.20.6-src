package javax.crypto.spec;

import java.security.spec.KeySpec;
import java.util.Arrays;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/PBEKeySpec.class */
public class PBEKeySpec implements KeySpec {
    private final int iterationCount;
    private final int keyLength;
    private char[] password;
    private final byte[] salt;

    public PBEKeySpec(char[] cArr) {
        if (cArr == null) {
            this.password = EmptyArray.CHAR;
        } else {
            this.password = new char[cArr.length];
            System.arraycopy(cArr, 0, this.password, 0, cArr.length);
        }
        this.salt = null;
        this.iterationCount = 0;
        this.keyLength = 0;
    }

    public PBEKeySpec(char[] cArr, byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("salt == null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("salt.length == 0");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("iterationCount <= 0");
        }
        if (cArr == null) {
            this.password = EmptyArray.CHAR;
        } else {
            this.password = new char[cArr.length];
            System.arraycopy(cArr, 0, this.password, 0, cArr.length);
        }
        this.salt = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.salt, 0, bArr.length);
        this.iterationCount = i;
        this.keyLength = 0;
    }

    public PBEKeySpec(char[] cArr, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("salt == null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("salt.length == 0");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("iterationCount <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("keyLength <= 0");
        }
        if (cArr == null) {
            this.password = EmptyArray.CHAR;
        } else {
            this.password = new char[cArr.length];
            System.arraycopy(cArr, 0, this.password, 0, cArr.length);
        }
        this.salt = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.salt, 0, bArr.length);
        this.iterationCount = i;
        this.keyLength = i2;
    }

    public final void clearPassword() {
        Arrays.fill(this.password, '?');
        this.password = null;
    }

    public final int getIterationCount() {
        return this.iterationCount;
    }

    public final int getKeyLength() {
        return this.keyLength;
    }

    public final char[] getPassword() {
        if (this.password == null) {
            throw new IllegalStateException("The password has been cleared");
        }
        char[] cArr = new char[this.password.length];
        System.arraycopy(this.password, 0, cArr, 0, this.password.length);
        return cArr;
    }

    public final byte[] getSalt() {
        if (this.salt == null) {
            return null;
        }
        byte[] bArr = new byte[this.salt.length];
        System.arraycopy(this.salt, 0, bArr, 0, this.salt.length);
        return bArr;
    }
}
