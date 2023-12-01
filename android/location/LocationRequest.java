package android.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import android.util.TimeUtils;

/* loaded from: source-9557208-dex2jar.jar:android/location/LocationRequest.class */
public final class LocationRequest implements Parcelable {
    public static final int ACCURACY_BLOCK = 102;
    public static final int ACCURACY_CITY = 104;
    public static final int ACCURACY_FINE = 100;
    public static final Parcelable.Creator<LocationRequest> CREATOR = new Parcelable.Creator<LocationRequest>() { // from class: android.location.LocationRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationRequest createFromParcel(Parcel parcel) {
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.setQuality(parcel.readInt());
            locationRequest.setFastestInterval(parcel.readLong());
            locationRequest.setInterval(parcel.readLong());
            locationRequest.setExpireAt(parcel.readLong());
            locationRequest.setNumUpdates(parcel.readInt());
            locationRequest.setSmallestDisplacement(parcel.readFloat());
            locationRequest.setHideFromAppOps(parcel.readInt() != 0);
            String readString = parcel.readString();
            if (readString != null) {
                locationRequest.setProvider(readString);
            }
            WorkSource workSource = (WorkSource) parcel.readParcelable(null);
            if (workSource != null) {
                locationRequest.setWorkSource(workSource);
            }
            return locationRequest;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationRequest[] newArray(int i) {
            return new LocationRequest[i];
        }
    };
    private static final double FASTEST_INTERVAL_FACTOR = 6.0d;
    public static final int POWER_HIGH = 203;
    public static final int POWER_LOW = 201;
    public static final int POWER_NONE = 200;
    private long mExpireAt;
    private boolean mExplicitFastestInterval;
    private long mFastestInterval;
    private boolean mHideFromAppOps;
    private long mInterval;
    private int mNumUpdates;
    private String mProvider;
    private int mQuality;
    private float mSmallestDisplacement;
    private WorkSource mWorkSource;

    public LocationRequest() {
        this.mQuality = 201;
        this.mInterval = 3600000L;
        this.mFastestInterval = (long) (this.mInterval / FASTEST_INTERVAL_FACTOR);
        this.mExplicitFastestInterval = false;
        this.mExpireAt = Long.MAX_VALUE;
        this.mNumUpdates = Integer.MAX_VALUE;
        this.mSmallestDisplacement = 0.0f;
        this.mWorkSource = null;
        this.mHideFromAppOps = false;
        this.mProvider = "fused";
    }

    public LocationRequest(LocationRequest locationRequest) {
        this.mQuality = 201;
        this.mInterval = 3600000L;
        this.mFastestInterval = (long) (this.mInterval / FASTEST_INTERVAL_FACTOR);
        this.mExplicitFastestInterval = false;
        this.mExpireAt = Long.MAX_VALUE;
        this.mNumUpdates = Integer.MAX_VALUE;
        this.mSmallestDisplacement = 0.0f;
        this.mWorkSource = null;
        this.mHideFromAppOps = false;
        this.mProvider = "fused";
        this.mQuality = locationRequest.mQuality;
        this.mInterval = locationRequest.mInterval;
        this.mFastestInterval = locationRequest.mFastestInterval;
        this.mExplicitFastestInterval = locationRequest.mExplicitFastestInterval;
        this.mExpireAt = locationRequest.mExpireAt;
        this.mNumUpdates = locationRequest.mNumUpdates;
        this.mSmallestDisplacement = locationRequest.mSmallestDisplacement;
        this.mProvider = locationRequest.mProvider;
        this.mWorkSource = locationRequest.mWorkSource;
        this.mHideFromAppOps = locationRequest.mHideFromAppOps;
    }

