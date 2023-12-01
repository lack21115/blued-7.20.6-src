package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.map.geolocation.util.SoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/c5.class */
public class c5 {
    public static long e;

    /* renamed from: a  reason: collision with root package name */
    public final g5 f3777a;
    public final a5 b;

    /* renamed from: c  reason: collision with root package name */
    public final b5 f3778c;
    public final List<z4> d;

    public c5(g5 g5Var, a5 a5Var, b5 b5Var, List<z4> list) {
        this.f3777a = g5Var;
        this.b = a5Var;
        this.f3778c = b5Var;
        this.d = list;
    }

    public g5 a() {
        return this.f3777a;
    }

    public final g5 a(g5 g5Var) {
        ArrayList arrayList = new ArrayList(g5Var.a());
        Collections.sort(arrayList, h6.g);
        return new g5(arrayList, g5Var.b(), g5Var.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0079 A[Catch: all -> 0x03f6, TRY_ENTER, TryCatch #1 {all -> 0x03f6, blocks: (B:6:0x0007, B:14:0x003a, B:15:0x003d, B:19:0x0054, B:25:0x0079, B:27:0x0081, B:30:0x00ae, B:34:0x00bc, B:52:0x0164, B:55:0x0174, B:59:0x0188, B:60:0x0193, B:61:0x0196, B:66:0x01d5, B:67:0x01e7, B:68:0x01ea, B:71:0x0293, B:74:0x02b7, B:76:0x02c2, B:79:0x02f9, B:81:0x0332, B:82:0x0335, B:80:0x0317, B:20:0x0061, B:10:0x001f, B:13:0x0030, B:36:0x00e9, B:40:0x00f7, B:42:0x0101, B:46:0x0119, B:48:0x0124), top: B:90:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc A[Catch: all -> 0x03f6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x03f6, blocks: (B:6:0x0007, B:14:0x003a, B:15:0x003d, B:19:0x0054, B:25:0x0079, B:27:0x0081, B:30:0x00ae, B:34:0x00bc, B:52:0x0164, B:55:0x0174, B:59:0x0188, B:60:0x0193, B:61:0x0196, B:66:0x01d5, B:67:0x01e7, B:68:0x01ea, B:71:0x0293, B:74:0x02b7, B:76:0x02c2, B:79:0x02f9, B:81:0x0332, B:82:0x0335, B:80:0x0317, B:20:0x0061, B:10:0x001f, B:13:0x0030, B:36:0x00e9, B:40:0x00f7, B:42:0x0101, B:46:0x0119, B:48:0x0124), top: B:90:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r6, int r7, java.lang.String r8, c.t.m.g.t3 r9, boolean r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 1033
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.c5.a(int, int, java.lang.String, c.t.m.g.t3, boolean, boolean, boolean):java.lang.String");
    }

    public String a(int i, String str, t3 t3Var, boolean z, boolean z2, boolean z3) {
        return a(i, 0, str, t3Var, z, z2, z3);
    }

    public final g5 b(g5 g5Var) {
        g5 g5Var2 = null;
        if (g5Var == null) {
            return null;
        }
        boolean z = Build.VERSION.SDK_INT >= 17;
        List<ScanResult> a2 = g5Var.a();
        if (a2 != null) {
            if (a2.size() == 0) {
                return null;
            }
            int[] iArr = new int[a2.size()];
            int[] iArr2 = new int[a2.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a2.size()) {
                    break;
                }
                iArr[i2] = a2.get(i2).level;
                iArr2[i2] = z ? (int) ((SystemClock.elapsedRealtime() / 1000) - ((a2.get(i2).timestamp / 1000) / 1000)) : 0;
                i = i2 + 1;
            }
            int[] fun_s = SoUtils.fun_s(iArr, iArr2, a2.size(), z);
            ArrayList arrayList = new ArrayList();
            int length = fun_s.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                arrayList.add(a2.get(fun_s[i4]));
                i3 = i4 + 1;
            }
            g5Var2 = new g5(arrayList, g5Var.b(), g5Var.c());
        }
        return g5Var2;
    }

    public boolean b() {
        return this.f3778c != null;
    }
}
