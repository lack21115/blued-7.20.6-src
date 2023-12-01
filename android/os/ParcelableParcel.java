package android.os;

import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/os/ParcelableParcel.class */
public class ParcelableParcel implements Parcelable {
    public static final Parcelable.ClassLoaderCreator<ParcelableParcel> CREATOR = new Parcelable.ClassLoaderCreator<ParcelableParcel>() { // from class: android.os.ParcelableParcel.1
        @Override // android.os.Parcelable.Creator
        public ParcelableParcel createFromParcel(Parcel parcel) {
            return new ParcelableParcel(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public ParcelableParcel createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ParcelableParcel(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public ParcelableParcel[] newArray(int i) {
            return new ParcelableParcel[i];
        }
    };
    final ClassLoader mClassLoader;
    final Parcel mParcel = Parcel.obtain();

    public ParcelableParcel(Parcel parcel, ClassLoader classLoader) {
        this.mClassLoader = classLoader;
        int readInt = parcel.readInt();
        int dataPosition = parcel.dataPosition();
        this.mParcel.appendFrom(parcel, parcel.dataPosition(), readInt);
        parcel.setDataPosition(dataPosition + readInt);
    }

    public ParcelableParcel(ClassLoader classLoader) {
        this.mClassLoader = classLoader;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Parcel getParcel() {
        this.mParcel.setDataPosition(0);
        return this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mParcel.dataSize());
        parcel.appendFrom(this.mParcel, 0, this.mParcel.dataSize());
    }
}
