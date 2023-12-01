package mtopsdk.mtop.antiattack;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/LockedEntity.class */
public class LockedEntity {

    /* renamed from: a  reason: collision with root package name */
    public String f43704a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f43705c;

    public LockedEntity(String str, long j, long j2) {
        this.f43704a = str;
        this.b = j;
        this.f43705c = j2;
    }

    public String toString() {
        return "LockedEntity [key=" + this.f43704a + ", lockStartTime=" + this.b + ", lockInterval=" + this.f43705c + "]";
    }
}
