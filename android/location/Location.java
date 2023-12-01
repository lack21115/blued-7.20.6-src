package android.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Printer;
import android.util.TimeUtils;
import java.util.StringTokenizer;

/* loaded from: source-9557208-dex2jar.jar:android/location/Location.class */
public class Location implements Parcelable {
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() { // from class: android.location.Location.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Location createFromParcel(Parcel parcel) {
            Location location = new Location(parcel.readString());
            location.mTime = parcel.readLong();
            location.mElapsedRealtimeNanos = parcel.readLong();
            location.mLatitude = parcel.readDouble();
            location.mLongitude = parcel.readDouble();
            location.mHasAltitude = parcel.readInt() != 0;
            location.mAltitude = parcel.readDouble();
            location.mHasSpeed = parcel.readInt() != 0;
            location.mSpeed = parcel.readFloat();
            location.mHasBearing = parcel.readInt() != 0;
            location.mBearing = parcel.readFloat();
            location.mHasAccuracy = parcel.readInt() != 0;
            location.mAccuracy = parcel.readFloat();
            location.mExtras = parcel.readBundle();
            location.mIsFromMockProvider = parcel.readInt() != 0;
            return location;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Location[] newArray(int i) {
            return new Location[i];
        }
    };
    public static final String EXTRA_COARSE_LOCATION = "coarseLocation";
    public static final String EXTRA_NO_GPS_LOCATION = "noGPSLocation";
    public static final int FORMAT_DEGREES = 0;
    public static final int FORMAT_MINUTES = 1;
    public static final int FORMAT_SECONDS = 2;
    private float mAccuracy;
    private double mAltitude;
    private float mBearing;
    private float mDistance;
    private long mElapsedRealtimeNanos;
    private Bundle mExtras;
    private boolean mHasAccuracy;
    private boolean mHasAltitude;
    private boolean mHasBearing;
    private boolean mHasSpeed;
    private float mInitialBearing;
    private boolean mIsFromMockProvider;
    private double mLat1;
    private double mLat2;
    private double mLatitude;
    private double mLon1;
    private double mLon2;
    private double mLongitude;
    private String mProvider;
    private final float[] mResults;
    private float mSpeed;
    private long mTime;

    public Location(Location location) {
        this.mTime = 0L;
        this.mElapsedRealtimeNanos = 0L;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        this.mHasAltitude = false;
        this.mAltitude = 0.0d;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasBearing = false;
        this.mBearing = 0.0f;
        this.mHasAccuracy = false;
        this.mAccuracy = 0.0f;
        this.mExtras = null;
        this.mIsFromMockProvider = false;
        this.mLat1 = 0.0d;
        this.mLon1 = 0.0d;
        this.mLat2 = 0.0d;
        this.mLon2 = 0.0d;
        this.mDistance = 0.0f;
        this.mInitialBearing = 0.0f;
        this.mResults = new float[2];
        set(location);
    }

    public Location(String str) {
        this.mTime = 0L;
        this.mElapsedRealtimeNanos = 0L;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        this.mHasAltitude = false;
        this.mAltitude = 0.0d;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasBearing = false;
        this.mBearing = 0.0f;
        this.mHasAccuracy = false;
        this.mAccuracy = 0.0f;
        this.mExtras = null;
        this.mIsFromMockProvider = false;
        this.mLat1 = 0.0d;
        this.mLon1 = 0.0d;
        this.mLat2 = 0.0d;
        this.mLon2 = 0.0d;
        this.mDistance = 0.0f;
        this.mInitialBearing = 0.0f;
        this.mResults = new float[2];
        this.mProvider = str;
    }

