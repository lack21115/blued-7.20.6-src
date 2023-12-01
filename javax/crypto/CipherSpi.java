package javax.crypto;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/CipherSpi.class */
public abstract class CipherSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public int engineDoFinal(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal;
        if (byteBuffer == null) {
            throw new NullPointerException("input == null");
        }
        if (byteBuffer2 == null) {
            throw new NullPointerException("output == null");
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (limit - position <= 0) {
            return 0;
        }
        if (byteBuffer.hasArray()) {
            byte[] engineDoFinal2 = engineDoFinal(byteBuffer.array(), byteBuffer.arrayOffset() + position, limit - position);
            byteBuffer.position(limit);
            engineDoFinal = engineDoFinal2;
        } else {
            byte[] bArr = new byte[limit - position];
            byteBuffer.get(bArr);
            engineDoFinal = engineDoFinal(bArr, 0, limit - position);
        }
        if (byteBuffer2.remaining() < engineDoFinal.length) {
            throw new ShortBufferException("output buffer too small");
        }
        try {
            byteBuffer2.put(engineDoFinal);
            return engineDoFinal.length;
        } catch (BufferOverflowException e) {
            throw new ShortBufferException("output buffer too small");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGetBlockSize();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGetIV();

    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGetOutputSize(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract AlgorithmParameters engineGetParameters();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineSetMode(String str) throws NoSuchAlgorithmException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineSetPadding(String str) throws NoSuchPaddingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineUpdate(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws ShortBufferException {
        byte[] engineUpdate;
        if (byteBuffer == null) {
            throw new NullPointerException("input == null");
        }
        if (byteBuffer2 == null) {
            throw new NullPointerException("output == null");
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (limit - position <= 0) {
            return 0;
        }
        if (byteBuffer.hasArray()) {
            byte[] engineUpdate2 = engineUpdate(byteBuffer.array(), byteBuffer.arrayOffset() + position, limit - position);
            byteBuffer.position(limit);
            engineUpdate = engineUpdate2;
        } else {
            byte[] bArr = new byte[limit - position];
            byteBuffer.get(bArr);
            engineUpdate = engineUpdate(bArr, 0, limit - position);
        }
        if (engineUpdate != null) {
            if (byteBuffer2.remaining() < engineUpdate.length) {
                throw new ShortBufferException("output buffer too small");
            }
            try {
                byteBuffer2.put(engineUpdate);
                return engineUpdate.length;
            } catch (BufferOverflowException e) {
                throw new ShortBufferException("output buffer too small");
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineUpdate(byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("input == null");
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (limit - position <= 0) {
            return;
        }
        if (byteBuffer.hasArray()) {
            engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + position, limit - position);
            byteBuffer.position(limit);
            return;
        }
        int i = limit - position;
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        engineUpdateAAD(bArr, 0, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineUpdateAAD(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("This cipher does not support Authenticated Encryption with Additional Data");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        throw new UnsupportedOperationException();
    }
}
