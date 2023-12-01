package android.net.wifi;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.util.AsyncChannel;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner.class */
public class WifiScanner {
    private static final int BASE = 159744;
    public static final int CMD_AP_FOUND = 159753;
    public static final int CMD_AP_LOST = 159754;
    public static final int CMD_CONFIGURE_WIFI_CHANGE = 159757;
    public static final int CMD_FULL_SCAN_RESULT = 159764;
    public static final int CMD_GET_SCAN_RESULTS = 159748;
    public static final int CMD_OP_FAILED = 159762;
    public static final int CMD_OP_SUCCEEDED = 159761;
    public static final int CMD_PERIOD_CHANGED = 159763;
    public static final int CMD_RESET_HOTLIST = 159751;
    public static final int CMD_SCAN = 159744;
    public static final int CMD_SCAN_RESULT = 159749;
    public static final int CMD_SET_HOTLIST = 159750;
    public static final int CMD_START_BACKGROUND_SCAN = 159746;
    public static final int CMD_START_TRACKING_CHANGE = 159755;
    public static final int CMD_STOP_BACKGROUND_SCAN = 159747;
    public static final int CMD_STOP_TRACKING_CHANGE = 159756;
    public static final int CMD_WIFI_CHANGES_STABILIZED = 159760;
    public static final int CMD_WIFI_CHANGE_DETECTED = 159759;
    private static final boolean DBG = true;
    public static final String GET_AVAILABLE_CHANNELS_EXTRA = "Channels";
    private static final int INVALID_KEY = 0;
    public static final int MAX_SCAN_PERIOD_MS = 1024000;
    public static final int MIN_SCAN_PERIOD_MS = 1000;
    public static final int REASON_INVALID_LISTENER = -2;
    public static final int REASON_INVALID_REQUEST = -3;
    public static final int REASON_NOT_AUTHORIZED = -4;
    public static final int REASON_SUCCEEDED = 0;
    public static final int REASON_UNSPECIFIED = -1;
    public static final int REPORT_EVENT_AFTER_BUFFER_FULL = 0;
    public static final int REPORT_EVENT_AFTER_EACH_SCAN = 1;
    public static final int REPORT_EVENT_FULL_SCAN_RESULT = 2;
    private static final String TAG = "WifiScanner";
    public static final int WIFI_BAND_24_GHZ = 1;
    public static final int WIFI_BAND_5_GHZ = 2;
    public static final int WIFI_BAND_5_GHZ_DFS_ONLY = 4;
    public static final int WIFI_BAND_5_GHZ_WITH_DFS = 6;
    public static final int WIFI_BAND_BOTH = 3;
    public static final int WIFI_BAND_BOTH_WITH_DFS = 7;
    public static final int WIFI_BAND_UNSPECIFIED = 0;
    private static AsyncChannel sAsyncChannel;
    private static CountDownLatch sConnected;
    private static HandlerThread sHandlerThread;
    private static int sThreadRefCount;
    private Context mContext;
    private IWifiScanner mService;
    private static int sListenerKey = 1;
    private static final SparseArray sListenerMap = new SparseArray();
    private static final Object sListenerMapLock = new Object();
    private static final Object sThreadRefLock = new Object();

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$ActionListener.class */
    public interface ActionListener {
        void onFailure(int i, String str);

        void onSuccess();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$BssidInfo.class */
    public static class BssidInfo {
        public String bssid;
        public int frequencyHint;
        public int high;
        public int low;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$BssidListener.class */
    public interface BssidListener extends ActionListener {
        void onFound(ScanResult[] scanResultArr);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$ChannelSpec.class */
    public static class ChannelSpec {
        public int frequency;
        public boolean passive = false;
        public int dwellTimeMS = 0;

