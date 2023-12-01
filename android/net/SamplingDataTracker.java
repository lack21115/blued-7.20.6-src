package android.net;

import android.os.SystemClock;
import android.util.Slog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/SamplingDataTracker.class */
public class SamplingDataTracker {
    private static final boolean DBG = false;
    private static final String TAG = "SamplingDataTracker";
    private SamplingSnapshot mBeginningSample;
    private SamplingSnapshot mEndingSample;
    private SamplingSnapshot mLastSample;
    public final Object mSamplingDataLock = new Object();
    private final int MINIMUM_SAMPLING_INTERVAL = 15000;
    private final int MINIMUM_SAMPLED_PACKETS = 30;

    /* loaded from: source-9557208-dex2jar.jar:android/net/SamplingDataTracker$SamplingSnapshot.class */
    public static class SamplingSnapshot {
        public long mRxByteCount;
        public long mRxPacketCount;
        public long mRxPacketErrorCount;
        public long mTimestamp;
        public long mTxByteCount;
        public long mTxPacketCount;
        public long mTxPacketErrorCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedReader] */
    public static void getSamplingSnapshots(Map<String, SamplingSnapshot> map) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                BufferedReader bufferedReader4 = new BufferedReader(new FileReader("/proc/net/dev"));
                try {
                    bufferedReader4.readLine();
                    bufferedReader4.readLine();
                    while (true) {
                        bufferedReader3 = bufferedReader4.readLine();
                        if (bufferedReader3 == null) {
                            break;
                        }
                        String[] split = bufferedReader3.trim().split("[ ]+");
                        if (split.length >= 17) {
                            String str = split[0].split(":")[0];
                            if (map.containsKey(str)) {
                                try {
                                    SamplingSnapshot samplingSnapshot = new SamplingSnapshot();
                                    samplingSnapshot.mTxByteCount = Long.parseLong(split[1]);
                                    samplingSnapshot.mTxPacketCount = Long.parseLong(split[2]);
                                    samplingSnapshot.mTxPacketErrorCount = Long.parseLong(split[3]);
                                    samplingSnapshot.mRxByteCount = Long.parseLong(split[9]);
                                    samplingSnapshot.mRxPacketCount = Long.parseLong(split[10]);
                                    samplingSnapshot.mRxPacketErrorCount = Long.parseLong(split[11]);
                                    samplingSnapshot.mTimestamp = SystemClock.elapsedRealtime();
                                    map.put(str, samplingSnapshot);
                                } catch (NumberFormatException e) {
                                }
                            }
                        }
                    }
                    if (bufferedReader4 != null) {
                        try {
                            bufferedReader4.close();
                        } catch (IOException e2) {
                            Slog.e(TAG, "could not close /proc/net/dev");
                        }
                    }
                } catch (FileNotFoundException e3) {
                    bufferedReader2 = bufferedReader4;
                    Slog.e(TAG, "could not find /proc/net/dev");
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            Slog.e(TAG, "could not close /proc/net/dev");
                        }
                    }
                } catch (IOException e5) {
                    bufferedReader = bufferedReader4;
                    Slog.e(TAG, "could not read /proc/net/dev");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            Slog.e(TAG, "could not close /proc/net/dev");
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader3 = bufferedReader4;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e7) {
                            Slog.e(TAG, "could not close /proc/net/dev");
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                bufferedReader2 = null;
            } catch (IOException e9) {
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int getSampleDuration() {
        synchronized (this.mSamplingDataLock) {
            if (this.mBeginningSample == null || this.mEndingSample == null) {
                return Integer.MAX_VALUE;
            }
            return (int) (this.mEndingSample.mTimestamp - this.mBeginningSample.mTimestamp);
        }
    }

    public long getSampleTimestamp() {
        synchronized (this.mSamplingDataLock) {
            if (this.mEndingSample != null) {
                return this.mEndingSample.mTimestamp;
            }
            return Long.MAX_VALUE;
        }
    }

    public long getSampledPacketCount() {
        return getSampledPacketCount(this.mBeginningSample, this.mEndingSample);
    }

    public long getSampledPacketCount(SamplingSnapshot samplingSnapshot, SamplingSnapshot samplingSnapshot2) {
        if (samplingSnapshot == null || samplingSnapshot2 == null) {
            return Long.MAX_VALUE;
        }
        return (samplingSnapshot2.mRxPacketCount - samplingSnapshot.mRxPacketCount) + (samplingSnapshot2.mTxPacketCount - samplingSnapshot.mTxPacketCount);
    }

    public long getSampledPacketErrorCount() {
        if (this.mBeginningSample == null || this.mEndingSample == null) {
            return Long.MAX_VALUE;
        }
        return getSampledRxPacketErrorCount() + getSampledTxPacketErrorCount();
    }

    public long getSampledRxByteCount() {
        synchronized (this.mSamplingDataLock) {
            if (this.mBeginningSample == null || this.mEndingSample == null) {
                return Long.MAX_VALUE;
            }
            return this.mEndingSample.mRxByteCount - this.mBeginningSample.mRxByteCount;
        }
    }

    public long getSampledRxPacketCount() {
        synchronized (this.mSamplingDataLock) {
            if (this.mBeginningSample == null || this.mEndingSample == null) {
                return Long.MAX_VALUE;
            }
            return this.mEndingSample.mRxPacketCount - this.mBeginningSample.mRxPacketCount;
        }
    }

    public long getSampledRxPacketErrorCount() {
        synchronized (this.mSamplingDataLock) {
            if (this.mBeginningSample == null || this.mEndingSample == null) {
                return Long.MAX_VALUE;
            }
            return this.mEndingSample.mRxPacketErrorCount - this.mBeginningSample.mRxPacketErrorCount;
        }
    }

    public long getSampledTxByteCount() {
        synchronized (this.mSamplingDataLock) {
            if (this.mBeginningSample == null || this.mEndingSample == null) {
                return Long.MAX_VALUE;
            }
            return this.mEndingSample.mTxByteCount - this.mBeginningSample.mTxByteCount;
        }
    }

    public long getSampledTxPacketCount() {
        synchronized (this.mSamplingDataLock) {
            if (this.mBeginningSample == null || this.mEndingSample == null) {
                return Long.MAX_VALUE;
            }
            return this.mEndingSample.mTxPacketCount - this.mBeginningSample.mTxPacketCount;
        }
    }

    public long getSampledTxPacketErrorCount() {
        synchronized (this.mSamplingDataLock) {
            if (this.mBeginningSample == null || this.mEndingSample == null) {
                return Long.MAX_VALUE;
            }
            return this.mEndingSample.mTxPacketErrorCount - this.mBeginningSample.mTxPacketErrorCount;
        }
    }

    public void resetSamplingData() {
        synchronized (this.mSamplingDataLock) {
            this.mLastSample = null;
        }
    }

    public void setCommonLinkQualityInfoFields(LinkQualityInfo linkQualityInfo) {
        synchronized (this.mSamplingDataLock) {
            linkQualityInfo.setLastDataSampleTime(getSampleTimestamp());
            linkQualityInfo.setDataSampleDuration(getSampleDuration());
            linkQualityInfo.setPacketCount(getSampledPacketCount());
            linkQualityInfo.setPacketErrorCount(getSampledPacketErrorCount());
        }
    }

    public void startSampling(SamplingSnapshot samplingSnapshot) {
        synchronized (this.mSamplingDataLock) {
            this.mLastSample = samplingSnapshot;
        }
    }

    public void stopSampling(SamplingSnapshot samplingSnapshot) {
        synchronized (this.mSamplingDataLock) {
            if (this.mLastSample != null && samplingSnapshot.mTimestamp - this.mLastSample.mTimestamp > 15000 && getSampledPacketCount(this.mLastSample, samplingSnapshot) > 30) {
                this.mBeginningSample = this.mLastSample;
                this.mEndingSample = samplingSnapshot;
                this.mLastSample = null;
            }
        }
    }
}
