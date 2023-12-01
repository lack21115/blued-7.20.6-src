package com.taobao.tao.remotebusiness;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.t;
import com.taobao.tao.remotebusiness.auth.RemoteAuth;
import com.taobao.tao.remotebusiness.listener.c;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/MtopBusiness.class */
public class MtopBusiness extends MtopBuilder {
    public static final int MAX_RETRY_TIMES = 3;
    private static final String TAG = "mtop.rb-RemoteBusiness";
    private static AtomicInteger seqGen = new AtomicInteger(0);
    private ApiID apiID;
    public String authParam;
    public Class clazz;
    public boolean isCached;
    private boolean isCanceled;
    private boolean isErrorNotifyAfterCache;
    public MtopListener listener;
    private MtopResponse mtopResponse;
    public long onBgFinishTime;
    public long reqStartTime;
    protected int requestType;
    protected int retryTime;
    public long sendStartTime;
    private final String seqNo;
    public boolean showAuthUI;
    private boolean showLoginUI;
    private CountDownLatch syncRequestLatch;

    /* JADX INFO: Access modifiers changed from: protected */
    public MtopBusiness(IMTOPDataObject iMTOPDataObject, String str) {
        super(iMTOPDataObject, str);
        this.isCanceled = false;
        this.retryTime = 0;
        this.requestType = 0;
        this.showLoginUI = true;
        this.isErrorNotifyAfterCache = false;
        this.authParam = null;
        this.showAuthUI = true;
        this.isCached = false;
        this.reqStartTime = 0L;
        this.onBgFinishTime = 0L;
        this.sendStartTime = 0L;
        this.mtopResponse = null;
        this.syncRequestLatch = null;
        this.seqNo = genSeqNo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MtopBusiness(MtopRequest mtopRequest, String str) {
        super(mtopRequest, str);
        this.isCanceled = false;
        this.retryTime = 0;
        this.requestType = 0;
        this.showLoginUI = true;
        this.isErrorNotifyAfterCache = false;
        this.authParam = null;
        this.showAuthUI = true;
        this.isCached = false;
        this.reqStartTime = 0L;
        this.onBgFinishTime = 0L;
        this.sendStartTime = 0L;
        this.mtopResponse = null;
        this.syncRequestLatch = null;
        this.seqNo = genSeqNo();
    }

    public static MtopBusiness build(IMTOPDataObject iMTOPDataObject) {
        return new MtopBusiness(iMTOPDataObject, (String) null);
    }

    public static MtopBusiness build(IMTOPDataObject iMTOPDataObject, String str) {
        return new MtopBusiness(iMTOPDataObject, str);
    }

    public static MtopBusiness build(MtopRequest mtopRequest) {
        return new MtopBusiness(mtopRequest, (String) null);
    }

    public static MtopBusiness build(MtopRequest mtopRequest, String str) {
        return new MtopBusiness(mtopRequest, str);
    }

    private void cancelRequest(boolean z) {
        if (z) {
            TBSdkLog.b(TAG, this.seqNo, c.a("cancelRequest.", this, false, null));
        }
        this.isCanceled = true;
        ApiID apiID = this.apiID;
        if (apiID != null) {
            try {
                apiID.b();
            } catch (Throwable th) {
                TBSdkLog.a(TAG, this.seqNo, c.a("Cancel request task failed.", this, true, null), th);
            }
        }
        a.b(this);
    }

    private void doQuery() {
        boolean d = this.request.d();
        boolean isNeedAuth = isNeedAuth();
        if (d && !RemoteLogin.isSessionValid()) {
            a.a(this);
            RemoteLogin.login(this.showLoginUI, this.request);
            return;
        }
        if (d) {
            try {
                if (StringUtils.b(mtopsdk.xstate.a.a())) {
                    TBSdkLog.c(TAG, this.seqNo, "[doQuery] session in loginContext is valid but XState's sid is null");
                    LoginContext loginContext = RemoteLogin.getLoginContext();
                    if (loginContext == null || StringUtils.b(loginContext.sid)) {
                        a.a(this);
                        RemoteLogin.login(this.showLoginUI, this.request);
                        return;
                    }
                    Mtop.a(SDKConfig.a().b()).a(loginContext.sid, loginContext.userId);
                }
            } catch (Exception e) {
                TBSdkLog.b(TAG, this.seqNo, "error happens in confirming session info");
            }
        }
        if (d && isNeedAuth) {
            if (!RemoteAuth.isAuthInfoValid()) {
                a.a(this);
                RemoteAuth.authorize(this.authParam, this.request.f(), null, this.showAuthUI);
                return;
            }
            String authToken = RemoteAuth.getAuthToken();
            if (TextUtils.isEmpty(authToken)) {
                a.a(this);
                RemoteAuth.authorize(this.authParam, this.request.f(), null, this.showAuthUI);
                return;
            }
            mtopsdk.xstate.a.a(t.cN, authToken);
        }
        this.sendStartTime = System.currentTimeMillis();
        this.apiID = super.asyncRequest();
    }

    private String genSeqNo() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("RB");
        sb.append(seqGen.getAndIncrement());
        sb.append('.');
        sb.append(this.stat.g());
        return sb.toString();
    }

