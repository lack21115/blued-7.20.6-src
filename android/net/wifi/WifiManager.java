package android.net.wifi;

import android.app.AppOpsManager;
import android.content.Context;
import android.net.DhcpInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.WorkSource;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.util.AsyncChannel;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiManager.class */
public class WifiManager {
    public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
    public static final String ACTION_REQUEST_SCAN_ALWAYS_AVAILABLE = "android.net.wifi.action.REQUEST_SCAN_ALWAYS_AVAILABLE";
    private static final int BASE = 151552;
    public static final String BATCHED_SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.BATCHED_RESULTS";
    public static final int BUSY = 2;
    public static final int CANCEL_WPS = 151566;
    public static final int CANCEL_WPS_FAILED = 151567;
    public static final int CANCEL_WPS_SUCCEDED = 151568;
    public static final int CHANGE_REASON_ADDED = 0;
    public static final int CHANGE_REASON_CONFIG_CHANGE = 2;
    public static final int CHANGE_REASON_REMOVED = 1;
    public static final String CONFIGURED_NETWORKS_CHANGED_ACTION = "android.net.wifi.CONFIGURED_NETWORKS_CHANGE";
    public static final int CONNECT_NETWORK = 151553;
    public static final int CONNECT_NETWORK_FAILED = 151554;
    public static final int CONNECT_NETWORK_SUCCEEDED = 151555;
    public static final int DATA_ACTIVITY_IN = 1;
    public static final int DATA_ACTIVITY_INOUT = 3;
    public static final int DATA_ACTIVITY_NONE = 0;
    public static final int DATA_ACTIVITY_NOTIFICATION = 1;
    public static final int DATA_ACTIVITY_OUT = 2;
    public static final boolean DEFAULT_POOR_NETWORK_AVOIDANCE_ENABLED = false;
    public static final int DISABLE_NETWORK = 151569;
    public static final int DISABLE_NETWORK_FAILED = 151570;
    public static final int DISABLE_NETWORK_SUCCEEDED = 151571;
    public static final int ERROR = 0;
    public static final int ERROR_AUTHENTICATING = 1;
    public static final String EXTRA_BSSID = "bssid";
    public static final String EXTRA_CHANGE_REASON = "changeReason";
    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
    public static final String EXTRA_MULTIPLE_NETWORKS_CHANGED = "multipleChanges";
    public static final String EXTRA_NETWORK_CAPABILITIES = "networkCapabilities";
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_NEW_RSSI = "newRssi";
    public static final String EXTRA_NEW_STATE = "newState";
    public static final String EXTRA_PREVIOUS_WIFI_AP_STATE = "previous_wifi_state";
    public static final String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";
    public static final String EXTRA_SCAN_AVAILABLE = "scan_enabled";
    public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
    public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
    public static final String EXTRA_WIFI_AP_STATE = "wifi_state";
    public static final String EXTRA_WIFI_CONFIGURATION = "wifiConfiguration";
    public static final String EXTRA_WIFI_INFO = "wifiInfo";
    public static final String EXTRA_WIFI_STATE = "wifi_state";
    public static final int FORGET_NETWORK = 151556;
    public static final int FORGET_NETWORK_FAILED = 151557;
    public static final int FORGET_NETWORK_SUCCEEDED = 151558;
    public static final int INVALID_ARGS = 8;
    private static final int INVALID_KEY = 0;
    public static final int IN_PROGRESS = 1;
    public static final String LINK_CONFIGURATION_CHANGED_ACTION = "android.net.wifi.LINK_CONFIGURATION_CHANGED";
    private static final int MAX_ACTIVE_LOCKS = 50;
    private static final int MAX_RSSI = -55;
    private static final int MIN_RSSI = -100;
    public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
    public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
    public static final int NOT_AUTHORIZED = 9;
    public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
    public static final int RSSI_LEVELS = 5;
    public static final int RSSI_PKTCNT_FETCH = 151572;
    public static final int RSSI_PKTCNT_FETCH_FAILED = 151574;
    public static final int RSSI_PKTCNT_FETCH_SUCCEEDED = 151573;
    public static final int SAVE_NETWORK = 151559;
    public static final int SAVE_NETWORK_FAILED = 151560;
    public static final int SAVE_NETWORK_SUCCEEDED = 151561;
    public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
    public static final int START_WPS = 151562;
    public static final int START_WPS_SUCCEEDED = 151563;
    public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION = "android.net.wifi.supplicant.CONNECTION_CHANGE";
    public static final String SUPPLICANT_STATE_CHANGED_ACTION = "android.net.wifi.supplicant.STATE_CHANGE";
    private static final String TAG = "WifiManager";
    public static final String WIFI_AP_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_AP_STATE_CHANGED";
    public static final int WIFI_AP_STATE_DISABLED = 11;
    public static final int WIFI_AP_STATE_DISABLING = 10;
    public static final int WIFI_AP_STATE_ENABLED = 13;
    public static final int WIFI_AP_STATE_ENABLING = 12;
    public static final int WIFI_AP_STATE_FAILED = 14;
    public static final int WIFI_FEATURE_ADDITIONAL_STA = 2048;
    public static final int WIFI_FEATURE_BATCH_SCAN = 512;
    public static final int WIFI_FEATURE_D2AP_RTT = 256;
    public static final int WIFI_FEATURE_D2D_RTT = 128;
    public static final int WIFI_FEATURE_EPR = 16384;
    public static final int WIFI_FEATURE_INFRA = 1;
    public static final int WIFI_FEATURE_INFRA_5G = 2;
    public static final int WIFI_FEATURE_MOBILE_HOTSPOT = 16;
    public static final int WIFI_FEATURE_NAN = 64;
    public static final int WIFI_FEATURE_P2P = 8;
    public static final int WIFI_FEATURE_PASSPOINT = 4;
    public static final int WIFI_FEATURE_PNO = 1024;
    public static final int WIFI_FEATURE_SCANNER = 32;
    public static final int WIFI_FEATURE_TDLS = 4096;
    public static final int WIFI_FEATURE_TDLS_OFFCHANNEL = 8192;
    public static final int WIFI_FREQUENCY_BAND_2GHZ = 2;
    public static final int WIFI_FREQUENCY_BAND_5GHZ = 1;
    public static final int WIFI_FREQUENCY_BAND_AUTO = 0;
    public static final int WIFI_MODE_FULL = 1;
    public static final int WIFI_MODE_FULL_HIGH_PERF = 3;
    public static final int WIFI_MODE_SCAN_ONLY = 2;
    public static final String WIFI_SCAN_AVAILABLE = "wifi_scan_available";
    public static final String WIFI_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";
    public static final int WIFI_STATE_DISABLED = 1;
    public static final int WIFI_STATE_DISABLING = 0;
    public static final int WIFI_STATE_ENABLED = 3;
    public static final int WIFI_STATE_ENABLING = 2;
    public static final int WIFI_STATE_UNKNOWN = 4;
    public static final int WPS_AUTH_FAILURE = 6;
    public static final int WPS_COMPLETED = 151565;
    public static final int WPS_FAILED = 151564;
    public static final int WPS_OVERLAP_ERROR = 3;
    public static final int WPS_TIMED_OUT = 7;
    public static final int WPS_TKIP_ONLY_PROHIBITED = 5;
    public static final int WPS_WEP_PROHIBITED = 4;
    private static AsyncChannel sAsyncChannel;
    private static CountDownLatch sConnected;
    private static HandlerThread sHandlerThread;
    private static int sThreadRefCount;
    private int mActiveLockCount;
    private final AppOpsManager mAppOps;
    private Context mContext;
    IWifiManager mService;
    private static int sListenerKey = 1;
    private static final SparseArray sListenerMap = new SparseArray();
    private static final Object sListenerMapLock = new Object();
    private static final Object sThreadRefLock = new Object();

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiManager$ActionListener.class */
    public interface ActionListener {
        void onFailure(int i);

