package java.security;

import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:java/security/SignatureSpi.class */
public abstract class SignatureSpi {
    protected SecureRandom appRandom;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract Object engineGetParameter(String str) throws InvalidParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInitSign(PrivateKey privateKey) throws InvalidKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.appRandom = secureRandom;
        engineInitSign(privateKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInitVerify(PublicKey publicKey) throws InvalidKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract void engineSetParameter(String str, Object obj) throws InvalidParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineSign(byte[] bArr, int i, int i2) throws SignatureException {
        byte[] engineSign = engineSign();
        if (engineSign == null) {
            return 0;
        }
        if (i2 < engineSign.length) {
            throw new SignatureException("The value of len parameter is less than the actual signature length");
        }
        if (i < 0) {
            throw new SignatureException("offset < 0");
        }
        if (i + i2 > bArr.length) {
            throw new SignatureException("offset + len > outbuf.length");
        }
        System.arraycopy(engineSign, 0, bArr, i, engineSign.length);
        return engineSign.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineSign() throws SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte b) throws SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineUpdate(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (!byteBuffer.hasArray()) {
                byte[] bArr = new byte[byteBuffer.limit() - byteBuffer.position()];
                byteBuffer.get(bArr);
                try {
                    engineUpdate(bArr, 0, bArr.length);
                    return;
                } catch (SignatureException e) {
                    throw new RuntimeException(e);
                }
            }
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset();
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            try {
                engineUpdate(array, arrayOffset + position, limit - position);
                byteBuffer.position(limit);
            } catch (SignatureException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean engineVerify(byte[] bArr) throws SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr, int i, int i2) throws SignatureException {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return engineVerify(bArr2);
    }
}
