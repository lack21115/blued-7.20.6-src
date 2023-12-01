package com.tencent.cos.xml.crypto;

import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/GCMCipherLite.class */
final class GCMCipherLite extends CipherLite {
    private static final int TAG_LENGTH = ContentCryptoScheme.AES_GCM.getTagLengthInBits() / 8;
    private CipherLite aux;
    private long currentCount;
    private boolean doneFinal;
    private byte[] finalBytes;
    private boolean invisiblyProcessed;
    private long markedCount;
    private long outputByteCount;
    private boolean securityViolated;
    private final int tagLen;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GCMCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        super(cipher, ContentCryptoScheme.AES_GCM, secretKey, i);
        this.tagLen = i == 1 ? TAG_LENGTH : 0;
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
    }

    private int checkMax(int i) {
        if (this.outputByteCount + i <= 68719476704L) {
            return i;
        }
        this.securityViolated = true;
        throw new SecurityException("Number of bytes processed has exceeded the maximum allowed by AES/GCM; [outputByteCount=" + this.outputByteCount + ", delta=" + i + "]");
    }

    private final byte[] doFinal0(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (!this.doneFinal) {
            this.doneFinal = true;
            byte[] doFinal = super.doFinal(bArr, i, i2);
            this.finalBytes = doFinal;
            if (doFinal == null) {
                return null;
            }
            this.outputByteCount += checkMax(doFinal.length - this.tagLen);
            return (byte[]) this.finalBytes.clone();
        } else if (this.securityViolated) {
            throw new SecurityException();
        } else {
            if (2 == getCipherMode()) {
                byte[] bArr2 = this.finalBytes;
                if (bArr2 == null) {
                    return null;
                }
                return (byte[]) bArr2.clone();
            }
            byte[] bArr3 = this.finalBytes;
            int length = bArr3.length;
            int i3 = this.tagLen;
            int i4 = length - i3;
            if (i2 == i4) {
                return (byte[]) bArr3.clone();
            }
            if (i2 >= i4 || i2 + this.currentCount != this.outputByteCount) {
                throw new IllegalStateException("Inconsistent re-rencryption");
            }
            return Arrays.copyOfRange(bArr3, (bArr3.length - i3) - i2, bArr3.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cos.xml.crypto.CipherLite
    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        if (this.doneFinal) {
            if (this.securityViolated) {
                throw new SecurityException();
            }
            byte[] bArr = this.finalBytes;
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        }
        this.doneFinal = true;
        byte[] doFinal = super.doFinal();
        this.finalBytes = doFinal;
        if (doFinal == null) {
            return null;
        }
        this.outputByteCount += checkMax(doFinal.length - this.tagLen);
        return (byte[]) this.finalBytes.clone();
    }

    @Override // com.tencent.cos.xml.crypto.CipherLite
    final byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal0(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cos.xml.crypto.CipherLite
    public final byte[] doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal0(bArr, i, i2);
    }

    long getCurrentCount() {
        return this.currentCount;
    }

    byte[] getFinalBytes() {
        byte[] bArr = this.finalBytes;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    long getMarkedCount() {
        return this.markedCount;
    }

    long getOutputByteCount() {
        return this.outputByteCount;
    }

    byte[] getTag() {
        byte[] bArr;
        if (getCipherMode() != 1 || (bArr = this.finalBytes) == null) {
            return null;
        }
        return Arrays.copyOfRange(bArr, bArr.length - this.tagLen, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cos.xml.crypto.CipherLite
    public long mark() {
        long j = this.aux == null ? this.outputByteCount : this.currentCount;
        this.markedCount = j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cos.xml.crypto.CipherLite
    public boolean markSupported() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cos.xml.crypto.CipherLite
    public void reset() {
        if (this.markedCount < this.outputByteCount || this.invisiblyProcessed) {
            try {
                this.aux = createAuxiliary(this.markedCount);
                this.currentCount = this.markedCount;
            } catch (Exception e) {
                throw (e instanceof RuntimeException ? (RuntimeException) e : new IllegalStateException(e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cos.xml.crypto.CipherLite
    public byte[] update(byte[] bArr, int i, int i2) {
        CipherLite cipherLite = this.aux;
        boolean z = true;
        if (cipherLite == null) {
            byte[] update = super.update(bArr, i, i2);
            if (update != null) {
                this.outputByteCount += checkMax(update.length);
                this.invisiblyProcessed = update.length == 0 && i2 > 0;
                return update;
            }
            if (bArr.length <= 0) {
                z = false;
            }
            this.invisiblyProcessed = z;
            return null;
        }
        byte[] update2 = cipherLite.update(bArr, i, i2);
        if (update2 == null) {
            return null;
        }
        long length = this.currentCount + update2.length;
        this.currentCount = length;
        long j = this.outputByteCount;
        if (length == j) {
            this.aux = null;
            return update2;
        } else if (length > j) {
            if (1 == getCipherMode()) {
                throw new IllegalStateException("currentCount=" + this.currentCount + " > outputByteCount=" + this.outputByteCount);
            }
            byte[] bArr2 = this.finalBytes;
            int length2 = bArr2 == null ? 0 : bArr2.length;
            long j2 = this.outputByteCount;
            long j3 = this.currentCount;
            long length3 = update2.length;
            long j4 = length2;
            this.currentCount = j2 - j4;
            this.aux = null;
            return Arrays.copyOf(update2, (int) ((j2 - (j3 - length3)) - j4));
        } else {
            return update2;
        }
    }
}
