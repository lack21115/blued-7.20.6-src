package org.apache.harmony.security.provider.crypto;

import dalvik.system.BlockGuard;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.ProviderException;
import java.security.SecureRandomSpi;
import libcore.io.Streams;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/provider/crypto/SHA1PRNG_SecureRandomImpl.class */
public class SHA1PRNG_SecureRandomImpl extends SecureRandomSpi implements Serializable {
    private static final int COUNTER_BASE = 0;
    private static final int[] END_FLAGS;
    private static final int EXTRAFRAME_OFFSET = 5;
    private static final int FRAME_LENGTH = 16;
    private static final int FRAME_OFFSET = 21;
    private static final int HASHBYTES_TO_USE = 20;
    private static final int HASHCOPY_OFFSET = 0;
    private static final int[] LEFT;
    private static final int[] MASK;
    private static final int MAX_BYTES = 48;
    private static final int NEXT_BYTES = 2;
    private static final int[] RIGHT1;
    private static final int[] RIGHT2;
    private static final int SET_SEED = 1;
    private static final int UNDEFINED = 0;
    private static FileInputStream devURandom;
    private static SHA1PRNG_SecureRandomImpl myRandom;
    private static final long serialVersionUID = 283736797212159675L;
    private transient int[] copies;
    private transient long counter;
    private transient int nextBIndex;
    private transient byte[] nextBytes;
    private transient int[] seed = new int[87];
    private transient long seedLength;
    private transient int state;

