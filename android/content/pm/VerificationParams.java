package android.content.pm;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/content/pm/VerificationParams.class */
public class VerificationParams implements Parcelable {
    public static final Parcelable.Creator<VerificationParams> CREATOR = new Parcelable.Creator<VerificationParams>() { // from class: android.content.pm.VerificationParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerificationParams createFromParcel(Parcel parcel) {
            return new VerificationParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VerificationParams[] newArray(int i) {
            return new VerificationParams[i];
        }
    };
    public static final int NO_UID = -1;
    private static final String TO_STRING_PREFIX = "VerificationParams{";
    private int mInstallerUid;
    private final ManifestDigest mManifestDigest;
    private final Uri mOriginatingURI;
    private final int mOriginatingUid;
    private final Uri mReferrer;
    private final Uri mVerificationURI;

    public VerificationParams(Uri uri, Uri uri2, Uri uri3, int i, ManifestDigest manifestDigest) {
        this.mVerificationURI = uri;
        this.mOriginatingURI = uri2;
        this.mReferrer = uri3;
        this.mOriginatingUid = i;
        this.mManifestDigest = manifestDigest;
        this.mInstallerUid = -1;
    }

    private VerificationParams(Parcel parcel) {
        this.mVerificationURI = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mOriginatingURI = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mReferrer = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.mOriginatingUid = parcel.readInt();
        this.mManifestDigest = (ManifestDigest) parcel.readParcelable(ManifestDigest.class.getClassLoader());
        this.mInstallerUid = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerificationParams) {
            VerificationParams verificationParams = (VerificationParams) obj;
            if (this.mVerificationURI == null) {
                if (verificationParams.mVerificationURI != null) {
                    return false;
                }
            } else if (!this.mVerificationURI.equals(verificationParams.mVerificationURI)) {
                return false;
            }
            if (this.mOriginatingURI == null) {
                if (verificationParams.mOriginatingURI != null) {
                    return false;
                }
            } else if (!this.mOriginatingURI.equals(verificationParams.mOriginatingURI)) {
                return false;
            }
            if (this.mReferrer == null) {
                if (verificationParams.mReferrer != null) {
                    return false;
                }
            } else if (!this.mReferrer.equals(verificationParams.mReferrer)) {
                return false;
            }
            if (this.mOriginatingUid != verificationParams.mOriginatingUid) {
                return false;
            }
            if (this.mManifestDigest == null) {
                if (verificationParams.mManifestDigest != null) {
                    return false;
                }
            } else if (!this.mManifestDigest.equals(verificationParams.mManifestDigest)) {
                return false;
            }
            return this.mInstallerUid == verificationParams.mInstallerUid;
        }
        return false;
    }

    public int getInstallerUid() {
        return this.mInstallerUid;
    }

    public ManifestDigest getManifestDigest() {
        return this.mManifestDigest;
    }

    public Uri getOriginatingURI() {
        return this.mOriginatingURI;
    }

    public int getOriginatingUid() {
        return this.mOriginatingUid;
    }

    public Uri getReferrer() {
        return this.mReferrer;
    }

    public Uri getVerificationURI() {
        return this.mVerificationURI;
    }

    public int hashCode() {
        int i = 1;
        int hashCode = this.mVerificationURI == null ? 1 : this.mVerificationURI.hashCode();
        int hashCode2 = this.mOriginatingURI == null ? 1 : this.mOriginatingURI.hashCode();
        int hashCode3 = this.mReferrer == null ? 1 : this.mReferrer.hashCode();
        int i2 = this.mOriginatingUid;
        if (this.mManifestDigest != null) {
            i = this.mManifestDigest.hashCode();
        }
        return 3 + (hashCode * 5) + (hashCode2 * 7) + (hashCode3 * 11) + (i2 * 13) + (i * 17) + (this.mInstallerUid * 19);
    }

    public void setInstallerUid(int i) {
        this.mInstallerUid = i;
    }

    public String toString() {
        return TO_STRING_PREFIX + "mVerificationURI=" + this.mVerificationURI.toString() + ",mOriginatingURI=" + this.mOriginatingURI.toString() + ",mReferrer=" + this.mReferrer.toString() + ",mOriginatingUid=" + this.mOriginatingUid + ",mManifestDigest=" + this.mManifestDigest.toString() + ",mInstallerUid=" + this.mInstallerUid + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mVerificationURI, 0);
        parcel.writeParcelable(this.mOriginatingURI, 0);
        parcel.writeParcelable(this.mReferrer, 0);
        parcel.writeInt(this.mOriginatingUid);
        parcel.writeParcelable(this.mManifestDigest, 0);
        parcel.writeInt(this.mInstallerUid);
    }
}
