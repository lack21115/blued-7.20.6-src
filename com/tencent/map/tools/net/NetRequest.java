package com.tencent.map.tools.net;

import android.text.TextUtils;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.map.tools.net.http.HttpProxy;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.map.tools.net.processor.Processor;
import com.tencent.mapsdk.internal.e7;
import com.tencent.mapsdk.internal.rb;
import com.tencent.mapsdk.internal.tb;
import com.tencent.mapsdk.internal.ub;
import com.tencent.mapsdk.internal.vb;
import com.tencent.mapsdk.internal.xb;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/NetRequest.class */
public class NetRequest {
    public HttpCanceler canceler;
    private File mCacheFile;
    private boolean mIsLogEnable;
    private NetAdapter mNetAdapter;
    private HashSet<Class<? extends rb>> mNetFlowProcessorClz;
    private HashMap<String, String> mNetFlowRules;
    public NetMethod mNetMethod;
    private List<HttpProxyRule> mProxyRules;
    private String mSecretKey;
    public byte[] postData;
    public HttpProxy proxy;
    public int retryMethod;
    public int timeout;
    public String url;
    public final long mRequestId = System.nanoTime();
    public final Map<String, String> mapHeaders = new HashMap();
    public final Set<String> respHeaders = new HashSet();
    public final List<Processor> processors = new ArrayList();
    private boolean mForceHttps = true;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/NetRequest$NetRequestBuilder.class */
    public static class NetRequestBuilder {
        private final NetRequest mNetRequest;

        public NetRequestBuilder(NetAdapter netAdapter, String str) {
            this(netAdapter, str, null);
        }

        public NetRequestBuilder(NetAdapter netAdapter, String str, NetRequest netRequest) {
            if (netRequest == null) {
                this.mNetRequest = new NetRequest().setTimeout(10000).setRetryMethod(1);
            } else {
                this.mNetRequest = netRequest;
            }
            this.mNetRequest.mNetAdapter = netAdapter;
            this.mNetRequest.mSecretKey = str;
            this.mNetRequest.mProxyRules = netAdapter.getProxyRuleList();
            this.mNetRequest.mIsLogEnable = netAdapter.isLogEnable();
            this.mNetRequest.mNetFlowProcessorClz = netAdapter.getNetFlowProcessor();
            this.mNetRequest.mNetFlowRules = netAdapter.getNetFlowRuleList();
        }

