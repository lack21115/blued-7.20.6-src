package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/NetTrafficManager.class */
public class NetTrafficManager {
    private static final long BANDWIDTH_LOWER_BOUND = 3;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    private static final int DEFAULT_GOOD_BANDWIDTH = 2000;
    private static final long DEFAULT_HYSTERESIS_PERCENT = 20;
    private static final int DEFAULT_MODERATE_BANDWIDTH = 550;
    private static final int DEFAULT_POOR_BANDWIDTH = 150;
    private static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private static final double HYSTERESIS_BOTTOM_MULTIPLIER = 0.8d;
    private static final double HYSTERESIS_TOP_MULTIPLIER = 1.25d;
    private static final String TAG = NetTrafficManager.class.getSimpleName();
    private final AtomicReference<NetworkQuality> currentNetworkQuality;
    private volatile boolean initiateStateChange;
    private final ArrayList<NetworkStateChangeListener> listenerList;
    private final ExponentialGeometricAverage mDownloadBandwidth;
    private AtomicReference<NetworkQuality> nextNetworkQuality;
    private int sampleCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.downloader.network.NetTrafficManager$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/NetTrafficManager$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[NetworkQuality.values().length];
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality = iArr;
            try {
                iArr[NetworkQuality.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/NetTrafficManager$ConnectionClassManagerHolder.class */
    static class ConnectionClassManagerHolder {
        public static final NetTrafficManager instance = new NetTrafficManager(null);

        private ConnectionClassManagerHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/NetTrafficManager$NetworkStateChangeListener.class */
    public interface NetworkStateChangeListener {
        void onBandwidthStateChange(NetworkQuality networkQuality);
    }

    private NetTrafficManager() {
        this.mDownloadBandwidth = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.initiateStateChange = false;
        this.currentNetworkQuality = new AtomicReference<>(NetworkQuality.UNKNOWN);
        this.listenerList = new ArrayList<>();
    }

    /* synthetic */ NetTrafficManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static NetTrafficManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    private NetworkQuality mapBandwidthQuality(double d) {
        return d < 0.0d ? NetworkQuality.UNKNOWN : d < 150.0d ? NetworkQuality.POOR : d < 550.0d ? NetworkQuality.MODERATE : d < 2000.0d ? NetworkQuality.GOOD : NetworkQuality.EXCELLENT;
    }

    private void notifyListeners() {
        try {
            int size = this.listenerList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                this.listenerList.get(i2).onBandwidthStateChange(this.currentNetworkQuality.get());
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean significantlyOutsideCurrentBand() {
        if (this.mDownloadBandwidth == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[this.currentNetworkQuality.get().ordinal()];
            double d = 2000.0d;
            double d2 = 550.0d;
            if (i == 1) {
                d2 = 0.0d;
                d = 150.0d;
            } else if (i == 2) {
                d = 550.0d;
                d2 = 150.0d;
            } else if (i != 3) {
                if (i != 4) {
                    return true;
                }
                d = 3.4028234663852886E38d;
                d2 = 2000.0d;
            }
            double average = this.mDownloadBandwidth.getAverage();
            return average > d ? average > d * HYSTERESIS_TOP_MULTIPLIER : average < d2 * HYSTERESIS_BOTTOM_MULTIPLIER;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void addBandwidth(long j, long j2) {
        NetworkQuality currentNetworkQuality;
        synchronized (this) {
            double d = ((j * 1.0d) / j2) * 8.0d;
            if (j2 == 0 || d < 3.0d) {
                return;
            }
            try {
                this.mDownloadBandwidth.addMeasurement(d);
                currentNetworkQuality = getCurrentNetworkQuality();
            } catch (Throwable th) {
            }
            if (!this.initiateStateChange) {
                if (this.currentNetworkQuality.get() != currentNetworkQuality) {
                    this.initiateStateChange = true;
                    this.nextNetworkQuality = new AtomicReference<>(currentNetworkQuality);
                }
                return;
            }
            this.sampleCount++;
            if (currentNetworkQuality != this.nextNetworkQuality.get()) {
                this.initiateStateChange = false;
                this.sampleCount = 1;
            }
            if (this.sampleCount >= DEFAULT_SAMPLES_TO_QUALITY_CHANGE && significantlyOutsideCurrentBand()) {
                this.initiateStateChange = false;
                this.sampleCount = 1;
                this.currentNetworkQuality.set(this.nextNetworkQuality.get());
                notifyListeners();
            }
        }
    }

    public NetworkQuality getCurrentNetworkQuality() {
        synchronized (this) {
            if (this.mDownloadBandwidth == null) {
                return NetworkQuality.UNKNOWN;
            }
            return mapBandwidthQuality(this.mDownloadBandwidth.getAverage());
        }
    }

    public double getDownloadKBitsPerSecond() {
        double average;
        synchronized (this) {
            average = this.mDownloadBandwidth == null ? -1.0d : this.mDownloadBandwidth.getAverage();
        }
        return average;
    }

    public NetworkQuality register(NetworkStateChangeListener networkStateChangeListener) {
        if (networkStateChangeListener != null) {
            this.listenerList.add(networkStateChangeListener);
        }
        return this.currentNetworkQuality.get();
    }

    public void remove(NetworkStateChangeListener networkStateChangeListener) {
        if (networkStateChangeListener != null) {
            this.listenerList.remove(networkStateChangeListener);
        }
    }

    public void reset() {
        try {
            if (this.mDownloadBandwidth != null) {
                this.mDownloadBandwidth.reset();
            }
            this.currentNetworkQuality.set(NetworkQuality.UNKNOWN);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
