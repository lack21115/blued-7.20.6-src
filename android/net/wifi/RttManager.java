package android.net.wifi;

import android.content.Context;
import android.os.Bundle;
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
import java.util.concurrent.CountDownLatch;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RttManager.class */
public class RttManager {
    public static final int BASE = 160256;
    public static final int CMD_OP_ABORTED = 160260;
    public static final int CMD_OP_FAILED = 160258;
    public static final int CMD_OP_START_RANGING = 160256;
    public static final int CMD_OP_STOP_RANGING = 160257;
    public static final int CMD_OP_SUCCEEDED = 160259;
    private static final boolean DBG = true;
    public static final String DESCRIPTION_KEY = "android.net.wifi.RttManager.Description";
    private static final int INVALID_KEY = 0;
    public static final int REASON_INVALID_LISTENER = -3;
    public static final int REASON_INVALID_REQUEST = -4;
    public static final int REASON_NOT_AVAILABLE = -2;
    public static final int REASON_UNSPECIFIED = -1;
    public static final int RTT_CHANNEL_WIDTH_10 = 6;
    public static final int RTT_CHANNEL_WIDTH_160 = 3;
    public static final int RTT_CHANNEL_WIDTH_20 = 0;
    public static final int RTT_CHANNEL_WIDTH_40 = 1;
    public static final int RTT_CHANNEL_WIDTH_5 = 5;
    public static final int RTT_CHANNEL_WIDTH_80 = 2;
    public static final int RTT_CHANNEL_WIDTH_80P80 = 4;
    public static final int RTT_CHANNEL_WIDTH_UNSPECIFIED = -1;
    public static final int RTT_PEER_TYPE_AP = 1;
    public static final int RTT_PEER_TYPE_STA = 2;
    public static final int RTT_PEER_TYPE_UNSPECIFIED = 0;
    public static final int RTT_STATUS_ABORTED = 8;
    public static final int RTT_STATUS_FAILURE = 1;
    public static final int RTT_STATUS_FAIL_AP_ON_DIFF_CHANNEL = 6;
    public static final int RTT_STATUS_FAIL_NOT_SCHEDULED_YET = 4;
    public static final int RTT_STATUS_FAIL_NO_CAPABILITY = 7;
    public static final int RTT_STATUS_FAIL_NO_RSP = 2;
    public static final int RTT_STATUS_FAIL_REJECTED = 3;
    public static final int RTT_STATUS_FAIL_TM_TIMEOUT = 5;
    public static final int RTT_STATUS_SUCCESS = 0;
    public static final int RTT_TYPE_11_MC = 4;
    public static final int RTT_TYPE_11_V = 2;
    public static final int RTT_TYPE_ONE_SIDED = 1;
    public static final int RTT_TYPE_UNSPECIFIED = 0;
    private static final String TAG = "RttManager";
    private static AsyncChannel sAsyncChannel;
    private static CountDownLatch sConnected;
    private static HandlerThread sHandlerThread;
    private static int sThreadRefCount;
    private Context mContext;
    private IRttManager mService;
    private static int sListenerKey = 1;
    private static final SparseArray sListenerMap = new SparseArray();
    private static final Object sListenerMapLock = new Object();
    private static final Object sThreadRefLock = new Object();

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RttManager$Capabilities.class */
    public class Capabilities {
        public int supportedPeerType;
        public int supportedType;