        private NetResponse onRequestFinish(NetResponse netResponse) {
            FileOutputStream fileOutputStream;
            Exception e;
            if (netResponse == null) {
                NetResponse netResponse2 = new NetResponse(this.mNetRequest);
                netResponse2.errorCode = -100;
                netResponse2.errorData = "未知".getBytes();
                return netResponse2;
            }
            File file = this.mNetRequest.mCacheFile;
            if (file == null) {
                return netResponse;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (file.isFile()) {
                        if (file.exists()) {
                            file.delete();
                        }
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        NetUtil.writeBytesWithoutClose(netResponse.data, fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        NetUtil.safeClose(fileOutputStream);
                        FileOutputStream fileOutputStream3 = fileOutputStream;
                        netResponse.exception(e);
                        NetUtil.safeClose(fileOutputStream);
                        return netResponse;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        NetUtil.safeClose(fileOutputStream2);
                        throw th;
                    }
                } catch (Exception e3) {
                    fileOutputStream = null;
                    e = e3;
                }
                NetUtil.safeClose(fileOutputStream);
                return netResponse;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private void onRequestStart(String str, NetRequestBuilder netRequestBuilder) {
            netRequestBuilder.addProcessor(new vb(this.mNetRequest.mIsLogEnable));
            netRequestBuilder.addProcessor(tb.a(this.mNetRequest.mForceHttps));
            netRequestBuilder.addProcessor(ub.a((List<HttpProxyRule>) this.mNetRequest.mProxyRules, false));
            netRequestBuilder.addProcessor(xb.a(this.mNetRequest.mSecretKey));
            if (this.mNetRequest.mProxyRules == null || this.mNetRequest.mProxyRules.size() <= 0) {
                Iterator it = this.mNetRequest.mNetFlowProcessorClz.iterator();
                while (it.hasNext()) {
                    try {
                        netRequestBuilder.addProcessor((rb) e7.a((Class) it.next(), this.mNetRequest.mNetFlowRules));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public NetRequestBuilder addProcessor(Processor processor) {
            this.mNetRequest.addProcessor(processor);
            return this;
        }

        public NetRequestBuilder canceler(HttpCanceler httpCanceler) {
            this.mNetRequest.canceler = httpCanceler;
            return this;
        }

        public NetResponse doGet() {
            onRequestStart("doGet", this);
            return onRequestFinish(this.mNetRequest.doGet());
        }

        public NetResponse doPost() {
            onRequestStart("doPost", this);
            return onRequestFinish(this.mNetRequest.doPost());
        }

        public NetResponse doRequest() {
            onRequestStart("doRequest", this);
            return onRequestFinish(this.mNetRequest.doRequest());
        }

        public NetResponse doStream() {
            onRequestStart("doStream", this);
            return onRequestFinish(this.mNetRequest.doStream());
        }

        public NetResponse downloadTo(File file) {
            onRequestStart("downloadTo[" + file + "]", this);
            return file(file).doGet();
        }

        public NetRequestBuilder file(File file) {
            this.mNetRequest.mCacheFile = file;
            return this;
        }

        public NetRequestBuilder forceHttps(boolean z) {
            this.mNetRequest.mForceHttps = z;
            return this;
        }

        public NetRequest getNetRequest() {
            return this.mNetRequest;
        }

        public NetRequestBuilder gzip() {
            header("Accept-Encoding", "gzip");
            return this;
        }

        public NetRequestBuilder header(String str, String str2) {
            this.mNetRequest.setMapHeaders(str, str2);
            return this;
        }

        public NetRequestBuilder header(HashMap<String, String> hashMap) {
            this.mNetRequest.setMapHeaders(hashMap);
            return this;
        }

        public NetRequestBuilder nonce(String str) {
            this.mNetRequest.setNonce(str);
            return this;
        }

        public NetRequestBuilder postData(byte[] bArr) {
            this.mNetRequest.postData = bArr;
            return this;
        }

        public NetRequestBuilder proxy(HttpProxy httpProxy) {
            this.mNetRequest.proxy = httpProxy;
            return this;
        }

        public NetRequestBuilder retryNum(int i) {
            this.mNetRequest.retryMethod = i;
            return this;
        }

        public NetRequestBuilder startTag(String str) {
            this.mNetRequest.setStart(str);
            return this;
        }

        public NetRequestBuilder timeOut(int i) {
            this.mNetRequest.timeout = i;
            return this;
        }

        public NetRequestBuilder timestamp(String str) {
            this.mNetRequest.setTimeStamp(str);
            return this;
        }

        public String toString() {
            return "NetRequestBuilder{, mRequestId=" + this.mNetRequest.mRequestId + ", mNetRequest=" + this.mNetRequest + '}';
        }

        public NetRequestBuilder token(String str) {
            this.mNetRequest.setToken(str);
            return this;
        }

        public NetRequestBuilder url(String str) {
            this.mNetRequest.url = str;
            return this;
        }

        public NetRequestBuilder userAgent(String str) {
            this.mNetRequest.setUserAgent(str);
            return this;
        }
    }

    public NetRequest() {
    }

    public NetRequest(NetMethod netMethod, String str) {
        this.mNetMethod = netMethod;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse doGet() {
        setNetMethod(NetMethod.GET);
        return this.mNetAdapter.doRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse doPost() {
        setNetMethod(NetMethod.POST);
        return this.mNetAdapter.doRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse doRequest() {
        return this.mNetAdapter.doRequest(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetResponse doStream() {
        setNetMethod(NetMethod.GET);
        return this.mNetAdapter.openStream(this);
    }

    public NetRequest addProcessor(Processor processor) {
        this.processors.add(processor);
        return this;
    }

    public NetRequest setCanceler(HttpCanceler httpCanceler) {
        this.canceler = httpCanceler;
        return this;
    }

    public NetRequest setMapHeaders(String str, String str2) {
        this.mapHeaders.put(str, str2);
        return this;
    }

    public NetRequest setMapHeaders(Map<String, String> map) {
        if (map == null) {
            return this;
        }
        this.mapHeaders.putAll(map);
        return this;
    }

    public NetRequest setNetMethod(NetMethod netMethod) {
        this.mNetMethod = netMethod;
        return this;
    }

    public NetRequest setNonce(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("nonce", str);
        }
        return this;
    }

    public NetRequest setPostData(byte[] bArr) {
        this.postData = bArr;
        return this;
    }

    public NetRequest setRespHeaders(String... strArr) {
        this.respHeaders.addAll(Arrays.asList((Object[]) strArr.clone()));
        return this;
    }

    public NetRequest setRetryMethod(int i) {
        this.retryMethod = i;
        return this;
    }

    public NetRequest setStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, String> map = this.mapHeaders;
            map.put("Range", "bytes=" + str + "-");
        }
        return this;
    }

    public NetRequest setTimeStamp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("timestamp", str);
        }
        return this;
    }

    public NetRequest setTimeout(int i) {
        this.timeout = i;
        return this;
    }

    public NetRequest setToken(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("Sign", str);
        }
        return this;
    }

    public NetRequest setUrl(String str) {
        this.url = str;
        return this;
    }

    public NetRequest setUserAgent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mapHeaders.put("User-Agent", str);
        }
        return this;
    }

    public String toString() {
        return "NetRequest{mRequestId=" + this.mRequestId + ", mNetMethod=" + this.mNetMethod + ", url='" + this.url + "', postData=" + Arrays.toString(this.postData) + ", retryMethod=" + this.retryMethod + ", mapHeaders=" + this.mapHeaders + ", respHeaders=" + this.respHeaders + ", processorSet=" + this.processors + ", canceler=" + this.canceler + ", timeout=" + this.timeout + ", proxy=" + this.proxy + '}';
    }
}
