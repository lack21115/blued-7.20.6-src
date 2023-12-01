package com.soft.blued.tinker.reporter;

import com.anythink.expressad.video.module.a.a.m;
import com.soft.blued.tinker.util.Utils;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/reporter/BluedTinkerReport.class */
public class BluedTinkerReport {

    /* renamed from: a  reason: collision with root package name */
    private static Reporter f29781a;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/reporter/BluedTinkerReport$Reporter.class */
    public interface Reporter {
        void a(int i);

        void a(String str);
    }

    public static void a() {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(309);
    }

    public static void a(int i) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        switch (i) {
            case -24:
                reporter.a(80);
                return;
            case -23:
                reporter.a(79);
                return;
            case -22:
                reporter.a(78);
                return;
            case -21:
                reporter.a(76);
                return;
            case -20:
                reporter.a(75);
                return;
            default:
                switch (i) {
                    case -6:
                        reporter.a(77);
                        return;
                    case -5:
                        reporter.a(81);
                        return;
                    case -4:
                        reporter.a(73);
                        return;
                    case -3:
                        reporter.a(72);
                        return;
                    case -2:
                        reporter.a(74);
                        return;
                    case -1:
                        reporter.a(71);
                        return;
                    default:
                        return;
                }
        }
    }

    public static void a(int i, Throwable th) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        if (i == 0) {
            reporter.a(452);
        } else if (i == 1) {
            reporter.a(450);
            Reporter reporter2 = f29781a;
            reporter2.a("Tinker Exception:interpret occur exception " + Utils.b(th));
        } else if (i != 2) {
        } else {
            reporter.a(451);
            Reporter reporter3 = f29781a;
            reporter3.a("Tinker Exception:interpret occur exception " + Utils.b(th));
        }
    }

    public static void a(long j) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(6);
        if (j < 0) {
            TinkerLog.e("Tinker.BluedTinkerReport", "hp_report report load cost failed, invalid cost", new Object[0]);
        } else if (j <= 500) {
            f29781a.a(400);
        } else if (j <= 1000) {
            f29781a.a(401);
        } else if (j <= m.ag) {
            f29781a.a(402);
        } else if (j <= 5000) {
            f29781a.a(403);
        } else {
            f29781a.a(404);
        }
    }

    public static void a(long j, boolean z) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        if (z) {
            reporter.a(5);
        }
        if (z) {
            f29781a.a(100);
        } else {
            f29781a.a(101);
        }
        TinkerLog.i("Tinker.BluedTinkerReport", "hp_report report apply cost = %d", Long.valueOf(j));
        if (j < 0) {
            TinkerLog.e("Tinker.BluedTinkerReport", "hp_report report apply cost failed, invalid cost", new Object[0]);
        } else if (j <= 5000) {
            if (z) {
                f29781a.a(200);
            } else {
                f29781a.a(205);
            }
        } else if (j <= 10000) {
            if (z) {
                f29781a.a(201);
            } else {
                f29781a.a(206);
            }
        } else if (j <= 30000) {
            if (z) {
                f29781a.a(202);
            } else {
                f29781a.a(207);
            }
        } else if (j <= 60000) {
            if (z) {
                f29781a.a(203);
            } else {
                f29781a.a(208);
            }
        } else if (z) {
            f29781a.a(204);
        } else {
            f29781a.a(209);
        }
    }

    public static void a(Throwable th) {
        if (f29781a == null) {
            return;
        }
        if (th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_EXIST_FAIL)) {
            f29781a.a(122);
        } else if (th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL)) {
            f29781a.a(123);
        } else {
            f29781a.a(121);
            Reporter reporter = f29781a;
            reporter.a("Tinker Exception:apply tinker occur exception " + Utils.b(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.Throwable r4, int r5) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.tinker.reporter.BluedTinkerReport.a(java.lang.Throwable, int):void");
    }

    public static void a(boolean z) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(2);
        f29781a.a(70);
        if (z) {
            f29781a.a(3);
        }
    }

    public static void b() {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(4);
    }

    public static void b(int i) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        switch (i) {
            case -9:
                reporter.a(358);
                return;
            case -8:
                reporter.a(357);
                return;
            case -7:
                reporter.a(355);
                return;
            case -6:
                reporter.a(354);
                return;
            case -5:
                reporter.a(353);
                return;
            case -4:
                reporter.a(352);
                return;
            case -3:
                reporter.a(351);
                return;
            case -2:
                reporter.a(356);
                return;
            case -1:
                reporter.a(350);
                return;
            default:
                return;
        }
    }

    public static void b(Throwable th) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(120);
        Reporter reporter2 = f29781a;
        reporter2.a("Tinker Exception:apply tinker occur exception " + Utils.b(th));
    }

    public static void c() {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(124);
    }

    public static void c(int i) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        switch (i) {
            case 1:
                reporter.a(305);
                return;
            case 2:
                reporter.a(306);
                return;
            case 3:
                reporter.a(303);
                return;
            case 4:
                reporter.a(307);
                return;
            case 5:
                reporter.a(304);
                return;
            case 6:
                reporter.a(308);
                return;
            default:
                return;
        }
    }

    public static void d() {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(180);
    }

    public static void d(int i) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        if (i == 3) {
            reporter.a(300);
        } else if (i == 5) {
            reporter.a(301);
        } else if (i != 6) {
        } else {
            reporter.a(302);
        }
    }

    public static void e() {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(7);
    }

    public static void e(int i) {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        if (i == 1) {
            reporter.a(181);
        } else if (i == 3) {
            reporter.a(182);
        } else if (i == 5) {
            reporter.a(183);
        } else if (i != 6) {
        } else {
            reporter.a(184);
        }
    }

    public static void f() {
        if (f29781a == null) {
            return;
        }
        if (ShareTinkerInternals.isVmArt()) {
            f29781a.a(9);
        } else {
            f29781a.a(8);
        }
    }

    public static void f(int i) {
        if (f29781a == null) {
            return;
        }
        TinkerLog.i("Tinker.BluedTinkerReport", "hp_report package check failed, error = %d", Integer.valueOf(i));
        switch (i) {
            case -9:
                f29781a.a(158);
                return;
            case -8:
                f29781a.a(157);
                return;
            case -7:
                f29781a.a(156);
                return;
            case -6:
                f29781a.a(154);
                return;
            case -5:
                f29781a.a(153);
                return;
            case -4:
                f29781a.a(152);
                return;
            case -3:
                f29781a.a(151);
                return;
            case -2:
                f29781a.a(155);
                return;
            case -1:
                f29781a.a(150);
                return;
            default:
                return;
        }
    }

    public static void g() {
        Reporter reporter = f29781a;
        if (reporter == null) {
            return;
        }
        reporter.a(10);
    }

    public void a(Reporter reporter) {
        f29781a = reporter;
    }
}
