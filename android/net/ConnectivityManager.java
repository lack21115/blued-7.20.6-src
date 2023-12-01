package android.net;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.net.wifi.WifiDevice;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.INetworkActivityListener;
import android.os.INetworkManagementService;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.SubscriptionManager;
import android.util.ArrayMap;
import android.util.Log;
import com.android.internal.telephony.ITelephony;
import com.android.internal.util.Preconditions;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import libcore.net.event.NetworkEventDispatcher;

/* loaded from: source-9557208-dex2jar.jar:android/net/ConnectivityManager.class */
public class ConnectivityManager {
    @Deprecated
    public static final String ACTION_BACKGROUND_DATA_SETTING_CHANGED = "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";
    public static final String ACTION_CAPTIVE_PORTAL_TEST_COMPLETED = "android.net.conn.CAPTIVE_PORTAL_TEST_COMPLETED";
    public static final String ACTION_DATA_ACTIVITY_CHANGE = "android.net.conn.DATA_ACTIVITY_CHANGE";
    public static final String ACTION_TETHER_STATE_CHANGED = "android.net.conn.TETHER_STATE_CHANGED";
    private static final int BASE = 524288;
    public static final int CALLBACK_AVAILABLE = 524290;
    public static final int CALLBACK_CAP_CHANGED = 524294;
    public static final int CALLBACK_EXIT = 524297;
    public static final int CALLBACK_IP_CHANGED = 524295;
    public static final int CALLBACK_LOSING = 524291;
    public static final int CALLBACK_LOST = 524292;
    public static final int CALLBACK_PRECHECK = 524289;
    public static final int CALLBACK_RELEASED = 524296;
    public static final int CALLBACK_UNAVAIL = 524293;
    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String CONNECTIVITY_ACTION_IMMEDIATE = "android.net.conn.CONNECTIVITY_CHANGE_IMMEDIATE";
    @Deprecated
    public static final int DEFAULT_NETWORK_PREFERENCE = 1;
    private static final int EXPIRE_LEGACY_REQUEST = 524298;
    public static final String EXTRA_ACTIVE_TETHER = "activeArray";
    public static final String EXTRA_AVAILABLE_TETHER = "availableArray";
    public static final String EXTRA_DEVICE_TYPE = "deviceType";
    public static final String EXTRA_ERRORED_TETHER = "erroredArray";
    public static final String EXTRA_EXTRA_INFO = "extraInfo";
    public static final String EXTRA_INET_CONDITION = "inetCondition";
    public static final String EXTRA_IS_ACTIVE = "isActive";
    public static final String EXTRA_IS_CAPTIVE_PORTAL = "captivePortal";
    public static final String EXTRA_IS_FAILOVER = "isFailover";
    public static final String EXTRA_NETWORK = "android.net.extra.NETWORK";
    @Deprecated
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_NETWORK_REQUEST = "android.net.extra.NETWORK_REQUEST";
    public static final String EXTRA_NETWORK_TYPE = "networkType";
    public static final String EXTRA_NO_CONNECTIVITY = "noConnectivity";
    public static final String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";
    public static final String EXTRA_REALTIME_NS = "tsNanos";
    public static final String EXTRA_REASON = "reason";
    public static final String INET_CONDITION_ACTION = "android.net.conn.INET_CONDITION_ACTION";
    private static final boolean LEGACY_DBG = true;
    private static final int LISTEN = 1;
    public static final int MAX_NETWORK_REQUEST_TIMEOUT_MS = 6000000;
    public static final int MAX_NETWORK_TYPE = 17;
    public static final int MAX_RADIO_TYPE = 17;
    public static final int NETID_UNSET = 0;
    private static final int REQUEST = 2;
    public static final int REQUEST_ID_UNSET = 0;
    private static final String TAG = "ConnectivityManager";
    public static final String TETHER_CONNECT_STATE_CHANGED = "android.net.conn.TETHER_CONNECT_STATE_CHANGED";
    public static final int TETHER_ERROR_DISABLE_NAT_ERROR = 9;
    public static final int TETHER_ERROR_ENABLE_NAT_ERROR = 8;
    public static final int TETHER_ERROR_IFACE_CFG_ERROR = 10;
    public static final int TETHER_ERROR_MASTER_ERROR = 5;
    public static final int TETHER_ERROR_NO_ERROR = 0;
    public static final int TETHER_ERROR_SERVICE_UNAVAIL = 2;
    public static final int TETHER_ERROR_TETHER_IFACE_ERROR = 6;
    public static final int TETHER_ERROR_UNAVAIL_IFACE = 4;
    public static final int TETHER_ERROR_UNKNOWN_IFACE = 1;
    public static final int TETHER_ERROR_UNSUPPORTED = 3;
    public static final int TETHER_ERROR_UNTETHER_IFACE_ERROR = 7;
    public static final int TYPE_BLUETOOTH = 7;
    public static final int TYPE_DUMMY = 8;
    public static final int TYPE_ETHERNET = 9;
    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_MOBILE_CBS = 12;
    public static final int TYPE_MOBILE_DUN = 4;
    public static final int TYPE_MOBILE_EMERGENCY = 15;
    public static final int TYPE_MOBILE_FOTA = 10;
    public static final int TYPE_MOBILE_HIPRI = 5;
    public static final int TYPE_MOBILE_IA = 14;
    public static final int TYPE_MOBILE_IMS = 11;
    public static final int TYPE_MOBILE_MMS = 2;
    public static final int TYPE_MOBILE_SUPL = 3;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_PROXY = 16;
    public static final int TYPE_VPN = 17;
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_WIFI_P2P = 13;
    public static final int TYPE_WIMAX = 6;
    private static ConnectivityManager sInstance;
    private INetworkManagementService mNMService;
    private final ArrayMap<OnNetworkActiveListener, INetworkActivityListener> mNetworkActivityListeners = new ArrayMap<>();
    private final IConnectivityManager mService;
    private static HashMap<NetworkCapabilities, LegacyRequest> sLegacyRequests = new HashMap<>();
    static final HashMap<NetworkRequest, NetworkCallback> sNetworkCallback = new HashMap<>();
    static final AtomicInteger sCallbackRefCount = new AtomicInteger(0);
    static CallbackHandler sCallbackHandler = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/ConnectivityManager$CallbackHandler.class */
    public class CallbackHandler extends Handler {
        private static final String TAG = "ConnectivityManager.CallbackHandler";
        private final HashMap<NetworkRequest, NetworkCallback> mCallbackMap;
        private final ConnectivityManager mCm;
        private final AtomicInteger mRefCount;

