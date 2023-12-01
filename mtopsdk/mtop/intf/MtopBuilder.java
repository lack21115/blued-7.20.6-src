package mtopsdk.mtop.intf;

import android.os.Handler;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.DefaultMtopCallback;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.listener.MtopBaseListenerProxy;
import mtopsdk.mtop.common.listener.MtopCacheListenerProxy;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/intf/MtopBuilder.class */
public class MtopBuilder {
    private static final String TAG = "mtopsdk.MtopBuilder";
    public MtopRequest request;
    public Object requestContext = null;
    public MtopNetworkProp mtopProp = new MtopNetworkProp();
    public MtopListener listener = null;
    private String fullBaseUrl = null;
    private String customDomain = null;
    private Handler handler = null;
    protected MtopStatistics stat = new MtopStatistics();

    public MtopBuilder(Object obj, String str) {
        this.request = MtopConvert.a(obj);
        this.mtopProp.g = str;
    }

    public MtopBuilder(IMTOPDataObject iMTOPDataObject, String str) {
        this.request = MtopConvert.a(iMTOPDataObject);
        this.mtopProp.g = str;
    }

    public MtopBuilder(MtopRequest mtopRequest, String str) {
        this.request = mtopRequest;
        this.mtopProp.g = str;
    }

    private MtopBaseListenerProxy createListenerProxy(MtopListener mtopListener) {
        if (mtopListener == null) {
            return new MtopBaseListenerProxy(new DefaultMtopCallback());
        }
        return mtopListener instanceof MtopCallback.MtopCacheListener ? new MtopCacheListenerProxy(mtopListener) : new MtopBaseListenerProxy(mtopListener);
    }

    private MtopProxy createMtopProxy(MtopListener mtopListener) {
        MtopProxy mtopProxy = new MtopProxy(this.request, this.mtopProp, this.requestContext, mtopListener);
        MtopRequest mtopRequest = this.request;
        if (mtopRequest != null) {
            this.stat.p = mtopRequest.f();
        }
        mtopProxy.h = this.stat;
        String str = this.customDomain;
        if (str != null) {
            mtopProxy.b(str);
        }
        String str2 = this.fullBaseUrl;
        if (str2 != null) {
            mtopProxy.a(str2);
        }
        return mtopProxy;
    }

    private boolean isUseCache() {
        return this.mtopProp.h || (this.listener instanceof MtopCallback.MtopCacheListener);
    }

    private boolean isUseWua() {
        return this.mtopProp.j >= 0;
    }

    public MtopBuilder addHttpQueryParameter(String str, String str2) {
        if (!StringUtils.b(str) && !StringUtils.b(str2)) {
            if (this.mtopProp.k == null) {
                this.mtopProp.k = new HashMap();
            }
            this.mtopProp.k.put(str, str2);
            return this;
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.a(TAG, "[addHttpQueryParameter]add HttpQueryParameter error,key=" + str + ",value=" + str2);
        }
        return this;
    }

    public MtopBuilder addListener(MtopListener mtopListener) {
        this.listener = mtopListener;
        return this;
    }

    public MtopBuilder addMteeUa(String str) {
        addHttpQueryParameter("ua", str);
        return this;
    }

    public ApiID asyncRequest() {
        this.stat.a();
        final MtopProxy createMtopProxy = createMtopProxy(this.listener);
        if (MtopUtils.b() && (isUseCache() || isUseWua())) {
            final ApiID apiID = new ApiID(null, createMtopProxy);
            MtopSDKThreadPoolExecutorFactory.b().submit(new Runnable() { // from class: mtopsdk.mtop.intf.MtopBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    apiID.a(createMtopProxy.a(MtopBuilder.this.handler).a());
                }
            });
            return apiID;
        }
        return createMtopProxy.a(this.handler);
    }

    public MtopBuilder forceRefreshCache() {
        this.mtopProp.i = true;
        return this;
    }

    public Object getReqContext() {
        return this.requestContext;
    }

    public MtopBuilder handler(Handler handler) {
        this.handler = handler;
        return this;
    }

    public MtopBuilder headers(Map map) {
        if (map != null && !map.isEmpty()) {
            if (this.mtopProp.e != null) {
                this.mtopProp.e.putAll(map);
                return this;
            }
            this.mtopProp.e = map;
        }
        return this;
    }

    protected void mtopCommitStatData(boolean z) {
        this.stat.a = z;
    }

    public MtopBuilder protocol(ProtocolEnum protocolEnum) {
        if (protocolEnum != null) {
            this.mtopProp.a = protocolEnum;
        }
        return this;
    }

    public MtopBuilder reqContext(Object obj) {
        this.requestContext = obj;
        return this;
    }

    public MtopBuilder reqMethod(MethodEnum methodEnum) {
        if (methodEnum != null) {
            this.mtopProp.b = methodEnum;
        }
        return this;
    }

    public MtopBuilder retryTime(int i) {
        this.mtopProp.d = i;
        return this;
    }

    public MtopBuilder setBizId(int i) {
        this.mtopProp.n = i;
        return this;
    }

    public MtopBuilder setCacheControlNoCache() {
        Map map = this.mtopProp.e;
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
        }
        hashMap.put("cache-control", "no-cache");
        this.mtopProp.e = hashMap;
        return this;
    }

    public MtopBuilder setConnectionTimeoutMilliSecond(int i) {
        if (i > 0) {
            this.mtopProp.l = i;
        }
        return this;
    }

    public MtopBuilder setCustomDomain(String str) {
        if (str != null) {
            this.customDomain = str;
        }
        return this;
    }

    public MtopBuilder setJsonType(JsonTypeEnum jsonTypeEnum) {
        if (jsonTypeEnum != null) {
            addHttpQueryParameter("type", jsonTypeEnum.a());
        }
        return this;
    }

    public MtopBuilder setReqUserId(String str) {
        this.mtopProp.q = str;
        return this;
    }

    public MtopBuilder setSocketTimeoutMilliSecond(int i) {
        if (i > 0) {
            this.mtopProp.m = i;
        }
        return this;
    }

    public MtopResponse syncRequest() {
        this.stat.a();
        MtopBaseListenerProxy createListenerProxy = createListenerProxy(this.listener);
        createMtopProxy(createListenerProxy).a(this.handler);
        synchronized (createListenerProxy) {
            try {
                if (createListenerProxy.b == null) {
                    createListenerProxy.wait(120000L);
                }
            } catch (Exception e) {
                TBSdkLog.b(TAG, "[apiCall] error", e);
            }
        }
        MtopResponse mtopResponse = createListenerProxy.b;
        if (createListenerProxy.c != null) {
            this.requestContext = createListenerProxy.c;
        }
        MtopResponse mtopResponse2 = mtopResponse;
        if (mtopResponse == null) {
            mtopResponse2 = new MtopResponse(this.request.a(), this.request.b(), "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT", "MTOP异步调用超时");
        }
        return mtopResponse2;
    }

    public MtopBuilder ttid(String str) {
        this.mtopProp.g = str;
        return this;
    }

    public MtopBuilder useCache() {
        this.mtopProp.h = true;
        return this;
    }

    public MtopBuilder useWua() {
        return useWua(0);
    }

    public MtopBuilder useWua(int i) {
        this.mtopProp.j = i;
        return this;
    }
}
