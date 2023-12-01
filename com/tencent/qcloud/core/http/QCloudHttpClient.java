package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.QCloudTask;
import com.tencent.qcloud.core.task.RetryStrategy;
import com.tencent.qcloud.core.task.TaskManager;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/QCloudHttpClient.class */
public final class QCloudHttpClient {
    public static final String HTTP_LOG_TAG = "QCloudHttp";
    public static final String QUIC_LOG_TAG = "QCloudQuic";
    private static volatile QCloudHttpClient gDefault;
    private static Map<Integer, NetworkClient> networkClientMap = new ConcurrentHashMap(2);
    private final ConnectionRepository connectionRepository;
    private boolean dnsCache;
    private final Map<String, List<InetAddress>> dnsMap;
    private final HttpLogger httpLogger;
    private Dns mDns;
    private EventListener.Factory mEventListenerFactory;
    private HostnameVerifier mHostnameVerifier;
    private String networkClientType;
    private final TaskManager taskManager;
    private final Set<String> verifiedHost;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/QCloudHttpClient$Builder.class */
    public static final class Builder {
        OkHttpClient.Builder mBuilder;
        NetworkClient networkClient;
        QCloudHttpRetryHandler qCloudHttpRetryHandler;
        RetryStrategy retryStrategy;
        int connectionTimeout = 15000;
        int socketTimeout = 30000;
        boolean enableDebugLog = false;
        List<String> prefetchHost = new LinkedList();
        boolean dnsCache = false;

        public Builder addPrefetchHost(String str) {
            this.prefetchHost.add(str);
            return this;
        }

        public QCloudHttpClient build() {
            if (this.retryStrategy == null) {
                this.retryStrategy = RetryStrategy.DEFAULT;
            }
            QCloudHttpRetryHandler qCloudHttpRetryHandler = this.qCloudHttpRetryHandler;
            if (qCloudHttpRetryHandler != null) {
                this.retryStrategy.setRetryHandler(qCloudHttpRetryHandler);
            }
            if (this.mBuilder == null) {
                this.mBuilder = new OkHttpClient.Builder();
            }
            return new QCloudHttpClient(this);
        }

        public Builder dnsCache(boolean z) {
            this.dnsCache = z;
            return this;
        }

        public Builder enableDebugLog(boolean z) {
            this.enableDebugLog = z;
            return this;
        }

        public Builder setConnectionTimeout(int i) {
            if (i >= 3000) {
                this.connectionTimeout = i;
                return this;
            }
            throw new IllegalArgumentException("connection timeout must be larger than 3 seconds.");
        }

        public Builder setInheritBuilder(OkHttpClient.Builder builder) {
            this.mBuilder = builder;
            return this;
        }

        public Builder setNetworkClient(NetworkClient networkClient) {
            this.networkClient = networkClient;
            return this;
        }

        public Builder setQCloudHttpRetryHandler(QCloudHttpRetryHandler qCloudHttpRetryHandler) {
            this.qCloudHttpRetryHandler = qCloudHttpRetryHandler;
            return this;
        }

        public Builder setRetryStrategy(RetryStrategy retryStrategy) {
            this.retryStrategy = retryStrategy;
            return this;
        }

        public Builder setSocketTimeout(int i) {
            if (i >= 3000) {
                this.socketTimeout = i;
                return this;
            }
            throw new IllegalArgumentException("socket timeout must be larger than 3 seconds.");
        }
    }

