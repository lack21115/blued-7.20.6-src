package javax.crypto;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/MacSpi.class */
public abstract class MacSpi {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineDoFinal();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGetMacLength();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineReset();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte b);

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineUpdate(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (!byteBuffer.hasArray()) {
                byte[] bArr = new byte[byteBuffer.limit() - byteBuffer.position()];
                byteBuffer.get(bArr);
                engineUpdate(bArr, 0, bArr.length);
                return;
            }
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset();
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            engineUpdate(array, arrayOffset + position, limit - position);
            byteBuffer.position(limit);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte[] bArr, int i, int i2);
}
