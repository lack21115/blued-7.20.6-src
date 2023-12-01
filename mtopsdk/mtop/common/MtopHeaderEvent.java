package mtopsdk.mtop.common;

import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopHeaderEvent.class */
public class MtopHeaderEvent extends MtopEvent {

    /* renamed from: a  reason: collision with root package name */
    private int f43708a;
    private Map b;

    public MtopHeaderEvent(int i, Map map) {
        this.f43708a = i;
        this.b = map;
    }

    public String toString() {
        return "MtopHeaderEvent [code=" + this.f43708a + ", header=" + this.b + "]";
    }
}
