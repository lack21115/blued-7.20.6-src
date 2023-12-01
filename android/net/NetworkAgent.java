package android.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.android.internal.util.AsyncChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkAgent.class */
public abstract class NetworkAgent extends Handler {
    private static final int BASE = 528384;
    public static final int CMD_REPORT_NETWORK_STATUS = 528391;
    public static final int CMD_SUSPECT_BAD = 528384;
    private static final boolean DBG = true;
    public static final int EVENT_NETWORK_CAPABILITIES_CHANGED = 528386;
    public static final int EVENT_NETWORK_INFO_CHANGED = 528385;
    public static final int EVENT_NETWORK_PROPERTIES_CHANGED = 528387;
    public static final int EVENT_NETWORK_SCORE_CHANGED = 528388;
    public static final int EVENT_SET_EXPLICITLY_SELECTED = 528392;
    public static final int EVENT_UID_RANGES_ADDED = 528389;
    public static final int EVENT_UID_RANGES_REMOVED = 528390;
    public static final int INVALID_NETWORK = 2;
    public static final int VALID_NETWORK = 1;
    private static final boolean VDBG = false;
    public static final int WIFI_BASE_SCORE = 60;
    private final String LOG_TAG;
    private volatile AsyncChannel mAsyncChannel;
    private final Context mContext;
    private final ArrayList<Message> mPreConnectedQueue;

    public NetworkAgent(Looper looper, Context context, String str, NetworkInfo networkInfo, NetworkCapabilities networkCapabilities, LinkProperties linkProperties, int i) {
        this(looper, context, str, networkInfo, networkCapabilities, linkProperties, i, null);
    }

    public NetworkAgent(Looper looper, Context context, String str, NetworkInfo networkInfo, NetworkCapabilities networkCapabilities, LinkProperties linkProperties, int i, NetworkMisc networkMisc) {
        super(looper);
        this.mPreConnectedQueue = new ArrayList<>();
        this.LOG_TAG = str;
        this.mContext = context;
        if (networkInfo == null || networkCapabilities == null || linkProperties == null) {
            throw new IllegalArgumentException();
        }
        ((ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE)).registerNetworkAgent(new Messenger(this), new NetworkInfo(networkInfo), new LinkProperties(linkProperties), new NetworkCapabilities(networkCapabilities), i, networkMisc);
    }

    private void queueOrSendMessage(int i, Object obj) {
        synchronized (this.mPreConnectedQueue) {
            if (this.mAsyncChannel != null) {
                this.mAsyncChannel.sendMessage(i, obj);
            } else {
                Message obtain = Message.obtain();
                obtain.what = i;
                obtain.obj = obj;
                this.mPreConnectedQueue.add(obtain);
            }
        }
    }

    public void addUidRanges(UidRange[] uidRangeArr) {
        queueOrSendMessage(EVENT_UID_RANGES_ADDED, uidRangeArr);
    }

    public void explicitlySelected() {
        queueOrSendMessage(EVENT_SET_EXPLICITLY_SELECTED, 0);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case AsyncChannel.CMD_CHANNEL_FULL_CONNECTION /* 69633 */:
                if (this.mAsyncChannel != null) {
                    log("Received new connection while already connected!");
                    return;
                }
                AsyncChannel asyncChannel = new AsyncChannel();
                asyncChannel.connected(null, this, message.replyTo);
                asyncChannel.replyToMessage(message, AsyncChannel.CMD_CHANNEL_FULLY_CONNECTED, 0);
                synchronized (this.mPreConnectedQueue) {
                    this.mAsyncChannel = asyncChannel;
                    Iterator<Message> it = this.mPreConnectedQueue.iterator();
                    while (it.hasNext()) {
                        asyncChannel.sendMessage(it.next());
                    }
                    this.mPreConnectedQueue.clear();
                }
                return;
            case AsyncChannel.CMD_CHANNEL_DISCONNECT /* 69635 */:
                if (this.mAsyncChannel != null) {
                    this.mAsyncChannel.disconnect();
                    return;
                }
                return;
            case AsyncChannel.CMD_CHANNEL_DISCONNECTED /* 69636 */:
                log("NetworkAgent channel lost");
                unwanted();
                synchronized (this.mPreConnectedQueue) {
                    this.mAsyncChannel = null;
                }
                return;
            case 528384:
                log("Unhandled Message " + message);
                return;
            case CMD_REPORT_NETWORK_STATUS /* 528391 */:
                networkStatus(message.arg1);
                return;
            default:
                return;
        }
    }

    protected void log(String str) {
        Log.d(this.LOG_TAG, "NetworkAgent: " + str);
    }

    protected void networkStatus(int i) {
    }

    public void removeUidRanges(UidRange[] uidRangeArr) {
        queueOrSendMessage(EVENT_UID_RANGES_REMOVED, uidRangeArr);
    }

    public void sendLinkProperties(LinkProperties linkProperties) {
        queueOrSendMessage(EVENT_NETWORK_PROPERTIES_CHANGED, new LinkProperties(linkProperties));
    }

    public void sendNetworkCapabilities(NetworkCapabilities networkCapabilities) {
        queueOrSendMessage(EVENT_NETWORK_CAPABILITIES_CHANGED, new NetworkCapabilities(networkCapabilities));
    }

    public void sendNetworkInfo(NetworkInfo networkInfo) {
        queueOrSendMessage(EVENT_NETWORK_INFO_CHANGED, new NetworkInfo(networkInfo));
    }

    public void sendNetworkScore(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Score must be >= 0");
        }
        queueOrSendMessage(EVENT_NETWORK_SCORE_CHANGED, new Integer(i));
    }

    protected abstract void unwanted();
}
