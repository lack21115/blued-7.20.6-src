package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f3733a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3734c;
    public final int d;
    public final long e;
    public final int f;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/d$a.class */
    public enum a {
        NONE,
        GSM,
        CDMA,
        WCDMA,
        LTE,
        NR,
        TEMP6,
        TEMP7,
        NOSIM
    }

    public d(int i, int i2, int i3, long j, int i4, int i5) {
        this.f3733a = i;
        this.b = i2;
        this.f3734c = i3;
        this.e = j;
        this.d = i4;
        this.f = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f3733a == dVar.f3733a && this.b == dVar.b && this.f3734c == dVar.f3734c && this.e == dVar.e;
    }

    public String toString() {
        return "CellCoreInfo{MCC=" + this.f3733a + ", MNC=" + this.b + ", LAC=" + this.f3734c + ", RSSI=" + this.d + ", CID=" + this.e + ", PhoneType=" + this.f + '}';
    }
}
