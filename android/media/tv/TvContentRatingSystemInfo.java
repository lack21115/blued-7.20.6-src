package android.media.tv;

import android.content.ContentResolver;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvContentRatingSystemInfo.class */
public final class TvContentRatingSystemInfo implements Parcelable {
    public static final Parcelable.Creator<TvContentRatingSystemInfo> CREATOR = new Parcelable.Creator<TvContentRatingSystemInfo>() { // from class: android.media.tv.TvContentRatingSystemInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TvContentRatingSystemInfo createFromParcel(Parcel parcel) {
            return new TvContentRatingSystemInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TvContentRatingSystemInfo[] newArray(int i) {
            return new TvContentRatingSystemInfo[i];
        }
    };
    private final ApplicationInfo mApplicationInfo;
    private final Uri mXmlUri;

    private TvContentRatingSystemInfo(Uri uri, ApplicationInfo applicationInfo) {
        this.mXmlUri = uri;
        this.mApplicationInfo = applicationInfo;
    }

    private TvContentRatingSystemInfo(Parcel parcel) {
        this.mXmlUri = (Uri) parcel.readParcelable(null);
        this.mApplicationInfo = (ApplicationInfo) parcel.readParcelable(null);
    }

    public static final TvContentRatingSystemInfo createTvContentRatingSystemInfo(int i, ApplicationInfo applicationInfo) {
        return new TvContentRatingSystemInfo(new Uri.Builder().scheme(ContentResolver.SCHEME_ANDROID_RESOURCE).authority(applicationInfo.packageName).appendPath(String.valueOf(i)).build(), applicationInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Uri getXmlUri() {
        return this.mXmlUri;
    }

    public final boolean isSystemDefined() {
        return (this.mApplicationInfo.flags & 1) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mXmlUri, i);
        parcel.writeParcelable(this.mApplicationInfo, i);
    }
}
