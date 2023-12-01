package c.t.m.g;

import android.content.Context;
import android.telephony.TelephonyManager;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/y5.class */
public class y5 {

    /* renamed from: a  reason: collision with root package name */
    public static y5 f4018a;

    public static y5 a() {
        if (f4018a == null) {
            f4018a = new y5();
        }
        return f4018a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:5|6|7|(24:9|10|11|12|(2:14|(19:16|17|18|19|(19:56|57|59|60|(1:62)(1:65)|63|64|23|(1:25)|26|(1:28)|29|(1:31)|32|(1:34)|35|(1:37)|38|(2:40|(2:42|(2:44|(2:46|47)(2:48|49))(2:50|51))(2:52|53))(2:54|55))|21|22|23|(0)|26|(0)|29|(0)|32|(0)|35|(0)|38|(0)(0)))|73|17|18|19|(0)|21|22|23|(0)|26|(0)|29|(0)|32|(0)|35|(0)|38|(0)(0))|77|76|18|19|(0)|21|22|23|(0)|26|(0)|29|(0)|32|(0)|35|(0)|38|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.y5.a(android.content.Context):int");
    }

    public boolean b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return telephonyManager.getSimState() == 5;
        } catch (Exception e) {
            return false;
        }
    }
}
