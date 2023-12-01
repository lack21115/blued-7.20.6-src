package mtopsdk.mtop.common;

import mtopsdk.mtop.domain.MtopResponse;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopFinishEvent.class */
public class MtopFinishEvent extends MtopEvent {
    public MtopResponse a;

    public MtopFinishEvent(MtopResponse mtopResponse) {
        this.a = mtopResponse;
    }

    public MtopResponse a() {
        return this.a;
    }

    public String toString() {
        return "MtopFinishEvent [mtopResponse" + this.a + "]";
    }
}
