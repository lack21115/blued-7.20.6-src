package android.text;

import android.os.Parcel;

/* loaded from: source-9557208-dex2jar.jar:android/text/Annotation.class */
public class Annotation implements ParcelableSpan {
    private final String mKey;
    private final String mValue;

    public Annotation(Parcel parcel) {
        this.mKey = parcel.readString();
        this.mValue = parcel.readString();
    }

    public Annotation(String str, String str2) {
        this.mKey = str;
        this.mValue = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getKey() {
        return this.mKey;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 18;
    }

    public String getValue() {
        return this.mValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKey);
        parcel.writeString(this.mValue);
    }
}
