package com.android.org.conscrypt;

import com.android.org.conscrypt.util.EmptyArray;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipherRSA.class */
public abstract class OpenSSLCipherRSA extends CipherSpi {
    private byte[] buffer;
    private int bufferOffset;
    private boolean encrypting;
    private boolean inputTooLarge;
    private OpenSSLKey key;
    private int padding;
    private boolean usingPrivateKey;

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipherRSA$PKCS1.class */
    public static class PKCS1 extends OpenSSLCipherRSA {
        public PKCS1() {
            super(1);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipherRSA$Raw.class */
    public static class Raw extends OpenSSLCipherRSA {
        public Raw() {
            super(3);
        }
    }

    protected OpenSSLCipherRSA(int i) {
        this.padding = 1;
        this.padding = i;
    }

    private void engineInitInternal(int i, Key key) throws InvalidKeyException {
        if (i == 1 || i == 3) {
            this.encrypting = true;
        } else if (i != 2 && i != 4) {
            throw new InvalidParameterException("Unsupported opmode " + i);
        } else {
            this.encrypting = false;
        }
        if (key instanceof OpenSSLRSAPrivateKey) {
            this.usingPrivateKey = true;
            this.key = ((OpenSSLRSAPrivateKey) key).getOpenSSLKey();
        } else if (key instanceof RSAPrivateCrtKey) {
            this.usingPrivateKey = true;
            this.key = OpenSSLRSAPrivateCrtKey.getInstance((RSAPrivateCrtKey) key);
        } else if (key instanceof RSAPrivateKey) {
            this.usingPrivateKey = true;
            this.key = OpenSSLRSAPrivateKey.getInstance((RSAPrivateKey) key);
        } else if (key instanceof OpenSSLRSAPublicKey) {
            this.usingPrivateKey = false;
            this.key = ((OpenSSLRSAPublicKey) key).getOpenSSLKey();
        } else if (!(key instanceof RSAPublicKey)) {
            throw new InvalidKeyException("Need RSA private or public key");
        } else {
            this.usingPrivateKey = false;
            this.key = OpenSSLRSAPublicKey.getInstance((RSAPublicKey) key);
        }
        this.buffer = new byte[NativeCrypto.RSA_size(this.key.getPkeyContext())];
        this.inputTooLarge = false;
    }

    private int keySizeBytes() {
        if (this.key == null) {
            throw new IllegalStateException("cipher is not initialized");
        }
        return NativeCrypto.RSA_size(this.key.getPkeyContext());
    }

    private int paddedBlockSizeBytes() {
        int keySizeBytes = keySizeBytes();
        int i = keySizeBytes;
        if (this.padding == 1) {
            i = (keySizeBytes - 1) - 10;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        int length = i3 + engineDoFinal.length;
        if (length > bArr2.length) {
            throw new ShortBufferException("output buffer is too small " + bArr2.length + " < " + length);
        }
        System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
        return engineDoFinal.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        int RSA_private_decrypt;
        if (bArr != null) {
            engineUpdate(bArr, i, i2);
        }
        if (this.inputTooLarge) {
            throw new IllegalBlockSizeException("input must be under " + this.buffer.length + " bytes");
        }
        if (this.bufferOffset == this.buffer.length) {
            bArr2 = this.buffer;
        } else if (this.padding == 3) {
            bArr2 = new byte[this.buffer.length];
            System.arraycopy(this.buffer, 0, bArr2, this.buffer.length - this.bufferOffset, this.bufferOffset);
        } else {
            bArr2 = Arrays.copyOf(this.buffer, this.bufferOffset);
        }
        byte[] bArr3 = new byte[this.buffer.length];
        if (this.encrypting) {
            RSA_private_decrypt = this.usingPrivateKey ? NativeCrypto.RSA_private_encrypt(bArr2.length, bArr2, bArr3, this.key.getPkeyContext(), this.padding) : NativeCrypto.RSA_public_encrypt(bArr2.length, bArr2, bArr3, this.key.getPkeyContext(), this.padding);
        } else {
            try {
                RSA_private_decrypt = this.usingPrivateKey ? NativeCrypto.RSA_private_decrypt(bArr2.length, bArr2, bArr3, this.key.getPkeyContext(), this.padding) : NativeCrypto.RSA_public_decrypt(bArr2.length, bArr2, bArr3, this.key.getPkeyContext(), this.padding);
            } catch (SignatureException e) {
                IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
                illegalBlockSizeException.initCause(e);
                throw illegalBlockSizeException;
            }
        }
        byte[] bArr4 = bArr3;
        if (!this.encrypting) {
            bArr4 = bArr3;
            if (RSA_private_decrypt != bArr3.length) {
                bArr4 = Arrays.copyOf(bArr3, RSA_private_decrypt);
            }
        }
        this.bufferOffset = 0;
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.encrypting ? paddedBlockSizeBytes() : keySizeBytes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        return this.encrypting ? keySizeBytes() : paddedBlockSizeBytes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters != null) {
            throw new InvalidAlgorithmParameterException("unknown param type: " + algorithmParameters.getClass().getName());
        }
        engineInitInternal(i, key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        engineInitInternal(i, key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("unknown param type: " + algorithmParameterSpec.getClass().getName());
        }
        engineInitInternal(i, key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = str.toUpperCase(Locale.ROOT);
        if (!"NONE".equals(upperCase) && !"ECB".equals(upperCase)) {
            throw new NoSuchAlgorithmException("mode not supported: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = str.toUpperCase(Locale.ROOT);
        if ("PKCS1PADDING".equals(upperCase)) {
            this.padding = 1;
        } else if (!"NOPADDING".equals(upperCase)) {
            throw new NoSuchPaddingException("padding not supported: " + str);
        } else {
            this.padding = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i == 1) {
                return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(engineDoFinal));
            }
            if (i == 2) {
                return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
            }
            if (i == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            throw new UnsupportedOperationException("wrappedKeyType == " + i);
        } catch (InvalidKeySpecException e) {
            throw new InvalidKeyException(e);
        } catch (BadPaddingException e2) {
            throw new InvalidKeyException(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new InvalidKeyException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        engineUpdate(bArr, i, i2);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        if (this.bufferOffset + i2 > this.buffer.length) {
            this.inputTooLarge = true;
            return EmptyArray.BYTE;
        }
        System.arraycopy(bArr, i, this.buffer, this.bufferOffset, i2);
        this.bufferOffset += i2;
        return EmptyArray.BYTE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        try {
            byte[] encoded = key.getEncoded();
            return engineDoFinal(encoded, 0, encoded.length);
        } catch (BadPaddingException e) {
            IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
            illegalBlockSizeException.initCause(e);
            throw illegalBlockSizeException;
        }
    }
}
