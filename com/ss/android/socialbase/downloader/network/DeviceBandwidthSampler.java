package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/DeviceBandwidthSampler.class */
public class DeviceBandwidthSampler {
    public static volatile boolean isWifi;
    private long mLastTimeReading;
    private static final String TAG = DeviceBandwidthSampler.class.getSimpleName();
    private static long sPreviousBytes = -1;
    private static volatile DeviceBandwidthSampler instance = null;
    private final NetTrafficManager mNetTrafficManager = NetTrafficManager.getInstance();
    private final AtomicInteger mSamplingCounter = new AtomicInteger();
    private final SamplingHandler mHandler = new SamplingHandler(DownloadWatchDog.getThreadLooper());

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/DeviceBandwidthSampler$SamplingHandler.class */
    class SamplingHandler extends Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;

        public SamplingHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            DeviceBandwidthSampler.this.addSample();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }

    private DeviceBandwidthSampler() {
    }

    public static long getAllRxBytesWifi() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static DeviceBandwidthSampler getInstance() {
        if (instance == null) {
            synchronized (DeviceBandwidthSampler.class) {
                try {
                    if (instance == null) {
                        instance = new DeviceBandwidthSampler();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static void updateWifiStatus() {
        isWifi = DownloadUtils.isWifi(DownloadComponentManager.getAppContext());
    }

    protected void addFinalSample() {
        addSample();
        sPreviousBytes = -1L;
    }

    protected void addSample() {
        try {
            updateWifiStatus();
            long allRxBytesWifi = isWifi ? getAllRxBytesWifi() : TrafficStats.getMobileRxBytes();
            long j = sPreviousBytes;
            if (sPreviousBytes >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.mNetTrafficManager.addBandwidth(allRxBytesWifi - j, uptimeMillis - this.mLastTimeReading);
                    this.mLastTimeReading = uptimeMillis;
                }
            }
            sPreviousBytes = allRxBytesWifi;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSampling() {
        return this.mSamplingCounter.get() != 0;
    }

    public void startSampling() {
        try {
            String str = TAG;
            Logger.i(str, "startSampling: mSamplingCounter = " + this.mSamplingCounter);
            if (this.mSamplingCounter.getAndIncrement() == 0) {
                this.mHandler.startSamplingThread();
                this.mLastTimeReading = SystemClock.uptimeMillis();
            }
        } catch (Throwable th) {
        }
    }

    public void stopSampling() {
        try {
            String str = TAG;
            Logger.i(str, "stopSampling: mSamplingCounter = " + this.mSamplingCounter);
            if (this.mSamplingCounter.decrementAndGet() == 0) {
                this.mHandler.stopSamplingThread();
                addFinalSample();
            }
        } catch (Throwable th) {
        }
    }
}
