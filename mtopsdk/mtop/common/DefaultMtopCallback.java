package mtopsdk.mtop.common;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/DefaultMtopCallback.class */
public class DefaultMtopCallback implements MtopCallback.MtopFinishListener, MtopCallback.MtopHeaderListener, MtopCallback.MtopProgressListener {
    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        if (mtopFinishEvent == null || mtopFinishEvent.a() == null || !TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            return;
        }
        TBSdkLog.a("mtopsdk.DefaultMtopCallback", "[onFinished]" + mtopFinishEvent.a().toString());
    }

    @Override // mtopsdk.mtop.common.MtopCallback.MtopHeaderListener
    public void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj) {
        if (mtopHeaderEvent == null || !TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            return;
        }
        TBSdkLog.a("mtopsdk.DefaultMtopCallback", "[onHeader]" + mtopHeaderEvent.toString());
    }
}
