package android.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-9557208-dex2jar.jar:android/net/DnsPinger.class */
public final class DnsPinger extends Handler {
    private static final int ACTION_CANCEL_ALL_PINGS = 327683;
    private static final int ACTION_LISTEN_FOR_RESPONSE = 327682;
    private static final int ACTION_PING_DNS = 327681;
    private static final int BASE = 327680;
    private static final boolean DBG = false;
    public static final int DNS_PING_RESULT = 327680;
    private static final int DNS_PORT = 53;
    private static final int RECEIVE_POLL_INTERVAL_MS = 200;
    public static final int SOCKET_EXCEPTION = -2;
    private static final int SOCKET_TIMEOUT_MS = 1;
    public static final int TIMEOUT = -1;
    private String TAG;
    private List<ActivePing> mActivePings;
    private final int mConnectionType;
    private ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private AtomicInteger mCurrentToken;
    private final ArrayList<InetAddress> mDefaultDns;
    private int mEventCounter;
    private final Handler mTarget;
    private static final Random sRandom = new Random();
    private static final AtomicInteger sCounter = new AtomicInteger();
    private static final byte[] mDnsQuery = {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 119, 119, 119, 6, 103, 111, 111, 103, 108, 101, 3, 99, 111, 109, 0, 0, 1, 0, 1};

    /* loaded from: source-9557208-dex2jar.jar:android/net/DnsPinger$ActivePing.class */
    private class ActivePing {
        int internalId;
        short packetId;
        Integer result;
        DatagramSocket socket;
        long start;
        int timeout;

