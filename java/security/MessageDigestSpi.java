package java.security;

import java.nio.ByteBuffer;

/* loaded from: source-2895416-dex2jar.jar:java/security/MessageDigestSpi.class */
public abstract class MessageDigestSpi {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineDigest(byte[] bArr, int i, int i2) throws DigestException {
        if (i2 < engineGetDigestLength()) {
            engineReset();
            throw new DigestException("The value of len parameter is less than the actual digest length");
        } else if (i < 0) {
            engineReset();
            throw new DigestException("offset < 0");
        } else if (i + i2 > bArr.length) {
            engineReset();
            throw new DigestException("offset + len > buf.length");
        } else {
            byte[] engineDigest = engineDigest();
            if (i2 < engineDigest.length) {
                throw new DigestException("The value of len parameter is less than the actual digest length");
            }
            System.arraycopy(engineDigest, 0, bArr, i, engineDigest.length);
            return engineDigest.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineDigest();

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineGetDigestLength() {
        return 0;
    }

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