        public ChannelSpec(int i) {
            this.frequency = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$HotlistSettings.class */
    public static class HotlistSettings implements Parcelable {
        public static final Parcelable.Creator<HotlistSettings> CREATOR = new Parcelable.Creator<HotlistSettings>() { // from class: android.net.wifi.WifiScanner.HotlistSettings.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HotlistSettings createFromParcel(Parcel parcel) {
                HotlistSettings hotlistSettings = new HotlistSettings();
                hotlistSettings.apLostThreshold = parcel.readInt();
                int readInt = parcel.readInt();
                hotlistSettings.bssidInfos = new BssidInfo[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        return hotlistSettings;
                    }
                    BssidInfo bssidInfo = new BssidInfo();
                    bssidInfo.bssid = parcel.readString();
                    bssidInfo.low = parcel.readInt();
                    bssidInfo.high = parcel.readInt();
                    bssidInfo.frequencyHint = parcel.readInt();
                    hotlistSettings.bssidInfos[i2] = bssidInfo;
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HotlistSettings[] newArray(int i) {
                return new HotlistSettings[i];
            }
        };
        public int apLostThreshold;
        public BssidInfo[] bssidInfos;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.apLostThreshold);
            if (this.bssidInfos == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(this.bssidInfos.length);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.bssidInfos.length) {
                    return;
                }
                BssidInfo bssidInfo = this.bssidInfos[i3];
                parcel.writeString(bssidInfo.bssid);
                parcel.writeInt(bssidInfo.low);
                parcel.writeInt(bssidInfo.high);
                parcel.writeInt(bssidInfo.frequencyHint);
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$OperationResult.class */
    public static class OperationResult implements Parcelable {
        public static final Parcelable.Creator<OperationResult> CREATOR = new Parcelable.Creator<OperationResult>() { // from class: android.net.wifi.WifiScanner.OperationResult.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public OperationResult createFromParcel(Parcel parcel) {
                return new OperationResult(parcel.readInt(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public OperationResult[] newArray(int i) {
                return new OperationResult[i];
            }
        };
        public String description;
        public int reason;

        public OperationResult(int i, String str) {
            this.reason = i;
            this.description = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.reason);
            parcel.writeString(this.description);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$ParcelableScanResults.class */
    public static class ParcelableScanResults implements Parcelable {
        public static final Parcelable.Creator<ParcelableScanResults> CREATOR = new Parcelable.Creator<ParcelableScanResults>() { // from class: android.net.wifi.WifiScanner.ParcelableScanResults.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelableScanResults createFromParcel(Parcel parcel) {
                int readInt = parcel.readInt();
                ScanResult[] scanResultArr = new ScanResult[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        return new ParcelableScanResults(scanResultArr);
                    }
                    scanResultArr[i2] = ScanResult.CREATOR.createFromParcel(parcel);
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelableScanResults[] newArray(int i) {
                return new ParcelableScanResults[i];
            }
        };
        public ScanResult[] mResults;

        public ParcelableScanResults(ScanResult[] scanResultArr) {
            this.mResults = scanResultArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public ScanResult[] getResults() {
            return this.mResults;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.mResults == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(this.mResults.length);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mResults.length) {
                    return;
                }
                this.mResults[i3].writeToParcel(parcel, i);
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$ScanListener.class */
    public interface ScanListener extends ActionListener {
        void onFullResult(ScanResult scanResult);

        void onPeriodChanged(int i);

        void onResults(ScanResult[] scanResultArr);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$ScanSettings.class */
    public static class ScanSettings implements Parcelable {
        public static final Parcelable.Creator<ScanSettings> CREATOR = new Parcelable.Creator<ScanSettings>() { // from class: android.net.wifi.WifiScanner.ScanSettings.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ScanSettings createFromParcel(Parcel parcel) {
                ScanSettings scanSettings = new ScanSettings();
                scanSettings.band = parcel.readInt();
                scanSettings.periodInMs = parcel.readInt();
                scanSettings.reportEvents = parcel.readInt();
                scanSettings.numBssidsPerScan = parcel.readInt();
                int readInt = parcel.readInt();
                scanSettings.channels = new ChannelSpec[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        return scanSettings;
                    }
                    ChannelSpec channelSpec = new ChannelSpec(parcel.readInt());
                    channelSpec.dwellTimeMS = parcel.readInt();
                    channelSpec.passive = parcel.readInt() == 1;
                    scanSettings.channels[i2] = channelSpec;
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ScanSettings[] newArray(int i) {
                return new ScanSettings[i];
            }
        };
        public int band;
        public ChannelSpec[] channels;
        public int numBssidsPerScan;
        public int periodInMs;
        public int reportEvents;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.band);
            parcel.writeInt(this.periodInMs);
            parcel.writeInt(this.reportEvents);
            parcel.writeInt(this.numBssidsPerScan);
            if (this.channels == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(this.channels.length);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.channels.length) {
                    return;
                }
                parcel.writeInt(this.channels[i3].frequency);
                parcel.writeInt(this.channels[i3].dwellTimeMS);
                parcel.writeInt(this.channels[i3].passive ? 1 : 0);
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$ServiceHandler.class */
    public static class ServiceHandler extends Handler {
        ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 69632:
                    if (message.arg1 == 0) {
                        WifiScanner.sAsyncChannel.sendMessage(69633);
                    } else {
                        Log.e(WifiScanner.TAG, "Failed to set up channel connection");
                        AsyncChannel unused = WifiScanner.sAsyncChannel = null;
                    }
                    WifiScanner.sConnected.countDown();
                    return;
                case 69633:
                case 69635:
                default:
                    Object listener = WifiScanner.getListener(message.arg2);
                    if (listener == null) {
                        Log.d(WifiScanner.TAG, "invalid listener key = " + message.arg2);
                        return;
                    }
                    Log.d(WifiScanner.TAG, "listener key = " + message.arg2);
                    switch (message.what) {
                        case WifiScanner.CMD_SCAN_RESULT /* 159749 */:
                            ((ScanListener) listener).onResults(((ParcelableScanResults) message.obj).getResults());
                            return;
                        case WifiScanner.CMD_SET_HOTLIST /* 159750 */:
                        case WifiScanner.CMD_RESET_HOTLIST /* 159751 */:
                        case 159752:
                        case WifiScanner.CMD_AP_LOST /* 159754 */:
                        case WifiScanner.CMD_START_TRACKING_CHANGE /* 159755 */:
                        case WifiScanner.CMD_STOP_TRACKING_CHANGE /* 159756 */:
                        case WifiScanner.CMD_CONFIGURE_WIFI_CHANGE /* 159757 */:
                        case 159758:
                        default:
                            Log.d(WifiScanner.TAG, "Ignoring message " + message.what);
                            return;
                        case WifiScanner.CMD_AP_FOUND /* 159753 */:
                            ((BssidListener) listener).onFound(((ParcelableScanResults) message.obj).getResults());
                            return;
                        case WifiScanner.CMD_WIFI_CHANGE_DETECTED /* 159759 */:
                            ((WifiChangeListener) listener).onChanging(((ParcelableScanResults) message.obj).getResults());
                            return;
                        case WifiScanner.CMD_WIFI_CHANGES_STABILIZED /* 159760 */:
                            ((WifiChangeListener) listener).onQuiescence(((ParcelableScanResults) message.obj).getResults());
                            return;
                        case WifiScanner.CMD_OP_SUCCEEDED /* 159761 */:
                            ((ActionListener) listener).onSuccess();
                            return;
                        case WifiScanner.CMD_OP_FAILED /* 159762 */:
                            OperationResult operationResult = (OperationResult) message.obj;
                            ((ActionListener) listener).onFailure(operationResult.reason, operationResult.description);
                            WifiScanner.removeListener(message.arg2);
                            return;
                        case WifiScanner.CMD_PERIOD_CHANGED /* 159763 */:
                            ((ScanListener) listener).onPeriodChanged(message.arg1);
                            return;
                        case WifiScanner.CMD_FULL_SCAN_RESULT /* 159764 */:
                            ((ScanListener) listener).onFullResult((ScanResult) message.obj);
                            return;
                    }
                case 69634:
                    return;
                case 69636:
                    Log.e(WifiScanner.TAG, "Channel connection lost");
                    AsyncChannel unused2 = WifiScanner.sAsyncChannel = null;
                    getLooper().quit();
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$WifiChangeListener.class */
    public interface WifiChangeListener extends ActionListener {
        void onChanging(ScanResult[] scanResultArr);

        void onQuiescence(ScanResult[] scanResultArr);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiScanner$WifiChangeSettings.class */
    public static class WifiChangeSettings implements Parcelable {
        public static final Parcelable.Creator<WifiChangeSettings> CREATOR = new Parcelable.Creator<WifiChangeSettings>() { // from class: android.net.wifi.WifiScanner.WifiChangeSettings.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WifiChangeSettings createFromParcel(Parcel parcel) {
                WifiChangeSettings wifiChangeSettings = new WifiChangeSettings();
                wifiChangeSettings.rssiSampleSize = parcel.readInt();
                wifiChangeSettings.lostApSampleSize = parcel.readInt();
                wifiChangeSettings.unchangedSampleSize = parcel.readInt();
                wifiChangeSettings.minApsBreachingThreshold = parcel.readInt();
                wifiChangeSettings.periodInMs = parcel.readInt();
                int readInt = parcel.readInt();
                wifiChangeSettings.bssidInfos = new BssidInfo[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        return wifiChangeSettings;
                    }
                    BssidInfo bssidInfo = new BssidInfo();
                    bssidInfo.bssid = parcel.readString();
                    bssidInfo.low = parcel.readInt();
                    bssidInfo.high = parcel.readInt();
                    bssidInfo.frequencyHint = parcel.readInt();
                    wifiChangeSettings.bssidInfos[i2] = bssidInfo;
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WifiChangeSettings[] newArray(int i) {
                return new WifiChangeSettings[i];
            }
        };
        public BssidInfo[] bssidInfos;
        public int lostApSampleSize;
        public int minApsBreachingThreshold;
        public int periodInMs;
        public int rssiSampleSize;
        public int unchangedSampleSize;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.rssiSampleSize);
            parcel.writeInt(this.lostApSampleSize);
            parcel.writeInt(this.unchangedSampleSize);
            parcel.writeInt(this.minApsBreachingThreshold);
            parcel.writeInt(this.periodInMs);
            if (this.bssidInfos == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(this.bssidInfos.length);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.bssidInfos.length) {
                    return;
                }
                BssidInfo bssidInfo = this.bssidInfos[i3];
                parcel.writeString(bssidInfo.bssid);
                parcel.writeInt(bssidInfo.low);
                parcel.writeInt(bssidInfo.high);
                parcel.writeInt(bssidInfo.frequencyHint);
                i2 = i3 + 1;
            }
        }
    }

    public WifiScanner(Context context, IWifiScanner iWifiScanner) {
        this.mContext = context;
        this.mService = iWifiScanner;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getListener(int i) {
        Object obj;
        if (i == 0) {
            return null;
        }
        synchronized (sListenerMapLock) {
            obj = sListenerMap.get(i);
        }
        return obj;
    }

    private static int getListenerKey(Object obj) {
        if (obj == null) {
            return 0;
        }
        synchronized (sListenerMapLock) {
            int indexOfValue = sListenerMap.indexOfValue(obj);
            if (indexOfValue == -1) {
                return 0;
            }
            return sListenerMap.keyAt(indexOfValue);
        }
    }

    private void init() {
        synchronized (sThreadRefLock) {
            int i = sThreadRefCount + 1;
            sThreadRefCount = i;
            if (i == 1) {
                Messenger messenger = null;
                try {
                    messenger = this.mService.getMessenger();
                } catch (RemoteException e) {
                } catch (SecurityException e2) {
                }
                if (messenger == null) {
                    sAsyncChannel = null;
                    return;
                }
                sHandlerThread = new HandlerThread(TAG);
                sAsyncChannel = new AsyncChannel();
                sConnected = new CountDownLatch(1);
                sHandlerThread.start();
                sAsyncChannel.connect(this.mContext, new ServiceHandler(sHandlerThread.getLooper()), messenger);
                try {
                    sConnected.await();
                } catch (InterruptedException e3) {
                    Log.e(TAG, "interrupted wait at init");
                }
            }
        }
    }

    private static int putListener(Object obj) {
        int i;
        if (obj == null) {
            return 0;
        }
        synchronized (sListenerMapLock) {
            do {
                i = sListenerKey;
                sListenerKey = i + 1;
            } while (i == 0);
            sListenerMap.put(i, obj);
        }
        return i;
    }

    private static int removeListener(Object obj) {
        int listenerKey = getListenerKey(obj);
        if (listenerKey == 0) {
            return listenerKey;
        }
        synchronized (sListenerMapLock) {
            sListenerMap.remove(listenerKey);
        }
        return listenerKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object removeListener(int i) {
        Object obj;
        if (i == 0) {
            return null;
        }
        synchronized (sListenerMapLock) {
            obj = sListenerMap.get(i);
            sListenerMap.remove(i);
        }
        return obj;
    }

    private void validateChannel() {
        if (sAsyncChannel == null) {
            throw new IllegalStateException("No permission to access and change wifi or a bad initialization");
        }
    }

    public void configureWifiChange(int i, int i2, int i3, int i4, int i5, BssidInfo[] bssidInfoArr) {
        validateChannel();
        WifiChangeSettings wifiChangeSettings = new WifiChangeSettings();
        wifiChangeSettings.rssiSampleSize = i;
        wifiChangeSettings.lostApSampleSize = i2;
        wifiChangeSettings.unchangedSampleSize = i3;
        wifiChangeSettings.minApsBreachingThreshold = i4;
        wifiChangeSettings.periodInMs = i5;
        wifiChangeSettings.bssidInfos = bssidInfoArr;
        configureWifiChange(wifiChangeSettings);
    }

    public void configureWifiChange(WifiChangeSettings wifiChangeSettings) {
        validateChannel();
        sAsyncChannel.sendMessage((int) CMD_CONFIGURE_WIFI_CHANGE, 0, 0, wifiChangeSettings);
    }

    public List<Integer> getAvailableChannels(int i) {
        try {
            return this.mService.getAvailableChannels(i).getIntegerArrayList(GET_AVAILABLE_CHANNELS_EXTRA);
        } catch (RemoteException e) {
            return null;
        }
    }

    public ScanResult[] getScanResults() {
        validateChannel();
        return (ScanResult[]) sAsyncChannel.sendMessageSynchronously((int) CMD_GET_SCAN_RESULTS, 0).obj;
    }

    public void startBackgroundScan(ScanSettings scanSettings, ScanListener scanListener) {
        validateChannel();
        sAsyncChannel.sendMessage((int) CMD_START_BACKGROUND_SCAN, 0, putListener(scanListener), scanSettings);
    }

    public void startTrackingBssids(BssidInfo[] bssidInfoArr, int i, BssidListener bssidListener) {
        validateChannel();
        HotlistSettings hotlistSettings = new HotlistSettings();
        hotlistSettings.bssidInfos = bssidInfoArr;
        sAsyncChannel.sendMessage((int) CMD_SET_HOTLIST, 0, putListener(bssidListener), hotlistSettings);
    }

    public void startTrackingWifiChange(WifiChangeListener wifiChangeListener) {
        validateChannel();
        sAsyncChannel.sendMessage((int) CMD_START_TRACKING_CHANGE, 0, putListener(wifiChangeListener));
    }

    public void stopBackgroundScan(ScanListener scanListener) {
        validateChannel();
        sAsyncChannel.sendMessage((int) CMD_STOP_BACKGROUND_SCAN, 0, removeListener(scanListener));
    }

    public void stopTrackingBssids(BssidListener bssidListener) {
        validateChannel();
        sAsyncChannel.sendMessage((int) CMD_RESET_HOTLIST, 0, removeListener(bssidListener));
    }

    public void stopTrackingWifiChange(WifiChangeListener wifiChangeListener) {
        validateChannel();
        sAsyncChannel.sendMessage((int) CMD_STOP_TRACKING_CHANGE, 0, removeListener(wifiChangeListener));
    }
}
