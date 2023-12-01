package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/g5.class */
public class g5 extends d5 {
    public static final g5 d = new g5(Collections.emptyList(), 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final List<ScanResult> f3822a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3823c;

    public g5(List<ScanResult> list, long j, int i) {
        this.b = j;
        this.f3823c = i;
        this.f3822a = new ArrayList(list);
    }

    public List<ScanResult> a() {
        return Collections.unmodifiableList(this.f3822a);
    }

    public boolean a(long j, long j2) {
        return j - this.b < j2;
    }

    public boolean a(g5 g5Var) {
        if (g5Var == null) {
            return false;
        }
        List<ScanResult> list = g5Var.f3822a;
        List<ScanResult> list2 = this.f3822a;
        if (list == null || list2 == null || list.size() == 0 || list2.size() == 0) {
            return false;
        }
        return !w4.a(list, list2);
    }

    public long b() {
        return this.b;
    }

    public int c() {
        return this.f3823c;
    }
}
