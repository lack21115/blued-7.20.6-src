package android.net.wifi.p2p;

import android.content.Context;
import android.net.wifi.WpsInfo;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceResponse;
import android.net.wifi.p2p.nsd.WifiP2pServiceInfo;
import android.net.wifi.p2p.nsd.WifiP2pServiceRequest;
import android.net.wifi.p2p.nsd.WifiP2pServiceResponse;
import android.net.wifi.p2p.nsd.WifiP2pUpnpServiceResponse;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.util.AsyncChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager.class */
public class WifiP2pManager {
    public static final int ADD_LOCAL_SERVICE = 139292;
    public static final int ADD_LOCAL_SERVICE_FAILED = 139293;
    public static final int ADD_LOCAL_SERVICE_SUCCEEDED = 139294;
    public static final int ADD_SERVICE_REQUEST = 139301;
    public static final int ADD_SERVICE_REQUEST_FAILED = 139302;
    public static final int ADD_SERVICE_REQUEST_SUCCEEDED = 139303;
    private static final int BASE = 139264;
    public static final int BUSY = 2;
    public static final int CANCEL_CONNECT = 139274;
    public static final int CANCEL_CONNECT_FAILED = 139275;
    public static final int CANCEL_CONNECT_SUCCEEDED = 139276;
    public static final int CLEAR_LOCAL_SERVICES = 139298;
    public static final int CLEAR_LOCAL_SERVICES_FAILED = 139299;
    public static final int CLEAR_LOCAL_SERVICES_SUCCEEDED = 139300;
    public static final int CLEAR_SERVICE_REQUESTS = 139307;
    public static final int CLEAR_SERVICE_REQUESTS_FAILED = 139308;
    public static final int CLEAR_SERVICE_REQUESTS_SUCCEEDED = 139309;
    public static final int CONNECT = 139271;
    public static final int CONNECT_FAILED = 139272;
    public static final int CONNECT_SUCCEEDED = 139273;
    public static final int CREATE_GROUP = 139277;
    public static final int CREATE_GROUP_FAILED = 139278;
    public static final int CREATE_GROUP_SUCCEEDED = 139279;
    public static final int DELETE_PERSISTENT_GROUP = 139318;
    public static final int DELETE_PERSISTENT_GROUP_FAILED = 139319;
    public static final int DELETE_PERSISTENT_GROUP_SUCCEEDED = 139320;
    public static final int DISCOVER_PEERS = 139265;
    public static final int DISCOVER_PEERS_FAILED = 139266;
    public static final int DISCOVER_PEERS_SUCCEEDED = 139267;
    public static final int DISCOVER_SERVICES = 139310;
    public static final int DISCOVER_SERVICES_FAILED = 139311;
    public static final int DISCOVER_SERVICES_SUCCEEDED = 139312;
    public static final int ERROR = 0;
    public static final String EXTRA_DISCOVERY_STATE = "discoveryState";
    public static final String EXTRA_HANDOVER_MESSAGE = "android.net.wifi.p2p.EXTRA_HANDOVER_MESSAGE";
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_P2P_DEVICE_LIST = "wifiP2pDeviceList";
    public static final String EXTRA_WIFI_P2P_DEVICE = "wifiP2pDevice";
    public static final String EXTRA_WIFI_P2P_GROUP = "p2pGroupInfo";
    public static final String EXTRA_WIFI_P2P_INFO = "wifiP2pInfo";
    public static final String EXTRA_WIFI_STATE = "wifi_p2p_state";
    public static final int GET_HANDOVER_REQUEST = 139339;
    public static final int GET_HANDOVER_SELECT = 139340;
    public static final int INITIATOR_REPORT_NFC_HANDOVER = 139342;
    public static final int MIRACAST_DISABLED = 0;
    public static final int MIRACAST_SINK = 2;
    public static final int MIRACAST_SOURCE = 1;
    public static final int NO_SERVICE_REQUESTS = 3;
    public static final int P2P_UNSUPPORTED = 1;
    public static final int PING = 139313;
    public static final int REMOVE_GROUP = 139280;
    public static final int REMOVE_GROUP_FAILED = 139281;
    public static final int REMOVE_GROUP_SUCCEEDED = 139282;
    public static final int REMOVE_LOCAL_SERVICE = 139295;
    public static final int REMOVE_LOCAL_SERVICE_FAILED = 139296;
    public static final int REMOVE_LOCAL_SERVICE_SUCCEEDED = 139297;
    public static final int REMOVE_SERVICE_REQUEST = 139304;
    public static final int REMOVE_SERVICE_REQUEST_FAILED = 139305;
    public static final int REMOVE_SERVICE_REQUEST_SUCCEEDED = 139306;
    public static final int REPORT_NFC_HANDOVER_FAILED = 139345;
    public static final int REPORT_NFC_HANDOVER_SUCCEEDED = 139344;
    public static final int REQUEST_CONNECTION_INFO = 139285;
    public static final int REQUEST_GROUP_INFO = 139287;
    public static final int REQUEST_PEERS = 139283;
    public static final int REQUEST_PERSISTENT_GROUP_INFO = 139321;
    public static final int RESPONDER_REPORT_NFC_HANDOVER = 139343;
    public static final int RESPONSE_CONNECTION_INFO = 139286;
    public static final int RESPONSE_GET_HANDOVER_MESSAGE = 139341;
    public static final int RESPONSE_GROUP_INFO = 139288;
    public static final int RESPONSE_PEERS = 139284;
    public static final int RESPONSE_PERSISTENT_GROUP_INFO = 139322;
    public static final int RESPONSE_SERVICE = 139314;
    public static final int SET_CHANNEL = 139335;
    public static final int SET_CHANNEL_FAILED = 139336;
    public static final int SET_CHANNEL_SUCCEEDED = 139337;
    public static final int SET_DEVICE_NAME = 139315;
    public static final int SET_DEVICE_NAME_FAILED = 139316;
    public static final int SET_DEVICE_NAME_SUCCEEDED = 139317;
    public static final int SET_WFD_INFO = 139323;
    public static final int SET_WFD_INFO_FAILED = 139324;
    public static final int SET_WFD_INFO_SUCCEEDED = 139325;
    public static final int START_LISTEN = 139329;
    public static final int START_LISTEN_FAILED = 139330;
    public static final int START_LISTEN_SUCCEEDED = 139331;
    public static final int START_WPS = 139326;
    public static final int START_WPS_FAILED = 139327;
    public static final int START_WPS_SUCCEEDED = 139328;
    public static final int STOP_DISCOVERY = 139268;
    public static final int STOP_DISCOVERY_FAILED = 139269;
    public static final int STOP_DISCOVERY_SUCCEEDED = 139270;
    public static final int STOP_LISTEN = 139332;
    public static final int STOP_LISTEN_FAILED = 139333;
    public static final int STOP_LISTEN_SUCCEEDED = 139334;
    private static final String TAG = "WifiP2pManager";
    public static final String WIFI_P2P_CONNECTION_CHANGED_ACTION = "android.net.wifi.p2p.CONNECTION_STATE_CHANGE";
    public static final String WIFI_P2P_DISCOVERY_CHANGED_ACTION = "android.net.wifi.p2p.DISCOVERY_STATE_CHANGE";
    public static final int WIFI_P2P_DISCOVERY_STARTED = 2;
    public static final int WIFI_P2P_DISCOVERY_STOPPED = 1;
    public static final String WIFI_P2P_PEERS_CHANGED_ACTION = "android.net.wifi.p2p.PEERS_CHANGED";
    public static final String WIFI_P2P_PERSISTENT_GROUPS_CHANGED_ACTION = "android.net.wifi.p2p.PERSISTENT_GROUPS_CHANGED";
    public static final String WIFI_P2P_STATE_CHANGED_ACTION = "android.net.wifi.p2p.STATE_CHANGED";
    public static final int WIFI_P2P_STATE_DISABLED = 1;
    public static final int WIFI_P2P_STATE_ENABLED = 2;
    public static final String WIFI_P2P_THIS_DEVICE_CHANGED_ACTION = "android.net.wifi.p2p.THIS_DEVICE_CHANGED";
    IWifiP2pManager mService;

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$ActionListener.class */
    public interface ActionListener {
        void onFailure(int i);

