package android.location;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/location/GeoFenceParams.class */
public class GeoFenceParams implements Parcelable {
    public static final Parcelable.Creator<GeoFenceParams> CREATOR = new Parcelable.Creator<GeoFenceParams>() { // from class: android.location.GeoFenceParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeoFenceParams createFromParcel(Parcel parcel) {
            return new GeoFenceParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeoFenceParams[] newArray(int i) {
            return new GeoFenceParams[i];
        }
    };
    public static final int ENTERING = 1;
    public static final int LEAVING = 2;
    public final long mExpiration;
    public final PendingIntent mIntent;
    public final double mLatitude;
    public final double mLongitude;
    public final String mPackageName;
    public final float mRadius;
    public final int mUid;

    public GeoFenceParams(double d, double d2, float f, long j, PendingIntent pendingIntent, String str) {
        this(Binder.getCallingUid(), d, d2, f, j, pendingIntent, str);
    }

    public GeoFenceParams(int i, double d, double d2, float f, long j, PendingIntent pendingIntent, String str) {
        this.mUid = i;
        this.mLatitude = d;
        this.mLongitude = d2;
        this.mRadius = f;
        this.mExpiration = j;
        this.mIntent = pendingIntent;
        this.mPackageName = str;
    }

    private GeoFenceParams(Parcel parcel) {
        this.mUid = parcel.readInt();
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
        this.mRadius = parcel.readFloat();
        this.mExpiration = parcel.readLong();
        this.mIntent = (PendingIntent) parcel.readParcelable(null);
        this.mPackageName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(PrintWriter printWriter, String str) {
        printWriter.println(str + this);
        printWriter.println(str + "mLatitude=" + this.mLatitude + " mLongitude=" + this.mLongitude);
        printWriter.println(str + "mRadius=" + this.mRadius + " mExpiration=" + this.mExpiration);
    }

    public int getCallerUid() {
        return this.mUid;
    }

    public long getExpiration() {
        return this.mExpiration;
    }

    public PendingIntent getIntent() {
        return this.mIntent;
    }

    public String toString() {
        return "GeoFenceParams:\n\tmUid - " + this.mUid + "\n\tmLatitide - " + this.mLatitude + "\n\tmLongitude - " + this.mLongitude + "\n\tmRadius - " + this.mRadius + "\n\tmExpiration - " + this.mExpiration + "\n\tmIntent - " + this.mIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mUid);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
        parcel.writeFloat(this.mRadius);
        parcel.writeLong(this.mExpiration);
        parcel.writeParcelable(this.mIntent, 0);
        parcel.writeString(this.mPackageName);
    }
}