        public Capabilities() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RttManager$ParcelableRttParams.class */
    public static class ParcelableRttParams implements Parcelable {
        public static final Parcelable.Creator<ParcelableRttParams> CREATOR = new Parcelable.Creator<ParcelableRttParams>() { // from class: android.net.wifi.RttManager.ParcelableRttParams.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelableRttParams createFromParcel(Parcel parcel) {
                int readInt = parcel.readInt();
                if (readInt == 0) {
                    return new ParcelableRttParams(null);
                }
                RttParams[] rttParamsArr = new RttParams[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        return new ParcelableRttParams(rttParamsArr);
                    }
                    rttParamsArr[i2] = new RttParams();
                    rttParamsArr[i2].deviceType = parcel.readInt();
                    rttParamsArr[i2].requestType = parcel.readInt();
                    rttParamsArr[i2].bssid = parcel.readString();
                    rttParamsArr[i2].frequency = parcel.readInt();
                    rttParamsArr[i2].channelWidth = parcel.readInt();
                    rttParamsArr[i2].num_samples = parcel.readInt();
                    rttParamsArr[i2].num_retries = parcel.readInt();
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelableRttParams[] newArray(int i) {
                return new ParcelableRttParams[i];
            }
        };
        public RttParams[] mParams;

        ParcelableRttParams(RttParams[] rttParamsArr) {
            this.mParams = rttParamsArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.mParams == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(this.mParams.length);
            RttParams[] rttParamsArr = this.mParams;
            int length = rttParamsArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                RttParams rttParams = rttParamsArr[i3];
                parcel.writeInt(rttParams.deviceType);
                parcel.writeInt(rttParams.requestType);
                parcel.writeString(rttParams.bssid);
                parcel.writeInt(rttParams.frequency);
                parcel.writeInt(rttParams.channelWidth);
                parcel.writeInt(rttParams.num_samples);
                parcel.writeInt(rttParams.num_retries);
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RttManager$ParcelableRttResults.class */
    public static class ParcelableRttResults implements Parcelable {
        public static final Parcelable.Creator<ParcelableRttResults> CREATOR = new Parcelable.Creator<ParcelableRttResults>() { // from class: android.net.wifi.RttManager.ParcelableRttResults.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelableRttResults createFromParcel(Parcel parcel) {
                int readInt = parcel.readInt();
                if (readInt == 0) {
                    return new ParcelableRttResults(null);
                }
                RttResult[] rttResultArr = new RttResult[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        return new ParcelableRttResults(rttResultArr);
                    }
                    rttResultArr[i2] = new RttResult();
                    rttResultArr[i2].bssid = parcel.readString();
                    rttResultArr[i2].status = parcel.readInt();
                    rttResultArr[i2].requestType = parcel.readInt();
                    rttResultArr[i2].ts = parcel.readLong();
                    rttResultArr[i2].rssi = parcel.readInt();
                    rttResultArr[i2].rssi_spread = parcel.readInt();
                    rttResultArr[i2].tx_rate = parcel.readInt();
                    rttResultArr[i2].rtt_ns = parcel.readLong();
                    rttResultArr[i2].rtt_sd_ns = parcel.readLong();
                    rttResultArr[i2].rtt_spread_ns = parcel.readLong();
                    rttResultArr[i2].distance_cm = parcel.readInt();
                    rttResultArr[i2].distance_sd_cm = parcel.readInt();
                    rttResultArr[i2].distance_spread_cm = parcel.readInt();
                    i = i2 + 1;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelableRttResults[] newArray(int i) {
                return new ParcelableRttResults[i];
            }
        };
        public RttResult[] mResults;

        public ParcelableRttResults(RttResult[] rttResultArr) {
            this.mResults = rttResultArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.mResults == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(this.mResults.length);
            RttResult[] rttResultArr = this.mResults;
            int length = rttResultArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                RttResult rttResult = rttResultArr[i3];
                parcel.writeString(rttResult.bssid);
                parcel.writeInt(rttResult.status);
                parcel.writeInt(rttResult.requestType);
                parcel.writeLong(rttResult.ts);
                parcel.writeInt(rttResult.rssi);
                parcel.writeInt(rttResult.rssi_spread);
                parcel.writeInt(rttResult.tx_rate);
                parcel.writeLong(rttResult.rtt_ns);
                parcel.writeLong(rttResult.rtt_sd_ns);
                parcel.writeLong(rttResult.rtt_spread_ns);
                parcel.writeInt(rttResult.distance_cm);
                parcel.writeInt(rttResult.distance_sd_cm);
                parcel.writeInt(rttResult.distance_spread_cm);
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RttManager$RttListener.class */
    public interface RttListener {
        void onAborted();

        void onFailure(int i, String str);

        void onSuccess(RttResult[] rttResultArr);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RttManager$RttParams.class */
    public static class RttParams {
        public String bssid;
        public int channelWidth;
        public int deviceType;
        public int frequency;
        public int num_retries;
        public int num_samples;
        public int requestType;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RttManager$RttResult.class */
    public static class RttResult {
        public String bssid;
        public int distance_cm;
        public int distance_sd_cm;
        public int distance_spread_cm;
        public int requestType;
        public int rssi;
        public int rssi_spread;
        public long rtt_ns;
        public long rtt_sd_ns;
        public long rtt_spread_ns;
        public int status;
        public long ts;
        public int tx_rate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/RttManager$ServiceHandler.class */
    public static class ServiceHandler extends Handler {
        ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 69632:
                    if (message.arg1 == 0) {
                        RttManager.sAsyncChannel.sendMessage(69633);
                    } else {
                        Log.e(RttManager.TAG, "Failed to set up channel connection");
                        AsyncChannel unused = RttManager.sAsyncChannel = null;
                    }
                    RttManager.sConnected.countDown();
                    return;
                case 69633:
                case 69635:
                default:
                    Object listener = RttManager.getListener(message.arg2);
                    if (listener == null) {
                        Log.d(RttManager.TAG, "invalid listener key = " + message.arg2);
                        return;
                    }
                    Log.d(RttManager.TAG, "listener key = " + message.arg2);
                    switch (message.what) {
                        case RttManager.CMD_OP_FAILED /* 160258 */:
                            reportFailure(listener, message);
                            RttManager.removeListener(message.arg2);
                            return;
                        case RttManager.CMD_OP_SUCCEEDED /* 160259 */:
                            reportSuccess(listener, message);
                            RttManager.removeListener(message.arg2);
                            return;
                        case RttManager.CMD_OP_ABORTED /* 160260 */:
                            ((RttListener) listener).onAborted();
                            RttManager.removeListener(message.arg2);
                            return;
                        default:
                            Log.d(RttManager.TAG, "Ignoring message " + message.what);
                            return;
                    }
                case 69634:
                    return;
                case 69636:
                    Log.e(RttManager.TAG, "Channel connection lost");
                    AsyncChannel unused2 = RttManager.sAsyncChannel = null;
                    getLooper().quit();
                    return;
            }
        }

        void reportFailure(Object obj, Message message) {
            RttListener rttListener = (RttListener) obj;
            ((RttListener) obj).onFailure(message.arg1, ((Bundle) message.obj).getString(RttManager.DESCRIPTION_KEY));
        }

        void reportSuccess(Object obj, Message message) {
            RttListener rttListener = (RttListener) obj;
            ((RttListener) obj).onSuccess(((ParcelableRttResults) message.obj).mResults);
        }
    }

    public RttManager(Context context, IRttManager iRttManager) {
        this.mContext = context;
        this.mService = iRttManager;
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
                    Log.d(TAG, "Get the messenger from " + this.mService);
                    messenger = this.mService.getMessenger();
                } catch (RemoteException e) {
                } catch (SecurityException e2) {
                }
                if (messenger == null) {
                    sAsyncChannel = null;
                    return;
                }
                sHandlerThread = new HandlerThread("WifiScanner");
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

    public Capabilities getCapabilities() {
        return new Capabilities();
    }

    public void startRanging(RttParams[] rttParamsArr, RttListener rttListener) {
        validateChannel();
        sAsyncChannel.sendMessage(160256, 0, putListener(rttListener), new ParcelableRttParams(rttParamsArr));
    }

    public void stopRanging(RttListener rttListener) {
        validateChannel();
        sAsyncChannel.sendMessage((int) CMD_OP_STOP_RANGING, 0, removeListener(rttListener));
    }
}