        void onSuccess();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$Channel.class */
    public static class Channel {
        private static final int INVALID_LISTENER_KEY = 0;
        private ChannelListener mChannelListener;
        Context mContext;
        private DnsSdServiceResponseListener mDnsSdServRspListener;
        private DnsSdTxtRecordListener mDnsSdTxtListener;
        private P2pHandler mHandler;
        private ServiceResponseListener mServRspListener;
        private UpnpServiceResponseListener mUpnpServRspListener;
        private HashMap<Integer, Object> mListenerMap = new HashMap<>();
        private Object mListenerMapLock = new Object();
        private int mListenerKey = 0;
        private AsyncChannel mAsyncChannel = new AsyncChannel();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$Channel$P2pHandler.class */
        public class P2pHandler extends Handler {
            P2pHandler(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Object listener = Channel.this.getListener(message.arg2);
                switch (message.what) {
                    case AsyncChannel.CMD_CHANNEL_DISCONNECTED /* 69636 */:
                        if (Channel.this.mChannelListener != null) {
                            Channel.this.mChannelListener.onChannelDisconnected();
                            Channel.this.mChannelListener = null;
                            return;
                        }
                        return;
                    case WifiP2pManager.DISCOVER_PEERS_FAILED /* 139266 */:
                    case WifiP2pManager.STOP_DISCOVERY_FAILED /* 139269 */:
                    case WifiP2pManager.CONNECT_FAILED /* 139272 */:
                    case WifiP2pManager.CANCEL_CONNECT_FAILED /* 139275 */:
                    case WifiP2pManager.CREATE_GROUP_FAILED /* 139278 */:
                    case WifiP2pManager.REMOVE_GROUP_FAILED /* 139281 */:
                    case WifiP2pManager.ADD_LOCAL_SERVICE_FAILED /* 139293 */:
                    case WifiP2pManager.REMOVE_LOCAL_SERVICE_FAILED /* 139296 */:
                    case WifiP2pManager.CLEAR_LOCAL_SERVICES_FAILED /* 139299 */:
                    case WifiP2pManager.ADD_SERVICE_REQUEST_FAILED /* 139302 */:
                    case WifiP2pManager.REMOVE_SERVICE_REQUEST_FAILED /* 139305 */:
                    case WifiP2pManager.CLEAR_SERVICE_REQUESTS_FAILED /* 139308 */:
                    case WifiP2pManager.DISCOVER_SERVICES_FAILED /* 139311 */:
                    case WifiP2pManager.SET_DEVICE_NAME_FAILED /* 139316 */:
                    case WifiP2pManager.DELETE_PERSISTENT_GROUP_FAILED /* 139319 */:
                    case WifiP2pManager.SET_WFD_INFO_FAILED /* 139324 */:
                    case WifiP2pManager.START_WPS_FAILED /* 139327 */:
                    case WifiP2pManager.START_LISTEN_FAILED /* 139330 */:
                    case WifiP2pManager.STOP_LISTEN_FAILED /* 139333 */:
                    case WifiP2pManager.SET_CHANNEL_FAILED /* 139336 */:
                    case WifiP2pManager.REPORT_NFC_HANDOVER_FAILED /* 139345 */:
                        if (listener != null) {
                            ((ActionListener) listener).onFailure(message.arg1);
                            return;
                        }
                        return;
                    case WifiP2pManager.DISCOVER_PEERS_SUCCEEDED /* 139267 */:
                    case WifiP2pManager.STOP_DISCOVERY_SUCCEEDED /* 139270 */:
                    case WifiP2pManager.CONNECT_SUCCEEDED /* 139273 */:
                    case WifiP2pManager.CANCEL_CONNECT_SUCCEEDED /* 139276 */:
                    case WifiP2pManager.CREATE_GROUP_SUCCEEDED /* 139279 */:
                    case WifiP2pManager.REMOVE_GROUP_SUCCEEDED /* 139282 */:
                    case WifiP2pManager.ADD_LOCAL_SERVICE_SUCCEEDED /* 139294 */:
                    case WifiP2pManager.REMOVE_LOCAL_SERVICE_SUCCEEDED /* 139297 */:
                    case WifiP2pManager.CLEAR_LOCAL_SERVICES_SUCCEEDED /* 139300 */:
                    case WifiP2pManager.ADD_SERVICE_REQUEST_SUCCEEDED /* 139303 */:
                    case WifiP2pManager.REMOVE_SERVICE_REQUEST_SUCCEEDED /* 139306 */:
                    case WifiP2pManager.CLEAR_SERVICE_REQUESTS_SUCCEEDED /* 139309 */:
                    case WifiP2pManager.DISCOVER_SERVICES_SUCCEEDED /* 139312 */:
                    case WifiP2pManager.SET_DEVICE_NAME_SUCCEEDED /* 139317 */:
                    case WifiP2pManager.DELETE_PERSISTENT_GROUP_SUCCEEDED /* 139320 */:
                    case WifiP2pManager.SET_WFD_INFO_SUCCEEDED /* 139325 */:
                    case WifiP2pManager.START_WPS_SUCCEEDED /* 139328 */:
                    case WifiP2pManager.START_LISTEN_SUCCEEDED /* 139331 */:
                    case WifiP2pManager.STOP_LISTEN_SUCCEEDED /* 139334 */:
                    case WifiP2pManager.SET_CHANNEL_SUCCEEDED /* 139337 */:
                    case WifiP2pManager.REPORT_NFC_HANDOVER_SUCCEEDED /* 139344 */:
                        if (listener != null) {
                            ((ActionListener) listener).onSuccess();
                            return;
                        }
                        return;
                    case WifiP2pManager.RESPONSE_PEERS /* 139284 */:
                        WifiP2pDeviceList wifiP2pDeviceList = (WifiP2pDeviceList) message.obj;
                        if (listener != null) {
                            ((PeerListListener) listener).onPeersAvailable(wifiP2pDeviceList);
                            return;
                        }
                        return;
                    case WifiP2pManager.RESPONSE_CONNECTION_INFO /* 139286 */:
                        WifiP2pInfo wifiP2pInfo = (WifiP2pInfo) message.obj;
                        if (listener != null) {
                            ((ConnectionInfoListener) listener).onConnectionInfoAvailable(wifiP2pInfo);
                            return;
                        }
                        return;
                    case WifiP2pManager.RESPONSE_GROUP_INFO /* 139288 */:
                        WifiP2pGroup wifiP2pGroup = (WifiP2pGroup) message.obj;
                        if (listener != null) {
                            ((GroupInfoListener) listener).onGroupInfoAvailable(wifiP2pGroup);
                            return;
                        }
                        return;
                    case WifiP2pManager.RESPONSE_SERVICE /* 139314 */:
                        Channel.this.handleServiceResponse((WifiP2pServiceResponse) message.obj);
                        return;
                    case WifiP2pManager.RESPONSE_PERSISTENT_GROUP_INFO /* 139322 */:
                        WifiP2pGroupList wifiP2pGroupList = (WifiP2pGroupList) message.obj;
                        if (listener != null) {
                            ((PersistentGroupInfoListener) listener).onPersistentGroupInfoAvailable(wifiP2pGroupList);
                            return;
                        }
                        return;
                    case WifiP2pManager.RESPONSE_GET_HANDOVER_MESSAGE /* 139341 */:
                        Bundle bundle = (Bundle) message.obj;
                        if (listener != null) {
                            String str = null;
                            if (bundle != null) {
                                str = bundle.getString(WifiP2pManager.EXTRA_HANDOVER_MESSAGE);
                            }
                            ((HandoverMessageListener) listener).onHandoverMessageAvailable(str);
                            return;
                        }
                        return;
                    default:
                        Log.d(WifiP2pManager.TAG, "Ignored " + message);
                        return;
                }
            }
        }