    private static void computeDistanceAndBearing(double d, double d2, double d3, double d4, float[] fArr) {
        double d5 = (6378137.0d - 6356752.3142d) / 6378137.0d;
        double d6 = ((6378137.0d * 6378137.0d) - (6356752.3142d * 6356752.3142d)) / (6356752.3142d * 6356752.3142d);
        double d7 = (d4 * 0.017453292519943295d) - (d2 * 0.017453292519943295d);
        double d8 = 0.0d;
        double atan = Math.atan((1.0d - d5) * Math.tan(d * 0.017453292519943295d));
        double atan2 = Math.atan((1.0d - d5) * Math.tan(d3 * 0.017453292519943295d));
        double cos = Math.cos(atan);
        double cos2 = Math.cos(atan2);
        double sin = Math.sin(atan);
        double sin2 = Math.sin(atan2);
        double d9 = cos * cos2;
        double d10 = sin * sin2;
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = 0.0d;
        double d14 = 0.0d;
        double d15 = d7;
        int i = 0;
        while (true) {
            double d16 = d15;
            if (i >= 20) {
                break;
            }
            d13 = Math.cos(d16);
            d14 = Math.sin(d16);
            double d17 = cos2 * d14;
            double d18 = (cos * sin2) - ((sin * cos2) * d13);
            double sqrt = Math.sqrt((d17 * d17) + (d18 * d18));
            double d19 = d10 + (d9 * d13);
            d11 = Math.atan2(sqrt, d19);
            double d20 = sqrt == 0.0d ? 0.0d : (d9 * d14) / sqrt;
            double d21 = 1.0d - (d20 * d20);
            double d22 = d21 == 0.0d ? 0.0d : d19 - ((2.0d * d10) / d21);
            double d23 = d21 * d6;
            d8 = 1.0d + ((d23 / 16384.0d) * (4096.0d + (((-768.0d) + ((320.0d - (175.0d * d23)) * d23)) * d23)));
            double d24 = (d23 / 1024.0d) * (256.0d + (((-128.0d) + ((74.0d - (47.0d * d23)) * d23)) * d23));
            double d25 = (d5 / 16.0d) * d21 * (4.0d + ((4.0d - (3.0d * d21)) * d5));
            double d26 = d22 * d22;
            double d27 = d24 * sqrt * (((d24 / 4.0d) * ((((-1.0d) + (2.0d * d26)) * d19) - ((((d24 / 6.0d) * d22) * ((-3.0d) + ((4.0d * sqrt) * sqrt))) * ((-3.0d) + (4.0d * d26))))) + d22);
            double d28 = d7 + ((1.0d - d25) * d5 * d20 * ((d25 * sqrt * ((d25 * d19 * ((-1.0d) + (2.0d * d22 * d22))) + d22)) + d11));
            if (Math.abs((d28 - d16) / d28) < 1.0E-12d) {
                d12 = d27;
                break;
            }
            i++;
            d12 = d27;
            d15 = d28;
        }
        fArr[0] = (float) (6356752.3142d * d8 * (d11 - d12));
        if (fArr.length > 1) {
            fArr[1] = (float) (((float) Math.atan2(cos2 * d14, (cos * sin2) - ((sin * cos2) * d13))) * 57.29577951308232d);
            if (fArr.length > 2) {
                fArr[2] = (float) (((float) Math.atan2(cos * d14, ((-sin) * cos2) + (cos * sin2 * d13))) * 57.29577951308232d);
            }
        }
    }