    public static void init(Context context, String str) {
        Mtop.a(context, str);
    }

    private void onErrorCallback(MtopResponse mtopResponse, boolean z) {
        IRemoteBaseListener iRemoteBaseListener = (IRemoteBaseListener) this.listener;
        try {
            if (z) {
                iRemoteBaseListener.onSystemError(this.requestType, mtopResponse, getReqContext());
            } else {
                iRemoteBaseListener.onError(this.requestType, mtopResponse, getReqContext());
            }
        } catch (Throwable th) {
            TBSdkLog.b(TAG, this.seqNo, "listener onError callback error", th);
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            String str = this.seqNo;
            StringBuilder sb = new StringBuilder("listener onError callback, ");
            sb.append(z ? "sys error" : "biz error");
            TBSdkLog.b(TAG, str, sb.toString());
        }
    }

    private void resetMtopListener() {
        MtopListener mtopListener;
        if (this.isCanceled || (mtopListener = this.listener) == null) {
            return;
        }
        super.addListener(c.a(this, mtopListener));
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness addListener(MtopListener mtopListener) {
        return registeListener(mtopListener);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public ApiID asyncRequest() {
        startRequest();
        return this.apiID;
    }

    public void cancelRequest() {
        cancelRequest(true);
    }

    public void doFinish(MtopResponse mtopResponse, BaseOutDo baseOutDo) {
        CountDownLatch countDownLatch = this.syncRequestLatch;
        if (countDownLatch != null) {
            this.mtopResponse = mtopResponse;
            countDownLatch.countDown();
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            StringBuilder sb = new StringBuilder();
            sb.append("doFinish api=[");
            sb.append(this.request.a());
            sb.append("]");
            if (mtopResponse != null) {
                sb.append(" retCode=");
                sb.append(mtopResponse.a());
                sb.append(" retMsg=");
                sb.append(mtopResponse.a());
            }
            TBSdkLog.b(TAG, this.seqNo, sb.toString());
        }
        if (!this.isCanceled) {
            MtopListener mtopListener = this.listener;
            if (mtopListener instanceof IRemoteBaseListener) {
                IRemoteBaseListener iRemoteBaseListener = (IRemoteBaseListener) mtopListener;
                if (mtopResponse == null) {
                    TBSdkLog.b(TAG, this.seqNo, "response is null.");
                    onErrorCallback(mtopResponse, false);
                    return;
                } else if (mtopResponse != null && mtopResponse.i()) {
                    try {
                        iRemoteBaseListener.onSuccess(this.requestType, mtopResponse, baseOutDo, getReqContext());
                    } catch (Throwable th) {
                        TBSdkLog.b(TAG, this.seqNo, "listener onSuccess callback error", th);
                    }
                    TBSdkLog.b(TAG, this.seqNo, "listener onSuccess callback.");
                    return;
                } else if (this.isCached && !this.isErrorNotifyAfterCache) {
                    TBSdkLog.a(TAG, this.seqNo, "listenr onCached callback,doNothing in doFinish()");
                    return;
                } else if (mtopResponse.m()) {
                    if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.b(TAG, this.seqNo, c.a("尝试登录后仍session失效，或用户取消登录。", this, false, null));
                        TBSdkLog.b(TAG, this.seqNo, "response.isSessionInvalid().");
                    }
                    onErrorCallback(mtopResponse, true);
                    return;
                } else if (mtopResponse.q() || mtopResponse.p() || mtopResponse.l() || mtopResponse.k() || mtopResponse.j() || mtopResponse.n() || mtopResponse.o()) {
                    onErrorCallback(mtopResponse, true);
                    return;
                } else {
                    onErrorCallback(mtopResponse, false);
                    return;
                }
            }
        }
        TBSdkLog.a(TAG, this.seqNo, "doFinish no callback.");
    }

    public int getRequestType() {
        return this.requestType;
    }

    public int getRetryTime() {
        return this.retryTime;
    }

    public String getSeqNo() {
        return this.seqNo;
    }

    public boolean isNeedAuth() {
        return this.authParam != null;
    }

    public boolean isShowLoginUI() {
        return this.showLoginUI;
    }

    public boolean isTaskCanceled() {
        return this.isCanceled;
    }

    public MtopBusiness registeListener(MtopListener mtopListener) {
        this.listener = mtopListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void retryRequest() {
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b(TAG, this.seqNo, c.a("retryRequest.", this, false, null));
        }
        if (this.retryTime >= 3) {
            this.retryTime = 0;
            doFinish(null, null);
            return;
        }
        cancelRequest(false);
        startRequest(this.requestType, this.clazz);
        this.retryTime++;
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopBusiness setBizId(int i) {
        return (MtopBusiness) super.setBizId(i);
    }

    public MtopBusiness setErrorNotifyAfterCache(boolean z) {
        this.isErrorNotifyAfterCache = z;
        return this;
    }

    public MtopBusiness setNeedAuth(String str, boolean z) {
        if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.a(TAG, "setNeedAuth. authParam" + str);
        }
        this.authParam = str;
        this.showAuthUI = z;
        return this;
    }

    public MtopBusiness showLoginUI(boolean z) {
        this.showLoginUI = z;
        return this;
    }

    public void startRequest() {
        startRequest(0, null);
    }

    public void startRequest(int i, Class cls) {
        if (this.request == null) {
            TBSdkLog.d(TAG, this.seqNo, "request is null!!!");
            return;
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            String str = this.seqNo;
            TBSdkLog.b(TAG, str, "start request api=[" + this.request.a() + "]");
        }
        this.reqStartTime = System.currentTimeMillis();
        this.isCanceled = false;
        this.isCached = false;
        this.clazz = cls;
        this.requestType = i;
        resetMtopListener();
        mtopCommitStatData(false);
        doQuery();
    }

    public void startRequest(Class cls) {
        startRequest(0, cls);
    }

    @Override // mtopsdk.mtop.intf.MtopBuilder
    public MtopResponse syncRequest() {
        TBSdkLog.b(TAG, this.seqNo, "syncRequest");
        this.syncRequestLatch = new CountDownLatch(1);
        if (this.listener == null) {
            this.listener = new IRemoteBaseListener() { // from class: com.taobao.tao.remotebusiness.MtopBusiness.1
                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                }
            };
        }
        startRequest();
        try {
            if (!this.syncRequestLatch.await(120L, TimeUnit.SECONDS)) {
                String str = this.seqNo;
                StringBuilder sb = new StringBuilder("syncRequest timeout . apiKey=");
                sb.append(this.request);
                TBSdkLog.c(TAG, str, sb.toString() != null ? this.request.f() : "");
                cancelRequest();
            }
        } catch (InterruptedException e) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.ErrorEnable)) {
                String str2 = this.seqNo;
                StringBuilder sb2 = new StringBuilder("SyncRequest InterruptedException. apiKey=");
                sb2.append(this.request);
                TBSdkLog.d(TAG, str2, sb2.toString() != null ? this.request.f() : "");
            }
        }
        if (this.mtopResponse == null) {
            this.mtopResponse = new MtopResponse(this.request.a(), this.request.b(), "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT", "MTOP异步调用超时");
        }
        return this.mtopResponse;
    }
}