        void onSuccess();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiManager$MulticastLock.class */
    public class MulticastLock {
        private final IBinder mBinder;
        private boolean mHeld;
        private int mRefCount;
        private boolean mRefCounted;
        private String mTag;

        private MulticastLock(String str) {
            this.mTag = str;
            this.mBinder = new Binder();
            this.mRefCount = 0;
            this.mRefCounted = true;
            this.mHeld = false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
            if (r4.this$0.mActiveLockCount < 50) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
            r4.this$0.mService.releaseMulticastLock();
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
            throw new java.lang.UnsupportedOperationException("Exceeded maximum number of wifi locks");
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
            if (r4.mHeld == false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
            android.net.wifi.WifiManager.access$508(r4.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r0 == 1) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
            r4.this$0.mService.acquireMulticastLock(r4.mBinder, r4.mTag);
            r0 = r4.this$0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void acquire() {
            /*
                r4 = this;
                r0 = r4
                android.os.IBinder r0 = r0.mBinder
                r7 = r0
                r0 = r7
                monitor-enter(r0)
                r0 = r4
                boolean r0 = r0.mRefCounted     // Catch: java.lang.Throwable -> L8a
                if (r0 == 0) goto L70
                r0 = r4
                int r0 = r0.mRefCount     // Catch: java.lang.Throwable -> L8a
                r1 = 1
                int r0 = r0 + r1
                r5 = r0
                r0 = r4
                r1 = r5
                r0.mRefCount = r1     // Catch: java.lang.Throwable -> L8a
                r0 = r5
                r1 = 1
                if (r0 != r1) goto L6d
            L1f:
                r0 = r4
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: android.os.RemoteException -> L66 java.lang.Throwable -> L8a
                android.net.wifi.IWifiManager r0 = r0.mService     // Catch: android.os.RemoteException -> L66 java.lang.Throwable -> L8a
                r1 = r4
                android.os.IBinder r1 = r1.mBinder     // Catch: android.os.RemoteException -> L66 java.lang.Throwable -> L8a
                r2 = r4
                java.lang.String r2 = r2.mTag     // Catch: android.os.RemoteException -> L66 java.lang.Throwable -> L8a
                r0.acquireMulticastLock(r1, r2)     // Catch: android.os.RemoteException -> L66 java.lang.Throwable -> L8a
                r0 = r4
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: android.os.RemoteException -> L66 java.lang.Throwable -> L8a
                r8 = r0
                r0 = r8
                monitor-enter(r0)     // Catch: android.os.RemoteException -> L66 java.lang.Throwable -> L8a
                r0 = r4
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L5e
                int r0 = android.net.wifi.WifiManager.access$500(r0)     // Catch: java.lang.Throwable -> L5e
                r1 = 50
                if (r0 < r1) goto L7c
                r0 = r4
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L5e
                android.net.wifi.IWifiManager r0 = r0.mService     // Catch: java.lang.Throwable -> L5e
                r0.releaseMulticastLock()     // Catch: java.lang.Throwable -> L5e
                java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch: java.lang.Throwable -> L5e
                r1 = r0
                java.lang.String r2 = "Exceeded maximum number of wifi locks"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L5e
                throw r0     // Catch: java.lang.Throwable -> L5e
            L5e:
                r9 = move-exception
                r0 = r8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                r0 = r9
                throw r0     // Catch: android.os.RemoteException -> L66 java.lang.Throwable -> L8a
            L66:
                r8 = move-exception
            L68:
                r0 = r4
                r1 = 1
                r0.mHeld = r1     // Catch: java.lang.Throwable -> L8a
            L6d:
                r0 = r7
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L8a
                return
            L70:
                r0 = r4
                boolean r0 = r0.mHeld     // Catch: java.lang.Throwable -> L8a
                r6 = r0
                r0 = r6
                if (r0 != 0) goto L6d
                goto L1f
            L7c:
                r0 = r4
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L5e
                int r0 = android.net.wifi.WifiManager.access$508(r0)     // Catch: java.lang.Throwable -> L5e
                r0 = r8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                goto L68
            L8a:
                r8 = move-exception
                r0 = r7
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L8a
                r0 = r8
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.net.wifi.WifiManager.MulticastLock.acquire():void");
        }

        protected void finalize() throws Throwable {
            super.finalize();
            setReferenceCounted(false);
            release();
        }

        public boolean isHeld() {
            boolean z;
            synchronized (this.mBinder) {
                z = this.mHeld;
            }
            return z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
            android.net.wifi.WifiManager.access$510(r5.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
            if (r5.mHeld != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
            if (r0 == 0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
            r5.this$0.mService.releaseMulticastLock();
            r0 = r5.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004a A[Catch: all -> 0x0068, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000e, B:8:0x001e, B:9:0x0032, B:14:0x003f, B:32:0x0082, B:16:0x0044, B:18:0x004a, B:19:0x0067, B:36:0x0089, B:25:0x006f), top: B:40:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void release() {
            /*
                r5 = this;
                r0 = r5
                android.os.IBinder r0 = r0.mBinder
                r8 = r0
                r0 = r8
                monitor-enter(r0)
                r0 = r5
                boolean r0 = r0.mRefCounted     // Catch: java.lang.Throwable -> L68
                if (r0 == 0) goto L6f
                r0 = r5
                int r0 = r0.mRefCount     // Catch: java.lang.Throwable -> L68
                r1 = 1
                int r0 = r0 - r1
                r6 = r0
                r0 = r5
                r1 = r6
                r0.mRefCount = r1     // Catch: java.lang.Throwable -> L68
                r0 = r6
                if (r0 != 0) goto L43
            L1e:
                r0 = r5
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L68 android.os.RemoteException -> L83
                android.net.wifi.IWifiManager r0 = r0.mService     // Catch: java.lang.Throwable -> L68 android.os.RemoteException -> L83
                r0.releaseMulticastLock()     // Catch: java.lang.Throwable -> L68 android.os.RemoteException -> L83
                r0 = r5
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L68 android.os.RemoteException -> L83
                r9 = r0
                r0 = r9
                monitor-enter(r0)     // Catch: java.lang.Throwable -> L68 android.os.RemoteException -> L83
                r0 = r5
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L7b
                int r0 = android.net.wifi.WifiManager.access$510(r0)     // Catch: java.lang.Throwable -> L7b
                r0 = r9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L7b
            L3e:
                r0 = r5
                r1 = 0
                r0.mHeld = r1     // Catch: java.lang.Throwable -> L68
            L43:
                r0 = r5
                int r0 = r0.mRefCount     // Catch: java.lang.Throwable -> L68
                if (r0 >= 0) goto L88
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L68
                r1 = r0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
                r3 = r2
                r3.<init>()     // Catch: java.lang.Throwable -> L68
                java.lang.String r3 = "MulticastLock under-locked "
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L68
                r3 = r5
                java.lang.String r3 = r3.mTag     // Catch: java.lang.Throwable -> L68
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L68
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L68
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L68
                throw r0     // Catch: java.lang.Throwable -> L68
            L68:
                r9 = move-exception
                r0 = r8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
                r0 = r9
                throw r0
            L6f:
                r0 = r5
                boolean r0 = r0.mHeld     // Catch: java.lang.Throwable -> L68
                r7 = r0
                r0 = r7
                if (r0 == 0) goto L43
                goto L1e
            L7b:
                r10 = move-exception
                r0 = r9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L7b
                r0 = r10
                throw r0     // Catch: java.lang.Throwable -> L68 android.os.RemoteException -> L83
            L83:
                r9 = move-exception
                goto L3e
            L88:
                r0 = r8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L68
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.net.wifi.WifiManager.MulticastLock.release():void");
        }

        public void setReferenceCounted(boolean z) {
            this.mRefCounted = z;
        }

        public String toString() {
            String str;
            synchronized (this.mBinder) {
                str = "MulticastLock{ " + Integer.toHexString(System.identityHashCode(this)) + "; " + (this.mHeld ? "held; " : "") + (this.mRefCounted ? "refcounted: refcount = " + this.mRefCount : "not refcounted") + " }";
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiManager$ServiceHandler.class */
    public static class ServiceHandler extends Handler {
        ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object removeListener = WifiManager.removeListener(message.arg2);
            switch (message.what) {
                case 69632:
                    if (message.arg1 == 0) {
                        WifiManager.sAsyncChannel.sendMessage(AsyncChannel.CMD_CHANNEL_FULL_CONNECTION);
                    } else {
                        Log.e(WifiManager.TAG, "Failed to set up channel connection");
                        AsyncChannel unused = WifiManager.sAsyncChannel = null;
                    }
                    WifiManager.sConnected.countDown();
                    return;
                case AsyncChannel.CMD_CHANNEL_FULLY_CONNECTED /* 69634 */:
                default:
                    return;
                case AsyncChannel.CMD_CHANNEL_DISCONNECTED /* 69636 */:
                    Log.e(WifiManager.TAG, "Channel connection lost");
                    AsyncChannel unused2 = WifiManager.sAsyncChannel = null;
                    getLooper().quit();
                    return;
                case WifiManager.CONNECT_NETWORK_FAILED /* 151554 */:
                case WifiManager.FORGET_NETWORK_FAILED /* 151557 */:
                case WifiManager.SAVE_NETWORK_FAILED /* 151560 */:
                case WifiManager.DISABLE_NETWORK_FAILED /* 151570 */:
                    if (removeListener != null) {
                        ((ActionListener) removeListener).onFailure(message.arg1);
                        return;
                    }
                    return;
                case WifiManager.CONNECT_NETWORK_SUCCEEDED /* 151555 */:
                case WifiManager.FORGET_NETWORK_SUCCEEDED /* 151558 */:
                case WifiManager.SAVE_NETWORK_SUCCEEDED /* 151561 */:
                case WifiManager.DISABLE_NETWORK_SUCCEEDED /* 151571 */:
                    if (removeListener != null) {
                        ((ActionListener) removeListener).onSuccess();
                        return;
                    }
                    return;
                case WifiManager.START_WPS_SUCCEEDED /* 151563 */:
                    if (removeListener != null) {
                        ((WpsCallback) removeListener).onStarted(((WpsResult) message.obj).pin);
                        synchronized (WifiManager.sListenerMapLock) {
                            WifiManager.sListenerMap.put(message.arg2, removeListener);
                        }
                        return;
                    }
                    return;
                case WifiManager.WPS_FAILED /* 151564 */:
                    if (removeListener != null) {
                        ((WpsCallback) removeListener).onFailed(message.arg1);
                        return;
                    }
                    return;
                case WifiManager.WPS_COMPLETED /* 151565 */:
                    if (removeListener != null) {
                        ((WpsCallback) removeListener).onSucceeded();
                        return;
                    }
                    return;
                case WifiManager.CANCEL_WPS_FAILED /* 151567 */:
                    if (removeListener != null) {
                        ((WpsCallback) removeListener).onFailed(message.arg1);
                        return;
                    }
                    return;
                case WifiManager.CANCEL_WPS_SUCCEDED /* 151568 */:
                    if (removeListener != null) {
                        ((WpsCallback) removeListener).onSucceeded();
                        return;
                    }
                    return;
                case WifiManager.RSSI_PKTCNT_FETCH_SUCCEEDED /* 151573 */:
                    if (removeListener != null) {
                        RssiPacketCountInfo rssiPacketCountInfo = (RssiPacketCountInfo) message.obj;
                        if (rssiPacketCountInfo != null) {
                            ((TxPacketCountListener) removeListener).onSuccess(rssiPacketCountInfo.txgood + rssiPacketCountInfo.txbad);
                            return;
                        } else {
                            ((TxPacketCountListener) removeListener).onFailure(0);
                            return;
                        }
                    }
                    return;
                case WifiManager.RSSI_PKTCNT_FETCH_FAILED /* 151574 */:
                    if (removeListener != null) {
                        ((TxPacketCountListener) removeListener).onFailure(message.arg1);
                        return;
                    }
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiManager$TxPacketCountListener.class */
    public interface TxPacketCountListener {
        void onFailure(int i);

        void onSuccess(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiManager$WifiLock.class */
    public class WifiLock {
        private final IBinder mBinder;
        private boolean mHeld;
        int mLockType;
        private int mRefCount;
        private boolean mRefCounted;
        private String mTag;
        private WorkSource mWorkSource;

        private WifiLock(int i, String str) {
            this.mTag = str;
            this.mLockType = i;
            this.mBinder = new Binder();
            this.mRefCount = 0;
            this.mRefCounted = true;
            this.mHeld = false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
            if (r6.this$0.mActiveLockCount < 50) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
            r6.this$0.mService.releaseWifiLock(r6.mBinder);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
            throw new java.lang.UnsupportedOperationException("Exceeded maximum number of wifi locks");
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
            if (r6.mHeld == false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
            android.net.wifi.WifiManager.access$508(r6.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r0 == 1) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
            r6.this$0.mService.acquireWifiLock(r6.mBinder, r6.mLockType, r6.mTag, r6.mWorkSource);
            r0 = r6.this$0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void acquire() {
            /*
                r6 = this;
                r0 = r6
                android.os.IBinder r0 = r0.mBinder
                r9 = r0
                r0 = r9
                monitor-enter(r0)
                r0 = r6
                boolean r0 = r0.mRefCounted     // Catch: java.lang.Throwable -> L98
                if (r0 == 0) goto L7e
                r0 = r6
                int r0 = r0.mRefCount     // Catch: java.lang.Throwable -> L98
                r1 = 1
                int r0 = r0 + r1
                r7 = r0
                r0 = r6
                r1 = r7
                r0.mRefCount = r1     // Catch: java.lang.Throwable -> L98
                r0 = r7
                r1 = 1
                if (r0 != r1) goto L7b
            L1f:
                r0 = r6
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                android.net.wifi.IWifiManager r0 = r0.mService     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                r1 = r6
                android.os.IBinder r1 = r1.mBinder     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                r2 = r6
                int r2 = r2.mLockType     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                r3 = r6
                java.lang.String r3 = r3.mTag     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                r4 = r6
                android.os.WorkSource r4 = r4.mWorkSource     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                boolean r0 = r0.acquireWifiLock(r1, r2, r3, r4)     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                r0 = r6
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                r10 = r0
                r0 = r10
                monitor-enter(r0)     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
                r0 = r6
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L6c
                int r0 = android.net.wifi.WifiManager.access$500(r0)     // Catch: java.lang.Throwable -> L6c
                r1 = 50
                if (r0 < r1) goto L8a
                r0 = r6
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L6c
                android.net.wifi.IWifiManager r0 = r0.mService     // Catch: java.lang.Throwable -> L6c
                r1 = r6
                android.os.IBinder r1 = r1.mBinder     // Catch: java.lang.Throwable -> L6c
                boolean r0 = r0.releaseWifiLock(r1)     // Catch: java.lang.Throwable -> L6c
                java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch: java.lang.Throwable -> L6c
                r1 = r0
                java.lang.String r2 = "Exceeded maximum number of wifi locks"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L6c
                throw r0     // Catch: java.lang.Throwable -> L6c
            L6c:
                r11 = move-exception
                r0 = r10
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L6c
                r0 = r11
                throw r0     // Catch: android.os.RemoteException -> L74 java.lang.Throwable -> L98
            L74:
                r10 = move-exception
            L76:
                r0 = r6
                r1 = 1
                r0.mHeld = r1     // Catch: java.lang.Throwable -> L98
            L7b:
                r0 = r9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L98
                return
            L7e:
                r0 = r6
                boolean r0 = r0.mHeld     // Catch: java.lang.Throwable -> L98
                r8 = r0
                r0 = r8
                if (r0 != 0) goto L7b
                goto L1f
            L8a:
                r0 = r6
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L6c
                int r0 = android.net.wifi.WifiManager.access$508(r0)     // Catch: java.lang.Throwable -> L6c
                r0 = r10
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L6c
                goto L76
            L98:
                r10 = move-exception
                r0 = r9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L98
                r0 = r10
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.net.wifi.WifiManager.WifiLock.acquire():void");
        }

        protected void finalize() throws Throwable {
            super.finalize();
            synchronized (this.mBinder) {
                if (this.mHeld) {
                    try {
                        WifiManager.this.mService.releaseWifiLock(this.mBinder);
                        synchronized (WifiManager.this) {
                            WifiManager.access$510(WifiManager.this);
                        }
                    } catch (RemoteException e) {
                    }
                }
            }
        }

        public boolean isHeld() {
            boolean z;
            synchronized (this.mBinder) {
                z = this.mHeld;
            }
            return z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
            android.net.wifi.WifiManager.access$510(r5.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
            if (r5.mHeld != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
            if (r0 == 0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
            r5.this$0.mService.releaseWifiLock(r5.mBinder);
            r0 = r5.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004f A[Catch: all -> 0x006d, TryCatch #2 {, blocks: (B:4:0x0007, B:6:0x000e, B:8:0x001e, B:9:0x0037, B:14:0x0044, B:32:0x0087, B:16:0x0049, B:18:0x004f, B:19:0x006c, B:36:0x008e, B:25:0x0074), top: B:42:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void release() {
            /*
                r5 = this;
                r0 = r5
                android.os.IBinder r0 = r0.mBinder
                r8 = r0
                r0 = r8
                monitor-enter(r0)
                r0 = r5
                boolean r0 = r0.mRefCounted     // Catch: java.lang.Throwable -> L6d
                if (r0 == 0) goto L74
                r0 = r5
                int r0 = r0.mRefCount     // Catch: java.lang.Throwable -> L6d
                r1 = 1
                int r0 = r0 - r1
                r6 = r0
                r0 = r5
                r1 = r6
                r0.mRefCount = r1     // Catch: java.lang.Throwable -> L6d
                r0 = r6
                if (r0 != 0) goto L48
            L1e:
                r0 = r5
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L6d android.os.RemoteException -> L88
                android.net.wifi.IWifiManager r0 = r0.mService     // Catch: java.lang.Throwable -> L6d android.os.RemoteException -> L88
                r1 = r5
                android.os.IBinder r1 = r1.mBinder     // Catch: java.lang.Throwable -> L6d android.os.RemoteException -> L88
                boolean r0 = r0.releaseWifiLock(r1)     // Catch: java.lang.Throwable -> L6d android.os.RemoteException -> L88
                r0 = r5
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L6d android.os.RemoteException -> L88
                r9 = r0
                r0 = r9
                monitor-enter(r0)     // Catch: java.lang.Throwable -> L6d android.os.RemoteException -> L88
                r0 = r5
                android.net.wifi.WifiManager r0 = android.net.wifi.WifiManager.this     // Catch: java.lang.Throwable -> L80
                int r0 = android.net.wifi.WifiManager.access$510(r0)     // Catch: java.lang.Throwable -> L80
                r0 = r9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
            L43:
                r0 = r5
                r1 = 0
                r0.mHeld = r1     // Catch: java.lang.Throwable -> L6d
            L48:
                r0 = r5
                int r0 = r0.mRefCount     // Catch: java.lang.Throwable -> L6d
                if (r0 >= 0) goto L8d
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L6d
                r1 = r0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
                r3 = r2
                r3.<init>()     // Catch: java.lang.Throwable -> L6d
                java.lang.String r3 = "WifiLock under-locked "
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L6d
                r3 = r5
                java.lang.String r3 = r3.mTag     // Catch: java.lang.Throwable -> L6d
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L6d
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6d
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L6d
                throw r0     // Catch: java.lang.Throwable -> L6d
            L6d:
                r9 = move-exception
                r0 = r8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
                r0 = r9
                throw r0
            L74:
                r0 = r5
                boolean r0 = r0.mHeld     // Catch: java.lang.Throwable -> L6d
                r7 = r0
                r0 = r7
                if (r0 == 0) goto L48
                goto L1e
            L80:
                r10 = move-exception
                r0 = r9
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
                r0 = r10
                throw r0     // Catch: java.lang.Throwable -> L6d android.os.RemoteException -> L88
            L88:
                r9 = move-exception
                goto L43
            L8d:
                r0 = r8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.net.wifi.WifiManager.WifiLock.release():void");
        }

        public void setReferenceCounted(boolean z) {
            this.mRefCounted = z;
        }

        public void setWorkSource(WorkSource workSource) {
            synchronized (this.mBinder) {
                WorkSource workSource2 = workSource;
                if (workSource != null) {
                    workSource2 = workSource;
                    if (workSource.size() == 0) {
                        workSource2 = null;
                    }
                }
                boolean z = true;
                if (workSource2 == null) {
                    this.mWorkSource = null;
                } else {
                    workSource2.clearNames();
                    if (this.mWorkSource == null) {
                        z = this.mWorkSource != null;
                        this.mWorkSource = new WorkSource(workSource2);
                    } else {
                        boolean diff = this.mWorkSource.diff(workSource2);
                        z = diff;
                        if (diff) {
                            this.mWorkSource.set(workSource2);
                            z = diff;
                        }
                    }
                }
                if (z && this.mHeld) {
                    try {
                        WifiManager.this.mService.updateWifiLockWorkSource(this.mBinder, this.mWorkSource);
                    } catch (RemoteException e) {
                    }
                }
            }
        }

        public String toString() {
            String str;
            synchronized (this.mBinder) {
                str = "WifiLock{ " + Integer.toHexString(System.identityHashCode(this)) + "; " + (this.mHeld ? "held; " : "") + (this.mRefCounted ? "refcounted: refcount = " + this.mRefCount : "not refcounted") + " }";
            }
            return str;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiManager$WpsCallback.class */
    public static abstract class WpsCallback {
        public abstract void onFailed(int i);

        public abstract void onStarted(String str);

        public abstract void onSucceeded();
    }

    public WifiManager(Context context, IWifiManager iWifiManager) {
        this.mContext = context;
        this.mService = iWifiManager;
        init();
        this.mAppOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
    }

    static /* synthetic */ int access$508(WifiManager wifiManager) {
        int i = wifiManager.mActiveLockCount;
        wifiManager.mActiveLockCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$510(WifiManager wifiManager) {
        int i = wifiManager.mActiveLockCount;
        wifiManager.mActiveLockCount = i - 1;
        return i;
    }

    private int addOrUpdateNetwork(WifiConfiguration wifiConfiguration) {
        try {
            return this.mService.addOrUpdateNetwork(wifiConfiguration);
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int calculateSignalLevel(int i, int i2) {
        if (i <= -100) {
            return 0;
        }
        if (i >= -55) {
            return i2 - 1;
        }
        return (int) (((i + 100) * (i2 - 1)) / 45.0f);
    }

    public static int compareSignalLevel(int i, int i2) {
        return i - i2;
    }

    private int getSupportedFeatures() {
        try {
            return this.mService.getSupportedFeatures();
        } catch (RemoteException e) {
            return 0;
        }
    }

    private void init() {
        synchronized (sThreadRefLock) {
            int i = sThreadRefCount + 1;
            sThreadRefCount = i;
            if (i == 1) {
                Messenger wifiServiceMessenger = getWifiServiceMessenger();
                if (wifiServiceMessenger == null) {
                    sAsyncChannel = null;
                    return;
                }
                sHandlerThread = new HandlerThread(TAG);
                sAsyncChannel = new AsyncChannel();
                sConnected = new CountDownLatch(1);
                sHandlerThread.start();
                sAsyncChannel.connect(this.mContext, new ServiceHandler(sHandlerThread.getLooper()), wifiServiceMessenger);
                try {
                    sConnected.await();
                } catch (InterruptedException e) {
                    Log.e(TAG, "interrupted wait at init");
                }
            }
        }
    }

    private boolean isFeatureSupported(int i) {
        return (getSupportedFeatures() & i) == i;
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

    public int addNetwork(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null) {
            return -1;
        }
        wifiConfiguration.networkId = -1;
        return addOrUpdateNetwork(wifiConfiguration);
    }

    public boolean addToBlacklist(String str) {
        try {
            this.mService.addToBlacklist(str);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public void cancelWps(WpsCallback wpsCallback) {
        validateChannel();
        sAsyncChannel.sendMessage(CANCEL_WPS, 0, putListener(wpsCallback));
    }

    public boolean clearBlacklist() {
        try {
            this.mService.clearBlacklist();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public void connect(int i, ActionListener actionListener) {
        if (i < 0) {
            throw new IllegalArgumentException("Network id cannot be negative");
        }
        validateChannel();
        sAsyncChannel.sendMessage(CONNECT_NETWORK, i, putListener(actionListener));
    }

    public void connect(WifiConfiguration wifiConfiguration, ActionListener actionListener) {
        if (wifiConfiguration == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        validateChannel();
        sAsyncChannel.sendMessage(CONNECT_NETWORK, -1, putListener(actionListener), wifiConfiguration);
    }

    public MulticastLock createMulticastLock(String str) {
        return new MulticastLock(str);
    }

    public WifiLock createWifiLock(int i, String str) {
        return new WifiLock(i, str);
    }

    public WifiLock createWifiLock(String str) {
        return new WifiLock(1, str);
    }

    public void disable(int i, ActionListener actionListener) {
        if (i < 0) {
            throw new IllegalArgumentException("Network id cannot be negative");
        }
        validateChannel();
        sAsyncChannel.sendMessage(DISABLE_NETWORK, i, putListener(actionListener));
    }

    public void disableEphemeralNetwork(String str) {
        if (str == null) {
            throw new IllegalArgumentException("SSID cannot be null");
        }
        try {
            this.mService.disableEphemeralNetwork(str);
        } catch (RemoteException e) {
        }
    }

    public boolean disableNetwork(int i) {
        try {
            return this.mService.disableNetwork(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean disconnect() {
        try {
            this.mService.disconnect();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public void enableAggressiveHandover(int i) {
        try {
            this.mService.enableAggressiveHandover(i);
        } catch (RemoteException e) {
        }
    }

    public boolean enableNetwork(int i, boolean z) {
        try {
            return this.mService.enableNetwork(i, z);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void enableVerboseLogging(int i) {
        try {
            this.mService.enableVerboseLogging(i);
        } catch (Exception e) {
            Log.e(TAG, "enableVerboseLogging " + e.toString());
        }
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (sThreadRefLock) {
                int i = sThreadRefCount - 1;
                sThreadRefCount = i;
                if (i == 0 && sAsyncChannel != null) {
                    sAsyncChannel.disconnect();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public void forget(int i, ActionListener actionListener) {
        if (i < 0) {
            throw new IllegalArgumentException("Network id cannot be negative");
        }
        validateChannel();
        sAsyncChannel.sendMessage(FORGET_NETWORK, i, putListener(actionListener));
    }

    public int getAggressiveHandover() {
        try {
            return this.mService.getAggressiveHandover();
        } catch (RemoteException e) {
            return 0;
        }
    }

    public int getAllowScansWithTraffic() {
        try {
            return this.mService.getAllowScansWithTraffic();
        } catch (RemoteException e) {
            return 0;
        }
    }

    public List<BatchedScanResult> getBatchedScanResults() {
        try {
            return this.mService.getBatchedScanResults(this.mContext.getOpPackageName());
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<WifiChannel> getChannelList() {
        try {
            return this.mService.getChannelList();
        } catch (RemoteException e) {
            return null;
        }
    }

    public String getConfigFile() {
        try {
            return this.mService.getConfigFile();
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<WifiConfiguration> getConfiguredNetworks() {
        try {
            return this.mService.getConfiguredNetworks();
        } catch (RemoteException e) {
            return null;
        }
    }

    public WifiInfo getConnectionInfo() {
        try {
            return this.mService.getConnectionInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public WifiConnectionStatistics getConnectionStatistics() {
        try {
            return this.mService.getConnectionStatistics();
        } catch (RemoteException e) {
            return null;
        }
    }

    public WifiActivityEnergyInfo getControllerActivityEnergyInfo(int i) {
        if (this.mService == null) {
            return null;
        }
        try {
            if (isEnhancedPowerReportingSupported()) {
                synchronized (this) {
                    WifiActivityEnergyInfo reportActivityInfo = this.mService.reportActivityInfo();
                    if (reportActivityInfo.isValid()) {
                        return reportActivityInfo;
                    }
                    return null;
                }
            }
            return null;
        } catch (RemoteException e) {
            Log.e(TAG, "getControllerActivityEnergyInfo: " + e);
            return null;
        }
    }

    public String getCountryCode() {
        try {
            return this.mService.getCountryCode();
        } catch (RemoteException e) {
            return null;
        }
    }

    public DhcpInfo getDhcpInfo() {
        try {
            return this.mService.getDhcpInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getFrequencyBand() {
        try {
            return this.mService.getFrequencyBand();
        } catch (RemoteException e) {
            return -1;
        }
    }

    public List<WifiConfiguration> getPrivilegedConfiguredNetworks() {
        try {
            return this.mService.getPrivilegedConfiguredNetworks();
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<ScanResult> getScanResults() {
        try {
            return this.mService.getScanResults(this.mContext.getOpPackageName());
        } catch (RemoteException e) {
            return null;
        }
    }

    public WifiEapSimInfo getSimInfo() {
        try {
            return this.mService.getSimInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public void getTxPacketCount(TxPacketCountListener txPacketCountListener) {
        validateChannel();
        sAsyncChannel.sendMessage(RSSI_PKTCNT_FETCH, 0, putListener(txPacketCountListener));
    }

    public int getVerboseLoggingLevel() {
        try {
            return this.mService.getVerboseLoggingLevel();
        } catch (RemoteException e) {
            return 0;
        }
    }

    public WifiConfiguration getWifiApConfiguration() {
        try {
            return this.mService.getWifiApConfiguration();
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getWifiApState() {
        try {
            return this.mService.getWifiApEnabledState();
        } catch (RemoteException e) {
            return 14;
        }
    }

    public Messenger getWifiServiceMessenger() {
        try {
            return this.mService.getWifiServiceMessenger();
        } catch (RemoteException e) {
            return null;
        } catch (SecurityException e2) {
            return null;
        }
    }

    public int getWifiState() {
        try {
            return this.mService.getWifiEnabledState();
        } catch (RemoteException e) {
            return 4;
        }
    }

    public String getWpsNfcConfigurationToken(int i) {
        try {
            return this.mService.getWpsNfcConfigurationToken(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean initializeMulticastFiltering() {
        try {
            this.mService.initializeMulticastFiltering();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean is5GHzBandSupported() {
        return isFeatureSupported(2);
    }

    public boolean isAdditionalStaSupported() {
        return isFeatureSupported(2048);
    }

    public boolean isBatchedScanSupported() {
        try {
            return this.mService.isBatchedScanSupported();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isDeviceToApRttSupported() {
        return isFeatureSupported(256);
    }

    public boolean isDeviceToDeviceRttSupported() {
        return isFeatureSupported(128);
    }

    public boolean isDualBandSupported() {
        try {
            return this.mService.isDualBandSupported();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isEnhancedPowerReportingSupported() {
        return isFeatureSupported(16384);
    }

    public boolean isIbssSupported() {
        try {
            return this.mService.isIbssSupported();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isMulticastEnabled() {
        try {
            return this.mService.isMulticastEnabled();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isNanSupported() {
        return isFeatureSupported(64);
    }

    public boolean isOffChannelTdlsSupported() {
        return isFeatureSupported(8192);
    }

    public boolean isP2pSupported() {
        return isFeatureSupported(8);
    }

    public boolean isPasspointSupported() {
        return isFeatureSupported(4);
    }

    public boolean isPortableHotspotSupported() {
        return isFeatureSupported(16);
    }

    public boolean isPreferredNetworkOffloadSupported() {
        return isFeatureSupported(1024);
    }

    public boolean isScanAlwaysAvailable() {
        try {
            return this.mService.isScanAlwaysAvailable();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isTdlsSupported() {
        return isFeatureSupported(4096);
    }

    public boolean isWifiApEnabled() {
        return getWifiApState() == 13;
    }

    public boolean isWifiEnabled() {
        return getWifiState() == 3;
    }

    public boolean isWifiScannerSupported() {
        return isFeatureSupported(32);
    }

    public boolean pingSupplicant() {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.pingSupplicant();
        } catch (RemoteException e) {
            return false;
        }
    }

    public void pollBatchedScan() {
        try {
            this.mService.pollBatchedScan();
        } catch (RemoteException e) {
        }
    }

    public boolean reassociate() {
        try {
            this.mService.reassociate();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean reconnect() {
        try {
            this.mService.reconnect();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean removeNetwork(int i) {
        try {
            return this.mService.removeNetwork(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean requestBatchedScan(BatchedScanSettings batchedScanSettings) {
        try {
            return this.mService.requestBatchedScan(batchedScanSettings, new Binder(), null);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean requestBatchedScan(BatchedScanSettings batchedScanSettings, WorkSource workSource) {
        try {
            return this.mService.requestBatchedScan(batchedScanSettings, new Binder(), workSource);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void save(WifiConfiguration wifiConfiguration, ActionListener actionListener) {
        if (wifiConfiguration == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        validateChannel();
        sAsyncChannel.sendMessage(SAVE_NETWORK, 0, putListener(actionListener), wifiConfiguration);
    }

    public boolean saveConfiguration() {
        try {
            return this.mService.saveConfiguration();
        } catch (RemoteException e) {
            return false;
        }
    }

    public void setAllowScansWithTraffic(int i) {
        try {
            this.mService.setAllowScansWithTraffic(i);
        } catch (RemoteException e) {
        }
    }

    public void setCountryCode(String str, boolean z) {
        try {
            this.mService.setCountryCode(str, z);
        } catch (RemoteException e) {
        }
    }

    public void setFrequencyBand(int i, boolean z) {
        try {
            this.mService.setFrequencyBand(i, z);
        } catch (RemoteException e) {
        }
    }

    public void setTdlsEnabled(InetAddress inetAddress, boolean z) {
        try {
            this.mService.enableTdls(inetAddress.getHostAddress(), z);
        } catch (RemoteException e) {
        }
    }

    public void setTdlsEnabledWithMacAddress(String str, boolean z) {
        try {
            this.mService.enableTdlsWithMacAddress(str, z);
        } catch (RemoteException e) {
        }
    }

    public boolean setWifiApConfiguration(WifiConfiguration wifiConfiguration) {
        try {
            this.mService.setWifiApConfiguration(wifiConfiguration);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean setWifiApEnabled(WifiConfiguration wifiConfiguration, boolean z) {
        try {
            this.mService.setWifiApEnabled(wifiConfiguration, z);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean setWifiEnabled(boolean z) {
        if (this.mAppOps.noteOp(48) != 0) {
            return false;
        }
        try {
            return this.mService.setWifiEnabled(z);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean startCustomizedScan(ScanSettings scanSettings) {
        try {
            this.mService.startScan(scanSettings, null);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean startCustomizedScan(ScanSettings scanSettings, WorkSource workSource) {
        try {
            this.mService.startScan(scanSettings, workSource);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean startLocationRestrictedScan(WorkSource workSource) {
        try {
            this.mService.startLocationRestrictedScan(workSource);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean startScan() {
        try {
            this.mService.startScan(null, null);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean startScan(WorkSource workSource) {
        try {
            this.mService.startScan(null, workSource);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean startWifi() {
        try {
            this.mService.startWifi();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public void startWps(WpsInfo wpsInfo, WpsCallback wpsCallback) {
        if (wpsInfo == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        validateChannel();
        sAsyncChannel.sendMessage(START_WPS, 0, putListener(wpsCallback), wpsInfo);
    }

    public void stopBatchedScan(BatchedScanSettings batchedScanSettings) {
        try {
            this.mService.stopBatchedScan(batchedScanSettings);
        } catch (RemoteException e) {
        }
    }

    public boolean stopWifi() {
        try {
            this.mService.stopWifi();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public int updateNetwork(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null || wifiConfiguration.networkId < 0) {
            return -1;
        }
        return addOrUpdateNetwork(wifiConfiguration);
    }
}