    public static double convert(String str) {
        double parseDouble;
        if (str == null) {
            throw new NullPointerException("coordinate");
        }
        boolean z = false;
        String str2 = str;
        if (str.charAt(0) == '-') {
            str2 = str.substring(1);
            z = true;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2, ":");
        int countTokens = stringTokenizer.countTokens();
        if (countTokens < 1) {
            throw new IllegalArgumentException("coordinate=" + str2);
        }
        try {
            String nextToken = stringTokenizer.nextToken();
            if (countTokens == 1) {
                double parseDouble2 = Double.parseDouble(nextToken);
                return z ? -parseDouble2 : parseDouble2;
            }
            String nextToken2 = stringTokenizer.nextToken();
            int parseInt = Integer.parseInt(nextToken);
            double d = 0.0d;
            if (stringTokenizer.hasMoreTokens()) {
                parseDouble = Integer.parseInt(nextToken2);
                d = Double.parseDouble(stringTokenizer.nextToken());
            } else {
                parseDouble = Double.parseDouble(nextToken2);
            }
            boolean z2 = z && parseInt == 180 && parseDouble == 0.0d && d == 0.0d;
            if (parseInt < 0.0d || (parseInt > 179 && !z2)) {
                throw new IllegalArgumentException("coordinate=" + str2);
            }
            if (parseDouble < 0.0d || parseDouble > 59.0d) {
                throw new IllegalArgumentException("coordinate=" + str2);
            }
            if (d < 0.0d || d > 59.0d) {
                throw new IllegalArgumentException("coordinate=" + str2);
            }
            double d2 = (((parseInt * 3600.0d) + (60.0d * parseDouble)) + d) / 3600.0d;
            return z ? -d2 : d2;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("coordinate=" + str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
        if (r8 == 2) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String convert(double r6, int r8) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.location.Location.convert(double, int):java.lang.String");
    }

    public static void distanceBetween(double d, double d2, double d3, double d4, float[] fArr) {
        if (fArr == null || fArr.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        }
        computeDistanceAndBearing(d, d2, d3, d4, fArr);
    }

    public float bearingTo(Location location) {
        float f;
        synchronized (this.mResults) {
            if (this.mLatitude != this.mLat1 || this.mLongitude != this.mLon1 || location.mLatitude != this.mLat2 || location.mLongitude != this.mLon2) {
                computeDistanceAndBearing(this.mLatitude, this.mLongitude, location.mLatitude, location.mLongitude, this.mResults);
                this.mLat1 = this.mLatitude;
                this.mLon1 = this.mLongitude;
                this.mLat2 = location.mLatitude;
                this.mLon2 = location.mLongitude;
                this.mDistance = this.mResults[0];
                this.mInitialBearing = this.mResults[1];
            }
            f = this.mInitialBearing;
        }
        return f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float distanceTo(Location location) {
        float f;
        synchronized (this.mResults) {
            if (this.mLatitude != this.mLat1 || this.mLongitude != this.mLon1 || location.mLatitude != this.mLat2 || location.mLongitude != this.mLon2) {
                computeDistanceAndBearing(this.mLatitude, this.mLongitude, location.mLatitude, location.mLongitude, this.mResults);
                this.mLat1 = this.mLatitude;
                this.mLon1 = this.mLongitude;
                this.mLat2 = location.mLatitude;
                this.mLon2 = location.mLongitude;
                this.mDistance = this.mResults[0];
                this.mInitialBearing = this.mResults[1];
            }
            f = this.mDistance;
        }
        return f;
    }

    public void dump(Printer printer, String str) {
        printer.println(str + toString());
    }

    public float getAccuracy() {
        return this.mAccuracy;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.mBearing;
    }

    public long getElapsedRealtimeNanos() {
        return this.mElapsedRealtimeNanos;
    }

    public Location getExtraLocation(String str) {
        if (this.mExtras != null) {
            Parcelable parcelable = this.mExtras.getParcelable(str);
            if (parcelable instanceof Location) {
                return (Location) parcelable;
            }
            return null;
        }
        return null;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getProvider() {
        return this.mProvider;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public long getTime() {
        return this.mTime;
    }

    public boolean hasAccuracy() {
        return this.mHasAccuracy;
    }

    public boolean hasAltitude() {
        return this.mHasAltitude;
    }

    public boolean hasBearing() {
        return this.mHasBearing;
    }

    public boolean hasSpeed() {
        return this.mHasSpeed;
    }

    public boolean isComplete() {
        return (this.mProvider == null || !this.mHasAccuracy || this.mTime == 0 || this.mElapsedRealtimeNanos == 0) ? false : true;
    }

    public boolean isFromMockProvider() {
        return this.mIsFromMockProvider;
    }

    public void makeComplete() {
        if (this.mProvider == null) {
            this.mProvider = "?";
        }
        if (!this.mHasAccuracy) {
            this.mHasAccuracy = true;
            this.mAccuracy = 100.0f;
        }
        if (this.mTime == 0) {
            this.mTime = System.currentTimeMillis();
        }
        if (this.mElapsedRealtimeNanos == 0) {
            this.mElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        }
    }

    public void removeAccuracy() {
        this.mAccuracy = 0.0f;
        this.mHasAccuracy = false;
    }

    public void removeAltitude() {
        this.mAltitude = 0.0d;
        this.mHasAltitude = false;
    }

    public void removeBearing() {
        this.mBearing = 0.0f;
        this.mHasBearing = false;
    }

    public void removeSpeed() {
        this.mSpeed = 0.0f;
        this.mHasSpeed = false;
    }

    public void reset() {
        this.mProvider = null;
        this.mTime = 0L;
        this.mElapsedRealtimeNanos = 0L;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        this.mHasAltitude = false;
        this.mAltitude = 0.0d;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasBearing = false;
        this.mBearing = 0.0f;
        this.mHasAccuracy = false;
        this.mAccuracy = 0.0f;
        this.mExtras = null;
        this.mIsFromMockProvider = false;
    }

    public void set(Location location) {
        this.mProvider = location.mProvider;
        this.mTime = location.mTime;
        this.mElapsedRealtimeNanos = location.mElapsedRealtimeNanos;
        this.mLatitude = location.mLatitude;
        this.mLongitude = location.mLongitude;
        this.mHasAltitude = location.mHasAltitude;
        this.mAltitude = location.mAltitude;
        this.mHasSpeed = location.mHasSpeed;
        this.mSpeed = location.mSpeed;
        this.mHasBearing = location.mHasBearing;
        this.mBearing = location.mBearing;
        this.mHasAccuracy = location.mHasAccuracy;
        this.mAccuracy = location.mAccuracy;
        this.mExtras = location.mExtras == null ? null : new Bundle(location.mExtras);
        this.mIsFromMockProvider = location.mIsFromMockProvider;
    }

    public void setAccuracy(float f) {
        this.mAccuracy = f;
        this.mHasAccuracy = true;
    }

    public void setAltitude(double d) {
        this.mAltitude = d;
        this.mHasAltitude = true;
    }

    public void setBearing(float f) {
        float f2;
        while (true) {
            f2 = f;
            if (f >= 0.0f) {
                break;
            }
            f += 360.0f;
        }
        while (f2 >= 360.0f) {
            f2 -= 360.0f;
        }
        this.mBearing = f2;
        this.mHasBearing = true;
    }

    public void setElapsedRealtimeNanos(long j) {
        this.mElapsedRealtimeNanos = j;
    }

    public void setExtraLocation(String str, Location location) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putParcelable(str, location);
    }

    public void setExtras(Bundle bundle) {
        this.mExtras = bundle == null ? null : new Bundle(bundle);
    }

    public void setIsFromMockProvider(boolean z) {
        this.mIsFromMockProvider = z;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public void setProvider(String str) {
        this.mProvider = str;
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
        this.mHasSpeed = true;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Location[");
        sb.append(this.mProvider);
        sb.append(String.format(" %.6f,%.6f", Double.valueOf(this.mLatitude), Double.valueOf(this.mLongitude)));
        if (this.mHasAccuracy) {
            sb.append(String.format(" acc=%.0f", Float.valueOf(this.mAccuracy)));
        } else {
            sb.append(" acc=???");
        }
        if (this.mTime == 0) {
            sb.append(" t=?!?");
        }
        if (this.mElapsedRealtimeNanos == 0) {
            sb.append(" et=?!?");
        } else {
            sb.append(" et=");
            TimeUtils.formatDuration(this.mElapsedRealtimeNanos / 1000000, sb);
        }
        if (this.mHasAltitude) {
            sb.append(" alt=").append(this.mAltitude);
        }
        if (this.mHasSpeed) {
            sb.append(" vel=").append(this.mSpeed);
        }
        if (this.mHasBearing) {
            sb.append(" bear=").append(this.mBearing);
        }
        if (this.mIsFromMockProvider) {
            sb.append(" mock");
        }
        if (this.mExtras != null) {
            sb.append(" {").append(this.mExtras).append('}');
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mProvider);
        parcel.writeLong(this.mTime);
        parcel.writeLong(this.mElapsedRealtimeNanos);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
        parcel.writeInt(this.mHasAltitude ? 1 : 0);
        parcel.writeDouble(this.mAltitude);
        parcel.writeInt(this.mHasSpeed ? 1 : 0);
        parcel.writeFloat(this.mSpeed);
        parcel.writeInt(this.mHasBearing ? 1 : 0);
        parcel.writeFloat(this.mBearing);
        parcel.writeInt(this.mHasAccuracy ? 1 : 0);
        parcel.writeFloat(this.mAccuracy);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mIsFromMockProvider ? 1 : 0);
    }
}
