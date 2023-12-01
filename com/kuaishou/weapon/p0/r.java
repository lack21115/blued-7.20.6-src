package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/r.class */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static r f23857c;
    private static Application d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f23858a;
    private String e;
    private static Random f = new Random();
    private static Map<String, s> g = new ConcurrentHashMap();
    private static Map<String, s> h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    private r() {
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        File file = new File(str2);
        if (dm.a(file)) {
            String a2 = f.a(file);
            return TextUtils.isEmpty(a2) ? new Pair<>(Boolean.FALSE, "") : !a2.equalsIgnoreCase(str) ? new Pair<>(Boolean.FALSE, a2) : new Pair<>(Boolean.TRUE, "");
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public static r a() {
        return f23857c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x001e -> B:5:0x001a). Please submit an issue!!! */
    public static r a(Context context, boolean z) {
        try {
            if (f23857c == null) {
                d = (Application) context.getApplicationContext();
                f23857c = new r();
            }
        } catch (Throwable th) {
        }
        return f23857c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:11|12|13|14|(4:16|17|18|(52:20|21|22|23|24|25|(45:27|28|29|(8:31|32|33|(4:35|36|37|(1:39))|135|136|137|(5:139|140|141|142|(4:144|145|146|(5:148|149|150|151|(1:153)(1:154))(1:155))(1:156))(1:157))(1:158)|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(4:71|72|73|(1:75)(1:76))|77|78|79|80|81|(4:83|84|85|(3:87|88|(9:90|91|92|93|(4:94|95|96|(1:98)(1:99))|100|(1:102)|103|104)))|120|121|122)|159|28|29|(0)(0)|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(5:71|72|73|(0)(0)|75)|77|78|79|80|81|(0)|120|121|122)(1:162))(1:164)|163|79|80|81|(0)|120|121|122) */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02b3, code lost:
        r18 = null;
        r17 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01bf A[EDGE_INSN: B:178:0x01bf->B:89:0x01bf ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b2 A[Catch: all -> 0x01d3, LOOP:1: B:85:0x01a4->B:88:0x01b2, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01d3, blocks: (B:86:0x01a6, B:88:0x01b2, B:89:0x01bf), top: B:154:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r7, java.lang.String r8, java.lang.String r9, java.util.HashSet<java.lang.String> r10, byte[] r11, java.lang.StringBuilder r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, java.util.HashSet, byte[], java.lang.StringBuilder, boolean):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:28|29|30|31|32|33|34|(4:36|37|38|(42:40|41|42|43|44|45|(35:47|48|49|(9:51|52|53|(3:55|56|57)|59|60|61|(4:63|64|65|(4:67|68|69|(4:71|72|73|(1:75))(1:77)))(1:78)|76)|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|(4:108|109|110|(1:112)(1:113))|114)|238|48|49|(0)|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|(5:108|109|110|(0)(0)|112)|114))|241|242|(1:289)(13:248|249|250|251|252|253|254|(4:255|256|257|(2:259|260)(1:275))|276|(1:278)|279|280|281)|273|274|76) */
    /* JADX WARN: Can't wrap try/catch for region: R(25:(2:5|(28:9|10|(1:12)(1:338)|13|(1:15)|16|17|18|19|20|21|22|23|(4:24|25|26|(14:28|29|30|31|32|33|34|(4:36|37|38|(42:40|41|42|43|44|45|(35:47|48|49|(9:51|52|53|(3:55|56|57)|59|60|61|(4:63|64|65|(4:67|68|69|(4:71|72|73|(1:75))(1:77)))(1:78)|76)|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|(4:108|109|110|(1:112)(1:113))|114)|238|48|49|(0)|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|(5:108|109|110|(0)(0)|112)|114))|241|242|(1:289)(13:248|249|250|251|252|253|254|(4:255|256|257|(2:259|260)(1:275))|276|(1:278)|279|280|281)|273|274|76)(1:293))|294|(1:296)|297|(1:299)|127|(8:129|130|131|(4:135|136|(1:138)(1:186)|139)|188|136|(0)(0)|139)(4:190|191|192|(4:194|195|196|(1:198)))|140|(3:142|(2:147|(2:149|(1:151)))|146)|153|154|155|156|157|(3:172|173|(1:181)(2:179|180))(4:163|164|a79|170)))|18|19|20|21|22|23|(5:24|25|26|(0)(0)|76)|294|(0)|297|(0)|127|(0)(0)|140|(0)|153|154|155|156|157|(2:159|161)|172|173|(2:175|182)(1:183)) */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0686, code lost:
        r30 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0761, code lost:
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0762, code lost:
        r11 = null;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0769, code lost:
        r19 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0770, code lost:
        r19 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0777, code lost:
        r19 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x07f4, code lost:
        if (r15 == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0835, code lost:
        if (r15 == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0876, code lost:
        if (r15 == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0879, code lost:
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x09f9, code lost:
        if (r0.contains("armeabi") != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x021c, code lost:
        if (r0.contains(r32) == false) goto L59;
     */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0b9a: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:279:0x0b94 */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0b97: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r17 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:279:0x0b94 */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0b94: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:279:0x0b94 */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0558 A[Catch: all -> 0x0570, FileNotFoundException | ZipException -> 0x0be7, EOFException -> 0x0bec, IOException -> 0x0bf1, LOOP:1: B:104:0x054a->B:107:0x0558, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #18 {EOFException -> 0x0bec, FileNotFoundException | ZipException -> 0x0be7, IOException -> 0x0bf1, all -> 0x0570, blocks: (B:105:0x054c, B:107:0x0558, B:108:0x0565), top: B:359:0x054c }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0824  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x082e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0865  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0957  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x09c1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0712 A[EDGE_INSN: B:363:0x0712->B:151:0x0712 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0565 A[EDGE_INSN: B:368:0x0565->B:108:0x0565 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 3112
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    private boolean a(s sVar) {
        synchronized (this) {
            if (sVar != null) {
                if (!TextUtils.isEmpty(sVar.e)) {
                    s sVar2 = g.get(sVar.e);
                    if (sVar2 != null) {
                        if (sVar2.d.equals(sVar.d)) {
                            return true;
                        }
                        a(sVar2.e);
                    }
                    try {
                        sVar.f = d;
                        if (sVar.p == 1) {
                            if (TextUtils.isEmpty(sVar.f23862c) || TextUtils.isEmpty(sVar.e)) {
                                throw new RuntimeException("apkPackageName or apkPkgPath is null");
                            }
                            sVar.m = d.getFilesDir().getCanonicalPath() + bh.j + sVar.f23861a;
                            String str = sVar.m + "/dex";
                            dm.c(sVar.m + "/lib");
                            String str2 = (sVar.m + "/lib/" + this.e) + BridgeUtil.SPLIT_MARK + f.nextInt();
                            e(str);
                            dm.a(str, Boolean.FALSE);
                            e(str2);
                            a(sVar, str2, str, false);
                            h.put(sVar.f23862c, sVar);
                            g.put(sVar.e, sVar);
                        }
                        if (sVar.p != 1 || 0 != 0) {
                            PackageInfo packageInfo = sVar.r;
                            if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                                packageInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                            }
                            if (TextUtils.isEmpty(packageInfo.packageName) || !packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                                throw new Exception("weapon package name check failed");
                            }
                            if (sVar.p != 1 && sVar.b != 1 && !a(sVar.j, sVar.e).first.booleanValue()) {
                                return false;
                            }
                            sVar.f23862c = packageInfo.packageName;
                            sVar.o = packageInfo.applicationInfo.className;
                            sVar.d = packageInfo.versionName;
                            sVar.l = packageInfo.activities;
                            sVar.q = packageInfo.applicationInfo.theme;
                            sVar.m = d.getFilesDir().getCanonicalPath() + bh.j + sVar.f23861a;
                            String str3 = sVar.m + "/dex";
                            dm.c(sVar.m + "/lib");
                            String str4 = (sVar.m + "/lib/" + this.e) + BridgeUtil.SPLIT_MARK + f.nextInt();
                            e(str3);
                            dm.a(str3, Boolean.FALSE);
                            e(str4);
                            a(sVar, str4, str3, true);
                            h.put(sVar.f23862c, sVar);
                            g.put(sVar.e, sVar);
                            b.add(Integer.valueOf(sVar.f23861a));
                        }
                        return true;
                    } catch (Throwable th) {
                        try {
                            a(sVar.e);
                        } catch (Throwable th2) {
                        }
                        return false;
                    }
                }
            }
            return false;
        }
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean a(s sVar, boolean z) {
        this.f23858a = z;
        this.e = sVar.d;
        return a(sVar);
    }

    public boolean a(String str) {
        s sVar = g.get(str);
        if (sVar != null) {
            g.remove(str);
            h.remove(sVar.f23862c);
            dm.c(sVar.m);
            Application application = d;
            if (application != null) {
                dm.c(application.getFileStreamPath(sVar.f23862c).getAbsolutePath());
                return true;
            }
            return true;
        }
        return false;
    }

    public Map<String, s> b() {
        return h;
    }

    public boolean b(String str) {
        s sVar = h.get(str);
        if (sVar != null) {
            g.remove(sVar.e);
            h.remove(str);
            dm.c(sVar.m);
            Application application = d;
            if (application != null) {
                dm.c(application.getFileStreamPath(sVar.f23862c).getAbsolutePath());
                return true;
            }
            return true;
        }
        return false;
    }

    public s c(String str) {
        try {
            return g.get(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return h.get(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
