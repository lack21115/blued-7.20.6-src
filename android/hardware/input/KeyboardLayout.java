package android.hardware.input;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/input/KeyboardLayout.class */
public final class KeyboardLayout implements Parcelable, Comparable<KeyboardLayout> {
    public static final Parcelable.Creator<KeyboardLayout> CREATOR = new Parcelable.Creator<KeyboardLayout>() { // from class: android.hardware.input.KeyboardLayout.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeyboardLayout createFromParcel(Parcel parcel) {
            return new KeyboardLayout(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeyboardLayout[] newArray(int i) {
            return new KeyboardLayout[i];
        }
    };
    private final String mCollection;
    private final String mDescriptor;
    private final String mLabel;
    private final int mPriority;

    private KeyboardLayout(Parcel parcel) {
        this.mDescriptor = parcel.readString();
        this.mLabel = parcel.readString();
        this.mCollection = parcel.readString();
        this.mPriority = parcel.readInt();
    }

    public KeyboardLayout(String str, String str2, String str3, int i) {
        this.mDescriptor = str;
        this.mLabel = str2;
        this.mCollection = str3;
        this.mPriority = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(KeyboardLayout keyboardLayout) {
        int compare = Integer.compare(keyboardLayout.mPriority, this.mPriority);
        int i = compare;
        if (compare == 0) {
            i = this.mLabel.compareToIgnoreCase(keyboardLayout.mLabel);
        }
        int i2 = i;
        if (i == 0) {
            i2 = this.mCollection.compareToIgnoreCase(keyboardLayout.mCollection);
        }
        return i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCollection() {
        return this.mCollection;
    }

    public String getDescriptor() {
        return this.mDescriptor;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String toString() {
        return this.mCollection.isEmpty() ? this.mLabel : this.mLabel + " - " + this.mCollection;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDescriptor);
        parcel.writeString(this.mLabel);
        parcel.writeString(this.mCollection);
        parcel.writeInt(this.mPriority);
    }
}
