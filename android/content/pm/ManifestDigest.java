package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Slog;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import libcore.io.IoUtils;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ManifestDigest.class */
public class ManifestDigest implements Parcelable {
    public static final Parcelable.Creator<ManifestDigest> CREATOR = new Parcelable.Creator<ManifestDigest>() { // from class: android.content.pm.ManifestDigest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ManifestDigest createFromParcel(Parcel parcel) {
            return new ManifestDigest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ManifestDigest[] newArray(int i) {
            return new ManifestDigest[i];
        }
    };
    private static final String DIGEST_ALGORITHM = "SHA-256";
    private static final String TAG = "ManifestDigest";
    private static final String TO_STRING_PREFIX = "ManifestDigest {mDigest=";
    private final byte[] mDigest;

    private ManifestDigest(Parcel parcel) {
        this.mDigest = parcel.createByteArray();
    }

    ManifestDigest(byte[] bArr) {
        this.mDigest = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ManifestDigest fromInputStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(DIGEST_ALGORITHM);
            DigestInputStream digestInputStream = new DigestInputStream(new BufferedInputStream(inputStream), messageDigest);
            try {
                try {
                    byte[] bArr = new byte[8192];
                    do {
                    } while (digestInputStream.read(bArr, 0, bArr.length) != -1);
                    IoUtils.closeQuietly(digestInputStream);
                    return new ManifestDigest(messageDigest.digest());
                } catch (IOException e) {
                    Slog.w(TAG, "Could not read manifest");
                    IoUtils.closeQuietly(digestInputStream);
                    return null;
                }
            } catch (Throwable th) {
                IoUtils.closeQuietly(digestInputStream);
                throw th;
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("SHA-256 must be available", e2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ManifestDigest) {
            ManifestDigest manifestDigest = (ManifestDigest) obj;
            return this == manifestDigest || Arrays.equals(this.mDigest, manifestDigest.mDigest);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mDigest);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(TO_STRING_PREFIX.length() + (this.mDigest.length * 3) + 1);
        sb.append(TO_STRING_PREFIX);
        int length = this.mDigest.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                sb.append('}');
                return sb.toString();
            }
            IntegralToString.appendByteAsHex(sb, this.mDigest[i2], false);
            sb.append(',');
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.mDigest);
    }
}
