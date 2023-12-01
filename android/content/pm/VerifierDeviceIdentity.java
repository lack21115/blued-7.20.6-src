package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/VerifierDeviceIdentity.class */
public class VerifierDeviceIdentity implements Parcelable {
    private static final int GROUP_SIZE = 4;
    private static final int LONG_SIZE = 13;
    private static final char SEPARATOR = '-';
    private final long mIdentity;
    private final String mIdentityString;
    private static final char[] ENCODE = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7'};
    public static final Parcelable.Creator<VerifierDeviceIdentity> CREATOR = new Parcelable.Creator<VerifierDeviceIdentity>() { // from class: android.content.pm.VerifierDeviceIdentity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifierDeviceIdentity createFromParcel(Parcel parcel) {
            return new VerifierDeviceIdentity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerifierDeviceIdentity[] newArray(int i) {
            return new VerifierDeviceIdentity[i];
        }
    };

    public VerifierDeviceIdentity(long j) {
        this.mIdentity = j;
        this.mIdentityString = encodeBase32(j);
    }

    private VerifierDeviceIdentity(Parcel parcel) {
        long readLong = parcel.readLong();
        this.mIdentity = readLong;
        this.mIdentityString = encodeBase32(readLong);
    }

    private static final long decodeBase32(byte[] bArr) throws IllegalArgumentException {
        int i;
        long j = 0;
        int i2 = 0;
        int length = bArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                if (i2 != 13) {
                    throw new IllegalArgumentException("too short; should have 13 characters");
                }
                return j;
            }
            byte b = bArr[i4];
            if (65 <= b && b <= 90) {
                i = b - 65;
            } else if (50 <= b && b <= 55) {
                i = b - 24;
            } else if (b == 45) {
                continue;
                i3 = i4 + 1;
            } else if (97 <= b && b <= 122) {
                i = b - 97;
            } else if (b == 48) {
                i = 14;
            } else if (b != 49) {
                throw new IllegalArgumentException("base base-32 character: " + ((int) b));
            } else {
                i = 8;
            }
            j = (j << 5) | i;
            int i5 = i2 + 1;
            if (i5 == 1) {
                i2 = i5;
                if ((i & 15) != i) {
                    throw new IllegalArgumentException("illegal start character; will overflow");
                }
            } else {
                i2 = i5;
                if (i5 > 13) {
                    throw new IllegalArgumentException("too long; should have 13 characters");
                }
            }
            i3 = i4 + 1;
        }
    }

    private static final String encodeBase32(long j) {
        char[] cArr = ENCODE;
        char[] cArr2 = new char[16];
        int length = cArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 13) {
                return String.valueOf(cArr2);
            }
            int i3 = length;
            if (i2 > 0) {
                i3 = length;
                if (i2 % 4 == 1) {
                    i3 = length - 1;
                    cArr2[i3] = '-';
                }
            }
            int i4 = (int) (31 & j);
            j >>>= 5;
            length = i3 - 1;
            cArr2[length] = cArr[i4];
            i = i2 + 1;
        }
    }

    public static VerifierDeviceIdentity generate() {
        return generate(new SecureRandom());
    }

    static VerifierDeviceIdentity generate(Random random) {
        return new VerifierDeviceIdentity(random.nextLong());
    }

    public static VerifierDeviceIdentity parse(String str) throws IllegalArgumentException {
        try {
            return new VerifierDeviceIdentity(decodeBase32(str.getBytes("US-ASCII")));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("bad base-32 characters in input");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof VerifierDeviceIdentity) && this.mIdentity == ((VerifierDeviceIdentity) obj).mIdentity;
    }

    public int hashCode() {
        return (int) this.mIdentity;
    }

    public String toString() {
        return this.mIdentityString;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mIdentity);
    }
}
