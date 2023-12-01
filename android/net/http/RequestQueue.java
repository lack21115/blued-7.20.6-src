package android.net.http;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.WebAddress;
import android.util.Log;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.HttpHost;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/RequestQueue.class */
public class RequestQueue implements RequestFeeder {
    private static final int CONNECTION_COUNT = 4;
    private final ActivePool mActivePool;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final LinkedHashMap<HttpHost, LinkedList<Request>> mPending;
    private BroadcastReceiver mProxyChangeReceiver;
    private HttpHost mProxyHost;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/http/RequestQueue$ActivePool.class */
    public class ActivePool implements ConnectionManager {
        private int mConnectionCount;
        IdleCache mIdleCache = new IdleCache();
        ConnectionThread[] mThreads;
        private int mTotalConnection;
        private int mTotalRequest;

        ActivePool(int i) {
            this.mConnectionCount = i;
            this.mThreads = new ConnectionThread[this.mConnectionCount];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mConnectionCount) {
                    return;
                }
                this.mThreads[i3] = new ConnectionThread(RequestQueue.this.mContext, i3, this, RequestQueue.this);
                i2 = i3 + 1;
            }
        }

        static /* synthetic */ int access$408(ActivePool activePool) {
            int i = activePool.mTotalRequest;
            activePool.mTotalRequest = i + 1;
            return i;
        }

        void disablePersistence() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mConnectionCount) {
                    this.mIdleCache.clear();
                    return;
                }
                Connection connection = this.mThreads[i2].mConnection;
                if (connection != null) {
                    connection.setCanPersist(false);
                }
                i = i2 + 1;
            }
        }

        @Override // android.net.http.RequestQueue.ConnectionManager
        public Connection getConnection(Context context, HttpHost httpHost) {
            HttpHost determineHost = RequestQueue.this.determineHost(httpHost);
            Connection connection = this.mIdleCache.getConnection(determineHost);
            Connection connection2 = connection;
            if (connection == null) {
                this.mTotalConnection++;
                connection2 = Connection.getConnection(RequestQueue.this.mContext, determineHost, RequestQueue.this.mProxyHost, RequestQueue.this);
            }
            return connection2;
        }

        @Override // android.net.http.RequestQueue.ConnectionManager
        public HttpHost getProxyHost() {
            return RequestQueue.this.mProxyHost;
        }

        ConnectionThread getThread(HttpHost httpHost) {
            synchronized (RequestQueue.this) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mThreads.length) {
                        return null;
                    }
                    ConnectionThread connectionThread = this.mThreads[i2];
                    Connection connection = connectionThread.mConnection;
                    if (connection != null && connection.mHost.equals(httpHost)) {
                        return connectionThread;
                    }
                    i = i2 + 1;
                }
            }
        }

        void logState() {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mConnectionCount) {
                    HttpLog.v(sb.toString());
                    return;
                } else {
                    sb.append(this.mThreads[i2] + "\n");
                    i = i2 + 1;
                }
            }
        }

        @Override // android.net.http.RequestQueue.ConnectionManager
        public boolean recycleConnection(Connection connection) {
            return this.mIdleCache.cacheConnection(connection.getHost(), connection);
        }

        void shutdown() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mConnectionCount) {
                    return;
                }
                this.mThreads[i2].requestStop();
                i = i2 + 1;
            }
        }

        void startConnectionThread() {
            synchronized (RequestQueue.this) {
                RequestQueue.this.notify();
            }
        }

        public void startTiming() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mConnectionCount) {
                    this.mTotalRequest = 0;
                    this.mTotalConnection = 0;
                    return;
                }
                ConnectionThread connectionThread = this.mThreads[i2];
                connectionThread.mCurrentThreadTime = -1L;
                connectionThread.mTotalThreadTime = 0L;
                i = i2 + 1;
            }
        }

        void startup() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mConnectionCount) {
                    return;
                }
                this.mThreads[i2].start();
                i = i2 + 1;
            }
        }

        public void stopTiming() {
            int i = 0;
            int i2 = 0;
            while (i2 < this.mConnectionCount) {
                ConnectionThread connectionThread = this.mThreads[i2];
                int i3 = i;
                if (connectionThread.mCurrentThreadTime != -1) {
                    i3 = (int) (i + connectionThread.mTotalThreadTime);
                }
                connectionThread.mCurrentThreadTime = 0L;
                i2++;
                i = i3;
            }
            Log.d("Http", "Http thread used " + i + " ms  for " + this.mTotalRequest + " requests and " + this.mTotalConnection + " new connections");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/http/RequestQueue$ConnectionManager.class */
    public interface ConnectionManager {
        Connection getConnection(Context context, HttpHost httpHost);

        HttpHost getProxyHost();

        boolean recycleConnection(Connection connection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/http/RequestQueue$SyncFeeder.class */
    public static class SyncFeeder implements RequestFeeder {
        private Request mRequest;

        SyncFeeder() {
        }

        @Override // android.net.http.RequestFeeder
        public Request getRequest() {
            Request request = this.mRequest;
            this.mRequest = null;
            return request;
        }

        @Override // android.net.http.RequestFeeder
        public Request getRequest(HttpHost httpHost) {
            return getRequest();
        }

        @Override // android.net.http.RequestFeeder
        public boolean haveRequest(HttpHost httpHost) {
            return this.mRequest != null;
        }

        @Override // android.net.http.RequestFeeder
        public void requeueRequest(Request request) {
            this.mRequest = request;
        }
    }

    public RequestQueue(Context context) {
        this(context, 4);
    }

    public RequestQueue(Context context, int i) {
        this.mProxyHost = null;
        this.mContext = context;
        this.mPending = new LinkedHashMap<>(32);
        this.mActivePool = new ActivePool(i);
        this.mActivePool.startup();
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpHost determineHost(HttpHost httpHost) {
        return (this.mProxyHost == null || "https".equals(httpHost.getSchemeName())) ? httpHost : this.mProxyHost;
    }

    private Request removeFirst(LinkedHashMap<HttpHost, LinkedList<Request>> linkedHashMap) {
        Request request = null;
        Iterator<Map.Entry<HttpHost, LinkedList<Request>>> it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<HttpHost, LinkedList<Request>> next = it.next();
            LinkedList<Request> value = next.getValue();
            Request removeFirst = value.removeFirst();
            request = removeFirst;
            if (value.isEmpty()) {
                linkedHashMap.remove(next.getKey());
                request = removeFirst;
            }
        }
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProxyConfig() {
        synchronized (this) {
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                String host = Proxy.getHost(this.mContext);
                if (host == null) {
                    this.mProxyHost = null;
                } else {
                    this.mActivePool.disablePersistence();
                    this.mProxyHost = new HttpHost(host, Proxy.getPort(this.mContext), "http");
                }
            } else {
                this.mProxyHost = null;
            }
        }
    }

    public void disablePlatformNotifications() {
        synchronized (this) {
            if (this.mProxyChangeReceiver != null) {
                this.mContext.unregisterReceiver(this.mProxyChangeReceiver);
                this.mProxyChangeReceiver = null;
            }
        }
    }

    void dump() {
        synchronized (this) {
            HttpLog.v("dump()");
            StringBuilder sb = new StringBuilder();
            if (!this.mPending.isEmpty()) {
                Iterator<Map.Entry<HttpHost, LinkedList<Request>>> it = this.mPending.entrySet().iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<HttpHost, LinkedList<Request>> next = it.next();
                    StringBuilder sb2 = new StringBuilder("p" + i2 + " " + next.getKey().getHostName() + " ");
                    next.getValue().listIterator(0);
                    while (it.hasNext()) {
                        sb2.append(((Request) it.next()) + " ");
                    }
                    sb.append((CharSequence) sb2);
                    sb.append("\n");
                    i = i2 + 1;
                }
            }
            HttpLog.v(sb.toString());
        }
    }

    public void enablePlatformNotifications() {
        synchronized (this) {
            if (this.mProxyChangeReceiver == null) {
                this.mProxyChangeReceiver = new BroadcastReceiver() { // from class: android.net.http.RequestQueue.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        RequestQueue.this.setProxyConfig();
                    }
                };
                this.mContext.registerReceiver(this.mProxyChangeReceiver, new IntentFilter(Proxy.PROXY_CHANGE_ACTION));
            }
            setProxyConfig();
        }
    }

    public HttpHost getProxyHost() {
        return this.mProxyHost;
    }

    @Override // android.net.http.RequestFeeder
    public Request getRequest() {
        Request request;
        synchronized (this) {
            request = null;
            if (!this.mPending.isEmpty()) {
                request = removeFirst(this.mPending);
            }
        }
        return request;
    }

    @Override // android.net.http.RequestFeeder
    public Request getRequest(HttpHost httpHost) {
        Request request;
        synchronized (this) {
            request = null;
            if (this.mPending.containsKey(httpHost)) {
                LinkedList<Request> linkedList = this.mPending.get(httpHost);
                Request removeFirst = linkedList.removeFirst();
                request = removeFirst;
                if (linkedList.isEmpty()) {
                    this.mPending.remove(httpHost);
                    request = removeFirst;
                }
            }
        }
        return request;
    }

    @Override // android.net.http.RequestFeeder
    public boolean haveRequest(HttpHost httpHost) {
        boolean containsKey;
        synchronized (this) {
            containsKey = this.mPending.containsKey(httpHost);
        }
        return containsKey;
    }

    public RequestHandle queueRequest(String str, WebAddress webAddress, String str2, Map<String, String> map, EventHandler eventHandler, InputStream inputStream, int i) {
        LoggingEventHandler loggingEventHandler = eventHandler;
        if (eventHandler == null) {
            loggingEventHandler = new LoggingEventHandler();
        }
        Request request = new Request(str2, new HttpHost(webAddress.getHost(), webAddress.getPort(), webAddress.getScheme()), this.mProxyHost, webAddress.getPath(), inputStream, i, loggingEventHandler, map);
        queueRequest(request, false);
        ActivePool.access$408(this.mActivePool);
        this.mActivePool.startConnectionThread();
        return new RequestHandle(this, str, webAddress, str2, map, inputStream, i, request);
    }

    public RequestHandle queueRequest(String str, String str2, Map<String, String> map, EventHandler eventHandler, InputStream inputStream, int i) {
        return queueRequest(str, new WebAddress(str), str2, map, eventHandler, inputStream, i);
    }

    protected void queueRequest(Request request, boolean z) {
        LinkedList<Request> linkedList;
        synchronized (this) {
            HttpHost httpHost = request.mProxyHost == null ? request.mHost : request.mProxyHost;
            if (this.mPending.containsKey(httpHost)) {
                linkedList = this.mPending.get(httpHost);
            } else {
                LinkedList<Request> linkedList2 = new LinkedList<>();
                this.mPending.put(httpHost, linkedList2);
                linkedList = linkedList2;
            }
            if (z) {
                linkedList.addFirst(request);
            } else {
                linkedList.add(request);
            }
        }
    }

    public RequestHandle queueSynchronousRequest(String str, WebAddress webAddress, String str2, Map<String, String> map, EventHandler eventHandler, InputStream inputStream, int i) {
        HttpHost httpHost = new HttpHost(webAddress.getHost(), webAddress.getPort(), webAddress.getScheme());
        return new RequestHandle(this, str, webAddress, str2, map, inputStream, i, new Request(str2, httpHost, this.mProxyHost, webAddress.getPath(), inputStream, i, eventHandler, map), Connection.getConnection(this.mContext, determineHost(httpHost), this.mProxyHost, new SyncFeeder()));
    }

    boolean requestsPending() {
        boolean z;
        synchronized (this) {
            z = !this.mPending.isEmpty();
        }
        return z;
    }

    @Override // android.net.http.RequestFeeder
    public void requeueRequest(Request request) {
        queueRequest(request, true);
    }

    public void shutdown() {
        this.mActivePool.shutdown();
    }

    public void startTiming() {
        this.mActivePool.startTiming();
    }

    public void stopTiming() {
        this.mActivePool.stopTiming();
    }
}
