package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/listener/MtopProgressListenerImpl.class */
class MtopProgressListenerImpl extends b implements MtopCallback.MtopHeaderListener, MtopCallback.MtopProgressListener {
    private static final String TAG = "mtop.rb-ProgressListener";

    public MtopProgressListenerImpl(MtopBusiness mtopBusiness, MtopListener mtopListener) {
        super(mtopBusiness, mtopListener);
    }

    public void onDataReceived(MtopProgressEvent mtopProgressEvent, Object obj) {
        String seqNo;
        String str;
        TBSdkLog.b(TAG, this.mtopBusiness.getSeqNo(), "Mtop onDataReceived event received.");
        if (this.mtopBusiness.isTaskCanceled()) {
            seqNo = this.mtopBusiness.getSeqNo();
            str = "The request of RemoteBusiness is canceled.";
        } else if (this.listener != null) {
            if (this.listener instanceof IRemoteProcessListener) {
                com.taobao.tao.remotebusiness.a.a.a().obtainMessage(1, com.taobao.tao.remotebusiness.a.a.a(this.listener, mtopProgressEvent, this.mtopBusiness)).sendToTarget();
                return;
            }
            return;
        } else {
            seqNo = this.mtopBusiness.getSeqNo();
            str = "The listener of RemoteBusiness is null.";
        }
        TBSdkLog.a(TAG, seqNo, str);
    }

    public void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj) {
        String seqNo;
        String str;
        TBSdkLog.b(TAG, this.mtopBusiness.getSeqNo(), "Mtop onHeader event received.");
        if (this.mtopBusiness.isTaskCanceled()) {
            seqNo = this.mtopBusiness.getSeqNo();
            str = "The request of RemoteBusiness is canceled.";
        } else if (this.listener != null) {
            if (this.listener instanceof IRemoteProcessListener) {
                com.taobao.tao.remotebusiness.a.a.a().obtainMessage(2, com.taobao.tao.remotebusiness.a.a.a(this.listener, mtopHeaderEvent, this.mtopBusiness)).sendToTarget();
                return;
            }
            return;
        } else {
            seqNo = this.mtopBusiness.getSeqNo();
            str = "The listener of RemoteBusiness is null.";
        }
        TBSdkLog.a(TAG, seqNo, str);
    }
}
