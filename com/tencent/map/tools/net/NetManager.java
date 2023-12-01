package com.tencent.map.tools.net;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.adapter.URLNetImpl;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.mapsdk.internal.fb;
import com.tencent.mapsdk.internal.rb;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/NetManager.class */
public class NetManager {
    private static NetManager sInstance;
    private NetAdapter mAdapter;
    private String mGlobalSecretKey;
    private boolean mInited = false;
    private boolean mGlobalForceHttps = true;
    private HashMap<String, String> mGlobalNetFlowRuleList = new HashMap<>();
    private HashSet<Class<? extends rb>> mGlobalNetFlowProcessorClzList = new HashSet<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/NetManager$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23573a;

        static {
            AdapterType.values();
            int[] iArr = new int[3];
            f23573a = iArr;
            try {
                AdapterType adapterType = AdapterType.DEFAULT;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f23573a;
                AdapterType adapterType2 = AdapterType.URL;
                iArr2[1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f23573a;
                AdapterType adapterType3 = AdapterType.Halley;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private NetManager() {
    }

    private NetRequest.NetRequestBuilder builder(NetRequest netRequest) {
        return new NetRequest.NetRequestBuilder(this.mAdapter, this.mGlobalSecretKey, netRequest);
    }

    public static NetAdapter createAdapter(Context context, NetConfig netConfig) {
        NetConfig netConfig2 = netConfig;
        if (netConfig == null) {
            netConfig2 = NetConfig.create().setForceHttps(true).setAdapterType(AdapterType.URL);
        }
        int i = a.f23573a[netConfig2.getAdapterType().ordinal()];
        fb fbVar = new fb();
        fbVar.initNet(context, netConfig2);
        return fbVar;
    }

    public static NetManager getInstance() {
        NetManager netManager;
        synchronized (NetManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new NetManager();
                }
                netManager = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return netManager;
    }

    private void init() {
        NetAdapter netAdapter;
        if (this.mInited || (netAdapter = this.mAdapter) == null) {
            return;
        }
        this.mInited = true;
        this.mGlobalForceHttps = netAdapter.isForceHttps();
        this.mGlobalSecretKey = this.mAdapter.getSecretKey();
        this.mGlobalNetFlowRuleList.putAll(this.mAdapter.getNetFlowRuleList());
        this.mGlobalNetFlowProcessorClzList.addAll(this.mAdapter.getNetFlowProcessor());
    }

    public static void init(Context context, NetConfig netConfig) {
        getInstance().setAdapter(createAdapter(context, netConfig));
    }

    public void appendNetFlowRules(HashMap<String, String> hashMap) {
        NetAdapter netAdapter = this.mAdapter;
        if (netAdapter != null) {
            netAdapter.getNetFlowRuleList().putAll(hashMap);
        }
    }

    public boolean available() {
        return this.mAdapter != null && this.mInited;
    }

    public NetRequest.NetRequestBuilder builder() {
        return builder("");
    }

    public NetRequest.NetRequestBuilder builder(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = this.mGlobalSecretKey;
        }
        NetRequest.NetRequestBuilder netRequestBuilder = new NetRequest.NetRequestBuilder(this.mAdapter, str2);
        netRequestBuilder.forceHttps(this.mGlobalForceHttps);
        return netRequestBuilder;
    }

    public NetResponse doGet(String str, String str2, int i, int i2, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        return builder().url(str).retryNum(i).header(hashMap).userAgent(str2).timeOut(i2).canceler(httpCanceler).doGet();
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i, int i2, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        return builder().url(str).userAgent(str2).postData(bArr).retryNum(i).header(hashMap).timeOut(i2).canceler(httpCanceler).doPost();
    }

    public NetResponse doRequest(NetRequest netRequest) {
        return builder(netRequest).doRequest();
    }

    public NetResponse doStream(NetRequest netRequest) {
        return builder(netRequest).doStream();
    }

    public void setAdapter(Context context, NetAdapter netAdapter) {
        if (netAdapter instanceof URLNetImpl) {
            ((URLNetImpl) netAdapter).setProxyAdapter(createAdapter(context, NetConfig.create()));
        }
        setAdapter(netAdapter);
    }

    public void setAdapter(NetAdapter netAdapter) {
        NetAdapter netAdapter2;
        if (netAdapter == null || (netAdapter2 = this.mAdapter) == netAdapter) {
            return;
        }
        this.mInited = false;
        if (netAdapter2 != null) {
            netAdapter.getNetFlowRuleList().putAll(this.mAdapter.getNetFlowRuleList());
        }
        this.mAdapter = netAdapter;
        init();
    }
}