        Channel(Context context, Looper looper, ChannelListener channelListener) {
            this.mHandler = new P2pHandler(looper);
            this.mChannelListener = channelListener;
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object getListener(int i) {
            Object remove;
            if (i == 0) {
                return null;
            }
            synchronized (this.mListenerMapLock) {
                remove = this.mListenerMap.remove(Integer.valueOf(i));
            }
            return remove;
        }

        private void handleDnsSdServiceResponse(WifiP2pDnsSdServiceResponse wifiP2pDnsSdServiceResponse) {
            if (wifiP2pDnsSdServiceResponse.getDnsType() == 12) {
                if (this.mDnsSdServRspListener != null) {
                    this.mDnsSdServRspListener.onDnsSdServiceAvailable(wifiP2pDnsSdServiceResponse.getInstanceName(), wifiP2pDnsSdServiceResponse.getDnsQueryName(), wifiP2pDnsSdServiceResponse.getSrcDevice());
                }
            } else if (wifiP2pDnsSdServiceResponse.getDnsType() != 16) {
                Log.e(WifiP2pManager.TAG, "Unhandled resp " + wifiP2pDnsSdServiceResponse);
            } else if (this.mDnsSdTxtListener != null) {
                this.mDnsSdTxtListener.onDnsSdTxtRecordAvailable(wifiP2pDnsSdServiceResponse.getDnsQueryName(), wifiP2pDnsSdServiceResponse.getTxtRecord(), wifiP2pDnsSdServiceResponse.getSrcDevice());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleServiceResponse(WifiP2pServiceResponse wifiP2pServiceResponse) {
            if (wifiP2pServiceResponse instanceof WifiP2pDnsSdServiceResponse) {
                handleDnsSdServiceResponse((WifiP2pDnsSdServiceResponse) wifiP2pServiceResponse);
            } else if (wifiP2pServiceResponse instanceof WifiP2pUpnpServiceResponse) {
                if (this.mUpnpServRspListener != null) {
                    handleUpnpServiceResponse((WifiP2pUpnpServiceResponse) wifiP2pServiceResponse);
                }
            } else if (this.mServRspListener != null) {
                this.mServRspListener.onServiceAvailable(wifiP2pServiceResponse.getServiceType(), wifiP2pServiceResponse.getRawData(), wifiP2pServiceResponse.getSrcDevice());
            }
        }

        private void handleUpnpServiceResponse(WifiP2pUpnpServiceResponse wifiP2pUpnpServiceResponse) {
            this.mUpnpServRspListener.onUpnpServiceAvailable(wifiP2pUpnpServiceResponse.getUniqueServiceNames(), wifiP2pUpnpServiceResponse.getSrcDevice());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int putListener(Object obj) {
            int i;
            if (obj == null) {
                return 0;
            }
            synchronized (this.mListenerMapLock) {
                do {
                    i = this.mListenerKey;
                    this.mListenerKey = i + 1;
                } while (i == 0);
                this.mListenerMap.put(Integer.valueOf(i), obj);
            }
            return i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$ChannelListener.class */
    public interface ChannelListener {
        void onChannelDisconnected();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$ConnectionInfoListener.class */
    public interface ConnectionInfoListener {
        void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$DnsSdServiceResponseListener.class */
    public interface DnsSdServiceResponseListener {
        void onDnsSdServiceAvailable(String str, String str2, WifiP2pDevice wifiP2pDevice);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$DnsSdTxtRecordListener.class */
    public interface DnsSdTxtRecordListener {
        void onDnsSdTxtRecordAvailable(String str, Map<String, String> map, WifiP2pDevice wifiP2pDevice);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$GroupInfoListener.class */
    public interface GroupInfoListener {
        void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$HandoverMessageListener.class */
    public interface HandoverMessageListener {
        void onHandoverMessageAvailable(String str);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$PeerListListener.class */
    public interface PeerListListener {
        void onPeersAvailable(WifiP2pDeviceList wifiP2pDeviceList);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$PersistentGroupInfoListener.class */
    public interface PersistentGroupInfoListener {
        void onPersistentGroupInfoAvailable(WifiP2pGroupList wifiP2pGroupList);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$ServiceResponseListener.class */
    public interface ServiceResponseListener {
        void onServiceAvailable(int i, byte[] bArr, WifiP2pDevice wifiP2pDevice);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pManager$UpnpServiceResponseListener.class */
    public interface UpnpServiceResponseListener {
        void onUpnpServiceAvailable(List<String> list, WifiP2pDevice wifiP2pDevice);
    }

    public WifiP2pManager(IWifiP2pManager iWifiP2pManager) {
        this.mService = iWifiP2pManager;
    }

    private static void checkChannel(Channel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("Channel needs to be initialized");
        }
    }

    private static void checkP2pConfig(WifiP2pConfig wifiP2pConfig) {
        if (wifiP2pConfig == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        if (TextUtils.isEmpty(wifiP2pConfig.deviceAddress)) {
            throw new IllegalArgumentException("deviceAddress cannot be empty");
        }
    }

    private static void checkServiceInfo(WifiP2pServiceInfo wifiP2pServiceInfo) {
        if (wifiP2pServiceInfo == null) {
            throw new IllegalArgumentException("service info is null");
        }
    }

    private static void checkServiceRequest(WifiP2pServiceRequest wifiP2pServiceRequest) {
        if (wifiP2pServiceRequest == null) {
            throw new IllegalArgumentException("service request is null");
        }
    }

    private Channel initalizeChannel(Context context, Looper looper, ChannelListener channelListener, Messenger messenger) {
        Channel channel;
        if (messenger == null) {
            channel = null;
        } else {
            Channel channel2 = new Channel(context, looper, channelListener);
            channel = channel2;
            if (channel2.mAsyncChannel.connectSync(context, channel2.mHandler, messenger) != 0) {
                return null;
            }
        }
        return channel;
    }

    public void addLocalService(Channel channel, WifiP2pServiceInfo wifiP2pServiceInfo, ActionListener actionListener) {
        checkChannel(channel);
        checkServiceInfo(wifiP2pServiceInfo);
        channel.mAsyncChannel.sendMessage(ADD_LOCAL_SERVICE, 0, channel.putListener(actionListener), wifiP2pServiceInfo);
    }

    public void addServiceRequest(Channel channel, WifiP2pServiceRequest wifiP2pServiceRequest, ActionListener actionListener) {
        checkChannel(channel);
        checkServiceRequest(wifiP2pServiceRequest);
        channel.mAsyncChannel.sendMessage(ADD_SERVICE_REQUEST, 0, channel.putListener(actionListener), wifiP2pServiceRequest);
    }

    public void cancelConnect(Channel channel, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(CANCEL_CONNECT, 0, channel.putListener(actionListener));
    }

    public void clearLocalServices(Channel channel, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(CLEAR_LOCAL_SERVICES, 0, channel.putListener(actionListener));
    }

    public void clearServiceRequests(Channel channel, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(CLEAR_SERVICE_REQUESTS, 0, channel.putListener(actionListener));
    }

    public void connect(Channel channel, WifiP2pConfig wifiP2pConfig, ActionListener actionListener) {
        checkChannel(channel);
        checkP2pConfig(wifiP2pConfig);
        channel.mAsyncChannel.sendMessage(CONNECT, 0, channel.putListener(actionListener), wifiP2pConfig);
    }

    public void createGroup(Channel channel, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(CREATE_GROUP, -2, channel.putListener(actionListener));
    }

    public void deletePersistentGroup(Channel channel, int i, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(DELETE_PERSISTENT_GROUP, i, channel.putListener(actionListener));
    }

    public void discoverPeers(Channel channel, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(DISCOVER_PEERS, 0, channel.putListener(actionListener));
    }

    public void discoverServices(Channel channel, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(DISCOVER_SERVICES, 0, channel.putListener(actionListener));
    }

    public Messenger getMessenger() {
        try {
            return this.mService.getMessenger();
        } catch (RemoteException e) {
            return null;
        }
    }

    public void getNfcHandoverRequest(Channel channel, HandoverMessageListener handoverMessageListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(GET_HANDOVER_REQUEST, 0, channel.putListener(handoverMessageListener));
    }

    public void getNfcHandoverSelect(Channel channel, HandoverMessageListener handoverMessageListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(GET_HANDOVER_SELECT, 0, channel.putListener(handoverMessageListener));
    }

    public Messenger getP2pStateMachineMessenger() {
        try {
            return this.mService.getP2pStateMachineMessenger();
        } catch (RemoteException e) {
            return null;
        }
    }

    public Channel initialize(Context context, Looper looper, ChannelListener channelListener) {
        return initalizeChannel(context, looper, channelListener, getMessenger());
    }

    public Channel initializeInternal(Context context, Looper looper, ChannelListener channelListener) {
        return initalizeChannel(context, looper, channelListener, getP2pStateMachineMessenger());
    }

    public void initiatorReportNfcHandover(Channel channel, String str, ActionListener actionListener) {
        checkChannel(channel);
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_HANDOVER_MESSAGE, str);
        channel.mAsyncChannel.sendMessage(INITIATOR_REPORT_NFC_HANDOVER, 0, channel.putListener(actionListener), bundle);
    }

    public void listen(Channel channel, boolean z, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(z ? 139329 : 139332, 0, channel.putListener(actionListener));
    }

    public void removeGroup(Channel channel, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(REMOVE_GROUP, 0, channel.putListener(actionListener));
    }

    public void removeLocalService(Channel channel, WifiP2pServiceInfo wifiP2pServiceInfo, ActionListener actionListener) {
        checkChannel(channel);
        checkServiceInfo(wifiP2pServiceInfo);
        channel.mAsyncChannel.sendMessage(REMOVE_LOCAL_SERVICE, 0, channel.putListener(actionListener), wifiP2pServiceInfo);
    }

    public void removeServiceRequest(Channel channel, WifiP2pServiceRequest wifiP2pServiceRequest, ActionListener actionListener) {
        checkChannel(channel);
        checkServiceRequest(wifiP2pServiceRequest);
        channel.mAsyncChannel.sendMessage(REMOVE_SERVICE_REQUEST, 0, channel.putListener(actionListener), wifiP2pServiceRequest);
    }

    public void requestConnectionInfo(Channel channel, ConnectionInfoListener connectionInfoListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(REQUEST_CONNECTION_INFO, 0, channel.putListener(connectionInfoListener));
    }

    public void requestGroupInfo(Channel channel, GroupInfoListener groupInfoListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(REQUEST_GROUP_INFO, 0, channel.putListener(groupInfoListener));
    }

    public void requestPeers(Channel channel, PeerListListener peerListListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(REQUEST_PEERS, 0, channel.putListener(peerListListener));
    }

    public void requestPersistentGroupInfo(Channel channel, PersistentGroupInfoListener persistentGroupInfoListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(REQUEST_PERSISTENT_GROUP_INFO, 0, channel.putListener(persistentGroupInfoListener));
    }

    public void responderReportNfcHandover(Channel channel, String str, ActionListener actionListener) {
        checkChannel(channel);
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_HANDOVER_MESSAGE, str);
        channel.mAsyncChannel.sendMessage(RESPONDER_REPORT_NFC_HANDOVER, 0, channel.putListener(actionListener), bundle);
    }

    public void setDeviceName(Channel channel, String str, ActionListener actionListener) {
        checkChannel(channel);
        WifiP2pDevice wifiP2pDevice = new WifiP2pDevice();
        wifiP2pDevice.deviceName = str;
        channel.mAsyncChannel.sendMessage(SET_DEVICE_NAME, 0, channel.putListener(actionListener), wifiP2pDevice);
    }

    public void setDnsSdResponseListeners(Channel channel, DnsSdServiceResponseListener dnsSdServiceResponseListener, DnsSdTxtRecordListener dnsSdTxtRecordListener) {
        checkChannel(channel);
        channel.mDnsSdServRspListener = dnsSdServiceResponseListener;
        channel.mDnsSdTxtListener = dnsSdTxtRecordListener;
    }

    public void setMiracastMode(int i) {
        try {
            this.mService.setMiracastMode(i);
        } catch (RemoteException e) {
        }
    }

    public void setServiceResponseListener(Channel channel, ServiceResponseListener serviceResponseListener) {
        checkChannel(channel);
        channel.mServRspListener = serviceResponseListener;
    }

    public void setUpnpServiceResponseListener(Channel channel, UpnpServiceResponseListener upnpServiceResponseListener) {
        checkChannel(channel);
        channel.mUpnpServRspListener = upnpServiceResponseListener;
    }

    public void setWFDInfo(Channel channel, WifiP2pWfdInfo wifiP2pWfdInfo, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(SET_WFD_INFO, 0, channel.putListener(actionListener), wifiP2pWfdInfo);
    }

    public void setWifiP2pChannels(Channel channel, int i, int i2, ActionListener actionListener) {
        checkChannel(channel);
        Bundle bundle = new Bundle();
        bundle.putInt("lc", i);
        bundle.putInt("oc", i2);
        channel.mAsyncChannel.sendMessage(SET_CHANNEL, 0, channel.putListener(actionListener), bundle);
    }

    public void startWps(Channel channel, WpsInfo wpsInfo, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(START_WPS, 0, channel.putListener(actionListener), wpsInfo);
    }

    public void stopPeerDiscovery(Channel channel, ActionListener actionListener) {
        checkChannel(channel);
        channel.mAsyncChannel.sendMessage(STOP_DISCOVERY, 0, channel.putListener(actionListener));
    }
}
