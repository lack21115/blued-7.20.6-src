package pl.droidsonroids.gif;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifAnimationMetaData.class */
public class GifAnimationMetaData implements Parcelable, Serializable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new Parcelable.Creator<GifAnimationMetaData>() { // from class: pl.droidsonroids.gif.GifAnimationMetaData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GifAnimationMetaData createFromParcel(Parcel parcel) {
            return new GifAnimationMetaData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GifAnimationMetaData[] newArray(int i) {
            return new GifAnimationMetaData[i];
        }
    };
    private static final long serialVersionUID = 5692363926580237325L;

    /* renamed from: a  reason: collision with root package name */
    private final int f44127a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f44128c;
    private final int d;
    private final int e;
    private final long f;
    private final long g;

    private GifAnimationMetaData(Parcel parcel) {
        this.f44127a = parcel.readInt();
        this.b = parcel.readInt();
        this.f44128c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.g = parcel.readLong();
        this.f = parcel.readLong();
    }

    public boolean a() {
        return this.e > 1 && this.b > 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        int i = this.f44127a;
        String format = String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", Integer.valueOf(this.d), Integer.valueOf(this.f44128c), Integer.valueOf(this.e), i == 0 ? "Infinity" : Integer.toString(i), Integer.valueOf(this.b));
        String str = format;
        if (a()) {
            str = "Animated " + format;
        }
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f44127a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f44128c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeLong(this.g);
        parcel.writeLong(this.f);
    }
}
