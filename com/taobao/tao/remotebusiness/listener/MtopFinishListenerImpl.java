package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.IRemoteParserListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.auth.RemoteAuth;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopStatistics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/listener/MtopFinishListenerImpl.class */
public class MtopFinishListenerImpl extends b implements MtopCallback.MtopFinishListener {
    private static final String TAG = "mtop.rb-FinishListener";

    public MtopFinishListenerImpl(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        super(mtopBusiness, mtopListener);
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        long j;
        TBSdkLog.b(TAG, this.mtopBusiness.getSeqNo(), "Mtop onFinish event received.");
        if (this.mtopBusiness.isTaskCanceled()) {
            TBSdkLog.a(TAG, this.mtopBusiness.getSeqNo(), "The request of RemoteBusiness is canceled.");
            return;
        }
        MtopResponse a2 = mtopFinishEvent.a();
        if (a2 == null) {
            TBSdkLog.a(TAG, this.mtopBusiness.getSeqNo(), "The MtopResponse is null.");
        } else if (a2.m() && this.mtopBusiness.request.d() && this.mtopBusiness.getRetryTime() == 0) {
            com.taobao.tao.remotebusiness.a.a(this.mtopBusiness);
            RemoteLogin.login(this.mtopBusiness.isShowLoginUI(), a2);
        } else {
            String a3 = a2.a();
            if (("FAIL_SYS_ACCESS_TOKEN_EXPIRED".equalsIgnoreCase(a3) || "FAIL_SYS_ILLEGAL_ACCESS_TOKEN".equalsIgnoreCase(a3)) && this.mtopBusiness.isNeedAuth()) {
                int retryTime = this.mtopBusiness.getRetryTime();
                MtopBusiness mtopBusiness = this.mtopBusiness;
                if (retryTime < 3) {
                    com.taobao.tao.remotebusiness.a.a(this.mtopBusiness);
                    RemoteAuth.authorize(this.mtopBusiness.authParam, this.mtopBusiness.request.f(), c.a(a2.e(), "x-act-hint"), this.mtopBusiness.showAuthUI);
                    return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.listener instanceof IRemoteParserListener) {
                ((IRemoteParserListener) this.listener).parseResponse(mtopFinishEvent.a());
            }
            com.taobao.tao.remotebusiness.a.b a4 = com.taobao.tao.remotebusiness.a.a.a(this.listener, mtopFinishEvent, this.mtopBusiness);
            a4.e = a2;
            long currentTimeMillis2 = System.currentTimeMillis();
            MtopStatistics mtopStatistics = null;
            if (a2 != null) {
                if (!a2.i() || this.mtopBusiness.clazz == null) {
                    j = currentTimeMillis2;
                } else {
                    a4.f34912c = MtopConvert.a(a2, this.mtopBusiness.clazz);
                    j = System.currentTimeMillis();
                }
                MtopStatistics g = a2.g();
                mtopStatistics = g;
                if (g == null) {
                    mtopStatistics = new MtopStatistics();
                    a2.a(mtopStatistics);
                }
            } else {
                j = currentTimeMillis2;
            }
            this.mtopBusiness.onBgFinishTime = System.currentTimeMillis();
            if (mtopStatistics != null) {
                MtopStatistics.RbStatisticData i = mtopStatistics.i();
                i.b = this.mtopBusiness.sendStartTime - this.mtopBusiness.reqStartTime;
                i.f43792a = currentTimeMillis - this.mtopBusiness.sendStartTime;
                i.f43793c = this.mtopBusiness.onBgFinishTime - currentTimeMillis;
                i.f = currentTimeMillis2 - currentTimeMillis;
                i.e = j - currentTimeMillis2;
                i.d = this.mtopBusiness.onBgFinishTime - this.mtopBusiness.reqStartTime;
            }
            com.taobao.tao.remotebusiness.a.a.a().obtainMessage(3, a4).sendToTarget();
        }
    }
}
