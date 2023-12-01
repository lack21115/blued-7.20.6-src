package org.conscrypt;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLSignatureRawECDSA.class */
public class OpenSSLSignatureRawECDSA extends SignatureSpi {
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private OpenSSLKey key;

    private static OpenSSLKey verifyKey(OpenSSLKey openSSLKey) throws InvalidKeyException {
        if (NativeCrypto.EVP_PKEY_type(openSSLKey.getNativeRef()) == 408) {
            return openSSLKey;
        }
        throw new InvalidKeyException("Non-EC key used to initialize EC signature.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) throws InvalidParameterException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        this.key = verifyKey(OpenSSLKey.fromPrivateKey(privateKey));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        this.key = verifyKey(OpenSSLKey.fromPublicKey(publicKey));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) throws InvalidParameterException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        OpenSSLKey openSSLKey = this.key;
        if (openSSLKey != null) {
            int ECDSA_size = NativeCrypto.ECDSA_size(openSSLKey.getNativeRef());
            byte[] bArr = new byte[ECDSA_size];
            try {
                try {
                    int ECDSA_sign = NativeCrypto.ECDSA_sign(this.buffer.toByteArray(), bArr, this.key.getNativeRef());
                    if (ECDSA_sign >= 0) {
                        byte[] bArr2 = bArr;
                        if (ECDSA_sign != ECDSA_size) {
                            bArr2 = new byte[ECDSA_sign];
                            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, ECDSA_sign);
                        }
                        this.buffer.reset();
                        return bArr2;
                    }
                    throw new SignatureException("Could not compute signature.");
                } catch (Exception e) {
                    throw new SignatureException(e);
                }
            } catch (Throwable th) {
                this.buffer.reset();
                throw th;
            }
        }
        throw new SignatureException("No key provided");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.buffer.write(b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        if (this.key != null) {
            try {
                try {
                    int ECDSA_verify = NativeCrypto.ECDSA_verify(this.buffer.toByteArray(), bArr, this.key.getNativeRef());
                    if (ECDSA_verify == -1) {
                        throw new SignatureException("Could not verify signature.");
                    }
                    boolean z = true;
                    if (ECDSA_verify != 1) {
                        z = false;
                    }
                    this.buffer.reset();
                    return z;
                } catch (Exception e) {
                    throw new SignatureException(e);
                }
            } catch (Throwable th) {
                this.buffer.reset();
                throw th;
            }
        }
        throw new SignatureException("No key provided");
    }
}
