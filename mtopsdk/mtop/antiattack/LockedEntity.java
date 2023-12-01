package mtopsdk.mtop.antiattack;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/LockedEntity.class */
public class LockedEntity {
    public String a;
    public long b;
    public long c;

    public LockedEntity(String str, long j, long j2) {
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    public String toString() {
        return "LockedEntity [key=" + this.a + ", lockStartTime=" + this.b + ", lockInterval=" + this.c + "]";
    }
}
