package java.util;

import com.android.internal.content.NativeLibraryHelper;
import com.anythink.core.common.k.f;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import libcore.io.Memory;

/* loaded from: source-2895416-dex2jar.jar:java/util/UUID.class */
public final class UUID implements Serializable, Comparable<UUID> {
    private static SecureRandom rng;
    private static final long serialVersionUID = -4856846361193249489L;
    private transient int clockSequence;
    private transient int hash;
    private long leastSigBits;
    private long mostSigBits;
    private transient long node;
    private transient long timestamp;
    private transient int variant;
    private transient int version;

    public UUID(long j, long j2) {
        this.mostSigBits = j;
        this.leastSigBits = j2;
        init();
    }

    public static UUID fromString(String str) {
        if (str == null) {
            throw new NullPointerException("uuid == null");
        }
        String[] split = str.split(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
        if (split.length != 5) {
            throw new IllegalArgumentException("Invalid UUID: " + str);
        }
        return new UUID((Long.parsePositiveLong(split[0], 16) << 32) | (Long.parsePositiveLong(split[1], 16) << 16) | Long.parsePositiveLong(split[2], 16), (Long.parsePositiveLong(split[3], 16) << 48) | Long.parsePositiveLong(split[4], 16));
    }

    private void init() {
        this.hash = ((int) (this.mostSigBits ^ (this.mostSigBits >>> 32))) ^ ((int) (this.leastSigBits ^ (this.leastSigBits >>> 32)));
        if ((this.leastSigBits & Long.MIN_VALUE) == 0) {
            this.variant = 0;
        } else if ((this.leastSigBits & 4611686018427387904L) != 0) {
            this.variant = (int) ((this.leastSigBits & (-2305843009213693952L)) >>> 61);
        } else {
            this.variant = 2;
        }
        this.version = (int) ((this.mostSigBits & 61440) >>> 12);
        if (this.variant == 2 || this.version == 1) {
            this.timestamp = ((this.mostSigBits & (-4294967296L)) >>> 32) | ((this.mostSigBits & 4294901760L) << 16) | ((this.mostSigBits & 4095) << 48);
            this.clockSequence = (int) ((this.leastSigBits & 4611404543450677248L) >>> 48);
            this.node = this.leastSigBits & 281474976710655L;
        }
    }

    private static UUID makeUuid(byte[] bArr, int i) {
        return new UUID((Memory.peekLong(bArr, 0, ByteOrder.BIG_ENDIAN) & (-61441)) | (i << 12), (Memory.peekLong(bArr, 8, ByteOrder.BIG_ENDIAN) & 4611686018427387903L) | Long.MIN_VALUE);
    }

    public static UUID nameUUIDFromBytes(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("name == null");
        }
        try {
            return makeUuid(MessageDigest.getInstance(f.a).digest(bArr), 3);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static UUID randomUUID() {
        byte[] bArr = new byte[16];
        synchronized (UUID.class) {
            try {
                if (rng == null) {
                    rng = new SecureRandom();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        rng.nextBytes(bArr);
        return makeUuid(bArr, 4);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    public int clockSequence() {
        if (this.version != 1) {
            throw new UnsupportedOperationException();
        }
        return this.clockSequence;
    }

    @Override // java.lang.Comparable
    public int compareTo(UUID uuid) {
        int i = -1;
        if (uuid == this) {
            i = 0;
        } else if (this.mostSigBits != uuid.mostSigBits) {
            if (this.mostSigBits >= uuid.mostSigBits) {
                return 1;
            }
        } else if (this.leastSigBits == uuid.leastSigBits) {
            return 0;
        } else {
            if (this.leastSigBits >= uuid.leastSigBits) {
                return 1;
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof UUID) {
            UUID uuid = (UUID) obj;
            if (this.leastSigBits != uuid.leastSigBits || this.mostSigBits != uuid.mostSigBits) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public long getLeastSignificantBits() {
        return this.leastSigBits;
    }

    public long getMostSignificantBits() {
        return this.mostSigBits;
    }

    public int hashCode() {
        return this.hash;
    }

    public long node() {
        if (this.version != 1) {
            throw new UnsupportedOperationException();
        }
        return this.node;
    }

    public long timestamp() {
        if (this.version != 1) {
            throw new UnsupportedOperationException();
        }
        return this.timestamp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        String hexString = Long.toHexString(this.mostSigBits);
        if (hexString.length() < 16) {
            int length = hexString.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 16 - length) {
                    break;
                }
                sb.append('0');
                i = i2 + 1;
            }
        }
        sb.append(hexString);
        sb.insert(8, '-');
        sb.insert(13, '-');
        sb.append('-');
        String hexString2 = Long.toHexString(this.leastSigBits);
        if (hexString2.length() < 16) {
            int length2 = hexString2.length();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 16 - length2) {
                    break;
                }
                sb.append('0');
                i3 = i4 + 1;
            }
        }
        sb.append(hexString2);
        sb.insert(23, '-');
        return sb.toString();
    }

    public int variant() {
        return this.variant;
    }

    public int version() {
        return this.version;
    }
}
