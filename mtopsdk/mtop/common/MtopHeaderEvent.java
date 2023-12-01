package mtopsdk.mtop.common;

import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopHeaderEvent.class */
public class MtopHeaderEvent extends MtopEvent {
    private int a;
    private Map b;

    public MtopHeaderEvent(int i, Map map) {
        this.a = i;
        this.b = map;
    }

    public String toString() {
        return "MtopHeaderEvent [code=" + this.a + ", header=" + this.b + "]";
    }
}
