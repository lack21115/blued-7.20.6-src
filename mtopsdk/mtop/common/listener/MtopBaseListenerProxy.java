package mtopsdk.mtop.common.listener;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.DefaultMtopCallback;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/listener/MtopBaseListenerProxy.class */
public class MtopBaseListenerProxy extends DefaultMtopCallback {
    protected MtopListener a;
    public MtopResponse b = null;
    public Object c = null;
    protected boolean d = false;

    public MtopBaseListenerProxy(MtopListener mtopListener) {
        this.a = null;
        this.a = mtopListener;
    }

    @Override // mtopsdk.mtop.common.DefaultMtopCallback, mtopsdk.mtop.common.MtopCallback.MtopFinishListener
    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
        MtopResponse mtopResponse;
        if (mtopFinishEvent != null && mtopFinishEvent.a() != null) {
            this.b = mtopFinishEvent.a();
            this.c = obj;
        }
        synchronized (this) {
            try {
                notifyAll();
            } catch (Exception e) {
                TBSdkLog.d("mtopsdk.MtopListenerProxy", "[onFinished] notify error");
            }
        }
        if (this.a instanceof MtopCallback.MtopFinishListener) {
            if (!this.d || ((mtopResponse = this.b) != null && mtopResponse.i())) {
                ((MtopCallback.MtopFinishListener) this.a).onFinished(mtopFinishEvent, obj);
            }
        }
    }

    @Override // mtopsdk.mtop.common.DefaultMtopCallback, mtopsdk.mtop.common.MtopCallback.MtopHeaderListener
    public void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj) {
        MtopListener mtopListener = this.a;
        if (mtopListener instanceof MtopCallback.MtopHeaderListener) {
            ((MtopCallback.MtopHeaderListener) mtopListener).onHeader(mtopHeaderEvent, obj);
        }
    }
}
