package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/core/location/GpsStatusWrapper.class */
public class GpsStatusWrapper extends GnssStatusCompat {

    /* renamed from: a  reason: collision with root package name */
    private final GpsStatus f2484a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<GpsSatellite> f2485c;
    private int d;
    private GpsSatellite e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.f2484a = gpsStatus2;
        this.b = -1;
        this.f2485c = gpsStatus2.getSatellites().iterator();
        this.d = -1;
        this.e = null;
    }

    private GpsSatellite a(int i) {
        GpsSatellite gpsSatellite;
        synchronized (this.f2484a) {
            if (i < this.d) {
                this.f2485c = this.f2484a.getSatellites().iterator();
                this.d = -1;
            }
            while (true) {
                if (this.d >= i) {
                    break;
                }
                this.d++;
                if (!this.f2485c.hasNext()) {
                    this.e = null;
                    break;
                }
                this.e = this.f2485c.next();
            }
            gpsSatellite = this.e;
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    private static int b(int i) {
        if (i <= 0 || i > 32) {
            if (i < 33 || i > 64) {
                if (i <= 64 || i > 88) {
                    if (i <= 200 || i > 235) {
                        return (i < 193 || i > 200) ? 0 : 4;
                    }
                    return 5;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    private static int c(int i) {
        int b = b(i);
        return b != 2 ? b != 3 ? b != 5 ? i : i - 200 : i - 64 : i + 87;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GpsStatusWrapper) {
            return this.f2484a.equals(((GpsStatusWrapper) obj).f2484a);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i) {
        return a(i).getAzimuth();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i) {
        return a(i).getSnr();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return b(a(i).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i) {
        return a(i).getElevation();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        int i;
        synchronized (this.f2484a) {
            if (this.b == -1) {
                for (GpsSatellite gpsSatellite : this.f2484a.getSatellites()) {
                    this.b++;
                }
                this.b++;
            }
            i = this.b;
        }
        return i;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i) {
        return Build.VERSION.SDK_INT < 24 ? a(i).getPrn() : c(a(i).getPrn());
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i) {
        return a(i).hasAlmanac();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i) {
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i) {
        return a(i).hasEphemeris();
    }

    public int hashCode() {
        return this.f2484a.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i) {
        return a(i).usedInFix();
    }
}
