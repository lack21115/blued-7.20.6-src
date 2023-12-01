package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.system.ErrnoException;
import com.android.okhttp.ConnectionPool;
import com.android.okhttp.HostResolver;
import com.android.okhttp.HttpHandler;
import com.android.okhttp.HttpsHandler;
import com.android.okhttp.OkHttpClient;
import com.huawei.hms.ads.fw;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

/* loaded from: source-9557208-dex2jar.jar:android/net/Network.class */
public class Network implements Parcelable {
    public static final Parcelable.Creator<Network> CREATOR;
    private static final boolean httpKeepAlive = Boolean.parseBoolean(System.getProperty("http.keepAlive", fw.Code));
    private static final long httpKeepAliveDurationMs;
    private static final int httpMaxConnections;
    public final int netId;
    private volatile NetworkBoundSocketFactory mNetworkBoundSocketFactory = null;
    private volatile ConnectionPool mConnectionPool = null;
    private volatile HostResolver mHostResolver = null;
    private Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Network$NetworkBoundSocketFactory.class */
    public class NetworkBoundSocketFactory extends SocketFactory {
        private final int mNetId;

        public NetworkBoundSocketFactory(int i) {
            this.mNetId = i;
        }

        private Socket connectToHost(String str, int i, SocketAddress socketAddress) throws IOException {
            InetAddress[] allByName = Network.this.getAllByName(str);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= allByName.length) {
                    throw new UnknownHostException(str);
                }
                try {
                    Socket createSocket = createSocket();
                    if (socketAddress != null) {
                        createSocket.bind(socketAddress);
                    }
                    createSocket.connect(new InetSocketAddress(allByName[i3], i));
                    return createSocket;
                } catch (IOException e) {
                    if (i3 == allByName.length - 1) {
                        throw e;
                    }
                    i2 = i3 + 1;
                }
            }
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket() throws IOException {
            Socket socket = new Socket();
            Network.this.bindSocket(socket);
            return socket;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) throws IOException {
            return connectToHost(str, i, null);
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
            return connectToHost(str, i, new InetSocketAddress(inetAddress, i2));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            Socket createSocket = createSocket();
            createSocket.connect(new InetSocketAddress(inetAddress, i));
            return createSocket;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            Socket createSocket = createSocket();
            createSocket.bind(new InetSocketAddress(inetAddress2, i2));
            createSocket.connect(new InetSocketAddress(inetAddress, i));
            return createSocket;
        }
    }

    static {
        httpMaxConnections = httpKeepAlive ? Integer.parseInt(System.getProperty("http.maxConnections", "5")) : 0;
        httpKeepAliveDurationMs = Long.parseLong(System.getProperty("http.keepAliveDuration", "300000"));
        CREATOR = new Parcelable.Creator<Network>() { // from class: android.net.Network.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Network createFromParcel(Parcel parcel) {
                return new Network(parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Network[] newArray(int i) {
                return new Network[i];
            }
        };
    }

    public Network(int i) {
        this.netId = i;
    }

    public Network(Network network) {
        this.netId = network.netId;
    }

    private void bindSocketFd(FileDescriptor fileDescriptor) throws IOException {
        int bindSocketToNetwork = NetworkUtils.bindSocketToNetwork(fileDescriptor.getInt$(), this.netId);
        if (bindSocketToNetwork != 0) {
            throw new ErrnoException("Binding socket to network " + this.netId, -bindSocketToNetwork).rethrowAsSocketException();
        }
    }

    private void maybeInitHttpClient() {
        synchronized (this.mLock) {
            if (this.mHostResolver == null) {
                this.mHostResolver = new HostResolver() { // from class: android.net.Network.1
                    public InetAddress[] getAllByName(String str) throws UnknownHostException {
                        return Network.this.getAllByName(str);
                    }
                };
            }
            if (this.mConnectionPool == null) {
                this.mConnectionPool = new ConnectionPool(httpMaxConnections, httpKeepAliveDurationMs);
            }
        }
    }

    public void bindSocket(DatagramSocket datagramSocket) throws IOException {
        if (datagramSocket.isConnected()) {
            throw new SocketException("Socket is connected");
        }
        datagramSocket.getReuseAddress();
        bindSocketFd(datagramSocket.getFileDescriptor$());
    }

    public void bindSocket(Socket socket) throws IOException {
        if (socket.isConnected()) {
            throw new SocketException("Socket is connected");
        }
        socket.getReuseAddress();
        bindSocketFd(socket.getFileDescriptor$());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Network) && this.netId == ((Network) obj).netId;
    }

    public InetAddress[] getAllByName(String str) throws UnknownHostException {
        return InetAddress.getAllByNameOnNet(str, this.netId);
    }

    public InetAddress getByName(String str) throws UnknownHostException {
        return InetAddress.getByNameOnNet(str, this.netId);
    }

    public SocketFactory getSocketFactory() {
        if (this.mNetworkBoundSocketFactory == null) {
            synchronized (this.mLock) {
                if (this.mNetworkBoundSocketFactory == null) {
                    this.mNetworkBoundSocketFactory = new NetworkBoundSocketFactory(this.netId);
                }
            }
        }
        return this.mNetworkBoundSocketFactory;
    }

    public int hashCode() {
        return this.netId * 11;
    }

    public URLConnection openConnection(URL url) throws IOException {
        ConnectivityManager connectivityManager = ConnectivityManager.getInstance();
        ProxyInfo globalProxy = connectivityManager.getGlobalProxy();
        ProxyInfo proxyInfo = globalProxy;
        if (globalProxy == null) {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(this);
            proxyInfo = globalProxy;
            if (linkProperties != null) {
                proxyInfo = linkProperties.getHttpProxy();
            }
        }
        return openConnection(url, proxyInfo != null ? proxyInfo.makeProxy() : java.net.Proxy.NO_PROXY);
    }

    public URLConnection openConnection(URL url, java.net.Proxy proxy) throws IOException {
        OkHttpClient createHttpsOkHttpClient;
        if (proxy == null) {
            throw new IllegalArgumentException("proxy is null");
        }
        maybeInitHttpClient();
        String protocol = url.getProtocol();
        if (protocol.equals("http")) {
            createHttpsOkHttpClient = HttpHandler.createHttpOkHttpClient(proxy);
        } else if (!protocol.equals("https")) {
            throw new MalformedURLException("Invalid URL or unrecognized protocol " + protocol);
        } else {
            createHttpsOkHttpClient = HttpsHandler.createHttpsOkHttpClient(proxy);
        }
        return createHttpsOkHttpClient.setSocketFactory(getSocketFactory()).setHostResolver(this.mHostResolver).setConnectionPool(this.mConnectionPool).open(url);
    }

    public String toString() {
        return Integer.toString(this.netId);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.netId);
    }
}
