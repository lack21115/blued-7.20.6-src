package com.taobao.tao.remotebusiness.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;
import mtopsdk.mtop.util.MtopStatistics;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/a/a.class */
public final class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f21219a;

    private a(Looper looper) {
        super(looper);
    }

    public static Handler a() {
        Handler handler;
        synchronized (a.class) {
            try {
                if (f21219a == null) {
                    f21219a = new a(Looper.getMainLooper());
                }
                handler = f21219a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public static b a(MtopListener mtopListener, MtopEvent mtopEvent, MtopBusiness mtopBusiness) {
        return new b(mtopListener, mtopEvent, mtopBusiness);
    }

    private static boolean a(b bVar) {
        if (bVar == null) {
            TBSdkLog.d("mtop.rb-HandlerMgr", bVar.d.getSeqNo(), "HandlerMsg is null.");
            return false;
        } else if (bVar.d.isTaskCanceled()) {
            TBSdkLog.b("mtop.rb-HandlerMgr", bVar.d.getSeqNo(), "The request of RemoteBusiness is canceled.");
            return false;
        } else {
            return true;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        MtopStatistics mtopStatistics;
        MtopStatistics.RbStatisticData rbStatisticData;
        int i = message.what;
        if (i == 1) {
            b bVar = (b) message.obj;
            if (!a(bVar)) {
                return;
            }
            TBSdkLog.b("mtop.rb-HandlerMgr", bVar.d.getSeqNo(), "onReceive: ON_DATA_RECEIVED.");
            ((IRemoteProcessListener) bVar.f21220a).onDataReceived((MtopProgressEvent) bVar.b, bVar.d.getReqContext());
        } else if (i == 2) {
            b bVar2 = (b) message.obj;
            if (!a(bVar2)) {
                return;
            }
            TBSdkLog.b("mtop.rb-HandlerMgr", bVar2.d.getSeqNo(), "onReceive: ON_HEADER.");
            try {
                ((IRemoteProcessListener) bVar2.f21220a).onHeader((MtopHeaderEvent) bVar2.b, bVar2.d.getReqContext());
            } catch (Throwable th) {
                TBSdkLog.b("mtop.rb-HandlerMgr", bVar2.d.getSeqNo(), "listener onHeader callback error.", th);
            }
        } else if (i == 3) {
            b bVar3 = (b) message.obj;
            if (!a(bVar3)) {
                return;
            }
            TBSdkLog.b("mtop.rb-HandlerMgr", bVar3.d.getSeqNo(), "onReceive: ON_FINISHED.");
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            if (bVar3.e != null) {
                MtopStatistics g = bVar3.e.g();
                if (g != null) {
                    MtopStatistics.RbStatisticData i2 = g.i();
                    i2.g = currentTimeMillis - bVar3.d.onBgFinishTime;
                    mtopStatistics = g;
                    rbStatisticData = i2;
                    if (bVar3.e.d() != null) {
                        j = bVar3.e.d().length;
                        mtopStatistics = g;
                        rbStatisticData = i2;
                    }
                } else {
                    rbStatisticData = null;
                    mtopStatistics = g;
                }
            } else {
                mtopStatistics = null;
                rbStatisticData = null;
            }
            bVar3.d.doFinish(bVar3.e, bVar3.f21221c);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
                StringBuilder sb = new StringBuilder();
                sb.append("doFinishTime=");
                sb.append(currentTimeMillis2 - currentTimeMillis);
                sb.append("; dataSize=");
                sb.append(j);
                sb.append("; ");
                if (rbStatisticData != null) {
                    sb.append(rbStatisticData.toString());
                }
                TBSdkLog.b("mtop.rb-HandlerMgr", bVar3.d.getSeqNo(), "onReceive: ON_FINISHED. " + sb.toString());
            }
            if (mtopStatistics != null) {
                mtopStatistics.a(true);
            }
        }
        message.obj = null;
    }
}
