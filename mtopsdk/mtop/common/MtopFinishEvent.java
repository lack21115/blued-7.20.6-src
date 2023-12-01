package mtopsdk.mtop.common;

import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopFinishEvent.class */
public class MtopFinishEvent extends MtopEvent {

    /* renamed from: a  reason: collision with root package name */
    public MtopResponse f43707a;

    public MtopFinishEvent(MtopResponse mtopResponse) {
        this.f43707a = mtopResponse;
    }

    public MtopResponse a() {
        return this.f43707a;
    }

    public String toString() {
        return "MtopFinishEvent [mtopResponse" + this.f43707a + "]";
    }
}
