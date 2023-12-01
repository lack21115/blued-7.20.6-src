package c.t.m.g;

import android.content.Context;
import android.location.GnssClock;
import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.tencentmap.lbssdk.service.GTime;
import com.tencent.tencentmap.lbssdk.service.GnssRaw;
import com.tencent.tencentmap.lbssdk.service.TxRtkSvr;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/y6.class */
public class y6 implements x6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4067a;
    public BufferedWriter d;
    public BufferedWriter e;
    public BufferedWriter f;
    public BufferedWriter g;
    public File h;
    public File i;
    public File j;
    public File k;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public GnssRaw f4068c = new GnssRaw();
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public boolean p = true;
    public boolean q = true;
    public ReentrantLock r = new ReentrantLock();

    public y6(Context context) {
        this.f4067a = context;
    }

    public final int a(String str, GnssRaw gnssRaw) {
        int jni_upd_android_data;
        synchronized (this) {
            jni_upd_android_data = TxRtkSvr.jni_upd_android_data(str.getBytes().length, str.getBytes(), gnssRaw, 2);
        }
        return jni_upd_android_data;
    }

    public final String a(GnssClock gnssClock) {
        String format;
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long timeNanos = gnssClock.getTimeNanos();
            String valueOf = gnssClock.hasLeapSecond() ? Integer.valueOf(gnssClock.getLeapSecond()) : "";
            String valueOf2 = gnssClock.hasTimeUncertaintyNanos() ? Double.valueOf(gnssClock.getTimeUncertaintyNanos()) : "";
            long fullBiasNanos = gnssClock.getFullBiasNanos();
            String valueOf3 = gnssClock.hasBiasNanos() ? Double.valueOf(gnssClock.getBiasNanos()) : "";
            String valueOf4 = gnssClock.hasBiasUncertaintyNanos() ? Double.valueOf(gnssClock.getBiasUncertaintyNanos()) : "";
            String valueOf5 = gnssClock.hasDriftNanosPerSecond() ? Double.valueOf(gnssClock.getDriftNanosPerSecond()) : "";
            String valueOf6 = gnssClock.hasDriftUncertaintyNanosPerSecond() ? Double.valueOf(gnssClock.getDriftUncertaintyNanosPerSecond()) : "";
            format = String.format("Raw,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Long.valueOf(elapsedRealtime), Long.valueOf(timeNanos), valueOf, valueOf2, Long.valueOf(fullBiasNanos), valueOf3, valueOf4, valueOf5, valueOf6, gnssClock.getHardwareClockDiscontinuityCount() + ",");
        }
        return format;
    }

    public void a() {
        e();
        d();
        c();
        b();
    }

    @Override // c.t.m.g.x6
    public void a(int i) {
        b("Gnss Navigation Message Status Changed");
    }

    public void a(long j) {
    }

    public void a(long j, String str) {
        BufferedWriter bufferedWriter = this.g;
        if (bufferedWriter == null) {
            return;
        }
        try {
            bufferedWriter.write(str);
            this.g.newLine();
            this.g.flush();
        } catch (IOException e) {
            a("Problem writing to file.", e);
        }
    }

    public final void a(GnssClock gnssClock, GnssMeasurement gnssMeasurement) {
        synchronized (this) {
            String a2 = a(gnssClock);
            String b = b(gnssClock, gnssMeasurement);
            String l = Long.toString(System.currentTimeMillis());
            double jni_getCurrSow = GTime.jni_getCurrSow();
            this.b = a2 + b + "," + jni_getCurrSow + "," + l;
        }
    }

    public final void a(GnssClock gnssClock, GnssMeasurement gnssMeasurement, GnssRaw gnssRaw) {
        synchronized (this) {
            a(gnssClock, gnssRaw);
            b(gnssClock, gnssMeasurement, gnssRaw);
        }
    }

    public final void a(GnssClock gnssClock, GnssRaw gnssRaw) {
        int i = 0;
        gnssRaw.mEndFlag = 0;
        gnssRaw.elapsedRealtime = SystemClock.elapsedRealtime();
        gnssRaw.mTimeNanos = gnssClock.getTimeNanos();
        if (gnssClock.hasLeapSecond()) {
            i = gnssClock.getLeapSecond();
        }
        gnssRaw.mLeapSecond = i;
        gnssRaw.mTimeUncertaintyNanos = gnssClock.hasTimeUncertaintyNanos() ? gnssClock.getTimeUncertaintyNanos() : 0.0d;
        gnssRaw.mFullBiasNanos = gnssClock.getFullBiasNanos();
        gnssRaw.mBiasNanos = gnssClock.hasBiasNanos() ? gnssClock.getBiasNanos() : 0.0d;
        gnssRaw.mBiasUncertaintyNanos = gnssClock.hasBiasUncertaintyNanos() ? gnssClock.getBiasUncertaintyNanos() : 0.0d;
        gnssRaw.mDriftNanosPerSecond = gnssClock.hasDriftNanosPerSecond() ? gnssClock.getDriftNanosPerSecond() : 0.0d;
        double d = 0.0d;
        if (gnssClock.hasDriftUncertaintyNanosPerSecond()) {
            d = gnssClock.getDriftUncertaintyNanosPerSecond();
        }
        gnssRaw.mDriftUncertaintyNanosPerSecond = d;
        gnssRaw.mHardwareClockDiscontinuityCount = gnssClock.getHardwareClockDiscontinuityCount();
    }

    @Override // c.t.m.g.x6
    public void a(GnssMeasurementsEvent gnssMeasurementsEvent) {
        gnssMeasurementsEvent.getMeasurements().size();
        GnssClock clock = gnssMeasurementsEvent.getClock();
        if (this.d != null) {
            for (GnssMeasurement gnssMeasurement : gnssMeasurementsEvent.getMeasurements()) {
                a(clock, gnssMeasurement);
                try {
                    if (e(clock, gnssMeasurement) == 0) {
                        a("Problem writing to file.");
                    }
                } catch (IOException e) {
                    a("Problem writing to file.", e);
                }
            }
        }
        int i = 0;
        int size = gnssMeasurementsEvent.getMeasurements().size();
        u6.a("txgpos", "get gnss satellites: " + size);
        this.r.lock();
        try {
            this.b = "";
            for (GnssMeasurement gnssMeasurement2 : gnssMeasurementsEvent.getMeasurements()) {
                if (this.p) {
                    a(clock, gnssMeasurement2);
                }
                a(clock, gnssMeasurement2, this.f4068c);
                i++;
                if (i == size) {
                    if (this.p) {
                        this.b += ",TXEPOCHEND\n";
                    }
                    this.f4068c.mEndFlag = 1;
                } else if (this.p) {
                    this.b += "\n";
                }
                a(this.b, this.f4068c);
            }
        } finally {
            this.r.unlock();
        }
    }

    @Override // c.t.m.g.x6
    public void a(GnssNavigationMessage gnssNavigationMessage) {
    }

    @Override // c.t.m.g.x6
    public void a(GnssStatus gnssStatus) {
    }

    public void a(Location location) {
        if (location.getProvider().equals("gps")) {
            String format = this.p ? String.format(Locale.US, "Fix,%s,%f,%f,%f,%f,%f,%f,%d,%d%n", location.getProvider(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getSpeed()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(location.getTime())) : "";
            this.f4068c.mLatitude = location.getLatitude();
            this.f4068c.mLongitude = location.getLongitude();
            this.f4068c.mAltitude = location.getAltitude();
            this.f4068c.mSpeed = location.getSpeed();
            this.f4068c.mHorizontalAccuracyMeters = location.getAccuracy();
            this.f4068c.mBearing = location.getBearing();
            this.f4068c.mTime = location.getTime();
            this.f4068c.mProvider = 1;
            BufferedWriter bufferedWriter = this.e;
            if (bufferedWriter != null && this.m != 0) {
                try {
                    bufferedWriter.write(format);
                    this.e.newLine();
                    this.e.flush();
                } catch (IOException e) {
                    a("Problem writing to file.", e);
                }
            }
            this.r.lock();
            try {
                TxRtkSvr.jni_upd_android_data(format.getBytes().length, format.getBytes(), this.f4068c, 1);
            } finally {
            }
        }
        if (location.getProvider().equals("network")) {
            String format2 = this.p ? String.format(Locale.US, "NLP,%s,%f,%f,%f,%f,%f,%f,%d,%d%n", location.getProvider(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(location.getSpeed()), Float.valueOf(location.getAccuracy()), Float.valueOf(location.getBearing()), Long.valueOf(System.currentTimeMillis()), Long.valueOf(location.getTime())) : "";
            this.f4068c.mLatitude = location.getLatitude();
            this.f4068c.mLongitude = location.getLongitude();
            this.f4068c.mAltitude = location.getAltitude();
            this.f4068c.mSpeed = location.getSpeed();
            this.f4068c.mHorizontalAccuracyMeters = location.getAccuracy();
            this.f4068c.mBearing = location.getBearing();
            this.f4068c.mTime = location.getTime();
            this.f4068c.mProvider = 0;
            BufferedWriter bufferedWriter2 = this.f;
            if (bufferedWriter2 != null && this.n != 0) {
                try {
                    bufferedWriter2.write(format2);
                    this.f.newLine();
                    this.f.flush();
                } catch (IOException e2) {
                    a("Problem writing to file.", e2);
                }
            }
            this.r.lock();
            try {
                TxRtkSvr.jni_upd_android_data(format2.getBytes().length, format2.getBytes(), this.f4068c, 0);
            } finally {
            }
        }
    }

    public final void a(String str) {
        if (u6.f4014a) {
            u6.a("GnssLogger", str);
        }
    }

    public void a(String str, int i, Bundle bundle) {
        b(str + "Not Implemented");
    }

    public final void a(String str, Exception exc) {
        if (u6.f4014a) {
            u6.a("GnssLogger", str);
        }
    }

    public final String b(GnssClock gnssClock, GnssMeasurement gnssMeasurement) {
        String str;
        synchronized (this) {
            str = c(gnssClock, gnssMeasurement) + d(gnssClock, gnssMeasurement);
        }
        return str;
    }

    public final void b() {
        BufferedWriter bufferedWriter;
        if (this.j == null || this.n == 0 || (bufferedWriter = this.f) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            this.f.close();
            this.f = null;
        } catch (IOException e) {
            a("unable to close all file streams.", e);
        }
    }

    @Override // c.t.m.g.x6
    public void b(int i) {
    }

    public final void b(GnssClock gnssClock, GnssMeasurement gnssMeasurement, GnssRaw gnssRaw) {
        gnssRaw.mSvid = gnssMeasurement.getSvid();
        gnssRaw.mTimeOffsetNanos = gnssMeasurement.getTimeOffsetNanos();
        gnssRaw.mState = gnssMeasurement.getState();
        gnssRaw.mReceivedSvTimeNanos = gnssMeasurement.getReceivedSvTimeNanos();
        gnssRaw.mReceivedSvTimeUncertaintyNanos = gnssMeasurement.getReceivedSvTimeUncertaintyNanos();
        gnssRaw.mCn0DbHz = gnssMeasurement.getCn0DbHz();
        gnssRaw.mPseudorangeRateMetersPerSecond = gnssMeasurement.getPseudorangeRateMetersPerSecond();
        gnssRaw.mPseudorangeRateUncertaintyMetersPerSecond = gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond();
        gnssRaw.mAccumulatedDeltaRangeState = gnssMeasurement.getAccumulatedDeltaRangeState();
        gnssRaw.mAccumulatedDeltaRangeMeters = gnssMeasurement.getAccumulatedDeltaRangeMeters();
        gnssRaw.mAccumulatedDeltaRangeUncertaintyMeters = gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters();
        gnssRaw.mCarrierFrequencyHz = gnssMeasurement.hasCarrierFrequencyHz() ? gnssMeasurement.getCarrierFrequencyHz() : 0.0f;
        gnssRaw.mCarrierCycles = gnssMeasurement.hasCarrierCycles() ? gnssMeasurement.getCarrierCycles() : 0L;
        gnssRaw.mCarrierPhase = gnssMeasurement.hasCarrierPhase() ? gnssMeasurement.getCarrierPhase() : 0.0d;
        gnssRaw.mCarrierPhaseUncertainty = gnssMeasurement.hasCarrierPhaseUncertainty() ? gnssMeasurement.getCarrierPhaseUncertainty() : 0.0d;
        gnssRaw.mMultipathIndicator = gnssMeasurement.getMultipathIndicator();
        gnssRaw.mSnrInDb = gnssMeasurement.hasSnrInDb() ? gnssMeasurement.getSnrInDb() : 0.0d;
        gnssRaw.mConstellationType = gnssMeasurement.getConstellationType();
        double d = 0.0d;
        if (Build.VERSION.SDK_INT >= 26) {
            d = 0.0d;
            if (gnssMeasurement.hasAutomaticGainControlLevelDb()) {
                d = gnssMeasurement.getAutomaticGainControlLevelDb();
            }
        }
        gnssRaw.mAutomaticGainControlLevelInDb = d;
    }

    public final void b(String str) {
    }

    public final String c(GnssClock gnssClock, GnssMeasurement gnssMeasurement) {
        String format;
        synchronized (this) {
            format = String.format("%s,%s,%s,%s,%s,%s,", Integer.valueOf(gnssMeasurement.getSvid()), Double.valueOf(gnssMeasurement.getTimeOffsetNanos()), Integer.valueOf(gnssMeasurement.getState()), Long.valueOf(gnssMeasurement.getReceivedSvTimeNanos()), Long.valueOf(gnssMeasurement.getReceivedSvTimeUncertaintyNanos()), Double.valueOf(gnssMeasurement.getCn0DbHz()));
        }
        return format;
    }

    public final void c() {
        BufferedWriter bufferedWriter;
        if (this.k == null || this.o == 0 || (bufferedWriter = this.g) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            this.g.close();
            this.g = null;
        } catch (IOException e) {
            a("unable to close all file streams.", e);
        }
    }

    public final String d(GnssClock gnssClock, GnssMeasurement gnssMeasurement) {
        String format;
        synchronized (this) {
            String valueOf = gnssMeasurement.hasCarrierFrequencyHz() ? String.valueOf(gnssMeasurement.getCarrierFrequencyHz()) : "";
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Double.valueOf(gnssMeasurement.getPseudorangeRateMetersPerSecond()), Double.valueOf(gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond()), Integer.valueOf(gnssMeasurement.getAccumulatedDeltaRangeState()), Double.valueOf(gnssMeasurement.getAccumulatedDeltaRangeMeters()), Double.valueOf(gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters()), valueOf, gnssMeasurement.hasCarrierCycles() ? String.valueOf(gnssMeasurement.getCarrierCycles()) : "", gnssMeasurement.hasCarrierPhase() ? String.valueOf(gnssMeasurement.getCarrierPhase()) : "", gnssMeasurement.hasCarrierPhaseUncertainty() ? String.valueOf(gnssMeasurement.getCarrierPhaseUncertainty()) : "", Integer.valueOf(gnssMeasurement.getMultipathIndicator()), gnssMeasurement.hasSnrInDb() ? String.valueOf(gnssMeasurement.getSnrInDb()) : "", Integer.valueOf(gnssMeasurement.getConstellationType()), (Build.VERSION.SDK_INT < 26 || !gnssMeasurement.hasAutomaticGainControlLevelDb()) ? "" : String.valueOf(gnssMeasurement.getAutomaticGainControlLevelDb()), valueOf, gnssClock.hasLeapSecond() ? String.valueOf(gnssClock.getLeapSecond()) : "");
        }
        return format;
    }

    public final void d() {
        BufferedWriter bufferedWriter;
        if (this.i == null || this.m == 0 || (bufferedWriter = this.e) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            this.e.close();
            this.e = null;
        } catch (IOException e) {
            a("unable to close all file streams.", e);
        }
    }

    public final int e(GnssClock gnssClock, GnssMeasurement gnssMeasurement) throws IOException {
        synchronized (this) {
            if (this.l == 0) {
                return 0;
            }
            this.d.write(this.b);
            this.d.newLine();
            this.d.flush();
            return 1;
        }
    }

    public final void e() {
        BufferedWriter bufferedWriter;
        if (this.h == null || this.l == 0 || (bufferedWriter = this.d) == null) {
            return;
        }
        try {
            bufferedWriter.flush();
            this.d.close();
            this.d = null;
        } catch (IOException e) {
            a("unable to close all file streams.", e);
        }
    }

    public final int f() {
        File file = new File(this.f4067a.getExternalFilesDir("dgnss"), String.format("%s_%s.raw", "gnss_log", new SimpleDateFormat("yyy_MM_dd_HH_mm_ss").format(new Date())));
        String absolutePath = file.getAbsolutePath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = this.d;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e) {
                    a("unable to close all file streams.", e);
                    return 0;
                }
            }
            this.h = file;
            this.d = bufferedWriter;
            return 1;
        } catch (IOException e2) {
            a("could not open file: " + absolutePath, e2);
            return 0;
        }
    }

    public final int g() {
        File file = new File(this.f4067a.getExternalFilesDir("dgnss"), String.format("%s_%s.nlp", "gnss_log", new SimpleDateFormat("yyy_MM_dd_HH_mm_ss").format(new Date())));
        String absolutePath = file.getAbsolutePath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = this.f;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e) {
                    a("unable to close all file streams.", e);
                    return 0;
                }
            }
            this.j = file;
            this.f = bufferedWriter;
            return 1;
        } catch (IOException e2) {
            a("Could not open file: " + absolutePath, e2);
            return 0;
        }
    }

    public final int h() {
        File file = new File(this.f4067a.getExternalFilesDir("dgnss"), String.format("%s_%s.nma", "gnss_log", new SimpleDateFormat("yyy_MM_dd_HH_mm_ss").format(new Date())));
        String absolutePath = file.getAbsolutePath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = this.g;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e) {
                    a("unable to close all file streams.", e);
                    return 0;
                }
            }
            this.k = file;
            this.g = bufferedWriter;
            return 1;
        } catch (IOException e2) {
            a("Could not open file: " + absolutePath, e2);
            return 0;
        }
    }

    public final int i() {
        File file = new File(this.f4067a.getExternalFilesDir("dgnss"), String.format("%s_%s.pos", "gnss_log", new SimpleDateFormat("yyy_MM_dd_HH_mm_ss").format(new Date())));
        String absolutePath = file.getAbsolutePath();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = this.e;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e) {
                    a("unable to close all file streams.", e);
                    return 0;
                }
            }
            this.i = file;
            this.e = bufferedWriter;
            return 1;
        } catch (IOException e2) {
            a("could not open file: " + absolutePath, e2);
            return 0;
        }
    }

    public void j() {
        if (this.q) {
            this.l = f();
        }
        if (this.q) {
            this.m = i();
        }
        if (this.q) {
            this.n = g();
        }
        if (this.q) {
            this.o = h();
        }
    }
}
