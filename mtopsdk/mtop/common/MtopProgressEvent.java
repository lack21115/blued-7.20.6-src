package mtopsdk.mtop.common;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopProgressEvent.class */
public class MtopProgressEvent extends MtopEvent {
    String a;
    int b;
    int c;

    public String toString() {
        return "MtopProgressEvent [desc=" + this.a + ", size=" + this.b + ", total=" + this.c + "]";
    }
}
