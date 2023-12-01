package android.location;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: source-9557208-dex2jar.jar:android/location/GpsStatus.class */
public final class GpsStatus {
    public static final int GPS_EVENT_FIRST_FIX = 3;
    public static final int GPS_EVENT_SATELLITE_STATUS = 4;
    public static final int GPS_EVENT_STARTED = 1;
    public static final int GPS_EVENT_STOPPED = 2;
    private static final int NUM_SATELLITES = 255;
    private int mTimeToFirstFix;
    private GpsSatellite[] mSatellites = new GpsSatellite[255];
    private Iterable<GpsSatellite> mSatelliteList = new Iterable<GpsSatellite>() { // from class: android.location.GpsStatus.1
        @Override // java.lang.Iterable
        public Iterator<GpsSatellite> iterator() {
            return new SatelliteIterator(GpsStatus.this.mSatellites);
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/location/GpsStatus$Listener.class */
    public interface Listener {
        void onGpsStatusChanged(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/location/GpsStatus$NmeaListener.class */
    public interface NmeaListener {
        void onNmeaReceived(long j, String str);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/location/GpsStatus$SatelliteIterator.class */
    private final class SatelliteIterator implements Iterator<GpsSatellite> {
        int mIndex = 0;
        private GpsSatellite[] mSatellites;

        SatelliteIterator(GpsSatellite[] gpsSatelliteArr) {
            this.mSatellites = gpsSatelliteArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (true) {
                int i2 = i;
                if (i2 >= this.mSatellites.length) {
                    return false;
                }
                if (this.mSatellites[i2].mValid) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public GpsSatellite next() {
            while (this.mIndex < this.mSatellites.length) {
                GpsSatellite[] gpsSatelliteArr = this.mSatellites;
                int i = this.mIndex;
                this.mIndex = i + 1;
                GpsSatellite gpsSatellite = gpsSatelliteArr[i];
                if (gpsSatellite.mValid) {
                    return gpsSatellite;
                }
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GpsStatus() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSatellites.length) {
                return;
            }
            this.mSatellites[i2] = new GpsSatellite(i2 + 1);
            i = i2 + 1;
        }
    }

    public int getMaxSatellites() {
        return 255;
    }

    public Iterable<GpsSatellite> getSatellites() {
        return this.mSatelliteList;
    }

    public int getTimeToFirstFix() {
        return this.mTimeToFirstFix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatus(int i, int[] iArr, float[] fArr, float[] fArr2, float[] fArr3, int i2, int i3, int i4) {
        synchronized (this) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.mSatellites.length) {
                    break;
                }
                this.mSatellites[i6].mValid = false;
                i5 = i6 + 1;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < i) {
                    int i9 = iArr[i8] - 1;
                    int i10 = 1 << i9;
                    if (i9 >= 0) {
                        if (i9 < this.mSatellites.length) {
                            GpsSatellite gpsSatellite = this.mSatellites[i9];
                            gpsSatellite.mValid = true;
                            gpsSatellite.mSnr = fArr[i8];
                            gpsSatellite.mElevation = fArr2[i8];
                            gpsSatellite.mAzimuth = fArr3[i8];
                            gpsSatellite.mHasEphemeris = (i2 & i10) != 0;
                            gpsSatellite.mHasAlmanac = (i3 & i10) != 0;
                            gpsSatellite.mUsedInFix = (i4 & i10) != 0;
                        }
                    }
                    i7 = i8 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStatus(GpsStatus gpsStatus) {
        this.mTimeToFirstFix = gpsStatus.getTimeToFirstFix();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mSatellites.length) {
                return;
            }
            this.mSatellites[i2].setStatus(gpsStatus.mSatellites[i2]);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTimeToFirstFix(int i) {
        this.mTimeToFirstFix = i;
    }
}