        CallbackHandler(Looper looper, HashMap<NetworkRequest, NetworkCallback> hashMap, AtomicInteger atomicInteger, ConnectivityManager connectivityManager) {
            super(looper);
            this.mCallbackMap = hashMap;
            this.mRefCount = atomicInteger;
            this.mCm = connectivityManager;
        }

        private NetworkCallback getCallbacks(NetworkRequest networkRequest) {
            NetworkCallback networkCallback;
            synchronized (this.mCallbackMap) {
                networkCallback = this.mCallbackMap.get(networkRequest);
            }
            return networkCallback;
        }

        private Object getObject(Message message, Class cls) {
            return message.getData().getParcelable(cls.getSimpleName());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NetworkCallback remove;
            NetworkCallback networkCallback;
            Log.d(TAG, "CM callback handler got msg " + message.what);
            switch (message.what) {
                case ConnectivityManager.CALLBACK_PRECHECK /* 524289 */:
                    NetworkCallback callbacks = getCallbacks((NetworkRequest) getObject(message, NetworkRequest.class));
                    if (callbacks != null) {
                        callbacks.onPreCheck((Network) getObject(message, Network.class));
                        return;
                    } else {
                        Log.e(TAG, "callback not found for PRECHECK message");
                        return;
                    }
                case ConnectivityManager.CALLBACK_AVAILABLE /* 524290 */:
                    NetworkCallback callbacks2 = getCallbacks((NetworkRequest) getObject(message, NetworkRequest.class));
                    if (callbacks2 != null) {
                        callbacks2.onAvailable((Network) getObject(message, Network.class));
                        return;
                    } else {
                        Log.e(TAG, "callback not found for AVAILABLE message");
                        return;
                    }
                case ConnectivityManager.CALLBACK_LOSING /* 524291 */:
                    NetworkCallback callbacks3 = getCallbacks((NetworkRequest) getObject(message, NetworkRequest.class));
                    if (callbacks3 != null) {
                        callbacks3.onLosing((Network) getObject(message, Network.class), message.arg1);
                        return;
                    } else {
                        Log.e(TAG, "callback not found for LOSING message");
                        return;
                    }
                case ConnectivityManager.CALLBACK_LOST /* 524292 */:
                    NetworkCallback callbacks4 = getCallbacks((NetworkRequest) getObject(message, NetworkRequest.class));
                    if (callbacks4 != null) {
                        callbacks4.onLost((Network) getObject(message, Network.class));
                        return;
                    } else {
                        Log.e(TAG, "callback not found for LOST message");
                        return;
                    }
                case ConnectivityManager.CALLBACK_UNAVAIL /* 524293 */:
                    NetworkRequest networkRequest = (NetworkRequest) getObject(message, NetworkRequest.class);
                    synchronized (this.mCallbackMap) {
                        networkCallback = this.mCallbackMap.get(networkRequest);
                    }
                    if (networkCallback != null) {
                        networkCallback.onUnavailable();
                        return;
                    } else {
                        Log.e(TAG, "callback not found for UNAVAIL message");
                        return;
                    }
                case ConnectivityManager.CALLBACK_CAP_CHANGED /* 524294 */:
                    NetworkCallback callbacks5 = getCallbacks((NetworkRequest) getObject(message, NetworkRequest.class));
                    if (callbacks5 != null) {
                        callbacks5.onCapabilitiesChanged((Network) getObject(message, Network.class), (NetworkCapabilities) getObject(message, NetworkCapabilities.class));
                        return;
                    } else {
                        Log.e(TAG, "callback not found for CAP_CHANGED message");
                        return;
                    }
                case ConnectivityManager.CALLBACK_IP_CHANGED /* 524295 */:
                    NetworkCallback callbacks6 = getCallbacks((NetworkRequest) getObject(message, NetworkRequest.class));
                    if (callbacks6 != null) {
                        callbacks6.onLinkPropertiesChanged((Network) getObject(message, Network.class), (LinkProperties) getObject(message, LinkProperties.class));
                        return;
                    } else {
                        Log.e(TAG, "callback not found for IP_CHANGED message");
                        return;
                    }
                case ConnectivityManager.CALLBACK_RELEASED /* 524296 */:
                    NetworkRequest networkRequest2 = (NetworkRequest) getObject(message, NetworkRequest.class);
                    synchronized (this.mCallbackMap) {
                        remove = this.mCallbackMap.remove(networkRequest2);
                    }
                    if (remove == null) {
                        Log.e(TAG, "callback not found for CANCELED message");
                        return;
                    }
                    synchronized (this.mRefCount) {
                        if (this.mRefCount.decrementAndGet() == 0) {
                            getLooper().quit();
                        }
                    }
                    return;
                case ConnectivityManager.CALLBACK_EXIT /* 524297 */:
                    Log.d(TAG, "Listener quiting");
                    getLooper().quit();
                    return;
                case ConnectivityManager.EXPIRE_LEGACY_REQUEST /* 524298 */:
                    ConnectivityManager.this.expireRequest((NetworkCapabilities) message.obj, message.arg1);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/ConnectivityManager$LegacyRequest.class */
    public static class LegacyRequest {
        Network currentNetwork;
        int delay;
        int expireSequenceNumber;
        NetworkCallback networkCallback;
        NetworkCapabilities networkCapabilities;
        NetworkRequest networkRequest;

        private LegacyRequest() {
            this.delay = -1;
            this.networkCallback = new NetworkCallback() { // from class: android.net.ConnectivityManager.LegacyRequest.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    LegacyRequest.this.currentNetwork = network;
                    Log.d(ConnectivityManager.TAG, "startUsingNetworkFeature got Network:" + network);
                    ConnectivityManager.setProcessDefaultNetworkForHostResolution(network);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    if (network.equals(LegacyRequest.this.currentNetwork)) {
                        LegacyRequest.this.clearDnsBinding();
                    }
                    Log.d(ConnectivityManager.TAG, "startUsingNetworkFeature lost Network:" + network);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDnsBinding() {
            if (this.currentNetwork != null) {
                this.currentNetwork = null;
                ConnectivityManager.setProcessDefaultNetworkForHostResolution(null);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/ConnectivityManager$NetworkCallback.class */
    public static class NetworkCallback {
        public static final int AVAILABLE = 2;
        public static final int CANCELED = 8;
        public static final int CAP_CHANGED = 6;
        public static final int LOSING = 3;
        public static final int LOST = 4;
        public static final int PRECHECK = 1;
        public static final int PROP_CHANGED = 7;
        public static final int UNAVAIL = 5;
        private NetworkRequest networkRequest;

        public void onAvailable(Network network) {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        }

        public void onLosing(Network network, int i) {
        }

        public void onLost(Network network) {
        }

        public void onPreCheck(Network network) {
        }

        public void onUnavailable() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/ConnectivityManager$OnNetworkActiveListener.class */
    public interface OnNetworkActiveListener {
        void onNetworkActive();
    }

    public ConnectivityManager(IConnectivityManager iConnectivityManager) {
        this.mService = (IConnectivityManager) Preconditions.checkNotNull(iConnectivityManager, "missing IConnectivityManager");
        sInstance = this;
    }

    private void checkPendingIntent(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            throw new IllegalArgumentException("PendingIntent cannot be null.");
        }
    }

    private void decCallbackHandlerRefCount() {
        synchronized (sCallbackRefCount) {
            if (sCallbackRefCount.decrementAndGet() == 0) {
                sCallbackHandler.obtainMessage(CALLBACK_EXIT).sendToTarget();
                sCallbackHandler = null;
            }
        }
    }

    public static final void enforceTetherChangePermission(Context context) {
        if (context.getResources().getStringArray(17236000).length == 2) {
            context.enforceCallingOrSelfPermission(Manifest.permission.CONNECTIVITY_INTERNAL, "ConnectivityService");
        } else {
            context.enforceCallingOrSelfPermission(Manifest.permission.CHANGE_NETWORK_STATE, "ConnectivityService");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expireRequest(NetworkCapabilities networkCapabilities, int i) {
        synchronized (sLegacyRequests) {
            LegacyRequest legacyRequest = sLegacyRequests.get(networkCapabilities);
            if (legacyRequest == null) {
                return;
            }
            int i2 = legacyRequest.expireSequenceNumber;
            if (legacyRequest.expireSequenceNumber == i) {
                removeRequestForFeature(networkCapabilities);
            }
            Log.d(TAG, "expireRequest with " + i2 + ", " + i);
        }
    }

    private NetworkRequest findRequestForFeature(NetworkCapabilities networkCapabilities) {
        synchronized (sLegacyRequests) {
            LegacyRequest legacyRequest = sLegacyRequests.get(networkCapabilities);
            if (legacyRequest != null) {
                return legacyRequest.networkRequest;
            }
            return null;
        }
    }

    public static ConnectivityManager from(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static ConnectivityManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException("No ConnectivityManager yet constructed");
        }
        return sInstance;
    }

    private INetworkManagementService getNetworkManagementService() {
        synchronized (this) {
            if (this.mNMService != null) {
                return this.mNMService;
            }
            this.mNMService = INetworkManagementService.Stub.asInterface(ServiceManager.getService(Context.NETWORKMANAGEMENT_SERVICE));
            return this.mNMService;
        }
    }

    public static String getNetworkTypeName(int i) {
        switch (i) {
            case 0:
                return "MOBILE";
            case 1:
                return "WIFI";
            case 2:
                return "MOBILE_MMS";
            case 3:
                return "MOBILE_SUPL";
            case 4:
                return "MOBILE_DUN";
            case 5:
                return "MOBILE_HIPRI";
            case 6:
                return "WIMAX";
            case 7:
                return "BLUETOOTH";
            case 8:
                return "DUMMY";
            case 9:
                return "ETHERNET";
            case 10:
                return "MOBILE_FOTA";
            case 11:
                return "MOBILE_IMS";
            case 12:
                return "MOBILE_CBS";
            case 13:
                return "WIFI_P2P";
            case 14:
                return "MOBILE_IA";
            case 15:
                return "MOBILE_EMERGENCY";
            case 16:
                return "PROXY";
            default:
                return Integer.toString(i);
        }
    }

    public static Network getProcessDefaultNetwork() {
        int networkBoundToProcess = NetworkUtils.getNetworkBoundToProcess();
        if (networkBoundToProcess == 0) {
            return null;
        }
        return new Network(networkBoundToProcess);
    }

    private void incCallbackHandlerRefCount() {
        synchronized (sCallbackRefCount) {
            if (sCallbackRefCount.incrementAndGet() == 1) {
                HandlerThread handlerThread = new HandlerThread(TAG);
                handlerThread.start();
                sCallbackHandler = new CallbackHandler(handlerThread.getLooper(), sNetworkCallback, sCallbackRefCount, this);
            }
        }
    }

    private int inferLegacyTypeForNetworkCapabilities(NetworkCapabilities networkCapabilities) {
        int i;
        if (networkCapabilities == null) {
            i = -1;
        } else if (!networkCapabilities.hasTransport(0)) {
            return -1;
        } else {
            String str = null;
            i = -1;
            if (networkCapabilities.hasCapability(5)) {
                str = "enableCBS";
                i = 12;
            } else if (networkCapabilities.hasCapability(4)) {
                str = "enableIMS";
                i = 11;
            } else if (networkCapabilities.hasCapability(3)) {
                str = "enableFOTA";
                i = 10;
            } else if (networkCapabilities.hasCapability(2)) {
                str = "enableDUN";
                i = 4;
            } else if (networkCapabilities.hasCapability(1)) {
                str = "enableSUPL";
                i = 3;
            } else if (networkCapabilities.hasCapability(0)) {
                str = "enableMMS";
                i = 2;
            } else if (networkCapabilities.hasCapability(12)) {
                str = "enableHIPRI";
                i = 5;
            }
            if (str == null) {
                return -1;
            }
            NetworkCapabilities networkCapabilitiesForFeature = networkCapabilitiesForFeature(0, str);
            if (!networkCapabilitiesForFeature.equalsNetCapabilities(networkCapabilities) || !networkCapabilitiesForFeature.equalsTransportTypes(networkCapabilities)) {
                return -1;
            }
        }
        return i;
    }

    public static boolean isNetworkTypeMobile(int i) {
        switch (i) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
                return true;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 13:
            default:
                return false;
        }
    }

    public static boolean isNetworkTypeValid(int i) {
        return i >= 0 && i <= 17;
    }

    public static boolean isNetworkTypeWifi(int i) {
        switch (i) {
            case 1:
            case 13:
                return true;
            default:
                return false;
        }
    }

    private int legacyTypeForNetworkCapabilities(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return -1;
        }
        if (networkCapabilities.hasCapability(5)) {
            return 12;
        }
        if (networkCapabilities.hasCapability(4)) {
            return 11;
        }
        if (networkCapabilities.hasCapability(3)) {
            return 10;
        }
        if (networkCapabilities.hasCapability(2)) {
            return 4;
        }
        if (networkCapabilities.hasCapability(1)) {
            return 3;
        }
        if (networkCapabilities.hasCapability(0)) {
            return 2;
        }
        if (networkCapabilities.hasCapability(12)) {
            return 5;
        }
        return networkCapabilities.hasCapability(6) ? 13 : -1;
    }

    private NetworkCapabilities networkCapabilitiesForFeature(int i, String str) {
        NetworkCapabilities networkCapabilities;
        int i2;
        if (i == 0) {
            if ("enableMMS".equals(str)) {
                i2 = 0;
            } else if ("enableSUPL".equals(str)) {
                i2 = 1;
            } else if ("enableDUN".equals(str) || "enableDUNAlways".equals(str)) {
                i2 = 2;
            } else if ("enableHIPRI".equals(str)) {
                i2 = 12;
            } else if ("enableFOTA".equals(str)) {
                i2 = 3;
            } else if ("enableIMS".equals(str)) {
                i2 = 4;
            } else {
                networkCapabilities = null;
                if ("enableCBS".equals(str)) {
                    i2 = 5;
                }
            }
            networkCapabilities = new NetworkCapabilities();
            networkCapabilities.addTransportType(0).addCapability(i2);
            networkCapabilities.maybeMarkCapabilitiesRestricted();
        } else {
            networkCapabilities = null;
            if (i == 1) {
                networkCapabilities = null;
                if ("p2p".equals(str)) {
                    NetworkCapabilities networkCapabilities2 = new NetworkCapabilities();
                    networkCapabilities2.addTransportType(1);
                    networkCapabilities2.addCapability(6);
                    networkCapabilities2.maybeMarkCapabilitiesRestricted();
                    return networkCapabilities2;
                }
            }
        }
        return networkCapabilities;
    }

    private boolean removeRequestForFeature(NetworkCapabilities networkCapabilities) {
        LegacyRequest remove;
        synchronized (sLegacyRequests) {
            remove = sLegacyRequests.remove(networkCapabilities);
        }
        if (remove == null) {
            return false;
        }
        unregisterNetworkCallback(remove.networkCallback);
        remove.clearDnsBinding();
        return true;
    }

    private void renewRequestLocked(LegacyRequest legacyRequest) {
        legacyRequest.expireSequenceNumber++;
        Log.d(TAG, "renewing request to seqNum " + legacyRequest.expireSequenceNumber);
        sendExpireMsgForFeature(legacyRequest.networkCapabilities, legacyRequest.expireSequenceNumber, legacyRequest.delay);
    }

    private NetworkRequest requestNetworkForFeatureLocked(NetworkCapabilities networkCapabilities) {
        int i = -1;
        int legacyTypeForNetworkCapabilities = legacyTypeForNetworkCapabilities(networkCapabilities);
        try {
            i = this.mService.getRestoreDefaultNetworkDelay(legacyTypeForNetworkCapabilities);
        } catch (RemoteException e) {
        }
        LegacyRequest legacyRequest = new LegacyRequest();
        legacyRequest.networkCapabilities = networkCapabilities;
        legacyRequest.delay = i;
        legacyRequest.expireSequenceNumber = 0;
        legacyRequest.networkRequest = sendRequestForNetwork(networkCapabilities, legacyRequest.networkCallback, 0, 2, legacyTypeForNetworkCapabilities);
        if (legacyRequest.networkRequest == null) {
            return null;
        }
        sLegacyRequests.put(networkCapabilities, legacyRequest);
        sendExpireMsgForFeature(networkCapabilities, legacyRequest.expireSequenceNumber, i);
        return legacyRequest.networkRequest;
    }

    private void sendExpireMsgForFeature(NetworkCapabilities networkCapabilities, int i, int i2) {
        if (i2 >= 0) {
            Log.d(TAG, "sending expire msg with seqNum " + i + " and delay " + i2);
            sCallbackHandler.sendMessageDelayed(sCallbackHandler.obtainMessage(EXPIRE_LEGACY_REQUEST, i, 0, networkCapabilities), i2);
        }
    }

    private NetworkRequest sendRequestForNetwork(NetworkCapabilities networkCapabilities, NetworkCallback networkCallback, int i, int i2, int i3) {
        if (networkCallback == null) {
            throw new IllegalArgumentException("null NetworkCallback");
        }
        if (networkCapabilities == null) {
            throw new IllegalArgumentException("null NetworkCapabilities");
        }
        try {
            incCallbackHandlerRefCount();
            synchronized (sNetworkCallback) {
                if (i2 == 1) {
                    networkCallback.networkRequest = this.mService.listenForNetwork(networkCapabilities, new Messenger(sCallbackHandler), new Binder());
                } else {
                    networkCallback.networkRequest = this.mService.requestNetwork(networkCapabilities, new Messenger(sCallbackHandler), i, new Binder(), i3);
                }
                if (networkCallback.networkRequest != null) {
                    sNetworkCallback.put(networkCallback.networkRequest, networkCallback);
                }
            }
        } catch (RemoteException e) {
        }
        if (networkCallback.networkRequest == null) {
            decCallbackHandlerRefCount();
        }
        return networkCallback.networkRequest;
    }

    public static boolean setProcessDefaultNetwork(Network network) {
        boolean z = false;
        int i = network == null ? 0 : network.netId;
        if (i == NetworkUtils.getNetworkBoundToProcess()) {
            z = true;
        } else if (NetworkUtils.bindProcessToNetwork(i)) {
            Proxy.setHttpProxySystemProperty(getInstance().getDefaultProxy());
            InetAddress.clearDnsCache();
            NetworkEventDispatcher.getInstance().onNetworkConfigurationChanged();
            return true;
        }
        return z;
    }

    public static boolean setProcessDefaultNetworkForHostResolution(Network network) {
        return NetworkUtils.bindProcessToNetworkForHostResolution(network == null ? 0 : network.netId);
    }

    public void addDefaultNetworkActiveListener(final OnNetworkActiveListener onNetworkActiveListener) {
        INetworkActivityListener.Stub stub = new INetworkActivityListener.Stub() { // from class: android.net.ConnectivityManager.1
            @Override // android.os.INetworkActivityListener
            public void onNetworkActive() throws RemoteException {
                onNetworkActiveListener.onNetworkActive();
            }
        };
        try {
            getNetworkManagementService().registerNetworkActivityListener(stub);
            this.mNetworkActivityListeners.put(onNetworkActiveListener, stub);
        } catch (RemoteException e) {
        }
    }

    public void captivePortalCheckCompleted(NetworkInfo networkInfo, boolean z) {
        try {
            this.mService.captivePortalCheckCompleted(networkInfo, z);
        } catch (RemoteException e) {
        }
    }

    public int checkMobileProvisioning(int i) {
        try {
            return this.mService.checkMobileProvisioning(i);
        } catch (RemoteException e) {
            return -1;
        }
    }

    public LinkProperties getActiveLinkProperties() {
        try {
            return this.mService.getActiveLinkProperties();
        } catch (RemoteException e) {
            return null;
        }
    }

    public NetworkInfo getActiveNetworkInfo() {
        try {
            return this.mService.getActiveNetworkInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public NetworkInfo getActiveNetworkInfoForUid(int i) {
        try {
            return this.mService.getActiveNetworkInfoForUid(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    public NetworkQuotaInfo getActiveNetworkQuotaInfo() {
        try {
            return this.mService.getActiveNetworkQuotaInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public NetworkInfo[] getAllNetworkInfo() {
        try {
            return this.mService.getAllNetworkInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public Network[] getAllNetworks() {
        try {
            return this.mService.getAllNetworks();
        } catch (RemoteException e) {
            return null;
        }
    }

    @Deprecated
    public boolean getBackgroundDataSetting() {
        return true;
    }

    public NetworkCapabilities[] getDefaultNetworkCapabilitiesForUser(int i) {
        try {
            return this.mService.getDefaultNetworkCapabilitiesForUser(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    public ProxyInfo getDefaultProxy() {
        Network processDefaultNetwork = getProcessDefaultNetwork();
        if (processDefaultNetwork == null) {
            try {
                return this.mService.getDefaultProxy();
            } catch (RemoteException e) {
                return null;
            }
        }
        ProxyInfo globalProxy = getGlobalProxy();
        if (globalProxy != null) {
            return globalProxy;
        }
        LinkProperties linkProperties = getLinkProperties(processDefaultNetwork);
        if (linkProperties != null) {
            return linkProperties.getHttpProxy();
        }
        return null;
    }

    public ProxyInfo getGlobalProxy() {
        try {
            return this.mService.getGlobalProxy();
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getLastTetherError(String str) {
        try {
            return this.mService.getLastTetherError(str);
        } catch (RemoteException e) {
            return 2;
        }
    }

    public LinkProperties getLinkProperties(int i) {
        try {
            return this.mService.getLinkPropertiesForType(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    public LinkProperties getLinkProperties(Network network) {
        try {
            return this.mService.getLinkProperties(network);
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean getMobileDataEnabled() {
        IBinder service = ServiceManager.getService("phone");
        if (service != null) {
            try {
                ITelephony asInterface = ITelephony.Stub.asInterface(service);
                int defaultDataSubId = SubscriptionManager.getDefaultDataSubId();
                Log.d(TAG, "getMobileDataEnabled()+ subId=" + defaultDataSubId);
                boolean dataEnabled = asInterface.getDataEnabled(defaultDataSubId);
                Log.d(TAG, "getMobileDataEnabled()- subId=" + defaultDataSubId + " retVal=" + dataEnabled);
                return dataEnabled;
            } catch (RemoteException e) {
            }
        }
        Log.d(TAG, "getMobileDataEnabled()- remote exception retVal=false");
        return false;
    }

    public String getMobileProvisioningUrl() {
        try {
            return this.mService.getMobileProvisioningUrl();
        } catch (RemoteException e) {
            return null;
        }
    }

    public String getMobileRedirectedProvisioningUrl() {
        try {
            return this.mService.getMobileRedirectedProvisioningUrl();
        } catch (RemoteException e) {
            return null;
        }
    }

    public NetworkCapabilities getNetworkCapabilities(Network network) {
        try {
            return this.mService.getNetworkCapabilities(network);
        } catch (RemoteException e) {
            return null;
        }
    }

    public Network getNetworkForType(int i) {
        try {
            return this.mService.getNetworkForType(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    public NetworkInfo getNetworkInfo(int i) {
        try {
            return this.mService.getNetworkInfo(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    public NetworkInfo getNetworkInfo(Network network) {
        try {
            return this.mService.getNetworkInfoForNetwork(network);
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getNetworkPreference() {
        return -1;
    }

    public NetworkInfo getProvisioningOrActiveNetworkInfo() {
        try {
            return this.mService.getProvisioningOrActiveNetworkInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    public List<WifiDevice> getTetherConnectedSta() {
        try {
            return this.mService.getTetherConnectedSta();
        } catch (RemoteException e) {
            return null;
        }
    }

    public String[] getTetherableBluetoothRegexs() {
        try {
            return this.mService.getTetherableBluetoothRegexs();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    public String[] getTetherableIfaces() {
        try {
            return this.mService.getTetherableIfaces();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    public String[] getTetherableUsbRegexs() {
        try {
            return this.mService.getTetherableUsbRegexs();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    public String[] getTetherableWifiRegexs() {
        try {
            return this.mService.getTetherableWifiRegexs();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    public String[] getTetheredDhcpRanges() {
        try {
            return this.mService.getTetheredDhcpRanges();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    public String[] getTetheredIfaces() {
        try {
            return this.mService.getTetheredIfaces();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    public String[] getTetheringErroredIfaces() {
        try {
            return this.mService.getTetheringErroredIfaces();
        } catch (RemoteException e) {
            return new String[0];
        }
    }

    public boolean isActiveNetworkMetered() {
        try {
            return this.mService.isActiveNetworkMetered();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isDefaultNetworkActive() {
        try {
            return getNetworkManagementService().isNetworkActive();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isNetworkSupported(int i) {
        try {
            return this.mService.isNetworkSupported(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isTetheringSupported() {
        try {
            return this.mService.isTetheringSupported();
        } catch (RemoteException e) {
            return false;
        }
    }

    public void registerNetworkAgent(Messenger messenger, NetworkInfo networkInfo, LinkProperties linkProperties, NetworkCapabilities networkCapabilities, int i, NetworkMisc networkMisc) {
        try {
            this.mService.registerNetworkAgent(messenger, networkInfo, linkProperties, networkCapabilities, i, networkMisc);
        } catch (RemoteException e) {
        }
    }

    public void registerNetworkCallback(NetworkRequest networkRequest, NetworkCallback networkCallback) {
        sendRequestForNetwork(networkRequest.networkCapabilities, networkCallback, 0, 1, -1);
    }

    public void registerNetworkFactory(Messenger messenger, String str) {
        try {
            this.mService.registerNetworkFactory(messenger, str);
        } catch (RemoteException e) {
        }
    }

    public void releaseNetworkRequest(PendingIntent pendingIntent) {
        checkPendingIntent(pendingIntent);
        try {
            this.mService.releasePendingNetworkRequest(pendingIntent);
        } catch (RemoteException e) {
        }
    }

    public void removeDefaultNetworkActiveListener(OnNetworkActiveListener onNetworkActiveListener) {
        INetworkActivityListener iNetworkActivityListener = this.mNetworkActivityListeners.get(onNetworkActiveListener);
        if (iNetworkActivityListener == null) {
            throw new IllegalArgumentException("Listener not registered: " + onNetworkActiveListener);
        }
        try {
            getNetworkManagementService().unregisterNetworkActivityListener(iNetworkActivityListener);
        } catch (RemoteException e) {
        }
    }

    public void reportBadNetwork(Network network) {
        try {
            this.mService.reportBadNetwork(network);
        } catch (RemoteException e) {
        }
    }

    public void reportInetCondition(int i, int i2) {
        try {
            this.mService.reportInetCondition(i, i2);
        } catch (RemoteException e) {
        }
    }

    public void requestNetwork(NetworkRequest networkRequest, PendingIntent pendingIntent) {
        checkPendingIntent(pendingIntent);
        try {
            this.mService.pendingRequestForNetwork(networkRequest.networkCapabilities, pendingIntent);
        } catch (RemoteException e) {
        }
    }

    public void requestNetwork(NetworkRequest networkRequest, NetworkCallback networkCallback) {
        sendRequestForNetwork(networkRequest.networkCapabilities, networkCallback, 0, 2, inferLegacyTypeForNetworkCapabilities(networkRequest.networkCapabilities));
    }

    public void requestNetwork(NetworkRequest networkRequest, NetworkCallback networkCallback, int i) {
        sendRequestForNetwork(networkRequest.networkCapabilities, networkCallback, i, 2, inferLegacyTypeForNetworkCapabilities(networkRequest.networkCapabilities));
    }

    public boolean requestRouteToHost(int i, int i2) {
        return requestRouteToHostAddress(i, NetworkUtils.intToInetAddress(i2));
    }

    public boolean requestRouteToHostAddress(int i, InetAddress inetAddress) {
        try {
            return this.mService.requestRouteToHostAddress(i, inetAddress.getAddress());
        } catch (RemoteException e) {
            return false;
        }
    }

    public void setAirplaneMode(boolean z) {
        try {
            this.mService.setAirplaneMode(z);
        } catch (RemoteException e) {
        }
    }

    @Deprecated
    public void setBackgroundDataSetting(boolean z) {
    }

    public void setDataDependency(int i, boolean z) {
        try {
            this.mService.setDataDependency(i, z);
        } catch (RemoteException e) {
        }
    }

    public void setGlobalProxy(ProxyInfo proxyInfo) {
        try {
            this.mService.setGlobalProxy(proxyInfo);
        } catch (RemoteException e) {
        }
    }

    public void setNetworkPreference(int i) {
    }

    public void setProvisioningNotificationVisible(boolean z, int i, String str) {
        try {
            this.mService.setProvisioningNotificationVisible(z, i, str);
        } catch (RemoteException e) {
        }
    }

    public int setUsbTethering(boolean z) {
        try {
            return this.mService.setUsbTethering(z);
        } catch (RemoteException e) {
            return 2;
        }
    }

    public int startUsingNetworkFeature(int i, String str) {
        NetworkCapabilities networkCapabilitiesForFeature = networkCapabilitiesForFeature(i, str);
        if (networkCapabilitiesForFeature == null) {
            Log.d(TAG, "Can't satisfy startUsingNetworkFeature for " + i + ", " + str);
            return 3;
        }
        synchronized (sLegacyRequests) {
            LegacyRequest legacyRequest = sLegacyRequests.get(networkCapabilitiesForFeature);
            if (legacyRequest != null) {
                Log.d(TAG, "renewing startUsingNetworkFeature request " + legacyRequest.networkRequest);
                renewRequestLocked(legacyRequest);
                return legacyRequest.currentNetwork != null ? 0 : 1;
            }
            NetworkRequest requestNetworkForFeatureLocked = requestNetworkForFeatureLocked(networkCapabilitiesForFeature);
            if (requestNetworkForFeatureLocked != null) {
                Log.d(TAG, "starting startUsingNetworkFeature for request " + requestNetworkForFeatureLocked);
                return 1;
            }
            Log.d(TAG, " request Failed");
            return 3;
        }
    }

    public int startUsingNetworkFeatureForSubscription(int i, String str, String str2) {
        Log.d(TAG, "startUsingNetworkFeatureForSubscription: for " + i + " feature = " + str + " subId = " + str2);
        NetworkCapabilities networkCapabilitiesForFeature = networkCapabilitiesForFeature(i, str);
        if (networkCapabilitiesForFeature == null) {
            Log.d(TAG, "Can't satisfy startUsingNetworkFeature for " + i + ", " + str);
            return 3;
        }
        networkCapabilitiesForFeature.setNetworkSpecifier(str2);
        synchronized (sLegacyRequests) {
            Log.d(TAG, "Looking for legacyRequest for netCap with hash: " + networkCapabilitiesForFeature + " (" + networkCapabilitiesForFeature.hashCode() + ")");
            Log.d(TAG, "sLegacyRequests has:");
            for (NetworkCapabilities networkCapabilities : sLegacyRequests.keySet()) {
                Log.d(TAG, "  " + networkCapabilities + " (" + networkCapabilities.hashCode() + ")");
            }
            LegacyRequest legacyRequest = sLegacyRequests.get(networkCapabilitiesForFeature);
            if (legacyRequest != null) {
                Log.d(TAG, "renewing startUsingNetworkFeature request " + legacyRequest.networkRequest);
                renewRequestLocked(legacyRequest);
                return legacyRequest.currentNetwork != null ? 0 : 1;
            }
            NetworkRequest requestNetworkForFeatureLocked = requestNetworkForFeatureLocked(networkCapabilitiesForFeature);
            if (requestNetworkForFeatureLocked != null) {
                Log.d(TAG, "starting startUsingNetworkFeature for request " + requestNetworkForFeatureLocked);
                return 1;
            }
            Log.d(TAG, " request Failed");
            return 3;
        }
    }

    public int stopUsingNetworkFeature(int i, String str) {
        NetworkCapabilities networkCapabilitiesForFeature = networkCapabilitiesForFeature(i, str);
        if (networkCapabilitiesForFeature == null) {
            Log.d(TAG, "Can't satisfy stopUsingNetworkFeature for " + i + ", " + str);
            return -1;
        } else if (removeRequestForFeature(networkCapabilitiesForFeature)) {
            Log.d(TAG, "stopUsingNetworkFeature for " + i + ", " + str);
            return 1;
        } else {
            return 1;
        }
    }

    public int stopUsingNetworkFeatureForSubscription(int i, String str, String str2) {
        Log.d(TAG, "stopUsingNetworkFeatureForSubscription: for " + i + " feature = " + str + " subId = " + str2);
        NetworkCapabilities networkCapabilitiesForFeature = networkCapabilitiesForFeature(i, str);
        if (networkCapabilitiesForFeature == null) {
            Log.d(TAG, "Can't satisfy stopUsingNetworkFeature for " + i + ", " + str);
            return -1;
        }
        networkCapabilitiesForFeature.setNetworkSpecifier(str2);
        if (removeRequestForFeature(networkCapabilitiesForFeature)) {
            Log.d(TAG, "stopUsingNetworkFeature for " + i + ", " + str);
            return 1;
        }
        return 1;
    }

    public void supplyMessenger(int i, Messenger messenger) {
        try {
            this.mService.supplyMessenger(i, messenger);
        } catch (RemoteException e) {
        }
    }

    public int tether(String str) {
        try {
            return this.mService.tether(str);
        } catch (RemoteException e) {
            return 2;
        }
    }

    public void unregisterNetworkCallback(NetworkCallback networkCallback) {
        if (networkCallback == null || networkCallback.networkRequest == null || networkCallback.networkRequest.requestId == 0) {
            throw new IllegalArgumentException("Invalid NetworkCallback");
        }
        try {
            this.mService.releaseNetworkRequest(networkCallback.networkRequest);
        } catch (RemoteException e) {
        }
    }

    public void unregisterNetworkFactory(Messenger messenger) {
        try {
            this.mService.unregisterNetworkFactory(messenger);
        } catch (RemoteException e) {
        }
    }

    public int untether(String str) {
        try {
            return this.mService.untether(str);
        } catch (RemoteException e) {
            return 2;
        }
    }

    public boolean updateLockdownVpn() {
        try {
            return this.mService.updateLockdownVpn();
        } catch (RemoteException e) {
            return false;
        }
    }
}
