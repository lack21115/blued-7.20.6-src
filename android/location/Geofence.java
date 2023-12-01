package android.location;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/location/Geofence.class */
public final class Geofence implements Parcelable {
    public static final Parcelable.Creator<Geofence> CREATOR = new Parcelable.Creator<Geofence>() { // from class: android.location.Geofence.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Geofence createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            double readDouble = parcel.readDouble();
            double readDouble2 = parcel.readDouble();
            float readFloat = parcel.readFloat();
            Geofence.checkType(readInt);
            return Geofence.createCircle(readDouble, readDouble2, readFloat);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Geofence[] newArray(int i) {
            return new Geofence[i];
        }
    };
    public static final int TYPE_HORIZONTAL_CIRCLE = 1;
    private final double mLatitude;
    private final double mLongitude;
    private final float mRadius;
    private final int mType;

    private Geofence(double d, double d2, float f) {
        checkRadius(f);
        checkLatLong(d, d2);
        this.mType = 1;
        this.mLatitude = d;
        this.mLongitude = d2;
        this.mRadius = f;
    }

    private static void checkLatLong(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        }
        if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void checkRadius(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkType(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("invalid type: " + i);
        }
    }

    public static Geofence createCircle(double d, double d2, float f) {
        return new Geofence(d, d2, f);
    }

    private static String typeToString(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                checkType(i);
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Geofence)) {
            Geofence geofence = (Geofence) obj;
            return this.mRadius == geofence.mRadius && this.mLatitude == geofence.mLatitude && this.mLongitude == geofence.mLongitude && this.mType == geofence.mType;
        }
        return false;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.mLatitude);
        int i = (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
        long doubleToLongBits2 = Double.doubleToLongBits(this.mLongitude);
        return ((((((i + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2))) * 31) + Float.floatToIntBits(this.mRadius)) * 31) + this.mType;
    }

    public String toString() {
        return String.format("Geofence[%s %.6f, %.6f %.0fm]", typeToString(this.mType), Double.valueOf(this.mLatitude), Double.valueOf(this.mLongitude), Float.valueOf(this.mRadius));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
        parcel.writeFloat(this.mRadius);
    }
}