    private QCloudHttpClient(Builder builder) {
        this.networkClientType = OkHttpClientImpl.class.getName();
        this.dnsCache = true;
        this.mHostnameVerifier = new HostnameVerifier() { // from class: com.tencent.qcloud.core.http.QCloudHttpClient.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                if (QCloudHttpClient.this.verifiedHost.size() > 0) {
                    for (String str2 : QCloudHttpClient.this.verifiedHost) {
                        if (HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession)) {
                            return true;
                        }
                    }
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
        };
        this.mDns = new Dns() { // from class: com.tencent.qcloud.core.http.QCloudHttpClient.2
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String str) throws UnknownHostException {
                List<InetAddress> list = QCloudHttpClient.this.dnsMap.containsKey(str) ? (List) QCloudHttpClient.this.dnsMap.get(str) : null;
                List<InetAddress> list2 = list;
                if (list == null) {
                    try {
                        list2 = Dns.SYSTEM.lookup(str);
                    } catch (UnknownHostException e) {
                        QCloudLogger.w(QCloudHttpClient.HTTP_LOG_TAG, "system dns failed, retry cache dns records.", new Object[0]);
                        list2 = list;
                    }
                }
                if (list2 == null && !QCloudHttpClient.this.dnsCache) {
                    throw new UnknownHostException("can not resolve host name " + str);
                }
                List<InetAddress> list3 = list2;
                if (list2 == null) {
                    try {
                        list3 = QCloudHttpClient.this.connectionRepository.getDnsRecord(str);
                    } catch (UnknownHostException e2) {
                        QCloudLogger.w(QCloudHttpClient.HTTP_LOG_TAG, "Not found dns in cache records.", new Object[0]);
                        list3 = list2;
                    }
                }
                if (list3 != null) {
                    ConnectionRepository.getInstance().insertDnsRecordCache(str, list3);
                    return list3;
                }
                throw new UnknownHostException(str);
            }
        };
        this.mEventListenerFactory = new EventListener.Factory() { // from class: com.tencent.qcloud.core.http.QCloudHttpClient.3
            @Override // okhttp3.EventListener.Factory
            public EventListener create(Call call) {
                return new CallMetricsListener(call);
            }
        };
        this.verifiedHost = new HashSet(5);
        this.dnsMap = new ConcurrentHashMap(3);
        this.taskManager = TaskManager.getInstance();
        this.connectionRepository = ConnectionRepository.getInstance();
        this.httpLogger = new HttpLogger(false);
        setDebuggable(false);
        NetworkClient networkClient = builder.networkClient;
        OkHttpClientImpl okHttpClientImpl = networkClient == null ? new OkHttpClientImpl() : networkClient;
        String name = okHttpClientImpl.getClass().getName();
        this.networkClientType = name;
        int hashCode = name.hashCode();
        if (!networkClientMap.containsKey(Integer.valueOf(hashCode))) {
            okHttpClientImpl.init(builder, hostnameVerifier(), this.mDns, this.httpLogger);
            networkClientMap.put(Integer.valueOf(hashCode), okHttpClientImpl);
        }
        this.connectionRepository.addPrefetchHosts(builder.prefetchHost);
        this.connectionRepository.init();
    }

    public static QCloudHttpClient getDefault() {
        if (gDefault == null) {
            synchronized (QCloudHttpClient.class) {
                try {
                    if (gDefault == null) {
                        gDefault = new Builder().build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return gDefault;
    }

    private <T> HttpTask<T> handleRequest(HttpRequest<T> httpRequest, QCloudCredentialProvider qCloudCredentialProvider) {
        return new HttpTask<>(httpRequest, qCloudCredentialProvider, networkClientMap.get(Integer.valueOf(this.networkClientType.hashCode())));
    }

    private HostnameVerifier hostnameVerifier() {
        return this.mHostnameVerifier;
    }

    public void addDnsRecord(String str, String[] strArr) throws UnknownHostException {
        if (strArr.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.dnsMap.put(str, arrayList);
                return;
            } else {
                arrayList.add(InetAddress.getByName(strArr[i2]));
                i = i2 + 1;
            }
        }
    }

    public void addVerifiedHost(String str) {
        if (str != null) {
            this.verifiedHost.add(str);
        }
    }

    public List<HttpTask> getTasksByTag(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        for (QCloudTask qCloudTask : this.taskManager.snapshot()) {
            if ((qCloudTask instanceof HttpTask) && str.equals(qCloudTask.getTag())) {
                arrayList.add((HttpTask) qCloudTask);
            }
        }
        return arrayList;
    }

    public <T> HttpTask<T> resolveRequest(HttpRequest<T> httpRequest) {
        return handleRequest(httpRequest, null);
    }

    public <T> HttpTask<T> resolveRequest(QCloudHttpRequest<T> qCloudHttpRequest, QCloudCredentialProvider qCloudCredentialProvider) {
        return handleRequest(qCloudHttpRequest, qCloudCredentialProvider);
    }

    public void setDebuggable(boolean z) {
        this.httpLogger.setDebug(z);
    }

    public void setNetworkClientType(Builder builder) {
        NetworkClient networkClient = builder.networkClient;
        if (networkClient != null) {
            String name = networkClient.getClass().getName();
            int hashCode = name.hashCode();
            if (!networkClientMap.containsKey(Integer.valueOf(hashCode))) {
                networkClient.init(builder, hostnameVerifier(), this.mDns, this.httpLogger);
                networkClientMap.put(Integer.valueOf(hashCode), networkClient);
            }
            this.networkClientType = name;
        }
    }
}