    static {
        try {
            devURandom = new FileInputStream(new File("/dev/urandom"));
            END_FLAGS = new int[]{Integer.MIN_VALUE, 8388608, 32768, 128};
            RIGHT1 = new int[]{0, 40, 48, 56};
            RIGHT2 = new int[]{0, 8, 16, 24};
            LEFT = new int[]{0, 24, 16, 8};
            MASK = new int[]{-1, 16777215, 65535, 255};
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SHA1PRNG_SecureRandomImpl() {
        this.seed[82] = 1732584193;
        this.seed[83] = -271733879;
        this.seed[84] = -1732584194;
        this.seed[85] = 271733878;
        this.seed[86] = -1009589776;
        this.seedLength = 0L;
        this.copies = new int[37];
        this.nextBytes = new byte[20];
        this.nextBIndex = 20;
        this.counter = 0L;
        this.state = 0;
    }

    private static byte[] getRandomBytes(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Too few bytes requested: " + i);
        }
        BlockGuard.Policy threadPolicy = BlockGuard.getThreadPolicy();
        try {
            try {
                BlockGuard.setThreadPolicy(BlockGuard.LAX_POLICY);
                byte[] bArr = new byte[i];
                Streams.readFully(devURandom, bArr, 0, i);
                return bArr;
            } catch (Exception e) {
                throw new ProviderException("Couldn't read " + i + " random bytes", e);
            }
        } finally {
            BlockGuard.setThreadPolicy(threadPolicy);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.seed = new int[87];
        this.copies = new int[37];
        this.nextBytes = new byte[20];
        this.seedLength = objectInputStream.readLong();
        this.counter = objectInputStream.readLong();
        this.state = objectInputStream.readInt();
        this.seed[81] = objectInputStream.readInt();
        int i = (this.seed[81] + 3) >> 2;
        if (this.state == 2) {
            if (this.seed[81] >= 48) {
                this.seed[16] = objectInputStream.readInt();
                this.seed[17] = objectInputStream.readInt();
                this.seed[30] = objectInputStream.readInt();
                this.seed[31] = objectInputStream.readInt();
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 16) {
                    break;
                }
                this.seed[i3] = objectInputStream.readInt();
                i2 = i3 + 1;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i) {
                    break;
                }
                this.copies[i5 + 21] = objectInputStream.readInt();
                i4 = i5 + 1;
            }
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= 5) {
                    break;
                }
                this.copies[i7] = objectInputStream.readInt();
                i6 = i7 + 1;
            }
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= 5) {
                    break;
                }
                this.seed[i9 + 82] = objectInputStream.readInt();
                i8 = i9 + 1;
            }
        } else {
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= i) {
                    break;
                }
                this.seed[i11] = objectInputStream.readInt();
                i10 = i11 + 1;
            }
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 >= 5) {
                    break;
                }
                this.seed[i13 + 82] = objectInputStream.readInt();
                i12 = i13 + 1;
            }
        }
        this.nextBIndex = objectInputStream.readInt();
        Streams.readFully(objectInputStream, this.nextBytes, this.nextBIndex, 20 - this.nextBIndex);
    }

    private void updateSeed(byte[] bArr) {
        SHA1Impl.updateHash(this.seed, bArr, 0, bArr.length - 1);
        this.seedLength += bArr.length;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int[] iArr;
        objectOutputStream.writeLong(this.seedLength);
        objectOutputStream.writeLong(this.counter);
        objectOutputStream.writeInt(this.state);
        objectOutputStream.writeInt(this.seed[81]);
        int i = (this.seed[81] + 3) >> 2;
        if (this.state != 2) {
            iArr = new int[i + 5];
            System.arraycopy(this.seed, 0, iArr, 0, i);
            System.arraycopy(this.seed, 82, iArr, i, 5);
        } else {
            int i2 = 0;
            if (this.seed[81] < 48) {
                iArr = new int[i + 26];
            } else {
                iArr = new int[i + 42];
                iArr[0] = this.seed[16];
                iArr[1] = this.seed[17];
                iArr[2] = this.seed[30];
                iArr[3] = this.seed[31];
                i2 = 0 + 4;
            }
            System.arraycopy(this.seed, 0, iArr, i2, 16);
            int i3 = i2 + 16;
            System.arraycopy(this.copies, 21, iArr, i3, i);
            int i4 = i3 + i;
            System.arraycopy(this.copies, 0, iArr, i4, 5);
            System.arraycopy(this.seed, 82, iArr, i4 + 5, 5);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= iArr.length) {
                objectOutputStream.writeInt(this.nextBIndex);
                objectOutputStream.write(this.nextBytes, this.nextBIndex, 20 - this.nextBIndex);
                return;
            }
            objectOutputStream.writeInt(iArr[i6]);
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public byte[] engineGenerateSeed(int i) {
        byte[] bArr;
        synchronized (this) {
            if (i < 0) {
                throw new NegativeArraySizeException(Integer.toString(i));
            }
            if (i == 0) {
                bArr = EmptyArray.BYTE;
            } else {
                if (myRandom == null) {
                    myRandom = new SHA1PRNG_SecureRandomImpl();
                    myRandom.engineSetSeed(getRandomBytes(20));
                }
                bArr = new byte[i];
                myRandom.engineNextBytes(bArr);
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public void engineNextBytes(byte[] bArr) {
        int i;
        int i2;
        synchronized (this) {
            if (bArr == null) {
                throw new NullPointerException("bytes == null");
            }
            int i3 = this.seed[81] == 0 ? 0 : (this.seed[81] + 7) >> 2;
            if (this.state == 0) {
                updateSeed(getRandomBytes(20));
                this.nextBIndex = 20;
                i = this.seed[81] == 0 ? 0 : (this.seed[81] + 7) >> 2;
            } else {
                i = i3;
                if (this.state == 1) {
                    System.arraycopy(this.seed, 82, this.copies, 0, 5);
                    int i4 = i3;
                    int i5 = 3;
                    while (true) {
                        int i6 = i4 + i5;
                        if (i6 >= 18) {
                            break;
                        }
                        this.seed[i6] = 0;
                        i4 = i6;
                        i5 = 1;
                    }
                    long j = (this.seedLength << 3) + 64;
                    if (this.seed[81] < 48) {
                        this.seed[14] = (int) (j >>> 32);
                        this.seed[15] = (int) ((-1) & j);
                    } else {
                        this.copies[19] = (int) (j >>> 32);
                        this.copies[20] = (int) ((-1) & j);
                    }
                    this.nextBIndex = 20;
                    i = i3;
                }
            }
            this.state = 2;
            if (bArr.length != 0) {
                int i7 = 0;
                int length = 20 - this.nextBIndex < bArr.length - 0 ? 20 - this.nextBIndex : bArr.length - 0;
                if (length > 0) {
                    System.arraycopy(this.nextBytes, this.nextBIndex, bArr, 0, length);
                    this.nextBIndex += length;
                    i7 = 0 + length;
                }
                if (i7 < bArr.length) {
                    int i8 = this.seed[81] & 3;
                    do {
                        if (i8 == 0) {
                            this.seed[i] = (int) (this.counter >>> 32);
                            this.seed[i + 1] = (int) (this.counter & (-1));
                            this.seed[i + 2] = END_FLAGS[0];
                        } else {
                            int[] iArr = this.seed;
                            iArr[i] = iArr[i] | ((int) ((this.counter >>> RIGHT1[i8]) & MASK[i8]));
                            this.seed[i + 1] = (int) ((this.counter >>> RIGHT2[i8]) & (-1));
                            this.seed[i + 2] = (int) ((this.counter << LEFT[i8]) | END_FLAGS[i8]);
                        }
                        if (this.seed[81] > 48) {
                            this.copies[5] = this.seed[16];
                            this.copies[6] = this.seed[17];
                        }
                        SHA1Impl.computeHash(this.seed);
                        if (this.seed[81] > 48) {
                            System.arraycopy(this.seed, 0, this.copies, 21, 16);
                            System.arraycopy(this.copies, 5, this.seed, 0, 16);
                            SHA1Impl.computeHash(this.seed);
                            System.arraycopy(this.copies, 21, this.seed, 0, 16);
                        }
                        this.counter++;
                        int i9 = 0;
                        int i10 = 0;
                        while (true) {
                            int i11 = i10;
                            if (i11 >= 5) {
                                break;
                            }
                            int i12 = this.seed[i11 + 82];
                            this.nextBytes[i9] = (byte) (i12 >>> 24);
                            this.nextBytes[i9 + 1] = (byte) (i12 >>> 16);
                            this.nextBytes[i9 + 2] = (byte) (i12 >>> 8);
                            this.nextBytes[i9 + 3] = (byte) i12;
                            i9 += 4;
                            i10 = i11 + 1;
                        }
                        this.nextBIndex = 0;
                        int length2 = 20 < bArr.length - i7 ? 20 : bArr.length - i7;
                        i2 = i7;
                        if (length2 > 0) {
                            System.arraycopy(this.nextBytes, 0, bArr, i7, length2);
                            i2 = i7 + length2;
                            this.nextBIndex += length2;
                        }
                        i7 = i2;
                    } while (i2 < bArr.length);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureRandomSpi
    public void engineSetSeed(byte[] bArr) {
        synchronized (this) {
            if (bArr == null) {
                throw new NullPointerException("seed == null");
            }
            if (this.state == 2) {
                System.arraycopy(this.copies, 0, this.seed, 82, 5);
            }
            this.state = 1;
            if (bArr.length != 0) {
                updateSeed(bArr);
            }
        }
    }
}
