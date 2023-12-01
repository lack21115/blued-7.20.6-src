package android.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-9557208-dex2jar.jar:android/net/ProxyDataTracker.class */
public class ProxyDataTracker extends BaseNetworkStateTracker {
    private static final String ACTION_PROXY_STATUS_CHANGE = "com.android.net.PROXY_STATUS_CHANGE";
    private static final String DNS1 = "8.8.8.8";
    private static final String DNS2 = "8.8.4.4";
    private static final String INTERFACE_NAME = "ifb0";
    private static final String KEY_IS_PROXY_AVAILABLE = "is_proxy_available";
    private static final String KEY_REPLY_TO_MESSENGER_BINDER = "reply_to_messenger_binder";
    private static final String KEY_REPLY_TO_MESSENGER_BINDER_BUNDLE = "reply_to_messenger_binder_bundle";
    private static final int MSG_SETUP_REQUEST = 2;
    private static final int MSG_TEAR_DOWN_REQUEST = 1;
    private static final String NETWORK_TYPE = "PROXY";
    private static final String PERMISSION_PROXY_STATUS_SENDER = "android.permission.ACCESS_NETWORK_CONDITIONS";
    private static final String REASON_DISABLED = "disabled";
    private static final String REASON_ENABLED = "enabled";
    private static final String REASON_PROXY_DOWN = "proxy_down";
    private static final String TAG = "ProxyDataTracker";
    private Messenger mProxyStatusService;
    private Handler mTarget;
    private AtomicBoolean mReconnectRequested = new AtomicBoolean(false);
    private AtomicBoolean mIsProxyAvailable = new AtomicBoolean(false);
    private final AtomicInteger mDefaultGatewayAddr = new AtomicInteger(0);
    private final BroadcastReceiver mProxyStatusServiceListener = new BroadcastReceiver() { // from class: android.net.ProxyDataTracker.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equals(ProxyDataTracker.ACTION_PROXY_STATUS_CHANGE)) {
                Log.d(ProxyDataTracker.TAG, "Unrecognized broadcast intent");
                return;
            }
            ProxyDataTracker.this.mIsProxyAvailable.set(intent.getBooleanExtra(ProxyDataTracker.KEY_IS_PROXY_AVAILABLE, false));
            if (!ProxyDataTracker.this.mIsProxyAvailable.get()) {
                ProxyDataTracker.this.setDetailedState(NetworkInfo.DetailedState.DISCONNECTED, ProxyDataTracker.REASON_PROXY_DOWN, null);
                return;
            }
            Bundle bundleExtra = intent.getBundleExtra(ProxyDataTracker.KEY_REPLY_TO_MESSENGER_BINDER_BUNDLE);
            if (bundleExtra == null || bundleExtra.getBinder(ProxyDataTracker.KEY_REPLY_TO_MESSENGER_BINDER) == null) {
                Log.e(ProxyDataTracker.TAG, "no messenger binder in the intent to send future requests");
                ProxyDataTracker.this.mIsProxyAvailable.set(false);
                return;
            }
            ProxyDataTracker.this.mProxyStatusService = new Messenger(bundleExtra.getBinder(ProxyDataTracker.KEY_REPLY_TO_MESSENGER_BINDER));
            if (ProxyDataTracker.this.mReconnectRequested.get()) {
                ProxyDataTracker.this.reconnect();
            }
        }
    };

    public ProxyDataTracker() {
        this.mNetworkInfo = new NetworkInfo(16, 0, NETWORK_TYPE, "");
        this.mLinkProperties = new LinkProperties();
        this.mNetworkCapabilities = new NetworkCapabilities();
        this.mNetworkInfo.setIsAvailable(true);
        try {
            this.mLinkProperties.addDnsServer(InetAddress.getByName(DNS1));
            this.mLinkProperties.addDnsServer(InetAddress.getByName(DNS2));
            this.mLinkProperties.setInterfaceName(INTERFACE_NAME);
        } catch (UnknownHostException e) {
            Log.e(TAG, "Could not add DNS address", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailedState(NetworkInfo.DetailedState detailedState, String str, String str2) {
        this.mNetworkInfo.setDetailedState(detailedState, str, str2);
        this.mTarget.obtainMessage(458752, this.mNetworkInfo).sendToTarget();
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public int getDefaultGatewayAddr() {
        return this.mDefaultGatewayAddr.get();
    }

    @Override // android.net.NetworkStateTracker
    public String getTcpBufferSizesPropName() {
        return BaseNetworkStateTracker.PROP_TCP_BUFFER_WIFI;
    }

    @Override // android.net.NetworkStateTracker
    public boolean reconnect() {
        this.mReconnectRequested.set(true);
        setTeardownRequested(false);
        if (!this.mIsProxyAvailable.get()) {
            Log.w(TAG, "Reconnect requested even though proxy service is not up. Bailing.");
            return false;
        }
        setDetailedState(NetworkInfo.DetailedState.CONNECTING, "enabled", null);
        try {
            this.mProxyStatusService.send(Message.obtain((Handler) null, 2));
            setDetailedState(NetworkInfo.DetailedState.CONNECTED, "enabled", null);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Unable to connect to proxy status service", e);
            setDetailedState(NetworkInfo.DetailedState.DISCONNECTED, REASON_PROXY_DOWN, null);
            return false;
        }
    }

    @Override // android.net.BaseNetworkStateTracker, android.net.NetworkStateTracker
    public void startMonitoring(Context context, Handler handler) {
        this.mContext = context;
        this.mTarget = handler;
        this.mContext.registerReceiver(this.mProxyStatusServiceListener, new IntentFilter(ACTION_PROXY_STATUS_CHANGE), "android.permission.ACCESS_NETWORK_CONDITIONS", null);
    }

    @Override // android.net.NetworkStateTracker
    public boolean teardown() {
        setTeardownRequested(true);
        this.mReconnectRequested.set(false);
        try {
            if (this.mIsProxyAvailable.get() && this.mProxyStatusService != null) {
                this.mProxyStatusService.send(Message.obtain((Handler) null, 1));
            }
            setDetailedState(NetworkInfo.DetailedState.DISCONNECTED, REASON_DISABLED, null);
            return true;
        } catch (RemoteException e) {
            Log.e(TAG, "Unable to connect to proxy status service", e);
            return false;
        }
    }
}
