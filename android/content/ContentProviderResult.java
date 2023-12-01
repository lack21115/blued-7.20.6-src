package android.content;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/content/ContentProviderResult.class */
public class ContentProviderResult implements Parcelable {
    public static final Parcelable.Creator<ContentProviderResult> CREATOR = new Parcelable.Creator<ContentProviderResult>() { // from class: android.content.ContentProviderResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentProviderResult createFromParcel(Parcel parcel) {
            return new ContentProviderResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentProviderResult[] newArray(int i) {
            return new ContentProviderResult[i];
        }
    };
    public final Integer count;
    public final Uri uri;

    public ContentProviderResult(int i) {
        this.count = Integer.valueOf(i);
        this.uri = null;
    }

    public ContentProviderResult(ContentProviderResult contentProviderResult, int i) {
        this.uri = ContentProvider.maybeAddUserId(contentProviderResult.uri, i);
        this.count = contentProviderResult.count;
    }

    public ContentProviderResult(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("uri must not be null");
        }
        this.uri = uri;
        this.count = null;
    }

    public ContentProviderResult(Parcel parcel) {
        if (parcel.readInt() == 1) {
            this.count = Integer.valueOf(parcel.readInt());
            this.uri = null;
            return;
        }
        this.count = null;
        this.uri = Uri.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.uri != null ? "ContentProviderResult(uri=" + this.uri.toString() + ")" : "ContentProviderResult(count=" + this.count + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.uri == null) {
            parcel.writeInt(1);
            parcel.writeInt(this.count.intValue());
            return;
        }
        parcel.writeInt(2);
        this.uri.writeToParcel(parcel, 0);
    }
}