        private ActivePing() {
            this.start = SystemClock.elapsedRealtime();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/DnsPinger$DnsArg.class */
    private class DnsArg {
        InetAddress dns;
        int seq;

        DnsArg(InetAddress inetAddress, int i) {
            this.dns = inetAddress;
            this.seq = i;
        }
    }

    public DnsPinger(Context context, String str, Looper looper, Handler handler, int i) {
        super(looper);
        this.mConnectivityManager = null;
        this.mCurrentToken = new AtomicInteger();
        this.mActivePings = new ArrayList();
        this.TAG = str;
        this.mContext = context;
        this.mTarget = handler;
        this.mConnectionType = i;
        if (!ConnectivityManager.isNetworkTypeValid(i)) {
            throw new IllegalArgumentException("Invalid connectionType in constructor: " + i);
        }
        this.mDefaultDns = new ArrayList<>();
        this.mDefaultDns.add(getDefaultDns());
        this.mEventCounter = 0;
    }

    private LinkProperties getCurrentLinkProperties() {
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        }
        return this.mConnectivityManager.getLinkProperties(this.mConnectionType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0.length() == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.InetAddress getDefaultDns() {
        /*
            r3 = this;
            r0 = r3
            android.content.Context r0 = r0.mContext
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r1 = "default_dns_server"
            java.lang.String r0 = android.provider.Settings.Global.getString(r0, r1)
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L1a
            r0 = r5
            r4 = r0
            r0 = r5
            int r0 = r0.length()
            if (r0 != 0) goto L27
        L1a:
            r0 = r3
            android.content.Context r0 = r0.mContext
            android.content.res.Resources r0 = r0.getResources()
            r1 = 17039599(0x10400ef, float:2.424524E-38)
            java.lang.String r0 = r0.getString(r1)
            r4 = r0
        L27:
            r0 = r4
            java.net.InetAddress r0 = android.net.NetworkUtils.numericToInetAddress(r0)     // Catch: java.lang.IllegalArgumentException -> L2e
            r4 = r0
            r0 = r4
            return r0
        L2e:
            r4 = move-exception
            r0 = r3
            java.lang.String r1 = "getDefaultDns::malformed default dns address"
            r0.loge(r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.DnsPinger.getDefaultDns():java.net.InetAddress");
    }

    private void log(String str) {
        Log.d(this.TAG, str);
    }

    private void loge(String str) {
        Log.e(this.TAG, str);
    }

    private void sendResponse(int i, int i2, int i3) {
        this.mTarget.sendMessage(obtainMessage(327680, i, i3));
    }

    public void cancelPings() {
        this.mCurrentToken.incrementAndGet();
        obtainMessage(ACTION_CANCEL_ALL_PINGS).sendToTarget();
    }

    public List<InetAddress> getDnsList() {
        LinkProperties currentLinkProperties = getCurrentLinkProperties();
        if (currentLinkProperties == null) {
            loge("getCurLinkProperties:: LP for type" + this.mConnectionType + " is null!");
            return this.mDefaultDns;
        }
        List<InetAddress> dnsServers = currentLinkProperties.getDnsServers();
        if (dnsServers == null || dnsServers.size() == 0) {
            loge("getDns::LinkProps has null dns - returning default");
            return this.mDefaultDns;
        }
        return new ArrayList(dnsServers);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case ACTION_PING_DNS /* 327681 */:
                DnsArg dnsArg = (DnsArg) message.obj;
                if (dnsArg.seq == this.mCurrentToken.get()) {
                    try {
                        ActivePing activePing = new ActivePing();
                        InetAddress inetAddress = dnsArg.dns;
                        activePing.internalId = message.arg1;
                        activePing.timeout = message.arg2;
                        activePing.socket = new DatagramSocket();
                        activePing.socket.setSoTimeout(1);
                        try {
                            activePing.socket.setNetworkInterface(NetworkInterface.getByName(getCurrentLinkProperties().getInterfaceName()));
                        } catch (Exception e) {
                            loge("sendDnsPing::Error binding to socket " + e);
                        }
                        activePing.packetId = (short) sRandom.nextInt();
                        byte[] bArr = (byte[]) mDnsQuery.clone();
                        bArr[0] = (byte) (activePing.packetId >> 8);
                        bArr[1] = (byte) activePing.packetId;
                        activePing.socket.send(new DatagramPacket(bArr, bArr.length, inetAddress, 53));
                        this.mActivePings.add(activePing);
                        this.mEventCounter++;
                        sendMessageDelayed(obtainMessage(ACTION_LISTEN_FOR_RESPONSE, this.mEventCounter, 0), 200L);
                        return;
                    } catch (IOException e2) {
                        sendResponse(message.arg1, -9999, -2);
                        return;
                    }
                }
                return;
            case ACTION_LISTEN_FOR_RESPONSE /* 327682 */:
                if (message.arg1 == this.mEventCounter) {
                    for (ActivePing activePing2 : this.mActivePings) {
                        try {
                            byte[] bArr2 = new byte[2];
                            activePing2.socket.receive(new DatagramPacket(bArr2, 2));
                            if (bArr2[0] == ((byte) (activePing2.packetId >> 8)) && bArr2[1] == ((byte) activePing2.packetId)) {
                                activePing2.result = Integer.valueOf((int) (SystemClock.elapsedRealtime() - activePing2.start));
                            }
                        } catch (SocketTimeoutException e3) {
                        } catch (Exception e4) {
                            activePing2.result = -2;
                        }
                    }
                    Iterator<ActivePing> it = this.mActivePings.iterator();
                    while (it.hasNext()) {
                        ActivePing next = it.next();
                        if (next.result != null) {
                            sendResponse(next.internalId, next.packetId, next.result.intValue());
                            next.socket.close();
                            it.remove();
                        } else if (SystemClock.elapsedRealtime() > next.start + next.timeout) {
                            sendResponse(next.internalId, next.packetId, -1);
                            next.socket.close();
                            it.remove();
                        }
                    }
                    if (this.mActivePings.isEmpty()) {
                        return;
                    }
                    sendMessageDelayed(obtainMessage(ACTION_LISTEN_FOR_RESPONSE, this.mEventCounter, 0), 200L);
                    return;
                }
                return;
            case ACTION_CANCEL_ALL_PINGS /* 327683 */:
                for (ActivePing activePing3 : this.mActivePings) {
                    activePing3.socket.close();
                }
                this.mActivePings.clear();
                return;
            default:
                return;
        }
    }

    public int pingDnsAsync(InetAddress inetAddress, int i, int i2) {
        int incrementAndGet = sCounter.incrementAndGet();
        sendMessageDelayed(obtainMessage(ACTION_PING_DNS, incrementAndGet, i, new DnsArg(inetAddress, this.mCurrentToken.get())), i2);
        return incrementAndGet;
    }
}