    private static void checkDisplacement(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void checkInterval(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void checkProvider(String str) {
        if (str == null) {
            throw new IllegalArgumentException("invalid provider: " + str);
        }
    }

    private static void checkQuality(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 200:
            case 201:
            case 203:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    public static LocationRequest createFromDeprecatedCriteria(Criteria criteria, long j, float f, boolean z) {
        int i;
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        switch (criteria.getAccuracy()) {
            case 1:
                i = 100;
                break;
            case 2:
                i = 102;
                break;
            default:
                switch (criteria.getPowerRequirement()) {
                    case 3:
                        i = 203;
                        break;
                    default:
                        i = 201;
                        break;
                }
        }
        LocationRequest smallestDisplacement = new LocationRequest().setQuality(i).setInterval(j2).setFastestInterval(j2).setSmallestDisplacement(f2);
        if (z) {
            smallestDisplacement.setNumUpdates(1);
        }
        return smallestDisplacement;
    }

    public static LocationRequest createFromDeprecatedProvider(String str, long j, float f, boolean z) {
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        float f2 = f;
        if (f < 0.0f) {
            f2 = 0.0f;
        }
        LocationRequest smallestDisplacement = new LocationRequest().setProvider(str).setQuality(LocationManager.PASSIVE_PROVIDER.equals(str) ? 200 : "gps".equals(str) ? 100 : 201).setInterval(j2).setFastestInterval(j2).setSmallestDisplacement(f2);
        if (z) {
            smallestDisplacement.setNumUpdates(1);
        }
        return smallestDisplacement;
    }

    public static String qualityToString(int i) {
        switch (i) {
            case 100:
                return "ACCURACY_FINE";
            case 102:
                return "ACCURACY_BLOCK";
            case 104:
                return "ACCURACY_CITY";
            case 200:
                return "POWER_NONE";
            case 201:
                return "POWER_LOW";
            case 203:
                return "POWER_HIGH";
            default:
                return "???";
        }
    }

    public void decrementNumUpdates() {
        if (this.mNumUpdates != Integer.MAX_VALUE) {
            this.mNumUpdates--;
        }
        if (this.mNumUpdates < 0) {
            this.mNumUpdates = 0;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getExpireAt() {
        return this.mExpireAt;
    }

    public long getFastestInterval() {
        return this.mFastestInterval;
    }

    public boolean getHideFromAppOps() {
        return this.mHideFromAppOps;
    }

    public long getInterval() {
        return this.mInterval;
    }

    public int getNumUpdates() {
        return this.mNumUpdates;
    }

    public String getProvider() {
        return this.mProvider;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public float getSmallestDisplacement() {
        return this.mSmallestDisplacement;
    }

    public WorkSource getWorkSource() {
        return this.mWorkSource;
    }

    public LocationRequest setExpireAt(long j) {
        this.mExpireAt = j;
        if (this.mExpireAt < 0) {
            this.mExpireAt = 0L;
        }
        return this;
    }

    public LocationRequest setExpireIn(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.mExpireAt = Long.MAX_VALUE;
        } else {
            this.mExpireAt = j + elapsedRealtime;
        }
        if (this.mExpireAt < 0) {
            this.mExpireAt = 0L;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long j) {
        checkInterval(j);
        this.mExplicitFastestInterval = true;
        this.mFastestInterval = j;
        return this;
    }

    public void setHideFromAppOps(boolean z) {
        this.mHideFromAppOps = z;
    }

    public LocationRequest setInterval(long j) {
        checkInterval(j);
        this.mInterval = j;
        if (!this.mExplicitFastestInterval) {
            this.mFastestInterval = (long) (this.mInterval / FASTEST_INTERVAL_FACTOR);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + i);
        }
        this.mNumUpdates = i;
        return this;
    }

    public LocationRequest setProvider(String str) {
        checkProvider(str);
        this.mProvider = str;
        return this;
    }

    public LocationRequest setQuality(int i) {
        checkQuality(i);
        this.mQuality = i;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f) {
        checkDisplacement(f);
        this.mSmallestDisplacement = f;
        return this;
    }

    public void setWorkSource(WorkSource workSource) {
        this.mWorkSource = workSource;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(qualityToString(this.mQuality));
        if (this.mProvider != null) {
            sb.append(' ').append(this.mProvider);
        }
        if (this.mQuality != 200) {
            sb.append(" requested=");
            TimeUtils.formatDuration(this.mInterval, sb);
        }
        sb.append(" fastest=");
        TimeUtils.formatDuration(this.mFastestInterval, sb);
        if (this.mExpireAt != Long.MAX_VALUE) {
            long j = this.mExpireAt;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            TimeUtils.formatDuration(j - elapsedRealtime, sb);
        }
        if (this.mNumUpdates != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.mNumUpdates);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mQuality);
        parcel.writeLong(this.mFastestInterval);
        parcel.writeLong(this.mInterval);
        parcel.writeLong(this.mExpireAt);
        parcel.writeInt(this.mNumUpdates);
        parcel.writeFloat(this.mSmallestDisplacement);
        parcel.writeInt(this.mHideFromAppOps ? 1 : 0);
        parcel.writeString(this.mProvider);
        parcel.writeParcelable(this.mWorkSource, 0);
    }
}
