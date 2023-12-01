package android.location;

/* loaded from: source-9557208-dex2jar.jar:android/location/GpsSatellite.class */
public final class GpsSatellite {
    float mAzimuth;
    float mElevation;
    boolean mHasAlmanac;
    boolean mHasEphemeris;
    int mPrn;
    float mSnr;
    boolean mUsedInFix;
    boolean mValid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GpsSatellite(int i) {
        this.mPrn = i;
    }

    public float getAzimuth() {
        return this.mAzimuth;
    }

    public float getElevation() {
        return this.mElevation;
    }

    public int getPrn() {
        return this.mPrn;
    }

    public float getSnr() {
        return this.mSnr;
    }

    public boolean hasAlmanac() {
        return this.mHasAlmanac;
    }

    public boolean hasEphemeris() {
        return this.mHasEphemeris;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatus(GpsSatellite gpsSatellite) {
        this.mValid = gpsSatellite.mValid;
        this.mHasEphemeris = gpsSatellite.mHasEphemeris;
        this.mHasAlmanac = gpsSatellite.mHasAlmanac;
        this.mUsedInFix = gpsSatellite.mUsedInFix;
        this.mSnr = gpsSatellite.mSnr;
        this.mElevation = gpsSatellite.mElevation;
        this.mAzimuth = gpsSatellite.mAzimuth;
    }

    public boolean usedInFix() {
        return this.mUsedInFix;
    }
}
